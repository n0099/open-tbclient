package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.NetLog;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class je {
    public static /* synthetic */ Interceptable $ic;
    public static List<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448308178, "Lcom/baidu/tieba/je;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448308178, "Lcom/baidu/tieba/je;");
                return;
            }
        }
        a = Collections.synchronizedList(new ArrayList());
    }

    public static List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (List) invokeV.objValue;
    }

    public static void a(@NonNull String str, int i) throws UnknownHostException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, str, i) == null) {
            try {
                a.clear();
                DnsHelper dnsHelper = new DnsHelper(AppRuntime.getAppContext());
                dnsHelper.setHttpDnsState(false, null, false, true);
                List<String> ipList = dnsHelper.getIpList(str);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (ipList != null && !ipList.isEmpty()) {
                    for (int i2 = 0; i2 < ipList.size(); i2++) {
                        if (c(ipList.get(i2))) {
                            TbLog netLog = NetLog.getInstance();
                            netLog.i("SocketIps", "V4 ： " + ipList.get(i2));
                            arrayList.add(ipList.get(i2));
                        } else {
                            TbLog netLog2 = NetLog.getInstance();
                            netLog2.i("SocketIps", "V6 ： " + ipList.get(i2));
                            arrayList2.add(ipList.get(i2));
                        }
                    }
                }
                int size = arrayList2.size();
                int size2 = arrayList.size();
                if (size > 0 && i == 2) {
                    a.addAll(arrayList2);
                } else if (size2 > 0 && i == 1) {
                    a.addAll(arrayList);
                } else if (i == 3) {
                    if (size > 0) {
                        a.addAll(arrayList2);
                    }
                    if (size2 > 0) {
                        a.addAll(arrayList);
                    }
                } else {
                    a.addAll(arrayList);
                }
            } catch (NullPointerException e) {
                BdLog.detailException(e);
            }
        }
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null && !str.isEmpty()) {
                return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
