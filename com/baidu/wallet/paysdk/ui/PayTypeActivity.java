package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.datamodel.GetJumpUrlResponse;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.h;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PaySettingActivity;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class PayTypeActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static final int REQUEST_CODE_FOR_BALANCE_LIMIT_LIGHT_APP = 1;
    public static final String TAG = "PayTypeActivity";

    /* renamed from: a  reason: collision with root package name */
    public PayRequest f25881a;

    /* renamed from: b  reason: collision with root package name */
    public String f25882b = "";

    /* renamed from: c  reason: collision with root package name */
    public boolean f25883c = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25884e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25885f;
    public PayTypeItemView mClickedItemView;
    public ViewGroup mPayTypeContainerView;
    public PayTypeContract.Presenter mPresenter;

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_pay_way_list"), null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void dismissLoading(int i2) {
        PayTypeItemView payTypeItemView = this.mClickedItemView;
        if (payTypeItemView != null) {
            payTypeItemView.setItemState(false);
        }
    }

    public void gotoOrderConfim() {
        EventBus eventBus = EventBus.getInstance();
        EventBus eventBus2 = EventBus.getInstance();
        eventBus.getClass();
        PayTypeContract.Presenter presenter = this.mPresenter;
        eventBus2.postStickyEvent(new EventBus.Event("order_confirm_event_bus_key", presenter != null ? presenter.getPayRequest() : null));
        finishWithoutAnim();
    }

    public void gotoPwdPay(boolean z) {
        PayTypeItemView payTypeItemView;
        PayTypeItemView.PayTypeItemViewData payTypeItemViewData;
        CardData.BondCard bondCard;
        this.f25885f = z;
        if (PayDataCache.getInstance().isFromPreCashier() && (payTypeItemView = this.mClickedItemView) != null && (payTypeItemViewData = payTypeItemView.mData) != null && (bondCard = payTypeItemViewData.card) != null && !TextUtils.isEmpty(bondCard.account_no)) {
            if (this.f25883c) {
                String g2 = com.baidu.wallet.paysdk.banksign.a.a.a().g(this.mClickedItemView.mData.card.account_no);
                if (!TextUtils.isEmpty(g2)) {
                    PayDataCache.getInstance().setOrderExtraInfo(g2);
                }
                BaiduPayDelegate.getInstance().reOrderPay(this.mAct);
                return;
            } else if (this.mClickedItemView.mData.card.is_sign_jump_bank == 1) {
                PayData.DirectPayPay directPayPay = PayDataCache.getInstance().getPayResponse().pay;
                String str = this.mClickedItemView.mData.card.account_no;
                directPayPay.selected_card_no = str;
                a(str);
                return;
            } else {
                jumpPwdPayActivity();
                return;
            }
        }
        jumpPwdPayActivity();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 768) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            GlobalUtils.toast(this.mAct, str);
        }
        super.handleFailure(i2, i3, str);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 768) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            GetJumpUrlResponse getJumpUrlResponse = (GetJumpUrlResponse) obj;
            if (getJumpUrlResponse.agreement_trans_id != null) {
                com.baidu.wallet.paysdk.banksign.a.a.a().f(getJumpUrlResponse.agreement_trans_id);
            }
            if (getJumpUrlResponse.is_signed == 0) {
                String str2 = getJumpUrlResponse.form_data;
                com.baidu.wallet.paysdk.banksign.a.a.a().a(str2 == null ? null : str2.getBytes());
                if (!this.f25884e) {
                    com.baidu.wallet.paysdk.banksign.a.a.a().a(this);
                } else {
                    com.baidu.wallet.paysdk.banksign.a.a.a().a((PayTypeActivity) null);
                }
                com.baidu.wallet.paysdk.banksign.a.a.a().a(this.f25884e);
                com.baidu.wallet.paysdk.banksign.a.a.a().d(getJumpUrlResponse.form_url);
                com.baidu.wallet.paysdk.banksign.a.a.a().e(getJumpUrlResponse.webview_title);
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.ShowGuide);
                a2.a(this.mAct);
            } else if (PayDataCache.getInstance().isFromPreCashier() && !this.f25884e) {
                jumpPwdPayActivity();
            } else if (this.f25884e && !TextUtils.isEmpty(getJumpUrlResponse.signed_msg)) {
                GlobalUtils.toast(this.mAct, getJumpUrlResponse.signed_msg);
            }
        }
        super.handleResponse(i2, obj, str);
    }

    public void initView() {
        this.mActionBar.setVisibility(0);
        this.mLeftImg.setOnClickListener(this);
        PayRequest payRequest = this.f25881a;
        if (payRequest != null && payRequest.isWithHoldingValidity()) {
            this.mRightTxt.setVisibility(8);
        } else if (com.baidu.wallet.paysdk.a.b.a()) {
            this.mRightTxt.setVisibility(8);
        } else {
            this.mRightTxt.setVisibility(0);
            this.mRightTxt.setText(ResUtils.getString(this, "ebpay_settings"));
            this.mRightTxt.setOnClickListener(this);
        }
        this.mTitle.setVisibility(4);
        TextView textView = (TextView) findViewById(ResUtils.id(this, "bd_wallet_payway_title"));
        this.mTitle = textView;
        textView.setText(ResUtils.getString(this, "ebpay_pwdpay_payment_select"));
        this.mPayTypeContainerView = (ViewGroup) findViewById(ResUtils.id(this, "bd_wallet_payway_container"));
    }

    public void jumpPwdPayActivity() {
        Intent intent = new Intent(this, PwdPayActivity.class);
        intent.putExtra("IS_FOR_BIND_CARD_PAY", this.f25885f);
        startActivity(intent);
    }

    public void jumpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, false, 1);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        PayTypeContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mHalfScreenContainer.isClickable()) {
            if (PayRequestCache.getInstance().isPaying() && PayDataCache.getInstance().isFromPreCashier()) {
                PayCallBackManager.callBackClientCancel(this, "PayTypeActivity.onBackPressed().1");
            }
            PayTypeContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onBackPressed();
            }
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.mRightTxt) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_CASHDESK_SETTINGS);
            PayController.getInstance().startPaySettingActivity(this, new PaySettingActivity.a() { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.4
                @Override // com.baidu.wallet.paysdk.ui.PaySettingActivity.a
                public void a(boolean z) {
                    LogUtil.d(PayTypeActivity.TAG, "是否更换了支付方式：" + z);
                    if (z) {
                        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_CASHDESK_SETTED_METHOD);
                        PayTypeContract.Presenter presenter = PayTypeActivity.this.mPresenter;
                        if (presenter != null) {
                            presenter.reOrderPay();
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f25881a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        this.f25883c = getIntent().getBooleanExtra("isGatewaySignPay", false);
        initView();
        if (PayDataCache.getInstance().isFromPreCashier()) {
            this.f25882b = "FORM_PRECASHIER";
        } else if (com.baidu.wallet.paysdk.a.b.a()) {
            this.f25882b = "FROM_AUTHORIZE";
        } else {
            this.f25882b = "";
        }
        PayTypeContract.Presenter a2 = h.a(this.f25882b, this);
        this.mPresenter = a2;
        if (a2 == null) {
            finish();
        } else {
            a2.onCreate(bundle);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(TAG);
        PayTypeContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onDestroy();
            this.mPresenter = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        PayTypeContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onSaveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    public void setPageClickable(boolean z) {
        this.mHalfScreenContainer.setClickable(z);
    }

    public void showLoading(int i2) {
        this.mClickedItemView.setItemState(true);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void reFreshUI(ArrayList<PayTypeItemView.PayTypeItemViewData> arrayList) {
        final PayTypeItemView generateItemView;
        this.mClickedItemView = null;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<PayTypeItemView.PayTypeItemViewData> it = arrayList.iterator();
            while (it.hasNext()) {
                final PayTypeItemView.PayTypeItemViewData next = it.next();
                boolean z = next.isChecked;
                BeanActivity beanActivity = this.mAct;
                if (beanActivity != null && (generateItemView = PayTypeItemView.generateItemView(beanActivity, next, new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayTypeActivity.this.jumpUrl(next.jump_url);
                        PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_PAY_METHOD_BALANCE_QUOTA, next.tips);
                    }
                }, new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CardData.BondCard bondCard;
                        boolean z2 = true;
                        PayTypeActivity.this.f25884e = true;
                        PayTypeItemView.PayTypeItemViewData payTypeItemViewData = next;
                        if ((payTypeItemViewData == null || (bondCard = payTypeItemViewData.card) == null || bondCard.is_sign_jump_bank != 1 || TextUtils.isEmpty(bondCard.account_no)) ? false : false) {
                            PayTypeActivity.this.a(next.card.account_no);
                            return;
                        }
                        if (!TextUtils.isEmpty(next.hintUrl)) {
                            BaiduWalletDelegate.getInstance().openH5Module(PayTypeActivity.this.getActivity(), next.hintUrl);
                        }
                        PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_PAY_METHOD_BANK_HINT, next.hintMsg);
                    }
                })) != null) {
                    generateItemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            PayTypeItemView.PayTypeItemViewData payTypeItemViewData = next;
                            if (!payTypeItemViewData.isAvaible) {
                                if (payTypeItemViewData.isNeedToColored()) {
                                    return;
                                }
                                PayTypeActivity payTypeActivity = PayTypeActivity.this;
                                PayTypeItemView.PayTypeItemViewData payTypeItemViewData2 = next;
                                GlobalUtils.toast(payTypeActivity, payTypeItemViewData2.removeSeparator(payTypeItemViewData2.tips));
                            } else if (PayTypeActivity.this.f25883c && PayDataCache.getInstance().isFromPreCashier()) {
                                String g2 = com.baidu.wallet.paysdk.banksign.a.a.a().g(next.card.account_no);
                                if (!TextUtils.isEmpty(g2)) {
                                    PayDataCache.getInstance().setOrderExtraInfo(g2);
                                }
                                BaiduPayDelegate.getInstance().reOrderPay(PayTypeActivity.this.mAct);
                            } else {
                                PayTypeActivity payTypeActivity2 = PayTypeActivity.this;
                                payTypeActivity2.mClickedItemView = generateItemView;
                                payTypeActivity2.f25884e = false;
                                PayTypeItemView.ItemViewType itemViewType = next.type;
                                if (itemViewType == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_NEWCARD_PAY);
                                } else if (itemViewType == PayTypeItemView.ItemViewType.BANKCARD) {
                                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_SWITCH_BANKCARD);
                                }
                                PayTypeContract.Presenter presenter = PayTypeActivity.this.mPresenter;
                                if (presenter != null) {
                                    presenter.modifyPayType(next);
                                }
                            }
                        }
                    });
                    arrayList2.add(generateItemView);
                }
            }
            this.mPayTypeContainerView.removeAllViews();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                this.mPayTypeContainerView.addView((PayTypeItemView) it2.next());
                View view = new View(getActivity());
                view.setBackgroundColor(ResUtils.getColor(getActivity(), "wallet_base_separator_color"));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 1);
                int dimension = (int) ResUtils.getDimension(this.mAct, "wallet_base_margin");
                layoutParams.setMargins(dimension, 0, dimension, 0);
                view.setLayoutParams(layoutParams);
                this.mPayTypeContainerView.addView(view);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void setPresenter(PayTypeContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
        if (this.f25884e) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_BANK_SIGN);
        }
        com.baidu.wallet.paysdk.banksign.beans.b bVar = (com.baidu.wallet.paysdk.banksign.beans.b) BankSignFactory.getInstance().getBean((Context) this.mAct, 768, TAG);
        com.baidu.wallet.paysdk.banksign.a.a.a().a(str);
        bVar.a(str);
        bVar.setResponseCallback(this.mAct);
        bVar.execBean();
    }

    private void a(String str, boolean z, final int i2) {
        LocalRouter.getInstance(this).route(this, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_getStartIntent").data("url", str).data("withAnim", Boolean.valueOf(z)).data("showShare", Boolean.TRUE), new RouterCallback() { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.5
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i3, HashMap hashMap) {
                Intent intent;
                if (i3 != 0 || hashMap == null || !(hashMap.get("result") instanceof Intent) || (intent = (Intent) hashMap.get("result")) == null) {
                    return;
                }
                PayTypeActivity.this.startActivityForResult(intent, i2);
            }
        });
    }
}
