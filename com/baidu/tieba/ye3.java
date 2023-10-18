package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public final class ye3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ye3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ik3<Exception>> a;
    public ArrayList<ik3<Exception>> b;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(ye3 ye3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p22.k("PresetSwanCoreUpdater", "onPresetCheck start.");
                xe3.s(this.a);
                p22.k("PresetSwanCoreUpdater", "onPresetCheck end.");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ye3 b;

        public b(ye3 ye3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ye3Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p22.k("PresetSwanCoreUpdater", "onPresetUpdate start.");
                ye3 ye3Var = this.b;
                int i = this.a;
                ye3Var.c(i, xe3.t(i));
                p22.k("PresetSwanCoreUpdater", "onPresetUpdate end.");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 a;
        public final /* synthetic */ Exception b;

        public c(ye3 ye3Var, ik3 ik3Var, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye3Var, ik3Var, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik3Var;
            this.b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948327234, "Lcom/baidu/tieba/ye3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948327234, "Lcom/baidu/tieba/ye3;");
                return;
            }
        }
        boolean z = am1.a;
    }

    public ye3() {
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
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
    }

    public static ye3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (ye3.class) {
                    if (c == null) {
                        c = new ye3();
                    }
                }
            }
            return c;
        }
        return (ye3) invokeV.objValue;
    }

    public final void c(int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, exc) == null) {
            synchronized (ye3.class) {
                try {
                    if (i == 0) {
                        Iterator<ik3<Exception>> it = this.a.iterator();
                        while (it.hasNext()) {
                            d(it.next(), exc);
                        }
                        this.a.clear();
                    } else if (i == 1) {
                        Iterator<ik3<Exception>> it2 = this.b.iterator();
                        while (it2.hasNext()) {
                            d(it2.next(), exc);
                        }
                        this.b.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void d(ik3<Exception> ik3Var, Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ik3Var, exc) == null) && ik3Var != null) {
            jj3.e0(new c(this, ik3Var, exc));
        }
    }

    public void e(ik3<Exception> ik3Var, int i) {
        ArrayList<ik3<Exception>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, ik3Var, i) == null) {
            p22.k("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
            synchronized (ye3.class) {
                boolean q = xe3.q(i);
                p22.k("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + q);
                if (!q && i == 0 && !xe3.r(i)) {
                    xe3.w(true, i);
                    new Thread(new a(this, i), "onPresetCheck").start();
                }
                if (!q) {
                    d(ik3Var, null);
                    return;
                }
                if (i == 1) {
                    arrayList = this.b;
                } else {
                    arrayList = this.a;
                }
                if (arrayList.isEmpty()) {
                    new Thread(new b(this, i), "updateSwanCoreAsync").start();
                }
                arrayList.add(ik3Var);
                p22.k("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (ye3.class) {
                c(i, xe3.t(i));
            }
        }
    }
}
