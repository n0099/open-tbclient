package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yma extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yma(MainTabActivity mainTabActivity, kka kkaVar) {
        super(2016493);
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
        wh5 wh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof wh5) && (wh5Var = (wh5) customResponsedMessage.getData()) != null && !StringUtils.isNull(wh5Var.a)) {
            bx5.h(wh5Var);
            if (StringUtils.isNull(wh5Var.c)) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{wh5Var.a});
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{wh5Var.a, wh5Var.c});
            }
        }
    }
}
