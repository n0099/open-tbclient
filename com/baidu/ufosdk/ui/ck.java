package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import java.util.Map;
/* loaded from: classes22.dex */
final class ck implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3808a;
    final /* synthetic */ cg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cg cgVar, int i) {
        this.b = cgVar;
        this.f3808a = i;
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
        this.b.f3804a.aF = this.f3808a;
        com.baidu.ufosdk.f.c.a("点击未解决！！！");
        ((Map) this.b.f3804a.h.get(this.f3808a)).put(UgcUBCUtils.UGC_TYPE_ASK, 3);
        if (((Map) this.b.f3804a.h.get(this.f3808a)).containsKey("chatId")) {
            this.b.f3804a.f = new StringBuilder().append(((Map) this.b.f3804a.h.get(this.f3808a)).get("chatId")).toString();
        }
        this.b.f3804a.l.execute(new cl(this));
        FeedbackInputActivity.a(this.b.f3804a, false, true);
    }
}
