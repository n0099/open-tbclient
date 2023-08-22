package com.baidu.tieba;

import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.c55;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.more.SettingTextImageView;
import com.baidu.tieba.setting.more.SettingTextNormalImageView;
import com.baidu.tieba.setting.more.SettingTextRedDotView;
import com.baidu.tieba.setting.more.SettingTextVersionView;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class x6a extends BdBaseView<MoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public RelativeLayout C;
    public BdSwitchView D;
    public RelativeLayout E;
    public BdSwitchView F;
    public MoreActivity a;
    public w6a b;
    public NavigationBar c;
    public a55 d;
    public c55 e;
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

    /* loaded from: classes8.dex */
    public class a implements c55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y45 a;
        public final /* synthetic */ x6a b;

        public a(x6a x6aVar, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x6aVar, y45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x6aVar;
            this.a = y45Var;
        }

        @Override // com.baidu.tieba.c55.f
        public void J0(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, c55Var, i, view2) == null) && i == this.a.f()) {
                this.b.O();
                this.b.b.a(12);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c55.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x6a a;

        public b(x6a x6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x6aVar;
        }

        @Override // com.baidu.tieba.c55.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.O();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x6a a;

        public c(x6a x6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x6aVar;
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
                    SharedPrefHelper.getInstance().putInt("setting_private_red_dot", 0);
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
    public x6a(MoreActivity moreActivity, w6a w6aVar) {
        super(moreActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {moreActivity, w6aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
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
        this.b = w6aVar;
        moreActivity.setContentView(R.layout.obfuscated_res_0x7f0d062a);
        U();
        f0();
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i) != null) || TbadkCoreApplication.getInst().getSkinType() == i) {
            return;
        }
        onChangeSkinType(i);
        TbadkCoreApplication.getInst().setSkinType(i);
        BitmapHelper.clearCashBitmap();
    }

    public final void M() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c55 c55Var = new c55(getPageContext().getPageActivity());
            this.e = c55Var;
            c55Var.t(getPageContext().getString(R.string.obfuscated_res_0x7f0f11c1));
            ArrayList arrayList = new ArrayList();
            y45 y45Var = new y45(getPageContext().getString(R.string.obfuscated_res_0x7f0f11c3), this.e);
            y45Var.q(R.color.CAM_X0301);
            arrayList.add(y45Var);
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.e.f());
            a aVar = new a(this, y45Var);
            b bVar = new b(this);
            this.e.l(arrayList);
            this.e.q(aVar);
            this.e.o(bVar);
            a55 a55Var = new a55(this.mContext);
            this.d = a55Var;
            a55Var.setCanceledOnTouchOutside(true);
            this.d.h(this.e);
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void O() {
        a55 a55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (a55Var = this.d) != null) {
            a55Var.dismiss();
        }
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!N()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return SharedPrefHelper.getInstance().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return invokeV.booleanValue;
    }

    public BdSwitchView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.D;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public final View.OnClickListener R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new c(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public BdSwitchView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.F;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public void X() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.o;
            if (tbSettingTextTipView != null) {
                if (areNotificationsEnabled) {
                    string = "";
                } else {
                    string = this.a.getString(R.string.obfuscated_res_0x7f0f0c5c);
                }
                tbSettingTextTipView.setTip(string);
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.d == null) {
                M();
            }
            this.d.l();
        }
    }

    public void c0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (textView = this.t) != null && textView.getVisibility() != 0) {
            this.t.setVisibility(0);
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.D.k();
            } else {
                this.D.h();
            }
        }
    }

    public final void T(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
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

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View.OnClickListener R = R();
            this.u = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091a55);
            this.v = this.a.findViewById(R.id.obfuscated_res_0x7f0920f9);
            this.a.findViewById(R.id.obfuscated_res_0x7f090f13).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            this.w = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1383));
            this.c.showBottomLine();
            this.i = (SettingTextNormalImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090064);
            this.j = (SettingTextImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091b95);
            this.k = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091163);
            this.l = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090063);
            this.m = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090496);
            this.n = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090093);
            this.o = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091758);
            SettingTextRedDotView settingTextRedDotView = (SettingTextRedDotView) this.a.findViewById(R.id.obfuscated_res_0x7f092163);
            this.p = settingTextRedDotView;
            settingTextRedDotView.i();
            this.q = (SettingTextVersionView) this.a.findViewById(R.id.obfuscated_res_0x7f0928ab);
            this.r = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090b02);
            this.s = (TbSettingTextNewDotView) this.a.findViewById(R.id.obfuscated_res_0x7f09236c);
            this.t = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e23);
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
                tbSettingTextTipView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1197));
                tbSettingTextTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout.addView(tbSettingTextTipView);
                this.u.addView(linearLayout);
                this.o = tbSettingTextTipView;
            }
            this.C = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090aca);
            this.D = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f0911e6);
            BdUtilHelper.addToParentArea(this.a.getPageContext().getPageActivity(), this.D, 10, 10, 10, 10);
            this.E = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090ba1);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090ba2);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0911ca);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090ba4);
            this.F = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f090ba3);
            BdUtilHelper.addToParentArea(this.a.getPageContext().getPageActivity(), this.F, 10, 10, 10, 10);
            this.x = this.a.findViewById(R.id.obfuscated_res_0x7f0908f6);
            this.y = this.a.findViewById(R.id.obfuscated_res_0x7f0908f5);
            this.z = this.a.findViewById(R.id.obfuscated_res_0x7f0908f7);
            this.A = this.a.findViewById(R.id.obfuscated_res_0x7f0908f8);
            this.B = this.a.findViewById(R.id.obfuscated_res_0x7f0908f9);
            Z();
            e0();
            this.j.b();
            d0(TbadkCoreApplication.getInst().getSkinType());
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            T(R);
            if (!N()) {
                this.m.setTip(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0394));
                this.x.setVisibility(8);
                this.C.setVisibility(8);
            } else {
                this.x.setVisibility(0);
                this.C.setVisibility(0);
            }
            RelativeLayout relativeLayout = this.E;
            if (P()) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
            if (SharedPrefHelper.getInstance().getBoolean("key_is_follow_system_mode", false)) {
                this.F.m();
            } else {
                this.F.j();
            }
        }
    }

    public void W(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) {
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

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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

    public void d0(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            this.c.onChangeSkinType(getPageContext(), i);
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.u);
            this.c.onChangeSkinType(getPageContext(), i);
            Z();
            this.D.b();
            this.F.b();
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0204);
            this.i.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
            c55 c55Var = this.e;
            if (c55Var != null) {
                c55Var.j();
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

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            d0(i);
            if (this.e != null) {
                BDLayoutMode layoutMode = this.a.getLayoutMode();
                if (i == 4) {
                    z = true;
                } else {
                    z = false;
                }
                layoutMode.setNightMode(z);
                this.a.getLayoutMode().onModeChanged(this.e.f());
            }
            if (i == 4) {
                this.D.m();
            } else {
                this.D.j();
            }
            EMManager.from(this.f).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.h).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.t).setTextColor(R.color.CAM_X0301).setBackGroundColor(R.color.CAM_X0205);
        }
    }
}
