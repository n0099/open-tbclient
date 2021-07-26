package com.bytedance.sdk.component.a;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.t;
import com.bytedance.sdk.component.a.v;
import com.bytedance.sdk.component.a.w;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class g implements w.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f27897a;

    /* renamed from: b  reason: collision with root package name */
    public final u f27898b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b> f27899c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.b> f27900d;

    /* renamed from: e  reason: collision with root package name */
    public final List<q> f27901e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f27902f;

    /* renamed from: g  reason: collision with root package name */
    public final m f27903g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f27904h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f27905i;
    public final com.bytedance.sdk.component.a.a j;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f27911a;

        /* renamed from: b  reason: collision with root package name */
        public String f27912b;

        public a(boolean z, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27911a = z;
            this.f27912b = str;
        }
    }

    public g(@NonNull j jVar, @NonNull com.bytedance.sdk.component.a.a aVar, @Nullable v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, aVar, vVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27899c = new HashMap();
        this.f27900d = new HashMap();
        this.f27901e = new ArrayList();
        this.f27902f = new HashSet();
        this.j = aVar;
        this.f27897a = jVar.f27918d;
        u uVar = new u(vVar, jVar.l, jVar.m);
        this.f27898b = uVar;
        uVar.a(this);
        this.f27898b.a(jVar.p);
        this.f27903g = jVar.f27923i;
        this.f27904h = jVar.f27922h;
        this.f27905i = jVar.o;
    }

    private x b(String str, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, bVar)) == null) {
            if (this.f27905i) {
                return x.f27977c;
            }
            return this.f27898b.a(this.f27904h, str, bVar);
        }
        return (x) invokeLL.objValue;
    }

    @Nullable
    @MainThread
    public a a(@NonNull q qVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qVar, fVar)) == null) {
            b bVar = this.f27899c.get(qVar.f27928d);
            if (bVar != null) {
                try {
                    x b2 = b(fVar.f27894b, bVar);
                    fVar.f27896d = b2;
                    if (b2 == null) {
                        if (this.f27903g != null) {
                            this.f27903g.a(fVar.f27894b, qVar.f27928d, 1);
                        }
                        i.a("Permission denied, call: " + qVar);
                        throw new s(-1);
                    } else if (bVar instanceof e) {
                        i.a("Processing stateless call: " + qVar);
                        return a(qVar, (e) bVar, fVar);
                    } else if (bVar instanceof c) {
                        i.a("Processing raw call: " + qVar);
                        return a(qVar, (c) bVar, b2);
                    }
                } catch (v.a e2) {
                    i.a("No remote permission config fetched, call pending: " + qVar, e2);
                    this.f27901e.add(qVar);
                    return new a(false, y.a());
                }
            }
            d.b bVar2 = this.f27900d.get(qVar.f27928d);
            if (bVar2 != null) {
                d a2 = bVar2.a();
                a2.a(qVar.f27928d);
                x b3 = b(fVar.f27894b, a2);
                fVar.f27896d = b3;
                if (b3 != null) {
                    i.a("Processing stateful call: " + qVar);
                    return a(qVar, a2, fVar);
                }
                i.a("Permission denied, call: " + qVar);
                a2.e();
                throw new s(-1);
            }
            m mVar = this.f27903g;
            if (mVar != null) {
                mVar.a(fVar.f27894b, qVar.f27928d, 2);
            }
            i.b("Received call: " + qVar + ", but not registered.");
            return null;
        }
        return (a) invokeLL.objValue;
    }

    public void a(String str, @NonNull e<?, ?> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
            eVar.a(str);
            this.f27899c.put(str, eVar);
            i.a("JsBridge stateless method registered: " + str);
        }
    }

    public void a(String str, @NonNull d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            this.f27900d.put(str, bVar);
            i.a("JsBridge stateful method registered: " + str);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (d dVar : this.f27902f) {
                dVar.f();
            }
            this.f27902f.clear();
            this.f27899c.clear();
            this.f27900d.clear();
            this.f27898b.b(this);
        }
    }

    @NonNull
    @MainThread
    private a a(@NonNull q qVar, @NonNull e eVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, qVar, eVar, fVar)) == null) ? new a(true, y.a(this.f27897a.a((h) eVar.a(a(qVar.f27929e, (b) eVar), fVar)))) : (a) invokeLLL.objValue;
    }

    @NonNull
    @MainThread
    private a a(@NonNull q qVar, @NonNull d dVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, qVar, dVar, fVar)) == null) {
            this.f27902f.add(dVar);
            dVar.a(a(qVar.f27929e, dVar), fVar, new d.a(this, qVar, dVar) { // from class: com.bytedance.sdk.component.a.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f27906a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f27907b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f27908c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, qVar, dVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27908c = this;
                    this.f27906a = qVar;
                    this.f27907b = dVar;
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) || this.f27908c.j == null) {
                        return;
                    }
                    this.f27908c.j.b(y.a(this.f27908c.f27897a.a((h) obj)), this.f27906a);
                    this.f27908c.f27902f.remove(this.f27907b);
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) || this.f27908c.j == null) {
                        return;
                    }
                    this.f27908c.j.b(y.a(th), this.f27906a);
                    this.f27908c.f27902f.remove(this.f27907b);
                }
            });
            return new a(false, y.a());
        }
        return (a) invokeLLL.objValue;
    }

    @NonNull
    @MainThread
    private a a(q qVar, c cVar, x xVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, qVar, cVar, xVar)) == null) {
            cVar.a(qVar, new t(qVar.f27928d, xVar, new t.a(this, qVar) { // from class: com.bytedance.sdk.component.a.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f27909a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f27910b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, qVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27910b = this;
                    this.f27909a = qVar;
                }
            }));
            return new a(false, y.a());
        }
        return (a) invokeLLL.objValue;
    }

    private Object a(String str, b bVar) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, bVar)) == null) ? this.f27897a.a(str, a(bVar)[0]) : invokeLL.objValue;
    }

    @NonNull
    public static Type[] a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj)) == null) {
            Type genericSuperclass = obj.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            }
            throw new IllegalStateException("Method is not parameterized?!");
        }
        return (Type[]) invokeL.objValue;
    }
}
