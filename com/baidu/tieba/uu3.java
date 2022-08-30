package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class uu3 extends go2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public EventTargetImpl d;
    public ru3 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223446, "Lcom/baidu/tieba/uu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223446, "Lcom/baidu/tieba/uu3;");
                return;
            }
        }
        f = kh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uu3(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eventTargetImpl, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((CallbackHandler) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = eventTargetImpl;
    }

    @Override // com.baidu.tieba.go2
    public void b(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            String optString = this.b.optString(str);
            ru3 ru3Var = this.e;
            if (ru3Var != null) {
                ru3Var.p(optString, jSONObject);
            }
            if (this.d.hasEventListener(optString)) {
                JSEvent jSEvent = new JSEvent(optString);
                if (jSONObject != null) {
                    jSEvent.data = jSONObject;
                }
                if (f && !"onTimeUpdate".equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("type = ");
                    sb.append(str);
                    sb.append("  result = ");
                    sb.append(jSONObject != null ? jSONObject.toString() : StringUtil.NULL_STRING);
                    Log.d("AudioCallbackForV8", sb.toString());
                }
                this.d.dispatchEvent(jSEvent);
            }
        }
    }

    @Override // com.baidu.tieba.go2
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void e(ru3 ru3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ru3Var) == null) {
            this.e = ru3Var;
        }
    }
}
