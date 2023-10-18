package com.baidu.tieba;

import android.os.Build;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tieba.downloadball.DownloadFloatBallManager;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tja extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final uha b;
    public final gha c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tja(MainTabActivity mainTabActivity, gha ghaVar) {
        super(2001371);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ghaVar};
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
        this.c = ghaVar;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && TbadkCoreApplication.getInst().isMainProcess(false) && Build.VERSION.SDK_INT > 25) {
            if (UbsABTestHelper.isAdNotInstallRemindA()) {
                xe1<uc5> a = new xc5().a();
                if (a != null && a.get() != null) {
                    a.get().a();
                    return;
                }
                return;
            }
            hh0.l().p();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !MainTabActivity.W) {
            g();
            vs5.a(1);
            pa5.u(HotEventData.getInstance());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        uha uhaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
            h();
            TbadkCoreApplication.getInst().syncHasFinish = true;
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                if (!TbSingleton.getInstance().mIsSplashClick && (uhaVar = this.b) != null && uhaVar.b() != null) {
                    this.b.b().a();
                }
                uha uhaVar2 = this.b;
                if (uhaVar2 != null && uhaVar2.h() != null) {
                    this.b.h().a();
                }
            }
            if (!MainTabActivity.W) {
                new rq5(this.a).m();
            }
            yja O = this.a.O();
            if (O != null) {
                O.b();
            }
            if (SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_new_god_pop_is_show"), false)) {
                PersonRedTipManager.getInstance().updateRedTipState(11, true, true);
            }
            MainTabActivity.W = true;
            this.c.T();
            DownloadFloatBallManager.l().s(false, true);
        }
    }
}
