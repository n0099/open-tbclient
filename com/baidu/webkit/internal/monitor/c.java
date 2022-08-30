package com.baidu.webkit.internal.monitor;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes6.dex */
public final class c implements com.baidu.webkit.logsdk.b {
    public static /* synthetic */ Interceptable $ic;
    public static String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1238909600, "Lcom/baidu/webkit/internal/monitor/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1238909600, "Lcom/baidu/webkit/internal/monitor/c;");
                return;
            }
        }
        String[] strArr = {StringUtil.NULL_STRING, StringUtil.NULL_STRING, StringUtil.NULL_STRING, StringUtil.NULL_STRING};
        a = strArr;
        strArr[0] = new String(Base64.decode(new byte[]{77, 106, 104, 71, 77, 122, 108, 70, 79, 84, 74, 67, 79, 84, 107, 53, 79, 69, 69, 120, 81, 84, 66, 71, 78, 68, 77, 50, 77, 106, 89, 119, 78, 84, 65, 48, 77, 84, 89, 121, 79, 68, 103, Base64.INTERNAL_PADDING}));
        a[1] = new String(Base64.decode(new byte[]{78, 106, 85, 52, 82, 68, 103, 49, 77, 69, 85, 120, 77, 68, 107, 122, 78, 48, 86, 68, 81, 122, 103, 120, 77, 122, 99, 119, 77, 122, 89, 48, 78, 85, 89, 122, 77, 106, 81, 51, 77, 68, 82, 70, 79, 81, Base64.INTERNAL_PADDING, Base64.INTERNAL_PADDING}));
        a[2] = new String(Base64.decode(new byte[]{79, 68, 77, 120, 89, 50, 78, 104, 90, 71, 69, 120, 90, 87, 89, 52, 79, 71, 77, 119, 78, 84, 108, 108, 78, 122, 70, 108, 78, 109, 73, 52, 77, 87, 69, 122, 89, 122, 69, 122, 77, 106, 89, 53, 77, 71, 89, 51, 79, 71, 69, 52, 89, 81, Base64.INTERNAL_PADDING, Base64.INTERNAL_PADDING}));
        a[3] = new String(Base64.decode(new byte[]{89, 122, 103, 122, 90, 84, 81, 122, 79, 87, 77, 48, 90, 71, 89, 51, 77, 71, 82, 105, 90, 87, 78, 104, 77, 50, 85, 53, 77, 50, 69, 51, 90, 87, 89, 122, 90, 84, 81, 52, 77, 50, 85, Base64.INTERNAL_PADDING}));
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "https://browserkernel.baidu.com/logstat/stat/log" : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 0) {
                String[] strArr = a;
                return i < strArr.length ? strArr[i] : "";
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? str : (String) invokeL.objValue;
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "https://browserkernel.baidu.com/log/config.json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? FileUtils.SEARCHBOX_FOLDER : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? FileUtils.SEARCHBOX_FOLDER : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.logsdk.b
    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return new String(Base64.encode(WebKitFactory.getCUIDString().getBytes(), false));
            } catch (Throwable unused) {
                return WebKitFactory.getCUIDString();
            }
        }
        return (String) invokeV.objValue;
    }
}
