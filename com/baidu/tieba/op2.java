package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.lifecycle.process.LifecycleProcessType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class op2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static final op2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean a;
    public final List b;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b extends uo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ op2 b;

        public b(op2 op2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {op2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = op2Var;
            this.a = 0;
        }

        @Override // com.baidu.tieba.uo2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                int i = this.a + 1;
                this.a = i;
                if (i == 1) {
                    this.b.d(activity);
                }
            }
        }

        @Override // com.baidu.tieba.uo2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                int i = this.a - 1;
                this.a = i;
                if (i == 0) {
                    this.b.e(activity);
                }
            }
        }

        public /* synthetic */ b(op2 op2Var, a aVar) {
            this(op2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948039864, "Lcom/baidu/tieba/op2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948039864, "Lcom/baidu/tieba/op2;");
                return;
            }
        }
        c = wj1.a;
        d = new op2();
    }

    public static op2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return d;
        }
        return (op2) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (LifecycleProcessType.getCurrent() == LifecycleProcessType.MAIN) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public op2() {
        List list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        ue1 ue1Var = new np2().a;
        if (ue1Var == null) {
            list = null;
        } else {
            list = ue1Var.getList();
        }
        this.b = list;
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && !this.a.getAndSet(true) && c()) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new b(this, null));
            }
        }
    }

    public void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            if (c) {
                String curProcessName = ProcessUtils.getCurProcessName();
                Log.d("ProcessLifecycleDispatcher", curProcessName + " to foreground");
            }
            if (this.b != null) {
                LifecycleProcessType current = LifecycleProcessType.getCurrent();
                for (lp2 lp2Var : this.b) {
                    if (current == lp2Var.b()) {
                        lp2Var.a(true, activity);
                    }
                }
            }
        }
    }

    public void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            if (c) {
                String curProcessName = ProcessUtils.getCurProcessName();
                Log.d("ProcessLifecycleDispatcher", curProcessName + " to background");
            }
            if (this.b != null) {
                LifecycleProcessType current = LifecycleProcessType.getCurrent();
                for (lp2 lp2Var : this.b) {
                    if (current == lp2Var.b()) {
                        lp2Var.a(false, activity);
                    }
                }
            }
        }
    }
}
