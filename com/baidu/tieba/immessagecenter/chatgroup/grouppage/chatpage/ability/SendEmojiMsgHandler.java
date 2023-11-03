package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability;

import android.content.Context;
import android.os.Vibrator;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.as8;
import com.baidu.tieba.dn8;
import com.baidu.tieba.gk5;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbEmojiReplySysMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.is8;
import com.baidu.tieba.ns8;
import com.baidu.tieba.os8;
import com.baidu.tieba.qr8;
import com.baidu.tieba.wv8;
import com.baidu.tieba.xk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001*B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J,\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J \u0010$\u001a\u00020\u001f2\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J \u0010&\u001a\u00020'2\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020)H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendEmojiMsgHandler;", "Lcom/baidu/tieba/im/base/core/uilist/BaseAbilityHandler;", "context", "Landroid/content/Context;", "repo", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/GroupChatRepo;", "chatPage", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "(Landroid/content/Context;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/GroupChatRepo;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;)V", "addReact", "", "cancelReact", "getChatPage", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "getContext", "()Landroid/content/Context;", "lastSendTime", "", "mVibrator", "Landroid/os/Vibrator;", "replyEmojiDeadLineCode", "sendTimeInterval", "vibratorTime", "buildEmojiReplySysMsg", "Lcom/baidu/tieba/im/lib/socket/msg/TbEmojiReplySysMsg;", "oriMsg", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "conf", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendEmojiMsgHandler$Conf;", "doHandle", "", "abilityItem", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "payload", "", "executeOptionEmojiStrategy", "executeVibratorEffect", "isCanSendEmojiReply", "", "provideType", "", "Conf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SendEmojiMsgHandler extends dn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context b;
    public final GroupChatRepo c;
    public final ChatPage d;
    public long e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public Vibrator j;
    public final long k;

    @Override // com.baidu.tieba.dn8
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "send_emoji_msg" : (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendEmojiMsgHandler$Conf;", "Ljava/io/Serializable;", "emojiContent", "", "isReplyOp", "", "(Ljava/lang/String;Z)V", "getEmojiContent", "()Ljava/lang/String;", "()Z", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", "", "hashCode", "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("content")
        public final String emojiContent;
        @SerializedName(SpeedStatsUtils.UBC_KEY_OPTION)
        public final boolean isReplyOp;

        public static /* synthetic */ Conf copy$default(Conf conf, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = conf.emojiContent;
            }
            if ((i & 2) != 0) {
                z = conf.isReplyOp;
            }
            return conf.copy(str, z);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.emojiContent : (String) invokeV.objValue;
        }

        public final boolean component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isReplyOp : invokeV.booleanValue;
        }

        public final Conf copy(String emojiContent, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, emojiContent, z)) == null) {
                Intrinsics.checkNotNullParameter(emojiContent, "emojiContent");
                return new Conf(emojiContent, z);
            }
            return (Conf) invokeLZ.objValue;
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
                    return Intrinsics.areEqual(this.emojiContent, conf.emojiContent) && this.isReplyOp == conf.isReplyOp;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int hashCode = this.emojiContent.hashCode() * 31;
                boolean z = this.isReplyOp;
                int i = z;
                if (z != 0) {
                    i = 1;
                }
                return hashCode + i;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "Conf(emojiContent=" + this.emojiContent + ", isReplyOp=" + this.isReplyOp + ')';
            }
            return (String) invokeV.objValue;
        }

        public Conf(String emojiContent, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiContent, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(emojiContent, "emojiContent");
            this.emojiContent = emojiContent;
            this.isReplyOp = z;
        }

        public final String getEmojiContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.emojiContent;
            }
            return (String) invokeV.objValue;
        }

        public final boolean isReplyOp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.isReplyOp;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements xk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendEmojiMsgHandler a;
        public final /* synthetic */ BaseItem<? extends TbBaseMsg> b;
        public final /* synthetic */ Conf c;

        public a(SendEmojiMsgHandler sendEmojiMsgHandler, BaseItem<? extends TbBaseMsg> baseItem, Conf conf) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendEmojiMsgHandler, baseItem, conf};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sendEmojiMsgHandler;
            this.b = baseItem;
            this.c = conf;
        }

        @Override // com.baidu.tieba.xk5
        public void a(String emojiContent, ChatMsg originMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, emojiContent, originMsg) == null) {
                Intrinsics.checkNotNullParameter(emojiContent, "emojiContent");
                Intrinsics.checkNotNullParameter(originMsg, "originMsg");
                this.a.m();
                this.a.l(this.b, this.c);
                this.a.c.w(this.a.k(this.b, this.c), MsgProcessor.d.a.d(MsgProcessor.d.g, false, 0, 2, null));
            }
        }

        @Override // com.baidu.tieba.xk5
        public void b(int i, String errorMsg, String emojiContent, ChatMsg originMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), errorMsg, emojiContent, originMsg}) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(emojiContent, "emojiContent");
                Intrinsics.checkNotNullParameter(originMsg, "originMsg");
                if (i == this.a.g) {
                    this.a.n().w1(R.string.obfuscated_res_0x7f0f063f);
                } else {
                    this.a.n().w1(R.string.obfuscated_res_0x7f0f0640);
                }
            }
        }
    }

    public SendEmojiMsgHandler(Context context, GroupChatRepo repo, ChatPage chatPage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, repo, chatPage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(chatPage, "chatPage");
        this.b = context;
        this.c = repo;
        this.d = chatPage;
        this.f = 500;
        this.g = 2003;
        this.h = 1;
        this.i = 2;
        this.k = 50L;
    }

    @Override // com.baidu.tieba.dn8
    public void b(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Object obj) {
        is8<?, ?> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseItem, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            if (baseItem == null) {
                return;
            }
            TbBaseMsg tbMsg = baseItem.getTbMsg();
            long userId = tbMsg.getUserId();
            Conf conf = (Conf) DataExt.toEntity(abilityItem.getConfMap(), Conf.class);
            if (!o(baseItem, conf) || (b = qr8.c.b(tbMsg.getClass())) == null) {
                return;
            }
            Object a2 = os8.a(b, as8.a, tbMsg);
            if (a2 != null) {
                gk5.b().b(this.b, conf.getEmojiContent(), userId, (ChatMsg) a2, conf.isReplyOp(), new a(this, baseItem, conf));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.imsdk.chatmessage.messages.ChatMsg");
        }
    }

    public final TbEmojiReplySysMsg k(BaseItem<? extends TbBaseMsg> baseItem, Conf conf) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseItem, conf)) == null) {
            TbBaseMsg tbMsg = baseItem.getTbMsg();
            if (tbMsg.getEmojiList() != null) {
                List<EmojiData> emojiList = tbMsg.getEmojiList();
                Intrinsics.checkNotNull(emojiList);
                int size = emojiList.size();
                arrayList = new ArrayList();
                List<EmojiData> emojiList2 = tbMsg.getEmojiList();
                Intrinsics.checkNotNull(emojiList2);
                arrayList.addAll(emojiList2.subList(0, size - 1));
            } else {
                arrayList = null;
            }
            ArrayList arrayList2 = arrayList;
            if (conf.isReplyOp()) {
                i = this.h;
            } else {
                i = this.i;
            }
            TbEmojiReplySysMsg create = TbEmojiReplySysMsg.create(i, ns8.b(tbMsg.getUserId()), tbMsg.getMsgId(), tbMsg.getMsgKey(), 1, arrayList2);
            Intrinsics.checkNotNullExpressionValue(create, "create(if (conf.isReplyO…kService.PACKAGE_ID, ext)");
            return create;
        }
        return (TbEmojiReplySysMsg) invokeLL.objValue;
    }

    public final void l(BaseItem<? extends TbBaseMsg> baseItem, Conf conf) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, baseItem, conf) == null) {
            TbBaseMsg tbMsg = baseItem.getTbMsg();
            List<EmojiData> emojiList = tbMsg.getEmojiList();
            if (conf.isReplyOp()) {
                if (emojiList != null && !emojiList.isEmpty()) {
                    EmojiData b = wv8.b(conf.getEmojiContent(), emojiList);
                    if (b != null) {
                        b.setAllNum(b.getAllNum() + 1);
                        b.setReplied(1);
                        return;
                    }
                    emojiList.add(emojiList.size() - 1, new EmojiData(conf.getEmojiContent(), tbMsg.getMsgId(), tbMsg.getMsgKey(), 1, System.currentTimeMillis() / 1000, Boolean.FALSE, 1));
                    return;
                }
                tbMsg.setEmojiList(new ArrayList());
                List<EmojiData> emojiList2 = tbMsg.getEmojiList();
                if (emojiList2 != null) {
                    emojiList2.add(new EmojiData(conf.getEmojiContent(), tbMsg.getMsgId(), tbMsg.getMsgKey(), 1, System.currentTimeMillis(), Boolean.FALSE, 1));
                }
                if (emojiList2 != null) {
                    emojiList2.add(new EmojiData(conf.getEmojiContent(), tbMsg.getMsgId(), tbMsg.getMsgKey(), 0, System.currentTimeMillis() / 1000, Boolean.TRUE, 0));
                    return;
                }
                return;
            }
            String emojiContent = conf.getEmojiContent();
            Intrinsics.checkNotNull(emojiList);
            EmojiData b2 = wv8.b(emojiContent, emojiList);
            if (b2 != null) {
                b2.setAllNum(b2.getAllNum() - 1);
                b2.setReplied(0);
                if (b2.getAllNum() <= 0) {
                    emojiList.remove(b2);
                    if (emojiList.size() <= 1) {
                        tbMsg.setEmojiList(null);
                    }
                }
            }
        }
    }

    public final void m() {
        Vibrator vibrator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.j == null) {
                Object systemService = this.b.getSystemService("vibrator");
                if (systemService instanceof Vibrator) {
                    vibrator = (Vibrator) systemService;
                } else {
                    vibrator = null;
                }
                this.j = vibrator;
            }
            Vibrator vibrator2 = this.j;
            if (vibrator2 != null) {
                vibrator2.vibrate(this.k);
            }
        }
    }

    public final ChatPage n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (ChatPage) invokeV.objValue;
    }

    public final boolean o(BaseItem<? extends TbBaseMsg> baseItem, Conf conf) {
        InterceptResult invokeLL;
        List<EmojiData> emojiList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, baseItem, conf)) == null) {
            if (System.currentTimeMillis() - this.e <= this.f) {
                this.d.w1(R.string.obfuscated_res_0x7f0f0641);
                return false;
            }
            this.e = System.currentTimeMillis();
            if (this.d.K0().e3() != null) {
                InputToolFragment e3 = this.d.K0().e3();
                Intrinsics.checkNotNull(e3);
                if (e3.P2() != null) {
                    InputToolFragment e32 = this.d.K0().e3();
                    Intrinsics.checkNotNull(e32);
                    InputDelegate P2 = e32.P2();
                    Intrinsics.checkNotNull(P2);
                    if (!wv8.c(P2)) {
                        this.d.w1(R.string.obfuscated_res_0x7f0f0642);
                        return false;
                    }
                }
            }
            if (conf.isReplyOp() && (emojiList = baseItem.getTbMsg().getEmojiList()) != null && wv8.b(conf.getEmojiContent(), emojiList) == null && emojiList.size() > 10) {
                this.d.w1(R.string.obfuscated_res_0x7f0f0643);
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
