package com.baidu.tieba.immessagecenter.msgtab.ui.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.cm8;
import com.baidu.tieba.htb;
import com.baidu.tieba.im.db.pojo.ChatSysNotifyPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.immessagecenter.im.model.MsgNotifyTabModel;
import com.baidu.tieba.immessagecenter.msgtab.data.NotifyType;
import com.baidu.tieba.jd8;
import com.baidu.tieba.r95;
import com.baidu.tieba.sxb;
import com.baidu.tieba.tm6;
import com.baidu.tieba.xsb;
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
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\tH\u0002J\u0016\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\"H\u0016J\b\u0010*\u001a\u00020\"H\u0016J\u0010\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u000200H\u0002J\u0006\u00101\u001a\u00020\"J\u0006\u00102\u001a\u00020\"R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011RJ\u0010\u0014\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n \u0015*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\t \u0015*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n \u0015*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\t\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000RJ\u0010\u001a\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001b \u0015*\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\t0\t \u0015*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001b \u0015*\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\t0\t\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\t0\u00048F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0007¨\u00063"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/MsgTabNotifyModel;", "Lcom/baidu/tieba/immessagecenter/arch/model/IModel;", "()V", "answerVisibleSubject", "Lrx/Observable;", "", "getAnswerVisibleSubject", "()Lrx/Observable;", "interactNotifyDataSubject", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgNotifyData;", "getInteractNotifyDataSubject", "mAnswerVisibleBs", "Lrx/subjects/BehaviorSubject;", "mDataRepository", "Lcom/baidu/tieba/immessagecenter/im/model/MsgNotifyTabModel;", "getMDataRepository", "()Lcom/baidu/tieba/immessagecenter/im/model/MsgNotifyTabModel;", "mDataRepository$delegate", "Lkotlin/Lazy;", "mInteractNotifyDataBs", "kotlin.jvm.PlatformType", "mMemoryListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mMsgInvitationListener", "mNewMessageListener", "mSystemNotifyDataBs", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "memoryInitCompleted", "systemNotifyDataSubject", "getSystemNotifyDataSubject", "getDefaultNotifyData", "getSystemNotifyList", "initNotifyModel", "", "list", "", "Lcom/baidu/tieba/im/db/pojo/ImMessageCenterPojo;", "mergeAndEmitNotifyData", "msgData", "Lcom/baidu/tbadk/data/NewsNotifyMessage;", "onAttachedUi", "onDetachedUi", "processMemoryChanged", "changeMessage", "Lcom/baidu/tieba/im/message/MemoryChangedMessage;", "processMemoryInitComplete", "message", "Lcom/baidu/tieba/im/message/MemoryInitCompleteMessage;", "registerListener", "unRegisterListener", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabNotifyModel implements jd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final sxb<Boolean> a;
    public final sxb<List<cm8>> b;
    public final sxb<List<ImMessageCenterShowItemData>> c;
    public final Lazy d;
    public boolean e;
    public final CustomMessageListener f;
    public final CustomMessageListener g;
    public final CustomMessageListener h;

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
                    this.a.s(memoryInitCompleteMessage);
                } else if (customResponsedMessage instanceof MemoryChangedMessage) {
                    MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                    if (memoryChangedMessage.getCmd() != 2016004 || !this.a.e) {
                        return;
                    }
                    this.a.r(memoryChangedMessage);
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
                    this.a.q(newsNotifyMessage);
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
        sxb<Boolean> O = sxb.O();
        Intrinsics.checkNotNullExpressionValue(O, "create()");
        this.a = O;
        this.b = sxb.O();
        this.c = sxb.O();
        this.d = LazyKt__LazyJVMKt.lazy(MsgTabNotifyModel$mDataRepository$2.INSTANCE);
        this.b.onNext(k());
        this.a.onNext(Boolean.valueOf(r95.p().l(r95.t("msg_tab_entrance_invitation_answer"), false)));
        this.f = new c(this);
        this.g = new b(this);
        this.h = new a(this);
    }

    public final List<ImMessageCenterShowItemData> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!tm6.a(m().getData())) {
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

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager.getInstance().registerListener(2016004, this.h);
            MessageManager.getInstance().registerListener(2016001, this.h);
            MessageManager.getInstance().registerListener(2016010, this.h);
            MessageManager.getInstance().registerListener(2016007, this.h);
            MessageManager.getInstance().registerListener(2016011, this.h);
            MessageManager.getInstance().registerListener(2016002, this.h);
            MessageManager.getInstance().registerListener(this.f);
            MessageManager.getInstance().registerListener(this.g);
        }
    }

    public final void p(List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            m().setData(list, null);
            this.c.onNext(o());
        }
    }

    @Override // com.baidu.tieba.jd8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            t();
        }
    }

    @Override // com.baidu.tieba.jd8
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u();
        }
    }

    public final xsb<Boolean> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            xsb<Boolean> s = this.a.a().w().s(htb.b());
            Intrinsics.checkNotNullExpressionValue(s, "mAnswerVisibleBs\n       …dSchedulers.mainThread())");
            return s;
        }
        return (xsb) invokeV.objValue;
    }

    public final xsb<List<cm8>> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            xsb<List<cm8>> s = this.b.a().w().s(htb.b());
            Intrinsics.checkNotNullExpressionValue(s, "mInteractNotifyDataBs\n  …dSchedulers.mainThread())");
            return s;
        }
        return (xsb) invokeV.objValue;
    }

    public final MsgNotifyTabModel m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (MsgNotifyTabModel) this.d.getValue();
        }
        return (MsgNotifyTabModel) invokeV.objValue;
    }

    public final xsb<List<ImMessageCenterShowItemData>> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            xsb<List<ImMessageCenterShowItemData>> s = this.c.a().w().s(htb.b());
            Intrinsics.checkNotNullExpressionValue(s, "mSystemNotifyDataBs\n    …dSchedulers.mainThread())");
            return s;
        }
        return (xsb) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    public final List<cm8> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return CollectionsKt__CollectionsKt.listOf((Object[]) new cm8[]{new cm8(NotifyType.AGREE_ME, 1), new cm8(NotifyType.REPLY_ME, 2), new cm8(NotifyType.AT_ME, 3), new cm8(NotifyType.FANS, 4)});
        }
        return (List) invokeV.objValue;
    }

    public final void q(NewsNotifyMessage newsNotifyMessage) {
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, newsNotifyMessage) == null) {
            List<cm8> k = k();
            for (ChatSysNotifyPojo chatSysNotifyPojo : newsNotifyMessage.getChatSysNotifys()) {
                Iterator<T> it = k.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((cm8) obj).a() == chatSysNotifyPojo.getType()) {
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
                cm8 cm8Var = (cm8) obj;
                if (cm8Var != null) {
                    cm8Var.e(chatSysNotifyPojo.getUnread());
                    cm8Var.d(chatSysNotifyPojo.getContent());
                }
            }
            this.b.onNext(k);
        }
    }

    public final void r(MemoryChangedMessage memoryChangedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, memoryChangedMessage) == null) {
            if (memoryChangedMessage.getType() == 1) {
                m().insertOrUpdate(memoryChangedMessage.getData(), null);
            } else if (memoryChangedMessage.getType() == 2) {
                m().remove(memoryChangedMessage.getData(), null);
            }
            this.c.onNext(o());
        }
    }

    public final void s(MemoryInitCompleteMessage memoryInitCompleteMessage) {
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
