package com.baidu.ufosdk.ui;

import android.text.TextUtils;
import android.view.View;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class cx implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22831a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONArray f22832b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22833c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ cg f22834d;

    public cx(cg cgVar, String str, JSONArray jSONArray, int i) {
        this.f22834d = cgVar;
        this.f22831a = str;
        this.f22832b = jSONArray;
        this.f22833c = i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0066: INVOKE  (r1v6 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.Map : 0x0064: CHECK_CAST (r3v4 java.util.Map A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x0060: INVOKE  (r3v3 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.List : 0x005c: IGET  (r3v2 java.util.List A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.FeedbackInputActivity : 0x005a: IGET  (r3v1 com.baidu.ufosdk.ui.FeedbackInputActivity A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.cg : 0x0058: IGET  (r3v0 com.baidu.ufosdk.ui.cg A[REMOVE]) = (r5v0 'this' com.baidu.ufosdk.ui.cx A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.cx.d com.baidu.ufosdk.ui.cg)
     com.baidu.ufosdk.ui.cg.a com.baidu.ufosdk.ui.FeedbackInputActivity)
     com.baidu.ufosdk.ui.FeedbackInputActivity.h java.util.List)
      (wrap: int : 0x005e: IGET  (r4v0 int A[REMOVE]) = (r5v0 'this' com.baidu.ufosdk.ui.cx A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.cx.c int)
     type: INTERFACE call: java.util.List.get(int):java.lang.Object))
      ("chatId")
     type: INTERFACE call: java.util.Map.get(java.lang.Object):java.lang.Object)] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        com.baidu.ufosdk.f.c.a("点击查看不满意原因");
        if (!TextUtils.isEmpty(this.f22831a) || ((jSONArray2 = this.f22832b) != null && jSONArray2.length() != 0)) {
            ((Map) this.f22834d.f22808a.f22715h.get(this.f22833c)).put("isClicked", 1);
        }
        this.f22834d.f22808a.aF = this.f22833c;
        if (((Map) this.f22834d.f22808a.f22715h.get(this.f22833c)).containsKey("chatId")) {
            FeedbackInputActivity feedbackInputActivity = this.f22834d.f22808a;
            StringBuilder sb = new StringBuilder();
            sb.append(((Map) this.f22834d.f22808a.f22715h.get(this.f22833c)).get("chatId"));
            feedbackInputActivity.f22713f = sb.toString();
        }
        if (TextUtils.isEmpty(this.f22831a) && ((jSONArray = this.f22832b) == null || jSONArray.length() == 0)) {
            FeedbackInputActivity.a(this.f22834d.f22808a, false, false);
        } else {
            FeedbackInputActivity.a(this.f22834d.f22808a, true, false);
        }
        this.f22834d.f22808a.j.notifyDataSetChanged();
    }
}
