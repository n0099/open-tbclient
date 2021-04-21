package com.baidu.wallet.core.beans;

import android.content.Context;
import com.baidu.apollon.restnet.rest.d;
/* loaded from: classes5.dex */
public class CometHttpRequestInterceptor extends EbpayHttpRequestInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23927a = 60000;

    /* renamed from: b  reason: collision with root package name */
    public static final String f23928b = "CometHttpRequestInterceptor";

    @Override // com.baidu.wallet.core.beans.EbpayHttpRequestInterceptor, com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
    public void intercept(Context context, d dVar) {
        super.intercept(context, dVar);
        dVar.a(60000);
    }
}
