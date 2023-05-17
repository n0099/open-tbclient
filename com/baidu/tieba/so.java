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
public class so {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static to b;
    public static String c;
    public static ij d;
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
                            if (so.d != null) {
                                so.d.c(so.c, message.arg1);
                                ij unused = so.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (so.d != null) {
                                if (mi.d()) {
                                    so.d.error(message.what, jj.a(R.string.obfuscated_res_0x7f0f17a0));
                                } else {
                                    so.d.error(message.what, jj.a(R.string.obfuscated_res_0x7f0f17a9));
                                }
                                ij unused2 = so.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (so.d != null) {
                                so.d.error(message.what, jj.a(R.string.obfuscated_res_0x7f0f17a1));
                                ij unused3 = so.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (so.d != null) {
                                so.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (so.d != null) {
                                so.d.error(message.what, jj.a(R.string.obfuscated_res_0x7f0f17a5));
                                ij unused4 = so.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (so.d != null) {
                                so.d.error(message.what, jj.a(R.string.obfuscated_res_0x7f0f17a2));
                                ij unused5 = so.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (so.d != null) {
                                so.d.error(message.what, jj.a(R.string.obfuscated_res_0x7f0f17b2));
                                ij unused6 = so.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (so.d != null) {
                                so.d.error(message.what, jj.a(R.string.obfuscated_res_0x7f0f17af));
                                ij unused7 = so.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (so.d != null) {
                                so.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (so.d != null) {
                                so.d.error(message.what, jj.a(R.string.obfuscated_res_0x7f0f17a7));
                                ij unused8 = so.d = null;
                                break;
                            }
                            break;
                    }
                } else if (so.d != null) {
                    so.d.e();
                }
                int unused9 = so.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317137, "Lcom/baidu/tieba/so;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317137, "Lcom/baidu/tieba/so;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            to toVar = b;
            if (toVar != null) {
                toVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            to toVar = b;
            if (toVar != null) {
                toVar.k();
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

    public static boolean g(String str, int i, ij ijVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, ijVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new to(f);
                }
                c = str;
                d = ijVar;
                if (b.j(str, i)) {
                    a = 3;
                    wn6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
