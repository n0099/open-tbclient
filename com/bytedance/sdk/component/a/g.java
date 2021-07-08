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
/* loaded from: classes5.dex */
public class g implements v.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f27739a;

    /* renamed from: b  reason: collision with root package name */
    public final t f27740b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b> f27741c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.b> f27742d;

    /* renamed from: e  reason: collision with root package name */
    public final List<p> f27743e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f27744f;

    /* renamed from: g  reason: collision with root package name */
    public final m f27745g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f27746h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f27747i;
    public final com.bytedance.sdk.component.a.a j;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f27753a;

        /* renamed from: b  reason: collision with root package name */
        public String f27754b;

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
            this.f27753a = z;
            this.f27754b = str;
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
        this.f27741c = new HashMap();
        this.f27742d = new HashMap();
        this.f27743e = new ArrayList();
        this.f27744f = new HashSet();
        this.j = aVar;
        this.f27739a = jVar.f27760d;
        t tVar = new t(uVar, jVar.l, jVar.m);
        this.f27740b = tVar;
        tVar.a(this);
        this.f27740b.a(jVar.p);
        this.f27745g = jVar.f27765i;
        this.f27746h = jVar.f27764h;
        this.f27747i = jVar.o;
    }

    private w b(String str, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, bVar)) == null) {
            if (this.f27747i) {
                return w.f27818c;
            }
            return this.f27740b.a(this.f27746h, str, bVar);
        }
        return (w) invokeLL.objValue;
    }

    @Nullable
    @MainThread
    public a a(@NonNull p pVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pVar, fVar)) == null) {
            b bVar = this.f27741c.get(pVar.f27769d);
            if (bVar != null) {
                try {
                    w b2 = b(fVar.f27736b, bVar);
                    fVar.f27738d = b2;
                    if (b2 == null) {
                        if (this.f27745g != null) {
                            this.f27745g.a(fVar.f27736b, pVar.f27769d, 1);
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
                    this.f27743e.add(pVar);
                    return new a(false, x.a());
                }
            }
            d.b bVar2 = this.f27742d.get(pVar.f27769d);
            if (bVar2 != null) {
                d a2 = bVar2.a();
                a2.a(pVar.f27769d);
                w b3 = b(fVar.f27736b, a2);
                fVar.f27738d = b3;
                if (b3 != null) {
                    i.a("Processing stateful call: " + pVar);
                    return a(pVar, a2, fVar);
                }
                i.a("Permission denied, call: " + pVar);
                a2.e();
                throw new r(-1);
            }
            m mVar = this.f27745g;
            if (mVar != null) {
                mVar.a(fVar.f27736b, pVar.f27769d, 2);
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
            this.f27741c.put(str, eVar);
            i.a("JsBridge stateless method registered: " + str);
        }
    }

    public void a(String str, @NonNull d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            this.f27742d.put(str, bVar);
            i.a("JsBridge stateful method registered: " + str);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (d dVar : this.f27744f) {
                dVar.f();
            }
            this.f27744f.clear();
            this.f27741c.clear();
            this.f27742d.clear();
            this.f27740b.b(this);
        }
    }

    @NonNull
    @MainThread
    private a a(@NonNull p pVar, @NonNull e eVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, pVar, eVar, fVar)) == null) ? new a(true, x.a(this.f27739a.a((h) eVar.a(a(pVar.f27770e, (b) eVar), fVar)))) : (a) invokeLLL.objValue;
    }

    @NonNull
    @MainThread
    private a a(@NonNull p pVar, @NonNull d dVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, pVar, dVar, fVar)) == null) {
            this.f27744f.add(dVar);
            dVar.a(a(pVar.f27770e, dVar), fVar, new d.a(this, pVar, dVar) { // from class: com.bytedance.sdk.component.a.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f27748a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f27749b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f27750c;

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
                    this.f27750c = this;
                    this.f27748a = pVar;
                    this.f27749b = dVar;
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) || this.f27750c.j == null) {
                        return;
                    }
                    this.f27750c.j.b(x.a(this.f27750c.f27739a.a((h) obj)), this.f27748a);
                    this.f27750c.f27744f.remove(this.f27749b);
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) || this.f27750c.j == null) {
                        return;
                    }
                    this.f27750c.j.b(x.a(th), this.f27748a);
                    this.f27750c.f27744f.remove(this.f27749b);
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
            cVar.a(pVar, new s(pVar.f27769d, wVar, new s.a(this, pVar) { // from class: com.bytedance.sdk.component.a.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f27751a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f27752b;

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
                    this.f27752b = this;
                    this.f27751a = pVar;
                }
            }));
            return new a(false, x.a());
        }
        return (a) invokeLLL.objValue;
    }

    private Object a(String str, b bVar) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, bVar)) == null) ? this.f27739a.a(str, a(bVar)[0]) : invokeLL.objValue;
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
