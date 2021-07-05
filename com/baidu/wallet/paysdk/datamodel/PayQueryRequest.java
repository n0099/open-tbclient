package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class PayQueryRequest extends BeanRequestBase implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CRDDITPAY_NAME = "get_credit_pay_android_result";
    public static final String EASYPAY_NAME = "get_easypay_trans_state_android";
    public static final long serialVersionUID = 7544071473932477587L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mBankNo;
    public String mName;
    public String mOrderNo;

    public PayQueryRequest() {
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
        this.mName = EASYPAY_NAME;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mBankNo == null) {
                this.mBankNo = "";
            }
            return !TextUtils.isEmpty(this.mOrderNo);
        }
        return invokeV.booleanValue;
    }

    public String getMd5Sign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mBankNo == null) {
                this.mBankNo = "";
            }
            return Md5Utils.toMD5("order_no=" + this.mOrderNo + "&name=get_easypay_trans_state_android&bank_no=" + this.mBankNo + "&key=baifubaowallet");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            setBelongPaySdk();
            return BeanConstants.REQUEST_ID_PAY_QUERY;
        }
        return (String) invokeV.objValue;
    }
}
