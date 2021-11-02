package com.baidu.wallet.fastpay.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes10.dex */
public class SimpleOrderInfo implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7569032433038662694L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mFaceValue;
    public String mMobile;
    public String mOrderInfo;
    public String mOrderNo;
    public String mPayDesc;
    public String mPrice;
    public String mSpNo;
    public String mSpSuccpageRemainTime;

    public SimpleOrderInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void init() {
        String[] split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.mOrderInfo) || (split = this.mOrderInfo.split("&")) == null) {
            return;
        }
        for (String str : split) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("total_amount")) {
                    this.mPrice = str.substring(13);
                }
                if (str.contains("sp_no")) {
                    this.mSpNo = str.substring(6);
                }
            }
        }
    }

    public boolean isGotoResultActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.mSpSuccpageRemainTime) || !this.mSpSuccpageRemainTime.equals("0") : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "SimpleOrderInfo [mMobile=" + this.mMobile + ", mFaceValue=" + this.mFaceValue + ", mOrderNo=" + this.mOrderNo + ", mPrice=" + this.mPrice + ", mOrderInfo=" + this.mOrderInfo + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
