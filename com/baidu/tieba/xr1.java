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
/* loaded from: classes6.dex */
public class xr1 extends or1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l33 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ xr1 d;

        public a(xr1 xr1Var, l33 l33Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr1Var, l33Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xr1Var;
            this.a = l33Var;
            this.b = jSONObject;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.b.put("isFavor", ja2.n(this.a.O()) ? "1" : "0");
                } catch (JSONException unused) {
                    l02.c("FollowStatusApi", "json put data fail");
                }
                this.d.d(this.c, new lv1(0, this.b));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xr1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.or1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Favorite" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FollowStatusApi" : (String) invokeV.objValue;
    }

    public lv1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            l33 b0 = l33.b0();
            if (b0 == null) {
                l02.c("FollowStatusApi", "swan app is null");
                return new lv1(1001, "swan app is null");
            } else if (b0.w() == null) {
                l02.c("FollowStatusApi", "swan activity is null");
                return new lv1(1001, "swan activity is null");
            } else {
                Pair<lv1, JSONObject> s = s(str);
                lv1 lv1Var = (lv1) s.first;
                if (!lv1Var.isSuccess()) {
                    l02.c("FollowStatusApi", "json str parse fail");
                    return lv1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    l02.c("FollowStatusApi", "cb is empty");
                    return new lv1(202, "cb is empty");
                }
                if (b0.N().e(sm2.c())) {
                    SwanFavorDataManager.h().d();
                }
                fg3.k(new a(this, b0, new JSONObject(), optString), "getFavorStatus");
                return new lv1(0);
            }
        }
        return (lv1) invokeL.objValue;
    }
}
