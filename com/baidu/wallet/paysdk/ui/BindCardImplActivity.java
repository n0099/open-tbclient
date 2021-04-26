package com.baidu.wallet.paysdk.ui;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.DivisionEditText;
import com.baidu.wallet.base.widget.OrderConfirmation;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.SafeKeyBoardUtil;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.StatusCode;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.b.f;
import com.baidu.wallet.paysdk.b.g;
import com.baidu.wallet.paysdk.b.j;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.y;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.QueryBankBinResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
import com.baidu.wallet.paysdk.ui.widget.BankCardInfoView;
import com.baidu.wallet.paysdk.ui.widget.BankCvv2InfoView;
import com.baidu.wallet.paysdk.ui.widget.BankMsgInfoView;
import com.baidu.wallet.paysdk.ui.widget.BankUserInfoView;
import com.baidu.wallet.paysdk.ui.widget.BindCardHeadView;
import com.baidu.wallet.paysdk.ui.widget.CertificateMenuView;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class BindCardImplActivity extends BindCardBaseActivity implements c {
    public static Pattern A = Pattern.compile("(4|1(1|2))");
    public static final String TAG = "BindCardImplActivity";
    public int B;
    public ViewGroup C;
    public GetCardInfoResponse.CertificateTypeInfo G;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f26390b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f26391c;

    /* renamed from: e  reason: collision with root package name */
    public GetCardInfoResponse f26392e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26393f;

    /* renamed from: i  reason: collision with root package name */
    public BankCardInfoView f26396i;
    public OrderConfirmation j;
    public AuthorizeInfoView k;
    public BankMsgInfoView l;
    public LinearLayout m;
    public BankCvv2InfoView mBankCvv2InfoView;
    public BankUserInfoView mBankUserInfoView;
    public com.baidu.wallet.paysdk.ui.widget.b mCertificateTypeDialog;
    public WalletBaseButtonWithImage n;
    public TextView o;
    public CheckBox p;
    public BindCardHeadView q;
    public TextView r;
    public TextView s;
    public LinearLayout t;
    public LinearLayout u;
    public GetCardInfoResponse v;
    public GetCardInfoResponse.CardInfo w;
    public boolean y;
    public a z;

    /* renamed from: g  reason: collision with root package name */
    public int f26394g = StatusCode.SERVICE_CODE_CARD_NUMBER_MAYBE_ERROR;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26395h = false;
    public StringBuilder x = new StringBuilder();
    public boolean D = true;
    public String E = "";
    public String F = "";
    public int H = 0;

    /* loaded from: classes5.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<c> f26459a;

        public a(c cVar) {
            this.f26459a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<c> weakReference;
            super.handleMessage(message);
            if (message.what == 0 && (weakReference = this.f26459a) != null) {
                weakReference.get().showBindCardDialog();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f26460a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f26461b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f26462c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f26463d;

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f26464e;

        public b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest != null) {
            if (bindFastRequest.getmBindFrom() == 1) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, StatHelper.collectData(StatHelper.getSessionId(), "-2", "initivativeBindCardCancel"));
            } else if (this.mBindReq.getmBindFrom() == 0) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BIND_CARD_FAILED, StatHelper.collectData(StatHelper.getOrderNo(), "-2", "payBindCardCancel"));
            } else if (this.mBindReq.getmBindFrom() == 6) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BIND_CARD_FAILED, StatHelper.collectData(StatHelper.getOrderNo(), "-2", "authorizeBindCardCancel"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText B() {
        return this.f26391c;
    }

    private boolean n() {
        GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo;
        if (!this.mBindCardController.m() || !this.mBankUserInfoView.getIdEditText().isEnabled() || this.mBankUserInfoView.getIdCardFromNet() || (certificateTypeInfo = this.G) == null) {
            return false;
        }
        return !certificateTypeInfo.getValidator().a(this.mBankUserInfoView.getIdEditText().getText());
    }

    private boolean o() {
        return this.mBindCardController.n() && this.mBankUserInfoView.getMobileEditText().isEnabled() && !this.mBankUserInfoView.getMobileFromNet() && !CheckUtils.isMobileAvailable(this.mBankUserInfoView.getMobileEditText().getRealText());
    }

    private boolean p() {
        int parseInt;
        if (this.mBindCardController.l() && this.mBankCvv2InfoView.getDateInputView().isEnabled()) {
            String obj = this.mBankCvv2InfoView.getDateInputView().getText().toString();
            if (!TextUtils.isEmpty(obj) && obj.length() == 5) {
                try {
                    if (TextUtils.isEmpty(obj) || ((parseInt = Integer.parseInt(obj.substring(0, 2))) > 0 && parseInt <= 12)) {
                        return Integer.parseInt(obj.substring(3, 5)) < q();
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return true;
        }
        return false;
    }

    private int q() {
        String format = new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(format) && format.length() == 4) {
            try {
                return Integer.parseInt(format.substring(2, 4));
            } catch (Exception unused) {
            }
        }
        return 18;
    }

    private boolean r() {
        return this.mBindCardController.k() && this.mBankCvv2InfoView.getCvv2InputView().isEnabled() && !CheckUtils.isBandCardEndAvailable(this.mBankCvv2InfoView.getCvv2InputView().getText().toString());
    }

    private void s() {
        DivisionEditText cardNoView = this.f26396i.getCardNoView();
        cardNoView.addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.9

            /* renamed from: a  reason: collision with root package name */
            public boolean f26457a = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!this.f26457a) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_CARD_NO);
                    this.f26457a = true;
                }
                BindCardImplActivity.this.y();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.f26396i.setTipClick(this);
        cardNoView.setOnMyFocusChangeListener(this);
    }

    private void t() {
        CardData.BondCard bondCard;
        int currentStep = getCurrentStep();
        if (currentStep == 0) {
            this.mScrollView.dismissKeyBoard(this.f26396i.getCardNoView());
            a("");
            return;
        }
        if (currentStep != 1) {
            return;
        }
        if (!this.f26396i.getCardNoView().isEnabled()) {
            BindFastRequest bindFastRequest = this.mBindReq;
            if (bindFastRequest != null && (bondCard = bindFastRequest.mBondCard) != null) {
                this.E = bondCard.account_no;
            }
        } else {
            this.E = this.f26396i.getCardNoView().getRealText();
        }
        if (TextUtils.isEmpty(this.E)) {
            StringBuilder sb = new StringBuilder();
            sb.append("view.isEnable:");
            sb.append(this.f26396i.getCardNoView().isEnabled());
            if (this.mBindReq != null) {
                sb.append(";mBindReq.mBondCard(isNull):");
                sb.append(this.mBindReq.mBondCard == null);
            }
            sb.append("; realText:");
            sb.append(this.f26396i.getCardNoView().getRealText());
            PayStatisticsUtil.onEventEndWithValue("bindcard.cardNo", -1, sb.toString());
        }
        BindFastRequest bindFastRequest2 = this.mBindReq;
        if (bindFastRequest2 != null) {
            bindFastRequest2.setmBankCard(this.E);
        }
        if (this.mBindCardController.E()) {
            w();
        } else {
            u();
        }
    }

    private void u() {
        j jVar = this.mBindCardController;
        if (jVar instanceof g) {
            g gVar = (g) jVar;
            String[] strArr = new String[6];
            strArr[0] = this.mBankCvv2InfoView.getCvv2InputView().getText().toString();
            strArr[1] = this.mBankCvv2InfoView.getDateInputView().getText().toString();
            strArr[2] = this.mBankUserInfoView.getTrueNameText().getText().toString();
            strArr[3] = this.mBankUserInfoView.getIdEditText().getText().toString();
            strArr[4] = this.mBankUserInfoView.getMobileEditText().getText().toString();
            GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.G;
            strArr[5] = certificateTypeInfo != null ? certificateTypeInfo.type : "";
            gVar.b(strArr);
            PayStatisticsUtil.onEvent(StatServiceEvent.BIND_CLICK_PAY);
            StatisticManager.onEventStart(StatServiceEvent.TIME_PAY);
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            y yVar = (y) PayBeanFactory.getInstance().getBean((Context) this, 13, BindCardBaseActivity.BEAN_TAG);
            yVar.setResponseCallback(this);
            yVar.execBean();
        }
    }

    private boolean v() {
        int currentStep = getCurrentStep();
        if (currentStep != 0) {
            if (currentStep != 1) {
                return true;
            }
            return k() && l();
        }
        if (!this.f26396i.getCardNoView().isEnabled()) {
            CardData.BondCard bondCard = this.mBindReq.mBondCard;
            if (bondCard != null) {
                this.E = bondCard.account_no;
            }
        } else {
            this.E = this.f26396i.getCardNoView().getRealText();
        }
        return j();
    }

    private void w() {
        PayStatisticsUtil.onEvent(StatServiceEvent.NEXT_SECOND);
        if (isBindInvalid()) {
            return;
        }
        WalletGlobalUtils.safeShowDialog(this, -2, "");
        j jVar = this.mBindCardController;
        String[] strArr = new String[6];
        strArr[0] = this.mBankCvv2InfoView.getCvv2InputView().getText().toString();
        strArr[1] = this.mBankCvv2InfoView.getDateInputView().getText().toString();
        strArr[2] = this.mBankUserInfoView.getTrueNameText().getText().toString();
        strArr[3] = this.mBankUserInfoView.getIdEditText().getText().toString();
        strArr[4] = this.mBankUserInfoView.getMobileEditText().getText().toString();
        GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.G;
        strArr[5] = certificateTypeInfo != null ? certificateTypeInfo.type : "";
        jVar.c(strArr);
    }

    private void x() {
        if (com.baidu.wallet.paysdk.a.b.a()) {
            WalletGlobalUtils.safeShowDialog(this, 629130, "");
        } else {
            WalletGlobalUtils.safeShowDialog(this, 4, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean y() {
        boolean z;
        this.f26396i.getClearView().setVisibility(8);
        View currentFocus = getWindow().getCurrentFocus();
        String realText = this.f26396i.getCardNoView().getRealText();
        if (this.f26396i.getCardNoView().isEnabled() && getCurrentStep() != 0 && !realText.equals(this.E)) {
            resetCardInfoState();
            this.F = "";
        }
        boolean z2 = false;
        if (currentFocus != null) {
            if (currentFocus.getId() == this.f26396i.getCardNoView().getId() && this.f26396i.getCardNoView().isEnabled()) {
                if (!TextUtils.isEmpty(realText)) {
                    this.f26396i.getClearView().setVisibility(0);
                    this.f26396i.setTipDel();
                } else {
                    if (this.mBindCardController.y()) {
                        this.f26396i.getClearView().setVisibility(0);
                    } else {
                        this.f26396i.getClearView().setVisibility(8);
                    }
                    this.f26396i.setTipScan();
                }
            } else {
                this.f26396i.getClearView().setVisibility(8);
            }
        }
        boolean z3 = true;
        if (this.f26396i.getCardNoView().getVisibility() == 0) {
            if (!TextUtils.isEmpty(realText) && realText.length() >= 10) {
                String substring = realText.substring(0, 10);
                GetCardInfoResponse.CardInfo cardInfo = this.w;
                if (cardInfo != null) {
                    String str = cardInfo.bank_no;
                    if (!TextUtils.isEmpty(str)) {
                        String replace = str.replace(" ", "");
                        if (replace.length() >= 10 && replace.substring(0, 10).equals(substring)) {
                            z = true;
                            if (!z) {
                                updateBankTitleInfo(this.w, false);
                            } else if (realText.length() == 10) {
                                b(realText);
                            } else {
                                b(realText.substring(0, 10));
                            }
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            } else {
                this.F = "";
                updateBankTitleInfo(null, false);
            }
        }
        boolean j = j();
        if (getCurrentStep() != 0) {
            j = (j && l() && k()) ? false : false;
        }
        if (this.m.getVisibility() != 0 || this.p.isChecked()) {
            z2 = j;
        }
        this.n.setEnabled(z2);
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        boolean v = v();
        if (this.m.getVisibility() == 0 && !this.p.isChecked()) {
            v = false;
        }
        this.n.setEnabled(v);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void doLivingPay() {
        u();
    }

    public void handleBindOtherCard() {
        BankCardInfoView bankCardInfoView = this.f26396i;
        if (bankCardInfoView != null) {
            bankCardInfoView.getCardNoView().getText().clear();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        GetCardInfoResponse.ChannelInfo channelInfo;
        if (i3 == 65025) {
            GlobalUtils.toast(this, str);
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            PayBaseBeanActivity.exitEbpay();
        } else if (i2 == 4) {
            GetCardInfoResponse getCardInfoResponse = this.f26392e;
            PayStatisticsUtil.onEventEndWithValue(StatServiceEvent.GET_CARD_INFO, i3, (getCardInfoResponse == null || (channelInfo = getCardInfoResponse.channel_info) == null) ? "0" : channelInfo.channel_no);
            WalletGlobalUtils.safeDismissDialog(this, -2);
            this.mDialogMsg = str;
            if (i3 == 100010) {
                a(true);
            } else if (i3 == 100040 || i3 == 100026) {
                WalletGlobalUtils.safeShowDialog(this, 3, "");
            } else if (i3 == 100028) {
                this.f26394g = i3;
                this.f26395h = false;
                WalletGlobalUtils.safeShowDialog(this, 33, "");
            } else {
                WalletGlobalUtils.safeShowDialog(this, 12, "");
            }
        } else if (i2 == 5 || i2 == 17) {
            WalletGlobalUtils.safeDismissDialog(this, -2);
            super.handleFailure(i2, i3, str);
            this.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(this, 12, "");
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_CHECK, i3);
        } else if (i2 == 7) {
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_BIN, i3);
        } else if (i2 == 13) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
            this.mDialogMsg = str;
            this.mPayErrorCode = i3;
            this.mBeanId = i2;
            WalletGlobalUtils.safeShowDialog(this, 12, "");
            StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, i3);
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.BIND_PAY_ACCEPT_FAIL, String.valueOf(i3));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        CardAddResponse.CustomerSvcCfg customerSvcCfg;
        int i3;
        super.handleResponse(i2, obj, str);
        if (i2 == 7) {
            if (obj == null || !(obj instanceof QueryBankBinResponse)) {
                return;
            }
            QueryBankBinResponse queryBankBinResponse = (QueryBankBinResponse) obj;
            GetCardInfoResponse.CardInfo cardInfo = queryBankBinResponse.card_info;
            if (cardInfo != null) {
                String str2 = cardInfo.bank_name;
                this.w = cardInfo;
                if (this.f26396i.getCardNoView() != null && !TextUtils.isEmpty(this.f26396i.getCardNoView().getText())) {
                    this.w.bank_no = this.f26396i.getCardNoView().getText().toString();
                }
            }
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_BIN, 0);
            updateBankTitleInfo(queryBankBinResponse.card_info, false);
        } else if (i2 == 4) {
            WalletGlobalUtils.safeDismissDialog(this, -2);
            GetCardInfoResponse getCardInfoResponse = (GetCardInfoResponse) obj;
            this.f26392e = getCardInfoResponse;
            if (getCardInfoResponse == null) {
                return;
            }
            GetCardInfoResponse.ChannelInfo channelInfo = getCardInfoResponse.channel_info;
            PayStatisticsUtil.onEventEndWithValue(StatServiceEvent.GET_CARD_INFO, 0, channelInfo != null ? channelInfo.channel_no : "0");
            this.f26394g = -1;
            this.mDialogMsg = "";
            Map<String, String> map = this.f26392e.cashdesk;
            if (map != null && map.size() > 0) {
                PayDataCache.getInstance().setSessionData(this.f26392e.cashdesk);
            }
            GetCardInfoResponse.Algorithm algorithm = this.f26392e.algorithm_check_info;
            if (algorithm != null && (i3 = algorithm.code) == 100027) {
                this.f26394g = i3;
                this.mDialogMsg = algorithm.msg;
                this.f26395h = false;
                WalletGlobalUtils.safeShowDialog(this, 33, "");
                return;
            }
            GetCardInfoResponse.BindCardInfo bindCardInfo = this.f26392e.bind_card_info;
            if (bindCardInfo != null && !TextUtils.isEmpty(bindCardInfo.bind_card_desc)) {
                this.f26394g = StatusCode.SERVICE_CODE_CARD_NUMBER_MAYBE_ERROR;
                this.mDialogMsg = this.f26392e.bind_card_info.bind_card_desc;
                this.f26395h = true;
                WalletGlobalUtils.safeShowDialog(this, 33, "");
                return;
            }
            a(this.f26392e);
        } else if (i2 != 5 && i2 != 17) {
            if (i2 == 13) {
                WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
                StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, 0);
                PayStatisticsUtil.onEvent("paySuccess");
            } else if (597 == i2) {
                CardAddResponse.updateContent(obj);
                CardAddResponse cardAddResponse = CardAddResponse.getInstance();
                if (cardAddResponse == null || (customerSvcCfg = cardAddResponse.intelligent_service) == null) {
                    return;
                }
                com.baidu.wallet.paysdk.ui.b.a(this.mAct, this.bdActionBar, customerSvcCfg.customer_service_url, customerSvcCfg.customer_service_icon, customerSvcCfg.customer_service_copy, StatServiceEvent.EVENT_CSTM_SVC_CARD_ADD);
            }
        } else {
            WalletGlobalUtils.safeDismissDialog(this, -2);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_CHECK, 0);
            CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
            this.mBindReq.setmNeedSms((1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) ? 1 : 0);
            Map<String, String> map2 = checkCardInfoResponse.cashdesk;
            if (map2 != null && map2.size() > 0) {
                PayDataCache.getInstance().setSessionData(checkCardInfoResponse.cashdesk);
            }
            if (!TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                this.mBindReq.setChannelNo(checkCardInfoResponse.channel_no);
            }
            this.mBindReq.setRegEx(checkCardInfoResponse.sms_pattern);
            this.mBindReq.setSmsLength(checkCardInfoResponse.sms_length);
            this.mBindReq.setSmsType(checkCardInfoResponse.sms_type);
            this.mBindReq.setSendSmsphone(checkCardInfoResponse.send_sms_phone);
            if (i2 == 5) {
                Bundle extras = getIntent().getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                extras.putString(BeanConstants.UPDATE_MOBILE_DESC, checkCardInfoResponse.update_mobile_desc);
                extras.putInt(BeanConstants.SMS_ACTIVITY_FROM_KEY, this.mBindReq.getmBindFrom() == 1 ? 7 : 0);
                PayRequestCache.BindCategory bindCategory = ((BindCardBaseActivity) this).f26374a;
                if (bindCategory == null) {
                    bindCategory = PayRequestCache.BindCategory.Other;
                }
                extras.putString(Constants.BDL_KEY_FROM, bindCategory.name());
                a(extras, WalletSmsActivity.class, false);
            }
            if (i2 == 17) {
                if (com.baidu.wallet.paysdk.a.b.a()) {
                    this.mBindReq.mBindFrom = 7;
                } else {
                    this.mBindReq.mBindFrom = 2;
                }
                Intent intent = new Intent();
                intent.setClass(this, WalletSmsActivity.class);
                intent.putExtra(BeanConstants.UPDATE_MOBILE_DESC, checkCardInfoResponse.update_mobile_desc);
                intent.putExtra(BeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, false);
                intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
                intent.putExtra(BeanConstants.KEY_SEND_SMS_AUTO, false);
                PayRequestCache.BindCategory bindCategory2 = ((BindCardBaseActivity) this).f26374a;
                if (bindCategory2 == null) {
                    bindCategory2 = PayRequestCache.BindCategory.Other;
                }
                intent.putExtra(Constants.BDL_KEY_FROM, bindCategory2.name());
                startActivityForResultWithoutAnim(intent, 0);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void initSafeKeyBoard() {
        if (isShowWithHalfScreeen()) {
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = {this.f26396i.getCardNoView(), this.mBankCvv2InfoView.getDateInputView(), this.mBankCvv2InfoView.getCvv2InputView(), this.mBankUserInfoView.getTrueNameText(), this.mBankUserInfoView.getIdEditText(), this.mBankUserInfoView.getMobileEditText()};
            for (int i2 = 0; i2 < 6; i2++) {
                SafeKeyBoardEditText safeKeyBoardEditText = safeKeyBoardEditTextArr[i2];
                safeKeyBoardEditText.setOnMyFocusChangeListener(this);
                safeKeyBoardEditText.initSafeKeyBoardParams(this.mRootView, this.mScrollView, (View) safeKeyBoardEditText.getTag(), false);
            }
        } else if (this.f26396i.getCardNoView().isEnabled()) {
            this.f26396i.getCardNoView().setOnMyFocusChangeListener(this);
            this.f26396i.getCardNoView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, this.m.getVisibility() == 0 ? this.m : this.s.getVisibility() == 0 ? this.s : this.n, false);
        }
        super.initSafeKeyBoard();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 40976 && i3 == -1 && intent != null && intent.getExtras() != null) {
            a(intent.getExtras().getString("subbankcode"));
        }
        if (i2 != 0 || i3 == -1) {
            return;
        }
        this.mBindReq.mBindFrom = this.B;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PayRequest payRequest = this.mPayReq;
        if (payRequest != null) {
            payRequest.clearMktSolution();
        }
        if (!this.f26393f) {
            A();
        }
        if (this.mBindReq.getmBindFrom() == 1) {
            PayController.getInstance().bindFail(this, "");
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            finish();
        } else if (this.mBindReq.getmBindFrom() == 5) {
            PayController.getInstance().bindFail(this, "");
            finish();
        } else if (this.f26393f) {
            x();
        } else if (this.mBindReq.getmBindFrom() != 2 && (this.mBindReq.getmBindFrom() != 0 || !PayDataCache.getInstance().isFromPreCashier())) {
            super.onBackPressed();
        } else {
            LogUtil.d(TAG, "callbackClientCancel  from  cardupdate  in  Precashier!");
            PayCallBackManager.callBackClientCancel(this, "BindCardImplActivity.onBackPressed().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.n && view.getId() != ResUtils.id(this.mAct, "wallet_base_safekeyboard_confirm")) {
            if (view == this.j.getCouponInfoView()) {
                PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_PRESS_OTHER_DISCOUNT);
                PayController.getInstance().gotoDiscountPage(this);
            }
        } else if (v()) {
            BankCardInfoView bankCardInfoView = this.f26396i;
            if (bankCardInfoView != null) {
                String scanCardNum = bankCardInfoView.getScanCardNum();
                if (!TextUtils.isEmpty(scanCardNum) && !scanCardNum.equals(this.f26396i.getCardNoView().getRealText())) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.STAT_CHANGENUMAFTSCAN);
                }
                this.f26396i.resetScanCardNum();
            }
            t();
        }
        super.onClick(view);
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String sessionId;
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
        if (LocalRouter.getInstance(getActivity()).isProviderExisted("bankdetection")) {
            this.D = getIntent().getBooleanExtra(Constants.BDL_KEY_BANKINFO_EXTRA, true);
        } else {
            this.D = false;
        }
        if (bundle == null) {
            this.f26393f = getIntent().getBooleanExtra(BindFastRequest.BIND_IS_FIRST, false);
            Serializable serializableExtra = getIntent().getSerializableExtra("cardinforesponse");
            if (serializableExtra != null && (serializableExtra instanceof GetCardInfoResponse)) {
                this.v = (GetCardInfoResponse) serializableExtra;
            }
        } else {
            this.f26393f = bundle.getBoolean("isFrist", false);
            this.f26395h = bundle.getBoolean("bindTipFromActivity", false);
            if (this.f26392e == null) {
                Serializable serializable = bundle.getSerializable("cacheResult");
                if (serializable != null && (serializable instanceof GetCardInfoResponse)) {
                    this.f26392e = (GetCardInfoResponse) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("cardinforesponse");
                if (serializable2 != null && (serializable2 instanceof GetCardInfoResponse)) {
                    this.v = (GetCardInfoResponse) serializable2;
                }
            }
        }
        a();
        getBindCardFlagDelegate().a(this.mBindReq);
        int i2 = this.mBindReq.getmBindFrom();
        this.B = i2;
        if (i2 != 1 && i2 != 5 && i2 != 3) {
            sessionId = StatHelper.getOrderNo();
        } else {
            sessionId = StatHelper.getSessionId();
        }
        StatisticManager.onEventWithValues(PayStatServiceEvent.ENTER_BIND_CARD_ACTIVITY, StatHelper.collectData(sessionId, this.B + ""));
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 629128) {
            return new PromptDialog(getActivity());
        }
        return super.onCreateDialog(i2);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBus.getInstance().unregister(this, "order_confirm_event_bus_key");
        this.mBindReq.setmBankInfo(null);
        this.mBindReq.mCardInfoUpdateContent = null;
        BeanManager.getInstance().removeAllBeans(BindCardBaseActivity.BEAN_TAG);
        if (LocalRouter.getInstance(this.mAct).isProviderExisted("bankdetection")) {
            LocalRouter.getInstance(this.mAct).route(this.mAct, new RouterRequest().provider("bankdetection").action("clearcallback"), new RouterCallback() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.19
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "bankcarddetection");
                        hashMap2.put("action", "clearcallback");
                        StatisticManager.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                    }
                }
            });
        }
        super.onDestroy();
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        a(view, z);
        if (z) {
            if (view instanceof EditText) {
                this.f26391c = (EditText) view;
            }
            z();
        } else {
            a(view);
        }
        super.onFocusChange(view, z);
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        if (event != null && "order_confirm_event_bus_key".equals(event.mEventKey)) {
            if (this.mBindCardController.d()) {
                this.mBindCardController.o();
            }
            resetCardInfoState();
            y();
            return;
        }
        super.onModuleEvent(event);
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.base.widget.SafeKeyBoardEditText.OnMyFocusChangeListener
    public void onMyFocusChange(View view, boolean z) {
        Drawable drawable;
        if (this.mRootView instanceof LinearLayout) {
            View findViewById = findViewById(ResUtils.id(this.mAct, "padding_view"));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            int height = findViewById.getHeight();
            if (1.0f == layoutParams.weight && height > 0) {
                PayRequest payRequest = this.mPayReq;
                boolean z2 = payRequest != null && BaiduPay.PAY_FROM_AUTHORIZE.equals(payRequest.mPayFrom);
                if (!PayDataCache.getInstance().isFromPreCashier() && !z2) {
                    drawable = new ColorDrawable(0);
                } else {
                    drawable = ResUtils.getDrawable(this.mAct, "wallet_base_halfscreen_bg");
                }
                findViewById.setBackgroundDrawable(drawable);
                layoutParams.weight = 0.0f;
                layoutParams.height = height;
                findViewById.setLayoutParams(layoutParams);
            }
        }
        if (view == this.f26396i.getCardNoView()) {
            if (z) {
                y();
            } else if (this.f26396i.getCardNoView().isEnabled()) {
                if (this.mBindCardController.y()) {
                    this.f26396i.getClearView().setVisibility(0);
                } else {
                    this.f26396i.getClearView().setVisibility(8);
                }
                this.f26396i.setTipScan();
            } else {
                this.f26396i.getClearView().setVisibility(8);
            }
            com.baidu.wallet.paysdk.ui.widget.a.a(view, false, z);
        } else {
            a(view, z);
            if (z) {
                if (view instanceof EditText) {
                    this.f26391c = (EditText) view;
                }
                z();
                this.mBankCvv2InfoView.getCvv2InputView();
                int i2 = view != this.mBankCvv2InfoView.getDateInputView() ? 0 : 1;
                if (view == this.mBankUserInfoView.getIdEditText()) {
                    i2 = 3;
                }
                if (view == this.mBankUserInfoView.getMobileEditText()) {
                    i2 = 4;
                }
                a(i2);
            } else {
                a(view);
            }
        }
        super.onMyFocusChange(view, z);
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean runInHalfScreenMode = runInHalfScreenMode();
        b d2 = d();
        super.onNewIntent(intent);
        int i2 = this.mBindReq.mBindFrom;
        if (i2 == 9) {
            j a2 = com.baidu.wallet.paysdk.b.c.a(i2);
            this.mBindCardController = a2;
            a2.a(this);
        }
        this.mBindCardController.a(this.mBindReq);
        if (runInHalfScreenMode != isShowWithHalfScreeen()) {
            a();
            a(d2);
        } else if (this.mBindCardController.s()) {
            loadCvv2();
        }
        if (this.mBindCardController instanceof f) {
            this.mBankUserInfoView.getMobileEditText().setEnabled(true);
            a(d2);
        }
        LogUtil.d("BindCardImplActivity.onNewIntent!");
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage(this.mDialogMsg);
            if (!TextUtils.isEmpty(this.E)) {
                promptDialog.setTitleText(formatCardNo(this.E));
            }
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_choose_credit_tip2"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_SURPPORT_BANKLIST);
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 3);
                    BindCardImplActivity.this.a(false);
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_SELECT_OTHER_PAYTYPE_FROMCARD);
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 3);
                }
            });
        } else if (i2 == 12) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage(this.mDialogMsg);
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 12);
                }
            });
            promptDialog2.hideNegativeButton();
        } else if (i2 == 33) {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage(this.mDialogMsg);
            if (!this.f26395h && !TextUtils.isEmpty(this.E)) {
                if (this.f26395h) {
                    promptDialog3.setTitleText(ResUtils.string(getActivity(), "ebpay_tip"));
                } else {
                    promptDialog3.setTitleText(formatCardNo(this.E));
                }
            }
            promptDialog3.setCanceledOnTouchOutside(false);
            promptDialog3.setNegativeBtn(ResUtils.string(getActivity(), this.f26395h ? "ebpay_choose_bind_sure" : "ebpay_choose_modify_card"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 33);
                }
            });
            promptDialog3.setPositiveBtn(ResUtils.string(getActivity(), this.f26395h ? "ebpay_choose_bind_continue" : "ebpay_choose_confirm"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_CONFIRM_CARDNO);
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 33);
                    if (BindCardImplActivity.this.f26394g != 100027) {
                        if (BindCardImplActivity.this.f26394g == 100028) {
                            BindCardImplActivity.this.a(true);
                            return;
                        }
                        return;
                    }
                    BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                    bindCardImplActivity.a(bindCardImplActivity.f26392e);
                }
            });
        } else if (i2 == 629128) {
            PromptDialog promptDialog4 = (PromptDialog) dialog;
            promptDialog4.setMessage(this.mDialogMsg);
            promptDialog4.setCanceledOnTouchOutside(false);
            promptDialog4.hideNegativeButton();
            promptDialog4.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 629128);
                }
            });
        } else if (i2 != 629130) {
            super.onPrepareDialog(i2, dialog);
        } else {
            final PromptDialog promptDialog5 = (PromptDialog) dialog;
            promptDialog5.setCanceledOnTouchOutside(false);
            promptDialog5.setMessage(ResUtils.getString(this, "bd_wallet_auth_confirm_to_cancel"));
            promptDialog5.setNegativeBtn(ResUtils.string(this, "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    promptDialog5.dismiss();
                }
            });
            promptDialog5.setPositiveBtn(ResUtils.string(this, "bd_wallet_auth_cancel_auth"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BindCardImplActivity.this.A();
                    promptDialog5.dismiss();
                    PayCallBackManager.callBackClientCancel(BindCardImplActivity.this, "BindCardImplActivity.onPrepareDialog().1");
                }
            });
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isFromRestore) {
            this.isFromRestore = false;
            WalletGlobalUtils.safeDismissDialog(this.mAct, 3);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 33);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 12);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        GetCardInfoResponse getCardInfoResponse = this.f26392e;
        if (getCardInfoResponse != null) {
            bundle.putSerializable("cacheResult", getCardInfoResponse);
        }
        GetCardInfoResponse getCardInfoResponse2 = this.v;
        if (getCardInfoResponse2 != null) {
            bundle.putSerializable("cardinforesponse", getCardInfoResponse2);
        }
        bundle.putBoolean("bindTipFromActivity", this.f26395h);
        bundle.putBoolean("is_first", this.f26393f);
        super.onSaveInstanceState(bundle);
    }

    public void resetCardInfoState() {
        if (getCurrentStep() != 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.m.setLayoutParams(layoutParams);
            this.mBindReq.setmBankInfo(null);
            this.mBindReq.setmBankCard("");
            this.G = null;
            this.F = "";
            this.f26391c = null;
            this.mBindCardController.b(null);
            this.m.setVisibility(8);
            this.l.setVisibility(8);
            this.l.hideCouponView();
            this.r.setVisibility(8);
            this.mBankCvv2InfoView.clearEditMsg();
            this.mBankCvv2InfoView.setVisibility(8);
            this.mBankCvv2InfoView.hideErrorLayout();
            this.mBankUserInfoView.clearEditMsg();
            this.mBankUserInfoView.setVisibility(8);
            this.mBankUserInfoView.hideErrorLayout();
            this.mBankUserInfoView.setMoblieFromNet(false);
            this.mBankUserInfoView.setIdCardFromNet(false);
            this.s.setVisibility(8);
            g();
            initSafeKeyBoard();
            this.mScrollView.invalidate();
            this.H = 0;
            changeCurrentStepInfo(this.mBindCardController.a(0)[0], 0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new LinearLayout.LayoutParams(-1, 100);
            }
            layoutParams2.topMargin = 0;
            this.n.setLayoutParams(layoutParams2);
            this.n.setText(this.mBindCardController.a(0)[1]);
            this.n.setDrawableLeftVisible(true);
            this.mScrollView.setBackgroundColor(ResUtils.getColor(this.mAct, "wallet_base_whiteColor"));
        }
    }

    public boolean runInHalfScreenMode() {
        return this.mRootView instanceof LinearLayout;
    }

    @Override // com.baidu.wallet.paysdk.ui.c
    public void showBindCardDialog() {
        if (this.isFromRestore) {
            return;
        }
        WalletGlobalUtils.safeShowDialog(this, 629128, "");
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        if (z) {
            PayController.getInstance().paySucess(this, payResultContent, i2);
        } else {
            PayController.getInstance().payPaying(this, payResultContent, i2);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void triggerSmsVerify(ErrorContentResponse.Verify verify, boolean z, String str, int i2) {
        StatisticManager.onEvent(StatServiceEvent.TRIGGLESMSPAY);
        Intent intent = new Intent();
        intent.setClass(this, WalletSmsActivity.class);
        intent.putExtra(BeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, true);
        intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
        intent.putExtra(BeanConstants.KEY_SEND_SMS_AUTO, z);
        intent.putExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
        intent.putExtra(BeanConstants.KEY_SMS_HINT, str);
        intent.putExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, i2);
        PayRequestCache.BindCategory bindCategory = ((BindCardBaseActivity) this).f26374a;
        if (bindCategory == null) {
            bindCategory = PayRequestCache.BindCategory.Other;
        }
        intent.putExtra(Constants.BDL_KEY_FROM, bindCategory.name());
        startActivityWithoutAnim(intent);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void triggerSpeechVerify(ErrorContentResponse.Verify verify) {
        PayStatisticsUtil.onEvent(StatServiceEvent.TRIGGER_SPEECH_VERIFY);
        Intent intent = new Intent();
        intent.setClass(this, VoiceVerifyActivity.class);
        intent.putExtra(BeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, true);
        intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
        intent.putExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
        startActivityWithoutAnim(intent);
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateBankCouponDesc(CharSequence charSequence) {
        this.l.setCouponDesc(charSequence);
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateBankTitleInfo(GetCardInfoResponse.CardInfo cardInfo, boolean z) {
        String string;
        if (cardInfo != null) {
            this.l.setVisibility(isShowWithHalfScreeen() ? 8 : 0);
            BankMsgInfoView bankMsgInfoView = this.l;
            String str = cardInfo.bank_logourl;
            StringBuilder sb = new StringBuilder();
            sb.append(cardInfo.bank_name);
            sb.append(" ");
            if (cardInfo.card_type == 1) {
                string = ResUtils.getString(getActivity(), "bd_wallet_credit");
            } else {
                string = ResUtils.getString(getActivity(), "bd_wallet_debit");
            }
            sb.append(string);
            bankMsgInfoView.setBankInfo(str, sb.toString());
        } else if (isShowWithHalfScreeen()) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(z ? 8 : 4);
        }
        this.l.invalidate();
        if (TextUtils.isEmpty(this.mBindCardController.c())) {
            this.r.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        this.r.setText(this.mBindCardController.c());
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateCardElement(final boolean z, final boolean z2, final boolean z3, final boolean z4, final boolean z5) {
        if (!z && !z2) {
            this.mBankCvv2InfoView.setVisibility(8);
        } else {
            this.mBankCvv2InfoView.setVisibility(0);
            this.mBankCvv2InfoView.hideArea(!z, !z2);
        }
        if (!z3 && !z4 && !z5) {
            this.mBankUserInfoView.setVisibility(8);
        } else {
            this.mBankUserInfoView.setVisibility(0);
            this.mBankUserInfoView.hideArea(!z3, !z4, !z5);
        }
        this.mBankUserInfoView.setMobileInputAreaStatus(this.mBindCardController.u());
        GetCardInfoResponse.CertificateTypeInfo w = this.mBindCardController.w();
        this.G = w;
        this.mBankUserInfoView.updateCertificateType(w);
        this.mBankUserInfoView.setIdInputAreaStatus(this.mBindCardController.a(this.G));
        int x = this.mBindCardController.x();
        this.mBankUserInfoView.setCertificateCanClick(x > 1);
        if (x > 1) {
            this.mBankUserInfoView.setOnCodeTypeClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_SWITCH_IDENTITY_TYPE);
                    if (BindCardImplActivity.this.B() != null) {
                        BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                        bindCardImplActivity.mScrollView.dismissKeyBoard((SafeKeyBoardEditText) bindCardImplActivity.B());
                    }
                    com.baidu.wallet.paysdk.ui.widget.b bVar = BindCardImplActivity.this.mCertificateTypeDialog;
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                    BindCardImplActivity bindCardImplActivity2 = BindCardImplActivity.this;
                    bindCardImplActivity2.mCertificateTypeDialog = new com.baidu.wallet.paysdk.ui.widget.b(view, bindCardImplActivity2.a(bindCardImplActivity2.G, BindCardImplActivity.this.mBindCardController.v()));
                    BindCardImplActivity.this.mCertificateTypeDialog.a(new CertificateMenuView.b() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.20.1
                        @Override // com.baidu.wallet.paysdk.ui.widget.CertificateMenuView.b
                        public void a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
                            BindCardImplActivity.this.mCertificateTypeDialog.dismiss();
                            BindCardImplActivity.this.G = certificateTypeInfo;
                            BindCardImplActivity.this.mBindCardController.b(certificateTypeInfo);
                            BindCardImplActivity bindCardImplActivity3 = BindCardImplActivity.this;
                            bindCardImplActivity3.mBankUserInfoView.setIdInputAreaStatus(bindCardImplActivity3.mBindCardController.a(bindCardImplActivity3.G), false);
                            BindCardImplActivity.this.mBankUserInfoView.updateCertificateType(certificateTypeInfo);
                            AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                            if (z4 && BindCardImplActivity.this.mBankUserInfoView.getIdEditText().isEnabled()) {
                                SafeKeyBoardEditText idEditText = BindCardImplActivity.this.mBankUserInfoView.getIdEditText();
                                AnonymousClass20 anonymousClass202 = AnonymousClass20.this;
                                BindCardImplActivity bindCardImplActivity4 = BindCardImplActivity.this;
                                idEditText.initSafeKeyBoardParams(bindCardImplActivity4.mRootView, bindCardImplActivity4.mScrollView, bindCardImplActivity4.a(3, z, z2, z3, z4, z5), false);
                            }
                            BindCardImplActivity.this.mBankUserInfoView.setIdTipRedColor(false);
                            BindCardImplActivity bindCardImplActivity5 = BindCardImplActivity.this;
                            bindCardImplActivity5.a(bindCardImplActivity5.mBankUserInfoView.getIdEditText());
                            BindCardImplActivity.this.z();
                        }
                    });
                    BindCardImplActivity.this.mCertificateTypeDialog.show();
                }
            });
        }
        changeCurrentStepInfo(this.mBindCardController.a(1)[0], 1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, 100);
        }
        layoutParams.topMargin = this.mAct.getResources().getDimensionPixelSize(ResUtils.dimen(this.mAct, "ebpay_bind_card_info_below_height"));
        this.n.setLayoutParams(layoutParams);
        this.n.setText(this.mBindCardController.a(1)[1]);
        this.n.setDrawableLeftVisible(false);
        if (isShowWithHalfScreeen()) {
            this.n.setVisibility(8);
        }
        z();
        this.mScrollView.setBackgroundColor(ResUtils.getColor(this.mAct, "wallet_base_whiteColor"));
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.21
            @Override // java.lang.Runnable
            public void run() {
                BindCardImplActivity.this.a(z, z2, z3, z4, z5);
            }
        }, 150L);
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateChangeCard() {
        if (this.f26396i.getCardNoView().isEnabled()) {
            this.f26396i.getCardNoView().requestFocus();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateCvv2Info(boolean z, boolean z2, boolean z3) {
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateDiscountTitle(String str) {
        this.j.setTitle(str);
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateDiscountTxt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
        String displayName;
        this.j.setOrderPrice(charSequence5, charSequence2);
        this.j.setDiscountInfoVisiable(true);
        this.j.setCouponInfo(charSequence3, charSequence4, this);
        this.j.setOrderInfo(charSequence);
        this.j.setSpNameValue(PayDataCache.getInstance().getSpName());
        if (PayDataCache.getInstance().isRemotePay() || com.baidu.wallet.paysdk.a.b.c()) {
            if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getPassUserName())) {
                displayName = WalletLoginHelper.getInstance().getPassUserName();
            } else {
                displayName = PayDataCache.getInstance().getPayResponse().getDisplayName();
            }
            this.j.setAccountInfo(displayName, null);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateProtocolFields(GetCardInfoResponse.ProtocolInfo protocolInfo) {
        if (protocolInfo == null) {
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(0);
        CheckBox checkBox = (CheckBox) findViewById(ResUtils.id(getActivity(), "ebpay_protocol"));
        this.p = checkBox;
        if (checkBox != null) {
            checkBox.setChecked(protocolInfo.isProtocolCheckedDefault());
            this.p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.26
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    StatisticManager.onEventWithValue(StatServiceEvent.CLICK_AGREE_BTN, z ? "0" : "1");
                    BindCardImplActivity.this.z();
                }
            });
        }
        TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "ebpay_protocol_text"));
        if (textView != null) {
            ArrayList arrayList = new ArrayList();
            GetCardInfoResponse.ProtocolItem[] protocolItemArr = protocolInfo.list;
            if (protocolItemArr != null) {
                for (GetCardInfoResponse.ProtocolItem protocolItem : protocolItemArr) {
                    if (!TextUtils.isEmpty(protocolItem.title)) {
                        arrayList.add(protocolItem);
                    }
                }
            }
            if (arrayList.size() > 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int color = ResUtils.getColor(getActivity(), "wallet_base_font_868e9e");
                spannableStringBuilder.append((CharSequence) (protocolInfo.prefix + " "));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, protocolInfo.prefix.length(), 33);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    GetCardInfoResponse.ProtocolItem protocolItem2 = (GetCardInfoResponse.ProtocolItem) arrayList.get(i2);
                    if (i2 != 0) {
                        String str = protocolInfo.separator;
                        if (i2 == arrayList.size() - 1) {
                            str = protocolInfo.last_separator;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            spannableStringBuilder.append((CharSequence) str);
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - str.length(), spannableStringBuilder.length(), 33);
                        }
                    }
                    spannableStringBuilder.append((CharSequence) protocolItem2.title);
                    if (!TextUtils.isEmpty(protocolItem2.url)) {
                        final String str2 = protocolItem2.url;
                        final String replaceAll = protocolItem2.title.replaceAll("<|>|《|》", "");
                        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.27
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View view) {
                                StatisticManager.onEvent(StatServiceEvent.CLICK_USER_TERMS);
                                Intent intent = new Intent(BindCardImplActivity.this.getActivity(), WebViewActivity.class);
                                intent.putExtra("jump_url", str2);
                                intent.putExtra("webview_title_string", replaceAll);
                                BindCardImplActivity.this.startActivity(intent);
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public void updateDrawState(TextPaint textPaint) {
                                textPaint.setColor(ResUtils.getColor(BindCardImplActivity.this.getActivity(), "wallet_base_color_clickable"));
                            }
                        }, spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                    } else {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                    }
                }
                textView.setEnabled(true);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                if (!TextUtils.isEmpty(protocolInfo.suffix)) {
                    spannableStringBuilder.append((CharSequence) protocolInfo.suffix);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - protocolInfo.suffix.length(), spannableStringBuilder.length(), 33);
                }
                textView.setText(spannableStringBuilder);
                return;
            }
            textView.setVisibility(8);
            CheckBox checkBox2 = this.p;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
                return;
            }
            return;
        }
        CheckBox checkBox3 = this.p;
        if (checkBox3 != null) {
            checkBox3.setVisibility(8);
        }
    }

    public void updateUiMode(Intent intent) {
        onNewIntent(intent);
    }

    private void b() {
        CardData.BondCard bondCard;
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest == null || (bondCard = bindFastRequest.mBondCard) == null) {
            return;
        }
        bindFastRequest.mBankNo = bondCard.bank_code;
        this.mBindCardController.a();
    }

    private void c() {
        Pair<Integer, Object> checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (checkSecurityEvn == null || ((Integer) checkSecurityEvn.first).intValue() != 0) {
            return;
        }
        Object obj = checkSecurityEvn.second;
        String str = null;
        if (obj != null && (obj instanceof String)) {
            str = (String) obj;
        }
        if (this.mBindReq == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mBindReq.mSecurityParams = Base64.encodeBytes(str.getBytes());
    }

    private b d() {
        b bVar = new b();
        BankCvv2InfoView bankCvv2InfoView = this.mBankCvv2InfoView;
        if (bankCvv2InfoView != null) {
            bVar.f26461b = bankCvv2InfoView.getCvv2InputView().getEditableText().toString();
            bVar.f26462c = this.mBankCvv2InfoView.getDateInputView().getEditableText().toString();
        }
        BankUserInfoView bankUserInfoView = this.mBankUserInfoView;
        if (bankUserInfoView != null) {
            bVar.f26460a = bankUserInfoView.getTrueNameText().getEditableText().toString();
            bVar.f26463d = this.mBankUserInfoView.getIdEditText().getEditableText().toString();
            bVar.f26464e = this.mBankUserInfoView.getMobileEditText().getEditableText().toString();
        }
        return bVar;
    }

    private void e() {
        CardData.BondCard bondCard;
        a aVar;
        if (this.mBindCardController.g()) {
            this.f26396i.setTrueName(this.mBindCardController.h());
        } else {
            this.f26396i.setTrueName("");
        }
        this.f26396i.setBindcardTip(this.mBindCardController.D());
        this.j.setDiscountInfoVisiable(this.mBindCardController.e());
        this.q.setVisibility(this.mBindCardController.b() ? 0 : 8);
        ArrayList<CharSequence> z = this.mBindCardController.z();
        if (z != null && z.size() > 0) {
            this.q.setTitleVisiable(true);
            this.q.setImageSrcId(ResUtils.drawable(getActivity(), "wallet_base_bind_card_pic"));
            if (z.size() >= 1) {
                this.q.setTitle(z.get(0));
            }
            if (z.size() >= 2) {
                this.q.setSubTitle(z.get(1));
            } else {
                this.q.setSubTitleVisibility(8);
            }
        } else {
            this.q.setTitleVisiable(false);
        }
        if (this.mBindCardController.d()) {
            this.j.setVisibility(0);
            a(this.j, this.u);
            if (!com.baidu.wallet.paysdk.a.b.a() && PayDataCache.getInstance().hasCanAmount()) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_complete_tip8");
                if (this.y && (aVar = this.z) != null) {
                    aVar.postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.23
                        @Override // java.lang.Runnable
                        public void run() {
                            BindCardImplActivity.this.z.obtainMessage(0).sendToTarget();
                        }
                    }, IMLikeRequest.TIME_INTERVAL);
                } else {
                    showBindCardDialog();
                }
            }
        } else {
            this.j.setVisibility(8);
        }
        if (this.mBindCardController.i()) {
            this.k.setVisibility(0);
            this.k.refreshView();
        } else {
            this.k.setVisibility(8);
        }
        boolean q = this.mBindCardController.q();
        if (q) {
            this.f26396i.getCardNoView().setEnabled(true);
            this.f26396i.getCardNoView().setFormatEnable(true);
            this.f26396i.getCardNoView().requestFocus();
        } else {
            this.f26396i.getCardNoView().setEnabled(false);
            this.f26396i.getCardNoView().setFormatEnable(false);
            this.f26396i.getClearView().setVisibility(8);
        }
        if (q) {
            this.f26396i.getCardNoView().setMyHint(this.mBindCardController.p(), "ebpay_bind_card_edittext_hint_txt_size");
        } else {
            this.f26396i.getCardNoView().setMyHint(this.mBindCardController.p(), "wallet_base_level18Font");
            this.f26396i.getCardNoView().setHintTextColor(ResUtils.getColor(this.mAct, "wallet_base_font_text3Color"));
        }
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest != null && bindFastRequest.getmBondCard() != null && !TextUtils.isEmpty(this.mBindReq.getmBondCard().card_required_msg)) {
            com.baidu.wallet.paysdk.ui.widget.a.a(this.C, this.mBindReq.getmBondCard().card_required_msg, null, null);
        } else {
            BindFastRequest bindFastRequest2 = this.mBindReq;
            if (bindFastRequest2 != null && (bondCard = bindFastRequest2.mBondCard) != null && bondCard.bank_code != null) {
                com.baidu.wallet.paysdk.ui.widget.a.a(this.C, "请完善", bondCard.getCardDesc(this.mAct, false), "的信息后继续支付");
            } else {
                com.baidu.wallet.paysdk.ui.widget.a.a(this.C, ResUtils.getString(this.mAct, "ebpay_title_complete_fixmsg"), null, null);
            }
        }
        findViewById(ResUtils.id(this.mAct, "wallet_bind_card_subtitle")).setVisibility(this.mBindCardController.t() ? 0 : 8);
        if (this.mBindCardController.d()) {
            this.mBindCardController.o();
        }
        g();
        BindFastRequest bindFastRequest3 = this.mBindReq;
        if (bindFastRequest3 != null && bindFastRequest3.getmBankInfo() != null) {
            this.mBindCardController.a();
        }
        if (this.mBindCardController.s()) {
            loadCvv2();
        }
        BindFastRequest bindFastRequest4 = this.mBindReq;
        if (bindFastRequest4 == null || !bindFastRequest4.isNotPayBindCard() || CardAddResponse.getInstance().intelligent_service == null) {
            return;
        }
        com.baidu.wallet.paysdk.ui.b.a(this.mAct, this.bdActionBar, CardAddResponse.getInstance().intelligent_service.customer_service_url, CardAddResponse.getInstance().intelligent_service.customer_service_icon, CardAddResponse.getInstance().intelligent_service.customer_service_copy, StatServiceEvent.EVENT_CSTM_SVC_CARD_ADD);
    }

    private void f() {
        addContentView(ResUtils.layout(getActivity(), isShowWithHalfScreeen() ? "wallet_cashdesk_bind_card_view_half_screen" : "wallet_cashdesk_bind_card_view"));
        this.u = (LinearLayout) findViewById(ResUtils.id(getActivity(), "ebpay_parent_bindcard"));
        this.t = (LinearLayout) findViewById(ResUtils.id(getActivity(), "bindcard_root_view"));
        this.r = (TextView) findViewById(ResUtils.id(getActivity(), "bindcard_onecentsdecs"));
        BankCardInfoView bankCardInfoView = (BankCardInfoView) findViewById(ResUtils.id(getActivity(), "bindcard_cardinfo"));
        this.f26396i = bankCardInfoView;
        bankCardInfoView.configDetectCardNum(this.D);
        this.j = (OrderConfirmation) findViewById(ResUtils.id(getActivity(), "bindcard_amount"));
        this.k = (AuthorizeInfoView) findViewById(ResUtils.id(getActivity(), "auth_info_view"));
        this.l = (BankMsgInfoView) findViewById(ResUtils.id(getActivity(), "bindcard_msginfo"));
        this.mBankCvv2InfoView = (BankCvv2InfoView) findViewById(ResUtils.id(getActivity(), "bindcard_cvv2info"));
        BankUserInfoView bankUserInfoView = (BankUserInfoView) findViewById(ResUtils.id(getActivity(), "bindcard_userinfo"));
        this.mBankUserInfoView = bankUserInfoView;
        bankUserInfoView.getMobileEditText().setFormatEnable(false);
        this.mBankUserInfoView.getIdEditText().setUseSafeKeyBoard(true);
        this.mBankUserInfoView.getIdEditText().setUseKeyX(true);
        this.n = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getActivity(), "next_btn"));
        TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "lv_skip_text_view"));
        this.s = textView;
        textView.setVisibility(8);
        this.o = (TextView) findViewById(ResUtils.id(getActivity(), "authorize_fee_tip"));
        this.m = (LinearLayout) findViewById(ResUtils.id(getActivity(), "protocol_display_area"));
        this.q = (BindCardHeadView) findViewById(ResUtils.id(getActivity(), "bindcard_pic"));
        if (!isShowWithHalfScreeen()) {
            findViewById(ResUtils.id(this.mAct, "card_area_top_margin")).setVisibility(this.mBindCardController.F() ? 4 : 8);
        }
        this.n.setEnabled(false);
        this.n.setOnClickListener(this);
        changeCurrentStepInfo(this.mBindCardController.a(0)[0], 0);
        this.n.setText(this.mBindCardController.a(0)[1]);
        this.mScrollView.setKeyBoardStatusChangeListener(new SafeScrollView.onKeyBoardStatusChangeListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.28
            @Override // com.baidu.wallet.base.widget.SafeScrollView.onKeyBoardStatusChangeListener
            public void onKeyBoardStatusChange(boolean z, int i2) {
                LogUtil.d(BindCardBaseActivity.BEAN_TAG, "安全键盘的状态" + z);
                if (z) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) BindCardImplActivity.this.m.getLayoutParams();
                    if (BindCardImplActivity.this.H - i2 >= 0) {
                        layoutParams.bottomMargin = BindCardImplActivity.this.H - i2;
                    } else {
                        layoutParams.bottomMargin = 0;
                    }
                    BindCardImplActivity.this.m.setLayoutParams(layoutParams);
                    BindCardImplActivity.this.t.postInvalidate();
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) BindCardImplActivity.this.m.getLayoutParams();
                layoutParams2.bottomMargin = BindCardImplActivity.this.H;
                BindCardImplActivity.this.m.setLayoutParams(layoutParams2);
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BindCardImplActivity.this.onBackPressed();
            }
        };
        this.j.getBackButton().setOnClickListener(onClickListener);
        if (isShowWithHalfScreeen()) {
            findViewById(ResUtils.id(getActivity(), "action_bar_left_img")).setOnClickListener(onClickListener);
            SafeKeyBoardUtil safeKeyBoardUtil = new SafeKeyBoardUtil();
            safeKeyBoardUtil.setState(SafeKeyBoardUtil.SafeKeyBoardState.CONFRIM_STATE);
            this.mScrollView.setSafeKeyBoardUtil(safeKeyBoardUtil);
            this.mScrollView.setAlwaysShowSoftKeyBoard(true);
            this.n.setVisibility(8);
        } else {
            int bindCardCause = getBindCardCause();
            View findViewById = findViewById(ResUtils.id(this.mAct, "bind_card_head_block"));
            if (1 != bindCardCause && 2 != bindCardCause) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
        this.C = (ViewGroup) findViewById(ResUtils.id(this.mAct, "wallet_bind_card_subtitle"));
        if (Build.VERSION.SDK_INT >= 19) {
            OrderConfirmation orderConfirmation = this.j;
            orderConfirmation.setPadding(orderConfirmation.getPaddingLeft(), StatusBarUtils.getStatusBarHeight(this.mAct), this.j.getPaddingRight(), this.j.getPaddingBottom());
        }
        s();
        h();
        i();
    }

    private void g() {
        if (!com.baidu.wallet.paysdk.a.b.a() || PayDataCache.getInstance().hasBondCards() || PayDataCache.getInstance().getPayResponse() == null || PayDataCache.getInstance().getPayResponse().authorize == null) {
            return;
        }
        Authorize authorize = PayDataCache.getInstance().getPayResponse().authorize;
        if (authorize.agreement_info != null) {
            updateProtocolFields(PayDataCache.getInstance().getPayResponse().authorize.agreement_info);
        }
        Authorize.Extra extra = authorize.extra;
        if (extra != null && !TextUtils.isEmpty(extra.fee_tip)) {
            this.o.setVisibility(0);
            this.o.setText(authorize.extra.fee_tip);
            return;
        }
        this.o.setVisibility(8);
    }

    private void h() {
        this.mBankUserInfoView.getTrueNameText().addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.30

            /* renamed from: b  reason: collision with root package name */
            public boolean f26445b = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                BindCardImplActivity.this.mBankUserInfoView.setTrueNameRedColor(false);
                BankUserInfoView bankUserInfoView = BindCardImplActivity.this.mBankUserInfoView;
                bankUserInfoView.hideErrorLayoutWithTag(bankUserInfoView.getTrueNameText(), BindCardImplActivity.this.mBankUserInfoView.getTrueNameText() == BindCardImplActivity.this.f26391c);
                if (!this.f26445b) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_TRUE_NAME);
                    this.f26445b = true;
                }
                BindCardImplActivity.this.z();
                BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                bindCardImplActivity.a((TextView) bindCardImplActivity.mBankUserInfoView.getTrueNameText(), BindCardImplActivity.this.mBankUserInfoView.getNameTip());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBankUserInfoView.getTrueNameText().setOnMyFocusChangeListener(this);
        this.mBankUserInfoView.getIdEditText().addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.31

            /* renamed from: b  reason: collision with root package name */
            public boolean f26447b = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (BindCardImplActivity.this.mBankUserInfoView.getIdCardFromNet()) {
                    BindCardImplActivity.this.mBankUserInfoView.setIdCardFromNet(false);
                    BindCardImplActivity.this.mBankUserInfoView.getIdEditText().setText("");
                }
                BindCardImplActivity.this.mBankUserInfoView.setIdTipRedColor(false);
                BankUserInfoView bankUserInfoView = BindCardImplActivity.this.mBankUserInfoView;
                bankUserInfoView.hideErrorLayoutWithTag(bankUserInfoView.getIdEditText(), BindCardImplActivity.this.mBankUserInfoView.getIdEditText() == BindCardImplActivity.this.f26391c);
                if (!this.f26447b) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_ID_CARD);
                    this.f26447b = true;
                }
                BindCardImplActivity.this.z();
                BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                bindCardImplActivity.a((TextView) bindCardImplActivity.mBankUserInfoView.getIdEditText(), BindCardImplActivity.this.mBankUserInfoView.getIdTip());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBankUserInfoView.getIdEditText().setOnMyFocusChangeListener(this);
        this.mBankUserInfoView.getMobileEditText().addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.32

            /* renamed from: b  reason: collision with root package name */
            public boolean f26449b = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (BindCardImplActivity.this.mBankUserInfoView.getMobileFromNet()) {
                    BindCardImplActivity.this.mBankUserInfoView.setMoblieFromNet(false);
                    BindCardImplActivity.this.mBankUserInfoView.getMobileEditText().setText("");
                }
                BindCardImplActivity.this.mBankUserInfoView.setMobileRedColor(false);
                BankUserInfoView bankUserInfoView = BindCardImplActivity.this.mBankUserInfoView;
                bankUserInfoView.hideErrorLayoutWithTag(bankUserInfoView.getMobileEditText(), BindCardImplActivity.this.mBankUserInfoView.getMobileEditText() == BindCardImplActivity.this.f26391c);
                if (!this.f26449b) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_MOBILE_NO);
                    this.f26449b = true;
                }
                BindCardImplActivity.this.z();
                BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                bindCardImplActivity.a((TextView) bindCardImplActivity.mBankUserInfoView.getMobileEditText(), BindCardImplActivity.this.mBankUserInfoView.getMobileTip());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBankUserInfoView.getMobileEditText().setOnMyFocusChangeListener(this);
        a((TextView) this.mBankUserInfoView.getTrueNameText(), this.mBankUserInfoView.getNameTip());
        a((TextView) this.mBankUserInfoView.getIdEditText(), this.mBankUserInfoView.getIdTip());
        a((TextView) this.mBankUserInfoView.getMobileEditText(), this.mBankUserInfoView.getMobileTip());
    }

    private void i() {
        this.mBankCvv2InfoView.getDateInputView().addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.33

            /* renamed from: a  reason: collision with root package name */
            public boolean f26450a = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                BindCardImplActivity.this.mBankCvv2InfoView.setValidDateRedColor(false);
                BankCvv2InfoView bankCvv2InfoView = BindCardImplActivity.this.mBankCvv2InfoView;
                bankCvv2InfoView.hideErrorLayoutWithTag(bankCvv2InfoView.getDateInputView(), BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView() == BindCardImplActivity.this.f26391c);
                if (!this.f26450a) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_DATA);
                    this.f26450a = true;
                }
                String obj = BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().getText().toString();
                if (BindCardImplActivity.this.x.toString().equals(obj)) {
                    BindCardImplActivity.this.z();
                    BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                    bindCardImplActivity.a((TextView) bindCardImplActivity.mBankCvv2InfoView.getDateInputView(), BindCardImplActivity.this.mBankCvv2InfoView.getDateTip());
                    if (BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().getText().toString().length() == 5) {
                        BindCardImplActivity bindCardImplActivity2 = BindCardImplActivity.this;
                        bindCardImplActivity2.a((View) bindCardImplActivity2.mBankCvv2InfoView.getDateInputView(), 0, true);
                        return;
                    }
                    return;
                }
                BindCardImplActivity.this.x.delete(0, BindCardImplActivity.this.x.length());
                BindCardImplActivity.this.x.append(obj.replace("/", ""));
                if (BindCardImplActivity.this.x.length() > 2) {
                    BindCardImplActivity.this.x.insert(2, "/");
                }
                BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().setText(BindCardImplActivity.this.x);
                BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().setSelection(BindCardImplActivity.this.x.length());
                BindCardImplActivity.this.z();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBankCvv2InfoView.getDateInputView().setOnMyFocusChangeListener(this);
        this.mBankCvv2InfoView.getCvv2InputView().addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.2

            /* renamed from: a  reason: collision with root package name */
            public boolean f26417a = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                BindCardImplActivity.this.mBankCvv2InfoView.setCNN2RedColor(false);
                BankCvv2InfoView bankCvv2InfoView = BindCardImplActivity.this.mBankCvv2InfoView;
                bankCvv2InfoView.hideErrorLayoutWithTag(bankCvv2InfoView.getCvv2InputView(), BindCardImplActivity.this.mBankCvv2InfoView.getCvv2InputView() == BindCardImplActivity.this.f26391c);
                if (!this.f26417a) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_CVV2);
                    this.f26417a = true;
                }
                BindCardImplActivity.this.z();
                BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                bindCardImplActivity.a((TextView) bindCardImplActivity.mBankCvv2InfoView.getCvv2InputView(), BindCardImplActivity.this.mBankCvv2InfoView.getCvv2Tip());
                if (BindCardImplActivity.this.mBankCvv2InfoView.getCvv2InputView().getText().toString().length() == 3) {
                    BindCardImplActivity bindCardImplActivity2 = BindCardImplActivity.this;
                    bindCardImplActivity2.a((View) bindCardImplActivity2.mBankCvv2InfoView.getCvv2InputView(), 1, true);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBankCvv2InfoView.getCvv2InputView().setOnMyFocusChangeListener(this);
        a((TextView) this.mBankCvv2InfoView.getCvv2InputView(), this.mBankCvv2InfoView.getCvv2Tip());
        a((TextView) this.mBankCvv2InfoView.getDateInputView(), this.mBankCvv2InfoView.getDateTip());
    }

    private boolean j() {
        return (this.f26396i.getCardNoView().getVisibility() == 0 && this.f26396i.getCardNoView().isEnabled() && this.f26396i.getCardNoView().getRealText().length() < 10) ? false : true;
    }

    private boolean k() {
        return (m() || n() || o()) ? false : true;
    }

    private boolean l() {
        return (r() || p()) ? false : true;
    }

    private boolean m() {
        return this.mBindCardController.j() && this.mBankUserInfoView.getTrueNameText().isEnabled() && this.mBankUserInfoView.getTrueNameText().getText().toString().trim().length() < 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, View view2) {
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        view2.setDrawingCacheEnabled(true);
        Bitmap drawingCache2 = view2.getDrawingCache();
        final ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(drawingCache);
        final ImageView imageView2 = new ImageView(this);
        imageView2.setImageBitmap(drawingCache2);
        this.f26390b.addView(imageView, new LinearLayout.LayoutParams(-1, -2));
        this.f26390b.addView(imageView2, new LinearLayout.LayoutParams(-1, -2));
        this.z.post(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.12
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) imageView.getParent();
                viewGroup.getTop();
                viewGroup.getBottom();
                final int bottom = imageView.getBottom();
                final int height = viewGroup.getHeight() - imageView2.getTop();
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                ofFloat.setDuration(500L).setInterpolator(new LinearInterpolator());
                ofFloat.start();
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.12.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        ViewHelper.setTranslationY(imageView, (-bottom) * floatValue);
                        ViewHelper.setTranslationY(imageView2, height * floatValue);
                        if (floatValue <= 0.0f) {
                            BindCardImplActivity.this.initSafeKeyBoard();
                            BindCardImplActivity.this.f26390b.setVisibility(8);
                            BindCardImplActivity.this.f26396i.getCardNoView().clearFocus();
                            BindCardImplActivity.this.f26396i.getCardNoView().requestFocus();
                        }
                    }
                });
            }
        });
    }

    private void a() {
        f();
        e();
        if (!this.y) {
            initSafeKeyBoard();
        }
        if ((this.mBindCardController instanceof g) && !this.f26396i.getCardNoView().isEnabled() && getCurrentStep() == 0) {
            this.mScrollView.setBackgroundColor(ResUtils.getColor(this.mAct, "wallet_base_whiteColor"));
            b();
        }
    }

    private void b(String str) {
        if (this.F.equals(str)) {
            return;
        }
        this.F = str;
        updateBankTitleInfo(null, false);
        this.mBindCardController.a(str);
    }

    private void a(final View view, final View view2) {
        this.y = true;
        this.z = new a(this);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f26390b = linearLayout;
        linearLayout.setOrientation(1);
        this.f26390b.setBackgroundResource(ResUtils.color(this, "wallet_base_window_bg"));
        ((ViewGroup) findViewById(16908290)).addView(this.f26390b, new FrameLayout.LayoutParams(-1, -1));
        this.z.post(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.1
            @Override // java.lang.Runnable
            public void run() {
                BindCardImplActivity.this.b(view, view2);
            }
        });
    }

    private void a(b bVar) {
        if (bVar != null) {
            BankCvv2InfoView bankCvv2InfoView = this.mBankCvv2InfoView;
            if (bankCvv2InfoView != null) {
                bankCvv2InfoView.getCvv2InputView().setText(bVar.f26461b);
                this.mBankCvv2InfoView.getDateInputView().setText(bVar.f26462c);
            }
            BankUserInfoView bankUserInfoView = this.mBankUserInfoView;
            if (bankUserInfoView != null) {
                bankUserInfoView.getTrueNameText().setText(bVar.f26460a);
                this.mBankUserInfoView.getIdEditText().setText(bVar.f26463d);
                this.mBankUserInfoView.getMobileEditText().setText(bVar.f26464e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final TextView textView, ImageView imageView) {
        imageView.setVisibility(0);
        if (textView.getText().toString().length() == 0) {
            imageView.setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            AccessibilityUtils.setContentDescription(imageView, "预留手机号说明");
            imageView.setOnClickListener(this);
            if (imageView == this.mBankUserInfoView.getIdTip()) {
                imageView.setVisibility(4);
            }
        } else if (textView.isEnabled()) {
            imageView.setImageResource(ResUtils.drawable(getActivity(), "wallet_base_delete"));
            AccessibilityUtils.setContentDescription(imageView, "清除");
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    textView.setText("");
                    textView.requestFocus();
                }
            });
        } else {
            imageView.setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            AccessibilityUtils.setContentDescription(imageView, "预留手机号说明");
            imageView.setOnClickListener(this);
            if (imageView == this.mBankUserInfoView.getIdTip()) {
                imageView.setVisibility(4);
            }
        }
    }

    private void a(View view, boolean z) {
        if (view == this.mBankCvv2InfoView.getCvv2InputView()) {
            int length = ((SafeKeyBoardEditText) view).getText().toString().length();
            if (!z) {
                this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
                return;
            }
            this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, true);
            if (length == 0) {
                this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
                return;
            }
            this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_delete"));
            this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BindCardImplActivity.this.mBankCvv2InfoView.getCvv2InputView().setText("");
                    BindCardImplActivity.this.mBankCvv2InfoView.getCvv2InputView().requestFocus();
                }
            });
        } else if (view == this.mBankCvv2InfoView.getDateInputView()) {
            int length2 = ((SafeKeyBoardEditText) view).getText().toString().length();
            if (!z) {
                this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
                return;
            }
            this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, true);
            if (length2 == 0) {
                this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
                return;
            }
            this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_delete"));
            this.mBankCvv2InfoView.getDateTip().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().setText("");
                    BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().requestFocus();
                }
            });
        } else if (view == this.mBankUserInfoView.getTrueNameText()) {
            int length3 = ((EditText) view).getText().toString().length();
            if (!z) {
                this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getNameTip().setOnClickListener(this);
                return;
            }
            this.mBankUserInfoView.hideErrorLayoutWithTag(view, true);
            if (length3 == 0) {
                this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getNameTip().setOnClickListener(this);
                return;
            }
            this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_delete"));
            this.mBankUserInfoView.getNameTip().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BindCardImplActivity.this.mBankUserInfoView.getTrueNameText().setText("");
                    BindCardImplActivity.this.mBankUserInfoView.getTrueNameText().requestFocus();
                }
            });
        } else if (view == this.mBankUserInfoView.getMobileEditText()) {
            int length4 = ((DivisionEditText) view).getText().toString().length();
            if (!z) {
                this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
                return;
            }
            this.mBankUserInfoView.hideErrorLayoutWithTag(view, true);
            if (length4 == 0) {
                this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
                return;
            }
            this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_delete"));
            this.mBankUserInfoView.getMobileTip().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BindCardImplActivity.this.mBankUserInfoView.getMobileEditText().setText("");
                    BindCardImplActivity.this.mBankUserInfoView.getMobileEditText().requestFocus();
                }
            });
        } else if (view == this.mBankUserInfoView.getIdEditText()) {
            int length5 = ((SafeKeyBoardEditText) view).getText().toString().length();
            if (!z) {
                this.mBankUserInfoView.getIdTip().setVisibility(4);
                return;
            }
            this.mBankUserInfoView.hideErrorLayoutWithTag(view, true);
            if (length5 == 0) {
                this.mBankUserInfoView.getIdTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getIdTip().setOnClickListener(this);
                this.mBankUserInfoView.getIdTip().setVisibility(4);
                return;
            }
            this.mBankUserInfoView.getIdTip().setVisibility(0);
            this.mBankUserInfoView.getIdTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_delete"));
            this.mBankUserInfoView.getIdTip().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BindCardImplActivity.this.mBankUserInfoView.getIdEditText().setText("");
                    BindCardImplActivity.this.mBankUserInfoView.getIdEditText().requestFocus();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == this.mBankCvv2InfoView.getCvv2InputView()) {
            if (!TextUtils.isEmpty(this.mBankCvv2InfoView.getCvv2InputView().getText().toString()) && r()) {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.ERROR_SHOW_INPUT_ERROR, ResUtils.getString(getActivity(), "ebpay_bank_cvv2_errortip"));
                this.mBankCvv2InfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_bank_cvv2"), ResUtils.getString(getActivity(), "ebpay_bank_cvv2_errortip"), view);
                return;
            }
            this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, false);
        } else if (view == this.mBankCvv2InfoView.getDateInputView()) {
            if (!TextUtils.isEmpty(this.mBankCvv2InfoView.getDateInputView().getText().toString()) && p()) {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.ERROR_SHOW_INPUT_ERROR, ResUtils.getString(getActivity(), "ebpay_valid_date_errortip"));
                this.mBankCvv2InfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_valid_date"), ResUtils.getString(getActivity(), "ebpay_valid_date_errortip"), view);
                return;
            }
            this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, false);
        } else if (view == this.mBankUserInfoView.getTrueNameText()) {
            if (!TextUtils.isEmpty(this.mBankUserInfoView.getTrueNameText().getText().toString()) && m()) {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.ERROR_SHOW_INPUT_ERROR, ResUtils.getString(getActivity(), "ebpay_name_error_tip"));
                this.mBankUserInfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_name"), ResUtils.getString(getActivity(), "ebpay_name_error_tip"), view);
                return;
            }
            this.mBankUserInfoView.hideErrorLayoutWithTag(view, false);
        } else if (view == this.mBankUserInfoView.getIdEditText()) {
            if (!TextUtils.isEmpty(this.mBankUserInfoView.getIdEditText().getText()) && n()) {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.ERROR_SHOW_INPUT_ERROR, ResUtils.getString(getActivity(), "ebpay_id_card_errortip"));
                BankUserInfoView bankUserInfoView = this.mBankUserInfoView;
                GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.G;
                bankUserInfoView.showErrorLayout((certificateTypeInfo == null || TextUtils.isEmpty(certificateTypeInfo.description)) ? ResUtils.getString(getActivity(), "ebpay_id_card") : this.G.description, ResUtils.getString(getActivity(), "ebpay_id_card_errortip"), view);
                return;
            }
            this.mBankUserInfoView.hideErrorLayoutWithTag(view, false);
        } else if (view == this.mBankUserInfoView.getMobileEditText()) {
            if (!TextUtils.isEmpty(this.mBankUserInfoView.getMobileEditText().getRealText()) && o()) {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.ERROR_SHOW_INPUT_ERROR, ResUtils.getString(getActivity(), "ebpay_bank_bind_phone_errortip"));
                this.mBankUserInfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_bank_bind_phone"), ResUtils.getString(getActivity(), "ebpay_bank_bind_phone_errortip"), view);
                return;
            }
            this.mBankUserInfoView.hideErrorLayoutWithTag(view, false);
        }
    }

    private void a(String str) {
        PayStatisticsUtil.onEvent(StatServiceEvent.NEXT_FIRST);
        if (isBindInvalid()) {
            return;
        }
        WalletGlobalUtils.safeShowDialog(this, -2, "");
        c();
        this.mBindReq.setChannelNo("");
        this.mBindReq.setSubBankCode(str);
        this.mBindCardController.d(this.E, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GetCardInfoResponse getCardInfoResponse) {
        if (getCardInfoResponse == null) {
            return;
        }
        GetCardInfoResponse.CardInfo cardInfo = getCardInfoResponse.card_info;
        if (cardInfo != null && !TextUtils.isEmpty(cardInfo.bank_no)) {
            this.mBindReq.mBankNo = getCardInfoResponse.card_info.bank_no;
        }
        this.mBindReq.setmBankInfo(getCardInfoResponse);
        this.mBindReq.setmBankCard(this.E);
        this.mBindCardController.a();
        this.s.setVisibility(8);
        this.o.setVisibility(8);
    }

    private void a(int i2) {
        if (i2 == 0) {
            this.mBankCvv2InfoView.getDateTip().setVisibility(0);
            this.mBankUserInfoView.getNameTip().setVisibility(0);
            this.mBankUserInfoView.getMobileTip().setVisibility(0);
            this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
            this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getNameTip().setOnClickListener(this);
            this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
        } else if (i2 == 1) {
            this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
            this.mBankUserInfoView.getNameTip().setVisibility(0);
            this.mBankUserInfoView.getMobileTip().setVisibility(0);
            this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
            this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getNameTip().setOnClickListener(this);
            this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
        } else if (i2 == 2) {
            this.mBankCvv2InfoView.getDateTip().setVisibility(0);
            this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
            this.mBankUserInfoView.getMobileTip().setVisibility(0);
            this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
            this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
            this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            this.mBankCvv2InfoView.getDateTip().setVisibility(0);
            this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
            this.mBankUserInfoView.getNameTip().setVisibility(0);
            this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
            this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
            this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getNameTip().setOnClickListener(this);
        } else {
            this.mBankCvv2InfoView.getDateTip().setVisibility(0);
            this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
            this.mBankUserInfoView.getNameTip().setVisibility(0);
            this.mBankUserInfoView.getMobileTip().setVisibility(0);
            this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
            this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
            this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
            this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getNameTip().setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GetCardInfoResponse.CertificateTypeInfo[] a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        if (certificateTypeInfoArr != null) {
            for (GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo2 : certificateTypeInfoArr) {
                if (certificateTypeInfo != null) {
                    if (certificateTypeInfo.type.equals(certificateTypeInfo2.type)) {
                        certificateTypeInfo2.setDisplay(true);
                    } else {
                        certificateTypeInfo2.setDisplay(false);
                    }
                } else {
                    certificateTypeInfo2.setDisplay(false);
                }
            }
        }
        return certificateTypeInfoArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest == null) {
            return;
        }
        if (z) {
            bindFastRequest.setmBankCard(this.E);
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putBoolean("isSelectBank", z);
        Intent intent = new Intent(getActivity(), SignChannelListActivity.class);
        intent.putExtras(extras);
        startActivityForResult(intent, BeanConstants.REQUEST_CODE_SIGN_CHANNEL_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i2, boolean z) {
        boolean[] zArr = new boolean[5];
        boolean z2 = true;
        zArr[0] = this.mBindCardController.l() && this.mBankCvv2InfoView.getDateInputView().isEnabled();
        zArr[1] = this.mBindCardController.k() && this.mBankCvv2InfoView.getCvv2InputView().isEnabled();
        zArr[2] = this.mBindCardController.j() && this.mBankUserInfoView.getTrueNameText().isEnabled();
        zArr[3] = this.mBindCardController.m() && this.mBankUserInfoView.getIdEditText().isEnabled();
        zArr[4] = this.mBindCardController.n() && this.mBankUserInfoView.getMobileEditText().isEnabled();
        View a2 = a(i2, zArr);
        if (((a2 instanceof TextView) && TextUtils.isEmpty(((TextView) a2).getText())) ? false : false) {
            a2.requestFocus();
            if (a2 == this.mBankUserInfoView.getTrueNameText()) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.22
                    @Override // java.lang.Runnable
                    public void run() {
                        GlobalUtils.showInputMethod(BindCardImplActivity.this.getActivity(), BindCardImplActivity.this.mBankUserInfoView.getTrueNameText());
                    }
                }, 150L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        CardData.BondCard bondCard;
        if (isShowWithHalfScreeen()) {
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = {this.f26396i.getCardNoView(), this.mBankCvv2InfoView.getDateInputView(), this.mBankCvv2InfoView.getCvv2InputView(), this.mBankUserInfoView.getIdEditText(), this.mBankUserInfoView.getMobileEditText()};
            SafeKeyBoardEditText.CheckFunc checkFunc = new SafeKeyBoardEditText.CheckFunc() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.24
                @Override // com.baidu.wallet.base.widget.SafeKeyBoardEditText.CheckFunc
                public boolean check(String str) {
                    return BindCardImplActivity.this.y();
                }
            };
            boolean z6 = false;
            for (int i2 = 0; i2 < 5; i2++) {
                SafeKeyBoardEditText safeKeyBoardEditText = safeKeyBoardEditTextArr[i2];
                if (safeKeyBoardEditText.isShown()) {
                    safeKeyBoardEditText.setConfirmListener(this);
                    safeKeyBoardEditText.setCheckFunc(checkFunc);
                    if (!z6) {
                        SafeScrollView safeScrollView = this.mScrollView;
                        safeScrollView.showKeyBoard(safeScrollView, safeKeyBoardEditText, (View) safeKeyBoardEditText.getTag());
                        z6 = true;
                    }
                }
            }
            if (this.mBankUserInfoView.getIdEditText().isShown()) {
                this.mBankUserInfoView.getIdEditText().setUseKeyX(true);
            }
            BindFastRequest bindFastRequest = this.mBindReq;
            if (bindFastRequest != null && (bondCard = bindFastRequest.mBondCard) != null && bondCard.bank_code != null) {
                com.baidu.wallet.paysdk.ui.widget.a.a(this.C, "请完善", bondCard.getCardDesc(this.mAct, false), "的信息后继续支付");
            } else {
                com.baidu.wallet.paysdk.ui.widget.a.a(this.C, ResUtils.getString(this.mAct, "ebpay_title_complete_fixmsg"), null, null);
            }
        }
        this.f26396i.getCardNoView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, this.f26396i.getCardNoView(), false);
        if (z2 && this.mBankCvv2InfoView.getDateInputView().isEnabled()) {
            this.mBankCvv2InfoView.getDateInputView().setOnMyFocusChangeListener(this);
            this.mBankCvv2InfoView.getDateInputView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, (View) this.mBankCvv2InfoView.getDateInputView().getTag(), false);
            this.mBankCvv2InfoView.getDateInputView().requestFocus();
        }
        if (z && this.mBankCvv2InfoView.getCvv2InputView().isEnabled()) {
            this.mBankCvv2InfoView.getCvv2InputView().setOnMyFocusChangeListener(this);
            this.mBankCvv2InfoView.getCvv2InputView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, this.mBankCvv2InfoView.getCvv2InputView(), false);
            if (!z2) {
                this.mBankCvv2InfoView.getCvv2InputView().requestFocus();
            }
        }
        if (z3 && this.mBankUserInfoView.getTrueNameText().isEnabled() && !z && !z2) {
            try {
                this.mBankUserInfoView.getTrueNameText().setSelection(this.mBankUserInfoView.getTrueNameText().getText().length());
            } catch (Exception unused) {
            }
            this.mBankUserInfoView.getTrueNameText().requestFocus();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.25
                @Override // java.lang.Runnable
                public void run() {
                    GlobalUtils.showInputMethod(BindCardImplActivity.this.getActivity(), BindCardImplActivity.this.mBankUserInfoView.getTrueNameText());
                }
            }, 150L);
        }
        if (z4 && this.mBankUserInfoView.getIdEditText().isEnabled()) {
            this.mBankUserInfoView.getIdEditText().setOnMyFocusChangeListener(this);
            this.mBankUserInfoView.getIdEditText().initSafeKeyBoardParams(this.mRootView, this.mScrollView, a(3, z, z2, z3, z4, z5), false);
            if (!z3 && !z2 && !z) {
                try {
                    this.mBankUserInfoView.getIdEditText().setSelection(this.mBankUserInfoView.getIdEditText().getText().length());
                } catch (Exception unused2) {
                }
                this.mBankUserInfoView.getIdEditText().requestFocus();
            }
        }
        if (z5 && this.mBankUserInfoView.getMobileEditText().isEnabled()) {
            this.mBankUserInfoView.getMobileEditText().setOnMyFocusChangeListener(this);
            this.mBankUserInfoView.getMobileEditText().initSafeKeyBoardParams(this.mRootView, this.mScrollView, a(4, z, z2, z3, z4, z5), false);
            if (z3 || z2 || z) {
                return;
            }
            if (z4 && this.mBankUserInfoView.getIdEditText().isEnabled()) {
                return;
            }
            try {
                this.mBankUserInfoView.getMobileEditText().setSelection(this.mBankUserInfoView.getMobileEditText().getText().length());
            } catch (Exception unused3) {
            }
            this.mBankUserInfoView.getMobileEditText().requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(int i2, boolean... zArr) {
        if (i2 >= zArr.length) {
            return this.n;
        }
        for (int i3 = i2 + 1; i3 < zArr.length; i3++) {
            if (zArr[i3]) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    return this.n;
                                }
                                return this.mBankUserInfoView.getMobileEditText();
                            }
                            return this.mBankUserInfoView.getIdEditText();
                        }
                        return this.mBankUserInfoView.getTrueNameText();
                    }
                    return this.mBankCvv2InfoView.getCvv2InputView();
                }
                return this.mBankCvv2InfoView.getDateInputView();
            }
        }
        return this.n;
    }
}
