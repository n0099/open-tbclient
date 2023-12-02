package com.baidu.tieba.im.under.common.uiliststyle.group.item;

import androidx.annotation.WorkerThread;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.base.core.uilist.Action;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbNoticeModifySysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.tieba.im.lib.socket.msg.data.TopBubbleData;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.NoticeModifySysItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/NoticeModifySysItem;", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lcom/baidu/tieba/im/lib/socket/msg/TbNoticeModifySysMsg;", "()V", "getType", "Lcom/baidu/adp/BdUniqueId;", "provideAction", "Lcom/baidu/tieba/im/base/core/uilist/Action;", "Companion", "im-under-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NoticeModifySysItem extends BaseItem<TbNoticeModifySysMsg> {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final BdUniqueId ADAPTER_TYPE;
    public static final a Companion;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    public static final Pair<Integer, Class<NoticeModifySysItem>> parsePair() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Companion.a() : (Pair) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        @JvmStatic
        public final Pair<Integer, Class<NoticeModifySysItem>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Pair<>(7001, NoticeModifySysItem.class);
            }
            return (Pair) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Action.a<BaseItem<TbNoticeModifySysMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public static final void b(BaseItem baseItem) {
            TbSysMsg.ChatRoomInfo chatroomInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, null, baseItem) == null) && (chatroomInfo = ((TbNoticeModifySysMsg) baseItem.getTbMsg()).getChatroomInfo()) != null) {
                TopBubbleData topBubbleData = new TopBubbleData();
                topBubbleData.setPinnedType("notice");
                topBubbleData.setContent(chatroomInfo.getNoticeContent());
                topBubbleData.setJumpTo(chatroomInfo.getNoticeUrl());
                topBubbleData.setVersionKey(chatroomInfo.getNoticeBubbleVersionKey());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921796, topBubbleData));
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.Action.a
        @WorkerThread
        public void a(Action.Op op, final BaseItem<TbNoticeModifySysMsg> baseItem, MsgProcessor.d source) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, op, baseItem, source) == null) {
                Intrinsics.checkNotNullParameter(op, "op");
                Intrinsics.checkNotNullParameter(source, "source");
                if (source.g() && baseItem != null && baseItem.getTbMsg() != null) {
                    UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.cz8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                NoticeModifySysItem.b.b(BaseItem.this);
                            }
                        }
                    });
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1492013753, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/NoticeModifySysItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1492013753, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/NoticeModifySysItem;");
                return;
            }
        }
        Companion = new a(null);
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        ADAPTER_TYPE = gen;
    }

    public NoticeModifySysItem() {
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

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem, java.lang.Object
    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem, com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem
    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbNoticeModifySysMsg tbMsg = getTbMsg();
            Action a2 = Action.a(tbMsg.getMsgId(), tbMsg.getMsgKey(), Action.Op.EXEC, new b());
            Intrinsics.checkNotNullExpressionValue(a2, "create(field.msgId,\n    …         }\n            })");
            return a2;
        }
        return (Action) invokeV.objValue;
    }
}
