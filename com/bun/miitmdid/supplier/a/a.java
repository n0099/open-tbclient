package com.bun.miitmdid.supplier.a;

import android.content.Context;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes9.dex */
public class a implements com.asus.msa.sdid.a, InnerIdSupplier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SupplierListener f63786a;

    /* renamed from: b  reason: collision with root package name */
    public String f63787b;

    /* renamed from: c  reason: collision with root package name */
    public String f63788c;

    /* renamed from: d  reason: collision with root package name */
    public String f63789d;

    /* renamed from: e  reason: collision with root package name */
    public String f63790e;

    /* renamed from: f  reason: collision with root package name */
    public SupplementaryDIDManager f63791f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63792g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63793h;

    public a(Context context, SupplierListener supplierListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, supplierListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63787b = "";
        this.f63788c = "";
        this.f63789d = "";
        this.f63790e = "";
        this.f63792g = false;
        this.f63793h = false;
        this.f63786a = supplierListener;
        this.f63791f = new SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.a
    public void a() {
        SupplierListener supplierListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (supplierListener = this.f63786a) == null) {
            return;
        }
        supplierListener.OnSupport(false, this);
    }

    @Override // com.asus.msa.sdid.a
    public void a(com.asus.msa.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            try {
                String b2 = aVar.b();
                this.f63787b = b2;
                if (b2 == null) {
                    this.f63787b = "";
                }
            } catch (Exception unused) {
            }
            try {
                String c2 = aVar.c();
                this.f63788c = c2;
                if (c2 == null) {
                    this.f63788c = "";
                }
            } catch (Exception unused2) {
            }
            try {
                String d2 = aVar.d();
                this.f63789d = d2;
                if (d2 == null) {
                    this.f63789d = "";
                }
            } catch (Exception unused3) {
            }
            try {
                String e2 = aVar.e();
                this.f63790e = e2;
                if (e2 == null) {
                    this.f63790e = "";
                }
            } catch (Exception unused4) {
            }
            try {
                this.f63793h = aVar.a();
            } catch (Exception unused5) {
            }
            this.f63792g = true;
            SupplierListener supplierListener = this.f63786a;
            if (supplierListener != null) {
                supplierListener.OnSupport(this.f63793h, this);
            }
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, supplierListener) == null) {
            this.f63791f.init(this);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (IBinder) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f63790e : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f63788c : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f63787b : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f63789d : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f63793h : invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        SupplementaryDIDManager supplementaryDIDManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f63792g && (supplementaryDIDManager = this.f63791f) != null) {
            supplementaryDIDManager.deInit();
        }
    }
}
