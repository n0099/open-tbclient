package com.bun.miitmdid;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes8.dex */
public abstract class n extends o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public g f;
    @Keep
    public String g;
    @Keep
    public String h;
    @Keep
    public String i;
    @Keep
    public boolean j;
    @Keep
    public boolean k;

    public n() {
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
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = false;
        this.k = false;
        this.f = d();
    }

    public abstract g d();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void doStart();

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

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native boolean isSync();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void shutDown();
}
