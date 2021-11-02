package com.baidu.tieba.medialive.like;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/* loaded from: classes9.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SurfaceHolder f51385e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f51386f;

    /* renamed from: g  reason: collision with root package name */
    public g[] f51387g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f51388h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f51389i;
    public Random j;
    public int k;
    public int l;
    public List<Pair<PointF, PointF>> m;
    public PointF n;
    public PointF o;
    public volatile int p;
    public ArrayList<Bitmap> q;
    public e r;
    public float s;
    public float t;
    public ViewTreeObserver.OnGlobalLayoutListener u;

    /* loaded from: classes9.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HeartSurfaceView f51390e;

        public a(HeartSurfaceView heartSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51390e = heartSurfaceView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f51390e.m != null && this.f51390e.l == this.f51390e.getWidth() && this.f51390e.k == this.f51390e.getHeight()) {
                    return;
                }
                HeartSurfaceView heartSurfaceView = this.f51390e;
                heartSurfaceView.l = heartSurfaceView.getWidth();
                HeartSurfaceView heartSurfaceView2 = this.f51390e;
                heartSurfaceView2.k = heartSurfaceView2.getHeight();
                float dimensionPixelSize = this.f51390e.getResources().getDimensionPixelSize(b.a.r0.t1.c.liveshow_heart_start_x);
                float dimensionPixelSize2 = this.f51390e.getResources().getDimensionPixelSize(b.a.r0.t1.c.liveshow_heart_start_x1);
                float dimensionPixelSize3 = this.f51390e.getResources().getDimensionPixelSize(b.a.r0.t1.c.liveshow_heart_padding_bottom);
                float dimensionPixelSize4 = this.f51390e.getResources().getDimensionPixelSize(b.a.r0.t1.c.liveshow_heart_padding_top);
                PointF pointF = new PointF(dimensionPixelSize, this.f51390e.k - dimensionPixelSize3);
                PointF pointF2 = new PointF(dimensionPixelSize, dimensionPixelSize4);
                PointF pointF3 = new PointF(dimensionPixelSize2, this.f51390e.k - dimensionPixelSize3);
                PointF pointF4 = new PointF(dimensionPixelSize2, dimensionPixelSize4);
                this.f51390e.m = new ArrayList();
                this.f51390e.m.add(Pair.create(pointF, pointF2));
                this.f51390e.m.add(Pair.create(pointF3, pointF4));
                this.f51390e.n = new PointF(0.0f, this.f51390e.k * 0.5f);
                this.f51390e.o = new PointF(this.f51390e.l + this.f51390e.getResources().getDimensionPixelSize(b.a.r0.t1.c.liveshow_heart_padding_right), this.f51390e.k * 0.5f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HeartSurfaceView f51391e;

        public b(HeartSurfaceView heartSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51391e = heartSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (this.f51391e.f51388h) {
                    SystemClock.sleep(10L);
                    while (this.f51391e.f51388h && this.f51391e.p > 0) {
                        if (this.f51391e.p()) {
                            HeartSurfaceView.k(this.f51391e);
                        }
                        SystemClock.sleep(120L);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HeartSurfaceView f51392e;

        public c(HeartSurfaceView heartSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51392e = heartSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (this.f51392e.f51388h) {
                    try {
                        while (this.f51392e.f51388h && !this.f51392e.f51389i) {
                            SystemClock.sleep(300L);
                        }
                        if (!this.f51392e.f51388h) {
                            return;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            this.f51392e.s();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 < 30) {
                            try {
                                Thread.sleep(Math.max(30 - currentTimeMillis2, 0L));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public float f51393h;

        /* renamed from: i  reason: collision with root package name */
        public float f51394i;
        public float j;
        public float k;
        public float l;
        public float m;
        public float n;
        public int o;
        public int p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51393h = 0.22f;
            this.f51394i = 0.88f;
            this.j = 0.7f;
            this.k = 0.5f;
            this.l = 0.85f;
            this.m = 0.2f;
            this.n = 7.0f;
            this.o = 1;
            this.p = 255;
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.f
        public Object a(float f2) {
            InterceptResult invokeF;
            float f3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                float f4 = this.f51393h;
                if (f2 < f4) {
                    f3 = this.k + f2;
                } else {
                    float f5 = this.f51394i;
                    if (f2 < f5) {
                        f3 = this.j + (this.m * (f2 - f4));
                    } else {
                        f3 = f2 < ((float) this.o) ? this.l - (this.n * (f2 - f5)) : 0.0f;
                    }
                }
                return Integer.valueOf((int) (this.p * f3));
            }
            return invokeF.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(int i2, int i3);
    }

    /* loaded from: classes9.dex */
    public static abstract class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f51395a;

        /* renamed from: b  reason: collision with root package name */
        public long f51396b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f51397c;

        /* renamed from: d  reason: collision with root package name */
        public h f51398d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f51399e;

        /* renamed from: f  reason: collision with root package name */
        public float f51400f;

        /* renamed from: g  reason: collision with root package name */
        public float f51401g;

        public f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51399e = false;
            this.f51400f = 1.0f;
            this.f51401g = 0.5f;
            this.f51395a = i2;
        }

        public abstract Object a(float f2);

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51399e : invokeV.booleanValue;
        }

        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
                this.f51398d = hVar;
            }
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.f51395a = i2;
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f51396b = System.currentTimeMillis();
                this.f51397c = true;
                this.f51399e = true;
            }
        }

        public void update(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                float f2 = ((float) (j - this.f51396b)) / this.f51395a;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                if (f2 >= this.f51400f) {
                    this.f51399e = false;
                    h hVar = this.f51398d;
                    if (hVar != null) {
                        hVar.onUpdate(a(f2));
                        this.f51398d.onOver();
                        return;
                    }
                    return;
                }
                if (f2 < this.f51401g) {
                    this.f51397c = true;
                } else if (this.f51397c) {
                    h hVar2 = this.f51398d;
                    if (hVar2 != null) {
                        hVar2.a();
                    }
                    this.f51397c = false;
                }
                h hVar3 = this.f51398d;
                if (hVar3 != null) {
                    hVar3.onUpdate(a(f2));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f51402a;

        /* renamed from: b  reason: collision with root package name */
        public int f51403b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f51404c;

        /* renamed from: d  reason: collision with root package name */
        public int f51405d;

        /* renamed from: e  reason: collision with root package name */
        public RectF f51406e;

        /* renamed from: f  reason: collision with root package name */
        public float f51407f;

        /* renamed from: g  reason: collision with root package name */
        public int f51408g;

        /* renamed from: h  reason: collision with root package name */
        public int f51409h;

        /* renamed from: i  reason: collision with root package name */
        public i f51410i;
        public j j;
        public d k;
        public PointF l;
        public volatile boolean m;
        public e n;

        /* loaded from: classes9.dex */
        public class a implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f51411a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51411a = gVar;
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onOver() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f51411a.j(false);
                }
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onUpdate(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    this.f51411a.f51405d = ((Integer) obj).intValue();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f51412a;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51412a = gVar;
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onOver() {
                g gVar;
                e eVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = (gVar = this.f51412a).n) == null) {
                    return;
                }
                RectF rectF = gVar.f51406e;
                eVar.a((int) rectF.left, (int) rectF.top);
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onUpdate(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    PointF pointF = (PointF) obj;
                    g gVar = this.f51412a;
                    RectF rectF = gVar.f51406e;
                    float f2 = pointF.x;
                    rectF.set(f2, pointF.y, (gVar.f51409h * this.f51412a.f51407f) + f2, pointF.y + (this.f51412a.f51408g * this.f51412a.f51407f));
                    g gVar2 = this.f51412a;
                    gVar2.f51406e.offset(((-gVar2.f51409h) * this.f51412a.f51407f) / this.f51412a.f51403b, ((-this.f51412a.f51408g) * this.f51412a.f51407f) / this.f51412a.f51403b);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f51413a;

            public c(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51413a = gVar;
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onOver() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onUpdate(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    this.f51413a.f51407f = ((Float) obj).floatValue();
                    g gVar = this.f51413a;
                    gVar.f51406e.set(gVar.l.x, this.f51413a.l.y, this.f51413a.l.x + (this.f51413a.f51409h * this.f51413a.f51407f), this.f51413a.l.y + (this.f51413a.f51408g * this.f51413a.f51407f));
                    g gVar2 = this.f51413a;
                    gVar2.f51406e.offset(((-gVar2.f51409h) * this.f51413a.f51407f) / this.f51413a.f51403b, ((-this.f51413a.f51408g) * this.f51413a.f51407f) / this.f51413a.f51403b);
                }
            }
        }

        public g(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap, pointF, pointF2, pointF3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51402a = 2.0f;
            this.f51403b = 2;
            this.f51404c = bitmap;
            this.f51408g = bitmap.getHeight();
            this.f51409h = this.f51404c.getWidth();
            this.f51405d = 128;
            this.f51407f = 0.28f;
            this.l = pointF;
            float f2 = pointF.x;
            float f3 = pointF.y;
            RectF rectF = new RectF(f2, f3, this.f51409h + f2, this.f51408g + f3);
            this.f51406e = rectF;
            float f4 = this.f51402a;
            rectF.offset((-this.f51409h) / f4, (-this.f51408g) / f4);
            d dVar = new d(1500);
            this.k = dVar;
            dVar.c(new a(this));
            this.k.e();
            i iVar = new i(pointF, pointF2, pointF3, 1500);
            this.f51410i = iVar;
            iVar.c(new b(this));
            this.f51410i.e();
            j jVar = new j(300, 1.0f);
            this.j = jVar;
            jVar.c(new c(this));
            this.j.e();
            j(true);
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.booleanValue;
        }

        public final void i(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, pointF, pointF2, pointF3) == null) {
                this.f51404c = bitmap;
                this.f51408g = bitmap.getHeight();
                int width = this.f51404c.getWidth();
                this.f51409h = width;
                this.f51405d = 128;
                this.f51407f = 0.28f;
                this.l = pointF;
                RectF rectF = this.f51406e;
                float f2 = pointF.x;
                float f3 = pointF.y;
                rectF.set(f2, f3, width + f2, this.f51408g + f3);
                RectF rectF2 = this.f51406e;
                float f4 = this.f51402a;
                rectF2.offset((-this.f51409h) / f4, (-this.f51408g) / f4);
                this.f51410i.i(pointF, pointF2, pointF3, 1500);
                this.f51410i.e();
                this.j.e();
                this.k.e();
                j(true);
            }
        }

        public synchronized void j(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                synchronized (this) {
                    this.m = z;
                }
            }
        }

        public void update(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
                if (this.j.b()) {
                    this.j.update(j);
                }
                if (this.f51410i.b()) {
                    this.f51410i.update(j);
                }
                if (this.k.b()) {
                    this.k.update(j);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface h {
        void a();

        void onOver();

        void onUpdate(Object obj);
    }

    /* loaded from: classes9.dex */
    public static class i extends f {
        public static /* synthetic */ Interceptable $ic = null;
        public static float m = 1.0f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public PointF f51414h;

        /* renamed from: i  reason: collision with root package name */
        public PointF f51415i;
        public PointF j;
        public PointF k;
        public float l;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-769941025, "Lcom/baidu/tieba/medialive/like/HeartSurfaceView$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-769941025, "Lcom/baidu/tieba/medialive/like/HeartSurfaceView$i;");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PointF pointF, PointF pointF2, PointF pointF3, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pointF, pointF2, pointF3, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.l = 1.0f;
            this.f51414h = pointF;
            this.f51415i = pointF2;
            this.j = pointF3;
            this.k = h(m, pointF, pointF2);
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.f
        public Object a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                float f3 = m;
                float f4 = this.l;
                if (f3 < f4) {
                    if (f2 < f3) {
                        return g(f2);
                    }
                    return f((f2 - f3) / (f4 - f3), this.k, this.j, this.f51415i);
                }
                return h(f2, this.f51414h, this.f51415i);
            }
            return invokeF.objValue;
        }

        public final PointF f(float f2, PointF pointF, PointF pointF2, PointF pointF3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), pointF, pointF2, pointF3})) == null) {
                float f3 = 1.0f - f2;
                float f4 = f2 * f2;
                float f5 = f3 * f3;
                PointF pointF4 = new PointF();
                float f6 = f2 * 2.0f * f3;
                pointF4.x = (pointF.x * f5) + (pointF2.x * f6) + (pointF3.x * f4);
                pointF4.y = (f5 * pointF.y) + (f6 * pointF2.y) + (f4 * pointF3.y);
                return pointF4;
            }
            return (PointF) invokeCommon.objValue;
        }

        public PointF g(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
                PointF pointF = new PointF();
                PointF pointF2 = this.f51414h;
                pointF.x = pointF2.x;
                pointF.y = (this.l - f2) * pointF2.y;
                return pointF;
            }
            return (PointF) invokeF.objValue;
        }

        public PointF h(float f2, PointF pointF, PointF pointF2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), pointF, pointF2})) == null) {
                PointF pointF3 = new PointF();
                float f3 = pointF.x;
                pointF3.x = f3 + ((pointF2.x - f3) * f2);
                float f4 = pointF.y;
                pointF3.y = f4 + ((pointF2.y - f4) * f2);
                return pointF3;
            }
            return (PointF) invokeCommon.objValue;
        }

        public void i(PointF pointF, PointF pointF2, PointF pointF3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048580, this, pointF, pointF2, pointF3, i2) == null) {
                d(i2);
                this.f51414h = pointF;
                this.f51415i = pointF2;
                this.j = pointF3;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class j extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public float f51416h;

        /* renamed from: i  reason: collision with root package name */
        public float f51417i;
        public float j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i2, float f2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51416h = 0.28f;
            this.f51417i = 1.0f;
            this.j = f2;
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.f
        public Object a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                float f3 = this.j;
                float f4 = 1.0f;
                if (f2 < f3) {
                    float f5 = this.f51417i;
                    float f6 = this.f51416h;
                    f4 = (((f5 - f6) / f3) * f2) + f6;
                } else {
                    float f7 = this.f51417i;
                    float f8 = (((-f7) / f3) * f2) + (f7 * 2.0f);
                    if (f8 > 1.0f) {
                        f4 = f8;
                    }
                }
                return Float.valueOf(f4);
            }
            return invokeF.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeartSurfaceView(Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static Bitmap fromDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            return fromDrawable(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return (Bitmap) invokeL.objValue;
    }

    public static /* synthetic */ int k(HeartSurfaceView heartSurfaceView) {
        int i2 = heartSurfaceView.p;
        heartSurfaceView.p = i2 - 1;
        return i2;
    }

    public void addHeart(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.p >= 120) {
            return;
        }
        this.p += i2;
    }

    public e getAnimateEndListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (e) invokeV.objValue;
    }

    public final boolean o(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, bitmap, pointF, pointF2, pointF3)) == null) {
            int i2 = 0;
            while (true) {
                g[] gVarArr = this.f51387g;
                if (i2 >= gVarArr.length) {
                    return false;
                }
                if (gVarArr[i2] == null) {
                    gVarArr[i2] = new g(bitmap, pointF, pointF2, pointF3);
                    this.f51387g[i2].n = this.r;
                    break;
                } else if (!gVarArr[i2].h()) {
                    this.f51387g[i2].i(bitmap, pointF, pointF2, pointF3);
                    break;
                } else {
                    i2++;
                }
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            getViewTreeObserver().addOnGlobalLayoutListener(this.u);
            this.f51388h = true;
            v();
            u();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f51388h = false;
            super.onDetachedFromWindow();
            getViewTreeObserver().removeOnGlobalLayoutListener(this.u);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, view, i2) == null) {
            if (i2 != 0) {
                this.f51389i = false;
            }
            super.onVisibilityChanged(view, i2);
            setVisibility(i2);
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        List<Pair<PointF, PointF>> list;
        PointF pointF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.f51389i || this.n == null || this.o == null || (list = this.m) == null) {
                return false;
            }
            Pair<PointF, PointF> pair = list.get(this.j.nextInt(list.size()));
            PointF pointF2 = (PointF) pair.first;
            PointF pointF3 = (PointF) pair.second;
            float nextFloat = this.j.nextFloat();
            if (nextFloat == 0.0f) {
                nextFloat = 1.0f;
            }
            float f2 = this.o.x;
            float f3 = (f2 / 4.0f) + ((f2 / 2.0f) * nextFloat);
            if (this.j.nextBoolean()) {
                pointF = new PointF(f3, this.n.y * ((nextFloat * this.s) + this.t));
            } else {
                pointF = new PointF(f3, this.o.y * ((nextFloat * this.s) + this.t));
            }
            ArrayList<Bitmap> arrayList = this.q;
            return o(arrayList.get(this.j.nextInt(arrayList.size())), pointF2, pointF3, pointF);
        }
        return invokeV.booleanValue;
    }

    public final Bitmap q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? fromDrawable(getResources().getDrawable(i2)) : (Bitmap) invokeI.objValue;
    }

    public final Bitmap r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? fromDrawable(getResources().getDrawable(i2)) : (Bitmap) invokeI.objValue;
    }

    public final void s() {
        Canvas canvas;
        g[] gVarArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.m != null && this.f51389i) {
            try {
                canvas = this.f51385e.lockCanvas();
            } catch (Exception e2) {
                e2.printStackTrace();
                canvas = null;
            }
            if (canvas != null) {
                try {
                    try {
                        try {
                            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                            long currentTimeMillis = System.currentTimeMillis();
                            for (g gVar : this.f51387g) {
                                if (!this.f51388h || !this.f51389i) {
                                    break;
                                }
                                if (gVar != null && gVar.h()) {
                                    gVar.update(currentTimeMillis);
                                    this.f51386f.setAlpha(gVar.f51405d);
                                    canvas.drawBitmap(gVar.f51404c, (Rect) null, gVar.f51406e, this.f51386f);
                                }
                            }
                            this.f51385e.unlockCanvasAndPost(canvas);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            this.f51385e.unlockCanvasAndPost(canvas);
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.f51385e.unlockCanvasAndPost(canvas);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
        }
    }

    public void setAnimateEndListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.r = eVar;
        }
    }

    public void setClickBySelf(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    public void setUpResNormalMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ArrayList<Bitmap> arrayList = new ArrayList<>();
            this.q = arrayList;
            arrayList.add(q(b.a.r0.t1.d.liveshow_video_heart_like1));
            this.q.add(q(b.a.r0.t1.d.liveshow_video_heart_like2));
            this.q.add(q(b.a.r0.t1.d.liveshow_video_heart_like3));
            this.q.add(q(b.a.r0.t1.d.liveshow_video_heart_like4));
            this.q.add(q(b.a.r0.t1.d.liveshow_video_heart_like5));
        }
    }

    public void setUserPortrait(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bitmap) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048590, this, surfaceHolder, i2, i3, i4) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, surfaceHolder) == null) {
            g[] gVarArr = this.f51387g;
            if (gVarArr != null) {
                for (g gVar : gVarArr) {
                    if (gVar != null && gVar.h()) {
                        gVar.j(false);
                    }
                }
            }
            this.f51389i = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, surfaceHolder) == null) {
            this.f51389i = false;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            SurfaceHolder holder = getHolder();
            this.f51385e = holder;
            holder.addCallback(this);
            Paint paint = new Paint();
            this.f51386f = paint;
            paint.setAntiAlias(true);
            this.f51387g = new g[30];
            this.j = new Random();
            this.f51388h = true;
            this.f51389i = false;
            ArrayList<Bitmap> arrayList = new ArrayList<>();
            this.q = arrayList;
            arrayList.add(r(b.a.r0.t1.d.liveshow_video_heart_like1));
            this.q.add(r(b.a.r0.t1.d.liveshow_video_heart_like2));
            this.q.add(r(b.a.r0.t1.d.liveshow_video_heart_like3));
            this.q.add(r(b.a.r0.t1.d.liveshow_video_heart_like4));
            this.q.add(r(b.a.r0.t1.d.liveshow_video_heart_like5));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ExecutorUtilsExt.postOnElastic(new b(this), "live_add_heart", 1);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this), "live_draw_heart", 1);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeartSurfaceView(Context context, AttributeSet attributeSet) {
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
    public HeartSurfaceView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51388h = false;
        this.f51389i = false;
        this.s = 0.6f;
        this.t = 0.7f;
        this.u = new a(this);
        t();
    }

    public static Bitmap fromDrawable(Drawable drawable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, null, drawable, i2, i3)) == null) {
            Bitmap bitmap = null;
            if (drawable != null && i2 > 0 && i3 > 0) {
                try {
                    bitmap = Bitmap.createBitmap(i2, i3, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                    if (bitmap != null) {
                        Canvas canvas = new Canvas(bitmap);
                        drawable.setBounds(0, 0, i2, i3);
                        drawable.draw(canvas);
                    }
                } catch (Exception | OutOfMemoryError e2) {
                    e2.printStackTrace();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }
}
