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
    public String f25944a;

    /* renamed from: b  reason: collision with root package name */
    public String f25945b;

    /* renamed from: c  reason: collision with root package name */
    public String f25946c;

    /* renamed from: d  reason: collision with root package name */
    public String f25947d;

    /* renamed from: e  reason: collision with root package name */
    public String f25948e;

    /* renamed from: f  reason: collision with root package name */
    public String f25949f;

    public ac(Context context) {
        super(context);
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f25944a = str;
        this.f25945b = str2;
        this.f25946c = str3;
        this.f25947d = str4;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("mobile_pwd", this.f25944a));
        arrayList.add(new RestNameValuePair("seed", this.f25945b));
        arrayList.add(new RestNameValuePair("new_passfree_status", this.f25946c));
        arrayList.add(new RestNameValuePair("new_passfree_credit", this.f25947d));
        if (!TextUtils.isEmpty(this.f25948e)) {
            arrayList.add(new RestNameValuePair("mobile", PayUtils.encrypt("phone_number", this.f25948e)));
        }
        if (!TextUtils.isEmpty(this.f25949f)) {
            arrayList.add(new RestNameValuePair("sms_vcode", this.f25949f));
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
        this.f25948e = str;
        this.f25949f = str2;
    }
}
