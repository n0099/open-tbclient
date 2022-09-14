package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xq8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final ip8 b;
    public sr8 c;
    public tr8 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xq8(MainTabActivity mainTabActivity, ip8 ip8Var) {
        super(2921728);
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
        this.c = new sr8(mainTabActivity.getPageContext(), ip8Var, mainTabActivity);
        tr8 tr8Var = new tr8(mainTabActivity.getPageContext(), ip8Var, mainTabActivity);
        this.d = tr8Var;
        PriorityOrganizer.s(this.c, tr8Var);
        setPriority(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ip8 ip8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921728 || (ip8Var = this.b) == null || ip8Var.B() == null) {
            return;
        }
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (getTag() == (currentActivity instanceof BdBaseFragmentActivity ? ((BdBaseFragmentActivity) currentActivity).getUniqueId() : null) && !this.c.w(true)) {
            this.c.F(true);
            this.a.d0().v(this.c);
        }
    }
}
