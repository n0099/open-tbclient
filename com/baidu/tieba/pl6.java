package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes7.dex */
public class pl6 extends nl6<nu6> {
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
    public nu6 u;
    public String v;
    public String w;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d01bb : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pl6(TbPageContext<?> tbPageContext, String str, String str2) {
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
        p(i());
    }

    public void A(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (view2 = this.t) != null) {
            view2.setVisibility(i);
        }
    }

    public String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, "...");
        }
        return (String) invokeL.objValue;
    }

    public void z(int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (relativeLayout = this.o) != null) {
            relativeLayout.setVisibility(i);
        }
    }

    public final void B(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && this.q != null && threadData != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
            this.q.setText(s(threadData.getAuthor().getName_show()));
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(i(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.t, R.color.CAM_X0204);
                rxa readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
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
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 == this.s) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 4).param("fid", this.v));
                FrsGameStrategyActivity.l1(this.b.getPageActivity(), this.v, this.w);
            } else if (f() != null) {
                f().a(i(), this.u);
            }
        }
    }

    public final void p(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09061b);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09061e);
            this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09061a);
            this.l = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090619);
            this.m = (ImageView) view2.findViewById(R.id.img_play);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09061f);
            this.o = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090620);
            this.p = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f090621);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090622);
            this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09061d);
            this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09061c);
            this.t = view2.findViewById(R.id.obfuscated_res_0x7f0905fb);
            this.l.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080a8f);
            int dimensionPixelSize = BdUtilHelper.getScreenDimensions(this.c)[0] - (this.c.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
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
            i().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: r */
    public void j(nu6 nu6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, nu6Var) == null) && nu6Var != null && nu6Var.getThreadData() != null) {
            this.u = nu6Var;
            String str = null;
            if (nu6Var.getThreadData().isVideoThreadType()) {
                this.m.setVisibility(0);
                this.n.setVisibility(0);
                if (nu6Var.getThreadData().getThreadVideoInfo() != null) {
                    this.n.setText(StringHelper.stringForVideoTime(nu6Var.getThreadData().getThreadVideoInfo().video_duration.intValue() * 1000));
                    str = nu6Var.getThreadData().getThreadVideoInfo().thumbnail_url;
                }
            } else {
                this.m.setVisibility(8);
                this.n.setVisibility(4);
                if (nu6Var.getThreadData().getMedias() != null && nu6Var.getThreadData().getMedias().size() >= 1) {
                    str = nu6Var.getThreadData().getMedias().get(0).origin_pic;
                }
            }
            this.l.startLoad(str, 10, false);
            this.j.setText(nu6Var.getThreadData().getTitle());
            rxa readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(nu6Var.getThreadData().getId())) {
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            }
            this.p.setData(nu6Var.getThreadData(), false);
            B(nu6Var.getThreadData());
            this.r.setText(StringHelper.getFormatTimeShort(nu6Var.getThreadData().getAuditTime()));
            if ("guide".equals(nu6Var.getThreadData().getGameInformationSource())) {
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
        }
    }

    public void y(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) && (linearLayout = this.i) != null) {
            linearLayout.setPadding(i, i2, i3, i4);
        }
    }
}
