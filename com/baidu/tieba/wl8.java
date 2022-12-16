package com.baidu.tieba;

import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.more.SettingTextImageView;
import com.baidu.tieba.setting.more.SettingTextNormalImageView;
import com.baidu.tieba.setting.more.SettingTextRedDotView;
import com.baidu.tieba.setting.more.SettingTextVersionView;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import com.baidu.tieba.wv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class wl8 extends p9<MoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public RelativeLayout C;
    public BdSwitchView D;
    public RelativeLayout E;
    public BdSwitchView F;
    public MoreActivity a;
    public vl8 b;
    public NavigationBar c;
    public uv4 d;
    public wv4 e;
    public TextView f;
    public TextView g;
    public TextView h;
    public SettingTextNormalImageView i;
    public SettingTextImageView j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TbSettingTextTipView m;
    public TbSettingTextTipView n;
    public TbSettingTextTipView o;
    public SettingTextRedDotView p;
    public SettingTextVersionView q;
    public TbSettingTextTipView r;
    public TbSettingTextNewDotView s;
    public TextView t;
    public RelativeLayout u;
    public View v;
    public View w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes6.dex */
    public class a implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv4 a;
        public final /* synthetic */ wl8 b;

        public a(wl8 wl8Var, sv4 sv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl8Var, sv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wl8Var;
            this.a = sv4Var;
        }

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) && i == this.a.f()) {
                this.b.z();
                this.b.b.a(12);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements wv4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl8 a;

        public b(wl8 wl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wl8Var;
        }

        @Override // com.baidu.tieba.wv4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl8 a;

        public c(wl8 wl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wl8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.w) {
                    this.a.b.a(0);
                } else if (view2 == this.a.j) {
                    this.a.b.a(1);
                } else if (view2 == this.a.k) {
                    this.a.b.a(15);
                } else if (view2 == this.a.l) {
                    this.a.b.a(2);
                } else if (view2 == this.a.m) {
                    this.a.b.a(3);
                } else if (view2 == this.a.o) {
                    this.a.b.a(4);
                } else if (view2 == this.a.p) {
                    ry4.l().x("setting_private_red_dot", 0);
                    this.a.p.i();
                    this.a.b.a(9);
                } else if (view2 == this.a.q) {
                    this.a.b.a(6);
                } else if (view2 == this.a.r) {
                    this.a.b.a(7);
                } else if (view2 == this.a.s) {
                    this.a.b.a(5);
                } else if (view2 == this.a.t) {
                    this.a.b.a(10);
                } else if (view2 == this.a.i) {
                    this.a.b.a(13);
                } else if (view2 == this.a.n) {
                    this.a.b.a(16);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wl8(MoreActivity moreActivity, vl8 vl8Var) {
        super(moreActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {moreActivity, vl8Var};
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
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.a = moreActivity;
        this.b = vl8Var;
        moreActivity.setContentView(R.layout.obfuscated_res_0x7f0d05b6);
        F();
        Q();
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!y()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return ry4.l().i("key_is_dark_mode_notify_shown", false);
        }
        return invokeV.booleanValue;
    }

    public BdSwitchView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.D;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public final View.OnClickListener C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new c(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public BdSwitchView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.F;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public void H() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.o;
            if (tbSettingTextTipView != null) {
                if (areNotificationsEnabled) {
                    string = "";
                } else {
                    string = this.a.getString(R.string.obfuscated_res_0x7f0f0b13);
                }
                tbSettingTextTipView.setTip(string);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SettingTextVersionView settingTextVersionView = this.q;
            if (settingTextVersionView != null) {
                settingTextVersionView.i();
            }
            TbSettingTextNewDotView tbSettingTextNewDotView = this.s;
            if (tbSettingTextNewDotView != null) {
                tbSettingTextNewDotView.i();
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.d == null) {
                x();
            }
            this.d.k();
        }
    }

    public void N() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (textView = this.t) != null && textView.getVisibility() != 0) {
            this.t.setVisibility(0);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.D.k();
            } else {
                this.D.h();
            }
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        uv4 uv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (uv4Var = this.d) != null) {
            uv4Var.dismiss();
        }
    }

    public final void E(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.i.setOnClickListener(onClickListener);
            this.w.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
            this.l.setOnClickListener(onClickListener);
            this.m.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.o.setOnClickListener(onClickListener);
            this.p.setOnClickListener(onClickListener);
            this.q.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            this.s.setOnClickListener(onClickListener);
            this.t.setOnClickListener(onClickListener);
            this.D.setOnSwitchStateChangeListener(this.a);
            this.F.setOnSwitchStateChangeListener(this.a);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View.OnClickListener C = C();
            this.u = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091835);
            this.v = this.a.findViewById(R.id.obfuscated_res_0x7f091e88);
            this.a.findViewById(R.id.obfuscated_res_0x7f090dba).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            this.w = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f11b3));
            this.c.showBottomLine();
            this.i = (SettingTextNormalImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090053);
            this.j = (SettingTextImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09197d);
            this.k = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090fd9);
            this.l = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090052);
            this.m = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090428);
            this.n = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090083);
            this.o = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0915b0);
            SettingTextRedDotView settingTextRedDotView = (SettingTextRedDotView) this.a.findViewById(R.id.obfuscated_res_0x7f091ef2);
            this.p = settingTextRedDotView;
            settingTextRedDotView.i();
            this.q = (SettingTextVersionView) this.a.findViewById(R.id.obfuscated_res_0x7f0925af);
            this.r = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0909da);
            this.s = (TbSettingTextNewDotView) this.a.findViewById(R.id.obfuscated_res_0x7f0920cc);
            this.t = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091bf8);
            int i = 8;
            if (!TbadkCoreApplication.isLogin()) {
                this.t.setVisibility(8);
            }
            if (this.a.getIntent() != null && this.a.getIntent().getBooleanExtra("not_need_account", false)) {
                this.v.setVisibility(8);
                LinearLayout linearLayout = new LinearLayout(this.a);
                linearLayout.setOrientation(1);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(3, R.id.view_navigation_bar);
                linearLayout.setLayoutParams(layoutParams);
                TbSettingTextTipView tbSettingTextTipView = new TbSettingTextTipView(this.a);
                tbSettingTextTipView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fd6));
                tbSettingTextTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout.addView(tbSettingTextTipView);
                this.u.addView(linearLayout);
                this.o = tbSettingTextTipView;
            }
            this.C = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909a2);
            this.D = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f091063);
            yi.b(this.a.getPageContext().getPageActivity(), this.D, 10, 10, 10, 10);
            this.E = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090a67);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a68);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091047);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a6a);
            this.F = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f090a69);
            yi.b(this.a.getPageContext().getPageActivity(), this.F, 10, 10, 10, 10);
            this.x = this.a.findViewById(R.id.obfuscated_res_0x7f090829);
            this.y = this.a.findViewById(R.id.obfuscated_res_0x7f090828);
            this.z = this.a.findViewById(R.id.obfuscated_res_0x7f09082a);
            this.A = this.a.findViewById(R.id.obfuscated_res_0x7f09082b);
            this.B = this.a.findViewById(R.id.obfuscated_res_0x7f09082c);
            K();
            P();
            this.j.b();
            O(TbadkCoreApplication.getInst().getSkinType());
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            E(C);
            if (!y()) {
                this.m.setTip(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0353));
                this.x.setVisibility(8);
                this.C.setVisibility(8);
            } else {
                this.x.setVisibility(0);
                this.C.setVisibility(0);
            }
            RelativeLayout relativeLayout = this.E;
            if (A()) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
            if (ry4.l().i("key_is_follow_system_mode", false)) {
                this.F.m();
            } else {
                this.F.j();
            }
        }
    }

    public void G(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) {
            if (str != null && str.length() > 0) {
                this.j.a();
                this.j.setIcon(str, z);
                return;
            }
            SettingTextImageView settingTextImageView = this.j;
            if (settingTextImageView != null) {
                settingTextImageView.b();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.e();
            this.k.g();
            this.l.g();
            this.m.g();
            this.o.g();
            this.p.g();
            this.q.g();
            this.r.g();
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048586, this, i) != null) || TbadkCoreApplication.getInst().getSkinType() == i) {
            return;
        }
        if (i == 1) {
            onChangeSkinType(i);
            TbadkCoreApplication.getInst().setSkinType(i);
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "1").param("obj_source", "0"));
        } else if (i == 0 || i == 4) {
            onChangeSkinType(i);
            TbadkCoreApplication.getInst().setSkinType(i);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "0").param("obj_source", "0"));
        }
        BitmapHelper.clearCashBitmap();
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            O(i);
            if (this.e != null) {
                tq4 layoutMode = this.a.getLayoutMode();
                if (i != 1 && i != 4) {
                    z = false;
                } else {
                    z = true;
                }
                layoutMode.l(z);
                this.a.getLayoutMode().k(this.e.f());
            }
            if (i == 1) {
                this.D.m();
            } else {
                this.D.j();
            }
            rw4.d(this.f).v(R.color.CAM_X0105);
            rw4.d(this.g).v(R.color.CAM_X0105);
            rw4.d(this.h).v(R.color.CAM_X0109);
            rw4 d = rw4.d(this.t);
            d.v(R.color.CAM_X0301);
            d.f(R.color.CAM_X0205);
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            this.c.onChangeSkinType(getPageContext(), i);
            tq4 layoutMode = this.a.getLayoutMode();
            boolean z = true;
            if (i != 1 && i != 4) {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.u);
            this.c.onChangeSkinType(getPageContext(), i);
            K();
            this.D.b();
            this.F.b();
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
            this.i.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
            wv4 wv4Var = this.e;
            if (wv4Var != null) {
                wv4Var.i();
            }
            this.i.c(i);
            this.j.f(i);
            this.k.f(i);
            this.l.f(i);
            this.m.f(i);
            this.n.f(i);
            this.o.f(i);
            this.p.f(i);
            this.q.f(i);
            this.r.f(i);
            this.s.f(i);
        }
    }

    public final void x() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            wv4 wv4Var = new wv4(getPageContext().getPageActivity());
            this.e = wv4Var;
            wv4Var.q(getPageContext().getString(R.string.obfuscated_res_0x7f0f0fff));
            ArrayList arrayList = new ArrayList();
            sv4 sv4Var = new sv4(getPageContext().getString(R.string.obfuscated_res_0x7f0f1001), this.e);
            sv4Var.q(R.color.CAM_X0301);
            arrayList.add(sv4Var);
            tq4 layoutMode = this.a.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            } else {
                z = true;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.e.f());
            a aVar = new a(this, sv4Var);
            b bVar = new b(this);
            this.e.j(arrayList);
            this.e.n(aVar);
            this.e.m(bVar);
            uv4 uv4Var = new uv4(this.mContext);
            this.d = uv4Var;
            uv4Var.setCanceledOnTouchOutside(true);
            this.d.h(this.e);
        }
    }
}
