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
public abstract class v84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public v84() {
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

    public static v84 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (v84.class) {
                    if (a == null) {
                        a = new w84();
                    }
                }
            }
            return a;
        }
        return (v84) invokeV.objValue;
    }

    public abstract boolean a(x94 x94Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(x94 x94Var, List<y94> list, v94 v94Var, t94 t94Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends w94> boolean e(Class<T> cls, String str);

    public abstract boolean f(z94 z94Var);

    public abstract boolean g(List<z94> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<y94> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends w94> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends w94> T o(Class<T> cls, String str);

    public abstract Map<String, x94> p();

    public abstract z94 q(String str, long j, long j2);

    public abstract List<z94> r(String str, String[] strArr);

    public abstract List<z94> s(String str, long j, long j2);

    @Nullable
    public abstract aa4 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<z94> w(String str);

    public abstract boolean x(z94 z94Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);
}
