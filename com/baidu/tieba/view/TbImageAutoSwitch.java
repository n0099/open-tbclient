package com.baidu.tieba.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public class TbImageAutoSwitch extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c A;
    public int a;
    public int b;
    public boolean c;
    public float d;
    public float e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public b s;
    public Timer t;
    public e u;
    public f v;
    public View[] w;
    public d x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view2, int i);

        void b(int i);

        View c();

        int getCount();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void onAnimationCancel(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationStart(Animator animator);
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View[] a;
        public AnimatorSet b;
        public final List<Animator> c;
        public c d;
        public PropertyValuesHolder e;
        public PropertyValuesHolder f;
        public PropertyValuesHolder g;
        public PropertyValuesHolder h;
        public PropertyValuesHolder i;
        public PropertyValuesHolder j;
        public PropertyValuesHolder k;
        public PropertyValuesHolder l;
        public PropertyValuesHolder m;
        public final Animator.AnimatorListener n;

        /* loaded from: classes8.dex */
        public class a implements Animator.AnimatorListener {
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

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && this.a.d != null) {
                    this.a.d.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.c.clear();
                    this.a.b = null;
                    if (this.a.d != null) {
                        this.a.d.onAnimationEnd(animator);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) && this.a.d != null) {
                    this.a.d.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, animator) == null) && this.a.d != null) {
                    this.a.d.onAnimationStart(animator);
                }
            }
        }

        public d(int i, int i2, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = new a(this);
            this.c = new ArrayList();
            f(i, i2, f, f2);
        }

        public void g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
                this.d = cVar;
            }
        }

        public void h(View[] viewArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, viewArr) == null) {
                this.a = viewArr;
            }
        }

        public void e(int i) {
            View[] viewArr;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (viewArr = this.a) != null && viewArr.length > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.b = animatorSet;
                animatorSet.setDuration(i);
                this.b.addListener(this.n);
                List<Animator> list = this.c;
                View[] viewArr2 = this.a;
                list.add(ObjectAnimator.ofPropertyValuesHolder(viewArr2[viewArr2.length - 1], this.e, this.f, this.g, this.h));
                View[] viewArr3 = this.a;
                if (viewArr3.length >= 2) {
                    for (int length = viewArr3.length - 2; length > 0; length--) {
                        this.c.add(ObjectAnimator.ofPropertyValuesHolder(this.a[length], this.i));
                    }
                }
                this.a[0].clearAnimation();
                this.c.add(ObjectAnimator.ofPropertyValuesHolder(this.a[0], this.j, this.k, this.l, this.m));
            }
        }

        public final void f(int i, int i2, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.e = PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, -i);
                this.f = PropertyValuesHolder.ofFloat(Key.ALPHA, f);
                this.g = PropertyValuesHolder.ofFloat(Key.SCALE_X, f2);
                this.h = PropertyValuesHolder.ofFloat(Key.SCALE_Y, f2);
                float f3 = -i2;
                this.i = PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, f3);
                this.j = PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, f3);
                this.k = PropertyValuesHolder.ofFloat(Key.ALPHA, 1.0f);
                this.l = PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f);
                this.m = PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f);
            }
        }

        public void i() {
            AnimatorSet animatorSet;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (animatorSet = this.b) != null) {
                animatorSet.playTogether(this.c);
                this.b.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageAutoSwitch a;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.c
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.c
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.c
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public a(TbImageAutoSwitch tbImageAutoSwitch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageAutoSwitch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageAutoSwitch;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.c
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.p();
            TbImageAutoSwitch.d(this.a);
            this.a.h %= this.a.s.getCount();
            this.a.s.b(this.a.h);
            this.a.s.a(this.a.w[0], this.a.h % this.a.s.getCount());
            this.a.c = false;
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<f> a;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(fVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fVar = this.a.get()) != null) {
                fVar.sendEmptyMessage(1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class f extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TbImageAutoSwitch> a;

        public f(TbImageAutoSwitch tbImageAutoSwitch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageAutoSwitch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(tbImageAutoSwitch);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                TbImageAutoSwitch tbImageAutoSwitch = this.a.get();
                if (tbImageAutoSwitch == null) {
                    return;
                }
                tbImageAutoSwitch.i();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbImageAutoSwitch(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbImageAutoSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbImageAutoSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = 3000;
        this.c = false;
        this.d = 0.0f;
        this.e = 0.2f;
        this.f = 3000;
        this.g = 3000;
        this.h = 3;
        this.i = true;
        this.y = false;
        this.z = false;
        this.A = new a(this);
        k();
    }

    public static /* synthetic */ int d(TbImageAutoSwitch tbImageAutoSwitch) {
        int i = tbImageAutoSwitch.h + 1;
        tbImageAutoSwitch.h = i;
        return i;
    }

    public void setAdapter(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.s = bVar;
        }
    }

    @Override // android.view.View
    public void setAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.d = f2;
        }
    }

    public void setAnimationDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.b = i;
        }
    }

    public void setCarouselDelayPeriod(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.g = i;
        }
    }

    public void setCarouselPeriod(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.f = i;
        }
    }

    public void setFromCarousel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.z = z;
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.e = f2;
        }
    }

    public List<View> getChildViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                arrayList.add(getChildAt(i));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e eVar = this.u;
            if (eVar != null) {
                eVar.cancel();
                this.u = null;
            }
            Timer timer = this.t;
            if (timer != null) {
                timer.cancel();
                this.t.purge();
                this.t = null;
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.v = new f(this);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u = new e(this.v);
            this.t = new Timer();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            j();
            this.y = false;
            d dVar = this.x;
            if (dVar != null) {
                dVar.d = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            r();
            d dVar = this.x;
            if (dVar != null) {
                dVar.d = this.A;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            if (!this.z && this.x != null) {
                j();
                this.y = false;
                this.x.d = null;
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View[] viewArr = this.w;
            int i = this.a;
            View view2 = viewArr[i - 1];
            System.arraycopy(viewArr, 0, viewArr, 1, i - 1);
            this.w[0] = view2;
            removeAllViews();
            for (View view3 : this.w) {
                addView(view3);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.x != null && !this.y) {
            m();
            this.t.schedule(this.u, this.g, this.f);
            this.y = true;
        }
    }

    public final void i() {
        d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.c && (dVar = this.x) != null) {
            this.c = true;
            dVar.h(this.w);
            this.x.g(this.A);
            this.x.e(this.b);
            this.x.i();
        }
    }

    public void l(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.q = i;
            this.o = i2;
            this.p = i3;
            this.n = i4;
        }
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            View childAt = getChildAt(i);
            if (this.w[i].equals(childAt)) {
                int i2 = this.j;
                int i3 = this.o;
                int i4 = this.n;
                childAt.layout(i2 - ((i3 - i4) * i), this.k, this.l - ((i3 - i4) * i), this.m);
                if (this.r > this.q) {
                    if (i == 0) {
                        childAt.setAlpha(this.d);
                        childAt.setScaleX(this.e);
                        childAt.setScaleY(this.e);
                    } else {
                        childAt.setAlpha(1.0f);
                        childAt.setScaleX(1.0f);
                        childAt.setScaleY(1.0f);
                    }
                    childAt.setTranslationX(0.0f);
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            int i5 = 0;
            if (this.r > this.q) {
                this.j = (i3 - getPaddingRight()) - (this.o / 2);
                this.k = getPaddingTop();
                this.l = this.j + this.o;
                this.m = i4 - getPaddingBottom();
                while (i5 < this.q + 1) {
                    n(i5);
                    i5++;
                }
                return;
            }
            this.j = (i3 - getPaddingRight()) - this.o;
            this.k = getPaddingTop();
            this.l = i3 - getPaddingRight();
            this.m = i4 - getPaddingBottom();
            while (i5 < this.r) {
                n(i5);
                i5++;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            int min = Math.min(this.r, this.q) + 1;
            setMeasuredDimension(FrameLayout.resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.o * min)) - (min * this.n), i), FrameLayout.resolveSize(getPaddingTop() + getPaddingBottom() + this.p, i2));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = 0;
            if (!this.i) {
                int i2 = this.h;
                if (this.x != null) {
                    int i3 = i2;
                    for (int i4 = 0; i4 < this.q + 1; i4++) {
                        this.s.a(this.w[i4], i2);
                        i3--;
                        if (i3 < 0) {
                            i2 = this.s.getCount() + i3;
                        } else {
                            i2 = i3 % this.s.getCount();
                        }
                    }
                    return;
                }
                while (true) {
                    int i5 = this.r;
                    if (i < i5) {
                        this.s.a(this.w[i], (i5 - 1) - i);
                        i++;
                    } else {
                        return;
                    }
                }
            } else {
                this.i = false;
                int count = this.s.getCount();
                this.r = count;
                if (count > this.q && this.x == null) {
                    int i6 = this.o;
                    this.x = new d(i6 / 2, i6 - this.n, this.d, this.e);
                }
                int i7 = this.r;
                int i8 = this.q;
                if (i7 > i8) {
                    i7 = i8 + 1;
                }
                this.a = i7;
                this.w = new View[i7];
                for (int i9 = 0; i9 < this.a; i9++) {
                    View c2 = this.s.c();
                    this.w[i9] = c2;
                    addView(c2);
                }
                b bVar = this.s;
                if (bVar != null && bVar.getCount() > 0) {
                    if (this.x == null) {
                        while (true) {
                            int i10 = this.r;
                            if (i >= i10) {
                                break;
                            }
                            this.s.a(this.w[i], (i10 - 1) - i);
                            i++;
                        }
                    } else {
                        while (i < this.q + 1) {
                            this.s.a(this.w[i], (this.r - 1) - i);
                            i++;
                        }
                    }
                }
                r();
            }
        }
    }
}
