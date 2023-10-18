package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class y35<T> extends Thread implements c45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final List<x35<T>> a;
    @Nullable
    public a45<T> b;
    @NonNull
    public final b45<T> c;
    public volatile boolean d;
    public volatile boolean e;
    @Nullable
    public z35<T> f;

    public y35(@NonNull b45<T> b45Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b45Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Collections.synchronizedList(new ArrayList());
        this.d = false;
        this.e = false;
        this.c = b45Var;
        e();
    }

    @Override // com.baidu.tieba.c45
    public void a(@Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
            synchronized (this.a) {
                for (x35<T> x35Var : this.a) {
                    x35Var.a(objArr);
                }
                this.e = false;
                this.d = true;
                this.a.notifyAll();
            }
        }
    }

    public final void b(@NonNull x35<T> x35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x35Var) == null) {
            synchronized (this.a) {
                Collections.addAll(this.a, x35Var);
            }
        }
    }

    public void d(T t) {
        z35<T> z35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, t) == null) && (z35Var = this.f) != null) {
            z35Var.a(t);
        }
    }

    public void f(@NonNull a45<T> a45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, a45Var) == null) {
            synchronized (this.a) {
                this.b = a45Var;
                this.a.notifyAll();
            }
        }
    }

    public void g(@NonNull z35<T> z35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, z35Var) == null) {
            this.f = z35Var;
        }
    }

    @WorkerThread
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (x35<T> x35Var : this.a) {
                x35Var.onDestroy();
            }
            this.a.clear();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            start();
        }
    }

    @Override // com.baidu.tieba.c45
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d = false;
            this.e = true;
            interrupt();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
        r4 = false;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.a) {
                while (true) {
                    if (isInterrupted()) {
                        c();
                        break;
                    } else if (this.e) {
                        c();
                        break;
                    } else {
                        if (this.a.size() == 0 || !this.d) {
                            try {
                                this.a.wait();
                            } catch (InterruptedException unused) {
                                c();
                            }
                        }
                        int i = 0;
                        while (true) {
                            z = true;
                            if (i >= this.a.size() || this.a.get(i).a == null) {
                                break;
                            } else if (i == this.a.size() - 1) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (z) {
                            if (this.b != null) {
                                this.b.a(this.c.a(this.a));
                            }
                            for (x35<T> x35Var : this.a) {
                                x35Var.a = null;
                                x35Var.onDestroy();
                            }
                            this.a.clear();
                            this.d = false;
                        }
                    }
                }
            }
        }
    }
}
