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
/* loaded from: classes4.dex */
public class ky7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public ou7 b;
    public RelativeLayout c;
    public TextView d;
    public ImageView e;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
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

    public ky7(PbFragment pbFragment, ou7 ou7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, ou7Var};
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
        this.b = ou7Var;
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

    public void b(mt7 mt7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mt7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || mt7Var == null || mt7Var.O() == null || mt7Var.O().getIsNoTitle() != 0 || mt7Var.O().isVideoThreadType()) {
            return;
        }
        if (mt7Var.j) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f0f);
            this.e.setVisibility(0);
        } else if (z && z2) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f51);
            this.e.setVisibility(0);
        } else if (z) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f4f);
            this.e.setVisibility(0);
        } else if (z2) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f50);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        if (this.e.getVisibility() != 0 || this.e.getLayoutParams() == null) {
            return;
        }
        this.e.getLayoutParams().height = sx7.h() - sx7.i();
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
                int f = ri.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int f2 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int f3 = ri.f(TbadkCoreApplication.getInst(), R.dimen.T_X09);
                int f4 = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f5 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int f6 = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f7 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds52);
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dc4);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                spannableStringBuilder2.append((CharSequence) string);
                yu4 yu4Var = new yu4(f, -1, R.color.CAM_X0302, f3, R.color.CAM_X0101, f4, f7);
                yu4Var.f(true);
                yu4Var.b(f2);
                yu4Var.h(f5);
                yu4Var.i(f6);
                yu4Var.g(true);
                yu4Var.d(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                spannableStringBuilder2.setSpan(yu4Var, 0, string.length(), 17);
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
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0631, (ViewGroup) null);
            this.c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09184f);
            this.e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -sx7.i());
            this.e.setImageMatrix(matrix);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092383);
            this.d = textView;
            os4 d = os4.d(textView);
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

    public void h(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, mt7Var) == null) || mt7Var == null || mt7Var.O() == null) {
            return;
        }
        SpannableStringBuilder span_str = mt7Var.O().getSpan_str();
        SpannableString c = sx7.c(mt7Var.O());
        if (!StringUtils.isNull(mt7Var.O().getTitle())) {
            if (c != null) {
                span_str.append((CharSequence) c);
                this.d.setText(span_str, TextView.BufferType.SPANNABLE);
            } else {
                this.d.setText(span_str);
            }
            k(mt7Var);
            this.d.setVisibility(0);
            this.d.setMaxLines(3);
            this.d.setEllipsize(TextUtils.TruncateAt.END);
            this.d.invalidate();
            return;
        }
        this.d.setVisibility(8);
    }

    public void i(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mt7Var) == null) {
            if (mt7Var != null && !mt7Var.O().isVideoThreadType() && this.d.getText() != null && this.d.getText().length() > 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void j(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, mt7Var) == null) || mt7Var == null || mt7Var.O() == null) {
            return;
        }
        SpannableStringBuilder span_str = mt7Var.O().getSpan_str();
        this.d.setOnTouchListener(new ax8(span_str));
        this.d.setText(d(span_str, mt7Var.O().isQuestionThread()));
        this.d.setVisibility(0);
    }

    public void k(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, mt7Var) == null) || this.d == null) {
            return;
        }
        int f = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (mt7Var.i0()) {
            f = 0;
        }
        layoutParams.bottomMargin = f;
        this.d.setLayoutParams(layoutParams);
    }
}
