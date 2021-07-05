package com.baidu.wallet.fastpay.datamodel;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigDecimal;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class QueryLocationResponse implements IBeanResponse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HUODONG_PRICE_NO = "0";
    public static final String HUODONG_PRICE_YES = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public String area;
    public String area_operator;
    public String is_huodong_price;
    public String mobile_msg;
    public String operator;
    public PriceInfo[] price_info;
    public FastPayFacePromotionInfoResponse[] promotion_info;

    public QueryLocationResponse() {
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
        this.operator = "";
        this.area = "";
        this.area_operator = "";
        this.is_huodong_price = "";
    }

    private void a() {
        PriceInfo[] priceInfoArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (priceInfoArr = this.price_info) == null) {
            return;
        }
        int length = priceInfoArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.price_info[i2].discount = new BigDecimal(this.price_info[i2].sell_price).multiply(BigDecimal.TEN).divide(new BigDecimal(this.price_info[i2].face), 2, 6).toString();
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a();
            return this.price_info != null;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "QueryLocationResult [operator=" + this.operator + ", area=" + this.area + ", area_operator=" + this.area_operator + ", is_huodong_price=" + this.is_huodong_price + ", price_info=" + Arrays.toString(this.price_info) + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
