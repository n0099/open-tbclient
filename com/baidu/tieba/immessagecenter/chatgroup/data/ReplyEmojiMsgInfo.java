package com.baidu.tieba.immessagecenter.chatgroup.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/data/ReplyEmojiMsgInfo;", "Ljava/io/Serializable;", "count", "", "msgList", "", "Lcom/baidu/tieba/immessagecenter/chatgroup/data/AtInfoMsg;", "(ILjava/util/List;)V", "getCount", "()I", "getMsgList", "()Ljava/util/List;", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ReplyEmojiMsgInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int count;
    @SerializedName("msg_list")
    public final List<AtInfoMsg> msgList;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.data.ReplyEmojiMsgInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReplyEmojiMsgInfo copy$default(ReplyEmojiMsgInfo replyEmojiMsgInfo, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = replyEmojiMsgInfo.count;
        }
        if ((i2 & 2) != 0) {
            list = replyEmojiMsgInfo.msgList;
        }
        return replyEmojiMsgInfo.copy(i, list);
    }

    public final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.count : invokeV.intValue;
    }

    public final List<AtInfoMsg> component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msgList : (List) invokeV.objValue;
    }

    public final ReplyEmojiMsgInfo copy(int i, List<? extends AtInfoMsg> msgList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, msgList)) == null) {
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            return new ReplyEmojiMsgInfo(i, msgList);
        }
        return (ReplyEmojiMsgInfo) invokeIL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReplyEmojiMsgInfo) {
                ReplyEmojiMsgInfo replyEmojiMsgInfo = (ReplyEmojiMsgInfo) obj;
                return this.count == replyEmojiMsgInfo.count && Intrinsics.areEqual(this.msgList, replyEmojiMsgInfo.msgList);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.count * 31) + this.msgList.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "ReplyEmojiMsgInfo(count=" + this.count + ", msgList=" + this.msgList + ')';
        }
        return (String) invokeV.objValue;
    }

    public ReplyEmojiMsgInfo(int i, List<? extends AtInfoMsg> msgList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), msgList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        this.count = i;
        this.msgList = msgList;
    }

    public final int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.count;
        }
        return invokeV.intValue;
    }

    public final List<AtInfoMsg> getMsgList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.msgList;
        }
        return (List) invokeV.objValue;
    }
}
