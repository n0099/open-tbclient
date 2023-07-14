package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.yw2;
import com.baidu.tieba.zb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class tu2 extends dc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, f> b;
    public final yw2 c;
    public final yw2 d;

    /* loaded from: classes8.dex */
    public class a implements oq3<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu2 a;

        public a(tu2 tu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tu2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) != null) {
                return;
            }
            fVar.h(this.a);
            this.a.b.put(fVar.a, fVar);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements oq3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq3 a;
        public final /* synthetic */ tu2 b;

        public b(tu2 tu2Var, hq3 hq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu2Var, hq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tu2Var;
            this.a = hq3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if ("on_progress".equals(str)) {
                    this.b.A((zb3.a) new zb3.a("installer_on_progress").v(" event_params_installer_progress", this.a.j()));
                } else if ("pump_finish".equals(str)) {
                    this.b.p("installer_on_pump_finish");
                } else if ("finish".equals(str)) {
                    this.b.p("installer_on_finish");
                } else if ("start".equals(str)) {
                    this.b.p("installer_on_start");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements oq3<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq3 a;

        public c(tu2 tu2Var, hq3 hq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu2Var, hq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                this.a.d(fVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements oq3<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(tu2 tu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu2Var};
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
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                fVar.f();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements oq3<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean[] a;

        public e(tu2 tu2Var, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu2Var, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                boolean[] zArr = this.a;
                zArr[0] = fVar.d() & zArr[0];
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class f implements oq3<Pipe.SourceChannel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final Bundle b;
        public tu2 c;

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        public abstract boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new Bundle();
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: e */
        public void a(Pipe.SourceChannel sourceChannel) {
            tu2 tu2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, sourceChannel) == null) && (tu2Var = this.c) != null && g(sourceChannel, tu2Var.c.D())) {
                i();
            }
        }

        public final void h(tu2 tu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, tu2Var) == null) {
                this.c = tu2Var;
            }
        }

        public Bundle c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (Bundle) invokeV.objValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return c().getBoolean("flag_is_ok");
            }
            return invokeV.booleanValue;
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.b.putBoolean("flag_is_ok", true);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193624, "Lcom/baidu/tieba/tu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193624, "Lcom/baidu/tieba/tu2;");
                return;
            }
        }
        e = fs1.a;
    }

    public tu2() {
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
        this.b = new HashMap();
        this.c = new yw2.a();
        this.d = new yw2.a();
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b.isEmpty() || this.d.d("flag_is_ok", false)) {
                return true;
            }
            boolean[] zArr = {true};
            L(new e(this, zArr));
            this.d.t("flag_is_ok", zArr[0]);
            return zArr[0];
        }
        return invokeV.booleanValue;
    }

    public tu2 J(f... fVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVarArr)) == null) {
            nq3.d(new a(this), fVarArr);
            return this;
        }
        return (tu2) invokeL.objValue;
    }

    public tu2 K(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.c.update(bundle);
            return this;
        }
        return (tu2) invokeL.objValue;
    }

    public final void L(oq3<f> oq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oq3Var) == null) {
            nq3.c(oq3Var, this.b.values());
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && e) {
            ax2.d(this.c.o("launch_id", "")).f(str).b("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    public synchronized tu2 M(ReadableByteChannel readableByteChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, readableByteChannel)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                this.d.a();
                hq3 hq3Var = new hq3();
                hq3Var.o(32768);
                hq3Var.q(30L, TimeUnit.SECONDS);
                hq3Var.g(this.c.D());
                hq3Var.p(new b(this, hq3Var));
                L(new c(this, hq3Var));
                O("connect: " + readableByteChannel + " at: " + currentTimeMillis);
                hq3Var.h(readableByteChannel);
                boolean N = N();
                if (e) {
                    O("allOk: " + N + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (!N) {
                    L(new d(this));
                }
            }
            return this;
        }
        return (tu2) invokeL.objValue;
    }
}
