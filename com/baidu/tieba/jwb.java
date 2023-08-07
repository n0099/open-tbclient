package com.baidu.tieba;

import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rub;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.ConcurrentLinkedQueueX;
import com.yy.transvod.player.log.TLog;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public abstract class jwb extends dwb implements rub.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String n = "jwb";
    public transient /* synthetic */ FieldHolder $fh;
    public rub l;
    public ConcurrentLinkedQueueX<ByteBuffer> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947899124, "Lcom/baidu/tieba/jwb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947899124, "Lcom/baidu/tieba/jwb;");
        }
    }

    @Override // com.baidu.tieba.rub.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public abstract void y();

    public jwb() {
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
        this.m = new ConcurrentLinkedQueueX<>();
        this.l = new avb(n);
    }

    public jwb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = new ConcurrentLinkedQueueX<>();
        if (z) {
            this.l = new zub(n);
        } else {
            this.l = new avb(n);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TLog.g(this, "ThreadFilter.setup enter.");
            this.l.b(this);
            this.l.start();
            TLog.g(this, "ThreadFilter.setup leave.");
        }
    }

    @Override // com.baidu.tieba.rub.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TLog.g(this, "ThreadFilter.onResume enter.");
            if (!this.f.isEmpty()) {
                this.l.f(2102);
            }
            TLog.g(this, "ThreadFilter.onResume leave.");
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TLog.l(this, "ThreadFilter.onStop mFreeQueue.size() = " + this.m.getElementCount());
        }
    }

    @Override // com.baidu.tieba.dwb
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TLog.g(this, "ThreadFilter.release enter.");
            this.l.c();
            TLog.g(this, "ThreadFilter.release leave.");
        }
    }

    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && message.what == 2102) {
            if (this.e.g() == 6) {
                y();
                return;
            }
            this.l.g(2102);
            TLog.l(this, String.format("player is not running. mCurrentState:%s", yub.a[this.e.g()]));
        }
    }
}
