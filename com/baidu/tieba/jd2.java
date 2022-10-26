package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes4.dex */
public class jd2 implements qo2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue c;

    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public static final jd2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-693678765, "Lcom/baidu/tieba/jd2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-693678765, "Lcom/baidu/tieba/jd2$b;");
                    return;
                }
            }
            a = new jd2(null);
        }
    }

    public jd2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ConcurrentLinkedQueue();
    }

    public static jd2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (jd2) invokeV.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.c.clear();
            }
        }
    }

    public /* synthetic */ jd2(a aVar) {
        this();
    }

    public synchronized void c(kd2 kd2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kd2Var, str) == null) {
            synchronized (this) {
                while (this.c.size() > 0) {
                    kd2 kd2Var2 = (kd2) this.c.peek();
                    if (kd2Var2 == null) {
                        this.c.remove();
                    } else if (kd2Var2.a()) {
                        break;
                    } else {
                        this.c.remove();
                    }
                }
                int size = this.c.size();
                if (size == 0) {
                    this.c.offer(kd2Var);
                    gh3.g0(kd2Var);
                } else {
                    kd2 kd2Var3 = (kd2) this.c.peek();
                    this.c.offer(kd2Var);
                    if (size == 1 && kd2Var3 != null && kd2Var3.b(str)) {
                        gh3.g0(kd2Var);
                    } else {
                        gh3.q().post(kd2Var);
                    }
                }
            }
        }
    }
}
