package com.baidu.wallet.qrcodescanner.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.qrcodescanner.datamodel.QRCodeShortUrlResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseBean<QRCodeShortUrlResponse> {

    /* renamed from: a  reason: collision with root package name */
    public String f26758a;

    /* renamed from: b  reason: collision with root package name */
    public String f26759b;

    public a(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f26758a = str;
    }

    public void b(String str) {
        this.f26759b = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(QRCodeShortUrlResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("output", "json"));
        if (!TextUtils.isEmpty(this.f26758a)) {
            arrayList.add(new RestNameValuePair("qrcode", this.f26758a));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return QRCodeScannerBeanFactory.QRCODE_SHORT_URL;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        if (!TextUtils.isEmpty(this.f26759b)) {
            return this.f26759b;
        }
        return DomainConfig.getInstance().getAppPayHost() + "/facilepaycenter/tinyurl/scancode";
    }
}
