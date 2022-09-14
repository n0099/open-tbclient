package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jr8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final ip8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jr8(MainTabActivity mainTabActivity, ip8 ip8Var) {
        super(2001304);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ip8Var};
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
        this.b = ip8Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ip8 ip8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer) || (ip8Var = this.b) == null || ip8Var.B() == null) {
            return;
        }
        int intValue = ((Integer) customResponsedMessage.getData()).intValue();
        int oldSkinType = TbadkCoreApplication.getInst().getOldSkinType();
        boolean z = false;
        if ((intValue == 2 || oldSkinType == 2) ? false : true) {
            return;
        }
        if ((intValue == 3 || intValue == 1 || intValue == 0) && oldSkinType == 2) {
            z = true;
        }
        if (z) {
            this.b.B().d(1);
        } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.b.B().d(2);
        } else {
            this.b.B().d(1);
        }
    }
}
