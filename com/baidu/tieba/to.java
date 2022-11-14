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
public class to {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static uo b;
    public static String c;
    public static pj d;
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
                            if (to.d != null) {
                                to.d.c(to.c, message.arg1);
                                pj unused = to.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (to.d != null) {
                                if (ti.d()) {
                                    to.d.error(message.what, qj.a(R.string.voice_err_create_file_fail));
                                } else {
                                    to.d.error(message.what, qj.a(R.string.voice_err_sdcard_nospace));
                                }
                                pj unused2 = to.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (to.d != null) {
                                to.d.error(message.what, qj.a(R.string.voice_err_file_fail));
                                pj unused3 = to.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (to.d != null) {
                                to.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (to.d != null) {
                                to.d.error(message.what, qj.a(R.string.voice_err_load_lib_fail));
                                pj unused4 = to.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (to.d != null) {
                                to.d.error(message.what, qj.a(R.string.voice_err_init_fail));
                                pj unused5 = to.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (to.d != null) {
                                to.d.error(message.what, qj.a(R.string.voice_record_timeout_tip));
                                pj unused6 = to.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (to.d != null) {
                                to.d.error(message.what, qj.a(R.string.voice_record_short_tip));
                                pj unused7 = to.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (to.d != null) {
                                to.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (to.d != null) {
                                to.d.error(message.what, qj.a(R.string.voice_err_other));
                                pj unused8 = to.d = null;
                                break;
                            }
                            break;
                    }
                } else if (to.d != null) {
                    to.d.e();
                }
                int unused9 = to.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448318098, "Lcom/baidu/tieba/to;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448318098, "Lcom/baidu/tieba/to;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            uo uoVar = b;
            if (uoVar != null) {
                uoVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            uo uoVar = b;
            if (uoVar != null) {
                uoVar.k();
            }
            a = 0;
        }
    }

    public static void f(int i) {
        uo uoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65542, null, i) == null) && (uoVar = b) != null) {
            uoVar.h(i);
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
                    b = new uo(f);
                }
                c = str;
                d = pjVar;
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
