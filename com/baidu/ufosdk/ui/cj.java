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
    public final /* synthetic */ ci f22697a;

    public cj(ci ciVar) {
        this.f22697a = ciVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        ci ciVar = this.f22697a;
        if (((Map) ciVar.f22696b.f22692a.f22596h.get(ciVar.f22695a)).containsKey("chatId")) {
            FeedbackInputActivity feedbackInputActivity = this.f22697a.f22696b.f22692a;
            StringBuilder sb = new StringBuilder();
            ci ciVar2 = this.f22697a;
            sb.append(((Map) ciVar2.f22696b.f22692a.f22596h.get(ciVar2.f22695a)).get("chatId"));
            feedbackInputActivity.f22594f = sb.toString();
        }
        com.baidu.ufosdk.e.a.a(this.f22697a.f22696b.f22692a.f22594f, 11);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("id", this.f22697a.f22696b.f22692a.f22593e);
            String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationToast", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
            handler = this.f22697a.f22696b.f22692a.aK;
            handler.obtainMessage(7, a3).sendToTarget();
            context = this.f22697a.f22696b.f22693b;
            String str = UfoSDK.clientid;
            com.baidu.ufosdk.e.a.a(context, this.f22697a.f22696b.f22692a.f22593e, UfoSDK.appid);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
