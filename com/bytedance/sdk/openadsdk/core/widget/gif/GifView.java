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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class GifView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Movie f30884a;

    /* renamed from: b  reason: collision with root package name */
    public long f30885b;

    /* renamed from: c  reason: collision with root package name */
    public int f30886c;

    /* renamed from: d  reason: collision with root package name */
    public AnimatedImageDrawable f30887d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30888e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30889f;

    /* renamed from: g  reason: collision with root package name */
    public float f30890g;

    /* renamed from: h  reason: collision with root package name */
    public float f30891h;

    /* renamed from: i  reason: collision with root package name */
    public float f30892i;
    public int j;
    public int k;
    public volatile boolean l;
    public boolean m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifView(Context context) {
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
        this.f30888e = Build.VERSION.SDK_INT >= 28;
        this.f30889f = false;
        this.m = true;
        a();
    }

    @TargetApi(28)
    private AnimatedImageDrawable b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, bArr)) == null) {
            ImageDecoder.Source source = null;
            if (bArr == null) {
                return null;
            }
            if (this.f30889f) {
                try {
                    source = (ImageDecoder.Source) ImageDecoder.class.getMethod("createSource", Resources.class, InputStream.class).invoke(null, getResources(), new ByteArrayInputStream(bArr));
                } catch (Throwable th) {
                    j.c("GifView", "GifView android P  : Use Reflection fail : ", th);
                }
            }
            if (source == null) {
                source = c(bArr);
            }
            return a(source);
        }
        return (AnimatedImageDrawable) invokeL.objValue;
    }

    @RequiresApi(api = 28)
    private ImageDecoder.Source c(byte[] bArr) {
        InterceptResult invokeL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65546, this, bArr)) != null) {
            return (ImageDecoder.Source) invokeL.objValue;
        }
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
                    j.c("GifView", "GifView  getSourceByFile fail : ", th);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f30888e) {
                setLayerType(1, null);
                return;
            }
            this.f30889f = q.a();
            j.b("GifView", "android p 反射解锁：exempt result: " + this.f30889f);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.f30884a != null && !this.f30888e) {
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
                    j.c("GifView", "onDraw->Throwable->", th);
                    return;
                }
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.f30884a != null && !this.f30888e) {
                this.f30890g = (getWidth() - this.j) / 2.0f;
                this.f30891h = (getHeight() - this.k) / 2.0f;
            }
            this.m = getVisibility() == 0;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Movie movie;
        int size;
        int size2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.f30888e || (movie = this.f30884a) == null) {
                return;
            }
            int width = movie.width();
            int height = this.f30884a.height();
            float max = 1.0f / Math.max((View.MeasureSpec.getMode(i2) == 0 || width <= (size2 = View.MeasureSpec.getSize(i2))) ? 1.0f : width / size2, (View.MeasureSpec.getMode(i3) == 0 || height <= (size = View.MeasureSpec.getSize(i3))) ? 1.0f : height / size);
            this.f30892i = max;
            int i4 = (int) (width * max);
            this.j = i4;
            int i5 = (int) (height * max);
            this.k = i5;
            setMeasuredDimension(i4, i5);
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onScreenStateChanged(i2);
            if (this.f30884a != null) {
                this.m = i2 == 1;
                b();
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
            if (this.f30884a != null) {
                this.m = i2 == 0;
                b();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (this.f30884a != null) {
                this.m = i2 == 0;
                b();
            }
        }
    }

    public void a(byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, z) == null) {
            this.l = z;
            if (bArr != null) {
                if (!this.f30888e) {
                    this.f30884a = a(bArr);
                } else {
                    this.f30887d = b(bArr);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f30888e = Build.VERSION.SDK_INT >= 28;
        this.f30889f = false;
        this.m = true;
        a();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.f30884a == null || this.f30888e || !this.m) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    private Movie a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bArr)) == null) {
            try {
                return Movie.decodeByteArray(bArr, 0, bArr.length);
            } catch (Throwable th) {
                j.a("GifView", "createMovieWithByteArrayBySafely error1", th);
                return null;
            }
        }
        return (Movie) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.f30884a == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f30885b == 0) {
            this.f30885b = uptimeMillis;
        }
        int duration = this.f30884a.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.f30886c = (int) ((uptimeMillis - this.f30885b) % duration);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f30888e = Build.VERSION.SDK_INT >= 28;
        this.f30889f = false;
        this.m = true;
        a();
    }

    @RequiresApi(api = 28)
    private AnimatedImageDrawable a(ImageDecoder.Source source) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, source)) == null) {
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
                j.a("GifView", "getAnimatedImageDrawable error", th);
                return null;
            }
        }
        return (AnimatedImageDrawable) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public GifView(Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f30888e = Build.VERSION.SDK_INT >= 28;
        this.f30889f = false;
        this.m = true;
        a();
    }

    private File a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, context, str, str2)) == null) {
            if (context == null) {
                return null;
            }
            return f.a(context, b.b(), str, str2);
        }
        return (File) invokeLLL.objValue;
    }

    private void a(Canvas canvas) {
        Movie movie;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, canvas) == null) || (movie = this.f30884a) == null) {
            return;
        }
        movie.setTime(this.f30886c);
        float f2 = this.f30892i;
        canvas.scale(f2, f2);
        Movie movie2 = this.f30884a;
        float f3 = this.f30890g;
        float f4 = this.f30892i;
        movie2.draw(canvas, f3 / f4, this.f30891h / f4);
        canvas.restore();
    }
}
