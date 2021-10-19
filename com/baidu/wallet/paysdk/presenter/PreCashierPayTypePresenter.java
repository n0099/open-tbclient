package com.baidu.wallet.paysdk.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class PreCashierPayTypePresenter extends PayTypeContract.Presenter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BALANCE = "balance";
    public static final String DEFAULT_PAY_DATA = "default_pay_data";
    public static final String EASYPAY = "easypay";
    public static final String TAG = "PreCashierPayTypePresenter";
    public transient /* synthetic */ FieldHolder $fh;
    public PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> mTupleDatasForPrecashier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreCashierPayTypePresenter(PayTypeActivity payTypeActivity) {
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

    private ArrayList<PayTypeItemView.PayTypeItemViewData> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (isFromClickChangePayType()) {
                PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier = this.mTupleDatasForPrecashier;
                return twoTupleForPrecashier == null ? new ArrayList<>() : getPrecashierData(twoTupleForPrecashier.datas);
            }
            return getNormalPayTypeListData();
        }
        return (ArrayList) invokeV.objValue;
    }

    private boolean isFromClickChangePayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier = this.mTupleDatasForPrecashier;
            return twoTupleForPrecashier != null && twoTupleForPrecashier.isFromChange().booleanValue();
        }
        return invokeV.booleanValue;
    }

    private void noticePayTypeChanged(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, payTypeItemViewData) == null) {
            PayTypeItemView.ItemViewType itemViewType = payTypeItemViewData.type;
            if (itemViewType == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                doBindCard(PrecashierModifyPayTypeManager.getInstance().getSpNo());
                return;
            }
            if (itemViewType.equals(PayTypeItemView.ItemViewType.BALANCE)) {
                PrecashierModifyPayTypeResponse precashierModifyPayTypeResponse = PrecashierModifyPayTypeResponse.getInstance();
                PayData.DirectPayBalance directPayBalance = (precashierModifyPayTypeResponse == null || (directPayPay = precashierModifyPayTypeResponse.pay) == null) ? null : directPayPay.balance;
                PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData = new PrecashierModifyPayTypeDefaultData();
                if (directPayBalance != null) {
                    precashierModifyPayTypeDefaultData.setDatas("balance", directPayBalance.balance_amount, null);
                }
                PayController.getInstance().onPreModifiedPayType(precashierModifyPayTypeDefaultData);
            } else if (payTypeItemViewData.type.equals(PayTypeItemView.ItemViewType.BANKCARD)) {
                PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData2 = new PrecashierModifyPayTypeDefaultData();
                PrecashierModifyPayTypeDefaultData.Card card = new PrecashierModifyPayTypeDefaultData.Card();
                CardData.BondCard bondCard = payTypeItemViewData.card;
                if (bondCard != null) {
                    card.account_no = bondCard.account_no;
                    card.bank_name = bondCard.bank_name;
                    card.single_quota = bondCard.single_quota;
                    card.bank_url = bondCard.bank_url;
                    CardData.BondCard.ChannelQuota channelQuota = bondCard.channel_quota;
                    if (channelQuota != null) {
                        card.single_limit = channelQuota.single_limit;
                        card.day_limit = channelQuota.day_limit;
                        card.month_limit = channelQuota.month_limit;
                    }
                }
                precashierModifyPayTypeDefaultData2.setDatas("easypay", null, card);
                PayController.getInstance().onPreModifiedPayType(precashierModifyPayTypeDefaultData2);
            }
            this.mActivity.finish();
        }
    }

    private void toCalculatePayAmount(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, payTypeItemViewData) == null) || payTypeItemViewData == null) {
            return;
        }
        if (payTypeItemViewData.isChecked) {
            this.mActivity.gotoPwdPay(false);
        } else if (payTypeItemViewData.type == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
            this.mActivity.gotoPwdPay(true);
        } else if (!PayDataCache.getInstance().needCalcPayment() && (payRequest = this.mPayRequest) != null) {
            payRequest.calcPayPriceByLocal(payTypeItemViewData);
            this.mActivity.gotoPwdPay(false);
        } else {
            calculatePayAmount(payTypeItemViewData);
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void afterCalculatePayamountGotoNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mActivity.gotoPwdPay(false);
        }
    }

    public void doBindCard(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            BaiduPay.getInstance().bindCard(this.mActivity, new BaiduPay.IBindCardCallback(this) { // from class: com.baidu.wallet.paysdk.presenter.PreCashierPayTypePresenter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PreCashierPayTypePresenter f62991a;

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
                    this.f62991a = this;
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeFailed(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) || this.f62991a.mActivity == null) {
                        return;
                    }
                    GlobalUtils.toast(this.f62991a.mActivity.getApplicationContext(), str2);
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeSucceed(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData = new PrecashierModifyPayTypeDefaultData();
                        precashierModifyPayTypeDefaultData.updated = 1;
                        PrecashierModifyPayTypeDefaultData.Card card = new PrecashierModifyPayTypeDefaultData.Card();
                        card.account_no = str2;
                        precashierModifyPayTypeDefaultData.card = card;
                        PayController.getInstance().onPreModifiedPayType(precashierModifyPayTypeDefaultData);
                        if (this.f62991a.mActivity != null) {
                            this.f62991a.mActivity.finish();
                        }
                    }
                }
            }, PayRequestCache.BindCategory.Initiative, 1, "2000", str, null, null, true, BeanConstants.FROM_BIND);
        }
    }

    public ArrayList<PayTypeItemView.PayTypeItemViewData> getPrecashierData(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
        InterceptResult invokeL;
        String str;
        UserData.UserModel userModel;
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, precashierModifyPayTypeDefaultData)) == null) {
            ArrayList<PayTypeItemView.PayTypeItemViewData> arrayList = new ArrayList<>();
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData = new PayTypeItemView.PayTypeItemViewData();
            payTypeItemViewData.type = PayTypeItemView.ItemViewType.BALANCE;
            String string = ResUtils.getString(this.mActivity, "ebpay_pwdpay_balance_txt");
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.fen2Yuan(!TextUtils.isEmpty(PayDataCache.getInstance().getCanAmount()) ? PayDataCache.getInstance().getCanAmount() : "");
            payTypeItemViewData.name = String.format(string, objArr);
            PrecashierModifyPayTypeResponse precashierModifyPayTypeResponse = PrecashierModifyPayTypeResponse.getInstance();
            PayData.DirectPayBalance directPayBalance = (precashierModifyPayTypeResponse == null || (directPayPay = precashierModifyPayTypeResponse.pay) == null) ? null : directPayPay.balance;
            if (precashierModifyPayTypeResponse != null && (userModel = precashierModifyPayTypeResponse.user) != null && userModel.isSupportBalance()) {
                if (directPayBalance != null && 1 == directPayBalance.status) {
                    payTypeItemViewData.isAvaible = true;
                    if (!TextUtils.isEmpty(directPayBalance.disabled_msg)) {
                        payTypeItemViewData.tips = directPayBalance.disabled_msg;
                        payTypeItemViewData.jump_url = directPayBalance.balance_jump_url;
                    } else {
                        payTypeItemViewData.tips = String.format(ResUtils.getString(this.mActivity, "ebpay_pwdpay_balance_tips"), StringUtils.fen2Yuan(directPayBalance.balance_amount));
                    }
                } else {
                    payTypeItemViewData.isAvaible = false;
                    if (directPayBalance != null) {
                        payTypeItemViewData.tips = directPayBalance.disabled_msg;
                        payTypeItemViewData.jump_url = directPayBalance.balance_jump_url;
                    }
                }
            } else {
                payTypeItemViewData.isAvaible = false;
                payTypeItemViewData.tips = PayDataCache.getInstance().getBalanceUnSupportReason();
            }
            if (directPayBalance != null) {
                payTypeItemViewData.isChecked = StringUtils.isAmountMoreThanZero(directPayBalance.balance_amount) && payTypeItemViewData.isAvaible && precashierModifyPayTypeDefaultData != null && "balance".equals(precashierModifyPayTypeDefaultData.getDefaultType());
            }
            arrayList.add(payTypeItemViewData);
            CardData.BondCard[] bondCards = precashierModifyPayTypeResponse != null ? precashierModifyPayTypeResponse.getBondCards() : null;
            if (bondCards != null && bondCards.length > 0) {
                for (int i2 = 0; i2 < bondCards.length; i2++) {
                    PayTypeItemView.PayTypeItemViewData payTypeItemViewData2 = new PayTypeItemView.PayTypeItemViewData();
                    payTypeItemViewData2.type = PayTypeItemView.ItemViewType.BANKCARD;
                    payTypeItemViewData2.hintMsg = bondCards[i2].card_hint_msg;
                    payTypeItemViewData2.hintUrl = bondCards[i2].card_hint_url;
                    if ("1".equals(bondCards[i2].card_state)) {
                        payTypeItemViewData2.isAvaible = true;
                        if (TextUtils.isEmpty(bondCards[i2].bank_card_msg)) {
                            str = !TextUtils.isEmpty(bondCards[i2].quota_show_msg) ? bondCards[i2].quota_show_msg : "";
                        } else {
                            str = bondCards[i2].bank_card_msg;
                        }
                        payTypeItemViewData2.tips = str;
                    } else {
                        payTypeItemViewData2.isAvaible = false;
                        payTypeItemViewData2.tips = bondCards[i2].bank_card_msg;
                    }
                    if (!TextUtils.isEmpty(bondCards[i2].bank_card_msg)) {
                        payTypeItemViewData2.tips = bondCards[i2].bank_card_msg;
                    }
                    payTypeItemViewData2.name = bondCards[i2].getCardDesc(this.mContext, true);
                    payTypeItemViewData2.card = bondCards[i2];
                    if (precashierModifyPayTypeDefaultData != null && !"balance".equals(precashierModifyPayTypeDefaultData.getDefaultType())) {
                        if (precashierModifyPayTypeDefaultData.getCard() != null) {
                            PrecashierModifyPayTypeDefaultData.Card card = precashierModifyPayTypeDefaultData.getCard();
                            if (!TextUtils.isEmpty(card.account_no) && bondCards[i2] != null && card.account_no.equals(bondCards[i2].account_no)) {
                                payTypeItemViewData2.isChecked = true;
                            }
                        }
                    } else {
                        payTypeItemViewData2.isChecked = false;
                    }
                    payTypeItemViewData2.logoUrl = bondCards[i2].bank_url;
                    arrayList.add(payTypeItemViewData2);
                }
            }
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData3 = new PayTypeItemView.PayTypeItemViewData();
            payTypeItemViewData3.isAvaible = PayDataCache.getInstance().enableAddBondCards();
            payTypeItemViewData3.type = PayTypeItemView.ItemViewType.ADD_NEWCARD;
            payTypeItemViewData3.name = ResUtils.getString(this.mActivity, "ebpay_use_new_card");
            if (!payTypeItemViewData3.isAvaible) {
                payTypeItemViewData3.tips = ResUtils.getString(this.mActivity, "ebpay_bankcard_fullof");
            }
            arrayList.add(payTypeItemViewData3);
            sortData(arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter, com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            super.handleResponse(i2, obj, str);
            if (i2 == 16) {
                this.mActivity.reFreshUI(getData());
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void modifyPayType(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, payTypeItemViewData) == null) || payTypeItemViewData == null) {
            return;
        }
        if (isFromClickChangePayType()) {
            noticePayTypeChanged(payTypeItemViewData);
        } else {
            toCalculatePayAmount(payTypeItemViewData);
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) && i2 == 1) {
            if (isFromClickChangePayType()) {
                PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData = new PrecashierModifyPayTypeDefaultData();
                precashierModifyPayTypeDefaultData.updated = 1;
                PayController.getInstance().onPreModifiedPayType(precashierModifyPayTypeDefaultData);
                PayBaseBeanActivity.exitEbpay();
                this.mActivity.finish();
                return;
            }
            reOrderPay();
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void onBackPressed() {
        PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                if (PayController.getInstance().getModifyPayTypeCallback() != null) {
                    PayController.getInstance().getModifyPayTypeCallback().onPayTypeModifiedFailed(-1, "");
                }
                PayController.getInstance().clearPreModifiedCallBack();
            }
            if (!PayDataCache.getInstance().isFromPreCashier() || (twoTupleForPrecashier = this.mTupleDatasForPrecashier) == null || twoTupleForPrecashier.isFromChange().booleanValue()) {
                return;
            }
            PayCallBackManager.callBackClientCancel(this.mActivity, "PreCashierPayTypePresenteronBackPressed().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            if (bundle == null) {
                this.mTupleDatasForPrecashier = (PrecashierModifyPayTypeManager.TwoTupleForPrecashier) this.mActivity.getIntent().getSerializableExtra(DEFAULT_PAY_DATA);
            } else {
                Serializable serializable = bundle.getSerializable("tuple_datas_for_precashier");
                if (serializable != null && (serializable instanceof PrecashierModifyPayTypeManager.TwoTupleForPrecashier)) {
                    this.mTupleDatasForPrecashier = (PrecashierModifyPayTypeManager.TwoTupleForPrecashier) serializable;
                }
            }
            this.mActivity.reFreshUI(getData());
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter, com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            EventBus.getInstance().unregister(this);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            bundle.putSerializable("tuple_datas_for_precashier", this.mTupleDatasForPrecashier);
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PayTypeContract.Presenter
    public void reOrderPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            PayBaseBeanActivity.exitEbpay();
            StatisticManager.onEvent("doPreCashierReorder");
            PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData = new PrecashierModifyPayTypeDefaultData();
            precashierModifyPayTypeDefaultData.updated = 1;
            PayController.getInstance().onPreModifiedPayType(precashierModifyPayTypeDefaultData);
            this.mActivity.finish();
        }
    }
}
