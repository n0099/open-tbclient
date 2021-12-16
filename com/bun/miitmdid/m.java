package com.bun.miitmdid;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class m extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public g f55002c;

    /* renamed from: d  reason: collision with root package name */
    public String f55003d;

    /* renamed from: e  reason: collision with root package name */
    public String f55004e;

    /* renamed from: f  reason: collision with root package name */
    public String f55005f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55006g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55007h;

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
        this.f55003d = "";
        this.f55004e = "";
        this.f55005f = "";
        this.f55006g = false;
        this.f55007h = false;
        this.f55002c = a();
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
            a(this.f55003d, this.f55004e, this.f55005f, this.f55006g, this.f55007h);
        }
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                this.f55005f = (String) this.f55002c.a().a();
            } catch (Exception e2) {
                e0.b("SyncProvider", "getAAID: Exception: " + e2.getMessage());
                this.f55005f = "";
            }
            return this.f55005f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                this.f55003d = (String) this.f55002c.b().a();
            } catch (Exception e2) {
                e0.b("SyncProvider", "getOAID: Exception: " + e2.getMessage());
                this.f55003d = "";
            }
            return this.f55003d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                this.f55004e = (String) this.f55002c.c().a();
            } catch (Exception e2) {
                e0.b("SyncProvider", "getVAID: Exception: " + e2.getMessage());
                this.f55004e = "";
            }
            return this.f55004e;
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
                d2 = this.f55002c.d();
                Class<?> b2 = d2.b();
                if (b2 == null) {
                    b2 = Boolean.class;
                }
                cast = b2.cast(d2.a());
            } catch (Exception unused) {
                this.f55007h = false;
            }
            if (cast != null) {
                if (cast instanceof String) {
                    booleanValue = ((String) cast).equals("0");
                } else if (cast instanceof Boolean) {
                    if (d2.c()) {
                        this.f55007h = !((Boolean) cast).booleanValue();
                        return this.f55007h;
                    }
                    booleanValue = ((Boolean) cast).booleanValue();
                }
                this.f55007h = booleanValue;
                return this.f55007h;
            }
            this.f55007h = false;
            return this.f55007h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                this.f55006g = ((Boolean) this.f55002c.e().a()).booleanValue();
            } catch (Exception e2) {
                e0.b("SyncProvider", "isSupported: Exception: " + e2.getMessage());
                this.f55006g = false;
            }
            return this.f55006g;
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
