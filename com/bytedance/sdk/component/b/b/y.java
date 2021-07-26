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
/* loaded from: classes5.dex */
public final class y implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f28759a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.c.j f28760b;

    /* renamed from: c  reason: collision with root package name */
    public final z f28761c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f28762d;

    /* renamed from: e  reason: collision with root package name */
    public p f28763e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28764f;

    /* loaded from: classes5.dex */
    public final class a extends com.bytedance.sdk.component.b.b.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f28765a;

        /* renamed from: c  reason: collision with root package name */
        public final f f28766c;

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
            this.f28765a = yVar;
            this.f28766c = fVar;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28765a.f28761c.a().g() : (String) invokeV.objValue;
        }

        public y b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28765a : (y) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.b.a.b
        public void c() {
            IOException e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = true;
                try {
                    try {
                        ab h2 = this.f28765a.h();
                        try {
                            if (this.f28765a.f28760b.b()) {
                                this.f28766c.onFailure(this.f28765a, new IOException(ResponseException.CANCELED));
                            } else {
                                this.f28766c.onResponse(this.f28765a, h2);
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            if (!z) {
                                this.f28765a.f28763e.a(this.f28765a, e2);
                                this.f28766c.onFailure(this.f28765a, e2);
                            } else {
                                com.bytedance.sdk.component.b.b.a.g.e b2 = com.bytedance.sdk.component.b.b.a.g.e.b();
                                b2.a(4, "Callback failure for " + this.f28765a.f(), e2);
                            }
                        }
                    } finally {
                        this.f28765a.f28759a.s().b(this);
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
        this.f28759a = wVar;
        this.f28761c = zVar;
        this.f28762d = z;
        this.f28760b = new com.bytedance.sdk.component.b.b.a.c.j(wVar, z);
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f28760b.a(com.bytedance.sdk.component.b.b.a.g.e.b().a("response.body().close()"));
        }
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public ab b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (!this.f28764f) {
                    this.f28764f = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            i();
            this.f28763e.a(this);
            try {
                try {
                    this.f28759a.s().a(this);
                    ab h2 = h();
                    if (h2 != null) {
                        return h2;
                    }
                    throw new IOException(ResponseException.CANCELED);
                } catch (IOException e2) {
                    this.f28763e.a(this, e2);
                    throw e2;
                }
            } finally {
                this.f28759a.s().b(this);
            }
        }
        return (ab) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f28760b.a();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28760b.b() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public y clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? a(this.f28759a, this.f28761c, this.f28762d) : (y) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(d() ? "canceled " : "");
            sb.append(this.f28762d ? "web socket" : NotificationCompat.CATEGORY_CALL);
            sb.append(" to ");
            sb.append(g());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28761c.a().n() : (String) invokeV.objValue;
    }

    public ab h() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList(this.f28759a.v());
            arrayList.add(this.f28760b);
            arrayList.add(new com.bytedance.sdk.component.b.b.a.c.a(this.f28759a.f()));
            arrayList.add(new com.bytedance.sdk.component.b.b.a.a.a(this.f28759a.g()));
            arrayList.add(new com.bytedance.sdk.component.b.b.a.b.a(this.f28759a));
            if (!this.f28762d) {
                arrayList.addAll(this.f28759a.w());
            }
            arrayList.add(new com.bytedance.sdk.component.b.b.a.c.b(this.f28762d));
            return new com.bytedance.sdk.component.b.b.a.c.g(arrayList, null, null, null, 0, this.f28761c, this, this.f28763e, this.f28759a.a(), this.f28759a.b(), this.f28759a.c()).a(this.f28761c);
        }
        return (ab) invokeV.objValue;
    }

    public static y a(w wVar, z zVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, wVar, zVar, z)) == null) {
            y yVar = new y(wVar, zVar, z);
            yVar.f28763e = wVar.x().a(yVar);
            return yVar;
        }
        return (y) invokeLLZ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28761c : (z) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            synchronized (this) {
                if (!this.f28764f) {
                    this.f28764f = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            i();
            this.f28763e.a(this);
            this.f28759a.s().a(new a(this, fVar));
        }
    }
}
