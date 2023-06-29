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
/* loaded from: classes8.dex */
public class u4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dh a;
    public String b;
    public boolean c;

    public u4a(String str) {
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
        x4a c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null && (c = c()) != null && c.f != null) {
            long e = this.a.e();
            if (e > 3000) {
                w4a w4aVar = c.f;
                w4aVar.a += e;
                w4aVar.b++;
                v4a.b(c, 10);
            }
        }
    }

    public void b(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        x4a c;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) != null) || this.a == null || (c = c()) == null) {
            return;
        }
        if (z) {
            w4a w4aVar = c.d;
            if (w4aVar == null) {
                return;
            }
            w4aVar.b++;
            if (z2) {
                w4aVar.a += j2;
                w4aVar.d += j;
            } else {
                w4aVar.c++;
            }
        } else {
            w4a w4aVar2 = c.e;
            if (w4aVar2 == null) {
                return;
            }
            w4aVar2.b++;
            if (z2) {
                w4aVar2.a += j3;
                w4aVar2.d += j;
            } else {
                w4aVar2.c++;
            }
            j2 = j3;
        }
        this.a = null;
        if (z2) {
            v4a.b(c, 10);
        }
        if (this.b == "frsStat") {
            if (!z2 || j2 > 3000) {
                dh dhVar = new dh("dbg");
                dhVar.b("act", "frs");
                String str3 = "0";
                if (z2) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                dhVar.b("result", str2);
                if (z) {
                    str3 = "1";
                }
                dhVar.b("isHttp", str3);
                dhVar.b("timeCost", String.valueOf(j2));
                dhVar.b(StatConstants.KEY_EXT_ERR_CODE, String.valueOf(i));
                dhVar.b(StatConstants.KEY_EXT_ERR_MSG, str);
                dhVar.b("down", String.valueOf(j));
                BdStatisticsManager.getInstance().debug("frs", dhVar);
            }
        }
    }

    public final x4a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return v4a.e(this.b, d(), this.c);
        }
        return (x4a) invokeV.objValue;
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
            this.a = new dh("dbg");
            v4a.c(str, d(), z);
        }
    }
}
