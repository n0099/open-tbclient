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
    public static final /* synthetic */ boolean f26559a = !d.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public String f26560b;

    /* renamed from: c  reason: collision with root package name */
    public String f26561c;

    /* renamed from: d  reason: collision with root package name */
    public String f26562d;

    /* renamed from: e  reason: collision with root package name */
    public String f26563e;

    /* renamed from: f  reason: collision with root package name */
    public String f26564f;

    /* renamed from: g  reason: collision with root package name */
    public String f26565g;

    /* renamed from: h  reason: collision with root package name */
    public String f26566h;

    public d(Context context) {
        super(context);
        this.f26560b = "";
        this.f26561c = "0";
        this.f26566h = "1";
    }

    public void a(String str) {
        this.f26560b = str;
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f26562d = str;
        this.f26563e = str2;
        this.f26564f = str3;
        this.f26565g = str4;
    }

    public void b(String str) {
        this.f26561c = str;
    }

    public void c(String str) {
        this.f26566h = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CouponListResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList;
        if (TextUtils.isEmpty(this.f26560b)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("page_index", this.f26560b));
            arrayList.add(new RestNameValuePair("filter_status", this.f26566h));
            if (TextUtils.isEmpty(this.f26561c)) {
                this.f26561c = "0";
            }
            arrayList.add(new RestNameValuePair("is_from_new_promot", this.f26561c));
        }
        if (!TextUtils.isEmpty(this.f26562d) && !TextUtils.isEmpty(this.f26563e) && !TextUtils.isEmpty(this.f26564f) && !TextUtils.isEmpty(this.f26565g)) {
            if (!f26559a && arrayList == null) {
                throw new AssertionError();
            }
            arrayList.add(new RestNameValuePair("activity_id", this.f26562d));
            arrayList.add(new RestNameValuePair(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE, this.f26563e));
            arrayList.add(new RestNameValuePair("coupon_num", this.f26564f));
            arrayList.add(new RestNameValuePair("coupon_expire_time", this.f26565g));
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
