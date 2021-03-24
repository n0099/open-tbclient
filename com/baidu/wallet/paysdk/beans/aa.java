package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.QueryBankBinResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class aa extends PayBaseBean<QueryBankBinResponse> {

    /* renamed from: a  reason: collision with root package name */
    public String f25477a;

    public <T> aa(Context context) {
        super(context);
        this.f25477a = "";
    }

    public void a(String str) {
        this.f25477a = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(QueryBankBinResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f25477a)) {
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25477a)));
        }
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        arrayList.add(new RestNameValuePair("source_flag", "3"));
        if (bindFastRequest != null) {
            arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, bindFastRequest.getServiceType()));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 7;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_QUERY_BANK_INFO;
    }
}
