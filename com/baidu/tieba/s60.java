package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.Callback;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.support.cookie.CookieJarImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class s60 implements Call {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t60 a;
    public final Request b;
    public final boolean c;
    public boolean d;
    public m60 e;

    /* loaded from: classes7.dex */
    public final class a extends p60 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Callback b;
        public final /* synthetic */ s60 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s60 s60Var, Callback callback) {
            super("BaiduNetwork %s", s60Var.d());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s60Var, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s60Var;
            this.b = callback;
        }

        @Override // com.baidu.tieba.p60
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        this.b.onResponse(this.c, this.c.b());
                    } catch (IOException e) {
                        this.b.onFailure(this.c, e);
                    }
                } finally {
                    this.c.a.p().d(this);
                }
            }
        }

        public s60 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c;
            }
            return (s60) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c.b.url().host();
            }
            return (String) invokeV.objValue;
        }
    }

    public s60(Request request, t60 t60Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {request, t60Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = request;
        this.c = z;
        this.a = t60Var;
        z60 z60Var = t60Var.m;
        this.e = new m60(t60Var);
    }

    public static s60 c(Request request, t60 t60Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, request, t60Var, z)) == null) {
            return new s60(request, t60Var, z);
        }
        return (s60) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.outback.core.Call
    /* renamed from: a */
    public s60 m138clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return c(this.b, this.a, this.c);
        }
        return (s60) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.b();
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b.url().redact();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e.d();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public synchronized boolean isExecuted() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                z = this.d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (Request) invokeV.objValue;
    }

    public Response b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a.t());
            arrayList.add(new c70(new CookieJarImpl(this.b.getCookieManager()), this.a));
            arrayList.add(this.e);
            arrayList.addAll(this.a.w());
            arrayList.add(new d70());
            return new e70(arrayList, null, 0, this.b, this).a(this.b);
        }
        return (Response) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public void enqueue(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, callback) == null) {
            synchronized (this) {
                if (!this.d) {
                    this.d = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            this.a.p().a(new a(this, callback));
        }
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public Response execute() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (!this.d) {
                    this.d = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            try {
                try {
                    this.a.p().b(this);
                    Response b = b();
                    if (b != null) {
                        return b;
                    }
                    throw new IOException("Canceled");
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    if (TextUtils.isEmpty(e2.getMessage())) {
                        throw new IOException("unknown exception", e2);
                    }
                    throw new IOException(e2);
                }
            } finally {
                this.a.p().e(this);
            }
        }
        return (Response) invokeV.objValue;
    }
}
