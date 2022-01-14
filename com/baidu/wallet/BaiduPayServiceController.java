package com.baidu.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.CheckCallBack;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class BaiduPayServiceController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ILightappInvokerCallback a;

    /* loaded from: classes13.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static BaiduPayServiceController a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(4006434, "Lcom/baidu/wallet/BaiduPayServiceController$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(4006434, "Lcom/baidu/wallet/BaiduPayServiceController$a;");
                    return;
                }
            }
            a = new BaiduPayServiceController();
        }
    }

    private void b(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65545, this, context, str, z) == null) {
            if (SdkInitResponse.getInstance().jumpSwanApp && c(context, SdkInitResponse.getInstance().transactionSchemeUrl)) {
                return;
            }
            String transactionRecordsUrl = SdkInitResponse.getInstance().getTransactionRecordsUrl(context);
            if (TextUtils.isEmpty(transactionRecordsUrl)) {
                transactionRecordsUrl = BeanConstants.TRANSACTION_RECORDS_URL;
            }
            StringBuilder sb = new StringBuilder(transactionRecordsUrl);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int i2 = new JSONObject(str).getInt("order_type");
                    sb.append("?");
                    sb.append("order_type");
                    sb.append("=");
                    sb.append(i2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            BaiduWalletDelegate.getInstance().openH5Module(context, sb.toString(), false);
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, context) == null) {
            String paySecurityCenterUrl = SdkInitResponse.getInstance().getPaySecurityCenterUrl(context);
            if (TextUtils.isEmpty(paySecurityCenterUrl)) {
                paySecurityCenterUrl = BeanConstants.API_PAY_SECURITY_CENTER_URL;
            }
            BaiduWalletDelegate.getInstance().openH5Module(context, paySecurityCenterUrl, false);
        }
    }

    public static BaiduPayServiceController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a.a : (BaiduPayServiceController) invokeV.objValue;
    }

    public void doScanCode(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            doScanCode(context, false, null, null);
        }
    }

    public void gotoCheckPwdFromH5(Context context, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, str, routerCallback) == null) {
            BaiduPayDelegate.getInstance().checkPwdFromH5(context, str, new CheckCallBack(this, routerCallback) { // from class: com.baidu.wallet.BaiduPayServiceController.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RouterCallback a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduPayServiceController f50310b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, routerCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50310b = this;
                    this.a = routerCallback;
                }

                @Override // com.baidu.wallet.api.CheckCallBack
                public void onCheckResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("errorCode", Integer.valueOf(i2));
                        StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_CHECK_PWD_FROM_H5_RESULT, new ArrayList(), hashMap);
                        if (this.a != null) {
                            HashMap hashMap2 = new HashMap();
                            HashMap hashMap3 = new HashMap();
                            if (i2 == 0) {
                                hashMap3.put("content", str2);
                            } else {
                                hashMap3.put("errCode", Integer.valueOf(i2));
                                hashMap3.put("des", str2);
                            }
                            hashMap2.put("result", BaiduPayDelegate.getInstance().assembleResult(hashMap3, i2 == 0));
                            this.a.onResult(i2 == 0 ? 0 : 1, hashMap2);
                        }
                    }
                }
            });
        }
    }

    public void gotoPaySetActivity(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            String paySettingUrl = SdkInitResponse.getInstance().getPaySettingUrl(context);
            if (TextUtils.isEmpty(paySettingUrl)) {
                paySettingUrl = BeanConstants.API_PAY_SETTING_URL;
            }
            BaiduWalletDelegate.getInstance().openH5Module(context, paySettingUrl, false);
        }
    }

    public void gotoWalletService(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, str2) == null) {
            gotoWalletService(context, str, str2, true);
        }
    }

    public BaiduPayServiceController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public void doScanCode(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            doScanCode(context, z, null, str);
        }
    }

    public void gotoWalletService(Context context, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j2), str}) == null) {
            gotoWalletService(context, j2, str, true);
        }
    }

    private void a(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, this, context, str, z) == null) {
            if (SdkInitResponse.getInstance().jumpSwanApp && c(context, SdkInitResponse.getInstance().balanceSchemeUrl)) {
                return;
            }
            String balanceHomeUrl = SdkInitResponse.getInstance().getBalanceHomeUrl(context);
            if (TextUtils.isEmpty(balanceHomeUrl)) {
                balanceHomeUrl = BeanConstants.API_WALLET_BALANCE_HOME_PATH;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    StringBuilder sb = new StringBuilder(balanceHomeUrl);
                    sb.append("?");
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = jSONObject.optString(next);
                        sb.append(next);
                        sb.append("=");
                        sb.append(optString);
                        sb.append("&");
                    }
                    if (sb.length() > 0) {
                        balanceHomeUrl = sb.substring(0, sb.length() - 1);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
            baiduWalletDelegate.openH5Module(context, balanceHomeUrl + "#", "", z, false);
        }
    }

    public void doScanCode(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) {
            String payCodeUrl = SdkInitResponse.getInstance().getPayCodeUrl(context);
            if (TextUtils.isEmpty(payCodeUrl)) {
                payCodeUrl = BeanConstants.API_WALLET_SCANCODE;
            }
            BaiduWalletDelegate.getInstance().openH5Module(context, payCodeUrl, false);
        }
    }

    public void gotoWalletService(Context context, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str, str2, iLightappInvokerCallback) == null) || iLightappInvokerCallback == null) {
            return;
        }
        this.a = iLightappInvokerCallback;
        gotoWalletService(context, str, str2, true);
    }

    private boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                return false;
            }
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void gotoWalletService(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            gotoWalletService(context, Long.parseLong(str), str2, z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void gotoWalletService(Context context, long j2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j2), str, Boolean.valueOf(z)}) == null) || context == null || j2 < 0) {
            return;
        }
        if (j2 == 4) {
            StatisticManager.onEvent("#myBankInfo");
            a(context);
        } else if (j2 == 16) {
            StatisticManager.onEvent("#transRecord");
            b(context, str, z);
        } else if (j2 == 8) {
            StatisticManager.onEvent("#securityCenter");
            c(context);
        } else if (j2 == 128) {
            StatisticManager.onEvent("#o2oParser");
            a(context, str);
        } else if (j2 == WalletServiceBeanConst.SERVICE_ID_WALLET_PAY_SET) {
            StatisticManager.onEvent("#paySet");
            gotoPaySetActivity(context);
        } else if (j2 == WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_SET) {
            StatisticManager.onEvent("#pwdSet");
            b(context);
        } else if (j2 == WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_CHECK) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_CHECK_PWD_FROM_H5_ENTER, str);
            b(context, str);
        } else if (j2 == 512) {
            StatisticManager.onEvent("#scanQrCode");
            doScanCode(context, false, str);
        } else if (j2 == 32) {
            StatisticManager.onEvent("#balanceInfo");
            a(context, str, z);
        } else if (j2 == 8192) {
            StatisticManager.onEvent("#cashBack");
            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_service_offline_tips"));
        } else {
            GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_not_include_tips"));
        }
    }

    private void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, context, str) == null) {
            BaiduPayDelegate.getInstance().checkPwdFromH5(context, str, new CheckCallBack(this) { // from class: com.baidu.wallet.BaiduPayServiceController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduPayServiceController a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.wallet.api.CheckCallBack
                public void onCheckResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("errorCode", Integer.valueOf(i2));
                        StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_CHECK_PWD_FROM_H5_RESULT, new ArrayList(), hashMap);
                        if (this.a.a != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("{\"result\":");
                            sb.append(i2 == 0 ? 0 : 1);
                            sb.append(",\"cnt\":{");
                            if (i2 == 0) {
                                if (!TextUtils.isEmpty(str2)) {
                                    sb.append("\"content\":\"");
                                    sb.append(str2);
                                    sb.append("\"");
                                }
                                sb.append("}}");
                            } else {
                                sb.append("\"errCode\":");
                                sb.append(i2);
                                sb.append(",\"des\":\"");
                                sb.append(str2);
                                sb.append("\"}}");
                            }
                            this.a.a.onResult(i2 != 0 ? 1 : 0, sb.toString());
                            this.a.a = null;
                        }
                    }
                }
            });
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            String payPwdSettingUrl = SdkInitResponse.getInstance().getPayPwdSettingUrl(context);
            if (TextUtils.isEmpty(payPwdSettingUrl)) {
                payPwdSettingUrl = BeanConstants.API_PAY_PWD_SETTING_URL;
            }
            BaiduWalletDelegate.getInstance().openH5Module(context, payPwdSettingUrl, false);
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            if (SdkInitResponse.getInstance().jumpSwanApp && c(context, SdkInitResponse.getInstance().bankCardSchemeUrl)) {
                return;
            }
            String bankCardListUrl = SdkInitResponse.getInstance().getBankCardListUrl(context);
            if (TextUtils.isEmpty(bankCardListUrl)) {
                bankCardListUrl = BeanConstants.API_BANK_CARD_LIST_URL;
            }
            BaiduWalletDelegate.getInstance().openH5Module(context, bankCardListUrl, false);
        }
    }

    private void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    str = URLEncoder.encode(str, "utf-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                BaiduWalletUtils.invokeHostLightapp(context, str);
                return;
            }
            GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_error"));
        }
    }
}
