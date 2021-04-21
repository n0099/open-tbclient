package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ac extends PayBaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public String f25174a;

    /* renamed from: b  reason: collision with root package name */
    public String f25175b;

    /* renamed from: c  reason: collision with root package name */
    public String f25176c;

    /* renamed from: d  reason: collision with root package name */
    public String f25177d;

    /* renamed from: e  reason: collision with root package name */
    public String f25178e;

    /* renamed from: f  reason: collision with root package name */
    public String f25179f;

    public ac(Context context) {
        super(context);
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f25174a = str;
        this.f25175b = str2;
        this.f25176c = str3;
        this.f25177d = str4;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("mobile_pwd", this.f25174a));
        arrayList.add(new RestNameValuePair("seed", this.f25175b));
        arrayList.add(new RestNameValuePair("new_passfree_status", this.f25176c));
        arrayList.add(new RestNameValuePair("new_passfree_credit", this.f25177d));
        if (!TextUtils.isEmpty(this.f25178e)) {
            arrayList.add(new RestNameValuePair("mobile", PayUtils.encrypt("phone_number", this.f25178e)));
        }
        if (!TextUtils.isEmpty(this.f25179f)) {
            arrayList.add(new RestNameValuePair("sms_vcode", this.f25179f));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SAVE_PAYFREE;
    }

    public void a(String str, String str2) {
        this.f25178e = str;
        this.f25179f = str2;
    }
}
