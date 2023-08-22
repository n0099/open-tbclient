package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zka extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public eja b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zka(MainTabActivity mainTabActivity) {
        super(2921736);
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
        eja ejaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && SpeedStatsUtils.UBC_VALUE_SPLASH.equals(customResponsedMessage.getData())) {
            MainTabActivity mainTabActivity = this.a;
            this.b = mainTabActivity.e;
            mainTabActivity.N1(true);
            if (MainTabActivity.W && (ejaVar = this.b) != null && ejaVar.h() != null) {
                this.b.h().a();
            }
            eja ejaVar2 = this.b;
            if (ejaVar2 != null && ejaVar2.c() != null) {
                this.b.c().b();
            }
            coa.c().b();
            coa.c().a();
            if (v75.a().f()) {
                v75.a().g(this.a.getClass().getName());
                v75.a().l(false);
            }
            if (v75.a().e()) {
                v75.a().b();
                v75.a().h(this.a.getClass().getName());
                v75.a().k(false);
            }
        }
    }
}
