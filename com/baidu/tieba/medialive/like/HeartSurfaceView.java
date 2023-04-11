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
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceHolder a;
    public Paint b;
    public g[] c;
    public volatile boolean d;
    public volatile boolean e;
    public Random f;
    public int g;
    public int h;
    public List<Pair<PointF, PointF>> i;
    public PointF j;
    public PointF k;
    public volatile int l;
    public ArrayList<Bitmap> m;
    public Bitmap n;
    public e o;
    public float p;
    public float q;
    public ViewTreeObserver.OnGlobalLayoutListener r;

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a();

        void onOver();

        void onUpdate(Object obj);
    }

    public void setClickBySelf(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048589, this, surfaceHolder, i2, i3, i4) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public int b;
        public Bitmap c;
        public int d;
        public RectF e;
        public float f;
        public int g;
        public int h;
        public i i;
        public j j;
        public d k;
        public PointF l;
        public volatile boolean m;
        public e n;

        /* loaded from: classes5.dex */
        public class a implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onUpdate(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    this.a.d = ((Integer) obj).intValue();
                }
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onOver() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.j(false);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onOver() {
                g gVar;
                e eVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (eVar = (gVar = this.a).n) != null) {
                    RectF rectF = gVar.e;
                    eVar.a((int) rectF.left, (int) rectF.top);
                }
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onUpdate(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    PointF pointF = (PointF) obj;
                    g gVar = this.a;
                    RectF rectF = gVar.e;
                    float f = pointF.x;
                    rectF.set(f, pointF.y, (gVar.h * this.a.f) + f, pointF.y + (this.a.g * this.a.f));
                    g gVar2 = this.a;
                    gVar2.e.offset(((-gVar2.h) * this.a.f) / this.a.b, ((-this.a.g) * this.a.f) / this.a.b);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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

            public c(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onUpdate(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    this.a.f = ((Float) obj).floatValue();
                    g gVar = this.a;
                    gVar.e.set(gVar.l.x, this.a.l.y, this.a.l.x + (this.a.h * this.a.f), this.a.l.y + (this.a.g * this.a.f));
                    g gVar2 = this.a;
                    gVar2.e.offset(((-gVar2.h) * this.a.f) / this.a.b, ((-this.a.g) * this.a.f) / this.a.b);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 2.0f;
            this.b = 2;
            this.c = bitmap;
            this.g = bitmap.getHeight();
            this.h = this.c.getWidth();
            this.d = 128;
            this.f = 0.28f;
            this.l = pointF;
            float f = pointF.x;
            float f2 = pointF.y;
            RectF rectF = new RectF(f, f2, this.h + f, this.g + f2);
            this.e = rectF;
            float f3 = this.a;
            rectF.offset((-this.h) / f3, (-this.g) / f3);
            d dVar = new d(1500);
            this.k = dVar;
            dVar.c(new a(this));
            this.k.e();
            i iVar = new i(pointF, pointF2, pointF3, 1500);
            this.i = iVar;
            iVar.c(new b(this));
            this.i.e();
            j jVar = new j(300, 1.0f);
            this.j = jVar;
            jVar.c(new c(this));
            this.j.e();
            j(true);
        }

        public synchronized void j(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                synchronized (this) {
                    this.m = z;
                }
            }
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.m;
            }
            return invokeV.booleanValue;
        }

        public final void i(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, pointF, pointF2, pointF3) == null) {
                this.c = bitmap;
                this.g = bitmap.getHeight();
                int width = this.c.getWidth();
                this.h = width;
                this.d = 128;
                this.f = 0.28f;
                this.l = pointF;
                RectF rectF = this.e;
                float f = pointF.x;
                float f2 = pointF.y;
                rectF.set(f, f2, width + f, this.g + f2);
                RectF rectF2 = this.e;
                float f3 = this.a;
                rectF2.offset((-this.h) / f3, (-this.g) / f3);
                this.i.i(pointF, pointF2, pointF3, 1500);
                this.i.e();
                this.j.e();
                this.k.e();
                j(true);
            }
        }

        public void update(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
                if (this.j.b()) {
                    this.j.update(j);
                }
                if (this.i.b()) {
                    this.i.update(j);
                }
                if (this.k.b()) {
                    this.k.update(j);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeartSurfaceView a;

        public a(HeartSurfaceView heartSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = heartSurfaceView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.i == null || this.a.h != this.a.getWidth() || this.a.g != this.a.getHeight()) {
                    HeartSurfaceView heartSurfaceView = this.a;
                    heartSurfaceView.h = heartSurfaceView.getWidth();
                    HeartSurfaceView heartSurfaceView2 = this.a;
                    heartSurfaceView2.g = heartSurfaceView2.getHeight();
                    float dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070418);
                    float dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070419);
                    float dimensionPixelSize3 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070415);
                    float dimensionPixelSize4 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070417);
                    PointF pointF = new PointF(dimensionPixelSize, this.a.g - dimensionPixelSize3);
                    PointF pointF2 = new PointF(dimensionPixelSize, dimensionPixelSize4);
                    PointF pointF3 = new PointF(dimensionPixelSize2, this.a.g - dimensionPixelSize3);
                    PointF pointF4 = new PointF(dimensionPixelSize2, dimensionPixelSize4);
                    this.a.i = new ArrayList();
                    this.a.i.add(Pair.create(pointF, pointF2));
                    this.a.i.add(Pair.create(pointF3, pointF4));
                    this.a.j = new PointF(0.0f, this.a.g * 0.5f);
                    this.a.k = new PointF(this.a.h + this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070416), this.a.g * 0.5f);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeartSurfaceView a;

        public b(HeartSurfaceView heartSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = heartSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (this.a.d) {
                    SystemClock.sleep(10L);
                    while (this.a.d && this.a.l > 0) {
                        if (this.a.q()) {
                            HeartSurfaceView.k(this.a);
                        }
                        SystemClock.sleep(120L);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeartSurfaceView a;

        public c(HeartSurfaceView heartSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = heartSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (this.a.d) {
                    try {
                        while (this.a.d && !this.a.e) {
                            SystemClock.sleep(300L);
                        }
                        if (this.a.d) {
                            long currentTimeMillis = System.currentTimeMillis();
                            try {
                                this.a.t();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 < 30) {
                                try {
                                    Thread.sleep(Math.max(30 - currentTimeMillis2, 0L));
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } else {
                            return;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float h;
        public float i;
        public float j;
        public float k;
        public float l;
        public float m;
        public float n;
        public int o;
        public int p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = 0.22f;
            this.i = 0.88f;
            this.j = 0.7f;
            this.k = 0.5f;
            this.l = 0.85f;
            this.m = 0.2f;
            this.n = 7.0f;
            this.o = 1;
            this.p = 255;
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.f
        public Object a(float f) {
            InterceptResult invokeF;
            float f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                float f3 = this.h;
                if (f < f3) {
                    f2 = this.k + f;
                } else {
                    float f4 = this.i;
                    if (f < f4) {
                        f2 = this.j + (this.m * (f - f3));
                    } else if (f < this.o) {
                        f2 = this.l - (this.n * (f - f4));
                    } else {
                        f2 = 0.0f;
                    }
                }
                return Integer.valueOf((int) (this.p * f2));
            }
            return invokeF.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public volatile boolean c;
        public h d;
        public volatile boolean e;
        public float f;
        public float g;

        public abstract Object a(float f);

        public f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = false;
            this.f = 1.0f;
            this.g = 0.5f;
            this.a = i;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.e;
            }
            return invokeV.booleanValue;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b = System.currentTimeMillis();
                this.c = true;
                this.e = true;
            }
        }

        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
                this.d = hVar;
            }
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.a = i;
            }
        }

        public void update(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                float f = ((float) (j - this.b)) / this.a;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                if (f >= this.f) {
                    this.e = false;
                    h hVar = this.d;
                    if (hVar != null) {
                        hVar.onUpdate(a(f));
                        this.d.onOver();
                        return;
                    }
                    return;
                }
                if (f < this.g) {
                    this.c = true;
                } else if (this.c) {
                    h hVar2 = this.d;
                    if (hVar2 != null) {
                        hVar2.a();
                    }
                    this.c = false;
                }
                h hVar3 = this.d;
                if (hVar3 != null) {
                    hVar3.onUpdate(a(f));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class i extends f {
        public static /* synthetic */ Interceptable $ic = null;
        public static float m = 1.0f;
        public transient /* synthetic */ FieldHolder $fh;
        public PointF h;
        public PointF i;
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
        public i(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pointF, pointF2, pointF3, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.l = 1.0f;
            this.h = pointF;
            this.i = pointF2;
            this.j = pointF3;
            this.k = h(m, pointF, pointF2);
        }

        public final PointF f(float f, PointF pointF, PointF pointF2, PointF pointF3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), pointF, pointF2, pointF3})) == null) {
                float f2 = 1.0f - f;
                float f3 = f * f;
                float f4 = f2 * f2;
                PointF pointF4 = new PointF();
                float f5 = f * 2.0f * f2;
                pointF4.x = (pointF.x * f4) + (pointF2.x * f5) + (pointF3.x * f3);
                pointF4.y = (f4 * pointF.y) + (f5 * pointF2.y) + (f3 * pointF3.y);
                return pointF4;
            }
            return (PointF) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.f
        public Object a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                float f2 = m;
                float f3 = this.l;
                if (f2 < f3) {
                    if (f < f2) {
                        return g(f);
                    }
                    return f((f - f2) / (f3 - f2), this.k, this.j, this.i);
                }
                return h(f, this.h, this.i);
            }
            return invokeF.objValue;
        }

        public PointF g(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
                PointF pointF = new PointF();
                PointF pointF2 = this.h;
                pointF.x = pointF2.x;
                pointF.y = (this.l - f) * pointF2.y;
                return pointF;
            }
            return (PointF) invokeF.objValue;
        }

        public PointF h(float f, PointF pointF, PointF pointF2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), pointF, pointF2})) == null) {
                PointF pointF3 = new PointF();
                float f2 = pointF.x;
                pointF3.x = f2 + ((pointF2.x - f2) * f);
                float f3 = pointF.y;
                pointF3.y = f3 + ((pointF2.y - f3) * f);
                return pointF3;
            }
            return (PointF) invokeCommon.objValue;
        }

        public void i(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048580, this, pointF, pointF2, pointF3, i) == null) {
                d(i);
                this.h = pointF;
                this.i = pointF2;
                this.j = pointF3;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class j extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float h;
        public float i;
        public float j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i, float f) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = 0.28f;
            this.i = 1.0f;
            this.j = f;
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.f
        public Object a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                float f2 = this.j;
                float f3 = 1.0f;
                if (f < f2) {
                    float f4 = this.i;
                    float f5 = this.h;
                    f3 = (((f4 - f5) / f2) * f) + f5;
                } else {
                    float f6 = this.i;
                    float f7 = (((-f6) / f2) * f) + (f6 * 2.0f);
                    if (f7 > 1.0f) {
                        f3 = f7;
                    }
                }
                return Float.valueOf(f3);
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
        this.d = false;
        this.e = false;
        this.p = 0.6f;
        this.q = 0.7f;
        this.r = new a(this);
        w();
    }

    public static /* synthetic */ int k(HeartSurfaceView heartSurfaceView) {
        int i2 = heartSurfaceView.l;
        heartSurfaceView.l = i2 - 1;
        return i2;
    }

    public static Bitmap u(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            return v(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return (Bitmap) invokeL.objValue;
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && this.l < 120) {
            this.l += i2;
        }
    }

    public final Bitmap r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return u(getResources().getDrawable(i2));
        }
        return (Bitmap) invokeI.objValue;
    }

    public final Bitmap s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return u(getResources().getDrawable(i2));
        }
        return (Bitmap) invokeI.objValue;
    }

    public void setAnimateEndListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public void setUserPortrait(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bitmap) == null) {
            this.n = bitmap;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surfaceHolder) == null) {
            g[] gVarArr = this.c;
            if (gVarArr != null) {
                for (g gVar : gVarArr) {
                    if (gVar != null && gVar.h()) {
                        gVar.j(false);
                    }
                }
            }
            this.e = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, surfaceHolder) == null) {
            this.e = false;
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, view2, i2) == null) {
            if (i2 != 0) {
                this.e = false;
            }
            super.onVisibilityChanged(view2, i2);
            setVisibility(i2);
        }
    }

    public static Bitmap v(Drawable drawable, int i2, int i3) {
        InterceptResult invokeLII;
        Bitmap.Config config;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65554, null, drawable, i2, i3)) == null) {
            Bitmap bitmap = null;
            if (drawable != null && i2 > 0 && i3 > 0) {
                if (drawable.getOpacity() != -1) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                try {
                    bitmap = Bitmap.createBitmap(i2, i3, config);
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

    public e getAnimateEndListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return (e) invokeV.objValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            getViewTreeObserver().addOnGlobalLayoutListener(this.r);
            this.d = true;
            y();
            x();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = false;
            super.onDetachedFromWindow();
            getViewTreeObserver().removeOnGlobalLayoutListener(this.r);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ExecutorUtilsExt.postOnElastic(new b(this), "live_add_heart", 1);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this), "live_draw_heart", 1);
        }
    }

    public final boolean o(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, pointF, pointF2, pointF3)) == null) {
            int i2 = 0;
            while (true) {
                g[] gVarArr = this.c;
                if (i2 >= gVarArr.length) {
                    return false;
                }
                if (gVarArr[i2] == null) {
                    gVarArr[i2] = new g(bitmap, pointF, pointF2, pointF3);
                    this.c[i2].n = this.o;
                    break;
                } else if (!gVarArr[i2].h()) {
                    this.c[i2].i(bitmap, pointF, pointF2, pointF3);
                    break;
                } else {
                    i2++;
                }
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        List<Pair<PointF, PointF>> list;
        PointF pointF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e && this.j != null && this.k != null && (list = this.i) != null) {
                Pair<PointF, PointF> pair = list.get(this.f.nextInt(list.size()));
                PointF pointF2 = (PointF) pair.first;
                PointF pointF3 = (PointF) pair.second;
                float nextFloat = this.f.nextFloat();
                if (nextFloat == 0.0f) {
                    nextFloat = 1.0f;
                }
                float f2 = this.k.x;
                float f3 = (f2 / 4.0f) + ((f2 / 2.0f) * nextFloat);
                if (this.f.nextBoolean()) {
                    pointF = new PointF(f3, this.j.y * ((nextFloat * this.p) + this.q));
                } else {
                    pointF = new PointF(f3, this.k.y * ((nextFloat * this.p) + this.q));
                }
                ArrayList<Bitmap> arrayList = this.m;
                return o(arrayList.get(this.f.nextInt(arrayList.size())), pointF2, pointF3, pointF);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setUpResNormalMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ArrayList<Bitmap> arrayList = new ArrayList<>();
            this.m = arrayList;
            arrayList.add(r(R.drawable.obfuscated_res_0x7f080db1));
            this.m.add(r(R.drawable.obfuscated_res_0x7f080db2));
            this.m.add(r(R.drawable.obfuscated_res_0x7f080db3));
            this.m.add(r(R.drawable.obfuscated_res_0x7f080db4));
            this.m.add(r(R.drawable.obfuscated_res_0x7f080db5));
        }
    }

    public final void t() {
        Canvas canvas;
        g[] gVarArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.i != null && this.e) {
            try {
                canvas = this.a.lockCanvas();
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
                            for (g gVar : this.c) {
                                if (!this.d || !this.e) {
                                    break;
                                }
                                if (gVar != null && gVar.h()) {
                                    gVar.update(currentTimeMillis);
                                    this.b.setAlpha(gVar.d);
                                    canvas.drawBitmap(gVar.c, (Rect) null, gVar.e, this.b);
                                }
                            }
                            this.a.unlockCanvasAndPost(canvas);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            this.a.unlockCanvasAndPost(canvas);
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.a.unlockCanvasAndPost(canvas);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            SurfaceHolder holder = getHolder();
            this.a = holder;
            holder.addCallback(this);
            Paint paint = new Paint();
            this.b = paint;
            paint.setAntiAlias(true);
            this.c = new g[30];
            this.f = new Random();
            this.d = true;
            this.e = false;
            ArrayList<Bitmap> arrayList = new ArrayList<>();
            this.m = arrayList;
            arrayList.add(s(R.drawable.obfuscated_res_0x7f080db1));
            this.m.add(s(R.drawable.obfuscated_res_0x7f080db2));
            this.m.add(s(R.drawable.obfuscated_res_0x7f080db3));
            this.m.add(s(R.drawable.obfuscated_res_0x7f080db4));
            this.m.add(s(R.drawable.obfuscated_res_0x7f080db5));
        }
    }
}
