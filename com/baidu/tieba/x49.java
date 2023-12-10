package com.baidu.tieba;

import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergeUtil;
import com.baidu.tieba.x49;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class x49 extends a55<List<? extends ChatMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<BaseFragmentActivity> b;
    public FastRequest c;

    /* loaded from: classes9.dex */
    public static final class a extends FastRequest.b<MsgContentMergeUtil.Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x49 d;
        public final /* synthetic */ long e;
        public final /* synthetic */ List<ChatMsg> f;

        public a(x49 x49Var, long j, List<? extends ChatMsg> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x49Var, Long.valueOf(j), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x49Var;
            this.e = j;
            this.f = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void m(x49 this$0, List oriMsgList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, oriMsgList) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(oriMsgList, "$oriMsgList");
                this$0.a = oriMsgList;
            }
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List, T] */
        public static final void o(x49 this$0, long j, MsgContentMergeUtil.Result result, List oriMsgList) {
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
        /* renamed from: l */
        public void f(int i, String errMsg, MsgContentMergeUtil.Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, result) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.f(i, errMsg, result);
                final x49 x49Var = this.d;
                final List<ChatMsg> list = this.f;
                UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.p49
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            x49.a.m(x49.this, list);
                        }
                    }
                });
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: n */
        public void i(final MsgContentMergeUtil.Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.i(result);
                final x49 x49Var = this.d;
                final long j = this.e;
                final List<ChatMsg> list = this.f;
                UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.s49
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            x49.a.o(x49.this, j, result, list);
                        }
                    }
                });
            }
        }
    }

    public x49(TbPageContext<BaseFragmentActivity> tbPageContext) {
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

    public static final void b(x49 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FastRequest fastRequest = this$0.c;
            if (fastRequest != null) {
                fastRequest.Q();
            }
        }
    }

    @Override // com.baidu.tieba.f55
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
                        arrayList.add(aw8.c(senderUid));
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
                    fastRequest.P("chatroom_id", String.valueOf(longValue));
                    fastRequest.P("uks", DataExt.toJson(arrayList));
                    fastRequest.P("msgs", DataExt.toJson(arrayList2));
                    fastRequest.X(2000);
                    fastRequest.S(2000);
                    fastRequest.Z(1);
                    fastRequest.R(new a(this, longValue, list));
                    UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.r49
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                x49.b(x49.this);
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

    @Override // com.baidu.tieba.f55
    public void onDestroy() {
        FastRequest fastRequest;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (fastRequest = this.c) != null) {
            fastRequest.onDestroy();
        }
    }
}
