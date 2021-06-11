package com.baidu.wallet.personal.datamodel;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class CouponList implements NoProguard, Serializable {
    public static final long serialVersionUID = -3899635839202556799L;
    public Coupon[] coupons;
    public String expire_message;
    public String label;

    /* loaded from: classes5.dex */
    public static class Coupon implements NoProguard, Serializable {
        public static final int CRAD_TYPE_BFB = 1;
        public static final int CRAD_TYPE_EXTERN = 2;
        public static final int CRAD_TYPE_POS = 3;
        public static final int CRAD_TYPE_YUANQUAN = 4;
        public static final int TEMPLATE_TYPE_DEDUCTION = 1;
        public static final int TEMPLATE_TYPE_DISCOUNT = 2;
        public static final int TEMPLATE_TYPE_OTHER = 3;
        public static final long serialVersionUID = -3899635839289305699L;
        public AppSceneService app_scene_service;
        public String background_color;
        public int card_type;
        public String coupon_num;
        public int coupon_receive_timestamp;
        public String date_message;
        public String date_message_expire;
        public String date_message_v2;
        public String date_not_started;
        public String discount_content;
        public String discount_content_v2;
        public String discount_content_v2_unit;
        public boolean isLabel = false;
        public String labelValue;
        public int label_status;
        public String logo_title;
        public String logo_url;
        public String marketing_label;
        public String scene_service;
        public String scene_service_label;
        public int source_type;
        public int status;
        public String status_desc;
        public String sub_title;
        public String template_num;
        public String template_title;
        public int template_type;
        public String use_limit;
        public String use_limit_v2;

        /* loaded from: classes5.dex */
        public static class AppSceneService implements NoProguard, Serializable {

            /* renamed from: android  reason: collision with root package name */
            public int f26354android;
            public String url;
        }
    }
}
