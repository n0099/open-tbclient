package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class un8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;
    public Animator b;
    public Animator c;
    public ValueAnimator d;
    public ValueAnimator e;
    public AnimatorSet f;
    public AnimatorSet g;
    public View h;
    public View i;
    public View j;
    public View k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public final Handler.Callback v;
    public final Handler w;

    /* loaded from: classes6.dex */
    public interface h {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        public a(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if ((i == 1 || i == 2) && this.a.o()) {
                    this.a.w.sendEmptyMessageDelayed(message.what, 100L);
                    return true;
                }
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return false;
                        }
                        this.a.B();
                        return true;
                    }
                    this.a.C();
                    return true;
                }
                this.a.D();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public b(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) || this.a.h == null) {
                return;
            }
            this.a.h.clearAnimation();
            if (this.a.s) {
                this.a.v(false);
            } else {
                this.a.v(true);
            }
            if (this.a.a != null) {
                this.a.a.a(false);
            }
            this.a.j.clearAnimation();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        public c(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    this.a.k.setLayoutParams(layoutParams);
                }
                this.a.k.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.a.l;
                    this.a.k.setLayoutParams(layoutParams);
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        public d(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = num.intValue();
                    this.a.k.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public e(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) || this.a.h == null) {
                return;
            }
            this.a.h.clearAnimation();
            this.a.h.setVisibility(0);
            this.a.v(false);
            if (this.a.a != null) {
                this.a.a.a(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        public f(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.k.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    this.a.k.setLayoutParams(layoutParams);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.k.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.a.l;
                    this.a.k.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        public g(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = num.intValue();
                    this.a.k.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public un8(Context context, View view2, View view3, View view4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, view3, view4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = UtilHelper.getLightStatusBarHeight();
        this.m = false;
        this.o = false;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = true;
        this.v = new a(this);
        this.w = new Handler(this.v);
        this.h = view2;
        this.i = view3;
        this.j = view4;
        this.k = view4.findViewById(R.id.obfuscated_res_0x7f09216c);
        this.n = UtilHelper.canUseStyleImmersiveSticky();
        j();
        v(false);
    }

    public boolean i(AbsListView absListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, absListView)) == null) {
            if (absListView == null) {
                return true;
            }
            if ((absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.r = z;
        }
    }

    public void t(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hVar) == null) {
            this.a = hVar;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.t = z;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.q = z;
        }
    }

    public void A(boolean z, boolean z2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (view2 = this.h) != null && view2.getY() == 0.0f && !o()) {
            if (z2) {
                this.h.setVisibility(8);
                if (this.s) {
                    v(false);
                    return;
                } else {
                    v(true);
                    return;
                }
            }
            this.h.setVisibility(0);
            if (this.g == null) {
                m();
            }
            AnimatorSet animatorSet = this.g;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.g.setDuration(300L).start();
            }
        }
    }

    public void r(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, absListView, i) == null) {
            if (i == 1) {
                this.m = true;
            } else if (i == 0) {
                this.m = false;
            }
            if (!this.u || this.q || this.r) {
                return;
            }
            if (this.o) {
                v(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                int i2 = this.p;
                if (firstVisiblePosition > i2) {
                    y();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < i2) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    z();
                } else if (firstVisiblePosition == i2) {
                    if (firstVisiblePosition != 0 && this.t && !i(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragDown:");
                        y();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                    z();
                }
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            A(false, true);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            A(false, false);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.w.removeCallbacksAndMessages(null);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        AnimatorSet animatorSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AnimatorSet animatorSet2 = this.f;
            if ((animatorSet2 != null && animatorSet2.isRunning()) || ((animatorSet = this.g) != null && animatorSet.isRunning())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.h.getVisibility() == 0 && this.h.getY() >= 0.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.w.removeMessages(1);
            if (!this.w.hasMessages(2)) {
                this.w.sendEmptyMessageDelayed(2, 110L);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.w.removeMessages(2);
            if (!this.w.hasMessages(1)) {
                this.w.sendEmptyMessageDelayed(1, 60L);
            }
        }
    }

    public void D() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (view2 = this.h) != null && view2.getY() < 0.0f && !o()) {
            this.h.setVisibility(0);
            if (this.f == null) {
                n();
            }
            AnimatorSet animatorSet = this.f;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.f.setDuration(300L).start();
            }
        }
    }

    public final void j() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (view2 = this.i) == null) {
            return;
        }
        if (this.n && view2.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.i.setLayoutParams(layoutParams);
            v(true);
            return;
        }
        v(false);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.u) {
            return;
        }
        if (this.o) {
            v(true);
        } else if (this.h != null && !this.q && !this.r && p()) {
            Log.i("PbView", "hideFloatingView: startDragDown");
            y();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || !this.u) {
            return;
        }
        if (this.o) {
            v(true);
        } else if (this.h != null && !p()) {
            Log.i("PbView", "showFloatingView: startDragUp");
            z();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view2 = this.h;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, (-view2.getMeasuredHeight()) + this.j.getMeasuredHeight());
            this.b = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.b.addListener(new b(this));
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.l);
            this.e = ofInt;
            ofInt.setInterpolator(new LinearInterpolator());
            this.e.addListener(new c(this));
            this.e.addUpdateListener(new d(this));
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            animatorSet.play(this.b).with(this.e);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.h, Key.TRANSLATION_Y, 0.0f);
            this.c = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.c.addListener(new e(this));
            ValueAnimator ofInt = ValueAnimator.ofInt(this.l, 0);
            this.d = ofInt;
            ofInt.setInterpolator(new LinearInterpolator());
            this.d.addListener(new f(this));
            this.d.addUpdateListener(new g(this));
            AnimatorSet animatorSet = new AnimatorSet();
            this.f = animatorSet;
            animatorSet.play(this.c).with(this.d);
        }
    }

    public void q(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048588, this, absListView, i, i2, i3) != null) || !this.u || this.h == null || this.q || this.r || !this.m) {
            return;
        }
        if (i > this.p && p()) {
            Log.i("PbView", "onScroll hideFloatingView");
            l();
        } else if (i < this.p && !p()) {
            Log.i("PbView", "onScroll showFloatingView");
            x();
        }
        this.p = i;
    }

    public final void v(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || (view2 = this.i) == null) {
            return;
        }
        if (this.n && z && view2.getVisibility() != 0) {
            this.i.setVisibility(0);
        } else if (!z && this.i.getVisibility() != 8) {
            this.i.setVisibility(8);
        }
    }
}
