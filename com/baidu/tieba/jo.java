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
public class jo {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static ko b;
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
                            if (jo.d != null) {
                                jo.d.c(jo.c, message.arg1);
                                zi unused = jo.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (jo.d != null) {
                                if (di.d()) {
                                    jo.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16b0));
                                } else {
                                    jo.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16b9));
                                }
                                zi unused2 = jo.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (jo.d != null) {
                                jo.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16b1));
                                zi unused3 = jo.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (jo.d != null) {
                                jo.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (jo.d != null) {
                                jo.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16b5));
                                zi unused4 = jo.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (jo.d != null) {
                                jo.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16b2));
                                zi unused5 = jo.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (jo.d != null) {
                                jo.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16c2));
                                zi unused6 = jo.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (jo.d != null) {
                                jo.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16bf));
                                zi unused7 = jo.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (jo.d != null) {
                                jo.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (jo.d != null) {
                                jo.d.error(message.what, aj.a(R.string.obfuscated_res_0x7f0f16b7));
                                zi unused8 = jo.d = null;
                                break;
                            }
                            break;
                    }
                } else if (jo.d != null) {
                    jo.d.e();
                }
                int unused9 = jo.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448308488, "Lcom/baidu/tieba/jo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448308488, "Lcom/baidu/tieba/jo;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            ko koVar = b;
            if (koVar != null) {
                koVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            ko koVar = b;
            if (koVar != null) {
                koVar.k();
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
                    b = new ko(f);
                }
                c = str;
                d = ziVar;
                if (b.j(str, i)) {
                    a = 3;
                    km6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
