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
/* loaded from: classes7.dex */
public final class mk3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mk3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<wp3<Exception>> a;
    public ArrayList<wp3<Exception>> b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(mk3 mk3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk3Var, Integer.valueOf(i)};
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
                d82.k("PresetSwanCoreUpdater", "onPresetCheck start.");
                lk3.s(this.a);
                d82.k("PresetSwanCoreUpdater", "onPresetCheck end.");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ mk3 b;

        public b(mk3 mk3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mk3Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d82.k("PresetSwanCoreUpdater", "onPresetUpdate start.");
                mk3 mk3Var = this.b;
                int i = this.a;
                mk3Var.c(i, lk3.t(i));
                d82.k("PresetSwanCoreUpdater", "onPresetUpdate end.");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp3 a;
        public final /* synthetic */ Exception b;

        public c(mk3 mk3Var, wp3 wp3Var, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk3Var, wp3Var, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp3Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947975508, "Lcom/baidu/tieba/mk3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947975508, "Lcom/baidu/tieba/mk3;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    public mk3() {
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

    public static mk3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (mk3.class) {
                    if (c == null) {
                        c = new mk3();
                    }
                }
            }
            return c;
        }
        return (mk3) invokeV.objValue;
    }

    public final void c(int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, exc) == null) {
            synchronized (mk3.class) {
                try {
                    if (i == 0) {
                        Iterator<wp3<Exception>> it = this.a.iterator();
                        while (it.hasNext()) {
                            d(it.next(), exc);
                        }
                        this.a.clear();
                    } else if (i == 1) {
                        Iterator<wp3<Exception>> it2 = this.b.iterator();
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

    public final void d(wp3<Exception> wp3Var, Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wp3Var, exc) == null) && wp3Var != null) {
            xo3.e0(new c(this, wp3Var, exc));
        }
    }

    public void e(wp3<Exception> wp3Var, int i) {
        ArrayList<wp3<Exception>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, wp3Var, i) == null) {
            d82.k("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
            synchronized (mk3.class) {
                boolean q = lk3.q(i);
                d82.k("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + q);
                if (!q && i == 0 && !lk3.r(i)) {
                    lk3.w(true, i);
                    new Thread(new a(this, i), "onPresetCheck").start();
                }
                if (!q) {
                    d(wp3Var, null);
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
                arrayList.add(wp3Var);
                d82.k("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (mk3.class) {
                c(i, lk3.t(i));
            }
        }
    }
}
