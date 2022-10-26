package com.baidu.yunjiasu.tornadosdk.backend;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yunjiasu.tornadosdk.Tornado;
import com.google.gson.Gson;
import com.heytap.mcssdk.mode.CommandMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/backend/Backend;", "", "()V", "CONFIG_BASE_PROD_URL", "", "CONFIG_BASE_TEST_URL", "channel", "clientVersion", "cuid", Config.DEVICE_PART, "gson", "Lcom/google/gson/Gson;", CommandMessage.SDK_VERSION, "token", "create", "", "getSClientConfig", "Lcom/baidu/yunjiasu/tornadosdk/backend/SClientConfig;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUrl", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class Backend {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONFIG_BASE_PROD_URL = "https://api-gt.baidu.com";
    public static final String CONFIG_BASE_TEST_URL = "https://apitest-gt.baidu.com";
    public static final Backend INSTANCE;
    public static String channel;
    public static String clientVersion;
    public static String cuid;
    public static String device;
    public static Gson gson;
    public static String sdkVersion;
    public static String token;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1338270659, "Lcom/baidu/yunjiasu/tornadosdk/backend/Backend;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1338270659, "Lcom/baidu/yunjiasu/tornadosdk/backend/Backend;");
                return;
            }
        }
        INSTANCE = new Backend();
        gson = new Gson();
    }

    public Backend() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (Tornado.INSTANCE.getDebug$tornadosdk_release()) {
                return CONFIG_BASE_TEST_URL;
            }
            return CONFIG_BASE_PROD_URL;
        }
        return (String) invokeV.objValue;
    }

    public final Object getSClientConfig(Continuation<? super SClientConfig> continuation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, continuation)) == null) {
            return BuildersKt.withContext(Dispatchers.getIO(), new Backend$getSClientConfig$2(null), continuation);
        }
        return invokeL.objValue;
    }

    public final void create(String channel2, String device2, String cuid2, String token2, String clientVersion2, String sdkVersion2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{channel2, device2, cuid2, token2, clientVersion2, sdkVersion2}) == null) {
            Intrinsics.checkNotNullParameter(channel2, "channel");
            Intrinsics.checkNotNullParameter(device2, "device");
            Intrinsics.checkNotNullParameter(cuid2, "cuid");
            Intrinsics.checkNotNullParameter(token2, "token");
            Intrinsics.checkNotNullParameter(clientVersion2, "clientVersion");
            Intrinsics.checkNotNullParameter(sdkVersion2, "sdkVersion");
            channel = channel2;
            device = device2;
            cuid = cuid2;
            token = token2;
            clientVersion = clientVersion2;
            sdkVersion = sdkVersion2;
        }
    }
}
