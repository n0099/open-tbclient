package com.bun.miitmdid.pojo;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.interfaces.IdSupplier;
@Keep
/* loaded from: classes9.dex */
public class IdSupplierImpl implements IdSupplier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public final String AAID;
    @Keep
    public final String OAID;
    @Keep
    public final String VAID;
    @Keep
    public final boolean isLimited;
    @Keep
    public final boolean isSupported;

    public IdSupplierImpl() {
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
        this.OAID = "";
        this.VAID = "";
        this.AAID = "";
        this.isSupported = false;
        this.isLimited = false;
    }

    public IdSupplierImpl(String str, String str2, String str3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.OAID = str;
        this.VAID = str2;
        this.AAID = str3;
        this.isSupported = z;
        this.isLimited = z2;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    @Keep
    public native String getAAID();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    @Keep
    public native String getOAID();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    @Keep
    public native String getVAID();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    @Keep
    public native boolean isLimited();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    @Keep
    public native boolean isSupported();
}
