package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public og a;
    public String b;
    public boolean c;

    public zl9(String str) {
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
        cm9 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null && (c = c()) != null && c.f != null) {
            long e = this.a.e();
            if (e > 3000) {
                bm9 bm9Var = c.f;
                bm9Var.a += e;
                bm9Var.b++;
                am9.b(c, 10);
            }
        }
    }

    public void b(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        cm9 c;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) != null) || this.a == null || (c = c()) == null) {
            return;
        }
        if (z) {
            bm9 bm9Var = c.d;
            if (bm9Var == null) {
                return;
            }
            bm9Var.b++;
            if (z2) {
                bm9Var.a += j2;
                bm9Var.d += j;
            } else {
                bm9Var.c++;
            }
        } else {
            bm9 bm9Var2 = c.e;
            if (bm9Var2 == null) {
                return;
            }
            bm9Var2.b++;
            if (z2) {
                bm9Var2.a += j3;
                bm9Var2.d += j;
            } else {
                bm9Var2.c++;
            }
            j2 = j3;
        }
        this.a = null;
        if (z2) {
            am9.b(c, 10);
        }
        if (this.b == "frsStat") {
            if (!z2 || j2 > 3000) {
                og ogVar = new og("dbg");
                ogVar.b("act", "frs");
                String str3 = "0";
                if (z2) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                ogVar.b("result", str2);
                if (z) {
                    str3 = "1";
                }
                ogVar.b("isHttp", str3);
                ogVar.b("timeCost", String.valueOf(j2));
                ogVar.b(StatConstants.KEY_EXT_ERR_CODE, String.valueOf(i));
                ogVar.b(StatConstants.KEY_EXT_ERR_MSG, str);
                ogVar.b("down", String.valueOf(j));
                BdStatisticsManager.getInstance().debug("frs", ogVar);
            }
        }
    }

    public final cm9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return am9.e(this.b, d(), this.c);
        }
        return (cm9) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int netType = BdNetTypeUtil.netType();
            if (netType == 0) {
                return "N";
            }
            if (netType == 1) {
                return "WIFI";
            }
            if (netType == 3) {
                return "3G";
            }
            if (netType != 2) {
                return "N";
            }
            return "2G";
        }
        return (String) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.g();
        }
    }

    public void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            this.b = str;
            this.c = z;
            this.a = new og("dbg");
            am9.c(str, d(), z);
        }
    }
}
