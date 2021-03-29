package com.baidu.wallet.personal.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.mobstat.Config;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.personal.datamodel.TransRecordsResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class QueryHceTransRecordsBean extends BaseBean<TransRecordsResponse> {

    /* renamed from: a  reason: collision with root package name */
    public String f26548a;

    /* renamed from: b  reason: collision with root package name */
    public String f26549b;

    public QueryHceTransRecordsBean(Context context) {
        super(context);
        this.f26548a = "";
        this.f26549b = "";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(TransRecordsResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f26548a)) {
            arrayList.add(new RestNameValuePair(Config.PACKAGE_NAME, this.f26548a));
        }
        if (!TextUtils.isEmpty(this.f26549b)) {
            arrayList.add(new RestNameValuePair("type", this.f26549b));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 604;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + "/o2o/0/hce/0/trans_query/0";
    }

    public void setPageNum(String str) {
        this.f26548a = str;
    }

    public void setType(String str) {
        this.f26549b = str;
    }
}
