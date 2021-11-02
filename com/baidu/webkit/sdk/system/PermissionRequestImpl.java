package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
@TargetApi(21)
/* loaded from: classes11.dex */
public final class PermissionRequestImpl extends PermissionRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final android.webkit.PermissionRequest mRequest;

    public PermissionRequestImpl(android.webkit.PermissionRequest permissionRequest) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {permissionRequest};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequest = permissionRequest;
    }

    public static PermissionRequest from(android.webkit.PermissionRequest permissionRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, permissionRequest)) == null) {
            if (permissionRequest == null) {
                return null;
            }
            return new PermissionRequestImpl(permissionRequest);
        }
        return (PermissionRequest) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.PermissionRequest
    public final boolean defaultHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.PermissionRequest
    public final void deny() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mRequest.deny();
        }
    }

    @Override // com.baidu.webkit.sdk.PermissionRequest
    public final Uri getOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRequest.getOrigin() : (Uri) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.PermissionRequest
    public final String[] getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRequest.getResources() : (String[]) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.PermissionRequest
    public final void grant(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
            this.mRequest.grant(strArr);
        }
    }
}
