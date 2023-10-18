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
public class kd {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static ld b;
    public static String c;
    public static md d;
    public static Handler e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                            if (kd.d != null) {
                                kd.d.error(message.what, rd.a(R.string.obfuscated_res_0x7f0f1853));
                            }
                        } else {
                            if (kd.d != null) {
                                kd.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (kd.d != null) {
                        kd.d.error(message.what, rd.a(R.string.obfuscated_res_0x7f0f1851));
                    }
                } else if (kd.d != null) {
                    kd.d.c(kd.c, message.arg1);
                }
                int unused = kd.a = 0;
                md unused2 = kd.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448309108, "Lcom/baidu/tieba/kd;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448309108, "Lcom/baidu/tieba/kd;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            ld ldVar = b;
            if (ldVar != null) {
                ldVar.l();
            } else {
                a = 0;
            }
        }
    }

    public static boolean e(String str, md mdVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, mdVar, i)) == null) {
            if (a == 0) {
                ld ldVar = b;
                if (ldVar == null) {
                    b = new ld(e, i);
                } else {
                    ldVar.k(i);
                }
                c = str;
                d = mdVar;
                b.j(str);
                a = 2;
                kp6.a(b, "AmrAudioPlayer", 2);
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
