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
public abstract class n32 implements p32 {
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
    public dy2 h;
    public String i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947951452, "Lcom/baidu/tieba/n32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947951452, "Lcom/baidu/tieba/n32;");
                return;
            }
        }
        boolean z = ho1.a;
    }

    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            n32 n32Var = (n32) super.clone();
            dy2 dy2Var = this.h;
            if (dy2Var != null) {
                n32Var.h = (dy2) dy2Var.clone();
            } else {
                n32Var.h = null;
            }
            return n32Var;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.wx2
    public boolean isValid() {
        InterceptResult invokeV;
        dy2 dy2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && (dy2Var = this.h) != null && dy2Var.h()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public n32(@NonNull String str, @NonNull String str2) {
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
            q42.a("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.i = str2;
        } else {
            q42.a("Component-Model-Base", "component id key is empty");
        }
    }

    @Override // com.baidu.tieba.wx2
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
            x42.c("Component-Model-Base", this.a + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId");
        this.c = optString3;
        if (TextUtils.isEmpty(optString3)) {
            x42.c("Component-Model-Base", this.a + " component slaveId is empty");
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
                x42.c("Component-Model-Base", this.a + " component componentId is empty");
            }
            String optString3 = jSONObject.optString("slaveId", this.c);
            this.c = optString3;
            if (TextUtils.isEmpty(optString3)) {
                x42.c("Component-Model-Base", this.a + " component slaveId is empty");
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
            dy2 dy2Var = this.h;
            int i4 = -1;
            if (dy2Var != null) {
                i = dy2Var.f();
            } else {
                i = -1;
            }
            dy2 dy2Var2 = this.h;
            if (dy2Var2 != null) {
                i4 = dy2Var2.c();
            }
            dy2 dy2Var3 = this.h;
            if (dy2Var3 != null) {
                i2 = dy2Var3.d();
            } else {
                i2 = 0;
            }
            dy2 dy2Var4 = this.h;
            if (dy2Var4 != null) {
                i3 = dy2Var4.e();
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

    public final void e(JSONObject jSONObject, @NonNull n32 n32Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, jSONObject, n32Var) != null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.i, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.b = optString;
            if (TextUtils.isEmpty(optString)) {
                this.b = jSONObject.optString(this.i, n32Var.b);
            }
        } else {
            String optString2 = jSONObject.optString(this.i);
            this.b = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.b = jSONObject.optString("componentId", n32Var.b);
            }
        }
        if (TextUtils.isEmpty(this.b)) {
            x42.c("Component-Model-Base", this.a + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId", n32Var.c);
        this.c = optString3;
        if (TextUtils.isEmpty(optString3)) {
            x42.c("Component-Model-Base", this.a + " component slaveId is empty");
        }
        this.d = jSONObject.optString("parentId", n32Var.d);
        this.e = jSONObject.optString("cb", n32Var.e);
        this.f = jSONObject.optBoolean("hide", n32Var.f);
        if (n32Var.g) {
            str = "1";
        } else {
            str = "0";
        }
        this.g = TextUtils.equals(jSONObject.optString("gesture", str), "1");
        dy2 dy2Var = n32Var.h;
        this.h = dy2Var;
        if (dy2Var == null) {
            this.h = new dy2();
        }
        f(jSONObject);
    }

    public final void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject(CriusAttrConstants.POSITION)) != null) {
            dy2 dy2Var = new dy2();
            this.h = dy2Var;
            dy2Var.l(ol3.g(c(optJSONObject, "left", 0.0f)));
            this.h.m(ol3.g(c(optJSONObject, "top", 0.0f)));
            this.h.n(ol3.g(c(optJSONObject, "width", 0.0f)));
            this.h.j(ol3.g(c(optJSONObject, "height", 0.0f)));
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
