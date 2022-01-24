package com.baidu.wallet.newbindcard.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.e;
import com.baidu.wallet.paysdk.datamodel.CardAddErrorContent;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.presenter.k;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
/* loaded from: classes13.dex */
public class b extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PayBaseBeanActivity payBaseBeanActivity) {
        super(payBaseBeanActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payBaseBeanActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((PayBaseBeanActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, dialog) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, precashierCreateOrderResponse) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void d() {
        PayBaseBeanActivity payBaseBeanActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (payBaseBeanActivity = this.f52146b) == null) {
            return;
        }
        payBaseBeanActivity.setFlagActiveBindCard();
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            StringBuilder sb = new StringBuilder();
            String extraParam = NewBindCardEntry.getInstance().getExtraParam();
            if (!TextUtils.isEmpty(extraParam)) {
                sb.append(extraParam);
                sb.setCharAt(sb.length() - 1, ',');
            } else {
                sb.append(StringUtil.ARRAY_START);
            }
            sb.append("request_type:11}");
            e eVar = new e(this.f52146b);
            eVar.a(NewBindCardEntry.getInstance().getBindReq());
            eVar.a(sb.toString());
            eVar.setResponseCallback(this);
            eVar.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "WelcomeActivity callBackCancel", false);
            PayBaseBeanActivity payBaseBeanActivity = this.f52146b;
            if (payBaseBeanActivity != null) {
                payBaseBeanActivity.finishWithoutAnim();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, obj, str) == null) {
            CardAddResponse.updateContent(obj);
            if (((CardAddResponse) obj) == null || this.f52146b == null) {
                return;
            }
            this.f52146b.startActivity(new Intent(this.f52146b, NewBindCardEnterActivity.class));
            this.f52146b.finishWithoutAnim();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            CardAddResponse.updateContent(null);
            if (i3 == 5003) {
                PayBaseBeanActivity payBaseBeanActivity = this.f52146b;
                GlobalUtils.toast(payBaseBeanActivity, ResUtils.getString(payBaseBeanActivity, "dxm_wallet_base_please_login"));
                AccountManager.getInstance(this.f52146b).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (-2 == i3 || -3 == i3) {
                PayBaseBeanActivity payBaseBeanActivity2 = this.f52146b;
                GlobalUtils.toast(payBaseBeanActivity2, ResUtils.getString(payBaseBeanActivity2, "dxm_fp_get_data_fail"));
            } else if (-8 == i3) {
                PayBaseBeanActivity payBaseBeanActivity3 = this.f52146b;
                GlobalUtils.toast(payBaseBeanActivity3, ResUtils.getString(payBaseBeanActivity3, "dxm_ebpay_no_network"));
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(this.f52146b, "dxm_fp_get_data_fail");
                }
                GlobalUtils.toast(this.f52146b, str);
            }
            c();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, int i3, String str, Object obj) {
        CardAddErrorContent cardAddErrorContent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            CardAddResponse.updateContent(null);
            if (i3 == 16254 && obj != null && (obj instanceof CardAddErrorContent)) {
                if (!TextUtils.isEmpty(((CardAddErrorContent) obj).goto_url)) {
                    StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_ENTER);
                    H5LifeCycleCallback h5LifeCycleCallback = new H5LifeCycleCallback(this) { // from class: com.baidu.wallet.newbindcard.b.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ b a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback, android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityDestroyed(Activity activity) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, activity) == null) {
                                pop();
                                if (this.a.a) {
                                    if (this.a.f52146b != null) {
                                        this.a.f52146b.finishWithoutAnim();
                                    }
                                } else {
                                    StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_FAILED);
                                    this.a.c();
                                }
                                this.a.a = false;
                            }
                        }
                    };
                    h5LifeCycleCallback.push();
                    EventBus.getInstance().register(this.f52146b, BeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT, 0, EventBus.ThreadMode.MainThread);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("with_anim", false);
                    bundle.putBoolean("show_share", false);
                    bundle.putString("url", cardAddErrorContent.goto_url + "?is_from_sdk=1");
                    bundle.putParcelable("lifecycleLsnr", h5LifeCycleCallback);
                    BaiduWalletDelegate.getInstance().openH5Module(this.f52146b, bundle);
                    return;
                }
                c();
                return;
            }
            c();
        }
    }

    public void a(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, event) == null) {
            if (event != null && event.mEventObj != null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                    if (jSONObject.has("confirm_result") && 1 == jSONObject.getInt("confirm_result")) {
                        StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_AGREE);
                        this.a = true;
                        NewBindCardEntry.getInstance().startWelcomeActivity(this.f52146b);
                    } else {
                        StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_FAILED);
                        c();
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    c();
                    return;
                }
            }
            StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_FAILED);
            c();
        }
    }
}
