package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.setting.more.AdSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tl8 extends p9<AdSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdSettingActivity a;
    public View b;
    public NavigationBar c;
    public MsgSettingItemView d;
    public TextView e;
    public ImageView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tl8(AdSettingActivity adSettingActivity) {
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
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adSettingActivity;
        k();
    }

    public final void g() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d.setText(R.string.obfuscated_res_0x7f0f0b19);
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

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d006f);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f00a9));
            this.d = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f09157e);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09157f);
            this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0902c9);
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091835);
            g();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.e();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.g();
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            tq4 layoutMode = this.a.getLayoutMode();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.b);
            this.c.onChangeSkinType(getPageContext(), i);
            this.d.c(this.a.getPageContext(), i);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
