package com.baidu.wallet.personal.datamodel;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class CouponList implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3899635839202556799L;
    public transient /* synthetic */ FieldHolder $fh;
    public int count;
    public Coupon[] coupons;
    public String desc;

    /* loaded from: classes2.dex */
    public static class Coupon implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TEMPLATE_BFB_NORMAL = 4;
        public static final int TEMPLATE_BFB_SPECIAL = 44;
        public static final int TEMPLATE_CASH_NORMAL = 5;
        public static final int TEMPLATE_CASH_SPECIAL = 55;
        public static final int TEMPLATE_COMMON = 100;
        public static final int TEMPLATE_CREDIT_NORMAL = 1;
        public static final int TEMPLATE_CREDIT_SPECIAL = 11;
        public static final int TEMPLATE_DARK_COMMON = 8;
        public static final int TEMPLATE_FINANCE_NORMAL = 2;
        public static final int TEMPLATE_FINANCE_SPECIAL = 22;
        public static final int TEMPLATE_GIFT_NORMAL = 6;
        public static final int TEMPLATE_GIFT_SPECIAL = 66;
        public static final int TEMPLATE_INSURANCE_NORMAL = 3;
        public static final int TEMPLATE_INSURANCE_SPECIAL = 33;
        public static final int TEMPLATE_LIGHT_COMMON = 7;
        public static final long serialVersionUID = -3899635839289305699L;
        public transient /* synthetic */ FieldHolder $fh;
        public AppSceneService app_scene_service;
        public int card_type;
        public String coupon_color;
        public String coupon_color_bg;
        public int coupon_list_show_formwork;
        public String coupon_name;
        public String coupon_num;
        public int coupon_receive_timestamp;
        public String coupon_title_desc;
        public String coupon_title_head;
        public String date_message;
        public String groupDesc;
        public String icon_url;
        public String list_scene_service_label;
        public String list_scene_service_label_URL;
        public String marketing_label;
        public String marketing_label_bgpic;
        public String sub_title;
        public String sub_title2;
        public String template_num;
        public String use_limit;

        /* loaded from: classes2.dex */
        public static class AppSceneService implements NoProguard, Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: android  reason: collision with root package name */
            public int f52609android;
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

        public Coupon() {
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

    public CouponList() {
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
