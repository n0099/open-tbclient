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
    public String f24354a;

    /* renamed from: b  reason: collision with root package name */
    public String f24355b;

    /* renamed from: c  reason: collision with root package name */
    public String f24356c;

    /* renamed from: d  reason: collision with root package name */
    public String f24357d;

    public <T> b(Context context) {
        super(context);
        this.f24354a = "";
        this.f24355b = "";
        this.f24356c = "";
        this.f24357d = "";
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f24354a = str2;
        this.f24355b = str;
        this.f24356c = str3;
        this.f24357d = str4;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(GetOrderResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f24355b)));
        arrayList.add(new RestNameValuePair("price", this.f24354a));
        arrayList.add(new RestNameValuePair("is_huodong_price", this.f24356c));
        arrayList.add(new RestNameValuePair("device_token", this.f24357d));
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
