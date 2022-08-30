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
/* loaded from: classes4.dex */
public class lo {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static mo b;
    public static String c;
    public static hj d;
    public static long e;
    public static Handler f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
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
                            if (lo.d != null) {
                                lo.d.c(lo.c, message.arg1);
                                hj unused = lo.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (lo.d != null) {
                                if (li.d()) {
                                    lo.d.error(message.what, ij.a(R.string.obfuscated_res_0x7f0f1563));
                                } else {
                                    lo.d.error(message.what, ij.a(R.string.obfuscated_res_0x7f0f156c));
                                }
                                hj unused2 = lo.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (lo.d != null) {
                                lo.d.error(message.what, ij.a(R.string.obfuscated_res_0x7f0f1564));
                                hj unused3 = lo.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (lo.d != null) {
                                lo.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (lo.d != null) {
                                lo.d.error(message.what, ij.a(R.string.obfuscated_res_0x7f0f1568));
                                hj unused4 = lo.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (lo.d != null) {
                                lo.d.error(message.what, ij.a(R.string.obfuscated_res_0x7f0f1565));
                                hj unused5 = lo.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (lo.d != null) {
                                lo.d.error(message.what, ij.a(R.string.obfuscated_res_0x7f0f1574));
                                hj unused6 = lo.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (lo.d != null) {
                                lo.d.error(message.what, ij.a(R.string.obfuscated_res_0x7f0f1572));
                                hj unused7 = lo.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (lo.d != null) {
                                lo.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (lo.d != null) {
                                lo.d.error(message.what, ij.a(R.string.obfuscated_res_0x7f0f156a));
                                hj unused8 = lo.d = null;
                                break;
                            }
                            break;
                    }
                } else if (lo.d != null) {
                    lo.d.e();
                }
                int unused9 = lo.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448310410, "Lcom/baidu/tieba/lo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448310410, "Lcom/baidu/tieba/lo;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            mo moVar = b;
            if (moVar != null) {
                moVar.cancel();
            }
            a = 0;
        }
    }

    public static void f(int i) {
        mo moVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65542, null, i) == null) || (moVar = b) == null) {
            return;
        }
        moVar.h(i);
    }

    public static boolean g(String str, int i, hj hjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, hjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new mo(f);
                }
                c = str;
                d = hjVar;
                if (b.j(str, i)) {
                    a = 3;
                    new Thread(b).start();
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            mo moVar = b;
            if (moVar != null) {
                moVar.k();
            }
            a = 0;
        }
    }
}
