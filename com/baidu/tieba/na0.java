package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.tieba.va0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class na0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "def";
    public transient /* synthetic */ FieldHolder $fh;
    public ua0 a;
    public String b;
    public List<va0> c;
    public List<va0> d;
    public pa0 e;
    public pa0 f;
    public va0 g;
    public va0.c h;
    public Context i;
    public Boolean j;
    public boolean k;
    public va0.c l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947995596, "Lcom/baidu/tieba/na0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947995596, "Lcom/baidu/tieba/na0;");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends va0.c<va0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na0 a;

        public a(na0 na0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.va0.c
        /* renamed from: f */
        public void b(va0 va0Var, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, va0Var, exc) == null) {
                super.b(va0Var, exc);
                this.a.s();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.va0.c
        /* renamed from: e */
        public void a(va0 va0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, va0Var, str) == null) {
                this.a.d.remove(va0Var);
                this.a.c.add(va0Var);
                if (va0Var == this.a.g) {
                    this.a.a.i(na0.m, this.a.g.m());
                }
                if (this.a.q()) {
                    this.a.r();
                }
                super.a(va0Var, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.va0.c
        /* renamed from: g */
        public void c(va0 va0Var, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{va0Var, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                super.c(va0Var, j, j2, i);
                int k = this.a.k();
                if (this.a.h != null) {
                    this.a.h.c(this.a, 0L, 100L, k);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final na0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-581992306, "Lcom/baidu/tieba/na0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-581992306, "Lcom/baidu/tieba/na0$b;");
                    return;
                }
            }
            a = new na0(null);
        }
    }

    public na0() {
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
        this.c = new ArrayList();
        this.d = null;
        this.l = new a(this);
        ua0 ua0Var = new ua0(qa0.d().g());
        this.a = ua0Var;
        ua0Var.h(m);
        o();
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<va0> list = this.d;
            float f = 100.0f;
            if (list != null && list.size() != 0) {
                float size = 100.0f / (this.c.size() + this.d.size());
                float f2 = 0.0f;
                for (int i = 0; i < this.d.size(); i++) {
                    f2 += (this.d.get(i).n() / 100.0f) * size;
                }
                f = (this.c.size() * size) + f2;
            }
            return (int) f;
        }
        return invokeV.intValue;
    }

    public /* synthetic */ na0(a aVar) {
        this();
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            Log.d("DuAr_InitModel", str);
        }
    }

    public static final na0 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            m = str;
            return b.a;
        }
        return (na0) invokeL.objValue;
    }

    public File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f.g;
        }
        return (File) invokeV.objValue;
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e.g;
        }
        return (File) invokeV.objValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return fa0.n();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        List<va0> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c.size() > 0 && ((list = this.d) == null || list.size() == 0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (p()) {
                i("all onFailed .");
            }
            synchronized (this) {
                this.k = false;
            }
        }
    }

    public final void h(va0 va0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, va0Var) == null) {
            boolean q = va0Var.q();
            if (p()) {
                i("isLoaded " + q + StringUtil.ARRAY_ELEMENT_SEPARATOR + va0Var.o() + " to " + va0Var.m());
            }
            if (va0Var.q()) {
                this.c.add(va0Var);
                return;
            }
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(va0Var);
        }
    }

    public boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Boolean bool = this.j;
            if (bool != null && bool.booleanValue()) {
                return this.j.booleanValue();
            }
            this.j = Boolean.FALSE;
            long currentTimeMillis = System.currentTimeMillis();
            boolean k0 = ea0.k0();
            if (p()) {
                i("ARControllerProxy.loadSoFile " + k0);
            }
            if (!k0) {
                return this.j.booleanValue();
            }
            File file = this.f.g;
            if (p()) {
                i("setResConfig " + file);
            }
            if (file != null) {
                fa0.t(new ga0(file.getAbsolutePath()));
            }
            if (p()) {
                i("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            Boolean bool2 = Boolean.TRUE;
            this.j = bool2;
            return bool2.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.clear();
            List<va0> list = this.d;
            if (list != null) {
                list.clear();
            }
            if ("live".equals(fa0.f())) {
                this.e = pa0.i();
                this.f = pa0.g();
            }
            if (BdUploadHandler.MEDIA_SOURCE_KEY.equals(fa0.f())) {
                this.e = pa0.h();
                this.f = pa0.f();
            }
            if ("tieba".equals(fa0.f())) {
                this.e = pa0.i();
                this.f = pa0.f();
            }
            oa0 oa0Var = new oa0(this.f);
            this.g = oa0Var;
            h(oa0Var);
            h(new oa0(this.e));
        }
    }

    public void r() {
        File file;
        va0.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.k = false;
            }
            boolean n = n(this.i);
            String str = null;
            if (!n && (cVar = this.h) != null) {
                cVar.b(null, null);
                return;
            }
            this.a.n(this.b);
            this.a.f();
            if (p()) {
                i("all onCompleted " + n);
            }
            if (this.h != null && n) {
                pa0 pa0Var = this.f;
                if (pa0Var != null && (file = pa0Var.g) != null) {
                    str = file.getAbsolutePath();
                }
                this.h.a(this, str);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b = this.a.e(m);
            List<va0> list = this.d;
            if (list != null && list.size() > 0) {
                for (va0 va0Var : this.d) {
                    va0Var.l(this.l);
                }
                return;
            }
            r();
        }
    }

    public void u(Context context, va0.c<na0> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, cVar) == null) {
            this.i = context;
            this.h = cVar;
            synchronized (this) {
                if (this.k) {
                    if (p()) {
                        i("start return, isLoading true");
                    }
                    return;
                }
                this.k = true;
                o();
                t();
            }
        }
    }
}
