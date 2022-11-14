package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
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
/* loaded from: classes5.dex */
public class rv8 {
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
    public ru8 t;
    public View.OnClickListener u;
    public int v;
    public int w;
    public int x;
    public int y;

    public rv8(PersonalCardDetailActivity personalCardDetailActivity, View.OnClickListener onClickListener) {
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
        View inflate = LayoutInflater.from(personalCardDetailActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0748, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        this.a.setNetRefreshViewTopMargin(BdListViewHelper.a);
        this.v = yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070224);
        this.w = yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070230);
        this.x = yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
        this.y = yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070201);
        this.u = onClickListener;
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f092613);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setTitleText(R.string.obfuscated_res_0x7f0f0ebe);
        this.e = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f092615);
        this.m = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0919e1);
        this.n = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0919e0);
        this.o = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0919e0);
        this.c = this.b.findViewById(R.id.obfuscated_res_0x7f09070d);
        this.s = this.b.findViewById(R.id.obfuscated_res_0x7f0922e9);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09056a);
        this.f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.obfuscated_res_0x7f08127e);
        this.f.setDefaultResource(R.drawable.obfuscated_res_0x7f08127e);
        this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09250a);
        HeadImageView headImageView = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0924f4);
        this.k = headImageView;
        headImageView.setIsRound(true);
        this.k.setDrawBorder(false);
        this.q = (UserIconBox) this.b.findViewById(R.id.obfuscated_res_0x7f0905ae);
        this.p = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09252b);
        this.r = this.b.findViewById(R.id.obfuscated_res_0x7f09083b);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09057d);
        this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090515);
        this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0905ad);
        TbImageView tbImageView2 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0905b0);
        this.h = tbImageView2;
        tbImageView2.setDefaultResource(R.drawable.obfuscated_res_0x7f08127e);
        this.h.setDefaultBgResource(R.drawable.obfuscated_res_0x7f08127e);
        this.j.setOnClickListener(this.u);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            rq4 layoutMode = this.a.getLayoutMode();
            boolean z = true;
            if (TbadkApplication.getInst().getSkinType() != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.b);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.e;
            if (noNetworkView != null) {
                noNetworkView.d(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            if (this.a.getLayoutMode() != null) {
                this.a.getLayoutMode().k(this.n);
                pw4.d(this.n).v(R.color.CAM_X0108);
            }
            if (this.a.getLayoutMode() != null) {
                this.a.getLayoutMode().k(this.m);
                pw4.d(this.m).v(R.color.CAM_X0108);
            }
            if (this.a.getLayoutMode() != null) {
                this.a.getLayoutMode().k(this.o);
                pw4.d(this.o).v(R.color.CAM_X0108);
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
        ru8 ru8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (ru8Var = this.t) == null) {
            return;
        }
        this.g.setText(ru8Var.j());
        this.i.setText(this.t.d());
        this.h.K(this.t.i(), 10, false);
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
            this.l.setText(R.string.obfuscated_res_0x7f0f04ad);
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
                this.p.K(str3, 10, false);
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
            this.k.K(str2, 12, false);
        }
        this.f.K(this.t.e(), 10, false);
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
            this.a.showNetRefreshView(this.b, this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c9d), true);
        }
    }

    public void h(int i, ru8 ru8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, ru8Var) == null) {
            if (ru8Var == null) {
                g();
            } else if (i != 0) {
            } else {
                this.t = ru8Var;
                b();
                f();
                e();
                i(ru8Var);
            }
        }
    }

    public void i(ru8 ru8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ru8Var) != null) || ru8Var == null) {
            return;
        }
        this.t = ru8Var;
        if (ru8Var == null) {
            this.j.setVisibility(8);
            return;
        }
        int f = ru8Var.f();
        this.j.setVisibility(0);
        if (this.t.g() == 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f050f);
        } else if (this.t.c() == 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f153a);
        } else if (f == 0) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f1539);
        } else if (f == 100) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
            if (this.t.h() == 0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f008c);
            } else {
                this.j.setText(R.string.obfuscated_res_0x7f0f153a);
            }
        } else if (f == 101) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f030b);
        } else if (f > 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0311), Integer.valueOf(f)));
        } else {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f030e);
        }
    }
}
