package com.baidu.tun2tornadolite.booster;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.AndroidOperationInterface;
import com.baidu.tun2tornadolite.booster.data.SClientConfig;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.baidu.tun2tornadolite.booster.sclient.SClient;
import com.baidu.tun2tornadolite.booster.tun.Tun;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J&\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/Engine;", "", "()V", "ai", "Lcom/baidu/tun2tornadolite/AndroidOperationInterface;", "getAi", "()Lcom/baidu/tun2tornadolite/AndroidOperationInterface;", "setAi", "(Lcom/baidu/tun2tornadolite/AndroidOperationInterface;)V", "sClientConfig", "Lcom/baidu/tun2tornadolite/booster/data/SClientConfig;", "tunfd", "", "init", "", "prepare", "", "sClientList", "", "", "start", "region", "gameID", "gamePackageName", IntentConfig.STOP, "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class Engine {
    public static /* synthetic */ Interceptable $ic;
    public static final Engine INSTANCE;
    public static AndroidOperationInterface ai;
    public static SClientConfig sClientConfig;
    public static int tunfd;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(477059675, "Lcom/baidu/tun2tornadolite/booster/Engine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(477059675, "Lcom/baidu/tun2tornadolite/booster/Engine;");
                return;
            }
        }
        INSTANCE = new Engine();
        sClientConfig = new SClientConfig();
    }

    public Engine() {
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

    public final AndroidOperationInterface getAi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ai : (AndroidOperationInterface) invokeV.objValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TornadoLiteRuntime.INSTANCE.setStartTime$tun2tornadolite_release(0L);
        }
    }

    public final boolean prepare(List<String> sClientList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sClientList)) == null) {
            Intrinsics.checkNotNullParameter(sClientList, "sClientList");
            return ((Boolean) BuildersKt.runBlocking$default(null, new Engine$prepare$1(sClientList, null), 1, null)).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void setAi(AndroidOperationInterface androidOperationInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, androidOperationInterface) == null) {
            ai = androidOperationInterface;
        }
    }

    public final void start(int i, String region, String gameID, String gamePackageName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), region, gameID, gamePackageName}) == null) {
            Intrinsics.checkNotNullParameter(region, "region");
            Intrinsics.checkNotNullParameter(gameID, "gameID");
            Intrinsics.checkNotNullParameter(gamePackageName, "gamePackageName");
            BuildersKt.runBlocking$default(null, new Engine$start$1(this, i, region, gameID, gamePackageName, null), 1, null);
        }
    }

    public final void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TornadoLiteRuntime.INSTANCE.setStartTime$tun2tornadolite_release(0L);
            SClient.INSTANCE.stop();
            Tun.INSTANCE.stop();
        }
    }
}
