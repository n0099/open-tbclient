package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Vector;
/* loaded from: classes6.dex */
public class ud4 implements kd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final og4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Vector a;
    public Object b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948207140, "Lcom/baidu/tieba/ud4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948207140, "Lcom/baidu/tieba/ud4;");
                return;
            }
        }
        c = og4.e();
    }

    public ud4(kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kd4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new Object();
        this.a = new Vector();
        c(kd4Var);
    }

    @Override // com.baidu.tieba.kd4
    public void a(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, od4Var) == null) {
            try {
                synchronized (this.b) {
                    Iterator it = this.a.iterator();
                    while (it.hasNext()) {
                        ((kd4) it.next()).a(od4Var);
                    }
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskRunning error", th);
            }
        }
    }

    @Override // com.baidu.tieba.kd4
    public void b(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, od4Var) == null) {
            Vector vector = new Vector();
            try {
                synchronized (this.b) {
                    Iterator it = this.a.iterator();
                    while (it.hasNext()) {
                        vector.add((kd4) it.next());
                    }
                }
                Iterator it2 = vector.iterator();
                while (it2.hasNext()) {
                    ((kd4) it2.next()).b(od4Var);
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskEnd error", th);
            }
        }
    }

    public void c(kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kd4Var) == null) && kd4Var != null) {
            synchronized (this.b) {
                this.a.add(kd4Var);
            }
        }
    }

    public void d(kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, kd4Var) == null) && kd4Var != null) {
            synchronized (this.b) {
                if (!this.a.remove(kd4Var)) {
                    this.a.remove(this.a.indexOf(kd4Var));
                }
            }
        }
    }
}
