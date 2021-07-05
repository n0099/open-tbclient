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
/* loaded from: classes6.dex */
public final class y implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f28555a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.c.j f28556b;

    /* renamed from: c  reason: collision with root package name */
    public final z f28557c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f28558d;

    /* renamed from: e  reason: collision with root package name */
    public p f28559e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28560f;

    /* loaded from: classes6.dex */
    public final class a extends com.bytedance.sdk.component.b.b.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f28561a;

        /* renamed from: c  reason: collision with root package name */
        public final f f28562c;

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
            this.f28561a = yVar;
            this.f28562c = fVar;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28561a.f28557c.a().g() : (String) invokeV.objValue;
        }

        public y b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28561a : (y) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.b.a.b
        public void c() {
            IOException e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = true;
                try {
                    try {
                        ab h2 = this.f28561a.h();
                        try {
                            if (this.f28561a.f28556b.b()) {
                                this.f28562c.onFailure(this.f28561a, new IOException(ResponseException.CANCELED));
                            } else {
                                this.f28562c.onResponse(this.f28561a, h2);
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            if (!z) {
                                this.f28561a.f28559e.a(this.f28561a, e2);
                                this.f28562c.onFailure(this.f28561a, e2);
                            } else {
                                com.bytedance.sdk.component.b.b.a.g.e b2 = com.bytedance.sdk.component.b.b.a.g.e.b();
                                b2.a(4, "Callback failure for " + this.f28561a.f(), e2);
                            }
                        }
                    } finally {
                        this.f28561a.f28555a.s().b(this);
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
        this.f28555a = wVar;
        this.f28557c = zVar;
        this.f28558d = z;
        this.f28556b = new com.bytedance.sdk.component.b.b.a.c.j(wVar, z);
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f28556b.a(com.bytedance.sdk.component.b.b.a.g.e.b().a("response.body().close()"));
        }
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public ab b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (!this.f28560f) {
                    this.f28560f = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            i();
            this.f28559e.a(this);
            try {
                try {
                    this.f28555a.s().a(this);
                    ab h2 = h();
                    if (h2 != null) {
                        return h2;
                    }
                    throw new IOException(ResponseException.CANCELED);
                } catch (IOException e2) {
                    this.f28559e.a(this, e2);
                    throw e2;
                }
            } finally {
                this.f28555a.s().b(this);
            }
        }
        return (ab) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f28556b.a();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28556b.b() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public y clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? a(this.f28555a, this.f28557c, this.f28558d) : (y) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(d() ? "canceled " : "");
            sb.append(this.f28558d ? "web socket" : NotificationCompat.CATEGORY_CALL);
            sb.append(" to ");
            sb.append(g());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28557c.a().n() : (String) invokeV.objValue;
    }

    public ab h() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList(this.f28555a.v());
            arrayList.add(this.f28556b);
            arrayList.add(new com.bytedance.sdk.component.b.b.a.c.a(this.f28555a.f()));
            arrayList.add(new com.bytedance.sdk.component.b.b.a.a.a(this.f28555a.g()));
            arrayList.add(new com.bytedance.sdk.component.b.b.a.b.a(this.f28555a));
            if (!this.f28558d) {
                arrayList.addAll(this.f28555a.w());
            }
            arrayList.add(new com.bytedance.sdk.component.b.b.a.c.b(this.f28558d));
            return new com.bytedance.sdk.component.b.b.a.c.g(arrayList, null, null, null, 0, this.f28557c, this, this.f28559e, this.f28555a.a(), this.f28555a.b(), this.f28555a.c()).a(this.f28557c);
        }
        return (ab) invokeV.objValue;
    }

    public static y a(w wVar, z zVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, wVar, zVar, z)) == null) {
            y yVar = new y(wVar, zVar, z);
            yVar.f28559e = wVar.x().a(yVar);
            return yVar;
        }
        return (y) invokeLLZ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28557c : (z) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.e
    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            synchronized (this) {
                if (!this.f28560f) {
                    this.f28560f = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            i();
            this.f28559e.a(this);
            this.f28555a.s().a(new a(this, fVar));
        }
    }
}
