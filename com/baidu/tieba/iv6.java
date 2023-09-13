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
/* loaded from: classes6.dex */
public final class iv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final Set<gv6> b;
    public int c;

    public iv6(int i) {
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

    public final gv6 a(int i, int i2) {
        InterceptResult invokeII;
        gv6 gv6Var;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            synchronized (this) {
                Iterator<T> it = this.b.iterator();
                while (true) {
                    gv6Var = null;
                    if (it.hasNext()) {
                        obj = it.next();
                        gv6 gv6Var2 = (gv6) obj;
                        if (gv6Var2.k() >= i && gv6Var2.i() >= i2 && gv6Var2.k() - i < 5 && gv6Var2.i() - i2 < 5) {
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
                gv6 gv6Var3 = (gv6) obj;
                if (gv6Var3 != null) {
                    this.b.remove(gv6Var3);
                    this.c -= gv6Var3.j();
                    gv6Var = gv6Var3;
                }
            }
            return gv6Var;
        }
        return (gv6) invokeII.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (gv6 gv6Var : this.b) {
                    gv6Var.e();
                }
                this.b.clear();
                this.c = 0;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean c(gv6 gv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gv6Var)) == null) {
            if (gv6Var == null || gv6Var.g() == null) {
                return true;
            }
            if (this.b.contains(gv6Var)) {
                return false;
            }
            if (gv6Var.j() + this.c > this.a) {
                BdLog.v("DrawingCache [Release][+] OOM Pool");
                return false;
            }
            synchronized (this) {
                this.b.add(gv6Var);
                gv6Var.f();
                this.c += gv6Var.j();
                Unit unit = Unit.INSTANCE;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
