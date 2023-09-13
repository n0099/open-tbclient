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
import com.baidu.tieba.log.TbLog;
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
/* loaded from: classes7.dex */
public final class n09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final lo5 b;
    public final int c;
    public BroadcastReceiver d;
    public final SpriteMsgProcessor e;
    public final ox5<String> f;
    public final String g;
    public final HashSet<b> h;

    /* loaded from: classes7.dex */
    public interface b {
        static {
            a aVar = a.a;
        }

        void a(List<? extends zy8> list);

        void b(int i, String str, ez8<?> ez8Var);

        void c(int i);

        void d(String str);

        void e(int i);

        void onError(int i);

        /* loaded from: classes7.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public static final /* synthetic */ a a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1229221673, "Lcom/baidu/tieba/n09$b$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1229221673, "Lcom/baidu/tieba/n09$b$a;");
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

    /* loaded from: classes7.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.n09.b
        public void b(int i, String errorMsg, ez8<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, errorMsg, msg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(msg, "msg");
            }
        }

        @Override // com.baidu.tieba.n09.b
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.n09.b
        public void d(String msgKey) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msgKey) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            }
        }

        @Override // com.baidu.tieba.n09.b
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.n09.b
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

    public n09(Context context) {
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
        this.b = ko5.a();
        this.c = 20;
        this.e = new SpriteMsgProcessor(this.a);
        this.f = ox5.c();
        this.g = "fetchMsgFirst";
        this.h = new HashSet<>();
    }

    public static final void c(final n09 this$0, String key, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        List<ChatMsg> msgs;
        List<ChatMsg> msgs2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{this$0, key, Integer.valueOf(i), str, personFetchMsgResponse}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "$key");
            Integer num = null;
            if (i == 0) {
                TbLog imSpriteSysLog = ImSpriteSysLog.getInstance();
                String r = this$0.e.r();
                StringBuilder sb = new StringBuilder();
                sb.append("fetchHistoryMsg success ：  responseCode : ");
                sb.append(i);
                sb.append(" errMsg : ");
                sb.append(str);
                sb.append(" response : ");
                if (personFetchMsgResponse != null && (msgs2 = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs2.size());
                }
                sb.append(num);
                imSpriteSysLog.i(r, sb.toString());
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.l());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.v(SpriteMsgProcessor.m.a(), treeSet, new SpriteMsgProcessor.e(1));
                mg.g(new Runnable() { // from class: com.baidu.tieba.g09
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            n09.d(n09.this);
                        }
                    }
                });
            } else {
                TbLog imSpriteSysLog2 = ImSpriteSysLog.getInstance();
                String r2 = this$0.e.r();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("fetchHistoryMsg error ：  responseCode : ");
                sb2.append(i);
                sb2.append(" errMsg : ");
                sb2.append(str);
                sb2.append(" response : ");
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs.size());
                }
                sb2.append(num);
                imSpriteSysLog2.i(r2, sb2.toString());
                mg.g(new Runnable() { // from class: com.baidu.tieba.xz8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            n09.e(n09.this);
                        }
                    }
                });
            }
            this$0.f.d(key);
        }
    }

    public static final void n(final n09 this$0, String key, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        List<ChatMsg> msgs;
        List<ChatMsg> msgs2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{this$0, key, Integer.valueOf(i), str, personFetchMsgResponse}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "$key");
            BdLog.e(StatConstants.KEY_EXT_ERR_MSG + str);
            Integer num = null;
            if (i == 0) {
                TbLog imSpriteSysLog = ImSpriteSysLog.getInstance();
                String r = this$0.e.r();
                StringBuilder sb = new StringBuilder();
                sb.append("firstFetchMsg success ：  responseCode : ");
                sb.append(i);
                sb.append(" errMsg : ");
                sb.append(str);
                sb.append(" response : ");
                if (personFetchMsgResponse != null && (msgs2 = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs2.size());
                }
                sb.append(num);
                imSpriteSysLog.i(r, sb.toString());
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.l());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.v(SpriteMsgProcessor.m.a(), treeSet, new SpriteMsgProcessor.e(0));
                mg.g(new Runnable() { // from class: com.baidu.tieba.a09
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            n09.o(n09.this);
                        }
                    }
                });
            } else {
                TbLog imSpriteSysLog2 = ImSpriteSysLog.getInstance();
                String r2 = this$0.e.r();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("firstFetchMsg error ：  responseCode : ");
                sb2.append(i);
                sb2.append(" errMsg : ");
                sb2.append(str);
                sb2.append(" response : ");
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs.size());
                }
                sb2.append(num);
                imSpriteSysLog2.i(r2, sb2.toString());
                mg.g(new Runnable() { // from class: com.baidu.tieba.j09
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            n09.p(n09.this);
                        }
                    }
                });
            }
            this$0.f.d(key);
        }
    }

    public static final void d(n09 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(1);
            }
        }
    }

    public static final void e(n09 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(1);
            }
        }
    }

    public static final void f(n09 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(1);
            }
        }
    }

    public static final void h(n09 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(2);
            }
        }
    }

    public static final void j(n09 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(2);
            }
        }
    }

    public static final void k(n09 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.onError(2);
            }
        }
    }

    public static final void m(n09 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.e(0);
            }
        }
    }

    public static final void o(n09 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (b bVar : this$0.h) {
                bVar.c(0);
            }
        }
    }

    public static final void p(n09 this$0) {
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
            mg.g(new Runnable() { // from class: com.baidu.tieba.e09
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        n09.h(n09.this);
                    }
                }
            });
            this.b.b(this.a, j, Long.MAX_VALUE, this.c, SpriteMsgProcessor.m.a(), new mo5() { // from class: com.baidu.tieba.b09
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mo5
                public final void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                        n09.i(n09.this, i, str, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void t(ez8<?> msg) {
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

    public static final void i(final n09 this$0, int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
        List<ChatMsg> msgs;
        List<ChatMsg> msgs2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65542, null, this$0, i, str, personFetchMsgResponse) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Integer num = null;
            if (i == 0) {
                TbLog imSpriteSysLog = ImSpriteSysLog.getInstance();
                String r = this$0.e.r();
                StringBuilder sb = new StringBuilder();
                sb.append("fetchNextMsg success ：  responseCode : ");
                sb.append(i);
                sb.append(" errMsg : ");
                sb.append(str);
                sb.append(" response : ");
                if (personFetchMsgResponse != null && (msgs2 = personFetchMsgResponse.getMsgs()) != null) {
                    num = Integer.valueOf(msgs2.size());
                }
                sb.append(num);
                imSpriteSysLog.i(r, sb.toString());
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.e.l());
                treeSet.addAll(personFetchMsgResponse.getMsgs());
                this$0.e.v(SpriteMsgProcessor.m.a(), treeSet, new SpriteMsgProcessor.e(2));
                mg.g(new Runnable() { // from class: com.baidu.tieba.i09
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            n09.j(n09.this);
                        }
                    }
                });
                return;
            }
            TbLog imSpriteSysLog2 = ImSpriteSysLog.getInstance();
            String r2 = this$0.e.r();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fetchNextMsg error ：  responseCode : ");
            sb2.append(i);
            sb2.append(" errMsg : ");
            sb2.append(str);
            sb2.append(" response : ");
            if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                num = Integer.valueOf(msgs.size());
            }
            sb2.append(num);
            imSpriteSysLog2.i(r2, sb2.toString());
            mg.g(new Runnable() { // from class: com.baidu.tieba.l09
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        n09.k(n09.this);
                    }
                }
            });
        }
    }

    public final void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.f.b(this.g) && this.f.a("fetchHistoryMsg")) {
            mg.g(new Runnable() { // from class: com.baidu.tieba.c09
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        n09.f(n09.this);
                    }
                }
            });
            this.b.b(this.a, 0L, j, -this.c, SpriteMsgProcessor.m.a(), new mo5() { // from class: com.baidu.tieba.vz8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mo5
                public final void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                        n09.c(n09.this, r2, i, str, personFetchMsgResponse);
                    }
                }
            });
        }
    }

    public final void q(Object msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg instanceof ez8) {
                ez8 ez8Var = (ez8) msg;
                if (ez8Var.h() instanceof ChatMsg) {
                    SpriteMsgProcessor spriteMsgProcessor = this.e;
                    Object h = ez8Var.h();
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
            mg.g(new Runnable() { // from class: com.baidu.tieba.m09
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        n09.m(n09.this);
                    }
                }
            });
            this.b.b(this.a, 0L, Long.MAX_VALUE, this.c, SpriteMsgProcessor.m.a(), new mo5() { // from class: com.baidu.tieba.k09
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mo5
                public final void a(int i, String str2, PersonFetchMsgResponse personFetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, personFetchMsgResponse) == null) {
                        n09.n(n09.this, str, i, str2, personFetchMsgResponse);
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
            lo5 lo5Var = this.b;
            Context context = this.a;
            Intrinsics.checkNotNull(broadcastReceiver);
            lo5Var.c(context, broadcastReceiver);
        }
    }
}
