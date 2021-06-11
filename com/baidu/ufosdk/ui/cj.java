package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class cj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ci f22800a;

    public cj(ci ciVar) {
        this.f22800a = ciVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        ci ciVar = this.f22800a;
        if (((Map) ciVar.f22799b.f22795a.f22699h.get(ciVar.f22798a)).containsKey("chatId")) {
            FeedbackInputActivity feedbackInputActivity = this.f22800a.f22799b.f22795a;
            StringBuilder sb = new StringBuilder();
            ci ciVar2 = this.f22800a;
            sb.append(((Map) ciVar2.f22799b.f22795a.f22699h.get(ciVar2.f22798a)).get("chatId"));
            feedbackInputActivity.f22697f = sb.toString();
        }
        com.baidu.ufosdk.e.a.a(this.f22800a.f22799b.f22795a.f22697f, 11);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("id", this.f22800a.f22799b.f22795a.f22696e);
            String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationToast", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
            handler = this.f22800a.f22799b.f22795a.aK;
            handler.obtainMessage(7, a3).sendToTarget();
            context = this.f22800a.f22799b.f22796b;
            String str = UfoSDK.clientid;
            com.baidu.ufosdk.e.a.a(context, this.f22800a.f22799b.f22795a.f22696e, UfoSDK.appid);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
