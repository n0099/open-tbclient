package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.youngster.utils.YoungsterVerifyUtils;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes7.dex */
public class p0b extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final sza b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(p0b p0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
                WordCommandManager.setOnInitialUIReadyState(true);
                WordCommandManager.getInstance().handleClipboardData();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0b(MainTabActivity mainTabActivity) {
        super(2001011);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean z = false;
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                gg.f();
                gg.i();
                this.a.V = UtilHelper.getCurrentDay();
                SharedPrefHelper.getInstance().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                MainTabActivity mainTabActivity = this.a;
                if (!mainTabActivity.C) {
                    sza szaVar = this.b;
                    if (szaVar != null && szaVar.j() != null) {
                        this.b.j().b();
                        return;
                    }
                    return;
                }
                mainTabActivity.C = false;
                return;
            }
            IdleHandlerManager.getInstance().addOrRunTask("WORDCOMMAND", new a(this));
            String currentDay = UtilHelper.getCurrentDay();
            if (!StringUtils.isNull(currentDay) && !currentDay.equals(this.a.V)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            MainTabActivity mainTabActivity2 = this.a;
            if (mainTabActivity2.x == null) {
                mainTabActivity2.x = new r4b();
            }
            r4b r4bVar = this.a.x;
            r4bVar.c(r4bVar.c);
            this.a.x.c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_HOT_BOOT;
            if (YoungsterVerifyUtils.isYoungsterOpen()) {
                int i = Calendar.getInstance().get(11);
                YoungsterVerifyUtils.isNight = (i >= 23 || i < 7) ? true : true;
                sza szaVar2 = this.b;
                if (szaVar2 != null && szaVar2.j() != null) {
                    this.b.j().b();
                    this.b.j().a();
                }
            }
        }
    }
}
