package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oi;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public b h;
    public View.OnClickListener i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChooseColorLayout a;

        public a(ChooseColorLayout chooseColorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chooseColorLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chooseColorLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int intValue;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2 instanceof ChooseColorView) && (intValue = ((Integer) view2.getTag()).intValue()) != this.a.f) {
                ChooseColorLayout chooseColorLayout = this.a;
                View childAt = chooseColorLayout.getChildAt(chooseColorLayout.f);
                if (childAt instanceof ChooseColorView) {
                    ((ChooseColorView) childAt).setIsChooseView(false);
                }
                this.a.f = intValue;
                ChooseColorView chooseColorView = (ChooseColorView) view2;
                this.a.e = chooseColorView.getChooseColor();
                chooseColorView.setIsChooseView(true);
                if (this.a.h != null) {
                    this.a.h.a(this.a.e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChooseColorLayout(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = oi.k(getContext());
            this.a = getResources().getIntArray(R.array.obfuscated_res_0x7f03000e);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
            this.d = dimensionPixelSize;
            int i = (this.g - (dimensionPixelSize * 2)) / 8;
            this.b = i;
            this.c = (i - (getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be) * 2)) / 2;
            int i2 = this.b;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            layoutParams.gravity = 17;
            for (int i3 = 0; i3 < this.a.length; i3++) {
                ChooseColorView chooseColorView = new ChooseColorView(getContext());
                chooseColorView.setChooseColor(this.a[i3]);
                chooseColorView.setTag(Integer.valueOf(i3));
                chooseColorView.setRadius(this.c);
                if (i3 == 0) {
                    chooseColorView.setIsChooseView(true);
                    this.e = this.a[i3];
                    this.f = i3;
                }
                chooseColorView.setOnClickListener(this.i);
                addView(chooseColorView, layoutParams);
            }
            int i4 = this.d;
            setPadding(i4, 0, i4, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5));
        }
    }

    public int getCurrentChooseColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : invokeV.intValue;
    }

    public void setOnChooseColorChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.h = bVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.i = new a(this);
        f();
    }
}
