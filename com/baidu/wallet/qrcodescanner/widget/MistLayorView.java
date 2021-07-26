package com.baidu.wallet.qrcodescanner.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class MistLayorView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Paint f27434a;

    /* renamed from: b  reason: collision with root package name */
    public final int f27435b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f27436c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MistLayorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27436c = new Rect();
        this.f27434a = new Paint();
        this.f27435b = Color.argb(127, 0, 0, 0);
    }

    public Rect getFocusFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27436c : (Rect) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.f27434a.setColor(this.f27435b);
            if (this.f27436c.width() == 0) {
                canvas.drawRect(0.0f, 0.0f, width, height, this.f27434a);
                return;
            }
            float f2 = width;
            canvas.drawRect(0.0f, 0.0f, f2, this.f27436c.top, this.f27434a);
            Rect rect = this.f27436c;
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f27434a);
            Rect rect2 = this.f27436c;
            canvas.drawRect(rect2.right + 1, rect2.top, f2, rect2.bottom + 1, this.f27434a);
            canvas.drawRect(0.0f, this.f27436c.bottom + 1, f2, height, this.f27434a);
        }
    }

    public void setFocusFrame(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rect) == null) {
            this.f27436c = rect;
            invalidate();
        }
    }
}
