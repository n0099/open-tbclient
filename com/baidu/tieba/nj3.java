package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nj3 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nj3(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/file/removeSavedFile");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
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

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (context != null && callbackHandler != null && vb3Var != null && vb3Var.f0() != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    v82.c("removeSavedFile", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String M = dj3.M(optParamsAsJo.optString("filePath"), vb3.g0());
                if (sd3.b) {
                    Log.d("SaveFileAction", "——> handle: fileUrl " + optParamsAsJo.optString("filePath"));
                    Log.d("SaveFileAction", "——> handle: filePath " + M);
                }
                if (sd3.b) {
                    Log.d("RemoveSavedFileAction", "——> handle: filePath " + M);
                }
                if (TextUtils.isEmpty(M)) {
                    v82.c("removeSavedFile", "file path is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                int a = vb3Var.f0().a(M);
                if (sd3.b) {
                    Log.d("RemoveSavedFileAction", "——> handle: statusCode " + a);
                }
                if (a > 2000) {
                    v82.c("removeSavedFile", "file path status code : " + a);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a, pc3.a(a)));
                    return false;
                } else if (zr4.k(M)) {
                    v82.i("removeSavedFile", "file delete success");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (sd3.b) {
                        Log.d("RemoveSavedFileAction", "——> handle:  delete OK ");
                        return true;
                    }
                    return true;
                } else {
                    v82.c("removeSavedFile", "file delete fail");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2004, pc3.a(2004)));
                    if (sd3.b) {
                        Log.d("RemoveSavedFileAction", "——> handle:  delete fail ");
                    }
                    return false;
                }
            }
            v82.c("removeSavedFile", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
