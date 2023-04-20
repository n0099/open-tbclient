package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes5.dex */
public final class lda {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1000;
    public static boolean b = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947940416, "Lcom/baidu/tieba/lda;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947940416, "Lcom/baidu/tieba/lda;");
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, str) == null) && b) {
            c(2, "BaiDuAbSDK", str, null);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && b) {
            c(5, "BaiDuAbSDK", str, null);
        }
    }

    public static void d(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th) == null) && b) {
            c(2, "BaiDuAbSDK", "", th);
        }
    }

    public static void e(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, th) == null) && b) {
            c(4, "BaiDuAbSDK", "", th);
        }
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            b = z;
        }
    }

    public static void c(int i, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), str, str2, th}) == null) {
            if (!TextUtils.isEmpty(str2)) {
                int length = str2.length();
                int i2 = a;
                if (length >= i2) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    if (i == 5) {
                                        Log.e(str, str2.substring(0, i2));
                                    }
                                } else {
                                    Log.w(str, str2.substring(0, i2));
                                }
                            } else {
                                Log.i(str, str2.substring(0, i2));
                            }
                        } else {
                            Log.d(str, str2.substring(0, i2));
                        }
                    } else {
                        Log.v(str, str2.substring(0, i2));
                    }
                } else if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    Log.d(str, str2);
                                } else {
                                    Log.e(str, str2);
                                }
                            } else {
                                Log.w(str, str2);
                            }
                        } else {
                            Log.i(str, str2);
                        }
                    } else {
                        Log.d(str, str2);
                    }
                } else {
                    Log.v(str, str2);
                }
            }
            if (th != null) {
                String f = f(th);
                if (!TextUtils.isEmpty(f)) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    if (i != 5) {
                                        Log.d(str, str2);
                                        return;
                                    } else {
                                        Log.e(str, f);
                                        return;
                                    }
                                }
                                Log.w(str, f);
                                return;
                            }
                            Log.i(str, f);
                            return;
                        }
                        Log.d(str, f);
                        return;
                    }
                    Log.v(str, f);
                }
            }
        }
    }

    public static String f(Throwable th) {
        InterceptResult invokeL;
        PrintWriter printWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, th)) == null) {
            StringWriter stringWriter = null;
            try {
                StringWriter stringWriter2 = new StringWriter();
                try {
                    printWriter = new PrintWriter(stringWriter2);
                    try {
                        th.printStackTrace(printWriter);
                        printWriter.flush();
                        stringWriter2.flush();
                        String stringWriter3 = stringWriter2.toString();
                        try {
                            stringWriter2.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        printWriter.close();
                        return stringWriter3;
                    } catch (Throwable th3) {
                        th = th3;
                        stringWriter = stringWriter2;
                        try {
                            th.printStackTrace();
                            return "";
                        } finally {
                            if (stringWriter != null) {
                                try {
                                    stringWriter.close();
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                            if (printWriter != null) {
                                printWriter.close();
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    printWriter = null;
                }
            } catch (Throwable th6) {
                th = th6;
                printWriter = null;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
