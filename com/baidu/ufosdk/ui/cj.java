package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class cj implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ci f56867a;

    public cj(ci ciVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ciVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56867a = ciVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ci ciVar = this.f56867a;
            if (((Map) ciVar.f56866b.f56862a.f56766h.get(ciVar.f56865a)).containsKey("chatId")) {
                FeedbackInputActivity feedbackInputActivity = this.f56867a.f56866b.f56862a;
                StringBuilder sb = new StringBuilder();
                ci ciVar2 = this.f56867a;
                sb.append(((Map) ciVar2.f56866b.f56862a.f56766h.get(ciVar2.f56865a)).get("chatId"));
                feedbackInputActivity.f56764f = sb.toString();
            }
            com.baidu.ufosdk.e.a.a(this.f56867a.f56866b.f56862a.f56764f, 11);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("appid", UfoSDK.appid);
                hashMap.put("id", this.f56867a.f56866b.f56862a.f56763e);
                String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
                String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationToast", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                handler = this.f56867a.f56866b.f56862a.aK;
                handler.obtainMessage(7, a3).sendToTarget();
                context = this.f56867a.f56866b.f56863b;
                String str = UfoSDK.clientid;
                com.baidu.ufosdk.e.a.a(context, this.f56867a.f56866b.f56862a.f56763e, UfoSDK.appid);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
