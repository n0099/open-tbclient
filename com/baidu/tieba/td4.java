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
/* loaded from: classes5.dex */
public class td4 implements jd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final ng4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Vector<jd4> a;
    public Object b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948177349, "Lcom/baidu/tieba/td4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948177349, "Lcom/baidu/tieba/td4;");
                return;
            }
        }
        c = ng4.e();
    }

    public td4(jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jd4Var};
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
        c(jd4Var);
    }

    @Override // com.baidu.tieba.jd4
    public <T> void a(nd4<T> nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nd4Var) == null) {
            try {
                synchronized (this.b) {
                    Iterator<jd4> it = this.a.iterator();
                    while (it.hasNext()) {
                        it.next().a(nd4Var);
                    }
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskRunning error", th);
            }
        }
    }

    @Override // com.baidu.tieba.jd4
    public <T> void b(nd4<T> nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nd4Var) == null) {
            Vector vector = new Vector();
            try {
                synchronized (this.b) {
                    Iterator<jd4> it = this.a.iterator();
                    while (it.hasNext()) {
                        vector.add(it.next());
                    }
                }
                Iterator it2 = vector.iterator();
                while (it2.hasNext()) {
                    ((jd4) it2.next()).b(nd4Var);
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskEnd error", th);
            }
        }
    }

    public void c(jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jd4Var) == null) || jd4Var == null) {
            return;
        }
        synchronized (this.b) {
            this.a.add(jd4Var);
        }
    }

    public void d(jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jd4Var) == null) || jd4Var == null) {
            return;
        }
        synchronized (this.b) {
            if (!this.a.remove(jd4Var)) {
                this.a.remove(this.a.indexOf(jd4Var));
            }
        }
    }
}
