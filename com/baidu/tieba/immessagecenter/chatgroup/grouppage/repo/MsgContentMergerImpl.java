package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo;

import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.f58;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergerImpl;
import com.baidu.tieba.ng;
import com.baidu.tieba.s48;
import com.baidu.tieba.uh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0018B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005JG\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2'\u0010\u000f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\t0\u0010H\u0016J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergerImpl;", "Lcom/baidu/tbadk/module/alalivesdk/interfaces/MsgContentMerger;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "(Lcom/baidu/tbadk/TbPageContext;)V", "request", "Lcom/baidu/tbadk/net/FastRequest;", "doMerge", "", "roomId", "", "oriMsgList", "", "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;", WebChromeClient.KEY_ARG_CALLBACK, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mergedMsgList", "mergeContent", "result", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergerImpl$Result;", MissionEvent.MESSAGE_DESTROY, "Result", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MsgContentMergerImpl implements uh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public FastRequest b;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergerImpl$Result;", "Ljava/io/Serializable;", "userInfo", "", "", "", "(Ljava/util/Map;)V", "getUserInfo", "()Ljava/util/Map;", "component1", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Result implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("user_info")
        public final Map<String, Object> userInfo;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergerImpl$Result */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = result.userInfo;
            }
            return result.copy(map);
        }

        public final Map<String, Object> component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.userInfo : (Map) invokeV.objValue;
        }

        public final Result copy(Map<String, ? extends Object> userInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userInfo)) == null) {
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                return new Result(userInfo);
            }
            return (Result) invokeL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Result) && Intrinsics.areEqual(this.userInfo, ((Result) obj).userInfo);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.userInfo.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "Result(userInfo=" + this.userInfo + ')';
            }
            return (String) invokeV.objValue;
        }

        public Result(Map<String, ? extends Object> userInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            this.userInfo = userInfo;
        }

        public final Map<String, Object> getUserInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.userInfo;
            }
            return (Map) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends FastRequest.b<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function1<List<? extends ChatMsg>, Unit> b;
        public final /* synthetic */ MsgContentMergerImpl c;
        public final /* synthetic */ long d;
        public final /* synthetic */ List<ChatMsg> e;

        public a(Function1<? super List<? extends ChatMsg>, Unit> function1, MsgContentMergerImpl msgContentMergerImpl, long j, List<? extends ChatMsg> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function1, msgContentMergerImpl, Long.valueOf(j), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = function1;
            this.c = msgContentMergerImpl;
            this.d = j;
            this.e = list;
        }

        public static final void g(Function1 callback, List oriMsgList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, callback, oriMsgList) == null) {
                Intrinsics.checkNotNullParameter(callback, "$callback");
                Intrinsics.checkNotNullParameter(oriMsgList, "$oriMsgList");
                callback.invoke(oriMsgList);
            }
        }

        public static final void i(Function1 callback, MsgContentMergerImpl this$0, long j, Result result, List oriMsgList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{callback, this$0, Long.valueOf(j), result, oriMsgList}) == null) {
                Intrinsics.checkNotNullParameter(callback, "$callback");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(result, "$result");
                Intrinsics.checkNotNullParameter(oriMsgList, "$oriMsgList");
                callback.invoke(this$0.d(j, result, oriMsgList));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, String errMsg, Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, result) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.b(i, errMsg, result);
                final Function1<List<? extends ChatMsg>, Unit> function1 = this.b;
                final List<ChatMsg> list = this.e;
                ng.d(new Runnable() { // from class: com.baidu.tieba.t68
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            MsgContentMergerImpl.a.g(Function1.this, list);
                        }
                    }
                });
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void e(final Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.e(result);
                final Function1<List<? extends ChatMsg>, Unit> function1 = this.b;
                final MsgContentMergerImpl msgContentMergerImpl = this.c;
                final long j = this.d;
                final List<ChatMsg> list = this.e;
                ng.d(new Runnable() { // from class: com.baidu.tieba.s68
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            MsgContentMergerImpl.a.i(Function1.this, msgContentMergerImpl, j, result, list);
                        }
                    }
                });
            }
        }
    }

    public MsgContentMergerImpl(TbPageContext<BaseFragmentActivity> pageContext) {
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
        this.a = pageContext;
    }

    public static final void c(MsgContentMergerImpl this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FastRequest fastRequest = this$0.b;
            if (fastRequest != null) {
                fastRequest.S();
            }
        }
    }

    @Override // com.baidu.tieba.uh5
    public void a(long j, List<? extends ChatMsg> oriMsgList, Function1<? super List<? extends ChatMsg>, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), oriMsgList, callback}) == null) {
            Intrinsics.checkNotNullParameter(oriMsgList, "oriMsgList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (this.b == null) {
                this.b = new FastRequest(this.a, CmdConfigHttp.CMD_GET_CHAT_ROOM_INIT_INFO, TbConfig.GET_CHAT_ROOM_INIT_INFO);
            }
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(oriMsgList, 10));
            for (ChatMsg chatMsg : oriMsgList) {
                String senderUid = chatMsg.getSenderUid();
                Intrinsics.checkNotNullExpressionValue(senderUid, "it.senderUid");
                arrayList.add(f58.b(senderUid));
            }
            FastRequest fastRequest = this.b;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.R("chatroom_id", String.valueOf(j));
            fastRequest.R("uks", DataExt.toJson(arrayList));
            fastRequest.X(2000);
            fastRequest.U(2000);
            fastRequest.Y(1);
            fastRequest.T(new a(callback, this, j, oriMsgList));
            ng.e(new Runnable() { // from class: com.baidu.tieba.r68
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MsgContentMergerImpl.c(MsgContentMergerImpl.this);
                    }
                }
            });
        }
    }

    public final List<ChatMsg> d(long j, Result result, List<? extends ChatMsg> list) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), result, list})) == null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (ChatMsg chatMsg : list) {
                String chatRoomContentExt = chatMsg.getChatRoomContentExt();
                if (chatRoomContentExt != null && chatRoomContentExt.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    try {
                        Map<String, Object> userInfo = result.getUserInfo();
                        String senderUid = chatMsg.getSenderUid();
                        Intrinsics.checkNotNullExpressionValue(senderUid, "it.senderUid");
                        Object obj = userInfo.get(f58.b(senderUid));
                        if (obj != null) {
                            JSONObject jSONObject = new JSONObject(chatMsg.getChatRoomContentExt());
                            jSONObject.put("user_extra_info", new JSONObject(DataExt.toJson(obj)));
                            chatMsg.setChatRoomContentExt(jSONObject.toString());
                        }
                    } catch (Exception e) {
                        s48.g("merge_msg_content_exception", j, e);
                    }
                }
                arrayList.add(chatMsg);
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.uh5
    public void onDestroy() {
        FastRequest fastRequest;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (fastRequest = this.b) != null) {
            fastRequest.onDestroy();
        }
    }
}
