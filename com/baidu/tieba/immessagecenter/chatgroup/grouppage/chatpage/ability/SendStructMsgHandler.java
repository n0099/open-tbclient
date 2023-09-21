package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ct8;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.inputtool.data.AtData;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbAtUserInfo;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbReMsgInfo;
import com.baidu.tieba.im.lib.socket.msg.TbTextMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.uf8;
import com.baidu.tieba.ze8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0002J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0014\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00182\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0016\u0010\u001b\u001a\u00020\u00192\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler;", "Lcom/baidu/tieba/im/base/core/uilist/BaseAbilityHandler;", "repo", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/GroupChatRepo;", "chatPage", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "sendTextMsgCallBack", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendMsgAbiCallBack;", "(Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/GroupChatRepo;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendMsgAbiCallBack;)V", "buildAtData", "", "Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo;", "subContent", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler$Conf$SubContent;", "doHandle", "", "abilityItem", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "oriMsg", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "payload", "", "getRobotParams", "", "", "provideType", "spliceHelpAtTextData", "Companion", "Conf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SendStructMsgHandler extends uf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final GroupChatRepo b;
    public final ChatPage c;
    public final ct8 d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-89660298, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-89660298, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler;");
        }
    }

    @Override // com.baidu.tieba.uf8
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "send_struct_msg" : (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler$Conf;", "Ljava/io/Serializable;", "subContent", "", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler$Conf$SubContent;", "(Ljava/util/List;)V", "getSubContent", "()Ljava/util/List;", "component1", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "", "SubContent", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("struct_content")
        public final List<SubContent> subContent;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.SendStructMsgHandler$Conf */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Conf copy$default(Conf conf, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = conf.subContent;
            }
            return conf.copy(list);
        }

        public final List<SubContent> component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.subContent : (List) invokeV.objValue;
        }

        public final Conf copy(List<SubContent> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) ? new Conf(list) : (Conf) invokeL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Conf) && Intrinsics.areEqual(this.subContent, ((Conf) obj).subContent);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                List<SubContent> list = this.subContent;
                if (list == null) {
                    return 0;
                }
                return list.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "Conf(subContent=" + this.subContent + ')';
            }
            return (String) invokeV.objValue;
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler$Conf$SubContent;", "Ljava/io/Serializable;", "type", "", "atData", "Lcom/baidu/tieba/im/base/core/inputtool/data/AtData;", "content", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler$Conf$SubContent$ContentData;", "robotParams", "", "", "(Ljava/lang/String;Lcom/baidu/tieba/im/base/core/inputtool/data/AtData;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler$Conf$SubContent$ContentData;Ljava/util/Map;)V", "getAtData", "()Lcom/baidu/tieba/im/base/core/inputtool/data/AtData;", "getContent", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler$Conf$SubContent$ContentData;", "getRobotParams", "()Ljava/util/Map;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "ContentData", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class SubContent implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @SerializedName("at_data")
            public final AtData atData;
            public final ContentData content;
            @SerializedName("robot_params")
            public final Map<String, Object> robotParams;
            public final String type;

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.SendStructMsgHandler$Conf$SubContent */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SubContent copy$default(SubContent subContent, String str, AtData atData, ContentData contentData, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = subContent.type;
                }
                if ((i & 2) != 0) {
                    atData = subContent.atData;
                }
                if ((i & 4) != 0) {
                    contentData = subContent.content;
                }
                if ((i & 8) != 0) {
                    map = subContent.robotParams;
                }
                return subContent.copy(str, atData, contentData, map);
            }

            public final String component1() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type : (String) invokeV.objValue;
            }

            public final AtData component2() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.atData : (AtData) invokeV.objValue;
            }

            public final ContentData component3() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.content : (ContentData) invokeV.objValue;
            }

            public final Map<String, Object> component4() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.robotParams : (Map) invokeV.objValue;
            }

            public final SubContent copy(String type, AtData atData, ContentData contentData, Map<String, ? extends Object> map) {
                InterceptResult invokeLLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, type, atData, contentData, map)) == null) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    return new SubContent(type, atData, contentData, map);
                }
                return (SubContent) invokeLLLL.objValue;
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof SubContent) {
                        SubContent subContent = (SubContent) obj;
                        return Intrinsics.areEqual(this.type, subContent.type) && Intrinsics.areEqual(this.atData, subContent.atData) && Intrinsics.areEqual(this.content, subContent.content) && Intrinsics.areEqual(this.robotParams, subContent.robotParams);
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public int hashCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    int hashCode = this.type.hashCode() * 31;
                    AtData atData = this.atData;
                    int hashCode2 = (hashCode + (atData == null ? 0 : atData.hashCode())) * 31;
                    ContentData contentData = this.content;
                    int hashCode3 = (hashCode2 + (contentData == null ? 0 : contentData.hashCode())) * 31;
                    Map<String, Object> map = this.robotParams;
                    return hashCode3 + (map != null ? map.hashCode() : 0);
                }
                return invokeV.intValue;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    return "SubContent(type=" + this.type + ", atData=" + this.atData + ", content=" + this.content + ", robotParams=" + this.robotParams + ')';
                }
                return (String) invokeV.objValue;
            }

            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendStructMsgHandler$Conf$SubContent$ContentData;", "Ljava/io/Serializable;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes6.dex */
            public static final class ContentData implements Serializable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final String text;

                public static /* synthetic */ ContentData copy$default(ContentData contentData, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = contentData.text;
                    }
                    return contentData.copy(str);
                }

                public final String component1() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.text : (String) invokeV.objValue;
                }

                public final ContentData copy(String text) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, text)) == null) {
                        Intrinsics.checkNotNullParameter(text, "text");
                        return new ContentData(text);
                    }
                    return (ContentData) invokeL.objValue;
                }

                public boolean equals(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof ContentData) && Intrinsics.areEqual(this.text, ((ContentData) obj).text);
                    }
                    return invokeL.booleanValue;
                }

                public int hashCode() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.text.hashCode() : invokeV.intValue;
                }

                public String toString() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                        return "ContentData(text=" + this.text + ')';
                    }
                    return (String) invokeV.objValue;
                }

                public ContentData(String text) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {text};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    Intrinsics.checkNotNullParameter(text, "text");
                    this.text = text;
                }

                public final String getText() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                        return this.text;
                    }
                    return (String) invokeV.objValue;
                }
            }

            public SubContent(String type, AtData atData, ContentData contentData, Map<String, ? extends Object> map) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {type, atData, contentData, map};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                Intrinsics.checkNotNullParameter(type, "type");
                this.type = type;
                this.atData = atData;
                this.content = contentData;
                this.robotParams = map;
            }

            public final AtData getAtData() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    return this.atData;
                }
                return (AtData) invokeV.objValue;
            }

            public final ContentData getContent() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    return this.content;
                }
                return (ContentData) invokeV.objValue;
            }

            public final Map<String, Object> getRobotParams() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    return this.robotParams;
                }
                return (Map) invokeV.objValue;
            }

            public final String getType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    return this.type;
                }
                return (String) invokeV.objValue;
            }
        }

        public Conf(List<SubContent> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.subContent = list;
        }

        public final List<SubContent> getSubContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.subContent;
            }
            return (List) invokeV.objValue;
        }
    }

    public SendStructMsgHandler(GroupChatRepo repo, ChatPage chatPage, ct8 sendTextMsgCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {repo, chatPage, sendTextMsgCallBack};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(chatPage, "chatPage");
        Intrinsics.checkNotNullParameter(sendTextMsgCallBack, "sendTextMsgCallBack");
        this.b = repo;
        this.c = chatPage;
        this.d = sendTextMsgCallBack;
    }

    @Override // com.baidu.tieba.uf8
    public void b(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Object obj) {
        Boolean bool;
        boolean z;
        InputToolFragment M2;
        InputDelegate r2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseItem, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            if (this.c.e1()) {
                return;
            }
            Conf conf = (Conf) DataExt.toEntity(abilityItem.getConfMap(), Conf.class);
            if (conf.getSubContent() != null && (!conf.getSubContent().isEmpty())) {
                String h = h(conf.getSubContent());
                List<TbAtUserInfo> f = f(conf.getSubContent());
                Map<String, ? extends Object> g = g(conf.getSubContent());
                TbTextMsg a = TbTextMsg.Companion.a(h);
                a.addAtUserInfo(f);
                if (obj instanceof Boolean) {
                    bool = (Boolean) obj;
                } else {
                    bool = null;
                }
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    z = false;
                }
                if (baseItem != null && z) {
                    a.setReMsgInfo(TbReMsgInfo.Companion.a(baseItem.getTbMsg(), baseItem.getTbMsg().getThumbnailText().toString()));
                }
                if (g != null) {
                    a.setRobotParams(g);
                }
                this.d.a(a);
                ze8.A(this.b, a, null, 2, null);
                if (z && (M2 = this.c.J0().M2()) != null && (r2 = M2.r2()) != null) {
                    r2.d();
                }
            }
        }
    }

    public final List<TbAtUserInfo> f(List<Conf.SubContent> list) {
        InterceptResult invokeL;
        String str;
        String atPortrait;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Conf.SubContent subContent : list) {
                int i2 = i + 1;
                if (Intrinsics.areEqual("at", subContent.getType())) {
                    AtData atData = subContent.getAtData();
                    if (atData != null) {
                        str = atData.getAtBaiduUk();
                    } else {
                        str = null;
                    }
                    String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(str);
                    Intrinsics.checkNotNullExpressionValue(bdUidFromBdUK, "getBdUidFromBdUK(atData?.atBaiduUk)");
                    long parseLong = Long.parseLong(bdUidFromBdUK);
                    TbAtUserInfo.a aVar = TbAtUserInfo.Companion;
                    TbAtUserInfo.AtType atType = TbAtUserInfo.AtType.USER;
                    String str2 = "";
                    String str3 = (atData == null || (str3 = atData.getAtName()) == null) ? "" : "";
                    if (atData != null && (atPortrait = atData.getAtPortrait()) != null) {
                        str2 = atPortrait;
                    }
                    arrayList.add(aVar.a(atType, parseLong, str3, str2, i));
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final String h(List<Conf.SubContent> list) {
        InterceptResult invokeL;
        Conf.SubContent.ContentData content;
        AtData atData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Conf.SubContent subContent : list) {
                if (Intrinsics.areEqual("at", subContent.getType()) && (atData = subContent.getAtData()) != null) {
                    sb.append("@");
                    sb.append(atData.getAtName());
                    sb.append(" ");
                }
                if (Intrinsics.areEqual("text", subContent.getType()) && (content = subContent.getContent()) != null) {
                    sb.append(content.getText());
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "textData.toString()");
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public final Map<String, Object> g(List<Conf.SubContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            Map<String, Object> linkedHashMap = new LinkedHashMap<>();
            for (Conf.SubContent subContent : list) {
                if (Intrinsics.areEqual("robot_params", subContent.getType())) {
                    linkedHashMap = subContent.getRobotParams();
                }
            }
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }
}
