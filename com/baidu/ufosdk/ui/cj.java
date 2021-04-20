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
    public final /* synthetic */ ci f22805a;

    public cj(ci ciVar) {
        this.f22805a = ciVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        ci ciVar = this.f22805a;
        if (((Map) ciVar.f22804b.f22800a.f22707h.get(ciVar.f22803a)).containsKey("chatId")) {
            FeedbackInputActivity feedbackInputActivity = this.f22805a.f22804b.f22800a;
            StringBuilder sb = new StringBuilder();
            ci ciVar2 = this.f22805a;
            sb.append(((Map) ciVar2.f22804b.f22800a.f22707h.get(ciVar2.f22803a)).get("chatId"));
            feedbackInputActivity.f22705f = sb.toString();
        }
        com.baidu.ufosdk.e.a.a(this.f22805a.f22804b.f22800a.f22705f, 11);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("id", this.f22805a.f22804b.f22800a.f22704e);
            String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationToast", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
            handler = this.f22805a.f22804b.f22800a.aK;
            handler.obtainMessage(7, a3).sendToTarget();
            context = this.f22805a.f22804b.f22801b;
            String str = UfoSDK.clientid;
            com.baidu.ufosdk.e.a.a(context, this.f22805a.f22804b.f22800a.f22704e, UfoSDK.appid);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
