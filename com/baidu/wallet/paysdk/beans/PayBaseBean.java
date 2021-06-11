package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class PayBaseBean<T> extends BaseBean<T> {

    /* renamed from: a  reason: collision with root package name */
    public long f25201a;

    public PayBaseBean(Context context) {
        super(context);
        this.f25201a = 0L;
    }

    private void a(int i2) {
        long currentTimeMillis = System.currentTimeMillis() - this.f25201a;
        try {
            String path = new URL(getUrl()).getPath();
            List<String> collectData = StatHelper.collectData(path, i2 + "");
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(currentTimeMillis));
            StatisticManager.onEventWithValues(PayStatServiceEvent.CALL_INTERFACE, collectData, hashMap);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        this.f25201a = System.currentTimeMillis();
        super.execBean(cls, cls2);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean, com.baidu.apollon.beans.ApollonBean
    public void handleCommonErrors(Exception exc) {
        a(-2);
        super.handleCommonErrors(exc);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean, com.baidu.apollon.beans.ApollonBean
    public void handleNetworkFailureError() {
        a(-8);
        super.handleNetworkFailureError();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Class<T1> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.wallet.core.beans.BaseBean, com.baidu.apollon.beans.ApollonBean
    public <T1, E> void handleResponse(Class<T1> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        if (restResponseEntity != null && restResponseEntity.getBody() != null) {
            a(restResponseEntity.getBody().ret);
        } else {
            a(-4);
        }
        super.handleResponse(cls, cls2, restResponseEntity);
    }

    public PayBaseBean(Context context, int i2) {
        super(context, i2);
        this.f25201a = 0L;
    }
}
