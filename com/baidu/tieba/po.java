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
public class po {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static qo b;
    public static String c;
    public static ti d;
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
                            if (po.d != null) {
                                po.d.c(po.c, message.arg1);
                                ti unused = po.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (po.d != null) {
                                if (zh.d()) {
                                    po.d.error(message.what, ui.a(R.string.obfuscated_res_0x7f0f184d));
                                } else {
                                    po.d.error(message.what, ui.a(R.string.obfuscated_res_0x7f0f1856));
                                }
                                ti unused2 = po.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (po.d != null) {
                                po.d.error(message.what, ui.a(R.string.obfuscated_res_0x7f0f184e));
                                ti unused3 = po.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (po.d != null) {
                                po.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (po.d != null) {
                                po.d.error(message.what, ui.a(R.string.obfuscated_res_0x7f0f1852));
                                ti unused4 = po.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (po.d != null) {
                                po.d.error(message.what, ui.a(R.string.obfuscated_res_0x7f0f184f));
                                ti unused5 = po.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (po.d != null) {
                                po.d.error(message.what, ui.a(R.string.obfuscated_res_0x7f0f185f));
                                ti unused6 = po.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (po.d != null) {
                                po.d.error(message.what, ui.a(R.string.obfuscated_res_0x7f0f185c));
                                ti unused7 = po.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (po.d != null) {
                                po.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (po.d != null) {
                                po.d.error(message.what, ui.a(R.string.obfuscated_res_0x7f0f1854));
                                ti unused8 = po.d = null;
                                break;
                            }
                            break;
                    }
                } else if (po.d != null) {
                    po.d.e();
                }
                int unused9 = po.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448314254, "Lcom/baidu/tieba/po;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448314254, "Lcom/baidu/tieba/po;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            qo qoVar = b;
            if (qoVar != null) {
                qoVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            qo qoVar = b;
            if (qoVar != null) {
                qoVar.k();
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

    public static boolean g(String str, int i, ti tiVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, tiVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new qo(f);
                }
                c = str;
                d = tiVar;
                if (b.j(str, i)) {
                    a = 3;
                    rt6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
