package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.setting.more.MsgRemindActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class tp9 extends i9<MsgRemindActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgSettingItemView a;
    public MsgSettingItemView b;
    public MsgSettingItemView c;
    public MsgSettingItemView d;
    public MsgSettingItemView e;
    public LinearLayout f;
    public TextView g;
    public TextView h;
    public MsgSettingItemView i;
    public View j;
    public NavigationBar k;
    public View l;
    public boolean m;
    public final MsgRemindActivity n;
    public MsgSettingItemView o;
    public MsgSettingItemView p;
    public MsgSettingItemView q;
    public MsgSettingItemView r;
    public MsgSettingItemView s;
    public MsgSettingItemView t;
    public MsgSettingItemView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public final HttpMessageListener y;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tp9 tp9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null) {
                return;
            }
            if ((!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) && this.a.n != null) {
                if (!TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.a.n.showToast(httpResponsedMessage.getErrorString());
                } else {
                    this.a.n.showToast(R.string.set_switch_fail);
                }
            }
            this.a.e0();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(tp9 tp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void d0(View view2, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                int i = 1;
                if (switchState == BdSwitchView.SwitchState.ON) {
                    n95.m().w("official_push_switch", true);
                } else {
                    n95.m().w("official_push_switch", false);
                }
                if (switchState != BdSwitchView.SwitchState.ON) {
                    i = 0;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921754, Integer.valueOf(i)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements OfficialAccountPushModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp9 a;

        public c(tp9 tp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp9Var;
        }

        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.b
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, arrayList, i, str) == null) {
                Iterator<OfficialAccountPushInfo> it = arrayList.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    OfficialAccountPushInfo next = it.next();
                    if (next.uid == 1501754229) {
                        if (next.is_on == 1) {
                            z = true;
                        }
                    }
                }
                if (ne5.d().n() != z) {
                    this.a.p.setSwitchStateNoCallback(z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tp9(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgRemindActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = null;
        this.m = true;
        this.y = new a(this, CmdConfigHttp.CMD_UPDATE_SIGN_DATA);
        this.n = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.obfuscated_res_0x7f0d061f);
    }

    public final void U(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, msgRemindActivity) == null) {
            this.a.setOnSwitchStateChangeListener(msgRemindActivity);
            this.c.setOnSwitchStateChangeListener(msgRemindActivity);
            this.s.setOnSwitchStateChangeListener(msgRemindActivity);
            this.t.setOnSwitchStateChangeListener(msgRemindActivity);
            this.b.setOnSwitchStateChangeListener(msgRemindActivity);
            this.d.setOnSwitchStateChangeListener(msgRemindActivity);
            this.e.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f.setOnClickListener(msgRemindActivity);
            this.i.setOnSwitchStateChangeListener(msgRemindActivity);
            this.k.getCenterText().setOnClickListener(msgRemindActivity);
            msgRemindActivity.registerListener(this.y);
        }
    }

    public void R(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, msgRemindActivity) == null) {
            Y(msgRemindActivity);
            V();
            X();
            W();
            U(msgRemindActivity);
            z();
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (z) {
                this.f.setVisibility(0);
                SkinManager.setBackgroundResource(this.f, R.drawable.more_all);
                return;
            }
            this.f.setVisibility(8);
        }
    }

    public void c0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            View view2 = this.l;
            if (this.m && z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public BdSwitchView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.q.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.o.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.u.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.s.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.t.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public TextView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.k.getCenterText();
        }
        return (TextView) invokeV.objValue;
    }

    public BdSwitchView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public BdSwitchView N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public BdSwitchView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public final void S() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (msgSettingItemView = this.o) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(ne5.d().o());
    }

    public final void T() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (msgSettingItemView = this.u) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(ne5.d().p());
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (ne5.d().E()) {
                this.i.g();
            } else {
                this.i.e();
            }
        }
    }

    public final void Z() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || (msgSettingItemView = this.q) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(ne5.d().m());
    }

    public final void a0() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (msgSettingItemView = this.p) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(ne5.d().n());
        new OfficialAccountPushModel(new c(this)).V();
    }

    public void d0() {
        MsgRemindActivity msgRemindActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (msgRemindActivity = this.n) != null) {
            pe5.c().j(this.n.getActivity(), (ViewGroup) msgRemindActivity.findViewById(16908290));
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.c.setOnSwitchStateChangeListener(null);
            this.c.setSwitchStateNoCallback(ne5.d().v());
            this.c.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.q.setOnSwitchStateChangeListener(null);
            this.q.setSwitchStateNoCallback(ne5.d().m());
            this.q.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.d.setOnSwitchStateChangeListener(null);
            this.d.setSwitchStateNoCallback(ne5.d().y());
            this.d.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.i.setOnSwitchStateChangeListener(null);
            this.i.setSwitchStateNoCallback(ne5.d().E());
            this.i.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.a.setOnSwitchStateChangeListener(null);
            this.a.setSwitchStateNoCallback(ne5.d().A());
            this.a.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.b.setOnSwitchStateChangeListener(null);
            this.b.setSwitchStateNoCallback(ne5.d().D());
            this.b.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.t.setOnSwitchStateChangeListener(null);
            this.t.setSwitchStateNoCallback(ne5.d().t());
            this.t.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.s.setOnSwitchStateChangeListener(null);
            this.s.setSwitchStateNoCallback(ne5.d().r());
            this.s.setOnSwitchStateChangeListener(this.n);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                this.i.setVisibility(8);
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            y();
        }
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.g != null && !TextUtils.equals(this.n.getString(R.string.obfuscated_res_0x7f0f046b), this.g.getText().toString())) {
                return this.g.getText().toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (ne5.d().F()) {
                this.e.f();
                this.f.setVisibility(0);
                e0();
                return;
            }
            this.e.d();
            this.f.setVisibility(8);
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.a.setSwitchStateNoCallback(ne5.d().A());
            this.b.setSwitchStateNoCallback(ne5.d().D());
            this.c.setSwitchStateNoCallback(ne5.d().v());
            this.d.setSwitchStateNoCallback(ne5.d().y());
            this.s.setSwitchStateNoCallback(ne5.d().r());
            this.t.setSwitchStateNoCallback(ne5.d().t());
        }
    }

    public void Y(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, msgRemindActivity) == null) {
            this.j = msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0919a4);
            NavigationBar navigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
            this.k = navigationBar;
            navigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1156));
            this.k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.l = msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f090c20);
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091e19);
            this.a = msgSettingItemView;
            msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f11ed);
            MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0929be);
            this.b = msgSettingItemView2;
            msgSettingItemView2.setVisibility(0);
            this.b.setText(R.string.action_praise_default);
            MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0902dd);
            this.c = msgSettingItemView3;
            msgSettingItemView3.setText(R.string.mention_atme);
            MsgSettingItemView msgSettingItemView4 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091891);
            this.d = msgSettingItemView4;
            msgSettingItemView4.setText(R.string.obfuscated_res_0x7f0f0df4);
            MsgSettingItemView msgSettingItemView5 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092136);
            this.e = msgSettingItemView5;
            msgSettingItemView5.setText(R.string.obfuscated_res_0x7f0f13a1);
            this.f = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092134);
            this.g = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092137);
            this.h = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092139);
            MsgSettingItemView msgSettingItemView6 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0918db);
            this.i = msgSettingItemView6;
            msgSettingItemView6.setText(R.string.obfuscated_res_0x7f0f0e13);
            this.i.setTipText(R.string.obfuscated_res_0x7f0f0e14);
            this.v = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092654);
            this.w = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0926b1);
            this.x = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092627);
            MsgSettingItemView msgSettingItemView7 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0917bb);
            this.s = msgSettingItemView7;
            msgSettingItemView7.setText(R.string.obfuscated_res_0x7f0f0ce1);
            this.s.setTipText(R.string.obfuscated_res_0x7f0f0ce2);
            MsgSettingItemView msgSettingItemView8 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0911ae);
            this.t = msgSettingItemView8;
            msgSettingItemView8.setText(R.string.obfuscated_res_0x7f0f0b20);
            MsgSettingItemView msgSettingItemView9 = (MsgSettingItemView) this.n.findViewById(R.id.obfuscated_res_0x7f0911ac);
            this.u = msgSettingItemView9;
            msgSettingItemView9.setText(R.string.obfuscated_res_0x7f0f1196);
            this.u.setOnSwitchStateChangeListener(this.n);
            T();
            MsgSettingItemView msgSettingItemView10 = (MsgSettingItemView) this.n.findViewById(R.id.obfuscated_res_0x7f0911ab);
            this.o = msgSettingItemView10;
            msgSettingItemView10.setText(R.string.obfuscated_res_0x7f0f1195);
            this.o.setOnSwitchStateChangeListener(this.n);
            S();
            MsgSettingItemView msgSettingItemView11 = (MsgSettingItemView) this.n.findViewById(R.id.obfuscated_res_0x7f0911b0);
            this.p = msgSettingItemView11;
            msgSettingItemView11.setText(R.string.obfuscated_res_0x7f0f0e92);
            this.p.setOnSwitchStateChangeListener(this.n);
            a0();
            MsgSettingItemView msgSettingItemView12 = (MsgSettingItemView) this.n.findViewById(R.id.obfuscated_res_0x7f0911aa);
            this.q = msgSettingItemView12;
            msgSettingItemView12.setText(R.string.obfuscated_res_0x7f0f074d);
            this.q.setOnSwitchStateChangeListener(this.n);
            Z();
            if (this.n.getIntent() != null && this.n.getIntent().getBooleanExtra("not_need_account", false)) {
                this.l.setVisibility(8);
                LinearLayout linearLayout = new LinearLayout(this.n);
                linearLayout.setOrientation(1);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(3, R.id.view_navigation_bar);
                linearLayout.setLayoutParams(layoutParams);
                MsgSettingItemView msgSettingItemView13 = new MsgSettingItemView(this.n);
                this.r = msgSettingItemView13;
                msgSettingItemView13.setText(R.string.obfuscated_res_0x7f0f0e92);
                msgSettingItemView13.setClickable(true);
                msgSettingItemView13.setFocusable(true);
                msgSettingItemView13.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout.addView(msgSettingItemView13);
                if (n95.m().i("official_push_switch", true)) {
                    msgSettingItemView13.f();
                } else {
                    msgSettingItemView13.d();
                }
                msgSettingItemView13.setOnSwitchStateChangeListener(new b(this));
                ((RelativeLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0919a4)).addView(linearLayout);
            }
        }
    }

    public void e0() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (ne5.d().F()) {
                int j = ne5.d().j();
                int k = ne5.d().k();
                if (j > 9) {
                    str = String.valueOf(j);
                } else {
                    str = "0" + j;
                }
                if (k > 9) {
                    str2 = String.valueOf(k);
                } else {
                    str2 = "0" + k;
                }
                this.g.setText(this.n.getString(R.string.obfuscated_res_0x7f0f13a2, new Object[]{str, str2}));
                this.f.setVisibility(0);
                if (!this.e.b()) {
                    this.e.g();
                    return;
                }
                return;
            }
            this.g.setText(R.string.obfuscated_res_0x7f0f046b);
            this.f.setVisibility(8);
            if (this.e.b()) {
                this.e.e();
            }
        }
    }

    public void onChangeSkinType(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            View view2 = this.j;
            if (TbadkCoreApplication.isLogin()) {
                i2 = R.color.CAM_X0204;
            } else {
                i2 = R.color.CAM_X0201;
            }
            SkinManager.setBackgroundColor(view2, i2);
            this.k.onChangeSkinType(this.n.getPageContext(), i);
            o75.d(this.v).w(R.color.CAM_X0109);
            o75.d(this.w).w(R.color.CAM_X0109);
            o75.d(this.x).w(R.color.CAM_X0109);
            this.a.c(this.n.getPageContext(), i);
            this.b.c(this.n.getPageContext(), i);
            this.c.c(this.n.getPageContext(), i);
            this.d.c(this.n.getPageContext(), i);
            this.e.c(this.n.getPageContext(), i);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
            this.o.c(this.n.getPageContext(), i);
            this.u.c(this.n.getPageContext(), i);
            this.p.c(this.n.getPageContext(), i);
            this.q.c(this.n.getPageContext(), i);
            MsgSettingItemView msgSettingItemView = this.r;
            if (msgSettingItemView != null) {
                msgSettingItemView.c(this.n.getPageContext(), i);
            }
            this.s.c(this.n.getPageContext(), i);
            this.t.c(this.n.getPageContext(), i);
            this.i.c(this.n.getPageContext(), i);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(null, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092135), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
