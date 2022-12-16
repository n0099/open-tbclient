package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.tieba.j22;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class k22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends j22.b {
        public static /* synthetic */ Interceptable $ic;
        public static final boolean b;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.j22.b
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "101 Switching Protocols" : (String) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-711225695, "Lcom/baidu/tieba/k22$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-711225695, "Lcom/baidu/tieba/k22$a;");
                    return;
                }
            }
            b = ok1.a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j22.a aVar) {
            super(aVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((j22.a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.j22.b
        public Map<String, String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Upgrade", "websocket");
                hashMap.put(HTTP.CONN_DIRECTIVE, "Upgrade");
                try {
                    hashMap.put("Sec-WebSocket-Accept", l22.g(this.a.a.get("sec-websocket-key")));
                } catch (NoSuchAlgorithmException e) {
                    if (b) {
                        Log.e("HandShakeResponse", "make accept key fail for error invalid algorithm", e);
                    }
                }
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends j22.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;

        @Override // com.baidu.tieba.j22.b
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "200 OK" : (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j22.a aVar) {
            super(aVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((j22.a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.j22.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.b == null) {
                    this.b = new g22().toString();
                }
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j22.b
        public Map<String, String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json; charset=UTF-8");
                hashMap.put(Util.ACCEPT_RANGES, "bytes");
                hashMap.put(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }
    }

    public static j22.b a(j22.a aVar) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            if (aVar != null && (map = aVar.a) != null && map.size() >= 1) {
                if (l22.f(aVar.a)) {
                    aVar.e = true;
                    return new a(aVar);
                }
                aVar.e = false;
                return new b(aVar);
            }
            return null;
        }
        return (j22.b) invokeL.objValue;
    }
}
