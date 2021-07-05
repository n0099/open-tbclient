package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CompressProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f21502e;

    /* renamed from: f  reason: collision with root package name */
    public int f21503f;

    /* renamed from: g  reason: collision with root package name */
    public int f21504g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f21505h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f21506i;
    public RectF j;
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompressProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        this.k = 0;
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21502e = getResources().getDimensionPixelSize(R.dimen.ds100);
            this.f21503f = getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f21504g = getResources().getDimensionPixelSize(R.dimen.ds2);
            Paint paint = new Paint();
            this.f21505h = paint;
            paint.setStrokeWidth(this.f21503f);
            this.f21505h.setColor(getResources().getColor(R.color.CAM_X0201));
            this.f21505h.setStyle(Paint.Style.STROKE);
            this.f21505h.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f21506i = paint2;
            paint2.setStrokeWidth(this.f21504g);
            this.f21506i.setColor(getResources().getColor(R.color.CAM_X0101));
            this.f21506i.setStyle(Paint.Style.STROKE);
            this.f21506i.setAntiAlias(true);
            int i2 = this.f21503f;
            int i3 = this.f21502e;
            this.j = new RectF(i2, i2, i3 + i2, i3 + i2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.drawArc(this.j, 270.0f, 360.0f, false, this.f21506i);
            canvas.drawArc(this.j, 270.0f, (this.k * 360) / 100, false, this.f21505h);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 == this.k) {
            return;
        }
        this.k = i2;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompressProgressView(Context context, AttributeSet attributeSet) {
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
        this.k = 0;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompressProgressView(Context context) {
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
        this.k = 0;
        a();
    }
}
