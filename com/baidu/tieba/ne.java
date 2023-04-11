package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fe;
import com.baidu.tieba.me;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ne<T> implements me.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final le<T> b;
    public final String c;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ me.a b;
        public final /* synthetic */ ne c;

        public a(ne neVar, String str, me.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = neVar;
            this.a = str;
            this.b = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.me$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a(this.a, this.c.get(this.a));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ long c;
        public final /* synthetic */ ne d;

        public b(ne neVar, String str, Object obj, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neVar, str, obj, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = neVar;
            this.a = str;
            this.b = obj;
            this.c = j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.ne */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.e(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ne b;

        public c(ne neVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = neVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.remove(this.a);
            }
        }
    }

    public ne(String str, le<T> leVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, leVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = str;
        this.b = leVar;
    }

    @Override // com.baidu.tieba.me
    public void a(String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, t) == null) {
            i(str, t, 315532800000L);
        }
    }

    @Override // com.baidu.tieba.me
    public void f(String str, me.a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, aVar) == null) {
            mg.a().b(new a(this, str, aVar));
        }
    }

    @Override // com.baidu.tieba.me
    public void g(String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, t) == null) {
            e(str, t, 315532800000L);
        }
    }

    @Override // com.baidu.tieba.me.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.g(this.c);
            l();
        }
    }

    @Override // com.baidu.tieba.me.c
    public le<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (le) invokeV.objValue;
    }

    @Override // com.baidu.tieba.me.c
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.b(this.c);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            fe c2 = c().c();
            if (c2 instanceof fe.b) {
                ((fe.b) c2).release();
            }
        }
    }

    @Override // com.baidu.tieba.me
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            mg.a().b(new c(this, str));
        }
    }

    @Override // com.baidu.tieba.me
    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.b.d(this.c, str);
        }
    }

    @Override // com.baidu.tieba.me
    public void e(String str, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, t, Long.valueOf(j)}) == null) {
            if (str != null) {
                if (j <= 315532800000L) {
                    j += System.currentTimeMillis();
                }
                long j2 = j;
                if (j2 <= System.currentTimeMillis()) {
                    remove(str);
                    return;
                } else {
                    this.b.f(this.c, str, t, j2);
                    return;
                }
            }
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
    }

    @Override // com.baidu.tieba.me
    public T get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (BdBaseApplication.getInst().isDebugMode() && ii.E()) {
                if (!this.a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            return this.b.a(this.c, str);
        }
        return (T) invokeL.objValue;
    }

    @Override // com.baidu.tieba.me
    public me.b<T> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (BdBaseApplication.getInst().isDebugMode() && ii.E()) {
                if (!this.a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            return this.b.e(this.c, str);
        }
        return (me.b) invokeL.objValue;
    }

    @Override // com.baidu.tieba.me
    public void i(String str, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, t, Long.valueOf(j)}) == null) {
            mg.a().b(new b(this, str, t, j));
        }
    }
}
