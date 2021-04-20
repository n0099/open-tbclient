package com.baidu.wallet.lightapp.business.a;

import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.lightapp.business.datamodel.LangBridgeCfg;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseBean {

    /* renamed from: a  reason: collision with root package name */
    public String f24790a;

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(LangBridgeCfg.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("cate[lbconfig]", this.f24790a));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppHost() + "/odp/wireless/config/common";
    }
}
