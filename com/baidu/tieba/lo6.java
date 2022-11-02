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
/* loaded from: classes5.dex */
public class lo6 extends p9<ForumRulesShowActivity> implements View.OnClickListener {
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
    public wn6 j;
    public ho6 k;
    public go6 l;
    public BdTypeRecyclerView m;
    public List<wn> n;
    public View o;
    public da5 p;
    public int q;
    public int r;
    public do6 s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ lo6 b;

        public a(lo6 lo6Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo6Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lo6Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ni.a(this.a.x);
                xi.P(this.b.a, this.b.a.getResources().getString(R.string.obfuscated_res_0x7f0f045e));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lo6(ForumRulesShowActivity forumRulesShowActivity, String str) {
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
                super((r9) newInitContext.callArgs[0]);
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
        forumRulesShowActivity.setContentView(R.layout.obfuscated_res_0x7f0d0037);
        this.k = new ho6(forumRulesShowActivity);
        this.l = new go6(forumRulesShowActivity);
        this.q = xi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070306);
        this.r = xi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        w(forumRulesShowActivity);
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.k != null && !StringUtils.isNull(str)) {
            this.k.a(this.m);
            this.k.e(str);
        }
    }

    public void E(String str) {
        go6 go6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (go6Var = this.l) != null) {
            go6Var.a(this.m);
            this.l.e(str);
        }
    }

    public void k(do6 do6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, do6Var) == null) {
            this.s = do6Var;
            this.n.add(do6Var);
        }
    }

    public void l(co6 co6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, co6Var) == null) {
            this.n.add(co6Var);
        }
    }

    public void m(List<eo6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.n.addAll(list);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            D(str);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.c = str;
            wn6 wn6Var = this.j;
            if (wn6Var != null) {
                wn6Var.d(str);
            }
        }
    }

    public void z(da5 da5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, da5Var) == null) {
            this.p = da5Var;
            da5Var.c().setOnClickListener(this);
        }
    }

    public final void A() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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

    public void B() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeRecyclerView = this.m) != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
    }

    public void C() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (view2 = this.o) != null) {
            view2.setVisibility(0);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a = null;
        }
    }

    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public ViewGroup q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void r() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (bdTypeRecyclerView = this.m) != null) {
            bdTypeRecyclerView.setVisibility(8);
        }
    }

    public void s() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (view2 = this.o) != null) {
            view2.setVisibility(8);
        }
    }

    public void t() {
        ho6 ho6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (ho6Var = this.k) != null) {
            ho6Var.d(this.m);
        }
    }

    public void u() {
        go6 go6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (go6Var = this.l) != null) {
            go6Var.d(this.m);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            u();
            t();
        }
    }

    public void y() {
        wn6 wn6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (wn6Var = this.j) != null) {
            wn6Var.c(this.n);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.e.onChangeSkinType(this.a.getPageContext(), i);
            if (this.b == i) {
                this.e.getCenterText().setTextSize((float) R.dimen.L_X06);
                SkinManager.setNavbarTitleColor(this.e.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
                WebPManager.setPureDrawable(this.g, R.drawable.obfuscated_res_0x7f080a3b, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.i, R.drawable.obfuscated_res_0x7f080a37, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.k.c(i);
                this.l.c(i);
                this.j.b(i);
                this.b = i;
            }
        }
    }

    public final void w(ForumRulesShowActivity forumRulesShowActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, forumRulesShowActivity) == null) {
            this.d = (ViewGroup) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090ab7);
            NavigationBar navigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f09169c);
            this.e = navigationBar;
            v(navigationBar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090ac4);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
            this.j = new wn6(forumRulesShowActivity, this.m);
            this.o = forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090ac5);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view2) == null) && this.a != null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091cc4) {
                int i = -1;
                do6 do6Var = this.s;
                String str2 = "";
                if (do6Var == null || do6Var.g() == null) {
                    str = "";
                } else {
                    i = this.s.g().forum_id.intValue();
                    str = this.s.g().forum_name;
                }
                do6 do6Var2 = this.s;
                if (do6Var2 != null) {
                    str2 = do6Var2.n();
                }
                String str3 = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
                ShareItem shareItem = new ShareItem();
                shareItem.v = str2;
                shareItem.w = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06d8), str);
                shareItem.x = str3;
                shareItem.n0 = false;
                do6 do6Var3 = this.s;
                if (do6Var3 != null && !StringUtils.isNull(do6Var3.g().avatar)) {
                    shareItem.z = Uri.parse(this.s.g().avatar);
                    shareItem.g();
                }
                shareItem.T = str2;
                shareItem.U = str3;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
                this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091680) {
                this.a.finish();
            } else if (this.p != null && view2.getId() == this.p.c().getId()) {
                this.a.B1();
            }
        }
    }

    public final void v(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, navigationBar) == null) {
            View addSystemImageButton = this.e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.f = addSystemImageButton;
            this.g = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f0926c0);
            this.e.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06d5));
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0642, this);
            this.h = addCustomView;
            this.i = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09167e);
            int i = this.q;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.rightMargin = this.r;
            this.h.setLayoutParams(layoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            A();
        }
    }
}
