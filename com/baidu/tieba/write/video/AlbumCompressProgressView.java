package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import c.a.t0.o4.d;
import c.a.t0.o4.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class AlbumCompressProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f51673e;

    /* renamed from: f  reason: collision with root package name */
    public int f51674f;

    /* renamed from: g  reason: collision with root package name */
    public int f51675g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f51676h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f51677i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f51678j;

    /* renamed from: k  reason: collision with root package name */
    public int f51679k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumCompressProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51679k = 0;
        init();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f51673e = getResources().getDimensionPixelSize(e.ds100);
            this.f51674f = getResources().getDimensionPixelSize(e.ds4);
            this.f51675g = getResources().getDimensionPixelSize(e.ds2);
            Paint paint = new Paint();
            this.f51676h = paint;
            paint.setStrokeWidth(this.f51674f);
            this.f51676h.setColor(getResources().getColor(d.CAM_X0201));
            this.f51676h.setStyle(Paint.Style.STROKE);
            this.f51676h.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f51677i = paint2;
            paint2.setStrokeWidth(this.f51675g);
            this.f51677i.setColor(getResources().getColor(d.CAM_X0101));
            this.f51677i.setStyle(Paint.Style.STROKE);
            this.f51677i.setAntiAlias(true);
            int i2 = this.f51674f;
            int i3 = this.f51673e;
            this.f51678j = new RectF(i2, i2, i3 + i2, i3 + i2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.drawArc(this.f51678j, 270.0f, 360.0f, false, this.f51677i);
            canvas.drawArc(this.f51678j, 270.0f, (this.f51679k * 360) / 100, false, this.f51676h);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 == this.f51679k) {
            return;
        }
        this.f51679k = i2;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumCompressProgressView(Context context, AttributeSet attributeSet) {
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
        this.f51679k = 0;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumCompressProgressView(Context context) {
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
        this.f51679k = 0;
        init();
    }
}
