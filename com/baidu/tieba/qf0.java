package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.tieba.yf0;
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
public class qf0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "def";
    public transient /* synthetic */ FieldHolder $fh;
    public xf0 a;
    public String b;
    public List<yf0> c;
    public List<yf0> d;
    public sf0 e;
    public sf0 f;
    public yf0 g;
    public yf0.c h;
    public Context i;
    public Boolean j;
    public boolean k;
    public yf0.c l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948089774, "Lcom/baidu/tieba/qf0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948089774, "Lcom/baidu/tieba/qf0;");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends yf0.c<yf0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf0 a;

        public a(qf0 qf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qf0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf0.c
        /* renamed from: f */
        public void b(yf0 yf0Var, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, yf0Var, exc) == null) {
                super.b(yf0Var, exc);
                this.a.s();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf0.c
        /* renamed from: e */
        public void a(yf0 yf0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, yf0Var, str) == null) {
                this.a.d.remove(yf0Var);
                this.a.c.add(yf0Var);
                if (yf0Var == this.a.g) {
                    this.a.a.i(qf0.m, this.a.g.m());
                }
                if (this.a.q()) {
                    this.a.r();
                }
                super.a(yf0Var, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf0.c
        /* renamed from: g */
        public void c(yf0 yf0Var, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{yf0Var, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                super.c(yf0Var, j, j2, i);
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
        public static final qf0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-491487248, "Lcom/baidu/tieba/qf0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-491487248, "Lcom/baidu/tieba/qf0$b;");
                    return;
                }
            }
            a = new qf0(null);
        }
    }

    public qf0() {
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
        xf0 xf0Var = new xf0(tf0.d().g());
        this.a = xf0Var;
        xf0Var.h(m);
        o();
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<yf0> list = this.d;
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

    public /* synthetic */ qf0(a aVar) {
        this();
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            Log.d("DuAr_InitModel", str);
        }
    }

    public static final qf0 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            m = str;
            return b.a;
        }
        return (qf0) invokeL.objValue;
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
            return if0.m();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        List<yf0> list;
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

    public final void h(yf0 yf0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yf0Var) == null) {
            boolean q = yf0Var.q();
            if (p()) {
                i("isLoaded " + q + StringUtil.ARRAY_ELEMENT_SEPARATOR + yf0Var.o() + " to " + yf0Var.m());
            }
            if (yf0Var.q()) {
                this.c.add(yf0Var);
                return;
            }
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(yf0Var);
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
            boolean k0 = hf0.k0();
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
                if0.s(new jf0(file.getAbsolutePath()));
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
            List<yf0> list = this.d;
            if (list != null) {
                list.clear();
            }
            if ("live".equals(if0.e())) {
                this.e = sf0.i();
                this.f = sf0.g();
            }
            if (BdUploadHandler.MEDIA_SOURCE_KEY.equals(if0.e())) {
                this.e = sf0.h();
                this.f = sf0.f();
            }
            if ("tieba".equals(if0.e())) {
                this.e = sf0.i();
                this.f = sf0.f();
            }
            rf0 rf0Var = new rf0(this.f);
            this.g = rf0Var;
            h(rf0Var);
            h(new rf0(this.e));
        }
    }

    public void r() {
        File file;
        yf0.c cVar;
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
                sf0 sf0Var = this.f;
                if (sf0Var != null && (file = sf0Var.g) != null) {
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
            List<yf0> list = this.d;
            if (list != null && list.size() > 0) {
                for (yf0 yf0Var : this.d) {
                    yf0Var.l(this.l);
                }
                return;
            }
            r();
        }
    }

    public void u(Context context, yf0.c<qf0> cVar) {
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
