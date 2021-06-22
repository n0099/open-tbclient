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
    public static final /* synthetic */ boolean f26416a = !d.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public String f26417b;

    /* renamed from: c  reason: collision with root package name */
    public String f26418c;

    /* renamed from: d  reason: collision with root package name */
    public String f26419d;

    /* renamed from: e  reason: collision with root package name */
    public String f26420e;

    /* renamed from: f  reason: collision with root package name */
    public String f26421f;

    /* renamed from: g  reason: collision with root package name */
    public String f26422g;

    /* renamed from: h  reason: collision with root package name */
    public String f26423h;

    public d(Context context) {
        super(context);
        this.f26417b = "";
        this.f26418c = "0";
        this.f26423h = "1";
    }

    public void a(String str) {
        this.f26417b = str;
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f26419d = str;
        this.f26420e = str2;
        this.f26421f = str3;
        this.f26422g = str4;
    }

    public void b(String str) {
        this.f26418c = str;
    }

    public void c(String str) {
        this.f26423h = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CouponListResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList;
        if (TextUtils.isEmpty(this.f26417b)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("page_index", this.f26417b));
            arrayList.add(new RestNameValuePair("filter_status", this.f26423h));
            if (TextUtils.isEmpty(this.f26418c)) {
                this.f26418c = "0";
            }
            arrayList.add(new RestNameValuePair("is_from_new_promot", this.f26418c));
        }
        if (!TextUtils.isEmpty(this.f26419d) && !TextUtils.isEmpty(this.f26420e) && !TextUtils.isEmpty(this.f26421f) && !TextUtils.isEmpty(this.f26422g)) {
            if (!f26416a && arrayList == null) {
                throw new AssertionError();
            }
            arrayList.add(new RestNameValuePair("activity_id", this.f26419d));
            arrayList.add(new RestNameValuePair(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE, this.f26420e));
            arrayList.add(new RestNameValuePair("coupon_num", this.f26421f));
            arrayList.add(new RestNameValuePair("coupon_expire_time", this.f26422g));
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
