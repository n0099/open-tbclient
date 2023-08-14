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
public class mo {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static no b;
    public static String c;
    public static ri d;
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
                            if (mo.d != null) {
                                mo.d.c(mo.c, message.arg1);
                                ri unused = mo.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (mo.d != null) {
                                if (xh.d()) {
                                    mo.d.error(message.what, si.a(R.string.obfuscated_res_0x7f0f183f));
                                } else {
                                    mo.d.error(message.what, si.a(R.string.obfuscated_res_0x7f0f1848));
                                }
                                ri unused2 = mo.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (mo.d != null) {
                                mo.d.error(message.what, si.a(R.string.obfuscated_res_0x7f0f1840));
                                ri unused3 = mo.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (mo.d != null) {
                                mo.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (mo.d != null) {
                                mo.d.error(message.what, si.a(R.string.obfuscated_res_0x7f0f1844));
                                ri unused4 = mo.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (mo.d != null) {
                                mo.d.error(message.what, si.a(R.string.obfuscated_res_0x7f0f1841));
                                ri unused5 = mo.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (mo.d != null) {
                                mo.d.error(message.what, si.a(R.string.obfuscated_res_0x7f0f1851));
                                ri unused6 = mo.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (mo.d != null) {
                                mo.d.error(message.what, si.a(R.string.obfuscated_res_0x7f0f184e));
                                ri unused7 = mo.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (mo.d != null) {
                                mo.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (mo.d != null) {
                                mo.d.error(message.what, si.a(R.string.obfuscated_res_0x7f0f1846));
                                ri unused8 = mo.d = null;
                                break;
                            }
                            break;
                    }
                } else if (mo.d != null) {
                    mo.d.e();
                }
                int unused9 = mo.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448311371, "Lcom/baidu/tieba/mo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448311371, "Lcom/baidu/tieba/mo;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            no noVar = b;
            if (noVar != null) {
                noVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            no noVar = b;
            if (noVar != null) {
                noVar.k();
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

    public static boolean g(String str, int i, ri riVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, riVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new no(f);
                }
                c = str;
                d = riVar;
                if (b.j(str, i)) {
                    a = 3;
                    gs6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
