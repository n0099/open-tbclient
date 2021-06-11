package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class BindFastRequest extends BeanRequestBase implements Serializable {
    public static final int BIND_FROM_BIND = 1;
    public static final int BIND_FROM_BIND_AUTHORIZE = 6;
    public static final int BIND_FROM_COMPLETE_AUTHORIZE = 7;
    public static final int BIND_FROM_COMPLETION = 2;
    public static final int BIND_FROM_COMPLETION_4_MODIFY_PHONE = 9;
    public static final int BIND_FROM_DIRECT_AUTHORIZE = 8;
    public static final int BIND_FROM_FORGET_PASSSWD = 3;
    public static final int BIND_FROM_FORGET_PASSSWD_BY_OLD_CARD = 4;
    public static final int BIND_FROM_ONLY_COMPLETION = 5;
    public static final int BIND_FROM_PAY = 0;
    public static final String BIND_IS_FIRST = "bind_is_first";
    public static final int CARD_TYPE_CREDIT = 1;
    public static final int CARD_TYPE_DEBIT = 2;
    public static final String HAS_BINDED_CARD = "has_binded_card";
    public static final String TAG = "BindFastRequest";
    public static final long serialVersionUID = -1642858228248654607L;
    public String mBankCard;
    public GetCardInfoResponse mBankInfo;
    public String mBankNo;
    public int mBankType;
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
    public String mValidDate;
    public String regEx;
    public String send_sms_phone;
    public String serviceType;
    public String smsLength;
    public String smsType;
    public String sms_token;
    public String sp_no;
    public static Pattern sNonCashBindPat = Pattern.compile("(4|1(1|2))");
    public static Pattern sInitiativeBindPat = Pattern.compile("(3|6|11)");
    public static Pattern sAuthBindPat = Pattern.compile("(8|12)");
    public static Pattern sPwdBindPat = Pattern.compile("(4|5)");
    public static Pattern sPayBind = Pattern.compile("2");
    public int mBindFrom = 0;
    public int mBindFromOrigin = 0;
    public boolean needSetPwd = false;
    public boolean mUseNewCardFindPwd = true;

    public static String categoryToId(PayRequestCache.BindCategory bindCategory) {
        if (bindCategory == null) {
            bindCategory = PayRequestCache.BindCategory.Other;
        }
        return bindCategory.name();
    }

    private NetworkBean.BizType getBizType() {
        PayRequestCache.BindCategory category = getCategory(getmBindFrom());
        NetworkBean.BizType bizType = NetworkBean.BizType.BackwardComp;
        if (PayRequestCache.BindCategory.Initiative == category) {
            return NetworkBean.BizType.BindCard;
        }
        return PayRequestCache.BindCategory.Pwd == category ? NetworkBean.BizType.Pwd : bizType;
    }

    public static PayRequestCache.BindCategory getCategory(int i2) {
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

    private String getNumFromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        try {
            return new BigDecimal(str).toString();
        } catch (Exception unused) {
            return "0";
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        GetCardInfoResponse getCardInfoResponse;
        return (TextUtils.isEmpty(this.mBankCard) && ((getCardInfoResponse = this.mBankInfo) == null || getCardInfoResponse.card_info == null || getCardInfoResponse.channel_info == null)) ? false : true;
    }

    public int getBankType() {
        return this.mBankType;
    }

    public String getBindFlag() {
        return ((getmBindFrom() == 2 || getmBindFrom() == 5) && PayDataCache.getInstance().hasMobilePwd()) ? "1" : "0";
    }

    public int getBindFromOrigin() {
        return this.mBindFromOrigin;
    }

    public CalcPaymentResponse getCalcPaymentResponse() {
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

    public String getCardRequestType() {
        return getCardRequestType(getmBindFrom());
    }

    public int getCardType() {
        GetCardInfoResponse.CardInfo cardInfo;
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

    public String getCertificateType() {
        return this.mCertificateType;
    }

    public String getChannelNo() {
        GetCardInfoResponse.ChannelInfo channelInfo;
        if (!TextUtils.isEmpty(this.mChannelNo)) {
            return this.mChannelNo;
        }
        GetCardInfoResponse getCardInfoResponse = this.mBankInfo;
        return (getCardInfoResponse == null || (channelInfo = getCardInfoResponse.channel_info) == null) ? "" : channelInfo.channel_no;
    }

    public String getEasyPayAmount() {
        CalcPaymentResponse calcPaymentResponse = this.mCalcPaymentResponse;
        if (calcPaymentResponse != null) {
            return calcPaymentResponse.easypay_amount;
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        return payRequest != null ? payRequest.getEasyPayAmount() : "";
    }

    public String getFinalPayAmount() {
        if (this.mCalcPaymentResponse != null) {
            BigDecimal bigDecimal = new BigDecimal(getNumFromString(this.mCalcPaymentResponse.easypay_amount));
            bigDecimal.add(new BigDecimal(getNumFromString(this.mCalcPaymentResponse.balance_amount)));
            bigDecimal.add(new BigDecimal(getNumFromString(this.mCalcPaymentResponse.credit_amount)));
            return bigDecimal.toString();
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        return payRequest != null ? payRequest.getFinalPayAmount() : "";
    }

    public String getRegEx() {
        return this.regEx;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        setBelongPaySdk();
        return categoryToId(getCategory(getmBindFrom()));
    }

    public String getSendSmsphone() {
        return TextUtils.isEmpty(this.send_sms_phone) ? "" : this.send_sms_phone;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public String getSessionId() {
        return NetworkBean.SessionCache.getInstance().getSessionId(getBizType());
    }

    public String getSmsLength() {
        return this.smsLength;
    }

    public String getSmsToken() {
        return this.sms_token;
    }

    public String getSmsType() {
        return this.smsType;
    }

    public String getSp_no() {
        return this.sp_no;
    }

    public String getSubBankCode() {
        return this.mSubBankCode;
    }

    public String getWithoutPay() {
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

    public String getmBankCard() {
        return this.mBankCard;
    }

    public GetCardInfoResponse getmBankInfo() {
        return this.mBankInfo;
    }

    public int getmBindFrom() {
        return this.mBindFrom;
    }

    public CardData.BondCard getmBondCard() {
        return this.mBondCard;
    }

    public String getmCvv() {
        return this.mCvv;
    }

    public String getmIdCard() {
        return this.mIdCard;
    }

    public String getmName() {
        return this.mName;
    }

    public String getmPhone() {
        return this.mPhone;
    }

    public String getmSmsVCode() {
        return this.mSmsVCode;
    }

    public String getmValidDate() {
        return this.mValidDate;
    }

    public boolean isNeedCheckSms() {
        return this.mNeedSms == 1;
    }

    public boolean isNotPayBindCard() {
        return PayRequestCache.BindCategory.Other != getCategory(getmBindFrom());
    }

    public boolean isRealPay() {
        int i2 = this.mBindFrom;
        return i2 == 0 || i2 == 2 || i2 == 6 || i2 == 7 || i2 == 8;
    }

    public void saveSession(BeanResponseBase.Session session) {
        NetworkBean.SessionCache.getInstance().put(getBizType(), session);
    }

    public void setBankType(int i2) {
        this.mBankType = i2;
    }

    public void setBindFromOrigin(int i2) {
        this.mBindFromOrigin = i2;
    }

    public void setCalcPaymentResponse(CalcPaymentResponse calcPaymentResponse) {
        this.mCalcPaymentResponse = calcPaymentResponse;
    }

    public void setCertificateType(String str) {
        this.mCertificateType = str;
    }

    public void setChannelNo(String str) {
        this.mChannelNo = str;
    }

    public void setRegEx(String str) {
        this.regEx = str;
    }

    public void setSendSmsphone(String str) {
        this.send_sms_phone = str;
    }

    public void setServiceType(String str) {
        this.serviceType = str;
    }

    public void setSmsLength(String str) {
        this.smsLength = str;
    }

    public void setSmsToken(String str) {
        this.sms_token = str;
    }

    public void setSmsType(String str) {
        this.smsType = str;
    }

    public void setSp_no(String str) {
        this.sp_no = str;
    }

    public void setSubBankCode(String str) {
        this.mSubBankCode = str;
    }

    public void setValidDateFromServer(String str) {
        this.mValidDate = str;
    }

    public void setmBankCard(String str) {
        this.mBankCard = str;
    }

    public void setmBankInfo(GetCardInfoResponse getCardInfoResponse) {
        GetCardInfoResponse.CardInfo cardInfo;
        this.mBankInfo = getCardInfoResponse;
        if (getCardInfoResponse == null || (cardInfo = getCardInfoResponse.card_info) == null) {
            return;
        }
        this.mBankNo = cardInfo.bank_no;
        this.mBankType = cardInfo.card_type;
    }

    public void setmCvv(String str) {
        this.mCvv = str;
    }

    public void setmIdCard(String str) {
        this.mIdCard = str;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public void setmNeedSms(int i2) {
        this.mNeedSms = i2;
    }

    public void setmPhone(String str) {
        this.mPhone = str;
    }

    public void setmValidDate(String str) {
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

    public static String getCardRequestType(int i2) {
        return i2 == 1 ? "11" : i2 == 0 ? "2" : i2 == 2 ? "3" : (i2 == 3 || i2 == 4) ? PayRequestCache.getInstance().isPaying() ? "5" : "4" : i2 == 5 ? "6" : i2 == 6 ? "8" : (i2 == 7 || i2 == 8) ? "9" : "";
    }
}
