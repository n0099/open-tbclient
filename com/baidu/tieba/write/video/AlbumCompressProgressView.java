package com.baidu.tieba.write.video;

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
/* loaded from: classes6.dex */
public class AlbumCompressProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f37348b;

    /* renamed from: c  reason: collision with root package name */
    public int f37349c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f37350d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f37351e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f37352f;

    /* renamed from: g  reason: collision with root package name */
    public int f37353g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumCompressProgressView(Context context, AttributeSet attributeSet, int i) {
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
        this.f37353g = 0;
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a);
            this.f37348b = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224);
            this.f37349c = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4);
            Paint paint = new Paint();
            this.f37350d = paint;
            paint.setStrokeWidth(this.f37348b);
            this.f37350d.setColor(getResources().getColor(R.color.CAM_X0201));
            this.f37350d.setStyle(Paint.Style.STROKE);
            this.f37350d.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f37351e = paint2;
            paint2.setStrokeWidth(this.f37349c);
            this.f37351e.setColor(getResources().getColor(R.color.CAM_X0101));
            this.f37351e.setStyle(Paint.Style.STROKE);
            this.f37351e.setAntiAlias(true);
            int i = this.f37348b;
            int i2 = this.a;
            this.f37352f = new RectF(i, i, i2 + i, i2 + i);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.drawArc(this.f37352f, 270.0f, 360.0f, false, this.f37351e);
            canvas.drawArc(this.f37352f, 270.0f, (this.f37353g * 360) / 100, false, this.f37350d);
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || i == this.f37353g) {
            return;
        }
        this.f37353g = i;
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
        this.f37353g = 0;
        a();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37353g = 0;
        a();
    }
}
