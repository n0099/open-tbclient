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
/* loaded from: classes5.dex */
public class og2 extends or1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements pg2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ og2 b;

        public /* synthetic */ b(og2 og2Var, String str, a aVar) {
            this(og2Var, str);
        }

        @Override // com.baidu.tieba.pg2
        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.b.d(this.a, jSONObject == null ? new lv1(0) : new lv1(0, jSONObject));
            }
        }

        @Override // com.baidu.tieba.pg2
        public void onFail(int i, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.b.d(this.a, str == null ? new lv1(i) : new lv1(i, str));
            }
        }

        public b(og2 og2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = og2Var;
            this.a = str;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements pg2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(og2 og2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pg2
        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            }
        }

        @Override // com.baidu.tieba.pg2
        public void onFail(int i, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }

        public /* synthetic */ c(og2 og2Var, a aVar) {
            this(og2Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public og2(@NonNull mr1 mr1Var) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "GameCenter" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "GameCenterApi" : (String) invokeV.objValue;
    }

    public lv1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#postGameCenterMessage", false);
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (!lv1Var.isSuccess()) {
                l02.c("GameCenterApi", "parse fail");
                return lv1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                l02.c("GameCenterApi", "empty cb");
                return new lv1(202, "empty cb");
            }
            return z(jSONObject, new b(this, optString, null));
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (!lv1Var.isSuccess()) {
                l02.c("GameCenterApi", "parse fail");
                return lv1Var;
            }
            return z((JSONObject) s.second, new c(this, null));
        }
        return (lv1) invokeL.objValue;
    }

    public final lv1 z(@NonNull JSONObject jSONObject, @NonNull pg2 pg2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, jSONObject, pg2Var)) == null) {
            String optString = jSONObject.optString("api");
            if (TextUtils.isEmpty(optString)) {
                return new lv1(202, "empty api name");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            lv1 a2 = sm2.v0().a(optString, optJSONObject, pg2Var);
            return a2 == null ? new lv1(0) : a2;
        }
        return (lv1) invokeLL.objValue;
    }
}
