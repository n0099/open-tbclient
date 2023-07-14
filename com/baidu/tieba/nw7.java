package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
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
import com.baidu.tieba.p55;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
/* loaded from: classes7.dex */
public class nw7 implements vm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public NoPressedRelativeLayout b;
    public vw7 c;
    public lka d;
    public nta e;
    public OvalActionButton f;
    public ota g;
    public final View.OnClickListener h;
    public final rg<jn> i;

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nw7 a;

        public a(nw7 nw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getPageContext().getPageActivity(), LoginDialogData.FRS_PUBLISH_RESULT_PAGE)) || this.a.d.c() || this.a.i() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (this.a.c != null) {
                this.a.c.i();
            }
            this.a.y();
            this.a.h();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nw7 a;

        public b(nw7 nw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) {
                super.onLoaded((b) jnVar, str, i);
                if (jnVar == null || !jnVar.w()) {
                    this.a.t();
                    return;
                }
                this.a.f.setImageDrawable(null);
                jnVar.h(this.a.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(nw7 nw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, p55Var) != null) || p55Var == null) {
                return;
            }
            p55Var.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfoData a;
        public final /* synthetic */ nw7 b;

        public d(nw7 nw7Var, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw7Var, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nw7Var;
            this.a = blockPopInfoData;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{this.a.ahead_url});
                if (p55Var == null) {
                    return;
                }
                p55Var.dismiss();
            }
        }
    }

    public nw7(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
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
        this.h = new a(this);
        this.i = new b(this);
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.a = frsFragment;
            this.b = noPressedRelativeLayout;
            this.d = new lka(frsFragment.getPageContext());
            this.e = new nta(this.a.getPageContext().getPageActivity(), "frs", 2, "2");
            r(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            sg.h().m(str, 10, this.i, this.a.getUniqueId());
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            ota otaVar = this.g;
            if (otaVar != null) {
                otaVar.d(i);
            }
            nta ntaVar = this.e;
            if (ntaVar != null) {
                ntaVar.i(i);
            }
            lka lkaVar = this.d;
            if (lkaVar != null) {
                lkaVar.f();
            }
        }
    }

    public void u(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, ovalActionButton) != null) || ovalActionButton == null) {
            return;
        }
        this.f = ovalActionButton;
        ovalActionButton.setOnClickListener(this.h);
        if (!j()) {
            t();
        }
    }

    @Override // com.baidu.tieba.vm7
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d.c() || i()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String k() {
        InterceptResult invokeV;
        FrsViewData c1;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (c1 = frsFragment.c1()) == null || (activityConfig = c1.activityConfig) == null) {
                return "";
            }
            return activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ota otaVar = this.g;
            if (otaVar == null) {
                return false;
            }
            return otaVar.b();
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ota otaVar = this.g;
            if (otaVar == null) {
                return false;
            }
            return otaVar.b();
        }
        return invokeV.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ota otaVar = this.g;
            if (otaVar != null) {
                otaVar.e();
            }
            vw7 vw7Var = this.c;
            if (vw7Var != null) {
                vw7Var.i();
            }
        }
    }

    public void p() {
        vw7 vw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (vw7Var = this.c) != null) {
            vw7Var.i();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ota otaVar = this.g;
            if (otaVar != null && otaVar.b()) {
                this.g.a(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f.setImageResource(0);
        }
    }

    public void z() {
        OvalActionButton ovalActionButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (ovalActionButton = this.f) != null) {
            ovalActionButton.performClick();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13604");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                ft5.b(frsFragment.getContext(), statisticItem);
                os7.b(statisticItem, this.a.w(), this.a.v());
            }
            os7.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        FrsViewData c1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (c1 = frsFragment.c1()) == null) {
                return false;
            }
            if (!ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                return true;
            }
            AntiData anti = c1.getAnti();
            if (anti == null || !v(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        FrsViewData c1;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (c1 = frsFragment.c1()) == null || (activityConfig = c1.activityConfig) == null || activityConfig.type.intValue() != 2 || TextUtils.isEmpty(activityConfig.addthread_icon)) {
                return false;
            }
            n(activityConfig.addthread_icon);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean v(int i, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeIL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i, blockPopInfoData)) == null) {
            if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            if (StringUtils.isNull(blockPopInfoData.block_info)) {
                str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07fb);
            } else {
                str = blockPopInfoData.block_info;
            }
            if (i != 1 && i != 2) {
                return false;
            }
            p55 p55Var = new p55(this.a.getPageContext().getPageActivity());
            p55Var.setMessage(StringHelper.getFixedText(str, 50, true));
            if (StringUtils.isNull(blockPopInfoData.ok_info)) {
                str2 = this.a.getResources().getString(R.string.group_create_private_isee);
            } else {
                str2 = blockPopInfoData.ok_info;
            }
            p55Var.setNegativeButton(StringHelper.getFixedText(str2, 4, true), new c(this));
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                p55Var.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new d(this, blockPopInfoData));
            }
            p55Var.create(this.a.getPageContext()).show();
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void w(View view2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, view2, frsViewData) == null) && this.a != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.c == null) {
                this.c = new vw7(this.a.getActivity(), this);
            }
            this.c.i();
            this.c.j(view2, frsViewData);
        }
    }

    public void x(boolean z) {
        int i;
        FrsViewData c1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && this.f != null) {
            j();
            OvalActionButton ovalActionButton = this.f;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            ovalActionButton.setVisibility(i);
            if (z && TbadkCoreApplication.isLogin() && (c1 = this.a.c1()) != null && c1.postTopic != null && c1.getForum() != null && !StringUtils.isNull(c1.getForum().getId()) && !StringUtils.isNull(c1.postTopic.recom_title) && !StringUtils.isNull(c1.postTopic.recom_topic) && ci7.d().c(c1.getForum().getId(), c1.postTopic.uniq_topicid.longValue())) {
                w(this.f, c1);
            }
        }
    }

    public final void y() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (frsFragment = this.a) != null) {
            ForumWriteData E3 = frsFragment.E3();
            ItemInfo itemInfo = null;
            if (this.a.c1() != null) {
                itemInfo = this.a.c1().itemInfo;
            }
            if (this.e == null) {
                this.e = new nta(this.a.getPageContext().getPageActivity(), "frs", 2, "2");
            }
            this.e.j(E3);
            this.e.l(k());
            this.e.k(itemInfo);
            this.e.m();
        }
    }
}
