package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public HeadImageView c;
    public TextView d;
    public TextView e;
    public LinearLayout f;
    public zb6 g;
    public na6 h;
    public View.OnClickListener i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xb6 a;

        public a(xb6 xb6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xb6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xb6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    vi.N(this.a.a.getPageActivity(), this.a.a.getPageActivity().getString(R.string.no_network_guide));
                } else if (this.a.h != null && this.a.h.d != null && view2 == this.a.b && this.a.g != null) {
                    this.a.g.a(this.a.h);
                }
            }
        }
    }

    public xb6(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0914, (ViewGroup) null);
        this.b = inflate;
        this.f = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09229f);
        this.c = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0911b9);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092604);
        this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092662);
        this.b.setOnClickListener(this.i);
        this.c.setBorderWidth(vi.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.c.setIsRound(true);
        this.c.setPlaceHolder(1);
        this.c.setAutoChangeStyle(true);
        this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f.setLayoutParams(new LinearLayout.LayoutParams((vi.l(this.a.getPageActivity()) - (this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void h(zb6 zb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zb6Var) == null) {
            this.g = zb6Var;
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void f(na6 na6Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, na6Var) == null) {
            if (na6Var != null && (threadData = na6Var.d) != null && threadData.getAuthor() != null) {
                e().setVisibility(0);
                this.h = na6Var;
                na6Var.d.getAuthor().getUserId();
                this.c.O(na6Var.d.getAuthor().getPortrait(), 25, false, false);
                String name_show = na6Var.d.getAuthor().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (ui.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, "...");
                    }
                    this.d.setText(name_show);
                }
                if (na6Var.d.getThreadAlaInfo() != null) {
                    this.e.setText(String.format(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0baa), StringHelper.numberUniformFormatExtraWithRound(na6Var.d.getThreadAlaInfo().audience_count)));
                }
                g(this.a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            e().setVisibility(4);
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            this.c.setBorderColor(this.a.getResources().getColor(R.color.CAM_X0903));
            Drawable drawable = SkinManager.getDrawable(this.a.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.e.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }
}
