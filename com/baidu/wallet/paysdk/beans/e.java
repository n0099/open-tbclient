package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
import com.baidu.wallet.paysdk.datamodel.SourceFlag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends PayBaseBean<CardListResponse> {

    /* renamed from: a  reason: collision with root package name */
    public SourceFlag f25147a;

    public e(Context context) {
        super(context);
        this.f25147a = SourceFlag.SDK;
    }

    public void a(SourceFlag sourceFlag) {
        if (sourceFlag == null) {
            sourceFlag = SourceFlag.SDK;
        }
        this.f25147a = sourceFlag;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CardListResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("source_flag", this.f25147a.value()));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_CARD_LIST;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_CARD_LIST;
    }
}
