package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vp8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public ho8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vp8(MainTabActivity mainTabActivity) {
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
        ho8 ho8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
            return;
        }
        MainTabActivity mainTabActivity = this.a;
        this.b = mainTabActivity.f;
        mainTabActivity.c1(true);
        if (MainTabActivity.X && (ho8Var = this.b) != null && ho8Var.i() != null) {
            this.b.i().a();
        }
        ho8 ho8Var2 = this.b;
        if (ho8Var2 != null && ho8Var2.d() != null) {
            this.b.d().b();
        }
        ho8 ho8Var3 = this.b;
        if (ho8Var3 != null && ho8Var3.a() != null) {
            this.b.a().l();
            this.b.a().m();
        }
        if (gt4.a().f()) {
            gt4.a().g(this.a.getClass().getName());
            gt4.a().l(false);
        }
        if (gt4.a().e()) {
            gt4.a().b();
            gt4.a().h(this.a.getClass().getName());
            gt4.a().k(false);
        }
    }
}
