package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ek8;
import com.baidu.tieba.en8;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.inputtool.data.InputBanData;
import com.baidu.tieba.im.base.core.inputtool.data.PaddingContentData;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.qd;
import com.baidu.tieba.zv8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\bJ,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/InputBoxHandler;", "Lcom/baidu/tieba/im/base/core/uilist/BaseAbilityHandler;", "chatPage", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "(Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;)V", "buildReplayMessageData", "Lcom/baidu/tieba/im/base/core/inputtool/robotfloor/data/UserReplyInfoData;", "oriMsg", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "doHandle", "", "abilityItem", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "payload", "", "provideType", "", "Conf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InputBoxHandler extends en8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatPage b;

    @Override // com.baidu.tieba.en8
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "input_box" : (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0080\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u000b\u0010\u0016R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014¨\u0006-"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/InputBoxHandler$Conf;", "Ljava/io/Serializable;", "isAt", "", "isReply", "inputText", "", "tips", "banList", "", "Lcom/baidu/tieba/im/base/core/inputtool/data/InputBanData;", "isShowSubPanel", "subPanelText", "paddingContent", "Lcom/baidu/tieba/im/base/core/inputtool/data/PaddingContentData;", "paddingContentPosition", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getBanList", "()Ljava/util/List;", "getInputText", "()Ljava/lang/String;", "()I", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPaddingContent", "getPaddingContentPosition", "getSubPanelText", "getTips", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(IILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/InputBoxHandler$Conf;", "equals", "", "other", "", "hashCode", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("ban_list")
        public final List<InputBanData> banList;
        @SerializedName(TbEnum.ChatInputStatus.INPUT_STATUS_TEXT)
        public final String inputText;
        @SerializedName("is_at")
        public final int isAt;
        @SerializedName("is_reply")
        public final int isReply;
        @SerializedName("is_show_sub_panel")
        public final Integer isShowSubPanel;
        @SerializedName("padding_content")
        public final List<PaddingContentData> paddingContent;
        @SerializedName("padding_content_position")
        public final Integer paddingContentPosition;
        @SerializedName("sub_panel_text")
        public final String subPanelText;
        @SerializedName("tips")
        public final String tips;

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

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.tips : (String) invokeV.objValue;
        }

        public final List<InputBanData> component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.banList : (List) invokeV.objValue;
        }

        public final Integer component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isShowSubPanel : (Integer) invokeV.objValue;
        }

        public final String component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.subPanelText : (String) invokeV.objValue;
        }

        public final List<PaddingContentData> component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.paddingContent : (List) invokeV.objValue;
        }

        public final Integer component9() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.paddingContentPosition : (Integer) invokeV.objValue;
        }

        public final Conf copy(int i, int i2, String inputText, String str, List<InputBanData> list, Integer num, String str2, List<PaddingContentData> list2, Integer num2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), inputText, str, list, num, str2, list2, num2})) == null) {
                Intrinsics.checkNotNullParameter(inputText, "inputText");
                return new Conf(i, i2, inputText, str, list, num, str2, list2, num2);
            }
            return (Conf) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Conf) {
                    Conf conf = (Conf) obj;
                    return this.isAt == conf.isAt && this.isReply == conf.isReply && Intrinsics.areEqual(this.inputText, conf.inputText) && Intrinsics.areEqual(this.tips, conf.tips) && Intrinsics.areEqual(this.banList, conf.banList) && Intrinsics.areEqual(this.isShowSubPanel, conf.isShowSubPanel) && Intrinsics.areEqual(this.subPanelText, conf.subPanelText) && Intrinsics.areEqual(this.paddingContent, conf.paddingContent) && Intrinsics.areEqual(this.paddingContentPosition, conf.paddingContentPosition);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                int hashCode = ((((this.isAt * 31) + this.isReply) * 31) + this.inputText.hashCode()) * 31;
                String str = this.tips;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                List<InputBanData> list = this.banList;
                int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
                Integer num = this.isShowSubPanel;
                int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
                String str2 = this.subPanelText;
                int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
                List<PaddingContentData> list2 = this.paddingContent;
                int hashCode6 = (hashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
                Integer num2 = this.paddingContentPosition;
                return hashCode6 + (num2 != null ? num2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return "Conf(isAt=" + this.isAt + ", isReply=" + this.isReply + ", inputText=" + this.inputText + ", tips=" + this.tips + ", banList=" + this.banList + ", isShowSubPanel=" + this.isShowSubPanel + ", subPanelText=" + this.subPanelText + ", paddingContent=" + this.paddingContent + ", paddingContentPosition=" + this.paddingContentPosition + ')';
            }
            return (String) invokeV.objValue;
        }

        public Conf(int i, int i2, String inputText, String str, List<InputBanData> list, Integer num, String str2, List<PaddingContentData> list2, Integer num2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), inputText, str, list, num, str2, list2, num2};
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
            this.tips = str;
            this.banList = list;
            this.isShowSubPanel = num;
            this.subPanelText = str2;
            this.paddingContent = list2;
            this.paddingContentPosition = num2;
        }

        public final List<InputBanData> getBanList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.banList;
            }
            return (List) invokeV.objValue;
        }

        public final String getInputText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.inputText;
            }
            return (String) invokeV.objValue;
        }

        public final List<PaddingContentData> getPaddingContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.paddingContent;
            }
            return (List) invokeV.objValue;
        }

        public final Integer getPaddingContentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.paddingContentPosition;
            }
            return (Integer) invokeV.objValue;
        }

        public final String getSubPanelText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.subPanelText;
            }
            return (String) invokeV.objValue;
        }

        public final String getTips() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.tips;
            }
            return (String) invokeV.objValue;
        }

        public final int isAt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.isAt;
            }
            return invokeV.intValue;
        }

        public final int isReply() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.isReply;
            }
            return invokeV.intValue;
        }

        public final Integer isShowSubPanel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.isShowSubPanel;
            }
            return (Integer) invokeV.objValue;
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

    @Override // com.baidu.tieba.en8
    public void b(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Object obj) {
        InputDelegate P2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseItem, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            InputToolFragment e3 = this.b.K0().e3();
            if (e3 == null || (P2 = e3.P2()) == null || this.b.f1()) {
                return;
            }
            Conf conf = (Conf) DataExt.toEntity(abilityItem.getConfMap(), Conf.class);
            String tips = conf.getTips();
            int i = 0;
            if (tips != null && tips.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                P2.U(conf.getTips());
            }
            String str = "";
            P2.T("");
            ek8 m = P2.m();
            if (m != null) {
                m.G();
            }
            if (baseItem != null) {
                if (conf.isReply() == 1) {
                    P2.L(f(baseItem), baseItem);
                } else {
                    P2.g();
                }
                if (conf.isAt() == 1) {
                    TbBaseMsg tbMsg = baseItem.getTbMsg();
                    AtSelectData atSelectData = new AtSelectData(tbMsg.getPortrait(), tbMsg.getUserName(), String.valueOf(tbMsg.getUserId()), tbMsg.isRobot());
                    if (conf.isReply() != 1 && qd.isEmpty(conf.getInputText())) {
                        ek8 m2 = P2.m();
                        if (m2 != null) {
                            m2.k(atSelectData, baseItem.getTbMsg().isRobot());
                        }
                    } else {
                        ek8 m3 = P2.m();
                        if (m3 != null) {
                            m3.k(atSelectData, false);
                        }
                    }
                }
            }
            Integer isShowSubPanel = conf.isShowSubPanel();
            if (isShowSubPanel != null && isShowSubPanel.intValue() == 1 && !TextUtils.isEmpty(conf.getSubPanelText())) {
                String subPanelText = conf.getSubPanelText();
                if (subPanelText != null) {
                    str = subPanelText;
                }
                P2.C(str);
                P2.B(conf.getPaddingContent());
                Integer paddingContentPosition = conf.getPaddingContentPosition();
                if (paddingContentPosition != null) {
                    i = paddingContentPosition.intValue();
                }
                P2.Z(i);
                P2.R(conf.getBanList());
            } else {
                P2.f();
            }
            if (!qd.isEmpty(conf.getInputText())) {
                P2.S(conf.getInputText());
            }
            ek8 m4 = P2.m();
            if (m4 != null) {
                m4.C();
            }
        }
    }

    public final UserReplyInfoData f(BaseItem<? extends TbBaseMsg> baseItem) {
        InterceptResult invokeL;
        TbBaseMsg tbBaseMsg;
        CharSequence charSequence;
        CharSequence charSequence2;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseItem)) == null) {
            UserReplyInfoData userReplyInfoData = new UserReplyInfoData();
            String str2 = null;
            if (baseItem != null) {
                tbBaseMsg = baseItem.getTbMsg();
            } else {
                tbBaseMsg = null;
            }
            if (tbBaseMsg != null) {
                charSequence = zv8.b(tbBaseMsg);
            } else {
                charSequence = null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            if (tbBaseMsg != null) {
                charSequence2 = tbBaseMsg.getThumbnailText();
            } else {
                charSequence2 = null;
            }
            spannableStringBuilder.append(charSequence2);
            userReplyInfoData.setmContent(spannableStringBuilder);
            if (tbBaseMsg != null) {
                str = tbBaseMsg.getUserName();
            } else {
                str = null;
            }
            userReplyInfoData.setmNameShow(str);
            if (tbBaseMsg != null) {
                str2 = tbBaseMsg.getPortrait();
            }
            userReplyInfoData.setmPortrait(str2);
            if (tbBaseMsg != null) {
                userReplyInfoData.setmUid(tbBaseMsg.getUserId());
            }
            if (tbBaseMsg != null) {
                z = tbBaseMsg.isRobot();
            } else {
                z = true;
            }
            userReplyInfoData.setRobot(z);
            return userReplyInfoData;
        }
        return (UserReplyInfoData) invokeL.objValue;
    }
}
