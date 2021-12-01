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
/* loaded from: classes11.dex */
public final class cj implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ci a;

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
        this.a = ciVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ci ciVar = this.a;
            if (((Map) ciVar.f51650b.a.f51610h.get(ciVar.a)).containsKey("chatId")) {
                FeedbackInputActivity feedbackInputActivity = this.a.f51650b.a;
                StringBuilder sb = new StringBuilder();
                ci ciVar2 = this.a;
                sb.append(((Map) ciVar2.f51650b.a.f51610h.get(ciVar2.a)).get("chatId"));
                feedbackInputActivity.f51608f = sb.toString();
            }
            com.baidu.ufosdk.e.a.a(this.a.f51650b.a.f51608f, 11);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("appid", UfoSDK.appid);
                hashMap.put("id", this.a.f51650b.a.f51607e);
                String a = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
                String a2 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationToast", "sdk_encrypt=" + URLEncoder.encode(a, "UTF-8"));
                handler = this.a.f51650b.a.aK;
                handler.obtainMessage(7, a2).sendToTarget();
                context = this.a.f51650b.f51649b;
                String str = UfoSDK.clientid;
                com.baidu.ufosdk.e.a.a(context, this.a.f51650b.a.f51607e, UfoSDK.appid);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
