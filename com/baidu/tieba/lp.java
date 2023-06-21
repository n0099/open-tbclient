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
public class lp {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static mp b;
    public static String c;
    public static nj d;
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
                            if (lp.d != null) {
                                lp.d.c(lp.c, message.arg1);
                                nj unused = lp.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (lp.d != null) {
                                if (ri.d()) {
                                    lp.d.error(message.what, oj.a(R.string.obfuscated_res_0x7f0f1808));
                                } else {
                                    lp.d.error(message.what, oj.a(R.string.obfuscated_res_0x7f0f1811));
                                }
                                nj unused2 = lp.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (lp.d != null) {
                                lp.d.error(message.what, oj.a(R.string.obfuscated_res_0x7f0f1809));
                                nj unused3 = lp.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (lp.d != null) {
                                lp.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (lp.d != null) {
                                lp.d.error(message.what, oj.a(R.string.obfuscated_res_0x7f0f180d));
                                nj unused4 = lp.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (lp.d != null) {
                                lp.d.error(message.what, oj.a(R.string.obfuscated_res_0x7f0f180a));
                                nj unused5 = lp.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (lp.d != null) {
                                lp.d.error(message.what, oj.a(R.string.obfuscated_res_0x7f0f181a));
                                nj unused6 = lp.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (lp.d != null) {
                                lp.d.error(message.what, oj.a(R.string.obfuscated_res_0x7f0f1817));
                                nj unused7 = lp.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (lp.d != null) {
                                lp.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (lp.d != null) {
                                lp.d.error(message.what, oj.a(R.string.obfuscated_res_0x7f0f180f));
                                nj unused8 = lp.d = null;
                                break;
                            }
                            break;
                    }
                } else if (lp.d != null) {
                    lp.d.e();
                }
                int unused9 = lp.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448310441, "Lcom/baidu/tieba/lp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448310441, "Lcom/baidu/tieba/lp;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            mp mpVar = b;
            if (mpVar != null) {
                mpVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            mp mpVar = b;
            if (mpVar != null) {
                mpVar.k();
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

    public static boolean g(String str, int i, nj njVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, njVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new mp(f);
                }
                c = str;
                d = njVar;
                if (b.j(str, i)) {
                    a = 3;
                    ps6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
