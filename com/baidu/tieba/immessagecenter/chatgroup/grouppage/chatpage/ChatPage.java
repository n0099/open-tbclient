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
import com.baidu.tieba.ag8;
import com.baidu.tieba.at8;
import com.baidu.tieba.bg8;
import com.baidu.tieba.cd8;
import com.baidu.tieba.cl8;
import com.baidu.tieba.ct8;
import com.baidu.tieba.dt8;
import com.baidu.tieba.ed8;
import com.baidu.tieba.et8;
import com.baidu.tieba.fd8;
import com.baidu.tieba.fl8;
import com.baidu.tieba.ft8;
import com.baidu.tieba.h55;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.inputtool.callback.uistate.ViewState;
import com.baidu.tieba.im.base.core.inputtool.consts.BotSourceType;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter;
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
import com.baidu.tieba.j55;
import com.baidu.tieba.lg;
import com.baidu.tieba.mo8;
import com.baidu.tieba.nn;
import com.baidu.tieba.od8;
import com.baidu.tieba.qo8;
import com.baidu.tieba.rx5;
import com.baidu.tieba.sf8;
import com.baidu.tieba.ss8;
import com.baidu.tieba.tf8;
import com.baidu.tieba.ur8;
import com.baidu.tieba.vf8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wf8;
import com.baidu.tieba.xf8;
import com.baidu.tieba.xs8;
import com.baidu.tieba.zf8;
import com.baidu.tieba.zs8;
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
public class ChatPage extends Slice implements ed8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BotsDTO A;
    public xs8 B;
    @NonNull
    public final tf8 C;
    @NonNull
    public final sf8 D;
    @NonNull
    public final SendMsgHandler E;
    public final SendStructMsgHandler F;
    @NonNull
    public final vf8.c G;
    public final CustomMessageListener H;
    public ss8 I;
    public final wf8<BaseItem<? extends TbBaseMsg>> J;
    public final xf8<BaseItem<? extends TbBaseMsg>> K;
    public final ur8 L;
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
    public ct8 x;
    public c0 y;
    @Nullable
    public ChatRoomDetail z;

    /* loaded from: classes6.dex */
    public class f implements MsgProcessor.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final nn a;
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
            public class RunnableC0341a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0341a(a aVar) {
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
                        this.a.d.b.j1();
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
                    this.d.b.k.X2();
                    if (this.b) {
                        Runnable runnable = this.c;
                        if (runnable == null) {
                            runnable = new RunnableC0341a(this);
                        }
                        lg.c(runnable);
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
            this.a = new nn(this.b.y.b);
        }

        @Override // com.baidu.tieba.im.base.core.repo.MsgProcessor.b
        public void a(long j, @NonNull List<? extends BaseItem<? extends TbBaseMsg>> list, @NonNull MsgProcessor.d dVar) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), list, dVar}) != null) || this.b.k.z2()) {
                return;
            }
            if (dVar.h() && (dVar.f() || this.b.g1(dVar))) {
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
        public class a implements cd8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zf8.e a;
            public final /* synthetic */ TbBaseImageMsg b;
            public final /* synthetic */ d0 c;

            public a(d0 d0Var, zf8.e eVar, TbBaseImageMsg tbBaseImageMsg) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d0Var, eVar, tbBaseImageMsg};
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
                this.a = eVar;
                this.b = tbBaseImageMsg;
            }

            @Override // com.baidu.tieba.cd8
            public void a(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                    this.a.b();
                }
            }

            @Override // com.baidu.tieba.cd8
            public void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.c(i);
                }
            }

            @Override // com.baidu.tieba.cd8
            public void c(int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                    this.b.setThumbUrl(str2);
                    this.b.setBigSrc(str);
                    this.b.onUploadImageSuccess();
                    this.a.a();
                    if (this.c.d.z != null && this.c.d.z.getBasicInfo() != null) {
                        mo8.d("c15090", 2, this.c.d.z.getBasicInfo().getForumId(), this.c.d.z.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
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
        @Override // com.baidu.tieba.zf8
        /* renamed from: q */
        public boolean k(@NonNull Msg msg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, msg)) == null) {
                return ((TbBaseImageMsg) msg.getTbMsg()).isInvalidAddress();
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zf8
        /* renamed from: p */
        public void i(@NonNull Msg msg, @NonNull zf8.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, msg, eVar) == null) {
                TbBaseImageMsg tbBaseImageMsg = (TbBaseImageMsg) msg.getTbMsg();
                if (this.d.k.M2() != null && this.d.k.M2().r2() != null && !StringUtils.isNull(tbBaseImageMsg.getThumbUrl())) {
                    this.d.k.M2().r2().e0(tbBaseImageMsg.getThumbUrl(), new a(this, eVar, tbBaseImageMsg));
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
        public class a implements fd8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zf8.e a;
            public final /* synthetic */ VoiceItem b;
            public final /* synthetic */ l c;

            public a(l lVar, zf8.e eVar, VoiceItem voiceItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, eVar, voiceItem};
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
                this.a = eVar;
                this.b = voiceItem;
            }

            @Override // com.baidu.tieba.fd8
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.b.getTbMsg().setVoiceUrl(str);
                    this.a.a();
                    if (this.c.d.z != null && this.c.d.z.getBasicInfo() != null) {
                        mo8.d("c15090", 3, this.c.d.z.getBasicInfo().getForumId(), this.c.d.z.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }

            @Override // com.baidu.tieba.fd8
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
        @Override // com.baidu.tieba.zf8
        /* renamed from: q */
        public boolean k(@NonNull VoiceItem voiceItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceItem)) == null) {
                return voiceItem.getTbMsg().isInvalidAddress();
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zf8
        /* renamed from: p */
        public void i(@NonNull VoiceItem voiceItem, @NonNull zf8.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceItem, eVar) == null) && this.d.k.M2() != null && this.d.k.M2().r2() != null && !StringUtils.isNull(voiceItem.getTbMsg().getPath())) {
                this.d.k.M2().r2().f0(voiceItem.getTbMsg().getPath(), new a(this, eVar, voiceItem));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y extends GroupChatRepo.u<TreeSet<ChatMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

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
                    this.a.c.q1();
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
            this.c = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: k */
        public void d(int i, @NonNull String str, @Nullable TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, treeSet) == null) {
                super.d(i, str, treeSet);
                this.c.y1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.e();
                this.c.y.c.g();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.f();
                this.c.y.c.j();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.u
        public void i(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                if (this.c.k.T2().getVisibility() == 0) {
                    i2 = this.c.k.T2().getHeight();
                } else {
                    i2 = 0;
                }
                if (this.c.y.b.getLayoutManager() instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) this.c.y.b.getLayoutManager()).scrollToPositionWithOffset(i, i2);
                } else {
                    this.c.y.b.scrollToPosition(i);
                }
                if (this.c.y.b.getAdapter() != null) {
                    this.c.y.b.getAdapter().notifyItemChanged(i);
                }
                lg.c(new a(this));
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.u
        public void j(@NonNull GroupChatRepo.FetchedEvent fetchedEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, fetchedEvent) == null) && fetchedEvent == GroupChatRepo.FetchedEvent.TARGET_MSG_NOT_EXIST) {
                if (this.c.t != null && TbadkCoreApplication.getInst().getVersionName().compareTo(this.c.t.getMsgMinVersion()) < 0) {
                    this.c.t = null;
                    this.c.v1(R.string.obfuscated_res_0x7f0f0975);
                    return;
                }
                this.c.v1(R.string.obfuscated_res_0x7f0f0974);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ag8 {
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

        @Override // com.baidu.tieba.ag8
        public Object a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.v.setBotsDTO(this.a.H0());
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
                this.a.l.l0();
                this.a.L0();
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
    public abstract class b0<Adapter extends BaseNormalAdapter, Msg extends BaseItem<? extends TbBaseMsg>> extends zf8<Adapter, Msg> {
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

        @Override // com.baidu.tieba.zf8
        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c.k.L();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.zf8
        public void l(Msg msg, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msg, i, i2) == null) && this.c.B != null) {
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
                this.a.l.d0(this.a.M);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BdTypeRecyclerView b;
        public ft8 c;
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
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0906c8);
                c0Var.b = bdTypeRecyclerView;
                c0Var.c = new ft8(bdTypeRecyclerView);
                c0Var.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090922);
                c0Var.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090921);
                c0Var.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906c2);
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
                this.a.l.e0(this.a.w);
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
                if (!this.a.y.b.canScrollVertically(1) && !this.a.l.k0()) {
                    ChatPage chatPage = this.a;
                    chatPage.u = chatPage.y.b.getFirstVisiblePosition();
                    this.a.L0();
                }
                if (i2 < 0) {
                    this.a.q1();
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
                this.a.l.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends b0<TextAdapter, TextItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zf8
        /* renamed from: p */
        public boolean k(@NonNull TextItem textItem) {
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
        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage.b0, com.baidu.tieba.zf8
        /* renamed from: q */
        public void l(TextItem textItem, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, textItem, i, i2) == null) {
                super.l(textItem, i, i2);
                if (this.d.z != null && this.d.z.getBasicInfo() != null) {
                    long forumId = this.d.z.getBasicInfo().getForumId();
                    long id = this.d.z.getBasicInfo().getId();
                    if (i == 5) {
                        mo8.d("c15090", 1, forumId, id, TbadkCoreApplication.getCurrentAccount());
                        TbTextMsg tbMsg = textItem.getTbMsg();
                        String text = tbMsg.getText();
                        if (this.d.I0() != null) {
                            this.d.I0().g0(text, tbMsg.getSessionId(), tbMsg.isMaster());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements wf8<NoticeModifySysItem> {
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
        @Override // com.baidu.tieba.wf8
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
    public class j implements wf8<SubscribeSysItem> {
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
        @Override // com.baidu.tieba.wf8
        /* renamed from: b */
        public void a(@NonNull View view2, @NonNull SubscribeSysItem subscribeSysItem, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, subscribeSysItem, i) == null) && this.b.k.N2().v0()) {
                this.a.R(true);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924cd);
                if (SelectorHelper.getResources() != null) {
                    textView.setTextColor(SelectorHelper.getResources().getColor(R.color.CAM_X0101));
                }
                this.b.k.N2().x0();
                view2.setEnabled(false);
                TiebaStatic.log(new StatisticItem("c15258"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends GroupChatRepo.t<TreeSet<ChatMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

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
            this.c = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: k */
        public void d(int i, @NonNull String str, @Nullable TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, treeSet) == null) {
                super.d(i, str, treeSet);
                this.c.y1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.e();
                this.c.y.c.f();
                this.c.x1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.f();
                this.c.y.c.i();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.t
        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c.j1();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.t
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c.D0();
                if (this.c.K0() != null) {
                    this.c.K0().m0();
                }
                this.c.n1();
                if (this.c.I != null) {
                    this.c.I.b(this.c.y.b, this.c.l, this.c.M);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends b0<ShareChatRoomAdapter, ShareChatRoomSysItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zf8
        /* renamed from: p */
        public boolean k(@NonNull ShareChatRoomSysItem shareChatRoomSysItem) {
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
        @Override // com.baidu.tieba.zf8
        /* renamed from: p */
        public boolean k(@NonNull ShareCommonCardSysItem shareCommonCardSysItem) {
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
        @Override // com.baidu.tieba.zf8
        /* renamed from: p */
        public boolean k(@NonNull ShareForumSysItem shareForumSysItem) {
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
        @Override // com.baidu.tieba.zf8
        /* renamed from: p */
        public boolean k(@NonNull ShareThreadSysItem shareThreadSysItem) {
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
        @Override // com.baidu.tieba.zf8
        /* renamed from: p */
        public void i(@NonNull SingleTextImageItem singleTextImageItem, @NonNull zf8.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, singleTextImageItem, eVar) == null) {
                super.i(singleTextImageItem, eVar);
                this.d.i(singleTextImageItem, eVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zf8
        /* renamed from: q */
        public boolean k(@NonNull SingleTextImageItem singleTextImageItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, singleTextImageItem)) == null) {
                return this.d.k(singleTextImageItem);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class r extends b0<TextGenImageAdapter, TextGenImageItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zf8
        /* renamed from: p */
        public boolean k(@NonNull TextGenImageItem textGenImageItem) {
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
    public class s implements j55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ bg8 b;
        public final /* synthetic */ BaseItem c;
        public final /* synthetic */ int d;
        public final /* synthetic */ h55 e;

        public s(ChatPage chatPage, String str, bg8 bg8Var, BaseItem baseItem, int i, h55 h55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, str, bg8Var, baseItem, Integer.valueOf(i), h55Var};
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
            this.b = bg8Var;
            this.c = baseItem;
            this.d = i;
            this.e = h55Var;
        }

        @Override // com.baidu.tieba.j55.f
        public void G0(j55 j55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, j55Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            if (TextUtils.equals(((TextView) view2).getText().toString(), this.a)) {
                this.b.a().n(this.c, this.d);
            }
            this.e.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class t implements ct8 {
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

        @Override // com.baidu.tieba.ct8
        public void a(@NonNull TbTextMsg tbTextMsg) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, tbTextMsg) == null) && this.a.k.M2() != null && tbTextMsg.getRobotParams() != null) {
                int i = -1;
                if (tbTextMsg.getRobotParams().get("type") instanceof String) {
                    i = Integer.parseInt((String) tbTextMsg.getRobotParams().get("type"));
                } else if (tbTextMsg.getRobotParams().get("type") instanceof Long) {
                    i = ((Long) tbTextMsg.getRobotParams().get("type")).intValue();
                }
                if (i != 10005 && i != 10006) {
                    if (i == 10007) {
                        this.a.k.M2().V2(2);
                        return;
                    }
                    return;
                }
                this.a.k.M2().V2(1);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.e1()) {
                return;
            }
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                if ((map.get("sub_skill_config_type") instanceof Integer) && (map.get("text_gen_image_msg") instanceof TbTextGenImageMsg)) {
                    int intValue = ((Integer) map.get("sub_skill_config_type")).intValue();
                    TbTextGenImageMsg tbTextGenImageMsg = (TbTextGenImageMsg) map.get("text_gen_image_msg");
                    if (this.a.k.M2() != null && this.a.k.M2().r2() != null) {
                        InputDelegate r2 = this.a.k.M2().r2();
                        r2.Z(intValue, tbTextGenImageMsg, this.a.C0(tbTextGenImageMsg));
                        r2.U(BotSourceType.TWO, true, true);
                        this.a.k.f3(ViewState.GONE);
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
    public class v implements wf8<BaseItem<? extends TbBaseMsg>> {
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

        @Override // com.baidu.tieba.wf8
        public void a(@NonNull View view2, @NonNull BaseItem<? extends TbBaseMsg> baseItem, int i) {
            TbReMsgInfo reMsgInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, view2, baseItem, i) == null) {
                if (view2.getId() == R.id.btn_msgitem_resend) {
                    bg8 b = bg8.b(view2);
                    if (b == null) {
                        return;
                    }
                    this.a.u1(b, baseItem, i);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eab && (reMsgInfo = baseItem.getTbMsg().getReMsgInfo()) != null) {
                    this.a.l.m0(reMsgInfo.getMsgId(), reMsgInfo.getMsgKey(), this.a.M);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements xf8<BaseItem<? extends TbBaseMsg>> {
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

        @Override // com.baidu.tieba.xf8
        public boolean a(@NonNull View view2, @NonNull BaseItem<? extends TbBaseMsg> baseItem, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, view2, baseItem, i)) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f0907a0 || id == R.id.obfuscated_res_0x7f090eb3 || id == R.id.obfuscated_res_0x7f090e92 || id == R.id.obfuscated_res_0x7f090eb7 || id == R.id.obfuscated_res_0x7f090eaf || id == R.id.obfuscated_res_0x7f090eb0 || id == R.id.obfuscated_res_0x7f090eae || id == R.id.obfuscated_res_0x7f090ead || id == R.id.obfuscated_res_0x7f090eab) {
                    this.a.t1(baseItem);
                    this.a.F0();
                    return false;
                }
                return false;
            }
            return invokeLLI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class x implements ur8 {
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

        @Override // com.baidu.tieba.ur8
        public void a(int i, @Nullable BaseItem<? extends TbBaseMsg> baseItem, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, baseItem, obj) == null) {
                if (i != 21) {
                    if (i == 24 && (obj instanceof AbilityItem)) {
                        AbilityItem abilityItem = (AbilityItem) obj;
                        this.a.C.c(abilityItem, baseItem);
                        this.a.E0(abilityItem);
                    }
                } else if (this.a.k.M2() != null && this.a.k.M2().r2() != null && baseItem != null && (obj instanceof UserReplyInfoData)) {
                    this.a.k.M2().r2().J((UserReplyInfoData) obj, baseItem);
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.k.M2().t2().getHeight() <= 0 && this.a < this.b.u) {
                this.b.N0();
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
        this.C = new tf8();
        this.D = new sf8();
        this.G = vf8.c.b();
        this.H = new u(this, 2921782);
        this.J = new v(this);
        this.K = new w(this);
        this.L = new x(this);
        this.M = new y(this);
        this.N = new g(this, 2921799);
        this.j = groupChatFragment.getPageContext();
        this.k = groupChatFragment;
        this.l = groupChatRepo;
        groupChatRepo.r0(this.w);
        this.E = new SendMsgHandler(groupChatRepo, this);
        this.F = new SendStructMsgHandler(groupChatRepo, this, this.x);
    }

    public void B0(@Nullable VoiceManager voiceManager) {
        VoiceAdapter voiceAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, voiceManager) == null) && (voiceAdapter = this.O) != null && voiceManager != null) {
            voiceAdapter.n0(voiceManager);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void Y(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z2) == null) {
            super.Y(z2);
            if (!z2) {
                x1();
            }
        }
    }

    public final boolean g1(@NonNull MsgProcessor.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, dVar)) == null) {
            if (dVar.g() && f1() && !N()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void l1(ss8 ss8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, ss8Var) == null) {
            this.I = ss8Var;
        }
    }

    public void o1(xs8 xs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, xs8Var) == null) {
            this.B = xs8Var;
        }
    }

    @Override // com.baidu.tieba.ed8
    public void p(@NonNull AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, abilityItem) == null) {
            this.C.c(abilityItem, null);
        }
    }

    public void t1(@NonNull BaseItem<? extends TbBaseMsg> baseItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048632, this, baseItem) != null) || this.z == null) {
            return;
        }
        this.k.P2().e(baseItem, this.z);
        this.k.P2().i();
    }

    public void v1(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            w1(this.k.getStringSafely(i2), false);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void Z(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, view2, bundle) == null) {
            super.Z(view2, bundle);
            rx5.b(view2);
            this.y = c0.a(view2, this.b);
            this.k.P2().a(this.L);
            c1();
        }
    }

    @Override // com.baidu.tieba.ed8
    public void c(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048607, this, str, i2) == null) {
            this.l.v(TbVoiceMsg.create(str, i2));
        }
    }

    public void h1(long j2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048613, this, j2, str) == null) {
            this.l.m0(j2, str, this.M);
        }
    }

    @Override // com.baidu.tieba.ed8
    public void k(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048616, this, str, i2) == null) {
            this.C.c(CallRobotHandler.f(str, i2), null);
        }
    }

    @Override // com.baidu.tieba.ed8
    public void l(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, str, str2) == null) {
            this.l.v(TbImageMsg.create(str, str2));
        }
    }

    public void s1(@NonNull List<EmojiData> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048631, this, list, i2) == null) {
            this.k.L2().k0(list, i2);
        }
    }

    @NonNull
    public final od8 C0(@NonNull TbTextGenImageMsg tbTextGenImageMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbTextGenImageMsg)) == null) {
            od8 od8Var = new od8();
            BotsDTO.BotListDTO.UserDTO userDTO = new BotsDTO.BotListDTO.UserDTO();
            od8Var.a = userDTO;
            userDTO.setName(tbTextGenImageMsg.getUserName());
            od8Var.a.setNameShow(tbTextGenImageMsg.getUserName());
            od8Var.a.setPortrait(tbTextGenImageMsg.getPortrait());
            od8Var.a.setUk(BIMManager.getBdUKFromBdUid(String.valueOf(tbTextGenImageMsg.getUserId())));
            od8Var.b = new BotsDTO.BotListDTO.SkillDTO();
            if (tbTextGenImageMsg.getSubSkillConfig() != null) {
                od8Var.b.setSubSkill(tbTextGenImageMsg.getSubSkillConfig().a);
            }
            od8Var.d(true);
            return od8Var;
        }
        return (od8) invokeL.objValue;
    }

    public final void k1(BotsDTO.BotListDTO botListDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, botListDTO) == null) && botListDTO != null && botListDTO.getUser() != null) {
            BotsDTO.BotListDTO.UserDTO user = botListDTO.getUser();
            TbTextMsg createRobotGuide = TbTextMsg.createRobotGuide(fl8.a(user.getUk()), user.getNameShow(), user.getPortrait(), user.getRobotRole(), user.getForumLevel());
            createRobotGuide.setText("@" + TbadkCoreApplication.getCurrentAccountNameShow() + " " + botListDTO.getAtGuide());
            TbAtUserInfo.AtType atType = TbAtUserInfo.AtType.USER;
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            createRobotGuide.addAtUserInfo(TbAtUserInfo.create(atType, currentAccountId, "@" + TbadkCoreApplication.getCurrentAccountNameShow(), TbadkCoreApplication.getCurrentPortrait(), 0));
            this.l.w(createRobotGuide, MsgProcessor.d.b(true, 5));
        }
    }

    public final void D0() {
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
                    k1(botListDTO);
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

    public final void E0(AbilityItem abilityItem) {
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
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 3).param("obj_source", 5).param("fid", this.k.G2()).param("fname", this.k.H2()).param("room_id", this.k.I2());
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = "";
            }
            TiebaStatic.log(param.param("obj_name", str).param("obj_id", obj2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.k.M2() != null && this.k.M2().r2() != null && this.k.M2().r2().e()) {
            this.k.M2().r2().C();
        }
    }

    @NonNull
    public final NoticeModifyAdapter P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            this.l.r(NoticeModifySysItem.parsePair());
            NoticeModifyAdapter noticeModifyAdapter = new NoticeModifyAdapter(this.j, NoticeModifySysItem.ADAPTER_TYPE);
            this.o = noticeModifyAdapter;
            noticeModifyAdapter.G(null, new i(this));
            return this.o;
        }
        return (NoticeModifyAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareChatRoomAdapter R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.l.r(ShareChatRoomSysItem.parsePair());
            ShareChatRoomAdapter shareChatRoomAdapter = new ShareChatRoomAdapter(this.j, ShareChatRoomSysItem.ADAPTER_TYPE);
            shareChatRoomAdapter.F(this.C, this.D);
            shareChatRoomAdapter.H(this.K, null);
            shareChatRoomAdapter.K(new m(this));
            return shareChatRoomAdapter;
        }
        return (ShareChatRoomAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareCommonCardAdapter S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            this.l.r(ShareCommonCardSysItem.parsePair());
            ShareCommonCardAdapter shareCommonCardAdapter = new ShareCommonCardAdapter(this.j, ShareCommonCardSysItem.ADAPTER_TYPE);
            shareCommonCardAdapter.h0(this.k.I2());
            shareCommonCardAdapter.F(this.C, this.D);
            shareCommonCardAdapter.H(this.K, null);
            shareCommonCardAdapter.K(new n(this));
            return shareCommonCardAdapter;
        }
        return (ShareCommonCardAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareForumAdapter T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            this.l.r(ShareForumSysItem.parsePair());
            ShareForumAdapter shareForumAdapter = new ShareForumAdapter(this.j, ShareForumSysItem.ADAPTER_TYPE);
            shareForumAdapter.F(this.C, this.D);
            shareForumAdapter.j0(this.k.I2());
            shareForumAdapter.H(this.K, null);
            shareForumAdapter.K(new o(this));
            return shareForumAdapter;
        }
        return (ShareForumAdapter) invokeV.objValue;
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.l.r(EffectGuidanceSysItem.parsePair());
            this.l.r(ExcellentSysItem.parsePair());
            this.l.r(EmojiReplySysItem.parsePair());
            this.l.r(ActivitySysItem.parsePair());
        }
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            int lastVisiblePosition = this.y.b.getLastVisiblePosition();
            if (this.k.M2() != null && this.k.M2().t2() != null) {
                this.k.M2().t2().post(new z(this, lastVisiblePosition));
            }
        }
    }

    @NonNull
    public sf8 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.D;
        }
        return (sf8) invokeV.objValue;
    }

    @Nullable
    public BotsDTO H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.A;
        }
        return (BotsDTO) invokeV.objValue;
    }

    @Nullable
    public EffectSlice I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.k.K2();
        }
        return (EffectSlice) invokeV.objValue;
    }

    @NonNull
    public GroupChatFragment J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.k;
        }
        return (GroupChatFragment) invokeV.objValue;
    }

    @Nullable
    public UpBubbleSlice K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k.U2();
        }
        return (UpBubbleSlice) invokeV.objValue;
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.y.e.getVisibility() == 0) {
            this.y.e.setVisibility(8);
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.y.e.getVisibility() != 0) {
            this.y.e.setVisibility(0);
            this.y.e.setOnClickListener(new a0(this));
        }
    }

    @NonNull
    public final RecallAdapter Q0() {
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
    public final SubscribeAdapter W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            this.l.r(SubscribeSysItem.parsePair());
            SubscribeAdapter subscribeAdapter = new SubscribeAdapter(this.j, SubscribeSysItem.ADAPTER_TYPE);
            subscribeAdapter.G(null, new j(this, subscribeAdapter));
            return subscribeAdapter;
        }
        return (SubscribeAdapter) invokeV.objValue;
    }

    @NonNull
    public final TimestampAdapter a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            this.l.r(TimestampSysItem.parsePair());
            return new TimestampAdapter(this.j, TimestampSysItem.ADAPTER_TYPE);
        }
        return (TimestampAdapter) invokeV.objValue;
    }

    @NonNull
    public final TipsAdapter b1() {
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

    public final boolean f1() {
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
    public tf8 i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.C;
        }
        return (tf8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onDestroy();
            this.G.c();
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onStart();
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && this.y.b.canScrollVertically(1)) {
            N0();
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && !BdNetTypeUtil.isNetWorkAvailable() && this.k.getContext() != null) {
            BdUtilHelper.showLongToast(this.k.getContext(), (int) R.string.obfuscated_res_0x7f0f0e42);
        }
    }

    @NonNull
    public final ImageAdapter M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.l.r(BigEmotionItem.parsePair());
            this.E.f(4, TbBigEmotionMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.j, BigEmotionItem.ADAPTER_TYPE);
            imageAdapter.G(this.J, null);
            imageAdapter.H(this.K, null);
            imageAdapter.F(this.C, this.D);
            imageAdapter.K(new d0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final ImageAdapter O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.l.r(ImageItem.parsePair());
            this.E.f(2, TbImageMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.j, ImageItem.ADAPTER_TYPE);
            imageAdapter.G(this.J, null);
            imageAdapter.H(this.K, null);
            imageAdapter.F(this.C, this.D);
            imageAdapter.K(new d0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareThreadAdapter U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.l.r(ShareThreadSysItem.parsePair());
            ShareThreadAdapter shareThreadAdapter = new ShareThreadAdapter(this.j, ShareThreadSysItem.ADAPTER_TYPE);
            this.r = shareThreadAdapter;
            shareThreadAdapter.l0(this.k.I2());
            this.r.F(this.C, this.D);
            this.r.H(this.K, null);
            this.r.K(new p(this));
            return this.r;
        }
        return (ShareThreadAdapter) invokeV.objValue;
    }

    @NonNull
    public final SingleTextImageAdapter V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            this.l.r(SingleTextImageItem.parsePair());
            SingleTextImageAdapter singleTextImageAdapter = new SingleTextImageAdapter(this.j, SingleTextImageItem.ADAPTER_TYPE);
            this.p = singleTextImageAdapter;
            singleTextImageAdapter.G(this.J, null);
            this.p.H(this.K, null);
            this.p.F(this.C, this.D);
            this.p.K(new q(this));
            return this.p;
        }
        return (SingleTextImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final TextAdapter Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            this.l.r(TextItem.parsePair());
            this.E.f(1, TbTextMsg.class);
            TextAdapter textAdapter = new TextAdapter(this.j, TextItem.ADAPTER_TYPE);
            textAdapter.K(new h(this));
            textAdapter.G(this.J, null);
            textAdapter.H(this.K, null);
            textAdapter.F(this.C, this.D);
            return textAdapter;
        }
        return (TextAdapter) invokeV.objValue;
    }

    @NonNull
    public final TextGenImageAdapter Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            this.l.r(TextGenImageItem.parsePair());
            this.l.r(TextGenImageUpdateSysItem.parsePair());
            TextGenImageAdapter textGenImageAdapter = new TextGenImageAdapter(this.j, TextGenImageItem.ADAPTER_TYPE);
            this.q = textGenImageAdapter;
            textGenImageAdapter.G(this.J, null);
            this.q.H(this.K, null);
            this.q.F(this.C, this.D);
            this.q.K(new r(this));
            return this.q;
        }
        return (TextGenImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final VoiceAdapter d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            this.l.r(VoiceItem.parsePair());
            this.E.f(3, TbVoiceMsg.class);
            VoiceAdapter voiceAdapter = new VoiceAdapter(this.j, VoiceItem.ADAPTER_TYPE);
            this.O = voiceAdapter;
            voiceAdapter.G(this.J, null);
            this.O.H(this.K, null);
            this.O.F(this.C, this.D);
            this.O.n0(this.k.P0());
            this.O.K(new l(this));
            return this.O;
        }
        return (VoiceAdapter) invokeV.objValue;
    }

    public boolean e1() {
        InterceptResult invokeV;
        cl8 n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.k.M2() == null || this.k.M2().r2() == null || (n2 = this.k.M2().r2().n()) == null) {
                return false;
            }
            new BdTopToast(this.k.getContext()).setContent(n2.c()).setIcon(false).show((ViewGroup) this.k.getView());
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            ChatRoomDetail chatRoomDetail = this.z;
            if (chatRoomDetail != null && !ListUtils.isEmpty(chatRoomDetail.getQuickTalk()) && ((J0() == null || !J0().Y2()) && !this.k.B2())) {
                this.k.f3(ViewState.VISIBLE);
                this.k.J2().d0(this.z);
                return;
            }
            this.k.f3(ViewState.GONE);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    @Nullable
    public View T(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08d9, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ed8
    public void b(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, str, str2, map) == null) {
            this.l.v(TbBigEmotionMsg.create(str, str2, map));
        }
    }

    public void r1(int i2, @NonNull BaseItem<? extends TbBaseMsg> baseItem, @Nullable List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048630, this, i2, baseItem, list) == null) {
            this.k.O2().p0(i2, baseItem, list);
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.C.a(this.E);
            this.C.a(this.F);
            this.C.a(new CallRobotHandler(this));
            this.C.a(new JumpToHandler(this.j));
            this.C.a(new InputBoxHandler(this));
            this.C.a(new zs8());
            this.C.a(new dt8(this));
            this.C.a(new JumpMsgHandler(this));
            this.C.a(new RequestRouterHandler(this));
            this.C.a(new at8(this));
            this.C.a(new SendEmojiMsgHandler(this.k.getContext(), this.l, this));
            this.C.a(new OpenEmojiDetailHandler(this));
            this.C.a(new OpenReactionPanelHandler(this));
            X0();
            this.G.a(Y0());
            this.G.a(P0());
            this.G.a(a1());
            this.G.a(b1());
            this.G.a(Q0());
            this.G.a(d1());
            this.G.a(O0());
            this.G.a(T0());
            this.G.a(U0());
            this.G.a(M0());
            this.G.a(V0());
            this.G.a(Z0());
            this.G.a(W0());
            this.G.a(R0());
            this.G.a(S0());
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

    public final void j1() {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
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

    public void m1(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, chatRoomDetail) == null) {
            this.z = chatRoomDetail;
            this.A = chatRoomDetail.getBots();
            long id = chatRoomDetail.getBasicInfo().getId();
            this.C.f(id);
            this.D.g(id);
            this.D.f(chatRoomDetail.getBasicInfo().getForumName());
            this.D.e(chatRoomDetail.getBasicInfo().getForumId());
            this.D.h(chatRoomDetail.getBasicInfo().getName());
            this.m.R(chatRoomDetail.getBasicInfo().getForumId());
            this.m.S(chatRoomDetail.getBasicInfo().getId());
            this.o.R(chatRoomDetail.getBasicInfo().getForumId());
            this.o.S(chatRoomDetail.getBasicInfo().getId());
            this.n.R(chatRoomDetail.getBasicInfo().getForumId());
            this.n.S(chatRoomDetail.getBasicInfo().getId());
            this.p.a(chatRoomDetail.getBasicInfo().getForumName());
            this.q.a(chatRoomDetail.getBasicInfo().getForumName());
            this.r.j0(chatRoomDetail.getBasicInfo().getForumId());
            this.r.k0(chatRoomDetail.getBasicInfo().getForumName());
        }
    }

    @Override // com.baidu.tieba.ed8
    public void n(@NonNull String str, @Nullable Object obj, @Nullable od8 od8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map, int i2) {
        TbBaseMsg tbBaseMsg;
        TbBaseMsg q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{str, obj, od8Var, list, map, Integer.valueOf(i2)}) == null) {
            if (obj instanceof BaseItem) {
                tbBaseMsg = ((BaseItem) obj).getTbMsg();
            } else {
                tbBaseMsg = null;
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2 && i2 != 3) {
                        q2 = TbTextMsg.create(str);
                        q2.addAtUserInfo(et8.o(list, map));
                    }
                } else {
                    q2 = TbTextMsg.create(str);
                    if (tbBaseMsg != null) {
                        q2.setReMsgInfo(TbReMsgInfo.create(tbBaseMsg, ((Object) qo8.b(tbBaseMsg)) + tbBaseMsg.getThumbnailText().toString()));
                    }
                    q2.addAtUserInfo(et8.o(list, map));
                }
                if (od8Var != null && od8Var.b != null && this.k.M2() != null) {
                    if (od8Var.b.getType() == 10005 && od8Var.b.getType() != 10006) {
                        if (od8Var.b.getType() == 10007) {
                            this.k.M2().V2(2);
                        }
                    } else {
                        this.k.M2().V2(1);
                    }
                }
                this.l.v(q2);
            }
            q2 = et8.q(et8.m(str, tbBaseMsg, od8Var, list, map), od8Var);
            if (od8Var != null) {
                if (od8Var.b.getType() == 10005) {
                }
                this.k.M2().V2(1);
            }
            this.l.v(q2);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
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

    public void p1(@NonNull String str, int i2, BotSourceType botSourceType, @Nullable TbBaseMsg tbBaseMsg, boolean z2, boolean z3, boolean z4, @Nullable String str2) {
        BotsDTO.BotListDTO findBotByUk;
        BotsDTO.BotListDTO.SkillDTO cloneSkillById;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048628, this, new Object[]{str, Integer.valueOf(i2), botSourceType, tbBaseMsg, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str2}) != null) || e1()) {
            return;
        }
        BotsDTO botsDTO = this.A;
        boolean z5 = true;
        if (botsDTO != null && (findBotByUk = botsDTO.findBotByUk(str)) != null && (cloneSkillById = findBotByUk.cloneSkillById(i2)) != null) {
            if (str2 != null && !str2.isEmpty()) {
                cloneSkillById.setKeyboardContent(str2);
            }
            if (this.k.M2() != null && this.k.M2().r2() != null) {
                InputDelegate r2 = this.k.M2().r2();
                AtSelectData atSelectData = null;
                if (z3 && tbBaseMsg != null) {
                    atSelectData = new AtSelectData(tbBaseMsg.getPortrait(), tbBaseMsg.getUserName(), String.valueOf(tbBaseMsg.getUserId()), tbBaseMsg.isRobot());
                    r2.m().E(atSelectData.getUid(), atSelectData);
                }
                r2.N(tbBaseMsg, findBotByUk.getUser(), cloneSkillById, z2);
                if (cloneSkillById.isFuncShowPanel() && (r2.v() == null || !r2.v().M())) {
                    r2.U(botSourceType, true, z4);
                }
                String w2 = r2.w();
                r2.R("");
                if (atSelectData != null && cloneSkillById.isCanKeyboardInput()) {
                    r2.a(atSelectData, true, cloneSkillById.isFuncShowPanel());
                }
                if (!TextUtils.isEmpty(w2)) {
                    r2.Q(w2);
                }
                if (cloneSkillById.isFuncSendMsg()) {
                    r2.k();
                    r2.l();
                    r2.j();
                }
                z5 = false;
            }
        }
        if (z5) {
            v1(R.string.obfuscated_res_0x7f0f092f);
        }
    }

    public final void u1(@NonNull bg8 bg8Var, @NonNull BaseItem<? extends TbBaseMsg> baseItem, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048633, this, bg8Var, baseItem, i2) == null) {
            h55 h55Var = new h55(this.j);
            String string = this.j.getString(R.string.msg_resend);
            h55Var.i(null, new String[]{string}, new s(this, string, bg8Var, baseItem, i2, h55Var));
            h55Var.l();
        }
    }

    public void w1(@NonNull String str, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048635, this, str, z2) == null) && this.k.getContext() != null) {
            new BdTopToast(this.k.getContext()).setContent(str).setIcon(z2).show((ViewGroup) this.k.getView());
        }
    }
}
