package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.tieba.av7;
import com.baidu.tieba.aw7;
import com.baidu.tieba.bv7;
import com.baidu.tieba.cv7;
import com.baidu.tieba.dv7;
import com.baidu.tieba.ev7;
import com.baidu.tieba.fv7;
import com.baidu.tieba.gg;
import com.baidu.tieba.hi;
import com.baidu.tieba.hu7;
import com.baidu.tieba.i05;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.positionbubble.UpBubbleSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.CallRobotHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.InputBoxHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.JumpToHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.SendMsgHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ImageAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.NoticeModifyAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.RecallAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ShareForumAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ShareThreadAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.SingleTextImageAdapter;
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
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.NoticeModifySysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.RecallSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareForumSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareThreadSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.SingleTextImageMsg;
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
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.jg;
import com.baidu.tieba.k05;
import com.baidu.tieba.kv7;
import com.baidu.tieba.lv7;
import com.baidu.tieba.m35;
import com.baidu.tieba.mv7;
import com.baidu.tieba.n15;
import com.baidu.tieba.ng;
import com.baidu.tieba.nv7;
import com.baidu.tieba.nx7;
import com.baidu.tieba.pp5;
import com.baidu.tieba.pv7;
import com.baidu.tieba.qt7;
import com.baidu.tieba.qw7;
import com.baidu.tieba.rv7;
import com.baidu.tieba.rw7;
import com.baidu.tieba.sn;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.xu7;
import com.baidu.tieba.xv7;
import com.baidu.tieba.yt7;
import com.baidu.tieba.yu7;
import com.baidu.tieba.zv7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public class ChatPage extends Slice implements aw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yu7 A;
    @NonNull
    public final fv7 B;
    @NonNull
    public final SendMsgHandler C;
    public final CustomMessageListener D;
    public xu7 E;
    public final kv7<BaseMsg> F;
    public final lv7<BaseMsg> G;
    public final av7 H;
    public final bv7 I;
    public final GroupChatRepo.o<TreeSet<ChatMsg>> J;
    public Runnable K;
    public Runnable L;
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
    public ev7 q;
    public String r;
    public int s;
    public final GroupChatRepo.n<TreeSet<ChatMsg>> t;
    @Nullable
    public yt7 u;
    public boolean v;
    public d0 w;
    public GestureDetector x;
    @Nullable
    public ChatRoomDetail y;
    @Nullable
    public BotsDTO z;

    /* loaded from: classes4.dex */
    public class j implements qw7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final sn a;
        public final /* synthetic */ ChatPage b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ j c;

            /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage$j$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0294a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0294a(a aVar) {
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
                        this.a.c.b.J0();
                    }
                }
            }

            public a(j jVar, List list, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, list, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = jVar;
                this.a = list;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.b.w.b.updateData(this.a, true, BaseMsg.DIFF_ITEM_CALLBACK);
                    if (this.b) {
                        ng.c(new RunnableC0294a(this));
                    }
                }
            }
        }

        public j(ChatPage chatPage) {
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
            this.a = new sn(this.b.w.b);
        }

        @Override // com.baidu.tieba.qw7.h
        @MainThread
        public void a(long j, @NonNull List<BaseMsg> list, @NonNull qw7.i iVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), list, iVar}) != null) || this.b.k.a2()) {
                return;
            }
            boolean z = true;
            if (!iVar.a && (!iVar.c || this.b.w.b.getLastVisiblePosition() != this.b.w.b.getCount() - 1 || this.b.k())) {
                z = false;
            }
            this.a.e(new a(this, list, z));
        }
    }

    /* loaded from: classes4.dex */
    public class e0<Adapter extends BaseChatAdapter> extends c0<Adapter, BaseImageMsg<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* loaded from: classes4.dex */
        public class a implements zv7 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mv7.e a;
            public final /* synthetic */ BaseImageMsg b;
            public final /* synthetic */ e0 c;

            public a(e0 e0Var, mv7.e eVar, BaseImageMsg baseImageMsg) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e0Var, eVar, baseImageMsg};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = e0Var;
                this.a = eVar;
                this.b = baseImageMsg;
            }

            @Override // com.baidu.tieba.zv7
            public void a(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                    this.a.b();
                }
            }

            @Override // com.baidu.tieba.zv7
            public void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.c(i);
                }
            }

            @Override // com.baidu.tieba.zv7
            public void c(int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                    this.b.setThumbUrl(str2);
                    this.b.setBigSrc(str);
                    this.b.setSdkMsg(str2, str);
                    this.a.a();
                    if (this.c.d.y != null && this.c.d.y.getBasicInfo() != null) {
                        nx7.a("c15090", 2, this.c.d.y.getBasicInfo().getForumId(), this.c.d.y.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(ChatPage chatPage) {
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

        public /* synthetic */ e0(ChatPage chatPage, k kVar) {
            this(chatPage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mv7
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
        @Override // com.baidu.tieba.mv7
        /* renamed from: o */
        public void i(@NonNull BaseImageMsg<?> baseImageMsg, @NonNull mv7.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseImageMsg, eVar) == null) && this.d.k.k2() != null && !StringUtils.isNull(baseImageMsg.getThumbUrl())) {
                this.d.k.k2().u1(baseImageMsg.getThumbUrl(), new a(this, eVar, baseImageMsg));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends c0<BaseChatAdapter, VoiceMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* loaded from: classes4.dex */
        public class a implements xv7 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mv7.e a;
            public final /* synthetic */ VoiceMsg b;
            public final /* synthetic */ n c;

            public a(n nVar, mv7.e eVar, VoiceMsg voiceMsg) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, eVar, voiceMsg};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = nVar;
                this.a = eVar;
                this.b = voiceMsg;
            }

            @Override // com.baidu.tieba.xv7
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.b.setVoiceUrl(str);
                    this.a.a();
                    if (this.c.d.y != null && this.c.d.y.getBasicInfo() != null) {
                        nx7.a("c15090", 3, this.c.d.y.getBasicInfo().getForumId(), this.c.d.y.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }

            @Override // com.baidu.tieba.xv7
            public void isFailed() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.b();
                }
            }
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
            this.d = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mv7
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
        @Override // com.baidu.tieba.mv7
        /* renamed from: o */
        public void i(@NonNull VoiceMsg voiceMsg, @NonNull mv7.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceMsg, eVar) == null) && this.d.k.k2() != null && !StringUtils.isNull(voiceMsg.getPath())) {
                this.d.k.k2().v1(voiceMsg.getPath(), new a(this, eVar, voiceMsg));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z extends GroupChatRepo.o<TreeSet<ChatMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z a;

            public a(z zVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {zVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = zVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.T0();
                }
            }
        }

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
            this.b = chatPage;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.o
        public void f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.b.w.b.scrollToPosition(i);
                ng.c(new a(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void b(int i, @NonNull String str, @Nullable TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, treeSet) == null) {
                super.b(i, str, treeSet);
                this.b.Y0();
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.o
        public void g(@NonNull GroupChatRepo.FetchedEvent fetchedEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, fetchedEvent) == null) && t.a[fetchedEvent.ordinal()] == 1) {
                BdTopToast bdTopToast = new BdTopToast(this.b.k.getContext());
                bdTopToast.g(this.b.k.getContext().getString(R.string.obfuscated_res_0x7f0f08a5));
                bdTopToast.h(false);
                bdTopToast.i((ViewGroup) this.b.k.getView());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.w != null && this.a.w.b != null) {
                this.a.w.b.scrollBy(0, -TbadkCoreApplication.getInst().getKeyboardHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements GroupInputTool.f {
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
                        ng.c(this.a.K);
                    }
                    this.a.v = false;
                    this.a.k.r2(false);
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
                            ng.c(this.a.L);
                        }
                    }
                    this.a.k.q2(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.l.H();
                this.a.r0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.w != null && this.a.w.b != null) {
                this.a.w.b.scrollBy(0, TbadkCoreApplication.getInst().getKeyboardHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ChatPage chatPage, Context context) {
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

    /* loaded from: classes4.dex */
    public abstract class c0<Adapter extends BaseChatAdapter, Msg extends BaseMsg> extends mv7<Adapter, Msg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

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
            this.c = chatPage;
        }

        public /* synthetic */ c0(ChatPage chatPage, k kVar) {
            this(chatPage);
        }

        @Override // com.baidu.tieba.mv7
        public void k(BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, baseMsg, i, i2) == null) && this.c.A != null) {
                this.c.A.a(baseMsg, i, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.s {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.s
        public void onScrollToTop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.x(this.a.J);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BdTypeRecyclerView b;
        public rv7 c;
        public ImageView d;
        public LinearLayout e;
        public RelativeLayout f;
        public LinearLayout g;

        public d0() {
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

        public static d0 a(@NonNull View view2, @NonNull Fragment fragment) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, view2, fragment)) == null) {
                d0 d0Var = new d0();
                d0Var.a = view2;
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0906a0);
                d0Var.b = bdTypeRecyclerView;
                d0Var.c = new rv7(bdTypeRecyclerView);
                d0Var.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908e3);
                d0Var.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908e2);
                d0Var.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09069a);
                d0Var.f = (RelativeLayout) fragment.requireView().findViewById(R.id.obfuscated_res_0x7f091497);
                return d0Var;
            }
            return (d0) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.A(this.a.t);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (!this.a.w.b.canScrollVertically(1) && !this.a.l.G()) {
                    ChatPage chatPage = this.a;
                    chatPage.s = chatPage.w.b.getFirstVisiblePosition();
                    this.a.r0();
                }
                if (i2 < 0) {
                    this.a.T0();
                }
                if (this.a.E != null) {
                    this.a.E.a(this.a.w.b);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements GestureDetector.OnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) {
            }
        }

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

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                this.a.l0();
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (Math.abs(f - f2) > 1.0f) {
                    this.a.l0();
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return this.a.x.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnLayoutChangeListener {
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

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                int lastVisiblePosition = this.a.w.b.getLastVisiblePosition();
                int firstVisiblePosition = this.a.w.b.getFirstVisiblePosition();
                if (lastVisiblePosition != -1 && this.a.w.b.getCount() > 0 && this.a.w.b.getCount() - 1 == lastVisiblePosition) {
                    this.a.s = firstVisiblePosition;
                }
                if (this.a.E != null) {
                    this.a.E.b(this.a.w.b, this.a.l, this.a.J);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends GroupChatRepo.n<TreeSet<ChatMsg>> {
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
                this.b.Y0();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.b.w.c.f();
                this.b.X0();
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.n
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.J0();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.n
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.k0();
                this.b.q0().W();
                this.b.N0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends c0<TextAdapter, TextMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage d;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mv7
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage.c0, com.baidu.tieba.mv7
        public void k(BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseMsg, i, i2) == null) {
                super.k(baseMsg, i, i2);
                if (this.d.y != null && this.d.y.getBasicInfo() != null) {
                    long forumId = this.d.y.getBasicInfo().getForumId();
                    long id = this.d.y.getBasicInfo().getId();
                    if (i == 5) {
                        nx7.a("c15090", 1, forumId, id, TbadkCoreApplication.getCurrentAccount());
                        String text = ((TextMsg) baseMsg).getText();
                        if (this.d.n0() != null) {
                            this.d.n0().P(text, baseMsg.getCommonMsgField().getRoomId(), !baseMsg.isLeft());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements kv7<NoticeModifySysMsg> {
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
        @Override // com.baidu.tieba.kv7
        /* renamed from: b */
        public void a(@NonNull View view2, @NonNull NoticeModifySysMsg noticeModifySysMsg, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, noticeModifySysMsg, i) == null) && noticeModifySysMsg != null && noticeModifySysMsg.getChatroomInfo() != null && noticeModifySysMsg.getChatroomInfo().getNoticeUrl() != null) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.k.getContext(), null, noticeModifySysMsg.getChatroomInfo().getNoticeUrl(), true);
                tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends c0<BaseChatAdapter, ShareForumSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mv7
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

    /* loaded from: classes4.dex */
    public class p extends c0<BaseChatAdapter, ShareThreadSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mv7
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

    /* loaded from: classes4.dex */
    public class q extends c0<SingleTextImageAdapter<SingleTextImageMsg>, SingleTextImageMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mv7
        /* renamed from: o */
        public boolean j(@NonNull SingleTextImageMsg singleTextImageMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, singleTextImageMsg)) == null) {
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

    /* loaded from: classes4.dex */
    public class r extends c0<ev7, TextGenImageMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mv7
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

    /* loaded from: classes4.dex */
    public class s implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nv7 b;
        public final /* synthetic */ BaseMsg c;
        public final /* synthetic */ int d;
        public final /* synthetic */ i05 e;

        public s(ChatPage chatPage, String str, nv7 nv7Var, BaseMsg baseMsg, int i, i05 i05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, str, nv7Var, baseMsg, Integer.valueOf(i), i05Var};
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
            this.b = nv7Var;
            this.c = baseMsg;
            this.d = i;
            this.e = i05Var;
        }

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, k05Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            if (TextUtils.equals(((TextView) view2).getText().toString(), this.a)) {
                this.b.a().m(this.c, this.d);
            }
            this.e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class t {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2023297034, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage$t;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2023297034, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage$t;");
                    return;
                }
            }
            int[] iArr = new int[GroupChatRepo.FetchedEvent.values().length];
            a = iArr;
            try {
                iArr[GroupChatRepo.FetchedEvent.TARGET_MSG_NOT_EXIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.G0()) {
                return;
            }
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                if ((map.get("sub_skill_config_type") instanceof Integer) && (map.get("text_gen_image_msg") instanceof TextGenImageMsg)) {
                    int intValue = ((Integer) map.get("sub_skill_config_type")).intValue();
                    TextGenImageMsg textGenImageMsg = (TextGenImageMsg) map.get("text_gen_image_msg");
                    if (this.a.k.k2() != null) {
                        GroupInputViewController k2 = this.a.k.k2();
                        k2.k1(intValue, textGenImageMsg, this.a.j0(textGenImageMsg));
                        k2.Z0(GroupInputViewController.SourceType.TWO, true, true);
                        this.a.k.r2(false);
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
                            this.a.r = skillDTO.getName();
                        }
                    }
                }
                TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 3).param("fid", forumId).param("fname", forumName).param("room_id", id).param("obj_name", this.a.r).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements kv7<BaseMsg> {
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

        @Override // com.baidu.tieba.kv7
        public void a(@NonNull View view2, @NonNull BaseMsg baseMsg, int i) {
            ReMsgInfo reMsgInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, view2, baseMsg, i) == null) {
                if (view2.getId() == R.id.btn_msgitem_resend) {
                    nv7 b = nv7.b(view2);
                    if (b == null) {
                        return;
                    }
                    this.a.V0(b, baseMsg, i);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e34 && (reMsgInfo = baseMsg.getReMsgInfo()) != null) {
                    this.a.l.J(reMsgInfo.getMsgId(), reMsgInfo.getMsgKey(), this.a.J);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements lv7<BaseMsg> {
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

        @Override // com.baidu.tieba.lv7
        public boolean a(@NonNull View view2, @NonNull BaseMsg baseMsg, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, view2, baseMsg, i)) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f09076e || id == R.id.obfuscated_res_0x7f090e3b || id == R.id.obfuscated_res_0x7f090e1c || id == R.id.obfuscated_res_0x7f090e40 || id == R.id.obfuscated_res_0x7f090e37 || id == R.id.obfuscated_res_0x7f090e38 || id == R.id.obfuscated_res_0x7f090e34) {
                    this.a.U0(baseMsg);
                    this.a.l0();
                    return false;
                }
                return false;
            }
            return invokeLLI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class x implements av7 {
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

        @Override // com.baidu.tieba.av7
        public void a(@NonNull UserReplyInfoData userReplyInfoData, @NonNull BaseMsg baseMsg) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userReplyInfoData, baseMsg) == null) && this.a.k.k2() != null) {
                this.a.k.k2().L0(userReplyInfoData, baseMsg);
                this.a.k.k2().W(userReplyInfoData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements bv7 {
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

        @Override // com.baidu.tieba.bv7
        public void a(@NonNull AbilityItem abilityItem, @NonNull BaseMsg baseMsg) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, abilityItem, baseMsg) == null) && this.a.B != null) {
                this.a.B.c(abilityItem, baseMsg);
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
        this.s = -1;
        this.t = new k(this);
        this.v = true;
        this.B = new fv7();
        this.D = new u(this, 2921782);
        this.F = new v(this);
        this.G = new w(this);
        this.H = new x(this);
        this.I = new y(this);
        this.J = new z(this);
        this.K = new b0(this);
        this.L = new a(this);
        this.j = groupChatFragment.getPageContext();
        this.k = groupChatFragment;
        this.l = groupChatRepo;
        groupChatRepo.T(this.t);
        this.C = new SendMsgHandler(groupChatRepo, this);
    }

    @NonNull
    public List<AtUserInfo> H0(List<AtSelectData> list, Map<String, Integer> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, list, map)) == null) {
            if (!ListUtils.isEmpty(list) && !map.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (AtSelectData atSelectData : list) {
                    AtUserInfo.AtType atType = AtUserInfo.AtType.USER;
                    if (AtSelectData.AT_ALL_FAKE_UID.equals(atSelectData.getUid())) {
                        atType = AtUserInfo.AtType.ALL;
                    }
                    arrayList.add(AtUserInfo.create(atType, gg.g(atSelectData.getUid(), 0L), atSelectData.getNameShow(), atSelectData.getPortrait(), map.get(atSelectData.getUid()).intValue()));
                }
                return arrayList;
            }
            return Collections.emptyList();
        }
        return (List) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void D(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) {
            super.D(z2);
            if (!z2) {
                X0();
            }
        }
    }

    public void L0(xu7 xu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, xu7Var) == null) {
            this.E = xu7Var;
        }
    }

    public void P0(yu7 yu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, yu7Var) == null) {
            this.A = yu7Var;
        }
    }

    public void U0(@NonNull BaseMsg baseMsg) {
        ChatRoomDetail chatRoomDetail;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, baseMsg) != null) || (chatRoomDetail = this.y) == null) {
            return;
        }
        this.u = qt7.c(this.j, baseMsg, chatRoomDetail, this.H, this.I);
    }

    public void W0(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            Context requireContext = this.k.requireContext();
            BdTopToast bdTopToast = new BdTopToast(requireContext);
            bdTopToast.g(requireContext.getString(i2));
            bdTopToast.h(false);
            bdTopToast.i((ViewGroup) this.k.getView());
        }
    }

    public void Q0(@NonNull String str, int i2, GroupInputViewController.SourceType sourceType, @Nullable BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048594, this, str, i2, sourceType, baseMsg) == null) {
            R0(str, i2, sourceType, baseMsg, false, false, false);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void E(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, bundle) == null) {
            super.E(view2, bundle);
            pp5.b(view2);
            this.w = d0.a(view2, this.b);
            E0();
        }
    }

    @Override // com.baidu.tieba.aw7
    public void b(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, str, i2) == null) {
            this.l.R(VoiceMsg.create(str, i2));
        }
    }

    @Override // com.baidu.tieba.aw7
    public void d(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, str2) == null) {
            this.l.R(ImageMsg.create(str, str2));
        }
    }

    @NonNull
    public final TextAdapter A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.l.O(1, TextMsg.class);
            this.C.e(1, TextMsg.class);
            TextAdapter textAdapter = new TextAdapter(this.j, TextMsg.ADAPTER_TYPE);
            textAdapter.D(new l(this));
            textAdapter.A(this.F, null);
            textAdapter.B(this.G, null);
            textAdapter.z(this.B);
            return textAdapter;
        }
        return (TextAdapter) invokeV.objValue;
    }

    public final void S0() {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (groupChatFragment = this.k) != null && groupChatFragment.getContext() != null) {
            BdTopToast bdTopToast = new BdTopToast(this.k.getContext());
            bdTopToast.g(this.k.getContext().getString(R.string.obfuscated_res_0x7f0f0863));
            bdTopToast.h(false);
            bdTopToast.i((ViewGroup) this.k.getView());
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int lastVisiblePosition = this.w.b.getLastVisiblePosition();
            GroupChatFragment groupChatFragment = this.k;
            if ((groupChatFragment == null || groupChatFragment.e2() == null || this.k.e2().D() == null || this.k.e2().D().getHeight() <= 0) && lastVisiblePosition < this.s) {
                t0();
            }
        }
    }

    @NonNull
    public final ImageAdapter s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            this.l.O(4, BigEmotionMsg.class);
            this.C.e(4, BigEmotionMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.j, BigEmotionMsg.ADAPTER_TYPE);
            imageAdapter.A(this.F, null);
            imageAdapter.B(this.G, null);
            imageAdapter.z(this.B);
            imageAdapter.D(new e0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final ImageAdapter u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            this.l.O(2, ImageMsg.class);
            this.C.e(2, ImageMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.j, ImageMsg.ADAPTER_TYPE);
            imageAdapter.A(this.F, null);
            imageAdapter.B(this.G, null);
            imageAdapter.z(this.B);
            imageAdapter.D(new e0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final NoticeModifyAdapter v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            this.l.O(7001, NoticeModifySysMsg.class);
            NoticeModifyAdapter noticeModifyAdapter = new NoticeModifyAdapter(this.j, NoticeModifySysMsg.ADAPTER_TYPE);
            this.o = noticeModifyAdapter;
            noticeModifyAdapter.A(null, new m(this));
            return this.o;
        }
        return (NoticeModifyAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareForumAdapter x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            this.l.O(7009, ShareForumSysMsg.class);
            ShareForumAdapter shareForumAdapter = new ShareForumAdapter(this.j, ShareForumSysMsg.ADAPTER_TYPE);
            shareForumAdapter.B(this.G, null);
            shareForumAdapter.D(new o(this));
            return shareForumAdapter;
        }
        return (ShareForumAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareThreadAdapter y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            this.l.O(7010, ShareThreadSysMsg.class);
            ShareThreadAdapter shareThreadAdapter = new ShareThreadAdapter(this.j, ShareThreadSysMsg.ADAPTER_TYPE);
            shareThreadAdapter.B(this.G, null);
            shareThreadAdapter.D(new p(this));
            return shareThreadAdapter;
        }
        return (ShareThreadAdapter) invokeV.objValue;
    }

    @NonNull
    public final ev7 B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.l.O(101, TextGenImageMsg.class);
            this.l.O(7014, TextGenImageUpdateSysMsg.class);
            ev7 ev7Var = new ev7(this.j, TextGenImageMsg.ADAPTER_TYPE);
            this.q = ev7Var;
            ev7Var.A(this.F, null);
            this.q.B(this.G, null);
            this.q.z(this.B);
            this.q.D(new r(this));
            return this.q;
        }
        return (ev7) invokeV.objValue;
    }

    @NonNull
    public final VoiceAdapter F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.l.O(3, VoiceMsg.class);
            this.C.e(3, VoiceMsg.class);
            VoiceAdapter voiceAdapter = new VoiceAdapter(this.j, VoiceMsg.ADAPTER_TYPE);
            voiceAdapter.A(this.F, null);
            voiceAdapter.B(this.G, null);
            voiceAdapter.z(this.B);
            GroupChatFragment groupChatFragment = this.k;
            if (groupChatFragment != null && groupChatFragment.k2() != null) {
                voiceAdapter.Y(this.k.k2().s0());
            }
            voiceAdapter.D(new n(this));
            return voiceAdapter;
        }
        return (VoiceAdapter) invokeV.objValue;
    }

    public boolean G0() {
        InterceptResult invokeV;
        rw7 f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.k.k2() == null || (f2 = this.k.k2().r0().f()) == null) {
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

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int lastVisiblePosition = this.w.b.getLastVisiblePosition();
            int firstVisiblePosition = this.w.b.getFirstVisiblePosition();
            if (lastVisiblePosition != -1 && this.w.b.getCount() > 0 && this.w.b.getCount() - 1 == lastVisiblePosition) {
                this.s = firstVisiblePosition;
            }
            RecyclerView.LayoutManager layoutManager = this.w.b.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(this.w.b.getCount() - 1, 0);
            }
        }
    }

    @NonNull
    public final SingleTextImageAdapter<SingleTextImageMsg> z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            this.l.O(102, SingleTextImageMsg.class);
            SingleTextImageAdapter<SingleTextImageMsg> singleTextImageAdapter = new SingleTextImageAdapter<>(this.j, SingleTextImageMsg.ADAPTER_TYPE);
            this.p = singleTextImageAdapter;
            singleTextImageAdapter.A(this.F, null);
            this.p.B(this.G, null);
            this.p.z(this.B);
            this.p.D(new q(this));
            return this.p;
        }
        return (SingleTextImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final TimestampAdapter C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.l.O(-7013, TimestampSysMsg.class);
            return new TimestampAdapter(this.j, TimestampSysMsg.ADAPTER_TYPE);
        }
        return (TimestampAdapter) invokeV.objValue;
    }

    @NonNull
    public final TipsAdapter D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.l.P(TipsSysMsg.MSG_TYPE_LIST, TipsSysMsg.class);
            TipsAdapter tipsAdapter = new TipsAdapter(this.j, TipsSysMsg.ADAPTER_TYPE);
            this.m = tipsAdapter;
            return tipsAdapter;
        }
        return (TipsAdapter) invokeV.objValue;
    }

    @NonNull
    public fv7 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.B;
        }
        return (fv7) invokeV.objValue;
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ChatRoomDetail chatRoomDetail = this.y;
            if (chatRoomDetail != null && chatRoomDetail.getQuickTalk() != null) {
                this.k.r2(true);
            } else {
                this.k.r2(false);
            }
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.k.k2() != null) {
            this.k.k2().c1(new a0(this));
        }
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.w.b.canScrollVertically(1)) {
            t0();
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && !BdNetTypeUtil.isNetWorkAvailable()) {
            hi.M(this.k.requireContext(), R.string.obfuscated_res_0x7f0f0d1f);
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.k.k2() != null) {
            GroupInputViewController k2 = this.k.k2();
            if (k2.Z()) {
                k2.u0();
            }
        }
    }

    @Nullable
    public EffectSlice n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.k.l2();
        }
        return (EffectSlice) invokeV.objValue;
    }

    @NonNull
    public GroupChatFragment o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.k;
        }
        return (GroupChatFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDestroy();
            if (this.K != null) {
                jg.a().removeCallbacks(this.K);
            }
            if (this.L != null) {
                jg.a().removeCallbacks(this.L);
            }
        }
    }

    @Nullable
    public yt7 p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.u;
        }
        return (yt7) invokeV.objValue;
    }

    @Nullable
    public UpBubbleSlice q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.k.n2();
        }
        return (UpBubbleSlice) invokeV.objValue;
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && this.w.e.getVisibility() == 0) {
            this.w.e.setVisibility(8);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.w.e.getVisibility() != 0) {
            this.w.e.setVisibility(0);
            this.w.e.setOnClickListener(new b(this));
        }
    }

    @NonNull
    public final RecallAdapter w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            this.l.P(RecallSysMsg.MSG_TYPE_LIST, RecallSysMsg.class);
            RecallAdapter recallAdapter = new RecallAdapter(this.j, RecallSysMsg.ADAPTER_TYPE);
            this.n = recallAdapter;
            return recallAdapter;
        }
        return (RecallAdapter) invokeV.objValue;
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.B.a(this.C);
            this.B.a(new CallRobotHandler(this));
            this.B.a(new JumpToHandler(this.j));
            this.B.a(new InputBoxHandler(this));
            this.B.a(new cv7());
            this.B.a(new dv7(this));
            ArrayList arrayList = new ArrayList();
            arrayList.add(A0());
            arrayList.add(v0());
            arrayList.add(C0());
            arrayList.add(D0());
            arrayList.add(w0());
            arrayList.add(F0());
            arrayList.add(u0());
            arrayList.add(x0());
            arrayList.add(y0());
            arrayList.add(s0());
            arrayList.add(z0());
            arrayList.add(B0());
            this.w.b.addAdapters(arrayList);
            this.w.b.setLayoutManager(new c(this, this.k.getContext()));
            this.w.b.setOnScrollToTopListener(new d(this));
            this.w.b.setOnSrollToBottomListener(new e(this));
            this.w.b.addOnScrollListener(new f(this));
            this.x = new GestureDetector(this.k.getContext(), new g(this));
            this.w.b.setRecyclerViewTouchListener(new h(this));
            this.w.b.addOnLayoutChangeListener(new i(this));
            this.l.U(new j(this));
            this.k.registerListener(this.D);
        }
    }

    public final void k0() {
        ChatRoomDetail chatRoomDetail;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (chatRoomDetail = this.y) != null && chatRoomDetail.getBots() != null && !ListUtils.isEmpty(this.y.getBots().getBotList())) {
            String s2 = m35.m().s("key_show_bot_tip_list", "");
            List asList = Arrays.asList(s2.split(","));
            List<BotsDTO.BotListDTO> botList = this.y.getBots().getBotList();
            for (int i2 = 0; i2 < botList.size(); i2++) {
                BotsDTO.BotListDTO botListDTO = botList.get(i2);
                if (botListDTO != null && botListDTO.getUser() != null && !TextUtils.isEmpty(botListDTO.getUser().getUk()) && !asList.contains(botListDTO.getUser().getUk()) && !TextUtils.equals(BIMManager.getBdUidFromBdUK(botListDTO.getUser().getUk()), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                    K0(botListDTO);
                    if (TextUtils.isEmpty(s2)) {
                        str = botListDTO.getUser().getUk();
                    } else {
                        str = s2 + "," + botListDTO.getUser().getUk();
                    }
                    m35.m().B("key_show_bot_tip_list", str);
                    return;
                }
            }
        }
    }

    public final void K0(BotsDTO.BotListDTO botListDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, botListDTO) == null) {
            if (botListDTO != null && botListDTO.getUser() != null) {
                BotsDTO.BotListDTO.UserDTO user = botListDTO.getUser();
                TextMsg create = TextMsg.create("@" + TbadkCoreApplication.getCurrentAccountNameShow() + " " + botListDTO.getAtGuide());
                create.setMockSenderInfo(gg.g(BIMManager.getBdUidFromBdUK(user.getUk()), 0L), user.getNameShow(), user.getPortrait(), 64, user.getRobotRole(), user.getForumLevel());
                AtUserInfo.AtType atType = AtUserInfo.AtType.USER;
                long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
                create.addAtUserInfo(AtUserInfo.create(atType, currentAccountId, "@" + TbadkCoreApplication.getCurrentAccountNameShow(), TbadkCoreApplication.getCurrentPortrait(), 0));
                create.setRobotGuideMsg(true);
                this.l.R(create);
            }
        }
    }

    public void M0(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, chatRoomDetail) == null) {
            this.y = chatRoomDetail;
            this.z = chatRoomDetail.getBots();
            this.B.d(chatRoomDetail.getBasicInfo().getId());
            this.m.L(chatRoomDetail.getBasicInfo().getForumId());
            this.m.M(chatRoomDetail.getBasicInfo().getId());
            this.o.L(chatRoomDetail.getBasicInfo().getForumId());
            this.o.M(chatRoomDetail.getBasicInfo().getId());
            this.n.L(chatRoomDetail.getBasicInfo().getForumId());
            this.n.M(chatRoomDetail.getBasicInfo().getId());
            this.p.a(chatRoomDetail.getBasicInfo().getForumName());
            this.q.a(chatRoomDetail.getBasicInfo().getForumName());
        }
    }

    @NonNull
    public final hu7 j0(@NonNull TextGenImageMsg textGenImageMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, textGenImageMsg)) == null) {
            hu7 hu7Var = new hu7();
            BotsDTO.BotListDTO.UserDTO userDTO = new BotsDTO.BotListDTO.UserDTO();
            hu7Var.a = userDTO;
            userDTO.setName(textGenImageMsg.getCommonMsgField().getUserName());
            hu7Var.a.setNameShow(textGenImageMsg.getCommonMsgField().getUserName());
            hu7Var.a.setPortrait(textGenImageMsg.getCommonMsgField().getPortrait());
            hu7Var.a.setUk(BIMManager.getBdUKFromBdUid(String.valueOf(textGenImageMsg.getCommonMsgField().getUserId())));
            hu7Var.b = new BotsDTO.BotListDTO.SkillDTO();
            if (textGenImageMsg.getSubSkillConfig() != null) {
                hu7Var.b.setSubSkill(textGenImageMsg.getSubSkillConfig().a);
            }
            hu7Var.c(true);
            return hu7Var;
        }
        return (hu7) invokeL.objValue;
    }

    public void R0(@NonNull String str, int i2, GroupInputViewController.SourceType sourceType, @Nullable BaseMsg baseMsg, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i2), sourceType, baseMsg, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) != null) || G0()) {
            return;
        }
        if (this.z == null) {
            S0();
            return;
        }
        new ArrayList();
        boolean z5 = true;
        for (BotsDTO.BotListDTO botListDTO : this.z.getBotList()) {
            if (botListDTO != null && botListDTO.getUser() != null) {
                if (str.equals(botListDTO.getUser().getUk())) {
                    BotsDTO.BotListDTO.UserDTO user = botListDTO.getUser();
                    if (botListDTO.getSkill() != null) {
                        for (BotsDTO.BotListDTO.SkillDTO skillDTO : botListDTO.getSkill()) {
                            if (i2 == skillDTO.getType()) {
                                List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> items = skillDTO.getItems();
                                GroupInputViewController k2 = this.k.k2();
                                if (k2 != null) {
                                    k2.R0(baseMsg, user, skillDTO, items, z2);
                                    this.k.k2().Z0(sourceType, true, z4);
                                    z5 = false;
                                    if (z3 && baseMsg != null) {
                                        CommonMsgField commonMsgField = baseMsg.getCommonMsgField();
                                        k2.V(new AtSelectData(commonMsgField.getPortrait(), commonMsgField.getUserName(), String.valueOf(commonMsgField.getUserId()), commonMsgField.isRobot()), true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (z5) {
            S0();
        }
    }

    public final void V0(@NonNull nv7 nv7Var, @NonNull BaseMsg baseMsg, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, nv7Var, baseMsg, i2) == null) {
            i05 i05Var = new i05(this.j);
            String string = this.j.getString(R.string.msg_resend);
            i05Var.i(null, new String[]{string}, new s(this, string, nv7Var, baseMsg, i2, i05Var));
            i05Var.k();
        }
    }

    @Override // com.baidu.tieba.aw7
    public void a(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, str, str2, map) == null) {
            this.l.R(BigEmotionMsg.create(str, str2, map));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @Nullable
    public View u(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048620, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0839, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.aw7
    public void c(@NonNull String str, @Nullable Object obj, @Nullable hu7 hu7Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map, int i2) {
        BaseMsg baseMsg;
        TextMsg e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{str, obj, hu7Var, list, map, Integer.valueOf(i2)}) == null) {
            if (obj instanceof BaseMsg) {
                baseMsg = (BaseMsg) obj;
            } else {
                baseMsg = null;
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2 && i2 != 3) {
                        e2 = TextMsg.create(str);
                    }
                } else {
                    e2 = TextMsg.create(str);
                    if (baseMsg != null) {
                        e2.setReMsgInfo(ReMsgInfo.create(baseMsg, ((Object) baseMsg.getReplyPrefix()) + baseMsg.getThumbnailText().toString()));
                    }
                }
                e2.addAtUserInfo(H0(list, map));
                this.l.R(e2);
            }
            e2 = pv7.e(str, baseMsg, hu7Var);
            map = m0(e2.getText(), list, map);
            e2.addAtUserInfo(H0(list, map));
            this.l.R(e2);
        }
    }

    @Nullable
    public final Map<String, Integer> m0(@NonNull String str, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, str, list, map)) == null) {
            if (list != null && map != null) {
                HashMap hashMap = new HashMap(map);
                for (AtSelectData atSelectData : list) {
                    int indexOf = str.indexOf("@" + atSelectData.getNameShow());
                    if (indexOf >= 0) {
                        hashMap.put(atSelectData.getUid(), Integer.valueOf(indexOf));
                    }
                }
                return hashMap;
            }
            return null;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            super.q(i2);
            this.w.c.h(i2);
            RecyclerView.Adapter adapter = this.w.b.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            n15 d2 = n15.d(this.w.e);
            d2.o(R.string.J_X01);
            d2.f(R.color.CAM_X0207);
            this.w.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.down_positioning_bubble_icon, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            qt7.b(i2);
        }
    }
}
