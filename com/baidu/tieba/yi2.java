package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class yi2 implements V8Engine.JavaScriptExceptionDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public li2 a;
    public String b;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final boolean d;
        public transient /* synthetic */ FieldHolder $fh;
        public JSEvent a;
        public String b;
        public String c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-259623926, "Lcom/baidu/tieba/yi2$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-259623926, "Lcom/baidu/tieba/yi2$a;");
                    return;
                }
            }
            d = nr1.a;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = new JSEvent("error");
        }

        public JSEvent a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("message", this.b);
                    jSONObject.put("stack", this.c);
                } catch (JSONException e) {
                    if (d) {
                        Log.e("V8Exception", Log.getStackTraceString(e));
                    }
                }
                if (jSONObject.length() > 0) {
                    this.a.data = jSONObject;
                }
                return this.a;
            }
            return (JSEvent) invokeV.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948331047, "Lcom/baidu/tieba/yi2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948331047, "Lcom/baidu/tieba/yi2;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    public yi2(li2 li2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {li2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "";
        this.a = li2Var;
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, str2) != null) || this.a.m() == null) {
            return;
        }
        EventTarget m = this.a.m();
        a aVar = new a();
        aVar.b(str + "\n" + str2);
        aVar.c("");
        m.dispatchEvent(aVar.a());
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8ExceptionInfo) != null) || v8ExceptionInfo == null) {
            return;
        }
        String str2 = "";
        if (TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
            str = "";
        } else {
            str = v8ExceptionInfo.exceptionMsg;
        }
        if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
            str2 = v8ExceptionInfo.exceptionTrace;
        }
        Log.e("V8Exception", this.a.l0() + "msg: " + str + " ,stack: " + str2);
        this.a.w().a(str);
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || this.b.equals(str)) {
            return;
        }
        this.b = str;
        a(str, str2);
        os1 j = lu2.j();
        j.e(str + ParamableElem.DIVIDE_PARAM + str2);
        xh3.b(v8ExceptionInfo);
        lu2.i().r(v8ExceptionInfo);
    }
}
