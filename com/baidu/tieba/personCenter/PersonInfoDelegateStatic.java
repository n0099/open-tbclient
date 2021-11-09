package com.baidu.tieba.personCenter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import b.a.e.e.p.l;
import b.a.q0.h0.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MissionCustomDialogActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.atomData.UserTropicGiftBagActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.redpackage.NewUserRedPackageActivity;
import com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PersonInfoDelegateStatic extends b.a.q0.h0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MessageRedDotView f53010a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f53011b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f53012c;

    /* loaded from: classes9.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            b.a.q0.h0.c fragmentTabStructure;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
            ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
            if (((d) customResponsedMessage.getData()).getContext() == null || (fragmentTabStructure = personInfoDelegateStatic.getFragmentTabStructure()) == null) {
                return;
            }
            fragmentTabStructure.f12612a.setArguments(new Bundle());
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonInfoDelegateStatic f53013a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonInfoDelegateStatic personInfoDelegateStatic, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personInfoDelegateStatic, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53013a = personInfoDelegateStatic;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof b.a.q0.h0.a)) {
                this.f53013a.f53011b = Boolean.valueOf(((b.a.q0.h0.a) customResponsedMessage.getData()).f12611a);
                if (this.f53013a.f53011b.booleanValue()) {
                    this.f53013a.f53010a.refresh(0);
                    this.f53013a.f53010a.setVisibility(0);
                } else {
                    this.f53013a.f53010a.setVisibility(8);
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (!this.f53013a.f53011b.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                    b.a.q0.s.e0.b.j().t("member_close_ad_mine_clicked", true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr == null || strArr[0] == null || tbPageContext == null || tbPageContext.getPageActivity() == null || !strArr[0].contains("openAiCustomService")) {
                    return 3;
                }
                b.a.r0.n2.b.a().b();
                return 0;
            }
            return invokeLL.intValue;
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
        d();
        b.a.r0.a3.a.v();
        a aVar = new a(2007002);
        aVar.setPriority(9);
        MessageManager.getInstance().registerListener(aVar);
        TbadkCoreApplication.getInst().RegisterIntent(NewUserRedPackageActivityConfig.class, NewUserRedPackageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MissionCustomDialogActivityConfig.class, MissionCustomDialogActivity.class);
        e();
        TbadkCoreApplication.getInst().RegisterIntent(UserTropicGiftBagActivityConfig.class, UserTropicGiftBagActivity.class);
        b.a.r0.n2.b.a();
    }

    public PersonInfoDelegateStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53011b = Boolean.FALSE;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            b.a.r0.l3.f0.a.h(303012, ProfileSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, b.a.r0.l3.f0.a.a("c/u/user/profile", 303012));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            UrlManager.getInstance().addListener(new c());
        }
    }

    @Override // b.a.q0.h0.b
    public b.a.q0.h0.c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.q0.h0.c cVar = new b.a.q0.h0.c();
            cVar.f12612a = new PersonCenterFragment();
            cVar.f12616e = 8;
            cVar.f12613b = R.string.mine;
            cVar.f12617f = R.raw.lottie_tab_my;
            cVar.f12620i = b.a.q0.h0.c.m;
            cVar.f12619h = b.a.q0.h0.e.c.d().c("person");
            return cVar;
        }
        return (b.a.q0.h0.c) invokeV.objValue;
    }

    @Override // b.a.q0.h0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
            this.f53010a = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            aVar.f45978f = this.mIndicator;
            aVar.f45975c = l.e(context, 10.0f);
            aVar.f45973a = this.f53010a;
            this.mIndicator.addTipWrapContent(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
            boolean g2 = b.a.q0.s.e0.b.j().g("key_feedback_tip_tab_show", false);
            if (!this.f53011b.booleanValue() && !g2) {
                this.f53010a.setVisibility(8);
            } else {
                this.f53010a.refresh(0);
                this.f53010a.setVisibility(0);
            }
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // b.a.q0.h0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MainTabActivityConfig.PERSON_TAB_AVAIBLE : invokeV.booleanValue;
    }

    @Override // b.a.q0.h0.b
    public void onAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b bVar = new b(this, 2007014);
            this.f53012c = bVar;
            bVar.setPriority(9);
            MessageManager.getInstance().registerListener(this.f53012c);
        }
    }

    @Override // b.a.q0.h0.b
    public void onRemove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onRemove();
            MessageManager.getInstance().unRegisterListener(this.f53012c);
        }
    }
}
