package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ChooseColorLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int[] f52962e;

    /* renamed from: f  reason: collision with root package name */
    public int f52963f;

    /* renamed from: g  reason: collision with root package name */
    public int f52964g;

    /* renamed from: h  reason: collision with root package name */
    public int f52965h;

    /* renamed from: i  reason: collision with root package name */
    public int f52966i;
    public int j;
    public int k;
    public b l;
    public View.OnClickListener onClickListener;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChooseColorLayout f52967e;

        public a(ChooseColorLayout chooseColorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chooseColorLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52967e = chooseColorLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != this.f52967e.j) {
                ChooseColorLayout chooseColorLayout = this.f52967e;
                View childAt = chooseColorLayout.getChildAt(chooseColorLayout.j);
                if (childAt instanceof ChooseColorView) {
                    ((ChooseColorView) childAt).setIsChooseView(false);
                }
                this.f52967e.j = intValue;
                ChooseColorView chooseColorView = (ChooseColorView) view;
                this.f52967e.f52966i = chooseColorView.getChooseColor();
                chooseColorView.setIsChooseView(true);
                if (this.f52967e.l != null) {
                    this.f52967e.l.a(this.f52967e.f52966i);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(int i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.k = l.k(getContext());
            this.f52962e = getResources().getIntArray(R.array.choose_colors);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
            this.f52965h = dimensionPixelSize;
            int i2 = (this.k - (dimensionPixelSize * 2)) / 8;
            this.f52963f = i2;
            this.f52964g = (i2 - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
            int i3 = this.f52963f;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            layoutParams.gravity = 17;
            for (int i4 = 0; i4 < this.f52962e.length; i4++) {
                ChooseColorView chooseColorView = new ChooseColorView(getContext());
                chooseColorView.setChooseColor(this.f52962e[i4]);
                chooseColorView.setTag(Integer.valueOf(i4));
                chooseColorView.setRadius(this.f52964g);
                if (i4 == 0) {
                    chooseColorView.setIsChooseView(true);
                    this.f52966i = this.f52962e[i4];
                    this.j = i4;
                }
                chooseColorView.setOnClickListener(this.onClickListener);
                addView(chooseColorView, layoutParams);
            }
            int i5 = this.f52965h;
            setPadding(i5, 0, i5, getResources().getDimensionPixelSize(R.dimen.ds20));
        }
    }

    public int getCurrentChooseColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52966i : invokeV.intValue;
    }

    public void setOnChooseColorChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.l = bVar;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.onClickListener = new a(this);
        f();
    }
}
