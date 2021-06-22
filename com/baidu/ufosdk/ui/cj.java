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
    public final /* synthetic */ ci f22882a;

    public cj(ci ciVar) {
        this.f22882a = ciVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        ci ciVar = this.f22882a;
        if (((Map) ciVar.f22881b.f22877a.f22781h.get(ciVar.f22880a)).containsKey("chatId")) {
            FeedbackInputActivity feedbackInputActivity = this.f22882a.f22881b.f22877a;
            StringBuilder sb = new StringBuilder();
            ci ciVar2 = this.f22882a;
            sb.append(((Map) ciVar2.f22881b.f22877a.f22781h.get(ciVar2.f22880a)).get("chatId"));
            feedbackInputActivity.f22779f = sb.toString();
        }
        com.baidu.ufosdk.e.a.a(this.f22882a.f22881b.f22877a.f22779f, 11);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("id", this.f22882a.f22881b.f22877a.f22778e);
            String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationToast", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
            handler = this.f22882a.f22881b.f22877a.aK;
            handler.obtainMessage(7, a3).sendToTarget();
            context = this.f22882a.f22881b.f22878b;
            String str = UfoSDK.clientid;
            com.baidu.ufosdk.e.a.a(context, this.f22882a.f22881b.f22877a.f22778e, UfoSDK.appid);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
