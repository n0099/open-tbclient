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
/* loaded from: classes5.dex */
public class pj {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static qj b;
    public static String c;
    public static rj d;
    public static Handler e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
                            if (pj.d != null) {
                                pj.d.error(message.what, wj.a(R.string.voice_err_play));
                            }
                        } else {
                            if (pj.d != null) {
                                pj.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (pj.d != null) {
                        pj.d.error(message.what, wj.a(R.string.voice_err_no_file));
                    }
                } else if (pj.d != null) {
                    pj.d.c(pj.c, message.arg1);
                }
                int unused = pj.a = 0;
                rj unused2 = pj.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448314099, "Lcom/baidu/tieba/pj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448314099, "Lcom/baidu/tieba/pj;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static boolean e(String str, rj rjVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, rjVar, i)) == null) {
            if (a == 0) {
                qj qjVar = b;
                if (qjVar == null) {
                    b = new qj(e, i);
                } else {
                    qjVar.k(i);
                }
                c = str;
                d = rjVar;
                b.j(str);
                a = 2;
                new Thread(b).start();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            qj qjVar = b;
            if (qjVar != null) {
                qjVar.l();
            } else {
                a = 0;
            }
        }
    }
}
