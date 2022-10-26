package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonExpandImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Rect a;
    public final Rect b;
    public final Paint c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Rect();
        this.b = new Rect();
        this.d = 0;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.c = new Paint();
        getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) && this.d != 0 && (drawable = getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width != 0 && height != 0) {
                float f3 = width;
                float f4 = height;
                float f5 = 0.0f;
                if ((f3 * 1.0f) / f4 < (getWidth() * 1.0f) / this.d) {
                    float width2 = (((((getWidth() * getHeight()) * 1.0f) / this.d) - getWidth()) * 0.2f) + getWidth();
                    float f6 = ((1.0f * f4) / f3) * width2;
                    if (width2 != 0.0f && f6 != 0.0f) {
                        float width3 = (getWidth() * width) / width2;
                        float height2 = (getHeight() * height) / f6;
                        f = (f3 - width3) / 2.0f;
                        float f7 = (f4 - height2) / 2.0f;
                        f2 = width3 + f;
                        if (f7 < 0.0f) {
                            float abs = Math.abs(f7) + height2;
                            if (abs <= f4) {
                                f4 = abs;
                            }
                        } else {
                            f4 = f7 + height2;
                            f5 = f7;
                        }
                    } else {
                        return;
                    }
                } else {
                    float height3 = ((getHeight() * width) * 1.0f) / f4;
                    if (height3 == 0.0f) {
                        return;
                    }
                    float width4 = (getWidth() * width) / height3;
                    f = (f3 - width4) / 2.0f;
                    f2 = width4 + f;
                }
                this.a.set((int) f, (int) f5, (int) f2, (int) f4);
                this.b.set(0, 0, getWidth(), getHeight());
                canvas.drawBitmap(bitmap, this.a, this.b, this.c);
            }
        }
    }

    public void setInitHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.d = i;
        }
    }
}
