package com.baidu.webkit.sdk.system;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes6.dex */
public final class CookieSyncManagerImpl extends CookieSyncManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CookieSyncManagerImpl() {
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

    @Override // com.baidu.webkit.sdk.CookieSyncManager
    public final void resetSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            android.webkit.CookieSyncManager.getInstance().resetSync();
        }
    }

    @Override // com.baidu.webkit.sdk.CookieSyncManager
    public final void startSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            android.webkit.CookieSyncManager.getInstance().startSync();
        }
    }

    @Override // com.baidu.webkit.sdk.CookieSyncManager
    public final void stopSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            android.webkit.CookieSyncManager.getInstance().stopSync();
        }
    }

    @Override // com.baidu.webkit.sdk.CookieSyncManager
    public final void sync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            android.webkit.CookieSyncManager.getInstance().sync();
        }
    }
}
