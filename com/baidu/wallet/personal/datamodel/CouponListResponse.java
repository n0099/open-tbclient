package com.baidu.wallet.personal.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class CouponListResponse implements IBeanResponse, Serializable {
    public static final int NEED_SHOW_MORE_COUPON = 1;
    public BannerCouponItemInfo[] banner_ad_info;
    public CodeCoupon code_equity;
    public CouponList[] coupon_list;
    public CouponListPushed[] coupon_list_pushed;
    public String empty_url;
    public String expire_message;
    public int is_need_load_more = 0;
    public int total_count;
    public String txt_pushed_coupon_issued_over;
    public String url_pushed_coupon_list;

    /* loaded from: classes5.dex */
    public static class CodeCoupon implements NoProguard, Serializable {
        public String desc;
        public String url;
    }

    /* loaded from: classes5.dex */
    public static class CouponListPushed implements NoProguard, Serializable {
        public int coupon_activity_id;
        public int coupon_activity_type;
        public int coupon_amount;
        public String coupon_expire_time;
        public String coupon_num;
        public String coupon_rule;
        public String sp_name;
        public int template_type;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
