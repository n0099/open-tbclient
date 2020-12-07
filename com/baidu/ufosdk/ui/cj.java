package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes22.dex */
final class cj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ci f3807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ci ciVar) {
        this.f3807a = ciVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x003b: INVOKE  (r0v31 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.Map : 0x0036: CHECK_CAST (r0v30 java.util.Map A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x0032: INVOKE  (r0v29 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.List : 0x002c: IGET  (r0v28 java.util.List A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.FeedbackInputActivity : 0x002a: IGET  (r0v27 com.baidu.ufosdk.ui.FeedbackInputActivity A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.cg : 0x0028: IGET  (r0v26 com.baidu.ufosdk.ui.cg A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.ci : 0x0026: IGET  (r0v25 com.baidu.ufosdk.ui.ci A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.cj A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.cj.a com.baidu.ufosdk.ui.ci)
     com.baidu.ufosdk.ui.ci.b com.baidu.ufosdk.ui.cg)
     com.baidu.ufosdk.ui.cg.a com.baidu.ufosdk.ui.FeedbackInputActivity)
     com.baidu.ufosdk.ui.FeedbackInputActivity.h java.util.List)
      (wrap: int : 0x0030: IGET  (r3v1 int A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.ci : 0x002e: IGET  (r3v0 com.baidu.ufosdk.ui.ci A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.cj A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.cj.a com.baidu.ufosdk.ui.ci)
     com.baidu.ufosdk.ui.ci.a int)
     type: INTERFACE call: java.util.List.get(int):java.lang.Object))
      ("chatId")
     type: INTERFACE call: java.util.Map.get(java.lang.Object):java.lang.Object)] */
    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        if (((Map) this.f3807a.b.f3804a.h.get(this.f3807a.f3806a)).containsKey("chatId")) {
            this.f3807a.b.f3804a.f = new StringBuilder().append(((Map) this.f3807a.b.f3804a.h.get(this.f3807a.f3806a)).get("chatId")).toString();
        }
        com.baidu.ufosdk.e.a.a(this.f3807a.b.f3804a.f, 11);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("id", this.f3807a.b.f3804a.e);
            String a2 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationToast", "sdk_encrypt=" + URLEncoder.encode(com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            handler = this.f3807a.b.f3804a.aK;
            handler.obtainMessage(7, a2).sendToTarget();
            context = this.f3807a.b.b;
            String str = UfoSDK.clientid;
            com.baidu.ufosdk.e.a.a(context, this.f3807a.b.f3804a.e, UfoSDK.appid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
