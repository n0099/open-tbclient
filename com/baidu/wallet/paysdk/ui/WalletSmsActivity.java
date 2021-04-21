package com.baidu.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.LoadingDialog;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.base.widget.dialog.listener.DelegateOnDismissListener;
import com.baidu.wallet.base.widget.textfilter.BlankCharEditTextPasteFilter;
import com.baidu.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.baidu.wallet.base.widget.textfilter.NumberEditTextPasteFilter;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.sms.controller.ISmsController;
import com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler;
import com.baidu.wallet.paysdk.sms.controller.d;
import com.baidu.wallet.paysdk.sms.controller.h;
import com.baidu.wallet.paysdk.sms.controller.i;
import com.baidu.wallet.paysdk.sms.controller.j;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.util.List;
/* loaded from: classes5.dex */
public class WalletSmsActivity extends PayBaseActivity implements View.OnClickListener, SmsVerifyHandler {

    /* renamed from: a  reason: collision with root package name */
    public Context f25973a;

    /* renamed from: c  reason: collision with root package name */
    public ISmsController f25975c;

    /* renamed from: e  reason: collision with root package name */
    public SafeKeyBoardEditText f25976e;

    /* renamed from: f  reason: collision with root package name */
    public SafeScrollView f25977f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f25978g;

    /* renamed from: h  reason: collision with root package name */
    public Button f25979h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public View l;
    public TextView m;
    public TextView mHelp;
    public Button mSendSms;
    public CountDownTimer mTimer;
    public TextView mTopPhoneTip;
    public Animation n;
    public Animation o;
    public int p;
    public int q;
    public TextView r;
    public String t;
    public Bundle u;
    public TextView v;
    public View w;
    public LinearLayout x;

    /* renamed from: b  reason: collision with root package name */
    public int f25974b = -1;
    public boolean s = false;
    public boolean mHasVerifyCodeSend = false;
    public int y = 4;
    public boolean z = true;

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void clearSmsEditText() {
        this.f25976e.setText("");
        this.f25976e.requestFocus();
        this.k.setVisibility(8);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void doStartCountDown() {
        startCountDown();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void doStopCountDown() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        this.mSendSms.setText(ResUtils.getString(getActivity(), "ebpay_get_sms_code"));
        this.mSendSms.setTextSize(1, 11.0f);
        this.mSendSms.setEnabled(true);
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void finish() {
        d();
        super.finish();
        BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void finishWithoutAnim() {
        LinearLayout linearLayout = this.x;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        d();
        super.finishWithoutAnim();
        BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public ISmsController getController(int i) {
        return j.a(i);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        ISmsController iSmsController = this.f25975c;
        if (iSmsController == null || !iSmsController.handleFailure(i, i2, str)) {
            super.handleFailure(i, i2, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        ISmsController iSmsController = this.f25975c;
        if (iSmsController == null || !iSmsController.handleResponse(i, obj, str)) {
            super.handleResponse(i, obj, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void initSMSActivityView(String str, String str2, String str3, String str4, boolean z) {
        this.x.setVisibility(0);
        this.m.setText(ResUtils.string(this.f25973a, str));
        setPhoneNum(str4);
        if (TextUtils.isEmpty(str2)) {
            this.j.setVisibility(8);
        } else {
            this.j.setText(str2);
            this.j.setVisibility(0);
        }
        this.f25979h.setText(str3);
        if (this.z) {
            return;
        }
        this.x.setVisibility(8);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public boolean isBindPay() {
        ISmsController iSmsController = this.f25975c;
        if (iSmsController != null && (iSmsController instanceof d)) {
            return ((d) iSmsController).b();
        }
        return super.isBindPay();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f25974b == 8) {
            WalletGlobalUtils.safeShowDialog(this, 18, "");
            return;
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (payRequest != null) {
            payRequest.clearMktSolution();
        }
        finishWithoutAnim();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i, int i2, String str, Object obj) {
        ErrorContentResponse.Guidance guidance;
        WalletGlobalUtils.safeDismissDialog(this, 0);
        ErrorContentResponse errorContentResponse = (obj == null || !(obj instanceof ErrorContentResponse)) ? null : (ErrorContentResponse) obj;
        ISmsController iSmsController = this.f25975c;
        if (iSmsController == null || !iSmsController.doOnBeanExecFailureWithErrContent(i, i2, str, obj)) {
            if (i2 == 51000 && errorContentResponse != null && (guidance = errorContentResponse.guidance) != null) {
                this.mGuidance = guidance;
                this.mPayErrorCode = i2;
                this.mBeanId = i;
                if (guidance != null) {
                    WalletGlobalUtils.safeShowDialog(this, 53, "");
                    return;
                } else {
                    super.onBeanExecFailureWithErrContent(i, i2, str, obj);
                    return;
                }
            }
            super.onBeanExecFailureWithErrContent(i, i2, str, obj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            clearSmsEditText();
        } else if (view == this.mSendSms) {
            StatisticManager.onEvent(StatServiceEvent.SMS_SEND_SMS_CLICK);
            clearSmsEditText();
            startCountDown();
            c();
            b();
        } else if (view == this.f25979h) {
            if (CheckUtils.isFastDoubleClick()) {
                return;
            }
            if (!this.mHasVerifyCodeSend) {
                a((CharSequence) ResUtils.getString(getActivity(), "ebpay_sms_tips_get_code_first"));
            } else if (!a(this.f25976e.getText().toString())) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_error_cer"));
                this.f25976e.requestFocus();
            } else {
                ISmsController iSmsController = this.f25975c;
                if (iSmsController != null) {
                    iSmsController.onNextBtnClick(this.f25976e.getText().toString());
                }
            }
        } else if (view == this.mHelp) {
            StatisticManager.onEvent(StatServiceEvent.CLICK_VCODE_TIP);
            WalletGlobalUtils.safeShowDialog(this, 23, "");
        } else if (view == this.l) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_CLOSE_FROM_SMS_VERIFY);
            finishWithoutAnim();
        } else if (view.getId() == ResUtils.id(this, "ebpay_btn_modify_phone")) {
            ISmsController iSmsController2 = this.f25975c;
            if (iSmsController2 instanceof com.baidu.wallet.paysdk.sms.controller.a) {
                ((com.baidu.wallet.paysdk.sms.controller.a) iSmsController2).a();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"UseCheckPermission"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        this.f25973a = getActivity();
        this.u = bundle;
        if (bundle == null) {
            this.f25974b = getIntent().getIntExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, -1);
        } else {
            this.f25974b = bundle.getInt("SMS_FROM");
        }
        setContentView(ResUtils.layout(this.f25973a, "wallet_base_sms"));
        a();
        a(this.f25974b, getIntent().getBooleanExtra(BeanConstants.KEY_SEND_SMS_AUTO, false));
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i) {
        ISmsController iSmsController = this.f25975c;
        if (iSmsController != null) {
            Dialog doOnCreateDialog = iSmsController.doOnCreateDialog(i);
            return doOnCreateDialog != null ? doOnCreateDialog : super.onCreateDialog(i);
        }
        return super.onCreateDialog(i);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ISmsController iSmsController = this.f25975c;
        if (iSmsController != null) {
            iSmsController.doOnDestroy();
        }
        d();
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(ISmsController.BEAN_TAG);
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        this.f25975c = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        a(intent);
        a(this.f25974b, intent.getBooleanExtra(BeanConstants.KEY_SEND_SMS_AUTO, false));
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        if (this.f25975c != null) {
            if (!(dialog instanceof LoadingDialog)) {
                try {
                    if (this.n == null) {
                        this.n = AnimationUtils.loadAnimation(this, this.p);
                    }
                    this.f25977f.setAlwaysShowSoftKeyBoard(false);
                    this.f25977f.startAnimation(this.n);
                } catch (Resources.NotFoundException unused) {
                }
                dialog.setOnDismissListener(new DelegateOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.wallet.paysdk.ui.WalletSmsActivity.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        try {
                            if (WalletSmsActivity.this.o == null) {
                                WalletSmsActivity.this.o = AnimationUtils.loadAnimation(WalletSmsActivity.this.getActivity(), WalletSmsActivity.this.q);
                            }
                            WalletSmsActivity.this.f25977f.setAlwaysShowSoftKeyBoard(true);
                            WalletSmsActivity.this.f25977f.startAnimation(WalletSmsActivity.this.o);
                        } catch (Resources.NotFoundException unused2) {
                        }
                    }
                }));
            }
            if (this.f25975c.doOnPrepareDialog(i, dialog)) {
                return;
            }
            super.onPrepareDialog(i, dialog);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        ISmsController iSmsController = this.f25975c;
        if (iSmsController != null) {
            iSmsController.doOnSaveInstanceState(bundle);
        }
        bundle.putInt("SMS_FROM", this.f25974b);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsSendFailure(int i, CharSequence charSequence) {
        GlobalUtils.toast(this, charSequence);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsSendSuccess() {
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsVerifyFailure(int i, CharSequence charSequence) {
        if (TextUtils.isEmpty(this.t)) {
            this.t = ResUtils.getString(this, "ebpay_verify_fail");
        }
        a(charSequence);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsVerifySuccess() {
    }

    public void setPhoneNum(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i.setText(StringUtils.maskingPhoneNumber(str));
        } else {
            this.i.setText("");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i) {
        if (z) {
            PayController.getInstance().paySucess(this, payResultContent, i);
        } else {
            PayController.getInstance().payPaying(this, payResultContent, i);
        }
    }

    public void startCountDown() {
        this.mHasVerifyCodeSend = true;
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(60000L, 1000L) { // from class: com.baidu.wallet.paysdk.ui.WalletSmsActivity.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                WalletSmsActivity walletSmsActivity = WalletSmsActivity.this;
                walletSmsActivity.mSendSms.setText(ResUtils.getString(walletSmsActivity.getActivity(), "ebpay_get_sms_code"));
                WalletSmsActivity.this.mSendSms.setTextSize(1, 11.0f);
                WalletSmsActivity.this.mSendSms.setEnabled(true);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                WalletSmsActivity.this.mSendSms.setEnabled(false);
                WalletSmsActivity.this.mSendSms.setTextSize(1, 11.0f);
                WalletSmsActivity walletSmsActivity = WalletSmsActivity.this;
                walletSmsActivity.mSendSms.setText(String.format(ResUtils.getString(walletSmsActivity.getActivity(), "ebpay_resend"), Integer.valueOf((int) (j / 1000))));
            }
        };
        this.mTimer = countDownTimer2;
        countDownTimer2.start();
        this.mSendSms.setEnabled(false);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void upDateSafeKeyBoradView(String str, String str2) {
        int i;
        if (this.f25976e != null) {
            if (TextUtils.isEmpty(str2)) {
                i = 0;
            } else {
                try {
                    i = Integer.parseInt(str2);
                } catch (Exception unused) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.NULL_SMS_STYLE);
                    i = 0;
                }
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.SMS_STYLE, str2);
            }
            int i2 = 10;
            if (!TextUtils.isEmpty(str)) {
                try {
                    i2 = Integer.parseInt(str);
                    this.y = i2;
                } catch (Exception unused2) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.NULL_SMS_LENTH);
                }
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.SMS_LENTH, str);
            }
            if (i == 0) {
                this.f25976e.setInputType(2);
                getWindow().setSoftInputMode(2);
                this.f25976e.setUseSafeKeyBoard(true);
                this.f25976e.initSafeKeyBoardParams(this.f25978g, this.f25977f, this.mHelp, true);
                this.f25977f.setAlwaysShowSoftKeyBoard(true);
                List<IEditTextPasteFilter> editTextPasteFilters = this.f25976e.getEditTextPasteFilters();
                if (editTextPasteFilters != null) {
                    editTextPasteFilters.clear();
                    editTextPasteFilters.add(new NumberEditTextPasteFilter());
                }
            } else {
                this.f25976e.setInputType(1);
                List<IEditTextPasteFilter> editTextPasteFilters2 = this.f25976e.getEditTextPasteFilters();
                if (editTextPasteFilters2 != null) {
                    editTextPasteFilters2.clear();
                    editTextPasteFilters2.add(new BlankCharEditTextPasteFilter());
                }
                getWindow().setSoftInputMode(4);
                this.f25976e.initSafeKeyBoardParams(this.f25978g, this.f25977f, this.mHelp, true);
            }
            this.f25976e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void updateButtonTip(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f25979h.setText(str);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void updateModifyPhoneUI(boolean z, CharSequence charSequence) {
        this.v.setText(charSequence);
        this.v.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.s) {
            this.w.setBackgroundColor(Color.parseColor("#54576A"));
            this.r.setVisibility(4);
            this.s = false;
        }
    }

    private void c() {
        ISmsController iSmsController = this.f25975c;
        if (iSmsController != null) {
            iSmsController.sendSms();
        }
    }

    private void d() {
        SafeScrollView safeScrollView = this.f25977f;
        if (safeScrollView == null || !safeScrollView.isPopupWindowShowing()) {
            return;
        }
        this.f25977f.dismissKeyBoard(this.f25976e);
    }

    private void a(int i, boolean z) {
        this.z = getIntent().getBooleanExtra("showSMSDialog", true);
        this.f25975c = getController(i);
        PayRequestCache.BindCategory bindCategoryByIntent = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
        getBindCardFlagDelegate().a((BindFastRequest) PayRequestCache.getInstance().getRequest(bindCategoryByIntent));
        ISmsController iSmsController = this.f25975c;
        if (iSmsController == null) {
            finish();
            return;
        }
        if (iSmsController instanceof d) {
            d dVar = (d) iSmsController;
            PayRequestCache.BindCategory bindCategoryByIntent2 = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
            dVar.a(bindCategoryByIntent2);
            dVar.a((BindFastRequest) PayRequestCache.getInstance().getRequest(bindCategoryByIntent2));
        }
        this.f25975c.setSmsUpdateUIInterface(this);
        this.f25975c.setSmsVerifyHandler(this);
        this.f25975c.setActivity(this);
        if (this.f25975c.onCreateCheckInvalide(this.u)) {
            if (this.f25975c.isBelongPaySDK()) {
                setFlagPaySdk();
            }
            this.f25975c.initSmsActivityView();
            ISmsController iSmsController2 = this.f25975c;
            if (!(iSmsController2 instanceof i) && !(iSmsController2 instanceof h)) {
                clearSmsEditText();
                startCountDown();
            }
            if (this.f25975c.isSendSmsOnCreate() || z) {
                stopCountDown();
                c();
            }
            if (i == 7) {
                setFlagActiveBindCard();
            }
        }
    }

    private void a() {
        this.f25978g = (ViewGroup) findViewById(ResUtils.id(this.f25973a, "root_view"));
        this.f25977f = (SafeScrollView) findViewById(ResUtils.id(this.f25973a, "scrollview"));
        this.i = (TextView) findViewById(ResUtils.id(this.f25973a, "ebpay_sms_moblie"));
        this.mTopPhoneTip = (TextView) findViewById(ResUtils.id(this.f25973a, "ebpay_tip_top"));
        this.f25976e = (SafeKeyBoardEditText) findViewById(ResUtils.id(this.f25973a, "ebpay_message_vcode_id"));
        this.k = (ImageView) findViewById(ResUtils.id(this.f25973a, "wallet_sms_clear"));
        this.mSendSms = (Button) findViewById(ResUtils.id(this.f25973a, "ebpay_sms_sendsms"));
        this.mHelp = (TextView) findViewById(ResUtils.id(this.f25973a, "ebpay_tip_bottom_right"));
        this.j = (TextView) findViewById(ResUtils.id(this.f25973a, "ebpay_top_tip"));
        this.f25979h = (Button) findViewById(ResUtils.id(this.f25973a, "ebpay_next_btn"));
        this.x = (LinearLayout) findViewById(ResUtils.id(getActivity(), "lin_sms_dialog"));
        SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        this.f25977f = safeScrollView;
        this.f25976e.initSafeKeyBoardParams(this.f25978g, safeScrollView, this.mHelp, false);
        this.f25976e.setUseSafeKeyBoard(true);
        this.k.setOnClickListener(this);
        this.mSendSms.setOnClickListener(this);
        this.f25979h.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
        this.f25976e.addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.WalletSmsActivity.1

            /* renamed from: b  reason: collision with root package name */
            public boolean f25981b = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(editable.toString())) {
                    WalletSmsActivity.this.k.setVisibility(0);
                } else {
                    WalletSmsActivity.this.k.setVisibility(8);
                }
                WalletSmsActivity.this.f25979h.setEnabled(WalletSmsActivity.this.a(editable.toString()));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!this.f25981b) {
                    if (WalletSmsActivity.this.f25975c != null) {
                        WalletSmsActivity.this.f25975c.doOnEvent();
                    }
                    this.f25981b = true;
                }
                WalletSmsActivity.this.b();
            }
        });
        View findViewById = findViewById(ResUtils.id(this.f25973a, "dialog_close"));
        this.l = findViewById;
        findViewById.setOnClickListener(this);
        this.m = (TextView) findViewById(ResUtils.id(this.f25973a, "dialog_title"));
        this.p = ResUtils.anim(this, "wallet_dialog_slide_to_left");
        this.q = ResUtils.anim(this, "wallet_dialog_slide_to_right");
        this.r = (TextView) findViewById(ResUtils.id(this, "ebpay_error_tip"));
        View findViewById2 = findViewById(ResUtils.id(this, "ebpay_sms_line_info"));
        this.w = findViewById2;
        findViewById2.setBackgroundColor(Color.parseColor("#54576A"));
        TextView textView = (TextView) findViewById(ResUtils.id(this, "ebpay_btn_modify_phone"));
        this.v = textView;
        textView.setOnClickListener(this);
        setSafeScrollView(this.f25977f);
        a(getIntent());
        this.f25976e.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.length() >= this.y;
    }

    private void a(Intent intent) {
        int intExtra = intent.getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
        String stringExtra = intent.getStringExtra(BeanConstants.KEY_SMS_HINT);
        if (intExtra != 5320 || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.mTopPhoneTip.setText(stringExtra);
    }

    private void a(CharSequence charSequence) {
        this.w.setBackgroundColor(Color.parseColor("#FA5050"));
        this.r.setText(charSequence);
        this.r.setVisibility(0);
        this.s = true;
    }
}
