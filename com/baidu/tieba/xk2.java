package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xk2 extends xv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.xv1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "GameCenter" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "GameCenterApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements yk2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ xk2 b;

        public b(xk2 xk2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xk2Var;
            this.a = str;
        }

        public /* synthetic */ b(xk2 xk2Var, String str, a aVar) {
            this(xk2Var, str);
        }

        @Override // com.baidu.tieba.yk2
        public void a(@Nullable JSONObject jSONObject) {
            uz1 uz1Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    uz1Var = new uz1(0);
                } else {
                    uz1Var = new uz1(0, jSONObject);
                }
                this.b.d(this.a, uz1Var);
            }
        }

        @Override // com.baidu.tieba.yk2
        public void onFail(int i, @Nullable String str) {
            uz1 uz1Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if (str == null) {
                    uz1Var = new uz1(i);
                } else {
                    uz1Var = new uz1(i, str);
                }
                this.b.d(this.a, uz1Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements yk2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.yk2
        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            }
        }

        @Override // com.baidu.tieba.yk2
        public void onFail(int i, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }

        public c(xk2 xk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(xk2 xk2Var, a aVar) {
            this(xk2Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk2(@NonNull vv1 vv1Var) {
        super(vv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public uz1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Pair<uz1, JSONObject> s = s(str);
            uz1 uz1Var = (uz1) s.first;
            if (!uz1Var.isSuccess()) {
                u42.c("GameCenterApi", "parse fail");
                return uz1Var;
            }
            return z((JSONObject) s.second, new c(this, null));
        }
        return (uz1) invokeL.objValue;
    }

    public uz1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#postGameCenterMessage", false);
            Pair<uz1, JSONObject> s = s(str);
            uz1 uz1Var = (uz1) s.first;
            if (!uz1Var.isSuccess()) {
                u42.c("GameCenterApi", "parse fail");
                return uz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                u42.c("GameCenterApi", "empty cb");
                return new uz1(202, "empty cb");
            }
            return z(jSONObject, new b(this, optString, null));
        }
        return (uz1) invokeL.objValue;
    }

    public final uz1 z(@NonNull JSONObject jSONObject, @NonNull yk2 yk2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, jSONObject, yk2Var)) == null) {
            String optString = jSONObject.optString("api");
            if (TextUtils.isEmpty(optString)) {
                return new uz1(202, "empty api name");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            uz1 a2 = br2.v0().a(optString, optJSONObject, yk2Var);
            if (a2 == null) {
                return new uz1(0);
            }
            return a2;
        }
        return (uz1) invokeLL.objValue;
    }
}
