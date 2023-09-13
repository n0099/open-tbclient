package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rc2 extends ic2<JSONObject, h32> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rc2() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mc2
    @NonNull
    /* renamed from: c */
    public h32 a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (b()) {
                if (ic2.a) {
                    h82.b("Api-HandleException", "has triggered fmp before remove skeleton");
                }
                return new h32(0);
            } else if (jSONObject == null) {
                return new h32(202);
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    return new h32(202, "data is required");
                }
                String optString = optJSONObject.optString("path");
                if (TextUtils.isEmpty(optString)) {
                    return new h32(202, "path is required");
                }
                gc2 gc2Var = new gc2();
                gc2Var.g(optString);
                gc2Var.e();
                return new h32(0);
            }
        }
        return (h32) invokeL.objValue;
    }
}
