package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tp8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public fo8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tp8(MainTabActivity mainTabActivity) {
        super(2921636);
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
        this.b = mainTabActivity.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        fo8 fo8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
            return;
        }
        MainTabActivity mainTabActivity = this.a;
        this.b = mainTabActivity.f;
        mainTabActivity.c1(true);
        if (MainTabActivity.X && (fo8Var = this.b) != null && fo8Var.i() != null) {
            this.b.i().a();
        }
        fo8 fo8Var2 = this.b;
        if (fo8Var2 != null && fo8Var2.d() != null) {
            this.b.d().b();
        }
        fo8 fo8Var3 = this.b;
        if (fo8Var3 != null && fo8Var3.a() != null) {
            this.b.a().l();
            this.b.a().m();
        }
        if (ft4.a().f()) {
            ft4.a().g(this.a.getClass().getName());
            ft4.a().l(false);
        }
        if (ft4.a().e()) {
            ft4.a().b();
            ft4.a().h(this.a.getClass().getName());
            ft4.a().k(false);
        }
    }
}
