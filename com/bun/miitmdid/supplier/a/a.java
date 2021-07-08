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
/* loaded from: classes5.dex */
public class a implements com.asus.msa.sdid.a, InnerIdSupplier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SupplierListener f27597a;

    /* renamed from: b  reason: collision with root package name */
    public String f27598b;

    /* renamed from: c  reason: collision with root package name */
    public String f27599c;

    /* renamed from: d  reason: collision with root package name */
    public String f27600d;

    /* renamed from: e  reason: collision with root package name */
    public String f27601e;

    /* renamed from: f  reason: collision with root package name */
    public SupplementaryDIDManager f27602f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27603g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27604h;

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
        this.f27598b = "";
        this.f27599c = "";
        this.f27600d = "";
        this.f27601e = "";
        this.f27603g = false;
        this.f27604h = false;
        this.f27597a = supplierListener;
        this.f27602f = new SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.a
    public void a() {
        SupplierListener supplierListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (supplierListener = this.f27597a) == null) {
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
                this.f27598b = b2;
                if (b2 == null) {
                    this.f27598b = "";
                }
            } catch (Exception unused) {
            }
            try {
                String c2 = aVar.c();
                this.f27599c = c2;
                if (c2 == null) {
                    this.f27599c = "";
                }
            } catch (Exception unused2) {
            }
            try {
                String d2 = aVar.d();
                this.f27600d = d2;
                if (d2 == null) {
                    this.f27600d = "";
                }
            } catch (Exception unused3) {
            }
            try {
                String e2 = aVar.e();
                this.f27601e = e2;
                if (e2 == null) {
                    this.f27601e = "";
                }
            } catch (Exception unused4) {
            }
            try {
                this.f27604h = aVar.a();
            } catch (Exception unused5) {
            }
            this.f27603g = true;
            SupplierListener supplierListener = this.f27597a;
            if (supplierListener != null) {
                supplierListener.OnSupport(this.f27604h, this);
            }
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, supplierListener) == null) {
            this.f27602f.init(this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27601e : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27599c : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f27598b : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27600d : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f27604h : invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        SupplementaryDIDManager supplementaryDIDManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f27603g && (supplementaryDIDManager = this.f27602f) != null) {
            supplementaryDIDManager.deInit();
        }
    }
}
