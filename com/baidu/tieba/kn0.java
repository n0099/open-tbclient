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
public class kn0 extends Handler implements in0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentLinkedQueue<b<?>> a;
    public boolean b;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final kn0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-655874017, "Lcom/baidu/tieba/kn0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-655874017, "Lcom/baidu/tieba/kn0$a;");
                    return;
                }
            }
            a = new kn0();
        }
    }

    /* loaded from: classes6.dex */
    public static class b<T extends gn0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final jn0<T> a;
        public final T b;

        public b(ln0 ln0Var, jn0<T> jn0Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln0Var, jn0Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn0Var;
            this.b = t;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kn0() {
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

    public static in0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (in0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in0
    public <T extends gn0> void a(ln0 ln0Var, jn0<T> jn0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ln0Var, jn0Var, t) == null) {
            if (ik0.b()) {
                jn0Var.onEvent(t);
                return;
            }
            synchronized (this) {
                this.a.offer(new b<>(ln0Var, jn0Var, t));
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
