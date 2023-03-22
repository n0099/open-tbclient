package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class si {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static ti b;
    public static String c;
    public static ui d;
    public static Handler e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 6) {
                            if (si.d != null) {
                                si.d.error(message.what, zi.a(R.string.obfuscated_res_0x7f0f16a9));
                            }
                        } else {
                            if (si.d != null) {
                                si.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (si.d != null) {
                        si.d.error(message.what, zi.a(R.string.obfuscated_res_0x7f0f16a7));
                    }
                } else if (si.d != null) {
                    si.d.c(si.c, message.arg1);
                }
                int unused = si.a = 0;
                ui unused2 = si.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448316951, "Lcom/baidu/tieba/si;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448316951, "Lcom/baidu/tieba/si;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            ti tiVar = b;
            if (tiVar != null) {
                tiVar.l();
            } else {
                a = 0;
            }
        }
    }

    public static boolean e(String str, ui uiVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, uiVar, i)) == null) {
            if (a == 0) {
                ti tiVar = b;
                if (tiVar == null) {
                    b = new ti(e, i);
                } else {
                    tiVar.k(i);
                }
                c = str;
                d = uiVar;
                b.j(str);
                a = 2;
                new Thread(b).start();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
