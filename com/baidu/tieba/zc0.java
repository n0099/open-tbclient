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
/* loaded from: classes7.dex */
public class zc0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "zc0";
    public transient /* synthetic */ FieldHolder $fh;
    public bd0 a;
    public List<ad0> b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948355010, "Lcom/baidu/tieba/zc0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948355010, "Lcom/baidu/tieba/zc0;");
        }
    }

    public zc0(Object obj, List<nd0> list) {
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
        List<ad0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.a != null && (list = this.b) != null && list.size() != 0) {
            synchronized (this) {
                for (ad0 ad0Var : this.b) {
                    this.a.b(ad0Var.c());
                    ad0Var.b(j);
                }
                notifyAll();
            }
            this.a.d(j);
            this.a.e();
        }
    }

    public final void b(Object obj, List<nd0> list) {
        ad0 ad0Var;
        bd0 bd0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) && list != null && list.size() != 0) {
            List<ad0> list2 = this.b;
            if (list2 == null) {
                this.b = new ArrayList();
            } else {
                list2.clear();
            }
            for (int i = 0; i < list.size(); i++) {
                try {
                    this.b.add(new ad0(list.get(i)));
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
                        this.a = new bd0(this.b.get(this.c).c(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.a = new bd0(this.b.get(this.c).c(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.a = new bd0(this.b.get(this.c).c(), (SurfaceHolder) obj);
                    }
                } else {
                    List<ad0> list3 = this.b;
                    if (list3 != null && list3 != null && (ad0Var = list3.get(i2)) != null && (bd0Var = this.a) != null) {
                        bd0Var.f(ad0Var.c());
                    }
                }
            }
            for (ad0 ad0Var2 : this.b) {
                bd0 bd0Var2 = this.a;
                if (bd0Var2 != null) {
                    bd0Var2.b(ad0Var2.c());
                    ad0Var2.f();
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            bd0 bd0Var = this.a;
            if (bd0Var != null) {
                bd0Var.g();
                this.a = null;
            }
            List<ad0> list = this.b;
            if (list != null) {
                for (ad0 ad0Var : list) {
                    ad0Var.e();
                }
                this.b.clear();
                this.b = null;
            }
        }
    }

    public void d(gd0 gd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gd0Var) == null) {
            for (ad0 ad0Var : this.b) {
                bd0 bd0Var = this.a;
                if (bd0Var != null) {
                    bd0Var.b(ad0Var.c());
                    ad0Var.g(gd0Var);
                }
            }
        }
    }

    public void e(List<nd0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(d, "updateSurfaceDrawer !!!");
            this.a.c();
            for (ad0 ad0Var : this.b) {
                ad0Var.e();
            }
            this.b.clear();
            b(null, list);
        }
    }
}
