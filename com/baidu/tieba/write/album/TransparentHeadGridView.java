package com.baidu.tieba.write.album;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.GridView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class TransparentHeadGridView extends GridView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f22731e;

    /* renamed from: f  reason: collision with root package name */
    public float f22732f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22733g;

    /* renamed from: h  reason: collision with root package name */
    public int f22734h;

    /* renamed from: i  reason: collision with root package name */
    public View f22735i;
    public Interpolator j;
    public f k;
    public int l;
    public c m;
    public d n;
    public AbsListView.OnScrollListener o;
    public Context p;
    public int q;
    public boolean r;
    public e s;
    public AbsListView.OnScrollListener t;

    /* loaded from: classes4.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransparentHeadGridView f22736a;

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
            this.f22736a = transparentHeadGridView;
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f22736a.r) {
                    this.f22736a.setVisibility(8);
                }
                if (this.f22736a.n != null) {
                    this.f22736a.n.a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransparentHeadGridView f22737e;

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
            this.f22737e = transparentHeadGridView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            int height;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (this.f22737e.m != null && this.f22737e.q != 100 && this.f22737e.getPaddingTop() == 0) {
                        this.f22737e.m.a(100);
                        this.f22737e.q = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (this.f22737e.f22734h < 0) {
                        this.f22737e.f22734h = childAt.getTop();
                    }
                    int i5 = -(childAt.getTop() - this.f22737e.f22734h);
                    this.f22737e.f22733g = i5 == 0;
                    if (this.f22737e.f22735i != null) {
                        this.f22737e.f22735i.scrollTo(0, i5);
                    }
                    if (this.f22737e.m != null && childAt.getHeight() != 0 && this.f22737e.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != this.f22737e.q) {
                        this.f22737e.m.a(height);
                        this.f22737e.q = height;
                    }
                }
                if (this.f22737e.o != null) {
                    this.f22737e.o.onScroll(absListView, i2, i3, i4);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) || this.f22737e.o == null) {
                return;
            }
            this.f22737e.o.onScrollStateChanged(absListView, i2);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a();

        void b(int i2);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Interpolator f22738e;

        /* renamed from: f  reason: collision with root package name */
        public final int f22739f;

        /* renamed from: g  reason: collision with root package name */
        public final int f22740g;

        /* renamed from: h  reason: collision with root package name */
        public final long f22741h;

        /* renamed from: i  reason: collision with root package name */
        public e f22742i;
        public boolean j;
        public long k;
        public int l;
        public final /* synthetic */ TransparentHeadGridView m;

        public f(TransparentHeadGridView transparentHeadGridView, int i2, int i3, long j, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transparentHeadGridView, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), eVar};
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
            this.j = true;
            this.k = -1L;
            this.l = -1;
            this.f22740g = i2;
            this.f22739f = i3;
            this.f22738e = transparentHeadGridView.j;
            this.f22741h = j;
            this.f22742i = eVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j = false;
                this.m.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.k == -1) {
                    this.k = System.currentTimeMillis();
                } else {
                    int round = this.f22740g - Math.round((this.f22740g - this.f22739f) * this.f22738e.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.k) * 1000) / this.f22741h, 1000L), 0L)) / 1000.0f));
                    this.l = round;
                    this.m.setPadding(0, round, 0, 0);
                    if (this.m.n != null && this.l >= 0 && this.m.l > 0 && this.l <= this.m.l) {
                        this.m.n.b((this.l * 100) / this.m.l);
                    }
                }
                if (this.j && this.f22739f != this.l) {
                    this.m.postDelayed(this, 16L);
                    return;
                }
                e eVar = this.f22742i;
                if (eVar != null) {
                    eVar.a();
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
        this.f22731e = 0;
        this.f22732f = 0.0f;
        this.f22733g = true;
        this.f22734h = -1;
        this.q = -1;
        this.r = false;
        this.s = new a(this);
        this.t = new b(this);
        m(context);
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.p = context;
            setOnScrollListener(this.t);
            this.l = (int) (l.i(context) * 0.22f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setPadding(0, (int) ((10.0f - this.f22732f) / 2.0f), 0, 0);
            this.f22731e = 0;
            this.f22732f = 0.0f;
            if (this.r && getPaddingTop() > this.l) {
                o(getHeight(), 200L, 0L, this.s);
            } else {
                o(0, 200L, 0L, null);
            }
        }
    }

    public final void o(int i2, long j, long j2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), eVar}) == null) {
            f fVar = this.k;
            if (fVar != null) {
                fVar.a();
            }
            int paddingTop = getPaddingTop();
            if (paddingTop != i2) {
                if (this.j == null) {
                    this.j = new DecelerateInterpolator();
                }
                f fVar2 = new f(this, paddingTop, i2, j, eVar);
                this.k = fVar2;
                if (j2 > 0) {
                    postDelayed(fVar2, j2);
                } else {
                    post(fVar2);
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
                this.f22731e = 0;
                this.f22732f = 0.0f;
                if (this.r && getPaddingTop() > this.l) {
                    o(getHeight(), 200L, 0L, this.s);
                } else {
                    o(0, 200L, 0L, null);
                }
            } else if (action == 2) {
                if (this.f22732f == 0.0f) {
                    this.f22732f = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.f22732f && getPaddingTop() == 0 && this.f22733g) {
                    this.f22731e = 1;
                }
                if (this.f22731e == 1) {
                    int i3 = (int) ((y - this.f22732f) / 2.0f);
                    d dVar = this.n;
                    if (dVar != null && i3 >= 0 && (i2 = this.l) > 0 && i3 <= i2) {
                        dVar.b((i3 * 100) / i2);
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
            this.f22735i = view;
        }
    }

    public void setOnHeadDisplayChangeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public void setOnPullChangeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onScrollListener) == null) {
            this.o = onScrollListener;
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
        this.f22731e = 0;
        this.f22732f = 0.0f;
        this.f22733g = true;
        this.f22734h = -1;
        this.q = -1;
        this.r = false;
        this.s = new a(this);
        this.t = new b(this);
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
        this.f22731e = 0;
        this.f22732f = 0.0f;
        this.f22733g = true;
        this.f22734h = -1;
        this.q = -1;
        this.r = false;
        this.s = new a(this);
        this.t = new b(this);
        m(context);
    }
}
