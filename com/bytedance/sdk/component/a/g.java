package com.bytedance.sdk.component.a;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.s;
import com.bytedance.sdk.component.a.u;
import com.bytedance.sdk.component.a.v;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class g implements v.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f27629a;

    /* renamed from: b  reason: collision with root package name */
    public final t f27630b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b> f27631c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.b> f27632d;

    /* renamed from: e  reason: collision with root package name */
    public final List<p> f27633e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f27634f;

    /* renamed from: g  reason: collision with root package name */
    public final m f27635g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f27636h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f27637i;
    public final com.bytedance.sdk.component.a.a j;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f27643a;

        /* renamed from: b  reason: collision with root package name */
        public String f27644b;

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
            this.f27643a = z;
            this.f27644b = str;
        }
    }

    public g(@NonNull j jVar, @NonNull com.bytedance.sdk.component.a.a aVar, @Nullable u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, aVar, uVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27631c = new HashMap();
        this.f27632d = new HashMap();
        this.f27633e = new ArrayList();
        this.f27634f = new HashSet();
        this.j = aVar;
        this.f27629a = jVar.f27650d;
        t tVar = new t(uVar, jVar.l, jVar.m);
        this.f27630b = tVar;
        tVar.a(this);
        this.f27630b.a(jVar.p);
        this.f27635g = jVar.f27655i;
        this.f27636h = jVar.f27654h;
        this.f27637i = jVar.o;
    }

    private w b(String str, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, bVar)) == null) {
            if (this.f27637i) {
                return w.f27708c;
            }
            return this.f27630b.a(this.f27636h, str, bVar);
        }
        return (w) invokeLL.objValue;
    }

    @Nullable
    @MainThread
    public a a(@NonNull p pVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pVar, fVar)) == null) {
            b bVar = this.f27631c.get(pVar.f27659d);
            if (bVar != null) {
                try {
                    w b2 = b(fVar.f27626b, bVar);
                    fVar.f27628d = b2;
                    if (b2 == null) {
                        if (this.f27635g != null) {
                            this.f27635g.a(fVar.f27626b, pVar.f27659d, 1);
                        }
                        i.a("Permission denied, call: " + pVar);
                        throw new r(-1);
                    } else if (bVar instanceof e) {
                        i.a("Processing stateless call: " + pVar);
                        return a(pVar, (e) bVar, fVar);
                    } else if (bVar instanceof c) {
                        i.a("Processing raw call: " + pVar);
                        return a(pVar, (c) bVar, b2);
                    }
                } catch (u.a e2) {
                    i.a("No remote permission config fetched, call pending: " + pVar, e2);
                    this.f27633e.add(pVar);
                    return new a(false, x.a());
                }
            }
            d.b bVar2 = this.f27632d.get(pVar.f27659d);
            if (bVar2 != null) {
                d a2 = bVar2.a();
                a2.a(pVar.f27659d);
                w b3 = b(fVar.f27626b, a2);
                fVar.f27628d = b3;
                if (b3 != null) {
                    i.a("Processing stateful call: " + pVar);
                    return a(pVar, a2, fVar);
                }
                i.a("Permission denied, call: " + pVar);
                a2.e();
                throw new r(-1);
            }
            m mVar = this.f27635g;
            if (mVar != null) {
                mVar.a(fVar.f27626b, pVar.f27659d, 2);
            }
            i.b("Received call: " + pVar + ", but not registered.");
            return null;
        }
        return (a) invokeLL.objValue;
    }

    public void a(String str, @NonNull e<?, ?> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
            eVar.a(str);
            this.f27631c.put(str, eVar);
            i.a("JsBridge stateless method registered: " + str);
        }
    }

    public void a(String str, @NonNull d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            this.f27632d.put(str, bVar);
            i.a("JsBridge stateful method registered: " + str);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (d dVar : this.f27634f) {
                dVar.f();
            }
            this.f27634f.clear();
            this.f27631c.clear();
            this.f27632d.clear();
            this.f27630b.b(this);
        }
    }

    @NonNull
    @MainThread
    private a a(@NonNull p pVar, @NonNull e eVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, this, pVar, eVar, fVar)) == null) ? new a(true, x.a(this.f27629a.a((h) eVar.a(a(pVar.f27660e, (b) eVar), fVar)))) : (a) invokeLLL.objValue;
    }

    @NonNull
    @MainThread
    private a a(@NonNull p pVar, @NonNull d dVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, pVar, dVar, fVar)) == null) {
            this.f27634f.add(dVar);
            dVar.a(a(pVar.f27660e, dVar), fVar, new d.a(this, pVar, dVar) { // from class: com.bytedance.sdk.component.a.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f27638a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f27639b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f27640c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pVar, dVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27640c = this;
                    this.f27638a = pVar;
                    this.f27639b = dVar;
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) || this.f27640c.j == null) {
                        return;
                    }
                    this.f27640c.j.b(x.a(this.f27640c.f27629a.a((h) obj)), this.f27638a);
                    this.f27640c.f27634f.remove(this.f27639b);
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) || this.f27640c.j == null) {
                        return;
                    }
                    this.f27640c.j.b(x.a(th), this.f27638a);
                    this.f27640c.f27634f.remove(this.f27639b);
                }
            });
            return new a(false, x.a());
        }
        return (a) invokeLLL.objValue;
    }

    @NonNull
    @MainThread
    private a a(p pVar, c cVar, w wVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, pVar, cVar, wVar)) == null) {
            cVar.a(pVar, new s(pVar.f27659d, wVar, new s.a(this, pVar) { // from class: com.bytedance.sdk.component.a.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f27641a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f27642b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27642b = this;
                    this.f27641a = pVar;
                }
            }));
            return new a(false, x.a());
        }
        return (a) invokeLLL.objValue;
    }

    private Object a(String str, b bVar) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, bVar)) == null) ? this.f27629a.a(str, a(bVar)[0]) : invokeLL.objValue;
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
