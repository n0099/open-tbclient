package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CircleProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f34455b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f34456c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f34457d;

    /* renamed from: e  reason: collision with root package name */
    public int f34458e;

    /* renamed from: f  reason: collision with root package name */
    public int f34459f;

    /* renamed from: g  reason: collision with root package name */
    public int f34460g;

    /* renamed from: h  reason: collision with root package name */
    public int f34461h;
    public int i;
    public int j;
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
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
        this.f34458e = 0;
        this.f34461h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.a = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34461h = n.f(this.a, R.dimen.obfuscated_res_0x7f070224);
            this.f34457d = new RectF();
            Paint paint = new Paint();
            this.f34455b = paint;
            paint.setAntiAlias(true);
            this.f34455b.setStrokeWidth(this.f34461h);
            this.f34455b.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f34456c = paint2;
            paint2.setAntiAlias(true);
            this.f34456c.setStrokeWidth(this.f34461h);
            this.f34456c.setStyle(Paint.Style.STROKE);
            this.f34459f = R.color.common_color_10184;
            this.f34460g = R.color.common_color_10162;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f34455b.setColor(SkinManager.getColor(this.f34459f));
            this.f34456c.setColor(SkinManager.getColor(this.f34460g));
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            this.i = getWidth();
            int height = getHeight();
            this.j = height;
            int i = this.i;
            if (i > height) {
                height = i;
            }
            this.k = height;
            RectF rectF = this.f34457d;
            int i2 = this.f34461h;
            rectF.left = i2 / 2.0f;
            rectF.top = i2 / 2.0f;
            rectF.right = height - (i2 / 2);
            rectF.bottom = height - (i2 / 2);
            canvas.drawArc(rectF, 150.0f, 360.0f, false, this.f34456c);
            canvas.drawArc(this.f34457d, 150.0f, this.f34458e, false, this.f34455b);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context, AttributeSet attributeSet) {
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
        this.f34458e = 0;
        this.f34461h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.a = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context) {
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
        this.f34458e = 0;
        this.f34461h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.a = context;
        a();
    }
}
