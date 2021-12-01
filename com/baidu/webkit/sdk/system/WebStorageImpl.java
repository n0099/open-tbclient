package com.baidu.webkit.sdk.system;

import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebStorage;
import java.util.Map;
/* loaded from: classes12.dex */
public final class WebStorageImpl extends WebStorage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class QuotaUpdater implements WebStorage.QuotaUpdater {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebStorage.QuotaUpdater mImpl;

        public QuotaUpdater(WebStorage.QuotaUpdater quotaUpdater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quotaUpdater};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mImpl = quotaUpdater;
        }

        @Override // com.baidu.webkit.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.mImpl.updateQuota(j2);
            }
        }
    }

    public WebStorageImpl() {
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

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void deleteAllData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            android.webkit.WebStorage.getInstance().deleteAllData();
        }
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void deleteAllDataIncludeServiceWorker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void deleteOrigin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void getOrigins(ValueCallback<Map> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, valueCallback) == null) {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        }
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, valueCallback) == null) {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        }
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, valueCallback) == null) {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        }
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void setQuotaForOrigin(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048582, this, str, j2) == null) {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j2);
        }
    }
}
