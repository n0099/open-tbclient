package com.bytedance.sdk.component.adnet.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.b.c;
import com.bytedance.sdk.component.adnet.core.l;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.core.o;
import com.bytedance.sdk.component.adnet.face.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, C0313b> f27737a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f27738b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final l f27739c;

    /* renamed from: d  reason: collision with root package name */
    public Context f27740d;

    /* loaded from: classes6.dex */
    public interface a extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27738b = new Handler(Looper.getMainLooper());
        this.f27740d = context;
        this.f27739c = lVar;
        this.f27737a = Collections.synchronizedMap(new LinkedHashMap());
    }

    private C0313b b(String str, a aVar, boolean z) {
        InterceptResult invokeLLZ;
        String absolutePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, this, str, aVar, z)) == null) {
            File b2 = aVar != null ? aVar.b(str) : null;
            if (b2 == null) {
                absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
            } else {
                absolutePath = b2.getAbsolutePath();
            }
            return new C0313b(this, str, absolutePath, aVar, z);
        }
        return (C0313b) invokeLLZ.objValue;
    }

    public void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            a(str, aVar, true);
        }
    }

    /* renamed from: com.bytedance.sdk.component.adnet.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0313b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f27744a;

        /* renamed from: b  reason: collision with root package name */
        public String f27745b;

        /* renamed from: c  reason: collision with root package name */
        public List<a> f27746c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f27747d;

        /* renamed from: e  reason: collision with root package name */
        public c f27748e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f27749f;

        public C0313b(b bVar, String str, String str2, a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27749f = bVar;
            this.f27744a = str;
            this.f27745b = str2;
            this.f27747d = z;
            a(aVar);
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
                return;
            }
            if (this.f27746c == null) {
                this.f27746c = Collections.synchronizedList(new ArrayList());
            }
            this.f27746c.add(aVar);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof C0313b) {
                    return ((C0313b) obj).f27744a.equals(this.f27744a);
                }
                return super.equals(obj);
            }
            return invokeL.booleanValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = new c(this.f27745b, this.f27744a, new c.a(this) { // from class: com.bytedance.sdk.component.adnet.b.b.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ C0313b f27750a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f27750a = this;
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.c.a
                    public void a(long j, long j2) {
                        List<a> list;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (list = this.f27750a.f27746c) == null) {
                            return;
                        }
                        for (a aVar : list) {
                            try {
                                aVar.a(j, j2);
                            } catch (Throwable th) {
                                o.a(th, "file loader onDownloadProgress error", new Object[0]);
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.component.adnet.core.m.a
                    public void b(m<File> mVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
                            List<a> list = this.f27750a.f27746c;
                            if (list != null) {
                                for (a aVar : list) {
                                    try {
                                        aVar.b(mVar);
                                    } catch (Throwable th) {
                                        o.a(th, "file loader onErrorResponse error", new Object[0]);
                                    }
                                }
                                this.f27750a.f27746c.clear();
                            }
                            this.f27750a.f27749f.f27737a.remove(this.f27750a.f27744a);
                        }
                    }

                    @Override // com.bytedance.sdk.component.adnet.core.m.a
                    public void a(m<File> mVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
                            List<a> list = this.f27750a.f27746c;
                            if (list != null) {
                                for (a aVar : list) {
                                    try {
                                        aVar.a(mVar);
                                    } catch (Throwable th) {
                                        o.a(th, "file loader onResponse error", new Object[0]);
                                    }
                                    try {
                                        aVar.a(this.f27750a.f27744a, mVar.f27921a);
                                    } catch (Throwable th2) {
                                        o.a(th2, "file loader putFile error", new Object[0]);
                                    }
                                }
                                this.f27750a.f27746c.clear();
                            }
                            this.f27750a.f27749f.f27737a.remove(this.f27750a.f27744a);
                        }
                    }
                });
                this.f27748e = cVar;
                cVar.setTag("FileLoader#" + this.f27744a);
                this.f27749f.f27739c.a(this.f27748e);
            }
        }
    }

    public void a(String str, a aVar, boolean z) {
        C0313b c0313b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (a(str) && (c0313b = this.f27737a.get(str)) != null) {
            c0313b.a(aVar);
            return;
        }
        File a2 = aVar.a(str);
        if (a2 != null && aVar != null) {
            this.f27738b.post(new Runnable(this, aVar, a2) { // from class: com.bytedance.sdk.component.adnet.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f27741a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ File f27742b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f27743c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, a2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27743c = this;
                    this.f27741a = aVar;
                    this.f27742b = a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27741a.a(this.f27742b.length(), this.f27742b.length());
                        this.f27741a.a(m.a(this.f27742b, (a.C0316a) null));
                    }
                }
            });
        } else {
            a(b(str, aVar, z));
        }
    }

    private void a(C0313b c0313b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, c0313b) == null) || c0313b == null) {
            return;
        }
        c0313b.a();
        this.f27737a.put(c0313b.f27744a, c0313b);
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, this, str)) == null) ? this.f27737a.containsKey(str) : invokeL.booleanValue;
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            File file = new File(com.bytedance.sdk.component.adnet.a.b(this.f27740d), "fileLoader");
            file.mkdirs();
            return file.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }
}
