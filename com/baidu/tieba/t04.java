package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.w04;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
/* loaded from: classes8.dex */
public class t04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public h04 b;
    public boolean c;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y04 a;
        public final /* synthetic */ m04 b;
        public final /* synthetic */ t04 c;

        /* renamed from: com.baidu.tieba.t04$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0481a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public final /* synthetic */ a b;

            /* renamed from: com.baidu.tieba.t04$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0482a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdElementInfo a;
                public final /* synthetic */ C0481a b;

                public RunnableC0482a(C0481a c0481a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0481a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0481a;
                    this.a = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.b.c.b != null) {
                        this.b.b.c.b.c(this.a);
                    }
                }
            }

            public C0481a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
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
                this.a = 0;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) != null) {
                    return;
                }
                this.b.c.g("3010002");
                a aVar = this.b;
                aVar.c.j(aVar.a, "requestFail", aVar.b);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i) == null) {
                    a aVar = this.b;
                    aVar.c.j(aVar.a, "requestSuccess", aVar.b);
                    if (adResponseInfo != null) {
                        if (adResponseInfo.getAdInstanceList().size() > 0) {
                            k14.c(new RunnableC0482a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
                            return;
                        }
                        if (!this.b.c.c) {
                            a aVar2 = this.b;
                            aVar2.c.j(aVar2.a, "requestNoAd", aVar2.b);
                        }
                        if (this.a == 1 && this.b.a.i.c() == "video" && p14.h()) {
                            a aVar3 = this.b;
                            aVar3.c.h(aVar3.b, aVar3.a, this);
                            return;
                        }
                        this.a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.b.c.g(errorCode);
                        return;
                    }
                    this.b.c.g("200000");
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public AdResponseInfo parseResponse(Response response, int i) {
                InterceptResult invokeLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                    if (response != null && response.body() != null) {
                        this.a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.b.c.c) {
                                    return new AdResponseInfo(string, this.b.c.c);
                                }
                                return new AdResponseInfo(string);
                            }
                        } catch (Exception | OutOfMemoryError unused) {
                        }
                    }
                    return null;
                }
                return (AdResponseInfo) invokeLI.objValue;
            }
        }

        public a(t04 t04Var, y04 y04Var, m04 m04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t04Var, y04Var, m04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t04Var;
            this.a = y04Var;
            this.b = m04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            y04 y04Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (y04Var = this.a) != null && y04Var.i != null) {
                C0481a c0481a = new C0481a(this);
                if (NetworkUtils.f(this.c.a)) {
                    if (this.c.c) {
                        y04 y04Var2 = this.a;
                        if (y04Var2 instanceof z04) {
                            z04 z04Var = (z04) y04Var2;
                            if (this.b != null && z04Var.i() != null) {
                                this.b.a(z04Var.g(), z04Var.i(), c0481a);
                                return;
                            }
                            return;
                        }
                    }
                    this.c.c = false;
                    String g = this.a.g();
                    m04 m04Var = this.b;
                    if (m04Var != null) {
                        m04Var.f(g, c0481a);
                    }
                    this.c.j(this.a, "request", this.b);
                    return;
                }
                this.c.g("3010003");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ t04 b;

        public b(t04 t04Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t04Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t04Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.b != null) {
                this.b.b.a(this.a);
            }
        }
    }

    public t04(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            k14.c(new b(this, str));
        }
    }

    public void k(h04 h04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h04Var) == null) {
            this.b = h04Var;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t04(Context context, boolean z) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = z;
    }

    public void i(y04 y04Var, m04 m04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, y04Var, m04Var) == null) {
            j14.d(new a(this, y04Var, m04Var), "execAdRequest");
        }
    }

    public void h(m04 m04Var, y04 y04Var, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m04Var, y04Var, responseCallback) == null) {
            if (NetworkUtils.f(this.a)) {
                this.c = true;
                if (y04Var instanceof z04) {
                    z04 z04Var = (z04) y04Var;
                    if (m04Var != null && z04Var.i() != null) {
                        m04Var.a(z04Var.g(), z04Var.i(), responseCallback);
                        return;
                    }
                    return;
                }
                w04.b bVar = new w04.b();
                bVar.m(p14.c());
                bVar.j(p14.d());
                bVar.o(y04Var.i.g());
                bVar.l(o14.i(this.a));
                bVar.i(o14.h(this.a));
                z04 z04Var2 = new z04(this.a, bVar.h(), 5, 5);
                if (m04Var != null && z04Var2.i() != null) {
                    m04Var.a(z04Var2.g(), z04Var2.i(), responseCallback);
                    return;
                }
                return;
            }
            g("3010003");
        }
    }

    public final void j(y04 y04Var, String str, m04 m04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, y04Var, str, m04Var) == null) {
            e14.n(str, e14.a(y04Var.i.c(), y04Var.i.f(), y04Var.i.e(), y04Var.i.b(), false), m04Var);
        }
    }
}
