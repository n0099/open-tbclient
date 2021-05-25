package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.SourceFlag;
import com.baidu.wallet.personal.datamodel.CardRedEemMasResp;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f extends BaseBean<CardRedEemMasResp> {

    /* renamed from: a  reason: collision with root package name */
    public SourceFlag f25148a;

    public f(Context context) {
        super(context);
        this.f25148a = SourceFlag.SDK;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CardRedEemMasResp.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("source_flag", this.f25148a.value()));
        arrayList.add(new RestNameValuePair("is_from_sdk", "1"));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 606;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.RED_EEM_MSG_CARD;
    }
}
