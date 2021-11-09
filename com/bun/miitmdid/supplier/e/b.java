package com.bun.miitmdid.supplier.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes11.dex */
public class b implements InnerIdSupplier, com.bun.miitmdid.supplier.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f61184a;

    /* renamed from: b  reason: collision with root package name */
    public SupplierListener f61185b;

    public b(Context context, SupplierListener supplierListener) {
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
        this.f61185b = supplierListener;
        this.f61184a = new a(context, this);
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a() {
        SupplierListener supplierListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (supplierListener = this.f61185b) == null) {
            return;
        }
        supplierListener.OnSupport(isSupported(), this);
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, supplierListener) == null) {
        }
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a(boolean z) {
        SupplierListener supplierListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (supplierListener = this.f61185b) == null) {
            return;
        }
        supplierListener.OnSupport(isSupported(), this);
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        InterceptResult invokeV;
        String e2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (isSupported() && (e2 = this.f61184a.e()) != null) ? e2 : "" : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        String a2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (isSupported() && (a2 = this.f61184a.a()) != null) ? a2 : "" : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (isSupported() && (b2 = this.f61184a.b()) != null) ? b2 : "" : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        String d2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (isSupported() && (d2 = this.f61184a.d()) != null) ? d2 : "" : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            a aVar = this.f61184a;
            if (aVar != null) {
                return aVar.c();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f61184a) == null) {
            return;
        }
        aVar.f();
    }
}
