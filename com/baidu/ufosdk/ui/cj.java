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
    public final /* synthetic */ ci f23119a;

    public cj(ci ciVar) {
        this.f23119a = ciVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        ci ciVar = this.f23119a;
        if (((Map) ciVar.f23118b.f23114a.f23021h.get(ciVar.f23117a)).containsKey("chatId")) {
            FeedbackInputActivity feedbackInputActivity = this.f23119a.f23118b.f23114a;
            StringBuilder sb = new StringBuilder();
            ci ciVar2 = this.f23119a;
            sb.append(((Map) ciVar2.f23118b.f23114a.f23021h.get(ciVar2.f23117a)).get("chatId"));
            feedbackInputActivity.f23019f = sb.toString();
        }
        com.baidu.ufosdk.e.a.a(this.f23119a.f23118b.f23114a.f23019f, 11);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("id", this.f23119a.f23118b.f23114a.f23018e);
            String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationToast", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
            handler = this.f23119a.f23118b.f23114a.aK;
            handler.obtainMessage(7, a3).sendToTarget();
            context = this.f23119a.f23118b.f23115b;
            String str = UfoSDK.clientid;
            com.baidu.ufosdk.e.a.a(context, this.f23119a.f23118b.f23114a.f23018e, UfoSDK.appid);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
