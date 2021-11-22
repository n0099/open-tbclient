package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import b.a.e.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class GridLineView extends BdGridView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f51888e;

    /* renamed from: f  reason: collision with root package name */
    public int f51889f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLineView(Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            Paint paint = new Paint();
            this.f51888e = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f51888e.setColor(SkinManager.getColor(R.color.CAM_X0204));
            this.f51888e.setStrokeWidth(1.0f);
            this.f51889f = l.g(context, R.dimen.ds26);
        }
    }

    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.dispatchDraw(canvas);
            int childCount = getChildCount();
            if (childCount > 0 && (childAt = getChildAt(0)) != null) {
                int numColumns = getNumColumns();
                int i3 = childCount % numColumns;
                int i4 = childCount / numColumns;
                if (i3 != 0) {
                    i4++;
                }
                int width = childAt.getWidth() * numColumns;
                int width2 = childAt.getWidth();
                int height = childAt.getHeight();
                int top = childAt.getTop();
                for (int i5 = 1; i5 <= i4; i5++) {
                    float f2 = top + (height * i5);
                    canvas.drawLine(0.0f, f2, width, f2, this.f51888e);
                    for (int i6 = 1; i6 < numColumns; i6++) {
                        float f3 = width2 * i6;
                        int i7 = this.f51889f;
                        canvas.drawLine(f3, ((i5 - 1) * height) + top + i7, f3, i2 - i7, this.f51888e);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f51888e.setColor(SkinManager.getColor(R.color.CAM_X0204));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLineView(Context context, AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLineView(Context context, AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}
