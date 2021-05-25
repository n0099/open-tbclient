package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.SafeKeyBoardUtil;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.j;
import com.baidu.wallet.paysdk.beans.y;
import com.baidu.wallet.paysdk.contract.a;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew;
import com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew;
/* loaded from: classes5.dex */
public class CardInfoCheckActivity extends HalfScreenBaseActivity {
    public static final String BEAN_TAG = "CardInfoCheckActivity";
    public static final String CHECK_INFO_STATE = "check_info_state";
    public static final String TAG = "CardInfoCheckActivity";

    /* renamed from: a  reason: collision with root package name */
    public a.InterfaceC0253a f25667a;

    /* renamed from: b  reason: collision with root package name */
    public a.b f25668b;

    /* renamed from: c  reason: collision with root package name */
    public int f25669c = 0;

    /* renamed from: e  reason: collision with root package name */
    public SafeKeyBoardEditText f25670e;

    /* renamed from: f  reason: collision with root package name */
    public PayRequest f25671f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f25672g;

    /* renamed from: h  reason: collision with root package name */
    public SafeScrollView f25673h;

    /* renamed from: i  reason: collision with root package name */
    public SafeKeyBoardUtil f25674i;
    public PayLoadingImageViewNew j;
    public View k;
    public SuccessImageViewNew l;
    public boolean m;

    private void e() {
        com.baidu.wallet.paysdk.beans.a aVar = (com.baidu.wallet.paysdk.beans.a) PayBeanFactory.getInstance().getBean((Context) this.mAct, 14, "CardInfoCheckActivity");
        aVar.setResponseCallback(this.mAct);
        aVar.execBean();
    }

    private void f() {
        y yVar = (y) PayBeanFactory.getInstance().getBean((Context) this.mAct, 13, "CardInfoCheckActivity");
        yVar.setResponseCallback(this.mAct);
        yVar.a(true);
        yVar.execBean();
    }

    private void g() {
        this.f25672g = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "wallet_cashdesk_card_info_check_content"));
        SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        this.f25673h = safeScrollView;
        safeScrollView.setVisibility(0);
        this.f25673h.addView(this.f25668b.a());
        PayLoadingImageViewNew payLoadingImageViewNew = (PayLoadingImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_cashier_loading_view"));
        this.j = payLoadingImageViewNew;
        payLoadingImageViewNew.setVisibility(8);
        this.l = (SuccessImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
        View findViewById = findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
        this.k = findViewById;
        findViewById.setVisibility(8);
        setSafeScrollView(this.f25673h);
        ((TextView) this.mHalfScreenContainer.findViewById(ResUtils.id(this.mAct, "bd_wallet_bind_card_title"))).setText(ResUtils.getString(getActivity(), "ebpay_title_risk_control"));
        ViewGroup viewGroup = (ViewGroup) this.mHalfScreenContainer.findViewById(ResUtils.id(this.mAct, "wallet_bind_card_subtitle"));
        CardData.BondCard bondCard = this.f25671f.mBondCard;
        if (bondCard == null) {
            com.baidu.wallet.paysdk.ui.widget.a.a(viewGroup, ResUtils.getString(this.mAct, "ebpay_title_complete_fixmsg"), null, null);
        } else {
            com.baidu.wallet.paysdk.ui.widget.a.a(viewGroup, "请完善", bondCard.getCardDesc(this.mAct, false), "的信息后继续支付");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        this.mHalfScreenContainer.removeView(this.mActionBar);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_card_info_check_layout"), null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
        this.mActionBar = findViewById(ResUtils.id(getActivity(), "ebpay_halfscreen_action_bar"));
        this.mLeftImg = (ImageView) findViewById(ResUtils.id(getActivity(), "action_bar_left_img"));
        this.mTitle = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_title"));
        this.mRightTxt = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_left_txt"));
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void handleErrorContent() {
        b();
        this.m = false;
        this.f25673h.setVisibility(0);
        super.handleErrorContent();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        b();
        this.m = false;
        this.f25673h.setVisibility(0);
        if (i2 != 263 && i2 != 13 && i2 != 14) {
            super.handleFailure(i2, i3, str);
        } else if (i3 == 5003) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_please_login"));
            AccountManager.getInstance(getActivity()).logout();
            WalletLoginHelper.getInstance().logout(false);
        } else if (i3 == -2) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
        } else if (i3 == -3) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
        } else if (i3 == -4) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
        } else if (i3 == -8) {
            WalletGlobalUtils.safeShowDialog(this, 11, "");
        } else {
            this.mDialogMsg = str;
            if (TextUtils.isEmpty(str)) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "fp_get_data_fail");
            }
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this, "fp_get_data_fail");
            }
            this.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(this, 12, "");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        super.handleResponse(i2, obj, str);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.m) {
            return;
        }
        if (PayDataCache.getInstance().isFromPreCashier()) {
            WalletGlobalUtils.safeShowDialog(this, 18, "");
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        b();
        this.m = false;
        super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        getActivity().getWindow().setSoftInputMode(2);
        this.f25671f = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        this.f25669c = extras.getInt(CHECK_INFO_STATE);
        a.b a2 = com.baidu.wallet.paysdk.ui.a.b.a().a(this.f25669c, getActivity());
        this.f25668b = a2;
        if (a2 == null) {
            finish();
            return;
        }
        a.InterfaceC0253a a3 = com.baidu.wallet.paysdk.presenter.a.b.a(this.f25669c, a2);
        this.f25667a = a3;
        if (a3 == null) {
            finish();
            return;
        }
        g();
        CardData.BondCard bondCard = this.f25671f.mBondCard;
        if (bondCard != null) {
            this.f25668b.a(bondCard.getCardDescShort());
        }
        if (bundle != null) {
            this.m = bundle.getBoolean("isloading");
            this.f25670e.setText((String) bundle.get("saveContent"));
        }
        SafeKeyBoardEditText b2 = this.f25668b.b();
        this.f25670e = b2;
        b2.setCheckFunc(new SafeKeyBoardEditText.CheckFunc() { // from class: com.baidu.wallet.paysdk.ui.CardInfoCheckActivity.1
            @Override // com.baidu.wallet.base.widget.SafeKeyBoardEditText.CheckFunc
            public boolean check(String str) {
                return CardInfoCheckActivity.this.f25667a.b(str);
            }
        });
        this.mLeftImg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.CardInfoCheckActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CardInfoCheckActivity.this.onBackPressed();
            }
        });
        this.f25670e.setConfirmListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.CardInfoCheckActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.InterfaceC0253a interfaceC0253a = CardInfoCheckActivity.this.f25667a;
                CardInfoCheckActivity cardInfoCheckActivity = CardInfoCheckActivity.this;
                if (!interfaceC0253a.a(cardInfoCheckActivity.a((CharSequence) cardInfoCheckActivity.f25670e.getEditableText().toString()))) {
                    CardInfoCheckActivity.this.f25668b.c();
                    return;
                }
                a.InterfaceC0253a interfaceC0253a2 = CardInfoCheckActivity.this.f25667a;
                CardInfoCheckActivity cardInfoCheckActivity2 = CardInfoCheckActivity.this;
                interfaceC0253a2.c(cardInfoCheckActivity2.a((CharSequence) cardInfoCheckActivity2.f25670e.getEditableText().toString()));
                CardInfoCheckActivity.this.c();
            }
        });
        SafeKeyBoardEditText safeKeyBoardEditText = this.f25670e;
        safeKeyBoardEditText.initSafeKeyBoardParams(this.f25672g, this.f25673h, safeKeyBoardEditText, false);
        SafeKeyBoardUtil safeKeyBoardUtil = new SafeKeyBoardUtil();
        this.f25674i = safeKeyBoardUtil;
        safeKeyBoardUtil.setState(SafeKeyBoardUtil.SafeKeyBoardState.CONFRIM_STATE);
        this.f25673h.setSafeKeyBoardUtil(this.f25674i);
        this.f25673h.setAlwaysShowSoftKeyBoard(true);
        this.f25670e.requestFocus();
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f25674i.hideSoftKeyBoard();
        this.f25673h.clear();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onNegativeBtnClick() {
        if (PayDataCache.getInstance().isFromPreCashier()) {
            PayCallBackManager.callBackClientCancel(this, "CardInfoCheckActivityonNegativeBtnClick().1");
        } else {
            finishWithoutAnim();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putSerializable("isloading", Boolean.valueOf(this.m));
            bundle.putString("saveContent", this.f25670e.getEditableText().toString());
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(final boolean z, final PayResultContent payResultContent, int i2) {
        b();
        this.mActionBar.setVisibility(4);
        this.f25673h.setVisibility(8);
        this.k.setVisibility(0);
        this.l.startAnimation(new SuccessImageViewNew.a() { // from class: com.baidu.wallet.paysdk.ui.CardInfoCheckActivity.4
            @Override // com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.a
            public void a() {
                if (z) {
                    CardInfoCheckActivity.this.m = false;
                    PayController.getInstance().paySucess(CardInfoCheckActivity.this, payResultContent, 1);
                    return;
                }
                CardInfoCheckActivity.this.m = false;
                PayController.getInstance().payPaying(CardInfoCheckActivity.this, payResultContent, 1);
            }
        });
    }

    private void b() {
        this.mActionBar.setVisibility(0);
        this.j.stopAnimation();
        this.j.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a();
        PayRequest.PayPrice.PayType payType = this.f25671f.getPayPrice().payType;
        if (payType == PayRequest.PayPrice.PayType.BANKCARD) {
            f();
        } else if (payType == PayRequest.PayPrice.PayType.BALANCE) {
            e();
        } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
            d();
        }
    }

    private void d() {
        j jVar = (j) PayBeanFactory.getInstance().getBean((Context) this.mAct, PayBeanFactory.BEAN_ID_CREDIT_PAY, "CardInfoCheckActivity");
        jVar.setResponseCallback(this.mAct);
        jVar.execBean();
    }

    private void a() {
        this.mActionBar.setVisibility(4);
        this.m = true;
        this.f25673h.setVisibility(8);
        this.f25673h.dismissKeyBoard(this.f25670e);
        this.j.setVisibility(0);
        this.j.startAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) ? charSequence.toString().replace(" ", "").trim() : "";
    }
}
