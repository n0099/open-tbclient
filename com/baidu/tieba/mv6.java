package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
/* loaded from: classes7.dex */
public final class mv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final Set<kv6> b;
    public int c;

    public mv6(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = new LinkedHashSet();
    }

    public final kv6 a(int i, int i2) {
        InterceptResult invokeII;
        kv6 kv6Var;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            synchronized (this) {
                Iterator<T> it = this.b.iterator();
                while (true) {
                    kv6Var = null;
                    if (it.hasNext()) {
                        obj = it.next();
                        kv6 kv6Var2 = (kv6) obj;
                        if (kv6Var2.k() >= i && kv6Var2.i() >= i2 && kv6Var2.k() - i < 5 && kv6Var2.i() - i2 < 5) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                kv6 kv6Var3 = (kv6) obj;
                if (kv6Var3 != null) {
                    this.b.remove(kv6Var3);
                    this.c -= kv6Var3.j();
                    kv6Var = kv6Var3;
                }
            }
            return kv6Var;
        }
        return (kv6) invokeII.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (kv6 kv6Var : this.b) {
                    kv6Var.e();
                }
                this.b.clear();
                this.c = 0;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean c(kv6 kv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kv6Var)) == null) {
            if (kv6Var == null || kv6Var.g() == null) {
                return true;
            }
            if (this.b.contains(kv6Var)) {
                return false;
            }
            if (kv6Var.j() + this.c > this.a) {
                BdLog.v("DrawingCache [Release][+] OOM Pool");
                return false;
            }
            synchronized (this) {
                this.b.add(kv6Var);
                kv6Var.f();
                this.c += kv6Var.j();
                Unit unit = Unit.INSTANCE;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
