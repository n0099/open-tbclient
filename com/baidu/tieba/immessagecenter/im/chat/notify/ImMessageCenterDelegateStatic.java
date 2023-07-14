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
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.b2c;
import com.baidu.tieba.ev8;
import com.baidu.tieba.i2c;
import com.baidu.tieba.immessagecenter.mention.MessageCenterFragment;
import com.baidu.tieba.immessagecenter.msgtab.obs.ObserverRegistry;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgCenterContainerFragment;
import com.baidu.tieba.io5;
import com.baidu.tieba.jo5;
import com.baidu.tieba.ko5;
import com.baidu.tieba.lf5;
import com.baidu.tieba.lo5;
import com.baidu.tieba.m2c;
import com.baidu.tieba.n2c;
import com.baidu.tieba.qo5;
import com.baidu.tieba.u1c;
import com.baidu.tieba.z2a;
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
public class ImMessageCenterDelegateStatic extends io5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageRedDotView c;
    public b2c d;

    /* loaded from: classes6.dex */
    public class a implements lo5.b {
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

        @Override // com.baidu.tieba.lo5.b
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
    public static class b extends CustomMessageListener {
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
            ((ko5) customResponsedMessage.getData()).a(new ImMessageCenterDelegateStatic());
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements UrlManager.UrlDealListener {
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
                return z2a.b(tbPageContext, strArr);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements i2c<Triple<Boolean, Integer, Boolean>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf5 a;
        public final /* synthetic */ ImMessageCenterDelegateStatic b;

        public d(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic, lf5 lf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterDelegateStatic, lf5Var};
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
            this.a = lf5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i2c
        public void call(Triple<Boolean, Integer, Boolean> triple) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, triple) == null) {
                if (triple.getThird().booleanValue()) {
                    this.b.l();
                    return;
                }
                boolean z = true;
                if (triple.getSecond().intValue() > 0) {
                    this.b.i(true, triple.getSecond().intValue());
                } else {
                    this.b.i((!triple.getFirst().booleanValue() || this.a.c()) ? false : false, triple.getSecond().intValue());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements m2c<Pair<NewsRemindMessage, Boolean>, Triple<Boolean, Integer, Boolean>> {
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
        @Override // com.baidu.tieba.m2c
        public Triple<Boolean, Integer, Boolean> call(Pair<NewsRemindMessage, Boolean> pair) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair)) == null) {
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
    public class f implements m2c<NewsRemindMessage, Boolean> {
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
        @Override // com.baidu.tieba.m2c
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

    /* loaded from: classes6.dex */
    public class g implements n2c<NewsRemindMessage, Boolean, Pair<NewsRemindMessage, Boolean>> {
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
        @Override // com.baidu.tieba.n2c
        public Pair<NewsRemindMessage, Boolean> call(NewsRemindMessage newsRemindMessage, Boolean bool) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, newsRemindMessage, bool)) == null) {
                return Pair.create(newsRemindMessage, bool);
            }
            return (Pair) invokeLL.objValue;
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
        this.d = null;
    }

    @Override // com.baidu.tieba.io5
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.io5
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.f();
            b2c b2cVar = this.d;
            if (b2cVar != null) {
                b2cVar.unsubscribe();
            }
            this.d = null;
            jo5 jo5Var = this.a;
            if (jo5Var != null) {
                jo5Var.a = null;
                this.a = null;
            }
        }
    }

    public final void k(int i) {
        TbFragmentTabIndicator tbFragmentTabIndicator;
        TbFragmentTabIndicator.a d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (tbFragmentTabIndicator = this.b) != null && (d2 = tbFragmentTabIndicator.d("msg")) != null) {
            d2.c = i;
        }
    }

    @Override // com.baidu.tieba.io5
    public jo5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            jo5 jo5Var = new jo5();
            if (ev8.a()) {
                jo5Var.a = new MsgCenterContainerFragment();
            } else {
                jo5Var.a = new MessageCenterFragment();
            }
            jo5Var.e = 3;
            jo5Var.b = R.string.my_message;
            jo5Var.f = R.raw.lottie_tab_msg_new;
            jo5Var.i = jo5.l;
            jo5Var.h = qo5.f().d("message");
            return jo5Var;
        }
        return (jo5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.io5
    public void e() {
        lf5 lf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (lf5Var = (lf5) ServiceManager.getService(lf5.a)) != null && this.d == null) {
            this.d = u1c.c(lf5Var.f().k(new f(this)), lf5Var.b(), new g(this)).p(new e(this)).H(new d(this, lf5Var));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.c != null && this.b != null) {
            k(-UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            MessageRedDotView messageRedDotView = this.c;
            messageRedDotView.g(messageRedDotView.getContext().getString(R.string.message_notify_upgrade), false);
            this.c.setVisibility(0);
            if (TbSingleton.MsgUpgradeTips.isMsgTabUpgradeTipsShowing()) {
                return;
            }
            TbSingleton.MsgUpgradeTips.setIsMsgTabUpgradeTipsShowing(true);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_GUIDE_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.io5
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.b = (MaintabBottomIndicator) lo5.e().d(1004, new a(this, context));
            this.c = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            TbFragmentTabIndicator tbFragmentTabIndicator = this.b;
            aVar.f = tbFragmentTabIndicator;
            aVar.a = this.c;
            aVar.b = true;
            tbFragmentTabIndicator.b("msg", aVar);
            this.c.setVisibility(4);
            if (!TbSingleton.getInstance().isShowVivoBadge()) {
                j(this.c.getContext(), 0);
            }
            return this.b;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    public final void i(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || this.c == null) {
            return;
        }
        k(0);
        if (z) {
            this.c.setThreeDotMode(2);
            this.c.f(i);
            this.c.setVisibility(0);
            if (TbSingleton.getInstance().isShowVivoBadge()) {
                j(this.c.getContext(), i);
                return;
            }
            return;
        }
        this.c.setVisibility(8);
        if (TbSingleton.getInstance().isShowVivoBadge()) {
            j(this.c.getContext(), 0);
        }
    }

    public final void j(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, context, i) == null) {
            Intent intent = new Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", "com.baidu.tieba");
            intent.putExtra(PushClientConstants.TAG_CLASS_NAME, SpeedRuntimeProvider.MAIN_ACTIVITY_NAME);
            intent.putExtra("notificationNum", i);
            intent.addFlags(16777216);
            context.sendBroadcast(intent);
        }
    }
}
