package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiDetailUserInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergeUtil;
import com.baidu.tieba.nt8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class nt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final EmojiData b;
    public final long c;
    public final BdUniqueId d;
    public FastRequest e;
    public volatile long f;

    /* loaded from: classes7.dex */
    public static final class a implements yo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt8 a;
        public final /* synthetic */ jt8 b;

        /* renamed from: com.baidu.tieba.nt8$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0396a extends FastRequest.b<MsgContentMergeUtil.Result> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jt8 c;
            public final /* synthetic */ int d;

            public C0396a(jt8 jt8Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jt8Var, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = jt8Var;
                this.d = i;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: i */
            public void d(int i, String errMsg, MsgContentMergeUtil.Result result) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, result) == null) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    this.c.onFailure(i, errMsg);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: j */
            public void g(MsgContentMergeUtil.Result result) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    ArrayList arrayList = new ArrayList();
                    Map<String, Object> userInfo = result.getUserInfo();
                    if (userInfo != null) {
                        for (Map.Entry<String, Object> entry : userInfo.entrySet()) {
                            arrayList.add(DataExt.toEntity(DataExt.toMap(entry.getValue()), EmojiDetailUserInfo.class));
                        }
                    }
                    jt8 jt8Var = this.c;
                    boolean z = true;
                    if (this.d != 1) {
                        z = false;
                    }
                    jt8Var.a(z, arrayList);
                }
            }
        }

        public a(nt8 nt8Var, jt8 jt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt8Var, jt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt8Var;
            this.b = jt8Var;
        }

        public static final void b(jt8 callback, int i, String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(65537, null, callback, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(callback, "$callback");
                Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
                callback.onFailure(i, errorMsg);
            }
        }

        public static final void c(nt8 this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                FastRequest fastRequest = this$0.e;
                if (fastRequest != null) {
                    fastRequest.O();
                }
            }
        }

        @Override // com.baidu.tieba.yo5
        public void a(int i, List<? extends IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail> details) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, details) == null) {
                Intrinsics.checkNotNullParameter(details, "details");
                if (this.a.e == null) {
                    nt8 nt8Var = this.a;
                    nt8Var.e = new FastRequest(nt8Var.a, CmdConfigHttp.CMD_GET_CHAT_ROOM_INIT_INFO, TbConfig.GET_CHAT_ROOM_INIT_INFO);
                    FastRequest fastRequest = this.a.e;
                    Intrinsics.checkNotNull(fastRequest);
                    fastRequest.setUniqueId(this.a.d);
                }
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(details, 10));
                for (IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail iMEmojiReplyReactionDetail : details) {
                    arrayList.add(iMEmojiReplyReactionDetail.bduk);
                }
                this.a.f = ((IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail) CollectionsKt___CollectionsKt.last((List<? extends Object>) details)).sortTimeUs;
                FastRequest fastRequest2 = this.a.e;
                Intrinsics.checkNotNull(fastRequest2);
                fastRequest2.N("scene", "2");
                fastRequest2.N("chatroom_id", String.valueOf(this.a.c));
                fastRequest2.N("uks", DataExt.toJson(arrayList));
                fastRequest2.V(2000);
                fastRequest2.Q(2000);
                fastRequest2.W(1);
                fastRequest2.P(new C0396a(this.b, i));
                final nt8 nt8Var2 = this.a;
                lg.g(new Runnable() { // from class: com.baidu.tieba.mt8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            nt8.a.c(nt8.this);
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.yo5
        public void onFailure(final int i, final String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                final jt8 jt8Var = this.b;
                lg.g(new Runnable() { // from class: com.baidu.tieba.lt8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            nt8.a.b(jt8.this, i, errorMsg);
                        }
                    }
                });
            }
        }
    }

    public nt8(TbPageContext<BaseFragmentActivity> pageContext, EmojiData emoji, long j, BdUniqueId uniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, emoji, Long.valueOf(j), uniqueId};
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
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        this.a = pageContext;
        this.b = emoji;
        this.c = j;
        this.d = uniqueId;
        this.f = 1L;
    }

    public final void g(jt8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            lo5.b().p(this.a.getPageActivity(), this.c, this.b.getMsgId(), this.b.getContent(), this.f, 20, new a(this, callback));
        }
    }
}
