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
import com.repackage.qi;
/* loaded from: classes4.dex */
public class TransparentHeadGridView extends GridView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public float b;
    public boolean c;
    public int d;
    public View e;
    public Interpolator f;
    public f g;
    public int h;
    public c i;
    public d j;
    public AbsListView.OnScrollListener k;
    public Context l;
    public int m;
    public boolean n;
    public e o;
    public AbsListView.OnScrollListener p;

    /* loaded from: classes4.dex */
    public class a implements e {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transparentHeadGridView;
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.n) {
                    this.a.setVisibility(8);
                }
                if (this.a.j != null) {
                    this.a.j.a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transparentHeadGridView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int height;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (this.a.i != null && this.a.m != 100 && this.a.getPaddingTop() == 0) {
                        this.a.i.a(100);
                        this.a.m = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (this.a.d < 0) {
                        this.a.d = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - this.a.d);
                    this.a.c = i4 == 0;
                    if (this.a.e != null) {
                        this.a.e.scrollTo(0, i4);
                    }
                    if (this.a.i != null && childAt.getHeight() != 0 && this.a.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != this.a.m) {
                        this.a.i.a(height);
                        this.a.m = height;
                    }
                }
                if (this.a.k != null) {
                    this.a.k.onScroll(absListView, i, i2, i3);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) || this.a.k == null) {
                return;
            }
            this.a.k.onScrollStateChanged(absListView, i);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a();

        void b(int i);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Interpolator a;
        public final int b;
        public final int c;
        public final long d;
        public e e;
        public boolean f;
        public long g;
        public int h;
        public final /* synthetic */ TransparentHeadGridView i;

        public f(TransparentHeadGridView transparentHeadGridView, int i, int i2, long j, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transparentHeadGridView, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = transparentHeadGridView;
            this.f = true;
            this.g = -1L;
            this.h = -1;
            this.c = i;
            this.b = i2;
            this.a = transparentHeadGridView.f;
            this.d = j;
            this.e = eVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f = false;
                this.i.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.g == -1) {
                    this.g = System.currentTimeMillis();
                } else {
                    int round = this.c - Math.round((this.c - this.b) * this.a.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.g) * 1000) / this.d, 1000L), 0L)) / 1000.0f));
                    this.h = round;
                    this.i.setPadding(0, round, 0, 0);
                    if (this.i.j != null && this.h >= 0 && this.i.h > 0 && this.h <= this.i.h) {
                        this.i.j.b((this.h * 100) / this.i.h);
                    }
                }
                if (this.f && this.b != this.h) {
                    this.i.postDelayed(this, 16L);
                    return;
                }
                e eVar = this.e;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0.0f;
        this.c = true;
        this.d = -1;
        this.m = -1;
        this.n = false;
        this.o = new a(this);
        this.p = new b(this);
        m(context);
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.l = context;
            setOnScrollListener(this.p);
            this.h = (int) (qi.i(context) * 0.22f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setPadding(0, (int) ((10.0f - this.b) / 2.0f), 0, 0);
            this.a = 0;
            this.b = 0.0f;
            if (this.n && getPaddingTop() > this.h) {
                o(getHeight(), 200L, 0L, this.o);
            } else {
                o(0, 200L, 0L, null);
            }
        }
    }

    public final void o(int i, long j, long j2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), eVar}) == null) {
            f fVar = this.g;
            if (fVar != null) {
                fVar.a();
            }
            int paddingTop = getPaddingTop();
            if (paddingTop != i) {
                if (this.f == null) {
                    this.f = new DecelerateInterpolator();
                }
                f fVar2 = new f(this, paddingTop, i, j, eVar);
                this.g = fVar2;
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 1) {
                this.a = 0;
                this.b = 0.0f;
                if (this.n && getPaddingTop() > this.h) {
                    o(getHeight(), 200L, 0L, this.o);
                } else {
                    o(0, 200L, 0L, null);
                }
            } else if (action == 2) {
                if (this.b == 0.0f) {
                    this.b = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.b && getPaddingTop() == 0 && this.c) {
                    this.a = 1;
                }
                if (this.a == 1) {
                    int i2 = (int) ((y - this.b) / 2.0f);
                    d dVar = this.j;
                    if (dVar != null && i2 >= 0 && (i = this.h) > 0 && i2 <= i) {
                        dVar.b((i2 * 100) / i);
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setBottomMoveView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.e = view2;
        }
    }

    public void setOnHeadDisplayChangeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.i = cVar;
        }
    }

    public void setOnPullChangeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onScrollListener) == null) {
            this.k = onScrollListener;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0.0f;
        this.c = true;
        this.d = -1;
        this.m = -1;
        this.n = false;
        this.o = new a(this);
        this.p = new b(this);
        m(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 0;
        this.b = 0.0f;
        this.c = true;
        this.d = -1;
        this.m = -1;
        this.n = false;
        this.o = new a(this);
        this.p = new b(this);
        m(context);
    }
}
