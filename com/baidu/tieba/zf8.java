package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class zf8<Adapter extends BaseNormalAdapter, Msg extends BaseItem<? extends TbBaseMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Adapter a;
    public int b;

    /* loaded from: classes9.dex */
    public interface e {
        void a();

        void b();

        void c(int i);
    }

    public void i(@NonNull Msg msg, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, msg, eVar) == null) {
        }
    }

    public abstract String j();

    public abstract boolean k(@NonNull Msg msg);

    public abstract void l(Msg msg, int i, int i2);

    /* loaded from: classes9.dex */
    public class b implements dp5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbBaseMsg a;
        public final /* synthetic */ BaseItem b;
        public final /* synthetic */ int c;
        public final /* synthetic */ zf8 d;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsg a;
            public final /* synthetic */ int b;
            public final /* synthetic */ b c;

            public a(b bVar, ChatMsg chatMsg, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, chatMsg, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = chatMsg;
                this.b = i;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.zf8 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ChatMsg chatMsg = this.a;
                    if (chatMsg != null) {
                        this.c.a.setOriginSdkMsg(chatMsg);
                        this.c.a.syncServerMsgId(this.a.getMsgId());
                    }
                    if (this.b == 0) {
                        i = 5;
                    } else {
                        i = 4;
                    }
                    b bVar = this.c;
                    bVar.d.m(bVar.b, i, bVar.c);
                    b bVar2 = this.c;
                    bVar2.d.l(bVar2.b, i, bVar2.c);
                }
            }
        }

        public b(zf8 zf8Var, TbBaseMsg tbBaseMsg, BaseItem baseItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf8Var, tbBaseMsg, baseItem, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zf8Var;
            this.a = tbBaseMsg;
            this.b = baseItem;
            this.c = i;
        }

        @Override // com.baidu.tieba.dp5
        public void onSendMessageResult(int i, @Nullable ChatMsg chatMsg) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, chatMsg) == null) {
                a aVar = new a(this, chatMsg, i);
                if (GlobalBuildConfig.isDebug()) {
                    j = this.d.b;
                } else {
                    j = 0;
                }
                lg.h(aVar, j);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseItem a;
        public final /* synthetic */ int b;
        public final /* synthetic */ zf8 c;

        public a(zf8 zf8Var, BaseItem baseItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf8Var, baseItem, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zf8Var;
            this.a = baseItem;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.h(this.a, this.b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseItem a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ zf8 d;

        public c(zf8 zf8Var, BaseItem baseItem, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf8Var, baseItem, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zf8Var;
            this.a = baseItem;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rx5.c(this.d.a, "必须要绑定数据适配器");
                this.a.setSendStatus(this.b);
                this.d.a.notifyItemChanged(this.c, 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseItem a;
        public final /* synthetic */ int b;
        public final /* synthetic */ zf8 c;

        @Override // com.baidu.tieba.zf8.e
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }

        public d(zf8 zf8Var, BaseItem baseItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf8Var, baseItem, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zf8Var;
            this.a = baseItem;
            this.b = i;
        }

        @Override // com.baidu.tieba.zf8.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g(this.a, this.b);
            }
        }

        @Override // com.baidu.tieba.zf8.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.c.m(this.a, 2, this.b);
        }
    }

    public zf8() {
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

    public final void m(@NonNull Msg msg, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, msg, i, i2) == null) {
            lg.c(new c(this, msg, i, i2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    public void f(@Nullable BaseNormalAdapter baseNormalAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, baseNormalAdapter) == null) {
            this.a = baseNormalAdapter;
        }
    }

    public final void g(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msg, i) == null) {
            lg.e(new a(this, msg, i));
        }
    }

    public final void o(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, msg, i) == null) {
            i(msg, new d(this, msg, i));
        }
    }

    @WorkerThread
    public final void h(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, msg, i) == null) {
            m(msg, 3, i);
            TbBaseMsg tbMsg = msg.getTbMsg();
            al8<?, ?> b2 = ik8.c.b(tbMsg.getClass());
            rx5.b(b2);
            ChatMsg chatMsg = (ChatMsg) gl8.a(b2, sk8.a, tbMsg);
            if (chatMsg == null) {
                m(msg, 4, i);
            } else {
                lo5.b().n(this.a.getContext(), tbMsg.getSessionId(), chatMsg, new b(this, tbMsg, msg, i));
            }
        }
    }

    public void n(@NonNull Msg msg, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, msg, i) == null) {
            rx5.c(this.a, "必须要绑定数据适配器");
            Monitor.a.b(new pra(String.valueOf(msg.getTbMsg().getMsgId()), "chatroom", j())).e();
            int sendStatus = msg.getSendStatus();
            if (sendStatus != 0 && sendStatus != 2) {
                z = false;
            } else {
                z = true;
            }
            if (k(msg) && z) {
                m(msg, 1, i);
                o(msg, i);
            } else if (sendStatus == 0 || sendStatus == 4) {
                g(msg, i);
            }
        }
    }
}
