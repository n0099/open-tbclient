package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
/* loaded from: classes7.dex */
public class pz1 extends iz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n12 a;
        public final /* synthetic */ CanvasView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ k63 e;
        public final /* synthetic */ CallbackHandler f;

        public a(pz1 pz1Var, n12 n12Var, CanvasView canvasView, String str, UnitedSchemeEntity unitedSchemeEntity, k63 k63Var, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz1Var, n12Var, canvasView, str, unitedSchemeEntity, k63Var, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n12Var;
            this.b = canvasView;
            this.c = str;
            this.d = unitedSchemeEntity;
            this.e = k63Var;
            this.f = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean i2 = this.a.i(this.b, this.c);
                HashMap<String, String> params = this.d.getParams();
                if (params != null && !params.isEmpty()) {
                    String str = params.get("params");
                    String str2 = null;
                    JSONObject jSONObject = new JSONObject();
                    if (str != null) {
                        try {
                            str2 = new JSONObject(str).optString("cb");
                            jSONObject.putOpt("tempFilePath", sd3.J(this.c, this.e.b));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (i2) {
                            i = 0;
                        } else {
                            i = 1001;
                        }
                        this.f.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, i).toString());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pz1(h73 h73Var) {
        super(h73Var, "/swanAPI/canvas/toTempFilePath");
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
                super((h73) objArr2[0], (String) objArr2[1]);
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
        s52 J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            n12 m = m(unitedSchemeEntity);
            if (m == null) {
                k32.c("SwanAppCanvas", "CanvasToTempFilePath action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            String x = sd3.x(k63Var.b);
            if (TextUtils.isEmpty(x)) {
                k32.c("SwanAppCanvas", "CanvasToTempFilePath cache path is empty");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            String str2 = x + File.separator + Calendar.getInstance().getTimeInMillis();
            if (m.h()) {
                str = str2 + ".jpg";
            } else {
                str = str2 + ".png";
            }
            String str3 = str;
            if (TextUtils.isEmpty(m.c) && (J = xr2.V().J()) != null) {
                m.c = J.A3();
            }
            if (!TextUtils.isEmpty(m.c) && !TextUtils.isEmpty(m.b)) {
                CanvasView a2 = l22.a(m);
                if (a2 == null) {
                    k32.c("SwanAppCanvas", "CanvasToTempFilePath canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                ej3.k(new a(this, m, a2, str3, unitedSchemeEntity, k63Var, callbackHandler), "tempFilePath");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            k32.c("SwanAppCanvas", "CanvasToTempFilePath slave id = " + m.c + " ; canvas id = " + m.b);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public n12 m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (!TextUtils.isEmpty(str)) {
                return new n12(str);
            }
            return null;
        }
        return (n12) invokeL.objValue;
    }
}
