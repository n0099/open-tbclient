package com.baidu.tieba.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class TbPreViewFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f58671e;

    /* renamed from: f  reason: collision with root package name */
    public int f58672f;

    /* renamed from: g  reason: collision with root package name */
    public float f58673g;

    /* renamed from: h  reason: collision with root package name */
    public float f58674h;

    /* renamed from: i  reason: collision with root package name */
    public float f58675i;

    /* renamed from: j  reason: collision with root package name */
    public float f58676j;
    public float k;
    public f l;
    public g m;
    public e n;
    public boolean o;
    public boolean p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f58677e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f58678f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPreViewFrameLayout f58679g;

        /* renamed from: com.baidu.tieba.view.widget.TbPreViewFrameLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1806a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f58680e;

            public C1806a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58680e = aVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < this.f58680e.f58679g.f58673g) {
                        floatValue = this.f58680e.f58679g.f58673g;
                    }
                    if (floatValue > 1.0f) {
                        floatValue = 1.0f;
                    }
                    float f2 = (1.0f - floatValue) + 0.04f;
                    if (this.f58680e.f58679g.f58671e / this.f58680e.f58679g.f58672f > 1.0f || (l.i(this.f58680e.f58679g.getContext()) - this.f58680e.f58679g.getFullRect()[1]) / 2 > this.f58680e.f58677e.getHeight() / 2) {
                        this.f58680e.f58679g.setTranslationY((-this.f58680e.f58679g.f58674h) * f2);
                        f2 = 0.0f;
                        this.f58680e.f58679g.n();
                        floatValue = 1.0f;
                    } else {
                        this.f58680e.f58679g.m(floatValue, f2);
                    }
                    this.f58680e.f58679g.u = floatValue;
                    this.f58680e.f58679g.v = f2;
                    if (this.f58680e.f58679g.l != null) {
                        this.f58680e.f58679g.l.b(this.f58680e.f58677e, floatValue, floatValue, 0.0f, f2);
                    }
                    a aVar = this.f58680e;
                    f fVar = aVar.f58678f;
                    if (fVar != null) {
                        fVar.b(aVar.f58677e, floatValue, floatValue, 0.0f, f2);
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f58681e;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58681e = aVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    if (this.f58681e.f58679g.l != null) {
                        this.f58681e.f58679g.l.a(this.f58681e.f58677e, true);
                    }
                    a aVar = this.f58681e;
                    f fVar = aVar.f58678f;
                    if (fVar != null) {
                        fVar.a(aVar.f58677e, true);
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    if (this.f58681e.f58679g.l != null) {
                        this.f58681e.f58679g.l.c(true);
                    }
                    f fVar = this.f58681e.f58678f;
                    if (fVar != null) {
                        fVar.c(true);
                    }
                }
            }
        }

        public a(TbPreViewFrameLayout tbPreViewFrameLayout, View view, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPreViewFrameLayout, view, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58679g = tbPreViewFrameLayout;
            this.f58677e = view;
            this.f58678f = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] fullRect = this.f58679g.getFullRect();
                this.f58679g.f58673g = (((fullRect[1] - this.f58677e.getHeight()) + 0.0f) * 1.0f) / fullRect[1];
                TbPreViewFrameLayout tbPreViewFrameLayout = this.f58679g;
                tbPreViewFrameLayout.f58673g = Math.abs(Math.round(tbPreViewFrameLayout.f58673g * 100.0f) / 100.0f);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, this.f58679g.f58673g);
                ofFloat.setDuration(250L);
                ofFloat.addUpdateListener(new C1806a(this));
                ofFloat.addListener(new b(this));
                ofFloat.start();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPreViewFrameLayout f58682e;

        public b(TbPreViewFrameLayout tbPreViewFrameLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPreViewFrameLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58682e = tbPreViewFrameLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() + this.f58682e.v;
                if (this.f58682e.l != null) {
                    this.f58682e.l.b(null, this.f58682e.u, this.f58682e.u, 0.0f, floatValue);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f58683e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f58684f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPreViewFrameLayout f58685g;

        public c(TbPreViewFrameLayout tbPreViewFrameLayout, View view, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPreViewFrameLayout, view, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58685g = tbPreViewFrameLayout;
            this.f58683e = view;
            this.f58684f = fVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < this.f58685g.f58673g) {
                    floatValue = this.f58685g.f58673g;
                }
                if (floatValue > 1.0f) {
                    floatValue = 1.0f;
                }
                float f2 = 1.0f - floatValue;
                if (this.f58685g.f58671e / this.f58685g.f58672f > 1.0f || (l.i(this.f58685g.getContext()) - this.f58685g.getFullRect()[1]) / 2 > this.f58683e.getHeight() / 2) {
                    this.f58685g.setTranslationY((-this.f58685g.f58674h) * f2);
                    f2 = 0.0f;
                    this.f58685g.n();
                    floatValue = 1.0f;
                } else {
                    this.f58685g.m(floatValue, f2);
                }
                if (this.f58685g.l != null) {
                    this.f58685g.l.d(this.f58683e, floatValue, floatValue, 0.0f, f2);
                }
                f fVar = this.f58684f;
                if (fVar != null) {
                    fVar.d(this.f58683e, floatValue, floatValue, 0.0f, f2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f58686e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f58687f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPreViewFrameLayout f58688g;

        public d(TbPreViewFrameLayout tbPreViewFrameLayout, View view, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPreViewFrameLayout, view, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58688g = tbPreViewFrameLayout;
            this.f58686e = view;
            this.f58687f = fVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.f58688g.l != null) {
                    this.f58688g.l.a(this.f58686e, false);
                }
                f fVar = this.f58687f;
                if (fVar != null) {
                    fVar.a(this.f58686e, false);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.f58688g.l != null) {
                    this.f58688g.l.c(false);
                }
                f fVar = this.f58687f;
                if (fVar != null) {
                    fVar.c(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        int[] a();
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(View view, boolean z);

        void b(View view, float f2, float f3, float f4, float f5);

        void c(boolean z);

        void d(View view, float f2, float f3, float f4, float f5);
    }

    /* loaded from: classes7.dex */
    public interface g {
        void a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent);

        void c(MotionEvent motionEvent);

        void d(MotionEvent motionEvent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbPreViewFrameLayout(@NonNull Context context) {
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

    public float getContainerBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.t : invokeV.floatValue;
    }

    public float getContainerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t - this.s : invokeV.floatValue;
    }

    public float getContainerLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : invokeV.floatValue;
    }

    public float getContainerRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.r : invokeV.floatValue;
    }

    public float getContainerTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s : invokeV.floatValue;
    }

    public float getContainerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Math.round(this.r - this.q) : invokeV.floatValue;
    }

    public int[] getFullRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int k = l.k(getContext());
            int i2 = l.i(getContext());
            e eVar = this.n;
            int[] a2 = eVar != null ? eVar.a() : new int[]{l.k(getContext()), l.i(getContext())};
            a2[0] = Math.min(k, a2[0]);
            a2[1] = Math.min(i2, a2[1]);
            return a2;
        }
        return (int[]) invokeV.objValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58673g : invokeV.floatValue;
    }

    public float getTranslate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58674h : invokeV.floatValue;
    }

    public void hideToolsView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            hideToolsView(view, null);
        }
    }

    public boolean isCanDrag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean isCanTouch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public final void m(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            int[] fullRect = getFullRect();
            float f4 = -f2;
            this.q = ((f4 + 1.0f) * fullRect[0]) / 2.0f;
            this.r = ((f2 + 1.0f) * fullRect[0]) / 2.0f;
            this.t = ((1.0f - (Math.round((f3 + f4) * 100.0f) / 100.0f)) * fullRect[1]) / 2.0f;
            this.s = ((1.0f - (Math.round(((f3 / 1.25f) + f2) * 100.0f) / 100.0f)) * fullRect[1]) / 2.0f;
        }
    }

    public void moveY(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
            ofFloat.setDuration(250L);
            ofFloat.addUpdateListener(new b(this));
            ofFloat.start();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.q = getLeft();
            this.r = getRight();
            this.s = getTop() + getTranslationY();
            this.t = getBottom() + getTranslationY();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        g gVar;
        g gVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            if (!this.o) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f58675i = motionEvent.getX();
                this.f58676j = motionEvent.getY();
                g gVar3 = this.m;
                if (gVar3 != null) {
                    gVar3.d(motionEvent);
                }
            } else if (action == 1 || action == 3) {
                if (Math.abs(this.f58675i - motionEvent.getX()) > this.k && (this.f58675i - motionEvent.getX()) - 50.0f > Math.abs(this.f58676j - motionEvent.getY()) && this.p) {
                    g gVar4 = this.m;
                    if (gVar4 != null) {
                        gVar4.b(motionEvent);
                    }
                } else if (Math.abs(this.f58675i - motionEvent.getX()) > this.k && (motionEvent.getX() - this.f58675i) - 50.0f > Math.abs(this.f58676j - motionEvent.getY()) && this.p && (gVar = this.m) != null) {
                    gVar.a(motionEvent);
                }
                if (Math.abs(this.f58675i - motionEvent.getX()) < 30.0f && Math.abs(this.f58676j - motionEvent.getY()) < 30.0f && motionEvent.getY() <= l.i(getContext()) * 0.6d && (gVar2 = this.m) != null) {
                    gVar2.c(motionEvent);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void onVideoSizeChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            this.f58671e = i2;
            this.f58672f = i3;
        }
    }

    public void setCanDrag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.p = z;
        }
    }

    public void setCanTouch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.o = z;
        }
    }

    public void setOnVideoViewRectCallback(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public void setOnViewChangedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) {
            this.l = fVar;
        }
    }

    public void setOnViewDragListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gVar) == null) {
            this.m = gVar;
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            this.f58673g = f2;
        }
    }

    public void setTranslate(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
            this.f58674h = f2;
        }
    }

    public void showToolsView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            showToolsView(view, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbPreViewFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    public void hideToolsView(View view, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view, fVar) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f58673g, 1.0f);
            ofFloat.setDuration(250L);
            ofFloat.addUpdateListener(new c(this, view, fVar));
            ofFloat.addListener(new d(this, view, fVar));
            ofFloat.start();
        }
    }

    public void showToolsView(View view, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, view, fVar) == null) || view == null) {
            return;
        }
        view.post(new a(this, view, fVar));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbPreViewFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f58673g = 0.7f;
        this.f58674h = 300.0f;
        this.f58675i = 0.0f;
        this.f58676j = 0.0f;
        this.o = true;
        this.p = true;
        this.u = 1.0f;
        this.v = 0.0f;
        this.k = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
