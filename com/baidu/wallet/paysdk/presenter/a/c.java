package com.baidu.wallet.paysdk.presenter.a;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.a;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
/* loaded from: classes5.dex */
public class c implements a.InterfaceC0270a {

    /* renamed from: a  reason: collision with root package name */
    public a.b f25441a;

    public c(a.b bVar) {
        this.f25441a = bVar;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.InterfaceC0270a
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.trim().length() == 3 || str.trim().length() == 4;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.InterfaceC0270a
    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.length() >= 3;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.InterfaceC0270a
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        payRequest.setmCvv2(str.trim());
        PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, payRequest);
    }
}
