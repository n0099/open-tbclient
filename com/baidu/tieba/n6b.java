package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.ExperimentalUrlRequest;
import com.baidu.turbonet.net.RequestFinishedInfo;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UrlRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class n6b extends ExperimentalUrlRequest.Builder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String B = "n6b";
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public final p5b a;
    public final String b;
    public final UrlRequest.Callback c;
    public final Executor d;
    public String e;
    public final ArrayList<Pair<String, String>> f;
    public boolean g;
    public boolean h;
    public int i;
    public Collection<Object> j;
    public UploadDataProvider k;
    public Executor l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public int q;
    public RequestFinishedInfo.Listener r;
    public int s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public Object y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947955823, "Lcom/baidu/tieba/n6b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947955823, "Lcom/baidu/tieba/n6b;");
        }
    }

    public n6b(String str, UrlRequest.Callback callback, Executor executor, p5b p5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, callback, executor, p5bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new ArrayList<>();
        this.i = 3;
        this.s = 0;
        if (str != null) {
            if (callback != null) {
                if (executor != null) {
                    if (p5bVar != null) {
                        this.b = str;
                        this.c = callback;
                        this.d = executor;
                        this.a = p5bVar;
                        this.t = false;
                        this.u = 0;
                        this.v = 0;
                        this.w = 0;
                        this.x = 0;
                        this.y = null;
                        this.z = null;
                        this.A = null;
                        return;
                    }
                    throw new NullPointerException("TurbonetEngine is required.");
                }
                throw new NullPointerException("Executor is required.");
            }
            throw new NullPointerException("Callback is required.");
        }
        throw new NullPointerException("URL is required.");
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder a(String str, String str2) {
        n(str, str2);
        return this;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder m(UploadDataProvider uploadDataProvider, Executor executor) {
        y(uploadDataProvider, executor);
        return this;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder c() {
        p();
        return this;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder d() {
        q();
        return this;
    }

    public n6b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.g = true;
            return this;
        }
        return (n6b) invokeV.objValue;
    }

    public n6b q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.t = true;
            return this;
        }
        return (n6b) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder e(String str) {
        r(str);
        return this;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public ExperimentalUrlRequest.Builder f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str != null) {
                this.e = str;
                return this;
            }
            throw new NullPointerException("Method is required.");
        }
        return (ExperimentalUrlRequest.Builder) invokeL.objValue;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder g(String str) {
        s(str);
        return this;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder h(int i) {
        t(i);
        return this;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder i(int i) {
        u(i);
        return this;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder j(int i) {
        v(i);
        return this;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder k(int i) {
        w(i);
        return this;
    }

    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder l(int i) {
        x(i);
        return this;
    }

    public n6b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.z = str;
            return this;
        }
        return (n6b) invokeL.objValue;
    }

    public n6b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.A = str;
            return this;
        }
        return (n6b) invokeL.objValue;
    }

    public n6b t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            this.w = i;
            return this;
        }
        return (n6b) invokeI.objValue;
    }

    public n6b u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            this.v = i;
            return this;
        }
        return (n6b) invokeI.objValue;
    }

    public n6b v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            this.u = i;
            return this;
        }
        return (n6b) invokeI.objValue;
    }

    public n6b w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            this.n = true;
            this.o = i;
            return this;
        }
        return (n6b) invokeI.objValue;
    }

    public n6b x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            this.p = true;
            this.q = i;
            return this;
        }
        return (n6b) invokeI.objValue;
    }

    public n6b n(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            if (str != null) {
                if (str2 != null) {
                    if ("Accept-Encoding".equalsIgnoreCase(str)) {
                        Log.w(B, "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
                        return this;
                    }
                    this.f.add(Pair.create(str, str2));
                    return this;
                }
                throw new NullPointerException("Invalid header value.");
            }
            throw new NullPointerException("Invalid header name.");
        }
        return (n6b) invokeLL.objValue;
    }

    public n6b y(UploadDataProvider uploadDataProvider, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, uploadDataProvider, executor)) == null) {
            if (uploadDataProvider != null) {
                if (executor != null) {
                    if (this.e == null) {
                        this.e = "POST";
                    }
                    this.k = uploadDataProvider;
                    this.l = executor;
                    return this;
                }
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        return (n6b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.turbonet.net.ExperimentalUrlRequest.Builder
    /* renamed from: o */
    public m6b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            m6b g = this.a.g(this.b, this.c, this.d, this.i, this.j, this.g, this.h, this.m, this.n, this.o, this.p, this.q, this.r, this.s);
            String str = this.e;
            if (str != null) {
                g.p(str);
            }
            Iterator<Pair<String, String>> it = this.f.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                g.n((String) next.first, (String) next.second);
            }
            UploadDataProvider uploadDataProvider = this.k;
            if (uploadDataProvider != null) {
                g.q(uploadDataProvider, this.l);
            }
            if (this.t) {
                g.b();
            }
            int i = this.u;
            if (i > 0) {
                g.l(i);
            }
            int i2 = this.v;
            if (i2 > 0) {
                g.j(i2);
            }
            int i3 = this.w;
            if (i3 > 0) {
                g.i(i3);
            }
            int i4 = this.x;
            if (i4 > 0) {
                g.h(i4);
            }
            Object obj = this.y;
            if (obj != null) {
                g.k(obj);
            }
            if (!TextUtils.isEmpty(this.z)) {
                g.f(this.z);
            }
            if (!TextUtils.isEmpty(this.A)) {
                g.g(this.A);
            }
            return g;
        }
        return (m6b) invokeV.objValue;
    }
}
