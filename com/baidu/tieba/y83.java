package com.baidu.tieba;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.s83;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: classes8.dex */
public class y83 implements s83.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Deque<Message> a;

    @Override // com.baidu.tieba.s83.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.s83.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948283989, "Lcom/baidu/tieba/y83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948283989, "Lcom/baidu/tieba/y83;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    public y83() {
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
        this.a = new ArrayDeque();
    }

    @Override // com.baidu.tieba.s83.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            x83 Q = x83.Q();
            while (Q.O() && !this.a.isEmpty()) {
                Message peek = this.a.peek();
                if (peek == null || e(peek)) {
                    this.a.poll();
                }
            }
        }
    }

    @Override // com.baidu.tieba.s83.c
    public void b(@NonNull u83 u83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u83Var) == null) {
            Message h = u83Var.h();
            h.arg1 = SwanAppProcessInfo.current().index;
            if (bc3.K().E()) {
                Object obj = h.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    if (!bundle.containsKey("ai_apps_id")) {
                        bundle.putString("ai_apps_id", bc3.K().getAppId());
                    }
                }
            }
            if (!e(h) && u83Var.n()) {
                this.a.offer(h);
                x83.Q().c0();
            }
        }
    }

    public final boolean e(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
            x83 Q = x83.Q();
            if (message != null && Q.O()) {
                try {
                    Q.S().send(message);
                    return true;
                } catch (RemoteException e) {
                    Q.U();
                    c92.l("SwanMsgSenderOfClient", " sendMsgToService msg = " + message.toString(), e);
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
