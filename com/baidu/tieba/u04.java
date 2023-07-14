package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g04 a;
    public Context b;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m04 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ u04 c;

        /* renamed from: com.baidu.tieba.u04$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0493a extends ResponseCallback<e04> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                }
            }

            /* renamed from: com.baidu.tieba.u04$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0494a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e04 a;
                public final /* synthetic */ C0493a b;

                public RunnableC0494a(C0493a c0493a, e04 e04Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0493a, e04Var};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0493a;
                    this.a = e04Var;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.c.a != null) {
                        this.b.a.c.a.h(this.a);
                    }
                }
            }

            public C0493a(a aVar) {
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
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(e04 e04Var, int i) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLI(1048576, this, e04Var, i) != null) || e04Var == null) {
                    return;
                }
                k14.c(new RunnableC0494a(this, e04Var));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public e04 parseResponse(Response response, int i) {
                InterceptResult invokeLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                    if (response == null || response.body() == null || !response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            return new e04(string);
                        }
                    } catch (Exception | OutOfMemoryError e) {
                        e.printStackTrace();
                    }
                    return null;
                }
                return (e04) invokeLI.objValue;
            }
        }

        public a(u04 u04Var, m04 m04Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u04Var, m04Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u04Var;
            this.a = m04Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                C0493a c0493a = new C0493a(this);
                if (NetworkUtils.f(this.c.b)) {
                    this.a.b("https://afdconf.baidu.com/afd/download", this.b, c0493a);
                }
            }
        }
    }

    public u04(Context context) {
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
        this.b = context;
    }

    public void d(g04 g04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g04Var) == null) {
            this.a = g04Var;
        }
    }

    public void c(m04 m04Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, m04Var, jSONObject) == null) {
            j14.d(new a(this, m04Var, jSONObject), "AdLandingDownloadRequest");
        }
    }
}
