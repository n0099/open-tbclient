package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.tieba.dr0;
import com.baidu.tieba.pq0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes5.dex */
public class nr0 extends pq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;
    public uq0 b;

    /* loaded from: classes5.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq0.a a;
        public final /* synthetic */ boolean b;

        /* renamed from: com.baidu.tieba.nr0$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0357a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IOException a;
            public final /* synthetic */ a b;

            public RunnableC0357a(a aVar, IOException iOException) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, iOException};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.a(this.a, 502);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public b(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.a(new Exception("body is null!"), this.a);
                }
            }
        }

        public a(nr0 nr0Var, pq0.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nr0Var, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                wi0.b(new RunnableC0357a(this, iOException));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                Headers.a aVar = new Headers.a();
                int code = response.code();
                ResponseBody body = response.body();
                if (body != null) {
                    for (Map.Entry<String, List<String>> entry : response.headers().toMultimap().entrySet()) {
                        List<String> value = entry.getValue();
                        if (value != null && value.size() > 0) {
                            aVar.a(entry.getKey(), value.get(0));
                        }
                    }
                    if (this.b) {
                        try {
                            try {
                                this.a.c(aVar.c(), body.string(), code);
                                return;
                            } catch (Throwable th) {
                                this.a.a(new Exception(th), 611);
                                return;
                            }
                        } catch (Throwable th2) {
                            this.a.a(new Exception(th2), 610);
                            return;
                        }
                    }
                    try {
                        this.a.b(aVar.c(), body.byteStream(), code);
                    } finally {
                        try {
                            return;
                        } finally {
                        }
                    }
                    return;
                }
                wi0.b(new b(this, code));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pq0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hr0 a;
        public final /* synthetic */ pr0 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Headers a;
            public final /* synthetic */ Object b;
            public final /* synthetic */ int c;
            public final /* synthetic */ b d;

            public a(b bVar, Headers headers, Object obj, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, headers, obj, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = bVar;
                this.a = headers;
                this.b = obj;
                this.c = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.d.a.b(this.a, this.b, this.c);
                }
            }
        }

        /* renamed from: com.baidu.tieba.nr0$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0358b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Exception a;
            public final /* synthetic */ int b;
            public final /* synthetic */ b c;

            public RunnableC0358b(b bVar, Exception exc, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, exc, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = exc;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.a.a(this.a, this.b);
                }
            }
        }

        public b(nr0 nr0Var, hr0 hr0Var, pr0 pr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nr0Var, hr0Var, pr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hr0Var;
            this.b = pr0Var;
        }

        @Override // com.baidu.tieba.pq0.a
        public void a(Exception exc, int i) {
            hr0 hr0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && (hr0Var = this.a) != null) {
                if (this.b.g) {
                    wi0.b(new RunnableC0358b(this, exc, i));
                } else {
                    hr0Var.a(exc, i);
                }
            }
        }

        @Override // com.baidu.tieba.pq0.a
        public void b(Headers headers, InputStream inputStream, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                throw new IllegalStateException("走错路了");
            }
        }

        @Override // com.baidu.tieba.pq0.a
        public void c(Headers headers, String str, int i) throws Exception {
            hr0 hr0Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i) != null) || (hr0Var = this.a) == null) {
                return;
            }
            Object d = hr0Var.d(headers, str, i);
            if (this.b.g) {
                wi0.b(new a(this, headers, d, i));
            } else {
                this.a.b(headers, d, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements pq0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gr0 a;

        public c(nr0 nr0Var, gr0 gr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nr0Var, gr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gr0Var;
        }

        @Override // com.baidu.tieba.pq0.a
        public void a(Exception exc, int i) {
            gr0 gr0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && (gr0Var = this.a) != null) {
                gr0Var.a(exc, i);
            }
        }

        @Override // com.baidu.tieba.pq0.a
        public void b(Headers headers, InputStream inputStream, int i) throws Exception {
            gr0 gr0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) && (gr0Var = this.a) != null) {
                gr0Var.c(headers, inputStream, i);
            }
        }

        @Override // com.baidu.tieba.pq0.a
        public void c(Headers headers, String str, int i) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i) == null) {
                throw new IllegalStateException("走错路了");
            }
        }
    }

    public nr0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
    }

    @Override // com.baidu.tieba.ar0
    public <T> void a(@NonNull pr0 pr0Var, @Nullable hr0<T> hr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, pr0Var, hr0Var) == null) {
            d(pr0Var, true, new b(this, hr0Var, pr0Var));
        }
    }

    @Override // com.baidu.tieba.ar0
    public void b(@NonNull pr0 pr0Var, @Nullable gr0 gr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pr0Var, gr0Var) == null) {
            d(pr0Var, false, new c(this, gr0Var));
        }
    }

    public final OkHttpClient c(@NonNull pr0 pr0Var) {
        InterceptResult invokeL;
        OkHttpClient.Builder newBuilder;
        uq0 uq0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pr0Var)) == null) {
            if (this.a != null && (uq0Var = this.b) != null && uq0Var.equals(pr0Var.f)) {
                return this.a;
            }
            this.b = pr0Var.f;
            OkHttpClient okHttpClient = this.a;
            if (okHttpClient == null) {
                newBuilder = new OkHttpClient.Builder();
            } else {
                newBuilder = okHttpClient.newBuilder();
            }
            newBuilder.dns(dr0.a.a());
            int i = this.b.b;
            if (i > 0) {
                newBuilder.readTimeout(i, TimeUnit.MILLISECONDS);
            }
            int i2 = this.b.c;
            if (i2 > 0) {
                newBuilder.writeTimeout(i2, TimeUnit.MILLISECONDS);
            }
            int i3 = this.b.a;
            if (i3 > 0) {
                newBuilder.connectTimeout(i3, TimeUnit.MILLISECONDS);
            }
            if (this.b.d != null) {
                newBuilder.cookieJar(new jr0(this.b.d));
            }
            return newBuilder.build();
        }
        return (OkHttpClient) invokeL.objValue;
    }

    public final void d(@NonNull pr0 pr0Var, boolean z, @NonNull pq0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{pr0Var, Boolean.valueOf(z), aVar}) == null) {
            RequestError b2 = pr0Var.b();
            if (b2 != null) {
                aVar.a(b2, 1001);
                return;
            }
            this.a = c(pr0Var);
            try {
                this.a.newCall(qr0.a(pr0Var).build()).enqueue(new a(this, aVar, z));
            } catch (RequestError e) {
                aVar.a(e, 1001);
            }
        }
    }
}
