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
    public Context f26123a;

    /* renamed from: c  reason: collision with root package name */
    public ISmsController f26125c;

    /* renamed from: e  reason: collision with root package name */
    public SafeKeyBoardEditText f26126e;

    /* renamed from: f  reason: collision with root package name */
    public SafeScrollView f26127f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f26128g;

    /* renamed from: h  reason: collision with root package name */
    public Button f26129h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26130i;
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
    public int f26124b = -1;
    public boolean s = false;
    public boolean mHasVerifyCodeSend = false;
    public int y = 4;
    public boolean z = true;

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void clearSmsEditText() {
        this.f26126e.setText("");
        this.f26126e.requestFocus();
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

    public ISmsController getController(int i2) {
        return j.a(i2);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        ISmsController iSmsController = this.f26125c;
        if (iSmsController == null || !iSmsController.handleFailure(i2, i3, str)) {
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        ISmsController iSmsController = this.f26125c;
        if (iSmsController == null || !iSmsController.handleResponse(i2, obj, str)) {
            super.handleResponse(i2, obj, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void initSMSActivityView(String str, String str2, String str3, String str4, boolean z) {
        this.x.setVisibility(0);
        this.m.setText(ResUtils.string(this.f26123a, str));
        setPhoneNum(str4);
        if (TextUtils.isEmpty(str2)) {
            this.j.setVisibility(8);
        } else {
            this.j.setText(str2);
            this.j.setVisibility(0);
        }
        this.f26129h.setText(str3);
        if (this.z) {
            return;
        }
        this.x.setVisibility(8);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public boolean isBindPay() {
        ISmsController iSmsController = this.f26125c;
        if (iSmsController != null && (iSmsController instanceof d)) {
            return ((d) iSmsController).b();
        }
        return super.isBindPay();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f26124b == 8) {
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
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        ErrorContentResponse.Guidance guidance;
        WalletGlobalUtils.safeDismissDialog(this, 0);
        ErrorContentResponse errorContentResponse = (obj == null || !(obj instanceof ErrorContentResponse)) ? null : (ErrorContentResponse) obj;
        ISmsController iSmsController = this.f26125c;
        if (iSmsController == null || !iSmsController.doOnBeanExecFailureWithErrContent(i2, i3, str, obj)) {
            if (i3 == 51000 && errorContentResponse != null && (guidance = errorContentResponse.guidance) != null) {
                this.mGuidance = guidance;
                this.mPayErrorCode = i3;
                this.mBeanId = i2;
                if (guidance != null) {
                    WalletGlobalUtils.safeShowDialog(this, 53, "");
                    return;
                } else {
                    super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
                    return;
                }
            }
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
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
        } else if (view == this.f26129h) {
            if (CheckUtils.isFastDoubleClick()) {
                return;
            }
            if (!this.mHasVerifyCodeSend) {
                a((CharSequence) ResUtils.getString(getActivity(), "ebpay_sms_tips_get_code_first"));
            } else if (!a(this.f26126e.getText().toString())) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_error_cer"));
                this.f26126e.requestFocus();
            } else {
                ISmsController iSmsController = this.f26125c;
                if (iSmsController != null) {
                    iSmsController.onNextBtnClick(this.f26126e.getText().toString());
                }
            }
        } else if (view == this.mHelp) {
            StatisticManager.onEvent(StatServiceEvent.CLICK_VCODE_TIP);
            WalletGlobalUtils.safeShowDialog(this, 23, "");
        } else if (view == this.l) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_CLOSE_FROM_SMS_VERIFY);
            finishWithoutAnim();
        } else if (view.getId() == ResUtils.id(this, "ebpay_btn_modify_phone")) {
            ISmsController iSmsController2 = this.f26125c;
            if (iSmsController2 instanceof com.baidu.wallet.paysdk.sms.controller.a) {
                ((com.baidu.wallet.paysdk.sms.controller.a) iSmsController2).a();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"UseCheckPermission"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        this.f26123a = getActivity();
        this.u = bundle;
        if (bundle == null) {
            this.f26124b = getIntent().getIntExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, -1);
        } else {
            this.f26124b = bundle.getInt("SMS_FROM");
        }
        setContentView(ResUtils.layout(this.f26123a, "wallet_base_sms"));
        a();
        a(this.f26124b, getIntent().getBooleanExtra(BeanConstants.KEY_SEND_SMS_AUTO, false));
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        ISmsController iSmsController = this.f26125c;
        if (iSmsController != null) {
            Dialog doOnCreateDialog = iSmsController.doOnCreateDialog(i2);
            return doOnCreateDialog != null ? doOnCreateDialog : super.onCreateDialog(i2);
        }
        return super.onCreateDialog(i2);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ISmsController iSmsController = this.f26125c;
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
        this.f26125c = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        a(intent);
        a(this.f26124b, intent.getBooleanExtra(BeanConstants.KEY_SEND_SMS_AUTO, false));
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        if (this.f26125c != null) {
            if (!(dialog instanceof LoadingDialog)) {
                try {
                    if (this.n == null) {
                        this.n = AnimationUtils.loadAnimation(this, this.p);
                    }
                    this.f26127f.setAlwaysShowSoftKeyBoard(false);
                    this.f26127f.startAnimation(this.n);
                } catch (Resources.NotFoundException unused) {
                }
                dialog.setOnDismissListener(new DelegateOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.wallet.paysdk.ui.WalletSmsActivity.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        try {
                            if (WalletSmsActivity.this.o == null) {
                                WalletSmsActivity.this.o = AnimationUtils.loadAnimation(WalletSmsActivity.this.getActivity(), WalletSmsActivity.this.q);
                            }
                            WalletSmsActivity.this.f26127f.setAlwaysShowSoftKeyBoard(true);
                            WalletSmsActivity.this.f26127f.startAnimation(WalletSmsActivity.this.o);
                        } catch (Resources.NotFoundException unused2) {
                        }
                    }
                }));
            }
            if (this.f26125c.doOnPrepareDialog(i2, dialog)) {
                return;
            }
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        ISmsController iSmsController = this.f26125c;
        if (iSmsController != null) {
            iSmsController.doOnSaveInstanceState(bundle);
        }
        bundle.putInt("SMS_FROM", this.f26124b);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsSendFailure(int i2, CharSequence charSequence) {
        GlobalUtils.toast(this, charSequence);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsSendSuccess() {
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsVerifyFailure(int i2, CharSequence charSequence) {
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
            this.f26130i.setText(StringUtils.maskingPhoneNumber(str));
        } else {
            this.f26130i.setText("");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        if (z) {
            PayController.getInstance().paySucess(this, payResultContent, i2);
        } else {
            PayController.getInstance().payPaying(this, payResultContent, i2);
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
        int i2;
        if (this.f26126e != null) {
            if (TextUtils.isEmpty(str2)) {
                i2 = 0;
            } else {
                try {
                    i2 = Integer.parseInt(str2);
                } catch (Exception unused) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.NULL_SMS_STYLE);
                    i2 = 0;
                }
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.SMS_STYLE, str2);
            }
            int i3 = 10;
            if (!TextUtils.isEmpty(str)) {
                try {
                    i3 = Integer.parseInt(str);
                    this.y = i3;
                } catch (Exception unused2) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.NULL_SMS_LENTH);
                }
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.SMS_LENTH, str);
            }
            if (i2 == 0) {
                this.f26126e.setInputType(2);
                getWindow().setSoftInputMode(2);
                this.f26126e.setUseSafeKeyBoard(true);
                this.f26126e.initSafeKeyBoardParams(this.f26128g, this.f26127f, this.mHelp, true);
                this.f26127f.setAlwaysShowSoftKeyBoard(true);
                List<IEditTextPasteFilter> editTextPasteFilters = this.f26126e.getEditTextPasteFilters();
                if (editTextPasteFilters != null) {
                    editTextPasteFilters.clear();
                    editTextPasteFilters.add(new NumberEditTextPasteFilter());
                }
            } else {
                this.f26126e.setInputType(1);
                List<IEditTextPasteFilter> editTextPasteFilters2 = this.f26126e.getEditTextPasteFilters();
                if (editTextPasteFilters2 != null) {
                    editTextPasteFilters2.clear();
                    editTextPasteFilters2.add(new BlankCharEditTextPasteFilter());
                }
                getWindow().setSoftInputMode(4);
                this.f26126e.initSafeKeyBoardParams(this.f26128g, this.f26127f, this.mHelp, true);
            }
            this.f26126e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void updateButtonTip(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f26129h.setText(str);
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
        ISmsController iSmsController = this.f26125c;
        if (iSmsController != null) {
            iSmsController.sendSms();
        }
    }

    private void d() {
        SafeScrollView safeScrollView = this.f26127f;
        if (safeScrollView == null || !safeScrollView.isPopupWindowShowing()) {
            return;
        }
        this.f26127f.dismissKeyBoard(this.f26126e);
    }

    private void a(int i2, boolean z) {
        this.z = getIntent().getBooleanExtra("showSMSDialog", true);
        this.f26125c = getController(i2);
        PayRequestCache.BindCategory bindCategoryByIntent = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
        getBindCardFlagDelegate().a((BindFastRequest) PayRequestCache.getInstance().getRequest(bindCategoryByIntent));
        ISmsController iSmsController = this.f26125c;
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
        this.f26125c.setSmsUpdateUIInterface(this);
        this.f26125c.setSmsVerifyHandler(this);
        this.f26125c.setActivity(this);
        if (this.f26125c.onCreateCheckInvalide(this.u)) {
            if (this.f26125c.isBelongPaySDK()) {
                setFlagPaySdk();
            }
            this.f26125c.initSmsActivityView();
            ISmsController iSmsController2 = this.f26125c;
            if (!(iSmsController2 instanceof i) && !(iSmsController2 instanceof h)) {
                clearSmsEditText();
                startCountDown();
            }
            if (this.f26125c.isSendSmsOnCreate() || z) {
                stopCountDown();
                c();
            }
            if (i2 == 7) {
                setFlagActiveBindCard();
            }
        }
    }

    private void a() {
        this.f26128g = (ViewGroup) findViewById(ResUtils.id(this.f26123a, "root_view"));
        this.f26127f = (SafeScrollView) findViewById(ResUtils.id(this.f26123a, "scrollview"));
        this.f26130i = (TextView) findViewById(ResUtils.id(this.f26123a, "ebpay_sms_moblie"));
        this.mTopPhoneTip = (TextView) findViewById(ResUtils.id(this.f26123a, "ebpay_tip_top"));
        this.f26126e = (SafeKeyBoardEditText) findViewById(ResUtils.id(this.f26123a, "ebpay_message_vcode_id"));
        this.k = (ImageView) findViewById(ResUtils.id(this.f26123a, "wallet_sms_clear"));
        this.mSendSms = (Button) findViewById(ResUtils.id(this.f26123a, "ebpay_sms_sendsms"));
        this.mHelp = (TextView) findViewById(ResUtils.id(this.f26123a, "ebpay_tip_bottom_right"));
        this.j = (TextView) findViewById(ResUtils.id(this.f26123a, "ebpay_top_tip"));
        this.f26129h = (Button) findViewById(ResUtils.id(this.f26123a, "ebpay_next_btn"));
        this.x = (LinearLayout) findViewById(ResUtils.id(getActivity(), "lin_sms_dialog"));
        SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        this.f26127f = safeScrollView;
        this.f26126e.initSafeKeyBoardParams(this.f26128g, safeScrollView, this.mHelp, false);
        this.f26126e.setUseSafeKeyBoard(true);
        this.k.setOnClickListener(this);
        this.mSendSms.setOnClickListener(this);
        this.f26129h.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
        this.f26126e.addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.WalletSmsActivity.1

            /* renamed from: b  reason: collision with root package name */
            public boolean f26132b = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(editable.toString())) {
                    WalletSmsActivity.this.k.setVisibility(0);
                } else {
                    WalletSmsActivity.this.k.setVisibility(8);
                }
                WalletSmsActivity.this.f26129h.setEnabled(WalletSmsActivity.this.a(editable.toString()));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!this.f26132b) {
                    if (WalletSmsActivity.this.f26125c != null) {
                        WalletSmsActivity.this.f26125c.doOnEvent();
                    }
                    this.f26132b = true;
                }
                WalletSmsActivity.this.b();
            }
        });
        View findViewById = findViewById(ResUtils.id(this.f26123a, "dialog_close"));
        this.l = findViewById;
        findViewById.setOnClickListener(this);
        this.m = (TextView) findViewById(ResUtils.id(this.f26123a, "dialog_title"));
        this.p = ResUtils.anim(this, "wallet_dialog_slide_to_left");
        this.q = ResUtils.anim(this, "wallet_dialog_slide_to_right");
        this.r = (TextView) findViewById(ResUtils.id(this, "ebpay_error_tip"));
        View findViewById2 = findViewById(ResUtils.id(this, "ebpay_sms_line_info"));
        this.w = findViewById2;
        findViewById2.setBackgroundColor(Color.parseColor("#54576A"));
        TextView textView = (TextView) findViewById(ResUtils.id(this, "ebpay_btn_modify_phone"));
        this.v = textView;
        textView.setOnClickListener(this);
        setSafeScrollView(this.f26127f);
        a(getIntent());
        this.f26126e.requestFocus();
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
