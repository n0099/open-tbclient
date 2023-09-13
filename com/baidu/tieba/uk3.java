package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.o12;
import com.baidu.tieba.tk3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class uk3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements tk3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ z12 c;
        public final /* synthetic */ uk3 d;

        public a(uk3 uk3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, z12 z12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uk3Var, unitedSchemeEntity, callbackHandler, z12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = uk3Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = z12Var;
        }

        @Override // com.baidu.tieba.tk3.a
        public void a(double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dArr) == null) {
                if (dArr != null && dArr.length == 3) {
                    h82.i("accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                    this.d.k(this.a, this.b, this.c, dArr);
                    return;
                }
                h82.c("accelerometer", "illegal accelerometers");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uk3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/startAccelerometer");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (hb3Var == null) {
                h82.c("accelerometer", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (ed3.b) {
                    Log.d("SwanAppAction", "startAccelerometer --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                h82.c("accelerometer", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (ed3.b) {
                    Log.d("SwanAppAction", "startAccelerometer --- illegal context");
                }
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    if (ed3.b) {
                        Log.d("SwanAppAction", "startAccelerometer --- params is empty");
                    }
                    h82.c("accelerometer", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (ed3.b) {
                        Log.d("SwanAppAction", "startAccelerometer --- cb is empty");
                    }
                    h82.c("accelerometer", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                h82.i("accelerometer", " init ");
                z12 z12Var = new z12("accelerometerChange", optParamsAsJo, optString);
                tk3 a2 = tk3.a();
                a2.b(context, o12.b.a(optParamsAsJo.optString("interval")));
                a2.e(new a(this, unitedSchemeEntity, callbackHandler, z12Var));
                a2.f();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                z12Var.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, z12 z12Var, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, z12Var, dArr) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", dArr[0]);
                jSONObject.put("y", dArr[1]);
                jSONObject.put("z", dArr[2]);
                z12Var.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e) {
                h82.c("accelerometer", "handle compass,json error，" + e.toString());
                z12Var.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
