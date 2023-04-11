package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.switchs.UploadLogButtonSwitch;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class zd9 extends y8<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SystemHelpSettingActivity a;
    public View b;
    public TbSettingTextTipView c;
    public TbSettingTextTipView d;
    public BdSwitchView e;
    public BdSwitchView f;
    public TbSettingTextNewDotView g;
    public MsgSettingItemView h;
    public TbSettingTextTipView i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TbSettingTextTipView p;
    public NavigationBar q;
    public BdSwitchView.b r;

    /* loaded from: classes7.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zd9 a;

        public a(zd9 zd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zd9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zd9Var;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void c0(View view2, BdSwitchView.SwitchState switchState) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) && view2 == this.a.h.getSwitchView()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    z = true;
                } else {
                    z = false;
                }
                p45 m = p45.m();
                m.w("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                this.a.a.A1("recnbar", z ^ true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zd9(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {systemHelpSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.i = null;
        this.p = null;
        this.r = new a(this);
        this.a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d08ae);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.q = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1432));
        this.q.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0906e4);
        this.c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.c.setOnClickListener(this.a);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0906e5);
        this.d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.d.setOnClickListener(this.a);
        this.e = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f09113f);
        ii.b(this.a.getPageContext().getPageActivity(), this.e, 10, 10, 10, 10);
        this.e.setOnSwitchStateChangeListener(this.a);
        this.f = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f092022);
        ii.b(this.a.getPageContext().getPageActivity(), this.f, 10, 10, 10, 10);
        this.f.setOnSwitchStateChangeListener(this.a);
        this.i = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090820);
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0921d4);
        this.k = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0921d6);
        this.l = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0921d5);
        this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091123);
        this.m = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091124);
        this.n = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0921d3);
        if (jv4.h()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.i.c();
        this.i.setOnClickListener(this.a);
        this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091922);
        if (TbadkCoreApplication.isLogin()) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.obfuscated_res_0x7f092190);
        this.g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.a);
        this.g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f091d0c);
        this.h = msgSettingItemView;
        msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f0fda);
        this.h.setOnSwitchStateChangeListener(this.r);
        p45 m = p45.m();
        F(m.i("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
        this.p = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f092678);
        if (UploadLogButtonSwitch.isOn()) {
            this.p.setVisibility(0);
            this.p.c();
            this.p.setOnClickListener(this.a);
            return;
        }
        this.p.setVisibility(8);
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (!z) {
                this.h.getSwitchView().m();
            } else {
                this.h.getSwitchView().j();
            }
        }
    }

    public TbSettingTextTipView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (TbSettingTextNewDotView) invokeV.objValue;
    }

    public TbSettingTextTipView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.p;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextTipView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            hv4 layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.b);
            this.q.onChangeSkinType(getPageContext(), i);
            this.e.b();
            this.f.b();
            this.h.c(this.a.getPageContext(), i);
            SkinManager.setBackgroundResource(this.c, R.drawable.more_all);
            q25.d(this.j).w(R.color.CAM_X0205);
            q25.d(this.k).w(R.color.CAM_X0205);
            q25.d(this.l).w(R.color.CAM_X0105);
            q25.d(this.m).w(R.color.CAM_X0109);
            q25.d(this.n).w(R.color.CAM_X0108);
            q25.d(this.o).w(R.color.CAM_X0105);
        }
    }
}
