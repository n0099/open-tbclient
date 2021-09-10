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
    public SupplierListener f63966a;

    /* renamed from: b  reason: collision with root package name */
    public String f63967b;

    /* renamed from: c  reason: collision with root package name */
    public String f63968c;

    /* renamed from: d  reason: collision with root package name */
    public String f63969d;

    /* renamed from: e  reason: collision with root package name */
    public String f63970e;

    /* renamed from: f  reason: collision with root package name */
    public SupplementaryDIDManager f63971f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63972g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63973h;

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
        this.f63967b = "";
        this.f63968c = "";
        this.f63969d = "";
        this.f63970e = "";
        this.f63972g = false;
        this.f63973h = false;
        this.f63966a = supplierListener;
        this.f63971f = new SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.a
    public void a() {
        SupplierListener supplierListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (supplierListener = this.f63966a) == null) {
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
                this.f63967b = b2;
                if (b2 == null) {
                    this.f63967b = "";
                }
            } catch (Exception unused) {
            }
            try {
                String c2 = aVar.c();
                this.f63968c = c2;
                if (c2 == null) {
                    this.f63968c = "";
                }
            } catch (Exception unused2) {
            }
            try {
                String d2 = aVar.d();
                this.f63969d = d2;
                if (d2 == null) {
                    this.f63969d = "";
                }
            } catch (Exception unused3) {
            }
            try {
                String e2 = aVar.e();
                this.f63970e = e2;
                if (e2 == null) {
                    this.f63970e = "";
                }
            } catch (Exception unused4) {
            }
            try {
                this.f63973h = aVar.a();
            } catch (Exception unused5) {
            }
            this.f63972g = true;
            SupplierListener supplierListener = this.f63966a;
            if (supplierListener != null) {
                supplierListener.OnSupport(this.f63973h, this);
            }
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, supplierListener) == null) {
            this.f63971f.init(this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f63970e : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f63968c : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f63967b : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f63969d : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f63973h : invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        SupplementaryDIDManager supplementaryDIDManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f63972g && (supplementaryDIDManager = this.f63971f) != null) {
            supplementaryDIDManager.deInit();
        }
    }
}
