package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.c90;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class v90 extends s90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c90.d b;

    @Override // com.baidu.tieba.u90.b
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "https://httpsdns.baidu.com/v6/0025" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u90.b
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s90, com.baidu.tieba.u90.b
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "GET" : (String) invokeV.objValue;
    }

    public v90(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.a = context;
    }

    public void a(c90.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.b = dVar;
        }
    }

    @Override // com.baidu.tieba.u90.b
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Host", DnsTransmitter.IDC_HOST);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u90.b
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ("type=ipv4,ipv6&dn=" + h90.Z(this.a).D).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u90.d
    public void onFailure(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) {
            if (y90.a) {
                z90.b("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i + ",errormsg:" + str);
            }
            c90.g(3, this.a);
            c90.a(this.a).b(h90.Z(this.a).D, this.b);
        }
    }

    @Override // com.baidu.tieba.u90.d
    public void onSuccess(byte[] bArr) {
        int length;
        int length2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            String str = new String(bArr);
            if (y90.a) {
                z90.a("LCPHttpDnsUrlRequest", "onSuccess----ip of " + h90.Z(this.a).D + " is " + str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(h90.Z(this.a).D);
                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6");
                if (optJSONArray2 == null) {
                    length = 0;
                } else {
                    length = optJSONArray2.length();
                }
                if (optJSONArray == null) {
                    length2 = 0;
                } else {
                    length2 = optJSONArray.length();
                }
                if (length2 + length > 0) {
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && length2 > 0) {
                        arrayList.add(optJSONArray.getString(0));
                    }
                    if (optJSONArray2 != null && length > 0) {
                        arrayList.add(optJSONArray2.getString(0));
                    }
                    c90.h(arrayList, this.a);
                    if (this.b != null && c90.b.size() > 0) {
                        this.b.a(0, DnsModel.MSG_OK, c90.b.get(0));
                        if (c90.b.size() > 1) {
                            c90.c++;
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (y90.a) {
                    z90.b("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
                }
                c90.g(3, this.a);
                c90.a(this.a).b(h90.Z(this.a).D, this.b);
            } catch (Exception e) {
                if (y90.a) {
                    z90.b("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e.getMessage());
                }
                c90.g(3, this.a);
                c90.a(this.a).b(h90.Z(this.a).D, this.b);
            }
        }
    }
}
