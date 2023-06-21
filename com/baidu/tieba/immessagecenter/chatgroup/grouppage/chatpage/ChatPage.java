package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.tieba.af8;
import com.baidu.tieba.bf8;
import com.baidu.tieba.bh;
import com.baidu.tieba.ce8;
import com.baidu.tieba.di8;
import com.baidu.tieba.ef8;
import com.baidu.tieba.eh8;
import com.baidu.tieba.gf8;
import com.baidu.tieba.gg8;
import com.baidu.tieba.gx5;
import com.baidu.tieba.hf8;
import com.baidu.tieba.ig8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.positionbubble.UpBubbleSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.CallRobotHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.InputBoxHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.JumpMsgHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.JumpToHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.RequestRouterHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.SendMsgHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.SendStructMsgHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ImageAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.NoticeModifyAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.RecallAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ShareChatRoomAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ShareCommonCardAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ShareForumAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ShareThreadAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.SingleTextImageAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.SubscribeAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.TextAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.TimestampAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.TipsAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.VoiceAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AtUserInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BigEmotionMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.EffectGuidanceSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ExcellentSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.NoticeModifySysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.RecallSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareChatRoomSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareCommonCardSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareForumSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareThreadSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.SingleTextImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.SubscribeSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageUpdateSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TimestampSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TipsSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.VoiceMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect.EffectSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.io;
import com.baidu.tieba.jf8;
import com.baidu.tieba.jg8;
import com.baidu.tieba.kf8;
import com.baidu.tieba.m55;
import com.baidu.tieba.o55;
import com.baidu.tieba.o95;
import com.baidu.tieba.p75;
import com.baidu.tieba.qe8;
import com.baidu.tieba.rx4;
import com.baidu.tieba.sd8;
import com.baidu.tieba.se8;
import com.baidu.tieba.ug;
import com.baidu.tieba.ve8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.we8;
import com.baidu.tieba.wf8;
import com.baidu.tieba.wi;
import com.baidu.tieba.xg;
import com.baidu.tieba.ye8;
import com.baidu.tieba.ze8;
import com.baidu.tieba.zf8;
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
public class ChatPage extends Slice implements jg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final bf8 A;
    @NonNull
    public final af8 B;
    @NonNull
    public final SendMsgHandler C;
    public final SendStructMsgHandler D;
    @NonNull
    public final ef8.c E;
    public final CustomMessageListener F;
    public qe8 G;
    public final gf8<BaseMsg> H;
    public final hf8<BaseMsg> I;
    public final sd8 J;
    public final GroupChatRepo.s<TreeSet<ChatMsg>> K;
    public Runnable L;
    public Runnable M;
    public final CustomMessageListener N;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> j;
    @NonNull
    public final GroupChatFragment k;
    @NonNull
    public final GroupChatRepo l;
    public TipsAdapter m;
    public RecallAdapter n;
    public NoticeModifyAdapter o;
    public SingleTextImageAdapter<SingleTextImageMsg> p;
    public ze8 q;
    public String r;
    public TopBubbleData s;
    public int t;
    public final GroupChatRepo.r<TreeSet<ChatMsg>> u;
    public boolean v;
    public f0 w;
    @Nullable
    public ChatRoomDetail x;
    @Nullable
    public BotsDTO y;
    public se8 z;

    /* loaded from: classes6.dex */
    public class i implements ChatMsgProcessor.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final io a;
        public final /* synthetic */ ChatPage b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ Runnable c;
            public final /* synthetic */ i d;

            /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage$i$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0337a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0337a(a aVar) {
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
                        this.a.d.b.a1();
                    }
                }
            }

            public a(i iVar, List list, boolean z, Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, list, Boolean.valueOf(z), runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = iVar;
                this.a = list;
                this.b = z;
                this.c = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.d.b.w.b.updateData(this.a, true, BaseMsg.DIFF_ITEM_CALLBACK);
                    this.d.b.k.y2();
                    if (this.b) {
                        Runnable runnable = this.c;
                        if (runnable == null) {
                            runnable = new RunnableC0337a(this);
                        }
                        bh.c(runnable);
                    }
                }
            }
        }

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
            this.b = chatPage;
            this.a = new io(this.b.w.b);
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor.h
        @MainThread
        public void a(long j, @NonNull List<BaseMsg> list, @NonNull ChatMsgProcessor.j jVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), list, jVar}) != null) || this.b.k.b2()) {
                return;
            }
            boolean z = true;
            if (!jVar.a && (!jVar.c || this.b.w.b.getLastVisiblePosition() != this.b.w.b.getCount() - 1 || this.b.G())) {
                z = false;
            }
            this.a.e(new a(this, list, z, jVar.c()));
        }
    }

    /* loaded from: classes6.dex */
    public class a0 extends GroupChatRepo.s<TreeSet<ChatMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a0 a;

            public a(a0 a0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = a0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.j1();
                }
            }
        }

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
            this.b = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void b(int i, @NonNull String str, @Nullable TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, treeSet) == null) {
                super.b(i, str, treeSet);
                this.b.p1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.b.w.c.g();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.b.w.c.j();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.s
        public void f(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                if (this.b.k.u2().getVisibility() == 0) {
                    i2 = this.b.k.u2().getHeight();
                } else {
                    i2 = 0;
                }
                if (this.b.w.b.getLayoutManager() instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) this.b.w.b.getLayoutManager()).scrollToPositionWithOffset(i, i2);
                } else {
                    this.b.w.b.scrollToPosition(i);
                }
                if (this.b.w.b.getAdapter() != null) {
                    this.b.w.b.getAdapter().notifyItemChanged(i);
                }
                bh.c(new a(this));
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.s
        public void g(@NonNull GroupChatRepo.FetchedEvent fetchedEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, fetchedEvent) == null) && fetchedEvent == GroupChatRepo.FetchedEvent.TARGET_MSG_NOT_EXIST) {
                if (this.b.s != null && TbadkCoreApplication.getInst().getVersionName().compareTo(this.b.s.getMsgMinVersion()) < 0) {
                    this.b.s = null;
                    this.b.m1(R.string.obfuscated_res_0x7f0f0957);
                    return;
                }
                this.b.m1(R.string.obfuscated_res_0x7f0f0956);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0<Adapter extends BaseChatAdapter> extends e0<Adapter, BaseImageMsg<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* loaded from: classes6.dex */
        public class a implements ig8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jf8.e a;
            public final /* synthetic */ BaseImageMsg b;
            public final /* synthetic */ g0 c;

            public a(g0 g0Var, jf8.e eVar, BaseImageMsg baseImageMsg) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {g0Var, eVar, baseImageMsg};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = g0Var;
                this.a = eVar;
                this.b = baseImageMsg;
            }

            @Override // com.baidu.tieba.ig8
            public void a(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                    this.a.b();
                }
            }

            @Override // com.baidu.tieba.ig8
            public void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.c(i);
                }
            }

            @Override // com.baidu.tieba.ig8
            public void c(int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                    this.b.setThumbUrl(str2);
                    this.b.setBigSrc(str);
                    this.b.setSdkMsg(str2, str);
                    this.a.a();
                    if (this.c.d.x != null && this.c.d.x.getBasicInfo() != null) {
                        di8.b("c15090", 2, this.c.d.x.getBasicInfo().getForumId(), this.c.d.x.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(ChatPage chatPage) {
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

        public /* synthetic */ g0(ChatPage chatPage, k kVar) {
            this(chatPage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: p */
        public boolean j(@NonNull BaseImageMsg<?> baseImageMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, baseImageMsg)) == null) {
                return baseImageMsg.isInvalidAddress();
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: o */
        public void i(@NonNull BaseImageMsg<?> baseImageMsg, @NonNull jf8.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseImageMsg, eVar) == null) && this.d.k.n2() != null && !StringUtils.isNull(baseImageMsg.getThumbUrl())) {
                this.d.k.n2().h2(baseImageMsg.getThumbUrl(), new a(this, eVar, baseImageMsg));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends e0<VoiceAdapter, VoiceMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* loaded from: classes6.dex */
        public class a implements gg8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jf8.e a;
            public final /* synthetic */ VoiceMsg b;
            public final /* synthetic */ o c;

            public a(o oVar, jf8.e eVar, VoiceMsg voiceMsg) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, eVar, voiceMsg};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = oVar;
                this.a = eVar;
                this.b = voiceMsg;
            }

            @Override // com.baidu.tieba.gg8
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.b.setVoiceUrl(str);
                    this.a.a();
                    if (this.c.d.x != null && this.c.d.x.getBasicInfo() != null) {
                        di8.b("c15090", 3, this.c.d.x.getBasicInfo().getForumId(), this.c.d.x.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }

            @Override // com.baidu.tieba.gg8
            public void isFailed() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.b();
                }
            }
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
            this.d = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: p */
        public boolean j(@NonNull VoiceMsg voiceMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceMsg)) == null) {
                return voiceMsg.isInvalidAddress();
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: o */
        public void i(@NonNull VoiceMsg voiceMsg, @NonNull jf8.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceMsg, eVar) == null) && this.d.k.n2() != null && !StringUtils.isNull(voiceMsg.getPath())) {
                this.d.k.n2().i2(voiceMsg.getPath(), new a(this, eVar, voiceMsg));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ChatPage b;

        public a(ChatPage chatPage, int i) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.k.f2().I().getHeight() <= 0 && this.a < this.b.t) {
                this.b.H0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public b(ChatPage chatPage) {
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
                this.a.l.S();
                this.a.F0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements GroupInputTool.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

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
            this.a = chatPage;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool.f
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if ((z || z2) && this.a.v) {
                    if (this.a.w != null && this.a.w.f != null && this.a.w.b != null && (this.a.w.f.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.w.f.getLayoutParams();
                        layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                        this.a.w.f.setLayoutParams(layoutParams);
                        this.a.w.f.requestLayout();
                        this.a.w.b.requestLayout();
                        bh.c(this.a.L);
                    }
                    this.a.v = false;
                    this.a.k.C2(false);
                } else if (z || z2) {
                } else {
                    this.a.v = true;
                    if (this.a.w != null && this.a.w.f != null && this.a.w.b != null && (this.a.w.f.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.a.w.f.getLayoutParams();
                        layoutParams2.height = 0;
                        this.a.w.f.setLayoutParams(layoutParams2);
                        this.a.w.f.requestLayout();
                        this.a.w.b.requestLayout();
                        if (this.a.w.b.canScrollVertically(1)) {
                            bh.c(this.a.M);
                        }
                    }
                    this.a.k.B2(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.a.A0();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public c0(ChatPage chatPage) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.w != null && this.a.w.b != null) {
                this.a.w.b.scrollBy(0, TbadkCoreApplication.getInst().getKeyboardHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ChatPage chatPage, Context context) {
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
    public class d0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public d0(ChatPage chatPage) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.w != null && this.a.w.b != null) {
                this.a.w.b.scrollBy(0, -TbadkCoreApplication.getInst().getKeyboardHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements BdListView.s {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.s
        public void onScrollToTop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.I(this.a.K);
            }
        }
    }

    /* loaded from: classes6.dex */
    public abstract class e0<Adapter extends BaseChatAdapter, Msg extends BaseMsg> extends jf8<Adapter, Msg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

        public e0(ChatPage chatPage) {
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

        public /* synthetic */ e0(ChatPage chatPage, k kVar) {
            this(chatPage);
        }

        @Override // com.baidu.tieba.jf8
        public void k(BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, baseMsg, i, i2) == null) && this.c.z != null) {
                this.c.z.a(baseMsg, i, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

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
            this.a = chatPage;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.J(this.a.u);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BdTypeRecyclerView b;
        public zf8 c;
        public ImageView d;
        public LinearLayout e;
        public RelativeLayout f;
        public LinearLayout g;

        public f0() {
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

        public static f0 a(@NonNull View view2, @NonNull Fragment fragment) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, view2, fragment)) == null) {
                f0 f0Var = new f0();
                f0Var.a = view2;
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0906c5);
                f0Var.b = bdTypeRecyclerView;
                f0Var.c = new zf8(bdTypeRecyclerView);
                f0Var.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090916);
                f0Var.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090915);
                f0Var.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906bf);
                f0Var.f = (RelativeLayout) fragment.requireView().findViewById(R.id.obfuscated_res_0x7f091506);
                return f0Var;
            }
            return (f0) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public g(ChatPage chatPage) {
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
                if (!this.a.w.b.canScrollVertically(1) && !this.a.l.R()) {
                    ChatPage chatPage = this.a;
                    chatPage.t = chatPage.w.b.getFirstVisiblePosition();
                    this.a.F0();
                }
                if (i2 < 0) {
                    this.a.j1();
                }
                if (this.a.G != null) {
                    this.a.G.a(this.a.w.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public h(ChatPage chatPage) {
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

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                int lastVisiblePosition = this.a.w.b.getLastVisiblePosition();
                int firstVisiblePosition = this.a.w.b.getFirstVisiblePosition();
                if (lastVisiblePosition != -1 && this.a.w.b.getCount() > 0 && this.a.w.b.getCount() - 1 == lastVisiblePosition) {
                    this.a.t = firstVisiblePosition;
                }
                if (this.a.G != null) {
                    this.a.G.b(this.a.w.b, this.a.l, this.a.K);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ChatPage chatPage, int i) {
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
                this.a.l.h0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends GroupChatRepo.r<TreeSet<ChatMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage b;

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
            this.b = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void b(int i, @NonNull String str, @Nullable TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, treeSet) == null) {
                super.b(i, str, treeSet);
                this.b.p1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.b.w.c.f();
                this.b.o1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.b.w.c.i();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.r
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.a1();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.r
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.y0();
                if (this.b.E0() != null) {
                    this.b.E0().h0();
                }
                this.b.f1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends e0<TextAdapter, TextMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: o */
        public boolean j(@NonNull TextMsg textMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, textMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage.e0, com.baidu.tieba.jf8
        public void k(BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseMsg, i, i2) == null) {
                super.k(baseMsg, i, i2);
                if (this.d.x != null && this.d.x.getBasicInfo() != null) {
                    long forumId = this.d.x.getBasicInfo().getForumId();
                    long id = this.d.x.getBasicInfo().getId();
                    if (i == 5) {
                        di8.b("c15090", 1, forumId, id, TbadkCoreApplication.getCurrentAccount());
                        String text = ((TextMsg) baseMsg).getText();
                        if (this.d.C0() != null) {
                            this.d.C0().a0(text, baseMsg.getCommonMsgField().getRoomId(), !baseMsg.isLeft());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements gf8<NoticeModifySysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public m(ChatPage chatPage) {
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
        @Override // com.baidu.tieba.gf8
        /* renamed from: b */
        public void a(@NonNull View view2, @NonNull NoticeModifySysMsg noticeModifySysMsg, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, noticeModifySysMsg, i) == null) && noticeModifySysMsg != null && noticeModifySysMsg.getChatroomInfo() != null && noticeModifySysMsg.getChatroomInfo().getNoticeUrl() != null) {
                String noticeUrl = noticeModifySysMsg.getChatroomInfo().getNoticeUrl();
                rx4.y(this.a.k.getContext(), null, noticeUrl + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, false, true, true, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements gf8<SubscribeSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SubscribeAdapter a;
        public final /* synthetic */ ChatPage b;

        public n(ChatPage chatPage, SubscribeAdapter subscribeAdapter) {
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
        @Override // com.baidu.tieba.gf8
        /* renamed from: b */
        public void a(@NonNull View view2, @NonNull SubscribeSysMsg subscribeSysMsg, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, subscribeSysMsg, i) == null) && this.b.k.o2().s0()) {
                this.a.R(true);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923e2);
                if (SelectorHelper.getResources() != null) {
                    textView.setTextColor(SelectorHelper.getResources().getColor(R.color.CAM_X0101));
                }
                this.b.k.o2().u0();
                view2.setEnabled(false);
                TiebaStatic.log(new StatisticItem("c15258"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends e0<ShareChatRoomAdapter, ShareChatRoomSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: o */
        public boolean j(@NonNull ShareChatRoomSysMsg shareChatRoomSysMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareChatRoomSysMsg)) == null) {
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
    public class q extends e0<ShareCommonCardAdapter, ShareCommonCardSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: o */
        public boolean j(@NonNull ShareCommonCardSysMsg shareCommonCardSysMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareCommonCardSysMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

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
        }
    }

    /* loaded from: classes6.dex */
    public class r extends e0<ShareForumAdapter, ShareForumSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: o */
        public boolean j(@NonNull ShareForumSysMsg shareForumSysMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareForumSysMsg)) == null) {
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
    public class s extends e0<ShareThreadAdapter, ShareThreadSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: o */
        public boolean j(@NonNull ShareThreadSysMsg shareThreadSysMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareThreadSysMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(ChatPage chatPage) {
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
    public class t extends e0<SingleTextImageAdapter<SingleTextImageMsg>, SingleTextImageMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final g0<SingleTextImageAdapter<SingleTextImageMsg>> d;
        public final /* synthetic */ ChatPage e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(ChatPage chatPage) {
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
            this.d = new g0<>(this.e, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: o */
        public void i(@NonNull SingleTextImageMsg singleTextImageMsg, @NonNull jf8.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, singleTextImageMsg, eVar) == null) {
                super.i(singleTextImageMsg, eVar);
                this.d.i(singleTextImageMsg, eVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: p */
        public boolean j(@NonNull SingleTextImageMsg singleTextImageMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, singleTextImageMsg)) == null) {
                return this.d.j(singleTextImageMsg);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class u extends e0<ze8, TextGenImageMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf8
        /* renamed from: o */
        public boolean j(@NonNull TextGenImageMsg textGenImageMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textGenImageMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(ChatPage chatPage) {
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
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(ChatPage chatPage, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.X0()) {
                return;
            }
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                if ((map.get("sub_skill_config_type") instanceof Integer) && (map.get("text_gen_image_msg") instanceof TextGenImageMsg)) {
                    int intValue = ((Integer) map.get("sub_skill_config_type")).intValue();
                    TextGenImageMsg textGenImageMsg = (TextGenImageMsg) map.get("text_gen_image_msg");
                    if (this.a.k.n2() != null) {
                        GroupInputViewController n2 = this.a.k.n2();
                        n2.V1(intValue, textGenImageMsg, this.a.x0(textGenImageMsg));
                        n2.J1(GroupInputViewController.SourceType.TWO, true, true);
                        this.a.k.C2(false);
                    }
                }
            }
            if (this.a.x != null && this.a.x.getBasicInfo() != null && this.a.x.getBots() != null && this.a.x.getBots().getBotList() != null) {
                long forumId = this.a.x.getBasicInfo().getForumId();
                String forumName = this.a.x.getBasicInfo().getForumName();
                long id = this.a.x.getBasicInfo().getId();
                for (BotsDTO.BotListDTO botListDTO : this.a.x.getBots().getBotList()) {
                    if (botListDTO != null && !ListUtils.isEmpty(botListDTO.getSkill())) {
                        for (BotsDTO.BotListDTO.SkillDTO skillDTO : botListDTO.getSkill()) {
                            this.a.r = skillDTO.getName();
                        }
                    }
                }
                TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 3).param("fid", forumId).param("fname", forumName).param("room_id", id).param("obj_name", this.a.r).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements o55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kf8 b;
        public final /* synthetic */ BaseMsg c;
        public final /* synthetic */ int d;
        public final /* synthetic */ m55 e;

        public w(ChatPage chatPage, String str, kf8 kf8Var, BaseMsg baseMsg, int i, m55 m55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, str, kf8Var, baseMsg, Integer.valueOf(i), m55Var};
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
            this.b = kf8Var;
            this.c = baseMsg;
            this.d = i;
            this.e = m55Var;
        }

        @Override // com.baidu.tieba.o55.f
        public void M0(o55 o55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, o55Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            if (TextUtils.equals(((TextView) view2).getText().toString(), this.a)) {
                this.b.a().m(this.c, this.d);
            }
            this.e.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class x implements gf8<BaseMsg> {
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

        @Override // com.baidu.tieba.gf8
        public void a(@NonNull View view2, @NonNull BaseMsg baseMsg, int i) {
            ReMsgInfo reMsgInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, view2, baseMsg, i) == null) {
                if (view2.getId() == R.id.btn_msgitem_resend) {
                    kf8 b = kf8.b(view2);
                    if (b == null) {
                        return;
                    }
                    this.a.l1(b, baseMsg, i);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e7d && (reMsgInfo = baseMsg.getReMsgInfo()) != null) {
                    this.a.l.T(reMsgInfo.getMsgId(), reMsgInfo.getMsgKey(), this.a.K);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements hf8<BaseMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

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
            this.a = chatPage;
        }

        @Override // com.baidu.tieba.hf8
        public boolean a(@NonNull View view2, @NonNull BaseMsg baseMsg, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, view2, baseMsg, i)) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f09079b || id == R.id.obfuscated_res_0x7f090e86 || id == R.id.obfuscated_res_0x7f090e62 || id == R.id.obfuscated_res_0x7f090e8c || id == R.id.obfuscated_res_0x7f090e82 || id == R.id.obfuscated_res_0x7f090e83 || id == R.id.obfuscated_res_0x7f090e81 || id == R.id.obfuscated_res_0x7f090e80 || id == R.id.obfuscated_res_0x7f090e7d) {
                    this.a.k1(baseMsg);
                    this.a.A0();
                    return false;
                }
                return false;
            }
            return invokeLLI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class z implements sd8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public z(ChatPage chatPage) {
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

        @Override // com.baidu.tieba.sd8
        public void a(int i, @Nullable BaseMsg baseMsg, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, baseMsg, obj) == null) {
                if (i != 21) {
                    if (i == 24 && (obj instanceof AbilityItem)) {
                        AbilityItem abilityItem = (AbilityItem) obj;
                        this.a.A.c(abilityItem, baseMsg);
                        this.a.z0(abilityItem);
                    }
                } else if (this.a.k.n2() != null && baseMsg != null && (obj instanceof UserReplyInfoData)) {
                    this.a.k.n2().r1((UserReplyInfoData) obj, baseMsg);
                }
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
        this.t = -1;
        this.u = new k(this);
        this.v = true;
        this.A = new bf8();
        this.B = new af8();
        this.E = ef8.c.b();
        this.F = new v(this, 2921782);
        this.H = new x(this);
        this.I = new y(this);
        this.J = new z(this);
        this.K = new a0(this);
        this.L = new c0(this);
        this.M = new d0(this);
        this.N = new j(this, 2921799);
        this.j = groupChatFragment.getPageContext();
        this.k = groupChatFragment;
        this.l = groupChatRepo;
        groupChatRepo.b0(this.u);
        this.C = new SendMsgHandler(groupChatRepo, this);
        this.D = new SendStructMsgHandler(groupChatRepo, this);
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void S(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            super.S(z2);
            if (!z2) {
                o1();
            }
        }
    }

    public void c1(qe8 qe8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, qe8Var) == null) {
            this.G = qe8Var;
        }
    }

    public void d1(TopBubbleData topBubbleData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, topBubbleData) == null) {
            this.s = topBubbleData;
        }
    }

    public void h1(se8 se8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, se8Var) == null) {
            this.z = se8Var;
        }
    }

    public void k1(@NonNull BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, baseMsg) != null) || this.x == null) {
            return;
        }
        this.k.p2().e(baseMsg, this.x);
        this.k.p2().k();
    }

    @Override // com.baidu.tieba.jg8
    public void l(@NonNull AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, abilityItem) == null) {
            this.A.c(abilityItem, null);
        }
    }

    public void m1(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            n1(this.k.getStringSafely(i2), false);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void T(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, view2, bundle) == null) {
            super.T(view2, bundle);
            gx5.b(view2);
            this.w = f0.a(view2, this.b);
            this.k.p2().c(this.J);
            V0();
        }
    }

    public void Y0(long j2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048603, this, j2, str) == null) {
            this.l.T(j2, str, this.K);
        }
    }

    @Override // com.baidu.tieba.jg8
    public void d(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, str, i2) == null) {
            this.l.Z(VoiceMsg.create(str, i2));
        }
    }

    @Override // com.baidu.tieba.jg8
    public void g(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048614, this, str, i2) == null) {
            this.A.c(CallRobotHandler.f(str, i2), null);
        }
    }

    @Override // com.baidu.tieba.jg8
    public void j(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, str, str2) == null) {
            this.l.Z(ImageMsg.create(str, str2));
        }
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.k.n2() != null) {
            GroupInputViewController n2 = this.k.n2();
            if (n2.m0()) {
                n2.Y0();
            }
        }
    }

    @Nullable
    public BotsDTO B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.y;
        }
        return (BotsDTO) invokeV.objValue;
    }

    @Nullable
    public EffectSlice C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k.q2();
        }
        return (EffectSlice) invokeV.objValue;
    }

    @NonNull
    public GroupChatFragment D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (GroupChatFragment) invokeV.objValue;
    }

    @Nullable
    public UpBubbleSlice E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k.v2();
        }
        return (UpBubbleSlice) invokeV.objValue;
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.w.e.getVisibility() == 0) {
            this.w.e.setVisibility(8);
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.w.e.getVisibility() != 0) {
            this.w.e.setVisibility(0);
            this.w.e.setOnClickListener(new b(this));
        }
    }

    @NonNull
    public final RecallAdapter K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            this.l.X(RecallSysMsg.MSG_TYPE_LIST, RecallSysMsg.class);
            RecallAdapter recallAdapter = new RecallAdapter(this.j, RecallSysMsg.ADAPTER_TYPE);
            this.n = recallAdapter;
            return recallAdapter;
        }
        return (RecallAdapter) invokeV.objValue;
    }

    @NonNull
    public final SubscribeAdapter Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            this.l.W(-7015, SubscribeSysMsg.class);
            SubscribeAdapter subscribeAdapter = new SubscribeAdapter(this.j, SubscribeSysMsg.ADAPTER_TYPE);
            subscribeAdapter.F(null, new n(this, subscribeAdapter));
            return subscribeAdapter;
        }
        return (SubscribeAdapter) invokeV.objValue;
    }

    @NonNull
    public final TimestampAdapter T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            this.l.W(-7013, TimestampSysMsg.class);
            return new TimestampAdapter(this.j, TimestampSysMsg.ADAPTER_TYPE);
        }
        return (TimestampAdapter) invokeV.objValue;
    }

    @NonNull
    public final TipsAdapter U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            this.l.X(TipsSysMsg.MSG_TYPE_LIST, TipsSysMsg.class);
            TipsAdapter tipsAdapter = new TipsAdapter(this.j, TipsSysMsg.ADAPTER_TYPE);
            this.m = tipsAdapter;
            return tipsAdapter;
        }
        return (TipsAdapter) invokeV.objValue;
    }

    @NonNull
    public bf8 Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.A;
        }
        return (bf8) invokeV.objValue;
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && this.k.n2() != null) {
            this.k.n2().N1(new b0(this));
        }
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && this.w.b.canScrollVertically(1)) {
            H0();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onDestroy();
            this.E.c();
            if (this.L != null) {
                xg.a().removeCallbacks(this.L);
            }
            if (this.M != null) {
                xg.a().removeCallbacks(this.M);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onStart();
        }
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && !BdNetTypeUtil.isNetWorkAvailable() && this.k.getContext() != null) {
            wi.M(this.k.getContext(), R.string.obfuscated_res_0x7f0f0df3);
        }
    }

    @NonNull
    public final ImageAdapter G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.l.W(4, BigEmotionMsg.class);
            this.C.f(4, BigEmotionMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.j, BigEmotionMsg.ADAPTER_TYPE);
            imageAdapter.F(this.H, null);
            imageAdapter.G(this.I, null);
            imageAdapter.E(this.A, this.B);
            imageAdapter.J(new g0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final ImageAdapter I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.l.W(2, ImageMsg.class);
            this.C.f(2, ImageMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.j, ImageMsg.ADAPTER_TYPE);
            imageAdapter.F(this.H, null);
            imageAdapter.G(this.I, null);
            imageAdapter.E(this.A, this.B);
            imageAdapter.J(new g0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final NoticeModifyAdapter J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.l.W(7001, NoticeModifySysMsg.class);
            NoticeModifyAdapter noticeModifyAdapter = new NoticeModifyAdapter(this.j, NoticeModifySysMsg.ADAPTER_TYPE);
            this.o = noticeModifyAdapter;
            noticeModifyAdapter.F(null, new m(this));
            return this.o;
        }
        return (NoticeModifyAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareChatRoomAdapter L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.l.W(7020, ShareChatRoomSysMsg.class);
            ShareChatRoomAdapter shareChatRoomAdapter = new ShareChatRoomAdapter(this.j, ShareChatRoomSysMsg.ADAPTER_TYPE);
            shareChatRoomAdapter.G(this.I, null);
            shareChatRoomAdapter.J(new p(this));
            return shareChatRoomAdapter;
        }
        return (ShareChatRoomAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareCommonCardAdapter M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.l.W(7021, ShareCommonCardSysMsg.class);
            ShareCommonCardAdapter shareCommonCardAdapter = new ShareCommonCardAdapter(this.j, ShareCommonCardSysMsg.ADAPTER_TYPE);
            shareCommonCardAdapter.G(this.I, null);
            shareCommonCardAdapter.J(new q(this));
            return shareCommonCardAdapter;
        }
        return (ShareCommonCardAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareForumAdapter N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            this.l.W(7009, ShareForumSysMsg.class);
            ShareForumAdapter shareForumAdapter = new ShareForumAdapter(this.j, ShareForumSysMsg.ADAPTER_TYPE);
            shareForumAdapter.G(this.I, null);
            shareForumAdapter.J(new r(this));
            return shareForumAdapter;
        }
        return (ShareForumAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareThreadAdapter O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.l.W(7010, ShareThreadSysMsg.class);
            ShareThreadAdapter shareThreadAdapter = new ShareThreadAdapter(this.j, ShareThreadSysMsg.ADAPTER_TYPE);
            shareThreadAdapter.G(this.I, null);
            shareThreadAdapter.J(new s(this));
            return shareThreadAdapter;
        }
        return (ShareThreadAdapter) invokeV.objValue;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (!ListUtils.isEmpty(this.x.getQuickTalk()) && (D0() == null || !D0().z2())) {
                this.k.C2(true);
                this.k.l2().X(this.x);
                return;
            }
            this.k.C2(false);
        }
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            int lastVisiblePosition = this.w.b.getLastVisiblePosition();
            if (this.k.f2() != null && this.k.f2().I() != null) {
                this.k.f2().I().post(new a(this, lastVisiblePosition));
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @Nullable
    public View M(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0889, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.jg8
    public void b(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048606, this, str, str2, map) == null) {
            this.l.Z(BigEmotionMsg.create(str, str2, map));
        }
    }

    @NonNull
    public final SingleTextImageAdapter<SingleTextImageMsg> P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.l.W(102, SingleTextImageMsg.class);
            SingleTextImageAdapter<SingleTextImageMsg> singleTextImageAdapter = new SingleTextImageAdapter<>(this.j, SingleTextImageMsg.ADAPTER_TYPE);
            this.p = singleTextImageAdapter;
            singleTextImageAdapter.F(this.H, null);
            this.p.G(this.I, null);
            this.p.E(this.A, this.B);
            this.p.J(new t(this));
            return this.p;
        }
        return (SingleTextImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final TextAdapter R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            this.l.W(1, TextMsg.class);
            this.l.W(7019, EffectGuidanceSysMsg.class);
            this.l.W(7018, ExcellentSysMsg.class);
            this.C.f(1, TextMsg.class);
            TextAdapter textAdapter = new TextAdapter(this.j, TextMsg.ADAPTER_TYPE);
            textAdapter.J(new l(this));
            textAdapter.F(this.H, null);
            textAdapter.G(this.I, null);
            textAdapter.E(this.A, this.B);
            return textAdapter;
        }
        return (TextAdapter) invokeV.objValue;
    }

    @NonNull
    public final ze8 S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.l.W(101, TextGenImageMsg.class);
            this.l.W(7014, TextGenImageUpdateSysMsg.class);
            ze8 ze8Var = new ze8(this.j, TextGenImageMsg.ADAPTER_TYPE);
            this.q = ze8Var;
            ze8Var.F(this.H, null);
            this.q.G(this.I, null);
            this.q.E(this.A, this.B);
            this.q.J(new u(this));
            return this.q;
        }
        return (ze8) invokeV.objValue;
    }

    @NonNull
    public final VoiceAdapter W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            this.l.W(3, VoiceMsg.class);
            this.C.f(3, VoiceMsg.class);
            VoiceAdapter voiceAdapter = new VoiceAdapter(this.j, VoiceMsg.ADAPTER_TYPE);
            voiceAdapter.F(this.H, null);
            voiceAdapter.G(this.I, null);
            voiceAdapter.E(this.A, this.B);
            if (this.k.n2() != null) {
                voiceAdapter.e0(this.k.n2().U0());
            }
            voiceAdapter.J(new o(this));
            return voiceAdapter;
        }
        return (VoiceAdapter) invokeV.objValue;
    }

    public boolean X0() {
        InterceptResult invokeV;
        eh8 f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.k.n2() == null || (f2 = this.k.n2().T0().f()) == null) {
                return false;
            }
            BdTopToast bdTopToast = new BdTopToast(this.k.getContext());
            bdTopToast.g(f2.c());
            bdTopToast.h(false);
            bdTopToast.i((ViewGroup) this.k.getView());
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.A.a(this.C);
            this.A.a(this.D);
            this.A.a(new CallRobotHandler(this));
            this.A.a(new JumpToHandler(this.j));
            this.A.a(new InputBoxHandler(this));
            this.A.a(new ve8());
            this.A.a(new ye8(this));
            this.A.a(new JumpMsgHandler(this));
            this.A.a(new RequestRouterHandler(this));
            this.A.a(new we8(this));
            this.E.a(R0());
            this.E.a(J0());
            this.E.a(T0());
            this.E.a(U0());
            this.E.a(K0());
            this.E.a(W0());
            this.E.a(I0());
            this.E.a(N0());
            this.E.a(O0());
            this.E.a(G0());
            this.E.a(P0());
            this.E.a(S0());
            this.E.a(Q0());
            this.E.a(L0());
            this.E.a(M0());
            this.E.f(new c(this));
            this.w.b.addAdapters(this.E.e());
            this.w.b.setLayoutManager(new d(this, this.k.getContext()));
            this.w.b.setOnScrollToTopListener(new e(this));
            this.w.b.setOnSrollToBottomListener(new f(this));
            this.w.b.addOnScrollListener(new g(this));
            this.w.b.addOnLayoutChangeListener(new h(this));
            this.l.d0(new i(this));
            this.k.registerListener(this.F);
            this.k.registerListener(this.N);
        }
    }

    public final void a1() {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            int lastVisiblePosition = this.w.b.getLastVisiblePosition();
            int firstVisiblePosition = this.w.b.getFirstVisiblePosition();
            if (lastVisiblePosition != -1 && this.w.b.getCount() > 0 && this.w.b.getCount() - 1 == lastVisiblePosition) {
                this.t = firstVisiblePosition;
            }
            RecyclerView.LayoutManager layoutManager = this.w.b.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                int count = this.w.b.getCount() - 1;
                int i2 = Integer.MIN_VALUE;
                if (count > 0 && (findViewByPosition = layoutManager.findViewByPosition(count)) != null) {
                    i2 = -findViewByPosition.getHeight();
                }
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(count, i2);
            }
        }
    }

    public final void b1(BotsDTO.BotListDTO botListDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, botListDTO) == null) {
            if (botListDTO != null && botListDTO.getUser() != null) {
                BotsDTO.BotListDTO.UserDTO user = botListDTO.getUser();
                TextMsg create = TextMsg.create("@" + TbadkCoreApplication.getCurrentAccountNameShow() + " " + botListDTO.getAtGuide());
                create.setMockSenderInfo(ug.g(BIMManager.getBdUidFromBdUK(user.getUk()), 0L), user.getNameShow(), user.getPortrait(), 64, user.getRobotRole(), user.getForumLevel());
                AtUserInfo.AtType atType = AtUserInfo.AtType.USER;
                long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
                create.addAtUserInfo(AtUserInfo.create(atType, currentAccountId, "@" + TbadkCoreApplication.getCurrentAccountNameShow(), TbadkCoreApplication.getCurrentPortrait(), 0));
                create.setRobotGuideMsg(true);
                this.l.Z(create);
            }
        }
    }

    public void e1(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, chatRoomDetail) == null) {
            this.x = chatRoomDetail;
            this.y = chatRoomDetail.getBots();
            long id = chatRoomDetail.getBasicInfo().getId();
            this.A.f(id);
            this.B.f(id);
            this.B.e(chatRoomDetail.getBasicInfo().getForumName());
            this.B.d(chatRoomDetail.getBasicInfo().getForumId());
            this.B.g(chatRoomDetail.getBasicInfo().getName());
            this.m.R(chatRoomDetail.getBasicInfo().getForumId());
            this.m.S(chatRoomDetail.getBasicInfo().getId());
            this.o.R(chatRoomDetail.getBasicInfo().getForumId());
            this.o.S(chatRoomDetail.getBasicInfo().getId());
            this.n.R(chatRoomDetail.getBasicInfo().getForumId());
            this.n.S(chatRoomDetail.getBasicInfo().getId());
            this.p.a(chatRoomDetail.getBasicInfo().getForumName());
            this.q.a(chatRoomDetail.getBasicInfo().getForumName());
        }
    }

    public final void z0(AbilityItem abilityItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, abilityItem) == null) && this.y != null) {
            String obj = abilityItem.getConfMap().get("bot_uk").toString();
            String obj2 = abilityItem.getConfMap().get("skill_id").toString();
            BotsDTO.BotListDTO findBotByUk = this.y.findBotByUk(obj);
            BotsDTO.BotListDTO.SkillDTO skillDTO = null;
            if (findBotByUk != null) {
                skillDTO = findBotByUk.cloneSkillById(Integer.parseInt(obj2));
            }
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 3).param("obj_source", 5).param("fid", this.k.h2()).param("fname", this.k.i2()).param("room_id", this.k.j2());
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = "";
            }
            TiebaStatic.log(param.param("obj_name", str).param("obj_id", obj2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.jg8
    public void f(@NonNull String str, @Nullable Object obj, @Nullable ce8 ce8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map, int i2) {
        BaseMsg baseMsg;
        BaseMsg r2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{str, obj, ce8Var, list, map, Integer.valueOf(i2)}) == null) {
            if (obj instanceof BaseMsg) {
                baseMsg = (BaseMsg) obj;
            } else {
                baseMsg = null;
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2 && i2 != 3) {
                        r2 = TextMsg.create(str);
                        r2.addAtUserInfo(wf8.p(list, map));
                    }
                } else {
                    r2 = TextMsg.create(str);
                    if (baseMsg != null) {
                        r2.setReMsgInfo(ReMsgInfo.create(baseMsg, ((Object) baseMsg.getReplyPrefix()) + baseMsg.getThumbnailText().toString()));
                    }
                    r2.addAtUserInfo(wf8.p(list, map));
                }
                this.l.Z(r2);
            }
            r2 = wf8.r(wf8.m(str, baseMsg, ce8Var, list, map), ce8Var);
            this.l.Z(r2);
        }
    }

    public void i1(@NonNull String str, int i2, GroupInputViewController.SourceType sourceType, @Nullable BaseMsg baseMsg, boolean z2, boolean z3, boolean z4, @Nullable String str2) {
        BotsDTO.BotListDTO findBotByUk;
        BotsDTO.BotListDTO.SkillDTO cloneSkillById;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048617, this, new Object[]{str, Integer.valueOf(i2), sourceType, baseMsg, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str2}) != null) || X0()) {
            return;
        }
        BotsDTO botsDTO = this.y;
        boolean z5 = true;
        if (botsDTO != null && (findBotByUk = botsDTO.findBotByUk(str)) != null && (cloneSkillById = findBotByUk.cloneSkillById(i2)) != null) {
            if (str2 != null && !str2.isEmpty()) {
                cloneSkillById.setKeyboardContent(str2);
            }
            GroupInputViewController n2 = this.k.n2();
            if (n2 != null) {
                AtSelectData atSelectData = null;
                if (z3 && baseMsg != null) {
                    CommonMsgField commonMsgField = baseMsg.getCommonMsgField();
                    atSelectData = new AtSelectData(commonMsgField.getPortrait(), commonMsgField.getUserName(), String.valueOf(commonMsgField.getUserId()), commonMsgField.isRobot());
                    if (n2.B0() != null) {
                        n2.B0().E(atSelectData.getUid(), atSelectData);
                    }
                }
                n2.z1(baseMsg, findBotByUk.getUser(), cloneSkillById, z2);
                if (cloneSkillById.isFuncShowPanel() && (n2.P0() == null || !n2.P0().L())) {
                    n2.J1(sourceType, true, z4);
                }
                String Q0 = n2.Q0();
                n2.G1("");
                if (atSelectData != null && cloneSkillById.isCanKeyboardInput()) {
                    n2.d0(atSelectData, true, cloneSkillById.isFuncShowPanel());
                }
                if (!TextUtils.isEmpty(Q0)) {
                    n2.F1(Q0);
                }
                if (cloneSkillById.isFuncSendMsg()) {
                    n2.z0();
                    n2.A0();
                    n2.y0();
                }
                z5 = false;
            }
        }
        if (z5) {
            m1(R.string.obfuscated_res_0x7f0f0913);
        }
    }

    public final void l1(@NonNull kf8 kf8Var, @NonNull BaseMsg baseMsg, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048622, this, kf8Var, baseMsg, i2) == null) {
            m55 m55Var = new m55(this.j);
            String string = this.j.getString(R.string.msg_resend);
            m55Var.i(null, new String[]{string}, new w(this, string, kf8Var, baseMsg, i2, m55Var));
            m55Var.l();
        }
    }

    public void n1(@NonNull String str, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048624, this, str, z2) == null) && this.k.getContext() != null) {
            BdTopToast bdTopToast = new BdTopToast(this.k.getContext());
            bdTopToast.g(str);
            bdTopToast.h(z2);
            bdTopToast.i((ViewGroup) this.k.getView());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.w.c.h(i2);
            RecyclerView.Adapter adapter = this.w.b.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            p75 d2 = p75.d(this.w.e);
            d2.o(R.string.J_X01);
            d2.f(R.color.CAM_X0207);
            this.w.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.down_positioning_bubble_icon, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    @NonNull
    public final ce8 x0(@NonNull TextGenImageMsg textGenImageMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, textGenImageMsg)) == null) {
            ce8 ce8Var = new ce8();
            BotsDTO.BotListDTO.UserDTO userDTO = new BotsDTO.BotListDTO.UserDTO();
            ce8Var.a = userDTO;
            userDTO.setName(textGenImageMsg.getCommonMsgField().getUserName());
            ce8Var.a.setNameShow(textGenImageMsg.getCommonMsgField().getUserName());
            ce8Var.a.setPortrait(textGenImageMsg.getCommonMsgField().getPortrait());
            ce8Var.a.setUk(BIMManager.getBdUKFromBdUid(String.valueOf(textGenImageMsg.getCommonMsgField().getUserId())));
            ce8Var.b = new BotsDTO.BotListDTO.SkillDTO();
            if (textGenImageMsg.getSubSkillConfig() != null) {
                ce8Var.b.setSubSkill(textGenImageMsg.getSubSkillConfig().a);
            }
            ce8Var.d(true);
            return ce8Var;
        }
        return (ce8) invokeL.objValue;
    }

    public final void y0() {
        ChatRoomDetail chatRoomDetail;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && (chatRoomDetail = this.x) != null && chatRoomDetail.getBots() != null && !ListUtils.isEmpty(this.x.getBots().getBotList())) {
            String w2 = o95.p().w("key_show_bot_tip_list", "");
            List asList = Arrays.asList(w2.split(","));
            List<BotsDTO.BotListDTO> botList = this.x.getBots().getBotList();
            for (int i2 = 0; i2 < botList.size(); i2++) {
                BotsDTO.BotListDTO botListDTO = botList.get(i2);
                if (botListDTO != null && botListDTO.getUser() != null && !TextUtils.isEmpty(botListDTO.getUser().getUk()) && !TextUtils.isEmpty(botListDTO.getAtGuide()) && !asList.contains(botListDTO.getUser().getUk()) && !TextUtils.equals(BIMManager.getBdUidFromBdUK(botListDTO.getUser().getUk()), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                    b1(botListDTO);
                    if (TextUtils.isEmpty(w2)) {
                        str = botListDTO.getUser().getUk();
                    } else {
                        str = w2 + "," + botListDTO.getUser().getUk();
                    }
                    o95.p().J("key_show_bot_tip_list", str);
                    return;
                }
            }
        }
    }
}
