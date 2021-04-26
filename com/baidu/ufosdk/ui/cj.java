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
    public final /* synthetic */ ci f23523a;

    public cj(ci ciVar) {
        this.f23523a = ciVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        ci ciVar = this.f23523a;
        if (((Map) ciVar.f23522b.f23518a.f23422h.get(ciVar.f23521a)).containsKey("chatId")) {
            FeedbackInputActivity feedbackInputActivity = this.f23523a.f23522b.f23518a;
            StringBuilder sb = new StringBuilder();
            ci ciVar2 = this.f23523a;
            sb.append(((Map) ciVar2.f23522b.f23518a.f23422h.get(ciVar2.f23521a)).get("chatId"));
            feedbackInputActivity.f23420f = sb.toString();
        }
        com.baidu.ufosdk.e.a.a(this.f23523a.f23522b.f23518a.f23420f, 11);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("id", this.f23523a.f23522b.f23518a.f23419e);
            String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationToast", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
            handler = this.f23523a.f23522b.f23518a.aK;
            handler.obtainMessage(7, a3).sendToTarget();
            context = this.f23523a.f23522b.f23519b;
            String str = UfoSDK.clientid;
            com.baidu.ufosdk.e.a.a(context, this.f23523a.f23522b.f23518a.f23419e, UfoSDK.appid);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
