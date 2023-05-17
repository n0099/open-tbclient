package com.baidu.validation.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ValidationViewSettingResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_HEIGHT = "height";
    public transient /* synthetic */ FieldHolder $fh;
    public int height;

    public ValidationViewSettingResult() {
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

    public static ValidationViewSettingResult parseFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ValidationViewSettingResult validationViewSettingResult = new ValidationViewSettingResult();
            validationViewSettingResult.height = jSONObject.optInt("height");
            return validationViewSettingResult;
        }
        return (ValidationViewSettingResult) invokeL.objValue;
    }
}
