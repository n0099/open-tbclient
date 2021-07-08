package com.bytedance.sdk.component.adnet.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, C0313b> f27847a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f27848b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final l f27849c;

    /* renamed from: d  reason: collision with root package name */
    public Context f27850d;

    /* loaded from: classes5.dex */
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
        this.f27848b = new Handler(Looper.getMainLooper());
        this.f27850d = context;
        this.f27849c = lVar;
        this.f27847a = Collections.synchronizedMap(new LinkedHashMap());
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
    /* loaded from: classes5.dex */
    public class C0313b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f27854a;

        /* renamed from: b  reason: collision with root package name */
        public String f27855b;

        /* renamed from: c  reason: collision with root package name */
        public List<a> f27856c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f27857d;

        /* renamed from: e  reason: collision with root package name */
        public c f27858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f27859f;

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
            this.f27859f = bVar;
            this.f27854a = str;
            this.f27855b = str2;
            this.f27857d = z;
            a(aVar);
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
                return;
            }
            if (this.f27856c == null) {
                this.f27856c = Collections.synchronizedList(new ArrayList());
            }
            this.f27856c.add(aVar);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof C0313b) {
                    return ((C0313b) obj).f27854a.equals(this.f27854a);
                }
                return super.equals(obj);
            }
            return invokeL.booleanValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = new c(this.f27855b, this.f27854a, new c.a(this) { // from class: com.bytedance.sdk.component.adnet.b.b.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ C0313b f27860a;

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
                        this.f27860a = this;
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.c.a
                    public void a(long j, long j2) {
                        List<a> list;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (list = this.f27860a.f27856c) == null) {
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
                            List<a> list = this.f27860a.f27856c;
                            if (list != null) {
                                for (a aVar : list) {
                                    try {
                                        aVar.b(mVar);
                                    } catch (Throwable th) {
                                        o.a(th, "file loader onErrorResponse error", new Object[0]);
                                    }
                                }
                                this.f27860a.f27856c.clear();
                            }
                            this.f27860a.f27859f.f27847a.remove(this.f27860a.f27854a);
                        }
                    }

                    @Override // com.bytedance.sdk.component.adnet.core.m.a
                    public void a(m<File> mVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
                            List<a> list = this.f27860a.f27856c;
                            if (list != null) {
                                for (a aVar : list) {
                                    try {
                                        aVar.a(mVar);
                                    } catch (Throwable th) {
                                        o.a(th, "file loader onResponse error", new Object[0]);
                                    }
                                    try {
                                        aVar.a(this.f27860a.f27854a, mVar.f28031a);
                                    } catch (Throwable th2) {
                                        o.a(th2, "file loader putFile error", new Object[0]);
                                    }
                                }
                                this.f27860a.f27856c.clear();
                            }
                            this.f27860a.f27859f.f27847a.remove(this.f27860a.f27854a);
                        }
                    }
                });
                this.f27858e = cVar;
                cVar.setTag("FileLoader#" + this.f27854a);
                this.f27859f.f27849c.a(this.f27858e);
            }
        }
    }

    public void a(String str, a aVar, boolean z) {
        C0313b c0313b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (a(str) && (c0313b = this.f27847a.get(str)) != null) {
            c0313b.a(aVar);
            return;
        }
        File a2 = aVar.a(str);
        if (a2 != null && aVar != null) {
            this.f27848b.post(new Runnable(this, aVar, a2) { // from class: com.bytedance.sdk.component.adnet.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f27851a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ File f27852b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f27853c;

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
                    this.f27853c = this;
                    this.f27851a = aVar;
                    this.f27852b = a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27851a.a(this.f27852b.length(), this.f27852b.length());
                        this.f27851a.a(m.a(this.f27852b, (a.C0316a) null));
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
        this.f27847a.put(c0313b.f27854a, c0313b);
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) ? this.f27847a.containsKey(str) : invokeL.booleanValue;
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            File file = new File(com.bytedance.sdk.component.adnet.a.b(this.f27850d), "fileLoader");
            file.mkdirs();
            return file.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }
}
