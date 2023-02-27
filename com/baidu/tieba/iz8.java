package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.setting.privacy.PrivacyMarkActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class iz8 extends v9<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x9<?> a;
    public View b;
    public NavigationBar c;
    public TextView d;
    public TextView e;
    public BdSwitchView f;
    public TextView g;
    public TextView h;
    public BdSwitchView i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* loaded from: classes4.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz8 a;

        public a(iz8 iz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz8Var;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void d0(View view2, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                int i = 3;
                boolean z = false;
                int i2 = 1;
                if (view2 == this.a.f) {
                    iz8 iz8Var = this.a;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        z = true;
                    }
                    iz8Var.k = z;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        i = 1;
                    }
                    this.a.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, i));
                } else if (view2 == this.a.i) {
                    iz8 iz8Var2 = this.a;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        z = true;
                    }
                    iz8Var2.j = z;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        i = 1;
                    }
                    this.a.a.sendMessage(new PrivacySettingMessage("bazhu_show_outside", i));
                }
                StatisticItem param = new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount());
                if (view2 != this.a.f) {
                    i2 = 2;
                }
                TiebaStatic.log(param.param("obj_type", i2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iz8(x9<PrivacyMarkActivity> x9Var, int i) {
        super(x9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x9Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((x9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.a = x9Var;
        q(x9Var.getPageActivity(), i);
        r();
    }

    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.k;
            this.k = z;
            if (z) {
                this.f.m();
            } else {
                this.f.j();
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.j;
            this.j = z;
            if (z) {
                this.i.m();
            } else {
                this.i.j();
            }
        }
    }

    public final void q(Context context, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0799, (ViewGroup) null);
            this.b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.obfuscated_res_0x7f0f0fd4));
            this.c.showBottomLine();
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091071);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09106e);
            this.f = (BdSwitchView) this.b.findViewById(R.id.obfuscated_res_0x7f09106f);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0918c9);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0918c6);
            this.i = (BdSwitchView) this.b.findViewById(R.id.obfuscated_res_0x7f0918c7);
            this.d.setText(R.string.obfuscated_res_0x7f0f0b58);
            this.e.setText(R.string.obfuscated_res_0x7f0f0b57);
            this.g.setText(R.string.obfuscated_res_0x7f0f0b59);
            this.h.setText(R.string.obfuscated_res_0x7f0f0b5a);
            int i2 = i & 3;
            int i3 = (i >> 2) & 3;
            if (i2 == 3) {
                this.i.j();
            } else {
                this.i.m();
            }
            if (i3 == 3) {
                this.f.j();
            } else {
                this.f.m();
            }
            boolean z2 = true;
            if (i2 != 3) {
                z = true;
            } else {
                z = false;
            }
            this.j = z;
            if (i3 == 3) {
                z2 = false;
            }
            this.k = z2;
            this.f.setOnSwitchStateChangeListener(this.l);
            this.i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0109);
            this.c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
