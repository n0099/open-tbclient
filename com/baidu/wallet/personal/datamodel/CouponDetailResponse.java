package com.baidu.wallet.personal.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class CouponDetailResponse implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AppSceneService app_scene_service;
    public String background_color;
    public String bank_message;
    public int card_type;
    public String coupon_detail;
    public int coupon_life_second;
    public String coupon_num;
    public int coupon_type;
    public String date_message;
    public Detail[] detail;
    public String discount_content;
    public String discount_content_v2;
    public String discount_content_v2_unit;
    public String display_coupon_num;
    public boolean is_started;
    public String logo_title;
    public String logo_url;
    public MarketingLabelDetail[] marketing_label_detail;
    public String prompt_message;
    public int qrcode_choose;
    public String qrcode_service;
    public String scene_service;
    public String scene_service_label;
    public String sdk_para;
    public int source_type;
    public int status;
    public Store[] store;
    public String sub_title;
    public String template_num;
    public String template_title;
    public int template_type;
    public String use_date_message;
    public String use_direction;
    public String use_limit;
    public String use_limit_detail;

    /* loaded from: classes5.dex */
    public static class AppSceneService implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: android  reason: collision with root package name */
        public int f27246android;
        public String url;

        public AppSceneService() {
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

    /* loaded from: classes5.dex */
    public static class Detail implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7483625839289305699L;
        public transient /* synthetic */ FieldHolder $fh;
        public String name;
        public String value;

        public Detail() {
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

    /* loaded from: classes5.dex */
    public static class MarketingLabelDetail implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7483625839289305699L;
        public transient /* synthetic */ FieldHolder $fh;
        public String label_name;

        public MarketingLabelDetail() {
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

    /* loaded from: classes5.dex */
    public static class Store implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7483625838372605699L;
        public transient /* synthetic */ FieldHolder $fh;
        public String store_address;
        public String store_distance;
        public String store_mapping;
        public String store_name;
        public String store_no;
        public String store_phone;
        public String store_poi;

        public Store() {
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

    public CouponDetailResponse() {
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
        this.coupon_life_second = 0;
        this.status = 0;
    }

    private void a(List<MarketingLabelDetail> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, list) == null) {
            Iterator<MarketingLabelDetail> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next().label_name)) {
                    it.remove();
                }
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

    public List<MarketingLabelDetail> getValidLabels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            MarketingLabelDetail[] marketingLabelDetailArr = this.marketing_label_detail;
            if (marketingLabelDetailArr != null && arrayList.addAll(Arrays.asList(marketingLabelDetailArr))) {
                a(arrayList);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
        }
    }
}
