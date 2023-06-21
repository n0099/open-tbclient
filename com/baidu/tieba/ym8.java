package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.module.alalivesdk.imSdkPersonService.data.PersonFetchMsgResponse;
import com.baidu.tieba.impersonal.sprite.ImSpriteSysLog;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
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
/* loaded from: classes8.dex */
public final class ym8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final un5 b;
    public final int c;
    public BroadcastReceiver d;
    public final SpriteMsgProcessor e;
    public final ex5<String> f;
    public final String g;
    public final HashSet<b> h;

    /* loaded from: classes8.dex */
    public interface b {
        static {
            a aVar = a.a;
        }

        void a(List<? extends ll8> list);

        void b(int i, String str, ql8<?> ql8Var);

        void c(int i);

        void d(String str);

        void e(int i);

        void onError(int i);

        /* loaded from: classes8.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public static final /* synthetic */ a a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-963656630, "Lcom/baidu/tieba/ym8$b$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-963656630, "Lcom/baidu/tieba/ym8$b$a;");
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

    /* loaded from: classes8.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ym8.b
        public void b(int i, String errorMsg, ql8<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, errorMsg, msg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(msg, "msg");
            }
        }

        @Override // com.baidu.tieba.ym8.b
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.ym8.b
        public void d(String msgKey) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msgKey) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            }
        }

        @Override // com.baidu.tieba.ym8.b
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.ym8.b
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
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

    public ym8(Context context) {
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
        this.b = tn5.a();
        this.c = 20;
        this.e = new SpriteMsgProcessor(this.a);
        this.f = ex5.c();
        this.g = "fetchMsgFirst";
        this.h = new HashSet<>();
    }

    public static final void c(final ym8 this$0, String key, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        Integer num;
        List<ChatMsg> msgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{this$0, key, Integer.valueOf(i), str, personFetchMsgResponse}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "$key");
            if (i == 0) {
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.l());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.v(SpriteMsgProcessor.m.a(), treeSet, new SpriteMsgProcessor.e(1));
                bh.e(new Runnable() { // from class: com.baidu.tieba.rm8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ym8.d(ym8.this);
                        }
                    }
                });
            } else {
                tr8 imSpriteSysLog = ImSpriteSysLog.getInstance();
                String r = this$0.e.r();
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
                imSpriteSysLog.c(r, sb.toString());
                bh.e(new Runnable() { // from class: com.baidu.tieba.im8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ym8.e(ym8.this);
                        }
                    }
                });
            }
            this$0.f.d(key);
        }
    }

    public static final void n(final ym8 this$0, String key, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        Integer num;
        List<ChatMsg> msgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{this$0, key, Integer.valueOf(i), str, personFetchMsgResponse}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "$key");
            BdLog.e(StatConstants.KEY_EXT_ERR_MSG + str);
            if (i == 0) {
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.l());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.v(SpriteMsgProcessor.m.a(), treeSet, new SpriteMsgProcessor.e(0));
                bh.e(new Runnable() { // from class: com.baidu.tieba.lm8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ym8.o(ym8.this);
                        }
                    }
                });
            } else {
                tr8 imSpriteSysLog = ImSpriteSysLog.getInstance();
                String r = this$0.e.r();
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
                imSpriteSysLog.c(r, sb.toString());
                bh.e(new Runnable() { // from class: com.baidu.tieba.um8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ym8.p(ym8.this);
                        }
                    }
                });
            }
            this$0.f.d(key);
        }
    }

    public static final void d(ym8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(1);
            }
        }
    }

    public static final void e(ym8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(1);
            }
        }
    }

    public static final void f(ym8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(1);
            }
        }
    }

    public static final void h(ym8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(2);
            }
        }
    }

    public static final void j(ym8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(2);
            }
        }
    }

    public static final void k(ym8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(2);
            }
        }
    }

    public static final void m(ym8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(0);
            }
        }
    }

    public static final void o(ym8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(0);
            }
        }
    }

    public static final void p(ym8 this$0) {
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
            this.e.e(bVar);
        }
    }

    public final void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            bh.e(new Runnable() { // from class: com.baidu.tieba.pm8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ym8.h(ym8.this);
                    }
                }
            });
            this.b.b(this.a, j, Long.MAX_VALUE, this.c, SpriteMsgProcessor.m.a(), new vn5() { // from class: com.baidu.tieba.mm8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.vn5
                public final void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                        ym8.i(ym8.this, i, str, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void t(ql8<?> msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.e.E(msg);
        }
    }

    public final void u(SpriteMsgProcessor.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.e.F(dVar);
        }
    }

    public static final void i(final ym8 this$0, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        Integer num;
        List<ChatMsg> msgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65542, null, this$0, i, str, personFetchMsgResponse) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (i == 0) {
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.l());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.v(SpriteMsgProcessor.m.a(), treeSet, new SpriteMsgProcessor.e(2));
                bh.e(new Runnable() { // from class: com.baidu.tieba.tm8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ym8.j(ym8.this);
                        }
                    }
                });
                return;
            }
            tr8 imSpriteSysLog = ImSpriteSysLog.getInstance();
            String r = this$0.e.r();
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
            imSpriteSysLog.c(r, sb.toString());
            bh.e(new Runnable() { // from class: com.baidu.tieba.wm8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ym8.k(ym8.this);
                    }
                }
            });
        }
    }

    public final void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.f.b(this.g) && this.f.a("fetchHistoryMsg")) {
            bh.e(new Runnable() { // from class: com.baidu.tieba.nm8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ym8.f(ym8.this);
                    }
                }
            });
            this.b.b(this.a, 0L, j, -this.c, SpriteMsgProcessor.m.a(), new vn5() { // from class: com.baidu.tieba.gm8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.vn5
                public final void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                        ym8.c(ym8.this, r2, i, str, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void q(Object msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg instanceof ql8) {
                ql8 ql8Var = (ql8) msg;
                if (ql8Var.h() instanceof ChatMsg) {
                    SpriteMsgProcessor spriteMsgProcessor = this.e;
                    Object h = ql8Var.h();
                    if (h != null) {
                        spriteMsgProcessor.y((ChatMsg) h);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.imsdk.chatmessage.messages.ChatMsg");
                }
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
            bh.e(new Runnable() { // from class: com.baidu.tieba.xm8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ym8.m(ym8.this);
                    }
                }
            });
            this.b.b(this.a, 0L, Long.MAX_VALUE, this.c, SpriteMsgProcessor.m.a(), new vn5() { // from class: com.baidu.tieba.vm8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.vn5
                public final void a(int i, String str2, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, personFetchMsgResponse) == null) {
                        ym8.n(ym8.this, str, i, str2, personFetchMsgResponse);
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
            this.e.D();
        }
    }

    public final void v() {
        BroadcastReceiver broadcastReceiver;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (broadcastReceiver = this.d) != null) {
            un5 un5Var = this.b;
            Context context = this.a;
            Intrinsics.checkNotNull(broadcastReceiver);
            un5Var.c(context, broadcastReceiver);
        }
    }
}
