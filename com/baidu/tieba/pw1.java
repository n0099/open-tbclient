package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pw1 extends iw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny1 a;
        public final /* synthetic */ CanvasView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ l33 e;
        public final /* synthetic */ CallbackHandler f;

        public a(pw1 pw1Var, ny1 ny1Var, CanvasView canvasView, String str, UnitedSchemeEntity unitedSchemeEntity, l33 l33Var, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pw1Var, ny1Var, canvasView, str, unitedSchemeEntity, l33Var, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny1Var;
            this.b = canvasView;
            this.c = str;
            this.d = unitedSchemeEntity;
            this.e = l33Var;
            this.f = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean i = this.a.i(this.b, this.c);
                HashMap<String, String> params = this.d.getParams();
                if (params == null || params.isEmpty()) {
                    return;
                }
                String str = params.get("params");
                String str2 = null;
                JSONObject jSONObject = new JSONObject();
                if (str != null) {
                    try {
                        str2 = new JSONObject(str).optString("cb");
                        jSONObject.putOpt("tempFilePath", ta3.J(this.c, this.e.b));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, i ? 0 : 1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pw1(i43 i43Var) {
        super(i43Var, "/swanAPI/canvas/toTempFilePath");
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
                super((i43) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        String str;
        t22 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            ny1 m = m(unitedSchemeEntity);
            if (m == null) {
                l02.c("SwanAppCanvas", "CanvasToTempFilePath action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            String x = ta3.x(l33Var.b);
            if (TextUtils.isEmpty(x)) {
                l02.c("SwanAppCanvas", "CanvasToTempFilePath cache path is empty");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            String str2 = x + File.separator + Calendar.getInstance().getTimeInMillis();
            if (m.h()) {
                str = str2 + ".jpg";
            } else {
                str = str2 + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            }
            String str3 = str;
            if (TextUtils.isEmpty(m.c) && (H = yo2.U().H()) != null) {
                m.c = H.t3();
            }
            if (!TextUtils.isEmpty(m.c) && !TextUtils.isEmpty(m.b)) {
                CanvasView a2 = mz1.a(m);
                if (a2 == null) {
                    l02.c("SwanAppCanvas", "CanvasToTempFilePath canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                fg3.k(new a(this, m, a2, str3, unitedSchemeEntity, l33Var, callbackHandler), "tempFilePath");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            l02.c("SwanAppCanvas", "CanvasToTempFilePath slave id = " + m.c + " ; canvas id = " + m.b);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public ny1 m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new ny1(str);
        }
        return (ny1) invokeL.objValue;
    }
}
