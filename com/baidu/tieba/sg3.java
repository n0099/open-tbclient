package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class sg3<ResultDataT> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final yg3<ResultDataT> a;
    public final Set<oq3<yg3<ResultDataT>>> b;
    public final LinkedList<ug3> c;
    public boolean d;
    public boolean e;

    public abstract void i();

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract ResultDataT m(JSONObject jSONObject) throws JSONException;

    public sg3<ResultDataT> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? this : (sg3) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class a extends ug3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg3 c;

        public a(sg3 sg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sg3Var;
        }

        @Override // com.baidu.tieba.ug3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.c.k()) {
                    return true;
                }
                tg3.k("initialPrepare failed", Boolean.TRUE);
                throw new OAuthException(10001);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ug3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg3 c;

        public b(sg3 sg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sg3Var;
        }

        @Override // com.baidu.tieba.ug3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.c.j()) {
                    tg3.k("finalPrepare failed", Boolean.TRUE);
                    if (sg3.f) {
                        throw new OAuthException(10001);
                    }
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq3 a;
        public final /* synthetic */ sg3 b;

        public c(sg3 sg3Var, oq3 oq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg3Var, oq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sg3Var;
            this.a = oq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            oq3 oq3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (oq3Var = this.a) != null) {
                oq3Var.a(this.b.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948150410, "Lcom/baidu/tieba/sg3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948150410, "Lcom/baidu/tieba/sg3;");
                return;
            }
        }
        f = fs1.a;
    }

    public final synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                i();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = new b(this);
            bVar.h(this);
            bVar.g();
            this.e = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(null);
        }
    }

    @NonNull
    public sg3 call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TaskState.INIT == e()) {
                s(TaskState.CALLING);
                n();
            }
            return this;
        }
        return (sg3) invokeV.objValue;
    }

    public TaskState e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.b;
        }
        return (TaskState) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a aVar = new a(this);
            aVar.h(this);
            aVar.g();
            this.d = true;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (oq3<yg3<ResultDataT>> oq3Var : this.b) {
                tg3.l(new c(this, oq3Var));
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.b = TaskState.INIT;
            this.d = false;
            this.e = false;
        }
    }

    public sg3() {
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
        this.a = new yg3<>();
        this.b = new HashSet();
        this.c = new LinkedList<>();
        this.d = false;
        this.e = false;
    }

    public void d(@Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (exc instanceof OAuthException) {
                this.a.c = (OAuthException) exc;
            } else if (exc != null) {
                tg3.t("OAuthTask#finish", exc.getMessage());
                this.a.c = new OAuthException(exc, 10001);
            }
            if (!this.a.c() && f && exc != null) {
                exc.printStackTrace();
            }
            s(TaskState.FINISHED);
            tg3.k(toString(), Boolean.FALSE);
            g();
            this.b.clear();
        }
    }

    public sg3 h(@NonNull ug3 ug3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ug3Var)) == null) {
            ug3Var.h(this);
            this.c.offer(ug3Var);
            return this;
        }
        return (sg3) invokeL.objValue;
    }

    public void l(ug3 ug3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ug3Var) == null) {
            if (ug3Var.c()) {
                n();
            } else {
                d(ug3Var.b());
            }
        }
    }

    public sg3<ResultDataT> o(oq3<yg3<ResultDataT>> oq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, oq3Var)) == null) {
            if (this.a.b.isCallbackAvailable()) {
                this.b.add(oq3Var);
            }
            return this;
        }
        return (sg3) invokeL.objValue;
    }

    public void r(ResultDataT resultdatat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, resultdatat) == null) {
            this.a.a = resultdatat;
        }
    }

    public final void s(TaskState taskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, taskState) == null) {
            this.a.b = taskState;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!TaskState.CALLING.equals(e())) {
                if (f) {
                    tg3.k("IllegalState on prepare", Boolean.FALSE);
                }
            } else if (!this.d) {
                f();
            } else if (!this.c.isEmpty()) {
                this.c.poll().g();
            } else if (!this.e) {
                b();
            } else {
                a();
            }
        }
    }
}
