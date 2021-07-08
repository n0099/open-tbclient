package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.NFCUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.personal.ui.BankCardListActivity;
/* loaded from: classes5.dex */
public class PwdManagerActivity extends PayBaseBeanActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f26653a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f26654b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f26655c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f26656d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26657e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26658f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26659g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26660h;

    /* renamed from: i  reason: collision with root package name */
    public DirectPayContentResponse f26661i;
    public boolean j;
    public LinearLayout k;
    public boolean l;
    public boolean m;
    public LoginBackListenerProxy n;

    public PwdManagerActivity() {
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
        this.f26659g = false;
        this.f26660h = false;
        this.j = false;
        this.l = false;
        this.m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.n = new LoginBackListenerProxy(this.f26653a, new ILoginBackListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PwdManagerActivity f26668a;

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
                    this.f26668a = this;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) && i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(this.f26668a.n);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f26668a.f();
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) this, 6, "PhonePwdActivity");
            userInfoBean.setResponseCallback(this);
            userInfoBean.execBean();
            WalletGlobalUtils.safeShowDialog(this, -1, "");
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, -1);
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
            this.f26661i = (DirectPayContentResponse) obj;
            WalletGlobalUtils.safeDismissDialog(this, -1);
            if (this.f26661i != null) {
                this.j = true;
                this.f26659g = false;
                a();
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setResult(-1, new Intent().putExtra("reload_userinfo", this.j));
            finish();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.f26653a = getActivity();
            setContentView(ResUtils.layout(getActivity(), "wallet_base_pwd_manager_activity"));
            setRequestedOrientation(1);
            if (bundle == null) {
                this.f26661i = PayDataCache.getInstance().getPayResponse();
            } else {
                this.f26661i = (DirectPayContentResponse) bundle.getSerializable("mUserInfoContent");
            }
            b();
            a();
            EventBus.getInstance().register(this, BankCardListActivity.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BeanManager.getInstance().removeAllBeans("PhonePwdActivity");
            if (this.m) {
                PasswordController.getPassWordInstance().clearEditPwdCallBack();
            }
            if (this.l) {
                PasswordController.getPassWordInstance().clearForgetPasswdCallback();
            }
            EventBus.getInstance().unregister(this);
            super.onDestroy();
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, event) == null) || event == null || !BankCardListActivity.EVT_PAY_PWD_CHANGE.equals(event.mEventKey) || event.mEventObj == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) event.mEventObj);
            if (jSONObject.has("is_succeed") && 1 == jSONObject.getInt("is_succeed")) {
                this.f26659g = true;
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.REGET_PWD_SUCCESSFULLY, "reGetPwd");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (!WalletLoginHelper.getInstance().isLogin()) {
                this.k.setVisibility(8);
                this.f26656d.setVisibility(8);
                this.f26657e.setVisibility(0);
                this.f26658f.setVisibility(8);
            } else if (this.f26660h) {
                this.k.setVisibility(0);
                this.f26656d.setVisibility(8);
                this.f26657e.setVisibility(8);
                this.f26658f.setVisibility(8);
            }
            if (this.f26659g) {
                e();
            }
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("mUserInfoContent", this.f26661i);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.k = (LinearLayout) findViewById(ResUtils.id(this.f26653a, "modify_forget_layout"));
            ViewGroup viewGroup = (ViewGroup) findViewById(ResUtils.id(this.f26653a, "bd_wallet_modify_pwd"));
            this.f26654b = viewGroup;
            if (viewGroup != null) {
                viewGroup.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdManagerActivity f26662a;

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
                        this.f26662a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayStatisticsUtil.onEventWithValue(StatServiceEvent.MODIFY_PWD_LAYOUT_CLICK, "modifyPwd");
                            PasswordController.getPassWordInstance().editPwd(this.f26662a.f26653a, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f26663a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f26663a = this;
                                }

                                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                                public void onFail(int i2, String str) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str) == null) {
                                    }
                                }

                                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                                public void onSucceed(String str) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                                        BaseActivity.clearTasksTopOf(this.f26663a.f26662a);
                                        PayStatisticsUtil.onEventWithValue(StatServiceEvent.MODIFY_PWD_SUCCESSFULLY, "editPwd");
                                    }
                                }
                            });
                            this.f26662a.m = true;
                        }
                    }
                });
            }
            ViewGroup viewGroup2 = (ViewGroup) findViewById(ResUtils.id(this.f26653a, "bd_wallet_forget_pwd"));
            this.f26655c = viewGroup2;
            if (viewGroup2 != null) {
                viewGroup2.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdManagerActivity f26664a;

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
                        this.f26664a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                            Activity activity = this.f26664a.getActivity();
                            baiduWalletDelegate.openH5Module(activity, DomainConfig.getInstance().getMHost() + BeanConstants.API_FIND_PASS, false);
                            this.f26664a.l = true;
                        }
                    }
                });
            }
            ViewGroup viewGroup3 = (ViewGroup) findViewById(ResUtils.id(this.f26653a, "bd_wallet_set_pwd"));
            this.f26656d = viewGroup3;
            if (viewGroup3 != null) {
                viewGroup3.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdManagerActivity f26665a;

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
                        this.f26665a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            BaiduPay.getInstance().bindCardOnCardaddReturn(this.f26665a.f26653a, new BindCardEntry.OnReturn(this) { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f26666a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f26666a = this;
                                }

                                @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                                public void onFailed(int i2, String str) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str) == null) {
                                    }
                                }

                                @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                                public void onResponse(CardAddResponse cardAddResponse) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cardAddResponse) == null) {
                                    }
                                }
                            }, PayRequestCache.BindCategory.Initiative, 4, null, null);
                        }
                    }
                });
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            TextView textView = (TextView) findViewById(ResUtils.id(this.f26653a, "bd_wallet_my_bank_network_not_avail"));
            this.f26657e = textView;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PwdManagerActivity f26667a;

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
                    this.f26667a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f26667a.e();
                    }
                }
            });
            this.f26658f = (TextView) findViewById(ResUtils.id(this.f26653a, "bd_wallet_get_info_error"));
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            initActionBar("bd_wallet_phone_pwd");
            c();
            d();
        }
    }

    private void a() {
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            DirectPayContentResponse directPayContentResponse = this.f26661i;
            if (directPayContentResponse != null && (userModel = directPayContentResponse.user) != null) {
                if (userModel.hasMobilePwd()) {
                    this.k.setVisibility(0);
                    this.f26656d.setVisibility(8);
                    this.f26657e.setVisibility(8);
                    this.f26658f.setVisibility(8);
                    this.f26660h = true;
                    return;
                } else if (this.f26661i.user.hasMobilePwd()) {
                    return;
                } else {
                    this.k.setVisibility(8);
                    this.f26656d.setVisibility(0);
                    this.f26657e.setVisibility(8);
                    this.f26658f.setVisibility(8);
                    return;
                }
            }
            this.k.setVisibility(8);
            this.f26657e.setVisibility(8);
            this.f26656d.setVisibility(8);
            this.f26658f.setVisibility(0);
        }
    }
}
