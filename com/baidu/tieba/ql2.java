package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class ql2<W extends rl2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, ol2<W>> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948095602, "Lcom/baidu/tieba/ql2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948095602, "Lcom/baidu/tieba/ql2;");
                return;
            }
        }
        b = eo1.a;
    }

    public ql2() {
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
        this.a = new HashMap<>();
    }

    public void a(ol2<W> ol2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ol2Var) == null) {
            if (b) {
                Log.v("CommandDispatcher", ol2Var.b() + " command added to supported command list");
            }
            this.a.put(ol2Var.b(), ol2Var);
        }
    }

    public void b(@Nullable ZeusPlugin.Command command, @Nullable W w) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command, w) == null) {
            if (command != null && !TextUtils.isEmpty(command.what)) {
                if (w == null) {
                    if (b) {
                        Log.e("CommandDispatcher", "inlineWidget is null, haven't dispatched");
                        return;
                    }
                    return;
                }
                ol2<W> ol2Var = this.a.get(command.what);
                if (ol2Var == null) {
                    if (b) {
                        Log.e("CommandDispatcher", command.what + " command is not supported, haven't dispatched");
                        return;
                    }
                    return;
                }
                if (b) {
                    Log.d("CommandDispatcher", command.what + " command dispatched");
                }
                ol2Var.a(command, w);
            } else if (b) {
                Log.e("CommandDispatcher", "command or command.what is null, haven't dispatched");
            }
        }
    }

    public void c(@Nullable ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            if (command != null && !TextUtils.isEmpty(command.what)) {
                ol2<W> ol2Var = this.a.get(command.what);
                if (ol2Var == null) {
                    if (b) {
                        Log.e("CommandDispatcher", command.what + " command is not supported, haven't mocked");
                        return;
                    }
                    return;
                }
                if (b) {
                    Log.d("CommandDispatcher", command.what + " cached command return value processed");
                }
                ol2Var.c(command);
            } else if (b) {
                Log.e("CommandDispatcher", "command or command.what is null, haven't mocked");
            }
        }
    }
}
