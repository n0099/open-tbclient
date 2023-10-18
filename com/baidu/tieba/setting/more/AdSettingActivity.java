package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AdSettingActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ShakeAdSwitchData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tieba.R;
import com.baidu.tieba.hz4;
import com.baidu.tieba.i5a;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.setting.im.more.MemberCloseAdHttpResponseMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdRequestMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdSocketResponseMessage;
import com.baidu.tieba.xda;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class AdSettingActivity extends BaseActivity implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int e = 0;
    public static int f = 1;
    public static int g = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public i5a a;
    public int b;
    public BlueCircleProgressDialog c;
    public NetMessageListener d;

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

    /* loaded from: classes8.dex */
    public class a implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                PayPanelUtils.launchPayPanel(this.a.getPageContext(), IMConstants.IM_MSG_TYPE_ADVISORY_ASK_OTHER_HIT_KEY_WORD, MemberPayStatistic.REFER_PAGE_SITE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends NetMessageListener {
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage != null && responsedMessage.getError() != 0) {
                    if (responsedMessage.getError() == 1990043) {
                        this.a.a1();
                    } else if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        this.a.U0();
                        return;
                    } else {
                        this.a.showToast(responsedMessage.getErrorString());
                    }
                    this.a.V0(false);
                    return;
                }
                boolean z = responsedMessage instanceof MemberCloseAdHttpResponseMessage;
                if (!z && !(responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                    this.a.U0();
                    return;
                }
                CloseAdData closeAdData = null;
                if (z) {
                    closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                    closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
                }
                if (closeAdData == null) {
                    this.a.U0();
                    return;
                }
                this.a.Z0(closeAdData.O());
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
        this.c = new BlueCircleProgressDialog(getPageContext());
        this.d = new c(this, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
    }

    public final void Z0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (i == 0) {
                this.a.u();
                currentAccountObj.setMemberCloseAdVipClose(0);
            } else {
                this.a.x();
                currentAccountObj.setMemberCloseAdVipClose(1);
            }
            this.b = g;
            this.c.setDialogVisiable(false);
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
            this.a = new i5a(this);
            S0();
            registerListener(this.d);
            initData();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void z(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, view2, switchState) == null) && view2 != null && this.a != null) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                TiebaStatic.log("c11143");
                T0(1);
                return;
            }
            T0(0);
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xda.h(309348, MemberCloseAdSocketResponseMessage.class, false, false);
            xda.c(309348, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            V0(true);
        }
    }

    public final void initData() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(AdSettingActivityConfig.KEY_SHOW_SHAKE_AD_DATA);
        if (serializableExtra instanceof ShakeAdSwitchData) {
            this.a.y((ShakeAdSwitchData) serializableExtra);
        }
    }

    public void T0(int i) {
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
        this.c.setTipString(R.string.setting_submiting);
        this.c.setDialogVisiable(true);
    }

    public final void V0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            int i = this.b;
            if (i == e) {
                this.a.x();
            } else if (i == f) {
                this.a.u();
            }
            if (z) {
                showToast(R.string.setdefualt_error);
            }
            this.b = g;
            this.c.setDialogVisiable(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            hz4 hz4Var = new hz4(getPageContext().getPageActivity());
            hz4Var.setMessageId(R.string.mebmer_close_ad_dialog_message);
            hz4Var.setButtonTextColor(R.color.CAM_X0305);
            hz4Var.setPositiveButton(R.string.open_now, new a(this));
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new b(this));
            hz4Var.create(getPageContext()).show();
        }
    }
}
