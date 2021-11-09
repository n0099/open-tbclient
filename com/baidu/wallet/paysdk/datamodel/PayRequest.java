package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.Withholding;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.fingerprint.FpConstancts;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.dxmpay.apollon.utils.EncodeUtils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
/* loaded from: classes10.dex */
public class PayRequest extends BeanRequestBase implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CASHIER_TYPE_ZHUAN_ZHANG = "1";
    public static final int FINGERPRINT_PAY = 2;
    public static final int FP_OPEN = 1;
    public static final int FP_REOPEN = 2;
    public static final int FP_UPGRADE = 3;
    public static final int PASSFREE_PAY = 1;
    public static final int PWD_PAY = 3;
    public static final String TAG = "PayRequest";
    public static final long serialVersionUID = 7746294089503922286L;
    public transient /* synthetic */ FieldHolder $fh;
    public int FP_Guide_Strategy;
    public boolean isPayByMktSolution;
    public String mBankCardNumber;
    public CardData.BondCard mBondCard;
    public CalcPaymentResponse mCalcPayMent;
    public String mCashierType;
    public String mChannelNo;
    public String mCvv2;
    public IFingerprintPay mFingerprintPay;
    public int mFlagOpenPassFree;
    public String mGoodName;
    public String mGoodsCategory;
    public String mIdCard;
    public String mLivingKey;
    public String mLivingResultCode;
    public ErrorContentResponse.MktSolution mMktSolution;
    public String mOrderNo;
    public String mParams;
    public String mPayFrom;
    public String mPayFromFromH5;
    public PayPrice mPayPrice;
    public String mPrice;
    public String mRemotePayHostName;
    public String mRemotePayUserAccountName;
    public String mRemotePayUserId;
    public String mRemotePkg;
    public String mRemoteWhereToBackAct;
    public String mSecurityParams;
    public String mSmsCode;
    public String mSpNO;
    public String mUseVcodeToPay;
    public String otp_seed;
    public int payWay;
    public PayData.RandomDiscount randomDiscount;
    public String sp_voice_info;
    public boolean supportFingerprintPay;
    public String title_url;
    public String verify_type;
    public Withholding withholding;
    public String withholding_auth;

    /* loaded from: classes10.dex */
    public static class PayPrice implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String availableCredit;
        public boolean balanceIsEnable;
        public String balanceJumpUrl;
        public String balancePayAmount;
        public String balanceTip;
        public String balanceTotalAmount;
        public String balanceTransAmount;
        public boolean creditIsEnable;
        public String creditPayAmount;
        public String creditTip;
        public String easyPrice;
        public String easyTipFromCalc;
        public boolean easypayIsEnable;
        public PayType payType;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes10.dex */
        public static final class PayType {
            public static final /* synthetic */ PayType[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final PayType BALANCE;
            public static final PayType BANKCARD;
            public static final PayType CREIDT;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-267475292, "Lcom/baidu/wallet/paysdk/datamodel/PayRequest$PayPrice$PayType;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-267475292, "Lcom/baidu/wallet/paysdk/datamodel/PayRequest$PayPrice$PayType;");
                        return;
                    }
                }
                BANKCARD = new PayType("BANKCARD", 0);
                BALANCE = new PayType("BALANCE", 1);
                PayType payType = new PayType("CREIDT", 2);
                CREIDT = payType;
                $VALUES = new PayType[]{BANKCARD, BALANCE, payType};
            }

            public PayType(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static PayType valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PayType) Enum.valueOf(PayType.class, str) : (PayType) invokeL.objValue;
            }

            public static PayType[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PayType[]) $VALUES.clone() : (PayType[]) invokeV.objValue;
            }
        }

        public PayPrice() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.creditIsEnable = true;
            this.availableCredit = "0";
            reset();
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.payType = PayType.BANKCARD;
                this.balanceIsEnable = false;
                this.balanceTip = "";
                this.balancePayAmount = "0";
                this.balanceJumpUrl = "";
                this.creditIsEnable = true;
                this.creditPayAmount = "0";
                this.creditTip = "";
                this.easypayIsEnable = false;
                this.easyPrice = "0";
                this.easyTipFromCalc = "";
                this.balanceTotalAmount = PayDataCache.getInstance().getTotalBalance();
                this.balanceTransAmount = "";
                this.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                if (payRequest == null) {
                    return "oh, return super.toString = " + super.toString();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(" ： payType= ");
                sb.append(this.payType);
                sb.append("\r\n && easypayIsEnable=");
                sb.append(this.easypayIsEnable);
                sb.append(" && bondCard=");
                CardData.BondCard bondCard = payRequest.mBondCard;
                sb.append(bondCard != null ? bondCard.account_no : "NULL");
                sb.append(" && easyPrice=");
                sb.append(this.easyPrice);
                sb.append(" && easyTip=");
                sb.append(this.easyTipFromCalc);
                sb.append(" \r\n && balanceIsEnable=");
                sb.append(this.balanceIsEnable);
                sb.append(" && balanceTransAmount=");
                sb.append(this.balanceTransAmount);
                sb.append(" && balancePayAmount=");
                sb.append(this.balancePayAmount);
                sb.append(" && balanceTip=");
                sb.append(this.balanceTip);
                sb.append(" \r\n && creditIsEnable=");
                sb.append(this.creditIsEnable);
                sb.append(" && creditPayAmount=");
                sb.append(this.creditPayAmount);
                sb.append(" && creditTip=");
                sb.append(this.creditTip);
                sb.append(" && availableCredit");
                sb.append(this.availableCredit);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public PayRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPayFrom = "";
        this.mUseVcodeToPay = null;
        this.mChannelNo = "";
        this.isPayByMktSolution = false;
        this.sp_voice_info = "";
        this.verify_type = "";
        this.mFlagOpenPassFree = 0;
        this.payWay = 3;
    }

    private void balancePay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            PayPrice payPrice = this.mPayPrice;
            payPrice.payType = PayPrice.PayType.BALANCE;
            payPrice.balanceIsEnable = true;
            payPrice.balancePayAmount = this.mPrice;
            payPrice.balanceTransAmount = getBalanceTransAmount();
            PayPrice payPrice2 = this.mPayPrice;
            payPrice2.balanceTip = "";
            payPrice2.balanceJumpUrl = "";
            payPrice2.easypayIsEnable = PayDataCache.getInstance().canUseEasypay();
            PayPrice payPrice3 = this.mPayPrice;
            payPrice3.easyPrice = "0";
            payPrice3.easyTipFromCalc = "";
            PayDataCache.b<Boolean, String> canUseCredit = PayDataCache.getInstance().canUseCredit();
            this.mPayPrice.creditIsEnable = canUseCredit.f59965a.booleanValue();
            PayPrice payPrice4 = this.mPayPrice;
            payPrice4.creditTip = canUseCredit.f59966b;
            payPrice4.creditPayAmount = "0";
            payPrice4.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
        }
    }

    private void creditPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            PayPrice payPrice = this.mPayPrice;
            payPrice.payType = PayPrice.PayType.CREIDT;
            payPrice.creditIsEnable = true;
            payPrice.creditPayAmount = this.mPrice;
            payPrice.creditTip = "";
            payPrice.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
            PayDataCache.b<Boolean, String> canUseBalance = PayDataCache.getInstance().canUseBalance();
            this.mPayPrice.balanceIsEnable = canUseBalance.f59965a.booleanValue();
            PayPrice payPrice2 = this.mPayPrice;
            payPrice2.balanceTip = canUseBalance.f59966b;
            payPrice2.balanceJumpUrl = PayDataCache.getInstance().getBalanceJumpUrl();
            PayPrice payPrice3 = this.mPayPrice;
            payPrice3.balancePayAmount = "0";
            payPrice3.balanceTransAmount = getBalanceTransAmount();
            this.mPayPrice.easypayIsEnable = PayDataCache.getInstance().canUseEasypay();
            PayPrice payPrice4 = this.mPayPrice;
            payPrice4.easyPrice = "0";
            payPrice4.easyTipFromCalc = "";
        }
    }

    private void easypay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            PayPrice payPrice = this.mPayPrice;
            payPrice.payType = PayPrice.PayType.BANKCARD;
            payPrice.easypayIsEnable = true;
            payPrice.easyPrice = this.mPrice;
            CardData.BondCard selectedCard = getSelectedCard();
            this.mBondCard = selectedCard;
            if (selectedCard == null) {
                this.mBondCard = getDefaultBankCardIdx();
            }
            PayDataCache.b<Boolean, String> canUseBalance = PayDataCache.getInstance().canUseBalance();
            this.mPayPrice.balanceIsEnable = canUseBalance.f59965a.booleanValue();
            PayPrice payPrice2 = this.mPayPrice;
            payPrice2.balanceTip = canUseBalance.f59966b;
            payPrice2.balanceJumpUrl = PayDataCache.getInstance().getBalanceJumpUrl();
            PayPrice payPrice3 = this.mPayPrice;
            payPrice3.balancePayAmount = "0";
            payPrice3.balanceTransAmount = getBalanceTransAmount();
            PayDataCache.b<Boolean, String> canUseCredit = PayDataCache.getInstance().canUseCredit();
            this.mPayPrice.creditIsEnable = canUseCredit.f59965a.booleanValue();
            PayPrice payPrice4 = this.mPayPrice;
            payPrice4.creditTip = canUseCredit.f59966b;
            payPrice4.creditPayAmount = "0";
            payPrice4.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
        }
    }

    private String getEffectiveAmount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) ? TextUtils.isEmpty(str) ? "0" : str : (String) invokeL.objValue;
    }

    private boolean showRandomDiscount() {
        InterceptResult invokeV;
        PayData.RandomDiscount randomDiscount;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (showCouponListEntry()) {
                return false;
            }
            CardData.BondCard bondCard = this.mBondCard;
            if ((bondCard == null || TextUtils.isEmpty(bondCard.channelDiscountDesc)) && (randomDiscount = this.randomDiscount) != null && !TextUtils.isEmpty(randomDiscount.msg) && (strArr = this.randomDiscount.paytype) != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.randomDiscount.paytype;
                    if (i2 >= strArr2.length) {
                        break;
                    } else if (TextUtils.equals("balance", strArr2[i2]) && this.mPayPrice.payType == PayPrice.PayType.BALANCE) {
                        return true;
                    } else {
                        if (TextUtils.equals("easypay", this.randomDiscount.paytype[i2]) && this.mPayPrice.payType == PayPrice.PayType.BANKCARD) {
                            return true;
                        }
                        i2++;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void applyNoPwd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.mFlagOpenPassFree = z ? 1 : 0;
        }
    }

    public void calcPayPriceByLocal(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payTypeItemViewData) == null) || payTypeItemViewData == null) {
            return;
        }
        PayTypeItemView.ItemViewType itemViewType = payTypeItemViewData.type;
        if (itemViewType == PayTypeItemView.ItemViewType.BANKCARD) {
            this.mPayPrice.payType = PayPrice.PayType.BANKCARD;
            BigDecimal bigDecimal = new BigDecimal(this.mPrice);
            if (StringUtils.isAmountMoreThanZero(getDiscountAmount())) {
                bigDecimal = bigDecimal.subtract(new BigDecimal(getDiscountAmount()));
            }
            this.mPayPrice.easyPrice = bigDecimal.toString();
            PayPrice payPrice = this.mPayPrice;
            payPrice.balancePayAmount = "0";
            payPrice.creditPayAmount = "0";
            this.mBondCard = payTypeItemViewData.card;
        } else if (itemViewType == PayTypeItemView.ItemViewType.BALANCE) {
            PayPrice payPrice2 = this.mPayPrice;
            payPrice2.payType = PayPrice.PayType.BALANCE;
            payPrice2.balanceIsEnable = true;
            payPrice2.balancePayAmount = this.mPrice;
            this.mBondCard = null;
            payPrice2.easyPrice = "0";
            payPrice2.creditPayAmount = "0";
        } else if (itemViewType == PayTypeItemView.ItemViewType.CREDIT) {
            PayPrice payPrice3 = this.mPayPrice;
            payPrice3.payType = PayPrice.PayType.CREIDT;
            payPrice3.creditIsEnable = true;
            payPrice3.creditPayAmount = this.mPrice;
            this.mBondCard = null;
            payPrice3.easyPrice = "0";
            payPrice3.balancePayAmount = "0";
        }
        String str = "本地计算金额之后的payprice是： " + this.mPayPrice;
    }

    public void calcPayPriceByRemote(CalcPaymentResponse calcPaymentResponse) {
        PayPrice payPrice;
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, calcPaymentResponse) == null) || calcPaymentResponse == null || (payPrice = this.mPayPrice) == null) {
            return;
        }
        payPrice.easyPrice = calcPaymentResponse.easypay_amount;
        payPrice.easypayIsEnable = StringUtils.isAmountMoreThanZero(calcPaymentResponse.easypay_trans_amount);
        if (this.mPayPrice.easypayIsEnable && StringUtils.isAmountMoreThanZero(calcPaymentResponse.easypay_amount)) {
            this.mPayPrice.payType = PayPrice.PayType.BANKCARD;
            if (this.mBondCard == null) {
                this.mBondCard = getDefaultBankCardIdx();
            }
        }
        PayPrice payPrice2 = this.mPayPrice;
        payPrice2.easyTipFromCalc = calcPaymentResponse.easypay_select_desc;
        String str = calcPaymentResponse.balance_amount;
        payPrice2.balancePayAmount = str;
        if (StringUtils.isAmountMoreThanZero(str)) {
            this.mPayPrice.payType = PayPrice.PayType.BALANCE;
        }
        this.mPayPrice.balanceIsEnable = StringUtils.isAmountMoreThanZero(calcPaymentResponse.balance_trans_amount);
        if (!this.mPayPrice.balanceIsEnable) {
            if (!TextUtils.isEmpty(calcPaymentResponse.balance_select_desc)) {
                PayPrice payPrice3 = this.mPayPrice;
                payPrice3.balanceTip = calcPaymentResponse.balance_select_desc;
                payPrice3.balanceJumpUrl = calcPaymentResponse.balance_jump_url;
            } else {
                DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                if (payResponse != null && (directPayPay = payResponse.pay) != null && (directPayBalance = directPayPay.balance) != null && !TextUtils.isEmpty(directPayBalance.disabled_msg)) {
                    PayPrice payPrice4 = this.mPayPrice;
                    PayData.DirectPayBalance directPayBalance2 = payResponse.pay.balance;
                    payPrice4.balanceTip = directPayBalance2.disabled_msg;
                    payPrice4.balanceJumpUrl = directPayBalance2.balance_jump_url;
                }
            }
        }
        PayPrice payPrice5 = this.mPayPrice;
        payPrice5.balanceTransAmount = calcPaymentResponse.balance_trans_amount;
        String str2 = calcPaymentResponse.credit_amount;
        payPrice5.creditPayAmount = str2;
        if (StringUtils.isAmountMoreThanZero(str2)) {
            this.mPayPrice.payType = PayPrice.PayType.CREIDT;
        }
        this.mPayPrice.creditIsEnable = StringUtils.isAmountMoreThanZero(calcPaymentResponse.credit_trans_amount);
        this.mPayPrice.creditTip = calcPaymentResponse.credit_select_desc;
        String str3 = "服务器计算金额之后的payprice是： " + this.mPayPrice;
    }

    @Override // com.dxmpay.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BaiduPay.PAY_FROM_BIND_CARD.equals(this.mPayFrom) ? (TextUtils.isEmpty(this.mSpNO) || TextUtils.isEmpty(this.mParams)) ? false : true : (TextUtils.isEmpty(this.mSpNO) || TextUtils.isEmpty(this.mOrderNo) || TextUtils.isEmpty(this.mPrice)) ? false : true : invokeV.booleanValue;
    }

    public void clearFingerPrintData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void clearMktSolution() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.isPayByMktSolution = false;
            this.mMktSolution = null;
        }
    }

    public PayData.Discount[] getActivityDiscount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
            if (calcPaymentResponse != null) {
                return calcPaymentResponse.activity_list;
            }
            return null;
        }
        return (PayData.Discount[]) invokeV.objValue;
    }

    public String getBalancePayAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PayPrice payPrice = this.mPayPrice;
            return payPrice != null ? payPrice.balancePayAmount : "";
        }
        return (String) invokeV.objValue;
    }

    public String getBalanceSelectStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            PayPrice payPrice = this.mPayPrice;
            return (payPrice == null || !StringUtils.isAmountMoreThanZero(payPrice.balancePayAmount)) ? "0" : "1";
        }
        return (String) invokeV.objValue;
    }

    public String getBalanceTransAmount() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
            if (calcPaymentResponse != null) {
                return calcPaymentResponse.balance_trans_amount;
            }
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse == null || (directPayPay = payResponse.pay) == null || (directPayBalance = directPayPay.balance) == null || TextUtils.isEmpty(directPayBalance.balance_trans_amount)) {
                return "0";
            }
            if (new BigDecimal(this.mPrice).compareTo(new BigDecimal(payResponse.pay.balance.balance_trans_amount)) > 0) {
                return payResponse.pay.balance.balance_trans_amount;
            }
            return this.mPrice;
        }
        return (String) invokeV.objValue;
    }

    public CalcPaymentResponse getCalcPayment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mCalcPayMent : (CalcPaymentResponse) invokeV.objValue;
    }

    public CardData.BondCard getCardByCardNo(String str) {
        InterceptResult invokeL;
        CardData.BondCard[] bondCards;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (bondCards = PayDataCache.getInstance().getBondCards()) == null || bondCards.length <= 0) {
                return null;
            }
            for (CardData.BondCard bondCard : bondCards) {
                if (bondCard != null && str.equals(bondCard.account_no)) {
                    return bondCard;
                }
            }
            return null;
        }
        return (CardData.BondCard) invokeL.objValue;
    }

    public String getCreditPaySelectStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PayPrice payPrice = this.mPayPrice;
            return (payPrice == null || !StringUtils.isAmountMoreThanZero(payPrice.creditPayAmount)) ? "0" : "1";
        }
        return (String) invokeV.objValue;
    }

    public String getCreditTotalAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PayPrice payPrice = this.mPayPrice;
            return payPrice != null ? payPrice.availableCredit : "0";
        }
        return (String) invokeV.objValue;
    }

    public CardData.BondCard getDefaultBankCardIdx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            CardData.BondCard[] bondCards = PayDataCache.getInstance().getBondCards();
            if (bondCards != null && bondCards.length != 0) {
                boolean z = true;
                int i2 = 0;
                for (CardData.BondCard bondCard : bondCards) {
                    if ("1".equals(bondCard.card_state)) {
                        if (bondCard.isCompled()) {
                            return bondCard;
                        }
                        z = false;
                    }
                    i2++;
                }
                if (!z && i2 >= bondCards.length) {
                    return bondCards[0];
                }
            }
            return null;
        }
        return (CardData.BondCard) invokeV.objValue;
    }

    public String getDiscountAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
            return calcPaymentResponse != null ? calcPaymentResponse.total_discount_amount : "";
        }
        return (String) invokeV.objValue;
    }

    public String getDiscountMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
            return calcPaymentResponse != null ? calcPaymentResponse.total_discount_msg : "";
        }
        return (String) invokeV.objValue;
    }

    public String getEasyPayAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            PayPrice payPrice = this.mPayPrice;
            if (payPrice != null && !TextUtils.isEmpty(payPrice.easyPrice)) {
                return this.mPayPrice.easyPrice;
            }
            return this.mPrice;
        }
        return (String) invokeV.objValue;
    }

    public int getFP_Guide_Strategy(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) {
            if (((Integer) SharedPreferencesUtils.getParam(context, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, "resultPageShowFpCounts", 3)).intValue() <= 0) {
                return 0;
            }
            return this.FP_Guide_Strategy;
        }
        return invokeL.intValue;
    }

    public String getFinalPayAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.mPayPrice == null) {
                return this.mPrice;
            }
            return new BigDecimal(getEffectiveAmount(this.mPayPrice.easyPrice)).add(new BigDecimal(getEffectiveAmount(this.mPayPrice.balancePayAmount))).add(new BigDecimal(getEffectiveAmount(this.mPayPrice.creditPayAmount))).toString();
        }
        return (String) invokeV.objValue;
    }

    public String getGoodsName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mGoodName : (String) invokeV.objValue;
    }

    public String getNeedToPayAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            BigDecimal bigDecimal = new BigDecimal(this.mPrice);
            CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
            if (calcPaymentResponse != null && calcPaymentResponse.total_discount_amount != null) {
                bigDecimal = bigDecimal.subtract(new BigDecimal(this.mCalcPayMent.total_discount_amount));
            }
            return bigDecimal.toString();
        }
        return (String) invokeV.objValue;
    }

    public int getOpenPassFreeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mFlagOpenPassFree : invokeV.intValue;
    }

    public String getOrderPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mPrice : (String) invokeV.objValue;
    }

    public String getPayFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.mPayFrom == null) {
                this.mPayFrom = "";
            }
            return this.mPayFrom;
        }
        return (String) invokeV.objValue;
    }

    public PayPrice getPayPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mPayPrice : (PayPrice) invokeV.objValue;
    }

    public int getPayWay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.payWay : invokeV.intValue;
    }

    public String getRandomDiscountMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (showRandomDiscount()) {
                return this.randomDiscount.msg;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            setBelongPaySdk();
            return BeanConstants.REQUEST_ID_PAY;
        }
        return (String) invokeV.objValue;
    }

    public CardData.BondCard getSelectedCard() {
        InterceptResult invokeV;
        CardData.BondCard[] bondCards;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            String selectedCardNo = PayDataCache.getInstance().getSelectedCardNo();
            if (TextUtils.isEmpty(selectedCardNo) || (bondCards = PayDataCache.getInstance().getBondCards()) == null || bondCards.length <= 0) {
                return null;
            }
            for (CardData.BondCard bondCard : bondCards) {
                if (bondCard != null && selectedCardNo.equals(bondCard.account_no)) {
                    return bondCard;
                }
            }
            return null;
        }
        return (CardData.BondCard) invokeV.objValue;
    }

    public String getmBankCardNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mBankCardNumber : (String) invokeV.objValue;
    }

    public String getmCvv2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mCvv2 : (String) invokeV.objValue;
    }

    public String getmIdCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mIdCard : (String) invokeV.objValue;
    }

    public boolean hasCashDeskCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? !TextUtils.isEmpty(this.mParams) && this.mParams.contains("cashdesk_code") : invokeV.booleanValue;
    }

    public boolean hasDiscountOrCoupon() {
        InterceptResult invokeV;
        PayData.Coupon[] couponArr;
        PayData.Discount[] discountArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
            if (calcPaymentResponse == null || (discountArr = calcPaymentResponse.activity_list) == null || discountArr.length <= 0) {
                CalcPaymentResponse calcPaymentResponse2 = this.mCalcPayMent;
                return (calcPaymentResponse2 == null || (couponArr = calcPaymentResponse2.coupon_list) == null || couponArr.length <= 0) ? false : true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void initBalanceChargeOrder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.mGoodName = "余额充值";
            this.mPrice = str;
            this.mParams = "total_amount=" + this.mPrice;
        }
    }

    public void initBindCardOrder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.mParams = str;
            if (str.contains("input_charset=1")) {
                String str2 = "";
                try {
                    String decode = URLDecoder.decode(str, "gbk");
                    String str3 = "gbkParams=" + decode;
                    str2 = EncodeUtils.gbk2utf8(decode);
                    String str4 = "转 utf8 tmpParam=" + str2;
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
            }
            this.mSpNO = getSinalParam(str, "SP_NO");
            this.mOrderNo = getSinalParam(str, "ORDER_NO");
        }
    }

    public void initOrder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.mParams = str;
            if (str.contains("input_charset=1")) {
                String str2 = "";
                try {
                    String decode = URLDecoder.decode(str, "gbk");
                    String str3 = "gbkParams=" + decode;
                    str2 = EncodeUtils.gbk2utf8(decode);
                    String str4 = "转 utf8 tmpParam=" + str2;
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                }
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
            }
            this.mSpNO = getSinalParam(str, "SP_NO");
            this.mOrderNo = getSinalParam(str, "ORDER_NO");
            this.mPrice = getSinalParam(str, "TOTAL_AMOUNT");
            this.mGoodName = getSinalParam(str, "GOODS_NAME");
            this.mGoodsCategory = getSinalParam(str, "GOODS_CATEGORY");
            if (TextUtils.isEmpty(this.mGoodName)) {
                this.mGoodName = getSinalParam(str, "GOODS_DESC");
            }
            this.mCashierType = getSinalParam(str, "CASHIER_TYPE");
            this.mPayFromFromH5 = getSinalParam(str, "PAY_FROM");
            if (isZhuanZhangCashier()) {
                this.mPayFrom = BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG;
            } else if (isSignatureCashier()) {
                this.mPayFrom = BaiduPay.PAY_FROM_AUTHORIZE;
            }
            StatHelper.cacheSpNo(this.mSpNO);
            StatHelper.cacheOrderNo(this.mOrderNo);
        }
    }

    public void initPayStrategy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, context) == null) {
            this.mPayPrice = new PayPrice();
            if (PayDataCache.getInstance().hasMobilePwd()) {
                DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                boolean z = WalletFingerprint.getInstance(context).getFingerprintPay() instanceof SysFingerprintPay;
                if (!PayDataCache.getInstance().isPassFree() && !com.baidu.wallet.paysdk.a.b.a()) {
                    if ("1".equalsIgnoreCase(payResponse.user.enable_fingerprint)) {
                        if (z && WalletFingerprint.getInstance(context).hasEnrollFingerprint()) {
                            if (WalletFingerprint.getInstance(context).hasOTPToken()) {
                                this.mFingerprintPay = WalletFingerprint.getInstance(context).getFingerprintPay(WalletFingerprint.FpType.SYSTEM_FINGERPRINT);
                                this.supportFingerprintPay = true;
                                setPayWay(2);
                            } else if ("1".equalsIgnoreCase(payResponse.user.guide_to_open_fingerprint)) {
                                this.FP_Guide_Strategy = 2;
                            }
                        }
                    } else if (z && !WalletFingerprint.getInstance(context).hasOTPToken() && "1".equalsIgnoreCase(payResponse.user.guide_to_open_fingerprint) && WalletFingerprint.getInstance(context).hasEnrollFingerprint()) {
                        this.FP_Guide_Strategy = 1;
                    }
                }
                if ("easypay".equals(PayDataCache.getInstance().getDefaultPayType())) {
                    easypay();
                    return;
                } else if ("balance".equals(PayDataCache.getInstance().getDefaultPayType())) {
                    balancePay();
                    return;
                } else if (PayDataCache.PAY_TYPE_CREDITPAY.equals(PayDataCache.getInstance().getDefaultPayType())) {
                    creditPay();
                    return;
                } else if (PayDataCache.PAY_TYPE_COMPOSITE.equals(PayDataCache.getInstance().getDefaultPayType())) {
                    calcPayPriceByRemote(this.mCalcPayMent);
                    return;
                } else {
                    PayPrice payPrice = this.mPayPrice;
                    payPrice.payType = PayPrice.PayType.BANKCARD;
                    payPrice.easypayIsEnable = true;
                    this.mBondCard = null;
                    CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
                    if (calcPaymentResponse != null) {
                        payPrice.easyPrice = calcPaymentResponse.easypay_amount;
                        payPrice.balanceIsEnable = StringUtils.isAmountMoreThanZero(calcPaymentResponse.balance_trans_amount);
                        PayPrice payPrice2 = this.mPayPrice;
                        CalcPaymentResponse calcPaymentResponse2 = this.mCalcPayMent;
                        payPrice2.balanceTip = calcPaymentResponse2.balance_select_desc;
                        payPrice2.balanceJumpUrl = calcPaymentResponse2.balance_jump_url;
                        payPrice2.balancePayAmount = "0";
                        payPrice2.balanceTransAmount = calcPaymentResponse2.balance_trans_amount;
                        payPrice2.creditIsEnable = StringUtils.isAmountMoreThanZero(calcPaymentResponse2.credit_trans_amount);
                        PayPrice payPrice3 = this.mPayPrice;
                        payPrice3.creditTip = this.mCalcPayMent.credit_select_desc;
                        payPrice3.creditPayAmount = "0";
                        payPrice3.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
                        return;
                    }
                    payPrice.easyPrice = this.mPrice;
                    PayDataCache.b<Boolean, String> canUseBalance = PayDataCache.getInstance().canUseBalance();
                    this.mPayPrice.balanceIsEnable = canUseBalance.f59965a.booleanValue();
                    PayPrice payPrice4 = this.mPayPrice;
                    payPrice4.balanceTip = canUseBalance.f59966b;
                    payPrice4.balanceJumpUrl = PayDataCache.getInstance().getBalanceJumpUrl();
                    PayPrice payPrice5 = this.mPayPrice;
                    payPrice5.balancePayAmount = "0";
                    payPrice5.balanceTransAmount = getBalanceTransAmount();
                    PayDataCache.b<Boolean, String> canUseCredit = PayDataCache.getInstance().canUseCredit();
                    this.mPayPrice.creditIsEnable = canUseCredit.f59965a.booleanValue();
                    PayPrice payPrice6 = this.mPayPrice;
                    payPrice6.creditTip = canUseCredit.f59966b;
                    payPrice6.creditPayAmount = "0";
                    payPrice6.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
                    return;
                }
            }
            CalcPaymentResponse calcPaymentResponse3 = this.mCalcPayMent;
            if (calcPaymentResponse3 != null) {
                calcPayPriceByRemote(calcPaymentResponse3);
            } else {
                easypay();
            }
        }
    }

    public boolean isSignatureCashier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (TextUtils.isEmpty(this.mPayFromFromH5)) {
                return false;
            }
            return BaiduPay.PAY_FROM_AUTHORIZE.equals(this.mPayFromFromH5);
        }
        return invokeV.booleanValue;
    }

    public String isTransfer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG.equals(this.mPayFrom) ? "1" : "0" : (String) invokeV.objValue;
    }

    public boolean isWithHoldingValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            Withholding withholding = this.withholding;
            return withholding != null && "1".equals(withholding.status);
        }
        return invokeV.booleanValue;
    }

    public boolean isZhuanZhangCashier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (TextUtils.isEmpty(this.mCashierType)) {
                return false;
            }
            return "1".equals(this.mCashierType);
        }
        return invokeV.booleanValue;
    }

    public void revert(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, payTypeItemViewData) == null) && payTypeItemViewData.type == PayTypeItemView.ItemViewType.BANKCARD) {
            this.mPayPrice.payType = PayPrice.PayType.BANKCARD;
            BigDecimal bigDecimal = new BigDecimal(this.mPrice);
            if (StringUtils.isAmountMoreThanZero(getDiscountAmount())) {
                bigDecimal = bigDecimal.subtract(new BigDecimal(getDiscountAmount()));
            }
            this.mPayPrice.easyPrice = bigDecimal.toString();
            PayPrice payPrice = this.mPayPrice;
            payPrice.balancePayAmount = "0";
            payPrice.creditPayAmount = "0";
            this.mBondCard = payTypeItemViewData.card;
        }
    }

    public void setCalcPayment(CalcPaymentResponse calcPaymentResponse) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048620, this, calcPaymentResponse) != null) {
            return;
        }
        this.mCalcPayMent = calcPaymentResponse;
        if (calcPaymentResponse == null || calcPaymentResponse.activity_map == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            PayData.ChannelDiscountMap[] channelDiscountMapArr = this.mCalcPayMent.activity_map;
            if (i2 >= channelDiscountMapArr.length) {
                return;
            }
            PayData.ChannelDiscountMap channelDiscountMap = channelDiscountMapArr[i2];
            if ("easypay".equals(channelDiscountMap.pay_type)) {
                String str = channelDiscountMap.card_no;
                String str2 = channelDiscountMap.description;
                CardData.BondCard[] bondCards = PayDataCache.getInstance().getBondCards();
                if (bondCards != null) {
                    int length = bondCards.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            CardData.BondCard bondCard = bondCards[i3];
                            if (bondCard.account_no.equals(str)) {
                                bondCard.channelDiscountDesc = str2;
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
            i2++;
        }
    }

    public void setMktSolution(ErrorContentResponse.MktSolution mktSolution) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, mktSolution) == null) || mktSolution == null) {
            return;
        }
        this.isPayByMktSolution = true;
        this.mMktSolution = mktSolution;
    }

    public void setPayFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mPayFrom = str;
        }
    }

    public void setPayWay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.payWay = i2;
        }
    }

    public void setRandomDiscount(PayData.RandomDiscount randomDiscount) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, randomDiscount) == null) {
            this.randomDiscount = randomDiscount;
        }
    }

    public void setmBankCardNumber(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.mBankCardNumber = str;
        }
    }

    public void setmCvv2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.mCvv2 = str;
        }
    }

    public void setmIdCard(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.mIdCard = str;
        }
    }

    public boolean showCouponListEntry() {
        InterceptResult invokeV;
        PayData.Coupon[] couponArr;
        PayData.Discount[] discountArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
            if (calcPaymentResponse != null && (discountArr = calcPaymentResponse.activity_list) != null && discountArr.length > 0) {
                for (PayData.Discount discount : discountArr) {
                    if (discount.isCommonDiscount()) {
                        return true;
                    }
                }
            }
            CalcPaymentResponse calcPaymentResponse2 = this.mCalcPayMent;
            return (calcPaymentResponse2 == null || (couponArr = calcPaymentResponse2.coupon_list) == null || couponArr.length <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void storeFingerprintData(String str) {
        IFingerprintPay iFingerprintPay;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, str) == null) && (iFingerprintPay = this.mFingerprintPay) != null && (iFingerprintPay instanceof SysFingerprintPay)) {
            this.otp_seed = str;
        }
    }
}
