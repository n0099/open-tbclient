package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.RecyclerViewTypeAdapter;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.tieba.bh;
import com.baidu.tieba.cx4;
import com.baidu.tieba.cz4;
import com.baidu.tieba.dl7;
import com.baidu.tieba.el7;
import com.baidu.tieba.fh;
import com.baidu.tieba.fl7;
import com.baidu.tieba.fw4;
import com.baidu.tieba.gl7;
import com.baidu.tieba.hw4;
import com.baidu.tieba.il7;
import com.baidu.tieba.imMessageCenter.chatgroup.data.AtInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.data.AtInfoMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter.ImageAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter.ManagerTipsAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter.NoticeModifyAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter.RecallAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter.ShareForumAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter.ShareThreadAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter.TextAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter.TextGenImageAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter.TimestampAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter.VoiceAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.AtUserInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.BigEmotionMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.ManagerTipsSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.NoticeModifySysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.RecallSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.ShareForumSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.ShareThreadSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageUpdateSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TimestampSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.VoiceMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputTool;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.jk7;
import com.baidu.tieba.kl7;
import com.baidu.tieba.ko;
import com.baidu.tieba.nl7;
import com.baidu.tieba.tl7;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.xk7;
import com.baidu.tieba.yg;
import com.baidu.tieba.yn;
import com.baidu.tieba.zi;
import com.baidu.tieba.zl7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public class ChatPage implements LifecycleObserver, GroupInputViewController.t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> a;
    @NonNull
    public final GroupChatFragment b;
    @NonNull
    public final GroupChatRepo c;
    public ManagerTipsAdapter d;
    public RecallAdapter e;
    public NoticeModifyAdapter f;
    public TextGenImageAdapter g;
    public String h;
    public final CustomMessageListener i;
    public int j;
    public LinearLayoutManager k;
    public boolean l;
    public long m;
    public String n;
    public boolean o;
    public final GroupChatRepo.n<TreeSet<ChatMsg>> p;
    public z q;
    @Nullable
    public ChatRoomDetail r;
    public final dl7<BaseMsg> s;
    public final el7<BaseMsg> t;
    public final GroupChatRepo.o<TreeSet<ChatMsg>> u;
    public boolean v;
    public final CustomMessageListener w;
    public Runnable x;
    public Runnable y;

    /* loaded from: classes4.dex */
    public class h implements tl7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ko a;
        public final /* synthetic */ ChatPage b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ h c;

            /* renamed from: com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.ChatPage$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0319a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0319a(a aVar) {
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
                        this.a.c.b.k0();
                    }
                }
            }

            public a(h hVar, List list, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, list, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = hVar;
                this.a = list;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.b.q.b.I(this.a, true, BaseMsg.DIFF_ITEM_CALLBACK);
                    if (this.b) {
                        fh.c(new RunnableC0319a(this));
                    }
                }
            }
        }

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
            this.b = chatPage;
            this.a = new ko(this.b.q.b);
        }

        @Override // com.baidu.tieba.tl7.h
        @MainThread
        public void a(long j, @NonNull List<BaseMsg> list, @NonNull tl7.i iVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), list, iVar}) != null) || this.b.b.T1()) {
                return;
            }
            boolean z = true;
            if (!iVar.a && (!iVar.c || this.b.q.b.getLastVisiblePosition() != this.b.q.b.getCount() - 1 || this.b.v)) {
                z = false;
            }
            this.a.e(new a(this, list, z));
        }
    }

    /* loaded from: classes4.dex */
    public class a0<Adapter extends BaseChatAdapter> extends fl7<Adapter, BaseImageMsg<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

        /* loaded from: classes4.dex */
        public class a implements GroupInputViewController.u {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fl7.e a;
            public final /* synthetic */ BaseImageMsg b;
            public final /* synthetic */ a0 c;

            public a(a0 a0Var, fl7.e eVar, BaseImageMsg baseImageMsg) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a0Var, eVar, baseImageMsg};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = a0Var;
                this.a = eVar;
                this.b = baseImageMsg;
            }

            @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController.u
            public void a(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                    this.a.b();
                }
            }

            @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController.u
            public void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.c(i);
                }
            }

            @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController.u
            public void c(int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                    this.b.setThumbUrl(str2);
                    this.b.setBigSrc(str);
                    this.b.setSdkMsg(str2, str);
                    this.a.a();
                    if (this.c.c.r != null && this.c.c.r.getBasicInfo() != null) {
                        long forumId = this.c.c.r.getBasicInfo().getForumId();
                        TiebaStatic.log(new StatisticItem("c15090").param("obj_type", 2).param("fid", forumId).param("room_id", this.c.c.r.getBasicInfo().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
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
            this.c = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fl7
        /* renamed from: p */
        public boolean j(@NonNull BaseImageMsg<?> baseImageMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, baseImageMsg)) == null) {
                return baseImageMsg.isInvalidAddress();
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ a0(ChatPage chatPage, j jVar) {
            this(chatPage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fl7
        /* renamed from: o */
        public void i(@NonNull BaseImageMsg<?> baseImageMsg, @NonNull fl7.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseImageMsg, eVar) == null) && this.c.b.Z1() != null) {
                this.c.b.Z1().S0(baseImageMsg, new a(this, eVar, baseImageMsg));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends fl7<BaseChatAdapter, VoiceMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

        /* loaded from: classes4.dex */
        public class a implements nl7 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fl7.e a;
            public final /* synthetic */ l b;

            public a(l lVar, fl7.e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = lVar;
                this.a = eVar;
            }

            @Override // com.baidu.tieba.nl7
            public void a(BaseMsg baseMsg, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, baseMsg, str) == null) {
                    if (baseMsg instanceof VoiceMsg) {
                        ((VoiceMsg) baseMsg).setVoiceUrl(str);
                    }
                    this.a.a();
                    if (this.b.c.r != null && this.b.c.r.getBasicInfo() != null) {
                        long forumId = this.b.c.r.getBasicInfo().getForumId();
                        TiebaStatic.log(new StatisticItem("c15090").param("obj_type", 3).param("fid", forumId).param("room_id", this.b.c.r.getBasicInfo().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                }
            }

            @Override // com.baidu.tieba.nl7
            public void isFailed() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.b();
                }
            }
        }

        public l(ChatPage chatPage) {
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
        @Override // com.baidu.tieba.fl7
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
        @Override // com.baidu.tieba.fl7
        /* renamed from: o */
        public void i(@NonNull VoiceMsg voiceMsg, @NonNull fl7.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceMsg, eVar) == null) && this.c.b.Z1() != null) {
                this.c.b.Z1().T0(voiceMsg, new a(this, eVar));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u extends GroupChatRepo.o<TreeSet<ChatMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ u a;

            public a(u uVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {uVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = uVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.n0();
                }
            }
        }

        public u(ChatPage chatPage) {
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

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.GroupChatRepo.o
        public void f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.b.q.b.scrollToPosition(i);
                fh.c(new a(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void b(int i, @NonNull String str, @Nullable TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048580, this, i, str, treeSet) == null) {
                super.b(i, str, treeSet);
                this.b.r0();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.b.q.c.g();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.b.q.c.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c.E(this.a.m, this.a.n, this.a.u);
                this.a.p0();
                this.a.T();
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
                this.a.c.D();
                this.a.Q();
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
                this.a.c.t(this.a.u);
            }
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
                this.a.c.u(this.a.p);
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
                if (!this.a.q.b.canScrollVertically(1) && !this.a.c.B()) {
                    ChatPage chatPage = this.a;
                    chatPage.j = chatPage.q.b.getFirstVisiblePosition();
                    this.a.Q();
                }
                if (i2 < 0) {
                    this.a.n0();
                }
                int firstVisiblePosition = this.a.q.b.getFirstVisiblePosition();
                List<yn> data = ((RecyclerViewTypeAdapter) this.a.q.b.getWrappedAdapter()).getData();
                if ((ListUtils.getItem(data, firstVisiblePosition) instanceof BaseMsg) && ((BaseMsg) ListUtils.getItem(data, firstVisiblePosition)).getCommonMsgField().getMsgId() == this.a.m && this.a.q.f.getVisibility() == 0) {
                    this.a.p0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnLayoutChangeListener {
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

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                int lastVisiblePosition = this.a.q.b.getLastVisiblePosition();
                int firstVisiblePosition = this.a.q.b.getFirstVisiblePosition();
                if (lastVisiblePosition != -1 && this.a.q.b.getCount() > 0 && this.a.q.b.getCount() - 1 == lastVisiblePosition) {
                    this.a.j = firstVisiblePosition;
                }
                if (this.a.l) {
                    ArrayList arrayList = new ArrayList();
                    List<yn> data = ((RecyclerViewTypeAdapter) this.a.q.b.getWrappedAdapter()).getData();
                    if (data.size() > 0 && firstVisiblePosition != -1 && lastVisiblePosition != -1) {
                        while (firstVisiblePosition <= lastVisiblePosition) {
                            yn ynVar = data.get(firstVisiblePosition);
                            if (ynVar instanceof TextMsg) {
                                long msgId = ((TextMsg) ynVar).getCommonMsgField().getMsgId();
                                if (this.a.r != null && this.a.r.getAtInfo() != null) {
                                    if (this.a.r.getAtInfo().getAllMsgList() != null) {
                                        for (AtInfoMsg atInfoMsg : this.a.r.getAtInfo().getAllMsgList()) {
                                            if (atInfoMsg != null && msgId == atInfoMsg.getMsgId()) {
                                                arrayList.add(atInfoMsg);
                                            }
                                        }
                                    }
                                    if (this.a.r.getAtInfo().getSingleMsgList() != null) {
                                        for (AtInfoMsg atInfoMsg2 : this.a.r.getAtInfo().getSingleMsgList()) {
                                            if (atInfoMsg2 != null && msgId == atInfoMsg2.getMsgId()) {
                                                arrayList.add(atInfoMsg2);
                                            }
                                        }
                                    }
                                }
                            }
                            firstVisiblePosition++;
                        }
                        if (arrayList.isEmpty()) {
                            this.a.e0();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends fl7<TextAdapter, TextMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fl7
        /* renamed from: o */
        public boolean j(@NonNull TextMsg textMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, textMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
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
            this.c = chatPage;
        }

        @Override // com.baidu.tieba.fl7
        public void k(BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseMsg, i, i2) == null) {
                super.k(baseMsg, i, i2);
                if (this.c.r != null && this.c.r.getBasicInfo() != null) {
                    long forumId = this.c.r.getBasicInfo().getForumId();
                    long id = this.c.r.getBasicInfo().getId();
                    if (i == 5) {
                        TiebaStatic.log(new StatisticItem("c15090").param("obj_type", 1).param("fid", forumId).param("room_id", id).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.g0()) {
                return;
            }
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof zl7)) {
                zl7 zl7Var = (zl7) customResponsedMessage.getData();
                if (this.a.b.Z1() != null) {
                    GroupInputViewController Z1 = this.a.b.Z1();
                    Z1.J0(zl7Var.c(), zl7Var.b());
                    Z1.y0(GroupInputViewController.SourceType.TWO, true);
                }
            }
            if (this.a.r != null && this.a.r.getBasicInfo() != null && this.a.r.getBots() != null && this.a.r.getBots().getBotList() != null) {
                long forumId = this.a.r.getBasicInfo().getForumId();
                String forumName = this.a.r.getBasicInfo().getForumName();
                long id = this.a.r.getBasicInfo().getId();
                for (BotsDTO.BotListDTO botListDTO : this.a.r.getBots().getBotList()) {
                    if (botListDTO != null && !ListUtils.isEmpty(botListDTO.getSkill())) {
                        for (BotsDTO.BotListDTO.SkillDTO skillDTO : botListDTO.getSkill()) {
                            this.a.h = skillDTO.getName();
                        }
                    }
                }
                TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 3).param("fid", forumId).param("fname", forumName).param("room_id", id).param("obj_name", this.a.h).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements dl7<NoticeModifySysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

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
            this.a = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl7
        /* renamed from: b */
        public void a(@NonNull View view2, @NonNull NoticeModifySysMsg noticeModifySysMsg, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, noticeModifySysMsg, i) == null) && this.a.r != null && this.a.r.getBasicInfo() != null) {
                long id = this.a.r.getBasicInfo().getId();
                long forumId = this.a.r.getBasicInfo().getForumId();
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.b.getContext(), null, TbConfig.URL_CHAT_ROOM_NOTICEMODIFY + "forumId=" + forumId + "&roomId=" + id + "&fr=room&customfullscreen=1&nonavigationbar=1", true);
                tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends fl7<BaseChatAdapter, ShareForumSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fl7
        /* renamed from: o */
        public boolean j(@NonNull ShareForumSysMsg shareForumSysMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareForumSysMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

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
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends fl7<BaseChatAdapter, ShareThreadSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fl7
        /* renamed from: o */
        public boolean j(@NonNull ShareThreadSysMsg shareThreadSysMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareThreadSysMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public n(ChatPage chatPage) {
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
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends fl7<TextGenImageAdapter, TextGenImageMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fl7
        /* renamed from: o */
        public boolean j(@NonNull TextGenImageMsg textGenImageMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textGenImageMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public o(ChatPage chatPage) {
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
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        public p(ChatPage chatPage) {
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

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.R();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.a.q.f.setClickable(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements hw4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ gl7 b;
        public final /* synthetic */ BaseMsg c;
        public final /* synthetic */ int d;
        public final /* synthetic */ fw4 e;

        public q(ChatPage chatPage, String str, gl7 gl7Var, BaseMsg baseMsg, int i, fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, str, gl7Var, baseMsg, Integer.valueOf(i), fw4Var};
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
            this.b = gl7Var;
            this.c = baseMsg;
            this.d = i;
            this.e = fw4Var;
        }

        @Override // com.baidu.tieba.hw4.f
        public void o0(hw4 hw4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, hw4Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            if (TextUtils.equals(((TextView) view2).getText().toString(), this.a)) {
                this.b.a().m(this.c, this.d);
            }
            this.e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class r extends GroupChatRepo.n<TreeSet<ChatMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage b;

        public r(ChatPage chatPage) {
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
                this.b.r0();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.b.q.c.f();
                this.b.q0();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.b.q.c.i();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.GroupChatRepo.n
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.k0();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.GroupChatRepo.n
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.P();
                this.b.O();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements dl7<BaseMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        public s(ChatPage chatPage) {
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

        @Override // com.baidu.tieba.dl7
        public void a(@NonNull View view2, @NonNull BaseMsg baseMsg, int i) {
            ReMsgInfo reMsgInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, view2, baseMsg, i) == null) {
                if (view2.getId() == R.id.btn_msgitem_resend) {
                    gl7 b = gl7.b(view2);
                    if (b == null) {
                        return;
                    }
                    this.a.o0(b, baseMsg, i);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090d71 && (reMsgInfo = baseMsg.getReMsgInfo()) != null) {
                    this.a.c.E(reMsgInfo.getMsgId(), reMsgInfo.getMsgKey(), this.a.u);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements el7<BaseMsg> {
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

        @Override // com.baidu.tieba.el7
        public boolean a(@NonNull View view2, @NonNull BaseMsg baseMsg, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, view2, baseMsg, i)) == null) {
                int id = view2.getId();
                if (id != R.id.obfuscated_res_0x7f0906fb && id != R.id.obfuscated_res_0x7f090d78 && id != R.id.obfuscated_res_0x7f090d5a && id != R.id.obfuscated_res_0x7f090d7c && id != R.id.obfuscated_res_0x7f090d74 && id != R.id.obfuscated_res_0x7f090d75 && id != R.id.obfuscated_res_0x7f090d71) {
                    return false;
                }
                if (id != R.id.obfuscated_res_0x7f090d5a && id != R.id.obfuscated_res_0x7f090d7c && id != R.id.obfuscated_res_0x7f090d74 && id != R.id.obfuscated_res_0x7f090d75) {
                    if (id == R.id.obfuscated_res_0x7f0906fb || id == R.id.obfuscated_res_0x7f090d78 || id == R.id.obfuscated_res_0x7f090d71) {
                        jk7.c(this.a.a, baseMsg, this.a.r);
                        return true;
                    }
                    return true;
                } else if (baseMsg.getCommonMsgField() != null && TbadkCoreApplication.getCurrentAccountId() != baseMsg.getCommonMsgField().getUserId()) {
                    jk7.c(this.a.a, baseMsg, this.a.r);
                    return true;
                } else {
                    return true;
                }
            }
            return invokeLLI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    this.a.v = ((Boolean) data).booleanValue();
                    if (!this.a.v) {
                        this.a.q0();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements GroupInputTool.h {
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

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputTool.h
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if ((z || z2) && this.a.o) {
                    if (this.a.q != null && this.a.q.j != null && this.a.q.b != null && (this.a.q.j.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.q.j.getLayoutParams();
                        layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                        this.a.q.j.setLayoutParams(layoutParams);
                        this.a.q.j.requestLayout();
                        this.a.q.b.requestLayout();
                        fh.c(this.a.x);
                    }
                    this.a.o = false;
                } else if (z || z2) {
                } else {
                    this.a.o = true;
                    if (this.a.q != null && this.a.q.j != null && this.a.q.b != null && (this.a.q.j.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.a.q.j.getLayoutParams();
                        layoutParams2.height = 0;
                        this.a.q.j.setLayoutParams(layoutParams2);
                        this.a.q.j.requestLayout();
                        this.a.q.b.requestLayout();
                        if (this.a.q.b.canScrollVertically(1)) {
                            fh.c(this.a.y);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.q != null && this.a.q.b != null) {
                this.a.q.b.scrollBy(0, TbadkCoreApplication.getInst().getKeyboardHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.q != null && this.a.q.b != null) {
                this.a.q.b.scrollBy(0, -TbadkCoreApplication.getInst().getKeyboardHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BdTypeRecyclerView b;
        public kl7 c;
        public TextView d;
        public ImageView e;
        public LinearLayout f;
        public ImageView g;
        public LinearLayout h;
        public LinearLayout i;
        public RelativeLayout j;

        public z() {
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

        public static z a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                z zVar = new z();
                zVar.a = view2;
                zVar.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090626);
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09062d);
                zVar.b = bdTypeRecyclerView;
                zVar.c = new kl7(bdTypeRecyclerView);
                zVar.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092564);
                zVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090488);
                zVar.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090492);
                zVar.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090863);
                zVar.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090862);
                zVar.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0913cd);
                return zVar;
            }
            return (z) invokeL.objValue;
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
        this.i = new j(this, 2921782);
        this.j = -1;
        this.l = false;
        this.o = true;
        this.p = new r(this);
        this.s = new s(this);
        this.t = new t(this);
        this.u = new u(this);
        this.w = new v(this, 2016523);
        this.x = new x(this);
        this.y = new y(this);
        this.a = groupChatFragment.getPageContext();
        this.b = groupChatFragment;
        this.c = groupChatRepo;
        groupChatRepo.L(this.p);
    }

    @NonNull
    public List<AtUserInfo> j0(List<AtSelectData> list, Map<String, Integer> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, list, map)) == null) {
            if (!ListUtils.isEmpty(list) && !map.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (AtSelectData atSelectData : list) {
                    AtUserInfo.AtType atType = AtUserInfo.AtType.USER;
                    if (AtSelectData.AT_ALL_FAKE_UID.equals(atSelectData.getUid())) {
                        atType = AtUserInfo.AtType.ALL;
                    }
                    arrayList.add(AtUserInfo.create(atType, yg.g(atSelectData.getUid(), 0L), atSelectData.getNameShow(), atSelectData.getPortrait(), map.get(atSelectData.getUid()).intValue()));
                }
                return arrayList;
            }
            return Collections.emptyList();
        }
        return (List) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController.t
    public void c(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i2) == null) {
            this.c.J(VoiceMsg.create(str, i2));
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController.t
    public void d(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
            this.c.J(ImageMsg.create(str, str2));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.q = z.a(this.b.requireView());
            this.b.registerListener(this.w);
            d0();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (this.x != null) {
                bh.a().removeCallbacks(this.x);
            }
            if (this.y != null) {
                bh.a().removeCallbacks(this.y);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && this.b.Z1() != null) {
            this.b.Z1().C0(new w(this));
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.q.h.getVisibility() == 0) {
            this.q.h.setVisibility(8);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.q.f.getVisibility() == 0) {
            this.q.f.setVisibility(8);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.q.h.getVisibility() != 0) {
            this.q.h.setVisibility(0);
            this.q.h.setOnClickListener(new b(this));
        }
    }

    @NonNull
    public final ManagerTipsAdapter V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.c.G(-7014, ManagerTipsSysMsg.class);
            ManagerTipsAdapter managerTipsAdapter = new ManagerTipsAdapter(this.a, ManagerTipsSysMsg.ADAPTER_TYPE);
            this.d = managerTipsAdapter;
            return managerTipsAdapter;
        }
        return (ManagerTipsAdapter) invokeV.objValue;
    }

    @NonNull
    public final RecallAdapter X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.c.G(RecallSysMsg.MSG_TYPE, RecallSysMsg.class);
            RecallAdapter recallAdapter = new RecallAdapter(this.a, RecallSysMsg.ADAPTER_TYPE);
            this.e = recallAdapter;
            return recallAdapter;
        }
        return (RecallAdapter) invokeV.objValue;
    }

    @NonNull
    public final TimestampAdapter c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            this.c.G(-7013, TimestampSysMsg.class);
            return new TimestampAdapter(this.a, TimestampSysMsg.ADAPTER_TYPE);
        }
        return (TimestampAdapter) invokeV.objValue;
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.q.b.getLastVisiblePosition() < this.j) {
            T();
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.l = false;
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 1000.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(1000L);
            this.q.f.startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new p(this));
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.q.b.canScrollVertically(1)) {
            T();
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && !BdNetTypeUtil.isNetWorkAvailable()) {
            zi.M(this.b.requireContext(), R.string.obfuscated_res_0x7f0f0cd1);
        }
    }

    public final void O() {
        ChatRoomDetail chatRoomDetail;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (chatRoomDetail = this.r) != null) {
            boolean z2 = false;
            if (chatRoomDetail.getAtInfo() == null) {
                this.l = false;
            } else {
                this.l = (this.r.getAtInfo().getAllMsgCount() > 0 || this.r.getAtInfo().getSingleMsgCount() > 0) ? true : true;
            }
        }
    }

    @NonNull
    public final ImageAdapter S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.c.G(4, BigEmotionMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.a, BigEmotionMsg.ADAPTER_TYPE);
            imageAdapter.w(this.s, null);
            imageAdapter.x(this.t, null);
            imageAdapter.z(new a0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final ImageAdapter U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.c.G(2, ImageMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.a, ImageMsg.ADAPTER_TYPE);
            imageAdapter.w(this.s, null);
            imageAdapter.x(this.t, null);
            imageAdapter.z(new a0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final NoticeModifyAdapter W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.c.G(7001, NoticeModifySysMsg.class);
            NoticeModifyAdapter noticeModifyAdapter = new NoticeModifyAdapter(this.a, NoticeModifySysMsg.ADAPTER_TYPE);
            this.f = noticeModifyAdapter;
            noticeModifyAdapter.w(null, new k(this));
            return this.f;
        }
        return (NoticeModifyAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareForumAdapter Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            this.c.G(7009, ShareForumSysMsg.class);
            ShareForumAdapter shareForumAdapter = new ShareForumAdapter(this.a, ShareForumSysMsg.ADAPTER_TYPE);
            shareForumAdapter.x(this.t, null);
            shareForumAdapter.z(new m(this));
            return shareForumAdapter;
        }
        return (ShareForumAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareThreadAdapter Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.c.G(7010, ShareThreadSysMsg.class);
            ShareThreadAdapter shareThreadAdapter = new ShareThreadAdapter(this.a, ShareThreadSysMsg.ADAPTER_TYPE);
            shareThreadAdapter.x(this.t, null);
            shareThreadAdapter.z(new n(this));
            return shareThreadAdapter;
        }
        return (ShareThreadAdapter) invokeV.objValue;
    }

    @NonNull
    public final TextAdapter a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.c.G(1, TextMsg.class);
            TextAdapter textAdapter = new TextAdapter(this.a, TextMsg.ADAPTER_TYPE);
            textAdapter.z(new i(this));
            textAdapter.w(this.s, null);
            textAdapter.x(this.t, null);
            return textAdapter;
        }
        return (TextAdapter) invokeV.objValue;
    }

    public final void P() {
        ChatRoomDetail chatRoomDetail;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (chatRoomDetail = this.r) != null && chatRoomDetail.getBots() != null && !ListUtils.isEmpty(this.r.getBots().getBotList())) {
            String r2 = cz4.l().r("key_show_bot_tip_list", "");
            List asList = Arrays.asList(r2.split(","));
            List<BotsDTO.BotListDTO> botList = this.r.getBots().getBotList();
            for (int i2 = 0; i2 < botList.size(); i2++) {
                BotsDTO.BotListDTO botListDTO = botList.get(i2);
                if (botListDTO != null && botListDTO.getUser() != null && !TextUtils.isEmpty(botListDTO.getUser().getUk()) && !asList.contains(botListDTO.getUser().getUk()) && !TextUtils.equals(BIMManager.getBdUidFromBdUK(botListDTO.getUser().getUk()), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                    l0(botListDTO);
                    if (TextUtils.isEmpty(r2)) {
                        str = botListDTO.getUser().getUk();
                    } else {
                        str = r2 + "," + botListDTO.getUser().getUk();
                    }
                    cz4.l().z("key_show_bot_tip_list", str);
                    return;
                }
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a0());
            arrayList.add(W());
            arrayList.add(c0());
            arrayList.add(V());
            arrayList.add(X());
            arrayList.add(f0());
            arrayList.add(U());
            arrayList.add(Y());
            arrayList.add(Z());
            arrayList.add(S());
            arrayList.add(b0());
            this.q.b.a(arrayList);
            ViewCommonUtil.setViewMargin(this.q.i, -1, UtilHelper.getStatusBarHeight(), -1, -1);
            c cVar = new c(this, this.b.getContext());
            this.k = cVar;
            this.q.b.setLayoutManager(cVar);
            this.q.b.setOnScrollToTopListener(new d(this));
            this.q.b.setOnSrollToBottomListener(new e(this));
            this.q.b.addOnScrollListener(new f(this));
            this.q.b.addOnLayoutChangeListener(new g(this));
            this.c.M(new h(this));
            this.b.registerListener(this.i);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController.t
    public void a(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, map) == null) {
            this.c.J(BigEmotionMsg.create(str, str2, map));
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController.t
    public void b(@NonNull String str, @Nullable BaseMsg baseMsg, @Nullable xk7 xk7Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048590, this, str, baseMsg, xk7Var, list, map) == null) {
            TextMsg e2 = il7.e(str, baseMsg, xk7Var);
            e2.addAtUserInfo(j0(list, map));
            this.c.J(e2);
        }
    }

    @NonNull
    public final TextGenImageAdapter b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.c.G(101, TextGenImageMsg.class);
            this.c.G(7014, TextGenImageUpdateSysMsg.class);
            TextGenImageAdapter textGenImageAdapter = new TextGenImageAdapter(this.a, TextGenImageMsg.ADAPTER_TYPE);
            this.g = textGenImageAdapter;
            textGenImageAdapter.w(this.s, null);
            this.g.x(this.t, null);
            this.g.z(new o(this));
            return this.g;
        }
        return (TextGenImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final VoiceAdapter f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            this.c.G(3, VoiceMsg.class);
            VoiceAdapter voiceAdapter = new VoiceAdapter(this.a, VoiceMsg.ADAPTER_TYPE);
            voiceAdapter.w(this.s, null);
            voiceAdapter.x(this.t, null);
            GroupChatFragment groupChatFragment = this.b;
            if (groupChatFragment != null && groupChatFragment.Z1() != null) {
                voiceAdapter.T(this.b.Z1().t0());
            }
            voiceAdapter.z(new l(this));
            return voiceAdapter;
        }
        return (VoiceAdapter) invokeV.objValue;
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.r;
            if (chatRoomDetail != null && chatRoomDetail.getAtInfo() != null) {
                AtInfo atInfo = this.r.getAtInfo();
                List<AtInfoMsg> singleMsgList = atInfo.getSingleMsgList();
                List<AtInfoMsg> allMsgList = atInfo.getAllMsgList();
                if (ListUtils.isEmpty(singleMsgList) && !ListUtils.isEmpty(allMsgList)) {
                    return true;
                }
                if (!ListUtils.isEmpty(singleMsgList) && !ListUtils.isEmpty(allMsgList) && singleMsgList.get(0).getMsgId() > allMsgList.get(0).getMsgId()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int lastVisiblePosition = this.q.b.getLastVisiblePosition();
            int firstVisiblePosition = this.q.b.getFirstVisiblePosition();
            if (lastVisiblePosition != -1 && this.q.b.getCount() > 0 && this.q.b.getCount() - 1 == lastVisiblePosition) {
                this.j = firstVisiblePosition;
            }
            RecyclerView.LayoutManager layoutManager = this.q.b.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(this.q.b.getCount() - 1, 0);
            }
        }
    }

    public final void e0() {
        AtInfoMsg atInfoMsg;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || this.r.getAtInfo() == null) {
            return;
        }
        this.q.f.setVisibility(0);
        if (!h0()) {
            this.q.d.setText(R.string.obfuscated_res_0x7f0f03b4);
        } else {
            this.q.d.setText(R.string.obfuscated_res_0x7f0f03b3);
        }
        if (!h0()) {
            atInfoMsg = this.r.getAtInfo().getSingleMsgList().get(0);
        } else {
            atInfoMsg = this.r.getAtInfo().getAllMsgList().get(0);
        }
        if (atInfoMsg != null) {
            this.m = atInfoMsg.getMsgId();
            this.n = atInfoMsg.getMsgKey();
        }
        this.q.f.setOnClickListener(new a(this));
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.r.getExtraInfo() != null && this.r.getUserInfo() != null && this.b.Z1() != null) {
                if (this.r.getExtraInfo().getIsFreezing() == 1) {
                    BdTopToast bdTopToast = new BdTopToast(this.b.getContext());
                    bdTopToast.g(this.b.getContext().getString(R.string.group_chat_group_had_close));
                    bdTopToast.h(false);
                    bdTopToast.i((ViewGroup) this.b.getView());
                    return true;
                } else if (this.r.getExtraInfo().getIsTalkBanned() == 1) {
                    BdTopToast bdTopToast2 = new BdTopToast(this.b.getContext());
                    bdTopToast2.g(this.b.getContext().getString(R.string.group_chat_no_speak_all));
                    bdTopToast2.h(false);
                    bdTopToast2.i((ViewGroup) this.b.getView());
                    return true;
                } else if (this.r.getUserInfo().getIsBeenTalkBanned() == 1) {
                    BdTopToast bdTopToast3 = new BdTopToast(this.b.getContext());
                    bdTopToast3.g(this.b.getContext().getString(R.string.group_chat_no_speak_person));
                    bdTopToast3.h(false);
                    bdTopToast3.i((ViewGroup) this.b.getView());
                    return true;
                } else if (this.r.getExtraInfo().getTalkType() == 1 && this.r.getUserInfo().getIdentityRole() != 3) {
                    BdTopToast bdTopToast4 = new BdTopToast(this.b.getContext());
                    bdTopToast4.g(this.b.getContext().getString(R.string.obfuscated_res_0x7f0f0857));
                    bdTopToast4.h(false);
                    bdTopToast4.i((ViewGroup) this.b.getView());
                    return true;
                } else if (this.b.Z1().N(this.r.getExtraInfo().getTalkThresholdLevel(), this.r.getUserInfo().getForumLevel())) {
                    String format = String.format(this.b.getStringSafely(R.string.obfuscated_res_0x7f0f084d), Integer.valueOf(this.r.getExtraInfo().getTalkThresholdLevel()));
                    BdTopToast bdTopToast5 = new BdTopToast(this.b.getContext());
                    bdTopToast5.g(format);
                    bdTopToast5.h(false);
                    bdTopToast5.i((ViewGroup) this.b.getView());
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.q.c.h(i2);
            RecyclerView.Adapter adapter = this.q.b.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            this.q.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.up_positioning_bubble_icon, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            cx4 d2 = cx4.d(this.q.f);
            d2.n(R.string.J_X20);
            d2.f(R.color.CAM_X0207);
            cx4 d3 = cx4.d(this.q.d);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X07);
            cx4 d4 = cx4.d(this.q.h);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0207);
            this.q.g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.down_positioning_bubble_icon, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void m0(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, chatRoomDetail) == null) {
            this.r = chatRoomDetail;
            this.d.G(chatRoomDetail.getBasicInfo().getForumId());
            this.d.H(chatRoomDetail.getBasicInfo().getId());
            this.f.G(chatRoomDetail.getBasicInfo().getForumId());
            this.f.H(chatRoomDetail.getBasicInfo().getId());
            this.e.G(chatRoomDetail.getBasicInfo().getForumId());
            this.e.H(chatRoomDetail.getBasicInfo().getId());
            this.g.a(chatRoomDetail.getBasicInfo().getForumName());
            this.g.W(chatRoomDetail.getBasicInfo().getForumId());
            this.g.X(chatRoomDetail.getBasicInfo().getId());
        }
    }

    public final void l0(BotsDTO.BotListDTO botListDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, botListDTO) == null) {
            if (botListDTO != null && botListDTO.getUser() != null) {
                BotsDTO.BotListDTO.UserDTO user = botListDTO.getUser();
                TextMsg create = TextMsg.create("@" + TbadkCoreApplication.getCurrentAccountNameShow() + " " + botListDTO.getAtGuide());
                create.setMockSenderInfo(yg.g(BIMManager.getBdUidFromBdUK(user.getUk()), 0L), user.getNameShow(), user.getPortrait(), 4, user.getRobotRole(), user.getForumLevel());
                AtUserInfo.AtType atType = AtUserInfo.AtType.USER;
                long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
                create.addAtUserInfo(AtUserInfo.create(atType, currentAccountId, "@" + TbadkCoreApplication.getCurrentAccountNameShow(), TbadkCoreApplication.getCurrentPortrait(), 0));
                create.setRobotGuideMsg(true);
                this.c.J(create);
            }
        }
    }

    public final void o0(@NonNull gl7 gl7Var, @NonNull BaseMsg baseMsg, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048606, this, gl7Var, baseMsg, i2) == null) {
            fw4 fw4Var = new fw4(this.a);
            String string = this.a.getString(R.string.msg_resend);
            fw4Var.i(null, new String[]{string}, new q(this, string, gl7Var, baseMsg, i2, fw4Var));
            fw4Var.k();
        }
    }
}
