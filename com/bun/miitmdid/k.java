package com.bun.miitmdid;

import android.content.Context;
import com.android.msasdk.FreemeIds;
import com.android.msasdk.FreemeIdsSupplier;
import com.android.msasdk.IConnect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k extends l implements IConnect {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context j;
    public String k;
    public FreemeIdsSupplier l;

    public k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = context;
    }

    @Override // com.android.msasdk.IConnect
    public void connectSuccess(boolean z) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || d()) {
            return;
        }
        try {
            try {
                if (z) {
                    this.f = this.l.isSupported();
                    String str3 = null;
                    if (this.f) {
                        String aaid = this.l.getAAID(this.k);
                        String oaid = this.l.getOAID();
                        str2 = this.l.getVAID(this.k);
                        str3 = oaid;
                        str = aaid;
                    } else {
                        str = null;
                        str2 = null;
                    }
                    if (str3 == null) {
                        str3 = "";
                    }
                    this.c = str3;
                    if (str2 == null) {
                        str2 = "";
                    }
                    this.d = str2;
                    if (str == null) {
                        str = "";
                    }
                    this.e = str;
                } else {
                    e0.b("FreemeProvider", "connectSuccess: false");
                    a();
                }
            } catch (Exception e) {
                e0.b("FreemeProvider", "connectSuccess: Exception: " + e.getMessage());
                a();
            }
            shutDown();
            a(this.c, this.d, this.e, this.f, this.g);
        } catch (Throwable th) {
            shutDown();
            a(this.c, this.d, this.e, this.f, this.g);
            throw th;
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Context a = a(this.j);
            this.j = a;
            this.k = a.getPackageName();
            this.l = new FreemeIds(this.j);
            try {
                c();
                this.l.connect(this);
                b();
            } catch (Exception e) {
                e0.b("FreemeProvider", "doStart: Exception: " + e.getMessage());
                a();
                a(this.c, this.d, this.e, this.f, this.g);
            }
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        FreemeIdsSupplier freemeIdsSupplier;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (freemeIdsSupplier = this.l) == null) {
            return;
        }
        freemeIdsSupplier.shutDown();
    }
}
