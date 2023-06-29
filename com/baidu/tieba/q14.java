package com.baidu.tieba;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes7.dex */
public final class q14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d a;
    public static final ltb b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface c extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    /* loaded from: classes7.dex */
    public static class a implements ltb<Pair<Runnable, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ltb
        public void call(Pair<Runnable, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                String name = Thread.currentThread().getName();
                Thread currentThread = Thread.currentThread();
                currentThread.setName(name + "-" + ((String) pair.second));
                try {
                    ((Runnable) pair.first).run();
                } catch (Throwable unused) {
                }
                Thread.currentThread().setName(name);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements ptb<Pair<Runnable, String>, xsb<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ptb
        public xsb<?> call(Pair<Runnable, String> pair) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pair)) == null) {
                return btb.g(pair).h(Schedulers.io()).f(q14.b).l();
            }
            return (xsb) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends uxb<Pair<Runnable, String>, Pair<Runnable, String>> implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(vxb vxbVar) {
            super(vxbVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vxbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((vxb) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                execute(runnable, "");
            }
        }

        @Override // com.baidu.tieba.q14.c
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, str) == null) {
                onNext(Pair.create(runnable, q14.c(str)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948038965, "Lcom/baidu/tieba/q14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948038965, "Lcom/baidu/tieba/q14;");
                return;
            }
        }
        b = new a();
    }

    public q14() {
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

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (q14.class) {
                    if (a == null) {
                        a = new d(PublishSubject.O());
                        a.v().l(new b()).B().C();
                    }
                }
            }
            return a;
        }
        return (c) invokeV.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null) {
                if (!str.startsWith("SwanAppExecutorUtils_")) {
                    str = "SwanAppExecutorUtils_" + str;
                }
            } else {
                str = null;
            }
            if (str == null) {
                str = "SwanAppExecutorUtils";
            }
            if (str.length() > 256) {
                return str.substring(0, 255);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void d(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, runnable, str) == null) {
            b().execute(runnable, str);
        }
    }
}
