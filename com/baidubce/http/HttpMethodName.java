package com.baidubce.http;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class HttpMethodName {
    public static final /* synthetic */ HttpMethodName[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final HttpMethodName DELETE;
    public static final HttpMethodName GET;
    public static final HttpMethodName HEAD;
    public static final HttpMethodName POST;
    public static final HttpMethodName PUT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1893481612, "Lcom/baidubce/http/HttpMethodName;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1893481612, "Lcom/baidubce/http/HttpMethodName;");
                return;
            }
        }
        GET = new HttpMethodName("GET", 0);
        POST = new HttpMethodName("POST", 1);
        PUT = new HttpMethodName(HttpPut.METHOD_NAME, 2);
        DELETE = new HttpMethodName(HttpDelete.METHOD_NAME, 3);
        HttpMethodName httpMethodName = new HttpMethodName("HEAD", 4);
        HEAD = httpMethodName;
        $VALUES = new HttpMethodName[]{GET, POST, PUT, DELETE, httpMethodName};
    }

    public HttpMethodName(String str, int i2) {
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

    public static HttpMethodName valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HttpMethodName) Enum.valueOf(HttpMethodName.class, str) : (HttpMethodName) invokeL.objValue;
    }

    public static HttpMethodName[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HttpMethodName[]) $VALUES.clone() : (HttpMethodName[]) invokeV.objValue;
    }
}
