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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
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
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.tieba.a55;
import com.baidu.tieba.an8;
import com.baidu.tieba.ao8;
import com.baidu.tieba.c55;
import com.baidu.tieba.cn8;
import com.baidu.tieba.dn8;
import com.baidu.tieba.do8;
import com.baidu.tieba.em8;
import com.baidu.tieba.en8;
import com.baidu.tieba.fn8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.positionbubble.UpBubbleSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleData;
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
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.EmojiReplySysMsg;
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
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.Reaction;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.in8;
import com.baidu.tieba.kn8;
import com.baidu.tieba.lg;
import com.baidu.tieba.ln8;
import com.baidu.tieba.nn;
import com.baidu.tieba.nn8;
import com.baidu.tieba.on8;
import com.baidu.tieba.sl8;
import com.baidu.tieba.tm8;
import com.baidu.tieba.to8;
import com.baidu.tieba.uw5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.vo8;
import com.baidu.tieba.wm8;
import com.baidu.tieba.wo8;
import com.baidu.tieba.xp8;
import com.baidu.tieba.yq8;
import com.baidu.tieba.zm8;
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
public class ChatPage extends Slice implements wo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wm8 A;
    @NonNull
    public final fn8 B;
    @NonNull
    public final en8 C;
    @NonNull
    public final SendMsgHandler D;
    public final SendStructMsgHandler E;
    @NonNull
    public final in8.c F;
    public final CustomMessageListener G;
    public tm8 H;
    public final kn8<BaseMsg> I;
    public final ln8<BaseMsg> J;
    public final sl8 K;
    public final GroupChatRepo.v<TreeSet<ChatMsg>> L;
    public Runnable M;
    public Runnable N;
    public final CustomMessageListener O;
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
    public dn8 q;
    public ShareThreadAdapter r;
    public String s;
    public TopBubbleData t;
    public int u;
    public final GroupChatRepo.u<TreeSet<ChatMsg>> v;
    public boolean w;
    public f0 x;
    @Nullable
    public ChatRoomDetail y;
    @Nullable
    public BotsDTO z;

    /* loaded from: classes6.dex */
    public class i implements ChatMsgProcessor.h {
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
            public final /* synthetic */ i d;

            /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage$i$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0346a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0346a(a aVar) {
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
                        this.a.d.b.f1();
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
                    this.d.b.x.b.updateData(this.a, true, BaseMsg.DIFF_ITEM_CALLBACK);
                    this.d.b.k.O2();
                    if (this.b) {
                        Runnable runnable = this.c;
                        if (runnable == null) {
                            runnable = new RunnableC0346a(this);
                        }
                        lg.c(runnable);
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
            this.a = new nn(this.b.x.b);
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor.h
        @MainThread
        public void a(long j, @NonNull List<BaseMsg> list, @NonNull ChatMsgProcessor.j jVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), list, jVar}) != null) || this.b.k.p2()) {
                return;
            }
            boolean z = true;
            if ((!jVar.b || jVar.a == 1) && (!jVar.d || this.b.x.b.getLastVisiblePosition() != this.b.x.b.getCount() - 1 || this.b.I())) {
                z = false;
            }
            this.a.e(new a(this, list, z, jVar.d()));
        }
    }

    /* loaded from: classes6.dex */
    public class a0 extends GroupChatRepo.v<TreeSet<ChatMsg>> {
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
                    this.a.b.o1();
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
                this.b.x1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.b.x.c.g();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.b.x.c.j();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.v
        public void f(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                if (this.b.k.K2().getVisibility() == 0) {
                    i2 = this.b.k.K2().getHeight();
                } else {
                    i2 = 0;
                }
                if (this.b.x.b.getLayoutManager() instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) this.b.x.b.getLayoutManager()).scrollToPositionWithOffset(i, i2);
                } else {
                    this.b.x.b.scrollToPosition(i);
                }
                if (this.b.x.b.getAdapter() != null) {
                    this.b.x.b.getAdapter().notifyItemChanged(i);
                }
                lg.c(new a(this));
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.v
        public void g(@NonNull GroupChatRepo.FetchedEvent fetchedEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, fetchedEvent) == null) && fetchedEvent == GroupChatRepo.FetchedEvent.TARGET_MSG_NOT_EXIST) {
                if (this.b.t != null && TbadkCoreApplication.getInst().getVersionName().compareTo(this.b.t.getMsgMinVersion()) < 0) {
                    this.b.t = null;
                    this.b.u1(R.string.obfuscated_res_0x7f0f096e);
                    return;
                }
                this.b.u1(R.string.obfuscated_res_0x7f0f096d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0<Adapter extends BaseChatAdapter> extends e0<Adapter, BaseImageMsg<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* loaded from: classes6.dex */
        public class a implements vo8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nn8.e a;
            public final /* synthetic */ BaseImageMsg b;
            public final /* synthetic */ g0 c;

            public a(g0 g0Var, nn8.e eVar, BaseImageMsg baseImageMsg) {
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

            @Override // com.baidu.tieba.vo8
            public void a(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                    this.a.b();
                }
            }

            @Override // com.baidu.tieba.vo8
            public void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.c(i);
                }
            }

            @Override // com.baidu.tieba.vo8
            public void c(int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                    this.b.setThumbUrl(str2);
                    this.b.setBigSrc(str);
                    this.b.setSdkMsg(str2, str);
                    this.a.a();
                    if (this.c.d.y != null && this.c.d.y.getBasicInfo() != null) {
                        yq8.d("c15090", 2, this.c.d.y.getBasicInfo().getForumId(), this.c.d.y.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
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
        @Override // com.baidu.tieba.nn8
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
        @Override // com.baidu.tieba.nn8
        /* renamed from: o */
        public void i(@NonNull BaseImageMsg<?> baseImageMsg, @NonNull nn8.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseImageMsg, eVar) == null) && this.d.k.C2() != null && !StringUtils.isNull(baseImageMsg.getThumbUrl())) {
                this.d.k.C2().j2(baseImageMsg.getThumbUrl(), new a(this, eVar, baseImageMsg));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends e0<VoiceAdapter, VoiceMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* loaded from: classes6.dex */
        public class a implements to8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nn8.e a;
            public final /* synthetic */ VoiceMsg b;
            public final /* synthetic */ o c;

            public a(o oVar, nn8.e eVar, VoiceMsg voiceMsg) {
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

            @Override // com.baidu.tieba.to8
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.b.setVoiceUrl(str);
                    this.a.a();
                    if (this.c.d.y != null && this.c.d.y.getBasicInfo() != null) {
                        yq8.d("c15090", 3, this.c.d.y.getBasicInfo().getForumId(), this.c.d.y.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }

            @Override // com.baidu.tieba.to8
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
        @Override // com.baidu.tieba.nn8
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
        @Override // com.baidu.tieba.nn8
        /* renamed from: o */
        public void i(@NonNull VoiceMsg voiceMsg, @NonNull nn8.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceMsg, eVar) == null) && this.d.k.C2() != null && !StringUtils.isNull(voiceMsg.getPath())) {
                this.d.k.C2().k2(voiceMsg.getPath(), new a(this, eVar, voiceMsg));
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.k.t2().L().getHeight() <= 0 && this.a < this.b.u) {
                this.b.J0();
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
                this.a.l.Y();
                this.a.H0();
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
                if ((z || z2) && this.a.w) {
                    if (this.a.x != null && this.a.x.f != null && this.a.x.b != null && (this.a.x.f.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.x.f.getLayoutParams();
                        layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                        this.a.x.f.setLayoutParams(layoutParams);
                        this.a.x.f.requestLayout();
                        this.a.x.b.requestLayout();
                        lg.c(this.a.M);
                    }
                    this.a.w = false;
                    this.a.k.R2(false);
                } else if (z || z2) {
                } else {
                    this.a.w = true;
                    if (this.a.x != null && this.a.x.f != null && this.a.x.b != null && (this.a.x.f.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.a.x.f.getLayoutParams();
                        layoutParams2.height = 0;
                        this.a.x.f.setLayoutParams(layoutParams2);
                        this.a.x.f.requestLayout();
                        this.a.x.b.requestLayout();
                        this.a.x.b.canScrollVertically(1);
                    }
                    this.a.k.Q2(false);
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
                    this.a.B0();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.x != null && this.a.x.b != null) {
                this.a.x.b.scrollBy(0, TbadkCoreApplication.getInst().getKeyboardHeight());
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.x != null && this.a.x.b != null) {
                this.a.x.b.scrollBy(0, -TbadkCoreApplication.getInst().getKeyboardHeight());
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
                this.a.l.P(this.a.L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public abstract class e0<Adapter extends BaseChatAdapter, Msg extends BaseMsg> extends nn8<Adapter, Msg> {
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

        @Override // com.baidu.tieba.nn8
        public void k(BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, baseMsg, i, i2) == null) && this.c.A != null) {
                this.c.A.a(baseMsg, i, i2);
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
                this.a.l.Q(this.a.v);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BdTypeRecyclerView b;
        public do8 c;
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
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0906dd);
                f0Var.b = bdTypeRecyclerView;
                f0Var.c = new do8(bdTypeRecyclerView);
                f0Var.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090932);
                f0Var.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090931);
                f0Var.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906d7);
                f0Var.f = (RelativeLayout) fragment.requireView().findViewById(R.id.obfuscated_res_0x7f091554);
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
                if (!this.a.x.b.canScrollVertically(1) && !this.a.l.X()) {
                    ChatPage chatPage = this.a;
                    chatPage.u = chatPage.x.b.getFirstVisiblePosition();
                    this.a.H0();
                }
                if (i2 < 0) {
                    this.a.o1();
                }
                if (this.a.H != null) {
                    this.a.H.a(this.a.x.b);
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
                int lastVisiblePosition = this.a.x.b.getLastVisiblePosition();
                int firstVisiblePosition = this.a.x.b.getFirstVisiblePosition();
                if (lastVisiblePosition != -1 && this.a.x.b.getCount() > 0 && this.a.x.b.getCount() - 1 == lastVisiblePosition) {
                    this.a.u = firstVisiblePosition;
                }
                if (this.a.H != null) {
                    this.a.H.b(this.a.x.b, this.a.l, this.a.L);
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
                this.a.l.p0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends GroupChatRepo.u<TreeSet<ChatMsg>> {
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
                this.b.x1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.b.x.c.f();
                this.b.w1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.b.x.c.i();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.u
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.f1();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.u
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.z0();
                if (this.b.G0() != null) {
                    this.b.G0().i0();
                }
                this.b.k1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends e0<TextAdapter, TextMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nn8
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage.e0, com.baidu.tieba.nn8
        public void k(BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseMsg, i, i2) == null) {
                super.k(baseMsg, i, i2);
                if (this.d.y != null && this.d.y.getBasicInfo() != null) {
                    long forumId = this.d.y.getBasicInfo().getForumId();
                    long id = this.d.y.getBasicInfo().getId();
                    if (i == 5) {
                        yq8.d("c15090", 1, forumId, id, TbadkCoreApplication.getCurrentAccount());
                        String text = ((TextMsg) baseMsg).getText();
                        if (this.d.E0() != null) {
                            this.d.E0().c0(text, baseMsg.getCommonMsgField().getRoomId(), !baseMsg.isLeft());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements kn8<NoticeModifySysMsg> {
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
        @Override // com.baidu.tieba.kn8
        /* renamed from: b */
        public void a(@NonNull View view2, @NonNull NoticeModifySysMsg noticeModifySysMsg, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, noticeModifySysMsg, i) == null) && noticeModifySysMsg != null && noticeModifySysMsg.getChatroomInfo() != null && noticeModifySysMsg.getChatroomInfo().getNoticeUrl() != null) {
                String noticeUrl = noticeModifySysMsg.getChatroomInfo().getNoticeUrl();
                BrowserHelper.startWebActivity(this.a.k.getContext(), null, noticeUrl + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, false, true, true, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements kn8<SubscribeSysMsg> {
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
        @Override // com.baidu.tieba.kn8
        /* renamed from: b */
        public void a(@NonNull View view2, @NonNull SubscribeSysMsg subscribeSysMsg, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, subscribeSysMsg, i) == null) && this.b.k.D2().r0()) {
                this.a.Q(true);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924c1);
                if (SelectorHelper.getResources() != null) {
                    textView.setTextColor(SelectorHelper.getResources().getColor(R.color.CAM_X0101));
                }
                this.b.k.D2().t0();
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
        @Override // com.baidu.tieba.nn8
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
        @Override // com.baidu.tieba.nn8
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
        @Override // com.baidu.tieba.nn8
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
        @Override // com.baidu.tieba.nn8
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
        @Override // com.baidu.tieba.nn8
        /* renamed from: o */
        public void i(@NonNull SingleTextImageMsg singleTextImageMsg, @NonNull nn8.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, singleTextImageMsg, eVar) == null) {
                super.i(singleTextImageMsg, eVar);
                this.d.i(singleTextImageMsg, eVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nn8
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
    public class u extends e0<dn8, TextGenImageMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nn8
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.a1()) {
                return;
            }
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                if ((map.get("sub_skill_config_type") instanceof Integer) && (map.get("text_gen_image_msg") instanceof TextGenImageMsg)) {
                    int intValue = ((Integer) map.get("sub_skill_config_type")).intValue();
                    TextGenImageMsg textGenImageMsg = (TextGenImageMsg) map.get("text_gen_image_msg");
                    if (this.a.k.C2() != null) {
                        GroupInputViewController C2 = this.a.k.C2();
                        C2.X1(intValue, textGenImageMsg, this.a.y0(textGenImageMsg));
                        C2.L1(GroupInputViewController.SourceType.TWO, true, true);
                        this.a.k.R2(false);
                    }
                }
            }
            if (this.a.y != null && this.a.y.getBasicInfo() != null && this.a.y.getBots() != null && this.a.y.getBots().getBotList() != null) {
                long forumId = this.a.y.getBasicInfo().getForumId();
                String forumName = this.a.y.getBasicInfo().getForumName();
                long id = this.a.y.getBasicInfo().getId();
                for (BotsDTO.BotListDTO botListDTO : this.a.y.getBots().getBotList()) {
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
    public class w implements c55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ on8 b;
        public final /* synthetic */ BaseMsg c;
        public final /* synthetic */ int d;
        public final /* synthetic */ a55 e;

        public w(ChatPage chatPage, String str, on8 on8Var, BaseMsg baseMsg, int i, a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, str, on8Var, baseMsg, Integer.valueOf(i), a55Var};
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
            this.b = on8Var;
            this.c = baseMsg;
            this.d = i;
            this.e = a55Var;
        }

        @Override // com.baidu.tieba.c55.f
        public void J0(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, c55Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            if (TextUtils.equals(((TextView) view2).getText().toString(), this.a)) {
                this.b.a().m(this.c, this.d);
            }
            this.e.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class x implements kn8<BaseMsg> {
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

        @Override // com.baidu.tieba.kn8
        public void a(@NonNull View view2, @NonNull BaseMsg baseMsg, int i) {
            ReMsgInfo reMsgInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, view2, baseMsg, i) == null) {
                if (view2.getId() == R.id.btn_msgitem_resend) {
                    on8 b = on8.b(view2);
                    if (b == null) {
                        return;
                    }
                    this.a.t1(b, baseMsg, i);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eb5 && (reMsgInfo = baseMsg.getReMsgInfo()) != null) {
                    this.a.l.Z(reMsgInfo.getMsgId(), reMsgInfo.getMsgKey(), this.a.L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements ln8<BaseMsg> {
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

        @Override // com.baidu.tieba.ln8
        public boolean a(@NonNull View view2, @NonNull BaseMsg baseMsg, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, view2, baseMsg, i)) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f0907b5 || id == R.id.obfuscated_res_0x7f090ebe || id == R.id.obfuscated_res_0x7f090e9a || id == R.id.obfuscated_res_0x7f090ec4 || id == R.id.obfuscated_res_0x7f090eba || id == R.id.obfuscated_res_0x7f090ebb || id == R.id.obfuscated_res_0x7f090eb9 || id == R.id.obfuscated_res_0x7f090eb8 || id == R.id.obfuscated_res_0x7f090eb5) {
                    this.a.s1(baseMsg);
                    this.a.B0();
                    return false;
                }
                return false;
            }
            return invokeLLI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class z implements sl8 {
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

        @Override // com.baidu.tieba.sl8
        public void a(int i, @Nullable BaseMsg baseMsg, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, baseMsg, obj) == null) {
                if (i != 21) {
                    if (i == 24 && (obj instanceof AbilityItem)) {
                        AbilityItem abilityItem = (AbilityItem) obj;
                        this.a.B.c(abilityItem, baseMsg);
                        this.a.A0(abilityItem);
                    }
                } else if (this.a.k.C2() != null && baseMsg != null && (obj instanceof UserReplyInfoData)) {
                    this.a.k.C2().t1((UserReplyInfoData) obj, baseMsg);
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
        this.u = -1;
        this.v = new k(this);
        this.w = true;
        this.B = new fn8();
        this.C = new en8();
        this.F = in8.c.b();
        this.G = new v(this, 2921782);
        this.I = new x(this);
        this.J = new y(this);
        this.K = new z(this);
        this.L = new a0(this);
        this.M = new c0(this);
        this.N = new d0(this);
        this.O = new j(this, 2921799);
        this.j = groupChatFragment.getPageContext();
        this.k = groupChatFragment;
        this.l = groupChatRepo;
        groupChatRepo.j0(this.v);
        this.D = new SendMsgHandler(groupChatRepo, this);
        this.E = new SendStructMsgHandler(groupChatRepo, this);
    }

    public ChatMsg C0(@NonNull Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            return this.l.T(map);
        }
        return (ChatMsg) invokeL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void U(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) {
            super.U(z2);
            if (!z2) {
                w1();
            }
        }
    }

    public void c1(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, chatMsg) == null) {
            this.l.b0(chatMsg);
        }
    }

    public void h1(tm8 tm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, tm8Var) == null) {
            this.H = tm8Var;
        }
    }

    public void i1(TopBubbleData topBubbleData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, topBubbleData) == null) {
            this.t = topBubbleData;
        }
    }

    @Override // com.baidu.tieba.wo8
    public void m(@NonNull AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, abilityItem) == null) {
            this.B.c(abilityItem, null);
        }
    }

    public void m1(wm8 wm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, wm8Var) == null) {
            this.A = wm8Var;
        }
    }

    public void s1(@NonNull BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048630, this, baseMsg) != null) || this.y == null) {
            return;
        }
        this.k.F2().e(baseMsg, this.y);
        this.k.F2().l();
    }

    public void u1(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            v1(this.k.getStringSafely(i2), false);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void V(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, view2, bundle) == null) {
            super.V(view2, bundle);
            uw5.b(view2);
            this.x = f0.a(view2, this.b);
            this.k.F2().b(this.K);
            Y0();
        }
    }

    public void b1(long j2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048605, this, j2, str) == null) {
            this.l.Z(j2, str, this.L);
        }
    }

    @Override // com.baidu.tieba.wo8
    public void d(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, str, i2) == null) {
            this.l.h0(VoiceMsg.create(str, i2));
        }
    }

    @Override // com.baidu.tieba.wo8
    public void j(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048616, this, str, i2) == null) {
            this.B.c(CallRobotHandler.f(str, i2), null);
        }
    }

    @Override // com.baidu.tieba.wo8
    public void k(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, str, str2) == null) {
            this.l.h0(ImageMsg.create(str, str2));
        }
    }

    public void q1(@NonNull List<EmojiData> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048629, this, list, i2) == null) {
            this.k.A2().g0(list, i2);
        }
    }

    public final void A0(AbilityItem abilityItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, abilityItem) == null) && this.z != null) {
            String obj = abilityItem.getConfMap().get("bot_uk").toString();
            String obj2 = abilityItem.getConfMap().get("skill_id").toString();
            BotsDTO.BotListDTO findBotByUk = this.z.findBotByUk(obj);
            BotsDTO.BotListDTO.SkillDTO skillDTO = null;
            if (findBotByUk != null) {
                skillDTO = findBotByUk.cloneSkillById(Integer.parseInt(obj2));
            }
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 3).param("obj_source", 5).param("fid", this.k.v2()).param("fname", this.k.w2()).param("room_id", this.k.x2());
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = "";
            }
            TiebaStatic.log(param.param("obj_name", str).param("obj_id", obj2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void g1(BotsDTO.BotListDTO botListDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, botListDTO) == null) {
            if (botListDTO != null && botListDTO.getUser() != null) {
                BotsDTO.BotListDTO.UserDTO user = botListDTO.getUser();
                TextMsg create = TextMsg.create("@" + TbadkCoreApplication.getCurrentAccountNameShow() + " " + botListDTO.getAtGuide());
                create.setMockSenderInfo(JavaTypesHelper.toLong(BIMManager.getBdUidFromBdUK(user.getUk()), 0L), user.getNameShow(), user.getPortrait(), 64, user.getRobotRole(), user.getForumLevel());
                AtUserInfo.AtType atType = AtUserInfo.AtType.USER;
                long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
                create.addAtUserInfo(AtUserInfo.create(atType, currentAccountId, "@" + TbadkCoreApplication.getCurrentAccountNameShow(), TbadkCoreApplication.getCurrentPortrait(), 0));
                create.setRobotGuideMsg(true);
                this.l.h0(create);
            }
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.k.C2() != null) {
            GroupInputViewController C2 = this.k.C2();
            if (C2.n0()) {
                C2.Z0();
            }
        }
    }

    @Nullable
    public BotsDTO D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.z;
        }
        return (BotsDTO) invokeV.objValue;
    }

    @Nullable
    public EffectSlice E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k.G2();
        }
        return (EffectSlice) invokeV.objValue;
    }

    @NonNull
    public GroupChatFragment F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.k;
        }
        return (GroupChatFragment) invokeV.objValue;
    }

    @Nullable
    public UpBubbleSlice G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.k.L2();
        }
        return (UpBubbleSlice) invokeV.objValue;
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.x.e.getVisibility() == 0) {
            this.x.e.setVisibility(8);
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.x.e.getVisibility() != 0) {
            this.x.e.setVisibility(0);
            this.x.e.setOnClickListener(new b(this));
        }
    }

    @NonNull
    public final RecallAdapter N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.l.f0(RecallSysMsg.MSG_TYPE_LIST, RecallSysMsg.class);
            RecallAdapter recallAdapter = new RecallAdapter(this.j, RecallSysMsg.ADAPTER_TYPE);
            this.n = recallAdapter;
            return recallAdapter;
        }
        return (RecallAdapter) invokeV.objValue;
    }

    @NonNull
    public final SubscribeAdapter T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            this.l.e0(-7015, SubscribeSysMsg.class);
            SubscribeAdapter subscribeAdapter = new SubscribeAdapter(this.j, SubscribeSysMsg.ADAPTER_TYPE);
            subscribeAdapter.F(null, new n(this, subscribeAdapter));
            return subscribeAdapter;
        }
        return (SubscribeAdapter) invokeV.objValue;
    }

    @NonNull
    public final TimestampAdapter W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            this.l.e0(-7013, TimestampSysMsg.class);
            return new TimestampAdapter(this.j, TimestampSysMsg.ADAPTER_TYPE);
        }
        return (TimestampAdapter) invokeV.objValue;
    }

    @NonNull
    public final TipsAdapter X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            this.l.f0(TipsSysMsg.MSG_TYPE_LIST, TipsSysMsg.class);
            TipsAdapter tipsAdapter = new TipsAdapter(this.j, TipsSysMsg.ADAPTER_TYPE);
            this.m = tipsAdapter;
            return tipsAdapter;
        }
        return (TipsAdapter) invokeV.objValue;
    }

    @NonNull
    public fn8 d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.B;
        }
        return (fn8) invokeV.objValue;
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.l.e0(20000, EmojiReplySysMsg.class);
        }
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.k.C2() != null) {
            this.k.C2().P1(new b0(this));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onDestroy();
            this.F.c();
            if (this.M != null) {
                SafeHandler.getInst().removeCallbacks(this.M);
            }
            if (this.N != null) {
                SafeHandler.getInst().removeCallbacks(this.N);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onStart();
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && this.x.b.canScrollVertically(1)) {
            J0();
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && !BdNetTypeUtil.isNetWorkAvailable() && this.k.getContext() != null) {
            BdUtilHelper.showLongToast(this.k.getContext(), (int) R.string.obfuscated_res_0x7f0f0e29);
        }
    }

    @NonNull
    public final ImageAdapter I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.l.e0(4, BigEmotionMsg.class);
            this.D.f(4, BigEmotionMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.j, BigEmotionMsg.ADAPTER_TYPE);
            imageAdapter.F(this.I, null);
            imageAdapter.G(this.J, null);
            imageAdapter.E(this.B, this.C);
            imageAdapter.J(new g0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final ImageAdapter K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            this.l.e0(2, ImageMsg.class);
            this.D.f(2, ImageMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.j, ImageMsg.ADAPTER_TYPE);
            imageAdapter.F(this.I, null);
            imageAdapter.G(this.J, null);
            imageAdapter.E(this.B, this.C);
            imageAdapter.J(new g0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final NoticeModifyAdapter L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.l.e0(7001, NoticeModifySysMsg.class);
            NoticeModifyAdapter noticeModifyAdapter = new NoticeModifyAdapter(this.j, NoticeModifySysMsg.ADAPTER_TYPE);
            this.o = noticeModifyAdapter;
            noticeModifyAdapter.F(null, new m(this));
            return this.o;
        }
        return (NoticeModifyAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareChatRoomAdapter O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.l.e0(7020, ShareChatRoomSysMsg.class);
            ShareChatRoomAdapter shareChatRoomAdapter = new ShareChatRoomAdapter(this.j, ShareChatRoomSysMsg.ADAPTER_TYPE);
            shareChatRoomAdapter.E(this.B, this.C);
            shareChatRoomAdapter.G(this.J, null);
            shareChatRoomAdapter.J(new p(this));
            return shareChatRoomAdapter;
        }
        return (ShareChatRoomAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareCommonCardAdapter P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.l.e0(7021, ShareCommonCardSysMsg.class);
            ShareCommonCardAdapter shareCommonCardAdapter = new ShareCommonCardAdapter(this.j, ShareCommonCardSysMsg.ADAPTER_TYPE);
            shareCommonCardAdapter.d0(this.k.x2());
            shareCommonCardAdapter.E(this.B, this.C);
            shareCommonCardAdapter.G(this.J, null);
            shareCommonCardAdapter.J(new q(this));
            return shareCommonCardAdapter;
        }
        return (ShareCommonCardAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareForumAdapter Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.l.e0(7009, ShareForumSysMsg.class);
            ShareForumAdapter shareForumAdapter = new ShareForumAdapter(this.j, ShareForumSysMsg.ADAPTER_TYPE);
            shareForumAdapter.E(this.B, this.C);
            shareForumAdapter.f0(this.k.x2());
            shareForumAdapter.G(this.J, null);
            shareForumAdapter.J(new r(this));
            return shareForumAdapter;
        }
        return (ShareForumAdapter) invokeV.objValue;
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (!ListUtils.isEmpty(this.y.getQuickTalk()) && (F0() == null || !F0().P2())) {
                this.k.R2(true);
                this.k.z2().Z(this.y);
                return;
            }
            this.k.R2(false);
        }
    }

    public void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            int lastVisiblePosition = this.x.b.getLastVisiblePosition();
            if (this.k.t2() != null && this.k.t2().L() != null) {
                this.k.t2().L().post(new a(this, lastVisiblePosition));
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @Nullable
    public View P(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08c7, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.wo8
    public void c(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048606, this, str, str2, map) == null) {
            this.l.h0(BigEmotionMsg.create(str, str2, map));
        }
    }

    public void p1(int i2, @NonNull BaseMsg baseMsg, @Nullable List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048628, this, i2, baseMsg, list) == null) {
            this.k.E2().l0(i2, baseMsg, list);
        }
    }

    @NonNull
    public final ShareThreadAdapter R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            this.l.e0(7010, ShareThreadSysMsg.class);
            ShareThreadAdapter shareThreadAdapter = new ShareThreadAdapter(this.j, ShareThreadSysMsg.ADAPTER_TYPE);
            this.r = shareThreadAdapter;
            shareThreadAdapter.h0(this.k.x2());
            this.r.E(this.B, this.C);
            this.r.G(this.J, null);
            this.r.J(new s(this));
            return this.r;
        }
        return (ShareThreadAdapter) invokeV.objValue;
    }

    @NonNull
    public final SingleTextImageAdapter<SingleTextImageMsg> S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            this.l.e0(102, SingleTextImageMsg.class);
            SingleTextImageAdapter<SingleTextImageMsg> singleTextImageAdapter = new SingleTextImageAdapter<>(this.j, SingleTextImageMsg.ADAPTER_TYPE);
            this.p = singleTextImageAdapter;
            singleTextImageAdapter.F(this.I, null);
            this.p.G(this.J, null);
            this.p.E(this.B, this.C);
            this.p.J(new t(this));
            return this.p;
        }
        return (SingleTextImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final TextAdapter U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            this.l.e0(1, TextMsg.class);
            this.l.e0(7019, EffectGuidanceSysMsg.class);
            this.l.e0(7018, ExcellentSysMsg.class);
            this.D.f(1, TextMsg.class);
            TextAdapter textAdapter = new TextAdapter(this.j, TextMsg.ADAPTER_TYPE);
            textAdapter.J(new l(this));
            textAdapter.F(this.I, null);
            textAdapter.G(this.J, null);
            textAdapter.E(this.B, this.C);
            return textAdapter;
        }
        return (TextAdapter) invokeV.objValue;
    }

    @NonNull
    public final dn8 V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            this.l.e0(101, TextGenImageMsg.class);
            this.l.e0(7014, TextGenImageUpdateSysMsg.class);
            dn8 dn8Var = new dn8(this.j, TextGenImageMsg.ADAPTER_TYPE);
            this.q = dn8Var;
            dn8Var.F(this.I, null);
            this.q.G(this.J, null);
            this.q.E(this.B, this.C);
            this.q.J(new u(this));
            return this.q;
        }
        return (dn8) invokeV.objValue;
    }

    @NonNull
    public final VoiceAdapter Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            this.l.e0(3, VoiceMsg.class);
            this.D.f(3, VoiceMsg.class);
            VoiceAdapter voiceAdapter = new VoiceAdapter(this.j, VoiceMsg.ADAPTER_TYPE);
            voiceAdapter.F(this.I, null);
            voiceAdapter.G(this.J, null);
            voiceAdapter.E(this.B, this.C);
            if (this.k.C2() != null) {
                voiceAdapter.j0(this.k.C2().V0());
            }
            voiceAdapter.J(new o(this));
            return voiceAdapter;
        }
        return (VoiceAdapter) invokeV.objValue;
    }

    public boolean a1() {
        InterceptResult invokeV;
        xp8 g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.k.C2() == null || (g2 = this.k.C2().U0().g()) == null) {
                return false;
            }
            new BdTopToast(this.k.getContext()).setContent(g2.c()).setIcon(false).show((ViewGroup) this.k.getView());
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.B.a(this.D);
            this.B.a(this.E);
            this.B.a(new CallRobotHandler(this));
            this.B.a(new JumpToHandler(this.j));
            this.B.a(new InputBoxHandler(this));
            this.B.a(new zm8());
            this.B.a(new cn8(this));
            this.B.a(new JumpMsgHandler(this));
            this.B.a(new RequestRouterHandler(this));
            this.B.a(new an8(this));
            this.B.a(new SendEmojiMsgHandler(this.j.getPageActivity(), this));
            this.B.a(new OpenEmojiDetailHandler(this));
            this.B.a(new OpenReactionPanelHandler(this));
            this.F.a(U0());
            this.F.a(L0());
            this.F.a(W0());
            this.F.a(X0());
            this.F.a(N0());
            this.F.a(Z0());
            this.F.a(K0());
            this.F.a(Q0());
            this.F.a(R0());
            this.F.a(I0());
            this.F.a(S0());
            this.F.a(V0());
            this.F.a(T0());
            this.F.a(O0());
            this.F.a(P0());
            this.F.f(new c(this));
            e1();
            this.x.b.addAdapters(this.F.e());
            this.x.b.setLayoutManager(new d(this, this.k.getContext()));
            this.x.b.setOnScrollToTopListener(new e(this));
            this.x.b.setOnSrollToBottomListener(new f(this));
            this.x.b.addOnScrollListener(new g(this));
            this.x.b.addOnLayoutChangeListener(new h(this));
            this.l.l0(new i(this));
            this.k.registerListener(this.G);
            this.k.registerListener(this.O);
        }
    }

    public final void f1() {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            int lastVisiblePosition = this.x.b.getLastVisiblePosition();
            int firstVisiblePosition = this.x.b.getFirstVisiblePosition();
            if (lastVisiblePosition != -1 && this.x.b.getCount() > 0 && this.x.b.getCount() - 1 == lastVisiblePosition) {
                this.u = firstVisiblePosition;
            }
            RecyclerView.LayoutManager layoutManager = this.x.b.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                int count = this.x.b.getCount() - 1;
                int i2 = Integer.MIN_VALUE;
                if (count > 0 && (findViewByPosition = layoutManager.findViewByPosition(count)) != null) {
                    i2 = -findViewByPosition.getHeight();
                }
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(count, i2);
            }
        }
    }

    @Override // com.baidu.tieba.wo8
    public void i(@NonNull String str, @Nullable Object obj, @Nullable em8 em8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map, int i2) {
        BaseMsg baseMsg;
        BaseMsg r2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, obj, em8Var, list, map, Integer.valueOf(i2)}) == null) {
            if (obj instanceof BaseMsg) {
                baseMsg = (BaseMsg) obj;
            } else {
                baseMsg = null;
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2 && i2 != 3) {
                        r2 = TextMsg.create(str);
                        r2.addAtUserInfo(ao8.p(list, map));
                    }
                } else {
                    r2 = TextMsg.create(str);
                    if (baseMsg != null) {
                        r2.setReMsgInfo(ReMsgInfo.create(baseMsg, ((Object) baseMsg.getReplyPrefix()) + baseMsg.getThumbnailText().toString()));
                    }
                    r2.addAtUserInfo(ao8.p(list, map));
                }
                this.l.h0(r2);
            }
            r2 = ao8.r(ao8.m(str, baseMsg, em8Var, list, map), em8Var);
            this.l.h0(r2);
        }
    }

    public void j1(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, chatRoomDetail) == null) {
            this.y = chatRoomDetail;
            this.z = chatRoomDetail.getBots();
            long id = chatRoomDetail.getBasicInfo().getId();
            this.B.f(id);
            this.C.f(id);
            this.C.e(chatRoomDetail.getBasicInfo().getForumName());
            this.C.d(chatRoomDetail.getBasicInfo().getForumId());
            this.C.g(chatRoomDetail.getBasicInfo().getName());
            this.m.Q(chatRoomDetail.getBasicInfo().getForumId());
            this.m.R(chatRoomDetail.getBasicInfo().getId());
            this.o.Q(chatRoomDetail.getBasicInfo().getForumId());
            this.o.R(chatRoomDetail.getBasicInfo().getId());
            this.n.Q(chatRoomDetail.getBasicInfo().getForumId());
            this.n.R(chatRoomDetail.getBasicInfo().getId());
            this.p.a(chatRoomDetail.getBasicInfo().getForumName());
            this.q.a(chatRoomDetail.getBasicInfo().getForumName());
            this.r.f0(chatRoomDetail.getBasicInfo().getForumId());
            this.r.g0(chatRoomDetail.getBasicInfo().getForumName());
        }
    }

    public void n1(@NonNull String str, int i2, GroupInputViewController.SourceType sourceType, @Nullable BaseMsg baseMsg, boolean z2, boolean z3, boolean z4, @Nullable String str2) {
        BotsDTO.BotListDTO findBotByUk;
        BotsDTO.BotListDTO.SkillDTO cloneSkillById;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048623, this, new Object[]{str, Integer.valueOf(i2), sourceType, baseMsg, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str2}) != null) || a1()) {
            return;
        }
        BotsDTO botsDTO = this.z;
        boolean z5 = true;
        if (botsDTO != null && (findBotByUk = botsDTO.findBotByUk(str)) != null && (cloneSkillById = findBotByUk.cloneSkillById(i2)) != null) {
            if (str2 != null && !str2.isEmpty()) {
                cloneSkillById.setKeyboardContent(str2);
            }
            GroupInputViewController C2 = this.k.C2();
            if (C2 != null) {
                AtSelectData atSelectData = null;
                if (z3 && baseMsg != null) {
                    CommonMsgField commonMsgField = baseMsg.getCommonMsgField();
                    atSelectData = new AtSelectData(commonMsgField.getPortrait(), commonMsgField.getUserName(), String.valueOf(commonMsgField.getUserId()), commonMsgField.isRobot());
                    if (C2.C0() != null) {
                        C2.C0().E(atSelectData.getUid(), atSelectData);
                    }
                }
                C2.B1(baseMsg, findBotByUk.getUser(), cloneSkillById, z2);
                if (cloneSkillById.isFuncShowPanel() && (C2.Q0() == null || !C2.Q0().L())) {
                    C2.L1(sourceType, true, z4);
                }
                String R0 = C2.R0();
                C2.I1("");
                if (atSelectData != null && cloneSkillById.isCanKeyboardInput()) {
                    C2.e0(atSelectData, true, cloneSkillById.isFuncShowPanel());
                }
                if (!TextUtils.isEmpty(R0)) {
                    C2.H1(R0);
                }
                if (cloneSkillById.isFuncSendMsg()) {
                    C2.A0();
                    C2.B0();
                    C2.z0();
                }
                z5 = false;
            }
        }
        if (z5) {
            u1(R.string.obfuscated_res_0x7f0f0929);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.x.c.h(i2);
            RecyclerView.Adapter adapter = this.x.b.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            EMManager.from(this.x.e).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0207);
            this.x.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.down_positioning_bubble_icon, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public final void t1(@NonNull on8 on8Var, @NonNull BaseMsg baseMsg, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048631, this, on8Var, baseMsg, i2) == null) {
            a55 a55Var = new a55(this.j);
            String string = this.j.getString(R.string.msg_resend);
            a55Var.i(null, new String[]{string}, new w(this, string, on8Var, baseMsg, i2, a55Var));
            a55Var.l();
        }
    }

    public void v1(@NonNull String str, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048633, this, str, z2) == null) && this.k.getContext() != null) {
            new BdTopToast(this.k.getContext()).setContent(str).setIcon(z2).show((ViewGroup) this.k.getView());
        }
    }

    @NonNull
    public final em8 y0(@NonNull TextGenImageMsg textGenImageMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, textGenImageMsg)) == null) {
            em8 em8Var = new em8();
            BotsDTO.BotListDTO.UserDTO userDTO = new BotsDTO.BotListDTO.UserDTO();
            em8Var.a = userDTO;
            userDTO.setName(textGenImageMsg.getCommonMsgField().getUserName());
            em8Var.a.setNameShow(textGenImageMsg.getCommonMsgField().getUserName());
            em8Var.a.setPortrait(textGenImageMsg.getCommonMsgField().getPortrait());
            em8Var.a.setUk(BIMManager.getBdUKFromBdUid(String.valueOf(textGenImageMsg.getCommonMsgField().getUserId())));
            em8Var.b = new BotsDTO.BotListDTO.SkillDTO();
            if (textGenImageMsg.getSubSkillConfig() != null) {
                em8Var.b.setSubSkill(textGenImageMsg.getSubSkillConfig().a);
            }
            em8Var.d(true);
            return em8Var;
        }
        return (em8) invokeL.objValue;
    }

    public final void z0() {
        ChatRoomDetail chatRoomDetail;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (chatRoomDetail = this.y) != null && chatRoomDetail.getBots() != null && !ListUtils.isEmpty(this.y.getBots().getBotList())) {
            String string = SharedPrefHelper.getInstance().getString("key_show_bot_tip_list", "");
            List asList = Arrays.asList(string.split(","));
            List<BotsDTO.BotListDTO> botList = this.y.getBots().getBotList();
            for (int i2 = 0; i2 < botList.size(); i2++) {
                BotsDTO.BotListDTO botListDTO = botList.get(i2);
                if (botListDTO != null && botListDTO.getUser() != null && !TextUtils.isEmpty(botListDTO.getUser().getUk()) && !TextUtils.isEmpty(botListDTO.getAtGuide()) && !asList.contains(botListDTO.getUser().getUk()) && !TextUtils.equals(BIMManager.getBdUidFromBdUK(botListDTO.getUser().getUk()), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                    g1(botListDTO);
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
}
