package com.baidu.wallet.paysdk.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class AuthorizePayTypePresenter extends PayTypeContract.Presenter {
    public static final String TAG = "AuthorizePayTypePresenter";

    public AuthorizePayTypePresenter(PayTypeActivity payTypeActivity) {
        super(payTypeActivity);
    }

    private void gotoNewCardAuth() {
        StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
        StatHelper.cachePayType(0);
        StatHelper.cachePayWay(4);
        if (PayDataCache.getInstance().hasMobilePwd()) {
            Intent intent = new Intent();
            intent.setClass(this.mActivity, PwdPayActivity.class);
            intent.putExtra(PwdPayPresenterFactory.PWDPAYACTIVITY_FROM_KEY, 3);
            this.mActivity.startActivity(intent);
            return;
        }
        BaiduPay.getInstance().bindCardAuth(this.mActivity.getActivity(), false);
    }

    private boolean isPureSign() {
        return com.baidu.wallet.paysdk.a.b.b();
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void afterCalculatePayamountGotoNext() {
        this.mActivity.gotoOrderConfim();
    }

    public ArrayList<PayTypeItemView.PayTypeItemViewData> getAuthorizePayTypeListData() {
        ArrayList<PayTypeItemView.PayTypeItemViewData> arrayList = new ArrayList<>();
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (payRequest == null) {
            return null;
        }
        CardData.BondCard[] bondCards = PayDataCache.getInstance().getBondCards();
        PayRequest.PayPrice payPrice = payRequest.getPayPrice();
        if (payPrice == null) {
            return null;
        }
        if (bondCards != null && bondCards.length > 0) {
            for (int i = 0; i < bondCards.length; i++) {
                PayTypeItemView.PayTypeItemViewData payTypeItemViewData = new PayTypeItemView.PayTypeItemViewData();
                payTypeItemViewData.type = PayTypeItemView.ItemViewType.BANKCARD;
                if ("1".equals(bondCards[i].card_state)) {
                    if (!payPrice.easypayIsEnable) {
                        payTypeItemViewData.isAvaible = false;
                        payTypeItemViewData.tips = payPrice.easyTipFromCalc;
                    } else {
                        payTypeItemViewData.isAvaible = true;
                        if (!TextUtils.isEmpty(bondCards[i].channelDiscountDesc)) {
                            payTypeItemViewData.tips = bondCards[i].channelDiscountDesc;
                            payTypeItemViewData.highlight = true;
                        } else {
                            payTypeItemViewData.tips = !TextUtils.isEmpty(bondCards[i].bank_card_msg) ? bondCards[i].bank_card_msg : payPrice.easyTipFromCalc;
                        }
                    }
                } else {
                    payTypeItemViewData.isAvaible = false;
                    payTypeItemViewData.tips = bondCards[i].bank_card_msg;
                }
                payTypeItemViewData.name = bondCards[i].getCardDesc(this.mContext, true);
                payTypeItemViewData.card = bondCards[i];
                CardData.BondCard bondCard = payRequest.mBondCard;
                if (bondCard != null && bondCard == bondCards[i]) {
                    payTypeItemViewData.isChecked = true;
                } else {
                    payTypeItemViewData.isChecked = false;
                }
                payTypeItemViewData.logoUrl = bondCards[i].bank_url;
                arrayList.add(payTypeItemViewData);
            }
        }
        PayTypeItemView.PayTypeItemViewData payTypeItemViewData2 = new PayTypeItemView.PayTypeItemViewData();
        payTypeItemViewData2.isAvaible = PayDataCache.getInstance().enableAddBondCards();
        payTypeItemViewData2.type = PayTypeItemView.ItemViewType.ADD_NEWCARD;
        payTypeItemViewData2.name = ResUtils.getString(this.mActivity, "ebpay_use_new_card");
        if (!payTypeItemViewData2.isAvaible) {
            payTypeItemViewData2.tips = ResUtils.getString(this.mActivity, "ebpay_bankcard_fullof");
        }
        arrayList.add(payTypeItemViewData2);
        sortData(arrayList);
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void modifyPayType(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        super.modifyPayType(payTypeItemViewData);
        if (payTypeItemViewData == null) {
            return;
        }
        if (isPureSign()) {
            if (payTypeItemViewData.isChecked) {
                this.mActivity.finishWithoutAnim();
            } else if (payTypeItemViewData.type == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                gotoNewCardAuth();
            } else {
                PayRequest payRequest = this.mPayRequest;
                if (payRequest != null) {
                    payRequest.mBondCard = payTypeItemViewData.card;
                }
                this.mActivity.gotoOrderConfim();
            }
        } else if (payTypeItemViewData.isChecked) {
            this.mActivity.gotoOrderConfim();
        } else if (payTypeItemViewData.type == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
            gotoNewCardAuth();
        } else {
            calculatePayAmount(payTypeItemViewData);
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            reOrderPay();
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void onBackPressed() {
        if (isPureSign()) {
            return;
        }
        EventBus eventBus = EventBus.getInstance();
        EventBus eventBus2 = EventBus.getInstance();
        eventBus2.getClass();
        eventBus.postStickyEvent(new EventBus.Event("order_confirm_event_bus_key", null));
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        this.mActivity.reFreshUI(getAuthorizePayTypeListData());
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter, com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
        super.onDestroy();
        EventBus.getInstance().unregister(this);
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onPause() {
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onResume() {
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void reOrderPay() {
        StatisticManager.onEvent(StatServiceEvent.AUTHORIZE_RECREATE_ORDER);
        BaiduPayDelegate.getInstance().reOrderPay(this.mActivity);
    }
}
