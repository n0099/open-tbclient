package com.baidu.webkit.sdk.system;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.MimeTypeMap;
/* loaded from: classes9.dex */
public final class MimeTypeMapImpl extends MimeTypeMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MimeTypeMapImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.webkit.sdk.MimeTypeMap
    public final String getExtensionFromMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.MimeTypeMap
    public final String getFileExtensionFromUrlImpl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? android.webkit.MimeTypeMap.getFileExtensionFromUrl(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.MimeTypeMap
    public final String getMimeTypeFromExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.MimeTypeMap
    public final boolean hasExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? android.webkit.MimeTypeMap.getSingleton().hasExtension(str) : invokeL.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.MimeTypeMap
    public final boolean hasMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? android.webkit.MimeTypeMap.getSingleton().hasMimeType(str) : invokeL.booleanValue;
    }
}
