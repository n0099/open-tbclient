package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public boolean b;

    public rea(MainTabActivity mainTabActivity, hea heaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, heaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b) {
            return;
        }
        if (c() && TbSingleton.getInstance().hasPerformedFirstLoginTest() && TbSingleton.getInstance().isNeedShowInterestGuide()) {
            this.b = true;
            InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(this.a);
            if (TbSingleton.getInstance().triggerInterestPanelYDaysConfig) {
                interestGuideActivityConfig.setCustomTitle(new String[]{this.a.getResources().getString(R.string.interest_main_title), this.a.getResources().getString(R.string.interest_select_second_title), this.a.getResources().getString(R.string.interest_forum_second_title)});
                interestGuideActivityConfig.setScene(10);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
            TbSingleton.getInstance();
            TbSingleton.setExceptInsertAdDiaShow(true);
        }
        SharedPrefHelper.getInstance().putLong("key_app_launch_time", System.currentTimeMillis());
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
            return;
        }
        TbSingleton.getInstance().setHasPerformedFirstLoginTest(true);
        if (UbsABTestHelper.isFirstLoginTestA()) {
            if (!TbadkCoreApplication.isLogin() && !LoginActivity.class.getName().equals(BdUtilHelper.getTopActivityName())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921535, this));
                TbSingleton.getInstance();
                TbSingleton.setExceptInsertAdDiaShow(true);
            }
        } else if (UbsABTestHelper.isFirstLoginTestB()) {
            if (TbadkApplication.getInst().isNeedNewUserLead()) {
                InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(this.a, 4);
                interestGuideActivityConfig.setRequestCode(25060);
                interestGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
                TbSingleton.getInstance();
                TbSingleton.setExceptInsertAdDiaShow(true);
            }
        } else if (TbadkApplication.getInst().isNeedNewUserLead()) {
            InterestGuideActivityConfig interestGuideActivityConfig2 = new InterestGuideActivityConfig(this.a, 4);
            interestGuideActivityConfig2.setRequestCode(25060);
            interestGuideActivityConfig2.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig2));
            TbSingleton.getInstance();
            TbSingleton.setExceptInsertAdDiaShow(true);
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Activity currentActivity = BdActivityStack.getInst().currentActivity();
            if (currentActivity != null) {
                str = currentActivity.getLocalClassName();
            } else {
                str = "";
            }
            if (!str.contains("MainTabActivity") && !str.contains("FrsActivity") && !str.contains("PbActivity") && !str.contains("NewSquareSearchActivity") && !str.contains("PbCommentFloatActivity")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
