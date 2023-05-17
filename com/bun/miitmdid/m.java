package com.bun.miitmdid;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes8.dex */
public abstract class m extends o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public volatile String f;
    @Keep
    public volatile String g;
    @Keep
    public volatile String h;
    @Keep
    public volatile boolean i;
    @Keep
    public volatile boolean j;
    @Keep
    public volatile long k;
    @Keep
    public volatile long l;
    @Keep
    public volatile boolean m;

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
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = false;
        this.j = false;
        this.l = 5000L;
    }

    @Keep
    public native void d();

    @Keep
    public native void e();

    @Keep
    public native void f();

    @Keep
    public native boolean g();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    @Keep
    public native String getAAID();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    @Keep
    public native String getOAID();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    @Keep
    public native String getVAID();

    @Keep
    public native void h();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    @Keep
    public native boolean isLimited();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    @Keep
    public native boolean isSupported();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native boolean isSync();
}
