package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
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
/* loaded from: classes6.dex */
public abstract class kz1 implements hz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final JSONObject c;
    public static final Pair<h32, JSONObject> d;
    public static final Pair<h32, JSONObject> e;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public iz1 a;
    @NonNull
    public CallbackHandler b;

    /* loaded from: classes6.dex */
    public interface a {
        h32 a(hb3 hb3Var, JSONObject jSONObject, @Nullable String str);
    }

    /* loaded from: classes6.dex */
    public interface b {
        h32 a(hb3 hb3Var);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947930279, "Lcom/baidu/tieba/kz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947930279, "Lcom/baidu/tieba/kz1;");
                return;
            }
        }
        c = new JSONObject();
        d = new Pair<>(h32.d(), c);
        e = new Pair<>(h32.e(), c);
    }

    public kz1(@NonNull iz1 iz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = iz1Var;
        this.b = iz1Var.f();
    }

    @NonNull
    public Pair<h32, JSONObject> s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                p("json str is empty", null, true);
                return d;
            }
            try {
                return new Pair<>(h32.f(), new JSONObject(str));
            } catch (JSONException e2) {
                p("json str parse fail", e2, true);
                return e;
            }
        }
        return (Pair) invokeL.objValue;
    }

    @Nullable
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

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static Pair<g32, JSONObject> t(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jsObject)) == null) {
            if (jsObject == null) {
                return new Pair<>(new h32(202, "parseParams(JsObject): jsObject cannot be null"), null);
            }
            int type = jsObject.getType();
            int length = jsObject.length();
            if (type != 9) {
                String str = "parseParams(JsObject): jsObject cannot be " + JsObject.typeToString(type) + " ,length " + length;
                jsObject.release();
                return new Pair<>(new h32(202, str), null);
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
                    return new Pair<>(new h32(202, str2), null);
                }
            }
            jsObject.release();
            return new Pair<>(new h32(0), jSONObject);
        }
        return (Pair) invokeL.objValue;
    }

    @NonNull
    public static Pair<g32, JSONObject> u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Pair<>(new h32(202, "parseParams(String): json string cannot be empty"), null);
            }
            try {
                return new Pair<>(new h32(0), new JSONObject(str));
            } catch (JSONException unused) {
                return new Pair<>(new h32(202, "parseParams(String): with json exception "), null);
            }
        }
        return (Pair) invokeL.objValue;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static JSONArray v(@NonNull JsObject[] jsObjectArr) {
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

    @Override // com.baidu.tieba.hz1
    @NonNull
    public final iz1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (iz1) invokeV.objValue;
    }

    @NonNull
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
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                return true;
            }
            return b0.n0();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hz1
    @SuppressLint({"BDThrowableCheck"})
    public final void d(@NonNull String str, @NonNull h32 h32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, h32Var) == null) {
            if (TextUtils.isEmpty(str)) {
                p("callback is empty", null, true);
            } else if (h32Var == null) {
                p("api result is empty", null, true);
            } else {
                w(str, h32Var);
            }
        }
    }

    public void q(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) && o()) {
            h82.j(j(), i(), str, z);
        }
    }

    public h32 k(boolean z, @NonNull b bVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048582, this, z, bVar)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                p("swan app is null", null, false);
                return h32.j();
            } else if (z && b0.w() == null) {
                p("swan activity is null", null, true);
                return h32.i();
            } else {
                return bVar.a(b0);
            }
        }
        return (h32) invokeZL.objValue;
    }

    @UiThread
    public final void w(@NonNull String str, @NonNull h32 h32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, h32Var) == null) {
            if (TextUtils.isEmpty(str) && !(this.b instanceof NullableCallbackHandler)) {
                q("#realInvokeCallback check-fail callback=" + str, false);
                return;
            }
            this.b.handleSchemeDispatchCallback(str, h32Var.a());
        }
    }

    public h32 l(String str, boolean z, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            hb3 b0 = hb3.b0();
            String str2 = null;
            if (b0 == null) {
                p("swan app is null", null, false);
                return new h32(1001, "swan app is null");
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                p("json str parse fail", null, true);
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (z) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new h32(202, "cb is empty");
                }
                str2 = optString;
            }
            return aVar.a(b0, jSONObject, str2);
        }
        return (h32) invokeCommon.objValue;
    }

    public h32 m(@Nullable String str, @NonNull jz1 jz1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jz1Var)) == null) {
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                p("json str parse fail", null, true);
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("cb is empty", null, true);
                return new h32(202, "cb is empty");
            }
            return jz1Var.f(jSONObject, optString, this);
        }
        return (h32) invokeLL.objValue;
    }

    public void p(String str, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048587, this, str, th, z) == null) && o()) {
            h82.e(j(), i(), str, th, z);
        }
    }
}
