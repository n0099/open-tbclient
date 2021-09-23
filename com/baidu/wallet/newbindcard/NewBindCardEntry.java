package com.baidu.wallet.newbindcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
/* loaded from: classes8.dex */
public class NewBindCardEntry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BING_CARD_SUCCESS_MSG = "ok";
    public static final String BING_CARD_SUCCESS_STATUS = "0";
    public transient /* synthetic */ FieldHolder $fh;
    public String mBindCardNo;
    public PayRequestCache.BindCategory mBindCategory;
    public BindFastRequest mBindReq;
    public String mExtraParam;
    public boolean mH5BindCardSuccess;

    /* loaded from: classes8.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final NewBindCardEntry INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1868061657, "Lcom/baidu/wallet/newbindcard/NewBindCardEntry$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1868061657, "Lcom/baidu/wallet/newbindcard/NewBindCardEntry$SingletonHolder;");
                    return;
                }
            }
            INSTANCE = new NewBindCardEntry();
        }

        public SingletonHolder() {
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
    }

    public static NewBindCardEntry getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? SingletonHolder.INSTANCE : (NewBindCardEntry) invokeV.objValue;
    }

    public PayRequestCache.BindCategory getBindCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBindCategory : (PayRequestCache.BindCategory) invokeV.objValue;
    }

    public BindFastRequest getBindReq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBindReq : (BindFastRequest) invokeV.objValue;
    }

    public String getExtraParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mExtraParam : (String) invokeV.objValue;
    }

    public void newBindCardCallback(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            if (!z) {
                a.a(PayStatServiceEvent.NEW_BIND_CARD_RESULT, a.a(), a.b(), a.c(), a.d(), str, str2);
            }
            BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
            if (bindCallback != null) {
                if ("0".equals(str)) {
                    bindCallback.onChangeSucceed(str2);
                } else {
                    bindCallback.onChangeFailed("");
                }
            }
            if (this.mBindCategory != null) {
                PayRequestCache.getInstance().removeBeanRequestFromCache(this.mBindCategory.name());
            }
            BindFastRequest bindFastRequest = this.mBindReq;
            if (bindFastRequest != null) {
                bindFastRequest.setmBankInfo(null);
            }
            this.mBindReq = null;
            this.mExtraParam = null;
            this.mBindCardNo = null;
            a.e();
            BaiduPay.getInstance().clearBindCallback();
            PayBaseBeanActivity.exitActiveBindCard();
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, event) == null) || event == null) {
            return;
        }
        if ((BeanConstants.EVENT_H5_QUICK_BIND_CARD.equals(event.mEventKey) || BeanConstants.EV_BANK_DETAIL_CARD_CHANGE.equals(event.mEventKey)) && event.mEventObj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                if (jSONObject.has("bind_card_result") && 1 == jSONObject.getInt("bind_card_result")) {
                    this.mH5BindCardSuccess = true;
                    this.mBindCardNo = jSONObject.optString("card_no", "");
                    a.a(PayStatServiceEvent.NEW_H5_BIND_CARD_SUCCESS, "1");
                } else if (jSONObject.has("type") && 1 == jSONObject.getInt("type")) {
                    this.mH5BindCardSuccess = true;
                    this.mBindCardNo = jSONObject.optString("card_no", "");
                    a.a(PayStatServiceEvent.NEW_H5_BIND_CARD_SUCCESS, "0");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setExtrParam(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mExtraParam = str;
        }
    }

    public void startH5BindCard(Context context, BaiduPay.IBindCardCallback iBindCardCallback, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, context, iBindCardCallback, str) == null) || iBindCardCallback == null) {
            return;
        }
        if (context == null) {
            iBindCardCallback.onChangeFailed("context is null");
            return;
        }
        a.a(PayStatServiceEvent.NEW_ENTER_H5_BIND_CARD, new String[0]);
        BaiduPay.getInstance().setBindCallback(iBindCardCallback);
        String h5BindCardUrl = SdkInitResponse.getInstance().getH5BindCardUrl(context);
        if (TextUtils.isEmpty(h5BindCardUrl)) {
            h5BindCardUrl = BeanConstants.API_H5_BIND_CARD_URL;
        }
        H5LifeCycleCallback h5LifeCycleCallback = new H5LifeCycleCallback(this) { // from class: com.baidu.wallet.newbindcard.NewBindCardEntry.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NewBindCardEntry this$0;

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
                this.this$0 = this;
            }

            @Override // com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, activity) == null) {
                    EventBus.getInstance().unregister(this.this$0, BeanConstants.EVENT_H5_QUICK_BIND_CARD);
                    EventBus.getInstance().unregister(this.this$0, BeanConstants.EV_BANK_DETAIL_CARD_CHANGE);
                    pop();
                    BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
                    if (bindCallback != null) {
                        if (this.this$0.mH5BindCardSuccess) {
                            bindCallback.onChangeSucceed(this.this$0.mBindCardNo);
                        } else {
                            bindCallback.onChangeFailed("");
                        }
                    }
                    this.this$0.mH5BindCardSuccess = false;
                    a.e();
                    BaiduPay.getInstance().clearBindCallback();
                    PayBaseBeanActivity.exitActiveBindCard();
                }
            }
        };
        Bundle bundle = new Bundle();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(h5BindCardUrl);
        if (TextUtils.isEmpty(str)) {
            stringBuffer.append("0");
        } else {
            stringBuffer.append(str);
        }
        stringBuffer.append("&is_from_sdk=1");
        bundle.putBoolean("with_anim", false);
        bundle.putBoolean("show_share", false);
        bundle.putString("url", stringBuffer.toString());
        bundle.putParcelable("lifecycleLsnr", h5LifeCycleCallback);
        stringBuffer.toString();
        h5LifeCycleCallback.push();
        EventBus.getInstance().register(this, BeanConstants.EV_BANK_DETAIL_CARD_CHANGE, 0, EventBus.ThreadMode.MainThread);
        EventBus.getInstance().register(this, BeanConstants.EVENT_H5_QUICK_BIND_CARD, 0, EventBus.ThreadMode.MainThread);
        BaiduWalletDelegate.getInstance().openH5Module(context, bundle);
    }

    public void startNewBindCard(Context context, BaiduPay.IBindCardCallback iBindCardCallback, PayRequestCache.BindCategory bindCategory, BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, context, iBindCardCallback, bindCategory, bindFastRequest) == null) || iBindCardCallback == null) {
            return;
        }
        if (context != null && bindCategory != null) {
            BaiduPay.getInstance().setBindCallback(iBindCardCallback);
            this.mBindReq = bindFastRequest;
            this.mBindCategory = bindCategory;
            PayRequestCache.getInstance().addBeanRequestToCache(this.mBindCategory.name(), this.mBindReq);
            startWelcomeActivity(context);
            return;
        }
        iBindCardCallback.onChangeFailed("context is null");
    }

    public void startWelcomeActivity(Context context) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            Intent intent = new Intent(context, WelcomeActivity.class);
            intent.putExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 5);
            if (BaiduWalletUtils.isActivity(context)) {
                if (context instanceof BaseActivity) {
                    BaseActivity baseActivity = (BaseActivity) context;
                    baseActivity.startActivityWithoutAnim(intent);
                    activity = baseActivity.getActivity();
                } else {
                    context.startActivity(intent);
                    activity = (Activity) context;
                }
                BaiduWalletUtils.overridePendingTransitionNoAnim(activity);
                return;
            }
            intent.addFlags(268435456);
            context.getApplicationContext().startActivity(intent);
        }
    }

    public NewBindCardEntry() {
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
        this.mH5BindCardSuccess = false;
    }
}
