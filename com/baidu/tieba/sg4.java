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
/* loaded from: classes8.dex */
public class sg4 implements ig4 {
    public static /* synthetic */ Interceptable $ic;
    public static final mj4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Vector<ig4> a;
    public Object b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948150441, "Lcom/baidu/tieba/sg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948150441, "Lcom/baidu/tieba/sg4;");
                return;
            }
        }
        c = mj4.e();
    }

    public sg4(ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ig4Var};
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
        c(ig4Var);
    }

    @Override // com.baidu.tieba.ig4
    public <T> void a(mg4<T> mg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mg4Var) == null) {
            try {
                synchronized (this.b) {
                    Iterator<ig4> it = this.a.iterator();
                    while (it.hasNext()) {
                        it.next().a(mg4Var);
                    }
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskRunning error", th);
            }
        }
    }

    @Override // com.baidu.tieba.ig4
    public <T> void b(mg4<T> mg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mg4Var) == null) {
            Vector vector = new Vector();
            try {
                synchronized (this.b) {
                    Iterator<ig4> it = this.a.iterator();
                    while (it.hasNext()) {
                        vector.add(it.next());
                    }
                }
                Iterator it2 = vector.iterator();
                while (it2.hasNext()) {
                    ((ig4) it2.next()).b(mg4Var);
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskEnd error", th);
            }
        }
    }

    public void c(ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ig4Var) == null) && ig4Var != null) {
            synchronized (this.b) {
                this.a.add(ig4Var);
            }
        }
    }

    public void d(ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ig4Var) == null) && ig4Var != null) {
            synchronized (this.b) {
                if (!this.a.remove(ig4Var)) {
                    this.a.remove(this.a.indexOf(ig4Var));
                }
            }
        }
    }
}
