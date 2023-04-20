package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.d58;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/CallRobotHandler;", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseAbilityHandler;", "chatPage", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "(Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;)V", "doHandle", "", "abilityItem", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem;", "oriMsg", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseMsg;", "provideType", "", "Conf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CallRobotHandler extends d58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatPage b;

    @Override // com.baidu.tieba.d58
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "call_robot" : (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÂ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÂ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÂ\u0003¢\u0006\u0002\u0010\u0012JF\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0007\u001a\u00020\u0018J\u0006\u0010\u0006\u001a\u00020\u0018J\u0006\u0010\b\u001a\u00020\u0018J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/CallRobotHandler$Conf;", "Ljava/io/Serializable;", "botUk", "", "skillId", "", "isNeedReply", "isNeedAt", "isNeedShowSelectPanel", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBotUk", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getSkillId", "()I", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "copy", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/CallRobotHandler$Conf;", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("bot_uk")
        public final String botUk;
        @SerializedName("is_at")
        public final Integer isNeedAt;
        @SerializedName("is_reply")
        public final Integer isNeedReply;
        @SerializedName("is_expand")
        public final Integer isNeedShowSelectPanel;
        @SerializedName("skill_id")
        public final int skillId;

        private final Integer component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.isNeedReply : (Integer) invokeV.objValue;
        }

        private final Integer component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.isNeedAt : (Integer) invokeV.objValue;
        }

        private final Integer component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.isNeedShowSelectPanel : (Integer) invokeV.objValue;
        }

        public static /* synthetic */ Conf copy$default(Conf conf, String str, int i, Integer num, Integer num2, Integer num3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = conf.botUk;
            }
            if ((i2 & 2) != 0) {
                i = conf.skillId;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                num = conf.isNeedReply;
            }
            Integer num4 = num;
            if ((i2 & 8) != 0) {
                num2 = conf.isNeedAt;
            }
            Integer num5 = num2;
            if ((i2 & 16) != 0) {
                num3 = conf.isNeedShowSelectPanel;
            }
            return conf.copy(str, i3, num4, num5, num3);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.botUk : (String) invokeV.objValue;
        }

        public final int component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.skillId : invokeV.intValue;
        }

        public final Conf copy(String botUk, int i, Integer num, Integer num2, Integer num3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{botUk, Integer.valueOf(i), num, num2, num3})) == null) {
                Intrinsics.checkNotNullParameter(botUk, "botUk");
                return new Conf(botUk, i, num, num2, num3);
            }
            return (Conf) invokeCommon.objValue;
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
                    return Intrinsics.areEqual(this.botUk, conf.botUk) && this.skillId == conf.skillId && Intrinsics.areEqual(this.isNeedReply, conf.isNeedReply) && Intrinsics.areEqual(this.isNeedAt, conf.isNeedAt) && Intrinsics.areEqual(this.isNeedShowSelectPanel, conf.isNeedShowSelectPanel);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                int hashCode = ((this.botUk.hashCode() * 31) + this.skillId) * 31;
                Integer num = this.isNeedReply;
                int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
                Integer num2 = this.isNeedAt;
                int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
                Integer num3 = this.isNeedShowSelectPanel;
                return hashCode3 + (num3 != null ? num3.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return "Conf(botUk=" + this.botUk + ", skillId=" + this.skillId + ", isNeedReply=" + this.isNeedReply + ", isNeedAt=" + this.isNeedAt + ", isNeedShowSelectPanel=" + this.isNeedShowSelectPanel + ')';
            }
            return (String) invokeV.objValue;
        }

        public Conf(String botUk, int i, Integer num, Integer num2, Integer num3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {botUk, Integer.valueOf(i), num, num2, num3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(botUk, "botUk");
            this.botUk = botUk;
            this.skillId = i;
            this.isNeedReply = num;
            this.isNeedAt = num2;
            this.isNeedShowSelectPanel = num3;
        }

        public final String getBotUk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.botUk;
            }
            return (String) invokeV.objValue;
        }

        public final int getSkillId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.skillId;
            }
            return invokeV.intValue;
        }

        public final boolean isNeedAt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Integer num = this.isNeedAt;
                if (num != null && num.intValue() == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final boolean isNeedReply() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Integer num = this.isNeedReply;
                if (num != null && num.intValue() == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final boolean isNeedShowSelectPanel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Integer num = this.isNeedShowSelectPanel;
                if (num != null && num.intValue() == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public CallRobotHandler(ChatPage chatPage) {
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

    @Override // com.baidu.tieba.d58
    public void b(AbilityItem abilityItem, BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, abilityItem, baseMsg) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            Object entity = DataExt.toEntity(abilityItem.getConfMap(), Conf.class);
            Intrinsics.checkNotNullExpressionValue(entity, "toEntity(abilityItem.confMap, Conf::class.java)");
            Conf conf = (Conf) entity;
            this.b.V0(conf.getBotUk(), conf.getSkillId(), GroupInputViewController.SourceType.TWO, baseMsg, conf.isNeedReply(), conf.isNeedAt(), conf.isNeedShowSelectPanel());
        }
    }
}
