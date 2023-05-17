package com.bun.miitmdid;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.lib.MsaIdInterface;
@Keep
/* loaded from: classes8.dex */
public class d0 extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public Context n;
    @Keep
    public String o;
    @Keep
    public a0 p;

    @Keep
    /* loaded from: classes8.dex */
    public class a implements b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Keep
        public final /* synthetic */ d0 a;

        public a(d0 d0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d0Var;
        }

        @Override // com.bun.miitmdid.b0
        @Keep
        public native void a(MsaIdInterface msaIdInterface);
    }

    public d0(Context context) {
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
        f0.c("ZteProvider", "ZteProvider(Context)");
        this.n = context;
        this.o = context.getPackageName();
        try {
        } catch (Exception unused) {
            f0.d("ZteProvider", "Constructor: MsaService not found");
        }
        if (context.getPackageManager().getPackageInfo("com.mdid.msa", 0) == null) {
            f0.d("ZteProvider", "Constructor: getPackageInfo is null");
            throw new NullPointerException("Constructor: getPackageInfo is null");
        }
        try {
            a0.a(this.n, this.o);
            f0.c("ZteProvider", "Constructor: MsaService start success");
        } catch (Exception e) {
            f0.b("ZteProvider", "Constructor: MsaService start Exception: " + e.getMessage());
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void doStart();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void shutDown();
}
