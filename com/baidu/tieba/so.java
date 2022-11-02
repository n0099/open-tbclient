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
public class so {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static to b;
    public static String c;
    public static oj d;
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
                            if (so.d != null) {
                                so.d.c(so.c, message.arg1);
                                oj unused = so.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (so.d != null) {
                                if (si.d()) {
                                    so.d.error(message.what, pj.a(R.string.voice_err_create_file_fail));
                                } else {
                                    so.d.error(message.what, pj.a(R.string.voice_err_sdcard_nospace));
                                }
                                oj unused2 = so.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (so.d != null) {
                                so.d.error(message.what, pj.a(R.string.voice_err_file_fail));
                                oj unused3 = so.d = null;
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
                                so.d.error(message.what, pj.a(R.string.voice_err_load_lib_fail));
                                oj unused4 = so.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (so.d != null) {
                                so.d.error(message.what, pj.a(R.string.voice_err_init_fail));
                                oj unused5 = so.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (so.d != null) {
                                so.d.error(message.what, pj.a(R.string.voice_record_timeout_tip));
                                oj unused6 = so.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (so.d != null) {
                                so.d.error(message.what, pj.a(R.string.voice_record_short_tip));
                                oj unused7 = so.d = null;
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
                                so.d.error(message.what, pj.a(R.string.voice_err_other));
                                oj unused8 = so.d = null;
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
        to toVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65542, null, i) == null) && (toVar = b) != null) {
            toVar.h(i);
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
                    b = new to(f);
                }
                c = str;
                d = ojVar;
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
}
