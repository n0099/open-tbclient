package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ck implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f23120a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f23121b;

    public ck(cg cgVar, int i) {
        this.f23121b = cgVar;
        this.f23120a = i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0053: INVOKE  (r0v8 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.Map : 0x0051: CHECK_CAST (r2v4 java.util.Map A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x004d: INVOKE  (r2v3 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.List : 0x0049: IGET  (r2v2 java.util.List A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.FeedbackInputActivity : 0x0047: IGET  (r2v1 com.baidu.ufosdk.ui.FeedbackInputActivity A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.cg : 0x0045: IGET  (r2v0 com.baidu.ufosdk.ui.cg A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.ck A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.ck.b com.baidu.ufosdk.ui.cg)
     com.baidu.ufosdk.ui.cg.a com.baidu.ufosdk.ui.FeedbackInputActivity)
     com.baidu.ufosdk.ui.FeedbackInputActivity.h java.util.List)
      (wrap: int : 0x004b: IGET  (r3v0 int A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.ck A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.ck.a int)
     type: INTERFACE call: java.util.List.get(int):java.lang.Object))
      ("chatId")
     type: INTERFACE call: java.util.Map.get(java.lang.Object):java.lang.Object)] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23121b.f23114a.aF = this.f23120a;
        com.baidu.ufosdk.f.c.a("点击未解决！！！");
        ((Map) this.f23121b.f23114a.f23021h.get(this.f23120a)).put("ask", 3);
        if (((Map) this.f23121b.f23114a.f23021h.get(this.f23120a)).containsKey("chatId")) {
            FeedbackInputActivity feedbackInputActivity = this.f23121b.f23114a;
            StringBuilder sb = new StringBuilder();
            sb.append(((Map) this.f23121b.f23114a.f23021h.get(this.f23120a)).get("chatId"));
            feedbackInputActivity.f23019f = sb.toString();
        }
        this.f23121b.f23114a.l.execute(new cl(this));
        FeedbackInputActivity.a(this.f23121b.f23114a, false, true);
    }
}
