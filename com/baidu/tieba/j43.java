package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j43 extends i53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j43(i43 i43Var) {
        super(i43Var, "/swanAPI/abTestConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File a = ag3.a();
            if (a == null) {
                return null;
            }
            String path = a.getPath();
            if (TextUtils.isEmpty(path)) {
                return null;
            }
            return path + "/debug_abtest_config.json";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            if (i53.b) {
                JSONObject a = i53.a(unitedSchemeEntity, "params");
                if (a != null && context != null) {
                    JSONObject optJSONObject = a.optJSONObject("abtest");
                    if (optJSONObject != null) {
                        Toast.makeText(context, l(optJSONObject) ? R.string.obfuscated_res_0x7f0f12c8 : R.string.obfuscated_res_0x7f0f12c6, 1).show();
                    } else {
                        j();
                        Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f12c9, 1).show();
                    }
                    return true;
                }
                Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f12c7, 1).show();
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String k = k();
            if (TextUtils.isEmpty(k)) {
                return;
            }
            File file = new File(k);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final boolean l(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            String k = k();
            if (TextUtils.isEmpty(k)) {
                return false;
            }
            return om2.b(k, jSONObject.toString(), false);
        }
        return invokeL.booleanValue;
    }
}
