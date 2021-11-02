package com.baidu.webkit.sdk.system;

import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.GeolocationPermissions;
import java.util.Set;
/* loaded from: classes11.dex */
public final class GeolocationPermissionsImpl extends GeolocationPermissions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class CallbackWrapper implements GeolocationPermissions.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final GeolocationPermissions.Callback mCallback;

        public CallbackWrapper(GeolocationPermissions.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallback = callback;
        }

        @Override // com.baidu.webkit.sdk.GeolocationPermissions.Callback
        public void invoke(String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.mCallback.invoke(str, z, z2);
            }
        }
    }

    public GeolocationPermissionsImpl() {
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

    @Override // com.baidu.webkit.sdk.GeolocationPermissions
    public final void allow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        }
    }

    @Override // com.baidu.webkit.sdk.GeolocationPermissions
    public final void clear(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        }
    }

    @Override // com.baidu.webkit.sdk.GeolocationPermissions
    public final void clearAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        }
    }

    @Override // com.baidu.webkit.sdk.GeolocationPermissions
    public final void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, valueCallback) == null) {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        }
    }

    @Override // com.baidu.webkit.sdk.GeolocationPermissions
    public final void getOrigins(ValueCallback<Set<String>> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, valueCallback) == null) {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        }
    }
}
