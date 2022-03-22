package com.bun.miitmdid;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class m extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public g f37989c;

    /* renamed from: d  reason: collision with root package name */
    public String f37990d;

    /* renamed from: e  reason: collision with root package name */
    public String f37991e;

    /* renamed from: f  reason: collision with root package name */
    public String f37992f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37993g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37994h;

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
        this.f37990d = "";
        this.f37991e = "";
        this.f37992f = "";
        this.f37993g = false;
        this.f37994h = false;
        this.f37989c = a();
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
            a(this.f37990d, this.f37991e, this.f37992f, this.f37993g, this.f37994h);
        }
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                this.f37992f = (String) this.f37989c.a().a();
            } catch (Exception e2) {
                e0.b("SyncProvider", "getAAID: Exception: " + e2.getMessage());
                this.f37992f = "";
            }
            return this.f37992f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                this.f37990d = (String) this.f37989c.b().a();
            } catch (Exception e2) {
                e0.b("SyncProvider", "getOAID: Exception: " + e2.getMessage());
                this.f37990d = "";
            }
            return this.f37990d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                this.f37991e = (String) this.f37989c.c().a();
            } catch (Exception e2) {
                e0.b("SyncProvider", "getVAID: Exception: " + e2.getMessage());
                this.f37991e = "";
            }
            return this.f37991e;
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
                d2 = this.f37989c.d();
                Class<?> b2 = d2.b();
                if (b2 == null) {
                    b2 = Boolean.class;
                }
                cast = b2.cast(d2.a());
            } catch (Exception unused) {
                this.f37994h = false;
            }
            if (cast != null) {
                if (cast instanceof String) {
                    booleanValue = ((String) cast).equals("0");
                } else if (cast instanceof Boolean) {
                    if (d2.c()) {
                        this.f37994h = !((Boolean) cast).booleanValue();
                        return this.f37994h;
                    }
                    booleanValue = ((Boolean) cast).booleanValue();
                }
                this.f37994h = booleanValue;
                return this.f37994h;
            }
            this.f37994h = false;
            return this.f37994h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                this.f37993g = ((Boolean) this.f37989c.e().a()).booleanValue();
            } catch (Exception e2) {
                e0.b("SyncProvider", "isSupported: Exception: " + e2.getMessage());
                this.f37993g = false;
            }
            return this.f37993g;
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
