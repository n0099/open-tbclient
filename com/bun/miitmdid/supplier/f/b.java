package com.bun.miitmdid.supplier.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes6.dex */
public class b implements InnerIdSupplier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27523a;

    public b(Context context) {
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
        this.f27523a = context;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, supplierListener) == null) {
            new Thread(new Runnable(this, supplierListener) { // from class: com.bun.miitmdid.supplier.f.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SupplierListener f27524a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f27525b;

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
                    this.f27525b = this;
                    this.f27524a = supplierListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f27524a != null) {
                                this.f27524a.OnSupport(this.f27525b.isSupported(), this.f27525b);
                            }
                        } catch (Exception e2) {
                            com.bun.miitmdid.utils.a.a("buniasuplier", "exception", e2);
                        }
                    }
                }
            }).start();
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return a.a(this.f27523a, sysParamters.g());
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return a.b(this.f27523a);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                return a.b(this.f27523a, sysParamters.g());
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return a.a(this.f27523a);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
