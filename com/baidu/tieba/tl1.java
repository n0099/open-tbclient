package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
/* loaded from: classes6.dex */
public class tl1 implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public static final tl1 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread.UncaughtExceptionHandler a;
    public boolean b;
    public ul1 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948184944, "Lcom/baidu/tieba/tl1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948184944, "Lcom/baidu/tieba/tl1;");
                return;
            }
        }
        d = new tl1();
    }

    public tl1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static tl1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return d;
        }
        return (tl1) invokeV.objValue;
    }

    public final String a(Throwable th) {
        PrintWriter printWriter;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
            try {
                StringWriter stringWriter = new StringWriter();
                printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    String obj = stringWriter.toString();
                    printWriter.close();
                    return obj;
                } catch (Throwable unused) {
                    if (printWriter != null) {
                        printWriter.close();
                        return "";
                    }
                    return "";
                }
            } catch (Throwable unused2) {
                printWriter = null;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public synchronized void b(ul1 ul1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ul1Var) == null) {
            synchronized (this) {
                try {
                    this.c = ul1Var;
                } finally {
                }
                if (ul1Var == null) {
                    return;
                }
                if (!ul1Var.a()) {
                    return;
                }
                if (this.b) {
                    return;
                }
                this.b = true;
                this.a = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(this);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, thread, th) == null) {
            try {
                String a = a(th);
                if (!TextUtils.isEmpty(a) && ((a.contains("com.baidu.sso") || a.contains("com.cmic.sso.sdk") || a.contains("com.sdk") || a.contains("cn.com.chinatelecom.gateway")) && this.c != null)) {
                    this.c.a(a);
                }
            } catch (Throwable th2) {
                dn1.d(th2);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
