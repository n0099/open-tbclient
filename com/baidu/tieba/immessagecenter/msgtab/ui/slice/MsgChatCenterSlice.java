package com.baidu.tieba.immessagecenter.msgtab.ui.slice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.dr5;
import com.baidu.tieba.er5;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.lx5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u0015J\b\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020 2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020%H\u0016J\"\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020#H\u0016J\u0012\u00103\u001a\u00020 2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u000e\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020 J\b\u00108\u001a\u00020#H\u0016J\b\u00109\u001a\u00020#H\u0016J\u000e\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020 J\u001c\u0010<\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010+2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010>\u001a\u00020#H\u0002J\b\u0010?\u001a\u00020#H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006@"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "Lcom/baidu/tbadk/mvc/event/IEventDelegate;", "frag", "Lcom/baidu/tbadk/core/BaseFragment;", "intent", "Landroid/content/Intent;", "pageSource", "", "(Lcom/baidu/tbadk/core/BaseFragment;Landroid/content/Intent;Ljava/lang/String;)V", "context", "Landroid/content/Context;", "getFrag", "()Lcom/baidu/tbadk/core/BaseFragment;", "getIntent", "()Landroid/content/Intent;", "mAccountChangedListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mHomeTabClickListener", "mMessageFromNotifyCenterListener", "sliceView", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView;", "viewEvent", "Lcom/baidu/tbadk/mvc/core/ViewEventCenter;", "getViewEvent", "()Lcom/baidu/tbadk/mvc/core/ViewEventCenter;", "viewEvent$delegate", "Lkotlin/Lazy;", "getUniqueId", "Lcom/baidu/adp/BdUniqueId;", "getView", "isEventMustSelf", "", "isFromNotify", "onActivityResult", "", "requestCode", "", "resultCode", "data", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onEventDispatch", "mvcEvent", "Lcom/baidu/tbadk/mvc/event/MvcEvent;", "onNetworkChange", "hasNetwork", MissionEvent.MESSAGE_PAUSE, "onResume", "onUserChanged", "isLogin", "onViewCreated", "view", "registerListeners", "requestChatData", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgChatCenterSlice extends Slice implements dr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment j;
    public final Intent k;
    public final String l;
    public final Context m;
    public final MsgChatCenterSliceView n;
    public final Lazy o;
    public final CustomMessageListener p;
    public final CustomMessageListener q;
    public final CustomMessageListener r;

    @Override // com.baidu.tieba.dr5
    public boolean C0(er5 er5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, er5Var)) == null) ? er5Var == null : invokeL.booleanValue;
    }

    public final void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.dr5
    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgChatCenterSlice a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MsgChatCenterSlice msgChatCenterSlice) {
            super(2005016);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgChatCenterSlice};
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
            this.a = msgChatCenterSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getCmd() != 2005016) {
                    return;
                }
                this.a.n.y0(true);
                MentionActivityConfig.newJumpIn = true;
                this.a.n.j0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgChatCenterSlice a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MsgChatCenterSlice msgChatCenterSlice) {
            super(2001384);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgChatCenterSlice};
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
            this.a = msgChatCenterSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (!(responsedMessage.getData() instanceof Integer)) {
                    return;
                }
                Integer num = (Integer) responsedMessage.getData();
                boolean z3 = false;
                if ((num != null && num.intValue() == 2) || (num != null && num.intValue() == 1)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || (num != null && num.intValue() == 21)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || (num != null && num.intValue() == 8)) {
                    z3 = true;
                }
                if (z3) {
                    this.a.n.w0();
                } else if (num != null && num.intValue() == 3) {
                    this.a.e0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgChatCenterSlice a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MsgChatCenterSlice msgChatCenterSlice) {
            super(2016321);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgChatCenterSlice};
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
            this.a = msgChatCenterSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getCmd() == 2016321 && (responsedMessage.getData() instanceof Intent)) {
                    Object data = responsedMessage.getData();
                    if (data == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.content.Intent");
                    }
                    this.a.n.onNewIntent((Intent) data);
                }
            }
        }
    }

    public MsgChatCenterSlice(BaseFragment frag, Intent intent, String pageSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frag, intent, pageSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(frag, "frag");
        Intrinsics.checkNotNullParameter(pageSource, "pageSource");
        this.j = frag;
        this.k = intent;
        this.l = pageSource;
        Activity pageActivity = frag.getPageContext().getPageActivity();
        Intrinsics.checkNotNullExpressionValue(pageActivity, "frag.pageContext.pageActivity");
        this.m = pageActivity;
        this.n = new MsgChatCenterSliceView(this.j, this, this.l);
        this.o = LazyKt__LazyJVMKt.lazy(MsgChatCenterSlice$viewEvent$2.INSTANCE);
        this.p = new a(this);
        this.q = new c(this);
        this.r = new b(this);
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void J(int i, int i2, Intent intent) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, intent) == null) {
            super.J(i, i2, intent);
            if (i2 == -1 && i == 12011) {
                Intrinsics.checkNotNull(intent);
                Bundle extras = intent.getExtras();
                String str4 = null;
                if (extras != null) {
                    str = extras.getString("user_id");
                } else {
                    str = null;
                }
                if (extras != null) {
                    str2 = extras.getString("user_name");
                } else {
                    str2 = null;
                }
                if (extras != null) {
                    str3 = extras.getString("name_show");
                } else {
                    str3 = null;
                }
                if (extras != null) {
                    str4 = extras.getString("portrait");
                }
                String str5 = str4;
                if (str2 != null && str != null) {
                    try {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.m, Long.parseLong(str), str2, str3, str5, 0)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public final boolean a0(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intent)) == null) {
            if (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n.l0(z);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onChangeSkinType(i);
            this.n.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View M(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            if (bundle != null) {
                this.n.D0(bundle);
            }
            return BaseView.H(this.n, this.m, container, false, false, 8, null);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void T(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, bundle) == null) {
            lx5.b(view2);
            getLifecycle().addObserver(this.n);
            Z().addEventDelegate(this);
            d0();
            if (a0(this.k)) {
                this.n.onNewIntent(this.k);
            } else {
                this.n.j0();
            }
            super.T(view2, bundle);
        }
    }

    public final MsgChatCenterSliceView Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (MsgChatCenterSliceView) invokeV.objValue;
    }

    public final ViewEventCenter Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (ViewEventCenter) this.o.getValue();
        }
        return (ViewEventCenter) invokeV.objValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.q);
            MessageManager.getInstance().registerListener(this.r);
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.n.t0();
            this.n.n0();
        }
    }

    @Override // com.baidu.tieba.dr5
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            BdUniqueId uniqueId = this.j.getPageContext().getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId, "frag.pageContext.uniqueId");
            return uniqueId;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            this.n.m().z();
            this.n.X();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            this.n.m().A();
            this.n.t0();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            TbSingleton.getInstance().setNeedJoinChatRoom(false);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }
}
