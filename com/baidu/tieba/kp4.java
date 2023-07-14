package com.baidu.tieba;

import android.app.SharedElementCallback;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tieba.up4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class kp4 extends tp4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final sp4 a;
    public d b;
    public d c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public String m;
    public boolean n;
    public int o;
    public int p;
    public CharSequence q;
    public int r;
    public CharSequence s;
    public ArrayList<String> t;
    public ArrayList<String> u;

    /* loaded from: classes6.dex */
    public class a implements up4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Fragment a;

        public a(kp4 kp4Var, Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp4Var, fragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fragment;
        }

        @Override // com.baidu.tieba.up4.f
        public View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.b0();
            }
            return (View) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ e d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ Fragment f;
        public final /* synthetic */ Fragment g;
        public final /* synthetic */ kp4 h;

        public b(kp4 kp4Var, View view2, Object obj, ArrayList arrayList, e eVar, boolean z, Fragment fragment, Fragment fragment2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp4Var, view2, obj, arrayList, eVar, Boolean.valueOf(z), fragment, fragment2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = kp4Var;
            this.a = view2;
            this.b = obj;
            this.c = arrayList;
            this.d = eVar;
            this.e = z;
            this.f = fragment;
            this.g = fragment2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                Object obj = this.b;
                if (obj != null) {
                    up4.s(obj, this.c);
                    this.c.clear();
                    cq4 I = this.h.I(this.d, this.e, this.f);
                    up4.v(this.b, this.d.d, I, this.c);
                    this.h.P(I, this.d);
                    this.h.t(this.d, this.f, this.g, this.e, I);
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ e b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ kp4 e;

        public c(kp4 kp4Var, View view2, e eVar, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp4Var, view2, eVar, Integer.valueOf(i), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = kp4Var;
            this.a = view2;
            this.b = eVar;
            this.c = i;
            this.d = obj;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.e.B(this.b, this.c, this.d);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;
        public d b;
        public int c;
        public Fragment d;
        public int e;
        public int f;
        public int g;
        public int h;
        public ArrayList<Fragment> i;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public cq4<String, String> a;
        public ArrayList<View> b;
        public up4.e c;
        public View d;

        public e(kp4 kp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new cq4<>();
            this.b = new ArrayList<>();
            this.c = new up4.e();
        }
    }

    static {
        InterceptResult invokeClinit;
        boolean z;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947920762, "Lcom/baidu/tieba/kp4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947920762, "Lcom/baidu/tieba/kp4;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            z = true;
        } else {
            z = false;
        }
        v = z;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tp4
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return w(false);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tp4
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return w(true);
        }
        return invokeV.intValue;
    }

    public kp4(sp4 sp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sp4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = true;
        this.o = -1;
        this.a = sp4Var;
    }

    public void o(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dVar) == null) {
            if (this.b == null) {
                this.c = dVar;
                this.b = dVar;
            } else {
                d dVar2 = this.c;
                dVar.b = dVar2;
                dVar2.a = dVar;
                this.c = dVar;
            }
            dVar.e = this.e;
            dVar.f = this.f;
            dVar.g = this.g;
            dVar.h = this.h;
            this.d++;
        }
    }

    public static Object D(Fragment fragment, boolean z) {
        InterceptResult invokeLZ;
        Object r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            if (z) {
                r = fragment.D();
            } else {
                r = fragment.r();
            }
            return up4.j(r);
        }
        return invokeLZ.objValue;
    }

    public static Object E(Fragment fragment, boolean z) {
        InterceptResult invokeLZ;
        Object t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            if (z) {
                t = fragment.E();
            } else {
                t = fragment.t();
            }
            return up4.j(t);
        }
        return invokeLZ.objValue;
    }

    public final void P(cq4<String, View> cq4Var, e eVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, cq4Var, eVar) == null) && this.u != null && !cq4Var.isEmpty() && (view2 = cq4Var.get(this.u.get(0))) != null) {
            eVar.c.a = view2;
        }
    }

    public final void R(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, sparseArray, fragment) == null) && fragment != null && (i = fragment.x) != 0) {
            sparseArray.put(i, fragment);
        }
    }

    @Override // com.baidu.tieba.tp4
    public tp4 a(int i, Fragment fragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, fragment)) == null) {
            y(i, fragment, null, 1);
            return this;
        }
        return (tp4) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.tp4
    public tp4 c(Fragment fragment, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, fragment, str)) == null) {
            y(0, fragment, str, 1);
            return this;
        }
        return (tp4) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tp4
    public tp4 i(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i, i2)) == null) {
            O(i, i2, 0, 0);
            return this;
        }
        return (tp4) invokeII.objValue;
    }

    public static Object G(Fragment fragment, Fragment fragment2, boolean z) {
        InterceptResult invokeLLZ;
        Object F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, fragment, fragment2, z)) == null) {
            if (fragment != null && fragment2 != null) {
                if (z) {
                    F = fragment2.G();
                } else {
                    F = fragment.F();
                }
                return up4.w(F);
            }
            return null;
        }
        return invokeLLZ.objValue;
    }

    public static void S(cq4<String, String> cq4Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65543, null, cq4Var, str, str2) == null) && str != null && str2 != null) {
            for (int i = 0; i < cq4Var.size(); i++) {
                if (str.equals(cq4Var.k(i))) {
                    cq4Var.j(i, str2);
                    return;
                }
            }
            cq4Var.put(str, str2);
        }
    }

    public static void U(e eVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65544, null, eVar, arrayList, arrayList2) == null) && arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                S(eVar.a, arrayList.get(i), arrayList2.get(i));
            }
        }
    }

    @Override // com.baidu.tieba.tp4
    public tp4 b(int i, Fragment fragment, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048591, this, i, fragment, str)) == null) {
            y(i, fragment, str, 1);
            return this;
        }
        return (tp4) invokeILL.objValue;
    }

    public static cq4<String, View> L(ArrayList<String> arrayList, ArrayList<String> arrayList2, cq4<String, View> cq4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, arrayList, arrayList2, cq4Var)) == null) {
            if (cq4Var.isEmpty()) {
                return cq4Var;
            }
            cq4<String, View> cq4Var2 = new cq4<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view2 = cq4Var.get(arrayList.get(i));
                if (view2 != null) {
                    cq4Var2.put(arrayList2.get(i), view2);
                }
            }
            return cq4Var2;
        }
        return (cq4) invokeLLL.objValue;
    }

    public final cq4<String, View> H(e eVar, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, eVar, fragment, z)) == null) {
            cq4<String, View> cq4Var = new cq4<>();
            View b0 = fragment.b0();
            if (b0 != null && this.t != null) {
                up4.m(cq4Var, b0);
                if (z) {
                    return L(this.t, this.u, cq4Var);
                }
                cq4Var.m(this.u);
                return cq4Var;
            }
            return cq4Var;
        }
        return (cq4) invokeLLZ.objValue;
    }

    public final void T(e eVar, cq4<String, View> cq4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, eVar, cq4Var, z) == null) {
            int size = cq4Var.size();
            for (int i = 0; i < size; i++) {
                String h = cq4Var.h(i);
                String o = up4.o(cq4Var.k(i));
                if (z) {
                    S(eVar.a, h, o);
                } else {
                    S(eVar.a, o, h);
                }
            }
        }
    }

    public static void Q(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, sparseArray, fragment) == null) && fragment != null && (i = fragment.x) != 0 && !fragment.n0() && fragment.l0() && fragment.b0() != null && sparseArray.get(i) == null) {
            sparseArray.put(i, fragment);
        }
    }

    public final void C(View view2, e eVar, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, view2, eVar, i, obj) == null) {
            view2.getViewTreeObserver().addOnPreDrawListener(new c(this, view2, eVar, i, obj));
        }
    }

    public tp4 O(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048586, this, i, i2, i3, i4)) == null) {
            this.e = i;
            this.f = i2;
            this.g = i3;
            this.h = i4;
            return this;
        }
        return (tp4) invokeIIII.objValue;
    }

    public void z(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048612, this, str, fileDescriptor, printWriter, strArr) == null) {
            A(str, printWriter, true);
        }
    }

    public static Object u(Object obj, Fragment fragment, ArrayList<View> arrayList, cq4<String, View> cq4Var, View view2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, obj, fragment, arrayList, cq4Var, view2)) == null) {
            if (obj != null) {
                return up4.g(obj, fragment.b0(), arrayList, cq4Var, view2);
            }
            return obj;
        }
        return invokeLLLLL.objValue;
    }

    public void A(String str, PrintWriter printWriter, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, printWriter, z) == null) {
            if (z) {
                printWriter.print(str);
                printWriter.print("mName=");
                printWriter.print(this.m);
                printWriter.print(" mIndex=");
                printWriter.print(this.o);
                printWriter.print(" mCommitted=");
                printWriter.println(this.n);
                if (this.i != 0) {
                    printWriter.print(str);
                    printWriter.print("mTransition=#");
                    printWriter.print(Integer.toHexString(this.i));
                    printWriter.print(" mTransitionStyle=#");
                    printWriter.println(Integer.toHexString(this.j));
                }
                if (this.e != 0 || this.f != 0) {
                    printWriter.print(str);
                    printWriter.print("mEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.e));
                    printWriter.print(" mExitAnim=#");
                    printWriter.println(Integer.toHexString(this.f));
                }
                if (this.g != 0 || this.h != 0) {
                    printWriter.print(str);
                    printWriter.print("mPopEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.g));
                    printWriter.print(" mPopExitAnim=#");
                    printWriter.println(Integer.toHexString(this.h));
                }
                if (this.p != 0 || this.q != null) {
                    printWriter.print(str);
                    printWriter.print("mBreadCrumbTitleRes=#");
                    printWriter.print(Integer.toHexString(this.p));
                    printWriter.print(" mBreadCrumbTitleText=");
                    printWriter.println(this.q);
                }
                if (this.r != 0 || this.s != null) {
                    printWriter.print(str);
                    printWriter.print("mBreadCrumbShortTitleRes=#");
                    printWriter.print(Integer.toHexString(this.r));
                    printWriter.print(" mBreadCrumbShortTitleText=");
                    printWriter.println(this.s);
                }
            }
            if (this.b != null) {
                printWriter.print(str);
                printWriter.println("Operations:");
                String str3 = str + "    ";
                d dVar = this.b;
                int i = 0;
                while (dVar != null) {
                    switch (dVar.c) {
                        case 0:
                            str2 = "NULL";
                            break;
                        case 1:
                            str2 = "ADD";
                            break;
                        case 2:
                            str2 = "REPLACE";
                            break;
                        case 3:
                            str2 = "REMOVE";
                            break;
                        case 4:
                            str2 = "HIDE";
                            break;
                        case 5:
                            str2 = "SHOW";
                            break;
                        case 6:
                            str2 = "DETACH";
                            break;
                        case 7:
                            str2 = "ATTACH";
                            break;
                        default:
                            str2 = "cmd=" + dVar.c;
                            break;
                    }
                    printWriter.print(str);
                    printWriter.print("  Op #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.print(str2);
                    printWriter.print(" ");
                    printWriter.println(dVar.d);
                    if (z) {
                        if (dVar.e != 0 || dVar.f != 0) {
                            printWriter.print(str);
                            printWriter.print("enterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.e));
                            printWriter.print(" exitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f));
                        }
                        if (dVar.g != 0 || dVar.h != 0) {
                            printWriter.print(str);
                            printWriter.print("popEnterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.g));
                            printWriter.print(" popExitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.h));
                        }
                    }
                    ArrayList<Fragment> arrayList = dVar.i;
                    if (arrayList != null && arrayList.size() > 0) {
                        for (int i2 = 0; i2 < dVar.i.size(); i2++) {
                            printWriter.print(str3);
                            if (dVar.i.size() == 1) {
                                printWriter.print("Removed: ");
                            } else {
                                if (i2 == 0) {
                                    printWriter.println("Removed:");
                                }
                                printWriter.print(str3);
                                printWriter.print("  #");
                                printWriter.print(i2);
                                printWriter.print(": ");
                            }
                            printWriter.println(dVar.i.get(i2));
                        }
                    }
                    dVar = dVar.a;
                    i++;
                }
            }
        }
    }

    public final void B(e eVar, int i, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, i, obj) == null) && this.a.e != null) {
            for (int i2 = 0; i2 < this.a.e.size(); i2++) {
                Fragment fragment = this.a.e.get(i2);
                View view2 = fragment.I;
                if (view2 != null && fragment.H != null && fragment.x == i) {
                    if (fragment.z) {
                        if (!eVar.b.contains(view2)) {
                            up4.l(obj, fragment.I, true);
                            eVar.b.add(fragment.I);
                        }
                    } else {
                        up4.l(obj, view2, false);
                        eVar.b.remove(fragment.I);
                    }
                }
            }
        }
    }

    public final cq4<String, View> I(e eVar, boolean z, Fragment fragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{eVar, Boolean.valueOf(z), fragment})) == null) {
            cq4<String, View> H = H(eVar, fragment, z);
            if (z) {
                SharedElementCallback sharedElementCallback = fragment.Y;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.u, H);
                }
                N(eVar, H, true);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.X;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.u, H);
                }
                T(eVar, H, true);
            }
            return H;
        }
        return (cq4) invokeCommon.objValue;
    }

    public final cq4<String, View> M(e eVar, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, fragment, z)) == null) {
            cq4<String, View> cq4Var = new cq4<>();
            if (this.t != null) {
                up4.m(cq4Var, fragment.b0());
                if (z) {
                    cq4Var.m(this.u);
                } else {
                    cq4Var = L(this.t, this.u, cq4Var);
                }
            }
            if (z) {
                SharedElementCallback sharedElementCallback = fragment.X;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.u, cq4Var);
                }
                N(eVar, cq4Var, false);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.Y;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.u, cq4Var);
                }
                T(eVar, cq4Var, false);
            }
            return cq4Var;
        }
        return (cq4) invokeLLZ.objValue;
    }

    public final void N(e eVar, cq4<String, View> cq4Var, boolean z) {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, cq4Var, z) == null) {
            ArrayList<String> arrayList = this.u;
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            for (int i = 0; i < size; i++) {
                String str = this.t.get(i);
                View view2 = cq4Var.get(this.u.get(i));
                if (view2 != null) {
                    String o = up4.o(view2);
                    if (z) {
                        S(eVar.a, str, o);
                    } else {
                        S(eVar.a, o, str);
                    }
                }
            }
        }
    }

    public e J(boolean z, e eVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), eVar, sparseArray, sparseArray2})) == null) {
            e eVar2 = null;
            if (sp4.x) {
                Log.v("FragmentManager", "popFromBackStack: " + this);
                fq4 fq4Var = new fq4("FragmentManager");
                PrintWriter printWriter = new PrintWriter(fq4Var);
                z(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                v(printWriter);
                v(fq4Var);
            }
            if (v) {
                if (eVar == null) {
                    if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                        eVar = p(sparseArray, sparseArray2, true);
                    }
                } else if (!z) {
                    U(eVar, this.u, this.t);
                }
            }
            q(-1);
            if (eVar != null) {
                i = 0;
            } else {
                i = this.j;
            }
            if (eVar != null) {
                i2 = 0;
            } else {
                i2 = this.i;
            }
            for (d dVar = this.c; dVar != null; dVar = dVar.b) {
                if (eVar != null) {
                    i3 = 0;
                } else {
                    i3 = dVar.g;
                }
                if (eVar != null) {
                    i4 = 0;
                } else {
                    i4 = dVar.h;
                }
                switch (dVar.c) {
                    case 1:
                        Fragment fragment = dVar.d;
                        fragment.G = i4;
                        this.a.Z(fragment, sp4.d0(i2), i);
                        break;
                    case 2:
                        Fragment fragment2 = dVar.d;
                        if (fragment2 != null) {
                            fragment2.G = i4;
                            this.a.Z(fragment2, sp4.d0(i2), i);
                        }
                        if (dVar.i != null) {
                            for (int i5 = 0; i5 < dVar.i.size(); i5++) {
                                Fragment fragment3 = dVar.i.get(i5);
                                fragment3.G = i3;
                                this.a.h(fragment3, false);
                            }
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        Fragment fragment4 = dVar.d;
                        fragment4.G = i3;
                        this.a.h(fragment4, false);
                        break;
                    case 4:
                        Fragment fragment5 = dVar.d;
                        fragment5.G = i3;
                        this.a.k0(fragment5, sp4.d0(i2), i);
                        break;
                    case 5:
                        Fragment fragment6 = dVar.d;
                        fragment6.G = i4;
                        this.a.K(fragment6, sp4.d0(i2), i);
                        break;
                    case 6:
                        Fragment fragment7 = dVar.d;
                        fragment7.G = i3;
                        this.a.k(fragment7, sp4.d0(i2), i);
                        break;
                    case 7:
                        Fragment fragment8 = dVar.d;
                        fragment8.G = i3;
                        this.a.m(fragment8, sp4.d0(i2), i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar.c);
                }
            }
            if (z) {
                sp4 sp4Var = this.a;
                sp4Var.R(sp4Var.l, sp4.d0(i2), i, true);
            } else {
                eVar2 = eVar;
            }
            int i6 = this.o;
            if (i6 >= 0) {
                this.a.H(i6);
                this.o = -1;
            }
            return eVar2;
        }
        return (e) invokeCommon.objValue;
    }

    public final void K(e eVar, View view2, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{eVar, view2, obj, fragment, fragment2, Boolean.valueOf(z), arrayList}) == null) {
            view2.getViewTreeObserver().addOnPreDrawListener(new b(this, view2, obj, arrayList, eVar, z, fragment, fragment2));
        }
    }

    @Override // com.baidu.tieba.tp4
    public tp4 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (this.l) {
                this.k = true;
                this.m = str;
                return this;
            }
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        return (tp4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tp4
    public tp4 g(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, fragment)) == null) {
            d dVar = new d();
            dVar.c = 4;
            dVar.d = fragment;
            o(dVar);
            return this;
        }
        return (tp4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tp4
    public tp4 h(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, fragment)) == null) {
            d dVar = new d();
            dVar.c = 3;
            dVar.d = fragment;
            o(dVar);
            return this;
        }
        return (tp4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tp4
    public tp4 j(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, fragment)) == null) {
            d dVar = new d();
            dVar.c = 5;
            dVar.d = fragment;
            o(dVar);
            return this;
        }
        return (tp4) invokeL.objValue;
    }

    public final void v(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final e p(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048601, this, sparseArray, sparseArray2, z)) == null) {
            e eVar = new e(this);
            eVar.d = new View(this.a.m.getContext());
            boolean z2 = false;
            for (int i = 0; i < sparseArray.size(); i++) {
                if (x(sparseArray.keyAt(i), eVar, z, sparseArray, sparseArray2)) {
                    z2 = true;
                }
            }
            for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
                int keyAt = sparseArray2.keyAt(i2);
                if (sparseArray.get(keyAt) == null && x(keyAt, eVar, z, sparseArray, sparseArray2)) {
                    z2 = true;
                }
            }
            if (!z2) {
                return null;
            }
            return eVar;
        }
        return (e) invokeLLZ.objValue;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048602, this, i) != null) || !this.k) {
            return;
        }
        if (sp4.x) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
        }
        for (d dVar = this.b; dVar != null; dVar = dVar.a) {
            Fragment fragment = dVar.d;
            if (fragment != null) {
                fragment.r += i;
                if (sp4.x) {
                    Log.v("FragmentManager", "Bump nesting of " + dVar.d + " to " + dVar.d.r);
                }
            }
            ArrayList<Fragment> arrayList = dVar.i;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = dVar.i.get(size);
                    fragment2.r += i;
                    if (sp4.x) {
                        Log.v("FragmentManager", "Bump nesting of " + fragment2 + " to " + fragment2.r);
                    }
                }
            }
        }
    }

    public void r(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048603, this, sparseArray, sparseArray2) != null) || !this.a.n.b()) {
            return;
        }
        for (d dVar = this.b; dVar != null; dVar = dVar.a) {
            switch (dVar.c) {
                case 1:
                    Q(sparseArray, dVar.d);
                    break;
                case 2:
                    ArrayList<Fragment> arrayList = dVar.i;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            R(sparseArray2, dVar.i.get(size));
                        }
                    }
                    Q(sparseArray, dVar.d);
                    break;
                case 3:
                    R(sparseArray2, dVar.d);
                    break;
                case 4:
                    R(sparseArray2, dVar.d);
                    break;
                case 5:
                    Q(sparseArray, dVar.d);
                    break;
                case 6:
                    R(sparseArray2, dVar.d);
                    break;
                case 7:
                    Q(sparseArray, dVar.d);
                    break;
            }
        }
    }

    public final void s(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048605, this, sparseArray, sparseArray2) != null) || !this.a.n.b()) {
            return;
        }
        for (d dVar = this.b; dVar != null; dVar = dVar.a) {
            switch (dVar.c) {
                case 1:
                    R(sparseArray2, dVar.d);
                    break;
                case 2:
                    Fragment fragment = dVar.d;
                    if (this.a.e != null) {
                        for (int i = 0; i < this.a.e.size(); i++) {
                            Fragment fragment2 = this.a.e.get(i);
                            if (fragment == null || fragment2.x == fragment.x) {
                                if (fragment2 == fragment) {
                                    fragment = null;
                                } else {
                                    Q(sparseArray, fragment2);
                                }
                            }
                        }
                    }
                    R(sparseArray2, fragment);
                    break;
                case 3:
                    Q(sparseArray, dVar.d);
                    break;
                case 4:
                    Q(sparseArray, dVar.d);
                    break;
                case 5:
                    R(sparseArray2, dVar.d);
                    break;
                case 6:
                    Q(sparseArray, dVar.d);
                    break;
                case 7:
                    R(sparseArray2, dVar.d);
                    break;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (sp4.x) {
                Log.v("FragmentManager", "Run: " + this);
            }
            if (this.k && this.o < 0) {
                throw new IllegalStateException("addToBackStack() called after commit()");
            }
            q(1);
            if (v) {
                SparseArray<Fragment> sparseArray = new SparseArray<>();
                SparseArray<Fragment> sparseArray2 = new SparseArray<>();
                s(sparseArray, sparseArray2);
                eVar = p(sparseArray, sparseArray2, false);
            } else {
                eVar = null;
            }
            if (eVar != null) {
                i = 0;
            } else {
                i = this.j;
            }
            if (eVar != null) {
                i2 = 0;
            } else {
                i2 = this.i;
            }
            for (d dVar = this.b; dVar != null; dVar = dVar.a) {
                if (eVar != null) {
                    i3 = 0;
                } else {
                    i3 = dVar.e;
                }
                if (eVar != null) {
                    i4 = 0;
                } else {
                    i4 = dVar.f;
                }
                switch (dVar.c) {
                    case 1:
                        Fragment fragment = dVar.d;
                        fragment.G = i3;
                        this.a.h(fragment, false);
                        continue;
                    case 2:
                        Fragment fragment2 = dVar.d;
                        int i5 = fragment2.x;
                        if (this.a.e != null) {
                            for (int i6 = 0; i6 < this.a.e.size(); i6++) {
                                Fragment fragment3 = this.a.e.get(i6);
                                if (sp4.x) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3);
                                }
                                if (fragment3.x == i5) {
                                    if (fragment3 == fragment2) {
                                        dVar.d = null;
                                        fragment2 = null;
                                    } else {
                                        if (dVar.i == null) {
                                            dVar.i = new ArrayList<>();
                                        }
                                        dVar.i.add(fragment3);
                                        fragment3.G = i4;
                                        if (this.k) {
                                            fragment3.r++;
                                            if (sp4.x) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment3 + " to " + fragment3.r);
                                            }
                                        }
                                        this.a.Z(fragment3, i2, i);
                                    }
                                }
                            }
                        }
                        if (fragment2 != null) {
                            fragment2.G = i3;
                            this.a.h(fragment2, false);
                            continue;
                        }
                        break;
                    case 3:
                        Fragment fragment4 = dVar.d;
                        fragment4.G = i4;
                        this.a.Z(fragment4, i2, i);
                        break;
                    case 4:
                        Fragment fragment5 = dVar.d;
                        fragment5.G = i4;
                        this.a.K(fragment5, i2, i);
                        break;
                    case 5:
                        Fragment fragment6 = dVar.d;
                        fragment6.G = i3;
                        this.a.k0(fragment6, i2, i);
                        break;
                    case 6:
                        Fragment fragment7 = dVar.d;
                        fragment7.G = i4;
                        this.a.m(fragment7, i2, i);
                        break;
                    case 7:
                        Fragment fragment8 = dVar.d;
                        fragment8.G = i3;
                        this.a.k(fragment8, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar.c);
                }
            }
            sp4 sp4Var = this.a;
            sp4Var.R(sp4Var.l, i2, i, true);
            if (this.k) {
                this.a.g(this);
            }
        }
    }

    public final void t(e eVar, Fragment fragment, Fragment fragment2, boolean z, cq4<String, View> cq4Var) {
        SharedElementCallback sharedElementCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{eVar, fragment, fragment2, Boolean.valueOf(z), cq4Var}) == null) {
            if (z) {
                sharedElementCallback = fragment2.X;
            } else {
                sharedElementCallback = fragment.X;
            }
            if (sharedElementCallback != null) {
                sharedElementCallback.onSharedElementEnd(new ArrayList(cq4Var.keySet()), new ArrayList(cq4Var.values()), null);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("BackStackEntry{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this.o >= 0) {
                sb.append(" #");
                sb.append(this.o);
            }
            if (this.m != null) {
                sb.append(" ");
                sb.append(this.m);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public int w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            if (!this.n) {
                if (sp4.x) {
                    Log.v("FragmentManager", "Commit: " + this);
                    fq4 fq4Var = new fq4("FragmentManager");
                    PrintWriter printWriter = new PrintWriter(fq4Var);
                    z(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                    v(printWriter);
                    v(fq4Var);
                }
                this.n = true;
                if (this.k) {
                    this.o = this.a.i(this);
                } else {
                    this.o = -1;
                }
                this.a.D(this, z);
                return this.o;
            }
            throw new IllegalStateException("commit already called");
        }
        return invokeZ.intValue;
    }

    public final boolean x(int i, e eVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Object obj;
        Object obj2;
        cq4<String, View> cq4Var;
        boolean z2;
        Object obj3;
        View view2;
        SharedElementCallback sharedElementCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i), eVar, Boolean.valueOf(z), sparseArray, sparseArray2})) == null) {
            ViewGroup viewGroup = (ViewGroup) this.a.n.a(i);
            if (viewGroup == null) {
                return false;
            }
            Fragment fragment = sparseArray2.get(i);
            Fragment fragment2 = sparseArray.get(i);
            Object D = D(fragment, z);
            Object G = G(fragment, fragment2, z);
            Object E = E(fragment2, z);
            ArrayList<View> arrayList = new ArrayList<>();
            Object obj4 = null;
            if (G != null) {
                cq4<String, View> M = M(eVar, fragment2, z);
                if (M.isEmpty()) {
                    cq4Var = null;
                    obj = E;
                    obj2 = D;
                } else {
                    if (z) {
                        sharedElementCallback = fragment2.X;
                    } else {
                        sharedElementCallback = fragment.X;
                    }
                    if (sharedElementCallback != null) {
                        sharedElementCallback.onSharedElementStart(new ArrayList(M.keySet()), new ArrayList(M.values()), null);
                    }
                    obj = E;
                    obj2 = D;
                    K(eVar, viewGroup, G, fragment, fragment2, z, arrayList);
                    obj4 = G;
                    cq4Var = M;
                }
            } else {
                obj = E;
                obj2 = D;
                cq4Var = null;
                obj4 = G;
            }
            if (obj2 == null && obj4 == null && obj == null) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Object u = u(obj, fragment2, arrayList2, cq4Var, eVar.d);
            ArrayList<String> arrayList3 = this.u;
            if (arrayList3 != null && cq4Var != null && (view2 = cq4Var.get(arrayList3.get(0))) != null) {
                if (u != null) {
                    up4.t(u, view2);
                }
                if (obj4 != null) {
                    up4.t(obj4, view2);
                }
            }
            a aVar = new a(this, fragment);
            ArrayList arrayList4 = new ArrayList();
            cq4 cq4Var2 = new cq4();
            if (fragment != null) {
                if (z) {
                    z2 = fragment.n();
                } else {
                    z2 = fragment.m();
                }
            } else {
                z2 = true;
            }
            Object r = up4.r(obj2, u, obj4, z2);
            if (r != null) {
                obj3 = r;
                up4.d(obj2, obj4, viewGroup, aVar, eVar.d, eVar.c, eVar.a, arrayList4, cq4Var, cq4Var2, arrayList);
                C(viewGroup, eVar, i, obj3);
                up4.l(obj3, eVar.d, true);
                B(eVar, i, obj3);
                up4.e(viewGroup, obj3);
                up4.i(viewGroup, eVar.d, obj2, arrayList4, u, arrayList2, obj4, arrayList, obj3, eVar.b, cq4Var2);
            } else {
                obj3 = r;
            }
            if (obj3 != null) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void y(int i, Fragment fragment, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i), fragment, str, Integer.valueOf(i2)}) == null) {
            fragment.s = this.a;
            if (str != null) {
                String str2 = fragment.y;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.y + " now " + str);
                }
                fragment.y = str;
            }
            if (i != 0) {
                int i3 = fragment.w;
                if (i3 != 0 && i3 != i) {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.w + " now " + i);
                }
                fragment.w = i;
                fragment.x = i;
            }
            d dVar = new d();
            dVar.c = i2;
            dVar.d = fragment;
            o(dVar);
        }
    }
}
