package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class lk6 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsActivity a;
    public rt6 b;
    public st6 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lk6(FrsActivity frsActivity) {
        super(2921728);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity};
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
        this.a = frsActivity;
        rt6 rt6Var = new rt6(frsActivity);
        this.b = rt6Var;
        rt6Var.F(true);
        st6 st6Var = new st6(frsActivity);
        this.c = st6Var;
        st6Var.F(true);
        PriorityOrganizer.m(this.b, this.c);
        setPriority(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921728) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            BdUniqueId bdUniqueId = null;
            if (currentActivity instanceof BdBaseFragmentActivity) {
                bdUniqueId = ((BdBaseFragmentActivity) currentActivity).getUniqueId();
            }
            if (getTag() == bdUniqueId && !this.b.v(true)) {
                this.b.E(true);
                this.a.d0().t(this.b);
            }
        }
    }
}
