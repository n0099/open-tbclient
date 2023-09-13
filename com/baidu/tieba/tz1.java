package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tz1 extends kz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Favorite" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FollowStatusApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb3 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ tz1 d;

        public a(tz1 tz1Var, hb3 hb3Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz1Var, hb3Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = tz1Var;
            this.a = hb3Var;
            this.b = jSONObject;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String O = this.a.O();
                try {
                    JSONObject jSONObject = this.b;
                    if (fi2.n(O)) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    jSONObject.put("isFavor", str);
                } catch (JSONException unused) {
                    h82.c("FollowStatusApi", "json put data fail");
                }
                this.d.d(this.c, new h32(0, this.b));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tz1(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public h32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                h82.c("FollowStatusApi", "swan app is null");
                return new h32(1001, "swan app is null");
            } else if (b0.w() == null) {
                h82.c("FollowStatusApi", "swan activity is null");
                return new h32(1001, "swan activity is null");
            } else {
                Pair<h32, JSONObject> s = s(str);
                h32 h32Var = (h32) s.first;
                if (!h32Var.isSuccess()) {
                    h82.c("FollowStatusApi", "json str parse fail");
                    return h32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    h82.c("FollowStatusApi", "cb is empty");
                    return new h32(202, "cb is empty");
                }
                if (b0.N().e(ou2.c())) {
                    SwanFavorDataManager.h().d();
                }
                bo3.k(new a(this, b0, new JSONObject(), optString), "getFavorStatus");
                return new h32(0);
            }
        }
        return (h32) invokeL.objValue;
    }
}
