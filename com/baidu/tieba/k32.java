package com.baidu.tieba;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class k32 implements m32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    @Nullable
    public ay2 h;
    public String i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947862079, "Lcom/baidu/tieba/k32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947862079, "Lcom/baidu/tieba/k32;");
                return;
            }
        }
        boolean z = eo1.a;
    }

    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            k32 k32Var = (k32) super.clone();
            ay2 ay2Var = this.h;
            if (ay2Var != null) {
                k32Var.h = (ay2) ay2Var.clone();
            } else {
                k32Var.h = null;
            }
            return k32Var;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.tx2
    public boolean isValid() {
        InterceptResult invokeV;
        ay2 ay2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && (ay2Var = this.h) != null && ay2Var.h()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public k32(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "unknown";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = false;
        this.g = false;
        this.i = "id";
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
        } else {
            n42.a("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.i = str2;
        } else {
            n42.a("Component-Model-Base", "component id key is empty");
        }
    }

    @Override // com.baidu.tieba.tx2
    @CallSuper
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.i, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.b = optString;
            if (TextUtils.isEmpty(optString)) {
                this.b = jSONObject.optString(this.i);
            }
        } else {
            String optString2 = jSONObject.optString(this.i);
            this.b = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.b = jSONObject.optString("componentId");
            }
        }
        if (TextUtils.isEmpty(this.b)) {
            u42.c("Component-Model-Base", this.a + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId");
        this.c = optString3;
        if (TextUtils.isEmpty(optString3)) {
            u42.c("Component-Model-Base", this.a + " component slaveId is empty");
        }
        this.d = jSONObject.optString("parentId");
        this.e = jSONObject.optString("cb");
        this.f = jSONObject.optBoolean("hide", false);
        this.g = TextUtils.equals(jSONObject.optString("gesture"), "1");
        f(jSONObject);
    }

    public void g(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            if (!TextUtils.equals(this.i, "ARCameraId")) {
                String optString = jSONObject.optString("componentId");
                this.b = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.b = jSONObject.optString(this.i, this.b);
                }
            } else {
                String optString2 = jSONObject.optString(this.i);
                this.b = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    this.b = jSONObject.optString("componentId", this.b);
                }
            }
            if (TextUtils.isEmpty(this.b)) {
                u42.c("Component-Model-Base", this.a + " component componentId is empty");
            }
            String optString3 = jSONObject.optString("slaveId", this.c);
            this.c = optString3;
            if (TextUtils.isEmpty(optString3)) {
                u42.c("Component-Model-Base", this.a + " component slaveId is empty");
            }
            this.d = jSONObject.optString("parentId", this.d);
            this.e = jSONObject.optString("cb", this.e);
            this.f = jSONObject.optBoolean("hide", this.f);
            if (this.g) {
                str = "1";
            } else {
                str = "0";
            }
            this.g = TextUtils.equals(jSONObject.optString("gesture", str), "1");
            f(jSONObject);
        }
    }

    public final FrameLayout.LayoutParams b() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ay2 ay2Var = this.h;
            int i4 = -1;
            if (ay2Var != null) {
                i = ay2Var.f();
            } else {
                i = -1;
            }
            ay2 ay2Var2 = this.h;
            if (ay2Var2 != null) {
                i4 = ay2Var2.c();
            }
            ay2 ay2Var3 = this.h;
            if (ay2Var3 != null) {
                i2 = ay2Var3.d();
            } else {
                i2 = 0;
            }
            ay2 ay2Var4 = this.h;
            if (ay2Var4 != null) {
                i3 = ay2Var4.e();
            } else {
                i3 = 0;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i4);
            layoutParams.setMargins(i2, i3, 0, 0);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    @NonNull
    public final String d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("【");
            sb.append(this.a);
            sb.append("#");
            if (TextUtils.isEmpty(this.b)) {
                str = "";
            } else {
                str = this.b;
            }
            sb.append(str);
            sb.append("】");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final float c(JSONObject jSONObject, String str, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONObject, str, Float.valueOf(f)})) == null) {
            if (jSONObject == null) {
                return f;
            }
            return (float) jSONObject.optDouble(str, f);
        }
        return invokeCommon.floatValue;
    }

    public final void e(JSONObject jSONObject, @NonNull k32 k32Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, jSONObject, k32Var) != null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.i, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.b = optString;
            if (TextUtils.isEmpty(optString)) {
                this.b = jSONObject.optString(this.i, k32Var.b);
            }
        } else {
            String optString2 = jSONObject.optString(this.i);
            this.b = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.b = jSONObject.optString("componentId", k32Var.b);
            }
        }
        if (TextUtils.isEmpty(this.b)) {
            u42.c("Component-Model-Base", this.a + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId", k32Var.c);
        this.c = optString3;
        if (TextUtils.isEmpty(optString3)) {
            u42.c("Component-Model-Base", this.a + " component slaveId is empty");
        }
        this.d = jSONObject.optString("parentId", k32Var.d);
        this.e = jSONObject.optString("cb", k32Var.e);
        this.f = jSONObject.optBoolean("hide", k32Var.f);
        if (k32Var.g) {
            str = "1";
        } else {
            str = "0";
        }
        this.g = TextUtils.equals(jSONObject.optString("gesture", str), "1");
        ay2 ay2Var = k32Var.h;
        this.h = ay2Var;
        if (ay2Var == null) {
            this.h = new ay2();
        }
        f(jSONObject);
    }

    public final void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject(CriusAttrConstants.POSITION)) != null) {
            ay2 ay2Var = new ay2();
            this.h = ay2Var;
            ay2Var.l(ll3.g(c(optJSONObject, "left", 0.0f)));
            this.h.m(ll3.g(c(optJSONObject, "top", 0.0f)));
            this.h.n(ll3.g(c(optJSONObject, "width", 0.0f)));
            this.h.j(ll3.g(c(optJSONObject, "height", 0.0f)));
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "SwanAppBaseComponentModel{componentType='" + this.a + "', componentId='" + this.b + "', slaveId='" + this.c + "', parentId='" + this.d + "', callback='" + this.e + "', hidden=" + this.f + ", gesture=" + this.g + ", position=" + this.h + ", mComponentIdKey='" + this.i + "'}";
        }
        return (String) invokeV.objValue;
    }
}
