package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class uu1 extends qu1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "OpenIdApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements dl3<nb3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ uu1 b;

        public a(uu1 uu1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uu1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<JSONObject> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                ly1 ly1Var = new ly1();
                String A = this.b.A(nb3Var);
                if (TextUtils.isEmpty(A)) {
                    ly1Var.b = 1001;
                    ly1Var.c = "openid is empty";
                    this.b.d(this.a, ly1Var);
                    return;
                }
                ly1Var.g("openid", A);
                ly1Var.b = 0;
                this.b.d(this.a, ly1Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223384, "Lcom/baidu/tieba/uu1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223384, "Lcom/baidu/tieba/uu1;");
                return;
            }
        }
        f = vm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uu1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final String A(nb3<JSONObject> nb3Var) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nb3Var)) == null) {
            if (nb3Var.c() && (jSONObject = nb3Var.a) != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                return optJSONObject.optString("openid");
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public ly1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#getOpenId", false);
            if (f) {
                Log.d("OpenIdApi", "#getOpenId params = " + str);
            }
            Pair<ly1, JSONObject> t = t(str);
            if (!((ly1) t.first).isSuccess()) {
                return (ly1) t.first;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new ly1(202, "cb is empty");
            }
            rb3 f2 = j63.K().x().a().b().f(j63.K());
            f2.p(new a(this, optString));
            f2.a();
            return ly1.f();
        }
        return (ly1) invokeL.objValue;
    }
}
