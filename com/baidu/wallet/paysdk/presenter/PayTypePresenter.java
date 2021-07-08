package com.baidu.wallet.paysdk.presenter;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PayTypePresenter";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayTypePresenter(PayTypeActivity payTypeActivity) {
        super(payTypeActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payTypeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((PayTypeActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void afterCalculatePayamountGotoNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mActivity.gotoOrderConfim();
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void modifyPayType(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payTypeItemViewData) == null) {
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
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) && i2 == 1) {
            reOrderPay();
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EventBus eventBus = EventBus.getInstance();
            EventBus eventBus2 = EventBus.getInstance();
            eventBus2.getClass();
            eventBus.postStickyEvent(new EventBus.Event(eventBus2, "order_confirm_event_bus_key", null));
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.mActivity.reFreshUI(getNormalPayTypeListData());
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter, com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            EventBus.getInstance().unregister(this);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void reOrderPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            BaiduPayDelegate.getInstance().reOrderPay(this.mActivity);
        }
    }
}
