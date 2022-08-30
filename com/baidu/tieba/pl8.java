package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xg a;
    public String b;
    public boolean c;

    public pl8(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = false;
        e(str, false);
    }

    public void a() {
        sl8 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null || (c = c()) == null || c.f == null) {
            return;
        }
        long e = this.a.e();
        if (e > 3000) {
            rl8 rl8Var = c.f;
            rl8Var.a += e;
            rl8Var.b++;
            ql8.b(c, 10);
        }
    }

    public void b(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        sl8 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.a == null || (c = c()) == null) {
            return;
        }
        if (z) {
            rl8 rl8Var = c.d;
            if (rl8Var == null) {
                return;
            }
            rl8Var.b++;
            if (z2) {
                rl8Var.a += j2;
                rl8Var.d += j;
            } else {
                rl8Var.c++;
            }
        } else {
            rl8 rl8Var2 = c.e;
            if (rl8Var2 == null) {
                return;
            }
            rl8Var2.b++;
            if (z2) {
                rl8Var2.a += j3;
                rl8Var2.d += j;
            } else {
                rl8Var2.c++;
            }
            j2 = j3;
        }
        this.a = null;
        if (z2) {
            ql8.b(c, 10);
        }
        if (this.b == "frsStat") {
            if (!z2 || j2 > 3000) {
                xg xgVar = new xg("dbg");
                xgVar.b("act", "frs");
                xgVar.b(TiebaStatic.LogFields.RESULT, z2 ? "0" : "1");
                xgVar.b("isHttp", z ? "1" : "0");
                xgVar.b("timeCost", String.valueOf(j2));
                xgVar.b(StatConstants.KEY_EXT_ERR_CODE, String.valueOf(i));
                xgVar.b(StatConstants.KEY_EXT_ERR_MSG, str);
                xgVar.b("down", String.valueOf(j));
                BdStatisticsManager.getInstance().debug("frs", xgVar);
            }
        }
    }

    public final sl8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ql8.e(this.b, d(), this.c) : (sl8) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int I = pi.I();
            return I == 0 ? "N" : I == 1 ? "WIFI" : I == 3 ? "3G" : I == 2 ? "2G" : "N";
        }
        return (String) invokeV.objValue;
    }

    public void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            this.b = str;
            this.c = z;
            this.a = new xg("dbg");
            ql8.c(str, d(), z);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.g();
        }
    }
}
