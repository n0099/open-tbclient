package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tieba.interest.InterestPanelShowManager;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public boolean b;

    public k1a(MainTabActivity mainTabActivity, a1a a1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, a1aVar};
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
        n95.m().A("key_app_launch_time", System.currentTimeMillis());
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
            return;
        }
        TbSingleton.getInstance().setHasPerformedFirstLoginTest(true);
        if (UbsABTestHelper.isFirstLoginTestA()) {
            if (!TbadkCoreApplication.isLogin() && !LoginActivity.class.getName().equals(vi.y())) {
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
            Activity b = g9.f().b();
            if (b != null) {
                str = b.getLocalClassName();
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

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || TbSingleton.getInstance().hasPerformInterestPanelShow) {
            return;
        }
        TbSingleton.getInstance().hasPerformInterestPanelShow = true;
        if (TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
            InterestPanelShowManager.a().d(this.a);
            TbSingleton.getInstance();
            TbSingleton.setExceptInsertAdDiaShow(true);
        }
        n95.m().A("key_app_launch_time", System.currentTimeMillis());
        b();
        if (!UbsABTestHelper.isFirstLoginTestA() && !UbsABTestHelper.isFirstLoginTestB() && !TbadkApplication.getInst().isNeedNewUserLead()) {
            InterestPanelShowManager.a().d(this.a);
            TbSingleton.getInstance();
            TbSingleton.setExceptInsertAdDiaShow(true);
        }
        if (UbsABTestHelper.isFirstLoginTestB() && !TbadkApplication.getInst().isNeedNewUserLead()) {
            InterestPanelShowManager.a().d(this.a);
            TbSingleton.getInstance();
            TbSingleton.setExceptInsertAdDiaShow(true);
        }
    }
}
