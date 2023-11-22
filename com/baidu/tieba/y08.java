package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SportScheduleInfo;
/* loaded from: classes9.dex */
public class y08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public TextView c;
    public TbImageView d;
    public TbImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y08 a;

        public a(y08 y08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !qd.isEmpty(this.a.k)) {
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{this.a.k}, true);
                TiebaStatic.log(new StatisticItem("c13418").param("fid", this.a.l));
            }
        }
    }

    public y08(FrsSportsRecommendFragment frsSportsRecommendFragment, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsSportsRecommendFragment, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this);
        if (frsSportsRecommendFragment != null && view2 != null) {
            this.a = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f090db5);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dbd);
            this.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090db6);
            this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dbb);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090db7);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dbc);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dba);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090db9);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090db8);
            this.d.setPageId(uniqueId);
            this.e.setPageId(uniqueId);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.b, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.c, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.b.setVisibility(8);
                this.c.setVisibility(0);
                this.c.setText(R.string.obfuscated_res_0x7f0f088d);
                return;
            }
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            this.d.startLoad(sportScheduleInfo.home_team_icon, 10, false);
            this.e.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, "...");
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, "...");
            }
            this.f.setText(str2);
            this.g.setText(str3);
            this.h.setText(sportScheduleInfo.match_top_info);
            this.i.setText(sportScheduleInfo.match_middle_info);
            this.j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.b.setOnClickListener(this.m);
        }
    }
}
