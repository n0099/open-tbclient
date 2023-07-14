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
public class np {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static op b;
    public static String c;
    public static pj d;
    public static long e;
    public static Handler f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
                            if (np.d != null) {
                                np.d.c(np.c, message.arg1);
                                pj unused = np.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (np.d != null) {
                                if (ti.d()) {
                                    np.d.error(message.what, qj.a(R.string.obfuscated_res_0x7f0f183b));
                                } else {
                                    np.d.error(message.what, qj.a(R.string.obfuscated_res_0x7f0f1844));
                                }
                                pj unused2 = np.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (np.d != null) {
                                np.d.error(message.what, qj.a(R.string.obfuscated_res_0x7f0f183c));
                                pj unused3 = np.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (np.d != null) {
                                np.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (np.d != null) {
                                np.d.error(message.what, qj.a(R.string.obfuscated_res_0x7f0f1840));
                                pj unused4 = np.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (np.d != null) {
                                np.d.error(message.what, qj.a(R.string.obfuscated_res_0x7f0f183d));
                                pj unused5 = np.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (np.d != null) {
                                np.d.error(message.what, qj.a(R.string.obfuscated_res_0x7f0f184d));
                                pj unused6 = np.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (np.d != null) {
                                np.d.error(message.what, qj.a(R.string.obfuscated_res_0x7f0f184a));
                                pj unused7 = np.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (np.d != null) {
                                np.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (np.d != null) {
                                np.d.error(message.what, qj.a(R.string.obfuscated_res_0x7f0f1842));
                                pj unused8 = np.d = null;
                                break;
                            }
                            break;
                    }
                } else if (np.d != null) {
                    np.d.e();
                }
                int unused9 = np.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448312363, "Lcom/baidu/tieba/np;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448312363, "Lcom/baidu/tieba/np;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            op opVar = b;
            if (opVar != null) {
                opVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            op opVar = b;
            if (opVar != null) {
                opVar.k();
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

    public static boolean g(String str, int i, pj pjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, pjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new op(f);
                }
                c = str;
                d = pjVar;
                if (b.j(str, i)) {
                    a = 3;
                    zu6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
