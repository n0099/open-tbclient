package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.jz8;
import com.baidu.tieba.mq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/OpenReactionPanelHandler;", "Lcom/baidu/tieba/im/base/core/uilist/BaseAbilityHandler;", "chatPage", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "(Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;)V", "getChatPage", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "doHandle", "", "abilityItem", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "oriMsg", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "payload", "", "isCanOpenReactionPanel", "", "provideType", "", "Conf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class OpenReactionPanelHandler extends mq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatPage b;

    @Override // com.baidu.tieba.mq8
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "open_emoji_panel" : (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/OpenReactionPanelHandler$Conf;", "Ljava/io/Serializable;", "scene", "", "(I)V", "getScene", "()I", "component1", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "toString", "", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int scene;

        public static /* synthetic */ Conf copy$default(Conf conf, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = conf.scene;
            }
            return conf.copy(i);
        }

        public final int component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.scene : invokeV.intValue;
        }

        public final Conf copy(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new Conf(i) : (Conf) invokeI.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Conf) && this.scene == ((Conf) obj).scene;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.scene : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "Conf(scene=" + this.scene + ')';
            }
            return (String) invokeV.objValue;
        }

        public Conf(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scene = i;
        }

        public final int getScene() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.scene;
            }
            return invokeV.intValue;
        }
    }

    public OpenReactionPanelHandler(ChatPage chatPage) {
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

    @Override // com.baidu.tieba.mq8
    public void b(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseItem, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            if (baseItem == null || !f()) {
                return;
            }
            this.b.s1(((Conf) DataExt.toEntity(abilityItem.getConfMap(), Conf.class)).getScene(), baseItem, null);
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.K0().q3() != null) {
                InputToolFragment q3 = this.b.K0().q3();
                Intrinsics.checkNotNull(q3);
                if (q3.b3() != null) {
                    InputToolFragment q32 = this.b.K0().q3();
                    Intrinsics.checkNotNull(q32);
                    InputDelegate b3 = q32.b3();
                    Intrinsics.checkNotNull(b3);
                    if (!jz8.c(b3)) {
                        this.b.w1(R.string.obfuscated_res_0x7f0f064a);
                        return false;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
