package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.OrderConfirmation;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.presenter.d;
import com.baidu.wallet.paysdk.presenter.e;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class AuthorizeSignActivity extends PayBaseBeanActivity implements View.OnClickListener {
    public static final String AUTH_SIGN_TYPE = "AuthorizeSignType";
    public static final int BUTTON_STATE_AUTH = 3;
    public static final int BUTTON_STATE_AUTH_NEWCARD = 4;
    public static final int BUTTON_STATE_NEWCARD = 2;
    public static final int BUTTON_STATE_NEXT = 1;

    /* renamed from: a  reason: collision with root package name */
    public e f25502a;

    /* renamed from: b  reason: collision with root package name */
    public AuthorizeInfoView f25503b;

    /* renamed from: c  reason: collision with root package name */
    public OrderConfirmation f25504c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f25505d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f25506e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25507f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25508g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25509h;

    /* renamed from: i  reason: collision with root package name */
    public WalletBaseButtonWithImage f25510i;
    public LinearLayout j;
    public TextView k;
    public LinearLayout l;
    public CheckBox m;
    public TextView n;
    public PayRequest o;
    public DirectPayContentResponse p;
    public CardData.BondCard q;
    public View r;

    public AuthorizeInfoView.b getAuthInfoViewAdapter(int i2) {
        if (this.f25503b != null) {
            return AuthorizeInfoView.a.a().a(i2, this.f25503b);
        }
        return null;
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public PayRequest getPayRequest() {
        if (this.o == null) {
            this.o = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }
        return this.o;
    }

    public DirectPayContentResponse getPayResponse() {
        if (this.p == null) {
            this.p = PayDataCache.getInstance().getPayResponse();
        }
        return this.p;
    }

    public CardData.BondCard getSelectedCard() {
        return this.q;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
    }

    public void initActionBarByString(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(getApplicationContext(), "bd_wallet_withhold_title");
            }
            bdActionBar.setTitle(str);
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.AuthorizeSignActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(AuthorizeSignActivity.this.getActivity());
                    AuthorizeSignActivity.this.onBackPressed();
                }
            });
        }
    }

    public void initCardList() {
        if (this.f25505d == null || this.f25507f == null || this.f25508g == null || this.f25506e == null) {
            return;
        }
        PayRequest payRequest = getPayRequest();
        if (payRequest != null) {
            this.q = payRequest.getDefaultBankCardIdx();
        }
        e eVar = this.f25502a;
        if (eVar != null) {
            eVar.a(this.q != null);
        }
        a();
        updateSelBankInfo(this.q);
    }

    public void initNextButton(View.OnClickListener onClickListener) {
        WalletBaseButtonWithImage walletBaseButtonWithImage = this.f25510i;
        if (walletBaseButtonWithImage != null) {
            if (onClickListener != null) {
                walletBaseButtonWithImage.setOnClickListener(onClickListener);
            }
            updateNextButton();
        }
    }

    public void initView() {
        setContentView(ResUtils.layout(getApplicationContext(), "wallet_cashdesk_authorize_sign_activity"));
        this.f25503b = (AuthorizeInfoView) findViewById(ResUtils.id(getApplicationContext(), "sign_info_view"));
        this.f25504c = (OrderConfirmation) findViewById(ResUtils.id(getApplicationContext(), "sign_order_view"));
        this.f25505d = (LinearLayout) findViewById(ResUtils.id(getApplicationContext(), "select_card_panel"));
        this.f25506e = (NetImageView) findViewById(ResUtils.id(getApplicationContext(), "select_card_bank_logo"));
        this.f25507f = (TextView) findViewById(ResUtils.id(getApplicationContext(), "select_card_bank_info"));
        this.f25508g = (TextView) findViewById(ResUtils.id(getApplicationContext(), "select_card_txt"));
        this.f25509h = (TextView) findViewById(ResUtils.id(getApplicationContext(), "select_card_need_detail"));
        this.f25510i = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getApplicationContext(), "sign_next_btn"));
        this.j = (LinearLayout) findViewById(ResUtils.id(getApplicationContext(), "sign_hint_panel"));
        this.k = (TextView) findViewById(ResUtils.id(getApplicationContext(), "sign_hint_txt"));
        this.l = (LinearLayout) findViewById(ResUtils.id(getApplicationContext(), "sign_protocol_panel"));
        this.m = (CheckBox) findViewById(ResUtils.id(getApplicationContext(), "sign_protocol_cb"));
        this.n = (TextView) findViewById(ResUtils.id(getApplicationContext(), "sign_protocol_txt"));
        this.f25504c.getBackButton().setOnClickListener(this);
        this.r = findViewById(ResUtils.id(getApplicationContext(), "statusbar_top"));
        e eVar = this.f25502a;
        if (eVar != null) {
            this.f25503b.setVisibility(eVar.d() ? 0 : 8);
            this.f25504c.setVisibility(this.f25502a.e() ? 0 : 8);
            this.j.setVisibility(this.f25502a.f() ? 0 : 8);
            if (this.f25502a.c()) {
                getBdActionBar().setVisibility(0);
            } else {
                getBdActionBar().setVisibility(8);
                setTop();
            }
            getBdActionBar().setVisibility(this.f25502a.c() ? 0 : 8);
            this.f25502a.a();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WalletGlobalUtils.safeShowDialog(this, 18, "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == ResUtils.id(getApplicationContext(), "bd_wallet_id_base_order_back")) {
            onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagPaySdk();
        this.f25502a = d.a().a(getIntent().getIntExtra(AUTH_SIGN_TYPE, 0), this);
        initView();
        EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
        refreshUI();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getInstance().unregister(this, "order_confirm_event_bus_key");
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !"order_confirm_event_bus_key".equals(event.mEventKey)) {
            return;
        }
        refreshUI();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 18) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setMessage(ResUtils.getString(this, "bd_wallet_auth_confirm_to_cancel"));
            promptDialog.setNegativeBtn(ResUtils.string(this, "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.AuthorizeSignActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(AuthorizeSignActivity.this, 18);
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(this, "bd_wallet_auth_cancel_auth"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.AuthorizeSignActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                    HashMap hashMap = new HashMap();
                    hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                    hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                    StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_CANCEL, collectData, hashMap);
                    WalletGlobalUtils.safeDismissDialog(AuthorizeSignActivity.this, 18);
                    PayCallBackManager.callBackClientCancel(AuthorizeSignActivity.this, "AuthorizeActivity.onPrepareDialog().1");
                    AuthorizeSignActivity.this.finishWithoutAnim();
                }
            });
            return;
        }
        super.onPrepareDialog(i2, dialog);
    }

    public void refreshUI() {
        e eVar = this.f25502a;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void setSelectCardListener(View.OnClickListener onClickListener) {
        LinearLayout linearLayout = this.f25505d;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(onClickListener);
        }
    }

    public void setTop() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.r.getLayoutParams());
        layoutParams.height = StatusBarUtils.getStatusBarHeight(this.mAct);
        this.r.setLayoutParams(layoutParams);
        ImmersiveStatusBarManager.setTopBar(this.mAct.getActivity(), this.r, this.mAct.isStatusbarTextColorBlack());
    }

    public void updateDiscountTitle(String str) {
        this.f25504c.setTitle(str);
    }

    public void updateDiscountTxt(boolean z, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, View.OnClickListener onClickListener) {
        this.f25504c.setDiscountInfoVisiable(z);
        this.f25504c.setOrderPrice(charSequence5, charSequence2);
        this.f25504c.setCouponInfo(charSequence3, charSequence4, onClickListener);
        this.f25504c.setOrderInfo(charSequence);
        this.f25504c.setSpNameValue(PayDataCache.getInstance().getSpName());
    }

    public void updateHintText(String str) {
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void updateNextButton() {
        e eVar = this.f25502a;
        int g2 = eVar != null ? eVar.g() : 0;
        if (g2 == 1) {
            this.f25510i.setText(ResUtils.getString(getApplicationContext(), "wallet_base_next_step"));
            this.f25510i.setDrawableLeftVisible(false);
        } else if (g2 == 2) {
            this.f25510i.setText(ResUtils.getString(getApplicationContext(), "ebpay_use_newcard_topay"));
            this.f25510i.setDrawableLeftVisible(false);
        } else if (g2 == 3) {
            this.f25510i.setText(ResUtils.getString(getApplicationContext(), "bd_wallet_auth_submit_sign"));
            this.f25510i.setDrawableLeftVisible(true);
        } else if (g2 != 4) {
            this.f25510i.setText(ResUtils.getString(getApplicationContext(), "wallet_base_next_step"));
            this.f25510i.setDrawableLeftVisible(false);
        } else {
            this.f25510i.setText(ResUtils.getString(getApplicationContext(), "bd_wallet_auth_newcard_submit_sign"));
            this.f25510i.setDrawableLeftVisible(true);
        }
        a(this.m.isChecked());
    }

    public void updateProtocolFields() {
        Authorize authorize;
        Authorize.AgreementInfo agreementInfo;
        DirectPayContentResponse payResponse = getPayResponse();
        if (payResponse != null && (authorize = payResponse.authorize) != null && (agreementInfo = authorize.agreement_info) != null) {
            this.l.setVisibility(0);
            CheckBox checkBox = this.m;
            if (checkBox != null) {
                checkBox.setChecked(agreementInfo.isProtocolCheckedDefault());
                this.m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.wallet.paysdk.ui.AuthorizeSignActivity.4
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        StatisticManager.onEventWithValue(StatServiceEvent.CLICK_AGREE_BTN, z ? "0" : "1");
                        AuthorizeSignActivity.this.a(z);
                    }
                });
            }
            if (this.n != null) {
                ArrayList arrayList = new ArrayList();
                GetCardInfoResponse.ProtocolItem[] protocolItemArr = agreementInfo.list;
                if (protocolItemArr != null) {
                    for (GetCardInfoResponse.ProtocolItem protocolItem : protocolItemArr) {
                        if (!TextUtils.isEmpty(protocolItem.title)) {
                            arrayList.add(protocolItem);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    int color = ResUtils.getColor(getActivity(), "bd_wallet_text_gray");
                    spannableStringBuilder.append((CharSequence) (agreementInfo.prefix + " "));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, agreementInfo.prefix.length(), 33);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        GetCardInfoResponse.ProtocolItem protocolItem2 = (GetCardInfoResponse.ProtocolItem) arrayList.get(i2);
                        if (i2 != 0) {
                            String str = agreementInfo.separator;
                            if (i2 == arrayList.size() - 1) {
                                str = agreementInfo.last_separator;
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
                            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.wallet.paysdk.ui.AuthorizeSignActivity.5
                                @Override // android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    StatisticManager.onEvent(StatServiceEvent.CLICK_USER_TERMS);
                                    Intent intent = new Intent(AuthorizeSignActivity.this.getActivity(), WebViewActivity.class);
                                    intent.putExtra("jump_url", str2);
                                    intent.putExtra("webview_title_string", replaceAll);
                                    AuthorizeSignActivity.this.startActivity(intent);
                                }

                                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                                public void updateDrawState(TextPaint textPaint) {
                                    textPaint.setColor(ResUtils.getColor(AuthorizeSignActivity.this.getActivity(), "wallet_base_mainColor"));
                                }
                            }, spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                        } else {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                        }
                    }
                    this.n.setEnabled(true);
                    this.n.setMovementMethod(LinkMovementMethod.getInstance());
                    this.n.setText(spannableStringBuilder);
                    return;
                }
                this.n.setVisibility(8);
                this.l.setVisibility(8);
                return;
            }
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(8);
    }

    public void updateSelBankInfo(CardData.BondCard bondCard) {
        if (bondCard != null && "1".equals(bondCard.card_state)) {
            PayRequest payRequest = getPayRequest();
            this.q = bondCard;
            if (payRequest != null) {
                payRequest.mBondCard = bondCard;
            }
            this.f25508g.setText(bondCard.getCardDesc(this.mAct, true));
            if (!TextUtils.isEmpty(bondCard.bank_card_msg)) {
                this.f25509h.setVisibility(0);
                this.f25509h.setText(bondCard.bank_card_msg);
            } else {
                this.f25509h.setVisibility(4);
            }
        } else {
            this.f25508g.setText(ResUtils.string(getActivity(), "ebpay_has_no_avaible_pay_type"));
        }
        this.f25507f.setText(ResUtils.getString(getApplicationContext(), "bd_wallet_auth_primary_pay_method"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.f25510i.setEnabled(true);
        } else {
            this.f25510i.setEnabled(false);
        }
    }

    private void a() {
        if (this.f25508g == null) {
            return;
        }
        Drawable drawable = ResUtils.getDrawable(getActivity(), "wallet_base_indicator_arrow");
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f25508g.setCompoundDrawables(null, null, drawable, null);
        this.f25508g.setCompoundDrawablePadding(DisplayUtils.dip2px(getApplicationContext(), 5.0f));
    }
}
