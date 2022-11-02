package com.baidu.tieba;

import android.app.Application;
import android.net.Uri;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tieba.bp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class pw3 extends kw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pw3() {
        super("navigateToSwanGame");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.kw3
    public ew1 a(JSONObject paramsJson, ih2 callback) {
        InterceptResult invokeLL;
        boolean z;
        Uri parse;
        bp2.a W;
        String I;
        bp2.a W2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, paramsJson, callback)) == null) {
            Intrinsics.checkNotNullParameter(paramsJson, "paramsJson");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Application c = ln2.c();
            if (c == null) {
                callback.onFail(202, "params may be error");
                return null;
            }
            String optString = paramsJson.optString("appKey");
            boolean z2 = false;
            if (optString != null && optString.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                callback.onFail(202, "params may be error");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            e43 b0 = e43.b0();
            String str = "";
            jSONObject.put("pre_source", (b0 == null || (W2 = b0.W()) == null || (r8 = W2.T()) == null) ? "" : "");
            e43 b02 = e43.b0();
            if (b02 != null && (W = b02.W()) != null && (I = W.I()) != null) {
                str = I;
            }
            jSONObject.put("pre_appid", str);
            paramsJson.put(UBCCloudControlProcessor.UBC_KEY, jSONObject);
            String d1 = cp2.d1(optString, 1, paramsJson);
            if ((d1 == null || d1.length() == 0) ? true : true) {
                parse = null;
            } else {
                parse = Uri.parse(d1);
            }
            if (parse == null) {
                callback.onFail(202, "params may be error");
                return null;
            }
            if (SchemeRouter.invokeScheme(c, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                callback.a(null);
            } else {
                callback.onFail(202, "params may be error");
            }
            return null;
        }
        return (ew1) invokeLL.objValue;
    }
}
