package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class xd3 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xd3(h73 h73Var) {
        super(h73Var, "/swanAPI/file/getInfo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
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

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (context != null && callbackHandler != null && k63Var != null && k63Var.g0() != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    k32.c("fileInfo", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString = optParamsAsJo.optString("filePath");
                if (sd3.s(optString) == PathType.BD_FILE) {
                    str = sd3.M(optString, k63.h0());
                } else if (sd3.s(optString) == PathType.RELATIVE) {
                    str = sd3.L(optString, k63Var, k63Var.l0());
                } else {
                    str = "";
                }
                if (h83.b) {
                    Log.d("GetFileInfoAction", "——> handle: fileUrl " + optString);
                    Log.d("GetFileInfoAction", "——> handle: filePath " + str);
                }
                if (TextUtils.isEmpty(str)) {
                    k32.c("fileInfo", "absolute filePath is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                File file = new File(str);
                if (TextUtils.equals(optParamsAsJo.optString("digestAlgorithm", "md5"), "md5")) {
                    str2 = "MD5";
                } else {
                    str2 = "SHA-1";
                }
                String b = cj3.b(str2, file, false);
                if (TextUtils.isEmpty(b)) {
                    k32.c("fileInfo", "hash is null");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, e73.a(2001)));
                    if (h83.b) {
                        Log.d("GetFileInfoAction", "——> handle: file not exist");
                    }
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("digest", b);
                    jSONObject.put("size", file.length());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, e73.a(2003)));
                    if (h83.b) {
                        Log.d("GetFileInfoAction", "——> handle: jsonException ");
                    }
                    return false;
                }
            }
            k32.c("fileInfo", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
