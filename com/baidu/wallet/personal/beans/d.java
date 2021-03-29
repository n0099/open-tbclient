package com.baidu.wallet.personal.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.personal.datamodel.CouponListResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseBean<CouponListResponse> {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f26560a = !d.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public String f26561b;

    /* renamed from: c  reason: collision with root package name */
    public String f26562c;

    /* renamed from: d  reason: collision with root package name */
    public String f26563d;

    /* renamed from: e  reason: collision with root package name */
    public String f26564e;

    /* renamed from: f  reason: collision with root package name */
    public String f26565f;

    /* renamed from: g  reason: collision with root package name */
    public String f26566g;

    /* renamed from: h  reason: collision with root package name */
    public String f26567h;

    public d(Context context) {
        super(context);
        this.f26561b = "";
        this.f26562c = "0";
        this.f26567h = "1";
    }

    public void a(String str) {
        this.f26561b = str;
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f26563d = str;
        this.f26564e = str2;
        this.f26565f = str3;
        this.f26566g = str4;
    }

    public void b(String str) {
        this.f26562c = str;
    }

    public void c(String str) {
        this.f26567h = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CouponListResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList;
        if (TextUtils.isEmpty(this.f26561b)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("page_index", this.f26561b));
            arrayList.add(new RestNameValuePair("filter_status", this.f26567h));
            if (TextUtils.isEmpty(this.f26562c)) {
                this.f26562c = "0";
            }
            arrayList.add(new RestNameValuePair("is_from_new_promot", this.f26562c));
        }
        if (!TextUtils.isEmpty(this.f26563d) && !TextUtils.isEmpty(this.f26564e) && !TextUtils.isEmpty(this.f26565f) && !TextUtils.isEmpty(this.f26566g)) {
            if (!f26560a && arrayList == null) {
                throw new AssertionError();
            }
            arrayList.add(new RestNameValuePair("activity_id", this.f26563d));
            arrayList.add(new RestNameValuePair(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE, this.f26564e));
            arrayList.add(new RestNameValuePair("coupon_num", this.f26565f));
            arrayList.add(new RestNameValuePair("coupon_expire_time", this.f26566g));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 515;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getMyHost() + "/yqcard/card/getcouponlistv2";
    }
}
