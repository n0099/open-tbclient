package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.MaintabAddResponedData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class n0b extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final fza b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0b(MainTabActivity mainTabActivity, fza fzaVar) {
        super(2007002);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, fzaVar};
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
        this.b = fzaVar;
        setPriority(100);
    }

    public final void g(Intent intent) {
        fza fzaVar;
        int a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, intent) == null) && intent != null && (fzaVar = this.b) != null && fzaVar.A() != null) {
            try {
                if (intent.hasExtra(MainEntrance.GOTO_TYPE)) {
                    a = intent.getIntExtra(MainEntrance.GOTO_TYPE, 1);
                } else {
                    a = this.a.p.a();
                }
                this.b.A().setCurrentTabByType(a);
            } catch (Throwable th) {
                BdLog.e(th);
                this.a.finish();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<FragmentDelegate> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((MaintabAddResponedData) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
            zya.a("AddTabListener  ====== begin initTabs ======");
            this.b.B(list);
            zya.a("AddTabListener  ====== end initTabs ======");
            if (this.a.c) {
                fza fzaVar = this.b;
                if (fzaVar != null && fzaVar.A() != null) {
                    this.b.A().setCurrentTabByType(this.a.b);
                }
            } else {
                fza fzaVar2 = this.b;
                if (fzaVar2 != null && fzaVar2.A() != null) {
                    if (this.a.getIntent() != null && this.a.getIntent().getDataString() != null && this.a.getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                        this.b.A().setCurrentTabByType(2);
                    } else {
                        g(this.a.getIntent());
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
