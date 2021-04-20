package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.beans.d;
import com.baidu.wallet.paysdk.banksign.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.banksign.datamodel.PollingResponse;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
/* loaded from: classes5.dex */
public class BusinessSignedGuideActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static final int DLG_BANK_SIGN_GUIDE = 64;
    public static final int SIGN_STATE_1 = 1;
    public static final int SIGN_STATE_2 = 2;
    public static final int SIGN_STATE_3 = 3;
    public static final int SIGN_STATE_4 = 4;
    public static final int SIGN_STATE_5 = 5;
    public static final int SIGN_STATE_6 = 6;
    public static final String TAG = "BusinessSignedGuideActivity";

    /* renamed from: a  reason: collision with root package name */
    public WalletBaseButtonWithImage f25689a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f25690b;

    /* renamed from: f  reason: collision with root package name */
    public QueryResponse f25693f;

    /* renamed from: c  reason: collision with root package name */
    public Handler f25691c = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public boolean f25692e = false;

    /* renamed from: g  reason: collision with root package name */
    public String f25694g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f25695h = false;
    public int i = 0;

    private void d() {
        int i;
        if (TextUtils.isEmpty(this.f25693f.toast_msg) || !this.f25694g.equals("pay")) {
            i = 0;
        } else {
            GlobalUtils.toast(this, this.f25693f.toast_msg);
            i = 2000;
        }
        this.f25691c.postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.8
            @Override // java.lang.Runnable
            public void run() {
                BusinessSignedGuideActivity.this.e();
            }
        }, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String str = this.f25693f.form_data;
        com.baidu.wallet.paysdk.banksign.a.a.a().a(str == null ? null : str.getBytes());
        com.baidu.wallet.paysdk.banksign.a.a.a().d(this.f25693f.form_url);
        com.baidu.wallet.paysdk.banksign.a.a.a().e(this.f25693f.webview_title);
        this.i = 0;
        this.f25692e = true;
        BankSignPayFlow a2 = BankSignPayFlow.a();
        a2.a(BankSignPayFlow.Action.JumpResign);
        a2.a(this.mAct);
        this.f25691c.post(this.f25690b);
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_half_sign_guide_activity"), null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void bindcard() {
        com.baidu.wallet.paysdk.banksign.beans.a aVar = (com.baidu.wallet.paysdk.banksign.beans.a) BankSignFactory.getInstance().getBean((Context) this.mAct, BankSignFactory.BEAN_ID_BIND_CARD, TAG);
        aVar.setResponseCallback(this);
        aVar.execBean();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void handleErrorContent() {
        WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
        super.handleErrorContent();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        if (i == 769) {
            return;
        }
        if (i == 770) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            GlobalUtils.toast(this, str);
        } else if (i == 771) {
            if (i2 != 0 && !TextUtils.isEmpty(str)) {
                GlobalUtils.toast(this, str, 1000);
            }
            if (PayDataCache.getInstance().isFromPreCashier()) {
                finishWithoutAnim();
                return;
            }
            BankSignPayFlow a2 = BankSignPayFlow.a();
            a2.a(BankSignPayFlow.Action.Cancel);
            a2.a(this.mAct);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        BindCardResponse bindCardResponse;
        int i2 = 2000;
        boolean z = true;
        if (i == 769) {
            PollingResponse pollingResponse = (PollingResponse) obj;
            Handler handler = this.f25691c;
            if (handler == null || pollingResponse == null || pollingResponse.has_sign_result != 1) {
                return;
            }
            handler.removeCallbacks(this.f25690b);
            if (!TextUtils.isEmpty(pollingResponse.toast_msg)) {
                GlobalUtils.toast(this.mAct, pollingResponse.toast_msg, 2000);
            }
            this.f25691c.postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    BaseActivity.clearTasksTopOf(BusinessSignedGuideActivity.this);
                }
            }, 5000L);
        } else if (i == 770) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            QueryResponse queryResponse = (QueryResponse) obj;
            this.f25693f = queryResponse;
            if (queryResponse != null) {
                int i3 = this.i + 1;
                this.i = i3;
                int i4 = queryResponse.sign_state;
                if (i3 == 1 && i4 == 2) {
                    z = false;
                }
                if (!TextUtils.isEmpty(this.f25693f.agreement_trans_id) && z) {
                    com.baidu.wallet.paysdk.banksign.a.a.a().f(this.f25693f.agreement_trans_id);
                }
                switch (i4) {
                    case 1:
                        if (this.i == 2) {
                            d();
                            return;
                        }
                        BankSignPayFlow a2 = BankSignPayFlow.a();
                        a2.a(BankSignPayFlow.Action.FirstFail);
                        a2.a(this.mAct);
                        return;
                    case 2:
                        if (this.i == 2) {
                            d();
                            return;
                        } else if (this.f25693f.isGuidanceAvilable()) {
                            WalletGlobalUtils.safeShowDialog(this, 64, "");
                            return;
                        } else {
                            return;
                        }
                    case 3:
                    case 5:
                    case 6:
                        if (this.i != 2 || TextUtils.isEmpty(this.f25693f.toast_msg)) {
                            i2 = 0;
                        } else {
                            GlobalUtils.toast(this, this.f25693f.toast_msg);
                        }
                        this.f25691c.postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (BusinessSignedGuideActivity.this.f25693f.isGuidanceAvilable()) {
                                    WalletGlobalUtils.safeShowDialog(BusinessSignedGuideActivity.this, 64, "");
                                }
                            }
                        }, i2);
                        return;
                    case 4:
                        if (this.i == 2 && !TextUtils.isEmpty(this.f25693f.toast_msg) && this.f25694g.equals(QueryResponse.Options.JUMP_RESIGN)) {
                            GlobalUtils.toast(this, this.f25693f.toast_msg);
                        } else {
                            i2 = 0;
                        }
                        this.f25691c.postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.4
                            @Override // java.lang.Runnable
                            public void run() {
                                BankSignPayFlow a3 = BankSignPayFlow.a();
                                a3.a(BankSignPayFlow.Action.Pay);
                                a3.a(BusinessSignedGuideActivity.this.mAct);
                                BusinessSignedGuideActivity.this.finishWithoutAnim();
                            }
                        }, i2);
                        return;
                    default:
                        return;
                }
            }
        } else if (i != 771 || (bindCardResponse = (BindCardResponse) obj) == null || TextUtils.isEmpty(bindCardResponse.sign_card_no)) {
        } else {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                String g2 = com.baidu.wallet.paysdk.banksign.a.a.a().g(bindCardResponse.sign_card_no);
                if (!TextUtils.isEmpty(g2)) {
                    PayDataCache.getInstance().setOrderExtraInfo(g2);
                }
            }
            BankSignPayFlow a3 = BankSignPayFlow.a();
            a3.a(BankSignPayFlow.Action.Cancel);
            a3.a(this.mAct);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view != this.f25689a || CheckUtils.isFastDoubleClick()) {
        } else {
            this.f25693f = null;
            BankSignPayFlow a2 = BankSignPayFlow.a();
            a2.a(BankSignPayFlow.Action.JumpResign);
            a2.a(this.mAct);
            this.f25692e = true;
            this.f25689a.setEnabled(false);
            b();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f25695h = getIntent().getBooleanExtra("isActiveSign", false);
        a();
        showLikeDismissLadingPage();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (64 == i) {
            return new PromptMultiBtnDialog(this);
        }
        return super.onCreateDialog(i);
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.f25691c;
        if (handler != null) {
            handler.removeCallbacks(this.f25690b);
        }
        com.baidu.wallet.paysdk.banksign.a.a.a().m();
        BeanManager.getInstance().removeAllBeans(TAG);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        if (64 == i) {
            a(dialog);
        } else {
            super.onPrepareDialog(i, dialog);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f25692e) {
            Handler handler = this.f25691c;
            if (handler != null) {
                handler.removeCallbacks(this.f25690b);
            }
            c();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i) {
    }

    private void b() {
        final com.baidu.wallet.paysdk.banksign.beans.c cVar = (com.baidu.wallet.paysdk.banksign.beans.c) BankSignFactory.getInstance().getBean((Context) getActivity(), BankSignFactory.BEAN_ID_POLLING, TAG);
        Runnable runnable = new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.setResponseCallback(BusinessSignedGuideActivity.this);
                cVar.execBean();
                BusinessSignedGuideActivity.this.f25691c.postDelayed(this, 3000L);
            }
        };
        this.f25690b = runnable;
        this.f25691c.post(runnable);
    }

    private void c() {
        this.f25692e = false;
        WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
        d dVar = (d) BankSignFactory.getInstance().getBean((Context) getActivity(), BankSignFactory.BEAN_ID_QUERY, TAG);
        if (!this.f25695h) {
            com.baidu.wallet.paysdk.banksign.a.a.a().a("");
            dVar.setResponseCallback(this);
            dVar.execBean();
            return;
        }
        dVar.execBean();
        finishWithoutAnim();
    }

    private void a() {
        this.mActionBar.setVisibility(0);
        this.mLeftImg.setOnClickListener(this);
        WalletBaseButtonWithImage walletBaseButtonWithImage = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getActivity(), "bd_wallet_sign_btn"));
        this.f25689a = walletBaseButtonWithImage;
        if (this.f25695h) {
            walletBaseButtonWithImage.setText(ResUtils.getString(getActivity(), "dxmpay_banksign_guide_sgin_btn"));
        } else {
            walletBaseButtonWithImage.setText(ResUtils.getString(getActivity(), "dxmpay_banksign_guide_pay_btn"));
        }
        this.f25689a.setDrawableLeftVisible(false);
        this.f25689a.setOnClickListener(this);
    }

    private void a(Dialog dialog) {
        PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
        QueryResponse queryResponse = this.f25693f;
        if (queryResponse == null) {
            return;
        }
        if (!TextUtils.isEmpty(queryResponse.dialog_title)) {
            promptMultiBtnDialog.setTitleMessage(this.f25693f.dialog_title);
        } else {
            promptMultiBtnDialog.setTitleMessage(ResUtils.getString(this.mAct, "dxmpay_banksign_dialog_title"));
        }
        if (!TextUtils.isEmpty(this.f25693f.dialog_hint)) {
            promptMultiBtnDialog.setMessage(this.f25693f.dialog_hint);
        }
        promptMultiBtnDialog.setFirstBtn(this.f25693f.dialog_options[0].msg, new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletGlobalUtils.safeDismissDialog(BusinessSignedGuideActivity.this, 64);
                BusinessSignedGuideActivity businessSignedGuideActivity = BusinessSignedGuideActivity.this;
                businessSignedGuideActivity.a(businessSignedGuideActivity.f25693f.dialog_options[0].type);
            }
        });
        promptMultiBtnDialog.setSecondBtn(this.f25693f.dialog_options[1].msg, new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletGlobalUtils.safeDismissDialog(BusinessSignedGuideActivity.this, 64);
                BusinessSignedGuideActivity businessSignedGuideActivity = BusinessSignedGuideActivity.this;
                businessSignedGuideActivity.a(businessSignedGuideActivity.f25693f.dialog_options[1].type);
            }
        });
        promptMultiBtnDialog.setThirdBtn(this.f25693f.dialog_options[2].msg, new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletGlobalUtils.safeDismissDialog(BusinessSignedGuideActivity.this, 64);
                BusinessSignedGuideActivity businessSignedGuideActivity = BusinessSignedGuideActivity.this;
                businessSignedGuideActivity.a(businessSignedGuideActivity.f25693f.dialog_options[2].type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(String str) {
        char c2;
        PayRequest payRequest;
        CardData.BondCard cardByCardNo;
        BankSignPayFlow a2 = BankSignPayFlow.a();
        this.f25694g = str;
        switch (str.hashCode()) {
            case -1367724422:
                if (str.equals(QueryResponse.Options.CANCEL)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -930533934:
                if (str.equals(QueryResponse.Options.BIND_CARD)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 110760:
                if (str.equals("pay")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1221572179:
                if (str.equals("change_paytype")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1235694497:
                if (str.equals(QueryResponse.Options.JUMP_RESIGN)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            if (this.i == 1 && this.f25693f.sign_state == 2) {
                c();
            } else {
                e();
            }
        } else if (c2 == 1) {
            if (this.i == 1 && this.f25693f.sign_state == 2) {
                c();
                return;
            }
            QueryResponse queryResponse = this.f25693f;
            if (queryResponse.sign_state == 5 && !TextUtils.isEmpty(queryResponse.sign_card_no) && (cardByCardNo = (payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).getCardByCardNo(this.f25693f.sign_card_no)) != null) {
                payRequest.mBondCard = cardByCardNo;
            }
            a2.a(BankSignPayFlow.Action.Pay);
            a2.a(this.mAct);
            finishWithoutAnim();
        } else if (c2 == 2) {
            a2.a(BankSignPayFlow.Action.Cancel);
            a2.a(this.mAct);
            finishWithoutAnim();
        } else if (c2 == 3) {
            a2.a(BankSignPayFlow.Action.ChangePayType);
            a2.a(this.mAct);
            finishWithoutAnim();
        } else if (c2 != 4) {
        } else {
            a2.a(BankSignPayFlow.Action.BindCard);
            a2.a(this.mAct);
        }
    }
}
