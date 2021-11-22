package com.bun.miitmdid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
/* loaded from: classes11.dex */
public class o extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f62106c;

    /* renamed from: d  reason: collision with root package name */
    public String f62107d;

    /* renamed from: e  reason: collision with root package name */
    public String f62108e;

    /* renamed from: f  reason: collision with root package name */
    public String f62109f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62110g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62111h;

    public o(Context context) {
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
        this.f62107d = "";
        this.f62108e = "";
        this.f62109f = "";
        this.f62110g = false;
        this.f62111h = false;
        this.f62106c = context;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62106c = a(this.f62106c);
            isSupported();
            isLimited();
            getOAID();
            getVAID();
            getAAID();
            a(this.f62107d, this.f62108e, this.f62109f, this.f62110g, this.f62111h);
        }
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                this.f62107d = AdvertisingIdClient.getAdvertisingIdInfo(this.f62106c).getId();
            } catch (IOException unused) {
                this.f62107d = "";
            }
            return this.f62107d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isLimited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                this.f62111h = AdvertisingIdClient.getAdvertisingIdInfo(this.f62106c).isLimitAdTrackingEnabled();
            } catch (Exception unused) {
                this.f62111h = false;
            }
            return this.f62111h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                this.f62107d = AdvertisingIdClient.getAdvertisingIdInfo(this.f62106c).getId();
            } catch (IOException unused) {
                this.f62110g = false;
            }
            boolean z = !TextUtils.isEmpty(getOAID());
            this.f62110g = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public boolean isSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
