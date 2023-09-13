package com.baidu.validation.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ekb;
import com.baidu.tieba.wf1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.validation.utils.ValidationLog;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class ValidationWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Paint i;
    public Paint j;
    public float[] k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValidationWebView(Context context) {
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
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        b(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValidationWebView(Context context, AttributeSet attributeSet) {
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
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        b(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValidationWebView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        b(context, attributeSet);
    }

    public void a(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            float[] fArr = this.k;
            fArr[0] = f;
            fArr[1] = f;
            fArr[2] = f2;
            fArr[3] = f2;
            fArr[4] = f3;
            fArr[5] = f3;
            fArr[6] = f4;
            fArr[7] = f4;
        }
    }

    public final void b(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
            Paint paint = new Paint();
            this.i = paint;
            paint.setColor(-1);
            this.i.setAntiAlias(true);
            this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Paint paint2 = new Paint();
            this.j = paint2;
            paint2.setXfermode(null);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, wf1.ValidationWebView);
                this.a = obtainStyledAttributes.getDimension(2, 0.0f);
                this.b = obtainStyledAttributes.getDimension(3, 0.0f);
                this.c = obtainStyledAttributes.getDimension(0, 0.0f);
                this.d = obtainStyledAttributes.getDimension(1, 0.0f);
                obtainStyledAttributes.recycle();
                a(this.a, this.b, this.d, this.c);
            }
            setScrollBarStyle(0);
            WebSettings settings = getSettings();
            settings.setTextSize(WebSettings.TextSize.NORMAL);
            settings.setJavaScriptEnabled(true);
            settings.setSupportZoom(true);
            settings.setSavePassword(false);
            settings.setAllowFileAccess(false);
            settings.setDomStorageEnabled(true);
            settings.setAllowContentAccess(false);
            settings.setUserAgentString(ekb.c(context, settings.getUserAgentString()));
            if (Build.VERSION.SDK_INT >= 29) {
                settings.setForceDark(0);
            }
            if (Build.VERSION.SDK_INT < 19) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    Method method = Class.forName("android.webkit.WebView").getMethod("setWebContentsDebuggingEnabled", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(null, Boolean.TRUE);
                } catch (Exception e) {
                    ValidationLog.e(e.getMessage(), new Object[0]);
                }
            }
            setFocusable(true);
            setDrawingCacheEnabled(true);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.g = getScrollX();
            this.h = getScrollY();
            Path path = new Path();
            int i = this.h;
            path.addRoundRect(new RectF(0.0f, i, this.g + this.e, i + this.f), this.k, Path.Direction.CW);
            canvas.clipPath(path);
            super.onDraw(canvas);
        }
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.e = getMeasuredWidth();
            this.f = getMeasuredHeight();
        }
    }
}
