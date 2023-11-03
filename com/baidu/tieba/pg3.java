package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.og3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pg3 extends d83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements og3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ zw1 c;
        public final /* synthetic */ pg3 d;

        public a(pg3 pg3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zw1 zw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg3Var, unitedSchemeEntity, callbackHandler, zw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pg3Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = zw1Var;
        }

        @Override // com.baidu.tieba.og3.b
        public void a(float[] fArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fArr) == null) && fArr != null && fArr.length == 3) {
                this.d.k(this.a, this.b, this.c, fArr);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pg3(d73 d73Var) {
        super(d73Var, "/swanAPI/startDeviceMotion");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d73Var};
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

    @Override // com.baidu.tieba.d83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g63 g63Var) {
        InterceptResult invokeLLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, g63Var)) == null) {
            if (g63Var == null) {
                g32.c("StartDeviceMotionAction", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
                return false;
            } else if (context == null) {
                g32.c("StartDeviceMotionAction", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    g32.c("StartDeviceMotionAction", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    g32.c("StartDeviceMotionAction", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString2 = optParamsAsJo.optString("interval");
                if (TaskUIData.key.equals(optString2)) {
                    i = 2;
                } else if ("game".equals(optString2)) {
                    i = 1;
                } else {
                    i = 3;
                }
                g32.i("StartDeviceMotionAction", "startSensor===");
                zw1 zw1Var = new zw1("deviceMotionChange", optParamsAsJo, optString);
                if (!og3.h().l(i, new a(this, unitedSchemeEntity, callbackHandler, zw1Var))) {
                    g32.c("StartDeviceMotionAction", "start system sensor fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "start system sensor fail");
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                zw1Var.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zw1 zw1Var, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, zw1Var, fArr) == null) {
            JSONObject jSONObject = new JSONObject();
            double[] dArr = new double[3];
            double d = fArr[0] - 1.5707963267948966d;
            if (d < 0.0d) {
                d += 6.283185307179586d;
            }
            dArr[0] = Math.toDegrees(d);
            dArr[1] = Math.toDegrees(-fArr[2]);
            dArr[2] = Math.toDegrees(-fArr[1]);
            if (d83.b) {
                Log.i("SwanAppAction", "deviceMotionChange: " + Arrays.toString(dArr));
            }
            try {
                jSONObject.put(Key.ALPHA, (float) dArr[0]);
                jSONObject.put("beta", (float) dArr[1]);
                jSONObject.put("gamma", (float) dArr[2]);
                zw1Var.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e) {
                g32.c("StartDeviceMotionAction", "handle orientation,json error，" + e.toString());
                zw1Var.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
