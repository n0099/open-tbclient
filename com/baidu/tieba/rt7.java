package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class rt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public TbImageView b;
    public LinearGradientView c;
    public BarImageView d;
    public TextView e;
    public FrsViewData f;
    public boolean g;
    public String h;
    public boolean i;
    public final View.OnClickListener j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt7 a;

        public a(rt7 rt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.b) {
                    if (!ei.isEmpty(this.a.h) && this.a.f != null && this.a.f.getForum() != null) {
                        int i = 1;
                        UrlManager.getInstance().dealOneLink(this.a.a, new String[]{this.a.h}, true);
                        StatisticItem param = new StatisticItem("c13415").param("fid", this.a.f.getForum().getId());
                        if (this.a.i) {
                            i = 2;
                        }
                        TiebaStatic.log(param.param("obj_type", i));
                    }
                } else if ((view2 == this.a.d || view2 == this.a.e) && this.a.f != null && this.a.f.getForum() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.a.a.getPageActivity(), this.a.f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.a.f.getForum().getId()));
                }
            }
        }
    }

    public rt7(FrsSportsRecommendFragment frsSportsRecommendFragment, View view2) {
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
        this.j = new a(this);
        if (frsSportsRecommendFragment != null && view2 != null) {
            this.a = frsSportsRecommendFragment.getPageContext();
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f0f);
            this.c = (LinearGradientView) view2.findViewById(R.id.obfuscated_res_0x7f090f11);
            this.d = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090cdc);
            this.e = (TextView) view2.findViewById(R.id.forum_name);
            this.b.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.d.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0322));
            this.d.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.d.setShowOval(true);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            BarImageView barImageView = this.d;
            if (barImageView != null) {
                barImageView.setBorderWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
                this.d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                this.d.setStrokeColorResId(R.color.CAM_X0201);
                this.d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (frsViewData = this.f) != null && (forum = frsViewData.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.g) {
                LinearGradientView linearGradientView = this.c;
                if (linearGradientView != null) {
                    ThemeElement themeElement2 = themeColorInfo.day;
                    String str = themeElement2.light_color;
                    String str2 = themeElement2.dark_color;
                    ThemeElement themeElement3 = themeColorInfo.night;
                    String str3 = themeElement3.light_color;
                    String str4 = themeElement3.dark_color;
                    ThemeElement themeElement4 = themeColorInfo.dark;
                    linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
                    this.c.a(skinType);
                }
                TbImageView tbImageView = this.b;
                if (tbImageView != null) {
                    tbImageView.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) && frsViewData != null && frsViewData.getForum() != null) {
            this.f = frsViewData;
            this.g = false;
            String name = frsViewData.getForum().getName();
            if (StringHelper.getChineseAndEnglishLength(name) > 20) {
                name = StringHelper.cutForumNameWithSuffix(name, 20, "...");
            }
            this.e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0879), name));
            this.d.startLoad(this.f.getForum().getImage_url(), 10, false);
            i();
            this.d.setOnClickListener(this.j);
            this.e.setOnClickListener(this.j);
        }
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.d.refresh();
            if (ei.isEmpty(str)) {
                this.g = false;
                i();
                return;
            }
            this.g = true;
            this.h = str2;
            this.i = z;
            this.b.startLoad(str, 10, false);
            this.b.setOnClickListener(this.j);
        }
    }
}
