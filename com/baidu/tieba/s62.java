package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.appframework.AppFrameworkConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s62 extends l72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948103290, "Lcom/baidu/tieba/s62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948103290, "Lcom/baidu/tieba/s62;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    @Override // com.baidu.tieba.l72, com.baidu.tieba.u13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s62(String str) {
        super("canvas", "canvasId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = false;
        try {
            a(new JSONObject(str));
        } catch (JSONException e) {
            v82.d("Canvas", "parsing CanvasBasicthis occurs exception", e);
        }
    }

    @Override // com.baidu.tieba.l72, com.baidu.tieba.u13
    public void a(JSONObject jSONObject) throws JSONException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.a(jSONObject);
            if (!TextUtils.equals(jSONObject.optString("hide"), "1") && !jSONObject.optBoolean("hide")) {
                z = false;
            } else {
                z = true;
            }
            this.f = z;
            this.j = !TextUtils.equals(jSONObject.optString("disableScroll"), "0");
            this.g = !TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK), "0");
        }
    }
}
