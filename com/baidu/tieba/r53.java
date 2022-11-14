package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.upload.UploadConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r53 extends c63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface b {
    }

    /* loaded from: classes5.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public a(r53 r53Var, Activity activity, Uri uri, String str, CallbackHandler callbackHandler, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r53Var, activity, uri, str, callbackHandler, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r53(c53 c53Var) {
        super(c53Var, "/swanAPI/file/openDocument");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c53Var};
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

    @Override // com.baidu.tieba.c63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, f43 f43Var) {
        InterceptResult invokeLLLL;
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, f43Var)) == null) {
            if (f43Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            } else if (f43Var.n0()) {
                if (c63.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject a2 = c63.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                    return false;
                }
                String optString = a2.optString("filePath");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal filePath");
                    return false;
                }
                String g0 = f43.g0();
                if (TextUtils.isEmpty(g0)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                    return false;
                }
                String M = nb3.M(optString, g0);
                if (TextUtils.isEmpty(M)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal realFilePath");
                    return false;
                }
                String optString2 = a2.optString(UploadConstant.KEY_FILE_TYPE);
                String t = jk4.t(M);
                if (TextUtils.isEmpty(t)) {
                    if (TextUtils.isEmpty(optString2)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file ext");
                        return false;
                    }
                } else {
                    optString2 = t;
                }
                String b2 = wg3.b(optString2);
                if (TextUtils.isEmpty(b2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file mimeType");
                    return false;
                }
                Uri parse = Uri.parse(M);
                if (parse == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal Uri path");
                    return false;
                }
                if (parse.getScheme() == null) {
                    uri = Uri.fromFile(new File(M));
                } else {
                    uri = parse;
                }
                SwanAppActivity w = f43Var.w();
                if (w == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal activity == null");
                    return false;
                } else if (!wg3.a(b2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support this mimeType=" + b2);
                    return false;
                } else {
                    String optString3 = a2.optString("cb");
                    ro1 r = mn2.r();
                    if (!r.b(w, b2)) {
                        if (TextUtils.isEmpty(optString3)) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not found plugin,mimeType=" + b2);
                            return false;
                        }
                        j(w, b2, uri, optString3, callbackHandler);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        return true;
                    }
                    r.c(w, uri, b2);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return true;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(Activity activity, String str, Uri uri, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, uri, str2, callbackHandler) == null) {
            mn2.r().a(activity, str, new a(this, activity, uri, str, callbackHandler, str2));
        }
    }
}
