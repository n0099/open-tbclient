package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d55;
import com.repackage.e55;
import com.repackage.f55;
import com.repackage.g55;
import com.repackage.j55;
import com.vivo.push.PushClientConstants;
/* loaded from: classes3.dex */
public class ImMessageCenterDelegateStatic extends d55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageRedDotView c;
    public CustomMessageListener d;

    /* loaded from: classes3.dex */
    public class a implements g55.a {
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

        @Override // com.repackage.g55.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LayoutInflater.from(this.a).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null) : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            ((f55) customResponsedMessage.getData()).a(new ImMessageCenterDelegateStatic());
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterDelegateStatic a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterDelegateStatic, Integer.valueOf(i)};
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
            this.a = imMessageCenterDelegateStatic;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                boolean z = false;
                try {
                    Pair pair = (Pair) customResponsedMessage.getData();
                    i = ((Integer) pair.first).intValue();
                    try {
                        z = ((Boolean) pair.second).booleanValue();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i = 0;
                }
                this.a.h(z, i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1225068987, "Lcom/baidu/tieba/imMessageCenter/im/chat/notify/ImMessageCenterDelegateStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1225068987, "Lcom/baidu/tieba/imMessageCenter/im/chat/notify/ImMessageCenterDelegateStatic;");
                return;
            }
        }
        b bVar = new b(2007002);
        bVar.setPriority(7);
        MessageManager.getInstance().registerListener(bVar);
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
            }
        }
    }

    @Override // com.repackage.d55
    public e55 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e55 e55Var = new e55();
            e55Var.a = new MessageCenterFragment();
            e55Var.e = 3;
            e55Var.b = R.string.obfuscated_res_0x7f0f0b46;
            e55Var.f = R.raw.lottie_tab_msg;
            e55Var.i = e55.l;
            e55Var.h = j55.d().c("message");
            return e55Var;
        }
        return (e55) invokeV.objValue;
    }

    @Override // com.repackage.d55
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.b = (MaintabBottomIndicator) g55.e().d(1004, new a(this, context));
            this.c = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            TbFragmentTabIndicator tbFragmentTabIndicator = this.b;
            aVar.f = tbFragmentTabIndicator;
            aVar.a = this.c;
            aVar.b = true;
            tbFragmentTabIndicator.b("msg", aVar);
            this.c.setVisibility(4);
            if (!TbSingleton.getInstance().isShowVivoBadge()) {
                i(this.c.getContext(), 0);
            }
            return this.b;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // com.repackage.d55
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE : invokeV.booleanValue;
    }

    @Override // com.repackage.d55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = new c(this, 2921002);
            MessageManager.getInstance().registerListener(this.d);
        }
    }

    @Override // com.repackage.d55
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.f();
            MessageManager.getInstance().unRegisterListener(this.d);
        }
    }

    public final void h(boolean z, int i) {
        MessageRedDotView messageRedDotView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (messageRedDotView = this.c) == null) {
            return;
        }
        if (z) {
            messageRedDotView.setThreeDotMode(2);
            this.c.f(i);
            this.c.setVisibility(0);
            if (TbSingleton.getInstance().isShowVivoBadge()) {
                i(this.c.getContext(), i);
                return;
            }
            return;
        }
        messageRedDotView.setVisibility(8);
        if (TbSingleton.getInstance().isShowVivoBadge()) {
            i(this.c.getContext(), 0);
        }
    }

    public final void i(Context context, int i) {
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
