package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ogb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Bitmap b;
    public Rect c;

    public ogb(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.c = new Rect();
    }

    public boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (motionEvent == null) {
                return false;
            }
            Rect rect = this.c;
            int i = rect.left;
            int i2 = rect.right;
            int i3 = rect.top;
            int i4 = rect.bottom;
            if (motionEvent.getX(0) < i || motionEvent.getX(0) > i2 || motionEvent.getY(0) < i3 || motionEvent.getY(0) > i4) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void a(Canvas canvas, float f, float f2) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2)}) != null) || (bitmap = this.b) == null) {
            return;
        }
        this.c.left = (int) (f - (bitmap.getWidth() / 2));
        this.c.right = (int) (f + (this.b.getWidth() / 2));
        this.c.top = (int) (f2 - (this.b.getHeight() / 2));
        this.c.bottom = (int) (f2 + (this.b.getHeight() / 2));
        canvas.drawBitmap(this.b, (Rect) null, this.c, (Paint) null);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b = BitmapHelper.getResBitmap(this.a, i);
        }
    }
}
