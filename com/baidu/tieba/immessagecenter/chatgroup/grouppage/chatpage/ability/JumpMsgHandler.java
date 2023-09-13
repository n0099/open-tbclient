package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.b;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.ko8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/JumpMsgHandler;", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseAbilityHandler;", "chatPage", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "(Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;)V", "doHandle", "", "abilityItem", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem;", "oriMsg", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseMsg;", "payload", "", "provideType", "", "Conf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class JumpMsgHandler extends ko8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatPage b;

    @Override // com.baidu.tieba.ko8
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "locate_chat_msg" : (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/JumpMsgHandler$Conf;", "Ljava/io/Serializable;", "msgKey", "", "msgId", "", "(Ljava/lang/String;J)V", "getMsgId", "()J", "getMsgKey", "()Ljava/lang/String;", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("msg_id")
        public final long msgId;
        @SerializedName("msg_key")
        public final String msgKey;

        public static /* synthetic */ Conf copy$default(Conf conf, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = conf.msgKey;
            }
            if ((i & 2) != 0) {
                j = conf.msgId;
            }
            return conf.copy(str, j);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.msgKey : (String) invokeV.objValue;
        }

        public final long component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msgId : invokeV.longValue;
        }

        public final Conf copy(String msgKey, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, msgKey, j)) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
                return new Conf(msgKey, j);
            }
            return (Conf) invokeLJ.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Conf) {
                    Conf conf = (Conf) obj;
                    return Intrinsics.areEqual(this.msgKey, conf.msgKey) && this.msgId == conf.msgId;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.msgKey.hashCode() * 31) + b.a(this.msgId) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "Conf(msgKey=" + this.msgKey + ", msgId=" + this.msgId + ')';
            }
            return (String) invokeV.objValue;
        }

        public Conf(String msgKey, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgKey, Long.valueOf(j)};
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
            this.msgKey = msgKey;
            this.msgId = j;
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

    public JumpMsgHandler(ChatPage chatPage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatPage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(chatPage, "chatPage");
        this.b = chatPage;
    }

    @Override // com.baidu.tieba.ko8
    public void b(AbilityItem abilityItem, BaseMsg baseMsg, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseMsg, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            Conf conf = (Conf) DataExt.toEntity(abilityItem.getConfMap(), Conf.class);
            this.b.d1(conf.getMsgId(), conf.getMsgKey());
        }
    }
}
