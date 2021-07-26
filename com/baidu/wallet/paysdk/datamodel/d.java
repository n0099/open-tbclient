package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class d extends BeanRequestBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f26216a;

    /* renamed from: b  reason: collision with root package name */
    public String f26217b;

    /* renamed from: c  reason: collision with root package name */
    public String f26218c;

    /* renamed from: d  reason: collision with root package name */
    public String f26219d;

    public d(String str, String str2, String str3, String str4) {
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
        this.f26216a = str;
        this.f26217b = str2;
        this.f26218c = str3;
        this.f26219d = str4;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f26216a) || TextUtils.isEmpty(this.f26217b) || TextUtils.isEmpty(this.f26218c) || TextUtils.isEmpty(this.f26219d)) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? BeanConstants.REQUEST_ID_VERIFY_CODE : (String) invokeV.objValue;
    }
}
