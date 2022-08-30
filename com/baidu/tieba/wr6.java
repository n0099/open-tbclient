package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tieba.fe5;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.wr4;
import com.baidu.tieba.yo6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes6.dex */
public class wr6 implements fk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public NoPressedRelativeLayout b;
    public es6 c;
    public xr8 d;
    public yo6 e;
    public nz8 f;
    public OvalActionButton g;
    public oz8 h;
    public yo6.d i;
    public final View.OnClickListener j;
    public final kg<an> k;

    /* loaded from: classes6.dex */
    public class a implements yo6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr6 a;

        public a(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr6Var;
        }

        @Override // com.baidu.tieba.yo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (z && i == 502) {
                    this.a.C(1);
                } else if (z) {
                    this.a.C(0);
                } else if (i != 502) {
                    this.a.C(-1);
                } else {
                    this.a.o();
                }
            }
        }

        @Override // com.baidu.tieba.yo6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.yo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr6 a;

        public b(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getPageContext().getPageActivity(), LoginDialogData.FRS_PUBLISH_RESULT_PAGE)) || this.a.d.c() || this.a.l() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (this.a.c != null) {
                this.a.c.i();
            }
            if (this.a.a.F3().K(502) == null || this.a.a.F3().C() == null) {
                this.a.C(-1);
            } else {
                this.a.e.h(this.a.a.d(), this.a.a.F3().C().a);
            }
            this.a.k();
        }
    }

    /* loaded from: classes6.dex */
    public class c extends kg<an> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr6 a;

        public c(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg
        public void onLoaded(an anVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, anVar, str, i) == null) {
                super.onLoaded((c) anVar, str, i);
                if (anVar == null || !anVar.w()) {
                    this.a.x();
                    return;
                }
                this.a.g.setImageDrawable(null);
                anVar.h(this.a.g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) || wr4Var == null) {
                return;
            }
            wr4Var.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfoData a;
        public final /* synthetic */ wr6 b;

        public e(wr6 wr6Var, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wr6Var;
            this.a = blockPopInfoData;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{this.a.ahead_url});
                if (wr4Var == null) {
                    return;
                }
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements fe5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.fe5.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !UbsABTestHelper.isHomeTabModifyABTestA() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fe5 a;
        public final /* synthetic */ wr6 b;

        public g(wr6 wr6Var, fe5 fe5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var, fe5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wr6Var;
            this.a = fe5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n(false);
                this.b.j.onClick(view2);
            }
        }
    }

    public wr6(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
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
        if (frsFragment == null || noPressedRelativeLayout == null) {
            return;
        }
        this.a = frsFragment;
        this.b = noPressedRelativeLayout;
        this.d = new xr8(frsFragment.getPageContext());
        yo6 yo6Var = new yo6(frsFragment.getPageContext());
        this.e = yo6Var;
        yo6Var.i(this.i);
        this.f = new nz8(this.a.getPageContext().getPageActivity(), "frs", 2, "2");
        v(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(View view2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, frsViewData) == null) || this.a == null || frsViewData == null || frsViewData.getForum() == null || frsViewData.postTopic == null) {
            return;
        }
        if (this.c == null) {
            this.c = new es6(this.a.getActivity(), this);
        }
        this.c.i();
        this.c.j(view2, frsViewData);
    }

    public void B(boolean z) {
        FrsViewData P0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.g == null) {
            return;
        }
        m();
        this.g.setVisibility(z ? 0 : 8);
        if (!z || !TbadkCoreApplication.isLogin() || (P0 = this.a.P0()) == null || P0.postTopic == null || P0.getForum() == null || StringUtils.isNull(P0.getForum().getId()) || StringUtils.isNull(P0.postTopic.recom_title) || StringUtils.isNull(P0.postTopic.recom_topic) || !gf6.d().c(P0.getForum().getId(), P0.postTopic.uniq_topicid.longValue())) {
            return;
        }
        A(this.g, P0);
    }

    public final void C(int i) {
        FrsViewData P0;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (UbsABTestHelper.isMainTabShowA() && (frsFragment = this.a) != null) {
                ForumWriteData o3 = frsFragment.o3();
                ItemInfo itemInfo = this.a.P0() != null ? this.a.P0().itemInfo : null;
                if (this.f == null) {
                    this.f = new nz8(this.a.getPageContext().getPageActivity(), "frs", 2, "2");
                }
                this.f.j(o3);
                this.f.l(n());
                this.f.k(itemInfo);
                this.f.m();
                return;
            }
            if (this.h == null) {
                FrsFragment frsFragment2 = this.a;
                oz8 oz8Var = new oz8(this.a.getPageContext(), this.b, "frs", (frsFragment2 == null || (P0 = frsFragment2.P0()) == null) ? null : P0.getVoiceRoomConfig());
                this.h = oz8Var;
                oz8Var.E("2");
                ItemInfo itemInfo2 = this.a.P0().itemInfo;
                this.h.D((itemInfo2 == null || itemInfo2.id.intValue() <= 0 || qi.isEmpty(itemInfo2.name)) ? false : true);
            }
            this.h.G(n());
            if (this.a.P0().getAnti() != null) {
                this.h.A(this.a.P0().getAnti().getCanGoods());
            }
            ForumWriteData o32 = this.a.o3();
            o32.setDefaultZone(i);
            this.h.B(o32);
            this.h.C(this.a.P0().itemInfo);
            this.h.F(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
            FrsFragment frsFragment3 = this.a;
            if (frsFragment3 != null && frsFragment3.P0() != null) {
                this.h.C(this.a.P0().itemInfo);
            }
            this.h.I(false, null, this.g);
            this.a.J3().setAlpha(0);
            FrsFragment frsFragment4 = this.a;
            if (frsFragment4 == null || frsFragment4.P0() == null || this.a.P0().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.a.d()).param("fname", this.a.c()).param("obj_param1", this.a.P0().itemInfo.name));
        }
    }

    public void D() {
        OvalActionButton ovalActionButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (ovalActionButton = this.g) == null) {
            return;
        }
        ovalActionButton.performClick();
    }

    @Override // com.baidu.tieba.fk6
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.d.c() || l()) ? false : true : invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13604");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                aa5.b(frsFragment.getContext(), statisticItem);
                lp6.b(statisticItem, this.a.d(), this.a.c());
            }
            lp6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        FrsViewData P0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (P0 = frsFragment.P0()) == null) {
                return false;
            }
            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                AntiData anti = P0.getAnti();
                return anti != null && z(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        FrsViewData P0;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && (P0 = frsFragment.P0()) != null && (activityConfig = P0.activityConfig) != null && activityConfig.type.intValue() == 2) {
                if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
                    r(activityConfig.night_addthread_icon);
                    return true;
                } else if (!TextUtils.isEmpty(activityConfig.addthread_icon)) {
                    r(activityConfig.addthread_icon);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String n() {
        InterceptResult invokeV;
        FrsViewData P0;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            FrsFragment frsFragment = this.a;
            return (frsFragment == null || (P0 = frsFragment.P0()) == null || (activityConfig = P0.activityConfig) == null) ? "" : activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
    }

    public final void o() {
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (frsFragment = this.a) == null || frsFragment.P0() == null || (forum = this.a.P0().getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ThemeElement themeElement = themeColorInfo.day;
            if (themeElement != null) {
                str9 = themeElement.light_color;
                str10 = themeElement.dark_color;
                str8 = skinType == 0 ? themeElement.pattern_image : null;
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

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            oz8 oz8Var = this.h;
            if (oz8Var == null) {
                return false;
            }
            return oz8Var.n();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            oz8 oz8Var = this.h;
            if (oz8Var == null) {
                return false;
            }
            return oz8Var.n();
        }
        return invokeV.booleanValue;
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            lg.h().m(str, 10, this.k, this.a.getUniqueId());
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            oz8 oz8Var = this.h;
            if (oz8Var != null) {
                oz8Var.u();
            }
            es6 es6Var = this.c;
            if (es6Var != null) {
                es6Var.i();
            }
        }
    }

    public void t() {
        es6 es6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (es6Var = this.c) == null) {
            return;
        }
        es6Var.i();
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            oz8 oz8Var = this.h;
            if (oz8Var != null) {
                oz8Var.s(i);
            }
            nz8 nz8Var = this.f;
            if (nz8Var != null) {
                nz8Var.i(i);
            }
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            oz8 oz8Var = this.h;
            if (oz8Var == null || !oz8Var.n()) {
                return false;
            }
            this.h.m(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.g.setImageResource(0);
        }
    }

    public void y(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, ovalActionButton) == null) || ovalActionButton == null) {
            return;
        }
        this.g = ovalActionButton;
        fe5 c2 = fe5.c(ovalActionButton.getContext());
        c2.h(BadgeDrawable.TOP_END);
        c2.g(-65536);
        c2.m(R.dimen.tbds39, false);
        c2.k(R.dimen.tbds39, false);
        c2.i(R.dimen.tbds12);
        c2.j(new f(this));
        c2.l("FrsGLWriteViewController.sendHelp");
        c2.b(ovalActionButton);
        this.g.setOnClickListener(new g(this, c2));
        if (m()) {
            return;
        }
        x();
    }

    public final boolean z(int i, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i, blockPopInfoData)) == null) {
            if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06dc) : blockPopInfoData.block_info;
            if (i == 1 || i == 2) {
                wr4 wr4Var = new wr4(this.a.getPageContext().getPageActivity());
                wr4Var.setMessage(StringHelper.getFixedText(string, 50, true));
                wr4Var.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07fd) : blockPopInfoData.ok_info, 4, true), new d(this));
                if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                    wr4Var.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new e(this, blockPopInfoData));
                }
                wr4Var.create(this.a.getPageContext()).show();
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }
}
