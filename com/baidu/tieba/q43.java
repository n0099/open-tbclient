package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, callbackHandler, unitedSchemeEntity)) == null) {
            String b = b(unitedSchemeEntity);
            if (TextUtils.isEmpty(b)) {
                v82.i("WxWebViewPayment", "wxPay: url is empty");
                v82.k("WxWebViewPayment", "param check error - src" + b);
                oi3.H(false, "wechatH5Action", oi3.m(b, "param check error - src"));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (!lg1.a().b(context)) {
                nb3.g(context, context.getText(R.string.obfuscated_res_0x7f0f0216)).G();
                v82.k("WxWebViewPayment", "Error: wechat not install. " + b);
                oi3.H(false, "wechatH5Action", oi3.m(b, "Error: wechat not install. "));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
                return false;
            } else {
                v13 d = v13.d(b, b);
                v82.k("WxWebViewPayment", "Info: open wechat pay webview, pageParam =" + d);
                if (!jb2.f3("wxPay", d)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    v82.k("WxWebViewPayment", "Error: webview fragment not opened.");
                    return false;
                }
                v82.k("WxWebViewPayment", "Success:open wxPay page success");
                v82.k("WxWebViewPayment", "Info: end WeChat H5 redirect " + b);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(j43.c(b), 0));
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static String b(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new JSONObject(str).optString("src");
            } catch (JSONException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
