package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tieba.R;
import com.baidu.tieba.fh8;
import com.baidu.tieba.pu4;
import com.baidu.tieba.qb;
import com.baidu.tieba.setting.im.more.MemberCloseAdHttpResponseMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdRequestMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdSocketResponseMessage;
import com.baidu.tieba.yx4;
import com.baidu.tieba.zm8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AdSettingActivity extends BaseActivity implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int e = 0;
    public static int f = 1;
    public static int g = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public fh8 a;
    public int b;
    public yx4 c;
    public qb d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(729576364, "Lcom/baidu/tieba/setting/more/AdSettingActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(729576364, "Lcom/baidu/tieba/setting/more/AdSettingActivity;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdSettingActivity a;

        public a(AdSettingActivity adSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adSettingActivity;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.getPageContext().getPageActivity(), 2, "", 20);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_SITE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdSettingActivity a;

        public b(AdSettingActivity adSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adSettingActivity;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdSettingActivity adSettingActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adSettingActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adSettingActivity;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage != null && responsedMessage.getError() != 0) {
                    if (responsedMessage.getError() != 1990043) {
                        if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                            this.a.showToast(responsedMessage.getErrorString());
                        } else {
                            this.a.E1();
                            return;
                        }
                    } else {
                        this.a.H1();
                    }
                    this.a.F1(false);
                    return;
                }
                boolean z = responsedMessage instanceof MemberCloseAdHttpResponseMessage;
                if (z || (responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                    CloseAdData closeAdData = null;
                    if (z) {
                        closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
                    } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                        closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
                    }
                    if (closeAdData != null) {
                        this.a.G1(closeAdData.A());
                        return;
                    }
                    this.a.E1();
                    return;
                }
                this.a.E1();
            }
        }
    }

    public AdSettingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = g;
        this.c = new yx4(getPageContext());
        this.d = new c(this, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void i0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, switchState) == null) && view2 != null && this.a != null) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                TiebaStatic.log("c11143");
                D1(1);
                return;
            }
            D1(0);
        }
    }

    public final void G1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (i == 0) {
                this.a.l();
                currentAccountObj.setMemberCloseAdVipClose(0);
            } else {
                this.a.m();
                currentAccountObj.setMemberCloseAdVipClose(1);
            }
            this.b = g;
            this.c.h(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            super.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new fh8(this);
            C1();
            registerListener(this.d);
        }
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            zm8.h(309348, MemberCloseAdSocketResponseMessage.class, false, false);
            zm8.c(309348, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F1(true);
        }
    }

    public void D1(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || this.b != g) {
            return;
        }
        if (i == 0) {
            this.b = e;
        } else {
            this.b = f;
        }
        MemberCloseAdRequestMessage memberCloseAdRequestMessage = new MemberCloseAdRequestMessage(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
        memberCloseAdRequestMessage.setVipClose(i);
        MessageManager.getInstance().sendMessage(memberCloseAdRequestMessage);
        this.c.i(R.string.obfuscated_res_0x7f0f1155);
        this.c.h(true);
    }

    public final void F1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            int i = this.b;
            if (i == e) {
                this.a.m();
            } else if (i == f) {
                this.a.l();
            }
            if (z) {
                showToast(R.string.obfuscated_res_0x7f0f1152);
            }
            this.b = g;
            this.c.h(false);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            pu4 pu4Var = new pu4(getPageContext().getPageActivity());
            pu4Var.setMessageId(R.string.obfuscated_res_0x7f0f0ad3);
            pu4Var.setButtonTextColor(R.color.CAM_X0305);
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d24, new a(this));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(this));
            pu4Var.create(getPageContext()).show();
        }
    }
}
