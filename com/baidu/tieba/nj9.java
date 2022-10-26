package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class nj9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public oj9 a;
    public long b;
    public int c;
    public long d;
    public LinkedList e;
    public ArrayList f;

    /* loaded from: classes5.dex */
    public class a implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(nj9 nj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nj9Var};
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
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(mj9 mj9Var, mj9 mj9Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mj9Var, mj9Var2)) == null) {
                int h = mj9Var2.h() - mj9Var.h();
                if (h == 0) {
                    return (int) (mj9Var2.i() - mj9Var.i());
                }
                return h;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948004524, "Lcom/baidu/tieba/nj9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948004524, "Lcom/baidu/tieba/nj9;");
                return;
            }
        }
        g = AppConfig.isDebug();
    }

    public final void d() {
        oj9 oj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (oj9Var = this.a) != null) {
            oj9Var.a();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.e.size() > 0) {
            Collections.sort(this.e, new a(this));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b = System.currentTimeMillis();
            if (g) {
                Log.d("VoyagerTaskModel", "update check task time: " + this.b);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c++;
        }
    }

    public nj9(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = oj9.f(context);
        j(z);
    }

    public void a(mj9 mj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mj9Var) == null) {
            if (mj9Var != null) {
                if (this.e.size() == 0) {
                    this.e.addFirst(mj9Var);
                } else {
                    int i = 0;
                    Iterator it = this.e.iterator();
                    while (it.hasNext() && mj9Var.h() < ((mj9) it.next()).h()) {
                        i++;
                    }
                    this.e.add(i, mj9Var);
                }
            }
            if (g) {
                Log.d("VoyagerTaskModel", "count: " + this.e.size());
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c < cj9.f().m()) {
                if (g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.c + ", max: " + cj9.f().m());
                }
                return true;
            }
            this.c = 0;
            if (System.currentTimeMillis() - this.b > cj9.f().l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            vj9.b(ej9.g().h());
            LinkedList linkedList = this.e;
            if (linkedList != null && linkedList.size() > 0) {
                this.e.clear();
            }
            ArrayList arrayList = this.f;
            if (arrayList != null && arrayList.size() > 0) {
                this.f.clear();
            }
            this.b = 0L;
            this.c = 0;
            this.d = 0L;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.g(this.f, this.e);
            if (this.f.size() > 0) {
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    vj9.d(ej9.g().h(), (String) it.next());
                    it.remove();
                }
            }
        }
    }

    public mj9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                return (mj9) this.e.getFirst();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.c = 0;
            return null;
        }
        return (mj9) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                long h = cj9.f().h();
                File h2 = ej9.g().h();
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    mj9 mj9Var = (mj9) it.next();
                    File file = new File(h2, mj9Var.j());
                    if (this.d < h) {
                        if (file.exists()) {
                            this.d += file.length();
                        }
                    } else {
                        mj9Var.r(false);
                        mj9Var.q(System.currentTimeMillis());
                        n(mj9Var);
                        file.delete();
                    }
                }
                if (g) {
                    Log.d("VoyagerTaskModel", "task count after delete exceed task: " + this.e.size());
                }
                int g2 = cj9.f().g();
                int size = this.e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    mj9 mj9Var2 = (mj9) this.e.removeLast();
                    mj9Var2.r(false);
                    mj9Var2.q(System.currentTimeMillis());
                    n(mj9Var2);
                    vj9.d(ej9.g().h(), mj9Var2.j());
                }
                if (g) {
                    Log.d("VoyagerTaskModel", "delete count: " + i);
                }
            } else if (g) {
                Log.d("VoyagerTaskModel", "task list length 0");
            }
        }
    }

    public final void g() {
        ArrayList f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (f = ej9.g().f()) != null && f.size() != 0) {
            Iterator it = f.iterator();
            while (it.hasNext()) {
                String name = ((File) it.next()).getName();
                Iterator it2 = this.e.iterator();
                while (it2.hasNext() && !TextUtils.equals(name, ((mj9) it2.next()).j())) {
                }
                it.remove();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "unreference file count: " + f.size());
            }
            if (f.size() > 0) {
                vj9.c(f);
            }
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.e) == null || linkedList.size() == 0) {
                return false;
            }
            String c = this.a.c();
            mj9 mj9Var = null;
            Iterator it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                mj9 mj9Var2 = (mj9) it.next();
                if (TextUtils.equals(c, mj9Var2.j())) {
                    mj9Var = mj9Var2;
                    break;
                }
            }
            if (mj9Var != null) {
                this.e.remove(mj9Var);
            }
            File file = new File(ej9.g().h(), c);
            if (file.exists()) {
                file.delete();
                this.d -= file.length();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                c();
                return;
            }
            this.e = new LinkedList();
            this.f = new ArrayList();
            this.b = 0L;
            this.c = 0;
            this.d = 0L;
            f();
            g();
            e();
            l();
        }
    }

    public void k(mj9 mj9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, mj9Var) == null) && mj9Var != null) {
            this.a.h(mj9Var);
        }
    }

    public void n(mj9 mj9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, mj9Var) == null) && mj9Var != null) {
            this.a.i(mj9Var);
        }
    }

    public void o(mj9 mj9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, mj9Var) == null) && mj9Var != null) {
            this.a.j(mj9Var);
        }
    }

    public void q(mj9 mj9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, mj9Var) == null) && mj9Var != null) {
            this.e.remove(mj9Var);
            this.e.addLast(mj9Var);
        }
    }

    public void m(boolean z, mj9 mj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, mj9Var) == null) {
            mj9Var.r(false);
            mj9Var.q(System.currentTimeMillis());
            n(mj9Var);
            if (z) {
                this.e.remove(mj9Var);
            }
        }
    }

    public void u(boolean z, mj9 mj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, mj9Var) == null) {
            mj9Var.r(false);
            mj9Var.q(System.currentTimeMillis());
            o(mj9Var);
            if (z) {
                q(mj9Var);
            } else {
                a(mj9Var);
            }
        }
    }

    public void s(boolean z, mj9 mj9Var, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), mj9Var, Long.valueOf(j)}) == null) {
            mj9Var.r(false);
            mj9Var.s(mj9Var.k() + 1);
            mj9Var.q(System.currentTimeMillis());
            if (z) {
                if (g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + mj9Var.d() + ", has uploaded " + mj9Var.k());
                }
                if (mj9Var.k() < mj9Var.d()) {
                    o(mj9Var);
                    q(mj9Var);
                    return;
                }
                n(mj9Var);
                this.e.remove(mj9Var);
                return;
            }
            o(mj9Var);
            a(mj9Var);
            if (g) {
                Log.d("VoyagerTaskModel", "add task " + mj9Var.j() + " to list");
            }
            this.d += j;
            while (this.d > cj9.f().h()) {
                if (!h()) {
                    this.d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, mj9 mj9Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), mj9Var, Long.valueOf(j), str}) == null) {
            mj9Var.r(true);
            mj9Var.q(System.currentTimeMillis());
            mj9Var.p(str);
            n(mj9Var);
            if (z) {
                this.e.remove(mj9Var);
                this.d -= j;
            }
        }
    }
}
