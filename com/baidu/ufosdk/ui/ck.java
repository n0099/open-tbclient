package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes8.dex */
final class ck implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f5497a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cg f5498b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cg cgVar, int i) {
        this.f5498b = cgVar;
        this.f5497a = i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0059: INVOKE  (r0v25 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.Map : 0x0054: CHECK_CAST (r0v24 java.util.Map A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x0050: INVOKE  (r0v23 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.List : 0x004c: IGET  (r0v22 java.util.List A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.FeedbackInputActivity : 0x004a: IGET  (r0v21 com.baidu.ufosdk.ui.FeedbackInputActivity A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.cg : 0x0048: IGET  (r0v20 com.baidu.ufosdk.ui.cg A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.ck A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.ck.b com.baidu.ufosdk.ui.cg)
     com.baidu.ufosdk.ui.cg.a com.baidu.ufosdk.ui.FeedbackInputActivity)
     com.baidu.ufosdk.ui.FeedbackInputActivity.h java.util.List)
      (wrap: int : 0x004e: IGET  (r3v0 int A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.ck A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.ck.a int)
     type: INTERFACE call: java.util.List.get(int):java.lang.Object))
      ("chatId")
     type: INTERFACE call: java.util.Map.get(java.lang.Object):java.lang.Object)] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f5498b.f5491a.aF = this.f5497a;
        com.baidu.ufosdk.f.c.a("点击未解决！！！");
        ((Map) this.f5498b.f5491a.h.get(this.f5497a)).put("ask", 3);
        if (((Map) this.f5498b.f5491a.h.get(this.f5497a)).containsKey("chatId")) {
            this.f5498b.f5491a.f = new StringBuilder().append(((Map) this.f5498b.f5491a.h.get(this.f5497a)).get("chatId")).toString();
        }
        this.f5498b.f5491a.l.execute(new cl(this));
        FeedbackInputActivity.a(this.f5498b.f5491a, false, true);
    }
}
