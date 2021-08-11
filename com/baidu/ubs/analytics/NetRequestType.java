package com.baidu.ubs.analytics;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class NetRequestType {
    public static final /* synthetic */ NetRequestType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NetRequestType CONNECT;
    public static final NetRequestType DELETE;
    public static final NetRequestType GET;
    public static final NetRequestType HEAD;
    public static final NetRequestType OPTIONS;
    public static final NetRequestType POST;
    public static final NetRequestType PUT;
    public static final NetRequestType TRACE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1036337425, "Lcom/baidu/ubs/analytics/NetRequestType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1036337425, "Lcom/baidu/ubs/analytics/NetRequestType;");
                return;
            }
        }
        GET = new NetRequestType("GET", 0);
        POST = new NetRequestType("POST", 1);
        PUT = new NetRequestType(HttpPut.METHOD_NAME, 2);
        DELETE = new NetRequestType(HttpDelete.METHOD_NAME, 3);
        HEAD = new NetRequestType("HEAD", 4);
        OPTIONS = new NetRequestType(HttpOptions.METHOD_NAME, 5);
        TRACE = new NetRequestType(HttpTrace.METHOD_NAME, 6);
        NetRequestType netRequestType = new NetRequestType("CONNECT", 7);
        CONNECT = netRequestType;
        $VALUES = new NetRequestType[]{GET, POST, PUT, DELETE, HEAD, OPTIONS, TRACE, netRequestType};
    }

    public NetRequestType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static NetRequestType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetRequestType) Enum.valueOf(NetRequestType.class, str) : (NetRequestType) invokeL.objValue;
    }

    public static NetRequestType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetRequestType[]) $VALUES.clone() : (NetRequestType[]) invokeV.objValue;
    }
}
