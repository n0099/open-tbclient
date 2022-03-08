package com.baidu.wallet.paysdk.presenter;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.OrderConfirmContract;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class OrderConfirmPresenter implements OrderConfirmContract.Presenter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "OrderConfirmPresenter";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isHasShowRedDot;
    public OrderConfirmActivity mActivity;
    public PayRequest mPayRequest;
    public OrderConfirmContract.Presenter.OrderConfirmViewData mViewData;

    public OrderConfirmPresenter(OrderConfirmActivity orderConfirmActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {orderConfirmActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isHasShowRedDot = false;
        this.mActivity = orderConfirmActivity;
        orderConfirmActivity.setPresenter((OrderConfirmContract.Presenter) this);
        this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
    }

    @Override // com.baidu.wallet.paysdk.contract.OrderConfirmContract.Presenter
    public void changePwdMode() {
        OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (orderConfirmViewData = this.mViewData) == null) {
            return;
        }
        orderConfirmViewData.isFingerprintPay = false;
        orderConfirmViewData.confirmBtnMsg = "确认支付";
        this.mActivity.reFreshUI(orderConfirmViewData);
    }

    @Override // com.baidu.wallet.paysdk.contract.OrderConfirmContract.Presenter
    public void clickCoupon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mActivity.gotoCoupon();
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.OrderConfirmContract.Presenter
    public void clickPayway() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mActivity.gotoPayType();
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.OrderConfirmContract.Presenter
    public void closeOrderComfirmPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mPayRequest.isWithHoldingValidity()) {
                this.mActivity.finish();
            } else {
                WalletGlobalUtils.safeShowDialog(this.mActivity, 18, "");
            }
        }
    }

    public int getPayWay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPayRequest.getPayWay() : invokeV.intValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.OrderConfirmContract.Presenter
    public void getViewData() {
        OrderConfirmActivity orderConfirmActivity;
        boolean z;
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        PayData.DirectPayPay directPayPay2;
        PayData.DirectPayBalance directPayBalance;
        String string;
        String string2;
        CardData.BondCard bondCard;
        PayData.DirectPayPay directPayPay3;
        String displayName;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (orderConfirmActivity = this.mActivity) == null || orderConfirmActivity.isFinishing()) {
            return;
        }
        this.mViewData = new OrderConfirmContract.Presenter.OrderConfirmViewData();
        if (PayDataCache.getInstance().isRemotePay()) {
            OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData = this.mViewData;
            if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getPassUserName())) {
                displayName = WalletLoginHelper.getInstance().getPassUserName();
            } else {
                displayName = PayDataCache.getInstance().getPayResponse().getDisplayName();
            }
            orderConfirmViewData.currentAccount = displayName;
        }
        PayRequest payRequest = this.mPayRequest;
        if (payRequest == null) {
            PayCallBackManager.callBackClientCancel(this.mActivity, "OrderConfirmPresentergetViewData().1");
            return;
        }
        OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData2 = this.mViewData;
        orderConfirmViewData2.goodsName = payRequest.mGoodName;
        orderConfirmViewData2.orderPrice = payRequest.getOrderPrice();
        this.mViewData.discountAmount = this.mPayRequest.getDiscountAmount();
        this.mViewData.discountDesc = this.mPayRequest.getDiscountMsg();
        this.mViewData.needPayAmount = this.mPayRequest.getFinalPayAmount();
        PayRequest.PayPrice payPrice = this.mPayRequest.getPayPrice();
        if (payPrice == null) {
            PayCallBackManager.callBackClientCancel(this.mActivity, "OrderConfirmPresentergetViewData().2");
            return;
        }
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse == null || (directPayPay3 = payResponse.pay) == null) {
            z = false;
        } else {
            z = directPayPay3.hasRecommendPaytype();
            this.mViewData.spName = payResponse.getSpName();
        }
        PayRequest.PayPrice.PayType payType = payPrice.payType;
        if (payType == PayRequest.PayPrice.PayType.BANKCARD) {
            StatHelper.cachePayType(0);
            CardData.BondCard bondCard2 = this.mPayRequest.mBondCard;
            if (bondCard2 != null) {
                if (!TextUtils.equals(bondCard2.is_recommended, "1") && z) {
                    if (!this.isHasShowRedDot) {
                        this.mViewData.isShowRedDot = true;
                    }
                } else {
                    this.mViewData.isShowRedDot = false;
                    this.isHasShowRedDot = true;
                }
                this.mViewData.payTyeDesc = this.mPayRequest.mBondCard.getCardDesc(this.mActivity, true);
                if (!TextUtils.isEmpty(this.mPayRequest.mBondCard.channelDiscountDesc)) {
                    OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData3 = this.mViewData;
                    orderConfirmViewData3.channelDiscountDesc = this.mPayRequest.mBondCard.channelDiscountDesc;
                    orderConfirmViewData3.highlight = true;
                }
                if (!TextUtils.isEmpty(this.mPayRequest.mBondCard.bank_card_msg)) {
                    this.mViewData.cardTip = this.mPayRequest.mBondCard.bank_card_msg;
                }
                this.mViewData.hasAvailablePayType = payResponse.hasSupportCards();
            } else {
                this.mViewData.payTyeDesc = ResUtils.getString(this.mActivity, "ebpay_has_no_avaible_pay_type");
                this.mViewData.hasAvailablePayType = false;
            }
        } else if (payType == PayRequest.PayPrice.PayType.BALANCE) {
            StatHelper.cachePayType(1);
            if (!z) {
                this.mViewData.isShowRedDot = false;
            } else if (payResponse != null && (directPayPay2 = payResponse.pay) != null && (directPayBalance = directPayPay2.balance) != null && TextUtils.equals(directPayBalance.is_recommended, "1")) {
                this.mViewData.isShowRedDot = false;
                this.isHasShowRedDot = true;
            } else if (!this.isHasShowRedDot) {
                this.mViewData.isShowRedDot = true;
            }
            this.mViewData.payTyeDesc = ResUtils.getString(this.mActivity, "ebpay_balance_pay");
            this.mViewData.hasAvailablePayType = PayDataCache.getInstance().isBalanceEnough();
        } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
            if (!z) {
                this.mViewData.isShowRedDot = false;
            } else if (payResponse != null && (directPayPay = payResponse.pay) != null && (creditPay = directPayPay.credit_pay) != null && TextUtils.equals(creditPay.is_recommended, "1")) {
                this.mViewData.isShowRedDot = false;
                this.isHasShowRedDot = true;
            } else if (!this.isHasShowRedDot) {
                this.mViewData.isShowRedDot = true;
            }
            this.mViewData.payTyeDesc = ResUtils.getString(this.mActivity, "ebpay_credit_pay");
            this.mViewData.hasAvailablePayType = PayDataCache.getInstance().oneKeyPayForCredit();
        }
        OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData4 = this.mViewData;
        if (!orderConfirmViewData4.hasAvailablePayType) {
            orderConfirmViewData4.payTyeDesc = ResUtils.getString(this.mActivity, "ebpay_has_no_avaible_pay_type");
        }
        this.mViewData.showDiscount = this.mPayRequest.showCouponListEntry();
        this.mViewData.randomDiscountMsg = this.mPayRequest.getRandomDiscountMsg();
        PayRequest payRequest2 = this.mPayRequest;
        if (!payRequest2.supportFingerprintPay) {
            payRequest2.clearFingerPrintData();
        }
        UserData.Misc misc = payResponse.misc;
        UserData.Misc.ConfirmButtonMsg payButtonMsg = misc != null ? misc.getPayButtonMsg() : null;
        OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData5 = this.mViewData;
        if (orderConfirmViewData5.hasAvailablePayType) {
            if (payPrice.payType == PayRequest.PayPrice.PayType.BANKCARD && (bondCard = this.mPayRequest.mBondCard) != null && !bondCard.isCompled()) {
                this.mViewData.confirmBtnMsg = (payButtonMsg == null || TextUtils.isEmpty(payButtonMsg.getDefault_msg())) ? ResUtils.getString(this.mActivity, "wallet_confirm_order_title") : payButtonMsg.getDefault_msg();
            } else if (PayDataCache.getInstance().isPassFree()) {
                this.mPayRequest.setPayWay(1);
                OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData6 = this.mViewData;
                if (payButtonMsg != null && !TextUtils.isEmpty(payButtonMsg.getNopass())) {
                    string2 = misc.getPayButtonMsg().getNopass();
                } else if (payButtonMsg != null && !TextUtils.isEmpty(payButtonMsg.getDefault_msg())) {
                    string2 = payButtonMsg.getDefault_msg();
                } else {
                    string2 = ResUtils.getString(this.mActivity, "wallet_confirm_order_title");
                }
                orderConfirmViewData6.confirmBtnMsg = string2;
            } else {
                PayRequest payRequest3 = this.mPayRequest;
                if (payRequest3.supportFingerprintPay) {
                    this.mViewData.isFingerprintPay = payRequest3.getPayWay() == 2;
                    OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData7 = this.mViewData;
                    if (orderConfirmViewData7.isFingerprintPay && !orderConfirmViewData7.isOTP) {
                        orderConfirmViewData7.confirmBtnMsg = ResUtils.getString(this.mActivity, "bd_wallet_fingerprint_pay");
                    } else {
                        this.mViewData.confirmBtnMsg = (payButtonMsg == null || TextUtils.isEmpty(payButtonMsg.getDefault_msg())) ? ResUtils.getString(this.mActivity, "wallet_confirm_order_title") : payButtonMsg.getDefault_msg();
                    }
                } else {
                    this.mViewData.confirmBtnMsg = (payButtonMsg == null || TextUtils.isEmpty(payButtonMsg.getDefault_msg())) ? ResUtils.getString(this.mActivity, "wallet_confirm_order_title") : payButtonMsg.getDefault_msg();
                    this.mViewData.isFingerprintPay = false;
                }
            }
        } else {
            if (payButtonMsg != null && !TextUtils.isEmpty(payButtonMsg.getNew_card())) {
                string = payButtonMsg.getNew_card();
            } else if (payButtonMsg != null && !TextUtils.isEmpty(payButtonMsg.getDefault_msg())) {
                string = payButtonMsg.getDefault_msg();
            } else {
                string = ResUtils.getString(this.mActivity, "ebpay_use_newcard_topay");
            }
            orderConfirmViewData5.confirmBtnMsg = string;
        }
        if (misc != null) {
            this.mViewData.title_url = misc.title_url;
        }
        StatisticManager.onEventWithValue("defaultVerType", this.mViewData.confirmBtnMsg);
        this.mActivity.reFreshUI(this.mViewData);
    }

    @Override // com.baidu.wallet.paysdk.contract.OrderConfirmContract.Presenter
    public void gotoPayUsePwd(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            if (z) {
                this.mPayRequest.supportFingerprintPay = false;
                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION, null, new String[0]);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("pay_from", StatHelper.getPayFrom());
            ArrayList arrayList = new ArrayList();
            arrayList.add(StatHelper.getOrderNo());
            hashMap.put(StatHelper.PAY_WAY, "0");
            StatisticManager.onEventWithValues(PayStatServiceEvent.CHANGE_PAY_WAY, arrayList, hashMap);
            this.mPayRequest.setPayWay(3);
            this.mActivity.gotoNext(null, str);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.presenter.OrderConfirmPresenter.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OrderConfirmPresenter a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.getViewData();
                    }
                }
            }, 800L);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) || bundle == null) {
            return;
        }
        this.mViewData = (OrderConfirmContract.Presenter.OrderConfirmViewData) bundle.get("viewdata");
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            EventBus.getInstance().removeAllStickyEvents();
            EventBus.getInstance().unregister(this, "order_confirm_event_bus_key");
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.OrderConfirmContract.Presenter
    public void onFpCheckError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mActivity.showFpCheckError();
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.OrderConfirmContract.Presenter
    public void onFpCheckSucces(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mActivity.showFpCheckSuccess(str);
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, event) == null) && event != null && "order_confirm_event_bus_key".equals(event.mEventKey)) {
            Object obj = event.mEventObj;
            if (obj != null && (obj instanceof PayRequest)) {
                this.mPayRequest = (PayRequest) obj;
            }
            getViewData();
            EventBus.getInstance().removeStickyEvent("order_confirm_event_bus_key");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            bundle.putSerializable("viewdata", this.mViewData);
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.OrderConfirmContract.Presenter
    public void quitCashDesk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            PayCallBackManager.callBackClientCancel(this.mActivity, "OrderConfirmPresenter.quitCashDesk().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.OrderConfirmContract.Presenter
    public void startFingerprintListening() {
        IFingerprintPay iFingerprintPay;
        OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.mPayRequest.getPayWay() == 2 && (orderConfirmViewData = this.mViewData) != null) {
                orderConfirmViewData.isFingerprintPay = true;
            }
            this.mActivity.reFreshUI(this.mViewData);
            if (this.mPayRequest.getPayWay() != 2 || (iFingerprintPay = this.mPayRequest.mFingerprintPay) == null || !(iFingerprintPay instanceof SysFingerprintPay) || Build.VERSION.SDK_INT < 23) {
                return;
            }
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION);
            WalletFingerprint.getInstance(this.mActivity).startListening(new com.baidu.wallet.paysdk.fingerprint.b(this) { // from class: com.baidu.wallet.paysdk.presenter.OrderConfirmPresenter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OrderConfirmPresenter a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.wallet.paysdk.fingerprint.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION, null, new String[0]);
                        if (i2 == 0) {
                            StatHelper.cacheCodeAndMsg(i2 + "", StatHelper.SENSOR_OK);
                        } else {
                            StatHelper.cacheCodeAndMsg(i2 + "", str);
                        }
                        if (i2 == 0) {
                            this.a.onFpCheckSucces(str);
                        } else if (i2 == -5) {
                            this.a.onFpCheckError();
                        } else if (i2 == -3) {
                            this.a.gotoPayUsePwd(true, str);
                        } else if (i2 == -1) {
                            this.a.changePwdMode();
                        } else if (i2 == -4 || i2 == -6) {
                            this.a.gotoPayUsePwd(true, str);
                        } else if (i2 == -7) {
                            this.a.gotoPayUsePwd(true, str);
                        } else if (i2 == -2) {
                            this.a.gotoPayUsePwd(true, "");
                        }
                    }
                }
            });
        }
    }
}
