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
/* loaded from: classes6.dex */
public class kn6 extends in6<hv6> {
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
    public hv6 u;
    public String v;
    public String w;

    @Override // com.baidu.tieba.in6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01a8 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kn6(TbPageContext<?> tbPageContext, String str, String str2) {
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
            return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, "...");
        }
        return (String) invokeL.objValue;
    }

    public void x(int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (relativeLayout = this.o) != null) {
            relativeLayout.setVisibility(i);
        }
    }

    public void y(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (view2 = this.t) != null) {
            view2.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.in6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.t, R.color.CAM_X0204);
                lz9 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
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
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905c0);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905c3);
            this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905bf);
            this.l = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905be);
            this.m = (ImageView) view2.findViewById(R.id.img_play);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905c4);
            this.o = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905c5);
            this.p = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905c6);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905c7);
            this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905c2);
            this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905c1);
            this.t = view2.findViewById(R.id.obfuscated_res_0x7f0905a0);
            this.l.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080a54);
            int dimensionPixelSize = vi.s(this.c)[0] - (this.c.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
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
    @Override // com.baidu.tieba.in6
    /* renamed from: s */
    public void i(hv6 hv6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, hv6Var) == null) && hv6Var != null && hv6Var.getThreadData() != null) {
            this.u = hv6Var;
            String str = null;
            if (hv6Var.getThreadData().isVideoThreadType()) {
                this.m.setVisibility(0);
                this.n.setVisibility(0);
                if (hv6Var.getThreadData().getThreadVideoInfo() != null) {
                    this.n.setText(StringHelper.stringForVideoTime(hv6Var.getThreadData().getThreadVideoInfo().video_duration.intValue() * 1000));
                    str = hv6Var.getThreadData().getThreadVideoInfo().thumbnail_url;
                }
            } else {
                this.m.setVisibility(8);
                this.n.setVisibility(4);
                if (hv6Var.getThreadData().getMedias() != null && hv6Var.getThreadData().getMedias().size() >= 1) {
                    str = hv6Var.getThreadData().getMedias().get(0).origin_pic;
                }
            }
            this.l.N(str, 10, false);
            this.j.setText(hv6Var.getThreadData().getTitle());
            lz9 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(hv6Var.getThreadData().getId())) {
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            }
            this.p.setData(hv6Var.getThreadData(), false);
            z(hv6Var.getThreadData());
            this.r.setText(StringHelper.getFormatTimeShort(hv6Var.getThreadData().getAuditTime()));
            if ("guide".equals(hv6Var.getThreadData().getGameInformationSource())) {
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

    public final void z(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) && this.q != null && threadData != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
            this.q.setText(t(threadData.getAuthor().getName_show()));
        }
    }
}
