package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class s82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<w82> a;
    public final Object b;
    public final int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948105212, "Lcom/baidu/tieba/s82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948105212, "Lcom/baidu/tieba/s82;");
                return;
            }
        }
        d = vm1.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public s82(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i < 1) {
            if (!d) {
                i = 1;
            } else {
                throw new RuntimeException("MasterPool size can not less than 1");
            }
        }
        this.c = i;
        this.b = new Object();
        this.a = new LinkedList();
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || TextUtils.isEmpty(str) || TextUtils.equals(str, "_default_id_")) {
            return;
        }
        synchronized (this.b) {
            ArrayList arrayList = new ArrayList();
            for (w82 w82Var : this.a) {
                if (TextUtils.equals(w82Var.h(), str)) {
                    arrayList.add(w82Var);
                }
            }
            b(arrayList);
        }
    }

    public void a(Collection<w82> collection) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, collection) == null) {
            int i = 0;
            if (collection != null && collection.size() > 0) {
                z = false;
            } else {
                z = true;
            }
            if (d) {
                StringBuilder sb = new StringBuilder();
                sb.append("master pool clear, excludes size - ");
                if (collection != null) {
                    i = collection.size();
                }
                sb.append(i);
                Log.i("MasterPool", sb.toString());
                if (collection != null) {
                    for (w82 w82Var : collection) {
                        if (w82Var.i() != null) {
                            Log.i("MasterPool", "excludes  - " + w82Var.i().a());
                        }
                    }
                }
            }
            synchronized (this.b) {
                ArrayList arrayList = new ArrayList();
                for (w82 w82Var2 : this.a) {
                    if (z || (collection != null && !collection.contains(w82Var2))) {
                        arrayList.add(w82Var2);
                    }
                }
                b(arrayList);
            }
        }
    }

    public final void b(Collection<w82> collection) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) && collection.size() > 0) {
            if (d) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            this.a.removeAll(collection);
            if (d) {
                Log.i("MasterPool", "remove no use master in pool, size - " + collection.size());
            }
            for (w82 w82Var : collection) {
                if (w82Var.i() != null) {
                    w82Var.i().destroy();
                    if (d) {
                        Log.i("MasterPool", "master destroy, id - " + w82Var.i().a() + ", isReady - " + w82Var.n() + ", is Default - " + w82Var.l() + ", is Prefetch - " + w82Var.j());
                    }
                }
            }
            if (d) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("MasterPool", "destroy masters cost - " + (currentTimeMillis - j) + ms.c);
            }
        }
    }

    public void g(Collection<w82> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, collection) == null) {
            if (this.c >= 3) {
                boolean z = true;
                if (this.a.size() > 1) {
                    if (collection != null && collection.size() > 0) {
                        z = false;
                    }
                    synchronized (this.b) {
                        ArrayList arrayList = new ArrayList();
                        for (w82 w82Var : this.a) {
                            if (!w82Var.l() && w82Var.j() && (z || !collection.contains(w82Var))) {
                                arrayList.add(w82Var);
                            }
                        }
                        if (d) {
                            Log.d("MasterPool", "remove all prefetch event master, size - " + arrayList.size());
                        }
                        b(arrayList);
                    }
                    return;
                }
            }
            if (d) {
                Log.d("MasterPool", "no need to remove prefetch master");
                Log.d("MasterPool", "max size - " + this.c);
                Log.d("MasterPool", "current cache size - " + this.a.size());
            }
        }
    }

    public w82 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            w82 w82Var = null;
            if (TextUtils.isEmpty(str)) {
                if (d) {
                    Log.w("MasterPool", "appId can not be empty");
                }
                return null;
            }
            synchronized (this.b) {
                if (TextUtils.equals(str, "_default_id_")) {
                    if (d) {
                        Log.i("MasterPool", "get default master manger for id - " + str);
                    }
                    return e();
                }
                int size = this.a.size() - 1;
                int i = size;
                while (true) {
                    if (i < 0) {
                        break;
                    }
                    w82 w82Var2 = this.a.get(i);
                    if (TextUtils.equals(w82Var2.h(), str)) {
                        if (d) {
                            Log.i("MasterPool", "get master in pool for id - " + str);
                        }
                        w82Var = w82Var2;
                    } else {
                        i--;
                    }
                }
                if (w82Var != null && i != size) {
                    this.a.remove(i);
                    this.a.add(w82Var);
                }
                if (d) {
                    if (w82Var == null) {
                        Log.i("MasterPool", "find no master for id - " + str);
                    } else {
                        Log.i("MasterPool", "hit a master cache for id - " + str);
                    }
                }
                return w82Var;
            }
        }
        return (w82) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final w82 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            for (w82 w82Var : this.a) {
                if (w82Var.l()) {
                    return w82Var;
                }
            }
            if (!d) {
                return null;
            }
            throw new RuntimeException("there must be one default master in pool, you should add default one first");
        }
        return (w82) invokeV.objValue;
    }

    public void f(w82 w82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, w82Var) != null) || w82Var == null) {
            return;
        }
        synchronized (this.b) {
            if (!this.a.contains(w82Var)) {
                this.a.add(w82Var);
            }
            h();
        }
    }

    public final void h() {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (size = this.a.size()) <= this.c) {
            return;
        }
        if (d) {
            Log.i("MasterPool", "resize, current - " + size + ", target - " + this.c);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            w82 w82Var = this.a.get(i);
            if (w82Var.l() && !z) {
                z = true;
            } else {
                arrayList.add(w82Var);
                if (arrayList.size() >= size - this.c) {
                    break;
                }
            }
        }
        b(arrayList);
    }
}
