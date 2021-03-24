package com.baidu.wallet.base.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class TransferRequest extends BeanRequestBase implements Serializable {
    public static final int TRANSFER_TO_ACCOUNT = 2;
    public static final int TRANSFER_TO_CARD = 1;
    public static final long serialVersionUID = -2837911236870472628L;
    public String mAccount;
    public String mAmountDefaultHint;
    public String mCardNo;
    public String mChannelNo;
    public String mCosttimeDesp;
    public String mInputAmount;
    public String mOrderIdExt;
    public String mPayAmount;
    public String mPayeeBankCode;
    public String mPayeeBankName;
    public String mPayeeCanCheck;
    public String mPayeeIsAuthod;
    public String mPayeeMobile;
    public String mPayeeName;
    public String mPayeeReason;
    public String mPayeeSpName;
    public String mPayee_type;
    public String mPayerBankName;
    public String mPreCashdesk;
    public String mSerialNum;
    public String mSuggetNotifyPayeeMobileBack;
    public String mSuggetNotifyPayeeMobileShow;
    public TransferArriveInfo mTransferArriveInfo;
    public String mTransferArriveType;
    public String mTransferBankCardArriveTime;
    public int mTransferType;
    public String qrcode;
    public String mIdTpl = "0";
    public String mAccountToDisplay = "";
    public boolean mIsUnregesterPhone = false;
    public String mIconShow = "";
    public String mPayerIconShow = "";
    public String mTrueName = "";
    public String mPayType = "";
    public String mCheckName = "";
    public String mCashdeskParam = "";

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return this.mTransferType == 1 ? (TextUtils.isEmpty(this.mPayAmount) || TextUtils.isEmpty(this.mPayeeName) || TextUtils.isEmpty(this.mAccount)) ? false : true : (TextUtils.isEmpty(this.mPayAmount) || TextUtils.isEmpty(this.mAccount)) ? false : true;
    }

    public boolean checkRequestValidityWithOutPayAmount() {
        if (this.mTransferType == 1) {
            return (TextUtils.isEmpty(this.mPayeeName) || TextUtils.isEmpty(this.mAccount)) ? false : true;
        }
        return !TextUtils.isEmpty(this.mAccount);
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return "request_id_transfer";
    }
}
