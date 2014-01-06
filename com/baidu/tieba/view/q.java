package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q extends ImageView {
    private boolean A;
    private int B;
    private volatile ak C;
    private Bitmap D;
    private int E;
    private volatile long F;
    private Paint G;
    private boolean H;
    private int I;
    private int J;
    private int K;
    private int L;
    private Interpolator M;
    public volatile int a;
    private Matrix b;
    private int c;
    private int d;
    private float e;
    private float f;
    private ArrayList<Float> g;
    private float h;
    private float i;
    private float j;
    private float k;
    private boolean l;
    private byte[] m;
    private int n;
    private int o;
    private int p;
    private v q;
    private View.OnClickListener r;
    private View.OnLongClickListener s;
    private u t;
    private t u;
    private GestureDetector v;
    private float w;
    private int x;
    private int y;
    private boolean z;

    public q(Context context) {
        super(context);
        this.b = new Matrix();
        this.c = 0;
        this.d = 0;
        this.l = false;
        this.m = null;
        this.n = 0;
        this.o = 1300;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.w = 1.0f;
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.A = false;
        this.a = 0;
        this.B = 0;
        this.C = null;
        this.D = null;
        this.E = 0;
        this.F = 0L;
        this.G = new Paint(-16777216);
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = AnimationUtils.loadInterpolator(getContext(), 17432582);
        u();
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Matrix();
        this.c = 0;
        this.d = 0;
        this.l = false;
        this.m = null;
        this.n = 0;
        this.o = 1300;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.w = 1.0f;
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.A = false;
        this.a = 0;
        this.B = 0;
        this.C = null;
        this.D = null;
        this.E = 0;
        this.F = 0L;
        this.G = new Paint(-16777216);
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = AnimationUtils.loadInterpolator(getContext(), 17432582);
        u();
    }

    public q(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Matrix();
        this.c = 0;
        this.d = 0;
        this.l = false;
        this.m = null;
        this.n = 0;
        this.o = 1300;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.w = 1.0f;
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.A = false;
        this.a = 0;
        this.B = 0;
        this.C = null;
        this.D = null;
        this.E = 0;
        this.F = 0L;
        this.G = new Paint(-16777216);
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = AnimationUtils.loadInterpolator(getContext(), 17432582);
        u();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getImageType() {
        return this.x;
    }

    public void setImageMode(int i) {
        this.p = i;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.I = i2;
        this.J = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.n = i;
    }

    public void a() {
        this.A = false;
        this.l = false;
        this.y = 0;
        v();
        if (this.j < this.h) {
            this.j = this.h;
            w();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.y = 0;
                this.l = true;
                this.z = false;
                this.A = false;
                break;
            case 1:
                a();
                break;
            case 2:
                if (this.y == 0) {
                    this.y = 1;
                    break;
                }
                break;
        }
        if (action == CompatibleUtile.getInstance().getActionPointerUp()) {
            this.y = 1;
        } else if (action == CompatibleUtile.getInstance().getActionPointerDown()) {
            this.w = a(motionEvent);
            if (this.w > 10.0f) {
                this.y = 2;
            }
        }
        if (this.y == 2 || !this.v.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.y == 2) {
                        this.z = true;
                        this.A = true;
                        if (this.x != 1 && this.x != 2) {
                            float a = a(motionEvent);
                            if (a >= 0.0f && Math.abs(this.w - a) >= 10.0f) {
                                if (Math.abs(this.w - a) > 100.0f) {
                                    this.w = a;
                                    break;
                                } else {
                                    float f = a / this.w;
                                    this.w = a;
                                    this.k = this.j;
                                    this.j *= f;
                                    if (this.j > this.i) {
                                        this.j = this.i;
                                    }
                                    if (this.j < this.h / 4.0f) {
                                        this.j = this.h / 4.0f;
                                    }
                                    w();
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public float a(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.c = i3 - i;
            this.d = i4 - i2;
            r();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean b() {
        return this.h == this.j;
    }

    private void r() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.p == 0) {
                float width = this.c / imageBitmap.getWidth();
                float height = this.d / imageBitmap.getHeight();
                if ((imageBitmap.getWidth() <= this.c * 0.2f && imageBitmap.getHeight() <= this.d * 0.2f) || this.x == 2) {
                    this.h = 1.0f;
                } else if (imageBitmap.getWidth() <= this.c * 0.4d && imageBitmap.getHeight() <= this.d * 0.4d) {
                    this.h = Math.min(width, height) * 0.6f;
                } else {
                    this.h = Math.min(width, height);
                }
            } else {
                this.h = Math.max(this.c / imageBitmap.getWidth(), ((this.d - this.I) - this.J) / imageBitmap.getHeight());
            }
            this.i = this.o / (imageBitmap.getHeight() * imageBitmap.getWidth());
            this.i = FloatMath.sqrt(this.i);
            if (this.i > 10.0f) {
                this.i = 10.0f;
            }
            this.g.clear();
            this.g.add(Float.valueOf(this.h));
            this.j = this.h;
            this.k = this.j;
            w();
            s();
            return;
        }
        this.e = 0.0f;
        this.f = 0.0f;
        this.h = 1.0f;
        this.i = 1.0f;
        this.j = 1.0f;
        this.k = this.j;
        this.g.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void s() {
        if (this.q != null) {
            this.q.a(this, p(), q());
        }
    }

    public void setOnSizeChangedListener(v vVar) {
        this.q = vVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void c() {
        if (this.C != null) {
            this.C.r();
            this.C = null;
        }
        this.H = false;
    }

    public void d() {
        c();
        this.E = 0;
        if (this.m != null) {
            this.a = 1;
            invalidate();
            new r(this).start();
        }
    }

    public byte[] getImageData() {
        return this.m;
    }

    public void setImageData(byte[] bArr) {
        this.m = bArr;
    }

    public Bitmap getGifCache() {
        return this.D;
    }

    public void setGifCache(Bitmap bitmap) {
        this.D = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.x == 1 && this.D != null && !this.D.isRecycled()) {
            int width = this.D.getWidth();
            int height = this.D.getHeight();
            int width2 = getWidth();
            int height2 = getHeight();
            int i = (width2 - width) >> 1;
            int i2 = (height2 - height) >> 1;
            boolean z = false;
            if (i < 0 || i2 < 0) {
                float min = Math.min(width2 / width, height2 / height);
                this.b.setScale(min, min);
                i = (int) ((width2 - (width * min)) / 2.0f);
                i2 = (int) ((height2 - (height * min)) / 2.0f);
                this.b.postTranslate(i, i2);
                width = (int) (width * min);
                height = (int) (height * min);
            } else {
                z = true;
            }
            canvas.clipRect(i, i2, width + i, height + i2);
            canvas.drawColor(-1);
            if (this.a == 2 && this.B == 1 && this.H && this.C != null) {
                if (this.F + this.C.a(this.E) < System.currentTimeMillis()) {
                    this.F += this.C.a(this.E);
                    t();
                }
                Bitmap b = this.C.b(this.E);
                if (b != null) {
                    if (z) {
                        canvas.drawBitmap(b, i, i2, (Paint) null);
                    } else {
                        canvas.drawBitmap(b, this.b, this.G);
                    }
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.D, i, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.D, this.b, this.G);
            }
        }
    }

    private void t() {
        if (this.C != null) {
            this.E++;
            if (this.E >= this.C.b()) {
                this.E = 0;
            }
        }
    }

    public void e() {
        if (this.x == 1) {
            if (this.a == 0) {
                d();
            } else {
                this.F = System.currentTimeMillis();
                invalidate();
            }
            this.H = true;
        }
    }

    public void f() {
        if (this.x == 1) {
            com.baidu.tieba.util.bo.e(getClass().getName(), "pause", null);
            this.H = false;
            invalidate();
        }
    }

    public void g() {
        if (this.x == 1) {
            super.setImageBitmap(null);
            this.H = false;
            c();
            this.a = 0;
            this.E = 0;
            invalidate();
        }
    }

    private void u() {
        this.o = com.baidu.adp.lib.h.g.c(getContext()) * com.baidu.adp.lib.h.g.b(getContext()) * 2;
        if (this.o < 1690000) {
            this.o = 1690000;
        }
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = new ArrayList<>();
        this.h = 1.0f;
        this.i = 1.0f;
        this.j = 1.0f;
        this.k = this.j;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.u = new t(this);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.v = new GestureDetector(new s(this));
    }

    private void v() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.e >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.e) {
                scrollX = (int) (this.e - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.f + this.I + this.J >= getHeight()) {
            i = scrollY < (-this.K) ? -this.K : scrollY;
            if (getHeight() + i > this.f + this.J + this.L) {
                i = (int) ((this.f - getHeight()) + this.J + this.L);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.e;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.f;
    }

    public boolean h() {
        if (this.x == 1 || this.x == 2) {
            return true;
        }
        return !this.A && getScrollX() >= ((int) (this.e - ((float) getWidth()))) + (-1);
    }

    public boolean i() {
        if (this.x == 1 || this.x == 2) {
            return true;
        }
        return !this.A && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.u.a()) {
            this.u.b();
        }
        super.setImageBitmap(bitmap);
        r();
        this.x = 0;
    }

    public void a(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.u.a()) {
                this.u.b();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.b);
            scrollTo(scrollX, scrollY);
            this.x = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.u.a()) {
            this.u.b();
        }
        super.setImageBitmap(null);
        c();
        r();
        this.x = 1;
        this.a = 0;
        this.D = bitmap;
        this.m = bArr;
        if (this.t != null) {
            this.t.a(this);
        }
    }

    public void j() {
        if (this.u.a()) {
            this.u.b();
        }
        super.setImageBitmap(null);
        c();
        this.m = null;
        this.a = 0;
        this.D = null;
        this.H = false;
    }

    public void k() {
        if (this.u.a()) {
            this.u.b();
        }
        super.setImageBitmap(null);
        c();
        this.a = 0;
        this.D = null;
        this.H = false;
    }

    public void l() {
        if (this.u.a()) {
            this.u.b();
        }
        if (TiebaApplication.g().an() == 1) {
            super.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.pic_baidu_logo_d_1));
        } else {
            super.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.pic_baidu_logo_d));
        }
        this.x = 2;
        r();
    }

    public void m() {
        if (this.x != 1 && this.x != 2) {
            int size = this.g.size();
            if (size > 0) {
                this.g.add(Float.valueOf(this.g.get(size - 1).floatValue() * 1.25f));
            } else {
                this.g.add(Float.valueOf(this.h));
            }
            w();
            s();
        }
    }

    public void n() {
        if (this.x != 1 && this.x != 2) {
            int size = this.g.size();
            if (size > 1) {
                this.g.remove(size - 1);
            }
            w();
            s();
        }
    }

    public void o() {
        s();
        if (this.x != 1 && this.x != 2 && this.j != this.h) {
            this.g.clear();
            this.g.add(Float.valueOf(this.h));
            this.j = this.h;
            this.k = this.j;
            w();
        }
    }

    public boolean p() {
        if (this.x == 1 || this.x == 2) {
            return false;
        }
        int size = this.g.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.g.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.o) && floatValue <= 5.0f;
    }

    public boolean q() {
        if (this.x == 1 || this.x == 2) {
            return false;
        }
        int size = this.g.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    private void w() {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.y != 2) {
                    int size = this.g.size();
                    if (size > 0) {
                        f2 = this.g.get(size - 1).floatValue();
                    } else {
                        f2 = this.h;
                    }
                    this.j = f2;
                }
                this.b.setScale(this.j, this.j);
                this.e = imageBitmap.getWidth() * this.j;
                this.f = imageBitmap.getHeight() * this.j;
                float width = this.k * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.k;
                this.K = this.I;
                this.L = 0;
                float f3 = this.e < ((float) this.c) ? (int) ((this.c - this.e) / 2.0f) : 0.0f;
                if (this.f < this.d) {
                    f = (int) ((this.d - this.f) / 2.0f);
                    if (this.p == 1 && f > this.I) {
                        f = this.I;
                    }
                    this.K = (int) (this.I - f);
                    this.L = this.I - this.K;
                } else {
                    f = 0.0f;
                }
                this.b.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (this.y == 2) {
                    scrollX += (int) ((this.e - width) / 2.0f);
                }
                if (this.e <= getWidth()) {
                    scrollX = 0;
                } else if (getWidth() + scrollX > this.e) {
                    scrollX = (int) (this.e - getWidth());
                }
                if (this.y == 2) {
                    scrollY += (int) ((this.f - height) / 2.0f);
                }
                if (this.f <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.f) {
                    scrollY = (int) (this.f - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                if (scrollY < 0) {
                    scrollY = 0;
                }
                scrollTo(scrollX, scrollY);
                setImageMatrix(this.b);
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b("DragImageView", "resizeBitmap", "error = " + e.getMessage());
            }
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.s = onLongClickListener;
    }

    public void setGifSetListener(u uVar) {
        this.t = uVar;
    }

    public Bitmap getVisableBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        Matrix matrix = new Matrix(this.b);
        matrix.postTranslate(-scrollX, -scrollY);
        canvas.drawBitmap(getImageBitmap(), matrix, null);
        return createBitmap;
    }
}
