package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.module.alalivesdk.imSdkPersonService.data.PersonFetchMsgResponse;
import com.baidu.tieba.impersonal.sprite.ImSpriteSysLog;
import com.baidu.tieba.q18;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class o18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final fg5 b;
    public final int c;
    public BroadcastReceiver d;
    public final q18 e;
    public final np5<String> f;
    public final String g;
    public final HashSet<b> h;

    /* loaded from: classes5.dex */
    public interface b {
        static {
            a aVar = a.a;
        }

        void a(List<? extends h08> list);

        void b(int i);

        void c();

        void d(String str);

        void e(int i);

        void f(int i, String str, ChatMsg chatMsg);

        void onError(int i);

        /* loaded from: classes5.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public static final /* synthetic */ a a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1372463192, "Lcom/baidu/tieba/o18$b$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1372463192, "Lcom/baidu/tieba/o18$b$a;");
                        return;
                    }
                }
                a = new a();
            }

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.o18.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void d(String msgKey) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msgKey) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void f(int i, String errorMsg, ChatMsg msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048580, this, i, errorMsg, msg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(msg, "msg");
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            }
        }

        public a() {
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

    public o18(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.a = context;
        this.b = eg5.a();
        this.c = 20;
        this.e = new q18(this.a);
        this.f = np5.c();
        this.g = "fetchMsgFirst";
        this.h = new HashSet<>();
    }

    public static final void c(final o18 this$0, String key, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        Integer num;
        List<ChatMsg> msgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{this$0, key, Integer.valueOf(i), str, personFetchMsgResponse}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "$key");
            if (i == 0) {
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.j());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.q(q18.k.a(), treeSet, new q18.e(1));
                ng.e(new Runnable() { // from class: com.baidu.tieba.g18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            o18.d(o18.this);
                        }
                    }
                });
            } else {
                w58 imSpriteSysLog = ImSpriteSysLog.getInstance();
                String n = this$0.e.n();
                StringBuilder sb = new StringBuilder();
                sb.append("fetchHistoryMsg ： responseCode : ");
                sb.append(i);
                sb.append("errMsg : ");
                sb.append(str);
                sb.append("response : ");
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs.size());
                } else {
                    num = null;
                }
                sb.append(num);
                imSpriteSysLog.c(n, sb.toString());
                ng.e(new Runnable() { // from class: com.baidu.tieba.y08
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            o18.e(o18.this);
                        }
                    }
                });
            }
            this$0.f.d(key);
        }
    }

    public static final void n(final o18 this$0, String key, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        Integer num;
        List<ChatMsg> msgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{this$0, key, Integer.valueOf(i), str, personFetchMsgResponse}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "$key");
            BdLog.e(StatConstants.KEY_EXT_ERR_MSG + str);
            if (i == 0) {
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.j());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.q(q18.k.a(), treeSet, new q18.e(0));
                ng.e(new Runnable() { // from class: com.baidu.tieba.a18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            o18.o(o18.this);
                        }
                    }
                });
            } else {
                w58 imSpriteSysLog = ImSpriteSysLog.getInstance();
                String n = this$0.e.n();
                StringBuilder sb = new StringBuilder();
                sb.append("firstFetchMsg ： responseCode : ");
                sb.append(i);
                sb.append("errMsg : ");
                sb.append(str);
                sb.append("response : ");
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs.size());
                } else {
                    num = null;
                }
                sb.append(num);
                imSpriteSysLog.c(n, sb.toString());
                ng.e(new Runnable() { // from class: com.baidu.tieba.j18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            o18.p(o18.this);
                        }
                    }
                });
            }
            this$0.f.d(key);
        }
    }

    public static final void d(o18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.b(1);
            }
        }
    }

    public static final void e(o18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(1);
            }
        }
    }

    public static final void f(o18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(1);
            }
        }
    }

    public static final void h(o18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(2);
            }
        }
    }

    public static final void j(o18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.b(2);
            }
        }
    }

    public static final void k(o18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(2);
            }
        }
    }

    public static final void m(o18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(0);
                bVar.c();
            }
        }
    }

    public static final void o(o18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.b(0);
            }
        }
    }

    public static final void p(o18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(0);
            }
        }
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (bVar != null) {
                this.h.add(bVar);
            }
            this.e.c(bVar);
        }
    }

    public final void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            ng.e(new Runnable() { // from class: com.baidu.tieba.d18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        o18.h(o18.this);
                    }
                }
            });
            this.b.b(this.a, j, Long.MAX_VALUE, this.c, q18.k.a(), new gg5() { // from class: com.baidu.tieba.b18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gg5
                public final void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                        o18.i(o18.this, i, str, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void v(q18.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.e.x(dVar);
        }
    }

    public static final void i(final o18 this$0, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        Integer num;
        List<ChatMsg> msgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65542, null, this$0, i, str, personFetchMsgResponse) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (i == 0) {
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.j());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.q(q18.k.a(), treeSet, new q18.e(2));
                ng.e(new Runnable() { // from class: com.baidu.tieba.i18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            o18.j(o18.this);
                        }
                    }
                });
                return;
            }
            w58 imSpriteSysLog = ImSpriteSysLog.getInstance();
            String n = this$0.e.n();
            StringBuilder sb = new StringBuilder();
            sb.append("fetchNextMsg ： responseCode : ");
            sb.append(i);
            sb.append("errMsg : ");
            sb.append(str);
            sb.append("response : ");
            if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                num = Integer.valueOf(msgs.size());
            } else {
                num = null;
            }
            sb.append(num);
            imSpriteSysLog.c(n, sb.toString());
            ng.e(new Runnable() { // from class: com.baidu.tieba.l18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        o18.k(o18.this);
                    }
                }
            });
        }
    }

    public final void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.f.b(this.g) && this.f.a("fetchHistoryMsg")) {
            ng.e(new Runnable() { // from class: com.baidu.tieba.c18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        o18.f(o18.this);
                    }
                }
            });
            this.b.b(this.a, 0L, j, -this.c, q18.k.a(), new gg5() { // from class: com.baidu.tieba.w08
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gg5
                public final void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                        o18.c(o18.this, r2, i, str, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void q(Object msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg instanceof k08) {
                k08 k08Var = (k08) msg;
                if (k08Var.g() instanceof ChatMsg) {
                    q18 q18Var = this.e;
                    Object g = k08Var.g();
                    if (g != null) {
                        q18Var.s((ChatMsg) g);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.imsdk.chatmessage.messages.ChatMsg");
                }
            }
        }
    }

    public final void t(String msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            ChatMsg a2 = x18.a(msg);
            if (a2 != null) {
                a2.setSendMsgTime(System.currentTimeMillis());
                this.e.q(q18.k.a(), this.e.y(a2), new q18.e(6));
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            final String str = this.g;
            if (!this.f.a(str)) {
                return;
            }
            ng.e(new Runnable() { // from class: com.baidu.tieba.m18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        o18.m(o18.this);
                    }
                }
            });
            this.b.b(this.a, 0L, Long.MAX_VALUE, this.c, q18.k.a(), new gg5() { // from class: com.baidu.tieba.k18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gg5
                public final void a(int i, String str2, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, personFetchMsgResponse) == null) {
                        o18.n(o18.this, str, i, str2, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = this.b.a(this.a, this.e);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.u(Long.MAX_VALUE);
        }
    }

    public final void w() {
        BroadcastReceiver broadcastReceiver;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (broadcastReceiver = this.d) != null) {
            fg5 fg5Var = this.b;
            Context context = this.a;
            Intrinsics.checkNotNull(broadcastReceiver);
            fg5Var.c(context, broadcastReceiver);
        }
    }

    public final void u(Object msg) {
        ChatMsg b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if ((msg instanceof l08) && (b2 = x18.b(msg)) != null) {
                b2.setContacter(q18.k.a());
                b2.setFromUser(AccountManager.getUK(this.a));
                b2.setStatus(1);
                b2.setSenderUid(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
                b2.setCategory(0);
                b2.setChatType(7);
                b2.setSendMsgTime(System.currentTimeMillis());
                b2.createMsgKey(this.a);
                b2.setContacterBduid(String.valueOf(q18.k.a()));
                this.e.t(b2);
            }
        }
    }
}
