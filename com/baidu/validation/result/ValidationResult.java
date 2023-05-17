package com.baidu.validation.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ValidationResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_OK = 0;
    public static final int ERROR_USER_CANCEL = -204;
    public static final String KEY_DATA = "data";
    public static final String KEY_DATA_DS = "ds";
    public static final String KEY_DATA_TK = "tk";
    public static final String KEY_ERRNO = "errno";
    public static final String KEY_MSG = "msg";
    public static final String MSG_SUCCESS = "验证通过";
    public static final String MSG_USER_CANCEL = "用户取消操作";
    public transient /* synthetic */ FieldHolder $fh;
    public Data data;
    public int errno;
    public String msg;

    /* loaded from: classes8.dex */
    public static class Data {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String ds;
        public String tk;

        public Data() {
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
    }

    public ValidationResult() {
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

    public static ValidationResult parseFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ValidationResult validationResult = new ValidationResult();
            validationResult.errno = jSONObject.optInt("errno");
            validationResult.msg = jSONObject.optString("msg");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                Data data = new Data();
                data.ds = optJSONObject.optString("ds");
                data.tk = optJSONObject.optString("tk");
                validationResult.data = data;
            }
            return validationResult;
        }
        return (ValidationResult) invokeL.objValue;
    }
}
