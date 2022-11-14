package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c10;
import com.baidu.tieba.y00;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class x00 implements c10.a {
    public static /* synthetic */ Interceptable $ic;
    public static x00 f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, c10> a;
    public q b;
    public ExecutorService c;
    public b10 d;
    public Handler e;

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ x00 b;

        public a(x00 x00Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x00Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x00Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.containsKey(this.a)) {
                this.b.a.remove(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x00 a;

        public b(x00 x00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x00Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (c10 c10Var : this.a.a.values()) {
                    if (c10Var != null && c10Var.isRunning()) {
                        c10Var.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x00 a;

        public c(x00 x00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x00Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (c10 c10Var : this.a.a.values()) {
                    if (c10Var != null && c10Var.isRunning()) {
                        c10Var.cancel();
                    }
                }
            }
        }
    }

    public x00() {
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
        this.e = new Handler(Looper.getMainLooper());
        this.a = new LinkedHashMap();
        j(new q());
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                c10 c10Var = this.a.get(e);
                if (c10Var != null) {
                    c10Var.cancel();
                }
                this.a.remove(e);
            }
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null) {
                return String.valueOf(str.hashCode());
            }
            throw new IllegalArgumentException("Tag can't be null!");
        }
        return (String) invokeL.objValue;
    }

    public final void j(@NonNull q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qVar) == null) {
            int i = qVar.b;
            int i2 = qVar.a;
            if (i <= i2) {
                this.b = qVar;
                this.c = Executors.newFixedThreadPool(i2);
                this.d = new o(this.e);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        c10 c10Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String e = e(str);
            if (this.a.containsKey(e) && (c10Var = this.a.get(e)) != null) {
                return c10Var.isRunning();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static x00 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (x00.class) {
                    if (f == null) {
                        f = new x00();
                    }
                }
            }
            return f;
        }
        return (x00) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.post(new c(this));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.post(new b(this));
        }
    }

    @Override // com.baidu.tieba.c10.a
    public void a(String str, c10 c10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, c10Var) == null) {
            this.e.post(new a(this, str));
        }
    }

    public void f(y00 y00Var, String str, z00 z00Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, y00Var, str, z00Var) == null) {
            String e = e(str);
            if (!k(e)) {
                n nVar = new n(y00Var, new h(this.d, z00Var), this.c, e, this.b, this);
                this.a.put(e, nVar);
                nVar.start();
            }
        }
    }

    public final void g(y00 y00Var, String str, z00 z00Var, b10 b10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, y00Var, str, z00Var, b10Var) == null) {
            Log.d("RtcDownSo", "start down judge is downloading");
            String e = e(str);
            if (!k(e)) {
                Log.d("RtcDownSo", "real start down ...");
                n nVar = new n(y00Var, new h(b10Var, z00Var), this.c, e, this.b, this);
                this.a.put(e, nVar);
                nVar.start();
            }
        }
    }

    public void h(String str, String str2, String str3, Looper looper, z00 z00Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, str3, looper, z00Var) == null) {
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            y00.a aVar = new y00.a();
            aVar.d(str);
            aVar.b(new File(str2));
            aVar.c(str3);
            g(aVar.a(), str, z00Var, new o(new Handler(looper)));
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        c10 c10Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (this.a.containsKey(str) && (c10Var = this.a.get(str)) != null) {
                if (c10Var.isRunning()) {
                    f10.c("DownloadInfo has been started!");
                    return true;
                }
                f10.c("DownloadInfo not started!");
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                c10 c10Var = this.a.get(e);
                if (c10Var != null && c10Var.isRunning()) {
                    c10Var.pause();
                }
                this.a.remove(e);
            }
        }
    }
}
