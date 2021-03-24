package com.baidu.wallet.paysdk.presenter;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
/* loaded from: classes5.dex */
public class PayTypePresenter extends PayTypeContract.Presenter {
    public static final String TAG = "PayTypePresenter";

    public PayTypePresenter(PayTypeActivity payTypeActivity) {
        super(payTypeActivity);
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void afterCalculatePayamountGotoNext() {
        this.mActivity.gotoOrderConfim();
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void modifyPayType(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        PayRequest payRequest;
        super.modifyPayType(payTypeItemViewData);
        if (payTypeItemViewData == null) {
            return;
        }
        if (payTypeItemViewData.isChecked) {
            this.mActivity.gotoOrderConfim();
        } else if (payTypeItemViewData.type == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            this.mActivity.gotoPwdPay(true);
        } else if (!PayDataCache.getInstance().needCalcPayment() && (payRequest = this.mPayRequest) != null) {
            payRequest.calcPayPriceByLocal(payTypeItemViewData);
            this.mActivity.gotoOrderConfim();
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
        EventBus eventBus = EventBus.getInstance();
        EventBus eventBus2 = EventBus.getInstance();
        eventBus2.getClass();
        eventBus.postStickyEvent(new EventBus.Event("order_confirm_event_bus_key", null));
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        this.mActivity.reFreshUI(getNormalPayTypeListData());
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
        BaiduPayDelegate.getInstance().reOrderPay(this.mActivity);
    }
}
