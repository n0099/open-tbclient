package com.baidu.tieba.immessagecenter.msgtab.ui.vm;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.d8c;
import com.baidu.tieba.hw8;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel;
import com.baidu.tieba.immessagecenter.im.model.MsgChatTabModel;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgChatCenterSliceViewModel;
import com.baidu.tieba.iw8;
import com.baidu.tieba.jd8;
import com.baidu.tieba.qcc;
import com.baidu.tieba.qk8;
import com.baidu.tieba.rw8;
import com.baidu.tieba.z7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0003H\u0014J\b\u0010\u001a\u001a\u00020\u0002H\u0014J\u0016\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u000fJ\u0006\u0010\"\u001a\u00020\u000fJ\u0006\u0010#\u001a\u00020\u000fJ\u000e\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u000fJ\n\u0010'\u001a\u0004\u0018\u00010(H\u0014J(\u0010)\u001a\u00020\u000f2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010-\u001a\u00020.R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgChatCenterSliceViewModel;", "Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterChatTabUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterChatTabUiIntent;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "(Lcom/baidu/tbadk/TbPageContext;)V", "mSubscription", "Lrx/subscriptions/CompositeSubscription;", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "personChatMsgModel", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/ChatMsgModel;", "deleteItem", "", "data", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "iProcess", "Lcom/baidu/tieba/im/chat/notify/IProcess;", "getMessageCenterModel", "Lcom/baidu/tieba/immessagecenter/im/model/MsgChatTabModel;", "getSocketDispatcher", "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/ChatTabSubscribeGroupMessageDispatcher;", "handleUiIntent", "intent", "initUiState", "officialMaskModelSwitchSingleMask", "isMask", "", TbEnum.ParamKey.GID, "", "onCreate", MissionEvent.MESSAGE_DESTROY, "onVmMsgTabPause", "onVmMsgTabPrimary", "refreshMsg", "isSort", "refreshUserList", "registerSubscribe", "", "sendChatTabRedTipUpdateMsg", "list", "", "Lcom/baidu/tieba/im/db/pojo/ImMessageCenterPojo;", "type", "", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgChatCenterSliceViewModel extends BaseViewModel<iw8, hw8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> d;
    public qcc e;
    public ChatMsgModel f;

    public Void D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Void) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: p */
    public void h(hw8 intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
        }
    }

    public MsgChatCenterSliceViewModel(TbPageContext<BaseFragmentActivity> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.d = pageContext;
    }

    public static final void t(MsgChatCenterSliceViewModel this$0, final List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b(new Function1<iw8, iw8>(list) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgChatCenterSliceViewModel$onCreate$1$1$1$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List<ImMessageCenterShowItemData> $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {list};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$it = list;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final iw8 invoke(iw8 emitUiState) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                        List<ImMessageCenterShowItemData> it = this.$it;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        return new iw8.f(it);
                    }
                    return (iw8) invokeL.objValue;
                }
            });
        }
    }

    public static final void u(MsgChatCenterSliceViewModel this$0, final Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, bool) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b(new Function1<iw8, iw8>(bool) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgChatCenterSliceViewModel$onCreate$1$1$2$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bool};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$it = bool;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final iw8 invoke(iw8 emitUiState) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                        Boolean it = this.$it;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        return new iw8.e(it.booleanValue());
                    }
                    return (iw8) invokeL.objValue;
                }
            });
        }
    }

    public static final void v(MsgChatCenterSliceViewModel this$0, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, obj) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b(MsgChatCenterSliceViewModel$onCreate$1$1$3$1.INSTANCE);
        }
    }

    public static final void w(MsgChatCenterSliceViewModel this$0, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, bool) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b(MsgChatCenterSliceViewModel$onCreate$1$1$4$1.INSTANCE);
        }
    }

    public static final void x(MsgChatCenterSliceViewModel this$0, final Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, pair) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            rw8.a.h(((Boolean) pair.getFirst()).booleanValue());
            this$0.b(new Function1<iw8, iw8>(pair) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgChatCenterSliceViewModel$onCreate$1$1$5$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Pair<Boolean, Boolean> $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {pair};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$it = pair;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final iw8 invoke(iw8 emitUiState) {
                    InterceptResult invokeL;
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, emitUiState)) == null) {
                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                        if (!this.$it.getFirst().booleanValue() && this.$it.getSecond().booleanValue()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return new iw8.b(z);
                    }
                    return (iw8) invokeL.objValue;
                }
            });
        }
    }

    public final void m(ImMessageCenterShowItemData data, jd8 iProcess) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, data, iProcess) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(iProcess, "iProcess");
            ChatMsgModel chatMsgModel = this.f;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            chatMsgModel.v(data, iProcess);
        }
    }

    public final void r(boolean z, String gid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, gid) == null) {
            Intrinsics.checkNotNullParameter(gid, "gid");
            ChatMsgModel chatMsgModel = this.f;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            chatMsgModel.W(z, gid);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ChatMsgModel chatMsgModel = this.f;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            chatMsgModel.N();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ChatMsgModel chatMsgModel = this.f;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            chatMsgModel.S();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    public /* bridge */ /* synthetic */ qcc l() {
        return (qcc) D();
    }

    public final MsgChatTabModel n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ChatMsgModel chatMsgModel = this.f;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            return chatMsgModel.y();
        }
        return (MsgChatTabModel) invokeV.objValue;
    }

    public final qk8 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ChatMsgModel chatMsgModel = this.f;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            return chatMsgModel.H();
        }
        return (qk8) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: q */
    public iw8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return iw8.a.a;
        }
        return (iw8) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ChatMsgModel chatMsgModel = this.f;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            chatMsgModel.X();
            qcc qccVar = this.e;
            if (qccVar != null) {
                qccVar.unsubscribe();
            }
            qcc qccVar2 = this.e;
            if (qccVar2 != null) {
                qccVar2.c();
            }
            this.e = null;
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ChatMsgModel chatMsgModel = this.f;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            chatMsgModel.M();
        }
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            ChatMsgModel chatMsgModel = this.f;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            chatMsgModel.R(z);
        }
    }

    public final void E(List<? extends ImMessageCenterPojo> list, ImMessageCenterShowItemData imMessageCenterShowItemData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, list, imMessageCenterShowItemData, i) == null) {
            ChatMsgModel chatMsgModel = this.f;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            chatMsgModel.U(list, imMessageCenterShowItemData, i);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ChatMsgModel chatMsgModel = new ChatMsgModel(this.d);
            this.f = chatMsgModel;
            if (chatMsgModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personChatMsgModel");
                chatMsgModel = null;
            }
            chatMsgModel.T();
            qcc qccVar = new qcc();
            qccVar.a(chatMsgModel.x().H(new d8c() { // from class: com.baidu.tieba.zv8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.d8c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgChatCenterSliceViewModel.t(MsgChatCenterSliceViewModel.this, (List) obj);
                    }
                }
            }));
            qccVar.a(chatMsgModel.E().w().s(z7c.b()).g().H(new d8c() { // from class: com.baidu.tieba.gw8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.d8c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgChatCenterSliceViewModel.u(MsgChatCenterSliceViewModel.this, (Boolean) obj);
                    }
                }
            }));
            qccVar.a(chatMsgModel.D().w().s(z7c.b()).H(new d8c() { // from class: com.baidu.tieba.bw8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.d8c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgChatCenterSliceViewModel.v(MsgChatCenterSliceViewModel.this, obj);
                    }
                }
            }));
            qccVar.a(chatMsgModel.B().w().s(z7c.b()).H(new d8c() { // from class: com.baidu.tieba.aw8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.d8c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgChatCenterSliceViewModel.w(MsgChatCenterSliceViewModel.this, (Boolean) obj);
                    }
                }
            }));
            qccVar.a(NotificationChangedMonitor.c.a().f().H(new d8c() { // from class: com.baidu.tieba.dw8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.d8c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgChatCenterSliceViewModel.x(MsgChatCenterSliceViewModel.this, (Pair) obj);
                    }
                }
            }));
            this.e = qccVar;
        }
    }
}
