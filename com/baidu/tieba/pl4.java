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
/* loaded from: classes7.dex */
public class pl4 implements fl4 {
    public static /* synthetic */ Interceptable $ic;
    public static final jo4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Vector<fl4> a;
    public Object b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948065873, "Lcom/baidu/tieba/pl4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948065873, "Lcom/baidu/tieba/pl4;");
                return;
            }
        }
        c = jo4.e();
    }

    public pl4(fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fl4Var};
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
        this.a = new Vector<>();
        c(fl4Var);
    }

    @Override // com.baidu.tieba.fl4
    public <T> void a(jl4<T> jl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jl4Var) == null) {
            try {
                synchronized (this.b) {
                    Iterator<fl4> it = this.a.iterator();
                    while (it.hasNext()) {
                        it.next().a(jl4Var);
                    }
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskRunning error", th);
            }
        }
    }

    @Override // com.baidu.tieba.fl4
    public <T> void b(jl4<T> jl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jl4Var) == null) {
            Vector vector = new Vector();
            try {
                synchronized (this.b) {
                    Iterator<fl4> it = this.a.iterator();
                    while (it.hasNext()) {
                        vector.add(it.next());
                    }
                }
                Iterator it2 = vector.iterator();
                while (it2.hasNext()) {
                    ((fl4) it2.next()).b(jl4Var);
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskEnd error", th);
            }
        }
    }

    public void c(fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fl4Var) == null) && fl4Var != null) {
            synchronized (this.b) {
                this.a.add(fl4Var);
            }
        }
    }

    public void d(fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, fl4Var) == null) && fl4Var != null) {
            synchronized (this.b) {
                if (!this.a.remove(fl4Var)) {
                    this.a.remove(this.a.indexOf(fl4Var));
                }
            }
        }
    }
}
