package com.baidu.validation.js.interpreter;

import com.baidu.tieba.ckb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.validation.js.BaseInterpreter;
import com.baidu.validation.result.LoadExternalWebViewResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ActionLoadExternalWebview extends BaseInterpreter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ActionLoadExternalWebview() {
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
    public String interpret(ckb ckbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ckbVar)) == null) {
            if (ckbVar != null && ckbVar.c() != null) {
                try {
                    this.mInterpreterCallback.a(this.mName, LoadExternalWebViewResult.parseFromJson(new JSONObject(ckbVar.c().get(0))));
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
