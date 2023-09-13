package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ul2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile ul2 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements aq3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq3 a;
        public final /* synthetic */ int b;

        /* renamed from: com.baidu.tieba.ul2$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0495a implements aq3<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0495a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                    h82.l("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                    aq3 aq3Var = this.a.a;
                    if (aq3Var != null) {
                        aq3Var.a(exc);
                    }
                }
            }
        }

        public a(ul2 ul2Var, aq3 aq3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var, aq3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq3Var;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (exc == null) {
                    h82.k("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                    aq3 aq3Var = this.a;
                    if (aq3Var != null) {
                        aq3Var.a(null);
                        return;
                    }
                    return;
                }
                h82.k("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
                mk3.o(this.b, new C0495a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements aq3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq3 a;
        public final /* synthetic */ int b;

        /* loaded from: classes8.dex */
        public class a implements aq3<Exception> {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(Exception exc) {
                aq3 aq3Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) && (aq3Var = this.a.a) != null) {
                    aq3Var.a(exc);
                }
            }
        }

        public b(ul2 ul2Var, aq3 aq3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var, aq3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq3Var;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (exc != null) {
                    aq3 aq3Var = this.a;
                    if (aq3Var != null) {
                        aq3Var.a(exc);
                        return;
                    }
                    return;
                }
                ql2.h(this.b, new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ul2 a;

        public c(ul2 ul2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ul2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948214766, "Lcom/baidu/tieba/ul2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948214766, "Lcom/baidu/tieba/ul2;");
                return;
            }
        }
        a = rr1.a;
    }

    public ul2() {
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

    public static ul2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                synchronized (ul2.class) {
                    if (b == null) {
                        b = new ul2();
                    }
                }
            }
            return b;
        }
        return (ul2) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            qk3.b().e(null, 0);
            qk3.b().e(null, 1);
            ql2.h(0, null);
            ql2.h(1, null);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this), "tryUpdateAllPresetCoresAsync", 2);
        }
    }

    public void c(@Nullable aq3<Exception> aq3Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aq3Var, i) == null) {
            h82.k("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i);
            g(new a(this, aq3Var, i), i);
        }
    }

    public final void g(@Nullable aq3<Exception> aq3Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, aq3Var, i) == null) {
            qk3.b().e(new b(this, aq3Var, i), i);
        }
    }

    public void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            if (a) {
                Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
            }
            mk3.l(i, i2);
            ql2.g(i, i2);
        }
    }
}
