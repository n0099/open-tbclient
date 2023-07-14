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
public class sha extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final pfa b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sha(MainTabActivity mainTabActivity, pfa pfaVar) {
        super(2001304);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, pfaVar};
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
        this.b = pfaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        pfa pfaVar;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (pfaVar = this.b) != null && pfaVar.y() != null) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            int oldSkinType = TbadkCoreApplication.getInst().getOldSkinType();
            boolean z2 = false;
            if (intValue != 2 && oldSkinType != 2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            if ((intValue == 3 || intValue == 0) && oldSkinType == 2) {
                z2 = true;
            }
            if (z2) {
                this.b.y().e(1);
            } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.b.y().e(2);
            } else {
                this.b.y().e(1);
            }
        }
    }
}
