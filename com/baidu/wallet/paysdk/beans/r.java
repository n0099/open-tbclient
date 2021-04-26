package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.UnBindSmSResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class r extends BaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.wallet.paysdk.datamodel.b f25989a;

    public <T> r(Context context) {
        super(context);
        this.f25989a = (com.baidu.wallet.paysdk.datamodel.b) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_GET_SMS);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(UnBindSmSResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f25989a.f26044a)));
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25989a.f26045b)));
        arrayList.add(new RestNameValuePair("request_type", "1"));
        arrayList.add(new RestNameValuePair("token", AccountManager.getInstance(this.mContext).getBfbToken()));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 514;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + com.baidu.wallet.core.beans.BeanConstants.API_SEND_BFB_SMS;
    }
}
