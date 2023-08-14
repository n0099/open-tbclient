package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability;

import android.content.Context;
import android.os.Vibrator;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.hk8;
import com.baidu.tieba.ij8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.kj8;
import com.baidu.tieba.qn5;
import com.baidu.tieba.zm5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020&H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendEmojiMsgHandler;", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseAbilityHandler;", "context", "Landroid/content/Context;", "chatPage", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "(Landroid/content/Context;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;)V", "addReact", "", "cancelReact", "getChatPage", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage;", "getContext", "()Landroid/content/Context;", "lastSendTime", "", "mVibrator", "Landroid/os/Vibrator;", "replyEmojiDeadLineCode", "sendTimeInterval", "vibratorTime", "buildEmojiReplySysMsg", "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;", "oriMsg", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseMsg;", "conf", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendEmojiMsgHandler$Conf;", "doHandle", "", "abilityItem", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem;", "payload", "", "executeOptionEmojiStrategy", "executeVibratorEffect", "isCanSendEmojiReply", "", "provideType", "", "Conf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SendEmojiMsgHandler extends ij8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context b;
    public final ChatPage c;
    public long d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public Vibrator i;
    public final long j;

    @Override // com.baidu.tieba.ij8
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "send_emoji_msg" : (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ability/SendEmojiMsgHandler$Conf;", "Ljava/io/Serializable;", "emojiContent", "", "isReplyOp", "", "(Ljava/lang/String;Z)V", "getEmojiContent", "()Ljava/lang/String;", "()Z", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    public static final class a implements qn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendEmojiMsgHandler a;
        public final /* synthetic */ BaseMsg b;
        public final /* synthetic */ Conf c;

        public a(SendEmojiMsgHandler sendEmojiMsgHandler, BaseMsg baseMsg, Conf conf) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendEmojiMsgHandler, baseMsg, conf};
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
            this.b = baseMsg;
            this.c = conf;
        }

        @Override // com.baidu.tieba.qn5
        public void a(String emojiContent, ChatMsg originMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, emojiContent, originMsg) == null) {
                Intrinsics.checkNotNullParameter(emojiContent, "emojiContent");
                Intrinsics.checkNotNullParameter(originMsg, "originMsg");
                this.a.l();
                this.a.k(this.b, this.c);
                this.a.m().c1(this.a.j(this.b, this.c));
            }
        }

        @Override // com.baidu.tieba.qn5
        public void b(int i, String errorMsg, String emojiContent, ChatMsg originMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), errorMsg, emojiContent, originMsg}) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(emojiContent, "emojiContent");
                Intrinsics.checkNotNullParameter(originMsg, "originMsg");
                if (i == this.a.f) {
                    this.a.m().u1(R.string.obfuscated_res_0x7f0f062d);
                } else {
                    this.a.m().u1(R.string.obfuscated_res_0x7f0f062e);
                }
            }
        }
    }

    public SendEmojiMsgHandler(Context context, ChatPage chatPage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatPage};
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
        Intrinsics.checkNotNullParameter(chatPage, "chatPage");
        this.b = context;
        this.c = chatPage;
        this.e = 500;
        this.f = 2003;
        this.g = 1;
        this.h = 2;
        this.j = 50L;
    }

    @Override // com.baidu.tieba.ij8
    public void b(AbilityItem abilityItem, BaseMsg baseMsg, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseMsg, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            if (baseMsg == null) {
                return;
            }
            long userId = baseMsg.getCommonMsgField().getUserId();
            Conf conf = (Conf) DataExt.toEntity(abilityItem.getConfMap(), Conf.class);
            if (!n(baseMsg, conf)) {
                return;
            }
            zm5.b().b(this.b, conf.getEmojiContent(), userId, baseMsg.getSdkMsg(), conf.isReplyOp(), new a(this, baseMsg, conf));
        }
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (Context) invokeV.objValue;
    }

    public final void l() {
        Vibrator vibrator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.i == null) {
                Object systemService = this.b.getSystemService("vibrator");
                if (systemService instanceof Vibrator) {
                    vibrator = (Vibrator) systemService;
                } else {
                    vibrator = null;
                }
                this.i = vibrator;
            }
            Vibrator vibrator2 = this.i;
            if (vibrator2 != null) {
                vibrator2.vibrate(this.j);
            }
        }
    }

    public final ChatPage m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (ChatPage) invokeV.objValue;
    }

    public final ChatMsg j(BaseMsg baseMsg, Conf conf) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseMsg, conf)) == null) {
            HashMap hashMap = new HashMap();
            if (conf.isReplyOp()) {
                i = this.g;
            } else {
                i = this.h;
            }
            hashMap.put("react_type", Integer.valueOf(i));
            String b = kj8.b(baseMsg.getCommonMsgField().getUserId());
            Intrinsics.checkNotNullExpressionValue(b, "oriMsg.commonMsgField.userId.toUk()");
            hashMap.put("msg_from_baidu_uk", b);
            hashMap.put("msg_id", Long.valueOf(baseMsg.getCommonMsgField().getMsgId()));
            String msgKey = baseMsg.getCommonMsgField().getMsgKey();
            Intrinsics.checkNotNullExpressionValue(msgKey, "oriMsg.commonMsgField.msgKey");
            hashMap.put("msg_key", msgKey);
            hashMap.put(Constants.EXTRA_EMOJI_PACKAGE_ID, 1);
            hashMap.put("room_id", Long.valueOf(baseMsg.getCommonMsgField().getRoomId()));
            hashMap.put("is_local", Boolean.TRUE);
            if (baseMsg.getCommonMsgField().getEmojiList() != null) {
                List<EmojiData> emojiList = baseMsg.getCommonMsgField().getEmojiList();
                Intrinsics.checkNotNull(emojiList);
                int size = emojiList.size();
                ArrayList arrayList = new ArrayList();
                List<EmojiData> emojiList2 = baseMsg.getCommonMsgField().getEmojiList();
                Intrinsics.checkNotNull(emojiList2);
                arrayList.addAll(emojiList2.subList(0, size - 1));
                hashMap.put("emoji_reaction_list", arrayList);
            }
            ChatMsg C0 = this.c.C0(hashMap);
            Intrinsics.checkNotNullExpressionValue(C0, "chatPage.generateEmojiReplySysMsg(emojiSysMsgMap)");
            return C0;
        }
        return (ChatMsg) invokeLL.objValue;
    }

    public final void k(BaseMsg baseMsg, Conf conf) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, baseMsg, conf) == null) {
            List<EmojiData> emojiList = baseMsg.getCommonMsgField().getEmojiList();
            if (conf.isReplyOp()) {
                if (emojiList != null && !emojiList.isEmpty()) {
                    EmojiData b = hk8.b(conf.getEmojiContent(), emojiList);
                    if (b != null) {
                        b.setAllNum(b.getAllNum() + 1);
                        b.setReplied(1);
                        return;
                    }
                    String emojiContent = conf.getEmojiContent();
                    long msgId = baseMsg.getCommonMsgField().getMsgId();
                    String msgKey = baseMsg.getCommonMsgField().getMsgKey();
                    Intrinsics.checkNotNullExpressionValue(msgKey, "oriMsg.commonMsgField.msgKey");
                    emojiList.add(emojiList.size() - 1, new EmojiData(emojiContent, msgId, msgKey, 1, System.currentTimeMillis() / 1000, Boolean.FALSE, 1));
                    return;
                }
                baseMsg.getCommonMsgField().setEmojiList(new ArrayList());
                List<EmojiData> emojiList2 = baseMsg.getCommonMsgField().getEmojiList();
                if (emojiList2 != null) {
                    String emojiContent2 = conf.getEmojiContent();
                    long msgId2 = baseMsg.getCommonMsgField().getMsgId();
                    String msgKey2 = baseMsg.getCommonMsgField().getMsgKey();
                    Intrinsics.checkNotNullExpressionValue(msgKey2, "oriMsg.commonMsgField.msgKey");
                    emojiList2.add(new EmojiData(emojiContent2, msgId2, msgKey2, 1, System.currentTimeMillis(), Boolean.FALSE, 1));
                }
                if (emojiList2 != null) {
                    String emojiContent3 = conf.getEmojiContent();
                    long msgId3 = baseMsg.getCommonMsgField().getMsgId();
                    String msgKey3 = baseMsg.getCommonMsgField().getMsgKey();
                    Intrinsics.checkNotNullExpressionValue(msgKey3, "oriMsg.commonMsgField.msgKey");
                    emojiList2.add(new EmojiData(emojiContent3, msgId3, msgKey3, 0, System.currentTimeMillis() / 1000, Boolean.TRUE, 0));
                    return;
                }
                return;
            }
            String emojiContent4 = conf.getEmojiContent();
            Intrinsics.checkNotNull(emojiList);
            EmojiData b2 = hk8.b(emojiContent4, emojiList);
            if (b2 != null) {
                b2.setAllNum(b2.getAllNum() - 1);
                b2.setReplied(0);
                if (b2.getAllNum() <= 0) {
                    emojiList.remove(b2);
                    if (emojiList.size() <= 1) {
                        baseMsg.getCommonMsgField().setEmojiList(null);
                    }
                }
            }
        }
    }

    public final boolean n(BaseMsg baseMsg, Conf conf) {
        InterceptResult invokeLL;
        List<EmojiData> emojiList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, baseMsg, conf)) == null) {
            if (System.currentTimeMillis() - this.d <= this.e) {
                this.c.u1(R.string.obfuscated_res_0x7f0f062f);
                return false;
            }
            this.d = System.currentTimeMillis();
            if (this.c.G0().q2() != null) {
                GroupInputViewController q2 = this.c.G0().q2();
                Intrinsics.checkNotNull(q2);
                if (!hk8.c(q2)) {
                    this.c.u1(R.string.obfuscated_res_0x7f0f0630);
                    return false;
                }
            }
            if (conf.isReplyOp() && (emojiList = baseMsg.getCommonMsgField().getEmojiList()) != null && hk8.b(conf.getEmojiContent(), emojiList) == null && emojiList.size() > 10) {
                this.c.u1(R.string.obfuscated_res_0x7f0f0631);
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
