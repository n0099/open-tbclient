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
public class vo {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static wo b;
    public static String c;
    public static qj d;
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
                            if (vo.d != null) {
                                vo.d.c(vo.c, message.arg1);
                                qj unused = vo.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (vo.d != null) {
                                if (ui.d()) {
                                    vo.d.error(message.what, rj.a(R.string.obfuscated_res_0x7f0f1611));
                                } else {
                                    vo.d.error(message.what, rj.a(R.string.obfuscated_res_0x7f0f161a));
                                }
                                qj unused2 = vo.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (vo.d != null) {
                                vo.d.error(message.what, rj.a(R.string.obfuscated_res_0x7f0f1612));
                                qj unused3 = vo.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (vo.d != null) {
                                vo.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (vo.d != null) {
                                vo.d.error(message.what, rj.a(R.string.obfuscated_res_0x7f0f1616));
                                qj unused4 = vo.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (vo.d != null) {
                                vo.d.error(message.what, rj.a(R.string.obfuscated_res_0x7f0f1613));
                                qj unused5 = vo.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (vo.d != null) {
                                vo.d.error(message.what, rj.a(R.string.obfuscated_res_0x7f0f1623));
                                qj unused6 = vo.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (vo.d != null) {
                                vo.d.error(message.what, rj.a(R.string.obfuscated_res_0x7f0f1620));
                                qj unused7 = vo.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (vo.d != null) {
                                vo.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (vo.d != null) {
                                vo.d.error(message.what, rj.a(R.string.obfuscated_res_0x7f0f1618));
                                qj unused8 = vo.d = null;
                                break;
                            }
                            break;
                    }
                } else if (vo.d != null) {
                    vo.d.e();
                }
                int unused9 = vo.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448320020, "Lcom/baidu/tieba/vo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448320020, "Lcom/baidu/tieba/vo;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            wo woVar = b;
            if (woVar != null) {
                woVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            wo woVar = b;
            if (woVar != null) {
                woVar.k();
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

    public static boolean g(String str, int i, qj qjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, qjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new wo(f);
                }
                c = str;
                d = qjVar;
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
