package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.NullableCallbackHandler;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class pr1 implements mr1 {
    public static /* synthetic */ Interceptable $ic;
    public static final JSONObject c;
    public static final Pair d;
    public static final Pair e;
    public transient /* synthetic */ FieldHolder $fh;
    public nr1 a;
    public CallbackHandler b;

    /* loaded from: classes5.dex */
    public interface a {
        mv1 a(m33 m33Var, JSONObject jSONObject, String str);
    }

    /* loaded from: classes5.dex */
    public interface b {
        mv1 a(m33 m33Var);
    }

    public abstract String h();

    public abstract String j();

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948071546, "Lcom/baidu/tieba/pr1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948071546, "Lcom/baidu/tieba/pr1;");
                return;
            }
        }
        c = new JSONObject();
        d = new Pair(mv1.d(), c);
        e = new Pair(mv1.e(), c);
    }

    public pr1(nr1 nr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = nr1Var;
        this.b = nr1Var.g();
    }

    public Pair s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                p("json str is empty", null, true);
                return d;
            }
            try {
                return new Pair(mv1.f(), new JSONObject(str));
            } catch (JSONException e2) {
                p("json str parse fail", e2, true);
                return e;
            }
        }
        return (Pair) invokeL.objValue;
    }

    public static JSONObject r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static Pair t(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jsObject)) == null) {
            if (jsObject == null) {
                return new Pair(new mv1(202, "parseParams(JsObject): jsObject cannot be null"), null);
            }
            int type = jsObject.getType();
            int length = jsObject.length();
            if (type != 9) {
                String str = "parseParams(JsObject): jsObject cannot be " + JsObject.typeToString(type) + " ,length " + length;
                jsObject.release();
                return new Pair(new mv1(202, str), null);
            }
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < length; i++) {
                try {
                    int propertyType = jsObject.getPropertyType(i);
                    String propertyName = jsObject.getPropertyName(i);
                    switch (propertyType) {
                        case 1:
                            jSONObject.put(propertyName, jsObject.toBoolean(i));
                            break;
                        case 2:
                            jSONObject.put(propertyName, jsObject.toInteger(i));
                            break;
                        case 3:
                            jSONObject.put(propertyName, jsObject.toLong(i));
                            break;
                        case 5:
                            try {
                                jSONObject.put(propertyName, jsObject.toDouble(i));
                                break;
                            } catch (JSONException unused) {
                                break;
                            }
                        case 6:
                            JsObject[] objectArray = jsObject.toObjectArray(i);
                            if (objectArray == null) {
                                break;
                            } else {
                                jSONObject.put(propertyName, v(objectArray));
                                break;
                            }
                        case 7:
                            jSONObject.put(propertyName, jsObject.toString(i));
                            break;
                        case 8:
                            jSONObject.put(propertyName, jsObject.toJsFunction(i));
                            break;
                        case 9:
                            jSONObject.put(propertyName, t(jsObject.toJsObject(i)).second);
                            break;
                        case 10:
                            jSONObject.put(propertyName, jsObject.toJsArrayBuffer(i));
                            break;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    String str2 = "parseParams(JsObject): with exception " + e2.getMessage();
                    jsObject.release();
                    return new Pair(new mv1(202, str2), null);
                }
            }
            jsObject.release();
            return new Pair(new mv1(0), jSONObject);
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Pair(new mv1(202, "parseParams(String): json string cannot be empty"), null);
            }
            try {
                return new Pair(new mv1(0), new JSONObject(str));
            } catch (JSONException unused) {
                return new Pair(new mv1(202, "parseParams(String): with json exception "), null);
            }
        }
        return (Pair) invokeL.objValue;
    }

    public static JSONArray v(JsObject[] jsObjectArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jsObjectArr)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (JsObject jsObject : jsObjectArr) {
                if (jsObject == null) {
                    jSONArray.put((Object) null);
                } else {
                    switch (jsObject.getType()) {
                        case 0:
                            jSONArray.put((Object) null);
                            continue;
                        case 1:
                            jSONArray.put(jsObject.toBoolean(0));
                            continue;
                        case 2:
                            jSONArray.put(jsObject.toInteger(0));
                            continue;
                        case 3:
                            jSONArray.put(jsObject.toLong(0));
                            continue;
                        case 5:
                            try {
                                jSONArray.put(jsObject.toDouble(0));
                                continue;
                            } catch (JSONException unused) {
                                jSONArray.put((Object) null);
                                break;
                            }
                        case 6:
                            JsObject[] objectArray = jsObject.toObjectArray(0);
                            if (objectArray == null) {
                                jSONArray.put((Object) null);
                                continue;
                            } else {
                                jSONArray.put(v(objectArray));
                                break;
                            }
                        case 7:
                            jSONArray.put(jsObject.toString(0));
                            continue;
                        case 8:
                            jSONArray.put(jsObject.toJsFunction(0));
                            continue;
                        case 9:
                            jSONArray.put(t(jsObject).second);
                            continue;
                        case 10:
                            jSONArray.put(jsObject.toJsArrayBuffer(0));
                            continue;
                        case 11:
                            jSONArray.put((Object) null);
                            continue;
                        case 12:
                            jSONArray.put((Object) null);
                            continue;
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mr1
    public final nr1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (nr1) invokeV.objValue;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.getContext();
        }
        return (Context) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "API-" + h();
        }
        return (String) invokeV.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            m33 b0 = m33.b0();
            if (b0 == null) {
                return true;
            }
            return b0.n0();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mr1
    public final void d(String str, mv1 mv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, mv1Var) == null) {
            if (TextUtils.isEmpty(str)) {
                p("callback is empty", null, true);
            } else if (mv1Var == null) {
                p("api result is empty", null, true);
            } else {
                w(str, mv1Var);
            }
        }
    }

    public void q(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) && o()) {
            m02.j(j(), i(), str, z);
        }
    }

    public mv1 k(boolean z, b bVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048582, this, z, bVar)) == null) {
            m33 b0 = m33.b0();
            if (b0 == null) {
                p("swan app is null", null, false);
                return mv1.j();
            } else if (z && b0.w() == null) {
                p("swan activity is null", null, true);
                return mv1.i();
            } else {
                return bVar.a(b0);
            }
        }
        return (mv1) invokeZL.objValue;
    }

    public final void w(String str, mv1 mv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, mv1Var) == null) {
            if (TextUtils.isEmpty(str) && !(this.b instanceof NullableCallbackHandler)) {
                q("#realInvokeCallback check-fail callback=" + str, false);
                return;
            }
            this.b.handleSchemeDispatchCallback(str, mv1Var.a());
        }
    }

    public mv1 l(String str, boolean z, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            m33 b0 = m33.b0();
            String str2 = null;
            if (b0 == null) {
                p("swan app is null", null, false);
                return new mv1(1001, "swan app is null");
            }
            Pair s = s(str);
            mv1 mv1Var = (mv1) s.first;
            if (!mv1Var.isSuccess()) {
                p("json str parse fail", null, true);
                return mv1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (z) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new mv1(202, "cb is empty");
                }
                str2 = optString;
            }
            return aVar.a(b0, jSONObject, str2);
        }
        return (mv1) invokeCommon.objValue;
    }

    public mv1 m(String str, or1 or1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, or1Var)) == null) {
            Pair s = s(str);
            mv1 mv1Var = (mv1) s.first;
            if (!mv1Var.isSuccess()) {
                p("json str parse fail", null, true);
                return mv1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("cb is empty", null, true);
                return new mv1(202, "cb is empty");
            }
            return or1Var.f(jSONObject, optString, this);
        }
        return (mv1) invokeLL.objValue;
    }

    public void p(String str, Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048587, this, str, th, z) == null) && o()) {
            m02.e(j(), i(), str, th, z);
        }
    }
}
