package com.bun.miitmdid;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public abstract class m extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public g f62096c;

    /* renamed from: d  reason: collision with root package name */
    public String f62097d;

    /* renamed from: e  reason: collision with root package name */
    public String f62098e;

    /* renamed from: f  reason: collision with root package name */
    public String f62099f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62100g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62101h;

    public m() {
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
        this.f62097d = "";
        this.f62098e = "";
        this.f62099f = "";
        this.f62100g = false;
        this.f62101h = false;
        this.f62096c = a();
    }

    public abstract g a();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            isSupported();
            isLimited();
            getOAID();
            getVAID();
            getAAID();
            a(this.f62097d, this.f62098e, this.f62099f, this.f62100g, this.f62101h);
        }
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                this.f62099f = (String) this.f62096c.a().a();
            } catch (Exception e2) {
                e0.b("SyncProvider", "getAAID: Exception: " + e2.getMessage());
                this.f62099f = "";
            }
            return this.f62099f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                this.f62097d = (String) this.f62096c.b().a();
            } catch (Exception e2) {
                e0.b("SyncProvider", "getOAID: Exception: " + e2.getMessage());
                this.f62097d = "";
            }
            return this.f62097d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                this.f62098e = (String) this.f62096c.c().a();
            } catch (Exception e2) {
                e0.b("SyncProvider", "getVAID: Exception: " + e2.getMessage());
                this.f62098e = "";
            }
            return this.f62098e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isLimited() {
        InterceptResult invokeV;
        h d2;
        Object cast;
        boolean booleanValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                d2 = this.f62096c.d();
                Class<?> b2 = d2.b();
                if (b2 == null) {
                    b2 = Boolean.class;
                }
                cast = b2.cast(d2.a());
            } catch (Exception unused) {
                this.f62101h = false;
            }
            if (cast != null) {
                if (cast instanceof String) {
                    booleanValue = ((String) cast).equals("0");
                } else if (cast instanceof Boolean) {
                    if (d2.c()) {
                        this.f62101h = !((Boolean) cast).booleanValue();
                        return this.f62101h;
                    }
                    booleanValue = ((Boolean) cast).booleanValue();
                }
                this.f62101h = booleanValue;
                return this.f62101h;
            }
            this.f62101h = false;
            return this.f62101h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                this.f62100g = ((Boolean) this.f62096c.e().a()).booleanValue();
            } catch (Exception e2) {
                e0.b("SyncProvider", "isSupported: Exception: " + e2.getMessage());
                this.f62100g = false;
            }
            return this.f62100g;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public boolean isSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }
}
