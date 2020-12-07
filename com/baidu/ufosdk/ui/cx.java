package com.baidu.ufosdk.ui;

import android.text.TextUtils;
import android.view.View;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes22.dex */
final class cx implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3821a;
    final /* synthetic */ JSONArray b;
    final /* synthetic */ int c;
    final /* synthetic */ cg d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cg cgVar, String str, JSONArray jSONArray, int i) {
        this.d = cgVar;
        this.f3821a = str;
        this.b = jSONArray;
        this.c = i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x006e: INVOKE  (r0v34 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.Map : 0x0069: CHECK_CAST (r0v33 java.util.Map A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x0065: INVOKE  (r0v32 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.List : 0x0061: IGET  (r0v31 java.util.List A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.FeedbackInputActivity : 0x005f: IGET  (r0v30 com.baidu.ufosdk.ui.FeedbackInputActivity A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.cg : 0x005d: IGET  (r0v29 com.baidu.ufosdk.ui.cg A[REMOVE]) = (r6v0 'this' com.baidu.ufosdk.ui.cx A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.cx.d com.baidu.ufosdk.ui.cg)
     com.baidu.ufosdk.ui.cg.a com.baidu.ufosdk.ui.FeedbackInputActivity)
     com.baidu.ufosdk.ui.FeedbackInputActivity.h java.util.List)
      (wrap: int : 0x0063: IGET  (r3v0 int A[REMOVE]) = (r6v0 'this' com.baidu.ufosdk.ui.cx A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.cx.c int)
     type: INTERFACE call: java.util.List.get(int):java.lang.Object))
      ("chatId")
     type: INTERFACE call: java.util.Map.get(java.lang.Object):java.lang.Object)] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击查看不满意原因");
        if (!TextUtils.isEmpty(this.f3821a) || (this.b != null && this.b.length() != 0)) {
            ((Map) this.d.f3804a.h.get(this.c)).put("isClicked", 1);
        }
        this.d.f3804a.aF = this.c;
        if (((Map) this.d.f3804a.h.get(this.c)).containsKey("chatId")) {
            this.d.f3804a.f = new StringBuilder().append(((Map) this.d.f3804a.h.get(this.c)).get("chatId")).toString();
        }
        if (TextUtils.isEmpty(this.f3821a) && (this.b == null || this.b.length() == 0)) {
            FeedbackInputActivity.a(this.d.f3804a, false, false);
        } else {
            FeedbackInputActivity.a(this.d.f3804a, true, false);
        }
        this.d.f3804a.j.notifyDataSetChanged();
    }
}
