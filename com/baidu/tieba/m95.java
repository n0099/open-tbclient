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
/* loaded from: classes7.dex */
public class m95<T> extends Thread implements q95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final List<l95<T>> a;
    @Nullable
    public o95<T> b;
    @NonNull
    public final p95<T> c;
    public volatile boolean d;
    public volatile boolean e;
    @Nullable
    public n95<T> f;

    public m95(@NonNull p95<T> p95Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p95Var};
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
        this.c = p95Var;
        e();
    }

    @Override // com.baidu.tieba.q95
    public void a(@Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
            synchronized (this.a) {
                for (l95<T> l95Var : this.a) {
                    l95Var.a(objArr);
                }
                this.e = false;
                this.d = true;
                this.a.notifyAll();
            }
        }
    }

    public final void b(@NonNull l95<T> l95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l95Var) == null) {
            synchronized (this.a) {
                Collections.addAll(this.a, l95Var);
            }
        }
    }

    public void d(T t) {
        n95<T> n95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, t) == null) && (n95Var = this.f) != null) {
            n95Var.a(t);
        }
    }

    public void f(@NonNull o95<T> o95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, o95Var) == null) {
            synchronized (this.a) {
                this.b = o95Var;
                this.a.notifyAll();
            }
        }
    }

    public void g(@NonNull n95<T> n95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, n95Var) == null) {
            this.f = n95Var;
        }
    }

    @WorkerThread
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (l95<T> l95Var : this.a) {
                l95Var.onDestroy();
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

    @Override // com.baidu.tieba.q95
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
                            for (l95<T> l95Var : this.a) {
                                l95Var.a = null;
                                l95Var.onDestroy();
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
