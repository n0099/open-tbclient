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
/* loaded from: classes6.dex */
public class jvb {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public static final LinkedList<pwb> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947898163, "Lcom/baidu/tieba/jvb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947898163, "Lcom/baidu/tieba/jvb;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        b = new LinkedList<>();
    }

    public jvb() {
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

    public static void a(pwb pwbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pwbVar) == null) {
            synchronized (jvb.class) {
                if (b.size() == 0) {
                    c(pwbVar);
                }
                if (!b.contains(pwbVar)) {
                    b.add(pwbVar);
                }
            }
        }
    }

    public static void c(pwb pwbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pwbVar) == null) && pwbVar != null) {
            pwbVar.S0(a.get());
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            TLog.h("PlayerGlobalOptions", " setAudioFocusEnable:" + z);
            a.set(z);
            awb.h(z);
            synchronized (jvb.class) {
                if (b.size() > 0) {
                    Iterator<pwb> it = b.iterator();
                    while (it.hasNext()) {
                        pwb next = it.next();
                        if (next != null) {
                            next.S0(z);
                        }
                    }
                }
            }
        }
    }
}
