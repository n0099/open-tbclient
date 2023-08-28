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
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiDetailUserInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergeUtil;
import com.baidu.tieba.oo8;
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
public final class oo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final EmojiData b;
    public final long c;
    public final BdUniqueId d;
    public FastRequest e;
    public volatile long f;

    /* loaded from: classes7.dex */
    public static final class a implements bo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oo8 a;
        public final /* synthetic */ jo8 b;

        /* renamed from: com.baidu.tieba.oo8$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0430a extends FastRequest.b<MsgContentMergeUtil.Result> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jo8 b;
            public final /* synthetic */ int c;

            public C0430a(jo8 jo8Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jo8Var, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jo8Var;
                this.c = i;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: f */
            public void b(int i, String errMsg, MsgContentMergeUtil.Result result) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, result) == null) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    this.b.onFailure(i, errMsg);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: g */
            public void e(MsgContentMergeUtil.Result result) {
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
                    jo8 jo8Var = this.b;
                    boolean z = true;
                    if (this.c != 1) {
                        z = false;
                    }
                    jo8Var.a(z, arrayList);
                }
            }
        }

        public a(oo8 oo8Var, jo8 jo8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo8Var, jo8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oo8Var;
            this.b = jo8Var;
        }

        public static final void b(jo8 callback, int i, String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(65537, null, callback, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(callback, "$callback");
                Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
                callback.onFailure(i, errorMsg);
            }
        }

        public static final void c(oo8 this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                FastRequest fastRequest = this$0.e;
                if (fastRequest != null) {
                    fastRequest.P();
                }
            }
        }

        @Override // com.baidu.tieba.bo5
        public void a(int i, List<? extends IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail> details) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, details) == null) {
                Intrinsics.checkNotNullParameter(details, "details");
                if (this.a.e == null) {
                    oo8 oo8Var = this.a;
                    oo8Var.e = new FastRequest(oo8Var.a, CmdConfigHttp.CMD_GET_CHAT_ROOM_INIT_INFO, TbConfig.GET_CHAT_ROOM_INIT_INFO);
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
                fastRequest2.O("scene", "2");
                fastRequest2.O("chatroom_id", String.valueOf(this.a.c));
                fastRequest2.O("uks", DataExt.toJson(arrayList));
                fastRequest2.W(2000);
                fastRequest2.R(2000);
                fastRequest2.X(1);
                fastRequest2.Q(new C0430a(this.b, i));
                final oo8 oo8Var2 = this.a;
                lg.g(new Runnable() { // from class: com.baidu.tieba.no8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            oo8.a.c(oo8.this);
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.bo5
        public void onFailure(final int i, final String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                final jo8 jo8Var = this.b;
                lg.g(new Runnable() { // from class: com.baidu.tieba.mo8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            oo8.a.b(jo8.this, i, errorMsg);
                        }
                    }
                });
            }
        }
    }

    public oo8(TbPageContext<BaseFragmentActivity> pageContext, EmojiData emoji, long j, BdUniqueId uniqueId) {
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

    public final void g(jo8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            on5.b().p(this.a.getPageActivity(), this.c, this.b.getMsgId(), this.b.getContent(), this.f, 20, new a(this, callback));
        }
    }
}
