package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.m1.b.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class LabelItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLUM_NUM = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53555e;

    /* renamed from: f  reason: collision with root package name */
    public int f53556f;

    /* renamed from: g  reason: collision with root package name */
    public int f53557g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f53558h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelItemView(Context context) {
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
        b();
    }

    public final TextView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextView) LayoutInflater.from(getContext()).inflate(R.layout.label_recommend_column_item, (ViewGroup) this, false) : (TextView) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setWeightSum(3.0f);
            setOrientation(0);
            Paint paint = new Paint();
            this.f53558h = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f53558h.setColor(SkinManager.getColor(R.color.CAM_X0204));
            this.f53558h.setStrokeWidth(1.0f);
            this.f53557g = l.g(getContext(), R.dimen.ds46);
            for (int i2 = 0; i2 < 3; i2++) {
                addView(a());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            int width = getWidth() / 3;
            int height = getHeight();
            for (int i2 = 1; i2 < this.f53556f; i2++) {
                int i3 = width * i2;
                int i4 = this.f53557g;
                canvas.drawLine(i3, (height - i4) / 2, i3 + 1, (i4 + height) / 2, this.f53558h);
            }
            if (this.f53555e) {
                return;
            }
            canvas.drawLine(0.0f, height - 1, getWidth(), height, this.f53558h);
        }
    }

    public void setData(List<a> list, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f53555e = z;
        this.f53556f = Math.min(list.size(), 3);
        int i3 = 0;
        while (true) {
            i2 = this.f53556f;
            if (i3 >= i2) {
                break;
            }
            a aVar = list.get(i3);
            if (aVar != null && (getChildAt(i3) instanceof TextView)) {
                TextView textView = (TextView) getChildAt(i3);
                textView.setVisibility(0);
                String str = aVar.f22351b;
                if (!StringUtils.isNull(str) && aVar.f22351b.length() > 4) {
                    str = aVar.f22351b.substring(0, 3) + "...";
                }
                textView.setText(str);
                SkinManager.setViewTextColor(textView, R.drawable.color_lable_selector);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_lable_selector), (Drawable) null);
                textView.setSelected(aVar.f22352c);
                textView.setTag(aVar);
            }
            i3++;
        }
        while (i2 < getChildCount()) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                childAt.setVisibility(8);
            }
            i2++;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                childAt.setOnClickListener(onClickListener);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelItemView(Context context, AttributeSet attributeSet) {
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
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelItemView(Context context, AttributeSet attributeSet, int i2) {
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
        b();
    }
}
