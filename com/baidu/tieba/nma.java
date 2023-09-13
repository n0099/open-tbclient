package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nma extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public q35 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nma(MainTabActivity mainTabActivity, kka kkaVar) {
        super(2921333);
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
            return;
        }
        if (this.b == null && !(customResponsedMessage.getData() instanceof q35)) {
            return;
        }
        if (customResponsedMessage.getData() != null) {
            this.b = (q35) customResponsedMessage.getData();
        }
        if (this.b != null && TbadkCoreApplication.isLogin()) {
            ika ikaVar = this.a.w;
            q35 q35Var = this.b;
            ikaVar.j(q35Var.a, q35Var.b, q35Var.c);
        }
    }
}
