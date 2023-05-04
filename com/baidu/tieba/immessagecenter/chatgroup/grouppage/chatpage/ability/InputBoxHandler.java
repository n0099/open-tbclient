package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability;

import android.text.SpannableStringBuilder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.c78;
import com.baidu.tieba.hi;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.z78;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/InputBoxHandler;", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseAbilityHandler;", "chatPage", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "(Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;)V", "buildReplayMessageData", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/robotfloor/data/UserReplyInfoData;", "oriMsg", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseMsg;", "doHandle", "", "abilityItem", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem;", "payload", "", "provideType", "", "Conf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputBoxHandler extends c78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatPage b;

    @Override // com.baidu.tieba.c78
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "input_box" : (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/InputBoxHandler$Conf;", "Ljava/io/Serializable;", "isAt", "", "isReply", "inputText", "", "(IILjava/lang/String;)V", "getInputText", "()Ljava/lang/String;", "()I", "component1", "component2", "component3", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName(TbEnum.ChatInputStatus.INPUT_STATUS_TEXT)
        public final String inputText;
        @SerializedName("is_at")
        public final int isAt;
        @SerializedName("is_reply")
        public final int isReply;

        public static /* synthetic */ Conf copy$default(Conf conf, int i, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = conf.isAt;
            }
            if ((i3 & 2) != 0) {
                i2 = conf.isReply;
            }
            if ((i3 & 4) != 0) {
                str = conf.inputText;
            }
            return conf.copy(i, i2, str);
        }

        public final int component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isAt : invokeV.intValue;
        }

        public final int component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isReply : invokeV.intValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.inputText : (String) invokeV.objValue;
        }

        public final Conf copy(int i, int i2, String inputText) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i, i2, inputText)) == null) {
                Intrinsics.checkNotNullParameter(inputText, "inputText");
                return new Conf(i, i2, inputText);
            }
            return (Conf) invokeIIL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Conf) {
                    Conf conf = (Conf) obj;
                    return this.isAt == conf.isAt && this.isReply == conf.isReply && Intrinsics.areEqual(this.inputText, conf.inputText);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (((this.isAt * 31) + this.isReply) * 31) + this.inputText.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return "Conf(isAt=" + this.isAt + ", isReply=" + this.isReply + ", inputText=" + this.inputText + ')';
            }
            return (String) invokeV.objValue;
        }

        public Conf(int i, int i2, String inputText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), inputText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(inputText, "inputText");
            this.isAt = i;
            this.isReply = i2;
            this.inputText = inputText;
        }

        public final String getInputText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.inputText;
            }
            return (String) invokeV.objValue;
        }

        public final int isAt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.isAt;
            }
            return invokeV.intValue;
        }

        public final int isReply() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.isReply;
            }
            return invokeV.intValue;
        }
    }

    public InputBoxHandler(ChatPage chatPage) {
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

    @Override // com.baidu.tieba.c78
    public void b(AbilityItem abilityItem, BaseMsg baseMsg, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseMsg, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            GroupInputViewController k2 = this.b.E0().k2();
            if (k2 == null || this.b.W0()) {
                return;
            }
            Conf conf = (Conf) DataExt.toEntity(abilityItem.getConfMap(), Conf.class);
            k2.p1("");
            z78 v0 = k2.v0();
            if (v0 != null) {
                v0.E();
            }
            if (baseMsg != null) {
                if (conf.isReply() == 1) {
                    k2.c1(f(baseMsg), baseMsg);
                } else {
                    k2.j0();
                }
                if (conf.isAt() == 1) {
                    AtSelectData atSelectData = new AtSelectData(baseMsg.getCommonMsgField().getPortrait(), baseMsg.getCommonMsgField().getUserName(), String.valueOf(baseMsg.getCommonMsgField().getUserId()), baseMsg.getCommonMsgField().isRobot());
                    if (conf.isReply() != 1 && hi.isEmpty(conf.getInputText())) {
                        z78 v02 = k2.v0();
                        if (v02 != null) {
                            v02.j(atSelectData, baseMsg.getCommonMsgField().isRobot());
                        }
                    } else {
                        z78 v03 = k2.v0();
                        if (v03 != null) {
                            v03.j(atSelectData, false);
                        }
                    }
                }
            }
            if (!hi.isEmpty(conf.getInputText())) {
                k2.o1(conf.getInputText());
            }
            z78 v04 = k2.v0();
            if (v04 != null) {
                v04.A();
            }
        }
    }

    public final UserReplyInfoData f(BaseMsg baseMsg) {
        InterceptResult invokeL;
        CharSequence charSequence;
        CharSequence charSequence2;
        String str;
        boolean z;
        CommonMsgField commonMsgField;
        CommonMsgField commonMsgField2;
        CommonMsgField commonMsgField3;
        CommonMsgField commonMsgField4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseMsg)) == null) {
            UserReplyInfoData userReplyInfoData = new UserReplyInfoData();
            String str2 = null;
            if (baseMsg != null) {
                charSequence = baseMsg.getReplyPrefix();
            } else {
                charSequence = null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            if (baseMsg != null) {
                charSequence2 = baseMsg.getThumbnailText();
            } else {
                charSequence2 = null;
            }
            spannableStringBuilder.append(charSequence2);
            userReplyInfoData.setmContent(spannableStringBuilder);
            if (baseMsg != null && (commonMsgField4 = baseMsg.getCommonMsgField()) != null) {
                str = commonMsgField4.getUserName();
            } else {
                str = null;
            }
            userReplyInfoData.setmNameShow(str);
            if (baseMsg != null && (commonMsgField3 = baseMsg.getCommonMsgField()) != null) {
                str2 = commonMsgField3.getPortrait();
            }
            userReplyInfoData.setmPortrait(str2);
            if (baseMsg != null && (commonMsgField2 = baseMsg.getCommonMsgField()) != null) {
                userReplyInfoData.setmUid(commonMsgField2.getUserId());
            }
            if (baseMsg != null && (commonMsgField = baseMsg.getCommonMsgField()) != null) {
                z = commonMsgField.isRobot();
            } else {
                z = true;
            }
            userReplyInfoData.setRobot(z);
            return userReplyInfoData;
        }
        return (UserReplyInfoData) invokeL.objValue;
    }
}
