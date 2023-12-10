package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class thc {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public static final LinkedList<zic> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948182650, "Lcom/baidu/tieba/thc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948182650, "Lcom/baidu/tieba/thc;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        b = new LinkedList<>();
    }

    public thc() {
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

    public static void a(zic zicVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, zicVar) == null) {
            synchronized (thc.class) {
                if (b.size() == 0) {
                    c(zicVar);
                }
                if (!b.contains(zicVar)) {
                    b.add(zicVar);
                }
            }
        }
    }

    public static void c(zic zicVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zicVar) == null) && zicVar != null) {
            zicVar.S0(a.get());
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            TLog.h("PlayerGlobalOptions", " setAudioFocusEnable:" + z);
            a.set(z);
            kic.h(z);
            synchronized (thc.class) {
                if (b.size() > 0) {
                    Iterator<zic> it = b.iterator();
                    while (it.hasNext()) {
                        zic next = it.next();
                        if (next != null) {
                            next.S0(z);
                        }
                    }
                }
            }
        }
    }
}
