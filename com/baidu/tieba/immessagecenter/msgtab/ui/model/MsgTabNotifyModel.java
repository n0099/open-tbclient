package com.baidu.tieba.immessagecenter.msgtab.ui.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.fl6;
import com.baidu.tieba.i1c;
import com.baidu.tieba.im.db.pojo.ChatSysNotifyPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.immessagecenter.im.model.MsgNotifyTabModel;
import com.baidu.tieba.immessagecenter.msgtab.data.NotifyType;
import com.baidu.tieba.immessagecenter.msgtab.ui.model.MsgTabNotifyModel;
import com.baidu.tieba.np8;
import com.baidu.tieba.oa8;
import com.baidu.tieba.t5c;
import com.baidu.tieba.y0c;
import com.baidu.tieba.yf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\tH\u0002J\u0016\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020$H\u0016J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0002J\u0006\u00103\u001a\u00020$J\u0006\u00104\u001a\u00020$R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013RJ\u0010\u0016\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n \u0017*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\t \u0017*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n \u0017*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\t\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000RJ\u0010\u001c\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001d \u0017*\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t0\t \u0017*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001d \u0017*\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t0\t\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\t0\u00048F¢\u0006\u0006\u001a\u0004\b \u0010\u0007¨\u00065"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/MsgTabNotifyModel;", "Lcom/baidu/tieba/immessagecenter/arch/model/IModel;", "()V", "answerVisibleSubject", "Lrx/Observable;", "", "getAnswerVisibleSubject", "()Lrx/Observable;", "interactNotifyDataSubject", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgNotifyData;", "getInteractNotifyDataSubject", "mAnswerVisibleBs", "Lrx/subjects/BehaviorSubject;", "mCompleteProcess", "Lcom/baidu/tieba/im/chat/notify/ICompleteProcess;", "mDataRepository", "Lcom/baidu/tieba/immessagecenter/im/model/MsgNotifyTabModel;", "getMDataRepository", "()Lcom/baidu/tieba/immessagecenter/im/model/MsgNotifyTabModel;", "mDataRepository$delegate", "Lkotlin/Lazy;", "mInteractNotifyDataBs", "kotlin.jvm.PlatformType", "mMemoryListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mMsgInvitationListener", "mNewMessageListener", "mSystemNotifyDataBs", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "memoryInitCompleted", "systemNotifyDataSubject", "getSystemNotifyDataSubject", "getDefaultNotifyData", "getSystemNotifyList", "initNotifyModel", "", "list", "", "Lcom/baidu/tieba/im/db/pojo/ImMessageCenterPojo;", "mergeAndEmitNotifyData", "msgData", "Lcom/baidu/tbadk/data/NewsNotifyMessage;", "onAttachedUi", "onDetachedUi", "processMemoryChanged", "changeMessage", "Lcom/baidu/tieba/im/message/MemoryChangedMessage;", "processMemoryInitComplete", "message", "Lcom/baidu/tieba/im/message/MemoryInitCompleteMessage;", "registerListener", "unRegisterListener", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabNotifyModel implements yf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t5c<Boolean> a;
    public final t5c<List<np8>> b;
    public final t5c<List<ImMessageCenterShowItemData>> c;
    public final Lazy d;
    public boolean e;
    public final oa8 f;
    public final CustomMessageListener g;
    public final CustomMessageListener h;
    public final CustomMessageListener i;

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgTabNotifyModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MsgTabNotifyModel msgTabNotifyModel) {
            super(0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgTabNotifyModel};
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
            this.a = msgTabNotifyModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<ImMessageCenterPojo> data;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage instanceof MemoryInitCompleteMessage) {
                    MemoryInitCompleteMessage memoryInitCompleteMessage = (MemoryInitCompleteMessage) customResponsedMessage;
                    if (memoryInitCompleteMessage.getCmd() != 2016002) {
                        return;
                    }
                    this.a.t(memoryInitCompleteMessage);
                } else if (customResponsedMessage instanceof MemoryChangedMessage) {
                    MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                    if (memoryChangedMessage.getCmd() != 2016004 || !this.a.e) {
                        return;
                    }
                    this.a.s(memoryChangedMessage);
                } else if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
                    ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
                    if (responsedMemoryListMessage.getCmd() != 2016007 || !this.a.e || (data = responsedMemoryListMessage.getData()) == null) {
                        return;
                    }
                    this.a.p(data);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgTabNotifyModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MsgTabNotifyModel msgTabNotifyModel) {
            super(2921726);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgTabNotifyModel};
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
            this.a = msgTabNotifyModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                boolean z = false;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921726) {
                    z = true;
                }
                if (z) {
                    this.a.a.onNext(Boolean.TRUE);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgTabNotifyModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MsgTabNotifyModel msgTabNotifyModel) {
            super(2001120);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgTabNotifyModel};
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
            this.a = msgTabNotifyModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg instanceof NewsNotifyMessage) {
                    NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) msg;
                    if (newsNotifyMessage.getCmd() != 2001120) {
                        return;
                    }
                    this.a.r(newsNotifyMessage);
                }
            }
        }
    }

    public MsgTabNotifyModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        t5c<Boolean> Q = t5c.Q();
        Intrinsics.checkNotNullExpressionValue(Q, "create()");
        this.a = Q;
        this.b = t5c.Q();
        this.c = t5c.Q();
        this.d = LazyKt__LazyJVMKt.lazy(MsgTabNotifyModel$mDataRepository$2.INSTANCE);
        this.b.onNext(k());
        this.a.onNext(Boolean.valueOf(SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("msg_tab_entrance_invitation_answer"), false)));
        this.f = new oa8() { // from class: com.baidu.tieba.nq8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.oa8
            public final void onComplete() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    MsgTabNotifyModel.q(MsgTabNotifyModel.this);
                }
            }
        };
        this.g = new c(this);
        this.h = new b(this);
        this.i = new a(this);
    }

    public final List<ImMessageCenterShowItemData> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!fl6.a(m().getData())) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                List<ImMessageCenterShowItemData> data = m().getData();
                Intrinsics.checkNotNullExpressionValue(data, "mDataRepository.data");
                for (ImMessageCenterShowItemData item : data) {
                    if (!linkedHashSet.contains(item.getFriendId())) {
                        String friendId = item.getFriendId();
                        Intrinsics.checkNotNullExpressionValue(friendId, "item.friendId");
                        linkedHashSet.add(friendId);
                        Intrinsics.checkNotNullExpressionValue(item, "item");
                        arrayList.add(item);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager.getInstance().registerListener(2016004, this.i);
            MessageManager.getInstance().registerListener(2016001, this.i);
            MessageManager.getInstance().registerListener(2016010, this.i);
            MessageManager.getInstance().registerListener(2016007, this.i);
            MessageManager.getInstance().registerListener(2016011, this.i);
            MessageManager.getInstance().registerListener(2016002, this.i);
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public static final void q(MsgTabNotifyModel this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.onNext(this$0.o());
        }
    }

    public final void p(List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            m().setData(list, this.f);
        }
    }

    @Override // com.baidu.tieba.yf8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u();
        }
    }

    @Override // com.baidu.tieba.yf8
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v();
        }
    }

    public final y0c<Boolean> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            y0c<Boolean> s = this.a.a().w().s(i1c.b());
            Intrinsics.checkNotNullExpressionValue(s, "mAnswerVisibleBs\n       …dSchedulers.mainThread())");
            return s;
        }
        return (y0c) invokeV.objValue;
    }

    public final y0c<List<np8>> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            y0c<List<np8>> s = this.b.a().w().s(i1c.b());
            Intrinsics.checkNotNullExpressionValue(s, "mInteractNotifyDataBs\n  …dSchedulers.mainThread())");
            return s;
        }
        return (y0c) invokeV.objValue;
    }

    public final MsgNotifyTabModel m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (MsgNotifyTabModel) this.d.getValue();
        }
        return (MsgNotifyTabModel) invokeV.objValue;
    }

    public final y0c<List<ImMessageCenterShowItemData>> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            y0c<List<ImMessageCenterShowItemData>> s = this.c.a().w().s(i1c.b());
            Intrinsics.checkNotNullExpressionValue(s, "mSystemNotifyDataBs\n    …dSchedulers.mainThread())");
            return s;
        }
        return (y0c) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.i);
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public final List<np8> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return CollectionsKt__CollectionsKt.listOf((Object[]) new np8[]{new np8(NotifyType.AGREE_ME, 1), new np8(NotifyType.REPLY_ME, 2), new np8(NotifyType.AT_ME, 3), new np8(NotifyType.FANS, 4)});
        }
        return (List) invokeV.objValue;
    }

    public final void r(NewsNotifyMessage newsNotifyMessage) {
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, newsNotifyMessage) == null) {
            List<np8> k = k();
            for (ChatSysNotifyPojo chatSysNotifyPojo : newsNotifyMessage.getChatSysNotifys()) {
                Iterator<T> it = k.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((np8) obj).a() == chatSysNotifyPojo.getType()) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                np8 np8Var = (np8) obj;
                if (np8Var != null) {
                    np8Var.e(chatSysNotifyPojo.getUnread());
                    np8Var.d(chatSysNotifyPojo.getContent());
                }
            }
            this.b.onNext(k);
        }
    }

    public final void s(MemoryChangedMessage memoryChangedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, memoryChangedMessage) == null) {
            if (memoryChangedMessage.getType() == 1) {
                m().insertOrUpdate(memoryChangedMessage.getData(), this.f);
            } else if (memoryChangedMessage.getType() == 2) {
                m().remove(memoryChangedMessage.getData(), this.f);
            }
        }
    }

    public final void t(MemoryInitCompleteMessage memoryInitCompleteMessage) {
        Boolean data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, memoryInitCompleteMessage) == null) && (data = memoryInitCompleteMessage.getData()) != null) {
            if (!data.booleanValue()) {
                data = null;
            }
            if (data != null) {
                this.e = true;
                MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
            }
        }
    }
}
