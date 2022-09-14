package com.baidu.tieba;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentStateManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.BackStackState;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentManagerState;
import com.baidu.swan.support.v4.app.FragmentState;
import com.baidu.swan.support.v4.app.SuperNotCalledException;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.ng4;
import com.baidu.tieba.ug4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public final class vg4 extends ug4 implements qh4 {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator A;
    public static boolean x;
    public static final boolean y;
    public static final Interpolator z;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Runnable> a;
    public Runnable[] b;
    public boolean c;
    public ArrayList<Fragment> d;
    public ArrayList<Fragment> e;
    public ArrayList<Integer> f;
    public ArrayList<ng4> g;
    public ArrayList<Fragment> h;
    public ArrayList<ng4> i;
    public ArrayList<Integer> j;
    public ArrayList<ug4.a> k;
    public int l;
    public tg4 m;
    public rg4 n;
    public Fragment o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;
    public boolean t;
    public Bundle u;
    public SparseArray<Parcelable> v;
    public Runnable w;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vg4 a;

        public a(vg4 vg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vg4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ vg4 c;

        public b(vg4 vg4Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg4Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vg4Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vg4 vg4Var = this.c;
                vg4Var.X(vg4Var.m.h(), null, this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ vg4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(vg4 vg4Var, View view2, Animation animation, Fragment fragment) {
            super(view2, animation);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg4Var, view2, animation, fragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (Animation) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vg4Var;
            this.c = fragment;
        }

        @Override // com.baidu.tieba.vg4.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                super.onAnimationEnd(animation);
                Fragment fragment = this.c;
                if (fragment.b != null) {
                    fragment.b = null;
                    this.d.U(fragment, fragment.c, 0, 0, false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public View b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    rh4.d(this.a.b, 2, null);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    rh4.d(this.a.b, 0, null);
                }
            }
        }

        public d(View view2, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            if (view2 == null || animation == null) {
                return;
            }
            this.b = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.a) {
                this.b.post(new b(this));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                boolean j0 = vg4.j0(this.b, animation);
                this.a = j0;
                if (j0) {
                    this.b.post(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static final int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-347298715, "Lcom/baidu/tieba/vg4$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-347298715, "Lcom/baidu/tieba/vg4$e;");
                    return;
                }
            }
            a = new int[]{16842755, 16842960, 16842961};
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948239814, "Lcom/baidu/tieba/vg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948239814, "Lcom/baidu/tieba/vg4;");
                return;
            }
        }
        y = Build.VERSION.SDK_INT >= 11;
        z = new DecelerateInterpolator(2.5f);
        A = new DecelerateInterpolator(1.5f);
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    public vg4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.u = null;
        this.v = null;
        this.w = new a(this);
    }

    public static Animation N(Context context, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
            alphaAnimation.setInterpolator(A);
            alphaAnimation.setDuration(220L);
            return alphaAnimation;
        }
        return (Animation) invokeCommon.objValue;
    }

    public static Animation P(Context context, float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            AnimationSet animationSet = new AnimationSet(false);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setInterpolator(z);
            scaleAnimation.setDuration(220L);
            animationSet.addAnimation(scaleAnimation);
            AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
            alphaAnimation.setInterpolator(A);
            alphaAnimation.setDuration(220L);
            animationSet.addAnimation(alphaAnimation);
            return animationSet;
        }
        return (Animation) invokeCommon.objValue;
    }

    public static boolean Q(Animation animation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, animation)) == null) {
            if (animation instanceof AlphaAnimation) {
                return true;
            }
            if (animation instanceof AnimationSet) {
                List<Animation> animations = ((AnimationSet) animation).getAnimations();
                for (int i = 0; i < animations.size(); i++) {
                    if (animations.get(i) instanceof AlphaAnimation) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int d0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (i != 4097) {
                if (i != 4099) {
                    return i != 8194 ? 0 : 4097;
                }
                return 4099;
            }
            return 8194;
        }
        return invokeI.intValue;
    }

    public static boolean j0(View view2, Animation animation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, view2, animation)) == null) ? rh4.b(view2) == 0 && rh4.c(view2) && Q(animation) : invokeLL.booleanValue;
    }

    public static int n0(int i, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z2)})) == null) {
            if (i == 4097) {
                return z2 ? 1 : 2;
            } else if (i == 4099) {
                return z2 ? 5 : 6;
            } else if (i != 8194) {
                return -1;
            } else {
                return z2 ? 3 : 4;
            }
        }
        return invokeCommon.intValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q = false;
            S(5, false);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q = false;
            S(4, false);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q = true;
            S(3, false);
        }
    }

    public void D(Runnable runnable, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, runnable, z2) == null) {
            if (!z2) {
                l();
            }
            synchronized (this) {
                if (!this.r && this.m != null) {
                    if (this.a == null) {
                        this.a = new ArrayList<>();
                    }
                    this.a.add(runnable);
                    if (this.a.size() == 1) {
                        this.m.h().removeCallbacks(this.w);
                        this.m.h().post(this.w);
                    }
                } else {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
        r6.c = true;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r3 >= r2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
        r6.b[r3].run();
        r6.b[r3] = null;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean E() {
        InterceptResult invokeV;
        zg4 zg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.c) {
                if (Looper.myLooper() == this.m.h().getLooper()) {
                    boolean z2 = false;
                    while (true) {
                        synchronized (this) {
                            if (this.a == null || this.a.size() == 0) {
                                break;
                            }
                            int size = this.a.size();
                            if (this.b == null || this.b.length < size) {
                                this.b = new Runnable[size];
                            }
                            this.a.toArray(this.b);
                            this.a.clear();
                            this.m.h().removeCallbacks(this.w);
                        }
                        this.c = false;
                        z2 = true;
                    }
                    if (this.t) {
                        boolean z3 = false;
                        for (int i = 0; i < this.d.size(); i++) {
                            Fragment fragment = this.d.get(i);
                            if (fragment != null && (zg4Var = fragment.M) != null) {
                                z3 |= zg4Var.j();
                            }
                        }
                        if (!z3) {
                            this.t = false;
                            l0();
                        }
                    }
                    return z2;
                }
                throw new IllegalStateException("Must be called from main thread of process");
            }
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        return invokeV.booleanValue;
    }

    public Fragment F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            ArrayList<Fragment> arrayList = this.e;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment = this.e.get(size);
                    if (fragment != null && fragment.w == i) {
                        return fragment;
                    }
                }
            }
            ArrayList<Fragment> arrayList2 = this.d;
            if (arrayList2 != null) {
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Fragment fragment2 = this.d.get(size2);
                    if (fragment2 != null && fragment2.w == i) {
                        return fragment2;
                    }
                }
                return null;
            }
            return null;
        }
        return (Fragment) invokeI.objValue;
    }

    public Fragment G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            ArrayList<Fragment> arrayList = this.e;
            if (arrayList != null && str != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment = this.e.get(size);
                    if (fragment != null && str.equals(fragment.y)) {
                        return fragment;
                    }
                }
            }
            ArrayList<Fragment> arrayList2 = this.d;
            if (arrayList2 == null || str == null) {
                return null;
            }
            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.d.get(size2);
                if (fragment2 != null && str.equals(fragment2.y)) {
                    return fragment2;
                }
            }
            return null;
        }
        return (Fragment) invokeL.objValue;
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            synchronized (this) {
                this.i.set(i, null);
                if (this.j == null) {
                    this.j = new ArrayList<>();
                }
                if (x) {
                    Log.v("FragmentManager", "Freeing back stack index " + i);
                }
                this.j.add(Integer.valueOf(i));
            }
        }
    }

    public Fragment I(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, str)) == null) {
            int i = bundle.getInt(str, -1);
            if (i == -1) {
                return null;
            }
            if (i < this.d.size()) {
                Fragment fragment = this.d.get(i);
                if (fragment != null) {
                    return fragment;
                }
                m0(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
                throw null;
            }
            m0(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
            throw null;
        }
        return (Fragment) invokeLL.objValue;
    }

    public qh4 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (qh4) invokeV.objValue;
    }

    public void K(Fragment fragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, fragment, i, i2) == null) {
            if (x) {
                Log.v("FragmentManager", "hide: " + fragment);
            }
            if (fragment.z) {
                return;
            }
            fragment.z = true;
            if (fragment.I != null) {
                Animation L = L(fragment, i, false, i2);
                if (L != null) {
                    i0(fragment.I, L);
                    fragment.I.startAnimation(L);
                }
                fragment.I.setVisibility(8);
            }
            if (fragment.l && fragment.D && fragment.E) {
                this.p = true;
            }
            fragment.C0(true);
        }
    }

    public Animation L(Fragment fragment, int i, boolean z2, int i2) {
        InterceptResult invokeCommon;
        int n0;
        Animation loadAnimation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{fragment, Integer.valueOf(i), Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            Animation v0 = fragment.v0(i, z2, fragment.G);
            if (v0 != null) {
                return v0;
            }
            if (fragment.G == 0 || (loadAnimation = AnimationUtils.loadAnimation(this.m.getContext(), fragment.G)) == null) {
                if (i != 0 && (n0 = n0(i, z2)) >= 0) {
                    switch (n0) {
                        case 1:
                            return P(this.m.getContext(), 1.125f, 1.0f, 0.0f, 1.0f);
                        case 2:
                            return P(this.m.getContext(), 1.0f, 0.975f, 1.0f, 0.0f);
                        case 3:
                            return P(this.m.getContext(), 0.975f, 1.0f, 0.0f, 1.0f);
                        case 4:
                            return P(this.m.getContext(), 1.0f, 1.075f, 1.0f, 0.0f);
                        case 5:
                            return N(this.m.getContext(), 0.0f, 1.0f);
                        case 6:
                            return N(this.m.getContext(), 1.0f, 0.0f);
                        default:
                            if (i2 == 0 && this.m.o()) {
                                i2 = this.m.n();
                            }
                            if (i2 == 0) {
                            }
                            return null;
                    }
                }
                return null;
            }
            return loadAnimation;
        }
        return (Animation) invokeCommon.objValue;
    }

    public void M(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, fragment) == null) || fragment.f >= 0) {
            return;
        }
        ArrayList<Integer> arrayList = this.f;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<Integer> arrayList2 = this.f;
            fragment.k1(arrayList2.remove(arrayList2.size() - 1).intValue(), this.o);
            this.d.set(fragment.f, fragment);
        } else {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            fragment.k1(this.d.size(), this.o);
            this.d.add(fragment);
        }
        if (x) {
            Log.v("FragmentManager", "Allocated fragment index " + fragment);
        }
    }

    public void O(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fragment) == null) || fragment.f < 0) {
            return;
        }
        if (x) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        this.d.set(fragment.f, null);
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.add(Integer.valueOf(fragment.f));
        this.m.j(fragment.g);
        fragment.b0();
    }

    public void R(int i, int i2, int i3, boolean z2) {
        tg4 tg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            if (this.m == null && i != 0) {
                throw new IllegalStateException("No host");
            }
            if (z2 || this.l != i) {
                this.l = i;
                if (this.d != null) {
                    boolean z3 = false;
                    for (int i4 = 0; i4 < this.d.size(); i4++) {
                        Fragment fragment = this.d.get(i4);
                        if (fragment != null) {
                            U(fragment, i, i2, i3, false);
                            zg4 zg4Var = fragment.M;
                            if (zg4Var != null) {
                                z3 |= zg4Var.j();
                            }
                        }
                    }
                    if (!z3) {
                        l0();
                    }
                    if (this.p && (tg4Var = this.m) != null && this.l == 5) {
                        tg4Var.s();
                        this.p = false;
                    }
                }
            }
        }
    }

    public void S(int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            R(i, 0, 0, z2);
        }
    }

    public void T(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fragment) == null) {
            U(fragment, this.l, 0, 0, false);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:124:0x0226 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x015e */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0160  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Throwable, android.os.Bundle, android.view.View] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [android.os.Bundle, android.util.SparseArray<android.os.Parcelable>] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U(Fragment fragment, int i, int i2, int i3, boolean z2) {
        int i4;
        View view2;
        String str;
        String str2;
        boolean z3;
        vg4 g;
        ?? r14;
        ViewGroup viewGroup;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{fragment, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            int i6 = 1;
            if (!fragment.l || fragment.A) {
                i4 = i;
                if (i4 > 1) {
                    i4 = 1;
                }
            } else {
                i4 = i;
            }
            if (fragment.m && i4 > (i5 = fragment.a)) {
                i4 = i5;
            }
            int i7 = (!fragment.K || fragment.a >= 4 || i4 <= 3) ? i4 : 3;
            int i8 = fragment.a;
            if (i8 < i7) {
                if (fragment.o && !fragment.p) {
                    return;
                }
                if (fragment.b != null) {
                    fragment.b = null;
                    str = "FragmentManager";
                    U(fragment, fragment.c, 0, 0, true);
                } else {
                    str = "FragmentManager";
                }
                int i9 = fragment.a;
                if (i9 == 0) {
                    if (x) {
                        str2 = str;
                        Log.v(str2, "moveto CREATED: " + fragment);
                    } else {
                        str2 = str;
                    }
                    Bundle bundle = fragment.d;
                    if (bundle != null) {
                        bundle.setClassLoader(this.m.getContext().getClassLoader());
                        fragment.e = fragment.d.getSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG);
                        Fragment I = I(fragment.d, FragmentStateManager.TARGET_STATE_TAG);
                        fragment.i = I;
                        if (I != null) {
                            z3 = false;
                            fragment.k = fragment.d.getInt(FragmentStateManager.TARGET_REQUEST_CODE_STATE_TAG, 0);
                        } else {
                            z3 = false;
                        }
                        boolean z4 = fragment.d.getBoolean(FragmentStateManager.USER_VISIBLE_HINT_TAG, true);
                        fragment.L = z4;
                        if (!z4) {
                            fragment.K = true;
                            if (i7 > 3) {
                                i7 = 3;
                            }
                        }
                    } else {
                        z3 = false;
                    }
                    tg4 tg4Var = this.m;
                    fragment.t = tg4Var;
                    Fragment fragment2 = this.o;
                    fragment.v = fragment2;
                    if (fragment2 != null) {
                        g = fragment2.u;
                    } else {
                        g = tg4Var.g();
                    }
                    fragment.s = g;
                    fragment.F = z3;
                    fragment.s0(this.m.getContext());
                    if (fragment.F) {
                        if (fragment.v == null) {
                            this.m.k(fragment);
                        }
                        if (!fragment.C) {
                            fragment.T0(fragment.d);
                        }
                        fragment.C = z3;
                        if (fragment.o) {
                            r14 = 0;
                            r14 = 0;
                            View V0 = fragment.V0(fragment.y(fragment.d), null, fragment.d);
                            fragment.I = V0;
                            if (V0 != null) {
                                fragment.J = V0;
                                if (Build.VERSION.SDK_INT >= 11) {
                                    rh4.e(V0, z3);
                                } else {
                                    fragment.I = ah4.a(V0);
                                }
                                if (fragment.z) {
                                    fragment.I.setVisibility(8);
                                }
                                fragment.N0(fragment.I, fragment.d);
                            } else {
                                fragment.J = null;
                            }
                            if (i7 > 1) {
                                if (x) {
                                    Log.v(str2, "moveto ACTIVITY_CREATED: " + fragment);
                                }
                                if (!fragment.o) {
                                    int i10 = fragment.x;
                                    if (i10 != 0) {
                                        viewGroup = (ViewGroup) this.n.a(i10);
                                        if (viewGroup == null && !fragment.q) {
                                            m0(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.x) + " (" + fragment.getResources().getResourceName(fragment.x) + ") for fragment " + fragment));
                                            throw r14;
                                        }
                                    } else {
                                        viewGroup = r14;
                                    }
                                    fragment.H = viewGroup;
                                    View V02 = fragment.V0(fragment.y(fragment.d), viewGroup, fragment.d);
                                    fragment.I = V02;
                                    if (V02 != null) {
                                        fragment.J = V02;
                                        if (Build.VERSION.SDK_INT >= 11) {
                                            rh4.e(V02, z3);
                                        } else {
                                            fragment.I = ah4.a(V02);
                                        }
                                        if (viewGroup != null) {
                                            Animation L = L(fragment, i2, true, i3);
                                            if (L != null) {
                                                i0(fragment.I, L);
                                                fragment.I.startAnimation(L);
                                            }
                                            viewGroup.addView(fragment.I);
                                        }
                                        if (fragment.z) {
                                            fragment.I.setVisibility(8);
                                        }
                                        fragment.N0(fragment.I, fragment.d);
                                    } else {
                                        fragment.J = r14;
                                    }
                                }
                                fragment.P0(fragment.d);
                                if (fragment.I != null) {
                                    fragment.i1(fragment.d);
                                }
                                fragment.d = r14;
                            }
                            if (i7 > 3) {
                            }
                            if (i7 > 4) {
                            }
                        }
                    } else {
                        throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onAttach()");
                    }
                } else if (i9 == 1) {
                    str2 = str;
                    z3 = false;
                } else if (i9 == 2 || i9 == 3) {
                    str2 = str;
                    r14 = 0;
                    if (i7 > 3) {
                        if (x) {
                            Log.v(str2, "moveto STARTED: " + fragment);
                        }
                        fragment.g1();
                    }
                    if (i7 > 4) {
                        if (x) {
                            Log.v(str2, "moveto RESUMED: " + fragment);
                        }
                        fragment.n = true;
                        fragment.e1();
                        fragment.d = r14;
                        fragment.e = r14;
                    }
                } else if (i9 == 4) {
                    str2 = str;
                    r14 = 0;
                    if (i7 > 4) {
                    }
                }
                r14 = 0;
                if (i7 > 1) {
                }
                if (i7 > 3) {
                }
                if (i7 > 4) {
                }
            } else if (i8 > i7) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 != 4) {
                                if (i8 == 5) {
                                    if (i7 < 5) {
                                        if (x) {
                                            Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                                        }
                                        fragment.b1();
                                        fragment.n = false;
                                    }
                                }
                            }
                            if (i7 < 4) {
                                if (x) {
                                    Log.v("FragmentManager", "movefrom STARTED: " + fragment);
                                }
                                fragment.h1();
                            }
                        }
                        if (i7 < 3) {
                            if (x) {
                                Log.v("FragmentManager", "movefrom STOPPED: " + fragment);
                            }
                            fragment.d1();
                        }
                    }
                    if (i7 < 2) {
                        if (x) {
                            Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                        }
                        if (fragment.I != null && this.m.q(fragment) && fragment.e == null) {
                            g0(fragment);
                        }
                        fragment.X0();
                        if (fragment.I != null && fragment.H != null) {
                            Animation L2 = (this.l <= 0 || this.r) ? null : L(fragment, i2, false, i3);
                            if (L2 != null) {
                                View view3 = fragment.I;
                                fragment.b = view3;
                                fragment.c = i7;
                                L2.setAnimationListener(new c(this, view3, L2, fragment));
                                fragment.I.startAnimation(L2);
                            }
                            fragment.H.removeView(fragment.I);
                        }
                        fragment.H = null;
                        fragment.I = null;
                        fragment.J = null;
                    }
                }
                if (i7 < 1) {
                    if (this.r && (view2 = fragment.b) != null) {
                        fragment.b = null;
                        view2.clearAnimation();
                    }
                    if (fragment.b != null) {
                        fragment.c = i7;
                        fragment.a = i6;
                    }
                    if (x) {
                        Log.v("FragmentManager", "movefrom CREATED: " + fragment);
                    }
                    if (!fragment.C) {
                        fragment.W0();
                    }
                    fragment.F = false;
                    fragment.B0();
                    if (!fragment.F) {
                        throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDetach()");
                    } else if (!z2) {
                        if (!fragment.C) {
                            O(fragment);
                        } else {
                            fragment.t = null;
                            fragment.v = null;
                            fragment.s = null;
                            fragment.u = null;
                        }
                    }
                }
            }
            i6 = i7;
            fragment.a = i6;
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.q = false;
        }
    }

    public void W(Fragment fragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, fragment) == null) && fragment.K) {
            if (this.c) {
                this.t = true;
                return;
            }
            fragment.K = false;
            U(fragment, this.l, 0, 0, false);
        }
    }

    public boolean X(Handler handler, String str, int i, int i2) {
        InterceptResult invokeLLII;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048596, this, handler, str, i, i2)) == null) {
            ArrayList<ng4> arrayList = this.g;
            if (arrayList == null) {
                return false;
            }
            ng4.e eVar = null;
            if (str == null && i < 0 && (i2 & 1) == 0) {
                int size2 = arrayList.size() - 1;
                if (size2 < 0) {
                    return false;
                }
                ng4 remove = this.g.remove(size2);
                SparseArray<Fragment> sparseArray = new SparseArray<>();
                SparseArray<Fragment> sparseArray2 = new SparseArray<>();
                remove.r(sparseArray, sparseArray2);
                remove.J(true, null, sparseArray, sparseArray2);
                a0();
            } else {
                if (str != null || i >= 0) {
                    size = this.g.size() - 1;
                    while (size >= 0) {
                        ng4 ng4Var = this.g.get(size);
                        if ((str != null && str.equals(ng4Var.F())) || (i >= 0 && i == ng4Var.o)) {
                            break;
                        }
                        size--;
                    }
                    if (size < 0) {
                        return false;
                    }
                    if ((i2 & 1) != 0) {
                        while (true) {
                            size--;
                            if (size < 0) {
                                break;
                            }
                            ng4 ng4Var2 = this.g.get(size);
                            if (str == null || !str.equals(ng4Var2.F())) {
                                if (i < 0 || i != ng4Var2.o) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    size = -1;
                }
                if (size == this.g.size() - 1) {
                    return false;
                }
                ArrayList arrayList2 = new ArrayList();
                for (int size3 = this.g.size() - 1; size3 > size; size3--) {
                    arrayList2.add(this.g.remove(size3));
                }
                int size4 = arrayList2.size() - 1;
                SparseArray<Fragment> sparseArray3 = new SparseArray<>();
                SparseArray<Fragment> sparseArray4 = new SparseArray<>();
                for (int i3 = 0; i3 <= size4; i3++) {
                    ((ng4) arrayList2.get(i3)).r(sparseArray3, sparseArray4);
                }
                int i4 = 0;
                while (i4 <= size4) {
                    if (x) {
                        Log.v("FragmentManager", "Popping back stack state: " + arrayList2.get(i4));
                    }
                    eVar = ((ng4) arrayList2.get(i4)).J(i4 == size4, eVar, sparseArray3, sparseArray4);
                    i4++;
                }
                a0();
            }
            return true;
        }
        return invokeLLII.booleanValue;
    }

    public void Y(Bundle bundle, String str, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, bundle, str, fragment) == null) {
            int i = fragment.f;
            if (i >= 0) {
                bundle.putInt(str, i);
                return;
            }
            m0(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
            throw null;
        }
    }

    public void Z(Fragment fragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048598, this, fragment, i, i2) == null) {
            if (x) {
                Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.r);
            }
            int i3 = !fragment.n0();
            if (fragment.A && i3 == 0) {
                return;
            }
            ArrayList<Fragment> arrayList = this.e;
            if (arrayList != null) {
                arrayList.remove(fragment);
            }
            if (fragment.D && fragment.E) {
                this.p = true;
            }
            fragment.l = false;
            fragment.m = true;
            U(fragment, i3 ^ 1, i, i2, false);
        }
    }

    @Override // com.baidu.tieba.ug4
    public wg4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new ng4(this) : (wg4) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.k == null) {
            return;
        }
        for (int i = 0; i < this.k.size(); i++) {
            this.k.get(i).onBackStackChanged();
        }
    }

    @Override // com.baidu.tieba.ug4
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048601, this, str, fileDescriptor, printWriter, strArr) == null) {
            String str2 = str + "    ";
            ArrayList<Fragment> arrayList = this.d;
            if (arrayList != null && (size6 = arrayList.size()) > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (int i = 0; i < size6; i++) {
                    Fragment fragment = this.d.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.l(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
            ArrayList<Fragment> arrayList2 = this.e;
            if (arrayList2 != null && (size5 = arrayList2.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (int i2 = 0; i2 < size5; i2++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(this.e.get(i2).toString());
                }
            }
            ArrayList<Fragment> arrayList3 = this.h;
            if (arrayList3 != null && (size4 = arrayList3.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < size4; i3++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(this.h.get(i3).toString());
                }
            }
            ArrayList<ng4> arrayList4 = this.g;
            if (arrayList4 != null && (size3 = arrayList4.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i4 = 0; i4 < size3; i4++) {
                    ng4 ng4Var = this.g.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(ng4Var.toString());
                    ng4Var.z(str2, fileDescriptor, printWriter, strArr);
                }
            }
            synchronized (this) {
                if (this.i != null && (size2 = this.i.size()) > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i5 = 0; i5 < size2; i5++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println((ng4) this.i.get(i5));
                    }
                }
                if (this.j != null && this.j.size() > 0) {
                    printWriter.print(str);
                    printWriter.print("mAvailBackStackIndices: ");
                    printWriter.println(Arrays.toString(this.j.toArray()));
                }
            }
            ArrayList<Runnable> arrayList5 = this.a;
            if (arrayList5 != null && (size = arrayList5.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i6 = 0; i6 < size; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println((Runnable) this.a.get(i6));
                }
            }
            printWriter.print(str);
            printWriter.println("FragmentManager misc state:");
            printWriter.print(str);
            printWriter.print("  mHost=");
            printWriter.println(this.m);
            printWriter.print(str);
            printWriter.print("  mContainer=");
            printWriter.println(this.n);
            if (this.o != null) {
                printWriter.print(str);
                printWriter.print("  mParent=");
                printWriter.println(this.o);
            }
            printWriter.print(str);
            printWriter.print("  mCurState=");
            printWriter.print(this.l);
            printWriter.print(" mStateSaved=");
            printWriter.print(this.q);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.r);
            if (this.p) {
                printWriter.print(str);
                printWriter.print("  mNeedMenuInvalidate=");
                printWriter.println(this.p);
            }
            if (this.s != null) {
                printWriter.print(str);
                printWriter.print("  mNoTransactionsBecause=");
                printWriter.println(this.s);
            }
            ArrayList<Integer> arrayList6 = this.f;
            if (arrayList6 == null || arrayList6.size() <= 0) {
                return;
            }
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f.toArray()));
        }
    }

    public void b0(Parcelable parcelable, List<Fragment> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, parcelable, list) == null) || parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Fragment fragment = list.get(i);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                }
                FragmentState fragmentState = fragmentManagerState.mActive[fragment.f];
                fragmentState.mInstance = fragment;
                fragment.e = null;
                fragment.r = 0;
                fragment.p = false;
                fragment.l = false;
                fragment.i = null;
                Bundle bundle = fragmentState.mSavedFragmentState;
                if (bundle != null) {
                    bundle.setClassLoader(this.m.getContext().getClassLoader());
                    fragment.e = fragmentState.mSavedFragmentState.getSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG);
                    fragment.d = fragmentState.mSavedFragmentState;
                }
            }
        }
        this.d = new ArrayList<>(fragmentManagerState.mActive.length);
        ArrayList<Integer> arrayList = this.f;
        if (arrayList != null) {
            arrayList.clear();
        }
        int i2 = 0;
        while (true) {
            FragmentState[] fragmentStateArr = fragmentManagerState.mActive;
            if (i2 >= fragmentStateArr.length) {
                break;
            }
            FragmentState fragmentState2 = fragmentStateArr[i2];
            if (fragmentState2 != null) {
                Fragment instantiate = fragmentState2.instantiate(this.m, this.o);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + instantiate);
                }
                this.d.add(instantiate);
                fragmentState2.mInstance = null;
            } else {
                this.d.add(null);
                if (this.f == null) {
                    this.f = new ArrayList<>();
                }
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                }
                this.f.add(Integer.valueOf(i2));
            }
            i2++;
        }
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                Fragment fragment2 = list.get(i3);
                int i4 = fragment2.j;
                if (i4 >= 0) {
                    if (i4 < this.d.size()) {
                        fragment2.i = this.d.get(fragment2.j);
                    } else {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.j);
                        fragment2.i = null;
                    }
                }
            }
        }
        if (fragmentManagerState.mAdded != null) {
            this.e = new ArrayList<>(fragmentManagerState.mAdded.length);
            int i5 = 0;
            while (true) {
                int[] iArr = fragmentManagerState.mAdded;
                if (i5 >= iArr.length) {
                    break;
                }
                Fragment fragment3 = this.d.get(iArr[i5]);
                if (fragment3 != null) {
                    fragment3.l = true;
                    if (x) {
                        Log.v("FragmentManager", "restoreAllState: added #" + i5 + ": " + fragment3);
                    }
                    if (!this.e.contains(fragment3)) {
                        this.e.add(fragment3);
                        i5++;
                    } else {
                        throw new IllegalStateException("Already added!");
                    }
                } else {
                    m0(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i5]));
                    throw null;
                }
            }
        } else {
            this.e = null;
        }
        if (fragmentManagerState.mBackStack != null) {
            this.g = new ArrayList<>(fragmentManagerState.mBackStack.length);
            int i6 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.mBackStack;
                if (i6 >= backStackStateArr.length) {
                    return;
                }
                ng4 instantiate2 = backStackStateArr[i6].instantiate(this);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + instantiate2.o + "): " + instantiate2);
                    instantiate2.A(GlideException.IndentedAppendable.INDENT, new PrintWriter(new ih4("FragmentManager")), false);
                }
                this.g.add(instantiate2);
                int i7 = instantiate2.o;
                if (i7 >= 0) {
                    h0(i7, instantiate2);
                }
                i6++;
            }
        } else {
            this.g = null;
        }
    }

    @Override // com.baidu.tieba.ug4
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? E() : invokeV.booleanValue;
    }

    public ArrayList<Fragment> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ArrayList<Fragment> arrayList = null;
            if (this.d != null) {
                for (int i = 0; i < this.d.size(); i++) {
                    Fragment fragment = this.d.get(i);
                    if (fragment != null && fragment.B) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(fragment);
                        fragment.C = true;
                        Fragment fragment2 = fragment.i;
                        fragment.j = fragment2 != null ? fragment2.f : -1;
                        if (x) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ug4
    public List<Fragment> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ug4
    public void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i, i2) == null) {
            if (i >= 0) {
                D(new b(this, i, i2), false);
                return;
            }
            throw new IllegalArgumentException("Bad id: " + i);
        }
    }

    public Parcelable e0() {
        InterceptResult invokeV;
        int[] iArr;
        int size;
        int size2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            E();
            if (y) {
                this.q = true;
            }
            ArrayList<Fragment> arrayList = this.d;
            BackStackState[] backStackStateArr = null;
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            int size3 = this.d.size();
            FragmentState[] fragmentStateArr = new FragmentState[size3];
            boolean z2 = false;
            for (int i = 0; i < size3; i++) {
                Fragment fragment = this.d.get(i);
                if (fragment != null) {
                    if (fragment.f >= 0) {
                        FragmentState fragmentState = new FragmentState(fragment);
                        fragmentStateArr[i] = fragmentState;
                        if (fragment.a > 0 && fragmentState.mSavedFragmentState == null) {
                            Bundle f0 = f0(fragment);
                            fragmentState.mSavedFragmentState = f0;
                            Fragment fragment2 = fragment.i;
                            if (fragment2 != null) {
                                if (fragment2.f >= 0) {
                                    if (f0 == null) {
                                        fragmentState.mSavedFragmentState = new Bundle();
                                    }
                                    Y(fragmentState.mSavedFragmentState, FragmentStateManager.TARGET_STATE_TAG, fragment.i);
                                    int i2 = fragment.k;
                                    if (i2 != 0) {
                                        fragmentState.mSavedFragmentState.putInt(FragmentStateManager.TARGET_REQUEST_CODE_STATE_TAG, i2);
                                    }
                                } else {
                                    m0(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.i));
                                    throw null;
                                }
                            }
                        } else {
                            fragmentState.mSavedFragmentState = fragment.d;
                        }
                        if (x) {
                            Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState);
                        }
                        z2 = true;
                    } else {
                        m0(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f));
                        throw null;
                    }
                }
            }
            if (!z2) {
                if (x) {
                    Log.v("FragmentManager", "saveAllState: no fragments!");
                }
                return null;
            }
            ArrayList<Fragment> arrayList2 = this.e;
            if (arrayList2 == null || (size2 = arrayList2.size()) <= 0) {
                iArr = null;
            } else {
                iArr = new int[size2];
                for (int i3 = 0; i3 < size2; i3++) {
                    iArr[i3] = this.e.get(i3).f;
                    if (iArr[i3] >= 0) {
                        if (x) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i3 + ": " + this.e.get(i3));
                        }
                    } else {
                        m0(new IllegalStateException("Failure saving state: active " + this.e.get(i3) + " has cleared index: " + iArr[i3]));
                        throw null;
                    }
                }
            }
            ArrayList<ng4> arrayList3 = this.g;
            if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                backStackStateArr = new BackStackState[size];
                for (int i4 = 0; i4 < size; i4++) {
                    backStackStateArr[i4] = new BackStackState(this.g.get(i4));
                    if (x) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.g.get(i4));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = fragmentStateArr;
            fragmentManagerState.mAdded = iArr;
            fragmentManagerState.mBackStack = backStackStateArr;
            return fragmentManagerState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ug4
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            l();
            c();
            return X(this.m.h(), null, -1, 0);
        }
        return invokeV.booleanValue;
    }

    public Bundle f0(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, fragment)) == null) {
            if (this.u == null) {
                this.u = new Bundle();
            }
            fragment.f1(this.u);
            Bundle bundle = null;
            if (!this.u.isEmpty()) {
                Bundle bundle2 = this.u;
                this.u = null;
                bundle = bundle2;
            }
            if (fragment.I != null) {
                g0(fragment);
            }
            if (fragment.e != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG, fragment.e);
            }
            if (!fragment.L) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean(FragmentStateManager.USER_VISIBLE_HINT_TAG, fragment.L);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void g(ng4 ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, ng4Var) == null) {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            this.g.add(ng4Var);
            a0();
        }
    }

    public void g0(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, fragment) == null) || fragment.J == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.v;
        if (sparseArray == null) {
            this.v = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.J.saveHierarchyState(this.v);
        if (this.v.size() > 0) {
            fragment.e = this.v;
            this.v = null;
        }
    }

    public void h(Fragment fragment, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048612, this, fragment, z2) == null) {
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            if (x) {
                Log.v("FragmentManager", "add: " + fragment);
            }
            M(fragment);
            if (fragment.A) {
                return;
            }
            if (!this.e.contains(fragment)) {
                this.e.add(fragment);
                fragment.l = true;
                fragment.m = false;
                if (fragment.D && fragment.E) {
                    this.p = true;
                }
                if (z2) {
                    T(fragment);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    public void h0(int i, ng4 ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048613, this, i, ng4Var) == null) {
            synchronized (this) {
                if (this.i == null) {
                    this.i = new ArrayList<>();
                }
                int size = this.i.size();
                if (i < size) {
                    if (x) {
                        Log.v("FragmentManager", "Setting back stack index " + i + " to " + ng4Var);
                    }
                    this.i.set(i, ng4Var);
                } else {
                    while (size < i) {
                        this.i.add(null);
                        if (this.j == null) {
                            this.j = new ArrayList<>();
                        }
                        if (x) {
                            Log.v("FragmentManager", "Adding available back stack index " + size);
                        }
                        this.j.add(Integer.valueOf(size));
                        size++;
                    }
                    if (x) {
                        Log.v("FragmentManager", "Adding back stack index " + i + " with " + ng4Var);
                    }
                    this.i.add(ng4Var);
                }
            }
        }
    }

    public int i(ng4 ng4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, ng4Var)) == null) {
            synchronized (this) {
                if (this.j != null && this.j.size() > 0) {
                    int intValue = this.j.remove(this.j.size() - 1).intValue();
                    if (x) {
                        Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + ng4Var);
                    }
                    this.i.set(intValue, ng4Var);
                    return intValue;
                }
                if (this.i == null) {
                    this.i = new ArrayList<>();
                }
                int size = this.i.size();
                if (x) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + ng4Var);
                }
                this.i.add(ng4Var);
                return size;
            }
        }
        return invokeL.intValue;
    }

    public final void i0(View view2, Animation animation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048615, this, view2, animation) == null) || view2 == null || animation == null || !j0(view2, animation)) {
            return;
        }
        animation.setAnimationListener(new d(view2, animation));
    }

    public void j(tg4 tg4Var, rg4 rg4Var, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048616, this, tg4Var, rg4Var, fragment) == null) {
            if (this.m == null) {
                this.m = tg4Var;
                this.n = rg4Var;
                this.o = fragment;
                return;
            }
            throw new IllegalStateException("Already attached");
        }
    }

    public void k(Fragment fragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048617, this, fragment, i, i2) == null) {
            if (x) {
                Log.v("FragmentManager", "attach: " + fragment);
            }
            if (fragment.A) {
                fragment.A = false;
                if (fragment.l) {
                    return;
                }
                if (this.e == null) {
                    this.e = new ArrayList<>();
                }
                if (!this.e.contains(fragment)) {
                    if (x) {
                        Log.v("FragmentManager", "add from attach: " + fragment);
                    }
                    this.e.add(fragment);
                    fragment.l = true;
                    if (fragment.D && fragment.E) {
                        this.p = true;
                    }
                    U(fragment, this.l, i, i2, false);
                    return;
                }
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
        }
    }

    public void k0(Fragment fragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048618, this, fragment, i, i2) == null) {
            if (x) {
                Log.v("FragmentManager", "show: " + fragment);
            }
            if (fragment.z) {
                fragment.z = false;
                if (fragment.I != null) {
                    Animation L = L(fragment, i, true, i2);
                    if (L != null) {
                        i0(fragment.I, L);
                        fragment.I.startAnimation(L);
                    }
                    fragment.I.setVisibility(0);
                }
                if (fragment.l && fragment.D && fragment.E) {
                    this.p = true;
                }
                fragment.C0(false);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (!this.q) {
                if (this.s == null) {
                    return;
                }
                throw new IllegalStateException("Can not perform this action inside of " + this.s);
            }
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.d == null) {
            return;
        }
        for (int i = 0; i < this.d.size(); i++) {
            Fragment fragment = this.d.get(i);
            if (fragment != null) {
                W(fragment);
            }
        }
    }

    public void m(Fragment fragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048621, this, fragment, i, i2) == null) {
            if (x) {
                Log.v("FragmentManager", "detach: " + fragment);
            }
            if (fragment.A) {
                return;
            }
            fragment.A = true;
            if (fragment.l) {
                if (this.e != null) {
                    if (x) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.e.remove(fragment);
                }
                if (fragment.D && fragment.E) {
                    this.p = true;
                }
                fragment.l = false;
                U(fragment, 1, i, i2, false);
            }
        }
    }

    public final void m0(RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, runtimeException) == null) {
            Log.e("FragmentManager", runtimeException.getMessage());
            Log.e("FragmentManager", "Activity state:");
            PrintWriter printWriter = new PrintWriter(new ih4("FragmentManager"));
            tg4 tg4Var = this.m;
            if (tg4Var != null) {
                try {
                    tg4Var.l(GlideException.IndentedAppendable.INDENT, null, printWriter, new String[0]);
                } catch (Exception e2) {
                    Log.e("FragmentManager", "Failed dumping state", e2);
                }
            } else {
                try {
                    b(GlideException.IndentedAppendable.INDENT, null, printWriter, new String[0]);
                } catch (Exception e3) {
                    Log.e("FragmentManager", "Failed dumping state", e3);
                }
            }
            try {
                printWriter.close();
            } catch (Exception unused) {
                if (x) {
                    Log.e("FragmentManager", "pw close exception");
                }
            }
            throw runtimeException;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.q = false;
            S(2, false);
        }
    }

    public void o(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, configuration) == null) || this.e == null) {
            return;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.R0(configuration);
            }
        }
    }

    @Override // com.baidu.tieba.qh4
    public View onCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048625, this, view2, str, context, attributeSet)) == null) {
            if ("fragment".equals(str)) {
                String attributeValue = attributeSet.getAttributeValue(null, DealIntentService.KEY_CLASS);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.a);
                if (attributeValue == null) {
                    attributeValue = obtainStyledAttributes.getString(0);
                }
                String str2 = attributeValue;
                int resourceId = obtainStyledAttributes.getResourceId(1, -1);
                String string = obtainStyledAttributes.getString(2);
                obtainStyledAttributes.recycle();
                if (Fragment.o0(this.m.getContext(), str2)) {
                    int id = view2 != null ? view2.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
                    }
                    Fragment F = resourceId != -1 ? F(resourceId) : null;
                    if (F == null && string != null) {
                        F = G(string);
                    }
                    if (F == null && id != -1) {
                        F = F(id);
                    }
                    if (x) {
                        Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + F);
                    }
                    if (F == null) {
                        F = Fragment.d0(context, str2);
                        F.o = true;
                        F.w = resourceId != 0 ? resourceId : id;
                        F.x = id;
                        F.y = string;
                        F.p = true;
                        F.s = this;
                        tg4 tg4Var = this.m;
                        F.t = tg4Var;
                        F.E0(tg4Var.getContext(), attributeSet, F.d);
                        h(F, true);
                    } else if (!F.p) {
                        F.p = true;
                        if (!F.C) {
                            F.E0(this.m.getContext(), attributeSet, F.d);
                        }
                    } else {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
                    }
                    Fragment fragment = F;
                    if (this.l < 1 && fragment.o) {
                        U(fragment, 1, 0, 0, false);
                    } else {
                        T(fragment);
                    }
                    View view3 = fragment.I;
                    if (view3 != null) {
                        if (resourceId != 0) {
                            view3.setId(resourceId);
                        }
                        if (fragment.I.getTag() == null) {
                            fragment.I.setTag(string);
                        }
                        return fragment.I;
                    }
                    throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
                }
                return null;
            }
            return null;
        }
        return (View) invokeLLLL.objValue;
    }

    public boolean p(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, menuItem)) == null) {
            if (this.e != null) {
                for (int i = 0; i < this.e.size(); i++) {
                    Fragment fragment = this.e.get(i);
                    if (fragment != null && fragment.S0(menuItem)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.q = false;
            S(1, false);
        }
    }

    public boolean r(Menu menu, MenuInflater menuInflater) {
        InterceptResult invokeLL;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048628, this, menu, menuInflater)) == null) {
            ArrayList<Fragment> arrayList = null;
            if (this.e != null) {
                z2 = false;
                for (int i = 0; i < this.e.size(); i++) {
                    Fragment fragment = this.e.get(i);
                    if (fragment != null && fragment.U0(menu, menuInflater)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(fragment);
                        z2 = true;
                    }
                }
            } else {
                z2 = false;
            }
            if (this.h != null) {
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    Fragment fragment2 = this.h.get(i2);
                    if (arrayList == null || !arrayList.contains(fragment2)) {
                        fragment2.z0();
                    }
                }
            }
            this.h = arrayList;
            return z2;
        }
        return invokeLL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.r = true;
            E();
            S(0, false);
            this.m = null;
            this.n = null;
            this.o = null;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            S(1, false);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("FragmentManager{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" in ");
            Fragment fragment = this.o;
            if (fragment != null) {
                hh4.a(fragment, sb);
            } else {
                hh4.a(this.m, sb);
            }
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || this.e == null) {
            return;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.Y0();
            }
        }
    }

    public boolean v(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, menuItem)) == null) {
            if (this.e != null) {
                for (int i = 0; i < this.e.size(); i++) {
                    Fragment fragment = this.e.get(i);
                    if (fragment != null && fragment.Z0(menuItem)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void w(Menu menu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, menu) == null) || this.e == null) {
            return;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.a1(menu);
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            S(4, false);
        }
    }

    public boolean y(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, menu)) == null) {
            if (this.e != null) {
                boolean z2 = false;
                for (int i = 0; i < this.e.size(); i++) {
                    Fragment fragment = this.e.get(i);
                    if (fragment != null && fragment.c1(menu)) {
                        z2 = true;
                    }
                }
                return z2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            S(2, false);
        }
    }
}
