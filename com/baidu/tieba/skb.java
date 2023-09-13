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
/* loaded from: classes8.dex */
public class skb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public tkb a;
    public long b;
    public int c;
    public long d;
    public LinkedList<rkb> e;
    public ArrayList<String> f;

    /* loaded from: classes8.dex */
    public class a implements Comparator<rkb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(skb skbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {skbVar};
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
        public int compare(rkb rkbVar, rkb rkbVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, rkbVar, rkbVar2)) == null) {
                int h = rkbVar2.h() - rkbVar.h();
                if (h == 0) {
                    return (int) (rkbVar2.i() - rkbVar.i());
                }
                return h;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948155711, "Lcom/baidu/tieba/skb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948155711, "Lcom/baidu/tieba/skb;");
                return;
            }
        }
        g = AppConfig.isDebug();
    }

    public final void d() {
        tkb tkbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (tkbVar = this.a) != null) {
            tkbVar.a();
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

    public skb(Context context, boolean z) {
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
        this.a = tkb.f(context);
        j(z);
    }

    public void a(rkb rkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rkbVar) == null) {
            if (rkbVar != null) {
                if (this.e.size() == 0) {
                    this.e.addFirst(rkbVar);
                } else {
                    int i = 0;
                    Iterator<rkb> it = this.e.iterator();
                    while (it.hasNext() && rkbVar.h() < it.next().h()) {
                        i++;
                    }
                    this.e.add(i, rkbVar);
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
            if (this.c < ikb.f().m()) {
                if (g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.c + ", max: " + ikb.f().m());
                }
                return true;
            }
            this.c = 0;
            if (System.currentTimeMillis() - this.b > ikb.f().l()) {
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
            alb.b(kkb.g().h());
            LinkedList<rkb> linkedList = this.e;
            if (linkedList != null && linkedList.size() > 0) {
                this.e.clear();
            }
            ArrayList<String> arrayList = this.f;
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
                Iterator<String> it = this.f.iterator();
                while (it.hasNext()) {
                    alb.d(kkb.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public rkb i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<rkb> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.e.getFirst();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.c = 0;
            return null;
        }
        return (rkb) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<rkb> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                long h = ikb.f().h();
                File h2 = kkb.g().h();
                Iterator<rkb> it = this.e.iterator();
                while (it.hasNext()) {
                    rkb next = it.next();
                    File file = new File(h2, next.j());
                    if (this.d < h) {
                        if (file.exists()) {
                            this.d += file.length();
                        }
                    } else {
                        next.r(false);
                        next.q(System.currentTimeMillis());
                        n(next);
                        file.delete();
                    }
                }
                if (g) {
                    Log.d("VoyagerTaskModel", "task count after delete exceed task: " + this.e.size());
                }
                int g2 = ikb.f().g();
                int size = this.e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    rkb removeLast = this.e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    alb.d(kkb.g().h(), removeLast.j());
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
        ArrayList<File> f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (f = kkb.g().f()) != null && f.size() != 0) {
            Iterator<File> it = f.iterator();
            while (it.hasNext()) {
                String name = it.next().getName();
                Iterator<rkb> it2 = this.e.iterator();
                while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
                }
                it.remove();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "unreference file count: " + f.size());
            }
            if (f.size() > 0) {
                alb.c(f);
            }
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<rkb> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.e) == null || linkedList.size() == 0) {
                return false;
            }
            String c = this.a.c();
            rkb rkbVar = null;
            Iterator<rkb> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                rkb next = it.next();
                if (TextUtils.equals(c, next.j())) {
                    rkbVar = next;
                    break;
                }
            }
            if (rkbVar != null) {
                this.e.remove(rkbVar);
            }
            File file = new File(kkb.g().h(), c);
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
            this.e = new LinkedList<>();
            this.f = new ArrayList<>();
            this.b = 0L;
            this.c = 0;
            this.d = 0L;
            f();
            g();
            e();
            l();
        }
    }

    public void k(rkb rkbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, rkbVar) == null) && rkbVar != null) {
            this.a.h(rkbVar);
        }
    }

    public void n(rkb rkbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, rkbVar) == null) && rkbVar != null) {
            this.a.i(rkbVar);
        }
    }

    public void o(rkb rkbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, rkbVar) == null) && rkbVar != null) {
            this.a.j(rkbVar);
        }
    }

    public void q(rkb rkbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, rkbVar) == null) && rkbVar != null) {
            this.e.remove(rkbVar);
            this.e.addLast(rkbVar);
        }
    }

    public void m(boolean z, rkb rkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, rkbVar) == null) {
            rkbVar.r(false);
            rkbVar.q(System.currentTimeMillis());
            n(rkbVar);
            if (z) {
                this.e.remove(rkbVar);
            }
        }
    }

    public void u(boolean z, rkb rkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, rkbVar) == null) {
            rkbVar.r(false);
            rkbVar.q(System.currentTimeMillis());
            o(rkbVar);
            if (z) {
                q(rkbVar);
            } else {
                a(rkbVar);
            }
        }
    }

    public void s(boolean z, rkb rkbVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), rkbVar, Long.valueOf(j)}) == null) {
            rkbVar.r(false);
            rkbVar.s(rkbVar.k() + 1);
            rkbVar.q(System.currentTimeMillis());
            if (z) {
                if (g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + rkbVar.d() + ", has uploaded " + rkbVar.k());
                }
                if (rkbVar.k() < rkbVar.d()) {
                    o(rkbVar);
                    q(rkbVar);
                    return;
                }
                n(rkbVar);
                this.e.remove(rkbVar);
                return;
            }
            o(rkbVar);
            a(rkbVar);
            if (g) {
                Log.d("VoyagerTaskModel", "add task " + rkbVar.j() + " to list");
            }
            this.d += j;
            while (this.d > ikb.f().h()) {
                if (!h()) {
                    this.d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, rkb rkbVar, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), rkbVar, Long.valueOf(j), str}) == null) {
            rkbVar.r(true);
            rkbVar.q(System.currentTimeMillis());
            rkbVar.p(str);
            n(rkbVar);
            if (z) {
                this.e.remove(rkbVar);
                this.d -= j;
            }
        }
    }
}
