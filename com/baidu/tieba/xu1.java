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
/* loaded from: classes9.dex */
public class xu1 extends ou1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Favorite" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FollowStatusApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k63 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ xu1 d;

        public a(xu1 xu1Var, k63 k63Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu1Var, k63Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xu1Var;
            this.a = k63Var;
            this.b = jSONObject;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String P = this.a.P();
                try {
                    JSONObject jSONObject = this.b;
                    if (id2.n(P)) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    jSONObject.put("isFavor", str);
                } catch (JSONException unused) {
                    k32.c("FollowStatusApi", "json put data fail");
                }
                this.d.d(this.c, new ly1(0, this.b));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xu1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ly1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                k32.c("FollowStatusApi", "swan app is null");
                return new ly1(1001, "swan app is null");
            } else if (c0.w() == null) {
                k32.c("FollowStatusApi", "swan activity is null");
                return new ly1(1001, "swan activity is null");
            } else {
                Pair<ly1, JSONObject> t = t(str);
                ly1 ly1Var = (ly1) t.first;
                if (!ly1Var.isSuccess()) {
                    k32.c("FollowStatusApi", "json str parse fail");
                    return ly1Var;
                }
                String optString = ((JSONObject) t.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    k32.c("FollowStatusApi", "cb is empty");
                    return new ly1(202, "cb is empty");
                }
                if (c0.N().e(rp2.c())) {
                    SwanFavorDataManager.h().d();
                }
                ej3.k(new a(this, c0, new JSONObject(), optString), "getFavorStatus");
                return new ly1(0);
            }
        }
        return (ly1) invokeL.objValue;
    }
}
