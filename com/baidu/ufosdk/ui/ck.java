package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes13.dex */
public final class ck implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f52200b;

    public ck(cg cgVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cgVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52200b = cgVar;
        this.a = i2;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0057: INVOKE  (r0v10 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.Map : 0x0055: CHECK_CAST (r2v5 java.util.Map A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x0051: INVOKE  (r2v4 java.lang.Object A[REMOVE]) = 
      (wrap: java.util.List : 0x004d: IGET  (r2v3 java.util.List A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.FeedbackInputActivity : 0x004b: IGET  (r2v2 com.baidu.ufosdk.ui.FeedbackInputActivity A[REMOVE]) = 
      (wrap: com.baidu.ufosdk.ui.cg : 0x0049: IGET  (r2v1 com.baidu.ufosdk.ui.cg A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.ck A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.ck.b com.baidu.ufosdk.ui.cg)
     com.baidu.ufosdk.ui.cg.a com.baidu.ufosdk.ui.FeedbackInputActivity)
     com.baidu.ufosdk.ui.FeedbackInputActivity.h java.util.List)
      (wrap: int : 0x004f: IGET  (r3v1 int A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.ck A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.ck.a int)
     type: INTERFACE call: java.util.List.get(int):java.lang.Object))
      ("chatId")
     type: INTERFACE call: java.util.Map.get(java.lang.Object):java.lang.Object)] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f52200b.a.aF = this.a;
            com.baidu.ufosdk.f.c.a("点击未解决！！！");
            ((Map) this.f52200b.a.f52159h.get(this.a)).put("ask", 3);
            if (((Map) this.f52200b.a.f52159h.get(this.a)).containsKey("chatId")) {
                FeedbackInputActivity feedbackInputActivity = this.f52200b.a;
                StringBuilder sb = new StringBuilder();
                sb.append(((Map) this.f52200b.a.f52159h.get(this.a)).get("chatId"));
                feedbackInputActivity.f52157f = sb.toString();
            }
            this.f52200b.a.l.execute(new cl(this));
            FeedbackInputActivity.a(this.f52200b.a, false, true);
        }
    }
}
