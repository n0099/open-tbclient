package com.bytedance.sdk.component.adnet.d;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.adnet.core.Header;
import com.bytedance.sdk.component.adnet.core.o;
import com.bytedance.sdk.component.adnet.face.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static a.C0316a a(com.bytedance.sdk.component.adnet.core.i iVar) {
        InterceptResult invokeL;
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iVar)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, String> map = iVar.f27906c;
            String str = map.get("Date");
            long a2 = str != null ? a(str) : 0L;
            String str2 = map.get("Cache-Control");
            int i2 = 0;
            if (str2 != null) {
                String[] split = str2.split(",", 0);
                int i3 = 0;
                j = 0;
                j2 = 0;
                while (i2 < split.length) {
                    String trim = split[i2].trim();
                    if (trim.equals("no-cache") || trim.equals("no-store")) {
                        return null;
                    }
                    if (trim.startsWith("max-age=")) {
                        try {
                            j = Long.parseLong(trim.substring(8));
                        } catch (Exception unused) {
                        }
                    } else if (trim.startsWith("stale-while-revalidate=")) {
                        j2 = Long.parseLong(trim.substring(23));
                    } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                        i3 = 1;
                    }
                    i2++;
                }
                i2 = i3;
                z = true;
            } else {
                z = false;
                j = 0;
                j2 = 0;
            }
            String str3 = map.get("Expires");
            long a3 = str3 != null ? a(str3) : 0L;
            String str4 = map.get("Last-Modified");
            long a4 = str4 != null ? a(str4) : 0L;
            String str5 = map.get("ETag");
            if (z) {
                j4 = currentTimeMillis + (j * 1000);
                if (i2 != 0) {
                    j5 = j4;
                } else {
                    Long.signum(j2);
                    j5 = (j2 * 1000) + j4;
                }
                j3 = j5;
            } else {
                j3 = 0;
                if (a2 <= 0 || a3 < a2) {
                    j4 = 0;
                } else {
                    j4 = currentTimeMillis + (a3 - a2);
                    j3 = j4;
                }
            }
            a.C0316a c0316a = new a.C0316a();
            c0316a.f27956a = iVar.f27904a;
            c0316a.f27957b = iVar.f27905b;
            c0316a.f27958c = str5;
            c0316a.f27962g = j4;
            c0316a.f27961f = j3;
            c0316a.f27959d = a2;
            c0316a.f27960e = a4;
            c0316a.f27963h = map;
            c0316a.f27964i = iVar.f27907d;
            return c0316a;
        }
        return (a.C0316a) invokeL.objValue;
    }

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return a().parse(str).getTime();
            } catch (Throwable th) {
                o.a(th, "Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? a().format(new Date(j)) : (String) invokeJ.objValue;
    }

    public static SimpleDateFormat a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat;
        }
        return (SimpleDateFormat) invokeV.objValue;
    }

    public static String a(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, str)) == null) {
            String str2 = map.get("Content-Type");
            if (str2 != null) {
                String[] split = str2.split(";", 0);
                for (int i2 = 1; i2 < split.length; i2++) {
                    String[] split2 = split[i2].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        return split2[1];
                    }
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static Map<String, String> a(List<Header> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, list)) == null) {
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            if (list != null) {
                for (Header header : list) {
                    treeMap.put(header.getName(), header.getValue());
                }
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static List<Header> a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, map)) == null) {
            if (map == null) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new Header(entry.getKey(), entry.getValue()));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
