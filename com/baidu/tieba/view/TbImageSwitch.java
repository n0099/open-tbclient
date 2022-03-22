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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public class TbImageSwitch extends FrameLayout implements View.OnAttachStateChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f36985b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36986c;

    /* renamed from: d  reason: collision with root package name */
    public float f36987d;

    /* renamed from: e  reason: collision with root package name */
    public float f36988e;

    /* renamed from: f  reason: collision with root package name */
    public int f36989f;

    /* renamed from: g  reason: collision with root package name */
    public int f36990g;

    /* renamed from: h  reason: collision with root package name */
    public int f36991h;
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
    public final c y;

    /* loaded from: classes6.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageSwitch a;

        public a(TbImageSwitch tbImageSwitch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageSwitch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageSwitch;
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.c
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.c
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.o();
                TbImageSwitch.d(this.a);
                this.a.f36991h %= this.a.s.getCount();
                this.a.s.b(this.a.f36991h);
                this.a.s.a(this.a.w[0], this.a.f36991h % this.a.s.getCount());
                this.a.f36986c = false;
            }
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.c
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.c
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(View view, int i);

        void b(int i);

        View c();

        int getCount();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onAnimationCancel(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationStart(Animator animator);
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View[] a;

        /* renamed from: b  reason: collision with root package name */
        public AnimatorSet f36992b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Animator> f36993c;

        /* renamed from: d  reason: collision with root package name */
        public c f36994d;

        /* renamed from: e  reason: collision with root package name */
        public PropertyValuesHolder f36995e;

        /* renamed from: f  reason: collision with root package name */
        public PropertyValuesHolder f36996f;

        /* renamed from: g  reason: collision with root package name */
        public PropertyValuesHolder f36997g;

        /* renamed from: h  reason: collision with root package name */
        public PropertyValuesHolder f36998h;
        public PropertyValuesHolder i;
        public PropertyValuesHolder j;
        public PropertyValuesHolder k;
        public PropertyValuesHolder l;
        public PropertyValuesHolder m;
        public final Animator.AnimatorListener n;

        /* loaded from: classes6.dex */
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a.f36994d == null) {
                    return;
                }
                this.a.f36994d.onAnimationCancel(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.f36993c.clear();
                    this.a.f36992b = null;
                    if (this.a.f36994d != null) {
                        this.a.f36994d.onAnimationEnd(animator);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.a.f36994d == null) {
                    return;
                }
                this.a.f36994d.onAnimationRepeat(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.a.f36994d == null) {
                    return;
                }
                this.a.f36994d.onAnimationStart(animator);
            }
        }

        public d(int i, int i2, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)};
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
            this.f36993c = new ArrayList();
            e(i, i2, f2, f3);
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.f36992b = animatorSet;
            animatorSet.setDuration(i);
            this.f36992b.addListener(this.n);
            List<Animator> list = this.f36993c;
            View[] viewArr = this.a;
            list.add(ObjectAnimator.ofPropertyValuesHolder(viewArr[viewArr.length - 1], this.f36995e, this.f36996f, this.f36997g, this.f36998h));
            for (int length = this.a.length - 2; length >= 0; length--) {
                this.f36993c.add(ObjectAnimator.ofPropertyValuesHolder(this.a[length], this.i));
            }
            this.f36993c.add(ObjectAnimator.ofPropertyValuesHolder(this.a[0], this.j, this.k, this.l, this.m));
        }

        public final void e(int i, int i2, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f36995e = PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_X, -i);
                this.f36996f = PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, f2);
                this.f36997g = PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f3);
                this.f36998h = PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f3);
                float f4 = -i2;
                this.i = PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_X, f4);
                this.j = PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_X, f4);
                this.k = PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, 1.0f);
                this.l = PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 1.0f);
                this.m = PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 1.0f);
            }
        }

        public void f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
                this.f36994d = cVar;
            }
        }

        public void g(View[] viewArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, viewArr) == null) {
                this.a = viewArr;
            }
        }

        public void h() {
            AnimatorSet animatorSet;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (animatorSet = this.f36992b) == null) {
                return;
            }
            animatorSet.playTogether(this.f36993c);
            this.f36992b.start();
        }
    }

    /* loaded from: classes6.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.get().sendEmptyMessage(1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TbImageSwitch> a;

        public f(TbImageSwitch tbImageSwitch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageSwitch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(tbImageSwitch);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                TbImageSwitch tbImageSwitch = this.a.get();
                if (tbImageSwitch != null) {
                    tbImageSwitch.i();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbImageSwitch(Context context) {
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

    public static /* synthetic */ int d(TbImageSwitch tbImageSwitch) {
        int i = tbImageSwitch.f36991h + 1;
        tbImageSwitch.f36991h = i;
        return i;
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

    public final void i() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f36986c || (dVar = this.x) == null) {
            return;
        }
        this.f36986c = true;
        dVar.g(this.w);
        this.x.f(this.y);
        this.x.d(this.f36985b);
        this.x.h();
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
            addOnAttachStateChangeListener(this);
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

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u = new e(this.v);
            this.t = new Timer();
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
                        childAt.setAlpha(this.f36987d);
                        childAt.setScaleX(this.f36988e);
                        childAt.setScaleY(this.f36988e);
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

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View[] viewArr = this.w;
            int i = this.a;
            View view = viewArr[i - 1];
            System.arraycopy(viewArr, 0, viewArr, 1, i - 1);
            this.w[0] = view;
            removeAllViews();
            for (View view2 : this.w) {
                addView(view2);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            int i5 = 0;
            if (this.r > this.q) {
                this.j = (i3 - getPaddingRight()) - this.n;
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
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            int min = Math.min(this.r, this.q);
            setMeasuredDimension(FrameLayout.resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.o * min)) - ((min - 1) * this.n), i), FrameLayout.resolveSize(getPaddingTop() + getPaddingBottom() + this.p, i2));
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view) == null) || this.x == null) {
            return;
        }
        m();
        this.t.schedule(this.u, this.f36990g, this.f36989f);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            j();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048588, this) != null) {
            return;
        }
        int i = 0;
        if (!this.i) {
            int i2 = this.f36991h;
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
                if (i >= i5) {
                    return;
                }
                this.s.a(this.w[i], (i5 - 1) - i);
                i++;
            }
        } else {
            this.i = false;
            int count = this.s.getCount();
            this.r = count;
            if (count > this.q && this.x == null) {
                int i6 = this.o;
                this.x = new d(i6 / 2, i6 - this.n, this.f36987d, this.f36988e);
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
            if (bVar == null || bVar.getCount() <= 0) {
                return;
            }
            if (this.x != null) {
                while (i < this.q + 1) {
                    this.s.a(this.w[i], this.f36991h - i);
                    i++;
                }
                return;
            }
            while (true) {
                int i10 = this.r;
                if (i >= i10) {
                    return;
                }
                this.s.a(this.w[i], (i10 - 1) - i);
                i++;
            }
        }
    }

    public void setAdapter(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.s = bVar;
        }
    }

    @Override // android.view.View
    public void setAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.f36987d = f2;
        }
    }

    public void setAnimationDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.f36985b = i * 1000;
        }
    }

    public void setCarouselDelayPeriod(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f36990g = i * 1000;
        }
    }

    public void setCarouselPeriod(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.f36989f = i * 1000;
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            this.f36988e = f2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbImageSwitch(Context context, AttributeSet attributeSet) {
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
    public TbImageSwitch(Context context, AttributeSet attributeSet, int i) {
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
        this.f36985b = 3000;
        this.f36986c = false;
        this.f36987d = 0.0f;
        this.f36988e = 0.2f;
        this.f36989f = 3000;
        this.f36990g = 3000;
        this.f36991h = 3;
        this.i = true;
        this.y = new a(this);
        k();
    }
}
