package com.baidu.tieba.immessagecenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.gs7;
import com.baidu.tieba.p35;
import com.baidu.tieba.qv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class InvatateAnswerSettingActivity extends BaseActivity<InvatateAnswerSettingActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gs7 a;

    public InvatateAnswerSettingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: com.baidu.tieba.p35 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: com.baidu.tieba.gs7 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void d0(View view2, BdSwitchView.SwitchState switchState) {
        gs7 gs7Var;
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView;
        ?? r5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) && view2 != null && (gs7Var = this.a) != null && (personalTalkSettingViewSettingView = gs7Var.n) != null && view2 == personalTalkSettingViewSettingView.getChatNeglectSwitch()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                r5 = 1;
            } else {
                r5 = 0;
            }
            p35.m().w("key_question_msg_no_remind", r5);
            this.a.c(r5);
            new StatisticItem(CommonStatisticKey.KEY_QUESTION_MSG_NO_SHIELD).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", (int) r5).eventStat();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921727, Boolean.valueOf((boolean) r5)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            qv4 layoutMode = getLayoutMode();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.a.a(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            gs7 gs7Var = new gs7(this);
            this.a = gs7Var;
            gs7Var.b(this);
        }
    }
}
