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
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class GifView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Movie f4621a;
    private long b;
    private int c;
    private AnimatedImageDrawable d;
    private boolean e;
    private boolean f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private volatile boolean l;
    private boolean m;

    public GifView(Context context) {
        super(context);
        this.e = Build.VERSION.SDK_INT >= 28;
        this.f = false;
        this.m = true;
        a();
    }

    public GifView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = Build.VERSION.SDK_INT >= 28;
        this.f = false;
        this.m = true;
        a();
    }

    public GifView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = Build.VERSION.SDK_INT >= 28;
        this.f = false;
        this.m = true;
        a();
    }

    @RequiresApi(api = 21)
    public GifView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.e = Build.VERSION.SDK_INT >= 28;
        this.f = false;
        this.m = true;
        a();
    }

    void a() {
        if (!this.e) {
            setLayerType(1, null);
            return;
        }
        this.f = ab.a();
        u.b("GifView", "android p 反射解锁：exempt result: " + this.f);
    }

    public void a(byte[] bArr, boolean z) {
        this.l = z;
        if (bArr != null) {
            if (!this.e) {
                this.f4621a = a(bArr);
            } else {
                this.d = b(bArr);
            }
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    @TargetApi(28)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AnimatedImageDrawable b(byte[] bArr) {
        ImageDecoder.Source source;
        if (bArr == null) {
            return null;
        }
        if (this.f) {
            try {
                source = (ImageDecoder.Source) ImageDecoder.class.getMethod("createSource", Resources.class, InputStream.class).invoke(null, getResources(), new ByteArrayInputStream(bArr));
            } catch (Throwable th) {
                u.c("GifView", "GifView android P  : Use Reflection fail : ", th);
            }
            if (source == null) {
                source = c(bArr);
            }
            return a(source);
        }
        source = null;
        if (source == null) {
        }
        return a(source);
    }

    @RequiresApi(api = 28)
    private ImageDecoder.Source c(byte[] bArr) {
        FileOutputStream fileOutputStream;
        File a2;
        ImageDecoder.Source source = null;
        try {
            a2 = a(getContext(), b.b() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(a2);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            source = ImageDecoder.createSource(a2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                u.c("GifView", "GifView  getSourceByFile fail : ", th);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th4) {
                    }
                }
                return source;
            } catch (Throwable th5) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th6) {
                    }
                }
                throw th5;
            }
        }
        return source;
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
                    return animatedImageDrawable;
                }
                return animatedImageDrawable;
            }
        } catch (Throwable th) {
            u.a("GifView", "getAnimatedImageDrawable error", th);
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (!this.e && this.f4621a != null) {
            int width = this.f4621a.width();
            int height = this.f4621a.height();
            this.i = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || width <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : width / size2, (View.MeasureSpec.getMode(i2) == 0 || height <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : height / size);
            this.j = (int) (width * this.i);
            this.k = (int) (height * this.i);
            setMeasuredDimension(this.j, this.k);
        }
    }

    private File a(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        return l.a(context, b.b(), str, str2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f4621a != null && !this.e) {
            this.g = (getWidth() - this.j) / 2.0f;
            this.h = (getHeight() - this.k) / 2.0f;
        }
        this.m = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f4621a != null && !this.e) {
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

    private void b() {
        if (this.f4621a != null && !this.e && this.m) {
            if (Build.VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    private void c() {
        if (this.f4621a != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.b == 0) {
                this.b = uptimeMillis;
            }
            int duration = this.f4621a.duration();
            if (duration == 0) {
                duration = 1000;
            }
            this.c = (int) ((uptimeMillis - this.b) % duration);
        }
    }

    private void a(Canvas canvas) {
        if (this.f4621a != null) {
            this.f4621a.setTime(this.c);
            canvas.scale(this.i, this.i);
            this.f4621a.draw(canvas, this.g / this.i, this.h / this.i);
            canvas.restore();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.f4621a != null) {
            this.m = i == 1;
            b();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f4621a != null) {
            this.m = i == 0;
            b();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f4621a != null) {
            this.m = i == 0;
            b();
        }
    }
}
