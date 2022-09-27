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
/* loaded from: classes5.dex */
public final class o46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final Set<m46> b;
    public int c;

    public o46(int i) {
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

    public final m46 a(int i, int i2) {
        InterceptResult invokeII;
        m46 m46Var;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            synchronized (this) {
                Iterator<T> it = this.b.iterator();
                while (true) {
                    m46Var = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    m46 m46Var2 = (m46) obj;
                    if (m46Var2.l() < i || m46Var2.j() < i2 || m46Var2.l() - i >= 5 || m46Var2.j() - i2 >= 5) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                m46 m46Var3 = (m46) obj;
                if (m46Var3 != null) {
                    this.b.remove(m46Var3);
                    this.c -= m46Var3.k();
                    m46Var = m46Var3;
                }
            }
            return m46Var;
        }
        return (m46) invokeII.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (m46 m46Var : this.b) {
                    m46Var.e();
                }
                this.b.clear();
                this.c = 0;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean c(m46 m46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m46Var)) == null) {
            if ((m46Var == null ? null : m46Var.g()) == null) {
                return true;
            }
            if (this.b.contains(m46Var)) {
                return false;
            }
            if (m46Var.k() + this.c > this.a) {
                BdLog.v("DrawingCache [Release][+] OOM Pool");
                return false;
            }
            synchronized (this) {
                this.b.add(m46Var);
                m46Var.f();
                this.c += m46Var.k();
                Unit unit = Unit.INSTANCE;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
