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
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class RichGuideHollowView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f48331e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f48332f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichGuideHollowView(@NonNull Context context) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        d();
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f48332f.setXfermode(null);
            this.f48332f.setColor(SkinManager.getColor(R.color.CAM_X0607));
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f48332f);
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.f48332f.setColor(-1);
            this.f48332f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            c(canvas);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || this.f48331e == null) {
            return;
        }
        Rect rect = new Rect();
        this.f48331e.getDrawingRect(rect);
        int[] iArr = new int[2];
        this.f48331e.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        rect.left = i2;
        int i3 = iArr[1];
        rect.top = i3;
        rect.right += i2;
        rect.bottom += i3;
        RectF rectF = new RectF();
        rectF.left = rect.left - n.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        rectF.right = rect.right + n.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        rectF.top = rect.top + n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        float f2 = rect.bottom - n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        rectF.bottom = f2;
        float f3 = rectF.top;
        canvas.drawRoundRect(rectF, f2 - f3, f2 - f3, this.f48332f);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f48332f = new Paint(1);
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

    public void setTargetView(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.f48331e = view;
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
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichGuideHollowView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        d();
    }
}
