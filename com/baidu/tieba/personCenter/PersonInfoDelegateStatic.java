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
import com.baidu.tbadk.core.atomData.MissionCustomDialogActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.atomData.UserTropicGiftBagActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.switchs.PreInitMainTabViewSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.redpackage.NewUserRedPackageActivity;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kk8;
import com.repackage.l45;
import com.repackage.m45;
import com.repackage.n45;
import com.repackage.o45;
import com.repackage.oi;
import com.repackage.p45;
import com.repackage.q45;
import com.repackage.t45;
import com.repackage.vt4;
/* loaded from: classes3.dex */
public class PersonInfoDelegateStatic extends m45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageRedDotView c;
    public Boolean d;
    public CustomMessageListener e;

    /* loaded from: classes3.dex */
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
            n45 b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
            ((o45) customResponsedMessage.getData()).a(personInfoDelegateStatic);
            if (((o45) customResponsedMessage.getData()).getContext() == null || (b = personInfoDelegateStatic.b()) == null) {
                return;
            }
            b.a.setArguments(new Bundle());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonInfoDelegateStatic a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonInfoDelegateStatic personInfoDelegateStatic, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof l45)) {
                this.a.d = Boolean.valueOf(((l45) customResponsedMessage.getData()).a);
                if (this.a.d.booleanValue()) {
                    this.a.c.f(0);
                    this.a.c.setVisibility(0);
                } else {
                    this.a.c.setVisibility(8);
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (!this.a.d.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                    vt4.k().u("member_close_ad_mine_clicked", true);
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
        TbadkCoreApplication.getInst().RegisterIntent(MissionCustomDialogActivityConfig.class, MissionCustomDialogActivity.class);
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

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            kk8.h(303012, ProfileSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, kk8.a("c/u/user/profile", 303012));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.repackage.m45
    public n45 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n45 n45Var = new n45();
            n45Var.a = new PersonCenterFragment();
            n45Var.e = 8;
            n45Var.b = R.string.mine;
            n45Var.f = R.raw.lottie_tab_my;
            n45Var.i = n45.n;
            n45Var.h = t45.d().c("person");
            n45Var.j = true;
            return n45Var;
        }
        return (n45) invokeV.objValue;
    }

    @Override // com.repackage.m45
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (p45.e().a()) {
                this.b = (MaintabBottomIndicator) p45.e().d(8);
            } else if (PreInitMainTabViewSwitch.getIsOn()) {
                this.b = q45.b().a();
            }
            if (this.b == null) {
                this.b = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
            }
            this.c = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            aVar.f = this.b;
            aVar.c = oi.d(context, 10.0f);
            aVar.a = this.c;
            this.b.b(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
            boolean h = vt4.k().h("key_feedback_tip_tab_show", false);
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

    @Override // com.repackage.m45
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MainTabActivityConfig.PERSON_TAB_AVAIBLE : invokeV.booleanValue;
    }

    @Override // com.repackage.m45
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b bVar = new b(this, 2007014);
            this.e = bVar;
            bVar.setPriority(9);
            MessageManager.getInstance().registerListener(this.e);
        }
    }

    @Override // com.repackage.m45
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.f();
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }
}
