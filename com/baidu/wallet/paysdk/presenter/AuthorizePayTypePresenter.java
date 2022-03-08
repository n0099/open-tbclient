package com.baidu.wallet.paysdk.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class AuthorizePayTypePresenter extends PayTypeContract.Presenter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AuthorizePayTypePresenter";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthorizePayTypePresenter(PayTypeActivity payTypeActivity) {
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

    private void gotoNewCardAuth() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_ENTER);
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_BIND_CARD_DURATION);
            if (PayDataCache.getInstance().hasMobilePwd()) {
                Intent intent = new Intent();
                intent.setClass(this.mActivity, PwdPayActivity.class);
                intent.putExtra(PwdPayPresenterFactory.PWDPAYACTIVITY_FROM_KEY, 3);
                this.mActivity.startActivity(intent);
                return;
            }
            BaiduPay.getInstance().bindCardAuth(this.mActivity.getActivity(), false);
        }
    }

    private boolean isPureSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? com.baidu.wallet.paysdk.a.b.b() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void afterCalculatePayamountGotoNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mActivity.gotoOrderConfim();
        }
    }

    public ArrayList<PayTypeItemView.PayTypeItemViewData> getAuthorizePayTypeListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
                for (int i2 = 0; i2 < bondCards.length; i2++) {
                    PayTypeItemView.PayTypeItemViewData payTypeItemViewData = new PayTypeItemView.PayTypeItemViewData();
                    payTypeItemViewData.type = PayTypeItemView.ItemViewType.BANKCARD;
                    if ("1".equals(bondCards[i2].card_state)) {
                        if (!payPrice.easypayIsEnable) {
                            payTypeItemViewData.isAvaible = false;
                            payTypeItemViewData.tips = payPrice.easyTipFromCalc;
                        } else {
                            payTypeItemViewData.isAvaible = true;
                            if (!TextUtils.isEmpty(bondCards[i2].channelDiscountDesc)) {
                                payTypeItemViewData.tips = bondCards[i2].channelDiscountDesc;
                                payTypeItemViewData.highlight = true;
                            } else {
                                payTypeItemViewData.tips = !TextUtils.isEmpty(bondCards[i2].bank_card_msg) ? bondCards[i2].bank_card_msg : payPrice.easyTipFromCalc;
                            }
                        }
                    } else {
                        payTypeItemViewData.isAvaible = false;
                        payTypeItemViewData.tips = bondCards[i2].bank_card_msg;
                    }
                    payTypeItemViewData.name = bondCards[i2].getCardDesc(this.mContext, true);
                    payTypeItemViewData.card = bondCards[i2];
                    CardData.BondCard bondCard = payRequest.mBondCard;
                    if (bondCard != null && bondCard == bondCards[i2]) {
                        payTypeItemViewData.isChecked = true;
                    } else {
                        payTypeItemViewData.isChecked = false;
                    }
                    payTypeItemViewData.logoUrl = bondCards[i2].bank_url;
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
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void modifyPayType(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, payTypeItemViewData) == null) {
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
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) && i2 == 1) {
            reOrderPay();
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isPureSign()) {
            return;
        }
        EventBus eventBus = EventBus.getInstance();
        EventBus eventBus2 = EventBus.getInstance();
        eventBus2.getClass();
        eventBus.postStickyEvent(new EventBus.Event(eventBus2, "order_confirm_event_bus_key", null));
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            this.mActivity.reFreshUI(getAuthorizePayTypeListData());
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter, com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            EventBus.getInstance().unregister(this);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void reOrderPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            StatisticManager.onEvent("authorizePayReorder");
            BaiduPayDelegate.getInstance().reOrderPay(this.mActivity);
        }
    }
}
