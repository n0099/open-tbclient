package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.UiUtils;
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
import com.baidu.tieba.o49;
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
public final class o49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final EmojiData b;
    public final long c;
    public final BdUniqueId d;
    public FastRequest e;
    public volatile long f;

    /* loaded from: classes7.dex */
    public static final class a implements el5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o49 a;
        public final /* synthetic */ k49 b;

        /* renamed from: com.baidu.tieba.o49$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0413a extends FastRequest.b<MsgContentMergeUtil.Result> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k49 d;
            public final /* synthetic */ int e;

            public C0413a(k49 k49Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k49Var, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = k49Var;
                this.e = i;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: l */
            public void f(int i, String errMsg, MsgContentMergeUtil.Result result) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, result) == null) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    this.d.onFailure(i, errMsg);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: m */
            public void i(MsgContentMergeUtil.Result result) {
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
                    k49 k49Var = this.d;
                    boolean z = true;
                    if (this.e != 1) {
                        z = false;
                    }
                    k49Var.a(z, arrayList);
                }
            }
        }

        public a(o49 o49Var, k49 k49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o49Var, k49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o49Var;
            this.b = k49Var;
        }

        public static final void b(k49 callback, int i, String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(65537, null, callback, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(callback, "$callback");
                Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
                callback.onFailure(i, errorMsg);
            }
        }

        public static final void c(o49 this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                FastRequest fastRequest = this$0.e;
                if (fastRequest != null) {
                    fastRequest.Q();
                }
            }
        }

        @Override // com.baidu.tieba.el5
        public void a(int i, List<? extends IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail> details) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, details) == null) {
                Intrinsics.checkNotNullParameter(details, "details");
                if (this.a.e == null) {
                    o49 o49Var = this.a;
                    o49Var.e = new FastRequest(o49Var.a, CmdConfigHttp.CMD_GET_CHAT_ROOM_INIT_INFO, TbConfig.GET_CHAT_ROOM_INIT_INFO);
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
                fastRequest2.P("scene", "2");
                fastRequest2.P("chatroom_id", String.valueOf(this.a.c));
                fastRequest2.P("uks", DataExt.toJson(arrayList));
                fastRequest2.X(2000);
                fastRequest2.S(2000);
                fastRequest2.Z(1);
                fastRequest2.R(new C0413a(this.b, i));
                final o49 o49Var2 = this.a;
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.n49
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            o49.a.c(o49.this);
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.el5
        public void onFailure(final int i, final String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                final k49 k49Var = this.b;
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.m49
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            o49.a.b(k49.this, i, errorMsg);
                        }
                    }
                });
            }
        }
    }

    public o49(TbPageContext<BaseFragmentActivity> pageContext, EmojiData emoji, long j, BdUniqueId uniqueId) {
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

    public final void g(k49 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            rk5.b().p(this.a.getPageActivity(), this.c, this.b.getMsgId(), this.b.getContent(), this.f, 20, new a(this, callback));
        }
    }
}
