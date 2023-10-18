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
/* loaded from: classes6.dex */
public class k80 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "k80";
    public transient /* synthetic */ FieldHolder $fh;
    public m80 a;
    public List<l80> b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947866822, "Lcom/baidu/tieba/k80;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947866822, "Lcom/baidu/tieba/k80;");
        }
    }

    public k80(Object obj, List<y80> list) {
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
        List<l80> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.a != null && (list = this.b) != null && list.size() != 0) {
            synchronized (this) {
                for (l80 l80Var : this.b) {
                    this.a.b(l80Var.c());
                    l80Var.b(j);
                }
                notifyAll();
            }
            this.a.d(j);
            this.a.e();
        }
    }

    public final void b(Object obj, List<y80> list) {
        l80 l80Var;
        m80 m80Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) && list != null && list.size() != 0) {
            List<l80> list2 = this.b;
            if (list2 == null) {
                this.b = new ArrayList();
            } else {
                list2.clear();
            }
            for (int i = 0; i < list.size(); i++) {
                try {
                    this.b.add(new l80(list.get(i)));
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
                        this.a = new m80(this.b.get(this.c).c(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.a = new m80(this.b.get(this.c).c(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.a = new m80(this.b.get(this.c).c(), (SurfaceHolder) obj);
                    }
                } else {
                    List<l80> list3 = this.b;
                    if (list3 != null && list3 != null && (l80Var = list3.get(i2)) != null && (m80Var = this.a) != null) {
                        m80Var.f(l80Var.c());
                    }
                }
            }
            for (l80 l80Var2 : this.b) {
                m80 m80Var2 = this.a;
                if (m80Var2 != null) {
                    m80Var2.b(l80Var2.c());
                    l80Var2.f();
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m80 m80Var = this.a;
            if (m80Var != null) {
                m80Var.g();
                this.a = null;
            }
            List<l80> list = this.b;
            if (list != null) {
                for (l80 l80Var : list) {
                    l80Var.e();
                }
                this.b.clear();
                this.b = null;
            }
        }
    }

    public void d(r80 r80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, r80Var) == null) {
            for (l80 l80Var : this.b) {
                m80 m80Var = this.a;
                if (m80Var != null) {
                    m80Var.b(l80Var.c());
                    l80Var.g(r80Var);
                }
            }
        }
    }

    public void e(List<y80> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(d, "updateSurfaceDrawer !!!");
            this.a.c();
            for (l80 l80Var : this.b) {
                l80Var.e();
            }
            this.b.clear();
            b(null, list);
        }
    }
}
