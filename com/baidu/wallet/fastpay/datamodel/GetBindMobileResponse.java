package com.baidu.wallet.fastpay.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.StringUtils;
import java.io.Serializable;
import java.math.BigDecimal;
/* loaded from: classes8.dex */
public class GetBindMobileResponse implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HUODONG_PRICE_NO = "0";
    public static final String HUODONG_PRICE_YES = "1";
    public static final long serialVersionUID = 4241463573323731942L;
    public transient /* synthetic */ FieldHolder $fh;
    public String area;
    public String area_operator;
    public String email;
    public BottomItem help_page;
    public String is_huodong_price;
    public String mobile;
    public BottomItem mobile_business_hall;
    public String operator;
    public String pay_desc;
    public PriceInfo[] price_info;
    public FastPayFacePromotionInfoResponse[] promotion_info;
    public String total_mobile_msg;

    /* loaded from: classes8.dex */
    public static class BottomItem implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String title;
        public String url;

        public BottomItem() {
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
    }

    public GetBindMobileResponse() {
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
        this.pay_desc = "";
    }

    private void initDiscount() {
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
            initDiscount();
            return true;
        }
        return invokeV.booleanValue;
    }

    public String getExpressMobile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.mobile)) {
                return "";
            }
            String decryptProxy = SafePay.getInstance().decryptProxy(this.mobile);
            if (TextUtils.isEmpty(decryptProxy)) {
                return "";
            }
            String unicodeDecode = SafePay.unicodeDecode(decryptProxy);
            return TextUtils.isEmpty(unicodeDecode) ? "" : StringUtils.formatPhoneNumber(unicodeDecode);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
        }
    }
}
