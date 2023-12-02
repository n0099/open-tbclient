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
public class shc {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public static final LinkedList<yic> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948152859, "Lcom/baidu/tieba/shc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948152859, "Lcom/baidu/tieba/shc;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        b = new LinkedList<>();
    }

    public shc() {
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

    public static void a(yic yicVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, yicVar) == null) {
            synchronized (shc.class) {
                if (b.size() == 0) {
                    c(yicVar);
                }
                if (!b.contains(yicVar)) {
                    b.add(yicVar);
                }
            }
        }
    }

    public static void c(yic yicVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yicVar) == null) && yicVar != null) {
            yicVar.S0(a.get());
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            TLog.h("PlayerGlobalOptions", " setAudioFocusEnable:" + z);
            a.set(z);
            jic.h(z);
            synchronized (shc.class) {
                if (b.size() > 0) {
                    Iterator<yic> it = b.iterator();
                    while (it.hasNext()) {
                        yic next = it.next();
                        if (next != null) {
                            next.S0(z);
                        }
                    }
                }
            }
        }
    }
}
