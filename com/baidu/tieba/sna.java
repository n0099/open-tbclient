package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
/* loaded from: classes8.dex */
public class sna extends BdBaseView<SystemHelpSettingActivity> {
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

    /* loaded from: classes8.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sna a;

        public a(sna snaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {snaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = snaVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void A(View view2, BdSwitchView.SwitchState switchState) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) && view2 == this.a.h.getSwitchView()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    z = true;
                } else {
                    z = false;
                }
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                this.a.a.K0("recnbar", z ^ true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sna(SystemHelpSettingActivity systemHelpSettingActivity) {
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
                super((BdPageContext) newInitContext.callArgs[0]);
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
        systemHelpSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d097d);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.q = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f160d));
        this.q.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090765);
        this.c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.c.setOnClickListener(this.a);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090766);
        this.d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.d.setOnClickListener(this.a);
        this.e = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f09125d);
        BdUtilHelper.addToParentArea(this.a.getPageContext().getPageActivity(), this.e, 10, 10, 10, 10);
        this.e.setOnSwitchStateChangeListener(this.a);
        this.f = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f09227d);
        BdUtilHelper.addToParentArea(this.a.getPageContext().getPageActivity(), this.f, 10, 10, 10, 10);
        this.f.setOnSwitchStateChangeListener(this.a);
        this.i = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0908ab);
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092459);
        this.k = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09245b);
        this.l = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09245a);
        this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091241);
        this.m = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091242);
        this.n = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092458);
        if (GlobalBuildConfig.isTiebaDebugTool()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.i.c();
        this.i.setOnClickListener(this.a);
        this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091b42);
        if (TbadkCoreApplication.isLogin()) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.obfuscated_res_0x7f092415);
        this.g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.a);
        this.g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f091f34);
        this.h = msgSettingItemView;
        msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f1186);
        this.h.setOnSwitchStateChangeListener(this.r);
        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
        G(sharedPrefHelper.getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
        this.p = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f092901);
        if (UploadLogButtonSwitch.isOn()) {
            this.p.setVisibility(0);
            this.p.c();
            this.p.setOnClickListener(this.a);
            return;
        }
        this.p.setVisibility(8);
    }

    public void G(boolean z) {
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

    public BdSwitchView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (TbSettingTextNewDotView) invokeV.objValue;
    }

    public TbSettingTextTipView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.p;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView F() {
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
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.b);
            this.q.onChangeSkinType(getPageContext(), i);
            this.e.b();
            this.f.b();
            this.h.c(this.a.getPageContext(), i);
            SkinManager.setBackgroundResource(this.c, R.drawable.more_all);
            EMManager.from(this.j).setTextColor(R.color.CAM_X0205);
            EMManager.from(this.k).setTextColor(R.color.CAM_X0205);
            EMManager.from(this.l).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.m).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.n).setTextColor(R.color.CAM_X0108);
            EMManager.from(this.o).setTextColor(R.color.CAM_X0105);
        }
    }
}
