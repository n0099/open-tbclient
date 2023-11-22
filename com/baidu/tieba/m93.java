package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tieba.ku1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m93 extends gx1 {
    public static /* synthetic */ Interceptable $ic;
    public static md2 f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "PreloadPackageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements ku1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m93 a;

        /* renamed from: com.baidu.tieba.m93$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0378a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.m93$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0379a implements vd4 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ RunnableC0378a b;

                public C0379a(RunnableC0378a runnableC0378a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0378a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = runnableC0378a;
                    this.a = str;
                }

                @Override // com.baidu.tieba.vd4
                public void a(@Nullable Map<String, String> map) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                        if (map == null) {
                            g32.c("PreloadPackageApi", "preloadPackage keyMap null");
                            return;
                        }
                        RunnableC0378a runnableC0378a = this.b;
                        runnableC0378a.d.a.A(map.get(this.b.b), this.a, runnableC0378a.c);
                    }
                }

                @Override // com.baidu.tieba.vd4
                public void onFail(Exception exc) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                        g32.c("PreloadPackageApi", "preloadPackage transform openBundleId fail");
                    }
                }
            }

            public RunnableC0378a(a aVar, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = jSONObject;
                this.b = str;
                this.c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean g = vi4.e().g(!ak3.G());
                    String optString = this.a.optString(PrefetchEvent.EVENT_KEY_PAGE_URL);
                    if (g) {
                        qd4.e(Collections.singletonList(this.b), m93.f.c(), new C0379a(this, optString));
                    } else {
                        this.d.a.A(this.b, optString, this.c);
                    }
                }
            }
        }

        public a(m93 m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m93Var;
        }

        @Override // com.baidu.tieba.ku1.a
        public hy1 a(g63 g63Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, g63Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("appKey");
                if (TextUtils.isEmpty(optString)) {
                    return new hy1(202, "appKey must not empty");
                }
                if (!m93.f.a(1)) {
                    return new hy1(402, "over single max limit");
                }
                aj3.h().execute(new RunnableC0378a(this, jSONObject, optString, str), "PreloadPackageApi");
                return hy1.f();
            }
            return (hy1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                String string = bundle.getString("appKey");
                String f1 = er2.f1(string, bundle.getString(PrefetchEvent.EVENT_KEY_PAGE_URL), 0, null);
                PrefetchEvent.b bVar = new PrefetchEvent.b();
                bVar.e("show");
                bVar.d(f1);
                bVar.c("10");
                bVar.a(string);
                fa2.g().f(bVar.b());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m93(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("appKey", str);
            bundle.putString(PrefetchEvent.EVENT_KEY_PAGE_URL, str2);
            t23.b(b.class, bundle);
        }
    }

    public hy1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#preloadPackage", false);
            String a2 = jy1.a(f63.K().getAppId());
            if (TextUtils.isEmpty(a2)) {
                return new hy1(101, "runtime parameter error");
            }
            md2 md2Var = f;
            if (md2Var == null || !md2Var.d(a2)) {
                f = new md2(a2, si4.b(a2));
            }
            if (f.e()) {
                return new hy1(402, "over max limit");
            }
            if (!f.b()) {
                return new hy1(402, "over time interval limit");
            }
            return m(str, false, new a(this));
        }
        return (hy1) invokeL.objValue;
    }
}
