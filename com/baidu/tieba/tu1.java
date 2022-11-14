package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class tu1 extends lu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PhoneCallApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tu1(@NonNull gs1 gs1Var) {
        super(gs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public fw1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#makePhoneCall", false);
            if (n()) {
                f12.c("PhoneCallApi", "PhoneCallApi does not supported when app is invisible.");
                return new fw1(1001, "PhoneCallApi does not supported when app is invisible.");
            }
            Intent intent = new Intent("android.intent.action.DIAL");
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject != null) {
                String optString = jSONObject.optString("phoneNumber");
                if (!TextUtils.isEmpty(optString)) {
                    intent.setData(Uri.fromParts("tel", optString, null));
                }
            }
            if (og3.g(getContext(), intent)) {
                return fw1.f();
            }
            return new fw1(1001);
        }
        return (fw1) invokeL.objValue;
    }
}
