package com.baidu.wallet.paysdk.payresult.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.v;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.apollon.NoProguard;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.beans.NetworkBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class CashierDeskPayResult extends H5PayResultProcess implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f62410a;

    /* renamed from: b  reason: collision with root package name */
    public H5LifeCycleCallback f62411b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class PayScenario {
        public static final /* synthetic */ PayScenario[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PayScenario BalancedPay;
        public static final PayScenario BankcardPay;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(610700344, "Lcom/baidu/wallet/paysdk/payresult/presenter/CashierDeskPayResult$PayScenario;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(610700344, "Lcom/baidu/wallet/paysdk/payresult/presenter/CashierDeskPayResult$PayScenario;");
                    return;
                }
            }
            BankcardPay = new PayScenario("BankcardPay", 0);
            PayScenario payScenario = new PayScenario("BalancedPay", 1);
            BalancedPay = payScenario;
            $VALUES = new PayScenario[]{BankcardPay, payScenario};
        }

        public PayScenario(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PayScenario valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PayScenario) Enum.valueOf(PayScenario.class, str) : (PayScenario) invokeL.objValue;
        }

        public static PayScenario[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PayScenario[]) $VALUES.clone() : (PayScenario[]) invokeV.objValue;
        }
    }

    public CashierDeskPayResult(Context context, H5ResultParams h5ResultParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, h5ResultParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62411b = null;
        this.mContext = context;
        this.mH5 = h5ResultParams;
    }

    private String a() {
        InterceptResult invokeV;
        H5ResultParams h5ResultParams;
        List<RestNameValuePair> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mContext == null || (h5ResultParams = this.mH5) == null || TextUtils.isEmpty(h5ResultParams.pay_result_url)) {
                return null;
            }
            if (PayScenario.BalancedPay == this.mH5.pay_scenario) {
                b2 = c();
            } else {
                b2 = b();
            }
            if (b2 == null) {
                return null;
            }
            if (!TextUtils.isEmpty(this.mH5.pay_result_params)) {
                for (String str : this.mH5.pay_result_params.split("&")) {
                    String[] split = str.split("=");
                    b2.add(new RestNameValuePair(split[0], split[1]));
                }
            }
            b2.add(new RestNameValuePair("session_id", NetworkBean.SessionCache.getInstance().getSessionId(null)));
            String processedParams = H5PayResultProcess.getProcessedParams(b2, "UTF-8");
            if (TextUtils.isEmpty(processedParams)) {
                return null;
            }
            return this.mH5.pay_result_url + "?is_from_sdk=1&result_type=cashdesk&order_query=" + processedParams;
        }
        return (String) invokeV.objValue;
    }

    private List<RestNameValuePair> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            v vVar = (v) PayBeanFactory.getInstance().getBean(this.mContext, 12, "CashierDeskPayResult");
            List<RestNameValuePair> generateRequestParam = vVar.generateRequestParam();
            BeanManager.getInstance().removeBean(vVar);
            if (generateRequestParam != null) {
                Iterator<RestNameValuePair> it = generateRequestParam.iterator();
                boolean z = false;
                while (!z && it.hasNext()) {
                    RestNameValuePair next = it.next();
                    if (next != null && "sign".equals(next.getName())) {
                        it.remove();
                        z = true;
                    }
                }
            }
            return generateRequestParam;
        }
        return (List) invokeV.objValue;
    }

    private List<RestNameValuePair> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            PayResultContent payStateContent = PayDataCache.getInstance().getPayStateContent();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("session_id", NetworkBean.SessionCache.getInstance().getSessionId(null)));
            arrayList.add(new RestNameValuePair("name", "get_balance_pay_trans_state"));
            arrayList.add(new RestNameValuePair("order_no", payStateContent.order_no));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void afterShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            PayDataCache.getInstance().setH5ResultParams(null);
            if (this.mContext == null) {
                return;
            }
            PayResultContent payStateContent = PayDataCache.getInstance().getPayStateContent();
            PayCallBackManager.callBackClientSuccess(this.mContext, payStateContent == null ? "" : payStateContent.notify);
            PayDataCache.getInstance().setPayReslutContent(null);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void beforeShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62410a = a();
            PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (this.f62410a == null) {
                afterShow();
                return;
            }
            if (this.f62411b == null) {
                H5LifeCycleCallback h5LifeCycleCallback = new H5LifeCycleCallback(this) { // from class: com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CashierDeskPayResult f62412a;

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
                        this.f62412a = this;
                    }

                    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, activity) == null) {
                            pop();
                            this.f62412a.afterShow();
                        }
                    }
                };
                this.f62411b = h5LifeCycleCallback;
                h5LifeCycleCallback.push();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("with_anim", false);
            bundle.putBoolean("show_share", false);
            bundle.putString("url", this.f62410a);
            bundle.putParcelable("lifecycleLsnr", this.f62411b);
            BaiduWalletDelegate.getInstance().openH5Module(this.mContext, bundle);
            PayBaseBeanActivity.exitEbpay();
        }
    }
}
