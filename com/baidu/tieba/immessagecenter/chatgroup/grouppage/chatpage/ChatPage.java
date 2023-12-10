package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.tieba.a49;
import com.baidu.tieba.aw8;
import com.baidu.tieba.b49;
import com.baidu.tieba.bj;
import com.baidu.tieba.d49;
import com.baidu.tieba.e49;
import com.baidu.tieba.f49;
import com.baidu.tieba.g49;
import com.baidu.tieba.go8;
import com.baidu.tieba.gu5;
import com.baidu.tieba.hz8;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.inputtool.callback.uistate.ViewState;
import com.baidu.tieba.im.base.core.inputtool.consts.BotSourceType;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter;
import com.baidu.tieba.im.base.core.uilist.MsgSender;
import com.baidu.tieba.im.lib.socket.msg.TbAtUserInfo;
import com.baidu.tieba.im.lib.socket.msg.TbBaseImageMsg;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbBigEmotionMsg;
import com.baidu.tieba.im.lib.socket.msg.TbImageMsg;
import com.baidu.tieba.im.lib.socket.msg.TbNoticeModifySysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbReMsgInfo;
import com.baidu.tieba.im.lib.socket.msg.TbTextGenImageMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextMsg;
import com.baidu.tieba.im.lib.socket.msg.TbVoiceMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.im.lib.socket.msg.data.Reaction;
import com.baidu.tieba.im.lib.socket.msg.data.TopBubbleData;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.ImageAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.NoticeModifyAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.RecallAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.ShareChatRoomAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.ShareCommonCardAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.ShareForumAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.ShareThreadAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.SingleTextImageAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.SubscribeAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.TextAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.TextGenImageAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.TimestampAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.TipsAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.VoiceAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.data.PayloadData;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.ActivitySysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.BaseImageItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.BigEmotionItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.EffectGuidanceSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.EmojiReplySysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.ExcellentSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.ImageItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.NoticeModifySysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.RecallSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.ShareChatRoomSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.ShareCommonCardSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.ShareForumSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.ShareThreadSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.SingleTextImageItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.SubscribeSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TextGenImageItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TextGenImageUpdateSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TextItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TimestampSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TipsSysItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.VoiceItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.positionbubble.UpBubbleSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.CallRobotHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.InputBoxHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.JumpMsgHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.JumpToHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.OpenEmojiDetailHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.OpenReactionPanelHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.RequestRouterHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.SendEmojiMsgHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.SendMsgHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.SendStructMsgHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect.EffectSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.kq8;
import com.baidu.tieba.lq8;
import com.baidu.tieba.lz8;
import com.baidu.tieba.n05;
import com.baidu.tieba.nq8;
import com.baidu.tieba.oq8;
import com.baidu.tieba.p05;
import com.baidu.tieba.pq8;
import com.baidu.tieba.rq8;
import com.baidu.tieba.sq8;
import com.baidu.tieba.t39;
import com.baidu.tieba.un8;
import com.baidu.tieba.v29;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wn8;
import com.baidu.tieba.xn8;
import com.baidu.tieba.xv8;
import com.baidu.tieba.y39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes6.dex */
public class ChatPage extends Slice implements wn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BotsDTO A;
    public y39 B;
    @NonNull
    public final lq8 C;
    @NonNull
    public final kq8 D;
    @NonNull
    public final SendMsgHandler E;
    public final SendStructMsgHandler F;
    @NonNull
    public final nq8.c G;
    public final CustomMessageListener H;
    public t39 I;
    public final oq8<BaseItem<? extends TbBaseMsg>> J;
    public final pq8<BaseItem<? extends TbBaseMsg>> K;
    public final v29 L;
    public final GroupChatRepo.u<TreeSet<ChatMsg>> M;
    public final CustomMessageListener N;
    public VoiceAdapter O;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> j;
    @NonNull
    public final GroupChatFragment k;
    @NonNull
    public final GroupChatRepo l;
    public TipsAdapter m;
    public RecallAdapter n;
    public NoticeModifyAdapter o;
    public SingleTextImageAdapter p;
    public TextGenImageAdapter q;
    public ShareThreadAdapter r;
    public String s;
    public TopBubbleData t;
    public int u;
    public final PayloadData v;
    public final GroupChatRepo.t<TreeSet<ChatMsg>> w;
    public d49 x;
    public c0 y;
    @Nullable
    public ChatRoomDetail z;

    /* loaded from: classes6.dex */
    public class f implements MsgProcessor.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final bj a;
        public final /* synthetic */ ChatPage b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ Runnable c;
            public final /* synthetic */ f d;

            /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0342a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0342a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.a.d.b.k1();
                    }
                }
            }

            public a(f fVar, List list, boolean z, Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, list, Boolean.valueOf(z), runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = fVar;
                this.a = list;
                this.b = z;
                this.c = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.d.b.y.b.updateData(this.a, true, BaseItem.getDIFF_ITEM_CALLBACK());
                    this.d.b.k.B3();
                    if (this.b) {
                        Runnable runnable = this.c;
                        if (runnable == null) {
                            runnable = new RunnableC0342a(this);
                        }
                        UiUtils.post(runnable);
                    }
                }
            }
        }

        public f(ChatPage chatPage) {
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
            this.b = chatPage;
            this.a = new bj(this.b.y.b);
        }

        @Override // com.baidu.tieba.im.base.core.repo.MsgProcessor.b
        public void a(long j, @NonNull List<? extends BaseItem<? extends TbBaseMsg>> list, @NonNull MsgProcessor.d dVar) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), list, dVar}) != null) || this.b.k.d3()) {
                return;
            }
            if (dVar.h() && (dVar.f() || this.b.h1(dVar))) {
                z = true;
            } else {
                z = false;
            }
            this.a.e(new a(this, list, z, dVar.d()));
        }
    }

    /* loaded from: classes6.dex */
    public class d0<Adapter extends BaseNormalAdapter, Msg extends BaseImageItem<? extends TbBaseImageMsg>> extends b0<Adapter, Msg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* loaded from: classes6.dex */
        public class a implements un8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsgSender.d a;
            public final /* synthetic */ TbBaseImageMsg b;
            public final /* synthetic */ d0 c;

            public a(d0 d0Var, MsgSender.d dVar, TbBaseImageMsg tbBaseImageMsg) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d0Var, dVar, tbBaseImageMsg};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = d0Var;
                this.a = dVar;
                this.b = tbBaseImageMsg;
            }

            @Override // com.baidu.tieba.un8
            public void a(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                    this.a.b();
                }
            }

            @Override // com.baidu.tieba.un8
            public void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.c(i);
                }
            }

            @Override // com.baidu.tieba.un8
            public void c(int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                    this.b.setThumbUrl(str2);
                    this.b.setBigSrc(str);
                    this.b.onUploadImageSuccess();
                    this.a.a();
                    if (this.c.d.z != null && this.c.d.z.getBasicInfo() != null) {
                        hz8.d("c15090", 2, this.c.d.z.getBasicInfo().getForumId(), this.c.d.z.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(ChatPage chatPage) {
            super(chatPage, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ChatPage) objArr2[0], (k) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = chatPage;
        }

        public /* synthetic */ d0(ChatPage chatPage, k kVar) {
            this(chatPage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: p */
        public boolean j(@NonNull Msg msg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, msg)) == null) {
                return ((TbBaseImageMsg) msg.getTbMsg()).isInvalidAddress();
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: o */
        public void i(@NonNull Msg msg, @NonNull MsgSender.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, msg, dVar) == null) {
                TbBaseImageMsg tbBaseImageMsg = (TbBaseImageMsg) msg.getTbMsg();
                if (this.d.k.q3() != null && this.d.k.q3().b3() != null && !StringUtils.isNull(tbBaseImageMsg.getThumbUrl())) {
                    this.d.k.q3().b3().g0(tbBaseImageMsg.getThumbUrl(), new a(this, dVar, tbBaseImageMsg));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends b0<VoiceAdapter, VoiceItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* loaded from: classes6.dex */
        public class a implements xn8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsgSender.d a;
            public final /* synthetic */ VoiceItem b;
            public final /* synthetic */ l c;

            public a(l lVar, MsgSender.d dVar, VoiceItem voiceItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, dVar, voiceItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = lVar;
                this.a = dVar;
                this.b = voiceItem;
            }

            @Override // com.baidu.tieba.xn8
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.b.getTbMsg().setVoiceUrl(str);
                    this.a.a();
                    if (this.c.d.z != null && this.c.d.z.getBasicInfo() != null) {
                        hz8.d("c15090", 3, this.c.d.z.getBasicInfo().getForumId(), this.c.d.z.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }

            @Override // com.baidu.tieba.xn8
            public void isFailed() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.b();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ChatPage chatPage) {
            super(chatPage, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ChatPage) objArr2[0], (k) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: p */
        public boolean j(@NonNull VoiceItem voiceItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceItem)) == null) {
                return voiceItem.getTbMsg().isInvalidAddress();
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: o */
        public void i(@NonNull VoiceItem voiceItem, @NonNull MsgSender.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceItem, dVar) == null) && this.d.k.q3() != null && this.d.k.q3().b3() != null && !StringUtils.isNull(voiceItem.getTbMsg().getPath())) {
                this.d.k.q3().b3().h0(voiceItem.getTbMsg().getPath(), new a(this, dVar, voiceItem));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y extends GroupChatRepo.u<TreeSet<ChatMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y a;

            public a(y yVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {yVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = yVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.d.r1();
                }
            }
        }

        public y(ChatPage chatPage) {
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
            this.d = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: n */
        public void f(int i, @NonNull String str, @Nullable TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, treeSet) == null) {
                super.f(i, str, treeSet);
                this.d.z1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.g();
                this.d.y.c.g();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.h();
                this.d.y.c.j();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.u
        public void l(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                if (this.d.k.x3().getVisibility() == 0) {
                    i2 = this.d.k.x3().getHeight();
                } else {
                    i2 = 0;
                }
                if (this.d.y.b.getLayoutManager() instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) this.d.y.b.getLayoutManager()).scrollToPositionWithOffset(i, i2);
                } else {
                    this.d.y.b.scrollToPosition(i);
                }
                if (this.d.y.b.getAdapter() != null) {
                    this.d.y.b.getAdapter().notifyItemChanged(i);
                }
                UiUtils.post(new a(this));
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.u
        public void m(@NonNull GroupChatRepo.FetchedEvent fetchedEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, fetchedEvent) == null) && fetchedEvent == GroupChatRepo.FetchedEvent.TARGET_MSG_NOT_EXIST) {
                if (this.d.t != null && TbadkCoreApplication.getInst().getVersionName().compareTo(this.d.t.getMsgMinVersion()) < 0) {
                    this.d.t = null;
                    this.d.w1(R.string.obfuscated_res_0x7f0f0997);
                    return;
                }
                this.d.w1(R.string.obfuscated_res_0x7f0f0996);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements rq8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public a(ChatPage chatPage) {
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
            this.a = chatPage;
        }

        @Override // com.baidu.tieba.rq8
        public Object a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.v.setBotsDTO(this.a.I0());
                return this.a.v;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public a0(ChatPage chatPage) {
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
            this.a = chatPage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.m0();
                this.a.M0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ChatPage chatPage, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, recycler, state) == null) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public abstract class b0<Adapter extends BaseNormalAdapter, Msg extends BaseItem<? extends TbBaseMsg>> extends MsgSender<Adapter, Msg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

        public b0(ChatPage chatPage) {
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
            this.c = chatPage;
        }

        public /* synthetic */ b0(ChatPage chatPage, k kVar) {
            this(chatPage);
        }

        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        public void k(Msg msg, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, msg, i, i2) == null) && this.c.B != null) {
                this.c.B.a(msg, i, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements BdListView.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public c(ChatPage chatPage) {
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
            this.a = chatPage;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.s
        public void onScrollToTop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.e0(this.a.M);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BdTypeRecyclerView b;
        public g49 c;
        public ImageView d;
        public LinearLayout e;
        public LinearLayout f;

        public c0() {
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

        public static c0 a(@NonNull View view2, @NonNull Fragment fragment) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, view2, fragment)) == null) {
                c0 c0Var = new c0();
                c0Var.a = view2;
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090720);
                c0Var.b = bdTypeRecyclerView;
                c0Var.c = new g49(bdTypeRecyclerView);
                c0Var.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09097d);
                c0Var.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09097c);
                c0Var.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09071a);
                return c0Var;
            }
            return (c0) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public d(ChatPage chatPage) {
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
            this.a = chatPage;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.f0(this.a.w);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public e(ChatPage chatPage) {
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
            this.a = chatPage;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (!this.a.y.b.canScrollVertically(1) && !this.a.l.l0()) {
                    ChatPage chatPage = this.a;
                    chatPage.u = chatPage.y.b.getFirstVisiblePosition();
                    this.a.M0();
                }
                if (i2 < 0) {
                    this.a.r1();
                }
                if (this.a.I != null) {
                    this.a.I.a(this.a.y.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ChatPage chatPage, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.l.w0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends b0<TextAdapter, TextItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: o */
        public boolean j(@NonNull TextItem textItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, textItem)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ChatPage chatPage) {
            super(chatPage, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ChatPage) objArr2[0], (k) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage.b0, com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: p */
        public void k(TextItem textItem, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, textItem, i, i2) == null) {
                super.k(textItem, i, i2);
                if (this.d.z != null && this.d.z.getBasicInfo() != null) {
                    long forumId = this.d.z.getBasicInfo().getForumId();
                    long id = this.d.z.getBasicInfo().getId();
                    if (i == 5) {
                        hz8.d("c15090", 1, forumId, id, TbadkCoreApplication.getCurrentAccount());
                        TbTextMsg tbMsg = textItem.getTbMsg();
                        String text = tbMsg.getText();
                        if (this.d.J0() != null) {
                            this.d.J0().h0(text, tbMsg.getSessionId(), tbMsg.isMaster());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements oq8<NoticeModifySysItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public i(ChatPage chatPage) {
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
            this.a = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq8
        /* renamed from: b */
        public void a(View view2, @NonNull NoticeModifySysItem noticeModifySysItem, int i) {
            TbNoticeModifySysMsg tbMsg;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, noticeModifySysItem, i) == null) && (tbMsg = noticeModifySysItem.getTbMsg()) != null && tbMsg.getChatroomInfo() != null && tbMsg.getChatroomInfo().getNoticeUrl() != null) {
                String noticeUrl = tbMsg.getChatroomInfo().getNoticeUrl();
                BrowserHelper.startWebActivity(this.a.k.getContext(), null, noticeUrl + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, false, true, true, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements oq8<SubscribeSysItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SubscribeAdapter a;
        public final /* synthetic */ ChatPage b;

        public j(ChatPage chatPage, SubscribeAdapter subscribeAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, subscribeAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatPage;
            this.a = subscribeAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq8
        /* renamed from: b */
        public void a(@NonNull View view2, @NonNull SubscribeSysItem subscribeSysItem, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, subscribeSysItem, i) == null) && this.b.k.r3().w0()) {
                this.a.T(true);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925b5);
                if (SelectorHelper.getResources() != null) {
                    textView.setTextColor(SelectorHelper.getResources().getColor(R.color.CAM_X0101));
                }
                this.b.k.r3().y0();
                view2.setEnabled(false);
                TiebaStatic.log(new StatisticItem("c15258"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends GroupChatRepo.t<TreeSet<ChatMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        public k(ChatPage chatPage) {
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
            this.d = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: n */
        public void f(int i, @NonNull String str, @Nullable TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, treeSet) == null) {
                super.f(i, str, treeSet);
                this.d.z1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.g();
                this.d.y.c.f();
                this.d.y1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.h();
                this.d.y.c.i();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.t
        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.d.k1();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.t
        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.d.E0();
                if (this.d.L0() != null) {
                    this.d.L0().n0();
                }
                this.d.o1();
                if (this.d.I != null) {
                    this.d.I.b(this.d.y.b, this.d.l, this.d.M);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends b0<ShareChatRoomAdapter, ShareChatRoomSysItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: o */
        public boolean j(@NonNull ShareChatRoomSysItem shareChatRoomSysItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareChatRoomSysItem)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ChatPage chatPage) {
            super(chatPage, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ChatPage) objArr2[0], (k) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends b0<ShareCommonCardAdapter, ShareCommonCardSysItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: o */
        public boolean j(@NonNull ShareCommonCardSysItem shareCommonCardSysItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareCommonCardSysItem)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ChatPage chatPage) {
            super(chatPage, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ChatPage) objArr2[0], (k) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends b0<ShareForumAdapter, ShareForumSysItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: o */
        public boolean j(@NonNull ShareForumSysItem shareForumSysItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareForumSysItem)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ChatPage chatPage) {
            super(chatPage, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ChatPage) objArr2[0], (k) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends b0<ShareThreadAdapter, ShareThreadSysItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: o */
        public boolean j(@NonNull ShareThreadSysItem shareThreadSysItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareThreadSysItem)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ChatPage chatPage) {
            super(chatPage, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ChatPage) objArr2[0], (k) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends b0<SingleTextImageAdapter, SingleTextImageItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final d0<SingleTextImageAdapter, SingleTextImageItem> d;
        public final /* synthetic */ ChatPage e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ChatPage chatPage) {
            super(chatPage, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ChatPage) objArr2[0], (k) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = chatPage;
            this.d = new d0<>(this.e, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: o */
        public void i(@NonNull SingleTextImageItem singleTextImageItem, @NonNull MsgSender.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, singleTextImageItem, dVar) == null) {
                super.i(singleTextImageItem, dVar);
                this.d.i(singleTextImageItem, dVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: p */
        public boolean j(@NonNull SingleTextImageItem singleTextImageItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, singleTextImageItem)) == null) {
                return this.d.j(singleTextImageItem);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class r extends b0<TextGenImageAdapter, TextGenImageItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender
        /* renamed from: o */
        public boolean j(@NonNull TextGenImageItem textGenImageItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textGenImageItem)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(ChatPage chatPage) {
            super(chatPage, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ChatPage) objArr2[0], (k) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sq8 b;
        public final /* synthetic */ BaseItem c;
        public final /* synthetic */ int d;
        public final /* synthetic */ n05 e;

        public s(ChatPage chatPage, String str, sq8 sq8Var, BaseItem baseItem, int i, n05 n05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, str, sq8Var, baseItem, Integer.valueOf(i), n05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = sq8Var;
            this.c = baseItem;
            this.d = i;
            this.e = n05Var;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, p05Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            if (TextUtils.equals(((TextView) view2).getText().toString(), this.a)) {
                this.b.a().m(this.c, this.d);
            }
            this.e.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class t implements d49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public t(ChatPage chatPage) {
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
            this.a = chatPage;
        }

        @Override // com.baidu.tieba.d49
        public void a(@NonNull TbTextMsg tbTextMsg) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, tbTextMsg) == null) && this.a.k.q3() != null && tbTextMsg.getRobotParams() != null) {
                int i = -1;
                if (tbTextMsg.getRobotParams().get("type") instanceof String) {
                    i = Integer.parseInt((String) tbTextMsg.getRobotParams().get("type"));
                } else if (tbTextMsg.getRobotParams().get("type") instanceof Long) {
                    i = ((Long) tbTextMsg.getRobotParams().get("type")).intValue();
                }
                if (i != 10005 && i != 10006) {
                    if (i == 10007) {
                        this.a.k.q3().G3(2);
                        return;
                    }
                    return;
                }
                this.a.k.q3().G3(1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(ChatPage chatPage, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.f1()) {
                return;
            }
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                if ((map.get("sub_skill_config_type") instanceof Integer) && (map.get("text_gen_image_msg") instanceof TbTextGenImageMsg)) {
                    int intValue = ((Integer) map.get("sub_skill_config_type")).intValue();
                    TbTextGenImageMsg tbTextGenImageMsg = (TbTextGenImageMsg) map.get("text_gen_image_msg");
                    if (this.a.k.q3() != null && this.a.k.q3().b3() != null) {
                        InputDelegate b3 = this.a.k.q3().b3();
                        b3.b0(intValue, tbTextGenImageMsg, this.a.D0(tbTextGenImageMsg));
                        b3.W(BotSourceType.TWO, true, true);
                        this.a.k.J3(ViewState.GONE);
                    }
                }
            }
            if (this.a.z != null && this.a.z.getBasicInfo() != null && this.a.z.getBots() != null && this.a.z.getBots().getBotList() != null) {
                long forumId = this.a.z.getBasicInfo().getForumId();
                String forumName = this.a.z.getBasicInfo().getForumName();
                long id = this.a.z.getBasicInfo().getId();
                for (BotsDTO.BotListDTO botListDTO : this.a.z.getBots().getBotList()) {
                    if (botListDTO != null && !ListUtils.isEmpty(botListDTO.getSkill())) {
                        for (BotsDTO.BotListDTO.SkillDTO skillDTO : botListDTO.getSkill()) {
                            this.a.s = skillDTO.getName();
                        }
                    }
                }
                TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 3).param("fid", forumId).param("fname", forumName).param("room_id", id).param("obj_name", this.a.s).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements oq8<BaseItem<? extends TbBaseMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public v(ChatPage chatPage) {
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
            this.a = chatPage;
        }

        @Override // com.baidu.tieba.oq8
        public void a(@NonNull View view2, @NonNull BaseItem<? extends TbBaseMsg> baseItem, int i) {
            TbReMsgInfo reMsgInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, view2, baseItem, i) == null) {
                if (view2.getId() == R.id.btn_msgitem_resend) {
                    sq8 b = sq8.b(view2);
                    if (b == null) {
                        return;
                    }
                    this.a.v1(b, baseItem, i);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090f1e && (reMsgInfo = baseItem.getTbMsg().getReMsgInfo()) != null) {
                    this.a.l.n0(reMsgInfo.getMsgId(), reMsgInfo.getMsgKey(), this.a.M);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements pq8<BaseItem<? extends TbBaseMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public w(ChatPage chatPage) {
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
            this.a = chatPage;
        }

        @Override // com.baidu.tieba.pq8
        public boolean a(@NonNull View view2, @NonNull BaseItem<? extends TbBaseMsg> baseItem, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, view2, baseItem, i)) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f0907f7 || id == R.id.obfuscated_res_0x7f090f26 || id == R.id.obfuscated_res_0x7f090f03 || id == R.id.obfuscated_res_0x7f090f2a || id == R.id.obfuscated_res_0x7f090f22 || id == R.id.obfuscated_res_0x7f090f23 || id == R.id.obfuscated_res_0x7f090f21 || id == R.id.obfuscated_res_0x7f090f20 || id == R.id.obfuscated_res_0x7f090f1e) {
                    this.a.u1(baseItem);
                    this.a.G0();
                    return false;
                }
                return false;
            }
            return invokeLLI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class x implements v29 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public x(ChatPage chatPage) {
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
            this.a = chatPage;
        }

        @Override // com.baidu.tieba.v29
        public void a(int i, @Nullable BaseItem<? extends TbBaseMsg> baseItem, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, baseItem, obj) == null) {
                if (i != 21) {
                    if (i == 24 && (obj instanceof AbilityItem)) {
                        AbilityItem abilityItem = (AbilityItem) obj;
                        this.a.C.c(abilityItem, baseItem);
                        this.a.F0(abilityItem);
                    }
                } else if (this.a.k.q3() != null && this.a.k.q3().b3() != null && baseItem != null && (obj instanceof UserReplyInfoData)) {
                    this.a.k.q3().b3().L((UserReplyInfoData) obj, baseItem);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ChatPage b;

        public z(ChatPage chatPage, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatPage;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.k.q3().d3().getHeight() <= 0 && this.a < this.b.u) {
                this.b.O0();
            }
        }
    }

    public ChatPage(@NonNull GroupChatFragment groupChatFragment, @NonNull GroupChatRepo groupChatRepo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment, groupChatRepo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = -1;
        this.v = new PayloadData(null);
        this.w = new k(this);
        this.x = new t(this);
        this.C = new lq8();
        this.D = new kq8();
        this.G = nq8.c.b();
        this.H = new u(this, 2921782);
        this.J = new v(this);
        this.K = new w(this);
        this.L = new x(this);
        this.M = new y(this);
        this.N = new g(this, 2921799);
        this.j = groupChatFragment.getPageContext();
        this.k = groupChatFragment;
        this.l = groupChatRepo;
        groupChatRepo.s0(this.w);
        this.E = new SendMsgHandler(groupChatRepo, this);
        this.F = new SendStructMsgHandler(groupChatRepo, this, this.x);
    }

    public void C0(@Nullable VoiceManager voiceManager) {
        VoiceAdapter voiceAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, voiceManager) == null) && (voiceAdapter = this.O) != null && voiceManager != null) {
            voiceAdapter.o0(voiceManager);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void Z(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z2) == null) {
            super.Z(z2);
            if (!z2) {
                y1();
            }
        }
    }

    public final boolean h1(@NonNull MsgProcessor.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, dVar)) == null) {
            if (dVar.g() && g1() && !N()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m1(t39 t39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, t39Var) == null) {
            this.I = t39Var;
        }
    }

    public void p1(y39 y39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, y39Var) == null) {
            this.B = y39Var;
        }
    }

    @Override // com.baidu.tieba.wn8
    public void q(@NonNull AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, abilityItem) == null) {
            this.C.c(abilityItem, null);
        }
    }

    public void u1(@NonNull BaseItem<? extends TbBaseMsg> baseItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048632, this, baseItem) != null) || this.z == null) {
            return;
        }
        this.k.t3().c(baseItem, this.z);
        this.k.t3().h();
    }

    public void w1(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            x1(this.k.getStringSafely(i2), false);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            gu5.b(view2);
            this.y = c0.a(view2, this.b);
            this.k.t3().a(this.L);
            d1();
        }
    }

    @Override // com.baidu.tieba.wn8
    public void d(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048607, this, str, i2) == null) {
            this.l.u(TbVoiceMsg.create(str, i2));
        }
    }

    public void i1(long j2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048613, this, j2, str) == null) {
            this.l.n0(j2, str, this.M);
        }
    }

    @Override // com.baidu.tieba.wn8
    public void j(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048614, this, str, i2) == null) {
            this.C.c(CallRobotHandler.f(str, i2), null);
        }
    }

    @Override // com.baidu.tieba.wn8
    public void k(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, str2) == null) {
            this.l.u(TbImageMsg.create(str, str2));
        }
    }

    public void t1(@NonNull List<EmojiData> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048631, this, list, i2) == null) {
            this.k.p3().l0(list, i2);
        }
    }

    @NonNull
    public final go8 D0(@NonNull TbTextGenImageMsg tbTextGenImageMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbTextGenImageMsg)) == null) {
            go8 go8Var = new go8();
            BotsDTO.BotListDTO.UserDTO userDTO = new BotsDTO.BotListDTO.UserDTO();
            go8Var.a = userDTO;
            userDTO.setName(tbTextGenImageMsg.getUserName());
            go8Var.a.setNameShow(tbTextGenImageMsg.getUserName());
            go8Var.a.setPortrait(tbTextGenImageMsg.getPortrait());
            go8Var.a.setUk(BIMManager.getBdUKFromBdUid(String.valueOf(tbTextGenImageMsg.getUserId())));
            go8Var.b = new BotsDTO.BotListDTO.SkillDTO();
            if (tbTextGenImageMsg.getSubSkillConfig() != null) {
                go8Var.b.setSubSkill(tbTextGenImageMsg.getSubSkillConfig().a);
            }
            go8Var.d(true);
            return go8Var;
        }
        return (go8) invokeL.objValue;
    }

    public final void l1(BotsDTO.BotListDTO botListDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, botListDTO) == null) && botListDTO != null && botListDTO.getUser() != null) {
            BotsDTO.BotListDTO.UserDTO user = botListDTO.getUser();
            TbTextMsg createRobotGuide = TbTextMsg.createRobotGuide(aw8.a(user.getUk()), user.getNameShow(), user.getPortrait(), user.getRobotRole(), user.getForumLevel());
            createRobotGuide.setText("@" + TbadkCoreApplication.getCurrentAccountNameShow() + " " + botListDTO.getAtGuide());
            TbAtUserInfo.AtType atType = TbAtUserInfo.AtType.USER;
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            createRobotGuide.addAtUserInfo(TbAtUserInfo.create(atType, currentAccountId, "@" + TbadkCoreApplication.getCurrentAccountNameShow(), TbadkCoreApplication.getCurrentPortrait(), 0));
            this.l.v(createRobotGuide, MsgProcessor.d.b(true, 5));
        }
    }

    public final void E0() {
        ChatRoomDetail chatRoomDetail;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (chatRoomDetail = this.z) != null && chatRoomDetail.getBots() != null && !ListUtils.isEmpty(this.z.getBots().getBotList())) {
            String string = SharedPrefHelper.getInstance().getString("key_show_bot_tip_list", "");
            List asList = Arrays.asList(string.split(","));
            List<BotsDTO.BotListDTO> botList = this.z.getBots().getBotList();
            for (int i2 = 0; i2 < botList.size(); i2++) {
                BotsDTO.BotListDTO botListDTO = botList.get(i2);
                if (botListDTO != null && botListDTO.getUser() != null && !TextUtils.isEmpty(botListDTO.getUser().getUk()) && !TextUtils.isEmpty(botListDTO.getAtGuide()) && !asList.contains(botListDTO.getUser().getUk()) && !TextUtils.equals(BIMManager.getBdUidFromBdUK(botListDTO.getUser().getUk()), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                    l1(botListDTO);
                    if (TextUtils.isEmpty(string)) {
                        str = botListDTO.getUser().getUk();
                    } else {
                        str = string + "," + botListDTO.getUser().getUk();
                    }
                    SharedPrefHelper.getInstance().putString("key_show_bot_tip_list", str);
                    return;
                }
            }
        }
    }

    public final void F0(AbilityItem abilityItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, abilityItem) == null) && this.A != null) {
            String obj = abilityItem.getConfMap().get("bot_uk").toString();
            String obj2 = abilityItem.getConfMap().get("skill_id").toString();
            BotsDTO.BotListDTO findBotByUk = this.A.findBotByUk(obj);
            BotsDTO.BotListDTO.SkillDTO skillDTO = null;
            if (findBotByUk != null) {
                skillDTO = findBotByUk.cloneSkillById(Integer.parseInt(obj2));
            }
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 3).param("obj_source", 5).param("fid", this.k.k3()).param("fname", this.k.l3()).param("room_id", this.k.m3());
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = "";
            }
            TiebaStatic.log(param.param("obj_name", str).param("obj_id", obj2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.k.q3() != null && this.k.q3().b3() != null && this.k.q3().b3().e()) {
            this.k.q3().b3().D();
        }
    }

    @NonNull
    public final NoticeModifyAdapter Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            this.l.r(NoticeModifySysItem.parsePair());
            NoticeModifyAdapter noticeModifyAdapter = new NoticeModifyAdapter(this.j, NoticeModifySysItem.ADAPTER_TYPE);
            this.o = noticeModifyAdapter;
            noticeModifyAdapter.I(null, new i(this));
            return this.o;
        }
        return (NoticeModifyAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareChatRoomAdapter S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.l.r(ShareChatRoomSysItem.parsePair());
            ShareChatRoomAdapter shareChatRoomAdapter = new ShareChatRoomAdapter(this.j, ShareChatRoomSysItem.ADAPTER_TYPE);
            shareChatRoomAdapter.H(this.C, this.D);
            shareChatRoomAdapter.J(this.K, null);
            shareChatRoomAdapter.M(new m(this));
            return shareChatRoomAdapter;
        }
        return (ShareChatRoomAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareCommonCardAdapter T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            this.l.r(ShareCommonCardSysItem.parsePair());
            ShareCommonCardAdapter shareCommonCardAdapter = new ShareCommonCardAdapter(this.j, ShareCommonCardSysItem.ADAPTER_TYPE);
            shareCommonCardAdapter.i0(this.k.m3());
            shareCommonCardAdapter.H(this.C, this.D);
            shareCommonCardAdapter.J(this.K, null);
            shareCommonCardAdapter.M(new n(this));
            return shareCommonCardAdapter;
        }
        return (ShareCommonCardAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareForumAdapter U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            this.l.r(ShareForumSysItem.parsePair());
            ShareForumAdapter shareForumAdapter = new ShareForumAdapter(this.j, ShareForumSysItem.ADAPTER_TYPE);
            shareForumAdapter.H(this.C, this.D);
            shareForumAdapter.k0(this.k.m3());
            shareForumAdapter.J(this.K, null);
            shareForumAdapter.M(new o(this));
            return shareForumAdapter;
        }
        return (ShareForumAdapter) invokeV.objValue;
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.l.r(EffectGuidanceSysItem.parsePair());
            this.l.r(ExcellentSysItem.parsePair());
            this.l.r(EmojiReplySysItem.parsePair());
            this.l.r(ActivitySysItem.parsePair());
        }
    }

    public void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            int lastVisiblePosition = this.y.b.getLastVisiblePosition();
            if (this.k.q3() != null && this.k.q3().d3() != null) {
                this.k.q3().d3().post(new z(this, lastVisiblePosition));
            }
        }
    }

    @NonNull
    public kq8 H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.D;
        }
        return (kq8) invokeV.objValue;
    }

    @Nullable
    public BotsDTO I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.A;
        }
        return (BotsDTO) invokeV.objValue;
    }

    @Nullable
    public EffectSlice J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.k.o3();
        }
        return (EffectSlice) invokeV.objValue;
    }

    @NonNull
    public GroupChatFragment K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.k;
        }
        return (GroupChatFragment) invokeV.objValue;
    }

    @Nullable
    public UpBubbleSlice L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k.y3();
        }
        return (UpBubbleSlice) invokeV.objValue;
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.y.e.getVisibility() == 0) {
            this.y.e.setVisibility(8);
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.y.e.getVisibility() != 0) {
            this.y.e.setVisibility(0);
            this.y.e.setOnClickListener(new a0(this));
        }
    }

    @NonNull
    public final RecallAdapter R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.l.r(RecallSysItem.parsePair());
            RecallAdapter recallAdapter = new RecallAdapter(this.j, RecallSysItem.ADAPTER_TYPE);
            this.n = recallAdapter;
            return recallAdapter;
        }
        return (RecallAdapter) invokeV.objValue;
    }

    @NonNull
    public final SubscribeAdapter X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            this.l.r(SubscribeSysItem.parsePair());
            SubscribeAdapter subscribeAdapter = new SubscribeAdapter(this.j, SubscribeSysItem.ADAPTER_TYPE);
            subscribeAdapter.I(null, new j(this, subscribeAdapter));
            return subscribeAdapter;
        }
        return (SubscribeAdapter) invokeV.objValue;
    }

    @NonNull
    public final TimestampAdapter b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            this.l.r(TimestampSysItem.parsePair());
            return new TimestampAdapter(this.j, TimestampSysItem.ADAPTER_TYPE);
        }
        return (TimestampAdapter) invokeV.objValue;
    }

    @NonNull
    public final TipsAdapter c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            this.l.r(TipsSysItem.parsePair());
            TipsAdapter tipsAdapter = new TipsAdapter(this.j, TipsSysItem.ADAPTER_TYPE);
            this.m = tipsAdapter;
            return tipsAdapter;
        }
        return (TipsAdapter) invokeV.objValue;
    }

    public final boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.y.b.getLastVisiblePosition() == this.y.b.getCount() - 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public lq8 j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.C;
        }
        return (lq8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onDestroy();
            this.G.c();
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onStart();
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && this.y.b.canScrollVertically(1)) {
            O0();
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && !BdNetTypeUtil.isNetWorkAvailable() && this.k.getContext() != null) {
            BdUtilHelper.showLongToast(this.k.getContext(), (int) R.string.obfuscated_res_0x7f0f0e70);
        }
    }

    @NonNull
    public final ImageAdapter N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.l.r(BigEmotionItem.parsePair());
            this.E.f(4, TbBigEmotionMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.j, BigEmotionItem.ADAPTER_TYPE);
            imageAdapter.I(this.J, null);
            imageAdapter.J(this.K, null);
            imageAdapter.H(this.C, this.D);
            imageAdapter.M(new d0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final ImageAdapter P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.l.r(ImageItem.parsePair());
            this.E.f(2, TbImageMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.j, ImageItem.ADAPTER_TYPE);
            imageAdapter.I(this.J, null);
            imageAdapter.J(this.K, null);
            imageAdapter.H(this.C, this.D);
            imageAdapter.M(new d0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareThreadAdapter V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.l.r(ShareThreadSysItem.parsePair());
            ShareThreadAdapter shareThreadAdapter = new ShareThreadAdapter(this.j, ShareThreadSysItem.ADAPTER_TYPE);
            this.r = shareThreadAdapter;
            shareThreadAdapter.m0(this.k.m3());
            this.r.H(this.C, this.D);
            this.r.J(this.K, null);
            this.r.M(new p(this));
            return this.r;
        }
        return (ShareThreadAdapter) invokeV.objValue;
    }

    @NonNull
    public final SingleTextImageAdapter W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            this.l.r(SingleTextImageItem.parsePair());
            SingleTextImageAdapter singleTextImageAdapter = new SingleTextImageAdapter(this.j, SingleTextImageItem.ADAPTER_TYPE);
            this.p = singleTextImageAdapter;
            singleTextImageAdapter.I(this.J, null);
            this.p.J(this.K, null);
            this.p.H(this.C, this.D);
            this.p.M(new q(this));
            return this.p;
        }
        return (SingleTextImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final TextAdapter Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            this.l.r(TextItem.parsePair());
            this.E.f(1, TbTextMsg.class);
            TextAdapter textAdapter = new TextAdapter(this.j, TextItem.ADAPTER_TYPE);
            textAdapter.M(new h(this));
            textAdapter.I(this.J, null);
            textAdapter.J(this.K, null);
            textAdapter.H(this.C, this.D);
            return textAdapter;
        }
        return (TextAdapter) invokeV.objValue;
    }

    @NonNull
    public final TextGenImageAdapter a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            this.l.r(TextGenImageItem.parsePair());
            this.l.r(TextGenImageUpdateSysItem.parsePair());
            TextGenImageAdapter textGenImageAdapter = new TextGenImageAdapter(this.j, TextGenImageItem.ADAPTER_TYPE);
            this.q = textGenImageAdapter;
            textGenImageAdapter.I(this.J, null);
            this.q.J(this.K, null);
            this.q.H(this.C, this.D);
            this.q.M(new r(this));
            return this.q;
        }
        return (TextGenImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final VoiceAdapter e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            this.l.r(VoiceItem.parsePair());
            this.E.f(3, TbVoiceMsg.class);
            VoiceAdapter voiceAdapter = new VoiceAdapter(this.j, VoiceItem.ADAPTER_TYPE);
            this.O = voiceAdapter;
            voiceAdapter.I(this.J, null);
            this.O.J(this.K, null);
            this.O.H(this.C, this.D);
            this.O.o0(this.k.d1());
            this.O.M(new l(this));
            return this.O;
        }
        return (VoiceAdapter) invokeV.objValue;
    }

    public boolean f1() {
        InterceptResult invokeV;
        xv8 n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.k.q3() == null || this.k.q3().b3() == null || (n2 = this.k.q3().b3().n()) == null) {
                return false;
            }
            new BdTopToast(this.k.getContext()).setContent(n2.c()).setIcon(false).show((ViewGroup) this.k.getView());
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            ChatRoomDetail chatRoomDetail = this.z;
            if (chatRoomDetail != null && !ListUtils.isEmpty(chatRoomDetail.getQuickTalk()) && ((K0() == null || !K0().C3()) && !this.k.f3())) {
                this.k.J3(ViewState.VISIBLE);
                this.k.n3().e0(this.z);
                return;
            }
            this.k.J3(ViewState.GONE);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    @Nullable
    public View U(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08fb, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.wn8
    public void b(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, str, str2, map) == null) {
            this.l.u(TbBigEmotionMsg.create(str, str2, map));
        }
    }

    public void s1(int i2, @NonNull BaseItem<? extends TbBaseMsg> baseItem, @Nullable List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048630, this, i2, baseItem, list) == null) {
            this.k.s3().q0(i2, baseItem, list);
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.C.a(this.E);
            this.C.a(this.F);
            this.C.a(new CallRobotHandler(this));
            this.C.a(new JumpToHandler(this.j));
            this.C.a(new InputBoxHandler(this));
            this.C.a(new a49());
            this.C.a(new e49(this));
            this.C.a(new JumpMsgHandler(this));
            this.C.a(new RequestRouterHandler(this));
            this.C.a(new b49(this));
            this.C.a(new SendEmojiMsgHandler(this.k.getContext(), this.l, this));
            this.C.a(new OpenEmojiDetailHandler(this));
            this.C.a(new OpenReactionPanelHandler(this));
            Y0();
            this.G.a(Z0());
            this.G.a(Q0());
            this.G.a(b1());
            this.G.a(c1());
            this.G.a(R0());
            this.G.a(e1());
            this.G.a(P0());
            this.G.a(U0());
            this.G.a(V0());
            this.G.a(N0());
            this.G.a(W0());
            this.G.a(a1());
            this.G.a(X0());
            this.G.a(S0());
            this.G.a(T0());
            this.G.f(new a(this));
            this.y.b.addAdapters(this.G.e());
            this.y.b.setLayoutManager(new b(this, this.k.getContext()));
            this.y.b.setOnScrollToTopListener(new c(this));
            this.y.b.setOnSrollToBottomListener(new d(this));
            this.y.b.addOnScrollListener(new e(this));
            this.l.B(new f(this));
            this.k.registerListener(this.H);
            this.k.registerListener(this.N);
        }
    }

    public final void k1() {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            int lastVisiblePosition = this.y.b.getLastVisiblePosition();
            int firstVisiblePosition = this.y.b.getFirstVisiblePosition();
            if (lastVisiblePosition != -1 && this.y.b.getCount() > 0 && this.y.b.getCount() - 1 == lastVisiblePosition) {
                this.u = firstVisiblePosition;
            }
            RecyclerView.LayoutManager layoutManager = this.y.b.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                int count = this.y.b.getCount() - 1;
                int i2 = Integer.MIN_VALUE;
                if (count > 0 && (findViewByPosition = layoutManager.findViewByPosition(count)) != null) {
                    i2 = -findViewByPosition.getHeight();
                }
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(count, i2);
            }
        }
    }

    @Override // com.baidu.tieba.wn8
    public void m(@NonNull String str, @Nullable Object obj, @Nullable go8 go8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map, int i2) {
        TbBaseMsg tbBaseMsg;
        TbBaseMsg q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{str, obj, go8Var, list, map, Integer.valueOf(i2)}) == null) {
            if (obj instanceof BaseItem) {
                tbBaseMsg = ((BaseItem) obj).getTbMsg();
            } else {
                tbBaseMsg = null;
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2 && i2 != 3) {
                        q2 = TbTextMsg.create(str);
                        q2.addAtUserInfo(f49.o(list, map));
                    }
                } else {
                    q2 = TbTextMsg.create(str);
                    if (tbBaseMsg != null) {
                        q2.setReMsgInfo(TbReMsgInfo.create(tbBaseMsg, ((Object) lz8.b(tbBaseMsg)) + tbBaseMsg.getThumbnailText().toString()));
                    }
                    q2.addAtUserInfo(f49.o(list, map));
                }
                if (go8Var != null && go8Var.b != null && this.k.q3() != null) {
                    if (go8Var.b.getType() == 10005 && go8Var.b.getType() != 10006) {
                        if (go8Var.b.getType() == 10007) {
                            this.k.q3().G3(2);
                        }
                    } else {
                        this.k.q3().G3(1);
                    }
                }
                this.l.u(q2);
            }
            q2 = f49.q(f49.m(str, tbBaseMsg, go8Var, list, map), go8Var);
            if (go8Var != null) {
                if (go8Var.b.getType() == 10005) {
                }
                this.k.q3().G3(1);
            }
            this.l.u(q2);
        }
    }

    public void n1(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, chatRoomDetail) == null) {
            this.z = chatRoomDetail;
            this.A = chatRoomDetail.getBots();
            long id = chatRoomDetail.getBasicInfo().getId();
            this.C.f(id);
            this.D.g(id);
            this.D.f(chatRoomDetail.getBasicInfo().getForumName());
            this.D.e(chatRoomDetail.getBasicInfo().getForumId());
            this.D.h(chatRoomDetail.getBasicInfo().getName());
            this.m.T(chatRoomDetail.getBasicInfo().getForumId());
            this.m.U(chatRoomDetail.getBasicInfo().getId());
            this.o.T(chatRoomDetail.getBasicInfo().getForumId());
            this.o.U(chatRoomDetail.getBasicInfo().getId());
            this.n.T(chatRoomDetail.getBasicInfo().getForumId());
            this.n.U(chatRoomDetail.getBasicInfo().getId());
            this.p.a(chatRoomDetail.getBasicInfo().getForumName());
            this.q.a(chatRoomDetail.getBasicInfo().getForumName());
            this.r.k0(chatRoomDetail.getBasicInfo().getForumId());
            this.r.l0(chatRoomDetail.getBasicInfo().getForumName());
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.y.c.h(i2);
            RecyclerView.Adapter adapter = this.y.b.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            EMManager.from(this.y.e).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0207);
            this.y.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.down_positioning_bubble_icon, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void q1(@NonNull String str, int i2, BotSourceType botSourceType, @Nullable TbBaseMsg tbBaseMsg, boolean z2, boolean z3, boolean z4, @Nullable String str2) {
        BotsDTO.BotListDTO findBotByUk;
        BotsDTO.BotListDTO.SkillDTO cloneSkillById;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048628, this, new Object[]{str, Integer.valueOf(i2), botSourceType, tbBaseMsg, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str2}) != null) || f1()) {
            return;
        }
        BotsDTO botsDTO = this.A;
        boolean z5 = true;
        if (botsDTO != null && (findBotByUk = botsDTO.findBotByUk(str)) != null && (cloneSkillById = findBotByUk.cloneSkillById(i2)) != null) {
            if (str2 != null && !str2.isEmpty()) {
                cloneSkillById.setKeyboardContent(str2);
            }
            if (this.k.q3() != null && this.k.q3().b3() != null) {
                InputDelegate b3 = this.k.q3().b3();
                AtSelectData atSelectData = null;
                if (z3 && tbBaseMsg != null) {
                    atSelectData = new AtSelectData(tbBaseMsg.getPortrait(), tbBaseMsg.getUserName(), String.valueOf(tbBaseMsg.getUserId()), tbBaseMsg.isRobot());
                    b3.m().E(atSelectData.getUid(), atSelectData);
                }
                b3.P(tbBaseMsg, findBotByUk.getUser(), cloneSkillById, z2);
                if (cloneSkillById.isFuncShowPanel() && (b3.w() == null || !b3.w().M())) {
                    b3.W(botSourceType, true, z4);
                }
                String x2 = b3.x();
                b3.T("");
                if (atSelectData != null && cloneSkillById.isCanKeyboardInput()) {
                    b3.a(atSelectData, true, cloneSkillById.isFuncShowPanel());
                }
                if (!TextUtils.isEmpty(x2)) {
                    b3.S(x2);
                }
                if (cloneSkillById.isFuncSendMsg()) {
                    b3.k();
                    b3.l();
                    b3.j();
                }
                z5 = false;
            }
        }
        if (z5) {
            w1(R.string.obfuscated_res_0x7f0f094c);
        }
    }

    public final void v1(@NonNull sq8 sq8Var, @NonNull BaseItem<? extends TbBaseMsg> baseItem, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048633, this, sq8Var, baseItem, i2) == null) {
            n05 n05Var = new n05(this.j);
            String string = this.j.getString(R.string.msg_resend);
            n05Var.i(null, new String[]{string}, new s(this, string, sq8Var, baseItem, i2, n05Var));
            n05Var.l();
        }
    }

    public void x1(@NonNull String str, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048635, this, str, z2) == null) && this.k.getContext() != null) {
            new BdTopToast(this.k.getContext()).setContent(str).setIcon(z2).show((ViewGroup) this.k.getView());
        }
    }
}
