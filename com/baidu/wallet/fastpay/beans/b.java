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
    public String f24355a;

    /* renamed from: b  reason: collision with root package name */
    public String f24356b;

    /* renamed from: c  reason: collision with root package name */
    public String f24357c;

    /* renamed from: d  reason: collision with root package name */
    public String f24358d;

    public <T> b(Context context) {
        super(context);
        this.f24355a = "";
        this.f24356b = "";
        this.f24357c = "";
        this.f24358d = "";
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f24355a = str2;
        this.f24356b = str;
        this.f24357c = str3;
        this.f24358d = str4;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(GetOrderResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f24356b)));
        arrayList.add(new RestNameValuePair("price", this.f24355a));
        arrayList.add(new RestNameValuePair("is_huodong_price", this.f24357c));
        arrayList.add(new RestNameValuePair("device_token", this.f24358d));
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
