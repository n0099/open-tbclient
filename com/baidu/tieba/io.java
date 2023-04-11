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
public class io {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static jo b;
    public static String c;
    public static zi d;
    public static long e;
    public static Handler f;
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
                if (i != 100) {
                    switch (i) {
                        case 0:
                            if (io.d != null) {
                                io.d.c(io.c, message.arg1);
                                zi unused = io.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (io.d != null) {
                                if (di.d()) {
                                    io.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f1697));
                                } else {
                                    io.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16a0));
                                }
                                zi unused2 = io.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (io.d != null) {
                                io.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f1698));
                                zi unused3 = io.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (io.d != null) {
                                io.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (io.d != null) {
                                io.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f169c));
                                zi unused4 = io.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (io.d != null) {
                                io.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f1699));
                                zi unused5 = io.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (io.d != null) {
                                io.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16a9));
                                zi unused6 = io.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (io.d != null) {
                                io.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16a6));
                                zi unused7 = io.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (io.d != null) {
                                io.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (io.d != null) {
                                io.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f169e));
                                zi unused8 = io.d = null;
                                break;
                            }
                            break;
                    }
                } else if (io.d != null) {
                    io.d.e();
                }
                int unused9 = io.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448307527, "Lcom/baidu/tieba/io;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448307527, "Lcom/baidu/tieba/io;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            jo joVar = b;
            if (joVar != null) {
                joVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            jo joVar = b;
            if (joVar != null) {
                joVar.k();
            }
            a = 0;
        }
    }

    public static void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            try {
                if (b != null) {
                    b.h(i);
                }
            } catch (NoClassDefFoundError e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean g(String str, int i, zi ziVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, ziVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new jo(f);
                }
                c = str;
                d = ziVar;
                if (b.j(str, i)) {
                    a = 3;
                    vk6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
