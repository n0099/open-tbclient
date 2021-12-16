package com.baidu.wallet.paysdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.google.protobuf.CodedInputStream;
import com.tencent.connect.common.Constants;
import java.io.Serializable;
/* loaded from: classes13.dex */
public final class PayCallBackManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isClientDead;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes13.dex */
    public static class PayStateModle implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int PAY_STATUS_CANCEL = 2;
        public static final int PAY_STATUS_CLEAR = 1000;
        public static final int PAY_STATUS_PAYING = 1;
        public static final int PAY_STATUS_SUCCESS = 0;
        public static final long serialVersionUID = 393136306694361260L;
        public transient /* synthetic */ FieldHolder $fh;
        public String mNotify;
        public String mOrder_no;
        public int mStatecode;

        public PayStateModle(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mStatecode = i2;
            this.mNotify = str;
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (payRequest != null) {
                this.mOrder_no = payRequest.mOrderNo;
            } else {
                reviseOrderByNotify();
            }
        }

        private void reviseOrderByNotify() {
            String[] split;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || !TextUtils.isEmpty(this.mOrder_no) || TextUtils.isEmpty(this.mNotify) || (split = this.mNotify.split("&")) == null || split.length <= 0) {
                return;
            }
            for (String str : split) {
                if (str != null) {
                    String trim = str.trim();
                    if (trim.toLowerCase().startsWith("order_no")) {
                        String[] split2 = trim.split("\\s*=\\s*");
                        if (split2 == null || 2 != split2.length) {
                            return;
                        }
                        this.mOrder_no = split2[1];
                        return;
                    }
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("statecode={");
                stringBuffer.append(this.mStatecode);
                stringBuffer.append("};");
                if (TextUtils.isEmpty(this.mOrder_no)) {
                    this.mOrder_no = "";
                }
                stringBuffer.append("order_no={");
                stringBuffer.append(this.mOrder_no);
                stringBuffer.append("};");
                if (TextUtils.isEmpty(this.mNotify)) {
                    this.mNotify = "";
                }
                stringBuffer.append("notify={");
                stringBuffer.append(this.mNotify);
                stringBuffer.append("};");
                return stringBuffer.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1278410266, "Lcom/baidu/wallet/paysdk/PayCallBackManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1278410266, "Lcom/baidu/wallet/paysdk/PayCallBackManager;");
        }
    }

    public PayCallBackManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, context, i2, str) == null) {
            PayCallBack payBack = BaiduPay.getInstance().getPayBack();
            if (payBack != null) {
                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_DURATION, null, new String[0]);
                payBack.onPayResult(i2, str);
            } else {
                BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
                if (bindCallback != null) {
                    if (i2 == 0) {
                        bindCallback.onChangeSucceed(str);
                    } else {
                        bindCallback.onChangeFailed(str);
                    }
                    BaiduPay.getInstance().clearBindCallback();
                } else {
                    BindBack bindCallbackExt = BaiduPay.getInstance().getBindCallbackExt();
                    if (bindCallbackExt != null) {
                        StatisticManager.onEvent("#onPayResult");
                        bindCallbackExt.onBindResult(i2, str);
                    }
                }
                if (PayDataCache.getInstance().isRemotePay()) {
                    if (BaiduPay.getInstance().getRemotePayContext() != null) {
                        if (i2 != 1000) {
                            try {
                                try {
                                    b(BaiduPay.getInstance().getRemotePayContext(), i2, str);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    StatisticManager.onEventWithValue("remoteGobackToRemotePayCatch", e2.getMessage());
                                }
                            } finally {
                                BaiduPay.getInstance().resetRemotePayContext();
                            }
                        }
                    }
                    PayDataCache.getInstance().setIsRemotePay(false);
                    PayDataCache.getInstance().setRemotePayHostName(null);
                    PayDataCache.getInstance().setRemotePkg(null);
                    PayDataCache.getInstance().setRemoteWhereToBackAct(null);
                }
                PayDataCache.getInstance().resetFromPrecashier();
                PayController.getInstance().clearPreModifiedCallBack();
                PayRequestCache.getInstance().clearPaySdkRequestCache();
                BaiduPay.getInstance().clearPayBack();
                BaiduPay.getInstance().clearBindCallbackExt();
                PayBaseBeanActivity.exitEbpay();
            }
            if (PayDataCache.getInstance().isRemotePay()) {
            }
            PayDataCache.getInstance().resetFromPrecashier();
            PayController.getInstance().clearPreModifiedCallBack();
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            BaiduPay.getInstance().clearPayBack();
            BaiduPay.getInstance().clearBindCallbackExt();
            PayBaseBeanActivity.exitEbpay();
        }
    }

    public static void b(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65539, null, context, i2, str) == null) || TextUtils.isEmpty(PayDataCache.getInstance().getRemotePkg()) || TextUtils.isEmpty(PayDataCache.getInstance().getRemoteWhereToBackAct())) {
            return;
        }
        ComponentName componentName = new ComponentName(PayDataCache.getInstance().getRemotePkg(), PayDataCache.getInstance().getRemoteWhereToBackAct());
        Intent intent = new Intent();
        intent.setComponent(componentName);
        if (isClientDead) {
            intent.putExtra("statuscode", i2);
            intent.putExtra("payresult", str);
        }
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        intent.addFlags(536870912);
        intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        isClientDead = false;
        context.startActivity(intent);
        BaseActivity.clearTask();
    }

    public static void callBackClientCancel(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_FAILED);
            } else {
                StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY);
                StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_FAILED);
            }
            StatisticManager.onEventWithValue("#callBackClientCancel", str);
            PayStateModle payStateModle = new PayStateModle(2, "");
            StatHelper.cacheCodeAndMsg("2", payStateModle.toString());
            a(context, 2, payStateModle.toString());
        }
    }

    public static void callBackClientClear(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            PayStateModle payStateModle = new PayStateModle(1000, "");
            StatHelper.cacheCodeAndMsg(Constants.DEFAULT_UIN, payStateModle.toString());
            a(context, 1000, payStateModle.toString());
        }
    }

    public static void callBackClientPaying(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            PayStateModle payStateModle = new PayStateModle(1, "");
            StatHelper.cacheCodeAndMsg("1", "paying");
            a(context, 1, payStateModle.toString());
        }
    }

    public static void callBackClientSuccess(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            PayStateModle payStateModle = new PayStateModle(0, str);
            StatHelper.cacheCodeAndMsg("0", "paySuccess");
            a(context, 0, payStateModle.toString());
        }
    }
}
