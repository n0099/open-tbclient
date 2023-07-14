package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tha extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public aga b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tha(MainTabActivity mainTabActivity) {
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
        aga agaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && SpeedStatsUtils.UBC_VALUE_SPLASH.equals(customResponsedMessage.getData())) {
            MainTabActivity mainTabActivity = this.a;
            this.b = mainTabActivity.e;
            mainTabActivity.Q1(true);
            if (MainTabActivity.W && (agaVar = this.b) != null && agaVar.h() != null) {
                this.b.h().a();
            }
            aga agaVar2 = this.b;
            if (agaVar2 != null && agaVar2.c() != null) {
                this.b.c().b();
            }
            nka.c().b();
            nka.c().a();
            if (v85.a().f()) {
                v85.a().g(this.a.getClass().getName());
                v85.a().l(false);
            }
            if (v85.a().e()) {
                v85.a().b();
                v85.a().h(this.a.getClass().getName());
                v85.a().k(false);
            }
        }
    }
}
