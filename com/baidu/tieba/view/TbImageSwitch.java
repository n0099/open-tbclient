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
/* loaded from: classes13.dex */
public class TbImageSwitch extends FrameLayout implements View.OnAttachStateChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View[] A;
    public d B;
    public final c C;

    /* renamed from: e  reason: collision with root package name */
    public int f49234e;

    /* renamed from: f  reason: collision with root package name */
    public int f49235f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49236g;

    /* renamed from: h  reason: collision with root package name */
    public float f49237h;

    /* renamed from: i  reason: collision with root package name */
    public float f49238i;

    /* renamed from: j  reason: collision with root package name */
    public int f49239j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public b w;
    public Timer x;
    public e y;
    public f z;

    /* loaded from: classes13.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.n();
                TbImageSwitch.d(this.a);
                this.a.l %= this.a.w.getCount();
                this.a.w.b(this.a.l);
                this.a.w.a(this.a.A[0], this.a.l % this.a.w.getCount());
                this.a.f49236g = false;
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

    /* loaded from: classes13.dex */
    public interface b {
        void a(View view, int i2);

        void b(int i2);

        View c();

        int getCount();
    }

    /* loaded from: classes13.dex */
    public interface c {
        void onAnimationCancel(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationStart(Animator animator);
    }

    /* loaded from: classes13.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View[] a;

        /* renamed from: b  reason: collision with root package name */
        public AnimatorSet f49240b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Animator> f49241c;

        /* renamed from: d  reason: collision with root package name */
        public c f49242d;

        /* renamed from: e  reason: collision with root package name */
        public PropertyValuesHolder f49243e;

        /* renamed from: f  reason: collision with root package name */
        public PropertyValuesHolder f49244f;

        /* renamed from: g  reason: collision with root package name */
        public PropertyValuesHolder f49245g;

        /* renamed from: h  reason: collision with root package name */
        public PropertyValuesHolder f49246h;

        /* renamed from: i  reason: collision with root package name */
        public PropertyValuesHolder f49247i;

        /* renamed from: j  reason: collision with root package name */
        public PropertyValuesHolder f49248j;
        public PropertyValuesHolder k;
        public PropertyValuesHolder l;
        public PropertyValuesHolder m;
        public final Animator.AnimatorListener n;

        /* loaded from: classes13.dex */
        public class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f49249e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49249e = dVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f49249e.f49242d == null) {
                    return;
                }
                this.f49249e.f49242d.onAnimationCancel(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.f49249e.f49241c.clear();
                    this.f49249e.f49240b = null;
                    if (this.f49249e.f49242d != null) {
                        this.f49249e.f49242d.onAnimationEnd(animator);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.f49249e.f49242d == null) {
                    return;
                }
                this.f49249e.f49242d.onAnimationRepeat(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f49249e.f49242d == null) {
                    return;
                }
                this.f49249e.f49242d.onAnimationStart(animator);
            }
        }

        public d(int i2, int i3, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = new a(this);
            this.f49241c = new ArrayList();
            e(i2, i3, f2, f3);
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.f49240b = animatorSet;
            animatorSet.setDuration(i2);
            this.f49240b.addListener(this.n);
            List<Animator> list = this.f49241c;
            View[] viewArr = this.a;
            list.add(ObjectAnimator.ofPropertyValuesHolder(viewArr[viewArr.length - 1], this.f49243e, this.f49244f, this.f49245g, this.f49246h));
            for (int length = this.a.length - 2; length >= 0; length--) {
                this.f49241c.add(ObjectAnimator.ofPropertyValuesHolder(this.a[length], this.f49247i));
            }
            this.f49241c.add(ObjectAnimator.ofPropertyValuesHolder(this.a[0], this.f49248j, this.k, this.l, this.m));
        }

        public final void e(int i2, int i3, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f49243e = PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_X, -i2);
                this.f49244f = PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, f2);
                this.f49245g = PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f3);
                this.f49246h = PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f3);
                float f4 = -i3;
                this.f49247i = PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_X, f4);
                this.f49248j = PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_X, f4);
                this.k = PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, 1.0f);
                this.l = PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 1.0f);
                this.m = PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 1.0f);
            }
        }

        public void f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
                this.f49242d = cVar;
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
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (animatorSet = this.f49240b) == null) {
                return;
            }
            animatorSet.playTogether(this.f49241c);
            this.f49240b.start();
        }
    }

    /* loaded from: classes13.dex */
    public static class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<f> f49250e;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49250e = new WeakReference<>(fVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49250e.get().sendEmptyMessage(1);
            }
        }
    }

    /* loaded from: classes13.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ int d(TbImageSwitch tbImageSwitch) {
        int i2 = tbImageSwitch.l + 1;
        tbImageSwitch.l = i2;
        return i2;
    }

    public List<View> getChildViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                arrayList.add(getChildAt(i2));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void i() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f49236g || (dVar = this.B) == null) {
            return;
        }
        this.f49236g = true;
        dVar.g(this.A);
        this.B.f(this.C);
        this.B.d(this.f49235f);
        this.B.h();
    }

    public void init(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            this.u = i2;
            this.s = i3;
            this.t = i4;
            this.r = i5;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e eVar = this.y;
            if (eVar != null) {
                eVar.cancel();
                this.y = null;
            }
            Timer timer = this.x;
            if (timer != null) {
                timer.cancel();
                this.x.purge();
                this.x = null;
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.z = new f(this);
            addOnAttachStateChangeListener(this);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.y = new e(this.z);
            this.x = new Timer();
        }
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            View childAt = getChildAt(i2);
            if (this.A[i2].equals(childAt)) {
                int i3 = this.n;
                int i4 = this.s;
                int i5 = this.r;
                childAt.layout(i3 - ((i4 - i5) * i2), this.o, this.p - ((i4 - i5) * i2), this.q);
                if (this.v > this.u) {
                    if (i2 == 0) {
                        childAt.setAlpha(this.f49237h);
                        childAt.setScaleX(this.f49238i);
                        childAt.setScaleY(this.f49238i);
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

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View[] viewArr = this.A;
            int i2 = this.f49234e;
            View view = viewArr[i2 - 1];
            System.arraycopy(viewArr, 0, viewArr, 1, i2 - 1);
            this.A[0] = view;
            removeAllViews();
            for (View view2 : this.A) {
                addView(view2);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            int i6 = 0;
            if (this.v > this.u) {
                this.n = (i4 - getPaddingRight()) - this.r;
                this.o = getPaddingTop();
                this.p = this.n + this.s;
                this.q = i5 - getPaddingBottom();
                while (i6 < this.u + 1) {
                    m(i6);
                    i6++;
                }
                return;
            }
            this.n = (i4 - getPaddingRight()) - this.s;
            this.o = getPaddingTop();
            this.p = i4 - getPaddingRight();
            this.q = i5 - getPaddingBottom();
            while (i6 < this.v) {
                m(i6);
                i6++;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            int min = Math.min(this.v, this.u);
            setMeasuredDimension(FrameLayout.resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.s * min)) - ((min - 1) * this.r), i2), FrameLayout.resolveSize(getPaddingTop() + getPaddingBottom() + this.t, i3));
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view) == null) || this.B == null) {
            return;
        }
        l();
        this.x.schedule(this.y, this.k, this.f49239j);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            j();
        }
    }

    public void requestViewUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048588, this) != null) {
            return;
        }
        int i2 = 0;
        if (!this.m) {
            int i3 = this.l;
            if (this.B != null) {
                int i4 = i3;
                for (int i5 = 0; i5 < this.u + 1; i5++) {
                    this.w.a(this.A[i5], i3);
                    i4--;
                    if (i4 < 0) {
                        i3 = this.w.getCount() + i4;
                    } else {
                        i3 = i4 % this.w.getCount();
                    }
                }
                return;
            }
            while (true) {
                int i6 = this.v;
                if (i2 >= i6) {
                    return;
                }
                this.w.a(this.A[i2], (i6 - 1) - i2);
                i2++;
            }
        } else {
            this.m = false;
            int count = this.w.getCount();
            this.v = count;
            if (count > this.u && this.B == null) {
                int i7 = this.s;
                this.B = new d(i7 / 2, i7 - this.r, this.f49237h, this.f49238i);
            }
            int i8 = this.v;
            int i9 = this.u;
            if (i8 > i9) {
                i8 = i9 + 1;
            }
            this.f49234e = i8;
            this.A = new View[i8];
            for (int i10 = 0; i10 < this.f49234e; i10++) {
                View c2 = this.w.c();
                this.A[i10] = c2;
                addView(c2);
            }
            b bVar = this.w;
            if (bVar == null || bVar.getCount() <= 0) {
                return;
            }
            if (this.B != null) {
                while (i2 < this.u + 1) {
                    this.w.a(this.A[i2], this.l - i2);
                    i2++;
                }
                return;
            }
            while (true) {
                int i11 = this.v;
                if (i2 >= i11) {
                    return;
                }
                this.w.a(this.A[i2], (i11 - 1) - i2);
                i2++;
            }
        }
    }

    public void setAdapter(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.w = bVar;
        }
    }

    @Override // android.view.View
    public void setAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.f49237h = f2;
        }
    }

    public void setAnimationDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f49235f = i2 * 1000;
        }
    }

    public void setCarouselDelayPeriod(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.k = i2 * 1000;
        }
    }

    public void setCarouselPeriod(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f49239j = i2 * 1000;
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            this.f49238i = f2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbImageSwitch(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f49234e = 3;
        this.f49235f = 3000;
        this.f49236g = false;
        this.f49237h = 0.0f;
        this.f49238i = 0.2f;
        this.f49239j = 3000;
        this.k = 3000;
        this.l = 3;
        this.m = true;
        this.C = new a(this);
        k();
    }
}
