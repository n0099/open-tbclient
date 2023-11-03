package com.baidu.tieba.immessagecenter.im.chat.notify;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tbadk.mainTab.MaintabAddResponedData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ak5;
import com.baidu.tieba.bkc;
import com.baidu.tieba.ckc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.immessagecenter.msgtab.obs.ObserverRegistry;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgCenterContainerFragment;
import com.baidu.tieba.pjc;
import com.baidu.tieba.rha;
import com.baidu.tieba.v95;
import com.baidu.tieba.wjc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import kotlin.Triple;
/* loaded from: classes6.dex */
public class ImMessageCenterDelegateStatic extends FragmentDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageRedDotView a;
    public pjc b;

    /* loaded from: classes6.dex */
    public class a implements ak5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterDelegateStatic, context};
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

        @Override // com.baidu.tieba.ak5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return LayoutInflater.from(this.a).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
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
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            ((MaintabAddResponedData) customResponsedMessage.getData()).addFragment(new ImMessageCenterDelegateStatic());
        }
    }

    /* loaded from: classes6.dex */
    public class c implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                return rha.b(tbPageContext, strArr);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements wjc<Triple<Boolean, Integer, Boolean>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v95 a;
        public final /* synthetic */ ImMessageCenterDelegateStatic b;

        public d(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic, v95 v95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterDelegateStatic, v95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = imMessageCenterDelegateStatic;
            this.a = v95Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wjc
        /* renamed from: a */
        public void call(Triple<Boolean, Integer, Boolean> triple) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, triple) == null) {
                if (!triple.getThird().booleanValue()) {
                    boolean z = true;
                    if (triple.getSecond().intValue() > 0) {
                        this.b.c(true, triple.getSecond().intValue());
                        return;
                    } else {
                        this.b.c((!triple.getFirst().booleanValue() || this.a.d()) ? false : false, triple.getSecond().intValue());
                        return;
                    }
                }
                this.b.f();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements bkc<Pair<NewsRemindMessage, Boolean>, Triple<Boolean, Integer, Boolean>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterDelegateStatic};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public Triple<Boolean, Integer, Boolean> call(Pair<NewsRemindMessage, Boolean> pair) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pair)) == null) {
                NewsRemindMessage newsRemindMessage = pair.first;
                int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                if (!newsRemindMessage.hasMsgRemind() && !newsRemindMessage.hasChatRemind() && !newsRemindMessage.hasNotificationRemind()) {
                    z = false;
                } else {
                    z = true;
                }
                return new Triple<>(Boolean.valueOf(z), Integer.valueOf(msgCount), pair.second);
            }
            return (Triple) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ckc<NewsRemindMessage, Boolean, Pair<NewsRemindMessage, Boolean>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterDelegateStatic};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: b */
        public Pair<NewsRemindMessage, Boolean> a(NewsRemindMessage newsRemindMessage, Boolean bool) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, newsRemindMessage, bool)) == null) {
                return Pair.create(newsRemindMessage, bool);
            }
            return (Pair) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements bkc<NewsRemindMessage, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterDelegateStatic};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public Boolean call(NewsRemindMessage newsRemindMessage) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, newsRemindMessage)) == null) {
                if (newsRemindMessage != null) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2000170427, "Lcom/baidu/tieba/immessagecenter/im/chat/notify/ImMessageCenterDelegateStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2000170427, "Lcom/baidu/tieba/immessagecenter/im/chat/notify/ImMessageCenterDelegateStatic;");
                return;
            }
        }
        b bVar = new b(2007002);
        bVar.setPriority(7);
        MessageManager.getInstance().registerListener(bVar);
        UrlManager.getInstance().addListener(new c());
        ObserverRegistry.a.start();
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public FragmentTabStructure createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
            fragmentTabStructure.frag = new MsgCenterContainerFragment();
            fragmentTabStructure.type = 3;
            fragmentTabStructure.textResId = R.string.my_message;
            fragmentTabStructure.animationResId = R.raw.lottie_tab_msg_new;
            fragmentTabStructure.showIconType = FragmentTabStructure.SHOWBOTH;
            fragmentTabStructure.dynamicIconData = MainTabBottomDynamicIconManager.getInstance().getIconData("message");
            return fragmentTabStructure;
        }
        return (FragmentTabStructure) invokeV.objValue;
    }

    public ImMessageCenterDelegateStatic() {
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
        this.b = null;
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public void onRemove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onRemove();
            pjc pjcVar = this.b;
            if (pjcVar != null) {
                pjcVar.unsubscribe();
            }
            this.b = null;
            FragmentTabStructure fragmentTabStructure = this.mFragement;
            if (fragmentTabStructure != null) {
                fragmentTabStructure.frag = null;
                this.mFragement = null;
            }
        }
    }

    public final void e(int i) {
        TbFragmentTabIndicator tbFragmentTabIndicator;
        TbFragmentTabIndicator.FragmentTapTip tip;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (tbFragmentTabIndicator = this.mIndicator) != null && (tip = tbFragmentTabIndicator.getTip("msg")) != null) {
            tip.offsetX = i;
        }
    }

    public final void c(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || this.a == null) {
            return;
        }
        e(0);
        if (z) {
            this.a.setThreeDotMode(2);
            this.a.refresh(i);
            this.a.setVisibility(0);
            if (TbSingleton.getInstance().isShowVivoBadge()) {
                d(this.a.getContext(), i);
                return;
            }
            return;
        }
        this.a.setVisibility(8);
        if (TbSingleton.getInstance().isShowVivoBadge()) {
            d(this.a.getContext(), 0);
        }
    }

    public final void d(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i) == null) {
            Intent intent = new Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", "com.baidu.tieba");
            intent.putExtra(PushClientConstants.TAG_CLASS_NAME, SpeedRuntimeProvider.MAIN_ACTIVITY_NAME);
            intent.putExtra("notificationNum", i);
            intent.addFlags(16777216);
            context.sendBroadcast(intent);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a != null && this.mIndicator != null) {
            e(-UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            MessageRedDotView messageRedDotView = this.a;
            messageRedDotView.refresh(messageRedDotView.getContext().getString(R.string.message_notify_upgrade), false);
            this.a.setVisibility(0);
            if (TbSingleton.MsgUpgradeTips.isMsgTabUpgradeTipsShowing()) {
                return;
            }
            TbSingleton.MsgUpgradeTips.setIsMsgTabUpgradeTipsShowing(true);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_GUIDE_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public void onAdd() {
        v95 v95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (v95Var = (v95) ServiceManager.getService(v95.a)) != null && this.b == null) {
            this.b = ijc.c(v95Var.g().k(new g(this)), v95Var.c(), new f(this)).p(new e(this)).H(new d(this, v95Var));
        }
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            this.mIndicator = (MaintabBottomIndicator) ak5.e().d(1004, new a(this, context));
            this.a = new MessageRedDotView(context);
            TbFragmentTabIndicator.FragmentTapTip fragmentTapTip = new TbFragmentTabIndicator.FragmentTapTip();
            TbFragmentTabIndicator tbFragmentTabIndicator = this.mIndicator;
            fragmentTapTip.indicator = tbFragmentTabIndicator;
            fragmentTapTip.f1083view = this.a;
            fragmentTapTip.isRight = true;
            tbFragmentTabIndicator.addTipWrapContent("msg", fragmentTapTip);
            this.a.setVisibility(4);
            if (!TbSingleton.getInstance().isShowVivoBadge()) {
                d(this.a.getContext(), 0);
            }
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }
}
