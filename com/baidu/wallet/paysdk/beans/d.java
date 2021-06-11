package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddErrorContent;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes5.dex */
public class d extends PayBaseBean<CardAddResponse> {

    /* renamed from: a  reason: collision with root package name */
    public String f25248a;

    /* renamed from: b  reason: collision with root package name */
    public BindFastRequest f25249b;

    public d(Context context) {
        super(context);
        this.f25248a = null;
        this.f25249b = null;
    }

    public void a(String str) {
        this.f25248a = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CardAddResponse.class, CardAddErrorContent.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        List<RestNameValuePair> json2KeyValuePairs;
        if (this.f25249b != null) {
            if (TextUtils.isEmpty(this.f25248a)) {
                json2KeyValuePairs = new ArrayList<>();
            } else {
                json2KeyValuePairs = JsonUtil.json2KeyValuePairs(this.f25248a);
                if (json2KeyValuePairs == null) {
                    json2KeyValuePairs = new ArrayList<>();
                }
                ListIterator<RestNameValuePair> listIterator = json2KeyValuePairs.listIterator();
                while (listIterator.hasNext()) {
                    RestNameValuePair next = listIterator.next();
                    if (next != null && "source_flag".equals(next.getName())) {
                        listIterator.remove();
                    }
                }
            }
            json2KeyValuePairs.add(new RestNameValuePair("source_flag", "3"));
            return json2KeyValuePairs;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_CARD_ADD;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_CARD_ADD;
    }

    @Override // com.baidu.wallet.core.beans.BaseBean
    public void handleSession(BeanResponseBase.Session session) {
        BindFastRequest bindFastRequest = this.f25249b;
        if (bindFastRequest != null) {
            bindFastRequest.saveSession(session);
        } else {
            NetworkBean.SessionCache.getInstance().put(null, session);
        }
    }

    public void a(BindFastRequest bindFastRequest) {
        this.f25249b = bindFastRequest;
    }

    public BindFastRequest a() {
        return this.f25249b;
    }
}
