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
public class xma extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final yka b;
    public final kka c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xma(MainTabActivity mainTabActivity, kka kkaVar) {
        super(2001371);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, kkaVar};
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
        this.c = kkaVar;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && TbadkCoreApplication.getInst().isMainProcess(false) && Build.VERSION.SDK_INT > 25) {
            if (UbsABTestHelper.isAdNotInstallRemindA()) {
                ok1<ki5> a = new ni5().a();
                if (a != null && a.get() != null) {
                    a.get().a();
                    return;
                }
                return;
            }
            lm0.l().p();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !MainTabActivity.X) {
            g();
            my5.a(1);
            eg5.u(HotEventData.getInstance());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        yka ykaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
            h();
            TbadkCoreApplication.getInst().syncHasFinish = true;
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                if (!TbSingleton.getInstance().mIsSplashClick && (ykaVar = this.b) != null && ykaVar.b() != null) {
                    this.b.b().a();
                }
                yka ykaVar2 = this.b;
                if (ykaVar2 != null && ykaVar2.h() != null) {
                    this.b.h().a();
                }
            }
            if (!MainTabActivity.X) {
                new jw5(this.a).m();
            }
            cna T2 = this.a.T();
            if (T2 != null) {
                T2.b();
            }
            if (SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_new_god_pop_is_show"), false)) {
                PersonRedTipManager.getInstance().updateRedTipState(11, true, true);
            }
            MainTabActivity.X = true;
            this.c.T();
            DownloadFloatBallManager.l().s(false, true);
        }
    }
}
