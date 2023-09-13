package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class poa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalCardDetailActivity a;
    public View b;
    public View c;
    public NavigationBar d;
    public NoNetworkView e;
    public TbImageView f;
    public TextView g;
    public TbImageView h;
    public TextView i;
    public TextView j;
    public HeadImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TbImageView p;
    public UserIconBox q;
    public View r;
    public View s;
    public pna t;
    public View.OnClickListener u;
    public int v;
    public int w;
    public int x;
    public int y;

    public poa(PersonalCardDetailActivity personalCardDetailActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalCardDetailActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.a = personalCardDetailActivity;
        View inflate = LayoutInflater.from(personalCardDetailActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0811, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        this.a.setNetRefreshViewTopMargin(BdListViewHelper.a);
        this.v = BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070224);
        this.w = BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07035d);
        this.x = BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
        this.y = BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070201);
        this.u = onClickListener;
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setTitleText(R.string.obfuscated_res_0x7f0f10b9);
        this.e = (NoNetworkView) this.b.findViewById(R.id.view_no_network);
        this.m = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c7a);
        this.n = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c79);
        this.o = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c79);
        this.c = this.b.findViewById(R.id.content_view);
        this.s = this.b.findViewById(R.id.obfuscated_res_0x7f092665);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090605);
        this.f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
        this.f.setDefaultResource(R.drawable.transparent_bg);
        this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09289b);
        HeadImageView headImageView = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f092880);
        this.k = headImageView;
        headImageView.setIsRound(true);
        this.k.setDrawBorder(false);
        this.q = (UserIconBox) this.b.findViewById(R.id.obfuscated_res_0x7f090638);
        this.p = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0928c0);
        this.r = this.b.findViewById(R.id.obfuscated_res_0x7f09091b);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090615);
        this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0905ac);
        this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090637);
        TbImageView tbImageView2 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09063a);
        this.h = tbImageView2;
        tbImageView2.setDefaultResource(R.drawable.transparent_bg);
        this.h.setDefaultBgResource(R.drawable.transparent_bg);
        this.j.setOnClickListener(this.u);
    }

    public void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (TbadkApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.b);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.e;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            if (this.a.getLayoutMode() != null) {
                this.a.getLayoutMode().onModeChanged(this.n);
                EMManager.from(this.n).setTextColor(R.color.CAM_X0108);
            }
            if (this.a.getLayoutMode() != null) {
                this.a.getLayoutMode().onModeChanged(this.m);
                EMManager.from(this.m).setTextColor(R.color.CAM_X0108);
            }
            if (this.a.getLayoutMode() != null) {
                this.a.getLayoutMode().onModeChanged(this.o);
                EMManager.from(this.o).setTextColor(R.color.CAM_X0108);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.setVisibility(0);
            this.s.setVisibility(0);
            this.f.setVisibility(0);
            this.r.setVisibility(0);
            this.g.setVisibility(0);
            this.i.setVisibility(0);
            this.h.setVisibility(0);
            this.j.setVisibility(0);
            this.a.hideNetRefreshView(this.b);
        }
    }

    public final void e() {
        pna pnaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (pnaVar = this.t) == null) {
            return;
        }
        this.g.setText(pnaVar.j());
        this.i.setText(this.t.d());
        this.h.startLoad(this.t.i(), 10, false);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public final void f() {
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.t == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.q.setVisibility(8);
            this.p.setVisibility(8);
            this.l.setPadding(this.x, 0, 0, 0);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0308, 1);
            this.l.setText(R.string.obfuscated_res_0x7f0f053b);
        } else {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            String str3 = null;
            if (currentAccountInfo != null) {
                String portrait = currentAccountInfo.getPortrait();
                str = currentAccountInfo.getAccountNameShow();
                String memberIconUrl = currentAccountInfo.getMemberIconUrl();
                i = currentAccountInfo.getMemberType();
                str2 = portrait;
                str3 = memberIconUrl;
            } else {
                str = null;
                str2 = null;
                i = 0;
            }
            if (i > 0) {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0308, 1);
            } else {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0108, 1);
            }
            if (StringUtils.isNull(str3)) {
                this.p.setVisibility(8);
                this.l.setPadding(this.x, 0, 0, 0);
                this.l.setText(str);
            } else {
                this.p.setVisibility(0);
                this.p.startLoad(str3, 10, false);
                this.l.setPadding(this.v, 0, 0, 0);
                this.l.setText(str);
            }
            this.q.setVisibility(0);
            if (currentAccountInfo != null && currentAccountInfo.getUserIcons() != null) {
                i2 = currentAccountInfo.getUserIcons().size();
            } else {
                i2 = 0;
            }
            if (i2 >= 8 || (i3 = i2 - 1) >= 4) {
                i4 = 4;
            } else {
                i4 = i3;
            }
            if (currentAccountInfo != null) {
                UserIconBox userIconBox = this.q;
                List<IconData> userIcons = currentAccountInfo.getUserIcons();
                int i5 = this.y;
                userIconBox.h(userIcons, i4, i5, i5, this.w, true);
            }
            this.k.startLoad(str2, 12, false);
        }
        this.f.startLoad(this.t.e(), 10, false);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.setVisibility(8);
            this.f.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.g.setVisibility(8);
            this.i.setVisibility(8);
            this.h.setVisibility(8);
            this.j.setVisibility(8);
            this.a.showNetRefreshView(this.b, this.a.getPageContext().getResources().getString(R.string.no_data_text), true);
        }
    }

    public void h(int i, pna pnaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, pnaVar) == null) {
            if (pnaVar == null) {
                g();
            } else if (i != 0) {
            } else {
                this.t = pnaVar;
                b();
                f();
                e();
                i(pnaVar);
            }
        }
    }

    public void i(pna pnaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pnaVar) != null) || pnaVar == null) {
            return;
        }
        this.t = pnaVar;
        if (pnaVar == null) {
            this.j.setVisibility(8);
            return;
        }
        int f = pnaVar.f();
        this.j.setVisibility(0);
        if (this.t.g() == 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f05ab);
        } else if (this.t.c() == 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.use_immediately);
        } else if (f == 0) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f17d7);
        } else if (f == 100) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
            if (this.t.h() == 0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f00b9);
            } else {
                this.j.setText(R.string.use_immediately);
            }
        } else if (f == 101) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f034b);
        } else if (f > 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0351), Integer.valueOf(f)));
        } else {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f034e);
        }
    }
}
