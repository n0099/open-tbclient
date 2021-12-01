package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.wallet.base.datamodel.UserData;
import java.io.Serializable;
/* loaded from: classes12.dex */
public class PrecashierModifyPayTypeResponse extends DirectPayContentResponse implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -936968920336557051L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mOriginHttpResponse;

    /* loaded from: classes12.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static PrecashierModifyPayTypeResponse a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1629915046, "Lcom/baidu/wallet/paysdk/datamodel/PrecashierModifyPayTypeResponse$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1629915046, "Lcom/baidu/wallet/paysdk/datamodel/PrecashierModifyPayTypeResponse$a;");
                    return;
                }
            }
            a = new PrecashierModifyPayTypeResponse();
        }
    }

    public PrecashierModifyPayTypeResponse() {
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

    public static PrecashierModifyPayTypeResponse getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (PrecashierModifyPayTypeResponse) invokeV.objValue;
    }

    public static void updateContent(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, obj) == null) {
            if (obj instanceof PrecashierModifyPayTypeResponse) {
                PrecashierModifyPayTypeResponse unused = a.a = (PrecashierModifyPayTypeResponse) obj;
            } else if (obj == null) {
                PrecashierModifyPayTypeResponse unused2 = a.a = null;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse, com.dxmpay.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.pay == null && this.sp == null && this.user == null) ? false : true : invokeV.booleanValue;
    }

    public void decrypt() {
        PayData.EasyPay easyPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            UserData.UserModel userModel = this.user;
            if (userModel != null) {
                userModel.decrypt();
            }
            PayData.DirectPayPay directPayPay = this.pay;
            if (directPayPay == null || (easyPay = directPayPay.easypay) == null) {
                return;
            }
            easyPay.decrypt();
        }
    }

    public String getOriginHttpResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOriginHttpResponse : (String) invokeV.objValue;
    }

    public void setOriginHttpResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mOriginHttpResponse = str;
        }
    }

    @Override // com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse, com.dxmpay.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            decrypt();
            updateContent(this);
            PayDataCache.getInstance().setPayResponse(this);
            PayDataCache.getInstance().setFromPreCashier();
        }
    }
}
