package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class io0 extends Handler implements go0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentLinkedQueue<b<?>> a;
    public boolean b;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final io0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-712208798, "Lcom/baidu/tieba/io0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-712208798, "Lcom/baidu/tieba/io0$a;");
                    return;
                }
            }
            a = new io0();
        }
    }

    /* loaded from: classes6.dex */
    public static class b<T extends eo0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ho0<T> a;
        public final T b;

        public b(jo0 jo0Var, ho0<T> ho0Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo0Var, ho0Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ho0Var;
            this.b = t;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public io0() {
        super(Looper.getMainLooper());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentLinkedQueue<>();
        this.b = false;
    }

    public static go0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (go0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.go0
    public <T extends eo0> void a(jo0 jo0Var, ho0<T> ho0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, jo0Var, ho0Var, t) == null) {
            if (gl0.b()) {
                ho0Var.onEvent(t);
                return;
            }
            synchronized (this) {
                this.a.offer(new b<>(jo0Var, ho0Var, t));
                if (!this.b) {
                    sendMessage(Message.obtain());
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                do {
                    b<?> poll = this.a.poll();
                    if (poll == null) {
                        synchronized (this) {
                            poll = this.a.poll();
                            if (poll == null) {
                                this.b = false;
                                return;
                            }
                        }
                    }
                    poll.a.onEvent(poll.b);
                } while (System.currentTimeMillis() - currentTimeMillis < 5);
                sendMessage(Message.obtain());
                this.b = true;
            } finally {
                this.b = false;
            }
        }
    }
}
