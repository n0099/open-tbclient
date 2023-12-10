package com.baidu.tieba;

import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergeUtil;
import com.baidu.tieba.w49;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class w49 extends a55<List<? extends ChatMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> b;
    public List<? extends ChatMsg> c;

    @Override // com.baidu.tieba.f55
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static final class a implements fl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w49 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ List<ChatMsg> c;

        public a(w49 w49Var, long j, List<? extends ChatMsg> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w49Var, Long.valueOf(j), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w49Var;
            this.b = j;
            this.c = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void a(w49 this$0, List oriMsgList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, oriMsgList) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(oriMsgList, "$oriMsgList");
                this$0.a = oriMsgList;
            }
        }

        @Override // com.baidu.tieba.fl5
        public void onFailure(int i, String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                final w49 w49Var = this.a;
                final List<ChatMsg> list = this.c;
                UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.t49
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            w49.a.a(w49.this, list);
                        }
                    }
                });
            }
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List, T] */
        public static final void b(w49 this$0, long j, MsgContentMergeUtil.Result result, List oriMsgList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{this$0, Long.valueOf(j), result, oriMsgList}) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(result, "$result");
                Intrinsics.checkNotNullParameter(oriMsgList, "$oriMsgList");
                this$0.a = MsgContentMergeUtil.a.a(j, result, oriMsgList);
            }
        }

        @Override // com.baidu.tieba.fl5
        public void onSuccess(Map<Long, ? extends ArrayList<IMEmojiReplyListListener.IMEmojiItem>> emojiItemMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emojiItemMap) == null) {
                Intrinsics.checkNotNullParameter(emojiItemMap, "emojiItemMap");
                Map c = this.a.c(emojiItemMap);
                ArrayList arrayList = new ArrayList(c.size());
                for (Iterator it = c.entrySet().iterator(); it.hasNext(); it = it) {
                    Map.Entry entry = (Map.Entry) it.next();
                    arrayList.add(Boolean.valueOf(((ArrayList) entry.getValue()).add(new EmojiData("", ((Number) entry.getKey()).longValue(), "", 0, 0L, Boolean.TRUE, 0))));
                }
                final MsgContentMergeUtil.Result result = new MsgContentMergeUtil.Result(null, null, c);
                final w49 w49Var = this.a;
                final long j = this.b;
                final List<ChatMsg> list = this.c;
                UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.q49
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            w49.a.b(w49.this, j, result, list);
                        }
                    }
                });
            }
        }
    }

    public w49(TbPageContext<BaseFragmentActivity> pageContext) {
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
        this.b = pageContext;
        this.c = new ArrayList(10);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.sk5 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.f55
    public void a(Object... args) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, args) == null) {
            Intrinsics.checkNotNullParameter(args, "args");
            Object obj = args[0];
            if (obj != null) {
                long longValue = ((Long) obj).longValue();
                Object obj2 = args[1];
                if (obj2 != null) {
                    rk5.b().i(this.b.getPageActivity(), longValue, this.c, new a(this, longValue, (List) obj2));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.baidu.android.imsdk.chatmessage.messages.ChatMsg>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
    }

    public final Map<Long, ArrayList<EmojiData>> c(Map<Long, ? extends ArrayList<IMEmojiReplyListListener.IMEmojiItem>> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            HashMap hashMap = new HashMap();
            Iterator<Map.Entry<Long, ? extends ArrayList<IMEmojiReplyListListener.IMEmojiItem>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Long, ? extends ArrayList<IMEmojiReplyListListener.IMEmojiItem>> next = it.next();
                long longValue = next.getKey().longValue();
                ArrayList arrayList = new ArrayList();
                Iterator<IMEmojiReplyListListener.IMEmojiItem> it2 = next.getValue().iterator();
                while (it2.hasNext()) {
                    IMEmojiReplyListListener.IMEmojiItem next2 = it2.next();
                    String str = next2.emojiContent;
                    Intrinsics.checkNotNullExpressionValue(str, "item.emojiContent");
                    long j = next2.msgId;
                    String str2 = next2.msgKey;
                    Intrinsics.checkNotNullExpressionValue(str2, "item.msgKey");
                    arrayList.add(new EmojiData(str, j, str2, next2.allNum, next2.minSortTimeUs, Boolean.FALSE, Integer.valueOf(next2.hasReacted)));
                    it = it;
                }
                hashMap.put(Long.valueOf(longValue), arrayList);
                it = it;
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.List<? extends com.baidu.android.imsdk.chatmessage.messages.ChatMsg>, java.util.List<com.baidu.android.imsdk.chatmessage.messages.ChatMsg> */
    public final List<ChatMsg> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }
}
