package com.baidu.tieba.sdkcode.tts;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ze;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/tieba/sdkcode/tts/TtsLog;", "", "()V", "logI", "", WebChromeClient.KEY_ARG_ARRAY, "", "([Ljava/lang/Object;)V", "SdkCodeInterface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TtsLog {
    public static /* synthetic */ Interceptable $ic;
    public static final TtsLog INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1390937176, "Lcom/baidu/tieba/sdkcode/tts/TtsLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1390937176, "Lcom/baidu/tieba/sdkcode/tts/TtsLog;");
                return;
            }
        }
        INSTANCE = new TtsLog();
    }

    public TtsLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void logI(Object... args) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, args) == null) {
            Intrinsics.checkNotNullParameter(args, "args");
            try {
                ze.a.a().i("Tts", DataExt.toJson(args));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
