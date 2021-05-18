package com.baidu.wallet.paysdk.presenter.a;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.a;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
/* loaded from: classes5.dex */
public class a implements a.InterfaceC0252a {

    /* renamed from: a  reason: collision with root package name */
    public a.b f25459a;

    public a(a.b bVar) {
        this.f25459a = bVar;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.InterfaceC0252a
    public boolean a(String str) {
        return !TextUtils.isEmpty(str);
    }

    @Override // com.baidu.wallet.paysdk.contract.a.InterfaceC0252a
    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.trim().replace(" ", "").length() >= 9;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.InterfaceC0252a
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        payRequest.setmBankCardNumber(str.replace(" ", ""));
        PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, payRequest);
    }
}
