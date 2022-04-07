package com.baidu.tieba.stampmission.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.stampmission.view.SingleStampView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hi8;
import com.repackage.oi;
import com.repackage.wr4;
/* loaded from: classes4.dex */
public class SingleStampView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public EMTextView b;
    public a c;

    /* loaded from: classes4.dex */
    public interface a {
        void a(hi8 hi8Var);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleStampView(Context context) {
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

    private void setClickListener(final hi8 hi8Var) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, hi8Var) == null) || (tbImageView = this.a) == null) {
            return;
        }
        tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.oi8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    SingleStampView.this.e(hi8Var, view2);
                }
            }
        });
    }

    private void setStampDescData(hi8 hi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, hi8Var) == null) {
            String str = hi8Var.c() + hi8Var.a() + "/" + hi8Var.b();
            if (hi8Var.a() > 0) {
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), hi8Var.c().length(), hi8Var.c().length() + String.valueOf(hi8Var.a()).length(), 33);
                this.b.setText(spannableString);
                return;
            }
            this.b.setText(str);
        }
    }

    private void setStampImgData(hi8 hi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, hi8Var) == null) {
            String d = hi8Var.d();
            if (TextUtils.isEmpty(d)) {
                return;
            }
            this.a.K(d, 10, false);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.b == null) {
                this.b = new EMTextView(getContext());
            }
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            wr4 d = wr4.d(this.b);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X08);
            addView(this.b);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.a == null) {
                this.a = new TbImageView(getContext());
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(oi.f(getContext(), R.dimen.tbds146), oi.f(getContext(), R.dimen.tbds146));
            layoutParams.setMargins(0, 0, 0, oi.f(getContext(), R.dimen.M_H_X004));
            this.a.setLayoutParams(layoutParams);
            this.a.setPlaceHolder(1);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.a);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            setOrientation(1);
            setGravity(1);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
            b();
            a();
        }
    }

    public /* synthetic */ void e(hi8 hi8Var, View view2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(hi8Var);
        }
    }

    public void setData(hi8 hi8Var, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, hi8Var, aVar) == null) || hi8Var == null) {
            return;
        }
        this.c = aVar;
        setStampImgData(hi8Var);
        setStampDescData(hi8Var);
        setClickListener(hi8Var);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleStampView(Context context, @Nullable AttributeSet attributeSet) {
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
    public SingleStampView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
