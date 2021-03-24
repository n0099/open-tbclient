package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.AuthStateResponse;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class SecuityCenterBean extends PayBaseBean<AuthStateResponse> implements NoProguard {
    public <T> SecuityCenterBean(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(AuthStateResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("enroll_fingerprint", WalletFingerprint.getInstance(this.mContext).hasEnrollFingerprint() ? "1" : "0"));
        arrayList.add(new RestNameValuePair("device_support", WalletFingerprint.getInstance(this.mContext).isDevicesSupport() ? "1" : "0"));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SECUITY_CENTER;
    }
}
