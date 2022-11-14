package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.gu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class o32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static final Set<String> f;
    public static final int g;
    public static final int h;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public bi4 a;
    public ArrayList<l32> b;
    public Queue<Runnable> c;
    public final List<a> d;

    /* loaded from: classes5.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public di4 a;
        public String b;
        public final /* synthetic */ o32 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l32 a;
            public final /* synthetic */ l32 b;

            public a(b bVar, l32 l32Var, l32 l32Var2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, l32Var, l32Var2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = l32Var;
                this.b = l32Var2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    l32 l32Var = this.a;
                    if (l32Var != null && l32Var.U()) {
                        this.a.m1(false);
                    }
                    l32 l32Var2 = this.a;
                    if (l32Var2 instanceof n32) {
                        ((n32) l32Var2).Z3();
                    }
                    this.b.m1(true);
                }
            }
        }

        /* renamed from: com.baidu.tieba.o32$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0367b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l32 a;

            public RunnableC0367b(b bVar, l32 l32Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, l32Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = l32Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                l32 l32Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l32Var = this.a) != null) {
                    l32Var.m1(true);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l32 a;

            public c(b bVar, l32 l32Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, l32Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = l32Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                l32 l32Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l32Var = this.a) != null) {
                    l32Var.m1(false);
                }
            }
        }

        public b(o32 o32Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o32Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o32Var;
            this.a = o32Var.a.a();
            this.b = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.b)) {
                    n32.U3(this.b);
                }
                while (!this.c.c.isEmpty()) {
                    if (this.c.c.peek() != null) {
                        ((Runnable) this.c.c.poll()).run();
                    }
                }
                d();
                this.a.f();
            }
        }

        public b i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.c.b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.c.b.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((l32) arrayList.get(size)).e2()) {
                        this.a.h((Fragment) arrayList.get(size));
                        this.c.b.remove(size);
                    }
                }
                r();
                return this;
            }
            return (b) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a();
                return this.c.a.c();
            }
            return invokeV.booleanValue;
        }

        public b g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                h(1);
                return this;
            }
            return (b) invokeV.objValue;
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
                this.c.c.offer(new RunnableC0367b(this, this.c.m()));
            }
        }

        public void c(l32 l32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l32Var) == null) {
                di4 di4Var = this.a;
                di4Var.g(l32Var);
                di4Var.f();
                this.c.a.c();
            }
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                return o32.f.contains(str);
            }
            return invokeL.booleanValue;
        }

        public void o(l32 l32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, l32Var) == null) {
                di4 di4Var = this.a;
                di4Var.j(l32Var);
                di4Var.f();
                this.c.a.c();
            }
        }

        public b q(fu2 fu2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, fu2Var)) == null) {
                n32 l = this.c.l();
                if (l != null) {
                    l.V3(fu2Var);
                    return this;
                }
                return k("normal", fu2Var);
            }
            return (b) invokeL.objValue;
        }

        public final void s(l32 l32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, l32Var) == null) {
                this.c.c.offer(new a(this, this.c.m(), l32Var));
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.c.b.isEmpty()) {
                return;
            }
            int size = this.c.b.size();
            boolean z = false;
            int i = size - 1;
            for (int i2 = i; i2 >= 0; i2--) {
                if (i2 >= i) {
                    if (o32.e) {
                        Log.d("SwanAppFragmentManager", "show fragment i " + i2 + " ,size: " + size);
                    }
                    this.a.j((Fragment) this.c.b.get(i2));
                    z = ((l32) this.c.b.get(i2)).D0;
                } else if (z) {
                    this.a.j((Fragment) this.c.b.get(i2));
                    z = ((l32) this.c.b.get(i2)).D0;
                } else {
                    this.a.g((Fragment) this.c.b.get(i2));
                }
            }
        }

        public b f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<Fragment> d = this.c.a.d();
                if (d != null && d.size() != this.c.b.size()) {
                    for (Fragment fragment : d) {
                        if (fragment != null && !this.c.b.contains(fragment)) {
                            if (o32.e) {
                                Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                            }
                            for (a aVar : this.c.d) {
                                if (aVar != null) {
                                    aVar.b(fragment);
                                }
                            }
                            this.a.h(fragment);
                        }
                    }
                }
                h(this.c.b.size());
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b h(int i) {
            InterceptResult invokeI;
            l32 l32Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                if (this.c.b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.c.b.clone();
                int size = arrayList.size();
                int i2 = size - i;
                if (i2 >= 0 && i > 0) {
                    l32Var = (l32) arrayList.get(i2);
                } else {
                    l32Var = null;
                }
                while (true) {
                    size--;
                    if (size <= i2 - 1 || size < 0) {
                        break;
                    }
                    for (a aVar : this.c.d) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(size));
                        }
                    }
                    this.a.h((Fragment) arrayList.get(size));
                    this.c.b.remove(size);
                }
                this.c.c.offer(new c(this, l32Var));
                r();
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b j(l32 l32Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, l32Var)) == null) {
                s(l32Var);
                this.a.b(R.id.obfuscated_res_0x7f09017c, l32Var, "SwanAppFragment");
                this.c.b.add(l32Var);
                for (a aVar : this.c.d) {
                    if (aVar != null) {
                        aVar.a(l32Var);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                int size = this.c.b.size();
                if (!this.c.b.isEmpty() && i >= 0 && i < size) {
                    this.a.h((l32) this.c.b.remove(i));
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public void p(List<l32> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
                for (int i = 0; i < list.size(); i++) {
                    this.a.j(list.get(i));
                }
                this.a.f();
                this.c.a.c();
            }
        }

        public b k(String str, fu2 fu2Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, fu2Var)) == null) {
                return l(str, fu2Var, false);
            }
            return (b) invokeLL.objValue;
        }

        public b n(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
                pg3.d(this.a, this.b, i, i2);
                return this;
            }
            return (b) invokeII.objValue;
        }

        @Nullable
        public b l(String str, fu2 fu2Var, boolean z) {
            InterceptResult invokeLLZ;
            l32 l32Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, fu2Var, z)) == null) {
                if ("about".equals(str)) {
                    l32Var = i32.q3();
                } else if ("authority".equals(str)) {
                    l32Var = k32.f3();
                } else if ("pluginFunPage".equals(str)) {
                    l32Var = p32.Y2(fu2Var.c, fu2Var.b);
                } else if (e(str)) {
                    l32Var = t32.c3(fu2Var, str);
                } else if (TextUtils.equals(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, str)) {
                    l32Var = r32.V2();
                } else if ("normal".equals(str)) {
                    gu2.a aVar = new gu2.a();
                    aVar.d(fu2Var.a);
                    aVar.e(fu2Var.b);
                    aVar.b(fu2Var.c);
                    aVar.c(z);
                    aVar.g(fu2Var.e);
                    aVar.f(fu2Var.f);
                    l32Var = n32.M3(aVar.a());
                } else if ("running_info".equals(str)) {
                    l32Var = q32.Z2();
                } else {
                    l32Var = null;
                }
                if (l32Var == null) {
                    return null;
                }
                j(l32Var);
                return this;
            }
            return (b) invokeLLZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981243, "Lcom/baidu/tieba/o32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981243, "Lcom/baidu/tieba/o32;");
                return;
            }
        }
        e = pk1.a;
        HashSet hashSet = new HashSet();
        f = hashSet;
        g = R.anim.obfuscated_res_0x7f010022;
        h = R.anim.obfuscated_res_0x7f010025;
        i = R.anim.obfuscated_res_0x7f01001c;
        hashSet.add("adLanding");
        f.add("wxPay");
        f.add("default_webview");
        f.add("allianceLogin");
        f.add("web_mode");
        f.add("allianceChooseAddress");
        f.add("qrCodePay");
    }

    public o32(FragmentActivity fragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        this.a = fragmentActivity.l();
        this.b = new ArrayList<>();
        this.d = new CopyOnWriteArrayList();
    }

    public void g(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && aVar != null) {
            this.d.add(aVar);
        }
    }

    public b i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return new b(this, str);
        }
        return (b) invokeL.objValue;
    }

    public l32 j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.b.isEmpty() || i2 < 0 || i2 >= this.b.size()) {
                return null;
            }
            return this.b.get(i2);
        }
        return (l32) invokeI.objValue;
    }

    public void p(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, aVar) != null) || aVar == null) {
            return;
        }
        this.d.remove(aVar);
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new b(this, "");
        }
        return (b) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Nullable
    public l32 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return j(this.b.size() - 1);
        }
        return (l32) invokeV.objValue;
    }

    public n32 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                l32 l32Var = this.b.get(size);
                if (l32Var instanceof n32) {
                    return (n32) l32Var;
                }
            }
            return null;
        }
        return (n32) invokeV.objValue;
    }

    public n32 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b.isEmpty()) {
                return null;
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.b.get(i2).e2()) {
                    return (n32) this.b.get(i2);
                }
            }
            return null;
        }
        return (n32) invokeV.objValue;
    }

    @Nullable
    public <T extends l32> T n(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            if (cls != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    T t = (T) this.b.get(size);
                    if (t.getClass() == cls) {
                        return t;
                    }
                }
                return null;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }
}
