package com.baidu.tieba.write.album;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.GridView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class TransparentHeadGridView extends GridView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float HEAD_HEIGHT_RATIO = 0.28f;
    public static final int SMOOTH_SCROLL_DURATION_MS = 200;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f51591e;

    /* renamed from: f  reason: collision with root package name */
    public float f51592f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51593g;

    /* renamed from: h  reason: collision with root package name */
    public int f51594h;

    /* renamed from: i  reason: collision with root package name */
    public View f51595i;

    /* renamed from: j  reason: collision with root package name */
    public Interpolator f51596j;

    /* renamed from: k  reason: collision with root package name */
    public g f51597k;
    public int l;
    public Animation m;
    public Animation n;
    public d o;
    public e p;
    public AbsListView.OnScrollListener q;
    public Context r;
    public int s;
    public boolean t;
    public Animation.AnimationListener u;
    public f v;
    public AbsListView.OnScrollListener w;

    /* loaded from: classes13.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransparentHeadGridView a;

        public a(TransparentHeadGridView transparentHeadGridView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transparentHeadGridView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transparentHeadGridView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.a.t) {
                this.a.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransparentHeadGridView a;

        public b(TransparentHeadGridView transparentHeadGridView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transparentHeadGridView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transparentHeadGridView;
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.t) {
                    this.a.setVisibility(8);
                }
                if (this.a.p != null) {
                    this.a.p.a();
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransparentHeadGridView f51598e;

        public c(TransparentHeadGridView transparentHeadGridView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transparentHeadGridView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51598e = transparentHeadGridView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            int height;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (this.f51598e.o != null && this.f51598e.s != 100 && this.f51598e.getPaddingTop() == 0) {
                        this.f51598e.o.a(100);
                        this.f51598e.s = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (this.f51598e.f51594h < 0) {
                        this.f51598e.f51594h = childAt.getTop();
                    }
                    int i5 = -(childAt.getTop() - this.f51598e.f51594h);
                    this.f51598e.f51593g = i5 == 0;
                    if (this.f51598e.f51595i != null) {
                        this.f51598e.f51595i.scrollTo(0, i5);
                    }
                    if (this.f51598e.o != null && childAt.getHeight() != 0 && this.f51598e.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != this.f51598e.s) {
                        this.f51598e.o.a(height);
                        this.f51598e.s = height;
                    }
                }
                if (this.f51598e.q != null) {
                    this.f51598e.q.onScroll(absListView, i2, i3, i4);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) || this.f51598e.q == null) {
                return;
            }
            this.f51598e.q.onScrollStateChanged(absListView, i2);
        }
    }

    /* loaded from: classes13.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes13.dex */
    public interface e {
        void a();

        void b(int i2);
    }

    /* loaded from: classes13.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes13.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Interpolator f51599e;

        /* renamed from: f  reason: collision with root package name */
        public final int f51600f;

        /* renamed from: g  reason: collision with root package name */
        public final int f51601g;

        /* renamed from: h  reason: collision with root package name */
        public final long f51602h;

        /* renamed from: i  reason: collision with root package name */
        public f f51603i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f51604j;

        /* renamed from: k  reason: collision with root package name */
        public long f51605k;
        public int l;
        public final /* synthetic */ TransparentHeadGridView m;

        public g(TransparentHeadGridView transparentHeadGridView, int i2, int i3, long j2, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transparentHeadGridView, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = transparentHeadGridView;
            this.f51604j = true;
            this.f51605k = -1L;
            this.l = -1;
            this.f51601g = i2;
            this.f51600f = i3;
            this.f51599e = transparentHeadGridView.f51596j;
            this.f51602h = j2;
            this.f51603i = fVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51604j = false;
                this.m.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f51605k == -1) {
                    this.f51605k = System.currentTimeMillis();
                } else {
                    int round = this.f51601g - Math.round((this.f51601g - this.f51600f) * this.f51599e.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.f51605k) * 1000) / this.f51602h, 1000L), 0L)) / 1000.0f));
                    this.l = round;
                    this.m.setPadding(0, round, 0, 0);
                    if (this.m.p != null && this.l >= 0 && this.m.l > 0 && this.l <= this.m.l) {
                        this.m.p.b((this.l * 100) / this.m.l);
                    }
                }
                if (this.f51604j && this.f51600f != this.l) {
                    this.m.postDelayed(this, 16L);
                    return;
                }
                f fVar = this.f51603i;
                if (fVar != null) {
                    fVar.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransparentHeadGridView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51591e = 0;
        this.f51592f = 0.0f;
        this.f51593g = true;
        this.f51594h = -1;
        this.s = -1;
        this.t = false;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this);
        m(context);
    }

    public void hideToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f51591e = 0;
            if (this.n == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.r, c.a.t0.o4.b.out_to_bottom);
                this.n = loadAnimation;
                loadAnimation.setAnimationListener(this.u);
            }
            startAnimation(this.n);
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.r = context;
            setOnScrollListener(this.w);
            this.l = (int) (n.i(context) * 0.22f);
        }
    }

    public final void n(int i2, long j2, long j3, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), fVar}) == null) {
            g gVar = this.f51597k;
            if (gVar != null) {
                gVar.a();
            }
            int paddingTop = getPaddingTop();
            if (paddingTop != i2) {
                if (this.f51596j == null) {
                    this.f51596j = new DecelerateInterpolator();
                }
                g gVar2 = new g(this, paddingTop, i2, j2, fVar);
                this.f51597k = gVar2;
                if (j3 > 0) {
                    postDelayed(gVar2, j3);
                } else {
                    post(gVar2);
                }
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 1) {
                this.f51591e = 0;
                this.f51592f = 0.0f;
                if (this.t && getPaddingTop() > this.l) {
                    n(getHeight(), 200L, 0L, this.v);
                } else {
                    n(0, 200L, 0L, null);
                }
            } else if (action == 2) {
                if (this.f51592f == 0.0f) {
                    this.f51592f = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.f51592f && getPaddingTop() == 0 && this.f51593g) {
                    this.f51591e = 1;
                }
                if (this.f51591e == 1) {
                    int i3 = (int) ((y - this.f51592f) / 2.0f);
                    e eVar = this.p;
                    if (eVar != null && i3 >= 0 && (i2 = this.l) > 0 && i3 <= i2) {
                        eVar.b((i3 * 100) / i2);
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setBottomMoveView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.f51595i = view;
        }
    }

    public void setOnHeadDisplayChangeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.o = dVar;
        }
    }

    public void setOnPullChangeListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.p = eVar;
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onScrollListener) == null) {
            this.q = onScrollListener;
        }
    }

    public void showFromBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(0);
            setPadding(0, 0, 0, 0);
            this.f51591e = 0;
            if (this.m == null) {
                this.m = AnimationUtils.loadAnimation(this.r, c.a.t0.o4.b.in_from_bottom);
            }
            startAnimation(this.m);
        }
    }

    public void smoothScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            setPadding(0, (int) ((10.0f - this.f51592f) / 2.0f), 0, 0);
            this.f51591e = 0;
            this.f51592f = 0.0f;
            if (this.t && getPaddingTop() > this.l) {
                n(getHeight(), 200L, 0L, this.v);
            } else {
                n(0, 200L, 0L, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51591e = 0;
        this.f51592f = 0.0f;
        this.f51593g = true;
        this.f51594h = -1;
        this.s = -1;
        this.t = false;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this);
        m(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51591e = 0;
        this.f51592f = 0.0f;
        this.f51593g = true;
        this.f51594h = -1;
        this.s = -1;
        this.t = false;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this);
        m(context);
    }
}
