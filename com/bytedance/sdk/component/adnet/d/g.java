package com.bytedance.sdk.component.adnet.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<String>> f64197a;

    /* renamed from: b  reason: collision with root package name */
    public String f64198b;

    public g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64197a = new LinkedHashMap();
        this.f64198b = str;
    }

    private String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            if (str2 == null) {
                str2 = "ISO-8859-1";
            }
            try {
                return URLEncoder.encode(str, str2);
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return (String) invokeLL.objValue;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            List<String> list = this.f64197a.get(str);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(String.valueOf(i2));
            this.f64197a.put(str, list);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? a() : (String) invokeV.objValue;
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64197a = new LinkedHashMap();
        this.f64198b = null;
    }

    public void a(String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Double.valueOf(d2)}) == null) {
            List<String> list = this.f64197a.get(str);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(String.valueOf(d2));
            this.f64197a.put(str, list);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            List<String> list = this.f64197a.get(str);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(String.valueOf(str2));
            this.f64197a.put(str, list);
        }
    }

    public String a() {
        InterceptResult invokeV;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f64197a.isEmpty()) {
                return this.f64198b;
            }
            String a2 = a(this.f64197a, "UTF-8");
            String str2 = this.f64198b;
            if (str2 == null || str2.length() == 0) {
                return a2;
            }
            if (this.f64198b.indexOf(63) >= 0) {
                sb = new StringBuilder();
                sb.append(this.f64198b);
                str = "&";
            } else {
                sb = new StringBuilder();
                sb.append(this.f64198b);
                str = "?";
            }
            sb.append(str);
            sb.append(a2);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String a(Map<String, List<String>> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, str)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String b2 = b(entry.getKey(), str);
                List<String> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    Iterator<String> it = value.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        String b3 = next != null ? b(next, str) : "";
                        if (sb.length() > 0) {
                            sb.append("&");
                        }
                        sb.append(b2);
                        if (!b3.isEmpty()) {
                            sb.append("=");
                            sb.append(b3);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
