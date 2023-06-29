package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class tq9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a h;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public String c;
    public String d;
    public final int e;
    public final int f;
    public final List<String> g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948189997, "Lcom/baidu/tieba/tq9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948189997, "Lcom/baidu/tieba/tq9;");
                return;
            }
        }
        h = new a(null);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof tq9) {
                tq9 tq9Var = (tq9) obj;
                return Intrinsics.areEqual(this.a, tq9Var.a) && Intrinsics.areEqual(this.b, tq9Var.b) && Intrinsics.areEqual(this.c, tq9Var.c) && Intrinsics.areEqual(this.d, tq9Var.d) && this.e == tq9Var.e && this.f == tq9Var.f && Intrinsics.areEqual(this.g, tq9Var.g);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f) * 31) + this.g.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "PushSceneItem(sceneName=" + this.a + ", style=" + this.b + ", title=" + this.c + ", text=" + this.d + ", period=" + this.e + ", threshold=" + this.f + ", sceneClass=" + this.g + ')';
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        @JvmStatic
        public final tq9 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                List<String> b = b(jSONObject.optJSONArray("class"));
                String optString = jSONObject.optString("scene_name");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"scene_name\")");
                String optString2 = jSONObject.optString("style");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"style\")");
                String optString3 = jSONObject.optString("title");
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"title\")");
                String optString4 = jSONObject.optString("text");
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"text\")");
                return new tq9(optString, optString2, optString3, optString4, jSONObject.optInt("freq"), jSONObject.optInt("threshold"), b);
            }
            return (tq9) invokeL.objValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
            if (r4 == true) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<String> b(JSONArray jSONArray) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String optString = jSONArray.optString(i);
                        boolean z2 = true;
                        if (optString != null) {
                            if (optString.length() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        z2 = false;
                        if (z2) {
                            String optString2 = jSONArray.optString(i);
                            Intrinsics.checkNotNullExpressionValue(optString2, "array.optString(i)");
                            arrayList.add(optString2);
                        }
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }
    }

    public tq9(String sceneName, String style, String title, String text, int i, int i2, List<String> sceneClass) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneName, style, title, text, Integer.valueOf(i), Integer.valueOf(i2), sceneClass};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(sceneName, "sceneName");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(sceneClass, "sceneClass");
        this.a = sceneName;
        this.b = style;
        this.c = title;
        this.d = text;
        this.e = i;
        this.f = i2;
        this.g = sceneClass;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.d = str;
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }
    }
}
