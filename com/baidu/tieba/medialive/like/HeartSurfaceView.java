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
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/* loaded from: classes3.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: e  reason: collision with root package name */
    public SurfaceHolder f18217e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f18218f;

    /* renamed from: g  reason: collision with root package name */
    public g[] f18219g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f18220h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f18221i;
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

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (HeartSurfaceView.this.m != null && HeartSurfaceView.this.l == HeartSurfaceView.this.getWidth() && HeartSurfaceView.this.k == HeartSurfaceView.this.getHeight()) {
                return;
            }
            HeartSurfaceView heartSurfaceView = HeartSurfaceView.this;
            heartSurfaceView.l = heartSurfaceView.getWidth();
            HeartSurfaceView heartSurfaceView2 = HeartSurfaceView.this;
            heartSurfaceView2.k = heartSurfaceView2.getHeight();
            float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(d.a.n0.n1.c.liveshow_heart_start_x);
            float dimensionPixelSize2 = HeartSurfaceView.this.getResources().getDimensionPixelSize(d.a.n0.n1.c.liveshow_heart_start_x1);
            float dimensionPixelSize3 = HeartSurfaceView.this.getResources().getDimensionPixelSize(d.a.n0.n1.c.liveshow_heart_padding_bottom);
            float dimensionPixelSize4 = HeartSurfaceView.this.getResources().getDimensionPixelSize(d.a.n0.n1.c.liveshow_heart_padding_top);
            PointF pointF = new PointF(dimensionPixelSize, HeartSurfaceView.this.k - dimensionPixelSize3);
            PointF pointF2 = new PointF(dimensionPixelSize, dimensionPixelSize4);
            PointF pointF3 = new PointF(dimensionPixelSize2, HeartSurfaceView.this.k - dimensionPixelSize3);
            PointF pointF4 = new PointF(dimensionPixelSize2, dimensionPixelSize4);
            HeartSurfaceView.this.m = new ArrayList();
            HeartSurfaceView.this.m.add(Pair.create(pointF, pointF2));
            HeartSurfaceView.this.m.add(Pair.create(pointF3, pointF4));
            HeartSurfaceView.this.n = new PointF(0.0f, HeartSurfaceView.this.k * 0.5f);
            HeartSurfaceView.this.o = new PointF(HeartSurfaceView.this.l + HeartSurfaceView.this.getResources().getDimensionPixelSize(d.a.n0.n1.c.liveshow_heart_padding_right), HeartSurfaceView.this.k * 0.5f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (HeartSurfaceView.this.f18220h) {
                SystemClock.sleep(10L);
                while (HeartSurfaceView.this.f18220h && HeartSurfaceView.this.p > 0) {
                    if (HeartSurfaceView.this.q()) {
                        HeartSurfaceView.k(HeartSurfaceView.this);
                    }
                    SystemClock.sleep(120L);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (HeartSurfaceView.this.f18220h) {
                try {
                    while (HeartSurfaceView.this.f18220h && !HeartSurfaceView.this.f18221i) {
                        SystemClock.sleep(300L);
                    }
                    if (!HeartSurfaceView.this.f18220h) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        HeartSurfaceView.this.t();
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

    /* loaded from: classes3.dex */
    public static class d extends f {

        /* renamed from: h  reason: collision with root package name */
        public float f18225h;

        /* renamed from: i  reason: collision with root package name */
        public float f18226i;
        public float j;
        public float k;
        public float l;
        public float m;
        public float n;
        public int o;
        public int p;

        public d(int i2) {
            super(i2);
            this.f18225h = 0.22f;
            this.f18226i = 0.88f;
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
            float f3;
            float f4 = this.f18225h;
            if (f2 < f4) {
                f3 = this.k + f2;
            } else {
                float f5 = this.f18226i;
                if (f2 < f5) {
                    f3 = this.j + (this.m * (f2 - f4));
                } else {
                    f3 = f2 < ((float) this.o) ? this.l - (this.n * (f2 - f5)) : 0.0f;
                }
            }
            return Integer.valueOf((int) (this.p * f3));
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        public int f18227a;

        /* renamed from: b  reason: collision with root package name */
        public long f18228b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f18229c;

        /* renamed from: d  reason: collision with root package name */
        public h f18230d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f18231e = false;

        /* renamed from: f  reason: collision with root package name */
        public float f18232f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f18233g = 0.5f;

        public f(int i2) {
            this.f18227a = i2;
        }

        public abstract Object a(float f2);

        public boolean b() {
            return this.f18231e;
        }

        public void c(h hVar) {
            this.f18230d = hVar;
        }

        public void d(int i2) {
            this.f18227a = i2;
        }

        public void e() {
            this.f18228b = System.currentTimeMillis();
            this.f18229c = true;
            this.f18231e = true;
        }

        public void f(long j) {
            float f2 = ((float) (j - this.f18228b)) / this.f18227a;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 >= this.f18232f) {
                this.f18231e = false;
                h hVar = this.f18230d;
                if (hVar != null) {
                    hVar.onUpdate(a(f2));
                    this.f18230d.onOver();
                    return;
                }
                return;
            }
            if (f2 < this.f18233g) {
                this.f18229c = true;
            } else if (this.f18229c) {
                h hVar2 = this.f18230d;
                if (hVar2 != null) {
                    hVar2.a();
                }
                this.f18229c = false;
            }
            h hVar3 = this.f18230d;
            if (hVar3 != null) {
                hVar3.onUpdate(a(f2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g {

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f18236c;

        /* renamed from: e  reason: collision with root package name */
        public RectF f18238e;

        /* renamed from: g  reason: collision with root package name */
        public int f18240g;

        /* renamed from: h  reason: collision with root package name */
        public int f18241h;

        /* renamed from: i  reason: collision with root package name */
        public i f18242i;
        public j j;
        public d k;
        public PointF l;
        public volatile boolean m;
        public e n;

        /* renamed from: a  reason: collision with root package name */
        public float f18234a = 2.0f;

        /* renamed from: b  reason: collision with root package name */
        public int f18235b = 2;

        /* renamed from: d  reason: collision with root package name */
        public int f18237d = 128;

        /* renamed from: f  reason: collision with root package name */
        public float f18239f = 0.28f;

        /* loaded from: classes3.dex */
        public class a implements h {
            public a() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void a() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onOver() {
                g.this.j(false);
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onUpdate(Object obj) {
                g.this.f18237d = ((Integer) obj).intValue();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements h {
            public b() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void a() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onOver() {
                g gVar = g.this;
                e eVar = gVar.n;
                if (eVar != null) {
                    RectF rectF = gVar.f18238e;
                    eVar.a((int) rectF.left, (int) rectF.top);
                }
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onUpdate(Object obj) {
                PointF pointF = (PointF) obj;
                g gVar = g.this;
                RectF rectF = gVar.f18238e;
                float f2 = pointF.x;
                rectF.set(f2, pointF.y, (gVar.f18241h * g.this.f18239f) + f2, pointF.y + (g.this.f18240g * g.this.f18239f));
                g gVar2 = g.this;
                gVar2.f18238e.offset(((-gVar2.f18241h) * g.this.f18239f) / g.this.f18235b, ((-g.this.f18240g) * g.this.f18239f) / g.this.f18235b);
            }
        }

        /* loaded from: classes3.dex */
        public class c implements h {
            public c() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void a() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onOver() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
            public void onUpdate(Object obj) {
                g.this.f18239f = ((Float) obj).floatValue();
                g gVar = g.this;
                gVar.f18238e.set(gVar.l.x, g.this.l.y, g.this.l.x + (g.this.f18241h * g.this.f18239f), g.this.l.y + (g.this.f18240g * g.this.f18239f));
                g gVar2 = g.this;
                gVar2.f18238e.offset(((-gVar2.f18241h) * g.this.f18239f) / g.this.f18235b, ((-g.this.f18240g) * g.this.f18239f) / g.this.f18235b);
            }
        }

        public g(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.f18236c = bitmap;
            this.f18240g = bitmap.getHeight();
            this.f18241h = this.f18236c.getWidth();
            this.l = pointF;
            float f2 = pointF.x;
            float f3 = pointF.y;
            RectF rectF = new RectF(f2, f3, this.f18241h + f2, this.f18240g + f3);
            this.f18238e = rectF;
            float f4 = this.f18234a;
            rectF.offset((-this.f18241h) / f4, (-this.f18240g) / f4);
            d dVar = new d(1500);
            this.k = dVar;
            dVar.c(new a());
            this.k.e();
            i iVar = new i(pointF, pointF2, pointF3, 1500);
            this.f18242i = iVar;
            iVar.c(new b());
            this.f18242i.e();
            j jVar = new j(300, 1.0f);
            this.j = jVar;
            jVar.c(new c());
            this.j.e();
            j(true);
        }

        public boolean h() {
            return this.m;
        }

        public final void i(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.f18236c = bitmap;
            this.f18240g = bitmap.getHeight();
            int width = this.f18236c.getWidth();
            this.f18241h = width;
            this.f18237d = 128;
            this.f18239f = 0.28f;
            this.l = pointF;
            RectF rectF = this.f18238e;
            float f2 = pointF.x;
            float f3 = pointF.y;
            rectF.set(f2, f3, width + f2, this.f18240g + f3);
            RectF rectF2 = this.f18238e;
            float f4 = this.f18234a;
            rectF2.offset((-this.f18241h) / f4, (-this.f18240g) / f4);
            this.f18242i.j(pointF, pointF2, pointF3, 1500);
            this.f18242i.e();
            this.j.e();
            this.k.e();
            j(true);
        }

        public synchronized void j(boolean z) {
            this.m = z;
        }

        public void k(long j) {
            if (this.j.b()) {
                this.j.f(j);
            }
            if (this.f18242i.b()) {
                this.f18242i.f(j);
            }
            if (this.k.b()) {
                this.k.f(j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a();

        void onOver();

        void onUpdate(Object obj);
    }

    /* loaded from: classes3.dex */
    public static class i extends f {
        public static float m = 1.0f;

        /* renamed from: h  reason: collision with root package name */
        public PointF f18246h;

        /* renamed from: i  reason: collision with root package name */
        public PointF f18247i;
        public PointF j;
        public PointF k;
        public float l;

        public i(PointF pointF, PointF pointF2, PointF pointF3, int i2) {
            super(i2);
            this.l = 1.0f;
            this.f18246h = pointF;
            this.f18247i = pointF2;
            this.j = pointF3;
            this.k = i(m, pointF, pointF2);
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.f
        public Object a(float f2) {
            float f3 = m;
            float f4 = this.l;
            if (f3 < f4) {
                if (f2 < f3) {
                    return h(f2);
                }
                return g((f2 - f3) / (f4 - f3), this.k, this.j, this.f18247i);
            }
            return i(f2, this.f18246h, this.f18247i);
        }

        public final PointF g(float f2, PointF pointF, PointF pointF2, PointF pointF3) {
            float f3 = 1.0f - f2;
            float f4 = f2 * f2;
            float f5 = f3 * f3;
            PointF pointF4 = new PointF();
            float f6 = f2 * 2.0f * f3;
            pointF4.x = (pointF.x * f5) + (pointF2.x * f6) + (pointF3.x * f4);
            pointF4.y = (f5 * pointF.y) + (f6 * pointF2.y) + (f4 * pointF3.y);
            return pointF4;
        }

        public PointF h(float f2) {
            PointF pointF = new PointF();
            PointF pointF2 = this.f18246h;
            pointF.x = pointF2.x;
            pointF.y = (this.l - f2) * pointF2.y;
            return pointF;
        }

        public PointF i(float f2, PointF pointF, PointF pointF2) {
            PointF pointF3 = new PointF();
            float f3 = pointF.x;
            pointF3.x = f3 + ((pointF2.x - f3) * f2);
            float f4 = pointF.y;
            pointF3.y = f4 + ((pointF2.y - f4) * f2);
            return pointF3;
        }

        public void j(PointF pointF, PointF pointF2, PointF pointF3, int i2) {
            d(i2);
            this.f18246h = pointF;
            this.f18247i = pointF2;
            this.j = pointF3;
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends f {

        /* renamed from: h  reason: collision with root package name */
        public float f18248h;

        /* renamed from: i  reason: collision with root package name */
        public float f18249i;
        public float j;

        public j(int i2, float f2) {
            super(i2);
            this.f18248h = 0.28f;
            this.f18249i = 1.0f;
            this.j = f2;
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.f
        public Object a(float f2) {
            float f3 = this.j;
            float f4 = 1.0f;
            if (f2 < f3) {
                float f5 = this.f18249i;
                float f6 = this.f18248h;
                f4 = (((f5 - f6) / f3) * f2) + f6;
            } else {
                float f7 = this.f18249i;
                float f8 = (((-f7) / f3) * f2) + (f7 * 2.0f);
                if (f8 > 1.0f) {
                    f4 = f8;
                }
            }
            return Float.valueOf(f4);
        }
    }

    public HeartSurfaceView(Context context) {
        this(context, null, 0);
    }

    public static /* synthetic */ int k(HeartSurfaceView heartSurfaceView) {
        int i2 = heartSurfaceView.p;
        heartSurfaceView.p = i2 - 1;
        return i2;
    }

    public static Bitmap u(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return v(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    public static Bitmap v(Drawable drawable, int i2, int i3) {
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

    public e getAnimateEndListener() {
        return this.r;
    }

    public final boolean o(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        int i2 = 0;
        while (true) {
            g[] gVarArr = this.f18219g;
            if (i2 >= gVarArr.length) {
                return false;
            }
            if (gVarArr[i2] == null) {
                gVarArr[i2] = new g(bitmap, pointF, pointF2, pointF3);
                this.f18219g[i2].n = this.r;
                break;
            } else if (!gVarArr[i2].h()) {
                this.f18219g[i2].i(bitmap, pointF, pointF2, pointF3);
                break;
            } else {
                i2++;
            }
        }
        return true;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.u);
        this.f18220h = true;
        y();
        x();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        this.f18220h = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.u);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        if (i2 != 0) {
            this.f18221i = false;
        }
        super.onVisibilityChanged(view, i2);
        setVisibility(i2);
    }

    public void p(int i2) {
        if (this.p < 120) {
            this.p += i2;
        }
    }

    public final boolean q() {
        List<Pair<PointF, PointF>> list;
        PointF pointF;
        if (!this.f18221i || this.n == null || this.o == null || (list = this.m) == null) {
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

    public final Bitmap r(int i2) {
        return u(getResources().getDrawable(i2));
    }

    public final Bitmap s(int i2) {
        return u(getResources().getDrawable(i2));
    }

    public void setAnimateEndListener(e eVar) {
        this.r = eVar;
    }

    public void setClickBySelf(boolean z) {
    }

    public void setUpResNormalMode() {
        ArrayList<Bitmap> arrayList = new ArrayList<>();
        this.q = arrayList;
        arrayList.add(r(d.a.n0.n1.d.liveshow_video_heart_like1));
        this.q.add(r(d.a.n0.n1.d.liveshow_video_heart_like2));
        this.q.add(r(d.a.n0.n1.d.liveshow_video_heart_like3));
        this.q.add(r(d.a.n0.n1.d.liveshow_video_heart_like4));
        this.q.add(r(d.a.n0.n1.d.liveshow_video_heart_like5));
    }

    public void setUserPortrait(Bitmap bitmap) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        g[] gVarArr = this.f18219g;
        if (gVarArr != null) {
            for (g gVar : gVarArr) {
                if (gVar != null && gVar.h()) {
                    gVar.j(false);
                }
            }
        }
        this.f18221i = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f18221i = false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0063 -> B:46:0x0072). Please submit an issue!!! */
    public final void t() {
        Canvas canvas;
        g[] gVarArr;
        if (this.m != null && this.f18221i) {
            try {
                canvas = this.f18217e.lockCanvas();
            } catch (Exception e2) {
                e2.printStackTrace();
                canvas = null;
            }
            try {
                try {
                } catch (Throwable th) {
                    try {
                        this.f18217e.unlockCanvasAndPost(canvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (canvas != null) {
                try {
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (g gVar : this.f18219g) {
                        if (!this.f18220h || !this.f18221i) {
                            break;
                        }
                        if (gVar != null && gVar.h()) {
                            gVar.k(currentTimeMillis);
                            this.f18218f.setAlpha(gVar.f18237d);
                            canvas.drawBitmap(gVar.f18236c, (Rect) null, gVar.f18238e, this.f18218f);
                        }
                    }
                    this.f18217e.unlockCanvasAndPost(canvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    this.f18217e.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public final void w() {
        SurfaceHolder holder = getHolder();
        this.f18217e = holder;
        holder.addCallback(this);
        Paint paint = new Paint();
        this.f18218f = paint;
        paint.setAntiAlias(true);
        this.f18219g = new g[30];
        this.j = new Random();
        this.f18220h = true;
        this.f18221i = false;
        ArrayList<Bitmap> arrayList = new ArrayList<>();
        this.q = arrayList;
        arrayList.add(s(d.a.n0.n1.d.liveshow_video_heart_like1));
        this.q.add(s(d.a.n0.n1.d.liveshow_video_heart_like2));
        this.q.add(s(d.a.n0.n1.d.liveshow_video_heart_like3));
        this.q.add(s(d.a.n0.n1.d.liveshow_video_heart_like4));
        this.q.add(s(d.a.n0.n1.d.liveshow_video_heart_like5));
    }

    public final void x() {
        ExecutorUtilsExt.postOnElastic(new b(), "live_add_heart", 1);
    }

    public final void y() {
        ExecutorUtilsExt.postOnElastic(new c(), "live_draw_heart", 1);
    }

    public HeartSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeartSurfaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18220h = false;
        this.f18221i = false;
        this.s = 0.6f;
        this.t = 0.7f;
        this.u = new a();
        w();
    }
}
