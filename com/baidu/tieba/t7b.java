package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b8b;
import com.baidu.tieba.u7b;
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
/* loaded from: classes8.dex */
public class t7b implements b8b.a {
    public static /* synthetic */ Interceptable $ic;
    public static t7b f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, b8b> a;
    public s7b b;
    public ExecutorService c;
    public z7b d;
    public Handler e;

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ t7b b;

        public a(t7b t7bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t7bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t7bVar;
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

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t7b a;

        public b(t7b t7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t7bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (b8b b8bVar : this.a.a.values()) {
                    if (b8bVar != null && b8bVar.isRunning()) {
                        b8bVar.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t7b a;

        public c(t7b t7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t7bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (b8b b8bVar : this.a.a.values()) {
                    if (b8bVar != null && b8bVar.isRunning()) {
                        b8bVar.cancel();
                    }
                }
            }
        }
    }

    public t7b() {
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
        i(new s7b());
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                b8b b8bVar = this.a.get(e);
                if (b8bVar != null) {
                    b8bVar.cancel();
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

    public final boolean j(String str) {
        InterceptResult invokeL;
        b8b b8bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.a.containsKey(str) && (b8bVar = this.a.get(str)) != null && b8bVar.isRunning()) {
                lab.d("DownloadInfo has been started!");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        b8b b8bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String e = e(str);
            if (this.a.containsKey(e) && (b8bVar = this.a.get(e)) != null) {
                return b8bVar.isRunning();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static t7b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (t7b.class) {
                    if (f == null) {
                        f = new t7b();
                    }
                }
            }
            return f;
        }
        return (t7b) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.post(new c(this));
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.post(new b(this));
        }
    }

    @Override // com.baidu.tieba.b8b.a
    public void a(String str, b8b b8bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, b8bVar) == null) {
            this.e.post(new a(this, str));
        }
    }

    public void f(u7b u7bVar, String str, w7b w7bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, u7bVar, str, w7bVar) == null) {
            String e = e(str);
            if (!j(e)) {
                h8b h8bVar = new h8b(u7bVar, new e8b(this.d, w7bVar), this.c, e, this.b, this);
                this.a.put(e, h8bVar);
                h8bVar.start();
            }
        }
    }

    public void g(String str, String str2, String str3, w7b w7bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, w7bVar) == null) {
            u7b.b bVar = new u7b.b();
            bVar.d(str);
            bVar.b(new File(str2));
            bVar.c(str3);
            f(bVar.a(), str, w7bVar);
        }
    }

    public final void i(@NonNull s7b s7bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, s7bVar) == null) {
            if (s7bVar.b() <= s7bVar.a()) {
                this.b = s7bVar;
                this.c = Executors.newFixedThreadPool(s7bVar.a());
                this.d = new f8b(this.e);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                b8b b8bVar = this.a.get(e);
                if (b8bVar != null && b8bVar.isRunning()) {
                    b8bVar.pause();
                }
                this.a.remove(e);
            }
        }
    }
}
