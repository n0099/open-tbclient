package com.baidu.tieba;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class mc0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "mc0";
    public transient /* synthetic */ FieldHolder $fh;
    public oc0 a;
    public List<nc0> b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947967727, "Lcom/baidu/tieba/mc0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947967727, "Lcom/baidu/tieba/mc0;");
        }
    }

    public mc0(Object obj, List<ad0> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        b(obj, list);
    }

    public void a(long j) {
        List<nc0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.a == null || (list = this.b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (nc0 nc0Var : this.b) {
                this.a.b(nc0Var.c());
                nc0Var.b(j);
            }
            notifyAll();
        }
        this.a.d(j);
        this.a.e();
    }

    public final void b(Object obj, List<ad0> list) {
        nc0 nc0Var;
        oc0 oc0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) || list == null || list.size() == 0) {
            return;
        }
        List<nc0> list2 = this.b;
        if (list2 == null) {
            this.b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                this.b.add(new nc0(list.get(i)));
                if (list.get(i).k()) {
                    this.c = i;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int size = this.b.size();
        int i2 = this.c;
        if (size > i2) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.a = new oc0(this.b.get(this.c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.a = new oc0(this.b.get(this.c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.a = new oc0(this.b.get(this.c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<nc0> list3 = this.b;
                if (list3 != null && list3 != null && (nc0Var = list3.get(i2)) != null && (oc0Var = this.a) != null) {
                    oc0Var.f(nc0Var.c());
                }
            }
        }
        for (nc0 nc0Var2 : this.b) {
            oc0 oc0Var2 = this.a;
            if (oc0Var2 != null) {
                oc0Var2.b(nc0Var2.c());
                nc0Var2.f();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            oc0 oc0Var = this.a;
            if (oc0Var != null) {
                oc0Var.g();
                this.a = null;
            }
            List<nc0> list = this.b;
            if (list != null) {
                for (nc0 nc0Var : list) {
                    nc0Var.e();
                }
                this.b.clear();
                this.b = null;
            }
        }
    }

    public void d(tc0 tc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tc0Var) == null) {
            for (nc0 nc0Var : this.b) {
                oc0 oc0Var = this.a;
                if (oc0Var != null) {
                    oc0Var.b(nc0Var.c());
                    nc0Var.g(tc0Var);
                }
            }
        }
    }

    public void e(List<ad0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(d, "updateSurfaceDrawer !!!");
            this.a.c();
            for (nc0 nc0Var : this.b) {
                nc0Var.e();
            }
            this.b.clear();
            b(null, list);
        }
    }
}
