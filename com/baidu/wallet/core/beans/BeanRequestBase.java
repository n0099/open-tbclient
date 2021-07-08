package com.baidu.wallet.core.beans;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
/* loaded from: classes5.dex */
public abstract class BeanRequestBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BeanRequestBase";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mBelongPaySdk;

    public BeanRequestBase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBelongPaySdk = false;
    }

    public abstract boolean checkRequestValidity();

    public abstract String getRequestId();

    @SuppressLint({"DefaultLocale"})
    public String getSinalParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                for (String str3 : str.split("&")) {
                    String[] split = str3.split("=");
                    if (split != null && !TextUtils.isEmpty(split[0]) && str2.equals(split[0].toUpperCase()) && split.length > 1) {
                        return URLDecoder.decode(split[1]);
                    }
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public void setBelongPaySdk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mBelongPaySdk = true;
        }
    }
}
