package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
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
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.cq7;
import com.baidu.tieba.cr7;
import com.baidu.tieba.dh;
import com.baidu.tieba.ej;
import com.baidu.tieba.gh;
import com.baidu.tieba.hq7;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfoMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ImageAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ManagerTipsAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.NoticeModifyAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.RecallAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ShareForumAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ShareThreadAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.TextAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.TextGenImageAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.TimestampAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.VoiceAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AtUserInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BigEmotionMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ManagerTipsSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.NoticeModifySysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.RecallSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareForumSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareThreadSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageUpdateSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TimestampSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.VoiceMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.ir7;
import com.baidu.tieba.jq7;
import com.baidu.tieba.kh;
import com.baidu.tieba.kq7;
import com.baidu.tieba.lq7;
import com.baidu.tieba.mq7;
import com.baidu.tieba.np7;
import com.baidu.tieba.oq7;
import com.baidu.tieba.p15;
import com.baidu.tieba.p35;
import com.baidu.tieba.po;
import com.baidu.tieba.pr7;
import com.baidu.tieba.qq7;
import com.baidu.tieba.s05;
import com.baidu.tieba.tq7;
import com.baidu.tieba.u05;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.vp7;
import com.baidu.tieba.vq7;
import com.baidu.tieba.wq7;
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
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes5.dex */
public class ChatPage implements LifecycleObserver, wq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
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
    public int i;
    public LinearLayoutManager j;
    public boolean k;
    public long l;
    public String m;
    @Nullable
    public vp7 n;
    public boolean o;
    public d0 p;
    public GestureDetector q;
    @Nullable
    public ChatRoomDetail r;
    public final CustomMessageListener s;
    public final GroupChatRepo.n<TreeSet<ChatMsg>> t;
    public final jq7<BaseMsg> u;
    public final kq7<BaseMsg> v;
    public final GroupChatRepo.o<TreeSet<ChatMsg>> w;
    public boolean x;
    public final CustomMessageListener y;
    public Runnable z;

    /* loaded from: classes4.dex */
    public class l implements cr7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final po a;
        public final /* synthetic */ ChatPage b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ l c;

            /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage$l$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0318a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0318a(a aVar) {
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
                        this.a.c.b.p0();
                    }
                }
            }

            public a(l lVar, List list, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, list, Boolean.valueOf(z)};
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
                this.a = list;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.b.p.b.I(this.a, true, BaseMsg.DIFF_ITEM_CALLBACK);
                    if (this.b) {
                        kh.c(new RunnableC0318a(this));
                    }
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
            this.b = chatPage;
            this.a = new po(this.b.p.b);
        }

        @Override // com.baidu.tieba.cr7.h
        @MainThread
        public void a(long j, @NonNull List<BaseMsg> list, @NonNull cr7.i iVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), list, iVar}) != null) || this.b.b.U1()) {
                return;
            }
            boolean z = true;
            if (!iVar.a && (!iVar.c || this.b.p.b.getLastVisiblePosition() != this.b.p.b.getCount() - 1 || this.b.x)) {
                z = false;
            }
            this.a.e(new a(this, list, z));
        }
    }

    /* loaded from: classes4.dex */
    public class e0<Adapter extends BaseChatAdapter> extends lq7<Adapter, BaseImageMsg<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

        /* loaded from: classes4.dex */
        public class a implements vq7 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ lq7.e a;
            public final /* synthetic */ BaseImageMsg b;
            public final /* synthetic */ e0 c;

            public a(e0 e0Var, lq7.e eVar, BaseImageMsg baseImageMsg) {
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

            @Override // com.baidu.tieba.vq7
            public void a(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                    this.a.b();
                }
            }

            @Override // com.baidu.tieba.vq7
            public void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.c(i);
                }
            }

            @Override // com.baidu.tieba.vq7
            public void c(int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                    this.b.setThumbUrl(str2);
                    this.b.setBigSrc(str);
                    this.b.setSdkMsg(str2, str);
                    this.a.a();
                    if (this.c.c.r != null && this.c.c.r.getBasicInfo() != null) {
                        pr7.a("c15090", 2, this.c.c.r.getBasicInfo().getForumId(), this.c.c.r.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }
        }

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq7
        /* renamed from: p */
        public boolean j(@NonNull BaseImageMsg<?> baseImageMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, baseImageMsg)) == null) {
                return baseImageMsg.isInvalidAddress();
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ e0(ChatPage chatPage, k kVar) {
            this(chatPage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq7
        /* renamed from: o */
        public void i(@NonNull BaseImageMsg<?> baseImageMsg, @NonNull lq7.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseImageMsg, eVar) == null) && this.c.b.b2() != null && !StringUtils.isNull(baseImageMsg.getThumbUrl())) {
                this.c.b.b2().n1(baseImageMsg.getThumbUrl(), new a(this, eVar, baseImageMsg));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends lq7<BaseChatAdapter, VoiceMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

        /* loaded from: classes4.dex */
        public class a implements tq7 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ lq7.e a;
            public final /* synthetic */ VoiceMsg b;
            public final /* synthetic */ o c;

            public a(o oVar, lq7.e eVar, VoiceMsg voiceMsg) {
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

            @Override // com.baidu.tieba.tq7
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.b.setVoiceUrl(str);
                    this.a.a();
                    if (this.c.c.r != null && this.c.c.r.getBasicInfo() != null) {
                        pr7.a("c15090", 3, this.c.c.r.getBasicInfo().getForumId(), this.c.c.r.getBasicInfo().getId(), TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }

            @Override // com.baidu.tieba.tq7
            public void isFailed() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.b();
                }
            }
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
                    return;
                }
            }
            this.c = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq7
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
        @Override // com.baidu.tieba.lq7
        /* renamed from: o */
        public void i(@NonNull VoiceMsg voiceMsg, @NonNull lq7.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceMsg, eVar) == null) && this.c.b.b2() != null && !StringUtils.isNull(voiceMsg.getPath())) {
                this.c.b.b2().o1(voiceMsg.getPath(), new a(this, eVar, voiceMsg));
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
                    this.a.b.s0();
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
                this.b.p.b.scrollToPosition(i);
                kh.c(new a(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void b(int i, @NonNull String str, @Nullable TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, treeSet) == null) {
                super.b(i, str, treeSet);
                this.b.x0();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.b.p.c.g();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.b.p.c.j();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.o
        public void g(@NonNull GroupChatRepo.FetchedEvent fetchedEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, fetchedEvent) == null) && u.a[fetchedEvent.ordinal()] == 1) {
                BdTopToast bdTopToast = new BdTopToast(this.b.b.getContext());
                bdTopToast.g(this.b.b.getContext().getString(R.string.obfuscated_res_0x7f0f089b));
                bdTopToast.h(false);
                bdTopToast.i((ViewGroup) this.b.b.getView());
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p != null && this.a.p.b != null) {
                this.a.p.b.scrollBy(0, -TbadkCoreApplication.getInst().getKeyboardHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(ChatPage chatPage, int i) {
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
                    this.a.x = ((Boolean) data).booleanValue();
                    if (!this.a.x) {
                        this.a.w0();
                    }
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
                this.a.c.E(this.a.l, this.a.m, this.a.w);
                this.a.v0();
                this.a.Y();
            }
        }
    }

    /* loaded from: classes4.dex */
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.GroupInputTool.f
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if ((z || z2) && this.a.o) {
                    if (this.a.p != null && this.a.p.j != null && this.a.p.b != null && (this.a.p.j.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.p.j.getLayoutParams();
                        layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                        this.a.p.j.setLayoutParams(layoutParams);
                        this.a.p.j.requestLayout();
                        this.a.p.b.requestLayout();
                        kh.c(this.a.z);
                    }
                    this.a.o = false;
                } else if (z || z2) {
                } else {
                    this.a.o = true;
                    if (this.a.p != null && this.a.p.j != null && this.a.p.b != null && (this.a.p.j.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.a.p.j.getLayoutParams();
                        layoutParams2.height = 0;
                        this.a.p.j.setLayoutParams(layoutParams2);
                        this.a.p.j.requestLayout();
                        this.a.p.b.requestLayout();
                        if (this.a.p.b.canScrollVertically(1)) {
                            kh.c(this.a.A);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c.D();
                this.a.V();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p != null && this.a.p.b != null) {
                this.a.p.b.scrollBy(0, TbadkCoreApplication.getInst().getKeyboardHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BdTypeRecyclerView b;
        public qq7 c;
        public TextView d;
        public ImageView e;
        public LinearLayout f;
        public ImageView g;
        public LinearLayout h;
        public LinearLayout i;
        public RelativeLayout j;

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

        public static d0 a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                d0 d0Var = new d0();
                d0Var.a = view2;
                d0Var.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09063f);
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090646);
                d0Var.b = bdTypeRecyclerView;
                d0Var.c = new qq7(bdTypeRecyclerView);
                d0Var.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925c9);
                d0Var.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090494);
                d0Var.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09049e);
                d0Var.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090885);
                d0Var.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090884);
                d0Var.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091424);
                return d0Var;
            }
            return (d0) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.c.t(this.a.w);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.c.v(this.a.t);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (!this.a.p.b.canScrollVertically(1) && !this.a.c.B()) {
                    ChatPage chatPage = this.a;
                    chatPage.i = chatPage.p.b.getFirstVisiblePosition();
                    this.a.V();
                }
                if (i2 < 0) {
                    this.a.s0();
                }
                int firstVisiblePosition = this.a.p.b.getFirstVisiblePosition();
                List<Cdo> data = ((RecyclerViewTypeAdapter) this.a.p.b.getWrappedAdapter()).getData();
                if ((ListUtils.getItem(data, firstVisiblePosition) instanceof BaseMsg) && ((BaseMsg) ListUtils.getItem(data, firstVisiblePosition)).getCommonMsgField().getMsgId() == this.a.l && this.a.p.f.getVisibility() == 0) {
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements GestureDetector.OnGestureListener {
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

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, motionEvent)) != null) {
                return invokeL.booleanValue;
            }
            this.a.T();
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (Math.abs(f - f2) > 1.0f) {
                    this.a.T();
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return this.a.q.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

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
            this.a = chatPage;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                int lastVisiblePosition = this.a.p.b.getLastVisiblePosition();
                int firstVisiblePosition = this.a.p.b.getFirstVisiblePosition();
                if (lastVisiblePosition != -1 && this.a.p.b.getCount() > 0 && this.a.p.b.getCount() - 1 == lastVisiblePosition) {
                    this.a.i = firstVisiblePosition;
                }
                if (this.a.k) {
                    ArrayList arrayList = new ArrayList();
                    List<Cdo> data = ((RecyclerViewTypeAdapter) this.a.p.b.getWrappedAdapter()).getData();
                    if (data.size() > 0 && firstVisiblePosition != -1 && lastVisiblePosition != -1) {
                        while (firstVisiblePosition <= lastVisiblePosition) {
                            Cdo cdo = data.get(firstVisiblePosition);
                            if (cdo instanceof TextMsg) {
                                long msgId = ((TextMsg) cdo).getCommonMsgField().getMsgId();
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
                            this.a.j0();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ChatPage chatPage, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.l0()) {
                return;
            }
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ir7)) {
                ir7 ir7Var = (ir7) customResponsedMessage.getData();
                if (this.a.b.b2() != null) {
                    GroupInputViewController b2 = this.a.b.b2();
                    b2.b1(ir7Var.c(), ir7Var.b(), this.a.Q(ir7Var.b()));
                    b2.O0(GroupInputViewController.SourceType.TWO, true);
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
    public class m extends lq7<TextAdapter, TextMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage c;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq7
        /* renamed from: o */
        public boolean j(@NonNull TextMsg textMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, textMsg)) == null) {
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
                    return;
                }
            }
            this.c = chatPage;
        }

        @Override // com.baidu.tieba.lq7
        public void k(BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseMsg, i, i2) == null) {
                super.k(baseMsg, i, i2);
                if (this.c.r != null && this.c.r.getBasicInfo() != null) {
                    long forumId = this.c.r.getBasicInfo().getForumId();
                    long id = this.c.r.getBasicInfo().getId();
                    if (i == 5) {
                        pr7.a("c15090", 1, forumId, id, TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements jq7<NoticeModifySysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

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
                    return;
                }
            }
            this.a = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jq7
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
    public class p extends lq7<BaseChatAdapter, ShareForumSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq7
        /* renamed from: o */
        public boolean j(@NonNull ShareForumSysMsg shareForumSysMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareForumSysMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
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
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends lq7<BaseChatAdapter, ShareThreadSysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq7
        /* renamed from: o */
        public boolean j(@NonNull ShareThreadSysMsg shareThreadSysMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareThreadSysMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public q(ChatPage chatPage) {
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
    public class r extends lq7<TextGenImageAdapter, TextGenImageMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq7
        /* renamed from: o */
        public boolean j(@NonNull TextGenImageMsg textGenImageMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textGenImageMsg)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

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
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

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

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.W();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.a.p.f.setClickable(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements u05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mq7 b;
        public final /* synthetic */ BaseMsg c;
        public final /* synthetic */ int d;
        public final /* synthetic */ s05 e;

        public t(ChatPage chatPage, String str, mq7 mq7Var, BaseMsg baseMsg, int i, s05 s05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, str, mq7Var, baseMsg, Integer.valueOf(i), s05Var};
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
            this.b = mq7Var;
            this.c = baseMsg;
            this.d = i;
            this.e = s05Var;
        }

        @Override // com.baidu.tieba.u05.f
        public void J0(u05 u05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, u05Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            if (TextUtils.equals(((TextView) view2).getText().toString(), this.a)) {
                this.b.a().m(this.c, this.d);
            }
            this.e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class u {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2023297065, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage$u;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2023297065, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/ChatPage$u;");
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
    public class v extends GroupChatRepo.n<TreeSet<ChatMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatPage b;

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
            this.b = chatPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void b(int i, @NonNull String str, @Nullable TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, treeSet) == null) {
                super.b(i, str, treeSet);
                this.b.x0();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.b.p.c.f();
                this.b.w0();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.b.p.c.i();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.n
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.p0();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.n
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.S();
                this.b.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements jq7<BaseMsg> {
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

        @Override // com.baidu.tieba.jq7
        public void a(@NonNull View view2, @NonNull BaseMsg baseMsg, int i) {
            ReMsgInfo reMsgInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, view2, baseMsg, i) == null) {
                if (view2.getId() == R.id.btn_msgitem_resend) {
                    mq7 b = mq7.b(view2);
                    if (b == null) {
                        return;
                    }
                    this.a.u0(b, baseMsg, i);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090dc5 && (reMsgInfo = baseMsg.getReMsgInfo()) != null) {
                    this.a.c.E(reMsgInfo.getMsgId(), reMsgInfo.getMsgKey(), this.a.w);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements kq7<BaseMsg> {
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

        @Override // com.baidu.tieba.kq7
        public boolean a(@NonNull View view2, @NonNull BaseMsg baseMsg, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, view2, baseMsg, i)) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f090718 || id == R.id.obfuscated_res_0x7f090dcc || id == R.id.obfuscated_res_0x7f090dad || id == R.id.obfuscated_res_0x7f090dd1 || id == R.id.obfuscated_res_0x7f090dc8 || id == R.id.obfuscated_res_0x7f090dc9 || id == R.id.obfuscated_res_0x7f090dc5) {
                    this.a.t0(baseMsg);
                    this.a.T();
                    return false;
                }
                return false;
            }
            return invokeLLI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class y implements hq7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseMsg a;
        public final /* synthetic */ ChatPage b;

        public y(ChatPage chatPage, BaseMsg baseMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatPage, baseMsg};
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
            this.a = baseMsg;
        }

        @Override // com.baidu.tieba.hq7
        public void a(@NonNull UserReplyInfoData userReplyInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, userReplyInfoData) == null) && this.b.b.b2() != null) {
                this.b.b.b2().D0(userReplyInfoData, this.a);
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
        this.i = -1;
        this.k = false;
        this.o = true;
        this.s = new k(this, 2921782);
        this.t = new v(this);
        this.u = new w(this);
        this.v = new x(this);
        this.w = new z(this);
        this.y = new a0(this, 2016523);
        this.z = new c0(this);
        this.A = new a(this);
        this.a = groupChatFragment.getPageContext();
        this.b = groupChatFragment;
        this.c = groupChatRepo;
        groupChatRepo.L(this.t);
    }

    @NonNull
    public List<AtUserInfo> o0(List<AtSelectData> list, Map<String, Integer> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, list, map)) == null) {
            if (!ListUtils.isEmpty(list) && !map.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (AtSelectData atSelectData : list) {
                    AtUserInfo.AtType atType = AtUserInfo.AtType.USER;
                    if (AtSelectData.AT_ALL_FAKE_UID.equals(atSelectData.getUid())) {
                        atType = AtUserInfo.AtType.ALL;
                    }
                    arrayList.add(AtUserInfo.create(atType, dh.g(atSelectData.getUid(), 0L), atSelectData.getNameShow(), atSelectData.getPortrait(), map.get(atSelectData.getUid()).intValue()));
                }
                return arrayList;
            }
            return Collections.emptyList();
        }
        return (List) invokeLL.objValue;
    }

    public void t0(@NonNull BaseMsg baseMsg) {
        ChatRoomDetail chatRoomDetail;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, baseMsg) != null) || (chatRoomDetail = this.r) == null) {
            return;
        }
        this.n = np7.c(this.a, baseMsg, chatRoomDetail, new y(this, baseMsg));
    }

    @Override // com.baidu.tieba.wq7
    public void b(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i2) == null) {
            this.c.J(VoiceMsg.create(str, i2));
        }
    }

    @Override // com.baidu.tieba.wq7
    public void d(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.c.J(ImageMsg.create(str, str2));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.p = d0.a(this.b.requireView());
            this.b.registerListener(this.y);
            i0();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            if (this.z != null) {
                gh.a().removeCallbacks(this.z);
            }
            if (this.A != null) {
                gh.a().removeCallbacks(this.A);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65563, this) == null) && this.b.b2() != null) {
            this.b.b2().S0(new b0(this));
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b.b2() != null) {
            GroupInputViewController b2 = this.b.b2();
            if (b2.U()) {
                b2.m0();
            }
        }
    }

    @Nullable
    public vp7 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (vp7) invokeV.objValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.p.h.getVisibility() == 0) {
            this.p.h.setVisibility(8);
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.p.f.getVisibility() == 0) {
            this.p.f.setVisibility(8);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.p.h.getVisibility() != 0) {
            this.p.h.setVisibility(0);
            this.p.h.setOnClickListener(new c(this));
        }
    }

    @NonNull
    public final ManagerTipsAdapter a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.c.G(-7014, ManagerTipsSysMsg.class);
            ManagerTipsAdapter managerTipsAdapter = new ManagerTipsAdapter(this.a, ManagerTipsSysMsg.ADAPTER_TYPE);
            this.d = managerTipsAdapter;
            return managerTipsAdapter;
        }
        return (ManagerTipsAdapter) invokeV.objValue;
    }

    @NonNull
    public final RecallAdapter c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.c.H(RecallSysMsg.MSG_TYPE_LIST, RecallSysMsg.class);
            RecallAdapter recallAdapter = new RecallAdapter(this.a, RecallSysMsg.ADAPTER_TYPE);
            this.e = recallAdapter;
            return recallAdapter;
        }
        return (RecallAdapter) invokeV.objValue;
    }

    @NonNull
    public final TimestampAdapter h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            this.c.G(-7013, TimestampSysMsg.class);
            return new TimestampAdapter(this.a, TimestampSysMsg.ADAPTER_TYPE);
        }
        return (TimestampAdapter) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.k = false;
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 1000.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(1000L);
            this.p.f.startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new s(this));
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.p.b.canScrollVertically(1)) {
            Y();
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && !BdNetTypeUtil.isNetWorkAvailable()) {
            ej.M(this.b.requireContext(), R.string.obfuscated_res_0x7f0f0d08);
        }
    }

    @NonNull
    public final cq7 Q(@NonNull TextGenImageMsg textGenImageMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, textGenImageMsg)) == null) {
            cq7 cq7Var = new cq7();
            BotsDTO.BotListDTO.UserDTO userDTO = new BotsDTO.BotListDTO.UserDTO();
            cq7Var.a = userDTO;
            userDTO.setName(textGenImageMsg.getCommonMsgField().getUserName());
            cq7Var.a.setNameShow(textGenImageMsg.getCommonMsgField().getUserName());
            cq7Var.a.setPortrait(textGenImageMsg.getCommonMsgField().getPortrait());
            cq7Var.a.setUk(BIMManager.getBdUKFromBdUid(String.valueOf(textGenImageMsg.getCommonMsgField().getUserId())));
            cq7Var.b = new BotsDTO.BotListDTO.SkillDTO();
            if (textGenImageMsg.getSubSkillConfig() != null) {
                cq7Var.b.setSubSkill(textGenImageMsg.getSubSkillConfig().a);
            }
            return cq7Var;
        }
        return (cq7) invokeL.objValue;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.p.c.h(i2);
            RecyclerView.Adapter adapter = this.p.b.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            this.p.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.up_positioning_bubble_icon, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            p15 d2 = p15.d(this.p.f);
            d2.n(R.string.J_X20);
            d2.f(R.color.CAM_X0207);
            p15 d3 = p15.d(this.p.d);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X07);
            p15 d4 = p15.d(this.p.h);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0207);
            this.p.g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.down_positioning_bubble_icon, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            np7.b();
        }
    }

    public void r0(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, chatRoomDetail) == null) {
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

    public final void R() {
        ChatRoomDetail chatRoomDetail;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (chatRoomDetail = this.r) != null) {
            boolean z2 = false;
            if (chatRoomDetail.getAtInfo() == null) {
                this.k = false;
            } else {
                this.k = (this.r.getAtInfo().getAllMsgCount() > 0 || this.r.getAtInfo().getSingleMsgCount() > 0) ? true : true;
            }
        }
    }

    @NonNull
    public final ImageAdapter X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.c.G(4, BigEmotionMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.a, BigEmotionMsg.ADAPTER_TYPE);
            imageAdapter.w(this.u, null);
            imageAdapter.x(this.v, null);
            imageAdapter.z(new e0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final ImageAdapter Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.c.G(2, ImageMsg.class);
            ImageAdapter imageAdapter = new ImageAdapter(this.a, ImageMsg.ADAPTER_TYPE);
            imageAdapter.w(this.u, null);
            imageAdapter.x(this.v, null);
            imageAdapter.z(new e0(this, null));
            return imageAdapter;
        }
        return (ImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final NoticeModifyAdapter b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.c.G(7001, NoticeModifySysMsg.class);
            NoticeModifyAdapter noticeModifyAdapter = new NoticeModifyAdapter(this.a, NoticeModifySysMsg.ADAPTER_TYPE);
            this.f = noticeModifyAdapter;
            noticeModifyAdapter.w(null, new n(this));
            return this.f;
        }
        return (NoticeModifyAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareForumAdapter d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            this.c.G(7009, ShareForumSysMsg.class);
            ShareForumAdapter shareForumAdapter = new ShareForumAdapter(this.a, ShareForumSysMsg.ADAPTER_TYPE);
            shareForumAdapter.x(this.v, null);
            shareForumAdapter.z(new p(this));
            return shareForumAdapter;
        }
        return (ShareForumAdapter) invokeV.objValue;
    }

    @NonNull
    public final ShareThreadAdapter e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            this.c.G(7010, ShareThreadSysMsg.class);
            ShareThreadAdapter shareThreadAdapter = new ShareThreadAdapter(this.a, ShareThreadSysMsg.ADAPTER_TYPE);
            shareThreadAdapter.x(this.v, null);
            shareThreadAdapter.z(new q(this));
            return shareThreadAdapter;
        }
        return (ShareThreadAdapter) invokeV.objValue;
    }

    @NonNull
    public final TextAdapter f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            this.c.G(1, TextMsg.class);
            TextAdapter textAdapter = new TextAdapter(this.a, TextMsg.ADAPTER_TYPE);
            textAdapter.z(new m(this));
            textAdapter.w(this.u, null);
            textAdapter.x(this.v, null);
            return textAdapter;
        }
        return (TextAdapter) invokeV.objValue;
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            int lastVisiblePosition = this.p.b.getLastVisiblePosition();
            GroupChatFragment groupChatFragment = this.b;
            if ((groupChatFragment == null || groupChatFragment.W1() == null || this.b.W1().z() == null || this.b.W1().z().getHeight() <= 0) && lastVisiblePosition < this.i) {
                Y();
            }
        }
    }

    public final void S() {
        ChatRoomDetail chatRoomDetail;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (chatRoomDetail = this.r) != null && chatRoomDetail.getBots() != null && !ListUtils.isEmpty(this.r.getBots().getBotList())) {
            String s2 = p35.m().s("key_show_bot_tip_list", "");
            List asList = Arrays.asList(s2.split(","));
            List<BotsDTO.BotListDTO> botList = this.r.getBots().getBotList();
            for (int i2 = 0; i2 < botList.size(); i2++) {
                BotsDTO.BotListDTO botListDTO = botList.get(i2);
                if (botListDTO != null && botListDTO.getUser() != null && !TextUtils.isEmpty(botListDTO.getUser().getUk()) && !asList.contains(botListDTO.getUser().getUk()) && !TextUtils.equals(BIMManager.getBdUidFromBdUK(botListDTO.getUser().getUk()), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                    q0(botListDTO);
                    if (TextUtils.isEmpty(s2)) {
                        str = botListDTO.getUser().getUk();
                    } else {
                        str = s2 + "," + botListDTO.getUser().getUk();
                    }
                    p35.m().B("key_show_bot_tip_list", str);
                    return;
                }
            }
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f0());
            arrayList.add(b0());
            arrayList.add(h0());
            arrayList.add(a0());
            arrayList.add(c0());
            arrayList.add(k0());
            arrayList.add(Z());
            arrayList.add(d0());
            arrayList.add(e0());
            arrayList.add(X());
            arrayList.add(g0());
            this.p.b.a(arrayList);
            ViewCommonUtil.setViewMargin(this.p.i, -1, UtilHelper.getStatusBarHeight(), -1, -1);
            d dVar = new d(this, this.b.getContext());
            this.j = dVar;
            this.p.b.setLayoutManager(dVar);
            this.p.b.setOnScrollToTopListener(new e(this));
            this.p.b.setOnSrollToBottomListener(new f(this));
            this.p.b.addOnScrollListener(new g(this));
            this.q = new GestureDetector(this.b.getContext(), new h(this));
            this.p.b.setRecyclerViewTouchListener(new i(this));
            this.p.b.addOnLayoutChangeListener(new j(this));
            this.c.M(new l(this));
            this.b.registerListener(this.s);
        }
    }

    @Override // com.baidu.tieba.wq7
    public void a(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, map) == null) {
            this.c.J(BigEmotionMsg.create(str, str2, map));
        }
    }

    @Override // com.baidu.tieba.wq7
    public void c(@NonNull String str, @Nullable Object obj, @Nullable cq7 cq7Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map, int i2) {
        BaseMsg baseMsg;
        TextMsg e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, obj, cq7Var, list, map, Integer.valueOf(i2)}) == null) {
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
                e2.addAtUserInfo(o0(list, map));
                this.c.J(e2);
            }
            e2 = oq7.e(str, baseMsg, cq7Var);
            e2.addAtUserInfo(o0(list, map));
            this.c.J(e2);
        }
    }

    @NonNull
    public final TextGenImageAdapter g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.c.G(101, TextGenImageMsg.class);
            this.c.G(7014, TextGenImageUpdateSysMsg.class);
            TextGenImageAdapter textGenImageAdapter = new TextGenImageAdapter(this.a, TextGenImageMsg.ADAPTER_TYPE);
            this.g = textGenImageAdapter;
            textGenImageAdapter.w(this.u, null);
            this.g.x(this.v, null);
            this.g.z(new r(this));
            return this.g;
        }
        return (TextGenImageAdapter) invokeV.objValue;
    }

    @NonNull
    public final VoiceAdapter k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            this.c.G(3, VoiceMsg.class);
            VoiceAdapter voiceAdapter = new VoiceAdapter(this.a, VoiceMsg.ADAPTER_TYPE);
            voiceAdapter.w(this.u, null);
            voiceAdapter.x(this.v, null);
            GroupChatFragment groupChatFragment = this.b;
            if (groupChatFragment != null && groupChatFragment.b2() != null) {
                voiceAdapter.T(this.b.b2().u0());
            }
            voiceAdapter.z(new o(this));
            return voiceAdapter;
        }
        return (VoiceAdapter) invokeV.objValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            int lastVisiblePosition = this.p.b.getLastVisiblePosition();
            int firstVisiblePosition = this.p.b.getFirstVisiblePosition();
            if (lastVisiblePosition != -1 && this.p.b.getCount() > 0 && this.p.b.getCount() - 1 == lastVisiblePosition) {
                this.i = firstVisiblePosition;
            }
            RecyclerView.LayoutManager layoutManager = this.p.b.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(this.p.b.getCount() - 1, 0);
            }
        }
    }

    public final void j0() {
        AtInfoMsg atInfoMsg;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || this.r.getAtInfo() == null) {
            return;
        }
        this.p.f.setVisibility(0);
        if (!m0()) {
            this.p.d.setText(R.string.obfuscated_res_0x7f0f03c2);
        } else {
            this.p.d.setText(R.string.obfuscated_res_0x7f0f03c1);
        }
        if (!m0()) {
            atInfoMsg = this.r.getAtInfo().getSingleMsgList().get(0);
        } else {
            atInfoMsg = this.r.getAtInfo().getAllMsgList().get(0);
        }
        if (atInfoMsg != null) {
            this.l = atInfoMsg.getMsgId();
            this.m = atInfoMsg.getMsgKey();
        }
        this.p.f.setOnClickListener(new b(this));
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.r.getExtraInfo() != null && this.r.getUserInfo() != null && this.b.b2() != null) {
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
                    bdTopToast4.g(this.b.getContext().getString(R.string.obfuscated_res_0x7f0f0883));
                    bdTopToast4.h(false);
                    bdTopToast4.i((ViewGroup) this.b.getView());
                    return true;
                } else if (this.b.b2().Z(this.r.getExtraInfo().getTalkThresholdLevel(), this.r.getUserInfo().getForumLevel())) {
                    String format = String.format(this.b.getStringSafely(R.string.obfuscated_res_0x7f0f0878), Integer.valueOf(this.r.getExtraInfo().getTalkThresholdLevel()));
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

    public final void q0(BotsDTO.BotListDTO botListDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, botListDTO) == null) {
            if (botListDTO != null && botListDTO.getUser() != null) {
                BotsDTO.BotListDTO.UserDTO user = botListDTO.getUser();
                TextMsg create = TextMsg.create("@" + TbadkCoreApplication.getCurrentAccountNameShow() + " " + botListDTO.getAtGuide());
                create.setMockSenderInfo(dh.g(BIMManager.getBdUidFromBdUK(user.getUk()), 0L), user.getNameShow(), user.getPortrait(), 4, user.getRobotRole(), user.getForumLevel());
                AtUserInfo.AtType atType = AtUserInfo.AtType.USER;
                long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
                create.addAtUserInfo(AtUserInfo.create(atType, currentAccountId, "@" + TbadkCoreApplication.getCurrentAccountNameShow(), TbadkCoreApplication.getCurrentPortrait(), 0));
                create.setRobotGuideMsg(true);
                this.c.J(create);
            }
        }
    }

    public final void u0(@NonNull mq7 mq7Var, @NonNull BaseMsg baseMsg, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048610, this, mq7Var, baseMsg, i2) == null) {
            s05 s05Var = new s05(this.a);
            String string = this.a.getString(R.string.msg_resend);
            s05Var.i(null, new String[]{string}, new t(this, string, mq7Var, baseMsg, i2, s05Var));
            s05Var.k();
        }
    }
}
