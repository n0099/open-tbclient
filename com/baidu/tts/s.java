package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.h1;
import java.net.URL;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class s implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ t a;

    public s(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.a.c;
            try {
                String host = new URL(((str == null || str.isEmpty()) ? "wss://tts.baidu.com/ws/sdktts" : "wss://tts.baidu.com/ws/sdktts").replace(SpeechSynthesizer.REQUEST_PROTOCOL_WS, "http")).getHost();
                h1 h1Var = h1.d.a;
                h1Var.a(host);
                h1Var.b(host);
            } catch (Exception e) {
                e.printStackTrace();
            }
            t tVar = this.a;
            tVar.a.postDelayed(tVar.b, TimeUnit.MINUTES.toMillis(4L));
        }
    }
}
