package com.baidu.tieba;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class mn6 {
    public static /* synthetic */ Interceptable $ic;
    public static final mn6 a;
    public static final Pools.SimplePool<RectF> b;
    public static final Pools.SimplePool<PointF> c;
    public static final Pools.SimplePool<fl6> d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947978484, "Lcom/baidu/tieba/mn6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947978484, "Lcom/baidu/tieba/mn6;");
                return;
            }
        }
        a = new mn6();
        b = new Pools.SimplePool<>(200);
        c = new Pools.SimplePool<>(200);
        d = new Pools.SimplePool<>(1000);
    }

    public mn6() {
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

    public final PointF b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PointF acquire = c.acquire();
            if (acquire == null) {
                return new PointF();
            }
            return acquire;
        }
        return (PointF) invokeV.objValue;
    }

    public final RectF c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RectF acquire = b.acquire();
            if (acquire == null) {
                return new RectF();
            }
            return acquire;
        }
        return (RectF) invokeV.objValue;
    }

    public final fl6 a(gl6 data, DanmakuPlayer player) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, data, player)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(player, "player");
            fl6 acquire = d.acquire();
            if (acquire != null) {
                acquire.m(data);
                acquire.q(player.m().w());
            } else {
                acquire = null;
            }
            if (acquire == null) {
                return new fl6(data, player);
            }
            return acquire;
        }
        return (fl6) invokeLL.objValue;
    }
}
