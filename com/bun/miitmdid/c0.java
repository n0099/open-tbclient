package com.bun.miitmdid;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.lib.MsaIdInterface;
/* loaded from: classes4.dex */
public class c0 extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context j;
    public String k;
    public z l;

    /* loaded from: classes4.dex */
    public class a implements a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c0 a;

        public a(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c0Var;
        }

        @Override // com.bun.miitmdid.a0
        public void a(MsaIdInterface msaIdInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, msaIdInterface) == null) || this.a.d()) {
                return;
            }
            try {
                c0 c0Var = this.a;
                c0Var.f = c0Var.l.d();
                String b = this.a.l.b();
                String c = this.a.l.c();
                String a = this.a.l.a();
                if (b == null) {
                    b = "";
                }
                this.a.c = b;
                c0 c0Var2 = this.a;
                if (c == null) {
                    c = "";
                }
                c0Var2.d = c;
                c0 c0Var3 = this.a;
                if (a == null) {
                    a = "";
                }
                c0Var3.e = a;
                synchronized (c0.class) {
                    this.a.i = true;
                    this.a.e();
                }
            } catch (Exception e) {
                synchronized (c0.class) {
                    e0.d("ZteProvider", "doStart: Exception: " + e.getMessage());
                    this.a.a();
                    this.a.i = true;
                    this.a.e();
                }
            }
        }
    }

    public c0(Context context) {
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
        e0.c("ZteProvider", "ZteProvider(Context)");
        this.j = context;
        this.k = context.getPackageName();
        try {
        } catch (Exception unused) {
            e0.d("ZteProvider", "Constructor: MsaService not found");
        }
        if (context.getPackageManager().getPackageInfo("com.mdid.msa", 0) == null) {
            e0.d("ZteProvider", "Constructor: getPackageInfo is null");
            throw new NullPointerException("Constructor: getPackageInfo is null");
        }
        try {
            z.a(this.j, this.k);
            e0.c("ZteProvider", "Constructor: MsaService start success");
        } catch (Exception e) {
            e0.b("ZteProvider", "Constructor: MsaService start Exception: " + e.getMessage());
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e0.c("ZteProvider", "doStart()");
            try {
                this.j = a(this.j);
                c();
                z zVar = new z(this.j, new a(this));
                this.l = zVar;
                zVar.a(this.k);
                e0.c("ZteProvider", "doStart: BindService success");
                b();
            } catch (Exception e) {
                e0.d("ZteProvider", "doStart: Exception: " + e.getMessage());
                a();
                e();
            }
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        z zVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (zVar = this.l) == null) {
            return;
        }
        zVar.e();
    }
}
