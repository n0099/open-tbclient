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
import com.baidu.android.imsdk.db.TableDefine;
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
import com.baidu.tieba.fh;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.pb5;
import com.baidu.tieba.pg7;
import com.baidu.tieba.pr4;
import com.baidu.tieba.qb5;
import com.baidu.tieba.qk5;
import com.baidu.tieba.sb5;
import com.baidu.tieba.sk5;
import com.baidu.tieba.tb5;
import com.baidu.tieba.tl7;
import com.baidu.tieba.wb5;
import com.baidu.tieba.xb5;
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
    public qb5 f;
    public final tl7 g;
    public long h;
    @Nullable
    public ChatRoomDetail i;
    @Nullable
    public IChatRoomEnterListener.ChatRoomInfo j;
    public boolean k;
    public boolean l;
    public final wb5 m;
    @Nullable
    public n<TreeSet<ChatMsg>> n;
    @NonNull
    public final qk5<String> o;
    public int p;

    /* loaded from: classes4.dex */
    public class k implements xb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsg a;
        public final /* synthetic */ n b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.g();
                }
            }
        }

        public k(GroupChatRepo groupChatRepo, ChatMsg chatMsg, n nVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, chatMsg, nVar, str};
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
            this.b = nVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.xb5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                this.d.g.F(this.d.c);
                this.d.g.x(i, this.d.c, treeSet);
                if (this.a != null) {
                    this.d.g.y(this.d.c, tl7.K(this.a));
                }
                n nVar = this.b;
                if (nVar != null) {
                    this.d.m(nVar, i, str, treeSet, this.c);
                }
                if (this.b != null) {
                    fh.e(new a(this));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public a(GroupChatRepo groupChatRepo, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
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
    public class b implements xb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ n b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        public b(GroupChatRepo groupChatRepo, boolean z, n nVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, Boolean.valueOf(z), nVar, str};
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
            this.b = nVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.xb5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    if (treeSet.size() >= 5 && !this.d.g.v(this.d.c, treeSet)) {
                        if (this.a) {
                            this.d.g.j(this.d.c);
                        }
                    } else {
                        this.d.g.G(this.d.c, false);
                    }
                    this.d.g.x(i, this.d.c, treeSet);
                }
                n nVar = this.b;
                if (nVar == null) {
                    return;
                }
                this.d.m(nVar, i, str, treeSet, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements xb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupChatRepo c;

        public c(GroupChatRepo groupChatRepo, o oVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, oVar, str};
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
            this.a = oVar;
            this.b = str;
        }

        @Override // com.baidu.tieba.xb5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    this.c.g.x(i, this.c.c, treeSet);
                }
                this.c.m(this.a, i, str, treeSet, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements tb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.tb5
        public void a(long j, int i, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            }
        }

        public d(GroupChatRepo groupChatRepo) {
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
    public class e implements wb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public e(GroupChatRepo groupChatRepo) {
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

        @Override // com.baidu.tieba.wb5
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 0) {
                GroupChatRepo groupChatRepo = this.a;
                groupChatRepo.w(groupChatRepo.n, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ sb5 c;
        public final /* synthetic */ GroupChatRepo d;

        public f(GroupChatRepo groupChatRepo, FastRequest.b bVar, sb5 sb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, bVar, sb5Var};
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
            this.c = sb5Var;
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
                    this.d.i = chatRoomDetail;
                    sb5 sb5Var = this.c;
                    if (sb5Var != null) {
                        this.d.q(sb5Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements sb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb5 a;
        public final /* synthetic */ GroupChatRepo b;

        public g(GroupChatRepo groupChatRepo, sb5 sb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, sb5Var};
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
            this.a = sb5Var;
        }

        @Override // com.baidu.tieba.sb5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                this.a.a(j, i, str, chatRoomInfo);
                if (i != 0) {
                    return;
                }
                this.b.j = chatRoomInfo;
                ChatMsg k = this.b.g.k(j, this.b.a.getString(R.string.obfuscated_res_0x7f0f0843));
                GroupChatRepo groupChatRepo = this.b;
                groupChatRepo.x(groupChatRepo.n, k);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseChatMsg a;
        public final /* synthetic */ GroupChatRepo b;

        public h(GroupChatRepo groupChatRepo, BaseChatMsg baseChatMsg) {
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
            this.b.K(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public i(GroupChatRepo groupChatRepo) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public j(GroupChatRepo groupChatRepo, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
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
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ TreeSet c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ GroupChatRepo f;

        public l(GroupChatRepo groupChatRepo, int i, FastRequest.b bVar, TreeSet treeSet, String str, String str2) {
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
                this.f.o.d(this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements xb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupChatRepo c;

        public m(GroupChatRepo groupChatRepo, FastRequest.b bVar, String str) {
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

        @Override // com.baidu.tieba.xb5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    this.c.g.x(i, this.c.c, treeSet);
                }
                this.c.m(this.a, i, str, treeSet, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class n<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void f();

        public abstract void g();

        public n() {
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

    /* loaded from: classes4.dex */
    public static abstract class o<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void f(int i);

        public o() {
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
        this.f = pb5.b();
        this.g = new tl7();
        this.k = true;
        this.l = false;
        this.m = new e(this);
        this.o = qk5.c();
        this.b = tbPageContext;
        this.a = tbPageContext.getPageActivity();
        this.c = j2;
        this.d = Collections.singletonList(Long.valueOf(j2));
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l = z;
        }
    }

    public void I(@Nullable FastRequest.b<ChatRoomDetail> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, bVar) != null) || !this.l) {
            return;
        }
        this.l = false;
        y(bVar, null);
    }

    public <T extends BaseChatMsg> void J(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
            fh.d(new h(this, t));
        }
    }

    public void L(@Nullable n<TreeSet<ChatMsg>> nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nVar) == null) {
            this.n = nVar;
        }
    }

    public void M(@Nullable tl7.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
            this.g.H(hVar);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.k = z;
        }
    }

    public void O(@Nullable tl7.j<? extends BaseSysMsg> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jVar) == null) {
            this.g.J(jVar);
        }
    }

    public void u(@Nullable n<TreeSet<ChatMsg>> nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, nVar) == null) && this.g.u(this.c)) {
            w(nVar, false);
        }
    }

    public void G(int i2, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, cls) == null) {
            this.g.D(i2, cls);
        }
    }

    public void H(List<Integer> list, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, cls) == null) {
            this.g.E(list, cls);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (this.k) {
                this.f.e(this.a, "SCENE_GROUP_CHAT", this.d, new d(this));
            }
            this.f.g(this.m);
            this.f.a(this.a, this.d, this.g);
            FastRequest fastRequest = this.e;
            if (fastRequest != null) {
                fastRequest.onDestroy();
            }
        }
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g.u(this.c);
        }
        return invokeV.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (B()) {
                this.g.F(this.c);
                this.g.w(this.c, tl7.i.a(true, false, false));
                return;
            }
            n<TreeSet<ChatMsg>> nVar = this.n;
            if (nVar != null) {
                nVar.f();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            qb5 a2 = pb5.a();
            this.f = a2;
            a2.g(this.m);
            this.f.a(this.a, this.d, this.g);
        }
    }

    @Nullable
    public BaseMsg z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.g.q(this.c);
        }
        return (BaseMsg) invokeV.objValue;
    }

    public void E(long j2, @NonNull String str, @NonNull o<TreeSet<ChatMsg>> oVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, oVar}) != null) || !this.o.a("jumpToMsg")) {
            return;
        }
        int s = this.g.s(this.c, str);
        if (s > 0) {
            oVar.f(s);
            this.o.d("jumpToMsg");
            return;
        }
        this.g.j(this.c);
        oVar.d();
        oVar.f(0);
        this.f.f(this.a, this.c, j2, 30, false, false, new c(this, oVar, "jumpToMsg"));
    }

    @WorkerThread
    public final <T extends BaseChatMsg> void K(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
            pr4 s = pr4.s();
            sk5.d(s.B());
            sk5.b(this.i);
            ChatRoomDetail.UserInfo userInfo = this.i.getUserInfo();
            ChatRoomDetail.BasicInfo basicInfo = this.i.getBasicInfo();
            CommonMsgField commonMsgFieldNullable = t.getCommonMsgFieldNullable();
            if (commonMsgFieldNullable != null) {
                commonMsgFieldNullable.setMsgKey(CommonMsgField.generateMsgKey(commonMsgFieldNullable.getUserId(), this.c));
            } else {
                this.p++;
                t.setItemStatus(0);
                commonMsgFieldNullable = CommonMsgField.create(s.i(), this.c);
                commonMsgFieldNullable.setUserName(s.l());
                commonMsgFieldNullable.setPortrait(s.q());
                commonMsgFieldNullable.setRole(userInfo.getIdentityRole());
                commonMsgFieldNullable.setLevel(userInfo.getForumLevel());
            }
            commonMsgFieldNullable.setFromAndroid();
            commonMsgFieldNullable.setType(t.getMsgType());
            commonMsgFieldNullable.setContent(DataExt.toMap(t));
            commonMsgFieldNullable.setForumId(basicInfo.getForumId());
            commonMsgFieldNullable.setLocalMsgId(true);
            String json = DataExt.toJson(commonMsgFieldNullable);
            ChatMsg createSdkMsg = t.createSdkMsg();
            t.fillSdkMsg4Base(createSdkMsg);
            createSdkMsg.setCategory(4);
            createSdkMsg.setChatType(20);
            createSdkMsg.setMsgId(tl7.l());
            createSdkMsg.setMsgKey(commonMsgFieldNullable.getMsgKey());
            createSdkMsg.setChatRoomContentExt(json);
            createSdkMsg.setSenderUid(String.valueOf(commonMsgFieldNullable.getUserId()));
            createSdkMsg.setNickName(commonMsgFieldNullable.getUserName());
            createSdkMsg.setPortrait(commonMsgFieldNullable.getPortrait());
            if (B()) {
                this.g.F(this.c);
                if (this.n != null) {
                    fh.e(new i(this));
                }
            }
            this.g.y(this.c, tl7.K(createSdkMsg));
        }
    }

    public final void m(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar, int i2, @NonNull String str, TreeSet<ChatMsg> treeSet, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{bVar, Integer.valueOf(i2), str, treeSet, str2}) == null) {
            fh.e(new l(this, i2, bVar, treeSet, str, str2));
        }
    }

    public final void q(@NonNull sb5 sb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sb5Var) == null) {
            this.f.d(this.m);
            this.f.b(this.a, this.d, this.g);
            this.f.c(this.a, "SCENE_GROUP_CHAT", this.d, new g(this, sb5Var));
            TiebaStatic.log(new StatisticItem("c15089").param("fid", this.i.getBasicInfo().getForumId()).param("room_id", this.c).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void t(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) && this.o.b("fetchMsgFirst") && this.o.a("fetchHistoryMsg")) {
            BaseMsg p = this.g.p(this.c);
            if (p == null) {
                this.o.d("fetchHistoryMsg");
                return;
            }
            bVar.d();
            this.f.f(this.a, this.c, p.getCommonMsgField().getMsgId(), 30, false, true, new m(this, bVar, "fetchHistoryMsg"));
        }
    }

    public final void w(@Nullable n<TreeSet<ChatMsg>> nVar, boolean z) {
        BaseMsg q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, nVar, z) == null) {
            String str = "fetchLatestMsg" + z;
            if (!this.o.a(str) || (q = this.g.q(this.c)) == null) {
                return;
            }
            if (nVar != null && !z) {
                fh.e(new a(this, nVar));
            }
            this.f.f(this.a, this.c, q.getCommonMsgField().getMsgId(), 30, false, false, new b(this, z, nVar, str));
        }
    }

    public void y(@Nullable FastRequest.b<ChatRoomDetail> bVar, @Nullable sb5 sb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, bVar, sb5Var) == null) {
            GroupChatRoomPojo c2 = pg7.f().c(TbadkCoreApplication.getCurrentAccount(), this.c);
            if (c2 != null) {
                this.h = c2.getLatestMsgId();
            }
            if (this.e == null) {
                this.e = new FastRequest(this.b, CmdConfigHttp.CMD_HTTP_CHAT_ROOM_DETAIL, TbConfig.GET_CHAT_ROOM_DETAIL);
            }
            FastRequest fastRequest = this.e;
            fastRequest.H(TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_ID, String.valueOf(this.h));
            fastRequest.H("chatroom_id", String.valueOf(this.c));
            fastRequest.J(new f(this, bVar, sb5Var));
            fastRequest.I();
        }
    }

    public void x(@Nullable n<TreeSet<ChatMsg>> nVar, @Nullable ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048596, this, nVar, chatMsg) != null) || !this.o.a("fetchMsgFirst")) {
            return;
        }
        if (nVar != null) {
            fh.e(new j(this, nVar));
        }
        this.f.f(this.a, this.c, 0L, 30, true, true, new k(this, chatMsg, nVar, "fetchMsgFirst"));
    }
}
