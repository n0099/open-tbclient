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
/* loaded from: classes9.dex */
public class PersonExpandImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f54169e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f54170f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f54171g;

    /* renamed from: h  reason: collision with root package name */
    public int f54172h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonExpandImageView(Context context, AttributeSet attributeSet) {
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
        this.f54169e = new Rect();
        this.f54170f = new Rect();
        this.f54172h = 0;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f54171g = new Paint();
        getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.f54172h == 0 || (drawable = getDrawable()) == null || !(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled()) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        float f4 = width;
        float f5 = height;
        float f6 = 0.0f;
        if ((f4 * 1.0f) / f5 < (getWidth() * 1.0f) / this.f54172h) {
            float width2 = (((((getWidth() * getHeight()) * 1.0f) / this.f54172h) - getWidth()) * 0.2f) + getWidth();
            float f7 = ((1.0f * f5) / f4) * width2;
            if (width2 == 0.0f || f7 == 0.0f) {
                return;
            }
            float width3 = (getWidth() * width) / width2;
            float height2 = (getHeight() * height) / f7;
            f2 = (f4 - width3) / 2.0f;
            float f8 = (f5 - height2) / 2.0f;
            f3 = width3 + f2;
            if (f8 < 0.0f) {
                float abs = Math.abs(f8) + height2;
                if (abs <= f5) {
                    f5 = abs;
                }
            } else {
                f5 = f8 + height2;
                f6 = f8;
            }
        } else {
            float height3 = ((getHeight() * width) * 1.0f) / f5;
            if (height3 == 0.0f) {
                return;
            }
            float width4 = (getWidth() * width) / height3;
            f2 = (f4 - width4) / 2.0f;
            f3 = width4 + f2;
        }
        this.f54169e.set((int) f2, (int) f6, (int) f3, (int) f5);
        this.f54170f.set(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(bitmap, this.f54169e, this.f54170f, this.f54171g);
    }

    public void setInitHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f54172h = i2;
        }
    }
}
