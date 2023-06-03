package com.baidu.tieba;

import android.os.Looper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class smb {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<smb> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final lmb a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948157633, "Lcom/baidu/tieba/smb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948157633, "Lcom/baidu/tieba/smb;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static smb a() {
        smb smbVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                smb smbVar2 = b.get();
                if (smbVar2 != null) {
                    return smbVar2;
                }
                smbVar = new smb();
            } while (!b.compareAndSet(null, smbVar));
            return smbVar;
        }
        return (smb) invokeV.objValue;
    }

    public static lmb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (lmb) invokeV.objValue;
    }

    public smb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lmb b2 = qmb.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new tmb(Looper.getMainLooper());
        }
    }
}
