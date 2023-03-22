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
public abstract class qf4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qf4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean a(sg4 sg4Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(sg4 sg4Var, List<tg4> list, qg4 qg4Var, og4 og4Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends rg4> boolean e(Class<T> cls, String str);

    public abstract boolean f(ug4 ug4Var);

    public abstract boolean g(List<ug4> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<tg4> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends rg4> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends rg4> T o(Class<T> cls, String str);

    public abstract Map<String, sg4> p();

    public abstract ug4 q(String str, long j, long j2);

    public abstract List<ug4> r(String str, String[] strArr);

    public abstract List<ug4> s(String str, long j, long j2);

    @Nullable
    public abstract vg4 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<ug4> w(String str);

    public abstract boolean x(ug4 ug4Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);

    public qf4() {
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

    public static qf4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (qf4.class) {
                    if (a == null) {
                        a = new rf4();
                    }
                }
            }
            return a;
        }
        return (qf4) invokeV.objValue;
    }
}
