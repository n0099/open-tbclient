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
    public static final /* synthetic */ boolean f26245a = !d.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public String f26246b;

    /* renamed from: c  reason: collision with root package name */
    public String f26247c;

    /* renamed from: d  reason: collision with root package name */
    public String f26248d;

    /* renamed from: e  reason: collision with root package name */
    public String f26249e;

    /* renamed from: f  reason: collision with root package name */
    public String f26250f;

    /* renamed from: g  reason: collision with root package name */
    public String f26251g;

    /* renamed from: h  reason: collision with root package name */
    public String f26252h;

    public d(Context context) {
        super(context);
        this.f26246b = "";
        this.f26247c = "0";
        this.f26252h = "1";
    }

    public void a(String str) {
        this.f26246b = str;
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f26248d = str;
        this.f26249e = str2;
        this.f26250f = str3;
        this.f26251g = str4;
    }

    public void b(String str) {
        this.f26247c = str;
    }

    public void c(String str) {
        this.f26252h = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CouponListResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList;
        if (TextUtils.isEmpty(this.f26246b)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("page_index", this.f26246b));
            arrayList.add(new RestNameValuePair("filter_status", this.f26252h));
            if (TextUtils.isEmpty(this.f26247c)) {
                this.f26247c = "0";
            }
            arrayList.add(new RestNameValuePair("is_from_new_promot", this.f26247c));
        }
        if (!TextUtils.isEmpty(this.f26248d) && !TextUtils.isEmpty(this.f26249e) && !TextUtils.isEmpty(this.f26250f) && !TextUtils.isEmpty(this.f26251g)) {
            if (!f26245a && arrayList == null) {
                throw new AssertionError();
            }
            arrayList.add(new RestNameValuePair("activity_id", this.f26248d));
            arrayList.add(new RestNameValuePair(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE, this.f26249e));
            arrayList.add(new RestNameValuePair("coupon_num", this.f26250f));
            arrayList.add(new RestNameValuePair("coupon_expire_time", this.f26251g));
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
