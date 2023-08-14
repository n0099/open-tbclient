package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class oj8<Adapter extends BaseChatAdapter, Msg extends BaseMsg> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Adapter a;
    public int b;

    /* loaded from: classes7.dex */
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

    public abstract boolean j(@NonNull Msg msg);

    public abstract void k(BaseMsg baseMsg, int i, int i2);

    /* loaded from: classes7.dex */
    public class b implements rn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseMsg a;
        public final /* synthetic */ int b;
        public final /* synthetic */ oj8 c;

        /* loaded from: classes7.dex */
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

            @Override // java.lang.Runnable
            public void run() {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ChatMsg chatMsg = this.a;
                    if (chatMsg != null) {
                        this.c.a.setSdkMsg(chatMsg);
                        this.c.a.syncServerMsgId(this.a);
                    }
                    if (this.b == 0) {
                        i = 5;
                    } else {
                        i = 4;
                    }
                    b bVar = this.c;
                    bVar.c.l(bVar.a, i, bVar.b);
                    b bVar2 = this.c;
                    bVar2.c.k(bVar2.a, i, bVar2.b);
                }
            }
        }

        public b(oj8 oj8Var, BaseMsg baseMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj8Var, baseMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oj8Var;
            this.a = baseMsg;
            this.b = i;
        }

        @Override // com.baidu.tieba.rn5
        public void onSendMessageResult(int i, @Nullable ChatMsg chatMsg) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, chatMsg) == null) {
                a aVar = new a(this, chatMsg, i);
                if (GlobalBuildConfig.isDebug()) {
                    j = this.c.b;
                } else {
                    j = 0;
                }
                lg.h(aVar, j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseMsg a;
        public final /* synthetic */ int b;
        public final /* synthetic */ oj8 c;

        public a(oj8 oj8Var, BaseMsg baseMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj8Var, baseMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oj8Var;
            this.a = baseMsg;
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

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseMsg a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ oj8 d;

        public c(oj8 oj8Var, BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj8Var, baseMsg, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = oj8Var;
            this.a = baseMsg;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dw5.c(this.d.a, "必须要绑定数据适配器");
                this.a.setItemStatus(this.b);
                this.d.a.notifyItemChanged(this.c, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseMsg a;
        public final /* synthetic */ int b;
        public final /* synthetic */ oj8 c;

        @Override // com.baidu.tieba.oj8.e
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }

        public d(oj8 oj8Var, BaseMsg baseMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj8Var, baseMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oj8Var;
            this.a = baseMsg;
            this.b = i;
        }

        @Override // com.baidu.tieba.oj8.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g(this.a, this.b);
            }
        }

        @Override // com.baidu.tieba.oj8.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.c.l(this.a, 2, this.b);
        }
    }

    public oj8() {
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

    public final void l(@NonNull Msg msg, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, msg, i, i2) == null) {
            lg.c(new c(this, msg, i, i2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    public void f(@Nullable BaseChatAdapter baseChatAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, baseChatAdapter) == null) {
            this.a = baseChatAdapter;
        }
    }

    public final void g(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msg, i) == null) {
            lg.e(new a(this, msg, i));
        }
    }

    public final void n(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, msg, i) == null) {
            i(msg, new d(this, msg, i));
        }
    }

    @WorkerThread
    public final void h(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, msg, i) == null) {
            l(msg, 3, i);
            CommonMsgField commonMsgField = msg.getCommonMsgField();
            msg.clearSdkMsgRedundancyFields();
            zm5.b().n(this.a.getContext(), commonMsgField.getRoomId(), msg.getSdkMsg(), new b(this, msg, i));
        }
    }

    public void m(@NonNull Msg msg, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, msg, i) == null) {
            dw5.c(this.a, "必须要绑定数据适配器");
            int itemStatus = msg.getItemStatus();
            if (itemStatus != 0 && itemStatus != 2) {
                z = false;
            } else {
                z = true;
            }
            if (j(msg) && z) {
                l(msg, 1, i);
                n(msg, i);
            } else if (itemStatus == 0 || itemStatus == 4) {
                g(msg, i);
            }
        }
    }
}
