package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.im.recommend.detail.RecommendDetailActivity;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes5.dex */
public class o08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendDetailActivity a;
    public View b;
    public NavigationBar c;
    public NoNetworkView d;
    public HeadImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public LinearLayout j;
    public LinearLayout k;
    public SettingTextSwitchView l;
    public SettingTextSwitchView m;
    public NoDataView n;
    public LinearLayout o;
    public RelativeLayout p;
    public RelativeLayout q;
    public View r;
    public boolean s;
    public long t;

    public o08(RecommendDetailActivity recommendDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recommendDetailActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = 0L;
        this.a = recommendDetailActivity;
        h();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.s) {
                e();
            } else {
                m();
            }
        }
    }

    public BdSwitchView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SettingTextSwitchView settingTextSwitchView = this.l;
            if (settingTextSwitchView != null) {
                return settingTextSwitchView.getSwitchView();
            }
            return null;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SettingTextSwitchView settingTextSwitchView = this.m;
            if (settingTextSwitchView != null) {
                return settingTextSwitchView.getSwitchView();
            }
            return null;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayout linearLayout = this.j;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            f();
        }
    }

    public void f() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (linearLayout = this.k) != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.o.setVisibility(0);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (TbadkCoreApplication.getInst().isPromotedMessageOn(String.valueOf(this.t)) && !this.s) {
                n();
            } else {
                f();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            LinearLayout linearLayout = this.j;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            n();
        }
    }

    public void n() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (linearLayout = this.k) != null) {
            linearLayout.setVisibility(0);
        }
    }

    public void b() {
        RecommendDetailActivity recommendDetailActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (recommendDetailActivity = this.a) != null && m95.M(String.valueOf(recommendDetailActivity.c))) {
            this.e.N(this.a.e, 12, false);
            RecommendDetailActivity recommendDetailActivity2 = this.a;
            this.t = recommendDetailActivity2.c;
            this.f.setText(UtilHelper.getFixedText(recommendDetailActivity2.d, 7));
            this.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0db7));
            e();
        }
    }

    public final void h() {
        RecommendDetailActivity recommendDetailActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (recommendDetailActivity = this.a) == null) {
            return;
        }
        recommendDetailActivity.setContentView(R.layout.obfuscated_res_0x7f0d07cc);
        this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091e33);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.c = navigationBar;
        navigationBar.showBottomLine();
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        k(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1078));
        this.d = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
        LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.content_view);
        this.o = linearLayout;
        linearLayout.setVisibility(8);
        this.p = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09079b);
        this.q = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090792);
        this.r = this.a.findViewById(R.id.obfuscated_res_0x7f0908b6);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09269d);
        this.e = headImageView;
        headImageView.setIsRound(true);
        this.f = (TextView) this.a.findViewById(R.id.user_name);
        this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0926d4);
        this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0926a5);
        this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910e7);
        this.j = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0921cd);
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f0921ce);
        this.l = settingTextSwitchView;
        settingTextSwitchView.setSwitchStateChangeListener(this.a);
        this.k = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0921d0);
        SettingTextSwitchView settingTextSwitchView2 = (SettingTextSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f0921d1);
        this.m = settingTextSwitchView2;
        settingTextSwitchView2.setSwitchStateChangeListener(this.a);
    }

    public void j(int i) {
        RecommendDetailActivity recommendDetailActivity;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (recommendDetailActivity = this.a) != null && recommendDetailActivity.getPageContext() != null && this.a.getPageContext().getLayoutMode() != null) {
            hv4 layoutMode = this.a.getPageContext().getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getPageContext().getLayoutMode().k(this.b);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), i);
            }
            NoNetworkView noNetworkView = this.d;
            if (noNetworkView != null) {
                noNetworkView.d(this.a.getPageContext(), i);
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i);
            }
            SettingTextSwitchView settingTextSwitchView = this.l;
            if (settingTextSwitchView != null) {
                settingTextSwitchView.d(i);
            }
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0201);
            q25 d = q25.d(this.f);
            d.C(R.string.F_X02);
            d.B(R.dimen.T_X04);
            d.w(R.color.CAM_X0105);
            q25 d2 = q25.d(this.g);
            d2.C(R.string.F_X01);
            d2.B(R.dimen.T_X08);
            d2.w(R.color.CAM_X0109);
            q25 d3 = q25.d(this.h);
            d3.C(R.string.F_X01);
            d3.B(R.dimen.obfuscated_res_0x7f0702b7);
            d3.w(R.color.CAM_X0105);
        }
    }

    public void k(String str) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && (navigationBar = this.c) != null) {
            navigationBar.setCenterTextTitle(str);
        }
    }

    public void l(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, view2, z) == null) {
            SettingTextSwitchView settingTextSwitchView = this.l;
            if (view2 == settingTextSwitchView) {
                if (z) {
                    settingTextSwitchView.getSwitchView().m();
                    return;
                } else {
                    settingTextSwitchView.getSwitchView().j();
                    return;
                }
            }
            SettingTextSwitchView settingTextSwitchView2 = this.m;
            if (view2 == settingTextSwitchView2) {
                if (z) {
                    settingTextSwitchView2.getSwitchView().m();
                } else {
                    settingTextSwitchView2.getSwitchView().j();
                }
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (this.n == null) {
                this.n = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07029f)), NoDataViewFactory.e.a(i), null);
            }
            this.n.setTextOption(NoDataViewFactory.e.a(i));
            this.n.f(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.o.setVisibility(8);
            this.n.setVisibility(0);
        }
    }

    public void p(UserInfoBigVip userInfoBigVip, boolean z) {
        RecommendDetailActivity recommendDetailActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048591, this, userInfoBigVip, z) == null) && userInfoBigVip != null && (recommendDetailActivity = this.a) != null) {
            String str = userInfoBigVip.user_name;
            if (!StringUtils.isNull(recommendDetailActivity.d) && !this.a.d.equals(userInfoBigVip.user_name)) {
                RecommendDetailActivity recommendDetailActivity2 = this.a;
                str = recommendDetailActivity2.d;
                if (m95.M(String.valueOf(recommendDetailActivity2.c))) {
                    b();
                    return;
                }
            }
            this.e.N(userInfoBigVip.portraith, 12, false);
            String fixedText = UtilHelper.getFixedText(str, 7);
            this.t = userInfoBigVip.user_id.longValue();
            this.f.setText(fixedText);
            this.g.setText(userInfoBigVip.user_type);
            this.s = m95.M(String.valueOf(this.t));
            if (!StringUtils.isNull(userInfoBigVip.user_detail) && !this.s) {
                this.q.setVisibility(0);
                this.r.setVisibility(0);
                this.i.setText(userInfoBigVip.user_detail);
            }
            a();
            if (z) {
                if (userInfoBigVip.message_accept.intValue() == 1) {
                    l(this.l, true);
                    TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(userInfoBigVip.user_id), true);
                } else {
                    l(this.l, false);
                    TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(userInfoBigVip.user_id), false);
                }
                if (userInfoBigVip.mute_notifications.intValue() == 1) {
                    l(this.m, true);
                    this.a.A1(true);
                } else {
                    l(this.m, false);
                    this.a.A1(false);
                }
            } else {
                l(this.l, TbadkCoreApplication.getInst().isPromotedMessageOn(String.valueOf(userInfoBigVip.user_id)));
                OfficialSettingItemData a = x08.j().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(userInfoBigVip.user_id));
                if (a != null) {
                    l(this.m, !a.isAcceptNotify());
                }
            }
            i();
        }
    }
}
