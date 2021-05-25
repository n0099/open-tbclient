package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.base.widget.SixNumberPwdView;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.PwdPayPresenterFactory;
import com.baidu.wallet.paysdk.presenter.PwdPayPresenterForCashdesk;
import com.baidu.wallet.paysdk.presenter.PwdPayPresenterForScancode;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew;
import com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew;
import com.baidu.wallet.personal.ui.BankCardListActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class PwdPayActivity extends HalfScreenBaseActivity implements View.OnClickListener, SixNumberPwdView.OnPwdChangedListener {
    public static final String TAG = "PwdPayActivity";

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f25831a;

    /* renamed from: b  reason: collision with root package name */
    public View f25832b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25833c;

    /* renamed from: e  reason: collision with root package name */
    public View f25834e;

    /* renamed from: f  reason: collision with root package name */
    public SafeScrollView f25835f;

    /* renamed from: g  reason: collision with root package name */
    public SafeKeyBoardEditText f25836g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25837h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f25838i;
    public TextView j;
    public SixNumberPwdView k;
    public PayLoadingImageViewNew l;
    public View m;
    public PwdPayContract.Presenter mPresenter;
    public SuccessImageViewNew n;
    public PwdRequest o;
    public boolean p;
    public boolean q;
    public boolean r;
    public View u;
    public CheckBox v;
    public TextView w;
    public AtomicBoolean s = new AtomicBoolean(false);
    public boolean t = false;
    public int x = 4;

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_pwd_pay_layout"), null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void dismissLoading(int i2) {
        this.mActionBar.setVisibility(0);
        this.p = false;
        this.f25835f.setVisibility(0);
        this.f25835f.dismissKeyBoard(this.f25836g);
        this.l.stopAnimation();
        this.l.setVisibility(8);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void doLivingPay() {
        PwdPayContract.Presenter presenter = this.mPresenter;
        if (presenter instanceof PwdPayPresenterForCashdesk) {
            ((PwdPayPresenterForCashdesk) presenter).doPay();
        }
    }

    public void doVerifyFingerprint(final IFingerprintPay iFingerprintPay) {
        this.k.resetPwd();
        PwdRequest pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
        this.o = pwdRequest;
        if (pwdRequest != null) {
            pwdRequest.mPayPass = null;
            pwdRequest.mConfirmPayPass = null;
        }
        if (this.s.compareAndSet(false, true)) {
            setPageTransparent(true);
        }
        if (iFingerprintPay == null) {
            GlobalUtils.toast(this.mAct, "手机不支持指纹支付", 1);
        } else {
            iFingerprintPay.verify(getActivity(), new FingerprintCallback() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.4
                @Override // com.baidu.wallet.paysdk.fingerprint.FingerprintCallback
                public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                    PwdPayActivity.this.s.set(false);
                    if (action == IFingerprintPay.Action.VERIFY) {
                        if (i2 == 0) {
                            PwdPayActivity.this.mPresenter.onFPCheckOK(str);
                        } else if (i2 == 1) {
                            PwdPayActivity.this.mPresenter.onFPCheckCancel();
                        } else if (i2 == 3) {
                            PwdPayActivity.this.turntoPwdPay(false, null);
                        } else {
                            PwdPayActivity.this.turntoPwdPay(true, str);
                        }
                    }
                    iFingerprintPay.destory();
                }
            });
        }
    }

    public void forgetPassword() {
        this.k.resetPwd();
        BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
        Activity activity = getActivity();
        baiduWalletDelegate.openH5Module(activity, DomainConfig.getInstance().getMHost() + BeanConstants.API_FIND_PASS, false);
        this.t = true;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void handleErrorContent() {
        this.mPresenter.handleActivityError();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 != 12) {
            dismissLoading(-1);
        }
        super.handleFailure(i2, i3, str);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        PwdPayContract.Presenter presenter = this.mPresenter;
        if ((presenter instanceof PwdPayPresenterForScancode) && i2 == 12) {
            presenter.handleResponse(i2, obj, str);
        }
        super.handleResponse(i2, obj, str);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void hideFullScreenLoading() {
        PwdPayContract.Presenter presenter = this.mPresenter;
        if ((presenter instanceof PwdPayPresenterForCashdesk) && ((PwdPayPresenterForCashdesk) presenter).shouldFullScreenLoading()) {
            showLikeDismissLadingPage();
        }
    }

    public boolean isGatewaySignPay() {
        return this.r;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.p && this.mPresenter.directQuit()) {
            if (this.q) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BIND_CARD_FAILED, StatHelper.collectData(StatHelper.getOrderNo(), "-2", "payBindCardCancel"));
            } else if (com.baidu.wallet.paysdk.a.b.a()) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BIND_CARD_FAILED, StatHelper.collectData(StatHelper.getOrderNo(), "-2", "authorizeBindCardCancel"));
            }
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        dismissLoading(-1);
        this.k.resetPwd();
        if (this.mPresenter.onBeanExecFailureWithErrContent(i2, i3, str, obj)) {
            return;
        }
        super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f25834e) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_FORGET_PWD_IN_CASHDESK);
            forgetPassword();
        } else if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.mRightTxt) {
            this.mPresenter.pwdAndFpTypeChange();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        getActivity().getWindow().setSoftInputMode(2);
        if (bundle == null) {
            Intent intent = this.mAct.getIntent();
            if (intent != null) {
                this.x = intent.getIntExtra(PwdPayPresenterFactory.PWDPAYACTIVITY_FROM_KEY, -1);
                this.r = intent.getBooleanExtra("gatewaySign", false);
                this.q = intent.getBooleanExtra("IS_FOR_BIND_CARD_PAY", false);
            }
        } else {
            this.x = bundle.getInt("forwhat");
            this.r = bundle.getBoolean("gatewaySign", false);
            this.q = bundle.getBoolean("isforBindCardPay", false);
        }
        b();
        PwdPayContract.Presenter a2 = PwdPayPresenterFactory.a(this.x, this);
        this.mPresenter = a2;
        if (a2 == null) {
            PayCallBackManager.callBackClientCancel(this, "PwdPayActivityonCreate().1");
            return;
        }
        a2.onCreate(bundle);
        if (bundle != null) {
            this.p = bundle.getBoolean("isloading");
            this.q = bundle.getBoolean("isforBindCardPay");
        }
        EventBus.getInstance().register(this, BankCardListActivity.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
        a();
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(TAG);
        if (this.t) {
            PasswordController.getPassWordInstance().clearForgetPasswdCallback();
        }
        PwdPayContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onDestroy();
        }
        this.mPresenter = null;
        EventBus.getInstance().unregister(this);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        if (event != null && BankCardListActivity.EVT_PAY_PWD_CHANGE.equals(event.mEventKey)) {
            if (event.mEventObj != null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                    if (jSONObject.has("is_succeed") && 1 == jSONObject.getInt("is_succeed")) {
                        if (this.o != null) {
                            PayRequestCache.getInstance().addBeanRequestToCache(this.o.getRequestId(), this.o);
                        }
                        if (this.f25833c != null) {
                            this.f25833c.setVisibility(8);
                        }
                        int i2 = 0;
                        try {
                            i2 = jSONObject.getInt("is_bind_card");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (1 == i2 && PayRequestCache.getInstance().isPaying() && this.f25833c != null) {
                            this.f25833c.postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    BaseActivity.clearTasksTopOf(PwdPayActivity.this);
                                    BaiduPayDelegate.getInstance().reOrderPay(PwdPayActivity.this.getActivity());
                                }
                            }, 1000L);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            return;
        }
        super.onModuleEvent(event);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onNegativeBtnClick() {
        if (this.mPresenter.dialogNevigateOper_QuitCashDesk()) {
            PayCallBackManager.callBackClientCancel(this, "PwdPayActivityonNegativeBtnClick().1");
        } else if (this.mPresenter.dialogNevigateOper_QuitCurrentPage()) {
            finishWithoutAnim();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 12) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage(this.mDialogMsg);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 12);
                    PwdPayActivity.this.onNegativeBtnClick();
                }
            });
            promptDialog.hideNegativeButton();
        } else if (i2 == 17) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage(this.mDialogMsg);
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_find_password"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PwdPayActivity pwdPayActivity = PwdPayActivity.this;
                    pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_find_password"));
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FIND_PWD_FROM_PWD_OVER_LIMIT);
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 17);
                    PwdPayActivity.this.d();
                    PwdPayActivity.this.forgetPassword();
                }
            });
            promptDialog2.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PwdPayActivity pwdPayActivity = PwdPayActivity.this;
                    pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_know"));
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_IGNOREPWD_OVER_LIMIT);
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 17);
                    PwdPayActivity.this.d();
                }
            });
        } else if (i2 == 36) {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage(this.mDialogMsg);
            promptDialog3.setNegativeBtn(ResUtils.getString(this, "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 36);
                    PwdPayActivity.this.onNegativeBtnClick();
                }
            });
            promptDialog3.setPositiveBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 36);
                    PayController.getInstance().gotoPayTypePage(PwdPayActivity.this, false);
                    PwdPayActivity.this.finishWithoutAnim();
                }
            });
        } else if (i2 != 37) {
            super.onPrepareDialog(i2, dialog);
        } else {
            PromptDialog promptDialog4 = (PromptDialog) dialog;
            promptDialog4.setMessage(this.mDialogMsg);
            promptDialog4.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PwdPayActivity pwdPayActivity = PwdPayActivity.this;
                    pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_know"));
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 37);
                    PwdPayActivity.this.onNegativeBtnClick();
                }
            });
            promptDialog4.setPositiveBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PwdPayActivity pwdPayActivity = PwdPayActivity.this;
                    pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_use_other_paytype"));
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 37);
                    PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                    if (payRequest != null) {
                        payRequest.clearMktSolution();
                    }
                    PayController.getInstance().gotoPayTypePage(PwdPayActivity.this, false);
                    PwdPayActivity.this.finishWithoutAnim();
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.widget.SixNumberPwdView.OnPwdChangedListener
    public void onPwdChanged(int i2) {
        if (i2 == 6) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FINISH_INPUTPWD_IN_CASHDESK);
            this.mPresenter.onPwdChanged(this.k.getPwd());
            return;
        }
        this.f25833c.setVisibility(8);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("isloading", Boolean.valueOf(this.p));
        bundle.putSerializable("pwdrequest", this.o);
        bundle.putSerializable("isforBindCardPay", Boolean.valueOf(this.q));
        bundle.putSerializable("gatewaySign", Boolean.valueOf(this.r));
        bundle.putSerializable("forwhat", Integer.valueOf(this.x));
        this.mPresenter.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        PayRequest payRequest;
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.onWindowFocusChanged(z);
        if (!z || (payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)) == null || payRequest.getPayWay() != 3 || (safeKeyBoardEditText = this.f25836g) == null) {
            return;
        }
        safeKeyBoardEditText.requestFocus();
    }

    public void reFreshUI(Object obj) {
    }

    public void rightTextShow(boolean z, String str) {
        if (z) {
            this.mRightTxt.setVisibility(0);
            this.mRightTxt.setOnClickListener(this);
            if (str != null) {
                this.mRightTxt.setText(str);
            }
            this.mRightTxt.setTextColor(ResUtils.getColor(this, "wallet_base_primary_color"));
            return;
        }
        this.mRightTxt.setVisibility(8);
    }

    public void setErrorArea(boolean z) {
        this.f25832b.setVisibility(z ? 0 : 8);
    }

    public void setErrorTips(boolean z, String str) {
        this.f25833c.setVisibility(z ? 0 : 8);
        if (str != null) {
            this.f25833c.setText(str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void setPresenter(PwdPayContract.Presenter presenter) {
    }

    public void setTitleText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f25837h.setText(str);
    }

    public void showLoading(int i2) {
        this.mActionBar.setVisibility(4);
        this.p = true;
        this.f25835f.setVisibility(8);
        this.f25835f.dismissKeyBoard(this.f25836g);
        this.l.setVisibility(0);
        this.l.startAnimation();
    }

    public void showPWdInputView(boolean z) {
        if (z) {
            this.f25835f.setVisibility(0);
            this.k.resetPwd();
            return;
        }
        this.f25835f.setVisibility(8);
        this.f25835f.dismissKeyBoard(this.f25836g);
    }

    public void showPassError(String str) {
        this.f25832b.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.f25833c.setText(str);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f25833c.setVisibility(0);
        } else {
            this.f25833c.setVisibility(8);
        }
        this.f25834e.setVisibility(0);
        this.f25836g.initSafeKeyBoardParams(this.f25831a, this.f25835f, this.k, true);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(final boolean z, final PayResultContent payResultContent, final int i2) {
        PwdPayContract.Presenter presenter = this.mPresenter;
        if (presenter != null && !presenter.showSucAnim()) {
            if (z) {
                PayController.getInstance().paySucess(this, payResultContent, 1);
                return;
            } else {
                PayController.getInstance().payPaying(this, payResultContent, 1);
                return;
            }
        }
        dismissLoading(-1);
        this.p = true;
        this.mActionBar.setVisibility(4);
        this.f25835f.setVisibility(8);
        this.m.setVisibility(0);
        this.n.startAnimation(new SuccessImageViewNew.a() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.5
            @Override // com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.a
            public void a() {
                if (z) {
                    PayController.getInstance().paySucess(PwdPayActivity.this, payResultContent, i2);
                } else {
                    PayController.getInstance().payPaying(PwdPayActivity.this, payResultContent, i2);
                }
            }
        });
    }

    public void showWarningTips(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f25838i.setText(str);
        this.f25838i.setVisibility(0);
    }

    public void turntoPwdPay(boolean z, String str) {
        this.mPresenter.onTurntoPwdPay(z);
        showLikeLoadingPage(false);
        showWarningTips(str);
        a();
    }

    private void b() {
        this.mActionBar.setVisibility(0);
        this.f25831a = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "ebpay_pwdpay_layout"));
        SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        this.f25835f = safeScrollView;
        safeScrollView.setVisibility(0);
        setSafeScrollView(this.f25835f);
        this.f25837h = (TextView) findViewById(ResUtils.id(this, "ebpay_pwd_title"));
        TextView textView = (TextView) findViewById(ResUtils.id(this, "warning_tips"));
        this.f25838i = textView;
        textView.setVisibility(4);
        SixNumberPwdView sixNumberPwdView = (SixNumberPwdView) findViewById(ResUtils.id(this, "pwd_input_box"));
        this.k = sixNumberPwdView;
        sixNumberPwdView.setShowInputMethod(true);
        this.k.addSixNumberPwdChangedListenter(this);
        SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.k.findViewById(ResUtils.id(getActivity(), "pwd_input"));
        this.f25836g = safeKeyBoardEditText;
        safeKeyBoardEditText.initSafeKeyBoardParams(this.f25831a, this.f25835f, this.k, false);
        this.f25836g.setDisablePast(true);
        this.f25836g.setGap(20);
        View findViewById = findViewById(ResUtils.id(this, "bd_wallet_pwd_error_layout"));
        this.f25832b = findViewById;
        findViewById.setVisibility(0);
        TextView textView2 = (TextView) findViewById(ResUtils.id(this, "error_tip"));
        this.f25833c = textView2;
        textView2.setVisibility(8);
        View findViewById2 = findViewById(ResUtils.id(this, "forget_pwd"));
        this.f25834e = findViewById2;
        findViewById2.setVisibility(0);
        this.f25834e.setOnClickListener(this);
        PayLoadingImageViewNew payLoadingImageViewNew = (PayLoadingImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_cashier_loading_view"));
        this.l = payLoadingImageViewNew;
        payLoadingImageViewNew.setVisibility(8);
        View findViewById3 = findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
        this.m = findViewById3;
        findViewById3.setVisibility(8);
        this.n = (SuccessImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
        this.mLeftImg.setOnClickListener(this);
        this.u = findViewById(ResUtils.id(this, "protocol_display_area"));
        this.v = (CheckBox) findViewById(ResUtils.id(this, "ebpay_protocol"));
        this.w = (TextView) findViewById(ResUtils.id(this, "ebpay_protocol_text"));
        this.j = (TextView) findViewById(ResUtils.id(this, "ebpay_protocol_msg"));
    }

    private void c() {
        final PwdPayContract.protocolModel needshowProtocolContainer = this.mPresenter.needshowProtocolContainer();
        if (needshowProtocolContainer != null && !TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_msg) && !TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_prefix) && !TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_url)) {
            this.w.setText(needshowProtocolContainer.passfree_protocol_prefix);
            this.j.setText(needshowProtocolContainer.passfree_protocol_msg);
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaiduWalletDelegate.getInstance().openH5Module(PwdPayActivity.this, needshowProtocolContainer.passfree_protocol_url, false);
                }
            });
            this.v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.7
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    needshowProtocolContainer.iClickCallback.onProtocolClicked(z);
                }
            });
            this.v.setChecked(needshowProtocolContainer.checked);
            this.f25833c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.8
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (PwdPayActivity.this.f25833c.getVisibility() == 0) {
                        PwdPayActivity.this.u.setVisibility(8);
                    } else {
                        PwdPayActivity.this.u.setVisibility(0);
                    }
                }
            });
            this.u.setVisibility(0);
            return;
        }
        this.u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f25832b.setVisibility(0);
        this.f25833c.setVisibility(8);
        this.f25834e.setVisibility(0);
    }

    private void a() {
        c();
    }
}
