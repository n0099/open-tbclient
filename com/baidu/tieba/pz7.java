package com.baidu.tieba;

import android.graphics.Matrix;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public xv7 b;
    public RelativeLayout c;
    public TextView d;
    public ImageView e;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(pz7 pz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public pz7(PbFragment pbFragment, xv7 xv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, xv7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.a = pbFragment;
        this.b = xv7Var;
        e();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.c.setVisibility(0);
        bdTypeListView.addHeaderView(this.c);
    }

    public void b(vu7 vu7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{vu7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || vu7Var == null || vu7Var.O() == null || vu7Var.O().getIsNoTitle() != 0 || vu7Var.O().isVideoThreadType()) {
            return;
        }
        if (vu7Var.j) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f36);
            this.e.setVisibility(0);
        } else if (z && z2) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f77);
            this.e.setVisibility(0);
        } else if (z) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f75);
            this.e.setVisibility(0);
        } else if (z2) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f76);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        if (this.e.getVisibility() != 0 || this.e.getLayoutParams() == null) {
            return;
        }
        this.e.getLayoutParams().height = xy7.h() - xy7.i();
    }

    public RelativeLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (RelativeLayout) invokeV.objValue;
    }

    public final SpannableStringBuilder d(SpannableStringBuilder spannableStringBuilder, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, spannableStringBuilder, z)) == null) {
            if (z) {
                int f = ej.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.T_X09);
                int f4 = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f5 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int f6 = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f7 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds52);
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dde);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                spannableStringBuilder2.append((CharSequence) string);
                gx4 gx4Var = new gx4(f, -1, R.color.CAM_X0302, f3, R.color.CAM_X0101, f4, f7);
                gx4Var.f(true);
                gx4Var.b(f2);
                gx4Var.h(f5);
                gx4Var.i(f6);
                gx4Var.g(true);
                gx4Var.d(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                spannableStringBuilder2.setSpan(gx4Var, 0, string.length(), 17);
                spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
                return spannableStringBuilder2;
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0648, (ViewGroup) null);
            this.c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091885);
            this.e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -xy7.i());
            this.e.setImageMatrix(matrix);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0923dc);
            this.d = textView;
            uu4 d = uu4.d(textView);
            d.z(R.dimen.T_X03);
            d.w(R.dimen.M_T_X003);
            d.v(R.color.CAM_X0105);
            d.A(R.string.F_X02);
            d.r(R.color.CAM_X0304);
            this.d.setVisibility(8);
            if (this.d.getParent() == null) {
                this.c.addView(this.d);
            }
            this.c.setOnTouchListener(this.b);
            this.c.setOnLongClickListener(new a(this));
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            TextView textView = this.d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                this.d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        }
    }

    public void g(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.c.setVisibility(8);
        bdTypeListView.removeHeaderView(this.c);
    }

    public void h(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, vu7Var) == null) || vu7Var == null || vu7Var.O() == null) {
            return;
        }
        SpannableStringBuilder span_str = vu7Var.O().getSpan_str();
        SpannableString c = xy7.c(vu7Var.O());
        if (!StringUtils.isNull(vu7Var.O().getTitle())) {
            if (c != null) {
                span_str.append((CharSequence) c);
                this.d.setText(span_str, TextView.BufferType.SPANNABLE);
            } else {
                this.d.setText(span_str);
            }
            k(vu7Var);
            this.d.setVisibility(0);
            this.d.setMaxLines(3);
            this.d.setEllipsize(TextUtils.TruncateAt.END);
            this.d.invalidate();
            return;
        }
        this.d.setVisibility(8);
    }

    public void i(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vu7Var) == null) {
            if (vu7Var != null && !vu7Var.O().isVideoThreadType() && this.d.getText() != null && this.d.getText().length() > 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void j(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, vu7Var) == null) || vu7Var == null || vu7Var.O() == null) {
            return;
        }
        SpannableStringBuilder span_str = vu7Var.O().getSpan_str();
        this.d.setOnTouchListener(new qy8(span_str));
        this.d.setText(d(span_str, vu7Var.O().isQuestionThread()));
        this.d.setVisibility(0);
    }

    public void k(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, vu7Var) == null) || this.d == null) {
            return;
        }
        int f = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (vu7Var.i0()) {
            f = 0;
        }
        layoutParams.bottomMargin = f;
        this.d.setLayoutParams(layoutParams);
    }
}
