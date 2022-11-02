package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.iv4;
import com.baidu.tieba.ns6;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class jv6 implements nn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public NoPressedRelativeLayout b;
    public rv6 c;
    public tv8 d;
    public ns6 e;
    public j39 f;
    public OvalActionButton g;
    public k39 h;
    public ns6.d i;
    public final View.OnClickListener j;
    public final rg<hn> k;

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements ns6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv6 a;

        @Override // com.baidu.tieba.ns6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.ns6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        public a(jv6 jv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jv6Var;
        }

        @Override // com.baidu.tieba.ns6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (z && i == 502) {
                    this.a.B(1);
                } else if (z) {
                    this.a.B(0);
                } else if (i != 502) {
                    this.a.B(-1);
                } else {
                    this.a.n();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv6 a;

        public b(jv6 jv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jv6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getPageContext().getPageActivity(), LoginDialogData.FRS_PUBLISH_RESULT_PAGE)) || this.a.d.c() || this.a.k() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (this.a.c != null) {
                this.a.c.i();
            }
            if (this.a.a.E3().K(502) == null || this.a.a.E3().C() == null) {
                this.a.B(-1);
            } else {
                this.a.e.h(this.a.a.k(), this.a.a.E3().C().a);
            }
            this.a.j();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends rg<hn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv6 a;

        public c(jv6 jv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(hn hnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, hnVar, str, i) == null) {
                super.onLoaded((c) hnVar, str, i);
                if (hnVar != null && hnVar.w()) {
                    this.a.g.setImageDrawable(null);
                    hnVar.h(this.a.g);
                    return;
                }
                this.a.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(jv6 jv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, iv4Var) != null) || iv4Var == null) {
                return;
            }
            iv4Var.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfoData a;
        public final /* synthetic */ jv6 b;

        public e(jv6 jv6Var, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv6Var, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jv6Var;
            this.a = blockPopInfoData;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{this.a.ahead_url});
                if (iv4Var == null) {
                    return;
                }
                iv4Var.dismiss();
            }
        }
    }

    public jv6(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, noPressedRelativeLayout};
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
        this.j = new b(this);
        this.k = new c(this);
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.a = frsFragment;
            this.b = noPressedRelativeLayout;
            this.d = new tv8(frsFragment.getPageContext());
            ns6 ns6Var = new ns6(frsFragment.getPageContext());
            this.e = ns6Var;
            ns6Var.i(this.i);
            this.f = new j39(this.a.getPageContext().getPageActivity(), "frs", 2, "2");
            u(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            sg.h().m(str, 10, this.k, this.a.getUniqueId());
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            k39 k39Var = this.h;
            if (k39Var != null) {
                k39Var.d(i);
            }
            j39 j39Var = this.f;
            if (j39Var != null) {
                j39Var.i(i);
            }
            tv8 tv8Var = this.d;
            if (tv8Var != null) {
                tv8Var.f();
            }
        }
    }

    public void x(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, ovalActionButton) != null) || ovalActionButton == null) {
            return;
        }
        this.g = ovalActionButton;
        ovalActionButton.setOnClickListener(this.j);
        if (!l()) {
            w();
        }
    }

    public void A(boolean z) {
        int i;
        FrsViewData O0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.g != null) {
            l();
            OvalActionButton ovalActionButton = this.g;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            ovalActionButton.setVisibility(i);
            if (z && TbadkCoreApplication.isLogin() && (O0 = this.a.O0()) != null && O0.postTopic != null && O0.getForum() != null && !StringUtils.isNull(O0.getForum().getId()) && !StringUtils.isNull(O0.postTopic.recom_title) && !StringUtils.isNull(O0.postTopic.recom_topic) && yi6.d().c(O0.getForum().getId(), O0.postTopic.uniq_topicid.longValue())) {
                z(this.g, O0);
            }
        }
    }

    public final void B(int i) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (frsFragment = this.a) != null) {
            ForumWriteData n3 = frsFragment.n3();
            ItemInfo itemInfo = null;
            if (this.a.O0() != null) {
                itemInfo = this.a.O0().itemInfo;
            }
            if (this.f == null) {
                this.f = new j39(this.a.getPageContext().getPageActivity(), "frs", 2, "2");
            }
            this.f.j(n3);
            this.f.l(m());
            this.f.k(itemInfo);
            this.f.m();
        }
    }

    public void C() {
        OvalActionButton ovalActionButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ovalActionButton = this.g) != null) {
            ovalActionButton.performClick();
        }
    }

    @Override // com.baidu.tieba.nn6
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d.c() || k()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String m() {
        InterceptResult invokeV;
        FrsViewData O0;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (O0 = frsFragment.O0()) == null || (activityConfig = O0.activityConfig) == null) {
                return "";
            }
            return activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            k39 k39Var = this.h;
            if (k39Var == null) {
                return false;
            }
            return k39Var.b();
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            k39 k39Var = this.h;
            if (k39Var == null) {
                return false;
            }
            return k39Var.b();
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            k39 k39Var = this.h;
            if (k39Var != null) {
                k39Var.e();
            }
            rv6 rv6Var = this.c;
            if (rv6Var != null) {
                rv6Var.i();
            }
        }
    }

    public void s() {
        rv6 rv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (rv6Var = this.c) != null) {
            rv6Var.i();
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            k39 k39Var = this.h;
            if (k39Var != null && k39Var.b()) {
                this.h.a(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.g.setImageResource(0);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13604");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                ud5.b(frsFragment.getContext(), statisticItem);
                ws6.b(statisticItem, this.a.k(), this.a.c());
            }
            ws6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        FrsViewData O0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (O0 = frsFragment.O0()) == null) {
                return false;
            }
            if (!ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                return true;
            }
            AntiData anti = O0.getAnti();
            if (anti == null || !y(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        FrsViewData O0;
        ActivityConfig activityConfig;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && (O0 = frsFragment.O0()) != null && (activityConfig = O0.activityConfig) != null && activityConfig.type.intValue() == 2) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
                    q(activityConfig.night_addthread_icon);
                    return true;
                } else if (!TextUtils.isEmpty(activityConfig.addthread_icon)) {
                    q(activityConfig.addthread_icon);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        FrsFragment frsFragment;
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (frsFragment = this.a) == null || frsFragment.O0() == null || (forum = this.a.O0().getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ThemeElement themeElement = themeColorInfo.day;
            if (themeElement != null) {
                str9 = themeElement.light_color;
                str10 = themeElement.dark_color;
                if (skinType == 0) {
                    str8 = themeElement.pattern_image;
                } else {
                    str8 = null;
                }
            } else {
                str8 = null;
                str9 = null;
                str10 = null;
            }
            ThemeElement themeElement2 = themeColorInfo.night;
            if (themeElement2 != null) {
                str11 = themeElement2.light_color;
                str12 = themeElement2.dark_color;
                if (skinType == 1) {
                    str8 = themeElement2.pattern_image;
                }
            } else {
                str11 = null;
                str12 = null;
            }
            ThemeElement themeElement3 = themeColorInfo.dark;
            if (themeElement3 != null) {
                String str13 = themeElement3.light_color;
                String str14 = themeElement3.dark_color;
                if (skinType == 4) {
                    str = themeElement3.pattern_image;
                    str6 = str13;
                } else {
                    str6 = str13;
                    str = str8;
                }
                str2 = str9;
                str3 = str10;
                str7 = str14;
            } else {
                str6 = null;
                str7 = null;
                str = str8;
                str2 = str9;
                str3 = str10;
            }
            str4 = str11;
            str5 = str12;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.a.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public final boolean y(int i, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeIL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i, blockPopInfoData)) == null) {
            if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            if (StringUtils.isNull(blockPopInfoData.block_info)) {
                str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06fe);
            } else {
                str = blockPopInfoData.block_info;
            }
            if (i != 1 && i != 2) {
                return false;
            }
            iv4 iv4Var = new iv4(this.a.getPageContext().getPageActivity());
            iv4Var.setMessage(StringHelper.getFixedText(str, 50, true));
            if (StringUtils.isNull(blockPopInfoData.ok_info)) {
                str2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0823);
            } else {
                str2 = blockPopInfoData.ok_info;
            }
            iv4Var.setNegativeButton(StringHelper.getFixedText(str2, 4, true), new d(this));
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                iv4Var.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new e(this, blockPopInfoData));
            }
            iv4Var.create(this.a.getPageContext()).show();
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void z(View view2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, view2, frsViewData) == null) && this.a != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.c == null) {
                this.c = new rv6(this.a.getActivity(), this);
            }
            this.c.i();
            this.c.j(view2, frsViewData);
        }
    }
}
