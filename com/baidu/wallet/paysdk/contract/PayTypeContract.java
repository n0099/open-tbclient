package com.baidu.wallet.paysdk.contract;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.d;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.presenter.NetWorkPresenter;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes13.dex */
public interface PayTypeContract {

    /* loaded from: classes13.dex */
    public static abstract class Presenter extends NetWorkPresenter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String TAG;
        public PayTypeActivity mActivity;
        public PayRequest mPayRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Presenter(PayTypeActivity payTypeActivity) {
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
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.TAG = toString();
            this.mActivity = payTypeActivity;
            payTypeActivity.setPresenter(this);
            this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }

        private void _loadOriginalStrategy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                if (PayDataCache.getInstance().isPassFree()) {
                    StatHelper.cachePayWay(2);
                    this.mPayRequest.setPayWay(1);
                } else if (this.mPayRequest.supportFingerprintPay) {
                    StatHelper.cachePayWay(1);
                    this.mPayRequest.setPayWay(2);
                } else {
                    StatHelper.cachePayWay(0);
                    this.mPayRequest.setPayWay(3);
                }
            }
        }

        public abstract void afterCalculatePayamountGotoNext();

        public void calculatePayAmount(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payTypeItemViewData) == null) {
                this.mActivity.showLoading(0);
                this.mActivity.setPageClickable(false);
                d dVar = (d) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 16, this.TAG);
                dVar.a(payTypeItemViewData);
                dVar.setResponseCallback(this);
                dVar.execBean();
            }
        }

        public ArrayList<PayTypeItemView.PayTypeItemViewData> getNormalPayTypeListData() {
            InterceptResult invokeV;
            PayData.DirectPayPay directPayPay;
            PayData.CreditPay creditPay;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList<PayTypeItemView.PayTypeItemViewData> arrayList = new ArrayList<>();
                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                CardData.BondCard[] bondCards = PayDataCache.getInstance().getBondCards();
                PayRequest.PayPrice payPrice = payRequest != null ? payRequest.getPayPrice() : null;
                if (payPrice == null || payRequest == null) {
                    return null;
                }
                if (bondCards != null && bondCards.length > 0) {
                    for (int i2 = 0; i2 < bondCards.length; i2++) {
                        PayTypeItemView.PayTypeItemViewData payTypeItemViewData = new PayTypeItemView.PayTypeItemViewData();
                        payTypeItemViewData.type = PayTypeItemView.ItemViewType.BANKCARD;
                        payTypeItemViewData.hintMsg = bondCards[i2].card_hint_msg;
                        payTypeItemViewData.hintUrl = bondCards[i2].card_hint_url;
                        if ("1".equals(bondCards[i2].card_state)) {
                            if (!payPrice.easypayIsEnable) {
                                payTypeItemViewData.isAvaible = false;
                                payTypeItemViewData.tips = payPrice.easyTipFromCalc;
                            } else {
                                payTypeItemViewData.isAvaible = true;
                                payTypeItemViewData.tips = !TextUtils.isEmpty(bondCards[i2].bank_card_msg) ? bondCards[i2].bank_card_msg : payPrice.easyTipFromCalc;
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
                        payTypeItemViewData.isRecommended = "1".equals(bondCards[i2].is_recommended);
                        arrayList.add(payTypeItemViewData);
                    }
                }
                PayTypeItemView.PayTypeItemViewData payTypeItemViewData2 = new PayTypeItemView.PayTypeItemViewData();
                payTypeItemViewData2.type = PayTypeItemView.ItemViewType.BALANCE;
                payTypeItemViewData2.name = String.format(ResUtils.getString(this.mActivity, "ebpay_pwdpay_balance_txt"), StringUtils.fen2Yuan(payPrice.balanceTotalAmount));
                if (PayDataCache.getInstance().isBalanceSupport()) {
                    if (payPrice.balanceIsEnable) {
                        payTypeItemViewData2.isAvaible = true;
                        payTypeItemViewData2.tips = String.format(ResUtils.getString(this.mActivity, "ebpay_pwdpay_balance_tips"), StringUtils.fen2Yuan(payPrice.balanceTransAmount));
                        PayData.DirectPayBalance balance = PayDataCache.getInstance().getBalance();
                        payTypeItemViewData2.isRecommended = balance == null ? false : "1".equals(balance.is_recommended);
                    } else {
                        payTypeItemViewData2.isAvaible = false;
                        payTypeItemViewData2.tips = payPrice.balanceTip;
                        payTypeItemViewData2.jump_url = payPrice.balanceJumpUrl;
                    }
                } else {
                    payTypeItemViewData2.isAvaible = false;
                    payTypeItemViewData2.tips = PayDataCache.getInstance().getBalanceUnSupportReason();
                }
                payTypeItemViewData2.isChecked = StringUtils.isAmountMoreThanZero(payPrice.balancePayAmount);
                arrayList.add(payTypeItemViewData2);
                if (PayDataCache.getInstance().isShowCreditPay()) {
                    PayTypeItemView.PayTypeItemViewData payTypeItemViewData3 = new PayTypeItemView.PayTypeItemViewData();
                    payTypeItemViewData3.type = PayTypeItemView.ItemViewType.CREDIT;
                    payTypeItemViewData3.isAvaible = payPrice.creditIsEnable;
                    payTypeItemViewData3.name = PayDataCache.getInstance().getPayResponse().pay.credit_pay.display_name;
                    if (payPrice.creditIsEnable) {
                        payTypeItemViewData3.isAvaible = true;
                        payTypeItemViewData3.tips = String.format(ResUtils.getString(this.mActivity, "ebpay_pwdpay_credit_tips"), StringUtils.fen2Yuan(payPrice.availableCredit));
                    } else {
                        payTypeItemViewData3.isAvaible = false;
                        if (!TextUtils.isEmpty(payPrice.creditTip)) {
                            payTypeItemViewData3.tips = payPrice.creditTip;
                        } else {
                            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                            if (payResponse != null && (directPayPay = payResponse.pay) != null && (creditPay = directPayPay.credit_pay) != null) {
                                payTypeItemViewData3.tips = creditPay.disable_msg;
                            }
                        }
                    }
                    payTypeItemViewData3.isChecked = StringUtils.isAmountMoreThanZero(payPrice.creditPayAmount);
                    arrayList.add(payTypeItemViewData3);
                }
                PayTypeItemView.PayTypeItemViewData payTypeItemViewData4 = new PayTypeItemView.PayTypeItemViewData();
                payTypeItemViewData4.isAvaible = PayDataCache.getInstance().enableAddBondCards();
                payTypeItemViewData4.type = PayTypeItemView.ItemViewType.ADD_NEWCARD;
                payTypeItemViewData4.name = ResUtils.getString(this.mActivity, "ebpay_use_new_card");
                if (!payTypeItemViewData4.isAvaible) {
                    payTypeItemViewData4.tips = ResUtils.getString(this.mActivity, "ebpay_bankcard_fullof");
                }
                arrayList.add(payTypeItemViewData4);
                sortData(arrayList);
                return arrayList;
            }
            return (ArrayList) invokeV.objValue;
        }

        public PayRequest getPayRequest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPayRequest : (PayRequest) invokeV.objValue;
        }

        @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
        public void handleFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
                this.mActivity.dismissLoading(0);
                GlobalUtils.toast(this.mActivity, str);
                this.mActivity.setPageClickable(true);
            }
        }

        @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
        public void handleResponse(int i2, Object obj, String str) {
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i2, obj, str) == null) {
                this.mActivity.dismissLoading(0);
                this.mActivity.setPageClickable(true);
                if (i2 == 16) {
                    CalcPaymentResponse calcPaymentResponse = obj instanceof CalcPaymentResponse ? (CalcPaymentResponse) obj : null;
                    PayTypeItemView payTypeItemView = this.mActivity.mClickedItemView;
                    if (payTypeItemView != null && (payTypeItemViewData = payTypeItemView.mData) != null) {
                        this.mPayRequest.mBondCard = payTypeItemViewData.card;
                    }
                    this.mPayRequest.setCalcPayment(calcPaymentResponse);
                    if (calcPaymentResponse != null) {
                        this.mPayRequest.calcPayPriceByRemote(calcPaymentResponse);
                    }
                    afterCalculatePayamountGotoNext();
                }
            }
        }

        public void modifyPayType(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
            PayTypeItemView.ItemViewType itemViewType;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, payTypeItemViewData) == null) || payTypeItemViewData == null || (itemViewType = payTypeItemViewData.type) == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                return;
            }
            if (itemViewType == PayTypeItemView.ItemViewType.BANKCARD) {
                CardData.BondCard bondCard = payTypeItemViewData.card;
                if (bondCard != null && !bondCard.isCompled()) {
                    this.mPayRequest.setPayWay(3);
                    StatHelper.cachePayWay(0);
                    return;
                }
                _loadOriginalStrategy();
                return;
            }
            _loadOriginalStrategy();
        }

        public abstract void onActivityResult(int i2, int i3, Intent intent);

        public abstract void onBackPressed();

        @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
        public void onDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                BeanManager.getInstance().removeAllBeans(this.TAG);
                this.mActivity = null;
            }
        }

        public abstract void reOrderPay();

        public void sortData(ArrayList<PayTypeItemView.PayTypeItemViewData> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, arrayList) == null) {
                Collections.sort(arrayList, new Comparator<Object>(this) { // from class: com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Presenter a;

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

                    @Override // java.util.Comparator
                    public int compare(Object obj, Object obj2) {
                        InterceptResult invokeLL;
                        PayTypeItemView.PayTypeItemViewData payTypeItemViewData;
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) {
                            PayTypeItemView.PayTypeItemViewData payTypeItemViewData2 = null;
                            if ((obj instanceof PayTypeItemView.PayTypeItemViewData) && (obj2 instanceof PayTypeItemView.PayTypeItemViewData)) {
                                payTypeItemViewData2 = (PayTypeItemView.PayTypeItemViewData) obj;
                                payTypeItemViewData = (PayTypeItemView.PayTypeItemViewData) obj2;
                            } else {
                                payTypeItemViewData = null;
                            }
                            if (payTypeItemViewData2 == null || payTypeItemViewData == null) {
                                return -1;
                            }
                            int i3 = 1000;
                            if (payTypeItemViewData2.type == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                                i2 = 1000;
                            } else {
                                i2 = payTypeItemViewData2.isAvaible ? 2000 : 0;
                            }
                            if (payTypeItemViewData.type != PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                                i3 = payTypeItemViewData.isAvaible ? 2000 : 0;
                            }
                            PayTypeItemView.ItemViewType itemViewType = payTypeItemViewData2.type;
                            if (itemViewType == PayTypeItemView.ItemViewType.BALANCE) {
                                i2 += 3;
                            } else if (itemViewType == PayTypeItemView.ItemViewType.CREDIT) {
                                i2 += 2;
                            } else if (itemViewType == PayTypeItemView.ItemViewType.BANKCARD) {
                                i2++;
                            }
                            PayTypeItemView.ItemViewType itemViewType2 = payTypeItemViewData.type;
                            if (itemViewType2 == PayTypeItemView.ItemViewType.BALANCE) {
                                i3 += 3;
                            } else if (itemViewType2 == PayTypeItemView.ItemViewType.CREDIT) {
                                i3 += 2;
                            } else if (itemViewType2 == PayTypeItemView.ItemViewType.BANKCARD) {
                                i3++;
                            }
                            return -(i2 - i3);
                        }
                        return invokeLL.intValue;
                    }
                });
            }
        }
    }
}
