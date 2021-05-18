package com.baidu.wallet.personal.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.personal.datamodel.CouponDetailResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BaseBean<CouponDetailResponse> {

    /* renamed from: a  reason: collision with root package name */
    public int f26297a;

    /* renamed from: b  reason: collision with root package name */
    public String f26298b;

    /* renamed from: c  reason: collision with root package name */
    public String f26299c;

    /* renamed from: d  reason: collision with root package name */
    public String f26300d;

    /* renamed from: e  reason: collision with root package name */
    public String f26301e;

    public c(Context context) {
        super(context);
        this.f26300d = "";
        this.f26301e = "";
    }

    public void a(int i2) {
        this.f26297a = i2;
    }

    public void a(String str) {
        this.f26298b = str;
    }

    public void a(String str, String str2) {
        this.f26300d = str;
        this.f26301e = str2;
    }

    public void b(String str) {
        this.f26299c = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CouponDetailResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("card_type", "" + this.f26297a));
        arrayList.add(new RestNameValuePair("coupon_num", this.f26298b));
        arrayList.add(new RestNameValuePair("template_num", this.f26299c));
        arrayList.add(new RestNameValuePair("user_mapping", this.f26300d + "," + this.f26301e));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 516;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getMyHost() + "/yqcard/card/getcoupondetailv2";
    }
}
