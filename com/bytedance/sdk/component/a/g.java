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
/* loaded from: classes9.dex */
public class g implements w.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f63932a;

    /* renamed from: b  reason: collision with root package name */
    public final u f63933b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b> f63934c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.b> f63935d;

    /* renamed from: e  reason: collision with root package name */
    public final List<q> f63936e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f63937f;

    /* renamed from: g  reason: collision with root package name */
    public final m f63938g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f63939h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f63940i;

    /* renamed from: j  reason: collision with root package name */
    public final com.bytedance.sdk.component.a.a f63941j;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f63947a;

        /* renamed from: b  reason: collision with root package name */
        public String f63948b;

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
            this.f63947a = z;
            this.f63948b = str;
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
        this.f63934c = new HashMap();
        this.f63935d = new HashMap();
        this.f63936e = new ArrayList();
        this.f63937f = new HashSet();
        this.f63941j = aVar;
        this.f63932a = jVar.f63954d;
        u uVar = new u(vVar, jVar.l, jVar.m);
        this.f63933b = uVar;
        uVar.a(this);
        this.f63933b.a(jVar.p);
        this.f63938g = jVar.f63959i;
        this.f63939h = jVar.f63958h;
        this.f63940i = jVar.o;
    }

    private x b(String str, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, bVar)) == null) {
            if (this.f63940i) {
                return x.f64014c;
            }
            return this.f63933b.a(this.f63939h, str, bVar);
        }
        return (x) invokeLL.objValue;
    }

    @Nullable
    @MainThread
    public a a(@NonNull q qVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qVar, fVar)) == null) {
            b bVar = this.f63934c.get(qVar.f63965d);
            if (bVar != null) {
                try {
                    x b2 = b(fVar.f63929b, bVar);
                    fVar.f63931d = b2;
                    if (b2 == null) {
                        if (this.f63938g != null) {
                            this.f63938g.a(fVar.f63929b, qVar.f63965d, 1);
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
                    this.f63936e.add(qVar);
                    return new a(false, y.a());
                }
            }
            d.b bVar2 = this.f63935d.get(qVar.f63965d);
            if (bVar2 != null) {
                d a2 = bVar2.a();
                a2.a(qVar.f63965d);
                x b3 = b(fVar.f63929b, a2);
                fVar.f63931d = b3;
                if (b3 != null) {
                    i.a("Processing stateful call: " + qVar);
                    return a(qVar, a2, fVar);
                }
                i.a("Permission denied, call: " + qVar);
                a2.e();
                throw new s(-1);
            }
            m mVar = this.f63938g;
            if (mVar != null) {
                mVar.a(fVar.f63929b, qVar.f63965d, 2);
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
            this.f63934c.put(str, eVar);
            i.a("JsBridge stateless method registered: " + str);
        }
    }

    public void a(String str, @NonNull d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            this.f63935d.put(str, bVar);
            i.a("JsBridge stateful method registered: " + str);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (d dVar : this.f63937f) {
                dVar.f();
            }
            this.f63937f.clear();
            this.f63934c.clear();
            this.f63935d.clear();
            this.f63933b.b(this);
        }
    }

    @NonNull
    @MainThread
    private a a(@NonNull q qVar, @NonNull e eVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, qVar, eVar, fVar)) == null) ? new a(true, y.a(this.f63932a.a((h) eVar.a(a(qVar.f63966e, (b) eVar), fVar)))) : (a) invokeLLL.objValue;
    }

    @NonNull
    @MainThread
    private a a(@NonNull q qVar, @NonNull d dVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, qVar, dVar, fVar)) == null) {
            this.f63937f.add(dVar);
            dVar.a(a(qVar.f63966e, dVar), fVar, new d.a(this, qVar, dVar) { // from class: com.bytedance.sdk.component.a.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f63942a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f63943b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f63944c;

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
                    this.f63944c = this;
                    this.f63942a = qVar;
                    this.f63943b = dVar;
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) || this.f63944c.f63941j == null) {
                        return;
                    }
                    this.f63944c.f63941j.b(y.a(this.f63944c.f63932a.a((h) obj)), this.f63942a);
                    this.f63944c.f63937f.remove(this.f63943b);
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) || this.f63944c.f63941j == null) {
                        return;
                    }
                    this.f63944c.f63941j.b(y.a(th), this.f63942a);
                    this.f63944c.f63937f.remove(this.f63943b);
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
            cVar.a(qVar, new t(qVar.f63965d, xVar, new t.a(this, qVar) { // from class: com.bytedance.sdk.component.a.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f63945a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f63946b;

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
                    this.f63946b = this;
                    this.f63945a = qVar;
                }
            }));
            return new a(false, y.a());
        }
        return (a) invokeLLL.objValue;
    }

    private Object a(String str, b bVar) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, bVar)) == null) ? this.f63932a.a(str, a(bVar)[0]) : invokeLL.objValue;
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
