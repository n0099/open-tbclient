package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.PayQueryRequest;
import com.baidu.wallet.paysdk.datamodel.QueryPayResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class z extends PayBaseBean<QueryPayResponse> {

    /* renamed from: a  reason: collision with root package name */
    public List<RestNameValuePair> f25547a;

    public <T> z(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(QueryPayResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        List<RestNameValuePair> list = this.f25547a;
        if (list != null) {
            return list;
        }
        PayQueryRequest payQueryRequest = (PayQueryRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY_QUERY);
        if (payQueryRequest == null || !payQueryRequest.checkRequestValidity()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("name", payQueryRequest.mName));
        arrayList.add(new RestNameValuePair("order_no", payQueryRequest.mOrderNo));
        if (!TextUtils.isEmpty(payQueryRequest.mBankNo)) {
            arrayList.add(new RestNameValuePair("bank_no", payQueryRequest.mBankNo));
        }
        arrayList.add(new RestNameValuePair("sign", payQueryRequest.getMd5Sign()));
        this.f25547a = arrayList;
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 12;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_QUERY_TRANS_EASY;
    }
}
