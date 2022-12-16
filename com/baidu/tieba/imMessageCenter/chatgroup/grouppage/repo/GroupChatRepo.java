package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.bb5;
import com.baidu.tieba.bk5;
import com.baidu.tieba.cb5;
import com.baidu.tieba.eb5;
import com.baidu.tieba.eh;
import com.baidu.tieba.fb5;
import com.baidu.tieba.fr4;
import com.baidu.tieba.ib5;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.jb5;
import com.baidu.tieba.xh7;
import com.baidu.tieba.zj5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public class GroupChatRepo implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context a;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> b;
    public final long c;
    @NonNull
    public final List<Long> d;
    @Nullable
    public FastRequest e;
    @NonNull
    public cb5 f;
    public final xh7 g;
    @Nullable
    public ChatRoomDetail h;
    @Nullable
    public IChatRoomEnterListener.ChatRoomInfo i;
    public boolean j;
    public final ib5 k;
    @Nullable
    public l<TreeSet<ChatMsg>> l;
    @NonNull
    public final zj5<String> m;

    /* loaded from: classes4.dex */
    public class a implements jb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ l b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        public a(GroupChatRepo groupChatRepo, boolean z, l lVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, Boolean.valueOf(z), lVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupChatRepo;
            this.a = z;
            this.b = lVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.jb5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    if (treeSet.size() < 5) {
                        this.d.g.h(this.d.c);
                    } else if (this.a) {
                        this.d.g.u(this.d.c);
                    }
                    this.d.g.v(i, this.d.c, treeSet);
                }
                l lVar = this.b;
                if (lVar == null) {
                    return;
                }
                this.d.m(lVar, i, str, treeSet, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements fb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.fb5
        public void a(long j, int i, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            }
        }

        public b(GroupChatRepo groupChatRepo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo};
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
    public class c implements ib5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public c(GroupChatRepo groupChatRepo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRepo;
        }

        @Override // com.baidu.tieba.ib5
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || i != 0) {
                return;
            }
            this.a.w(null, true);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ eb5 c;
        public final /* synthetic */ GroupChatRepo d;

        public d(GroupChatRepo groupChatRepo, FastRequest.b bVar, eb5 eb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, bVar, eb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupChatRepo;
            this.b = bVar;
            this.c = eb5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048580, this, i, str, chatRoomDetail) == null) {
                super.b(i, str, chatRoomDetail);
                FastRequest.b bVar = this.b;
                if (bVar != null) {
                    bVar.b(i, str, chatRoomDetail);
                }
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                FastRequest.b bVar = this.b;
                if (bVar != null) {
                    bVar.c();
                }
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                FastRequest.b bVar = this.b;
                if (bVar != null) {
                    bVar.d();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, chatRoomDetail) == null) {
                super.e(chatRoomDetail);
                FastRequest.b bVar = this.b;
                if (bVar != null) {
                    bVar.e(chatRoomDetail);
                }
                if (!chatRoomDetail.isJumpH5()) {
                    this.d.h = chatRoomDetail;
                    this.d.q(this.c);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements eb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eb5 a;
        public final /* synthetic */ GroupChatRepo b;

        public e(GroupChatRepo groupChatRepo, eb5 eb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, eb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupChatRepo;
            this.a = eb5Var;
        }

        @Override // com.baidu.tieba.eb5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                this.a.a(j, i, str, chatRoomInfo);
                if (i != 0) {
                    return;
                }
                this.b.i = chatRoomInfo;
                ChatMsg l = this.b.g.l(j, this.b.a.getString(R.string.obfuscated_res_0x7f0f0835));
                GroupChatRepo groupChatRepo = this.b;
                groupChatRepo.x(groupChatRepo.l, l);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseChatMsg a;
        public final /* synthetic */ GroupChatRepo b;

        public f(GroupChatRepo groupChatRepo, BaseChatMsg baseChatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, baseChatMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupChatRepo;
            this.a = baseChatMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.E(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public g(GroupChatRepo groupChatRepo, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
                this.a.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements jb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsg a;
        public final /* synthetic */ l b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        public h(GroupChatRepo groupChatRepo, ChatMsg chatMsg, l lVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, chatMsg, lVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupChatRepo;
            this.a = chatMsg;
            this.b = lVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.jb5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                this.d.g.g(this.d.c);
                this.d.g.h(this.d.c);
                this.d.g.v(i, this.d.c, treeSet);
                if (this.a != null) {
                    this.d.g.w(this.d.c, xh7.G(this.a));
                }
                l lVar = this.b;
                if (lVar == null) {
                    return;
                }
                this.d.m(lVar, i, str, treeSet, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ TreeSet c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ GroupChatRepo f;

        public i(GroupChatRepo groupChatRepo, int i, FastRequest.b bVar, TreeSet treeSet, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, Integer.valueOf(i), bVar, treeSet, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = groupChatRepo;
            this.a = i;
            this.b = bVar;
            this.c = treeSet;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i == 0) {
                    this.b.e(this.c);
                } else {
                    this.b.b(i, this.d, null);
                }
                this.b.c();
                this.f.m.d(this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements jb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupChatRepo c;

        public j(GroupChatRepo groupChatRepo, FastRequest.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = groupChatRepo;
            this.a = bVar;
            this.b = str;
        }

        @Override // com.baidu.tieba.jb5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    this.c.g.v(i, this.c.c, treeSet);
                }
                this.c.m(this.a, i, str, treeSet, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public k(GroupChatRepo groupChatRepo, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
                this.a.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class l<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void f();

        public l() {
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
    }

    public GroupChatRepo(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = bb5.b();
        this.g = new xh7();
        this.j = true;
        this.k = new c(this);
        this.m = zj5.c();
        this.b = tbPageContext;
        this.a = tbPageContext.getPageActivity();
        this.c = j2;
        this.d = Collections.singletonList(Long.valueOf(j2));
    }

    public <T extends BaseChatMsg> void D(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            eh.d(new f(this, t));
        }
    }

    public void F(@Nullable l<TreeSet<ChatMsg>> lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lVar) == null) {
            this.l = lVar;
        }
    }

    public void G(@Nullable xh7.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.g.D(fVar);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.j = z;
        }
    }

    public void I(@Nullable xh7.h<? extends BaseSysMsg> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
            this.g.F(hVar);
        }
    }

    public void u(@Nullable l<TreeSet<ChatMsg>> lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, lVar) == null) && this.g.t(this.c)) {
            w(lVar, false);
        }
    }

    public void A(int i2, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, cls) == null) {
            this.g.B(i2, cls);
        }
    }

    public void B(List<Integer> list, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, cls) == null) {
            this.g.C(list, cls);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (this.j) {
                this.f.e(this.a, "SCENE_GROUP_CHAT", this.d, new b(this));
            }
            this.f.g(this.k);
            this.f.a(this.a, this.d, this.g);
            FastRequest fastRequest = this.e;
            if (fastRequest != null) {
                fastRequest.onDestroy();
            }
        }
    }

    @WorkerThread
    public final <T extends BaseChatMsg> void E(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            t.setItemStatus(0);
            fr4 s = fr4.s();
            bk5.d(s.B());
            bk5.b(this.h);
            ChatRoomDetail.UserInfo userInfo = this.h.getUserInfo();
            CommonMsgField create = CommonMsgField.create(s.i(), this.c);
            create.setType(t.getMsgType());
            create.setContent(DataExt.toMap(t));
            create.setUserName(s.l());
            create.setPortrait(s.q());
            create.setRole(userInfo.getIdentityRole());
            create.setLevel(userInfo.getForumLevel());
            String json = DataExt.toJson(create);
            ChatMsg createSdkMsg = t.createSdkMsg();
            createSdkMsg.setCategory(4);
            createSdkMsg.setChatType(20);
            createSdkMsg.setMsgId(xh7.m());
            createSdkMsg.setMsgKey(create.getMsgKey());
            createSdkMsg.setChatRoomContentExt(json);
            createSdkMsg.setSenderUid(String.valueOf(create.getUserId()));
            createSdkMsg.setNickName(create.getUserName());
            createSdkMsg.setPortrait(create.getPortrait());
            if (this.g.t(this.c)) {
                x(this.l, createSdkMsg);
                return;
            }
            this.g.w(this.c, xh7.G(createSdkMsg));
        }
    }

    public final void m(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar, int i2, @NonNull String str, TreeSet<ChatMsg> treeSet, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{bVar, Integer.valueOf(i2), str, treeSet, str2}) == null) {
            eh.e(new i(this, i2, bVar, treeSet, str, str2));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            cb5 a2 = bb5.a();
            this.f = a2;
            a2.g(this.k);
            this.f.a(this.a, this.d, this.g);
        }
    }

    @Nullable
    public BaseMsg z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.g.r(this.c);
        }
        return (BaseMsg) invokeV.objValue;
    }

    public final void q(@NonNull eb5 eb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eb5Var) == null) {
            this.f.d(this.k);
            this.f.b(this.a, this.d, this.g);
            this.f.c(this.a, "SCENE_GROUP_CHAT", this.d, new e(this, eb5Var));
            TiebaStatic.log(new StatisticItem("c15089").param("fid", this.h.getBasicInfo().getForumId()).param("room_id", this.c).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void t(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar) {
        BaseMsg p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, bVar) != null) || !this.m.b("fetchMsgFirst") || !this.m.a("fetchHistoryMsg") || (p = this.g.p(this.c)) == null) {
            return;
        }
        bVar.d();
        this.f.f(this.a, this.c, p.getCommonMsgField().getMsgId(), 30, false, true, new j(this, bVar, "fetchHistoryMsg"));
    }

    public final void w(@Nullable l<TreeSet<ChatMsg>> lVar, boolean z) {
        BaseMsg q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, lVar, z) == null) {
            String str = "fetchLatestMsg" + z;
            if (!this.m.a(str) || (q = this.g.q(this.c)) == null) {
                return;
            }
            if (lVar != null) {
                eh.e(new k(this, lVar));
            }
            this.f.f(this.a, this.c, q.getCommonMsgField().getMsgId(), 30, false, false, new a(this, z, lVar, str));
        }
    }

    public void x(@Nullable l<TreeSet<ChatMsg>> lVar, @Nullable ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, lVar, chatMsg) != null) || !this.m.a("fetchMsgFirst")) {
            return;
        }
        if (lVar != null) {
            eh.e(new g(this, lVar));
        }
        this.f.f(this.a, this.c, 0L, 30, true, true, new h(this, chatMsg, lVar, "fetchMsgFirst"));
    }

    public void y(@Nullable FastRequest.b<ChatRoomDetail> bVar, @NonNull eb5 eb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bVar, eb5Var) == null) {
            if (this.e == null) {
                this.e = new FastRequest(this.b, CmdConfigHttp.CMD_HTTP_CHAT_ROOM_DETAIL, TbConfig.GET_CHAT_ROOM_DETAIL);
            }
            FastRequest fastRequest = this.e;
            fastRequest.H("chatroom_id", String.valueOf(this.c));
            fastRequest.J(new d(this, bVar, eb5Var));
            fastRequest.I();
        }
    }
}
