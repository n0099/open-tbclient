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
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public fy7 b;
    public RelativeLayout c;
    public TextView d;
    public ImageView e;

    /* loaded from: classes6.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public a(y18 y18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public y18(PbFragment pbFragment, fy7 fy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, fy7Var};
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
        this.b = fy7Var;
        f();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) && bdTypeListView != null) {
            this.c.setVisibility(0);
            bdTypeListView.addHeaderView(this.c);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            TextView textView = this.d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                this.d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        }
    }

    public void h(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bdTypeListView) == null) && bdTypeListView != null) {
            this.c.setVisibility(8);
            bdTypeListView.removeHeaderView(this.c);
        }
    }

    public void b(dx7 dx7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dx7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && dx7Var != null && dx7Var.Q() != null && dx7Var.Q().getIsNoTitle() == 0 && !dx7Var.Q().isVideoThreadType()) {
            if (dx7Var.j) {
                this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f68);
                this.e.setVisibility(0);
            } else if (z && z2) {
                this.e.setImageResource(R.drawable.obfuscated_res_0x7f080fa9);
                this.e.setVisibility(0);
            } else if (z) {
                this.e.setImageResource(R.drawable.obfuscated_res_0x7f080fa7);
                this.e.setVisibility(0);
            } else if (z2) {
                this.e.setImageResource(R.drawable.obfuscated_res_0x7f080fa8);
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
            if (this.e.getVisibility() == 0 && this.e.getLayoutParams() != null) {
                this.e.getLayoutParams().height = f18.s() - f18.t();
            }
        }
    }

    public final SpannableStringBuilder c(SpannableStringBuilder spannableStringBuilder, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder, z)) == null) {
            if (!z) {
                return spannableStringBuilder;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            spannableStringBuilder2.insert(0, (CharSequence) "icon");
            int g = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g3 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds49);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f08080d, -1, EMRichTextAnyIconSpan.IconType.PIC);
            eMRichTextAnyIconSpan.f(g2);
            eMRichTextAnyIconSpan.g(g);
            eMRichTextAnyIconSpan.h(g3);
            eMRichTextAnyIconSpan.b(true);
            spannableStringBuilder2.setSpan(eMRichTextAnyIconSpan, 0, 4, 17);
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final SpannableStringBuilder e(SpannableStringBuilder spannableStringBuilder, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, spannableStringBuilder, z)) == null) {
            if (!z) {
                return spannableStringBuilder;
            }
            int g = xi.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int g3 = xi.g(TbadkCoreApplication.getInst(), R.dimen.T_X09);
            int g4 = xi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g5 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int g6 = xi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g7 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e06);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) string);
            py4 py4Var = new py4(g, -1, R.color.CAM_X0302, g3, R.color.CAM_X0101, g4, g7);
            py4Var.f(true);
            py4Var.b(g2);
            py4Var.h(g5);
            py4Var.i(g6);
            py4Var.g(true);
            py4Var.d(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
            spannableStringBuilder2.setSpan(py4Var, 0, string.length(), 17);
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d065c, (ViewGroup) null);
        this.c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0918bd);
        this.e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -f18.t());
        this.e.setImageMatrix(matrix);
        TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09241f);
        this.d = textView;
        kw4 d = kw4.d(textView);
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

    public void i(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dx7Var) == null) && dx7Var != null && dx7Var.Q() != null) {
            SpannableStringBuilder span_str = dx7Var.Q().getSpan_str();
            SpannableString h = f18.h(dx7Var.Q());
            if (!StringUtils.isNull(dx7Var.Q().getTitle())) {
                if (h != null) {
                    span_str.append((CharSequence) h);
                    this.d.setText(span_str, TextView.BufferType.SPANNABLE);
                } else {
                    this.d.setText(span_str);
                }
                l(dx7Var);
                this.d.setVisibility(0);
                this.d.setMaxLines(3);
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                this.d.invalidate();
                return;
            }
            this.d.setVisibility(8);
        }
    }

    public void j(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dx7Var) == null) {
            if (dx7Var != null && !dx7Var.Q().isVideoThreadType() && this.d.getText() != null && this.d.getText().length() > 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void l(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, dx7Var) != null) || this.d == null) {
            return;
        }
        int g = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (dx7Var.l0()) {
            g = 0;
        }
        layoutParams.bottomMargin = g;
        this.d.setLayoutParams(layoutParams);
    }

    public void k(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, dx7Var) == null) && dx7Var != null && dx7Var.Q() != null) {
            SpannableStringBuilder span_str = dx7Var.Q().getSpan_str();
            this.d.setOnTouchListener(new y09(span_str));
            SpannableStringBuilder e = e(span_str, dx7Var.Q().isQuestionThread());
            if (!dx7Var.Q().isQuestionThread()) {
                e = c(span_str, dx7Var.Q().isPbHeadLinesThread());
            }
            this.d.setText(e);
            this.d.setVisibility(0);
        }
    }
}
