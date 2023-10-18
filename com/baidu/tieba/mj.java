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
public class mj {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static nj b;
    public static String c;
    public static qd d;
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
                            if (mj.d != null) {
                                mj.d.c(mj.c, message.arg1);
                                qd unused = mj.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (mj.d != null) {
                                if (wc.d()) {
                                    mj.d.error(message.what, rd.a(R.string.obfuscated_res_0x7f0f184b));
                                } else {
                                    mj.d.error(message.what, rd.a(R.string.obfuscated_res_0x7f0f1854));
                                }
                                qd unused2 = mj.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (mj.d != null) {
                                mj.d.error(message.what, rd.a(R.string.obfuscated_res_0x7f0f184c));
                                qd unused3 = mj.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (mj.d != null) {
                                mj.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (mj.d != null) {
                                mj.d.error(message.what, rd.a(R.string.obfuscated_res_0x7f0f1850));
                                qd unused4 = mj.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (mj.d != null) {
                                mj.d.error(message.what, rd.a(R.string.obfuscated_res_0x7f0f184d));
                                qd unused5 = mj.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (mj.d != null) {
                                mj.d.error(message.what, rd.a(R.string.obfuscated_res_0x7f0f185d));
                                qd unused6 = mj.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (mj.d != null) {
                                mj.d.error(message.what, rd.a(R.string.obfuscated_res_0x7f0f185a));
                                qd unused7 = mj.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (mj.d != null) {
                                mj.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (mj.d != null) {
                                mj.d.error(message.what, rd.a(R.string.obfuscated_res_0x7f0f1852));
                                qd unused8 = mj.d = null;
                                break;
                            }
                            break;
                    }
                } else if (mj.d != null) {
                    mj.d.e();
                }
                int unused9 = mj.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448311216, "Lcom/baidu/tieba/mj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448311216, "Lcom/baidu/tieba/mj;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            nj njVar = b;
            if (njVar != null) {
                njVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            nj njVar = b;
            if (njVar != null) {
                njVar.k();
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

    public static boolean g(String str, int i, qd qdVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, qdVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new nj(f);
                }
                c = str;
                d = qdVar;
                if (b.j(str, i)) {
                    a = 3;
                    kp6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
