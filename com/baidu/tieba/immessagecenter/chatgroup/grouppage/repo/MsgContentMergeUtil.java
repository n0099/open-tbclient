package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.aw8;
import com.baidu.tieba.c;
import com.baidu.tieba.ot5;
import com.baidu.tieba.uq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001f\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000e\"\u00020\f¢\u0006\u0002\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergeUtil;", "", "()V", "mergeContent", "", "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;", "roomId", "", "result", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergeUtil$Result;", "oriMsgList", "mergeJson", "Lorg/json/JSONObject;", "originalJson", "", "([Lorg/json/JSONObject;)Lorg/json/JSONObject;", "ChatRoomInitInfo", "Result", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgContentMergeUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final MsgContentMergeUtil a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(561373192, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergeUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(561373192, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergeUtil;");
                return;
            }
        }
        a = new MsgContentMergeUtil();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergeUtil$ChatRoomInitInfo;", "Lcom/baidu/adp/lib/OrmObject/toolsystem/orm/object/OrmObject;", "Ljava/io/Serializable;", "msgId", "", "msgKey", "", "(JLjava/lang/String;)V", "getMsgId", "()J", "getMsgKey", "()Ljava/lang/String;", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ChatRoomInitInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("msg_id")
        public final long msgId;
        @SerializedName("msg_key")
        public final String msgKey;

        public static /* synthetic */ ChatRoomInitInfo copy$default(ChatRoomInitInfo chatRoomInitInfo, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = chatRoomInitInfo.msgId;
            }
            if ((i & 2) != 0) {
                str = chatRoomInitInfo.msgKey;
            }
            return chatRoomInitInfo.copy(j, str);
        }

        public final long component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.msgId : invokeV.longValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msgKey : (String) invokeV.objValue;
        }

        public final ChatRoomInitInfo copy(long j, String msgKey) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, msgKey)) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
                return new ChatRoomInitInfo(j, msgKey);
            }
            return (ChatRoomInitInfo) invokeJL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ChatRoomInitInfo) {
                    ChatRoomInitInfo chatRoomInitInfo = (ChatRoomInitInfo) obj;
                    return this.msgId == chatRoomInitInfo.msgId && Intrinsics.areEqual(this.msgKey, chatRoomInitInfo.msgKey);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (c.a(this.msgId) * 31) + this.msgKey.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "ChatRoomInitInfo(msgId=" + this.msgId + ", msgKey=" + this.msgKey + ')';
            }
            return (String) invokeV.objValue;
        }

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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.msgId;
            }
            return invokeV.longValue;
        }

        public final String getMsgKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.msgKey;
            }
            return (String) invokeV.objValue;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0011\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergeUtil$Result;", "Ljava/io/Serializable;", "userInfo", "", "", "", "msgInfo", "emojiInfo", "", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getEmojiInfo", "()Ljava/util/Map;", "getMsgInfo", "getUserInfo", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "hashCode", "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Result implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @ot5(deserialize = false, serialize = false)
        public final Map<Long, Object> emojiInfo;
        @SerializedName("msg_info")
        public final Map<String, Object> msgInfo;
        @SerializedName(SourceConstant.SOURCE_USER_INFO)
        public final Map<String, Object> userInfo;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergeUtil$Result */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, Map map, Map map2, Map map3, int i, Object obj) {
            if ((i & 1) != 0) {
                map = result.userInfo;
            }
            if ((i & 2) != 0) {
                map2 = result.msgInfo;
            }
            if ((i & 4) != 0) {
                map3 = result.emojiInfo;
            }
            return result.copy(map, map2, map3);
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

        public final Map<Long, Object> component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.emojiInfo : (Map) invokeV.objValue;
        }

        public final Result copy(Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<Long, ? extends Object> map3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, map, map2, map3)) == null) ? new Result(map, map2, map3) : (Result) invokeLLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Result) {
                    Result result = (Result) obj;
                    return Intrinsics.areEqual(this.userInfo, result.userInfo) && Intrinsics.areEqual(this.msgInfo, result.msgInfo) && Intrinsics.areEqual(this.emojiInfo, result.emojiInfo);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Map<String, Object> map = this.userInfo;
                int hashCode = (map == null ? 0 : map.hashCode()) * 31;
                Map<String, Object> map2 = this.msgInfo;
                int hashCode2 = (hashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
                Map<Long, Object> map3 = this.emojiInfo;
                return hashCode2 + (map3 != null ? map3.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return "Result(userInfo=" + this.userInfo + ", msgInfo=" + this.msgInfo + ", emojiInfo=" + this.emojiInfo + ')';
            }
            return (String) invokeV.objValue;
        }

        public Result(Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<Long, ? extends Object> map3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, map2, map3};
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
            this.emojiInfo = map3;
        }

        public final Map<Long, Object> getEmojiInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.emojiInfo;
            }
            return (Map) invokeV.objValue;
        }

        public final Map<String, Object> getMsgInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.msgInfo;
            }
            return (Map) invokeV.objValue;
        }

        public final Map<String, Object> getUserInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.userInfo;
            }
            return (Map) invokeV.objValue;
        }
    }

    public MsgContentMergeUtil() {
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

    /* JADX WARN: Removed duplicated region for block: B:27:0x0077 A[Catch: Exception -> 0x00c4, TryCatch #0 {Exception -> 0x00c4, blocks: (B:8:0x0029, B:10:0x0030, B:12:0x0043, B:14:0x0049, B:16:0x0053, B:18:0x0059, B:19:0x0065, B:21:0x006b, B:27:0x0077, B:30:0x0088, B:32:0x0098, B:34:0x00a8, B:35:0x00b6, B:37:0x00bc, B:28:0x007d), top: B:47:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[Catch: Exception -> 0x00c4, TryCatch #0 {Exception -> 0x00c4, blocks: (B:8:0x0029, B:10:0x0030, B:12:0x0043, B:14:0x0049, B:16:0x0053, B:18:0x0059, B:19:0x0065, B:21:0x006b, B:27:0x0077, B:30:0x0088, B:32:0x0098, B:34:0x00a8, B:35:0x00b6, B:37:0x00bc, B:28:0x007d), top: B:47:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088 A[Catch: Exception -> 0x00c4, TryCatch #0 {Exception -> 0x00c4, blocks: (B:8:0x0029, B:10:0x0030, B:12:0x0043, B:14:0x0049, B:16:0x0053, B:18:0x0059, B:19:0x0065, B:21:0x006b, B:27:0x0077, B:30:0x0088, B:32:0x0098, B:34:0x00a8, B:35:0x00b6, B:37:0x00bc, B:28:0x007d), top: B:47:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098 A[Catch: Exception -> 0x00c4, TryCatch #0 {Exception -> 0x00c4, blocks: (B:8:0x0029, B:10:0x0030, B:12:0x0043, B:14:0x0049, B:16:0x0053, B:18:0x0059, B:19:0x0065, B:21:0x006b, B:27:0x0077, B:30:0x0088, B:32:0x0098, B:34:0x00a8, B:35:0x00b6, B:37:0x00bc, B:28:0x007d), top: B:47:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8 A[Catch: Exception -> 0x00c4, TryCatch #0 {Exception -> 0x00c4, blocks: (B:8:0x0029, B:10:0x0030, B:12:0x0043, B:14:0x0049, B:16:0x0053, B:18:0x0059, B:19:0x0065, B:21:0x006b, B:27:0x0077, B:30:0x0088, B:32:0x0098, B:34:0x00a8, B:35:0x00b6, B:37:0x00bc, B:28:0x007d), top: B:47:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bc A[Catch: Exception -> 0x00c4, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c4, blocks: (B:8:0x0029, B:10:0x0030, B:12:0x0043, B:14:0x0049, B:16:0x0053, B:18:0x0059, B:19:0x0065, B:21:0x006b, B:27:0x0077, B:30:0x0088, B:32:0x0098, B:34:0x00a8, B:35:0x00b6, B:37:0x00bc, B:28:0x007d), top: B:47:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ca A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ChatMsg> a(long j, Result result, List<? extends ChatMsg> oriMsgList) {
        InterceptResult invokeCommon;
        Object obj;
        Object obj2;
        Object obj3;
        String chatRoomContentExt;
        boolean z;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), result, oriMsgList})) == null) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(oriMsgList, "oriMsgList");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(oriMsgList, 10));
            for (ChatMsg chatMsg : oriMsgList) {
                try {
                    Map<String, Object> userInfo = result.getUserInfo();
                    obj = null;
                    if (userInfo != null) {
                        String senderUid = chatMsg.getSenderUid();
                        Intrinsics.checkNotNullExpressionValue(senderUid, "it.senderUid");
                        obj2 = userInfo.get(aw8.c(senderUid));
                    } else {
                        obj2 = null;
                    }
                    Map<String, Object> msgInfo = result.getMsgInfo();
                    if (msgInfo != null) {
                        obj3 = msgInfo.get(chatMsg.getMsgKey());
                    } else {
                        obj3 = null;
                    }
                    Map<Long, Object> emojiInfo = result.getEmojiInfo();
                    if (emojiInfo != null) {
                        obj = emojiInfo.get(Long.valueOf(chatMsg.getMsgId()));
                    }
                    chatRoomContentExt = chatMsg.getChatRoomContentExt();
                } catch (Exception e) {
                    uq8.g("merge_msg_content_exception", j, e);
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
                    if (obj3 != null) {
                        jSONObject.put("excellent_info", new JSONObject(DataExt.toJson(obj3)));
                    }
                    if (obj != null) {
                        jSONObject.put("emoji_info", new JSONArray(DataExt.toJson(obj)));
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
                if (obj3 != null) {
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

    public final JSONObject b(JSONObject... originalJson) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, originalJson)) == null) {
            Intrinsics.checkNotNullParameter(originalJson, "originalJson");
            JSONObject jSONObject = new JSONObject();
            for (JSONObject jSONObject2 : originalJson) {
                Iterator<String> keys = jSONObject2.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "it.keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!jSONObject.has(next)) {
                        jSONObject.put(next, jSONObject2.get(next));
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
