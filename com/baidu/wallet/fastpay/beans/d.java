package com.baidu.wallet.fastpay.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.statistics.StatSettings;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.fastpay.datamodel.QueryLocationResponse;
import com.baidu.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public String f24801a;

    /* renamed from: b  reason: collision with root package name */
    public String f24802b;

    public <T> d(Context context) {
        super(context);
        this.f24801a = "";
        this.f24802b = "";
    }

    public void a(String str, String str2) {
        this.f24801a = str;
        this.f24802b = str2;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(QueryLocationResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("mobile_num", PayUtils.encrypt("phone_number", this.f24801a)));
        arrayList.add(new RestNameValuePair("cmd", "1067"));
        arrayList.add(new RestNameValuePair("callback", "phonePriceInfo_common"));
        arrayList.add(new RestNameValuePair("device_token", this.f24802b));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return FastPayBeanFactory.BEAN_ID_QUERY_LOCATION;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getLifeHost() + StatSettings.GET_STRATETY_URL;
    }
}
