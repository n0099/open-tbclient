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
/* loaded from: classes6.dex */
public class s83 extends r93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s83(r83 r83Var) {
        super(r83Var, "/swanAPI/abTestConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r83Var};
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
            File a = jk3.a();
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

    @Override // com.baidu.tieba.r93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u73 u73Var) {
        InterceptResult invokeLLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u73Var)) == null) {
            if (!r93.b) {
                return false;
            }
            JSONObject a = r93.a(unitedSchemeEntity, "params");
            if (a != null && context != null) {
                JSONObject optJSONObject = a.optJSONObject("abtest");
                if (optJSONObject != null) {
                    if (l(optJSONObject)) {
                        i = R.string.obfuscated_res_0x7f0f1396;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f1394;
                    }
                    Toast.makeText(context, i, 1).show();
                } else {
                    j();
                    Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f1397, 1).show();
                }
                return true;
            }
            Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f1395, 1).show();
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
            return xq2.b(k, jSONObject.toString(), false);
        }
        return invokeL.booleanValue;
    }
}
