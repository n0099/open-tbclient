package com.bun.miitmdid;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class m extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public boolean h;

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = false;
        this.h = false;
        this.c = a();
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
            a(this.d, this.e, this.f, this.g, this.h);
        }
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                this.f = (String) this.c.a().a();
            } catch (Exception e) {
                e0.b("SyncProvider", "getAAID: Exception: " + e.getMessage());
                this.f = "";
            }
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                this.d = (String) this.c.b().a();
            } catch (Exception e) {
                e0.b("SyncProvider", "getOAID: Exception: " + e.getMessage());
                this.d = "";
            }
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                this.e = (String) this.c.c().a();
            } catch (Exception e) {
                e0.b("SyncProvider", "getVAID: Exception: " + e.getMessage());
                this.e = "";
            }
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isLimited() {
        InterceptResult invokeV;
        h d;
        Object cast;
        boolean booleanValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                d = this.c.d();
                Class<?> b = d.b();
                if (b == null) {
                    b = Boolean.class;
                }
                cast = b.cast(d.a());
            } catch (Exception unused) {
                this.h = false;
            }
            if (cast != null) {
                if (cast instanceof String) {
                    booleanValue = ((String) cast).equals("0");
                } else if (cast instanceof Boolean) {
                    if (d.c()) {
                        this.h = !((Boolean) cast).booleanValue();
                        return this.h;
                    }
                    booleanValue = ((Boolean) cast).booleanValue();
                }
                this.h = booleanValue;
                return this.h;
            }
            this.h = false;
            return this.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                this.g = ((Boolean) this.c.e().a()).booleanValue();
            } catch (Exception e) {
                e0.b("SyncProvider", "isSupported: Exception: " + e.getMessage());
                this.g = false;
            }
            return this.g;
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
