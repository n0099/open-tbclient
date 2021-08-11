package com.baidu.ufosdk.ui;

import android.text.TextUtils;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public final class cx implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f59420a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONArray f59421b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f59422c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ cg f59423d;

    public cx(cg cgVar, String str, JSONArray jSONArray, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cgVar, str, jSONArray, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59423d = cgVar;
        this.f59420a = str;
        this.f59421b = jSONArray;
        this.f59422c = i2;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0069: INVOKE  (r1v6 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.Map : 0x0067: CHECK_CAST (r3v5 java.util.Map A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x0063: INVOKE  (r3v4 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.List : 0x005f: IGET  (r3v3 java.util.List A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.FeedbackInputActivity : 0x005d: IGET  (r3v2 com.baidu.ufosdk.ui.FeedbackInputActivity A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.cg : 0x005b: IGET  (r3v1 com.baidu.ufosdk.ui.cg A[REMOVE]) = (r5v0 'this' com.baidu.ufosdk.ui.cx A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.cx.d com.baidu.ufosdk.ui.cg)
     com.baidu.ufosdk.ui.cg.a com.baidu.ufosdk.ui.FeedbackInputActivity)
     com.baidu.ufosdk.ui.FeedbackInputActivity.h java.util.List)
      (wrap: int : 0x0061: IGET  (r4v1 int A[REMOVE]) = (r5v0 'this' com.baidu.ufosdk.ui.cx A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.cx.c int)
     type: INTERFACE call: java.util.List.get(int):java.lang.Object))
      ("chatId")
     type: INTERFACE call: java.util.Map.get(java.lang.Object):java.lang.Object)] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            com.baidu.ufosdk.f.c.a("点击查看不满意原因");
            if (!TextUtils.isEmpty(this.f59420a) || ((jSONArray2 = this.f59421b) != null && jSONArray2.length() != 0)) {
                ((Map) this.f59423d.f59397a.f59298h.get(this.f59422c)).put("isClicked", 1);
            }
            this.f59423d.f59397a.aF = this.f59422c;
            if (((Map) this.f59423d.f59397a.f59298h.get(this.f59422c)).containsKey("chatId")) {
                FeedbackInputActivity feedbackInputActivity = this.f59423d.f59397a;
                StringBuilder sb = new StringBuilder();
                sb.append(((Map) this.f59423d.f59397a.f59298h.get(this.f59422c)).get("chatId"));
                feedbackInputActivity.f59296f = sb.toString();
            }
            if (TextUtils.isEmpty(this.f59420a) && ((jSONArray = this.f59421b) == null || jSONArray.length() == 0)) {
                FeedbackInputActivity.a(this.f59423d.f59397a, false, false);
            } else {
                FeedbackInputActivity.a(this.f59423d.f59397a, true, false);
            }
            this.f59423d.f59397a.f59300j.notifyDataSetChanged();
        }
    }
}
