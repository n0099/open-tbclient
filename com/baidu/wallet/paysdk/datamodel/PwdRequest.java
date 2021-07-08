package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes5.dex */
public class PwdRequest extends BeanRequestBase implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_CHECK = 1;
    public static final int FROM_CREATE = 3;
    public static final int FROM_EDIT = 2;
    public static final int FROM_RNAUTH_SETTING = 4;
    public static final int FROM_SETTING = 0;
    public static final int REQUEST_TYPE_CHECK = 1;
    public static final int REQUEST_TYPE_MODIFY = 3;
    public static final int REQUEST_TYPE_VERIFY = 2;
    public static final long serialVersionUID = 3208920939235207235L;
    public transient /* synthetic */ FieldHolder $fh;
    public String fromType;
    public String mConfirmPayPass;
    public Map<String, String> mExtData;
    public int mFrom;
    public String mPayPass;
    public int mRequestType;
    public String mSessionKey;
    public String serviceType;

    public PwdRequest() {
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
        this.mFrom = 1;
        this.mRequestType = 1;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mRequestType == 3) {
                return !TextUtils.isEmpty(this.mPayPass);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            setBelongPaySdk();
            return BeanConstants.REQUEST_ID_PWD;
        }
        return (String) invokeV.objValue;
    }
}
