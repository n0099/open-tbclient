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
public class mp {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static np b;
    public static String c;
    public static oj d;
    public static long e;
    public static Handler f;
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
                if (i != 100) {
                    switch (i) {
                        case 0:
                            if (mp.d != null) {
                                mp.d.c(mp.c, message.arg1);
                                oj unused = mp.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (mp.d != null) {
                                if (si.d()) {
                                    mp.d.error(message.what, pj.a(R.string.obfuscated_res_0x7f0f1825));
                                } else {
                                    mp.d.error(message.what, pj.a(R.string.obfuscated_res_0x7f0f182e));
                                }
                                oj unused2 = mp.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (mp.d != null) {
                                mp.d.error(message.what, pj.a(R.string.obfuscated_res_0x7f0f1826));
                                oj unused3 = mp.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (mp.d != null) {
                                mp.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (mp.d != null) {
                                mp.d.error(message.what, pj.a(R.string.obfuscated_res_0x7f0f182a));
                                oj unused4 = mp.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (mp.d != null) {
                                mp.d.error(message.what, pj.a(R.string.obfuscated_res_0x7f0f1827));
                                oj unused5 = mp.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (mp.d != null) {
                                mp.d.error(message.what, pj.a(R.string.obfuscated_res_0x7f0f1837));
                                oj unused6 = mp.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (mp.d != null) {
                                mp.d.error(message.what, pj.a(R.string.obfuscated_res_0x7f0f1834));
                                oj unused7 = mp.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (mp.d != null) {
                                mp.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (mp.d != null) {
                                mp.d.error(message.what, pj.a(R.string.obfuscated_res_0x7f0f182c));
                                oj unused8 = mp.d = null;
                                break;
                            }
                            break;
                    }
                } else if (mp.d != null) {
                    mp.d.e();
                }
                int unused9 = mp.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448311402, "Lcom/baidu/tieba/mp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448311402, "Lcom/baidu/tieba/mp;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            np npVar = b;
            if (npVar != null) {
                npVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            np npVar = b;
            if (npVar != null) {
                npVar.k();
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

    public static boolean g(String str, int i, oj ojVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, ojVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new np(f);
                }
                c = str;
                d = ojVar;
                if (b.j(str, i)) {
                    a = 3;
                    us6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
