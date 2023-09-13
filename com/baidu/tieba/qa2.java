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
import com.baidu.tieba.i13;
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
/* loaded from: classes7.dex */
public final class qa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static final Set<String> f;
    public static final int g;
    public static final int h;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public dp4 a;
    public ArrayList<na2> b;
    public Queue<Runnable> c;
    public final List<a> d;

    /* loaded from: classes7.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fp4 a;
        public String b;
        public final /* synthetic */ qa2 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ na2 a;
            public final /* synthetic */ na2 b;

            public a(b bVar, na2 na2Var, na2 na2Var2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, na2Var, na2Var2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = na2Var;
                this.b = na2Var2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    na2 na2Var = this.a;
                    if (na2Var != null && na2Var.Z()) {
                        this.a.m1(false);
                    }
                    na2 na2Var2 = this.a;
                    if (na2Var2 instanceof pa2) {
                        ((pa2) na2Var2).b4();
                    }
                    this.b.m1(true);
                }
            }
        }

        /* renamed from: com.baidu.tieba.qa2$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0463b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ na2 a;

            public RunnableC0463b(b bVar, na2 na2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, na2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = na2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                na2 na2Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (na2Var = this.a) != null) {
                    na2Var.m1(true);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ na2 a;

            public c(b bVar, na2 na2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, na2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = na2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                na2 na2Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (na2Var = this.a) != null) {
                    na2Var.m1(false);
                }
            }
        }

        public b(qa2 qa2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qa2Var;
            this.a = qa2Var.a.a();
            this.b = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.b)) {
                    pa2.W3(this.b);
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
                    if (!((na2) arrayList.get(size)).g2()) {
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
                this.c.c.offer(new RunnableC0463b(this, this.c.m()));
            }
        }

        public void c(na2 na2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, na2Var) == null) {
                fp4 fp4Var = this.a;
                fp4Var.g(na2Var);
                fp4Var.f();
                this.c.a.c();
            }
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                return qa2.f.contains(str);
            }
            return invokeL.booleanValue;
        }

        public void o(na2 na2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, na2Var) == null) {
                fp4 fp4Var = this.a;
                fp4Var.j(na2Var);
                fp4Var.f();
                this.c.a.c();
            }
        }

        public b q(h13 h13Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, h13Var)) == null) {
                pa2 l = this.c.l();
                if (l != null) {
                    l.X3(h13Var);
                    return this;
                }
                return k("normal", h13Var);
            }
            return (b) invokeL.objValue;
        }

        public final void s(na2 na2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, na2Var) == null) {
                this.c.c.offer(new a(this, this.c.m(), na2Var));
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
                    if (qa2.e) {
                        Log.d("SwanAppFragmentManager", "show fragment i " + i2 + " ,size: " + size);
                    }
                    this.a.j((Fragment) this.c.b.get(i2));
                    z = ((na2) this.c.b.get(i2)).E0;
                } else if (z) {
                    this.a.j((Fragment) this.c.b.get(i2));
                    z = ((na2) this.c.b.get(i2)).E0;
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
                            if (qa2.e) {
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
            na2 na2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                if (this.c.b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.c.b.clone();
                int size = arrayList.size();
                int i2 = size - i;
                if (i2 >= 0 && i > 0) {
                    na2Var = (na2) arrayList.get(i2);
                } else {
                    na2Var = null;
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
                this.c.c.offer(new c(this, na2Var));
                r();
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b j(na2 na2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, na2Var)) == null) {
                s(na2Var);
                this.a.b(R.id.obfuscated_res_0x7f090181, na2Var, "SwanAppFragment");
                this.c.b.add(na2Var);
                for (a aVar : this.c.d) {
                    if (aVar != null) {
                        aVar.a(na2Var);
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
                    this.a.h((na2) this.c.b.remove(i));
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public void p(List<na2> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
                for (int i = 0; i < list.size(); i++) {
                    this.a.j(list.get(i));
                }
                this.a.f();
                this.c.a.c();
            }
        }

        public b k(String str, h13 h13Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, h13Var)) == null) {
                return l(str, h13Var, false);
            }
            return (b) invokeLL.objValue;
        }

        public b n(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
                rn3.d(this.a, this.b, i, i2);
                return this;
            }
            return (b) invokeII.objValue;
        }

        @Nullable
        public b l(String str, h13 h13Var, boolean z) {
            InterceptResult invokeLLZ;
            na2 na2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, h13Var, z)) == null) {
                if ("about".equals(str)) {
                    na2Var = ka2.s3();
                } else if ("authority".equals(str)) {
                    na2Var = ma2.h3();
                } else if ("pluginFunPage".equals(str)) {
                    na2Var = ra2.a3(h13Var.c, h13Var.b);
                } else if (e(str)) {
                    na2Var = va2.e3(h13Var, str);
                } else if (TextUtils.equals(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, str)) {
                    na2Var = ta2.X2();
                } else if ("normal".equals(str)) {
                    i13.a aVar = new i13.a();
                    aVar.d(h13Var.a);
                    aVar.e(h13Var.b);
                    aVar.b(h13Var.c);
                    aVar.c(z);
                    aVar.g(h13Var.e);
                    aVar.f(h13Var.f);
                    na2Var = pa2.O3(aVar.a());
                } else if ("running_info".equals(str)) {
                    na2Var = sa2.b3();
                } else {
                    na2Var = null;
                }
                if (na2Var == null) {
                    return null;
                }
                j(na2Var);
                return this;
            }
            return (b) invokeLLZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948085031, "Lcom/baidu/tieba/qa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948085031, "Lcom/baidu/tieba/qa2;");
                return;
            }
        }
        e = rr1.a;
        HashSet hashSet = new HashSet();
        f = hashSet;
        g = R.anim.obfuscated_res_0x7f010023;
        h = R.anim.obfuscated_res_0x7f010026;
        i = R.anim.obfuscated_res_0x7f01001d;
        hashSet.add("adLanding");
        f.add("wxPay");
        f.add("default_webview");
        f.add("allianceLogin");
        f.add("web_mode");
        f.add("allianceChooseAddress");
        f.add("qrCodePay");
    }

    public qa2(FragmentActivity fragmentActivity) {
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
        this.a = fragmentActivity.k();
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

    public na2 j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.b.isEmpty() || i2 < 0 || i2 >= this.b.size()) {
                return null;
            }
            return this.b.get(i2);
        }
        return (na2) invokeI.objValue;
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
    public na2 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return j(this.b.size() - 1);
        }
        return (na2) invokeV.objValue;
    }

    public pa2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                na2 na2Var = this.b.get(size);
                if (na2Var instanceof pa2) {
                    return (pa2) na2Var;
                }
            }
            return null;
        }
        return (pa2) invokeV.objValue;
    }

    public pa2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b.isEmpty()) {
                return null;
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.b.get(i2).g2()) {
                    return (pa2) this.b.get(i2);
                }
            }
            return null;
        }
        return (pa2) invokeV.objValue;
    }

    @Nullable
    public <T extends na2> T n(Class<T> cls) {
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
