package com.baidu.wallet.base.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanRequestBase;
import java.io.Serializable;
/* loaded from: classes10.dex */
public class TransferRequest extends BeanRequestBase implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TRANSFER_TO_ACCOUNT = 2;
    public static final int TRANSFER_TO_CARD = 1;
    public static final long serialVersionUID = -2837911236870472628L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAccount;
    public String mAccountToDisplay;
    public String mAmountDefaultHint;
    public String mCardNo;
    public String mCashdeskParam;
    public String mChannelNo;
    public String mCheckName;
    public String mCosttimeDesp;
    public String mIconShow;
    public String mIdTpl;
    public String mInputAmount;
    public boolean mIsUnregesterPhone;
    public String mOrderIdExt;
    public String mPayAmount;
    public String mPayType;
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
    public String mPayerIconShow;
    public String mPreCashdesk;
    public String mSerialNum;
    public String mSuggetNotifyPayeeMobileBack;
    public String mSuggetNotifyPayeeMobileShow;
    public TransferArriveInfo mTransferArriveInfo;
    public String mTransferArriveType;
    public String mTransferBankCardArriveTime;
    public int mTransferType;
    public String mTrueName;
    public String qrcode;

    public TransferRequest() {
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
        this.mIdTpl = "0";
        this.mAccountToDisplay = "";
        this.mIsUnregesterPhone = false;
        this.mIconShow = "";
        this.mPayerIconShow = "";
        this.mTrueName = "";
        this.mPayType = "";
        this.mCheckName = "";
        this.mCashdeskParam = "";
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mTransferType == 1 ? (TextUtils.isEmpty(this.mPayAmount) || TextUtils.isEmpty(this.mPayeeName) || TextUtils.isEmpty(this.mAccount)) ? false : true : (TextUtils.isEmpty(this.mPayAmount) || TextUtils.isEmpty(this.mAccount)) ? false : true : invokeV.booleanValue;
    }

    public boolean checkRequestValidityWithOutPayAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mTransferType == 1) {
                return (TextUtils.isEmpty(this.mPayeeName) || TextUtils.isEmpty(this.mAccount)) ? false : true;
            }
            return !TextUtils.isEmpty(this.mAccount);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "request_id_transfer" : (String) invokeV.objValue;
    }
}
