package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
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
import com.baidu.tieba.e78;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergerImpl;
import com.baidu.tieba.ng;
import com.baidu.tieba.ni5;
import com.baidu.tieba.o68;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005JG\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2'\u0010\u000f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\t0\u0010H\u0016J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergerImpl;", "Lcom/baidu/tbadk/module/alalivesdk/interfaces/MsgContentMerger;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "(Lcom/baidu/tbadk/TbPageContext;)V", "request", "Lcom/baidu/tbadk/net/FastRequest;", "doMerge", "", "roomId", "", "oriMsgList", "", "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;", WebChromeClient.KEY_ARG_CALLBACK, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mergedMsgList", "mergeContent", "result", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergerImpl$Result;", MissionEvent.MESSAGE_DESTROY, "ChatRoomInitInfo", "Result", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MsgContentMergerImpl implements ni5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public FastRequest b;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergerImpl$ChatRoomInitInfo;", "Lcom/baidu/adp/lib/OrmObject/toolsystem/orm/object/OrmObject;", "Ljava/io/Serializable;", "msgId", "", "msgKey", "", "(JLjava/lang/String;)V", "getMsgId", "()J", "setMsgId", "(J)V", "getMsgKey", "()Ljava/lang/String;", "setMsgKey", "(Ljava/lang/String;)V", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ChatRoomInitInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("msg_id")
        public long msgId;
        @SerializedName("msg_key")
        public String msgKey;

        public ChatRoomInitInfo(long j, String msgKey) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), msgKey};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            this.msgId = j;
            this.msgKey = msgKey;
        }

        public final long getMsgId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.msgId;
            }
            return invokeV.longValue;
        }

        public final String getMsgKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.msgKey;
            }
            return (String) invokeV.objValue;
        }

        public final void setMsgId(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                this.msgId = j;
            }
        }

        public final void setMsgKey(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.msgKey = str;
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J9\u0010\r\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergerImpl$Result;", "Ljava/io/Serializable;", "userInfo", "", "", "", "msgInfo", "(Ljava/util/Map;Ljava/util/Map;)V", "getMsgInfo", "()Ljava/util/Map;", "getUserInfo", "component1", "component2", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Result implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("msg_info")
        public final Map<String, Object> msgInfo;
        @SerializedName("user_info")
        public final Map<String, Object> userInfo;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergerImpl$Result */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = result.userInfo;
            }
            if ((i & 2) != 0) {
                map2 = result.msgInfo;
            }
            return result.copy(map, map2);
        }

        public final Map<String, Object> component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.userInfo : (Map) invokeV.objValue;
        }

        public final Map<String, Object> component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msgInfo : (Map) invokeV.objValue;
        }

        public final Result copy(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, map, map2)) == null) ? new Result(map, map2) : (Result) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Result) {
                    Result result = (Result) obj;
                    return Intrinsics.areEqual(this.userInfo, result.userInfo) && Intrinsics.areEqual(this.msgInfo, result.msgInfo);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Map<String, Object> map = this.userInfo;
                int hashCode = (map == null ? 0 : map.hashCode()) * 31;
                Map<String, Object> map2 = this.msgInfo;
                return hashCode + (map2 != null ? map2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "Result(userInfo=" + this.userInfo + ", msgInfo=" + this.msgInfo + ')';
            }
            return (String) invokeV.objValue;
        }

        public Result(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, map2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.userInfo = map;
            this.msgInfo = map2;
        }

        public final Map<String, Object> getMsgInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.msgInfo;
            }
            return (Map) invokeV.objValue;
        }

        public final Map<String, Object> getUserInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
                ng.d(new Runnable() { // from class: com.baidu.tieba.w88
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
                ng.d(new Runnable() { // from class: com.baidu.tieba.v88
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
                fastRequest.X();
            }
        }
    }

    @Override // com.baidu.tieba.ni5
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
                arrayList.add(e78.b(senderUid));
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(oriMsgList, 10));
            for (ChatMsg chatMsg2 : oriMsgList) {
                long msgId = chatMsg2.getMsgId();
                String msgKey = chatMsg2.getMsgKey();
                Intrinsics.checkNotNullExpressionValue(msgKey, "it.msgKey");
                arrayList2.add(new ChatRoomInitInfo(msgId, msgKey));
            }
            FastRequest fastRequest = this.b;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.W("chatroom_id", String.valueOf(j));
            fastRequest.W("uks", DataExt.toJson(arrayList));
            fastRequest.W("msgs", DataExt.toJson(arrayList2));
            fastRequest.c0(2000);
            fastRequest.Z(2000);
            fastRequest.d0(1);
            fastRequest.Y(new a(callback, this, j, oriMsgList));
            ng.e(new Runnable() { // from class: com.baidu.tieba.x88
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x0059 A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:8:0x001f, B:10:0x0026, B:12:0x0039, B:14:0x003f, B:15:0x0047, B:17:0x004d, B:23:0x0059, B:26:0x006a, B:28:0x007a, B:29:0x0088, B:31:0x008e, B:24:0x005f), top: B:41:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:8:0x001f, B:10:0x0026, B:12:0x0039, B:14:0x003f, B:15:0x0047, B:17:0x004d, B:23:0x0059, B:26:0x006a, B:28:0x007a, B:29:0x0088, B:31:0x008e, B:24:0x005f), top: B:41:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:8:0x001f, B:10:0x0026, B:12:0x0039, B:14:0x003f, B:15:0x0047, B:17:0x004d, B:23:0x0059, B:26:0x006a, B:28:0x007a, B:29:0x0088, B:31:0x008e, B:24:0x005f), top: B:41:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:8:0x001f, B:10:0x0026, B:12:0x0039, B:14:0x003f, B:15:0x0047, B:17:0x004d, B:23:0x0059, B:26:0x006a, B:28:0x007a, B:29:0x0088, B:31:0x008e, B:24:0x005f), top: B:41:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e A[Catch: Exception -> 0x0096, TRY_LEAVE, TryCatch #0 {Exception -> 0x0096, blocks: (B:8:0x001f, B:10:0x0026, B:12:0x0039, B:14:0x003f, B:15:0x0047, B:17:0x004d, B:23:0x0059, B:26:0x006a, B:28:0x007a, B:29:0x0088, B:31:0x008e, B:24:0x005f), top: B:41:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ChatMsg> d(long j, Result result, List<? extends ChatMsg> list) {
        InterceptResult invokeCommon;
        Object obj;
        Object obj2;
        String chatRoomContentExt;
        boolean z;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), result, list})) == null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (ChatMsg chatMsg : list) {
                try {
                    Map<String, Object> userInfo = result.getUserInfo();
                    obj = null;
                    if (userInfo != null) {
                        String senderUid = chatMsg.getSenderUid();
                        Intrinsics.checkNotNullExpressionValue(senderUid, "it.senderUid");
                        obj2 = userInfo.get(e78.b(senderUid));
                    } else {
                        obj2 = null;
                    }
                    Map<String, Object> msgInfo = result.getMsgInfo();
                    if (msgInfo != null) {
                        obj = msgInfo.get(chatMsg.getMsgKey());
                    }
                    chatRoomContentExt = chatMsg.getChatRoomContentExt();
                } catch (Exception e) {
                    o68.g("merge_msg_content_exception", j, e);
                }
                if (chatRoomContentExt != null && chatRoomContentExt.length() != 0) {
                    z = false;
                    if (!z) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(chatMsg.getChatRoomContentExt());
                    }
                    if (obj2 != null) {
                        jSONObject.put("user_extra_info", new JSONObject(DataExt.toJson(obj2)));
                    }
                    if (obj != null) {
                        jSONObject.put("excellent_info", new JSONObject(DataExt.toJson(obj)));
                    }
                    if (jSONObject.length() <= 0) {
                        chatMsg.setChatRoomContentExt(jSONObject.toString());
                    }
                    arrayList.add(chatMsg);
                }
                z = true;
                if (!z) {
                }
                if (obj2 != null) {
                }
                if (obj != null) {
                }
                if (jSONObject.length() <= 0) {
                }
                arrayList.add(chatMsg);
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ni5
    public void onDestroy() {
        FastRequest fastRequest;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (fastRequest = this.b) != null) {
            fastRequest.onDestroy();
        }
    }
}
