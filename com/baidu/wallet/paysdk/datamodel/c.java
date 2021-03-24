package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends PayBaseBean<RiskControlResponseForNoPwd> {
    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(RiskControlResponseForNoPwd.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("new_passfree_status", "1"));
        arrayList.add(new RestNameValuePair("new_passfree_credit", "20000"));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_RCS_APPLY_NO_PWD;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_REQUEST_RCS_FOR_NO_PWD;
    }
}
