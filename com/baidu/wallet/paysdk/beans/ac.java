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
    public String f25221a;

    /* renamed from: b  reason: collision with root package name */
    public String f25222b;

    /* renamed from: c  reason: collision with root package name */
    public String f25223c;

    /* renamed from: d  reason: collision with root package name */
    public String f25224d;

    /* renamed from: e  reason: collision with root package name */
    public String f25225e;

    /* renamed from: f  reason: collision with root package name */
    public String f25226f;

    public ac(Context context) {
        super(context);
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f25221a = str;
        this.f25222b = str2;
        this.f25223c = str3;
        this.f25224d = str4;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("mobile_pwd", this.f25221a));
        arrayList.add(new RestNameValuePair("seed", this.f25222b));
        arrayList.add(new RestNameValuePair("new_passfree_status", this.f25223c));
        arrayList.add(new RestNameValuePair("new_passfree_credit", this.f25224d));
        if (!TextUtils.isEmpty(this.f25225e)) {
            arrayList.add(new RestNameValuePair("mobile", PayUtils.encrypt("phone_number", this.f25225e)));
        }
        if (!TextUtils.isEmpty(this.f25226f)) {
            arrayList.add(new RestNameValuePair("sms_vcode", this.f25226f));
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
        this.f25225e = str;
        this.f25226f = str2;
    }
}
