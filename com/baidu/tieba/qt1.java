package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qt1 extends pt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;
    public String g;

    @Override // com.baidu.tieba.pr1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "RequestSubscribeFormIdApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m33 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ SubscribeHelper d;
        public final /* synthetic */ qt1 e;

        /* loaded from: classes5.dex */
        public class a implements SubscribeHelper.k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
            public void a(int i, String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                    if (jSONObject == null) {
                        b bVar = this.a;
                        bVar.e.d(bVar.c, new mv1(i, str));
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    b bVar2 = this.a;
                    bVar2.e.D(jSONObject, jSONObject2, bVar2.d);
                    b bVar3 = this.a;
                    bVar3.e.d(bVar3.c, new mv1(i, str, jSONObject2));
                }
            }
        }

        public b(qt1 qt1Var, m33 m33Var, String str, String str2, SubscribeHelper subscribeHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qt1Var, m33Var, str, str2, subscribeHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qt1Var;
            this.a = m33Var;
            this.b = str;
            this.c = str2;
            this.d = subscribeHelper;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (k83.h(p83Var)) {
                    this.d.o(this.b, new a(this));
                } else {
                    this.e.C(this.a, this.b, this.c, this.d);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qt1 a;

        public a(qt1 qt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qt1Var;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeILL(1048576, this, i, str, jSONObject) != null) {
                return;
            }
            this.a.f = i;
            this.a.g = str;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ SubscribeHelper b;
        public final /* synthetic */ qt1 c;

        public c(qt1 qt1Var, String str, SubscribeHelper subscribeHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qt1Var, str, subscribeHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qt1Var;
            this.a = str;
            this.b = subscribeHelper;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                if (jSONObject == null) {
                    this.c.d(this.a, new mv1(i, str));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                this.c.D(jSONObject, jSONObject2, this.b);
                this.c.d(this.a, new mv1(i, str, jSONObject2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qt1(nr1 nr1Var) {
        super(nr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void B(m33 m33Var, String str, String str2, SubscribeHelper subscribeHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, m33Var, str, str2, subscribeHelper) == null) {
            m33Var.e0().g(getContext(), "mapp_request_subscribe_message", new b(this, m33Var, str, str2, subscribeHelper));
        }
    }

    public final void C(m33 m33Var, String str, String str2, SubscribeHelper subscribeHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m33Var, str, str2, subscribeHelper) == null) {
            if (TextUtils.equals(gh3.n().e(), eh3.g(m33Var.W().e0())) && TextUtils.equals("1", m33Var.W().i0())) {
                subscribeHelper.o(str, new c(this, str2, subscribeHelper));
            } else {
                d(str2, new mv1(500107, "不符合使用条件"));
            }
        }
    }

    public final void D(JSONObject jSONObject, JSONObject jSONObject2, SubscribeHelper subscribeHelper) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, jSONObject2, subscribeHelper) == null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("list")) == null) {
                    return;
                }
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null && (optJSONArray2 = optJSONObject2.optJSONArray("sub_info")) != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                jSONObject2.put(optJSONObject3.optString("template_id"), optJSONObject3.optString("formid"));
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                p("#parseDate put json data error", e, false);
            }
        }
    }

    public mv1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#requestSubscribeFormId params=" + str, false);
            m33 b0 = m33.b0();
            if (b0 == null) {
                return new mv1(202, "swan app is null");
            }
            String O = b0.O();
            if (TextUtils.isEmpty(O)) {
                return new mv1(202, "appKey is empty");
            }
            Pair s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((mv1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new mv1(202, "cb is invalid");
                }
                SubscribeHelper subscribeHelper = new SubscribeHelper();
                if (!subscribeHelper.n(getContext(), b0, O, jSONObject, SubscribeHelper.invokeSubscribeFrom.REQUEST_SUBSCRIBE_FORM_ID_API, new a(this))) {
                    return new mv1(this.f, this.g);
                }
                B(b0, O, optString, subscribeHelper);
                return mv1.f();
            }
            return new mv1(202);
        }
        return (mv1) invokeL.objValue;
    }
}
