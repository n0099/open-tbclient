package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes5.dex */
public class lf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public HttpMessageTask.HTTP_METHOD c;
    public Map<String, String> d;
    public LinkedList<BasicNameValuePair> e;
    public Map<String, String> f;
    public HashMap<String, byte[]> g;
    public boolean h;
    public boolean i;

    public lf() {
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
        this.a = "";
        this.b = "";
        this.d = new HashMap();
        this.e = new LinkedList<>();
        this.f = new LinkedHashMap();
        this.g = new HashMap<>();
        this.h = false;
        this.i = false;
    }

    public void a(String str, String str2) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && (map = this.d) != null) {
            map.put(str, str2);
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && str2 != null) {
            this.e.add(new BasicNameValuePair(str, str2));
            this.f.put(str, str2);
        }
    }

    public void c(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            this.g.put(str, bArr);
        }
    }

    public void d(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, basicNameValuePair) == null) && basicNameValuePair != null && basicNameValuePair.getValue() != null) {
            this.e.add(basicNameValuePair);
            this.f.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
        }
    }

    public String k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            if (z) {
                return this.a;
            }
            return this.b;
        }
        return (String) invokeZ.objValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.i = z;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.h = z;
        }
    }

    public void p(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hashMap) == null) {
            this.d = hashMap;
        }
    }

    public void q(HttpMessageTask.HTTP_METHOD http_method) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, http_method) == null) {
            this.c = http_method;
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public Map<String, String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (Map) invokeV.objValue;
    }

    public HttpMessageTask.HTTP_METHOD h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (HttpMessageTask.HTTP_METHOD) invokeV.objValue;
    }

    public Map<String, String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (Map) invokeV.objValue;
    }

    public LinkedList<BasicNameValuePair> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return (LinkedList) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HashMap<String, byte[]> hashMap = this.g;
            if (hashMap != null && hashMap.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public String f(boolean z, jf jfVar) {
        InterceptResult invokeZL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048581, this, z, jfVar)) == null) {
            if (z) {
                str = this.a;
            } else {
                str = this.b;
            }
            if (this.e.size() == 0) {
                if (jfVar != null) {
                    jfVar.a = str.length();
                }
                return str;
            }
            StringBuilder sb = new StringBuilder(30);
            sb.append(str);
            if (str.indexOf("?") < 0) {
                sb.append("?");
            } else if (!str.endsWith("?") && !str.endsWith("&")) {
                sb.append("&");
            }
            for (int i = 0; i < this.e.size(); i++) {
                if (i != 0) {
                    sb.append("&");
                }
                sb.append(this.e.get(i).getName());
                sb.append("=");
                sb.append(hi.getUrlEncode(this.e.get(i).getValue()));
            }
            if (jfVar != null) {
                jfVar.a = sb.length();
            }
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public void r(List<Map.Entry<String, Object>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        if (entry.getValue() != null) {
                            this.e.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                            this.f.put(entry.getKey(), (String) entry.getValue());
                        }
                    } else if (value instanceof byte[]) {
                        this.g.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (str == null) {
                this.a = "";
            } else {
                this.a = str;
            }
            if (this.a.startsWith(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS)) {
                String[] split = this.a.split(UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
                if (split != null && split.length == 2) {
                    this.b = UrlSchemaHelper.SCHEMA_TYPE_HTTP + split[1];
                }
            } else if (this.a.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA)) {
                String[] split2 = this.a.split(UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
                if (split2 != null && split2.length == 2) {
                    this.b = UrlSchemaHelper.SCHEMA_TYPE_HTTP + split2[1];
                }
            } else {
                this.b = this.a;
            }
        }
    }

    public void t(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, httpURLConnection) == null) && httpURLConnection != null && (map = this.d) != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
