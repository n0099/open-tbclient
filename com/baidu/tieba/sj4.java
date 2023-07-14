package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class sj4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sj4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean a(uk4 uk4Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(uk4 uk4Var, List<vk4> list, sk4 sk4Var, qk4 qk4Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends tk4> boolean e(Class<T> cls, String str);

    public abstract boolean f(wk4 wk4Var);

    public abstract boolean g(List<wk4> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<vk4> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends tk4> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends tk4> T o(Class<T> cls, String str);

    public abstract Map<String, uk4> p();

    public abstract wk4 q(String str, long j, long j2);

    public abstract List<wk4> r(String str, String[] strArr);

    public abstract List<wk4> s(String str, long j, long j2);

    @Nullable
    public abstract xk4 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<wk4> w(String str);

    public abstract boolean x(wk4 wk4Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);

    public sj4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static sj4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (sj4.class) {
                    if (a == null) {
                        a = new tj4();
                    }
                }
            }
            return a;
        }
        return (sj4) invokeV.objValue;
    }
}
