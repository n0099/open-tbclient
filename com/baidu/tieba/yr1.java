package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.la3;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.client.methods.HttpDelete;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class yr1 extends kz1 {
    public static /* synthetic */ Interceptable $ic;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "Bookshelf" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "SwanAppBookshelfApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ tc2 b;
        public final /* synthetic */ yr1 c;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    za3.a();
                }
            }
        }

        /* renamed from: com.baidu.tieba.yr1$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0533b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0533b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    za3.f(ou2.c(), R.string.obfuscated_res_0x7f0f14f6).G();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    za3.a();
                }
            }
        }

        public b(yr1 yr1Var, boolean z, tc2 tc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, Boolean.valueOf(z), tc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yr1Var;
            this.a = z;
            this.b = tc2Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.a) {
                    bp3.e0(new c(this));
                }
                yr1 yr1Var = this.c;
                tc2 tc2Var = this.b;
                yr1Var.N(tc2Var, 1001, "operation fail, msg = " + exc.getMessage(), this.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (this.a) {
                    bp3.e0(new a(this));
                }
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        if (this.a) {
                            bp3.e0(new RunnableC0533b(this));
                        }
                        this.c.N(this.b, optInt, jSONObject.optString("errmsg"), false);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        this.c.O(this.b, optJSONObject, this.a);
                        return;
                    } else {
                        this.c.N(this.b, 0, jSONObject.optString("errmsg"), this.a);
                        return;
                    }
                }
                this.c.N(this.b, 1001, "server response fail", this.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response != null && response.body() != null) {
                    return ho3.d(response.body().string());
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ yr1 d;

        /* loaded from: classes8.dex */
        public class a implements tc2<h32> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.tc2
            /* renamed from: b */
            public void a(h32 h32Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h32Var) == null) {
                    f fVar = this.a;
                    fVar.d.d(fVar.c, h32Var);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    za3.f(this.a.d.getContext(), R.string.obfuscated_res_0x7f0f14f4).G();
                }
            }
        }

        public f(yr1 yr1Var, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yr1Var;
            this.a = jSONArray;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (fg3.h(kg3Var)) {
                    int type = gb3.K().q().W().getType();
                    String v1 = gb3.K().q().W().v1();
                    String O = gb3.K().q().O();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", O);
                    hashMap.put("contentIds", this.a);
                    hashMap.put("category", this.b);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", v1);
                    this.d.W("INSERT", hashMap, new a(this));
                    return;
                }
                this.d.d(this.c, new h32(kg3Var.b(), fg3.f(kg3Var.b())));
                bp3.e0(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ yr1 d;

        /* loaded from: classes8.dex */
        public class a implements tc2<h32> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.tc2
            /* renamed from: b */
            public void a(h32 h32Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h32Var) == null) {
                    g gVar = this.a;
                    gVar.d.d(gVar.c, h32Var);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    za3.f(this.a.d.getContext(), R.string.obfuscated_res_0x7f0f14f4).G();
                }
            }
        }

        public g(yr1 yr1Var, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yr1Var;
            this.a = jSONArray;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (fg3.h(kg3Var)) {
                    int type = gb3.K().q().W().getType();
                    String v1 = gb3.K().q().W().v1();
                    String O = gb3.K().q().O();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", O);
                    hashMap.put("contentIds", this.a);
                    hashMap.put("category", this.b);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", v1);
                    this.d.W(HttpDelete.METHOD_NAME, hashMap, new a(this));
                    return;
                }
                this.d.d(this.c, new h32(kg3Var.b(), fg3.f(kg3Var.b())));
                bp3.e0(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ yr1 e;

        /* loaded from: classes8.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    gb3.K().q().e0().E();
                }
            }
        }

        public l(yr1 yr1Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yr1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                la3.a aVar = new la3.a(this.e.getContext());
                aVar.V(this.a);
                aVar.x(this.b);
                aVar.y();
                aVar.n(new pq3());
                aVar.m(false);
                aVar.P(this.c, new b(this));
                aVar.C(this.d, new a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr1 a;

        public a(yr1 yr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                za3 f = za3.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f14f5);
                f.l(10);
                f.s(false);
                f.z();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public c(yr1 yr1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                za3.g(ou2.c(), this.a).G();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr1 a;

        public d(yr1 yr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                za3.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f01cd).G();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr1 a;

        public e(yr1 yr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                za3.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f01cd).G();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements tc2<h32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yr1 b;

        public h(yr1 yr1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yr1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tc2
        /* renamed from: b */
        public void a(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h32Var) == null) {
                this.b.d(this.a, h32Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements tc2<h32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yr1 b;

        public i(yr1 yr1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yr1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tc2
        /* renamed from: b */
        public void a(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h32Var) == null) {
                this.b.d(this.a, h32Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements tr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ yr1 c;

        public j(yr1 yr1Var, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yr1Var;
            this.a = z;
            this.b = str;
        }

        @Override // com.baidu.tieba.tr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (!this.a) {
                        ai3.S("fail", 10, "api");
                    }
                    this.c.d(this.b, new h32(1001, "user is not login"));
                    return;
                }
                if (!this.a) {
                    ai3.S("success", 10, "api");
                }
                this.c.S(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements CallbackHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yr1 b;

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public String getCurrentPageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        public k(yr1 yr1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yr1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public void handleSchemeDispatchCallback(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) != null) {
                return;
            }
            this.b.Q(str2, this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yr1(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            hb3 q = gb3.K().q();
            q.N().f(q.w(), null, new j(this, q.N().e(getContext()), str));
        }
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ou2.l0().d(new k(this, str));
        }
    }

    public final void I(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, jSONArray, str, str2) == null) {
            gb3.K().q().e0().g(getContext(), "scope_insert_bookshelf", new g(this, jSONArray, str, str2));
        }
    }

    public final void J(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, str2) == null) {
            gb3.K().q().e0().g(getContext(), "scope_insert_bookshelf", new f(this, jSONArray, str, str2));
        }
    }

    public final void O(tc2<h32> tc2Var, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, tc2Var, jSONObject, z) == null) {
            if (tc2Var != null && jSONObject != null) {
                tc2Var.a(new h32(0, jSONObject));
            }
            if (z) {
                ou2.l0().b(getContext());
            }
        }
    }

    public h32 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#deleteBookshelf", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (h32Var.isSuccess() && jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    String optString = jSONObject.optString("category");
                    if (TextUtils.isEmpty(optString)) {
                        return new h32(201, "category is invalid");
                    }
                    String optString2 = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        return new h32(202, "cb is invalid");
                    }
                    if (!SwanAppNetworkUtils.i(getContext())) {
                        bp3.e0(new e(this));
                        return new h32(1001, "network is not connected");
                    } else if (R()) {
                        M();
                        return new h32(10003, fg3.f(10003));
                    } else {
                        I(optJSONArray, optString, optString2);
                        return h32.f();
                    }
                }
                return new h32(201, "contentIds is invalid");
            }
            return h32Var;
        }
        return (h32) invokeL.objValue;
    }

    public h32 P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#insertBookshelf", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (h32Var.isSuccess() && jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    String optString = jSONObject.optString("category");
                    f = optString;
                    if (TextUtils.isEmpty(optString)) {
                        return new h32(201, "category is invalid");
                    }
                    String optString2 = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        return new h32(202, "cb is invalid");
                    }
                    if (!SwanAppNetworkUtils.i(getContext())) {
                        bp3.e0(new d(this));
                        return new h32(1001, "network is not connected");
                    } else if (R()) {
                        M();
                        return new h32(10003, fg3.f(10003));
                    } else {
                        J(optJSONArray, f, optString2);
                        return h32.f();
                    }
                }
                return new h32(201, "contentIds is invalid");
            }
            return h32Var;
        }
        return (h32) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String L(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            switch (str.hashCode()) {
                case -2130463047:
                    if (str.equals("INSERT")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 77406376:
                    if (str.equals("QUERY")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1020968928:
                    if (str.equals("UPDATE_READ_TIME")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2012838315:
                    if (str.equals(HttpDelete.METHOD_NAME)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return null;
                        }
                        return ou2.o().H();
                    }
                    return ou2.o().y();
                }
                return ou2.o().h();
            }
            return ou2.o().w();
        }
        return (String) invokeL.objValue;
    }

    public h32 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            q("#navigateToBookshelf", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (h32Var.isSuccess() && jSONObject != null) {
                f = jSONObject.optString("category");
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new h32(202, "cb is invalid");
                }
                if (!gb3.K().q().N().e(getContext())) {
                    ai3.S("show", 10, "api");
                    T(optString);
                    return h32.f();
                }
                S(optString);
                return h32.f();
            }
            return h32Var;
        }
        return (h32) invokeL.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bp3.e0(new l(this, getContext().getString(R.string.obfuscated_res_0x7f0f14f8), getContext().getString(R.string.obfuscated_res_0x7f0f14f7), getContext().getString(R.string.obfuscated_res_0x7f0f1592), getContext().getString(R.string.obfuscated_res_0x7f0f152e)));
        }
    }

    public final void N(tc2<h32> tc2Var, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{tc2Var, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (tc2Var != null) {
                tc2Var.a(new h32(i2, str));
            }
            if (z) {
                bp3.e0(new c(this, str));
            }
        }
    }

    public final void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            int i2 = 1001;
            if (TextUtils.isEmpty(str)) {
                d(str2, new h32(1001, "navigateToBookshelf fail"));
            }
            try {
                i2 = new JSONObject(str).optInt("status", 1001);
            } catch (JSONException e2) {
                p("json put data fail", e2, false);
            }
            if (i2 == 0) {
                d(str2, new h32(i2, "navigateToBookshelf success"));
            } else {
                d(str2, new h32(i2, "navigateToBookshelf fail"));
            }
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            hg3 hg3Var = f33.g(true).get("scope_insert_bookshelf");
            if (hg3Var == null) {
                return true;
            }
            if (hg3Var.j < 0 && !hg3Var.d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public h32 V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            q("#queryBookshelf", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (h32Var.isSuccess() && jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        return new h32(202, "cb is invalid");
                    }
                    if (!SwanAppNetworkUtils.i(getContext())) {
                        return new h32(1001, "network is not connected");
                    }
                    if (!gb3.K().q().N().e(getContext())) {
                        return new h32(1001, "user is not login");
                    }
                    Object O = gb3.K().q().O();
                    int type = gb3.K().q().W().getType();
                    Object v1 = gb3.K().q().W().v1();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("appKey", O);
                    hashMap.put("contentIds", optJSONArray);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", v1);
                    W("QUERY", hashMap, new h(this, optString));
                    return h32.f();
                }
                return new h32(201, "contentIds is invalid");
            }
            return h32Var;
        }
        return (h32) invokeL.objValue;
    }

    public h32 X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            q("#updateBookshelfReadTime", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (h32Var.isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("contentId");
                if (TextUtils.isEmpty(optString)) {
                    return new h32(201, "contentId is invalid");
                }
                String optString2 = jSONObject.optString("category");
                if (TextUtils.isEmpty(optString2)) {
                    return new h32(201, "category is invalid");
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    return new h32(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    return new h32(1001, "network is not connected");
                }
                if (!gb3.K().q().N().e(getContext())) {
                    return new h32(1001, "user is not login");
                }
                Object O = gb3.K().q().O();
                int type = gb3.K().q().W().getType();
                Object v1 = gb3.K().q().W().v1();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("appKey", O);
                hashMap.put("contentId", optString);
                hashMap.put("category", optString2);
                hashMap.put("pkg_type", Integer.valueOf(type));
                hashMap.put("version_code", v1);
                W("UPDATE_READ_TIME", hashMap, new i(this, optString3));
                return h32.f();
            }
            return h32Var;
        }
        return (h32) invokeL.objValue;
    }

    public final void W(String str, HashMap<String, Object> hashMap, tc2<h32> tc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, hashMap, tc2Var) == null) {
            boolean equals = TextUtils.equals(str, "INSERT");
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
            RequestBody create = RequestBody.create(o23.a, jSONObject.toString());
            String L = L(str);
            if (TextUtils.isEmpty(L)) {
                N(tc2Var, 1001, "operation fail, msg = url is null", equals);
                return;
            }
            if (equals) {
                bp3.e0(new a(this));
            }
            ki4 ki4Var = new ki4(L, create, new b(this, equals, tc2Var));
            if (li4.g().c()) {
                ki4Var.f = true;
            }
            ki4Var.g = true;
            li4.g().e(ki4Var);
        }
    }
}
