package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class oc6 extends mc6<bi6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public RelativeLayout k;
    public TbImageView l;
    public ImageView m;
    public TextView n;
    public RelativeLayout o;
    public ClickableHeaderImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public View t;
    public bi6 u;
    public String v;
    public String w;

    @Override // com.baidu.tieba.mc6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0187 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oc6(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = str;
        this.w = str2;
        r(h());
    }

    public String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
        }
        return (String) invokeL.objValue;
    }

    public void v(int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (relativeLayout = this.o) != null) {
            relativeLayout.setVisibility(i);
        }
    }

    public void w(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (view2 = this.t) != null) {
            view2.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.mc6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.t, R.color.CAM_X0204);
                l39 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && readThreadHistory.d(this.u.getThreadData().getId())) {
                    SkinManager.setViewTextColor(this.j, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
                }
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0101, 1);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2 == this.s) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 4).param("fid", this.v));
                FrsGameStrategyActivity.startActivity(this.b.getPageActivity(), this.v, this.w);
            } else if (e() != null) {
                e().a(h(), this.u);
            }
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090549);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09054c);
            this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090548);
            this.l = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090547);
            this.m = (ImageView) view2.findViewById(R.id.img_play);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09054d);
            this.o = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09054e);
            this.p = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f09054f);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090550);
            this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09054b);
            this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09054a);
            this.t = view2.findViewById(R.id.obfuscated_res_0x7f090529);
            this.l.setDefaultBgResource(R.drawable.obfuscated_res_0x7f0808d3);
            int dimensionPixelSize = ej.s(this.c)[0] - (this.c.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = (dimensionPixelSize * 9) / 21;
            this.k.setLayoutParams(layoutParams);
            this.s.setOnClickListener(this);
            this.p.setDefaultResource(17170445);
            this.p.setDefaultBgResource(R.color.CAM_X0205);
            this.p.setIsRound(true);
            this.p.setDrawBorder(true);
            this.p.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.p.setBorderWidth(this.c.getResources().getDimensionPixelSize(R.dimen.tbds1));
            h().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mc6
    /* renamed from: s */
    public void i(bi6 bi6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bi6Var) == null) && bi6Var != null && bi6Var.getThreadData() != null) {
            this.u = bi6Var;
            String str = null;
            if (bi6Var.getThreadData().isVideoThreadType()) {
                this.m.setVisibility(0);
                this.n.setVisibility(0);
                if (bi6Var.getThreadData().getThreadVideoInfo() != null) {
                    this.n.setText(StringHelper.stringForVideoTime(bi6Var.getThreadData().getThreadVideoInfo().video_duration.intValue() * 1000));
                    str = bi6Var.getThreadData().getThreadVideoInfo().thumbnail_url;
                }
            } else {
                this.m.setVisibility(8);
                this.n.setVisibility(4);
                if (bi6Var.getThreadData().getMedias() != null && bi6Var.getThreadData().getMedias().size() >= 1) {
                    str = bi6Var.getThreadData().getMedias().get(0).origin_pic;
                }
            }
            this.l.K(str, 10, false);
            this.j.setText(bi6Var.getThreadData().getTitle());
            l39 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(bi6Var.getThreadData().getId())) {
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            }
            this.p.setData(bi6Var.getThreadData(), false);
            x(bi6Var.getThreadData());
            this.r.setText(StringHelper.getFormatTimeShort(bi6Var.getThreadData().getAuditTime()));
            if ("guide".equals(bi6Var.getThreadData().getGameInformationSource())) {
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
        }
    }

    public void u(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) && (linearLayout = this.i) != null) {
            linearLayout.setPadding(i, i2, i3, i4);
        }
    }

    public final void x(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) && this.q != null && threadData != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
            this.q.setText(t(threadData.getAuthor().getName_show()));
        }
    }
}
