package com.baidu.tieba;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class tn7 extends j9<ForumRulesShowActivity> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity a;
    public int b;
    public String c;
    public ViewGroup d;
    public NavigationBar e;
    public View f;
    public ImageView g;
    public View h;
    public ImageView i;
    public en7 j;
    public pn7 k;
    public on7 l;
    public BdTypeRecyclerView m;
    public List<yn> n;
    public View o;
    public do5 p;
    public int q;
    public int r;
    public ln7 s;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ tn7 b;

        public a(tn7 tn7Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn7Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tn7Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                oi.a(this.a.x);
                yi.R(this.b.a, this.b.a.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tn7(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.n = new ArrayList();
        this.q = 0;
        this.r = 0;
        this.a = forumRulesShowActivity;
        this.c = str;
        forumRulesShowActivity.setContentView(R.layout.obfuscated_res_0x7f0d0039);
        this.k = new pn7(forumRulesShowActivity);
        this.l = new on7(forumRulesShowActivity);
        this.q = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070420);
        this.r = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        M(forumRulesShowActivity);
    }

    public void B(List<mn7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.n.addAll(list);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            T(str);
        }
    }

    public void P(do5 do5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, do5Var) == null) {
            this.p = do5Var;
            do5Var.c().setOnClickListener(this);
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && this.k != null && !StringUtils.isNull(str)) {
            this.k.a(this.m);
            this.k.e(str);
        }
    }

    public void U(String str) {
        on7 on7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && (on7Var = this.l) != null) {
            on7Var.a(this.m);
            this.l.e(str);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.c = str;
            en7 en7Var = this.j;
            if (en7Var != null) {
                en7Var.d(str);
            }
        }
    }

    public void y(ln7 ln7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ln7Var) == null) {
            this.s = ln7Var;
            this.n.add(ln7Var);
        }
    }

    public void z(kn7 kn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, kn7Var) == null) {
            this.n.add(kn7Var);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = null;
        }
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public ViewGroup F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void G() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (bdTypeRecyclerView = this.m) != null) {
            bdTypeRecyclerView.setVisibility(8);
        }
    }

    public void H() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (view2 = this.o) != null) {
            view2.setVisibility(8);
        }
    }

    public void I() {
        pn7 pn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (pn7Var = this.k) != null) {
            pn7Var.d(this.m);
        }
    }

    public void J() {
        on7 on7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (on7Var = this.l) != null) {
            on7Var.d(this.m);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            J();
            I();
        }
    }

    public void O() {
        en7 en7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (en7Var = this.j) != null) {
            en7Var.c(this.n);
        }
    }

    public void R() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (bdTypeRecyclerView = this.m) != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
    }

    public void S() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (view2 = this.o) != null) {
            view2.setVisibility(0);
        }
    }

    public final void L(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, navigationBar) == null) {
            View addSystemImageButton = this.e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.f = addSystemImageButton;
            this.g = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            this.e.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07ce));
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
            this.h = addCustomView;
            this.i = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int i = this.q;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.rightMargin = this.r;
            this.h.setLayoutParams(layoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            Q();
        }
    }

    public final void M(ForumRulesShowActivity forumRulesShowActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, forumRulesShowActivity) == null) {
            this.d = (ViewGroup) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090bf1);
            NavigationBar navigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f0918d0);
            this.e = navigationBar;
            L(navigationBar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090bfe);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
            this.j = new en7(forumRulesShowActivity, this.m);
            this.o = forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090bff);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.e.onChangeSkinType(this.a.getPageContext(), i);
            if (this.b == i) {
                this.e.getCenterText().setTextSize((float) R.dimen.L_X06);
                SkinManager.setNavbarTitleColor(this.e.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
                WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.i, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.k.c(i);
                this.l.c(i);
                this.j.b(i);
                this.b = i;
            }
        }
    }

    public final void Q() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
            if (baseSwitchs != null && baseSwitchs.containsKey("is_disable_forumrule_share")) {
                i = baseSwitchs.get("is_disable_forumrule_share").intValue();
            } else {
                i = -1;
            }
            if (i == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.c)) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, view2) == null) && this.a != null) {
            if (view2.getId() == R.id.root_pb_more) {
                int i = -1;
                ln7 ln7Var = this.s;
                String str2 = "";
                if (ln7Var == null || ln7Var.e() == null) {
                    str = "";
                } else {
                    i = this.s.e().forum_id.intValue();
                    str = this.s.e().forum_name;
                }
                ln7 ln7Var2 = this.s;
                if (ln7Var2 != null) {
                    str2 = ln7Var2.k();
                }
                String str3 = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
                ShareItem shareItem = new ShareItem();
                shareItem.v = str2;
                shareItem.w = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07d1), str);
                shareItem.x = str3;
                shareItem.q0 = false;
                ln7 ln7Var3 = this.s;
                if (ln7Var3 != null && !StringUtils.isNull(ln7Var3.e().avatar)) {
                    shareItem.z = Uri.parse(this.s.e().avatar);
                    shareItem.m();
                }
                shareItem.U = str2;
                shareItem.V = str3;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
                this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            } else if (view2.getId() == R.id.navigationBarGoBack) {
                this.a.finish();
            } else if (this.p != null && view2.getId() == this.p.c().getId()) {
                this.a.x1();
            }
        }
    }
}
