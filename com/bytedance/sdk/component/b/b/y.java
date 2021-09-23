package com.bytedance.sdk.component.b.b;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class y implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f65312a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.c.j f65313b;

    /* renamed from: c  reason: collision with root package name */
    public final z f65314c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f65315d;

    /* renamed from: e  reason: collision with root package name */
    public p f65316e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65317f;

    /* loaded from: classes9.dex */
    public final class a extends com.bytedance.sdk.component.b.b.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f65318a;

        /* renamed from: c  reason: collision with root package name */
        public final f f65319c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y yVar, f fVar) {
            super("OkHttp %s", yVar.g());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65318a = yVar;
            this.f65319c = fVar;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65318a.f65314c.a().g() : (String) invokeV.objValue;
        }

        public y b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65318a : (y) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.b.a.b
        public void c() {
            IOException e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = true;
                try {
                    try {
                        ab h2 = this.f65318a.h();
                        try {
                            if (this.f65318a.f65313b.b()) {
                                this.f65319c.onFailure(this.f65318a, new IOException(ResponseException.CANCELED));
                            } else {
                                this.f65319c.onResponse(this.f65318a, h2);
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            if (!z) {
                                this.f65318a.f65316e.a(this.f65318a, e2);
                                this.f65319c.onFailure(this.f65318a, e2);
                            } else {
                                com.bytedance.sdk.component.b.b.a.g.e b2 = com.bytedance.sdk.component.b.b.a.g.e.b();
                                b2.a(4, "Callback failure for " + this.f65318a.f(), e2);
                            }
                        }
                    } finally {
                        this.f65318a.f65312a.s().b(this);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    z = false;
                }
            }
        }
    }

    public y(w wVar, z zVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, zVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65312a = wVar;
        this.f65314c = zVar;
        this.f65315d = z;
        this.f65313b = new com.bytedance.sdk.component.b.b.a.c.j(wVar, z);
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f65313b.a(com.bytedance.sdk.component.b.b.a.g.e.b().a("response.body().close()"));
        }
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public ab b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (!this.f65317f) {
                    this.f65317f = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            i();
            this.f65316e.a(this);
            try {
                try {
                    this.f65312a.s().a(this);
                    ab h2 = h();
                    if (h2 != null) {
                        return h2;
                    }
                    throw new IOException(ResponseException.CANCELED);
                } catch (IOException e2) {
                    this.f65316e.a(this, e2);
                    throw e2;
                }
            } finally {
                this.f65312a.s().b(this);
            }
        }
        return (ab) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f65313b.a();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f65313b.b() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public y clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? a(this.f65312a, this.f65314c, this.f65315d) : (y) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(d() ? "canceled " : "");
            sb.append(this.f65315d ? "web socket" : NotificationCompat.CATEGORY_CALL);
            sb.append(" to ");
            sb.append(g());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f65314c.a().n() : (String) invokeV.objValue;
    }

    public ab h() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList(this.f65312a.v());
            arrayList.add(this.f65313b);
            arrayList.add(new com.bytedance.sdk.component.b.b.a.c.a(this.f65312a.f()));
            arrayList.add(new com.bytedance.sdk.component.b.b.a.a.a(this.f65312a.g()));
            arrayList.add(new com.bytedance.sdk.component.b.b.a.b.a(this.f65312a));
            if (!this.f65315d) {
                arrayList.addAll(this.f65312a.w());
            }
            arrayList.add(new com.bytedance.sdk.component.b.b.a.c.b(this.f65315d));
            return new com.bytedance.sdk.component.b.b.a.c.g(arrayList, null, null, null, 0, this.f65314c, this, this.f65316e, this.f65312a.a(), this.f65312a.b(), this.f65312a.c()).a(this.f65314c);
        }
        return (ab) invokeV.objValue;
    }

    public static y a(w wVar, z zVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, wVar, zVar, z)) == null) {
            y yVar = new y(wVar, zVar, z);
            yVar.f65316e = wVar.x().a(yVar);
            return yVar;
        }
        return (y) invokeLLZ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65314c : (z) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            synchronized (this) {
                if (!this.f65317f) {
                    this.f65317f = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            i();
            this.f65316e.a(this);
            this.f65312a.s().a(new a(this, fVar));
        }
    }
}
