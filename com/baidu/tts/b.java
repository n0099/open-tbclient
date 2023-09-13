package com.baidu.tts;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechSynthesizer;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, SpeechSynthesizer> a;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1850147622, "Lcom/baidu/tts/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1850147622, "Lcom/baidu/tts/b$a;");
                    return;
                }
            }
            a = new b();
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (b) invokeV.objValue;
    }

    public String a(SpeechSynthesizer speechSynthesizer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, speechSynthesizer)) == null) {
            String str = UUID.randomUUID().toString().split("-")[0];
            if (!this.a.containsKey(str)) {
                this.a.put(str, speechSynthesizer);
                LoggerProxy.d("SynthesizerStats", "registerSynthesizer " + str + " , count " + this.a.size());
                return str;
            }
            return a(speechSynthesizer);
        }
        return (String) invokeL.objValue;
    }
}
