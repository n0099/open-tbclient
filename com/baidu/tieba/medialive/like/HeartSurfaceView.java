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
    public SurfaceHolder f18944e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f18945f;

    /* renamed from: g  reason: collision with root package name */
    public f[] f18946g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f18947h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f18948i;
    public Random j;
    public int k;
    public int l;
    public List<Pair<PointF, PointF>> m;
    public PointF n;
    public PointF o;
    public volatile int p;
    public ArrayList<Bitmap> q;
    public e r;
    public ViewTreeObserver.OnGlobalLayoutListener s;

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
            float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(d.a.j0.m1.c.liveshow_heart_start_x);
            float dimensionPixelSize2 = HeartSurfaceView.this.getResources().getDimensionPixelSize(d.a.j0.m1.c.liveshow_heart_start_x1);
            float dimensionPixelSize3 = HeartSurfaceView.this.getResources().getDimensionPixelSize(d.a.j0.m1.c.liveshow_heart_padding_bottom);
            float dimensionPixelSize4 = HeartSurfaceView.this.getResources().getDimensionPixelSize(d.a.j0.m1.c.liveshow_heart_padding_top);
            PointF pointF = new PointF(dimensionPixelSize, HeartSurfaceView.this.k - dimensionPixelSize3);
            PointF pointF2 = new PointF(dimensionPixelSize, dimensionPixelSize4);
            PointF pointF3 = new PointF(dimensionPixelSize2, HeartSurfaceView.this.k - dimensionPixelSize3);
            PointF pointF4 = new PointF(dimensionPixelSize2, dimensionPixelSize4);
            HeartSurfaceView.this.m = new ArrayList();
            HeartSurfaceView.this.m.add(Pair.create(pointF, pointF2));
            HeartSurfaceView.this.m.add(Pair.create(pointF3, pointF4));
            HeartSurfaceView.this.n = new PointF(0.0f, HeartSurfaceView.this.k * 0.5f);
            HeartSurfaceView.this.o = new PointF(HeartSurfaceView.this.l + HeartSurfaceView.this.getResources().getDimensionPixelSize(d.a.j0.m1.c.liveshow_heart_padding_right), HeartSurfaceView.this.k * 0.5f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (HeartSurfaceView.this.f18947h) {
                SystemClock.sleep(10L);
                while (HeartSurfaceView.this.f18947h && HeartSurfaceView.this.p > 0) {
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
            while (HeartSurfaceView.this.f18947h) {
                try {
                    while (HeartSurfaceView.this.f18947h && !HeartSurfaceView.this.f18948i) {
                        SystemClock.sleep(300L);
                    }
                    if (!HeartSurfaceView.this.f18947h) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        HeartSurfaceView.this.t();
                    } catch (Exception unused) {
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 < 30) {
                        try {
                            Thread.sleep(Math.max(30 - currentTimeMillis2, 0L));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends h {
        public d(int i2) {
            super(i2);
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
        public Object a(float f2) {
            return Integer.valueOf((int) ((f2 < 0.22f ? f2 + 0.5f : f2 < 0.88f ? ((f2 - 0.22f) * 0.2f) + 0.7f : f2 < 1.0f ? 0.85f - ((f2 - 0.88f) * 7.0f) : 0.0f) * 255.0f));
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f18952a;

        /* renamed from: c  reason: collision with root package name */
        public RectF f18954c;

        /* renamed from: e  reason: collision with root package name */
        public int f18956e;

        /* renamed from: f  reason: collision with root package name */
        public int f18957f;

        /* renamed from: g  reason: collision with root package name */
        public i f18958g;

        /* renamed from: h  reason: collision with root package name */
        public j f18959h;

        /* renamed from: i  reason: collision with root package name */
        public d f18960i;
        public PointF j;
        public volatile boolean k;
        public e l;

        /* renamed from: b  reason: collision with root package name */
        public int f18953b = 128;

        /* renamed from: d  reason: collision with root package name */
        public float f18955d = 0.28f;

        /* loaded from: classes3.dex */
        public class a implements g {
            public a() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.g
            public void a() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.g
            public void onOver() {
                f.this.i(false);
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.g
            public void onUpdate(Object obj) {
                f.this.f18953b = ((Integer) obj).intValue();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements g {
            public b() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.g
            public void a() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.g
            public void onOver() {
                f fVar = f.this;
                e eVar = fVar.l;
                if (eVar != null) {
                    RectF rectF = fVar.f18954c;
                    eVar.a((int) rectF.left, (int) rectF.top);
                }
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.g
            public void onUpdate(Object obj) {
                PointF pointF = (PointF) obj;
                f fVar = f.this;
                RectF rectF = fVar.f18954c;
                float f2 = pointF.x;
                rectF.set(f2, pointF.y, (fVar.f18957f * f.this.f18955d) + f2, pointF.y + (f.this.f18956e * f.this.f18955d));
                f fVar2 = f.this;
                fVar2.f18954c.offset(((-fVar2.f18957f) * f.this.f18955d) / 2.0f, ((-f.this.f18956e) * f.this.f18955d) / 2.0f);
            }
        }

        /* loaded from: classes3.dex */
        public class c implements g {
            public c() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.g
            public void a() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.g
            public void onOver() {
            }

            @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.g
            public void onUpdate(Object obj) {
                f.this.f18955d = ((Float) obj).floatValue();
                f fVar = f.this;
                fVar.f18954c.set(fVar.j.x, f.this.j.y, f.this.j.x + (f.this.f18957f * f.this.f18955d), f.this.j.y + (f.this.f18956e * f.this.f18955d));
                f fVar2 = f.this;
                fVar2.f18954c.offset(((-fVar2.f18957f) * f.this.f18955d) / 2.0f, ((-f.this.f18956e) * f.this.f18955d) / 2.0f);
            }
        }

        public f(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.f18952a = bitmap;
            this.f18956e = bitmap.getHeight();
            this.f18957f = this.f18952a.getWidth();
            this.j = pointF;
            float f2 = pointF.x;
            float f3 = pointF.y;
            RectF rectF = new RectF(f2, f3, this.f18957f + f2, this.f18956e + f3);
            this.f18954c = rectF;
            rectF.offset((-this.f18957f) / 2.0f, (-this.f18956e) / 2.0f);
            d dVar = new d(1500);
            this.f18960i = dVar;
            dVar.c(new a());
            this.f18960i.e();
            i iVar = new i(pointF, pointF2, pointF3, 1500);
            this.f18958g = iVar;
            iVar.c(new b());
            this.f18958g.e();
            j jVar = new j(300, 1.0f);
            this.f18959h = jVar;
            jVar.c(new c());
            this.f18959h.e();
            i(true);
        }

        public boolean g() {
            return this.k;
        }

        public final void h(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.f18952a = bitmap;
            this.f18956e = bitmap.getHeight();
            int width = this.f18952a.getWidth();
            this.f18957f = width;
            this.f18953b = 128;
            this.f18955d = 0.28f;
            this.j = pointF;
            RectF rectF = this.f18954c;
            float f2 = pointF.x;
            float f3 = pointF.y;
            rectF.set(f2, f3, width + f2, this.f18956e + f3);
            this.f18954c.offset((-this.f18957f) / 2.0f, (-this.f18956e) / 2.0f);
            this.f18958g.j(pointF, pointF2, pointF3, 1500);
            this.f18958g.e();
            this.f18959h.e();
            this.f18960i.e();
            i(true);
        }

        public synchronized void i(boolean z) {
            this.k = z;
        }

        public void j(long j) {
            if (this.f18959h.b()) {
                this.f18959h.f(j);
            }
            if (this.f18958g.b()) {
                this.f18958g.f(j);
            }
            if (this.f18960i.b()) {
                this.f18960i.f(j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a();

        void onOver();

        void onUpdate(Object obj);
    }

    /* loaded from: classes3.dex */
    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        public int f18964a;

        /* renamed from: b  reason: collision with root package name */
        public long f18965b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f18966c;

        /* renamed from: d  reason: collision with root package name */
        public g f18967d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f18968e = false;

        public h(int i2) {
            this.f18964a = i2;
        }

        public abstract Object a(float f2);

        public boolean b() {
            return this.f18968e;
        }

        public void c(g gVar) {
            this.f18967d = gVar;
        }

        public void d(int i2) {
            this.f18964a = i2;
        }

        public void e() {
            this.f18965b = System.currentTimeMillis();
            this.f18966c = true;
            this.f18968e = true;
        }

        public void f(long j) {
            float f2 = ((float) (j - this.f18965b)) / this.f18964a;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 >= 1.0f) {
                this.f18968e = false;
                g gVar = this.f18967d;
                if (gVar != null) {
                    gVar.onUpdate(a(f2));
                    this.f18967d.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.f18966c = true;
            } else if (this.f18966c) {
                g gVar2 = this.f18967d;
                if (gVar2 != null) {
                    gVar2.a();
                }
                this.f18966c = false;
            }
            g gVar3 = this.f18967d;
            if (gVar3 != null) {
                gVar3.onUpdate(a(f2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends h {
        public static float j = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public PointF f18969f;

        /* renamed from: g  reason: collision with root package name */
        public PointF f18970g;

        /* renamed from: h  reason: collision with root package name */
        public PointF f18971h;

        /* renamed from: i  reason: collision with root package name */
        public PointF f18972i;

        public i(PointF pointF, PointF pointF2, PointF pointF3, int i2) {
            super(i2);
            this.f18969f = pointF;
            this.f18970g = pointF2;
            this.f18971h = pointF3;
            this.f18972i = i(j, pointF, pointF2);
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
        public Object a(float f2) {
            float f3 = j;
            if (f3 < 1.0f) {
                if (f2 < f3) {
                    return h(f2);
                }
                return g((f2 - f3) / (1.0f - f3), this.f18972i, this.f18971h, this.f18970g);
            }
            return i(f2, this.f18969f, this.f18970g);
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
            PointF pointF2 = this.f18969f;
            pointF.x = pointF2.x;
            pointF.y = (1.0f - f2) * pointF2.y;
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
            this.f18969f = pointF;
            this.f18970g = pointF2;
            this.f18971h = pointF3;
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends h {

        /* renamed from: f  reason: collision with root package name */
        public float f18973f;

        /* renamed from: g  reason: collision with root package name */
        public float f18974g;

        /* renamed from: h  reason: collision with root package name */
        public float f18975h;

        public j(int i2, float f2) {
            super(i2);
            this.f18973f = 0.28f;
            this.f18974g = 1.0f;
            this.f18975h = f2;
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.h
        public Object a(float f2) {
            float f3 = this.f18975h;
            float f4 = 1.0f;
            if (f2 < f3) {
                float f5 = this.f18974g;
                float f6 = this.f18973f;
                f4 = (((f5 - f6) / f3) * f2) + f6;
            } else {
                float f7 = this.f18974g;
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
            f[] fVarArr = this.f18946g;
            if (i2 >= fVarArr.length) {
                return false;
            }
            if (fVarArr[i2] == null) {
                fVarArr[i2] = new f(bitmap, pointF, pointF2, pointF3);
                this.f18946g[i2].l = this.r;
                break;
            } else if (!fVarArr[i2].g()) {
                this.f18946g[i2].h(bitmap, pointF, pointF2, pointF3);
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
        getViewTreeObserver().addOnGlobalLayoutListener(this.s);
        this.f18947h = true;
        y();
        x();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        this.f18947h = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.s);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        if (i2 != 0) {
            this.f18948i = false;
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
        if (!this.f18948i || this.n == null || this.o == null || (list = this.m) == null) {
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
            pointF = new PointF(f3, this.n.y * ((nextFloat * 0.6f) + 0.7f));
        } else {
            pointF = new PointF(f3, this.o.y * ((nextFloat * 0.6f) + 0.7f));
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
        arrayList.add(r(d.a.j0.m1.d.liveshow_video_heart_like1));
        this.q.add(r(d.a.j0.m1.d.liveshow_video_heart_like2));
        this.q.add(r(d.a.j0.m1.d.liveshow_video_heart_like3));
        this.q.add(r(d.a.j0.m1.d.liveshow_video_heart_like4));
        this.q.add(r(d.a.j0.m1.d.liveshow_video_heart_like5));
    }

    public void setUserPortrait(Bitmap bitmap) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        f[] fVarArr = this.f18946g;
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                if (fVar != null && fVar.g()) {
                    fVar.i(false);
                }
            }
        }
        this.f18948i = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f18948i = false;
    }

    public final void t() {
        Canvas canvas;
        f[] fVarArr;
        if (this.m != null && this.f18948i) {
            try {
                canvas = this.f18944e.lockCanvas();
            } catch (Exception unused) {
                canvas = null;
            }
            try {
                try {
                    if (canvas != null) {
                        try {
                            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                            long currentTimeMillis = System.currentTimeMillis();
                            for (f fVar : this.f18946g) {
                                if (!this.f18947h || !this.f18948i) {
                                    break;
                                }
                                if (fVar != null && fVar.g()) {
                                    fVar.j(currentTimeMillis);
                                    this.f18945f.setAlpha(fVar.f18953b);
                                    canvas.drawBitmap(fVar.f18952a, (Rect) null, fVar.f18954c, this.f18945f);
                                }
                            }
                            this.f18944e.unlockCanvasAndPost(canvas);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            this.f18944e.unlockCanvasAndPost(canvas);
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    this.f18944e.unlockCanvasAndPost(canvas);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
    }

    public final void w() {
        SurfaceHolder holder = getHolder();
        this.f18944e = holder;
        holder.addCallback(this);
        Paint paint = new Paint();
        this.f18945f = paint;
        paint.setAntiAlias(true);
        this.f18946g = new f[30];
        this.j = new Random();
        this.f18947h = true;
        this.f18948i = false;
        ArrayList<Bitmap> arrayList = new ArrayList<>();
        this.q = arrayList;
        arrayList.add(s(d.a.j0.m1.d.liveshow_video_heart_like1));
        this.q.add(s(d.a.j0.m1.d.liveshow_video_heart_like2));
        this.q.add(s(d.a.j0.m1.d.liveshow_video_heart_like3));
        this.q.add(s(d.a.j0.m1.d.liveshow_video_heart_like4));
        this.q.add(s(d.a.j0.m1.d.liveshow_video_heart_like5));
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
        this.f18947h = false;
        this.f18948i = false;
        this.s = new a();
        w();
    }
}
