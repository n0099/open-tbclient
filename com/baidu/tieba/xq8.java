package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergeUtil;
import com.baidu.tieba.xq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class xq8 extends l95<List<? extends ChatMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<BaseFragmentActivity> b;
    public FastRequest c;

    /* loaded from: classes8.dex */
    public static final class a extends FastRequest.b<MsgContentMergeUtil.Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xq8 b;
        public final /* synthetic */ long c;
        public final /* synthetic */ List<ChatMsg> d;

        public a(xq8 xq8Var, long j, List<? extends ChatMsg> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xq8Var, Long.valueOf(j), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xq8Var;
            this.c = j;
            this.d = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void h(xq8 this$0, List oriMsgList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, oriMsgList) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(oriMsgList, "$oriMsgList");
                this$0.a = oriMsgList;
            }
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List, T] */
        public static final void j(xq8 this$0, long j, MsgContentMergeUtil.Result result, List oriMsgList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{this$0, Long.valueOf(j), result, oriMsgList}) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(result, "$result");
                Intrinsics.checkNotNullParameter(oriMsgList, "$oriMsgList");
                this$0.a = MsgContentMergeUtil.a.a(j, result, oriMsgList);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void b(int i, String errMsg, MsgContentMergeUtil.Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, result) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.b(i, errMsg, result);
                final xq8 xq8Var = this.b;
                final List<ChatMsg> list = this.d;
                mg.e(new Runnable() { // from class: com.baidu.tieba.pq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            xq8.a.h(xq8.this, list);
                        }
                    }
                });
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: i */
        public void f(final MsgContentMergeUtil.Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.f(result);
                final xq8 xq8Var = this.b;
                final long j = this.c;
                final List<ChatMsg> list = this.d;
                mg.e(new Runnable() { // from class: com.baidu.tieba.sq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            xq8.a.j(xq8.this, j, result, list);
                        }
                    }
                });
            }
        }
    }

    public xq8(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
    }

    public static final void b(xq8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FastRequest fastRequest = this$0.c;
            if (fastRequest != null) {
                fastRequest.O();
            }
        }
    }

    @Override // com.baidu.tieba.q95
    public void a(Object... args) {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, args) == null) {
            Intrinsics.checkNotNullParameter(args, "args");
            Object obj = args[0];
            if (obj != null) {
                long longValue = ((Long) obj).longValue();
                Object obj2 = args[1];
                if (obj2 != null) {
                    List<ChatMsg> list = (List) obj2;
                    if (this.c == null && (tbPageContext = this.b) != null) {
                        Intrinsics.checkNotNull(tbPageContext);
                        this.c = new FastRequest(tbPageContext, CmdConfigHttp.CMD_GET_CHAT_ROOM_INIT_INFO, TbConfig.GET_CHAT_ROOM_INIT_INFO);
                        this.b = null;
                    }
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    for (ChatMsg chatMsg : list) {
                        String senderUid = chatMsg.getSenderUid();
                        Intrinsics.checkNotNullExpressionValue(senderUid, "it.senderUid");
                        arrayList.add(mo8.c(senderUid));
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    for (ChatMsg chatMsg2 : list) {
                        long msgId = chatMsg2.getMsgId();
                        String msgKey = chatMsg2.getMsgKey();
                        Intrinsics.checkNotNullExpressionValue(msgKey, "it.msgKey");
                        arrayList2.add(new MsgContentMergeUtil.ChatRoomInitInfo(msgId, msgKey));
                    }
                    FastRequest fastRequest = this.c;
                    Intrinsics.checkNotNull(fastRequest);
                    fastRequest.N("chatroom_id", String.valueOf(longValue));
                    fastRequest.N("uks", DataExt.toJson(arrayList));
                    fastRequest.N("msgs", DataExt.toJson(arrayList2));
                    fastRequest.V(2000);
                    fastRequest.Q(2000);
                    fastRequest.W(1);
                    fastRequest.P(new a(this, longValue, list));
                    mg.g(new Runnable() { // from class: com.baidu.tieba.rq8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                xq8.b(xq8.this);
                            }
                        }
                    });
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.baidu.android.imsdk.chatmessage.messages.ChatMsg>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
    }

    @Override // com.baidu.tieba.q95
    public void onDestroy() {
        FastRequest fastRequest;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (fastRequest = this.c) != null) {
            fastRequest.onDestroy();
        }
    }
}
