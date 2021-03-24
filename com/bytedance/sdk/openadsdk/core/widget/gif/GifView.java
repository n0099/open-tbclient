package com.bytedance.sdk.openadsdk.core.widget.gif;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class GifView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Movie f28945a;

    /* renamed from: b  reason: collision with root package name */
    public long f28946b;

    /* renamed from: c  reason: collision with root package name */
    public int f28947c;

    /* renamed from: d  reason: collision with root package name */
    public AnimatedImageDrawable f28948d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28949e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28950f;

    /* renamed from: g  reason: collision with root package name */
    public float f28951g;

    /* renamed from: h  reason: collision with root package name */
    public float f28952h;
    public float i;
    public int j;
    public int k;
    public volatile boolean l;
    public boolean m;

    public GifView(Context context) {
        super(context);
        this.f28949e = Build.VERSION.SDK_INT >= 28;
        this.f28950f = false;
        this.m = true;
        a();
    }

    @TargetApi(28)
    private AnimatedImageDrawable b(byte[] bArr) {
        ImageDecoder.Source source = null;
        if (bArr == null) {
            return null;
        }
        if (this.f28950f) {
            try {
                source = (ImageDecoder.Source) ImageDecoder.class.getMethod("createSource", Resources.class, InputStream.class).invoke(null, getResources(), new ByteArrayInputStream(bArr));
            } catch (Throwable th) {
                u.c("GifView", "GifView android P  : Use Reflection fail : ", th);
            }
        }
        if (source == null) {
            source = c(bArr);
        }
        return a(source);
    }

    @RequiresApi(api = 28)
    private ImageDecoder.Source c(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            File a2 = a(getContext(), b.b() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(a2);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                ImageDecoder.Source createSource = ImageDecoder.createSource(a2);
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                return createSource;
            } catch (Throwable th) {
                th = th;
                try {
                    u.c("GifView", "GifView  getSourceByFile fail : ", th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public void a() {
        if (!this.f28949e) {
            setLayerType(1, null);
            return;
        }
        this.f28950f = ac.a();
        u.b("GifView", "android p 反射解锁：exempt result: " + this.f28950f);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f28945a != null && !this.f28949e) {
            try {
                if (!this.l) {
                    c();
                    a(canvas);
                    b();
                } else {
                    a(canvas);
                }
                return;
            } catch (Throwable th) {
                u.c("GifView", "onDraw->Throwable->", th);
                return;
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f28945a != null && !this.f28949e) {
            this.f28951g = (getWidth() - this.j) / 2.0f;
            this.f28952h = (getHeight() - this.k) / 2.0f;
        }
        this.m = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.f28949e || (movie = this.f28945a) == null) {
            return;
        }
        int width = movie.width();
        int height = this.f28945a.height();
        float max = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || width <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : width / size2, (View.MeasureSpec.getMode(i2) == 0 || height <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : height / size);
        this.i = max;
        int i3 = (int) (width * max);
        this.j = i3;
        int i4 = (int) (height * max);
        this.k = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.f28945a != null) {
            this.m = i == 1;
            b();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f28945a != null) {
            this.m = i == 0;
            b();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f28945a != null) {
            this.m = i == 0;
            b();
        }
    }

    public void a(byte[] bArr, boolean z) {
        this.l = z;
        if (bArr != null) {
            if (!this.f28949e) {
                this.f28945a = a(bArr);
            } else {
                this.f28948d = b(bArr);
            }
        }
    }

    public GifView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28949e = Build.VERSION.SDK_INT >= 28;
        this.f28950f = false;
        this.m = true;
        a();
    }

    private void b() {
        if (this.f28945a == null || this.f28949e || !this.m) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    private Movie a(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable th) {
            u.a("GifView", "createMovieWithByteArrayBySafely error1", th);
            return null;
        }
    }

    private void c() {
        if (this.f28945a == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f28946b == 0) {
            this.f28946b = uptimeMillis;
        }
        int duration = this.f28945a.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.f28947c = (int) ((uptimeMillis - this.f28946b) % duration);
    }

    public GifView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28949e = Build.VERSION.SDK_INT >= 28;
        this.f28950f = false;
        this.m = true;
        a();
    }

    @RequiresApi(api = 28)
    private AnimatedImageDrawable a(ImageDecoder.Source source) {
        try {
            Drawable decodeDrawable = ImageDecoder.decodeDrawable(source);
            setImageDrawable(decodeDrawable);
            if (decodeDrawable instanceof AnimatedImageDrawable) {
                AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) decodeDrawable;
                if (!this.l) {
                    animatedImageDrawable.start();
                }
                return animatedImageDrawable;
            }
            return null;
        } catch (Throwable th) {
            u.a("GifView", "getAnimatedImageDrawable error", th);
            return null;
        }
    }

    @RequiresApi(api = 21)
    public GifView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f28949e = Build.VERSION.SDK_INT >= 28;
        this.f28950f = false;
        this.m = true;
        a();
    }

    private File a(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        return l.a(context, b.b(), str, str2);
    }

    private void a(Canvas canvas) {
        Movie movie = this.f28945a;
        if (movie == null) {
            return;
        }
        movie.setTime(this.f28947c);
        float f2 = this.i;
        canvas.scale(f2, f2);
        Movie movie2 = this.f28945a;
        float f3 = this.f28951g;
        float f4 = this.i;
        movie2.draw(canvas, f3 / f4, this.f28952h / f4);
        canvas.restore();
    }
}
