package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class MistView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MASK_COLOR_DEFAULT_TRANSPARENT;
    public static final long a = 100;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f50888b;

    /* renamed from: c  reason: collision with root package name */
    public int f50889c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f50890d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2092935932, "Lcom/baidu/wallet/base/widget/MistView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2092935932, "Lcom/baidu/wallet/base/widget/MistView;");
                return;
            }
        }
        MASK_COLOR_DEFAULT_TRANSPARENT = Color.argb(127, 0, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MistView(Context context, AttributeSet attributeSet) {
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
        this.f50890d = new Rect();
        this.f50888b = new Paint();
        this.f50889c = MASK_COLOR_DEFAULT_TRANSPARENT;
    }

    public Rect getFocusFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50890d : (Rect) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.f50888b.setColor(this.f50889c);
            if (this.f50890d.width() == 0) {
                return;
            }
            float f2 = width;
            canvas.drawRect(0.0f, 0.0f, f2, this.f50890d.top, this.f50888b);
            Rect rect = this.f50890d;
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.f50888b);
            Rect rect2 = this.f50890d;
            canvas.drawRect(rect2.right, rect2.top, f2, rect2.bottom, this.f50888b);
            canvas.drawRect(0.0f, this.f50890d.bottom, f2, height, this.f50888b);
            Rect rect3 = this.f50890d;
            postInvalidateDelayed(100L, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
    }

    public void setMistColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f50889c = i2;
            postInvalidate();
        }
    }
}
