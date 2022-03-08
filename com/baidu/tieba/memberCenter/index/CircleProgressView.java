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

    /* renamed from: e  reason: collision with root package name */
    public Context f44434e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f44435f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f44436g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f44437h;

    /* renamed from: i  reason: collision with root package name */
    public int f44438i;

    /* renamed from: j  reason: collision with root package name */
    public int f44439j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f44438i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f44434e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l = n.f(this.f44434e, R.dimen.ds4);
            this.f44437h = new RectF();
            Paint paint = new Paint();
            this.f44435f = paint;
            paint.setAntiAlias(true);
            this.f44435f.setStrokeWidth(this.l);
            this.f44435f.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f44436g = paint2;
            paint2.setAntiAlias(true);
            this.f44436g.setStrokeWidth(this.l);
            this.f44436g.setStyle(Paint.Style.STROKE);
            this.f44439j = R.color.common_color_10184;
            this.k = R.color.common_color_10162;
            onChangeSkin();
        }
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f44435f.setColor(SkinManager.getColor(this.f44439j));
            this.f44436g.setColor(SkinManager.getColor(this.k));
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            this.m = getWidth();
            int height = getHeight();
            this.n = height;
            int i2 = this.m;
            if (i2 > height) {
                height = i2;
            }
            this.o = height;
            RectF rectF = this.f44437h;
            int i3 = this.l;
            rectF.left = i3 / 2.0f;
            rectF.top = i3 / 2.0f;
            rectF.right = height - (i3 / 2);
            rectF.bottom = height - (i3 / 2);
            canvas.drawArc(rectF, 150.0f, 360.0f, false, this.f44436g);
            canvas.drawArc(this.f44437h, 150.0f, this.f44438i, false, this.f44435f);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void updateView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f44438i = i2;
            invalidate();
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
        this.f44438i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f44434e = context;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44438i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f44434e = context;
        a();
    }
}
