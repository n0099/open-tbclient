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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tbadk.mainTab.MaintabAddResponedData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ak5;
import com.baidu.tieba.bk5;
import com.baidu.tieba.dra;
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
/* loaded from: classes7.dex */
public class PersonInfoDelegateStatic extends FragmentDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageRedDotView a;
    public Boolean b;
    public CustomMessageListener c;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
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
            FragmentTabStructure fragmentTabStructure;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
            ((MaintabAddResponedData) customResponsedMessage.getData()).addFragment(personInfoDelegateStatic);
            if (((MaintabAddResponedData) customResponsedMessage.getData()).getContext() == null || (fragmentTabStructure = personInfoDelegateStatic.getFragmentTabStructure()) == null) {
                return;
            }
            fragmentTabStructure.frag.setArguments(new Bundle());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bk5.b {
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

        @Override // com.baidu.tieba.bk5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return LayoutInflater.from(this.a).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ak5)) {
                this.a.b = Boolean.valueOf(((ak5) customResponsedMessage.getData()).a);
                if (this.a.b.booleanValue()) {
                    this.a.a.refresh(0);
                    this.a.a.setVisibility(0);
                } else {
                    this.a.a.setVisibility(8);
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (!this.a.b.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                    SharedPrefHelper.getInstance().putBoolean("member_close_ad_mine_clicked", true);
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
        d();
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
        this.b = Boolean.FALSE;
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public void onAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c cVar = new c(this, 2007014);
            this.c = cVar;
            cVar.setPriority(9);
            MessageManager.getInstance().registerListener(this.c);
        }
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public void onRemove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onRemove();
            MessageManager.getInstance().unRegisterListener(this.c);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            dra.h(303012, ProfileSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, dra.a("c/u/user/profile", 303012));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public FragmentTabStructure createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
            fragmentTabStructure.frag = new PersonCenterFragment();
            fragmentTabStructure.type = 8;
            fragmentTabStructure.textResId = R.string.mine;
            fragmentTabStructure.animationResId = R.raw.lottie_tab_my;
            fragmentTabStructure.showIconType = FragmentTabStructure.SHOWLOTTIE;
            fragmentTabStructure.dynamicIconData = MainTabBottomDynamicIconManager.getInstance().getIconData("person");
            return fragmentTabStructure;
        }
        return (FragmentTabStructure) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.mIndicator = (MaintabBottomIndicator) bk5.e().d(1005, new b(this, context));
            this.a = new MessageRedDotView(context);
            TbFragmentTabIndicator.FragmentTapTip fragmentTapTip = new TbFragmentTabIndicator.FragmentTapTip();
            TbFragmentTabIndicator tbFragmentTabIndicator = this.mIndicator;
            fragmentTapTip.indicator = tbFragmentTabIndicator;
            fragmentTapTip.f1083view = this.a;
            tbFragmentTabIndicator.addTipWrapContent(FileHelper.FILE_CACHE_EMOTION_PACKAGE, fragmentTapTip);
            boolean z = SharedPrefHelper.getInstance().getBoolean("key_feedback_tip_tab_show", false);
            if (!this.b.booleanValue() && !z) {
                this.a.setVisibility(8);
            } else {
                this.a.refresh(0);
                this.a.setVisibility(0);
            }
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }
}
