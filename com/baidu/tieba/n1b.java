package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n1b extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public sza b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1b(MainTabActivity mainTabActivity) {
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
        sza szaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && SpeedStatsUtils.UBC_VALUE_SPLASH.equals(customResponsedMessage.getData())) {
            MainTabActivity mainTabActivity = this.a;
            this.b = mainTabActivity.e;
            mainTabActivity.I1(true);
            if (MainTabActivity.W && (szaVar = this.b) != null && szaVar.h() != null) {
                this.b.h().a();
            }
            sza szaVar2 = this.b;
            if (szaVar2 != null && szaVar2.c() != null) {
                this.b.c().b();
            }
            v4b.c().b();
            v4b.c().a();
            if (r35.a().f()) {
                r35.a().g(this.a.getClass().getName());
                r35.a().l(false);
            }
            if (r35.a().e()) {
                r35.a().b();
                r35.a().h(this.a.getClass().getName());
                r35.a().k(false);
            }
        }
    }
}
