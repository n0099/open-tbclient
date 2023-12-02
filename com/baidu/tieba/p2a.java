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
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public tx9 b;
    public RelativeLayout c;
    public TextView d;
    public ImageView e;

    /* loaded from: classes7.dex */
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

        public a(p2a p2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p2aVar};
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

    public p2a(PbFragment pbFragment, tx9 tx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, tx9Var};
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
        this.b = tx9Var;
        f();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) && bdTypeListView != null) {
            this.c.setVisibility(0);
            bdTypeListView.addHeaderView(this.c);
            this.c.setTag(Integer.valueOf(bdTypeListView.getHeaderViewsCount()));
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

    public RelativeLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public ImageView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (ImageView) invokeV.objValue;
    }

    public final SpannableStringBuilder c(SpannableStringBuilder spannableStringBuilder, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder, z)) == null) {
            if (!z) {
                return spannableStringBuilder;
            }
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (UbsABTestHelper.isNewFrs()) {
                i = R.color.CAM_X0302;
            } else {
                i = R.color.CAM_X0101;
            }
            int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
            int dimens4 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens5 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens7 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            String string = TbadkCoreApplication.getInst().getString(R.string.pb_ask_post_title_help);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) string);
            j55 j55Var = new j55(dimens, -1, (int) R.color.CAM_X0302, dimens3, i, dimens4, dimens7);
            if (UbsABTestHelper.isNewFrs()) {
                j55Var.f(false);
            } else {
                j55Var.f(true);
            }
            j55Var.b(dimens2);
            j55Var.h(dimens5);
            j55Var.i(dimens6);
            j55Var.g(true);
            j55Var.d(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
            spannableStringBuilder2.setSpan(j55Var, 0, string.length(), 17);
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public final SpannableStringBuilder e(SpannableStringBuilder spannableStringBuilder, @DrawableRes int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{spannableStringBuilder, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!z) {
                return spannableStringBuilder;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            spannableStringBuilder2.insert(0, (CharSequence) "icon");
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds49);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(i, -1, EMRichTextAnyIconSpan.IconType.PIC);
            eMRichTextAnyIconSpan.j(dimens2);
            eMRichTextAnyIconSpan.f(0);
            eMRichTextAnyIconSpan.k(dimens);
            eMRichTextAnyIconSpan.l(dimens3);
            eMRichTextAnyIconSpan.c(true);
            spannableStringBuilder2.setSpan(eMRichTextAnyIconSpan, 0, 4, 17);
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0740, (ViewGroup) null);
        this.c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091c3d);
        this.e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -m1a.o());
        this.e.setImageMatrix(matrix);
        TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092855);
        this.d = textView;
        EMManager.from(textView).setTextSize(R.dimen.T_X03).setTextLinePadding(R.dimen.M_T_X003).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02).setLinkTextColor(R.color.CAM_X0304);
        this.d.setVisibility(8);
        if (this.d.getParent() == null) {
            this.c.addView(this.d);
        }
        this.c.setOnTouchListener(this.b);
        this.c.setOnLongClickListener(new a(this));
    }

    public void i(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zv9Var) == null) && zv9Var != null && zv9Var.R() != null) {
            SpannableStringBuilder span_str = zv9Var.R().getSpan_str();
            SpannableString e = m1a.e(zv9Var.R());
            if (!StringUtils.isNull(zv9Var.R().getTitle())) {
                if (e != null) {
                    span_str.append((CharSequence) e);
                    this.d.setText(span_str, TextView.BufferType.SPANNABLE);
                } else {
                    this.d.setText(span_str);
                }
                l(zv9Var);
                this.d.setVisibility(0);
                this.d.setMaxLines(3);
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                this.d.invalidate();
                return;
            }
            this.d.setVisibility(8);
        }
    }

    public void k(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, zv9Var) == null) && zv9Var != null && zv9Var.R() != null) {
            SpannableStringBuilder span_str = zv9Var.R().getSpan_str();
            this.d.setOnTouchListener(new cab(span_str));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(span_str);
            if (zv9Var.R().isQuestionThread()) {
                spannableStringBuilder = c(span_str, true);
            } else if (zv9Var.R().isPbHeadLinesThread()) {
                spannableStringBuilder = e(span_str, R.drawable.icon_mask_label_toutiao16, true);
            } else if (zv9Var.R().isExcellentThread()) {
                spannableStringBuilder = e(span_str, R.drawable.icon_mask_excellent_pb, true);
            }
            this.d.setText(spannableStringBuilder);
            this.d.setVisibility(0);
        }
    }

    public void j(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zv9Var) == null) {
            if (zv9Var != null && !zv9Var.R().isVideoThreadType() && this.d.getText() != null && this.d.getText().length() > 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void l(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, zv9Var) != null) || this.d == null) {
            return;
        }
        int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (zv9Var.a()) {
            dimens = 0;
        }
        layoutParams.bottomMargin = dimens;
        this.d.setLayoutParams(layoutParams);
    }
}
