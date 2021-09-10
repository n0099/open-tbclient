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
    public final h f64112a;

    /* renamed from: b  reason: collision with root package name */
    public final u f64113b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b> f64114c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.b> f64115d;

    /* renamed from: e  reason: collision with root package name */
    public final List<q> f64116e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f64117f;

    /* renamed from: g  reason: collision with root package name */
    public final m f64118g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f64119h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f64120i;

    /* renamed from: j  reason: collision with root package name */
    public final com.bytedance.sdk.component.a.a f64121j;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f64127a;

        /* renamed from: b  reason: collision with root package name */
        public String f64128b;

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
            this.f64127a = z;
            this.f64128b = str;
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
        this.f64114c = new HashMap();
        this.f64115d = new HashMap();
        this.f64116e = new ArrayList();
        this.f64117f = new HashSet();
        this.f64121j = aVar;
        this.f64112a = jVar.f64134d;
        u uVar = new u(vVar, jVar.l, jVar.m);
        this.f64113b = uVar;
        uVar.a(this);
        this.f64113b.a(jVar.p);
        this.f64118g = jVar.f64139i;
        this.f64119h = jVar.f64138h;
        this.f64120i = jVar.o;
    }

    private x b(String str, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, bVar)) == null) {
            if (this.f64120i) {
                return x.f64194c;
            }
            return this.f64113b.a(this.f64119h, str, bVar);
        }
        return (x) invokeLL.objValue;
    }

    @Nullable
    @MainThread
    public a a(@NonNull q qVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qVar, fVar)) == null) {
            b bVar = this.f64114c.get(qVar.f64145d);
            if (bVar != null) {
                try {
                    x b2 = b(fVar.f64109b, bVar);
                    fVar.f64111d = b2;
                    if (b2 == null) {
                        if (this.f64118g != null) {
                            this.f64118g.a(fVar.f64109b, qVar.f64145d, 1);
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
                    this.f64116e.add(qVar);
                    return new a(false, y.a());
                }
            }
            d.b bVar2 = this.f64115d.get(qVar.f64145d);
            if (bVar2 != null) {
                d a2 = bVar2.a();
                a2.a(qVar.f64145d);
                x b3 = b(fVar.f64109b, a2);
                fVar.f64111d = b3;
                if (b3 != null) {
                    i.a("Processing stateful call: " + qVar);
                    return a(qVar, a2, fVar);
                }
                i.a("Permission denied, call: " + qVar);
                a2.e();
                throw new s(-1);
            }
            m mVar = this.f64118g;
            if (mVar != null) {
                mVar.a(fVar.f64109b, qVar.f64145d, 2);
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
            this.f64114c.put(str, eVar);
            i.a("JsBridge stateless method registered: " + str);
        }
    }

    public void a(String str, @NonNull d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            this.f64115d.put(str, bVar);
            i.a("JsBridge stateful method registered: " + str);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (d dVar : this.f64117f) {
                dVar.f();
            }
            this.f64117f.clear();
            this.f64114c.clear();
            this.f64115d.clear();
            this.f64113b.b(this);
        }
    }

    @NonNull
    @MainThread
    private a a(@NonNull q qVar, @NonNull e eVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, qVar, eVar, fVar)) == null) ? new a(true, y.a(this.f64112a.a((h) eVar.a(a(qVar.f64146e, (b) eVar), fVar)))) : (a) invokeLLL.objValue;
    }

    @NonNull
    @MainThread
    private a a(@NonNull q qVar, @NonNull d dVar, @NonNull f fVar) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, qVar, dVar, fVar)) == null) {
            this.f64117f.add(dVar);
            dVar.a(a(qVar.f64146e, dVar), fVar, new d.a(this, qVar, dVar) { // from class: com.bytedance.sdk.component.a.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f64122a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f64123b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f64124c;

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
                    this.f64124c = this;
                    this.f64122a = qVar;
                    this.f64123b = dVar;
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) || this.f64124c.f64121j == null) {
                        return;
                    }
                    this.f64124c.f64121j.b(y.a(this.f64124c.f64112a.a((h) obj)), this.f64122a);
                    this.f64124c.f64117f.remove(this.f64123b);
                }

                @Override // com.bytedance.sdk.component.a.d.a
                public void a(@Nullable Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) || this.f64124c.f64121j == null) {
                        return;
                    }
                    this.f64124c.f64121j.b(y.a(th), this.f64122a);
                    this.f64124c.f64117f.remove(this.f64123b);
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
            cVar.a(qVar, new t(qVar.f64145d, xVar, new t.a(this, qVar) { // from class: com.bytedance.sdk.component.a.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f64125a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f64126b;

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
                    this.f64126b = this;
                    this.f64125a = qVar;
                }
            }));
            return new a(false, y.a());
        }
        return (a) invokeLLL.objValue;
    }

    private Object a(String str, b bVar) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, bVar)) == null) ? this.f64112a.a(str, a(bVar)[0]) : invokeLL.objValue;
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
