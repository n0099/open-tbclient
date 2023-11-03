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
public class p72 extends h72<JSONObject, hy1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p72() {
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
    @Override // com.baidu.tieba.l72
    @NonNull
    /* renamed from: c */
    public hy1 a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new hy1(202);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return new hy1(202, "data is required");
            }
            String optString = optJSONObject.optString("status");
            if (TextUtils.isEmpty(optString)) {
                return new hy1(202, "status is required");
            }
            char c = 65535;
            int hashCode = optString.hashCode();
            if (hashCode != 48) {
                if (hashCode == 49 && optString.equals("1")) {
                    c = 0;
                }
            } else if (optString.equals("0")) {
                c = 1;
            }
            if (c != 0) {
                if (c != 1) {
                    return new hy1(202, "status value is invalid");
                }
                new f72().d();
            }
            return new hy1(0);
        }
        return (hy1) invokeL.objValue;
    }
}
