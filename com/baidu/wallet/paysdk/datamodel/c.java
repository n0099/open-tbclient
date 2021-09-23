package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
/* loaded from: classes8.dex */
public class c extends BeanRequestBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f62760a;

    /* renamed from: b  reason: collision with root package name */
    public String f62761b;

    /* renamed from: c  reason: collision with root package name */
    public String f62762c;

    /* renamed from: d  reason: collision with root package name */
    public String f62763d;

    public c(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62760a = str;
        this.f62761b = str2;
        this.f62762c = str3;
        this.f62763d = str4;
    }

    @Override // com.dxmpay.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f62760a) || TextUtils.isEmpty(this.f62761b) || TextUtils.isEmpty(this.f62762c) || TextUtils.isEmpty(this.f62763d)) ? false : true : invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? BeanConstants.REQUEST_ID_VERIFY_CODE : (String) invokeV.objValue;
    }
}
