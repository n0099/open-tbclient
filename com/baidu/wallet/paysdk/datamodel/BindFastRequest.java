package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import com.dxmpay.wallet.core.beans.NetworkBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class BindFastRequest extends BeanRequestBase implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BIND_FROM_BIND = 1;
    public static final int BIND_FROM_BIND_AUTHORIZE = 6;
    public static final int BIND_FROM_COMPLETE_AUTHORIZE = 7;
    public static final int BIND_FROM_COMPLETION = 2;
    public static final int BIND_FROM_COMPLETION_4_MODIFY_PHONE = 9;
    public static final int BIND_FROM_DIRECT_AUTHORIZE = 8;
    public static final int BIND_FROM_FORGET_PASSSWD = 3;
    public static final int BIND_FROM_FORGET_PASSSWD_BY_OLD_CARD = 4;
    public static final String BIND_FROM_INITIATIVE = "11";
    public static final int BIND_FROM_ONLY_COMPLETION = 5;
    public static final int BIND_FROM_PAY = 0;
    public static final String BIND_IS_FIRST = "bind_is_first";
    public static final int CARD_TYPE_CREDIT = 1;
    public static final int CARD_TYPE_DEBIT = 2;
    public static final String HAS_BINDED_CARD = "has_binded_card";
    public static final String TAG = "BindFastRequest";
    public static Pattern sAuthBindPat = null;
    public static Pattern sInitiativeBindPat = null;
    public static Pattern sNonCashBindPat = null;
    public static Pattern sPayBind = null;
    public static Pattern sPwdBindPat = null;
    public static final long serialVersionUID = -1642858228248654607L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mBankCard;
    public GetCardInfoResponse mBankInfo;
    public String mBankNo;
    public int mBankType;
    public int mBindFrom;
    public int mBindFromOrigin;
    public CardData.BondCard mBondCard;
    public CalcPaymentResponse mCalcPaymentResponse;
    public ErrorContentResponse mCardInfoUpdateContent;
    public String mCertificateType;
    public String mChannelNo;
    public String mCvv;
    public String mIdCard;
    public String mName;
    public int mNeedSms;
    public String mPhone;
    public String mSecurityParams;
    public String mSmsVCode;
    public String mSubBankCode;
    public boolean mUseNewCardFindPwd;
    public String mValidDate;
    public boolean needSetPwd;
    public String regEx;
    public String send_sms_phone;
    public String serviceType;
    public String smsLength;
    public String smsType;
    public String sms_token;
    public String sp_no;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1856089450, "Lcom/baidu/wallet/paysdk/datamodel/BindFastRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1856089450, "Lcom/baidu/wallet/paysdk/datamodel/BindFastRequest;");
                return;
            }
        }
        sNonCashBindPat = Pattern.compile("(4|1(1|2))");
        sInitiativeBindPat = Pattern.compile("(3|6|11)");
        sAuthBindPat = Pattern.compile("(8|12)");
        sPwdBindPat = Pattern.compile("(4|5)");
        sPayBind = Pattern.compile("2");
    }

    public BindFastRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBindFrom = 0;
        this.mBindFromOrigin = 0;
        this.needSetPwd = false;
        this.mUseNewCardFindPwd = true;
    }

    public static String categoryToId(PayRequestCache.BindCategory bindCategory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bindCategory)) == null) {
            if (bindCategory == null) {
                bindCategory = PayRequestCache.BindCategory.Other;
            }
            return bindCategory.name();
        }
        return (String) invokeL.objValue;
    }

    private NetworkBean.BizType getBizType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            PayRequestCache.BindCategory category = getCategory(getmBindFrom());
            NetworkBean.BizType bizType = NetworkBean.BizType.BackwardComp;
            if (PayRequestCache.BindCategory.Initiative == category) {
                return NetworkBean.BizType.BindCard;
            }
            return PayRequestCache.BindCategory.Pwd == category ? NetworkBean.BizType.Pwd : bizType;
        }
        return (NetworkBean.BizType) invokeV.objValue;
    }

    public static PayRequestCache.BindCategory getCategory(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            if (PayRequestCache.getInstance().isPaying()) {
                return PayRequestCache.BindCategory.Other;
            }
            if (i2 != 1) {
                if (i2 != 3 && i2 != 4 && i2 != 5) {
                    return PayRequestCache.BindCategory.Other;
                }
                return PayRequestCache.BindCategory.Pwd;
            }
            return PayRequestCache.BindCategory.Initiative;
        }
        return (PayRequestCache.BindCategory) invokeI.objValue;
    }

    private String getNumFromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "0";
            }
            try {
                return new BigDecimal(str).toString();
            } catch (Exception unused) {
                return "0";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        InterceptResult invokeV;
        GetCardInfoResponse getCardInfoResponse;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.mBankCard) && ((getCardInfoResponse = this.mBankInfo) == null || getCardInfoResponse.card_info == null || getCardInfoResponse.channel_info == null)) ? false : true : invokeV.booleanValue;
    }

    public int getBankType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBankType : invokeV.intValue;
    }

    public String getBindFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((getmBindFrom() == 2 || getmBindFrom() == 5) && PayDataCache.getInstance().hasMobilePwd()) ? "1" : "0" : (String) invokeV.objValue;
    }

    public int getBindFromOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBindFromOrigin : invokeV.intValue;
    }

    public CalcPaymentResponse getCalcPaymentResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            CalcPaymentResponse calcPaymentResponse = this.mCalcPaymentResponse;
            if (calcPaymentResponse != null) {
                return calcPaymentResponse;
            }
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (payRequest != null) {
                return payRequest.getCalcPayment();
            }
            return null;
        }
        return (CalcPaymentResponse) invokeV.objValue;
    }

    public String getCardRequestType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getCardRequestType(getmBindFrom()) : (String) invokeV.objValue;
    }

    public int getCardType() {
        InterceptResult invokeV;
        GetCardInfoResponse.CardInfo cardInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            GetCardInfoResponse getCardInfoResponse = this.mBankInfo;
            if (getCardInfoResponse != null && (cardInfo = getCardInfoResponse.card_info) != null) {
                return cardInfo.card_type;
            }
            CardData.BondCard bondCard = this.mBondCard;
            if (bondCard != null) {
                return bondCard.card_type;
            }
            return this.mBankType;
        }
        return invokeV.intValue;
    }

    public String getCertificateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mCertificateType : (String) invokeV.objValue;
    }

    public String getChannelNo() {
        InterceptResult invokeV;
        GetCardInfoResponse.ChannelInfo channelInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!TextUtils.isEmpty(this.mChannelNo)) {
                return this.mChannelNo;
            }
            GetCardInfoResponse getCardInfoResponse = this.mBankInfo;
            return (getCardInfoResponse == null || (channelInfo = getCardInfoResponse.channel_info) == null) ? "" : channelInfo.channel_no;
        }
        return (String) invokeV.objValue;
    }

    public String getEasyPayAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            CalcPaymentResponse calcPaymentResponse = this.mCalcPaymentResponse;
            if (calcPaymentResponse != null) {
                return calcPaymentResponse.easypay_amount;
            }
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            return payRequest != null ? payRequest.getEasyPayAmount() : "";
        }
        return (String) invokeV.objValue;
    }

    public String getFinalPayAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mCalcPaymentResponse != null) {
                BigDecimal bigDecimal = new BigDecimal(getNumFromString(this.mCalcPaymentResponse.easypay_amount));
                bigDecimal.add(new BigDecimal(getNumFromString(this.mCalcPaymentResponse.balance_amount)));
                bigDecimal.add(new BigDecimal(getNumFromString(this.mCalcPaymentResponse.credit_amount)));
                return bigDecimal.toString();
            }
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            return payRequest != null ? payRequest.getFinalPayAmount() : "";
        }
        return (String) invokeV.objValue;
    }

    public String getRegEx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.regEx : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            setBelongPaySdk();
            return categoryToId(getCategory(getmBindFrom()));
        }
        return (String) invokeV.objValue;
    }

    public String getSendSmsphone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? TextUtils.isEmpty(this.send_sms_phone) ? "" : this.send_sms_phone : (String) invokeV.objValue;
    }

    public String getServiceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.serviceType : (String) invokeV.objValue;
    }

    public String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? NetworkBean.SessionCache.getInstance().getSessionId(getBizType()) : (String) invokeV.objValue;
    }

    public String getSmsLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.smsLength : (String) invokeV.objValue;
    }

    public String getSmsToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.sms_token : (String) invokeV.objValue;
    }

    public String getSmsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.smsType : (String) invokeV.objValue;
    }

    public String getSp_no() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.sp_no : (String) invokeV.objValue;
    }

    public String getSubBankCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mSubBankCode : (String) invokeV.objValue;
    }

    public String getWithoutPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i2 = getmBindFrom();
            if (i2 != 0) {
                if (i2 == 1) {
                    return "1";
                }
                if (i2 != 2 && i2 == 3 && this.mBondCard == null) {
                    return "1";
                }
            } else if (!PayDataCache.getInstance().hasMobilePwd()) {
                return "1";
            }
            return "0";
        }
        return (String) invokeV.objValue;
    }

    public String getmBankCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mBankCard : (String) invokeV.objValue;
    }

    public GetCardInfoResponse getmBankInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mBankInfo : (GetCardInfoResponse) invokeV.objValue;
    }

    public int getmBindFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mBindFrom : invokeV.intValue;
    }

    public CardData.BondCard getmBondCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mBondCard : (CardData.BondCard) invokeV.objValue;
    }

    public String getmCvv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mCvv : (String) invokeV.objValue;
    }

    public String getmIdCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mIdCard : (String) invokeV.objValue;
    }

    public String getmName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public String getmPhone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mPhone : (String) invokeV.objValue;
    }

    public String getmSmsVCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mSmsVCode : (String) invokeV.objValue;
    }

    public String getmValidDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mValidDate : (String) invokeV.objValue;
    }

    public boolean isNeedCheckSms() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mNeedSms == 1 : invokeV.booleanValue;
    }

    public boolean isNotPayBindCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? PayRequestCache.BindCategory.Other != getCategory(getmBindFrom()) : invokeV.booleanValue;
    }

    public boolean isRealPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            int i2 = this.mBindFrom;
            return i2 == 0 || i2 == 2 || i2 == 6 || i2 == 7 || i2 == 8;
        }
        return invokeV.booleanValue;
    }

    public void saveSession(BeanResponseBase.Session session) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, session) == null) {
            NetworkBean.SessionCache.getInstance().put(getBizType(), session);
        }
    }

    public void setBankType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.mBankType = i2;
        }
    }

    public void setBindFromOrigin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.mBindFromOrigin = i2;
        }
    }

    public void setCalcPaymentResponse(CalcPaymentResponse calcPaymentResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, calcPaymentResponse) == null) {
            this.mCalcPaymentResponse = calcPaymentResponse;
        }
    }

    public void setCertificateType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.mCertificateType = str;
        }
    }

    public void setChannelNo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.mChannelNo = str;
        }
    }

    public void setRegEx(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.regEx = str;
        }
    }

    public void setSendSmsphone(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.send_sms_phone = str;
        }
    }

    public void setServiceType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.serviceType = str;
        }
    }

    public void setSmsLength(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.smsLength = str;
        }
    }

    public void setSmsToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.sms_token = str;
        }
    }

    public void setSmsType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.smsType = str;
        }
    }

    public void setSp_no(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.sp_no = str;
        }
    }

    public void setSubBankCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.mSubBankCode = str;
        }
    }

    public void setValidDateFromServer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.mValidDate = str;
        }
    }

    public void setmBankCard(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.mBankCard = str;
        }
    }

    public void setmBankInfo(GetCardInfoResponse getCardInfoResponse) {
        GetCardInfoResponse.CardInfo cardInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, getCardInfoResponse) == null) {
            this.mBankInfo = getCardInfoResponse;
            if (getCardInfoResponse == null || (cardInfo = getCardInfoResponse.card_info) == null) {
                return;
            }
            this.mBankNo = cardInfo.bank_no;
            this.mBankType = cardInfo.card_type;
        }
    }

    public void setmCvv(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.mCvv = str;
        }
    }

    public void setmIdCard(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.mIdCard = str;
        }
    }

    public void setmName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.mName = str;
        }
    }

    public void setmNeedSms(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.mNeedSms = i2;
        }
    }

    public void setmPhone(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.mPhone = str;
        }
    }

    public void setmValidDate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str) && str.length() == 4) {
                sb.append(str.charAt(2));
                sb.append(str.charAt(3));
                sb.append(str.charAt(0));
                sb.append(str.charAt(1));
                str = sb.toString();
            }
            this.mValidDate = str;
        }
    }

    public static String getCardRequestType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 == 1 ? "11" : i2 == 0 ? "2" : i2 == 2 ? "3" : (i2 == 3 || i2 == 4) ? PayRequestCache.getInstance().isPaying() ? "5" : "4" : i2 == 5 ? "6" : i2 == 6 ? "8" : (i2 == 7 || i2 == 8) ? "9" : "" : (String) invokeI.objValue;
    }
}
