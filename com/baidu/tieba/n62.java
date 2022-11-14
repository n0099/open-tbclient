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
/* loaded from: classes5.dex */
public class n62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<r62> a;
    public final Object b;
    public final int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947954335, "Lcom/baidu/tieba/n62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947954335, "Lcom/baidu/tieba/n62;");
                return;
            }
        }
        d = pk1.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public n62(int i) {
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
            for (r62 r62Var : this.a) {
                if (TextUtils.equals(r62Var.h(), str)) {
                    arrayList.add(r62Var);
                }
            }
            b(arrayList);
        }
    }

    public void a(Collection<r62> collection) {
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
                    for (r62 r62Var : collection) {
                        if (r62Var.i() != null) {
                            Log.i("MasterPool", "excludes  - " + r62Var.i().a());
                        }
                    }
                }
            }
            synchronized (this.b) {
                ArrayList arrayList = new ArrayList();
                for (r62 r62Var2 : this.a) {
                    if (z || (collection != null && !collection.contains(r62Var2))) {
                        arrayList.add(r62Var2);
                    }
                }
                b(arrayList);
            }
        }
    }

    public final void b(Collection<r62> collection) {
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
            for (r62 r62Var : collection) {
                if (r62Var.i() != null) {
                    r62Var.i().destroy();
                    if (d) {
                        Log.i("MasterPool", "master destroy, id - " + r62Var.i().a() + ", isReady - " + r62Var.n() + ", is Default - " + r62Var.l() + ", is Prefetch - " + r62Var.j());
                    }
                }
            }
            if (d) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("MasterPool", "destroy masters cost - " + (currentTimeMillis - j) + "ms");
            }
        }
    }

    public void g(Collection<r62> collection) {
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
                        for (r62 r62Var : this.a) {
                            if (!r62Var.l() && r62Var.j() && (z || !collection.contains(r62Var))) {
                                arrayList.add(r62Var);
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

    public r62 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            r62 r62Var = null;
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
                    r62 r62Var2 = this.a.get(i);
                    if (TextUtils.equals(r62Var2.h(), str)) {
                        if (d) {
                            Log.i("MasterPool", "get master in pool for id - " + str);
                        }
                        r62Var = r62Var2;
                    } else {
                        i--;
                    }
                }
                if (r62Var != null && i != size) {
                    this.a.remove(i);
                    this.a.add(r62Var);
                }
                if (d) {
                    if (r62Var == null) {
                        Log.i("MasterPool", "find no master for id - " + str);
                    } else {
                        Log.i("MasterPool", "hit a master cache for id - " + str);
                    }
                }
                return r62Var;
            }
        }
        return (r62) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final r62 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            for (r62 r62Var : this.a) {
                if (r62Var.l()) {
                    return r62Var;
                }
            }
            if (!d) {
                return null;
            }
            throw new RuntimeException("there must be one default master in pool, you should add default one first");
        }
        return (r62) invokeV.objValue;
    }

    public void f(r62 r62Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, r62Var) != null) || r62Var == null) {
            return;
        }
        synchronized (this.b) {
            if (!this.a.contains(r62Var)) {
                this.a.add(r62Var);
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
            r62 r62Var = this.a.get(i);
            if (r62Var.l() && !z) {
                z = true;
            } else {
                arrayList.add(r62Var);
                if (arrayList.size() >= size - this.c) {
                    break;
                }
            }
        }
        b(arrayList);
    }
}
