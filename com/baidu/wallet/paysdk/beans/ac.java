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
    public String f25480a;

    /* renamed from: b  reason: collision with root package name */
    public String f25481b;

    /* renamed from: c  reason: collision with root package name */
    public String f25482c;

    /* renamed from: d  reason: collision with root package name */
    public String f25483d;

    /* renamed from: e  reason: collision with root package name */
    public String f25484e;

    /* renamed from: f  reason: collision with root package name */
    public String f25485f;

    public ac(Context context) {
        super(context);
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f25480a = str;
        this.f25481b = str2;
        this.f25482c = str3;
        this.f25483d = str4;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("mobile_pwd", this.f25480a));
        arrayList.add(new RestNameValuePair("seed", this.f25481b));
        arrayList.add(new RestNameValuePair("new_passfree_status", this.f25482c));
        arrayList.add(new RestNameValuePair("new_passfree_credit", this.f25483d));
        if (!TextUtils.isEmpty(this.f25484e)) {
            arrayList.add(new RestNameValuePair("mobile", PayUtils.encrypt("phone_number", this.f25484e)));
        }
        if (!TextUtils.isEmpty(this.f25485f)) {
            arrayList.add(new RestNameValuePair("sms_vcode", this.f25485f));
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
        this.f25484e = str;
        this.f25485f = str2;
    }
}
