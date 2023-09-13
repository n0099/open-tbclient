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
/* loaded from: classes7.dex */
public class oi {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static pi b;
    public static String c;
    public static qi d;
    public static Handler e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Handler.Callback {
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
                            if (oi.d != null) {
                                oi.d.error(message.what, vi.a(R.string.obfuscated_res_0x7f0f1873));
                            }
                        } else {
                            if (oi.d != null) {
                                oi.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (oi.d != null) {
                        oi.d.error(message.what, vi.a(R.string.obfuscated_res_0x7f0f1871));
                    }
                } else if (oi.d != null) {
                    oi.d.c(oi.c, message.arg1);
                }
                int unused = oi.a = 0;
                qi unused2 = oi.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448313107, "Lcom/baidu/tieba/oi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448313107, "Lcom/baidu/tieba/oi;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            pi piVar = b;
            if (piVar != null) {
                piVar.l();
            } else {
                a = 0;
            }
        }
    }

    public static boolean e(String str, qi qiVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, qiVar, i)) == null) {
            if (a == 0) {
                pi piVar = b;
                if (piVar == null) {
                    b = new pi(e, i);
                } else {
                    piVar.k(i);
                }
                c = str;
                d = qiVar;
                b.j(str);
                a = 2;
                vu6.a(b, "AmrAudioPlayer", 2);
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
