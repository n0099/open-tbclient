package com.bun.miitmdid;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.lib.MsaIdInterface;
/* loaded from: classes7.dex */
public class c0 extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public Context f51514j;
    public String k;
    public z l;

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                c0Var.f51541f = c0Var.l.d();
                String b2 = this.a.l.b();
                String c2 = this.a.l.c();
                String a = this.a.l.a();
                if (b2 == null) {
                    b2 = "";
                }
                this.a.f51538c = b2;
                c0 c0Var2 = this.a;
                if (c2 == null) {
                    c2 = "";
                }
                c0Var2.f51539d = c2;
                c0 c0Var3 = this.a;
                if (a == null) {
                    a = "";
                }
                c0Var3.f51540e = a;
                synchronized (c0.class) {
                    this.a.f51544i = true;
                    this.a.e();
                }
            } catch (Exception e2) {
                synchronized (c0.class) {
                    e0.d("ZteProvider", "doStart: Exception: " + e2.getMessage());
                    this.a.a();
                    this.a.f51544i = true;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e0.c("ZteProvider", "ZteProvider(Context)");
        this.f51514j = context;
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
            z.a(this.f51514j, this.k);
            e0.c("ZteProvider", "Constructor: MsaService start success");
        } catch (Exception e2) {
            e0.b("ZteProvider", "Constructor: MsaService start Exception: " + e2.getMessage());
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e0.c("ZteProvider", "doStart()");
            try {
                this.f51514j = a(this.f51514j);
                c();
                z zVar = new z(this.f51514j, new a(this));
                this.l = zVar;
                zVar.a(this.k);
                e0.c("ZteProvider", "doStart: BindService success");
                b();
            } catch (Exception e2) {
                e0.d("ZteProvider", "doStart: Exception: " + e2.getMessage());
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
