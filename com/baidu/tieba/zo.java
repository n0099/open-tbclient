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
public class zo {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static ap b;
    public static String c;
    public static vj d;
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
                            if (zo.d != null) {
                                zo.d.c(zo.c, message.arg1);
                                vj unused = zo.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (zo.d != null) {
                                if (zi.d()) {
                                    zo.d.error(message.what, wj.a(R.string.voice_err_create_file_fail));
                                } else {
                                    zo.d.error(message.what, wj.a(R.string.voice_err_sdcard_nospace));
                                }
                                vj unused2 = zo.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (zo.d != null) {
                                zo.d.error(message.what, wj.a(R.string.voice_err_file_fail));
                                vj unused3 = zo.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (zo.d != null) {
                                zo.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (zo.d != null) {
                                zo.d.error(message.what, wj.a(R.string.voice_err_load_lib_fail));
                                vj unused4 = zo.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (zo.d != null) {
                                zo.d.error(message.what, wj.a(R.string.voice_err_init_fail));
                                vj unused5 = zo.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (zo.d != null) {
                                zo.d.error(message.what, wj.a(R.string.voice_record_timeout_tip));
                                vj unused6 = zo.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (zo.d != null) {
                                zo.d.error(message.what, wj.a(R.string.voice_record_short_tip));
                                vj unused7 = zo.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (zo.d != null) {
                                zo.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (zo.d != null) {
                                zo.d.error(message.what, wj.a(R.string.voice_err_other));
                                vj unused8 = zo.d = null;
                                break;
                            }
                            break;
                    }
                } else if (zo.d != null) {
                    zo.d.e();
                }
                int unused9 = zo.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448323864, "Lcom/baidu/tieba/zo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448323864, "Lcom/baidu/tieba/zo;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            ap apVar = b;
            if (apVar != null) {
                apVar.cancel();
            }
            a = 0;
        }
    }

    public static void f(int i) {
        ap apVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65542, null, i) == null) || (apVar = b) == null) {
            return;
        }
        apVar.h(i);
    }

    public static boolean g(String str, int i, vj vjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, vjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new ap(f);
                }
                c = str;
                d = vjVar;
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
            ap apVar = b;
            if (apVar != null) {
                apVar.k();
            }
            a = 0;
        }
    }
}
