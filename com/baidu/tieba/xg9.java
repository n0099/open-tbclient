package com.baidu.tieba;

import android.os.Build;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tieba.downloadball.DownloadFloatBallManager;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xg9 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final df9 b;
    public final se9 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xg9(MainTabActivity mainTabActivity, se9 se9Var) {
        super(2001371);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, se9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = mainTabActivity.e;
        this.c = se9Var;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && TbadkCoreApplication.getInst().isMainProcess(false) && Build.VERSION.SDK_INT > 25) {
            zk0.l().p();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !MainTabActivity.Y) {
            if (UbsABTestHelper.isAdRetargetNotificationRemindTest()) {
                a();
            }
            lq5.a(1);
            h95.i(HotEventData.getInstance());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        df9 df9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
            b();
            TbadkCoreApplication.getInst().syncHasFinish = true;
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                if (!TbSingleton.getInstance().mIsSplashClick && (df9Var = this.b) != null && df9Var.b() != null) {
                    if (UbsABTestHelper.isNewInterestShowTestA()) {
                        this.b.b().d();
                    } else {
                        this.b.b().a();
                    }
                }
                df9 df9Var2 = this.b;
                if (df9Var2 != null && df9Var2.h() != null) {
                    this.b.h().a();
                }
            }
            if (!MainTabActivity.Y && UbsABTestHelper.isAdRetargetTipsRemindTest()) {
                new go5(this.a).o();
            }
            ch9 B1 = this.a.B1();
            if (B1 != null) {
                B1.c();
            }
            if (m35.m().i(m35.q("key_new_god_pop_is_show"), false)) {
                PersonRedTipManager.getInstance().updateRedTipState(11, true, true);
            }
            MainTabActivity.Y = true;
            this.c.O();
            DownloadFloatBallManager.k().r(false, true);
        }
    }
}
