package com.baidu.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.NFCUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.SecuityBeanFactory;
import com.baidu.wallet.paysdk.beans.SecuityCenterBean;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.datamodel.AuthStateResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import com.baidu.wallet.utils.StringUtil;
import com.google.protobuf.CodedInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class SecurityCenterActivity extends PayBaseBeanActivity implements View.OnClickListener, BaiduPay.IBindCardCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f26869a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f26870b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f26871c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f26872d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f26873e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f26874f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f26875g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26876h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f26877i;
    public TextView j;
    public RelativeLayout k;
    public RelativeLayout l;
    public RelativeLayout m;
    public View n;
    public View o;
    public com.baidu.wallet.paysdk.presenter.b.a p;
    public DirectPayContentResponse q;
    public AuthStateResponse r;
    public TextView s;
    public RelativeLayout t;
    public SecuityCenterBean u;
    public int v;
    public boolean w;
    public boolean x;
    public String y;
    public LoginBackListenerProxy z;

    public SecurityCenterActivity() {
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
        this.v = -1;
        this.w = false;
        this.x = false;
    }

    private int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            PackageManager packageManager = getPackageManager();
            try {
                if (packageManager.getPackageInfo("cn.opda.a.phonoalbumshoushou", 0) == null) {
                    return 1;
                }
                Intent intent = new Intent("com.dianxinos.optimizer.action.LAUNCH_PAYSECURITY");
                intent.setPackage("cn.opda.a.phonoalbumshoushou");
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                if (queryIntentActivities != null) {
                    return queryIntentActivities.size() == 0 ? 2 : 3;
                }
                return 2;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return 1;
            }
        }
        return invokeV.intValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"InlinedApi"})
    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            PayStatisticsUtil.onEvent(StatServiceEvent.SECURITY_PROTECTION_LAUNCH);
            Intent intent = new Intent("com.dianxinos.optimizer.action.LAUNCH_PAYSECURITY");
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            intent.addFlags(32768);
            intent.putExtra("extra_from", getPackageName());
            ResolveInfo a2 = a(intent);
            if (a2 == null || a2.activityInfo == null) {
                return;
            }
            ActivityInfo activityInfo = a2.activityInfo;
            intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (this.u == null) {
                this.u = (SecuityCenterBean) SecuityBeanFactory.getInstance().getBean((Context) this, 1, "SecurityCenterActivity");
            }
            this.u.setResponseCallback(this);
            this.u.execBean();
            WalletGlobalUtils.safeShowDialog(this, -1, "");
        }
    }

    public com.baidu.wallet.paysdk.presenter.b.a getLoginPresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.p == null) {
                this.p = new com.baidu.wallet.paysdk.presenter.b.b();
            }
            return this.p;
        }
        return (com.baidu.wallet.paysdk.presenter.b.a) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, -1);
            if (i3 == 5003) {
                return;
            }
            if (i2 == 6) {
                if (i3 == 100035 || i3 == 100036) {
                    PassUtil.passNormalized(getActivity(), str, i3 == 100036 ? 2 : 1, new PassUtil.PassNormalize(this) { // from class: com.baidu.wallet.paysdk.ui.SecurityCenterActivity.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ SecurityCenterActivity f26885a;

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
                            this.f26885a = this;
                        }

                        @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                        public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                            InterceptResult invokeLIL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, context, i4, map)) == null) {
                                if (super.onNormalize(context, i4, map)) {
                                    this.f26885a.d();
                                    return false;
                                }
                                this.f26885a.finish();
                                return false;
                            }
                            return invokeLIL.booleanValue;
                        }
                    });
                    return;
                }
            } else if (i2 == 1) {
                a(false);
            }
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, -1);
            if (i2 == 6) {
                DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
                this.q = directPayContentResponse;
                if (directPayContentResponse != null && (userModel = directPayContentResponse.user) != null && userModel.hasMobilePwd()) {
                    if (this.v == 1) {
                        Intent intent = new Intent();
                        intent.setClass(getActivity(), PwdManagerActivity.class);
                        startActivityForResult(intent, 204);
                        return;
                    }
                    return;
                }
                PasswordController.getPassWordInstance().setPasswdByUser(getActivity(), this);
                this.w = true;
            } else if (i2 != 1 || obj == null) {
            } else {
                AuthStateResponse authStateResponse = (AuthStateResponse) obj;
                this.r = authStateResponse;
                this.y = authStateResponse.online_kefu;
                AuthStateResponse.Auth auth = authStateResponse.auth;
                if (auth != null) {
                    this.s.setText(auth.auth_state_desc);
                }
                AuthStateResponse.SignPay signPay = this.r.sign_pay;
                if (signPay != null && !TextUtils.isEmpty(signPay.sign_pay_url)) {
                    a(true);
                } else {
                    a(false);
                }
                AuthStateResponse.AccountInfo accountInfo = this.r.account_info;
                if (accountInfo != null && !TextUtils.isEmpty(accountInfo.link_addr)) {
                    b(true);
                } else {
                    b(false);
                }
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        DirectPayContentResponse payResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 != 40969 || i3 != -1 || intent == null || intent.getExtras() == null || !intent.getExtras().getBoolean("reload_userinfo") || (payResponse = PayDataCache.getInstance().getPayResponse()) == null) {
                return;
            }
            this.q = payResponse;
        }
    }

    @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
    public void onChangeFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
    public void onChangeSucceed(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && this.v == 1) {
            this.v = 4;
            GlobalUtils.toast(this, ResUtils.getString(this, "ebpay_set_pwd_success"));
            d();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AuthStateResponse.AccountInfo accountInfo;
        AuthStateResponse.SignPay signPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view.getId() == this.f26877i.getId()) {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_SECURITY_CLICK_ITEM, "NFC");
                LocalRouter.getInstance(this.mAct).route(this.mAct, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_NFC).action("nfcsetting").data("withAnim", Boolean.FALSE.toString()), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.ui.SecurityCenterActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SecurityCenterActivity f26880a;

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
                        this.f26880a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_NFC);
                            hashMap2.put("action", "nfcsetting");
                            StatisticManager.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                        }
                    }
                });
            } else if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_no_network"));
            } else {
                this.x = true;
                if (view.getId() == ResUtils.id(getActivity(), "security_mobile_pwd_layout")) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_SECURITY_CLICK_ITEM, "PWD");
                    getLoginPresent().a(getActivity(), new LoginBackListenerProxy(getActivity(), new ILoginBackListener(this) { // from class: com.baidu.wallet.paysdk.ui.SecurityCenterActivity.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ SecurityCenterActivity f26881a;

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
                            this.f26881a = this;
                        }

                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onFail(int i2, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            }
                        }

                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onSuccess(int i2, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                                this.f26881a.v = 1;
                                this.f26881a.d();
                            }
                        }
                    }));
                } else if (view.getId() == ResUtils.id(getActivity(), "security_pay_setting")) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_SECURITY_CLICK_ITEM, "PaySetting");
                    getLoginPresent().a(getActivity(), new LoginBackListenerProxy(getActivity(), new ILoginBackListener(this) { // from class: com.baidu.wallet.paysdk.ui.SecurityCenterActivity.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ SecurityCenterActivity f26882a;

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
                            this.f26882a = this;
                        }

                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onFail(int i2, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            }
                        }

                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onSuccess(int i2, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                                this.f26882a.startActivity(new Intent(this.f26882a.getActivity(), PaySettingActivity.class));
                            }
                        }
                    }));
                } else if (f() && view.getId() == ResUtils.id(getActivity(), "security_protection_layout")) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_SECURITY_CLICK_ITEM, "WeiShi");
                    int i2 = this.f26869a;
                    if (i2 == 1) {
                        WalletGlobalUtils.safeShowDialog(this, 3, getText(ResUtils.string(getActivity(), "bd_wallet_pay_security_protection_message_install")).toString());
                    } else if (i2 == 2) {
                        WalletGlobalUtils.safeShowDialog(this, 3, getText(ResUtils.string(getActivity(), "bd_wallet_pay_security_protection_message_update")).toString());
                    } else if (i2 != 3) {
                    } else {
                        g();
                    }
                } else if (view.getId() == ResUtils.id(getActivity(), "security_tips_layout")) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_SECURITY_CLICK_ITEM, "Tips");
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    startActivity(intent.putExtra("jump_url", DomainConfig.getInstance().getCOHost() + "/content/mywallet/h5/safe_tips.html").putExtra("webview_title", "bd_wallet_pay_security_tip"));
                } else if (view.getId() == ResUtils.id(getActivity(), "security_faq_layout")) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_SECURITY_CLICK_ITEM, "FAQ");
                    Intent intent2 = new Intent(getActivity(), WebViewActivity.class);
                    startActivity(intent2.putExtra("jump_url", DomainConfig.getInstance().getCOHost() + "/content/mywallet/h5/com_problem.html").putExtra("webview_title", "bd_wallet_pay_securtiy_faq"));
                } else if (view.getId() == ResUtils.id(getActivity(), "security_contact_layout")) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_SECURITY_CLICK_ITEM, "KeFu");
                    if (WalletLoginHelper.getInstance().isLogin()) {
                        if (TextUtils.isEmpty(this.y)) {
                            return;
                        }
                        String trim = this.y.trim();
                        this.y = trim;
                        if (StringUtil.AcceptUrlPat.matcher(trim).matches()) {
                            BaiduWalletDelegate.getInstance().openH5Module(getApplicationContext(), this.y, false);
                            return;
                        }
                        return;
                    }
                    if (this.z == null) {
                        this.z = new LoginBackListenerProxy(getActivity(), new ILoginBackListener(this) { // from class: com.baidu.wallet.paysdk.ui.SecurityCenterActivity.6
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ SecurityCenterActivity f26883a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f26883a = this;
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onFail(int i3, String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str) == null) {
                                    if (i3 == 603) {
                                        WalletLoginHelper.getInstance().onlyLogin(this.f26883a.z);
                                    } else {
                                        this.f26883a.x = false;
                                    }
                                }
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onSuccess(int i3, String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, str) == null) {
                                }
                            }
                        });
                    }
                    WalletLoginHelper.getInstance().login(this.z);
                } else if (view == this.t) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_SECURITY_CLICK_ITEM, "RNAuth");
                    HashMap hashMap = new HashMap();
                    hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "0");
                    StatisticManager.onEvent(PayStatServiceEvent.PAY_SECURITY_RNAUTH_ENTER);
                    BaiduPayDelegate.getInstance().doRNAuth(getActivity(), hashMap, new RNAuthCallBack(this) { // from class: com.baidu.wallet.paysdk.ui.SecurityCenterActivity.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ SecurityCenterActivity f26884a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f26884a = this;
                        }

                        @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                        public void onRNAuthResult(int i3, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str) == null) {
                                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_SECURITY_RNAUTH_RESULT, StatHelper.collectData(i3 + "", str));
                                this.f26884a.i();
                                this.f26884a.x = false;
                            }
                        }
                    });
                } else if (view.getId() == ResUtils.id(getActivity(), "security_sign_state_layout")) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_SECURITY_CLICK_ITEM, "SingState");
                    AuthStateResponse authStateResponse = this.r;
                    if (authStateResponse != null && (signPay = authStateResponse.sign_pay) != null && !TextUtils.isEmpty(signPay.sign_pay_url)) {
                        if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_no_network"));
                            return;
                        } else {
                            BaiduWalletDelegate.getInstance().openH5Module(getActivity(), this.r.sign_pay.sign_pay_url, true);
                            return;
                        }
                    }
                    GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
                } else if (view.getId() == ResUtils.id(getActivity(), "security_account_info_layout")) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_SECURITY_CLICK_ITEM, "Account");
                    AuthStateResponse authStateResponse2 = this.r;
                    if (authStateResponse2 != null && (accountInfo = authStateResponse2.account_info) != null && !TextUtils.isEmpty(accountInfo.link_addr)) {
                        if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_no_network"));
                            return;
                        } else {
                            BaiduWalletDelegate.getInstance().openH5Module(getActivity(), this.r.account_info.link_addr, true);
                            return;
                        }
                    }
                    GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_securitycenter_activity"));
            setRequestedOrientation(1);
            initActionBar("bd_wallet_pay_security");
            b();
            c();
            i();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BeanManager.getInstance().removeAllBeans("SecurityCenterActivity");
            BaiduPay.getInstance().clearRNAuthBack();
            if (this.w) {
                PasswordController.getPassWordInstance().clearBindCardCallback();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, dialog) == null) {
            if (f() && i2 == 3) {
                PayStatisticsUtil.onEvent(StatServiceEvent.SECURITY_PROTECTION_PROMPT);
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setCancelable(true);
                int string = ResUtils.string(getActivity(), "bd_wallet_pay_security_protection_message_install");
                int string2 = ResUtils.string(getActivity(), "bd_wallet_pay_security_protection_install");
                if (2 == this.f26869a) {
                    string = ResUtils.string(getActivity(), "bd_wallet_pay_security_protection_message_update");
                    string2 = ResUtils.string(getActivity(), "bd_wallet_pay_security_protection_update");
                }
                promptDialog.setMessage(string);
                promptDialog.setTitleText(ResUtils.string(getActivity(), "bd_wallet_pay_security_protection"));
                promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.SecurityCenterActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SecurityCenterActivity f26878a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26878a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26878a, 3);
                        }
                    }
                });
                promptDialog.setPositiveBtn(string2, new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.SecurityCenterActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SecurityCenterActivity f26879a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26879a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26879a, 3);
                            this.f26879a.h();
                        }
                    }
                });
                return;
            }
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            if (f()) {
                a();
            }
            if (this.x) {
                i();
                this.x = false;
            }
            if (NFCUtil.getInstance().isWalletNFCSurport(getActivity())) {
                TextView textView = this.j;
                if (NFCUtil.getInstance().isWalletNFCEnable(getActivity())) {
                    string = ResUtils.getString(getActivity(), "wallet_base_buscard_setting_tip_open");
                } else {
                    string = ResUtils.getString(getActivity(), "wallet_base_buscard_setting_tip_close");
                }
                textView.setText(string);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "security_pay_setting"));
            this.f26871c = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.f26870b = (LinearLayout) findViewById(ResUtils.id(getActivity(), "security_item_layout"));
            RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "security_mobile_pwd_layout"));
            this.f26872d = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
            RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "security_sign_state_layout"));
            this.f26873e = relativeLayout3;
            relativeLayout3.setOnClickListener(this);
            RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "security_account_info_layout"));
            this.f26874f = relativeLayout4;
            relativeLayout4.setOnClickListener(this);
            RelativeLayout relativeLayout5 = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "security_protection_layout"));
            this.f26875g = relativeLayout5;
            relativeLayout5.setOnClickListener(this);
            this.f26876h = (TextView) findViewById(ResUtils.id(getActivity(), "security_protection_status"));
            RelativeLayout relativeLayout6 = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "security_auth_layout"));
            this.t = relativeLayout6;
            relativeLayout6.setOnClickListener(this);
            this.s = (TextView) findViewById(ResUtils.id(getActivity(), "security_auth_status"));
            RelativeLayout relativeLayout7 = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "nfc_setting_layout"));
            this.f26877i = relativeLayout7;
            relativeLayout7.setOnClickListener(this);
            this.j = (TextView) findViewById(ResUtils.id(getActivity(), "nfc_setting_status"));
            RelativeLayout relativeLayout8 = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "security_tips_layout"));
            this.k = relativeLayout8;
            relativeLayout8.setOnClickListener(this);
            RelativeLayout relativeLayout9 = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "security_faq_layout"));
            this.l = relativeLayout9;
            relativeLayout9.setOnClickListener(this);
            RelativeLayout relativeLayout10 = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "security_contact_layout"));
            this.m = relativeLayout10;
            relativeLayout10.setOnClickListener(this);
            this.n = findViewById(ResUtils.id(getActivity(), "security_sign_state_layout_divider"));
            this.o = findViewById(ResUtils.id(getActivity(), "security_account_info_layout_divider"));
            String str = BeanConstants.VERSION_NO;
            TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "version_tv"));
            if (textView != null) {
                textView.setOnClickListener(this);
                if (TextUtils.isEmpty(BeanConstants.VERSION_NO)) {
                    return;
                }
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= BeanConstants.VERSION_NO.length()) {
                        i2 = 0;
                        break;
                    } else if (BeanConstants.VERSION_NO.charAt(i2) == '.' && (i3 = i3 + 1) >= 3) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 > 0) {
                    str = BeanConstants.VERSION_NO.substring(0, i2);
                }
                textView.setText("v" + str);
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f26871c.setVisibility(0);
            this.f26870b.setVisibility(0);
            this.f26872d.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            boolean f2 = f();
            this.f26875g.setVisibility(f2 ? 0 : 8);
            findViewById(ResUtils.id(getActivity(), "security_protection_inner_divider")).setVisibility(f2 ? 0 : 8);
            boolean isWalletNFCSurport = NFCUtil.getInstance().isWalletNFCSurport(getActivity());
            this.f26877i.setVisibility(isWalletNFCSurport ? 0 : 8);
            findViewById(ResUtils.id(getActivity(), "nfc_setting_divider")).setVisibility(isWalletNFCSurport ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) getActivity(), 6, "SecurityCenterActivity");
            userInfoBean.setResponseCallback(this);
            userInfoBean.execBean();
            WalletGlobalUtils.safeShowDialog(this, -1, "");
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int e2 = e();
            this.f26869a = e2;
            if (3 == e2) {
                this.f26876h.setText(ResUtils.string(getActivity(), "bd_wallet_enabled"));
            } else {
                this.f26876h.setText(ResUtils.string(getActivity(), "bd_wallet_disabled"));
            }
        }
    }

    private ResolveInfo a(Intent intent) {
        InterceptResult invokeL;
        ActivityInfo activityInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, intent)) == null) {
            List<ResolveInfo> queryIntentActivities = getActivity().getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() >= 1) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && "cn.opda.a.phonoalbumshoushou".equals(activityInfo.packageName)) {
                        return resolveInfo;
                    }
                }
            }
            return null;
        }
        return (ResolveInfo) invokeL.objValue;
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) || this.f26873e == null) {
            return;
        }
        int i2 = z ? 0 : 8;
        this.n.setVisibility(i2);
        this.f26873e.setVisibility(i2);
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65545, this, z) == null) || this.f26874f == null) {
            return;
        }
        int i2 = z ? 0 : 8;
        this.o.setVisibility(i2);
        this.f26874f.setVisibility(i2);
    }
}
