package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class NewSdkInitBean extends BaseBean<SdkInitResponse> {
    public NewSdkInitBean(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(SdkInitResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        return new ArrayList();
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return com.baidu.wallet.core.beans.BeanConstants.BEAN_ID_FOR_NEW_INIT;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getInitHost(true) + com.baidu.wallet.core.beans.BeanConstants.API_GET_FP;
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean needVerifySignature() {
        return true;
    }
}
