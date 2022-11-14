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
/* loaded from: classes5.dex */
public class mj8 extends p9<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r9<?> a;
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

    /* loaded from: classes5.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mj8 a;

        public a(mj8 mj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mj8Var;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void h0(View view2, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                int i = 3;
                boolean z = false;
                int i2 = 1;
                if (view2 == this.a.f) {
                    mj8 mj8Var = this.a;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        z = true;
                    }
                    mj8Var.k = z;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        i = 1;
                    }
                    this.a.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, i));
                } else if (view2 == this.a.i) {
                    mj8 mj8Var2 = this.a;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        z = true;
                    }
                    mj8Var2.j = z;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        i = 1;
                    }
                    this.a.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, i));
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
    public mj8(r9<PrivacyMarkActivity> r9Var, int i) {
        super(r9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.a = r9Var;
        p(r9Var.getPageActivity(), i);
        q();
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void r() {
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

    public void s() {
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

    public final void p(Context context, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d076a, (ViewGroup) null);
            this.b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f09168f);
            this.c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.obfuscated_res_0x7f0f0f49));
            this.c.showBottomLine();
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090f6b);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090f68);
            this.f = (BdSwitchView) this.b.findViewById(R.id.obfuscated_res_0x7f090f69);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0917b6);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0917b3);
            this.i = (BdSwitchView) this.b.findViewById(R.id.obfuscated_res_0x7f0917b4);
            this.d.setText(R.string.obfuscated_res_0x7f0f0acf);
            this.e.setText(R.string.obfuscated_res_0x7f0f0ace);
            this.g.setText(R.string.obfuscated_res_0x7f0f0ad0);
            this.h.setText(R.string.obfuscated_res_0x7f0f0ad1);
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

    public void q() {
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
