package com.baidu.webkit.sdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MimeTypeMap {
    public static /* synthetic */ Interceptable $ic;
    public static final MimeTypeMap sMimeTypeMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1407706751, "Lcom/baidu/webkit/sdk/MimeTypeMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1407706751, "Lcom/baidu/webkit/sdk/MimeTypeMap;");
                return;
            }
        }
        sMimeTypeMap = new MimeTypeMap();
    }

    public MimeTypeMap() {
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

    public static String getFileExtensionFromUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? WebViewFactory.getProvider().getMimeTypeMap().getFileExtensionFromUrlImpl(str) : (String) invokeL.objValue;
    }

    public static MimeTypeMap getSingleton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sMimeTypeMap : (MimeTypeMap) invokeV.objValue;
    }

    public String getExtensionFromMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? WebViewFactory.getProvider().getMimeTypeMap().getExtensionFromMimeType(str) : (String) invokeL.objValue;
    }

    public String getFileExtensionFromUrlImpl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? "" : (String) invokeL.objValue;
    }

    public String getMimeTypeFromExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? WebViewFactory.getProvider().getMimeTypeMap().getMimeTypeFromExtension(str) : (String) invokeL.objValue;
    }

    public boolean hasExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? WebViewFactory.getProvider().getMimeTypeMap().hasExtension(str) : invokeL.booleanValue;
    }

    public boolean hasMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? WebViewFactory.getProvider().getMimeTypeMap().hasMimeType(str) : invokeL.booleanValue;
    }
}
