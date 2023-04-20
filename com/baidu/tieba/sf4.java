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
/* loaded from: classes6.dex */
public abstract class sf4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sf4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean a(ug4 ug4Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(ug4 ug4Var, List<vg4> list, sg4 sg4Var, qg4 qg4Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends tg4> boolean e(Class<T> cls, String str);

    public abstract boolean f(wg4 wg4Var);

    public abstract boolean g(List<wg4> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<vg4> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends tg4> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends tg4> T o(Class<T> cls, String str);

    public abstract Map<String, ug4> p();

    public abstract wg4 q(String str, long j, long j2);

    public abstract List<wg4> r(String str, String[] strArr);

    public abstract List<wg4> s(String str, long j, long j2);

    @Nullable
    public abstract xg4 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<wg4> w(String str);

    public abstract boolean x(wg4 wg4Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);

    public sf4() {
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

    public static sf4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (sf4.class) {
                    if (a == null) {
                        a = new tf4();
                    }
                }
            }
            return a;
        }
        return (sf4) invokeV.objValue;
    }
}
