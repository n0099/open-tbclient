package com.baidu.validation.js.interpreter;

import com.baidu.tieba.swa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.validation.js.BaseInterpreter;
import com.baidu.validation.result.ValidationResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ActionValidationResult extends BaseInterpreter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ActionValidationResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.validation.js.BaseInterpreter
    public String interpret(swa swaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, swaVar)) == null) {
            if (swaVar != null && swaVar.c() != null) {
                try {
                    this.mInterpreterCallback.a(this.mName, ValidationResult.parseFromJson(new JSONObject(swaVar.c().get(0))));
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
