package com.baidu.wallet.qrcodescanner.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.qrcodescanner.datamodel.QRCodeWhiteListResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseBean<QRCodeWhiteListResponse> {

    /* renamed from: a  reason: collision with root package name */
    public String f26435a;

    public b(Context context) {
        super(context);
        this.f26435a = "";
    }

    public void a(String str) {
        this.f26435a = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(QRCodeWhiteListResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f26435a)) {
            this.f26435a = "";
        }
        arrayList.add(new RestNameValuePair("cate[whitelist]", this.f26435a));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return QRCodeScannerBeanFactory.QRCODE_WHITE_LIST;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppHost() + "/odp/wireless/config/common";
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean needVerifySignature() {
        return true;
    }
}
