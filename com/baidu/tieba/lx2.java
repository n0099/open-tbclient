package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class lx2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lx2 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final yj3 a;

    public lx2() {
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
        this.a = new yj3("swan_local_ab_data");
        if (ProcessUtils.isMainProcess()) {
            this.a.clear();
        }
        c();
    }

    public static lx2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (lx2.class) {
                    if (b == null) {
                        b = new lx2();
                    }
                }
            }
            return b;
        }
        return (lx2) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.getString(Config.SID, "");
        }
        return (String) invokeV.objValue;
    }

    public final void c() {
        String substring;
        Object e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && ProcessUtils.isMainProcess()) {
            List<mx2> c = new kx2().c();
            for (mx2 mx2Var : c) {
                nx2 b2 = mx2Var.b();
                ox2 c2 = mx2Var.c();
                if (b2 == null) {
                    e = c2.d();
                } else {
                    e = b2.e();
                }
                if (e instanceof Boolean) {
                    this.a.writeBool(c2.e(), ((Boolean) e).booleanValue());
                } else if (e instanceof Double) {
                    this.a.writeDouble(c2.e(), ((Double) e).doubleValue());
                } else if (e instanceof Integer) {
                    this.a.writeInt(c2.e(), ((Integer) e).intValue());
                } else if (e instanceof Long) {
                    this.a.writeLong(c2.e(), ((Long) e).longValue());
                } else if (e instanceof String) {
                    this.a.writeString(c2.e(), (String) e);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (mx2 mx2Var2 : c) {
                nx2 b3 = mx2Var2.b();
                if (b3 != null) {
                    sb.append(b3.d());
                    sb.append("-");
                }
            }
            if (sb.length() == 0) {
                substring = "";
            } else {
                substring = sb.substring(0, sb.length() - 1);
            }
            this.a.writeString(Config.SID, substring);
        }
    }
}
