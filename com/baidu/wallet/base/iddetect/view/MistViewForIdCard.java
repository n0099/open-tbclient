package com.baidu.wallet.base.iddetect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.MistView;
/* loaded from: classes8.dex */
public class MistViewForIdCard extends MistView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBackgroundColor;
    public int mCornerSize;
    public int mRoundCornerColor;
    public int mRoundCornerWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MistViewForIdCard(Context context, AttributeSet attributeSet) {
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
        this.mCornerSize = 40;
        this.mBackgroundColor = MistView.MASK_COLOR_DEFAULT_TRANSPARENT;
        this.mRoundCornerColor = -1;
        this.mRoundCornerWidth = 4;
    }

    @Override // com.baidu.wallet.base.widget.MistView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            Rect focusFrame = getFocusFrame();
            if (focusFrame.width() == 0) {
                return;
            }
            Paint paint = new Paint();
            Path path = new Path();
            paint.setColor(this.mBackgroundColor);
            path.addRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), Path.Direction.CW);
            path.close();
            canvas.drawPath(path, paint);
            Paint paint2 = new Paint();
            paint2.setStyle(Paint.Style.FILL);
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            paint2.setFlags(1);
            Path path2 = new Path();
            RectF rectF = new RectF(focusFrame.left, focusFrame.top, focusFrame.right, focusFrame.bottom);
            int i2 = this.mCornerSize;
            path2.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            path2.close();
            canvas.drawPath(path2, paint2);
            Paint paint3 = new Paint();
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setStrokeWidth(this.mRoundCornerWidth);
            paint3.setColor(this.mRoundCornerColor);
            paint3.setFlags(1);
            int i3 = this.mCornerSize;
            canvas.drawRoundRect(rectF, i3, i3, paint3);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mBackgroundColor = i2;
        }
    }

    public void setCornerSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.mCornerSize = i2;
        }
    }
}
