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
public abstract class md4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile md4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean a(oe4 oe4Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(oe4 oe4Var, List<pe4> list, me4 me4Var, ke4 ke4Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends ne4> boolean e(Class<T> cls, String str);

    public abstract boolean f(qe4 qe4Var);

    public abstract boolean g(List<qe4> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<pe4> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends ne4> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends ne4> T o(Class<T> cls, String str);

    public abstract Map<String, oe4> p();

    public abstract qe4 q(String str, long j, long j2);

    public abstract List<qe4> r(String str, String[] strArr);

    public abstract List<qe4> s(String str, long j, long j2);

    @Nullable
    public abstract re4 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<qe4> w(String str);

    public abstract boolean x(qe4 qe4Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);

    public md4() {
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

    public static md4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (md4.class) {
                    if (a == null) {
                        a = new nd4();
                    }
                }
            }
            return a;
        }
        return (md4) invokeV.objValue;
    }
}
