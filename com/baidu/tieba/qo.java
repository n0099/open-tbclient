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
public class qo {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static ro b;
    public static String c;
    public static ui d;
    public static long e;
    public static Handler f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Handler.Callback {
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
                            if (qo.d != null) {
                                qo.d.c(qo.c, message.arg1);
                                ui unused = qo.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (qo.d != null) {
                                if (ai.d()) {
                                    qo.d.error(message.what, vi.a(R.string.obfuscated_res_0x7f0f186b));
                                } else {
                                    qo.d.error(message.what, vi.a(R.string.obfuscated_res_0x7f0f1874));
                                }
                                ui unused2 = qo.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (qo.d != null) {
                                qo.d.error(message.what, vi.a(R.string.obfuscated_res_0x7f0f186c));
                                ui unused3 = qo.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (qo.d != null) {
                                qo.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (qo.d != null) {
                                qo.d.error(message.what, vi.a(R.string.obfuscated_res_0x7f0f1870));
                                ui unused4 = qo.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (qo.d != null) {
                                qo.d.error(message.what, vi.a(R.string.obfuscated_res_0x7f0f186d));
                                ui unused5 = qo.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (qo.d != null) {
                                qo.d.error(message.what, vi.a(R.string.obfuscated_res_0x7f0f187d));
                                ui unused6 = qo.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (qo.d != null) {
                                qo.d.error(message.what, vi.a(R.string.obfuscated_res_0x7f0f187a));
                                ui unused7 = qo.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (qo.d != null) {
                                qo.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (qo.d != null) {
                                qo.d.error(message.what, vi.a(R.string.obfuscated_res_0x7f0f1872));
                                ui unused8 = qo.d = null;
                                break;
                            }
                            break;
                    }
                } else if (qo.d != null) {
                    qo.d.e();
                }
                int unused9 = qo.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448315215, "Lcom/baidu/tieba/qo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448315215, "Lcom/baidu/tieba/qo;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            ro roVar = b;
            if (roVar != null) {
                roVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            ro roVar = b;
            if (roVar != null) {
                roVar.k();
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

    public static boolean g(String str, int i, ui uiVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, uiVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new ro(f);
                }
                c = str;
                d = uiVar;
                if (b.j(str, i)) {
                    a = 3;
                    vu6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
