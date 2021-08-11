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
    public final h f63732a;

    /* renamed from: b  reason: collision with root package name */
    public final u f63733b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b> f63734c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.b> f63735d;

    /* renamed from: e  reason: collision with root package name */
    public final List<q> f63736e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f63737f;

    /* renamed from: g  reason: collision with root package name */
    public final m f63738g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f63739h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f63740i;

    /* renamed from: j  reason: collision with root package name */
    public final com.bytedance.sdk.component.a.a f63741j;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f63747a;

        /* renamed from: b  reason: collision with root package name */
        public String f63748b;

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
            this.f63747a = z;
            this.f63748b = str;
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
        this.f63734c = new HashMap();
        this.f63735d = new HashMap();
        this.f63736e = new ArrayList();
        this.f63737f = new HashSet();
        this.f63741j = aVar;
        this.f63732a = jVar.f63754d;
        u uVar = new u(vVar, jVar.l, jVar.m);
        this.f63733b = uVar;
        uVar.a(this);
        this.f63733b.a(jVar.p);
        this.f63738g = jVar.f63759i;
        this.f63739h = jVar.f63758h;
        this.f63740i = jVar.o;
    }

    private x b(String str, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, bVar)) == null) {
            if (this.f63740i) {
                return x.f63814c;
            }
            return this.f63733b.a(this.f63739h, str, bVar);
        }
        return (x) invokeLL.objValue;
    }

    @Nullable
    @MainThread
    public a a(@NonNull q qVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qVar, fVar)) == null) {
            b bVar = this.f63734c.get(qVar.f63765d);
            if (bVar != null) {
                try {
                    x b2 = b(fVar.f63729b, bVar);
                    fVar.f63731d = b2;
                    if (b2 == null) {
                        if (this.f63738g != null) {
                            this.f63738g.a(fVar.f63729b, qVar.f63765d, 1);
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
                    this.f63736e.add(qVar);
                    return new a(false, y.a());
                }
            }
            d.b bVar2 = this.f63735d.get(qVar.f63765d);
            if (bVar2 != null) {
                d a2 = bVar2.a();
                a2.a(qVar.f63765d);
                x b3 = b(fVar.f63729b, a2);
                fVar.f63731d = b3;
                if (b3 != null) {
                    i.a("Processing stateful call: " + qVar);
                    return a(qVar, a2, fVar);
                }
                i.a("Permission denied, call: " + qVar);
                a2.e();
                throw new s(-1);
            }
            m mVar = this.f63738g;
            if (mVar != null) {
                mVar.a(fVar.f63729b, qVar.f63765d, 2);
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
            this.f63734c.put(str, eVar);
            i.a("JsBridge stateless method registered: " + str);
        }
    }

    public void a(String str, @NonNull d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            this.f63735d.put(str, bVar);
            i.a("JsBridge stateful method registered: " + str);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (d dVar : this.f63737f) {
                dVar.f();
            }
            this.f63737f.clear();
            this.f63734c.clear();
            this.f63735d.clear();
            this.f63733b.b(this);
        }
    }

    @NonNull
    @MainThread
    private a a(@NonNull q qVar, @NonNull e eVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, qVar, eVar, fVar)) == null) ? new a(true, y.a(this.f63732a.a((h) eVar.a(a(qVar.f63766e, (b) eVar), fVar)))) : (a) invokeLLL.objValue;
    }

    @NonNull
    @MainThread
    private a a(@NonNull q qVar, @NonNull d dVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, qVar, dVar, fVar)) == null) {
            this.f63737f.add(dVar);
            dVar.a(a(qVar.f63766e, dVar), fVar, new d.a(this, qVar, dVar) { // from class: com.bytedance.sdk.component.a.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f63742a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f63743b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f63744c;

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
                    this.f63744c = this;
                    this.f63742a = qVar;
                    this.f63743b = dVar;
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) || this.f63744c.f63741j == null) {
                        return;
                    }
                    this.f63744c.f63741j.b(y.a(this.f63744c.f63732a.a((h) obj)), this.f63742a);
                    this.f63744c.f63737f.remove(this.f63743b);
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) || this.f63744c.f63741j == null) {
                        return;
                    }
                    this.f63744c.f63741j.b(y.a(th), this.f63742a);
                    this.f63744c.f63737f.remove(this.f63743b);
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
            cVar.a(qVar, new t(qVar.f63765d, xVar, new t.a(this, qVar) { // from class: com.bytedance.sdk.component.a.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f63745a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f63746b;

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
                    this.f63746b = this;
                    this.f63745a = qVar;
                }
            }));
            return new a(false, y.a());
        }
        return (a) invokeLLL.objValue;
    }

    private Object a(String str, b bVar) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, bVar)) == null) ? this.f63732a.a(str, a(bVar)[0]) : invokeLL.objValue;
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
