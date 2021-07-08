package com.baidu.webkit.sdk.system;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebViewDatabase;
/* loaded from: classes5.dex */
public final class WebViewDatabaseImpl extends WebViewDatabase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public WebViewDatabaseImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final void clearFormData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            android.webkit.WebViewDatabase.getInstance(this.mContext).clearFormData();
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final void clearHttpAuthUsernamePassword() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            android.webkit.WebViewDatabase.getInstance(this.mContext).clearHttpAuthUsernamePassword();
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final void clearUsernamePassword() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            android.webkit.WebViewDatabase.getInstance(this.mContext).clearUsernamePassword();
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final String[] getHttpAuthUsernamePassword(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return android.webkit.WebViewDatabase.getInstance(this.mContext).getHttpAuthUsernamePassword(str, str2);
            }
            return null;
        }
        return (String[]) invokeLL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final boolean hasFormData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? android.webkit.WebViewDatabase.getInstance(this.mContext).hasFormData() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final boolean hasHttpAuthUsernamePassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? android.webkit.WebViewDatabase.getInstance(this.mContext).hasHttpAuthUsernamePassword() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final boolean hasUsernamePassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? android.webkit.WebViewDatabase.getInstance(this.mContext).hasUsernamePassword() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, str4) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        android.webkit.WebViewDatabase.getInstance(this.mContext).setHttpAuthUsernamePassword(str, str2, str3, str4);
    }
}
