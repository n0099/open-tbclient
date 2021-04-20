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
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
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

    /* renamed from: a  reason: collision with root package name */
    public Context f25849a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f25850b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f25851c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f25852d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25853e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25854f;
    public DirectPayContentResponse i;
    public LinearLayout k;
    public LoginBackListenerProxy n;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25855g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25856h = false;
    public boolean j = false;
    public boolean l = false;
    public boolean m = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.n = new LoginBackListenerProxy(this.f25849a, new ILoginBackListener() { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.5
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(PwdManagerActivity.this.n);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                PwdManagerActivity.this.f();
            }
        });
        WalletLoginHelper.getInstance().login(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) this, 6, "PhonePwdActivity");
        userInfoBean.setResponseCallback(this);
        userInfoBean.execBean();
        WalletGlobalUtils.safeShowDialog(this, -1, "");
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        WalletGlobalUtils.safeDismissDialog(this, -1);
        super.handleFailure(i, i2, str);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        this.i = (DirectPayContentResponse) obj;
        WalletGlobalUtils.safeDismissDialog(this, -1);
        if (this.i != null) {
            this.j = true;
            this.f25855g = false;
            a();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1, new Intent().putExtra("reload_userinfo", this.j));
        finish();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f25849a = getActivity();
        setContentView(ResUtils.layout(getActivity(), "wallet_base_pwd_manager_activity"));
        setRequestedOrientation(1);
        if (bundle == null) {
            this.i = PayDataCache.getInstance().getPayResponse();
        } else {
            this.i = (DirectPayContentResponse) bundle.getSerializable("mUserInfoContent");
        }
        b();
        a();
        EventBus.getInstance().register(this, BankCardListActivity.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
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

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !BankCardListActivity.EVT_PAY_PWD_CHANGE.equals(event.mEventKey) || event.mEventObj == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) event.mEventObj);
            if (jSONObject.has("is_succeed") && 1 == jSONObject.getInt("is_succeed")) {
                this.f25855g = true;
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.REGET_PWD_SUCCESSFULLY, "reGetPwd");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!WalletLoginHelper.getInstance().isLogin()) {
            this.k.setVisibility(8);
            this.f25852d.setVisibility(8);
            this.f25853e.setVisibility(0);
            this.f25854f.setVisibility(8);
        } else if (this.f25856h) {
            this.k.setVisibility(0);
            this.f25852d.setVisibility(8);
            this.f25853e.setVisibility(8);
            this.f25854f.setVisibility(8);
        }
        if (this.f25855g) {
            e();
        }
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("mUserInfoContent", this.i);
    }

    private void c() {
        this.k = (LinearLayout) findViewById(ResUtils.id(this.f25849a, "modify_forget_layout"));
        ViewGroup viewGroup = (ViewGroup) findViewById(ResUtils.id(this.f25849a, "bd_wallet_modify_pwd"));
        this.f25850b = viewGroup;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.MODIFY_PWD_LAYOUT_CLICK, "modifyPwd");
                    PasswordController.getPassWordInstance().editPwd(PwdManagerActivity.this.f25849a, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.1.1
                        @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                        public void onFail(int i, String str) {
                        }

                        @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                        public void onSucceed(String str) {
                            BaseActivity.clearTasksTopOf(PwdManagerActivity.this);
                            PayStatisticsUtil.onEventWithValue(StatServiceEvent.MODIFY_PWD_SUCCESSFULLY, "editPwd");
                        }
                    });
                    PwdManagerActivity.this.m = true;
                }
            });
        }
        ViewGroup viewGroup2 = (ViewGroup) findViewById(ResUtils.id(this.f25849a, "bd_wallet_forget_pwd"));
        this.f25851c = viewGroup2;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                    Activity activity = PwdManagerActivity.this.getActivity();
                    baiduWalletDelegate.openH5Module(activity, DomainConfig.getInstance().getMHost() + BeanConstants.API_FIND_PASS, false);
                    PwdManagerActivity.this.l = true;
                }
            });
        }
        ViewGroup viewGroup3 = (ViewGroup) findViewById(ResUtils.id(this.f25849a, "bd_wallet_set_pwd"));
        this.f25852d = viewGroup3;
        if (viewGroup3 != null) {
            viewGroup3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaiduPay.getInstance().bindCardOnCardaddReturn(PwdManagerActivity.this.f25849a, new BindCardEntry.OnReturn() { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.3.1
                        @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                        public void onFailed(int i, String str) {
                        }

                        @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                        public void onResponse(CardAddResponse cardAddResponse) {
                        }
                    }, PayRequestCache.BindCategory.Initiative, 4, null, null);
                }
            });
        }
    }

    private void d() {
        TextView textView = (TextView) findViewById(ResUtils.id(this.f25849a, "bd_wallet_my_bank_network_not_avail"));
        this.f25853e = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdManagerActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PwdManagerActivity.this.e();
            }
        });
        this.f25854f = (TextView) findViewById(ResUtils.id(this.f25849a, "bd_wallet_get_info_error"));
    }

    private void b() {
        initActionBar("bd_wallet_phone_pwd");
        c();
        d();
    }

    private void a() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.i;
        if (directPayContentResponse != null && (userModel = directPayContentResponse.user) != null) {
            if (userModel.hasMobilePwd()) {
                this.k.setVisibility(0);
                this.f25852d.setVisibility(8);
                this.f25853e.setVisibility(8);
                this.f25854f.setVisibility(8);
                this.f25856h = true;
                return;
            } else if (this.i.user.hasMobilePwd()) {
                return;
            } else {
                this.k.setVisibility(8);
                this.f25852d.setVisibility(0);
                this.f25853e.setVisibility(8);
                this.f25854f.setVisibility(8);
                return;
            }
        }
        this.k.setVisibility(8);
        this.f25853e.setVisibility(8);
        this.f25852d.setVisibility(8);
        this.f25854f.setVisibility(0);
    }
}
