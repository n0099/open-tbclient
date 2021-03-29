package com.baidu.ufosdk.ui;

import android.text.TextUtils;
import android.view.View;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class cx implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23138a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONArray f23139b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f23140c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ cg f23141d;

    public cx(cg cgVar, String str, JSONArray jSONArray, int i) {
        this.f23141d = cgVar;
        this.f23138a = str;
        this.f23139b = jSONArray;
        this.f23140c = i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0065: INVOKE  (r1v6 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.Map : 0x0063: CHECK_CAST (r3v4 java.util.Map A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x005f: INVOKE  (r3v3 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.List : 0x005b: IGET  (r3v2 java.util.List A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.FeedbackInputActivity : 0x0059: IGET  (r3v1 com.baidu.ufosdk.ui.FeedbackInputActivity A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.cg : 0x0057: IGET  (r3v0 com.baidu.ufosdk.ui.cg A[REMOVE]) = (r5v0 'this' com.baidu.ufosdk.ui.cx A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.cx.d com.baidu.ufosdk.ui.cg)
     com.baidu.ufosdk.ui.cg.a com.baidu.ufosdk.ui.FeedbackInputActivity)
     com.baidu.ufosdk.ui.FeedbackInputActivity.h java.util.List)
      (wrap: int : 0x005d: IGET  (r4v0 int A[REMOVE]) = (r5v0 'this' com.baidu.ufosdk.ui.cx A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.cx.c int)
     type: INTERFACE call: java.util.List.get(int):java.lang.Object))
      ("chatId")
     type: INTERFACE call: java.util.Map.get(java.lang.Object):java.lang.Object)] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        com.baidu.ufosdk.f.c.a("点击查看不满意原因");
        if (!TextUtils.isEmpty(this.f23138a) || ((jSONArray2 = this.f23139b) != null && jSONArray2.length() != 0)) {
            ((Map) this.f23141d.f23115a.f23022h.get(this.f23140c)).put("isClicked", 1);
        }
        this.f23141d.f23115a.aF = this.f23140c;
        if (((Map) this.f23141d.f23115a.f23022h.get(this.f23140c)).containsKey("chatId")) {
            FeedbackInputActivity feedbackInputActivity = this.f23141d.f23115a;
            StringBuilder sb = new StringBuilder();
            sb.append(((Map) this.f23141d.f23115a.f23022h.get(this.f23140c)).get("chatId"));
            feedbackInputActivity.f23020f = sb.toString();
        }
        if (TextUtils.isEmpty(this.f23138a) && ((jSONArray = this.f23139b) == null || jSONArray.length() == 0)) {
            FeedbackInputActivity.a(this.f23141d.f23115a, false, false);
        } else {
            FeedbackInputActivity.a(this.f23141d.f23115a, true, false);
        }
        this.f23141d.f23115a.j.notifyDataSetChanged();
    }
}
