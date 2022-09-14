package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class iq8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final ip8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iq8(MainTabActivity mainTabActivity, ip8 ip8Var) {
        super(2007002);
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
        setPriority(100);
    }

    public final void a(Intent intent) {
        ip8 ip8Var;
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null || (ip8Var = this.b) == null || ip8Var.B() == null) {
            return;
        }
        try {
            if (intent.hasExtra("locate_type")) {
                a = intent.getIntExtra("locate_type", 1);
            } else {
                a = this.a.o.a();
            }
            this.b.B().setCurrentTabByType(a);
        } catch (Throwable th) {
            BdLog.e(th);
            this.a.finish();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<y85> b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null || (b = ((a95) customResponsedMessage.getData()).b()) == null || b.size() == 0) {
            return;
        }
        this.b.C(b);
        if (this.a.c) {
            ip8 ip8Var = this.b;
            if (ip8Var != null && ip8Var.B() != null) {
                this.b.B().setCurrentTabByType(this.a.b);
            }
        } else {
            ip8 ip8Var2 = this.b;
            if (ip8Var2 != null && ip8Var2.B() != null) {
                if (this.a.getIntent() != null && this.a.getIntent().getDataString() != null && this.a.getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                    this.b.B().setCurrentTabByType(2);
                } else {
                    a(this.a.getIntent());
                }
            }
        }
        this.a.c = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, 0));
    }
}
