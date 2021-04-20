package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ck implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22806a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f22807b;

    public ck(cg cgVar, int i) {
        this.f22807b = cgVar;
        this.f22806a = i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0054: INVOKE  (r0v8 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.Map : 0x0052: CHECK_CAST (r2v4 java.util.Map A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x004e: INVOKE  (r2v3 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.List : 0x004a: IGET  (r2v2 java.util.List A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.FeedbackInputActivity : 0x0048: IGET  (r2v1 com.baidu.ufosdk.ui.FeedbackInputActivity A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.cg : 0x0046: IGET  (r2v0 com.baidu.ufosdk.ui.cg A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.ck A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.ck.b com.baidu.ufosdk.ui.cg)
     com.baidu.ufosdk.ui.cg.a com.baidu.ufosdk.ui.FeedbackInputActivity)
     com.baidu.ufosdk.ui.FeedbackInputActivity.h java.util.List)
      (wrap: int : 0x004c: IGET  (r3v0 int A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.ck A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.ck.a int)
     type: INTERFACE call: java.util.List.get(int):java.lang.Object))
      ("chatId")
     type: INTERFACE call: java.util.Map.get(java.lang.Object):java.lang.Object)] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f22807b.f22800a.aF = this.f22806a;
        com.baidu.ufosdk.f.c.a("点击未解决！！！");
        ((Map) this.f22807b.f22800a.f22707h.get(this.f22806a)).put("ask", 3);
        if (((Map) this.f22807b.f22800a.f22707h.get(this.f22806a)).containsKey("chatId")) {
            FeedbackInputActivity feedbackInputActivity = this.f22807b.f22800a;
            StringBuilder sb = new StringBuilder();
            sb.append(((Map) this.f22807b.f22800a.f22707h.get(this.f22806a)).get("chatId"));
            feedbackInputActivity.f22705f = sb.toString();
        }
        this.f22807b.f22800a.l.execute(new cl(this));
        FeedbackInputActivity.a(this.f22807b.f22800a, false, true);
    }
}
