package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
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
import com.baidu.tieba.setting.im.more.MemberCloseAdHttpResponseMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdRequestMessage;
import com.baidu.tieba.setting.im.more.MemberCloseAdSocketResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hj8;
import com.repackage.ku4;
import com.repackage.nr4;
import com.repackage.wa;
import com.repackage.yc8;
/* loaded from: classes4.dex */
public class AdSettingActivity extends BaseActivity implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int NO_SET_MEMBER_CLOSE_AD = -1;
    public static int SET_MEMBER_CLOSE_AD_FALSE = 0;
    public static int SET_MEMBER_CLOSE_AD_TRUE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public wa mMemberCloseAdListener;
    public int mMemberCloseAdSettingState;
    public yc8 mView;
    public ku4 mWaitingDialog;

    /* loaded from: classes4.dex */
    public class a implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.getPageContext().getPageActivity(), 2, "", 20);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_SITE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends wa {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage != null && responsedMessage.getError() != 0) {
                    if (responsedMessage.getError() == 1990043) {
                        this.a.showMemberDialog();
                    } else if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        this.a.setMemberCloseAdFail();
                        return;
                    } else {
                        this.a.showToast(responsedMessage.getErrorString());
                    }
                    this.a.setMemberCloseAdFail(false);
                    return;
                }
                boolean z = responsedMessage instanceof MemberCloseAdHttpResponseMessage;
                if (!z && !(responsedMessage instanceof MemberCloseAdSocketResponseMessage)) {
                    this.a.setMemberCloseAdFail();
                    return;
                }
                CloseAdData closeAdData = null;
                if (z) {
                    closeAdData = ((MemberCloseAdHttpResponseMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof MemberCloseAdSocketResponseMessage) {
                    closeAdData = ((MemberCloseAdSocketResponseMessage) responsedMessage).getData();
                }
                if (closeAdData == null) {
                    this.a.setMemberCloseAdFail();
                    return;
                }
                this.a.setMemberCloseAdSuccess(closeAdData.z());
            }
        }
    }

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
        this.mMemberCloseAdSettingState = NO_SET_MEMBER_CLOSE_AD;
        this.mWaitingDialog = new ku4(getPageContext());
        this.mMemberCloseAdListener = new c(this, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemberCloseAdFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            setMemberCloseAdFail(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemberCloseAdSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (i == 0) {
                this.mView.h();
                currentAccountObj.setMemberCloseAdVipClose(0);
            } else {
                this.mView.i();
                currentAccountObj.setMemberCloseAdVipClose(1);
            }
            this.mMemberCloseAdSettingState = NO_SET_MEMBER_CLOSE_AD;
            this.mWaitingDialog.h(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void showMemberDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            nr4 nr4Var = new nr4(getPageContext().getPageActivity());
            nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0aa2);
            nr4Var.setButtonTextColor(R.color.CAM_X0305);
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ce6, new a(this));
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new b(this));
            nr4Var.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) || view2 == null || this.mView == null) {
            return;
        }
        if (BdSwitchView.SwitchState.ON == switchState) {
            TiebaStatic.log("c11143");
            sendMessageToCloseAd(1);
            return;
        }
        sendMessageToCloseAd(0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new yc8(this);
            registerTask();
            registerListener(this.mMemberCloseAdListener);
        }
    }

    public void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hj8.h(309348, MemberCloseAdSocketResponseMessage.class, false, false);
            hj8.c(309348, CmdConfigHttp.CMD_MEMBER_CLOSE_AD, TbConfig.SET_MEMBER_CLOSE_AD, MemberCloseAdHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void sendMessageToCloseAd(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.mMemberCloseAdSettingState == NO_SET_MEMBER_CLOSE_AD) {
            if (i == 0) {
                this.mMemberCloseAdSettingState = SET_MEMBER_CLOSE_AD_FALSE;
            } else {
                this.mMemberCloseAdSettingState = SET_MEMBER_CLOSE_AD_TRUE;
            }
            MemberCloseAdRequestMessage memberCloseAdRequestMessage = new MemberCloseAdRequestMessage(CmdConfigHttp.CMD_MEMBER_CLOSE_AD, 309348);
            memberCloseAdRequestMessage.setVipClose(i);
            MessageManager.getInstance().sendMessage(memberCloseAdRequestMessage);
            this.mWaitingDialog.i(R.string.obfuscated_res_0x7f0f1122);
            this.mWaitingDialog.h(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemberCloseAdFail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            int i = this.mMemberCloseAdSettingState;
            if (i == SET_MEMBER_CLOSE_AD_FALSE) {
                this.mView.i();
            } else if (i == SET_MEMBER_CLOSE_AD_TRUE) {
                this.mView.h();
            }
            if (z) {
                showToast(R.string.obfuscated_res_0x7f0f1113);
            }
            this.mMemberCloseAdSettingState = NO_SET_MEMBER_CLOSE_AD;
            this.mWaitingDialog.h(false);
        }
    }
}
