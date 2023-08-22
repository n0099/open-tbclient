package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.pms.db.PackageTable;
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
/* loaded from: classes7.dex */
public class qi3 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qi3(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/file/getInfo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
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

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (context != null && callbackHandler != null && db3Var != null && db3Var.f0() != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    d82.c("fileInfo", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString = optParamsAsJo.optString("filePath");
                if (li3.s(optString) == PathType.BD_FILE) {
                    str = li3.M(optString, db3.g0());
                } else if (li3.s(optString) == PathType.RELATIVE) {
                    str = li3.L(optString, db3Var, db3Var.k0());
                } else {
                    str = "";
                }
                if (ad3.b) {
                    Log.d("GetFileInfoAction", "——> handle: fileUrl " + optString);
                    Log.d("GetFileInfoAction", "——> handle: filePath " + str);
                }
                if (TextUtils.isEmpty(str)) {
                    d82.c("fileInfo", "absolute filePath is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                File file = new File(str);
                if (TextUtils.equals(optParamsAsJo.optString("digestAlgorithm", PackageTable.MD5), PackageTable.MD5)) {
                    str2 = "MD5";
                } else {
                    str2 = "SHA-1";
                }
                String b = vn3.b(str2, file, false);
                if (TextUtils.isEmpty(b)) {
                    d82.c("fileInfo", "hash is null");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, xb3.a(2001)));
                    if (ad3.b) {
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
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, xb3.a(2003)));
                    if (ad3.b) {
                        Log.d("GetFileInfoAction", "——> handle: jsonException ");
                    }
                    return false;
                }
            }
            d82.c("fileInfo", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
