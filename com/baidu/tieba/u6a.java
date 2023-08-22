package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ShakeAdSwitchData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.setting.more.AdSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u6a extends BdBaseView<AdSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdSettingActivity a;
    public View b;
    public NavigationBar c;
    public MsgSettingItemView d;
    public TextView e;
    public ImageView f;
    public ShakeAdSwitchData g;
    public MsgSettingItemView h;

    /* loaded from: classes8.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(u6a u6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u6aVar};
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
        public void U(View view2, BdSwitchView.SwitchState switchState) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                if (BdSwitchView.SwitchState.ON == switchState) {
                    z = true;
                } else {
                    z = false;
                }
                sharedPrefHelper.putBoolean("key_splash_shake_ad_open", z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u6a(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adSettingActivity};
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
        this.a = adSettingActivity;
        y();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d.g();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d.e();
        }
    }

    public void D(ShakeAdSwitchData shakeAdSwitchData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shakeAdSwitchData) == null) {
            this.g = shakeAdSwitchData;
            x();
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.b);
            this.c.onChangeSkinType(getPageContext(), i);
            this.d.c(this.a.getPageContext(), i);
            this.h.c(this.a.getPageContext(), i);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public final void u() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.setText(R.string.obfuscated_res_0x7f0f0c63);
            this.d.setOnSwitchStateChangeListener(this.a);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            int i2 = 0;
            if (currentAccountObj != null) {
                i2 = currentAccountObj.getMemberCloseAdIsOpen();
                i = currentAccountObj.getMemberCloseAdVipClose();
            } else {
                i = 0;
            }
            if (i2 == 0) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
            } else if (i == 0) {
                this.d.e();
            } else {
                this.d.g();
            }
        }
    }

    public final void x() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (msgSettingItemView = this.h) == null) {
            return;
        }
        ShakeAdSwitchData shakeAdSwitchData = this.g;
        if (shakeAdSwitchData != null && shakeAdSwitchData.isShow != 0) {
            msgSettingItemView.setVisibility(0);
            this.h.setTextStr(this.g.title);
            this.h.setTipTextStr(this.g.desc);
            if (SharedPrefHelper.getInstance().getBoolean("key_splash_shake_ad_open", true)) {
                this.h.g();
            } else {
                this.h.e();
            }
            this.h.setOnSwitchStateChangeListener(new a(this));
            return;
        }
        this.h.setVisibility(8);
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0074);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d5));
            this.d = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f091722);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091723);
            this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0902c9);
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091a55);
            this.h = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f0921b5);
            u();
        }
    }
}
