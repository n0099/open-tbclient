package com.bun.miitmdid.supplier.h;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.supplier.IdSupplier;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.supplier.h.a.d;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes9.dex */
public class a implements InnerIdSupplier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f64355a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64356b;

    public a(Context context) {
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
        this.f64356b = context;
        this.f64355a = "";
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, supplierListener) == null) {
            new Thread(new Runnable(this, supplierListener) { // from class: com.bun.miitmdid.supplier.h.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SupplierListener f64357a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f64358b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, supplierListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64358b = this;
                    this.f64357a = supplierListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    SupplierListener supplierListener2;
                    boolean isSupported;
                    IdSupplier idSupplier;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f64357a != null) {
                                if (Build.VERSION.SDK_INT < 28) {
                                    supplierListener2 = this.f64357a;
                                    isSupported = false;
                                    idSupplier = new com.bun.miitmdid.supplier.a();
                                } else {
                                    supplierListener2 = this.f64357a;
                                    isSupported = this.f64358b.isSupported();
                                    idSupplier = this.f64358b;
                                }
                                supplierListener2.OnSupport(isSupported, idSupplier);
                            }
                        } catch (Exception e2) {
                            com.bun.miitmdid.utils.a.a("vivosuplier", "exception", e2);
                        }
                    }
                }
            }).start();
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f64355a = str;
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String b2 = d.b(this.f64356b, this.f64355a);
            return TextUtils.isEmpty(b2) ? sysParamters.f() : b2;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String b2 = d.b(this.f64356b);
            return b2 == null ? "" : b2;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String a2 = d.a(this.f64356b, this.f64355a);
            return a2 == null ? "" : a2;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? d.a(this.f64356b) : invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }
}
