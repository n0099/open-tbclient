package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ad extends PayBaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public String f25172a;

    /* renamed from: b  reason: collision with root package name */
    public String f25173b;

    /* renamed from: c  reason: collision with root package name */
    public String f25174c;

    public ad(Context context) {
        super(context);
        this.f25172a = "";
        this.f25173b = "";
        this.f25174c = "";
    }

    public void a(String str) {
        this.f25174c = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("paymethod_list", this.f25174c));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_PAY_SORT_SAVE;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SAVE_PAY_SORT;
    }
}
