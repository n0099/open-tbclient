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
/* loaded from: classes10.dex */
public class PromotionInfoResponse implements IBeanResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MoreServiceItemInfo[] additional_services;
    public String customer_service_copy;
    public String customer_service_icon;
    public String customer_service_url;
    public MenuItemInfo[] help_menu;
    public int link_type;
    public BannerChargeItemInfo[] promotion_banner;
    public String promotion_bigimg_url;
    public String promotion_desc;
    public String promotion_detail_url;
    public String promotion_img_url;
    public String promotion_txt;
    public int promotion_type;

    public PromotionInfoResponse() {
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

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
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
            return "PromotionInfoResponse [promotion_img_url=" + this.promotion_img_url + ", promotion_txt=" + this.promotion_txt + ", promotion_desc=" + this.promotion_desc + ", promotion_detail_url=" + this.promotion_detail_url + ", promotion_bigimg_url=" + this.promotion_bigimg_url + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
