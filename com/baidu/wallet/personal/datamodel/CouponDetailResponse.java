package com.baidu.wallet.personal.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class CouponDetailResponse implements IBeanResponse, Serializable {
    public AppSceneService app_scene_service;
    public String background_color;
    public String bank_message;
    public int card_type;
    public String coupon_detail;
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
    public Store[] store;
    public String sub_title;
    public String template_num;
    public String template_title;
    public int template_type;
    public String use_date_message;
    public String use_direction;
    public String use_limit;
    public String use_limit_detail;
    public int coupon_life_second = 0;
    public int status = 0;

    /* loaded from: classes5.dex */
    public static class AppSceneService implements NoProguard, Serializable {

        /* renamed from: android  reason: collision with root package name */
        public int f27076android;
        public String url;
    }

    /* loaded from: classes5.dex */
    public static class Detail implements NoProguard, Serializable {
        public static final long serialVersionUID = -7483625839289305699L;
        public String name;
        public String value;
    }

    /* loaded from: classes5.dex */
    public static class MarketingLabelDetail implements NoProguard, Serializable {
        public static final long serialVersionUID = 7483625839289305699L;
        public String label_name;
    }

    /* loaded from: classes5.dex */
    public static class Store implements NoProguard, Serializable {
        public static final long serialVersionUID = -7483625838372605699L;
        public String store_address;
        public String store_distance;
        public String store_mapping;
        public String store_name;
        public String store_no;
        public String store_phone;
        public String store_poi;
    }

    private void a(List<MarketingLabelDetail> list) {
        Iterator<MarketingLabelDetail> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().label_name)) {
                it.remove();
            }
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public List<MarketingLabelDetail> getValidLabels() {
        ArrayList arrayList = new ArrayList();
        MarketingLabelDetail[] marketingLabelDetailArr = this.marketing_label_detail;
        if (marketingLabelDetailArr != null && arrayList.addAll(Arrays.asList(marketingLabelDetailArr))) {
            a(arrayList);
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
