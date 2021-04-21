package com.baidu.wallet.paysdk.presenter.a;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.a;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
/* loaded from: classes5.dex */
public class d implements a.InterfaceC0270a {

    /* renamed from: a  reason: collision with root package name */
    public a.b f25442a;

    /* renamed from: b  reason: collision with root package name */
    public final com.baidu.wallet.paysdk.a f25443b = new com.baidu.wallet.paysdk.a(2);

    public d(a.b bVar) {
        this.f25442a = bVar;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.InterfaceC0270a
    public boolean a(String str) {
        return this.f25443b.a(str);
    }

    @Override // com.baidu.wallet.paysdk.contract.a.InterfaceC0270a
    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.length() >= 15;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.InterfaceC0270a
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        payRequest.setmIdCard(str.trim());
        PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, payRequest);
    }
}
