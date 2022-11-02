package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nt8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public zr8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nt8(MainTabActivity mainTabActivity) {
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
        zr8 zr8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && SpeedStatsUtils.UBC_VALUE_SPLASH.equals(customResponsedMessage.getData())) {
            MainTabActivity mainTabActivity = this.a;
            this.b = mainTabActivity.e;
            mainTabActivity.j1(true);
            if (MainTabActivity.W && (zr8Var = this.b) != null && zr8Var.h() != null) {
                this.b.h().a();
            }
            zr8 zr8Var2 = this.b;
            if (zr8Var2 != null && zr8Var2.c() != null) {
                this.b.c().b();
            }
            if (dx4.a().f()) {
                dx4.a().g(this.a.getClass().getName());
                dx4.a().l(false);
            }
            if (dx4.a().e()) {
                dx4.a().b();
                dx4.a().h(this.a.getClass().getName());
                dx4.a().k(false);
            }
        }
    }
}
