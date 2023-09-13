package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tieba.ho5;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.ipa;
import com.baidu.tieba.mg;
import com.baidu.tieba.qx5;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.tieba.zo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.HashMap;
/* loaded from: classes6.dex */
public abstract class MsgSendHelper<Adapter extends BaseChatAdapter, Msg extends BaseMsg> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Adapter a;
    public int b;

    /* loaded from: classes6.dex */
    public interface d {
        void a();

        void b();

        void c(int i);
    }

    public void i(@NonNull Msg msg, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, msg, dVar) == null) {
        }
    }

    public abstract String j();

    public abstract boolean k(@NonNull Msg msg);

    public abstract void l(BaseMsg baseMsg, int i, int i2);

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseMsg a;
        public final /* synthetic */ int b;
        public final /* synthetic */ MsgSendHelper c;

        public a(MsgSendHelper msgSendHelper, BaseMsg baseMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgSendHelper, baseMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = msgSendHelper;
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

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseMsg a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ MsgSendHelper d;

        public b(MsgSendHelper msgSendHelper, BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgSendHelper, baseMsg, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = msgSendHelper;
            this.a = baseMsg;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qx5.c(this.d.a, "必须要绑定数据适配器");
                this.a.setItemStatus(this.b);
                this.d.a.notifyItemChanged(this.c, 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseMsg a;
        public final /* synthetic */ int b;
        public final /* synthetic */ MsgSendHelper c;

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.MsgSendHelper.d
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }

        public c(MsgSendHelper msgSendHelper, BaseMsg baseMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgSendHelper, baseMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = msgSendHelper;
            this.a = baseMsg;
            this.b = i;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.MsgSendHelper.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g(this.a, this.b);
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.MsgSendHelper.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.c.m(this.a, 2, this.b);
        }
    }

    public MsgSendHelper() {
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
            mg.c(new b(this, msg, i, i2));
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
            mg.e(new a(this, msg, i));
        }
    }

    public final void o(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, msg, i) == null) {
            i(msg, new c(this, msg, i));
        }
    }

    @WorkerThread
    public final void h(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, msg, i) == null) {
            m(msg, 3, i);
            CommonMsgField commonMsgField = msg.getCommonMsgField();
            String valueOf = String.valueOf(commonMsgField.getMsgId());
            msg.clearSdkMsgRedundancyFields();
            ho5.b().n(this.a.getContext(), commonMsgField.getRoomId(), msg.getSdkMsg(), new zo5(this, msg, i, valueOf) { // from class: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.MsgSendHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseMsg a;
                public final /* synthetic */ int b;
                public final /* synthetic */ String c;
                public final /* synthetic */ MsgSendHelper d;

                /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.MsgSendHelper$2$a */
                /* loaded from: classes6.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatMsg a;
                    public final /* synthetic */ int b;
                    public final /* synthetic */ AnonymousClass2 c;

                    public a(AnonymousClass2 anonymousClass2, ChatMsg chatMsg, int i) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, chatMsg, Integer.valueOf(i)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.c = anonymousClass2;
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
                            AnonymousClass2 anonymousClass2 = this.c;
                            anonymousClass2.d.m(anonymousClass2.a, i, anonymousClass2.b);
                            AnonymousClass2 anonymousClass22 = this.c;
                            anonymousClass22.d.l(anonymousClass22.a, i, anonymousClass22.b);
                        }
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, msg, Integer.valueOf(i), valueOf};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.d = this;
                    this.a = msg;
                    this.b = i;
                    this.c = valueOf;
                }

                @Override // com.baidu.tieba.zo5
                public void onSendMessageResult(int i2, @Nullable ChatMsg chatMsg) {
                    long j;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, chatMsg) == null) {
                        a aVar = new a(this, chatMsg, i2);
                        if (GlobalBuildConfig.isDebug()) {
                            j = this.d.b;
                        } else {
                            j = 0;
                        }
                        mg.h(aVar, j);
                        if (i2 == 0 && chatMsg != null) {
                            Monitor.a.b(new ipa(this.c)).g(new HashMap<String, String>(this, chatMsg) { // from class: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.MsgSendHelper.2.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;
                                public final /* synthetic */ ChatMsg val$chatMsg;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, chatMsg};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$chatMsg = chatMsg;
                                    put("msg_type", String.valueOf(this.val$chatMsg.getMsgType()));
                                }
                            });
                        } else {
                            Monitor.a.b(new ipa(this.c)).b(new HashMap<String, String>(this, i2, chatMsg) { // from class: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.MsgSendHelper.2.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;
                                public final /* synthetic */ ChatMsg val$chatMsg;
                                public final /* synthetic */ int val$responseCode;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i2), chatMsg};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$responseCode = i2;
                                    this.val$chatMsg = chatMsg;
                                    put(PushMessageHelper.ERROR_TYPE, String.valueOf(this.val$responseCode));
                                    put("error_info", String.valueOf(this.val$responseCode));
                                    ChatMsg chatMsg2 = this.val$chatMsg;
                                    if (chatMsg2 != null) {
                                        put("msg_type", String.valueOf(chatMsg2.getMsgType()));
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    public void n(@NonNull Msg msg, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, msg, i) == null) {
            qx5.c(this.a, "必须要绑定数据适配器");
            Monitor.a.b(new ipa(String.valueOf(msg.getCommonMsgField().getMsgId()), "chatroom", j())).e();
            int itemStatus = msg.getItemStatus();
            if (itemStatus != 0 && itemStatus != 2) {
                z = false;
            } else {
                z = true;
            }
            if (k(msg) && z) {
                m(msg, 1, i);
                o(msg, i);
            } else if (itemStatus == 0 || itemStatus == 4) {
                g(msg, i);
            }
        }
    }
}
