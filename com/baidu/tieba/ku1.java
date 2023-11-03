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
/* loaded from: classes7.dex */
public abstract class ku1 implements hu1 {
    public static /* synthetic */ Interceptable $ic;
    public static final JSONObject c;
    public static final Pair<hy1, JSONObject> d;
    public static final Pair<hy1, JSONObject> e;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public iu1 a;
    @NonNull
    public CallbackHandler b;

    /* loaded from: classes7.dex */
    public interface a {
        hy1 a(g63 g63Var, JSONObject jSONObject, @Nullable String str);
    }

    /* loaded from: classes7.dex */
    public interface b {
        hy1 a(g63 g63Var);
    }

    public abstract String h();

    public abstract String k();

    public boolean p() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925474, "Lcom/baidu/tieba/ku1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925474, "Lcom/baidu/tieba/ku1;");
                return;
            }
        }
        c = new JSONObject();
        d = new Pair<>(hy1.d(), c);
        e = new Pair<>(hy1.e(), c);
    }

    public ku1(@NonNull iu1 iu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = iu1Var;
        this.b = iu1Var.f();
    }

    @NonNull
    public Pair<hy1, JSONObject> t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                q("json str is empty", null, true);
                return d;
            }
            try {
                return new Pair<>(hy1.f(), new JSONObject(str));
            } catch (JSONException e2) {
                q("json str parse fail", e2, true);
                return e;
            }
        }
        return (Pair) invokeL.objValue;
    }

    @Nullable
    public static JSONObject s(String str) {
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
    public static Pair<gy1, JSONObject> u(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jsObject)) == null) {
            if (jsObject == null) {
                return new Pair<>(new hy1(202, "parseParams(JsObject): jsObject cannot be null"), null);
            }
            int type = jsObject.getType();
            int length = jsObject.length();
            if (type != 9) {
                String str = "parseParams(JsObject): jsObject cannot be " + JsObject.typeToString(type) + " ,length " + length;
                jsObject.release();
                return new Pair<>(new hy1(202, str), null);
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
                                jSONObject.put(propertyName, w(objectArray));
                                break;
                            }
                        case 7:
                            jSONObject.put(propertyName, jsObject.toString(i));
                            break;
                        case 8:
                            jSONObject.put(propertyName, jsObject.toJsFunction(i));
                            break;
                        case 9:
                            jSONObject.put(propertyName, u(jsObject.toJsObject(i)).second);
                            break;
                        case 10:
                            jSONObject.put(propertyName, jsObject.toJsArrayBuffer(i));
                            break;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    String str2 = "parseParams(JsObject): with exception " + e2.getMessage();
                    jsObject.release();
                    return new Pair<>(new hy1(202, str2), null);
                }
            }
            jsObject.release();
            return new Pair<>(new hy1(0), jSONObject);
        }
        return (Pair) invokeL.objValue;
    }

    @NonNull
    public static Pair<gy1, JSONObject> v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Pair<>(new hy1(202, "parseParams(String): json string cannot be empty"), null);
            }
            try {
                return new Pair<>(new hy1(0), new JSONObject(str));
            } catch (JSONException unused) {
                return new Pair<>(new hy1(202, "parseParams(String): with json exception "), null);
            }
        }
        return (Pair) invokeL.objValue;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static JSONArray w(@NonNull JsObject[] jsObjectArr) {
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
                                jSONArray.put(w(objectArray));
                                break;
                            }
                        case 7:
                            jSONArray.put(jsObject.toString(0));
                            continue;
                        case 8:
                            jSONArray.put(jsObject.toJsFunction(0));
                            continue;
                        case 9:
                            jSONArray.put(u(jsObject).second);
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

    @Override // com.baidu.tieba.hu1
    @NonNull
    public final iu1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (iu1) invokeV.objValue;
    }

    @NonNull
    public final Context i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.getContext();
        }
        return (Context) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "API-" + h();
        }
        return (String) invokeV.objValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            g63 c0 = g63.c0();
            if (c0 == null) {
                return true;
            }
            return c0.o0();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hu1
    @SuppressLint({"BDThrowableCheck"})
    public final void d(@NonNull String str, @NonNull hy1 hy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hy1Var) == null) {
            if (TextUtils.isEmpty(str)) {
                q("callback is empty", null, true);
            } else if (hy1Var == null) {
                q("api result is empty", null, true);
            } else {
                x(str, hy1Var);
            }
        }
    }

    public void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) && p()) {
            g32.j(k(), j(), str, z);
        }
    }

    public hy1 l(boolean z, @NonNull b bVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048582, this, z, bVar)) == null) {
            g63 c0 = g63.c0();
            if (c0 == null) {
                q("swan app is null", null, false);
                return hy1.j();
            } else if (z && c0.w() == null) {
                q("swan activity is null", null, true);
                return hy1.i();
            } else {
                return bVar.a(c0);
            }
        }
        return (hy1) invokeZL.objValue;
    }

    @UiThread
    public final void x(@NonNull String str, @NonNull hy1 hy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, hy1Var) == null) {
            if (TextUtils.isEmpty(str) && !(this.b instanceof NullableCallbackHandler)) {
                r("#realInvokeCallback check-fail callback=" + str, false);
                return;
            }
            this.b.handleSchemeDispatchCallback(str, hy1Var.a());
        }
    }

    public hy1 m(String str, boolean z, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            g63 c0 = g63.c0();
            String str2 = null;
            if (c0 == null) {
                q("swan app is null", null, false);
                return new hy1(1001, "swan app is null");
            }
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                q("json str parse fail", null, true);
                return hy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            if (z) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    q("cb is empty", null, true);
                    return new hy1(202, "cb is empty");
                }
                str2 = optString;
            }
            return aVar.a(c0, jSONObject, str2);
        }
        return (hy1) invokeCommon.objValue;
    }

    public hy1 n(@Nullable String str, @NonNull ju1 ju1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, ju1Var)) == null) {
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                q("json str parse fail", null, true);
                return hy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                q("cb is empty", null, true);
                return new hy1(202, "cb is empty");
            }
            return ju1Var.f(jSONObject, optString, this);
        }
        return (hy1) invokeLL.objValue;
    }

    public void q(String str, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048587, this, str, th, z) == null) && p()) {
            g32.e(k(), j(), str, th, z);
        }
    }
}
