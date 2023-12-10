package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.im.lib.socket.msg.data.TopBubbleData;
import com.baidu.tieba.v39;
import com.baidu.tieba.w39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007*\u0002\u0012\u001d\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001f\u001a\u00020\u0015J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0018\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0015H\u0002J\u0006\u0010(\u001a\u00020!J\u0014\u0010)\u001a\u00020!2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0+J\u0006\u0010,\u001a\u00020\u0015J\u0006\u0010-\u001a\u00020!J\u0010\u0010-\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0015H\u0002J\u000e\u0010.\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010/\u001a\u00020!J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\tH\u0002R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0017\u0010\u000bR!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001a\u0010\u000bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/bubble/topbubble/PinnedModel;", "", "wrapper", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/bubble/topbubble/PinnedSliceWrapper;", "roomId", "", "(Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/bubble/topbubble/PinnedSliceWrapper;Ljava/lang/String;)V", "activityList", "Ljava/util/LinkedList;", "Lcom/baidu/tieba/im/lib/socket/msg/data/TopBubbleData;", "getActivityList", "()Ljava/util/LinkedList;", "activityList$delegate", "Lkotlin/Lazy;", "excellentList", "getExcellentList", "excellentList$delegate", "hideNoticeListener", "com/baidu/tieba/immessagecenter/chatgroup/grouppage/bubble/topbubble/PinnedModel$hideNoticeListener$1", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/bubble/topbubble/PinnedModel$hideNoticeListener$1;", "isOverlay", "", "noticeList", "getNoticeList", "noticeList$delegate", "pinnedList", "getPinnedList", "pinnedList$delegate", "pinnedUpdateListener", "com/baidu/tieba/immessagecenter/chatgroup/grouppage/bubble/topbubble/PinnedModel$pinnedUpdateListener$1", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/bubble/topbubble/PinnedModel$pinnedUpdateListener$1;", "excellentShowListFillIn", "handleExcellentListStrategy", "", "firstIsExcellent", "handlePinnedList", "data", "isInsert", "handlePinnedStatus", "isInit", "hideExcellentMsg", "initPinnedList", "dataList", "", "isExistExcellent", "notifyDataChange", "notifyPinnedListByFirst", MissionEvent.MESSAGE_DESTROY, "removeExcellentMsg", "excellent", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PinnedModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final v39 a;
    public final String b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public boolean g;
    public final a h;
    public final b i;

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PinnedModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PinnedModel pinnedModel) {
            super(2921795);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pinnedModel};
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
            this.a = pinnedModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !this.a.i().isEmpty()) {
                w39.f(((TopBubbleData) this.a.i().get(0)).getVersionKey(), true);
                this.a.i().clear();
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PinnedModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PinnedModel pinnedModel) {
            super(2921796);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pinnedModel};
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
            this.a = pinnedModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    TopBubbleData topBubbleData = (TopBubbleData) data;
                    if (topBubbleData.isExcellent()) {
                        if (!w39.a(topBubbleData.getVersionKey(), this.a.b)) {
                            return;
                        }
                        if (!topBubbleData.isSetExcellent()) {
                            this.a.u(topBubbleData);
                            this.a.q();
                            return;
                        }
                    }
                    if (topBubbleData.isActivity()) {
                        if (!this.a.g().isEmpty() && ((TopBubbleData) this.a.g().get(0)).getActivityID() == topBubbleData.getActivityID()) {
                            ((TopBubbleData) this.a.g().get(0)).setActivityStatus(topBubbleData.getActivityStatus());
                            this.a.q();
                            return;
                        }
                        return;
                    }
                    this.a.l(topBubbleData, true);
                    this.a.q();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.im.lib.socket.msg.data.TopBubbleData");
            }
        }
    }

    public PinnedModel(v39 wrapper, String roomId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wrapper, roomId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.a = wrapper;
        this.b = roomId;
        this.c = LazyKt__LazyJVMKt.lazy(PinnedModel$pinnedList$2.INSTANCE);
        this.d = LazyKt__LazyJVMKt.lazy(PinnedModel$activityList$2.INSTANCE);
        this.e = LazyKt__LazyJVMKt.lazy(PinnedModel$noticeList$2.INSTANCE);
        this.f = LazyKt__LazyJVMKt.lazy(PinnedModel$excellentList$2.INSTANCE);
        this.h = new a(this);
        this.i = new b(this);
        MessageManager.getInstance().registerListener(this.h);
        MessageManager.getInstance().registerListener(this.i);
    }

    public final void l(TopBubbleData topBubbleData, boolean z) {
        String pinnedType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048582, this, topBubbleData, z) == null) && (pinnedType = topBubbleData.getPinnedType()) != null) {
            int hashCode = pinnedType.hashCode();
            if (hashCode != -1655966961) {
                if (hashCode != -1420194824) {
                    if (hashCode == -1039690024 && pinnedType.equals("notice") && !w39.b(topBubbleData.getVersionKey())) {
                        i().clear();
                        i().add(topBubbleData);
                    }
                } else if (pinnedType.equals(TopBubbleData.EXCELLENT)) {
                    if (z) {
                        h().add(0, topBubbleData);
                    } else {
                        h().add(topBubbleData);
                    }
                }
            } else if (pinnedType.equals("activity") && w39.c(topBubbleData)) {
                g().add(topBubbleData);
            }
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048589, this, z) != null) || j().isEmpty()) {
            return;
        }
        this.g = z;
        q();
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (g().isEmpty() && i().isEmpty()) {
                if (h().size() >= 6) {
                    return true;
                }
                return false;
            } else if (h().size() >= 5) {
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (j().isEmpty()) {
                return false;
            }
            for (TopBubbleData topBubbleData : j()) {
                if (topBubbleData.isExcellent()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final LinkedList<TopBubbleData> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (LinkedList) this.d.getValue();
        }
        return (LinkedList) invokeV.objValue;
    }

    public final LinkedList<TopBubbleData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (LinkedList) this.f.getValue();
        }
        return (LinkedList) invokeV.objValue;
    }

    public final LinkedList<TopBubbleData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (LinkedList) this.e.getValue();
        }
        return (LinkedList) invokeV.objValue;
    }

    public final LinkedList<TopBubbleData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (LinkedList) this.c.getValue();
        }
        return (LinkedList) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || h().isEmpty()) {
            return;
        }
        w39.e(h().get(0).getVersionKey(), this.b);
        q();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            r(false);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (!h().isEmpty() && !w39.a(h().getFirst().getVersionKey(), this.b)) {
                return;
            }
            if (!z) {
                if (h().size() >= 5) {
                    j().addAll(h().subList(0, 5));
                } else {
                    j().addAll(h());
                }
            } else if (h().size() >= 6) {
                j().addAll(h().subList(0, 6));
            } else {
                j().addAll(h());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
        if (r0.equals("notice") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
        if (r0.equals("activity") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
        if (r8.g == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
        r0 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0070, code lost:
        r0 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0071, code lost:
        r9.setStatusType(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                if (j().size() > 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.g = z2;
            }
            TopBubbleData topBubbleData = j().get(0);
            Intrinsics.checkNotNullExpressionValue(topBubbleData, "pinnedList[0]");
            TopBubbleData topBubbleData2 = topBubbleData;
            String pinnedType = topBubbleData2.getPinnedType();
            if (pinnedType != null) {
                int hashCode = pinnedType.hashCode();
                if (hashCode != -1655966961) {
                    if (hashCode != -1420194824) {
                        if (hashCode == -1039690024) {
                        }
                    } else if (pinnedType.equals(TopBubbleData.EXCELLENT)) {
                        topBubbleData2.setStatusType(!w39.b(topBubbleData2.getVersionKey()) ? 1 : 0);
                    }
                }
            }
            if (j().size() > 2) {
                TopBubbleData topBubbleData3 = j().get(1);
                Intrinsics.checkNotNullExpressionValue(topBubbleData3, "pinnedList[1]");
                TopBubbleData topBubbleData4 = topBubbleData3;
                String pinnedType2 = topBubbleData4.getPinnedType();
                if (Intrinsics.areEqual(pinnedType2, "notice")) {
                    topBubbleData4.setStatusType(2);
                } else if (Intrinsics.areEqual(pinnedType2, TopBubbleData.EXCELLENT)) {
                    topBubbleData4.setStatusType(!w39.b(topBubbleData2.getVersionKey()) ? 1 : 0);
                }
            }
            if (j().size() > 3) {
                int size = j().size();
                for (int i = 2; i < size; i++) {
                    TopBubbleData topBubbleData5 = j().get(i);
                    Intrinsics.checkNotNullExpressionValue(topBubbleData5, "pinnedList[index]");
                    TopBubbleData topBubbleData6 = topBubbleData5;
                    topBubbleData6.setStatusType(!w39.b(topBubbleData6.getVersionKey()) ? 1 : 0);
                }
            }
        }
    }

    public final void o(List<? extends TopBubbleData> dataList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dataList) == null) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            if (dataList.isEmpty()) {
                this.a.f();
                return;
            }
            for (TopBubbleData topBubbleData : dataList) {
                l(topBubbleData, false);
            }
            r(true);
        }
    }

    public final void u(TopBubbleData topBubbleData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, topBubbleData) == null) {
            long msgId = topBubbleData.getMsgId();
            Iterator<TopBubbleData> it = h().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "excellentList.iterator()");
            while (it.hasNext()) {
                TopBubbleData next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (next.getMsgId() == msgId) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public final void r(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            j().clear();
            j().addAll(g());
            j().addAll(i());
            if (j().size() <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            k(z2);
            if (j().size() > 0) {
                m(z);
                this.a.r(j());
                return;
            }
            this.a.f();
        }
    }
}
