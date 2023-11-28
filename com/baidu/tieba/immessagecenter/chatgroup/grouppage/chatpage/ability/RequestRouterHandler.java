package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.a49;
import com.baidu.tieba.c;
import com.baidu.tieba.hq8;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.x39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J,\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J,\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/RequestRouterHandler;", "Lcom/baidu/tieba/im/base/core/uilist/BaseAbilityHandler;", "chatPage", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "(Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;)V", "fragment", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/GroupChatFragment;", "request", "Lcom/baidu/tbadk/net/FastRequest;", "tips", "", "doHandle", "", "abilityItem", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "oriMsg", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "payload", "", "getCallRobotRequestData", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/RequestRouterHandler$CallRobotRequest;", "conf", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/RequestRouterHandler$Conf;", "provideType", "requestBotSkill", "item", "tryFindBotSkills", "CallRobotRequest", "CallRobotResponse", "Conf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RequestRouterHandler extends hq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatPage b;
    public FastRequest c;
    public String d;
    public GroupChatFragment e;

    @Override // com.baidu.tieba.hq8
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "quick_call_robot" : (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006$"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/RequestRouterHandler$CallRobotRequest;", "Ljava/io/Serializable;", "chatroomId", "", "forumId", "botUk", "", "skillId", "msgId", "msgKey", "robotParams", "(JJLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "getBotUk", "()Ljava/lang/String;", "getChatroomId", "()J", "getForumId", "getMsgId", "getMsgKey", "getRobotParams", "getSkillId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class CallRobotRequest implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String botUk;
        public final long chatroomId;
        public final long forumId;
        public final long msgId;
        public final String msgKey;
        public final String robotParams;
        public final long skillId;

        public final long component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.chatroomId : invokeV.longValue;
        }

        public final long component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forumId : invokeV.longValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.botUk : (String) invokeV.objValue;
        }

        public final long component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.skillId : invokeV.longValue;
        }

        public final long component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.msgId : invokeV.longValue;
        }

        public final String component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.msgKey : (String) invokeV.objValue;
        }

        public final String component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.robotParams : (String) invokeV.objValue;
        }

        public final CallRobotRequest copy(long j, long j2, String botUk, long j3, long j4, String msgKey, String robotParams) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), botUk, Long.valueOf(j3), Long.valueOf(j4), msgKey, robotParams})) == null) {
                Intrinsics.checkNotNullParameter(botUk, "botUk");
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
                Intrinsics.checkNotNullParameter(robotParams, "robotParams");
                return new CallRobotRequest(j, j2, botUk, j3, j4, msgKey, robotParams);
            }
            return (CallRobotRequest) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof CallRobotRequest) {
                    CallRobotRequest callRobotRequest = (CallRobotRequest) obj;
                    return this.chatroomId == callRobotRequest.chatroomId && this.forumId == callRobotRequest.forumId && Intrinsics.areEqual(this.botUk, callRobotRequest.botUk) && this.skillId == callRobotRequest.skillId && this.msgId == callRobotRequest.msgId && Intrinsics.areEqual(this.msgKey, callRobotRequest.msgKey) && Intrinsics.areEqual(this.robotParams, callRobotRequest.robotParams);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (((((((((((c.a(this.chatroomId) * 31) + c.a(this.forumId)) * 31) + this.botUk.hashCode()) * 31) + c.a(this.skillId)) * 31) + c.a(this.msgId)) * 31) + this.msgKey.hashCode()) * 31) + this.robotParams.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return "CallRobotRequest(chatroomId=" + this.chatroomId + ", forumId=" + this.forumId + ", botUk=" + this.botUk + ", skillId=" + this.skillId + ", msgId=" + this.msgId + ", msgKey=" + this.msgKey + ", robotParams=" + this.robotParams + ')';
            }
            return (String) invokeV.objValue;
        }

        public CallRobotRequest(long j, long j2, String botUk, long j3, long j4, String msgKey, String robotParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), botUk, Long.valueOf(j3), Long.valueOf(j4), msgKey, robotParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(botUk, "botUk");
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            Intrinsics.checkNotNullParameter(robotParams, "robotParams");
            this.chatroomId = j;
            this.forumId = j2;
            this.botUk = botUk;
            this.skillId = j3;
            this.msgId = j4;
            this.msgKey = msgKey;
            this.robotParams = robotParams;
        }

        public final String getBotUk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.botUk;
            }
            return (String) invokeV.objValue;
        }

        public final long getChatroomId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.chatroomId;
            }
            return invokeV.longValue;
        }

        public final long getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.forumId;
            }
            return invokeV.longValue;
        }

        public final long getMsgId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.msgId;
            }
            return invokeV.longValue;
        }

        public final String getMsgKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.msgKey;
            }
            return (String) invokeV.objValue;
        }

        public final String getRobotParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.robotParams;
            }
            return (String) invokeV.objValue;
        }

        public final long getSkillId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.skillId;
            }
            return invokeV.longValue;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/RequestRouterHandler$CallRobotResponse;", "Ljava/io/Serializable;", "()V", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class CallRobotResponse implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public CallRobotResponse() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/RequestRouterHandler$Conf;", "Ljava/io/Serializable;", "botUk", "", "skillId", "", "(Ljava/lang/String;J)V", "getBotUk", "()Ljava/lang/String;", "getSkillId", "()J", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("bot_uk")
        public final String botUk;
        @SerializedName("skill_id")
        public final long skillId;

        public static /* synthetic */ Conf copy$default(Conf conf, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = conf.botUk;
            }
            if ((i & 2) != 0) {
                j = conf.skillId;
            }
            return conf.copy(str, j);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.botUk : (String) invokeV.objValue;
        }

        public final long component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.skillId : invokeV.longValue;
        }

        public final Conf copy(String botUk, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, botUk, j)) == null) {
                Intrinsics.checkNotNullParameter(botUk, "botUk");
                return new Conf(botUk, j);
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
                    return Intrinsics.areEqual(this.botUk, conf.botUk) && this.skillId == conf.skillId;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.botUk.hashCode() * 31) + c.a(this.skillId) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "Conf(botUk=" + this.botUk + ", skillId=" + this.skillId + ')';
            }
            return (String) invokeV.objValue;
        }

        public Conf(String botUk, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {botUk, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(botUk, "botUk");
            this.botUk = botUk;
            this.skillId = j;
        }

        public final String getBotUk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.botUk;
            }
            return (String) invokeV.objValue;
        }

        public final long getSkillId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.skillId;
            }
            return invokeV.longValue;
        }
    }

    public RequestRouterHandler(ChatPage chatPage) {
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
        GroupChatFragment K0 = chatPage.K0();
        Intrinsics.checkNotNullExpressionValue(K0, "chatPage.groupChatFragment");
        this.e = K0;
    }

    @Override // com.baidu.tieba.hq8
    public void b(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Object obj) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseItem, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            Conf conf = (Conf) DataExt.toEntity(abilityItem.getConfMap(), Conf.class);
            AbilityItem.StyleConf styleConf = abilityItem.getStyleConf();
            if (styleConf != null) {
                str = styleConf.getErrorTips();
            } else {
                str = null;
            }
            this.d = str;
            CallRobotRequest f = f(abilityItem, baseItem, conf);
            if (f != null) {
                g(f);
            }
        }
    }

    public final CallRobotRequest f(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Conf conf) {
        InterceptResult invokeLLL;
        TbBaseMsg tbBaseMsg;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, abilityItem, baseItem, conf)) == null) {
            CallRobotRequest callRobotRequest = null;
            if (baseItem != null) {
                tbBaseMsg = baseItem.getTbMsg();
            } else {
                tbBaseMsg = null;
            }
            if (tbBaseMsg != null) {
                long sessionId = tbBaseMsg.getSessionId();
                TbBaseMsg.c forumExt = tbBaseMsg.getForumExt();
                if (forumExt != null) {
                    j = forumExt.a();
                } else {
                    j = 0;
                }
                String botUk = conf.getBotUk();
                long skillId = conf.getSkillId();
                long msgId = tbBaseMsg.getMsgId();
                String msgKey = tbBaseMsg.getMsgKey();
                String h = h(abilityItem, baseItem, conf);
                if (h == null) {
                    h = "";
                }
                callRobotRequest = new CallRobotRequest(sessionId, j, botUk, skillId, msgId, msgKey, h);
            }
            return callRobotRequest;
        }
        return (CallRobotRequest) invokeLLL.objValue;
    }

    public final String h(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Conf conf) {
        InterceptResult invokeLLL;
        TbBaseMsg tbBaseMsg;
        BotsDTO.BotListDTO botListDTO;
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, abilityItem, baseItem, conf)) == null) {
            if (baseItem != null) {
                tbBaseMsg = baseItem.getTbMsg();
            } else {
                tbBaseMsg = null;
            }
            if (tbBaseMsg instanceof TbTextMsg) {
                ((TbTextMsg) baseItem.getTbMsg()).getText();
            }
            String botUk = conf.getBotUk();
            long skillId = conf.getSkillId();
            BotsDTO I0 = this.b.I0();
            if (I0 != null) {
                botListDTO = I0.findBotByUk(botUk);
            } else {
                botListDTO = null;
            }
            if (botListDTO != null) {
                skillDTO = botListDTO.cloneSkillById((int) skillId);
            } else {
                skillDTO = null;
            }
            if (skillDTO != null) {
                HashMap<String, Object> g = a49.g(skillDTO, skillDTO.getItems(), null);
                Intrinsics.checkNotNullExpressionValue(g, "assembleRobotParams(it, skillDTO.items, null)");
                return DataExt.toJson(g);
            }
            return "";
        }
        return (String) invokeLLL.objValue;
    }

    public final void g(CallRobotRequest callRobotRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, callRobotRequest) == null) {
            if (this.c == null) {
                this.c = new FastRequest(this.e.getPageContext(), CmdConfigHttp.CMD_POST_CALL_ROBOT_ROUTER, TbConfig.URL_CALL_ROBOT_ROUTER);
            }
            FastRequest fastRequest = this.c;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.U(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.P("chatroom_id", Long.valueOf(callRobotRequest.getChatroomId()));
            fastRequest.P("forum_id", Long.valueOf(callRobotRequest.getForumId()));
            fastRequest.P("bot_uk", callRobotRequest.getBotUk());
            fastRequest.P("skill_id", Long.valueOf(callRobotRequest.getSkillId()));
            fastRequest.P("msg_id", Long.valueOf(callRobotRequest.getMsgId()));
            fastRequest.P("msg_key", callRobotRequest.getMsgKey());
            fastRequest.P("robot_params", callRobotRequest.getRobotParams());
            fastRequest.R(new x39(this.d, this.b));
            FastRequest fastRequest2 = this.c;
            Intrinsics.checkNotNull(fastRequest2);
            fastRequest2.Q();
        }
    }
}
