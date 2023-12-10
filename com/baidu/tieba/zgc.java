package com.baidu.tieba;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.render.RenderEngine;
import com.yy.render.trans.SimpleClientMessageSender;
import com.yy.transvod.player.log.TLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zgc implements vfc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zgc h;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean a;
    public AtomicBoolean b;
    public int c;
    public a d;
    public Handler e;
    public WeakReference<xgc> f;
    public WeakReference<Looper> g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948360435, "Lcom/baidu/tieba/zgc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948360435, "Lcom/baidu/tieba/zgc;");
        }
    }

    /* loaded from: classes9.dex */
    public class a extends SimpleClientMessageSender {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String f;
        public final /* synthetic */ zgc g;

        @Override // com.yy.render.trans.SimpleClientMessageSender
        public void d(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
            }
        }

        @Override // com.yy.render.trans.SimpleClientMessageSender
        public String e(String str, Bitmap bitmap) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bitmap)) == null) {
                return null;
            }
            return (String) invokeLL.objValue;
        }

        @Override // com.yy.render.trans.SimpleClientMessageSender
        public void f(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle) == null) {
            }
        }

        @Override // com.yy.render.trans.SimpleClientMessageSender
        public String g(String str, Bundle bundle) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
                return null;
            }
            return (String) invokeLL.objValue;
        }

        @Override // com.yy.render.trans.SimpleClientMessageSender
        public String i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
                return null;
            }
            return (String) invokeLL.objValue;
        }

        @Override // com.yy.render.trans.SimpleClientMessageSender
        public void j(String str, int i, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048582, this, str, i, str2, str3) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.zgc$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class HandlerC0549a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC0549a(a aVar, Looper looper) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, looper};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                xgc xgcVar;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || (xgcVar = (xgc) this.a.g.f.get()) == null) {
                    return;
                }
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        xgcVar.b(message.arg1, message.arg2, (String) message.obj);
                        return;
                    }
                    return;
                }
                ygc ygcVar = (ygc) message.obj;
                xgcVar.a(ygcVar.a, ygcVar.b, ygcVar.c, ygcVar.d);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zgc zgcVar, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zgcVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zgcVar;
            this.f = str;
        }

        @Override // com.yy.render.trans.SimpleClientMessageSender
        public void h(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048580, this, str, str2) != null) || !str.equals(this.f)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                o(jSONObject.optString("cmd"), jSONObject.getJSONObject("data"));
            } catch (Exception e) {
                e.printStackTrace();
                TLog.d("[P2pManagerClient]", "(onDataFromServer) ex" + e.getMessage());
            }
        }

        @Override // com.yy.render.trans.SimpleClientMessageSender
        public void k(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                TLog.g(this, "P2pManagerClient onServiceCrash: " + str);
            }
        }

        public final void n() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.g.e == null) {
                Looper looper = (Looper) this.g.g.get();
                if (looper == null) {
                    looper = Looper.getMainLooper();
                }
                this.g.e = new HandlerC0549a(this, looper);
            }
        }

        public final void o(String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048585, this, str, jSONObject) == null) && jSONObject != null) {
                n();
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 144413458) {
                    if (hashCode != 1541535551) {
                        if (hashCode == 2091728354 && str.equals("onUpdatePcdnResult")) {
                            c = 2;
                        }
                    } else if (str.equals("onShareStats")) {
                        c = 0;
                    }
                } else if (str.equals("onJsonContent")) {
                    c = 1;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c == 2) {
                            int optInt = jSONObject.optInt("playTaskId");
                            int optInt2 = jSONObject.optInt("result");
                            String optString = jSONObject.optString("pcdnUrl");
                            if (this.g.e != null) {
                                this.g.e.sendMessage(Message.obtain(this.g.e, 3, optInt, optInt2, optString));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    int optInt3 = jSONObject.optInt("playTaskId");
                    int optInt4 = jSONObject.optInt("cbKye");
                    String optString2 = jSONObject.optString("json");
                    if (this.g.e != null) {
                        this.g.e.sendMessage(Message.obtain(this.g.e, 2, optInt3, optInt4, optString2));
                        return;
                    }
                    return;
                }
                int optInt5 = jSONObject.optInt("playTaskId");
                int optInt6 = jSONObject.optInt("shareUpStreamFlow");
                int optInt7 = jSONObject.optInt("shareDownStreamFlow");
                int optInt8 = jSONObject.optInt("serverDownStreamFlow");
                if (this.g.e != null) {
                    this.g.e.sendMessage(Message.obtain(this.g.e, 1, new ygc(optInt5, optInt6, optInt7, optInt8)));
                }
            }
        }
    }

    public zgc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.c = hashCode();
        this.d = null;
        this.e = null;
        this.f = new WeakReference<>(null);
        this.g = new WeakReference<>(null);
        this.d = new a(this, String.valueOf(this.c));
    }

    public static zgc h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (h == null) {
                synchronized (zgc.class) {
                    if (h == null) {
                        h = new zgc();
                    }
                }
            }
            return h;
        }
        return (zgc) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vfc
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TLog.h("[P2pManagerClient]", "P2pManagerClient on service connect");
            if (blc.n().k()) {
                TLog.h("[P2pManagerClient]", "P2pManagerClient on service connect, just return as FailOver2MainProcess");
            } else {
                TLog.h("[P2pManagerClient]", "P2pManagerClient on service connect p2p not enabled");
            }
        }
    }

    @Override // com.baidu.tieba.vfc
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TLog.h("[P2pManagerClient]", "P2pManagerClient on service onDisconnect");
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TLog.h("[P2pManagerClient]", "init");
            if (this.a.compareAndSet(false, true)) {
                RenderEngine.r.a().r(this);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TLog.h("[P2pManagerClient]", "close");
            if (this.b.compareAndSet(true, false)) {
                TLog.h("[P2pManagerClient]", "close msg client!!!");
                this.d.a();
            }
            if (this.a.compareAndSet(true, false)) {
                RenderEngine.r.a().D(this);
            }
        }
    }
}
