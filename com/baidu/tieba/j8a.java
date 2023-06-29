package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.switchs.DuTokenNewSwitch;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class j8a extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final p7a b;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(j8a j8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j8aVar};
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && DuTokenNewSwitch.isOn() && PermissionUtil.isAgreePrivacyPolicy()) {
                WordCommandManager.setOnInitialUIReadyState(true);
                WordCommandManager.getInstance().handleClipboardData();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j8a(MainTabActivity mainTabActivity) {
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
                nl.f();
                nl.i();
                this.a.V = UtilHelper.getCurrentDay();
                r95.p().H("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                MainTabActivity mainTabActivity = this.a;
                if (!mainTabActivity.C) {
                    p7a p7aVar = this.b;
                    if (p7aVar != null && p7aVar.j() != null) {
                        this.b.j().b();
                        return;
                    }
                    return;
                }
                mainTabActivity.C = false;
                return;
            }
            bc.b().a("WORDCOMMAND", new a(this));
            String currentDay = UtilHelper.getCurrentDay();
            if (!StringUtils.isNull(currentDay) && !currentDay.equals(this.a.V)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            MainTabActivity mainTabActivity2 = this.a;
            if (mainTabActivity2.x == null) {
                mainTabActivity2.x = new sba();
            }
            sba sbaVar = this.a.x;
            sbaVar.c(sbaVar.c);
            this.a.x.c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_HOT_BOOT;
            if (n36.a()) {
                int i = Calendar.getInstance().get(11);
                n36.a = (i >= 23 || i < 7) ? true : true;
                p7a p7aVar2 = this.b;
                if (p7aVar2 != null && p7aVar2.j() != null) {
                    this.b.j().b();
                    this.b.j().a();
                }
            }
        }
    }
}
