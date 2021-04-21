package com.baidu.wallet.paysdk.fingerprint.bean;

import android.content.Context;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends PayBaseBean {

    /* renamed from: a  reason: collision with root package name */
    public String f25332a;

    public a(Context context) {
        super(context);
        this.f25332a = null;
    }

    public void a(String str) {
        this.f25332a = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        execBean(String.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (this.f25332a != null) {
            arrayList.add(new RestNameValuePair("serial_num", SafePay.getInstance().encryptProxy(this.f25332a)));
        }
        arrayList.add(new RestNameValuePair("pay_type", "1"));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + "/_u/otp/closetoken";
    }
}
