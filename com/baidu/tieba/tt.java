package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class tt<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public wt<vt<T>, tt<T>.c> b;
    public int c;
    public volatile Object d;
    public volatile Object e;
    public int f;
    public boolean g;
    public boolean h;
    public final Runnable i;

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt a;

        public a(tt ttVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ttVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ttVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.tt */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.a.a) {
                obj = this.a.e;
                this.a.e = tt.j;
            }
            this.a.p(obj);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends tt<T>.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.tt.c
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tt ttVar, vt<T> vtVar) {
            super(ttVar, vtVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ttVar, vtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((tt) objArr2[0], (vt) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final vt<T> a;
        public boolean b;
        public int c;
        public final /* synthetic */ tt d;

        public abstract boolean b();

        public c(tt ttVar, vt<T> vtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ttVar, vtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ttVar;
            this.c = -1;
            this.a = vtVar;
        }

        public void a(boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || z == this.b) {
                return;
            }
            this.b = z;
            int i = 1;
            if (this.d.c == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            tt ttVar = this.d;
            int i2 = ttVar.c;
            if (!this.b) {
                i = -1;
            }
            ttVar.c = i2 + i;
            if (z2 && this.b) {
                this.d.m();
            }
            if (this.d.c == 0 && !this.b) {
                this.d.n();
            }
            if (!this.b) {
                return;
            }
            this.d.j(this);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448318253, "Lcom/baidu/tieba/tt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448318253, "Lcom/baidu/tieba/tt;");
                return;
            }
        }
        j = new Object();
    }

    public T k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            T t = (T) this.d;
            if (t != j) {
                return t;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    public tt() {
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
        this.a = new Object();
        this.b = new wt<>();
        this.c = 0;
        this.d = j;
        this.e = j;
        this.f = -1;
        this.i = new a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.baidu.tieba.vt<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void i(tt<T>.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, cVar) != null) || !cVar.b) {
            return;
        }
        if (!cVar.b()) {
            cVar.a(false);
            return;
        }
        int i = cVar.c;
        int i2 = this.f;
        if (i >= i2) {
            return;
        }
        cVar.c = i2;
        cVar.a.onChanged(this.d);
    }

    public void l(vt<T> vtVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vtVar) == null) {
            b bVar = new b(this, vtVar);
            if (this.b.d(vtVar, bVar) != null) {
                return;
            }
            bVar.a(true);
        }
    }

    public void o(T t) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            synchronized (this.a) {
                if (this.e == j) {
                    z = true;
                } else {
                    z = false;
                }
                this.e = t;
            }
            if (!z) {
                return;
            }
            eu.c(this.i);
        }
    }

    public void p(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
            h("setValue");
            this.f++;
            this.d = t;
            j(null);
        }
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, str) != null) || eu.b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public final void j(tt<T>.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (this.g) {
                this.h = true;
                return;
            }
            this.g = true;
            do {
                this.h = false;
                if (cVar != null) {
                    i(cVar);
                    cVar = null;
                } else {
                    wt<vt<T>, tt<T>.c>.d f = this.b.f();
                    while (f.hasNext()) {
                        i((c) ((Map.Entry) f.next()).getValue());
                        if (this.h) {
                            break;
                        }
                    }
                }
            } while (this.h);
            this.g = false;
        }
    }
}
