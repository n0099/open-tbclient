package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
import com.baidu.wallet.paysdk.datamodel.EemCardListResponse;
import com.baidu.wallet.paysdk.datamodel.SourceFlag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends BaseBean<CardListResponse> {

    /* renamed from: a  reason: collision with root package name */
    public SourceFlag f25982a;

    public k(Context context) {
        super(context);
        this.f25982a = SourceFlag.SDK;
    }

    public void a(SourceFlag sourceFlag) {
        if (sourceFlag == null) {
            sourceFlag = SourceFlag.SDK;
        }
        this.f25982a = sourceFlag;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(EemCardListResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("source_flag", this.f25982a.value()));
        arrayList.add(new RestNameValuePair("is_from_sdk", "1"));
        arrayList.add(new RestNameValuePair("ea_bank_code", "0"));
        arrayList.add(new RestNameValuePair("need_balance", "1"));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 607;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_EEM_CARD_LIST;
    }
}
