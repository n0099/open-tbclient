package com.baidu.wallet.fastpay.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.fastpay.datamodel.GetOrderResponse;
import com.baidu.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseBean<GetOrderResponse> {

    /* renamed from: a  reason: collision with root package name */
    public String f24156a;

    /* renamed from: b  reason: collision with root package name */
    public String f24157b;

    /* renamed from: c  reason: collision with root package name */
    public String f24158c;

    /* renamed from: d  reason: collision with root package name */
    public String f24159d;

    public <T> b(Context context) {
        super(context);
        this.f24156a = "";
        this.f24157b = "";
        this.f24158c = "";
        this.f24159d = "";
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f24156a = str2;
        this.f24157b = str;
        this.f24158c = str3;
        this.f24159d = str4;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(GetOrderResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f24157b)));
        arrayList.add(new RestNameValuePair("price", this.f24156a));
        arrayList.add(new RestNameValuePair("is_huodong_price", this.f24158c));
        arrayList.add(new RestNameValuePair("device_token", this.f24159d));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return FastPayBeanFactory.BEAN_ID_GET_ORDER;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getLifeHost() + "/_u/pdc/common_charge/native";
    }
}
