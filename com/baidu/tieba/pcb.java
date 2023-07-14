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
/* loaded from: classes7.dex */
public class pcb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public qcb a;
    public long b;
    public int c;
    public long d;
    public LinkedList<ocb> e;
    public ArrayList<String> f;

    /* loaded from: classes7.dex */
    public class a implements Comparator<ocb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(pcb pcbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pcbVar};
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
        public int compare(ocb ocbVar, ocb ocbVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ocbVar, ocbVar2)) == null) {
                int h = ocbVar2.h() - ocbVar.h();
                if (h == 0) {
                    return (int) (ocbVar2.i() - ocbVar.i());
                }
                return h;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948058650, "Lcom/baidu/tieba/pcb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948058650, "Lcom/baidu/tieba/pcb;");
                return;
            }
        }
        g = AppConfig.isDebug();
    }

    public final void d() {
        qcb qcbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (qcbVar = this.a) != null) {
            qcbVar.a();
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

    public pcb(Context context, boolean z) {
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
        this.a = qcb.f(context);
        j(z);
    }

    public void a(ocb ocbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ocbVar) == null) {
            if (ocbVar != null) {
                if (this.e.size() == 0) {
                    this.e.addFirst(ocbVar);
                } else {
                    int i = 0;
                    Iterator<ocb> it = this.e.iterator();
                    while (it.hasNext() && ocbVar.h() < it.next().h()) {
                        i++;
                    }
                    this.e.add(i, ocbVar);
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
            if (this.c < fcb.f().m()) {
                if (g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.c + ", max: " + fcb.f().m());
                }
                return true;
            }
            this.c = 0;
            if (System.currentTimeMillis() - this.b > fcb.f().l()) {
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
            xcb.b(hcb.g().h());
            LinkedList<ocb> linkedList = this.e;
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
                    xcb.d(hcb.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public ocb i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<ocb> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.e.getFirst();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.c = 0;
            return null;
        }
        return (ocb) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<ocb> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                long h = fcb.f().h();
                File h2 = hcb.g().h();
                Iterator<ocb> it = this.e.iterator();
                while (it.hasNext()) {
                    ocb next = it.next();
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
                int g2 = fcb.f().g();
                int size = this.e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    ocb removeLast = this.e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    xcb.d(hcb.g().h(), removeLast.j());
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
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (f = hcb.g().f()) != null && f.size() != 0) {
            Iterator<File> it = f.iterator();
            while (it.hasNext()) {
                String name = it.next().getName();
                Iterator<ocb> it2 = this.e.iterator();
                while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
                }
                it.remove();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "unreference file count: " + f.size());
            }
            if (f.size() > 0) {
                xcb.c(f);
            }
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<ocb> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.e) == null || linkedList.size() == 0) {
                return false;
            }
            String c = this.a.c();
            ocb ocbVar = null;
            Iterator<ocb> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ocb next = it.next();
                if (TextUtils.equals(c, next.j())) {
                    ocbVar = next;
                    break;
                }
            }
            if (ocbVar != null) {
                this.e.remove(ocbVar);
            }
            File file = new File(hcb.g().h(), c);
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

    public void k(ocb ocbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, ocbVar) == null) && ocbVar != null) {
            this.a.h(ocbVar);
        }
    }

    public void n(ocb ocbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, ocbVar) == null) && ocbVar != null) {
            this.a.i(ocbVar);
        }
    }

    public void o(ocb ocbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, ocbVar) == null) && ocbVar != null) {
            this.a.j(ocbVar);
        }
    }

    public void q(ocb ocbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, ocbVar) == null) && ocbVar != null) {
            this.e.remove(ocbVar);
            this.e.addLast(ocbVar);
        }
    }

    public void m(boolean z, ocb ocbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, ocbVar) == null) {
            ocbVar.r(false);
            ocbVar.q(System.currentTimeMillis());
            n(ocbVar);
            if (z) {
                this.e.remove(ocbVar);
            }
        }
    }

    public void u(boolean z, ocb ocbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, ocbVar) == null) {
            ocbVar.r(false);
            ocbVar.q(System.currentTimeMillis());
            o(ocbVar);
            if (z) {
                q(ocbVar);
            } else {
                a(ocbVar);
            }
        }
    }

    public void s(boolean z, ocb ocbVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), ocbVar, Long.valueOf(j)}) == null) {
            ocbVar.r(false);
            ocbVar.s(ocbVar.k() + 1);
            ocbVar.q(System.currentTimeMillis());
            if (z) {
                if (g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + ocbVar.d() + ", has uploaded " + ocbVar.k());
                }
                if (ocbVar.k() < ocbVar.d()) {
                    o(ocbVar);
                    q(ocbVar);
                    return;
                }
                n(ocbVar);
                this.e.remove(ocbVar);
                return;
            }
            o(ocbVar);
            a(ocbVar);
            if (g) {
                Log.d("VoyagerTaskModel", "add task " + ocbVar.j() + " to list");
            }
            this.d += j;
            while (this.d > fcb.f().h()) {
                if (!h()) {
                    this.d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, ocb ocbVar, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), ocbVar, Long.valueOf(j), str}) == null) {
            ocbVar.r(true);
            ocbVar.q(System.currentTimeMillis());
            ocbVar.p(str);
            n(ocbVar);
            if (z) {
                this.e.remove(ocbVar);
                this.d -= j;
            }
        }
    }
}
