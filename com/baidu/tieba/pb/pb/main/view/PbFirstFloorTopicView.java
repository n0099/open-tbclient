package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class PbFirstFloorTopicView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f55426e;

    /* renamed from: f  reason: collision with root package name */
    public int f55427f;

    /* renamed from: g  reason: collision with root package name */
    public int f55428g;

    /* renamed from: h  reason: collision with root package name */
    public int f55429h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorTopicView(Context context) {
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
        this.f55426e = null;
        c(context);
    }

    public final LinearLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f55426e);
            SkinManager.setBackgroundColor(linearLayout, R.color.transparent);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.f55429h, -2));
            linearLayout.setGravity(17);
            addView(linearLayout);
            return linearLayout;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void b(LinearLayout linearLayout, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, str) == null) {
            TextView textView = new TextView(this.f55426e);
            textView.setText(str);
            textView.setGravity(17);
            SkinManager.setBackgroundColor(textView, R.color.CAM_X0204);
            SkinManager.setViewTextColor(textView, R.color.black_alpha100);
            textView.setTextSize(0, getResources().getDimension(R.dimen.ds28));
            textView.setTypeface(null, 1);
            textView.setMinLines(1);
            textView.setMaxLines(1);
            textView.setWidth(this.f55427f);
            textView.setOnClickListener(this);
            linearLayout.addView(textView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            int i2 = this.f55428g;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            setOrientation(1);
            this.f55426e = context;
            this.f55428g = l.g(context, R.dimen.ds8);
            this.f55429h = l.k(this.f55426e);
            this.f55427f = l.k(this.f55426e) / 2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && (view instanceof TextView)) {
            TextView textView = (TextView) view;
            if (textView.getText() != null) {
                textView.getText().toString();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            removeAllViews();
            super.onDetachedFromWindow();
        }
    }

    public void setData(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        if (getChildCount() > 0) {
            removeAllViews();
        }
        int count = ListUtils.getCount(arrayList);
        LinearLayout linearLayout = null;
        for (int i2 = 0; i2 < count; i2++) {
            if (i2 % 2 == 0) {
                linearLayout = a();
            } else if (linearLayout != null) {
                b(linearLayout, (String) ListUtils.getItem(arrayList, i2 - 1));
                b(linearLayout, (String) ListUtils.getItem(arrayList, i2));
            }
        }
        if (linearLayout == null || linearLayout.getChildCount() != 0) {
            return;
        }
        this.f55427f = this.f55429h;
        b(linearLayout, (String) ListUtils.getItem(arrayList, count - 1));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorTopicView(Context context, AttributeSet attributeSet) {
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
        this.f55426e = null;
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorTopicView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f55426e = null;
        c(context);
    }
}
