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
public class kp {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static lp b;
    public static String c;
    public static mj d;
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
                            if (kp.d != null) {
                                kp.d.c(kp.c, message.arg1);
                                mj unused = kp.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (kp.d != null) {
                                if (qi.d()) {
                                    kp.d.error(message.what, nj.a(R.string.obfuscated_res_0x7f0f1804));
                                } else {
                                    kp.d.error(message.what, nj.a(R.string.obfuscated_res_0x7f0f180d));
                                }
                                mj unused2 = kp.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (kp.d != null) {
                                kp.d.error(message.what, nj.a(R.string.obfuscated_res_0x7f0f1805));
                                mj unused3 = kp.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (kp.d != null) {
                                kp.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (kp.d != null) {
                                kp.d.error(message.what, nj.a(R.string.obfuscated_res_0x7f0f1809));
                                mj unused4 = kp.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (kp.d != null) {
                                kp.d.error(message.what, nj.a(R.string.obfuscated_res_0x7f0f1806));
                                mj unused5 = kp.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (kp.d != null) {
                                kp.d.error(message.what, nj.a(R.string.obfuscated_res_0x7f0f1816));
                                mj unused6 = kp.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (kp.d != null) {
                                kp.d.error(message.what, nj.a(R.string.obfuscated_res_0x7f0f1813));
                                mj unused7 = kp.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (kp.d != null) {
                                kp.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (kp.d != null) {
                                kp.d.error(message.what, nj.a(R.string.obfuscated_res_0x7f0f180b));
                                mj unused8 = kp.d = null;
                                break;
                            }
                            break;
                    }
                } else if (kp.d != null) {
                    kp.d.e();
                }
                int unused9 = kp.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448309480, "Lcom/baidu/tieba/kp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448309480, "Lcom/baidu/tieba/kp;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            lp lpVar = b;
            if (lpVar != null) {
                lpVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            lp lpVar = b;
            if (lpVar != null) {
                lpVar.k();
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

    public static boolean g(String str, int i, mj mjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, mjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new lp(f);
                }
                c = str;
                d = mjVar;
                if (b.j(str, i)) {
                    a = 3;
                    ks6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
