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
/* loaded from: classes5.dex */
public class p14 extends av2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public EventTargetImpl d;
    public m14 e;

    @Override // com.baidu.tieba.av2
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948009174, "Lcom/baidu/tieba/p14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948009174, "Lcom/baidu/tieba/p14;");
                return;
            }
        }
        f = eo1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p14(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
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

    @Override // com.baidu.tieba.av2
    public void b(String str, JSONObject jSONObject) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            String optString = this.b.optString(str);
            m14 m14Var = this.e;
            if (m14Var != null) {
                m14Var.p(optString, jSONObject);
            }
            if (!this.d.hasEventListener(optString)) {
                return;
            }
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (f && !"onTimeUpdate".equals(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("type = ");
                sb.append(str);
                sb.append("  result = ");
                if (jSONObject != null) {
                    str2 = jSONObject.toString();
                } else {
                    str2 = StringUtil.NULL_STRING;
                }
                sb.append(str2);
                Log.d("AudioCallbackForV8", sb.toString());
            }
            this.d.dispatchEvent(jSEvent);
        }
    }

    public void e(m14 m14Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m14Var) == null) {
            this.e = m14Var;
        }
    }
}
