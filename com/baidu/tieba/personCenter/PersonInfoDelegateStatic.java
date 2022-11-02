package com.baidu.tieba.personCenter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.atomData.UserTropicGiftBagActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ha5;
import com.baidu.tieba.ia5;
import com.baidu.tieba.io8;
import com.baidu.tieba.ja5;
import com.baidu.tieba.ka5;
import com.baidu.tieba.ky4;
import com.baidu.tieba.la5;
import com.baidu.tieba.oa5;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.redpackage.NewUserRedPackageActivity;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonInfoDelegateStatic extends ia5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageRedDotView c;
    public Boolean d;
    public CustomMessageListener e;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ja5 b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
            ((ka5) customResponsedMessage.getData()).a(personInfoDelegateStatic);
            if (((ka5) customResponsedMessage.getData()).getContext() == null || (b = personInfoDelegateStatic.b()) == null) {
                return;
            }
            b.a.setArguments(new Bundle());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements la5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(PersonInfoDelegateStatic personInfoDelegateStatic, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personInfoDelegateStatic, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tieba.la5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return LayoutInflater.from(this.a).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonInfoDelegateStatic a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonInfoDelegateStatic personInfoDelegateStatic, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personInfoDelegateStatic, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personInfoDelegateStatic;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ha5)) {
                this.a.d = Boolean.valueOf(((ha5) customResponsedMessage.getData()).a);
                if (this.a.d.booleanValue()) {
                    this.a.c.f(0);
                    this.a.c.setVisibility(0);
                } else {
                    this.a.c.setVisibility(8);
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (!this.a.d.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                    ky4.k().u("member_close_ad_mine_clicked", true);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1102907506, "Lcom/baidu/tieba/personCenter/PersonInfoDelegateStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1102907506, "Lcom/baidu/tieba/personCenter/PersonInfoDelegateStatic;");
                return;
            }
        }
        j();
        PersonRedTipManager.getInstance();
        a aVar = new a(2007002);
        aVar.setPriority(9);
        MessageManager.getInstance().registerListener(aVar);
        TbadkCoreApplication.getInst().RegisterIntent(NewUserRedPackageActivityConfig.class, NewUserRedPackageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(UserTropicGiftBagActivityConfig.class, UserTropicGiftBagActivity.class);
    }

    public PersonInfoDelegateStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = Boolean.FALSE;
    }

    @Override // com.baidu.tieba.ia5
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ia5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c cVar = new c(this, 2007014);
            this.e = cVar;
            cVar.setPriority(9);
            MessageManager.getInstance().registerListener(this.e);
        }
    }

    @Override // com.baidu.tieba.ia5
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.f();
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            io8.h(303012, ProfileSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, io8.a("c/u/user/profile", 303012));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.tieba.ia5
    public ja5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ja5 ja5Var = new ja5();
            ja5Var.a = new PersonCenterFragment();
            ja5Var.e = 8;
            ja5Var.b = R.string.mine;
            ja5Var.f = R.raw.lottie_tab_my;
            ja5Var.i = ja5.m;
            ja5Var.h = oa5.d().c("person");
            return ja5Var;
        }
        return (ja5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ia5
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.b = (MaintabBottomIndicator) la5.e().d(1005, new b(this, context));
            this.c = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            aVar.f = this.b;
            aVar.c = xi.d(context, 10.0f);
            aVar.a = this.c;
            this.b.b(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
            boolean h = ky4.k().h("key_feedback_tip_tab_show", false);
            if (!this.d.booleanValue() && !h) {
                this.c.setVisibility(8);
            } else {
                this.c.f(0);
                this.c.setVisibility(0);
            }
            return this.b;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }
}
