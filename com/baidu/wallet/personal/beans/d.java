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
    public static final /* synthetic */ boolean f27057a = !d.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public String f27058b;

    /* renamed from: c  reason: collision with root package name */
    public String f27059c;

    /* renamed from: d  reason: collision with root package name */
    public String f27060d;

    /* renamed from: e  reason: collision with root package name */
    public String f27061e;

    /* renamed from: f  reason: collision with root package name */
    public String f27062f;

    /* renamed from: g  reason: collision with root package name */
    public String f27063g;

    /* renamed from: h  reason: collision with root package name */
    public String f27064h;

    public d(Context context) {
        super(context);
        this.f27058b = "";
        this.f27059c = "0";
        this.f27064h = "1";
    }

    public void a(String str) {
        this.f27058b = str;
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f27060d = str;
        this.f27061e = str2;
        this.f27062f = str3;
        this.f27063g = str4;
    }

    public void b(String str) {
        this.f27059c = str;
    }

    public void c(String str) {
        this.f27064h = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CouponListResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList;
        if (TextUtils.isEmpty(this.f27058b)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("page_index", this.f27058b));
            arrayList.add(new RestNameValuePair("filter_status", this.f27064h));
            if (TextUtils.isEmpty(this.f27059c)) {
                this.f27059c = "0";
            }
            arrayList.add(new RestNameValuePair("is_from_new_promot", this.f27059c));
        }
        if (!TextUtils.isEmpty(this.f27060d) && !TextUtils.isEmpty(this.f27061e) && !TextUtils.isEmpty(this.f27062f) && !TextUtils.isEmpty(this.f27063g)) {
            if (!f27057a && arrayList == null) {
                throw new AssertionError();
            }
            arrayList.add(new RestNameValuePair("activity_id", this.f27060d));
            arrayList.add(new RestNameValuePair(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE, this.f27061e));
            arrayList.add(new RestNameValuePair("coupon_num", this.f27062f));
            arrayList.add(new RestNameValuePair("coupon_expire_time", this.f27063g));
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
