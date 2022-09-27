package com.baidu.tieba;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class iw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<?> a;
        public final Object b;
        public final Class<?> c;
        public final Method d;
        public final Object e;
        public final Method f;
        public final c g;
        public final int h;
        public final lw4 i;
        public int j;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.i.a(this.a.f());
                    this.a.g.c();
                    this.a.g();
                }
            }
        }

        public /* synthetic */ b(int i, lw4 lw4Var, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lw4Var);
        }

        public final List<Long> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(24);
                List<Long> h = h();
                int size = h.size();
                int i = 0;
                while (i < size - 1) {
                    long longValue = h.get(i).longValue();
                    i++;
                    arrayList.add(Long.valueOf(h.get(i).longValue() - longValue));
                }
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.g.c();
            }
        }

        public final List<Long> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g.a : (List) invokeV.objValue;
        }

        public final void i() throws InvocationTargetException, IllegalAccessException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f.invoke(this.e, this.b);
            }
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i = this.j;
                if (i >= this.h) {
                    gh.a().post(new a(this));
                    return;
                }
                this.j = i + 1;
                try {
                    i();
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }

        public b(int i, lw4 lw4Var) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), lw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = 0;
            this.c = Class.forName("android.view.Choreographer");
            this.a = Class.forName("android.view.Choreographer$FrameCallback");
            this.g = new c(this);
            this.b = Proxy.newProxyInstance(this.a.getClassLoader(), new Class[]{this.a}, this.g);
            Method method = this.c.getMethod("getInstance", new Class[0]);
            this.d = method;
            this.e = method.invoke(null, new Object[0]);
            this.f = this.c.getMethod("postFrameCallback", this.a);
            this.h = i <= 0 ? 16 : i;
            this.i = lw4Var;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<Long> a;
        public final List<Integer> b;
        public b c;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bVar;
            this.a = new ArrayList(240);
            this.b = new ArrayList(15);
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c = null;
                this.a.clear();
                this.b.clear();
            }
        }

        public final void d(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a.add(Long.valueOf(j));
                this.c.j();
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, method, objArr)) == null) {
                String name = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                if ("doFrame".equals(name) && parameterTypes.length == 1 && parameterTypes[0] == Long.TYPE) {
                    d(((Long) objArr[0]).longValue());
                    return null;
                }
                return null;
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final iw4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-704701373, "Lcom/baidu/tieba/iw4$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-704701373, "Lcom/baidu/tieba/iw4$d;");
                    return;
                }
            }
            a = new iw4();
        }
    }

    public iw4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public static iw4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d.a : (iw4) invokeV.objValue;
    }

    public void b(int i, lw4 lw4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, lw4Var) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            b bVar = new b(i, lw4Var, null);
            this.a = bVar;
            bVar.j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
