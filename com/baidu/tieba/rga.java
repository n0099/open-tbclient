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
/* loaded from: classes7.dex */
public class rga extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final pfa b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rga(MainTabActivity mainTabActivity, pfa pfaVar) {
        super(2007002);
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
        setPriority(100);
    }

    public final void a(Intent intent) {
        pfa pfaVar;
        int a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, intent) == null) && intent != null && (pfaVar = this.b) != null && pfaVar.y() != null) {
            try {
                if (intent.hasExtra("locate_type")) {
                    a = intent.getIntExtra("locate_type", 1);
                } else {
                    a = this.a.o.a();
                }
                this.b.y().setCurrentTabByType(a);
            } catch (Throwable th) {
                BdLog.e(th);
                this.a.finish();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<io5> b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (b = ((ko5) customResponsedMessage.getData()).b()) != null && b.size() != 0) {
            this.b.z(b);
            if (this.a.c) {
                pfa pfaVar = this.b;
                if (pfaVar != null && pfaVar.y() != null) {
                    this.b.y().setCurrentTabByType(this.a.b);
                }
            } else {
                pfa pfaVar2 = this.b;
                if (pfaVar2 != null && pfaVar2.y() != null) {
                    if (this.a.getIntent() != null && this.a.getIntent().getDataString() != null && this.a.getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                        this.b.y().setCurrentTabByType(2);
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
}
