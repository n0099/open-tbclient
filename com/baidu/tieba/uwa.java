package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uwa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdStatsItem a;
    public String b;
    public boolean c;

    public uwa(String str) {
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
        xwa c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null && (c = c()) != null && c.f != null) {
            long timeCost = this.a.getTimeCost();
            if (timeCost > 3000) {
                wwa wwaVar = c.f;
                wwaVar.a += timeCost;
                wwaVar.b++;
                vwa.b(c, 10);
            }
        }
    }

    public void b(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        xwa c;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) != null) || this.a == null || (c = c()) == null) {
            return;
        }
        if (z) {
            wwa wwaVar = c.d;
            if (wwaVar == null) {
                return;
            }
            wwaVar.b++;
            if (z2) {
                wwaVar.a += j2;
                wwaVar.d += j;
            } else {
                wwaVar.c++;
            }
        } else {
            wwa wwaVar2 = c.e;
            if (wwaVar2 == null) {
                return;
            }
            wwaVar2.b++;
            if (z2) {
                wwaVar2.a += j3;
                wwaVar2.d += j;
            } else {
                wwaVar2.c++;
            }
            j2 = j3;
        }
        this.a = null;
        if (z2) {
            vwa.b(c, 10);
        }
        if (this.b == "frsStat") {
            if (!z2 || j2 > 3000) {
                BdStatsItem bdStatsItem = new BdStatsItem("dbg");
                bdStatsItem.append("act", "frs");
                String str3 = "0";
                if (z2) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                bdStatsItem.append("result", str2);
                if (z) {
                    str3 = "1";
                }
                bdStatsItem.append("isHttp", str3);
                bdStatsItem.append("timeCost", String.valueOf(j2));
                bdStatsItem.append(StatConstants.KEY_EXT_ERR_CODE, String.valueOf(i));
                bdStatsItem.append(StatConstants.KEY_EXT_ERR_MSG, str);
                bdStatsItem.append("down", String.valueOf(j));
                BdStatisticsManager.getInstance().debug("frs", bdStatsItem);
            }
        }
    }

    public final xwa c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return vwa.e(this.b, d(), this.c);
        }
        return (xwa) invokeV.objValue;
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
            this.a.startTimer();
        }
    }

    public void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            this.b = str;
            this.c = z;
            this.a = new BdStatsItem("dbg");
            vwa.c(str, d(), z);
        }
    }
}
