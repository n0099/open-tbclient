package com.baidu.tieba.write.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qi;
/* loaded from: classes4.dex */
public class RichGuideHollowView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public Paint b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichGuideHollowView(@NonNull Context context) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        d();
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.b.setXfermode(null);
            this.b.setColor(SkinManager.getColor(R.color.CAM_X0607));
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.b);
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.b.setColor(-1);
            this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            c(canvas);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || this.a == null) {
            return;
        }
        Rect rect = new Rect();
        this.a.getDrawingRect(rect);
        int[] iArr = new int[2];
        this.a.getLocationOnScreen(iArr);
        int i = iArr[0];
        rect.left = i;
        int i2 = iArr[1];
        rect.top = i2;
        rect.right += i;
        rect.bottom += i2;
        RectF rectF = new RectF();
        rectF.left = rect.left - qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        rectF.right = rect.right + qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        rectF.top = rect.top + qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        float f = rect.bottom - qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        rectF.bottom = f;
        float f2 = rectF.top;
        canvas.drawRoundRect(rectF, f - f2, f - f2, this.b);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = new Paint(1);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int saveLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (Build.VERSION.SDK_INT >= 21) {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
            } else {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            }
            a(canvas);
            b(canvas);
            canvas.restoreToCount(saveLayer);
        }
    }

    public void setTargetView(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.a = view2;
            postInvalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichGuideHollowView(Context context, @Nullable AttributeSet attributeSet) {
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
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichGuideHollowView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        d();
    }
}
