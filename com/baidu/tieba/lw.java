package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.async.BdRunnable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class lw {
    public static /* synthetic */ Interceptable $ic;
    public static lw e;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService a;
    public Handler b;
    public Handler c;
    public List<kw> d;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lw lwVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lwVar, looper};
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
            this.a = lwVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj = message.obj;
                            if (obj instanceof BdRunnable) {
                                post((BdRunnable) obj);
                            }
                        }
                    } else if (message.obj instanceof kw) {
                        this.a.d.add((kw) message.obj);
                    }
                } else if (this.a.d != null) {
                    Iterator it = this.a.d.iterator();
                    while (it.hasNext()) {
                        kw kwVar = (kw) it.next();
                        if (this.a.e(kwVar)) {
                            this.a.a.submit(kwVar);
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    public lw() {
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
        this.d = new ArrayList();
        this.a = Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        this.b = new a(this, jw.a("threadpool").getLooper());
        this.c = new Handler(Looper.getMainLooper());
    }

    public void h(BdRunnable bdRunnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdRunnable) == null) {
            this.c.post(bdRunnable);
        }
    }

    public static lw f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (lw.class) {
                    if (e == null) {
                        e = new lw();
                    }
                }
            }
            return e;
        }
        return (lw) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.removeMessages(0);
            this.b.sendEmptyMessage(0);
        }
    }

    public final boolean e(kw kwVar) {
        InterceptResult invokeL;
        List<BdRunnable> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kwVar)) == null) {
            if (kwVar != null && (d = kwVar.d()) != null) {
                for (int i = 0; i < d.size(); i++) {
                    BdRunnable bdRunnable = d.get(i);
                    if (bdRunnable != null && !bdRunnable.c()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g(BdRunnable bdRunnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdRunnable) == null) && bdRunnable != null) {
            if (bdRunnable instanceof kw) {
                if (e((kw) bdRunnable)) {
                    this.a.submit(bdRunnable);
                    return;
                } else {
                    this.b.obtainMessage(1, bdRunnable).sendToTarget();
                    return;
                }
            }
            try {
                this.a.submit(bdRunnable);
            } catch (Error e2) {
                bdRunnable.a(e2);
            } catch (Exception e3) {
                bdRunnable.onException(e3);
            }
        }
    }
}
