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
import com.baidu.tieba.xg4;
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
/* loaded from: classes5.dex */
public final class ng4 extends wg4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final vg4 a;
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

    /* loaded from: classes5.dex */
    public class a implements xg4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Fragment a;

        public a(ng4 ng4Var, Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng4Var, fragment};
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

        @Override // com.baidu.tieba.xg4.f
        public View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.V() : (View) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
        public final /* synthetic */ ng4 h;

        public b(ng4 ng4Var, View view2, Object obj, ArrayList arrayList, e eVar, boolean z, Fragment fragment, Fragment fragment2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng4Var, view2, obj, arrayList, eVar, Boolean.valueOf(z), fragment, fragment2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = ng4Var;
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
                    xg4.s(obj, this.c);
                    this.c.clear();
                    fh4 I = this.h.I(this.d, this.e, this.f);
                    xg4.v(this.b, this.d.d, I, this.c);
                    this.h.P(I, this.d);
                    this.h.t(this.d, this.f, this.g, this.e, I);
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ e b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ ng4 e;

        public c(ng4 ng4Var, View view2, e eVar, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng4Var, view2, eVar, Integer.valueOf(i), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ng4Var;
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fh4<String, String> a;
        public ArrayList<View> b;
        public xg4.e c;
        public View d;

        public e(ng4 ng4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new fh4<>();
            this.b = new ArrayList<>();
            this.c = new xg4.e();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948001486, "Lcom/baidu/tieba/ng4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948001486, "Lcom/baidu/tieba/ng4;");
                return;
            }
        }
        v = Build.VERSION.SDK_INT >= 21;
    }

    public ng4(vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vg4Var};
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
        this.a = vg4Var;
    }

    public static Object D(Fragment fragment, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            return xg4.j(z ? fragment.B() : fragment.t());
        }
        return invokeLZ.objValue;
    }

    public static Object E(Fragment fragment, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            return xg4.j(z ? fragment.D() : fragment.u());
        }
        return invokeLZ.objValue;
    }

    public static Object G(Fragment fragment, Fragment fragment2, boolean z) {
        InterceptResult invokeLLZ;
        Object E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, fragment, fragment2, z)) == null) {
            if (fragment == null || fragment2 == null) {
                return null;
            }
            if (z) {
                E = fragment2.F();
            } else {
                E = fragment.E();
            }
            return xg4.w(E);
        }
        return invokeLLZ.objValue;
    }

    public static fh4<String, View> L(ArrayList<String> arrayList, ArrayList<String> arrayList2, fh4<String, View> fh4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, arrayList, arrayList2, fh4Var)) == null) {
            if (fh4Var.isEmpty()) {
                return fh4Var;
            }
            fh4<String, View> fh4Var2 = new fh4<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view2 = fh4Var.get(arrayList.get(i));
                if (view2 != null) {
                    fh4Var2.put(arrayList2.get(i), view2);
                }
            }
            return fh4Var2;
        }
        return (fh4) invokeLLL.objValue;
    }

    public static void Q(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, sparseArray, fragment) == null) || fragment == null || (i = fragment.x) == 0 || fragment.m0() || !fragment.k0() || fragment.V() == null || sparseArray.get(i) != null) {
            return;
        }
        sparseArray.put(i, fragment);
    }

    public static void S(fh4<String, String> fh4Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, fh4Var, str, str2) == null) || str == null || str2 == null) {
            return;
        }
        for (int i = 0; i < fh4Var.size(); i++) {
            if (str.equals(fh4Var.k(i))) {
                fh4Var.j(i, str2);
                return;
            }
        }
        fh4Var.put(str, str2);
    }

    public static void U(e eVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, eVar, arrayList, arrayList2) == null) || arrayList == null) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            S(eVar.a, arrayList.get(i), arrayList2.get(i));
        }
    }

    public static Object u(Object obj, Fragment fragment, ArrayList<View> arrayList, fh4<String, View> fh4Var, View view2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, obj, fragment, arrayList, fh4Var, view2)) == null) ? obj != null ? xg4.g(obj, fragment.V(), arrayList, fh4Var, view2) : obj : invokeLLLLL.objValue;
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
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, i, obj) == null) || this.a.e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.a.e.size(); i2++) {
            Fragment fragment = this.a.e.get(i2);
            View view2 = fragment.I;
            if (view2 != null && fragment.H != null && fragment.x == i) {
                if (fragment.z) {
                    if (!eVar.b.contains(view2)) {
                        xg4.l(obj, fragment.I, true);
                        eVar.b.add(fragment.I);
                    }
                } else {
                    xg4.l(obj, view2, false);
                    eVar.b.remove(fragment.I);
                }
            }
        }
    }

    public final void C(View view2, e eVar, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, view2, eVar, i, obj) == null) {
            view2.getViewTreeObserver().addOnPreDrawListener(new c(this, view2, eVar, i, obj));
        }
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public final fh4<String, View> H(e eVar, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, eVar, fragment, z)) == null) {
            fh4<String, View> fh4Var = new fh4<>();
            View V = fragment.V();
            if (V == null || this.t == null) {
                return fh4Var;
            }
            xg4.m(fh4Var, V);
            if (z) {
                return L(this.t, this.u, fh4Var);
            }
            fh4Var.m(this.u);
            return fh4Var;
        }
        return (fh4) invokeLLZ.objValue;
    }

    public final fh4<String, View> I(e eVar, boolean z, Fragment fragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{eVar, Boolean.valueOf(z), fragment})) == null) {
            fh4<String, View> H = H(eVar, fragment, z);
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
        return (fh4) invokeCommon.objValue;
    }

    public e J(boolean z, e eVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), eVar, sparseArray, sparseArray2})) == null) {
            e eVar2 = null;
            if (vg4.x) {
                Log.v("FragmentManager", "popFromBackStack: " + this);
                ih4 ih4Var = new ih4("FragmentManager");
                PrintWriter printWriter = new PrintWriter(ih4Var);
                z(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                v(printWriter);
                v(ih4Var);
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
            int i = eVar != null ? 0 : this.j;
            int i2 = eVar != null ? 0 : this.i;
            for (d dVar = this.c; dVar != null; dVar = dVar.b) {
                int i3 = eVar != null ? 0 : dVar.g;
                int i4 = eVar != null ? 0 : dVar.h;
                switch (dVar.c) {
                    case 1:
                        Fragment fragment = dVar.d;
                        fragment.G = i4;
                        this.a.Z(fragment, vg4.d0(i2), i);
                        break;
                    case 2:
                        Fragment fragment2 = dVar.d;
                        if (fragment2 != null) {
                            fragment2.G = i4;
                            this.a.Z(fragment2, vg4.d0(i2), i);
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
                        this.a.k0(fragment5, vg4.d0(i2), i);
                        break;
                    case 5:
                        Fragment fragment6 = dVar.d;
                        fragment6.G = i4;
                        this.a.K(fragment6, vg4.d0(i2), i);
                        break;
                    case 6:
                        Fragment fragment7 = dVar.d;
                        fragment7.G = i3;
                        this.a.k(fragment7, vg4.d0(i2), i);
                        break;
                    case 7:
                        Fragment fragment8 = dVar.d;
                        fragment8.G = i3;
                        this.a.m(fragment8, vg4.d0(i2), i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar.c);
                }
            }
            if (z) {
                vg4 vg4Var = this.a;
                vg4Var.R(vg4Var.l, vg4.d0(i2), i, true);
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

    public final fh4<String, View> M(e eVar, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, fragment, z)) == null) {
            fh4<String, View> fh4Var = new fh4<>();
            if (this.t != null) {
                xg4.m(fh4Var, fragment.V());
                if (z) {
                    fh4Var.m(this.u);
                } else {
                    fh4Var = L(this.t, this.u, fh4Var);
                }
            }
            if (z) {
                SharedElementCallback sharedElementCallback = fragment.X;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.u, fh4Var);
                }
                N(eVar, fh4Var, false);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.Y;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.u, fh4Var);
                }
                T(eVar, fh4Var, false);
            }
            return fh4Var;
        }
        return (fh4) invokeLLZ.objValue;
    }

    public final void N(e eVar, fh4<String, View> fh4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, fh4Var, z) == null) {
            ArrayList<String> arrayList = this.u;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                String str = this.t.get(i);
                View view2 = fh4Var.get(this.u.get(i));
                if (view2 != null) {
                    String o = xg4.o(view2);
                    if (z) {
                        S(eVar.a, str, o);
                    } else {
                        S(eVar.a, o, str);
                    }
                }
            }
        }
    }

    public wg4 O(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048586, this, i, i2, i3, i4)) == null) {
            this.e = i;
            this.f = i2;
            this.g = i3;
            this.h = i4;
            return this;
        }
        return (wg4) invokeIIII.objValue;
    }

    public final void P(fh4<String, View> fh4Var, e eVar) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, fh4Var, eVar) == null) || this.u == null || fh4Var.isEmpty() || (view2 = fh4Var.get(this.u.get(0))) == null) {
            return;
        }
        eVar.c.a = view2;
    }

    public final void R(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, sparseArray, fragment) == null) || fragment == null || (i = fragment.x) == 0) {
            return;
        }
        sparseArray.put(i, fragment);
    }

    public final void T(e eVar, fh4<String, View> fh4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, eVar, fh4Var, z) == null) {
            int size = fh4Var.size();
            for (int i = 0; i < size; i++) {
                String h = fh4Var.h(i);
                String o = xg4.o(fh4Var.k(i));
                if (z) {
                    S(eVar.a, h, o);
                } else {
                    S(eVar.a, o, h);
                }
            }
        }
    }

    @Override // com.baidu.tieba.wg4
    public wg4 a(int i, Fragment fragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, fragment)) == null) {
            y(i, fragment, null, 1);
            return this;
        }
        return (wg4) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.wg4
    public wg4 b(int i, Fragment fragment, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048591, this, i, fragment, str)) == null) {
            y(i, fragment, str, 1);
            return this;
        }
        return (wg4) invokeILL.objValue;
    }

    @Override // com.baidu.tieba.wg4
    public wg4 c(Fragment fragment, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, fragment, str)) == null) {
            y(0, fragment, str, 1);
            return this;
        }
        return (wg4) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.wg4
    public wg4 d(String str) {
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
        return (wg4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wg4
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? w(false) : invokeV.intValue;
    }

    @Override // com.baidu.tieba.wg4
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? w(true) : invokeV.intValue;
    }

    @Override // com.baidu.tieba.wg4
    public wg4 g(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, fragment)) == null) {
            d dVar = new d();
            dVar.c = 4;
            dVar.d = fragment;
            o(dVar);
            return this;
        }
        return (wg4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wg4
    public wg4 h(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, fragment)) == null) {
            d dVar = new d();
            dVar.c = 3;
            dVar.d = fragment;
            o(dVar);
            return this;
        }
        return (wg4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wg4
    public wg4 i(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i, i2)) == null) {
            O(i, i2, 0, 0);
            return this;
        }
        return (wg4) invokeII.objValue;
    }

    @Override // com.baidu.tieba.wg4
    public wg4 j(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, fragment)) == null) {
            d dVar = new d();
            dVar.c = 5;
            dVar.d = fragment;
            o(dVar);
            return this;
        }
        return (wg4) invokeL.objValue;
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
            if (z2) {
                return eVar;
            }
            return null;
        }
        return (e) invokeLLZ.objValue;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && this.k) {
            if (vg4.x) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (d dVar = this.b; dVar != null; dVar = dVar.a) {
                Fragment fragment = dVar.d;
                if (fragment != null) {
                    fragment.r += i;
                    if (vg4.x) {
                        Log.v("FragmentManager", "Bump nesting of " + dVar.d + " to " + dVar.d.r);
                    }
                }
                ArrayList<Fragment> arrayList = dVar.i;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment2 = dVar.i.get(size);
                        fragment2.r += i;
                        if (vg4.x) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment2 + " to " + fragment2.r);
                        }
                    }
                }
            }
        }
    }

    public void r(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, sparseArray, sparseArray2) == null) && this.a.n.b()) {
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
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (vg4.x) {
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
            int i = eVar != null ? 0 : this.j;
            int i2 = eVar != null ? 0 : this.i;
            for (d dVar = this.b; dVar != null; dVar = dVar.a) {
                int i3 = eVar != null ? 0 : dVar.e;
                int i4 = eVar != null ? 0 : dVar.f;
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
                                if (vg4.x) {
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
                                            if (vg4.x) {
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
            vg4 vg4Var = this.a;
            vg4Var.R(vg4Var.l, i2, i, true);
            if (this.k) {
                this.a.g(this);
            }
        }
    }

    public final void s(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, sparseArray, sparseArray2) == null) && this.a.n.b()) {
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
    }

    public final void t(e eVar, Fragment fragment, Fragment fragment2, boolean z, fh4<String, View> fh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{eVar, fragment, fragment2, Boolean.valueOf(z), fh4Var}) == null) {
            SharedElementCallback sharedElementCallback = z ? fragment2.X : fragment.X;
            if (sharedElementCallback != null) {
                sharedElementCallback.onSharedElementEnd(new ArrayList(fh4Var.keySet()), new ArrayList(fh4Var.values()), null);
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

    public final void v(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public int w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            if (!this.n) {
                if (vg4.x) {
                    Log.v("FragmentManager", "Commit: " + this);
                    ih4 ih4Var = new ih4("FragmentManager");
                    PrintWriter printWriter = new PrintWriter(ih4Var);
                    z(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                    v(printWriter);
                    v(ih4Var);
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
        fh4<String, View> fh4Var;
        boolean z2;
        Object obj3;
        View view2;
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
                fh4<String, View> M = M(eVar, fragment2, z);
                if (M.isEmpty()) {
                    fh4Var = null;
                    obj = E;
                    obj2 = D;
                } else {
                    SharedElementCallback sharedElementCallback = z ? fragment2.X : fragment.X;
                    if (sharedElementCallback != null) {
                        sharedElementCallback.onSharedElementStart(new ArrayList(M.keySet()), new ArrayList(M.values()), null);
                    }
                    obj = E;
                    obj2 = D;
                    K(eVar, viewGroup, G, fragment, fragment2, z, arrayList);
                    obj4 = G;
                    fh4Var = M;
                }
            } else {
                obj = E;
                obj2 = D;
                fh4Var = null;
                obj4 = G;
            }
            if (obj2 == null && obj4 == null && obj == null) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Object u = u(obj, fragment2, arrayList2, fh4Var, eVar.d);
            ArrayList<String> arrayList3 = this.u;
            if (arrayList3 != null && fh4Var != null && (view2 = fh4Var.get(arrayList3.get(0))) != null) {
                if (u != null) {
                    xg4.t(u, view2);
                }
                if (obj4 != null) {
                    xg4.t(obj4, view2);
                }
            }
            a aVar = new a(this, fragment);
            ArrayList arrayList4 = new ArrayList();
            fh4 fh4Var2 = new fh4();
            if (fragment == null) {
                z2 = true;
            } else if (z) {
                z2 = fragment.o();
            } else {
                z2 = fragment.n();
            }
            Object r = xg4.r(obj2, u, obj4, z2);
            if (r != null) {
                obj3 = r;
                xg4.d(obj2, obj4, viewGroup, aVar, eVar.d, eVar.c, eVar.a, arrayList4, fh4Var, fh4Var2, arrayList);
                C(viewGroup, eVar, i, obj3);
                xg4.l(obj3, eVar.d, true);
                B(eVar, i, obj3);
                xg4.e(viewGroup, obj3);
                xg4.i(viewGroup, eVar.d, obj2, arrayList4, u, arrayList2, obj4, arrayList, obj3, eVar.b, fh4Var2);
            } else {
                obj3 = r;
            }
            return obj3 != null;
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

    public void z(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048612, this, str, fileDescriptor, printWriter, strArr) == null) {
            A(str, printWriter, true);
        }
    }
}
