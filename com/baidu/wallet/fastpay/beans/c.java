package com.baidu.wallet.fastpay.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.fastpay.datamodel.PromotionInfoResponse;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BaseBean<PromotionInfoResponse> {
    public <T> c(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(PromotionInfoResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        return null;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getAuthLevel() {
        return 1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return FastPayBeanFactory.BEAN_ID_PROMOTION_INFO;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getLifeHost() + "/_u/wireless/promotion_query";
    }
}
