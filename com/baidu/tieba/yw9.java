package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhKeyValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class yw9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final List<zw9> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948344718, "Lcom/baidu/tieba/yw9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948344718, "Lcom/baidu/tieba/yw9;");
                return;
            }
        }
        c = new a(null);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof yw9) {
                yw9 yw9Var = (yw9) obj;
                return Intrinsics.areEqual(this.a, yw9Var.a) && Intrinsics.areEqual(this.b, yw9Var.b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.a.hashCode() * 31) + this.b.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "PushSceneGroupRecord(date=" + this.a + ", groups=" + this.b + ')';
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

        public final List<zw9> a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("groups");
                if (optJSONArray == null) {
                    return new ArrayList();
                }
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    zw9 a = zw9.c.a(optJSONArray.optJSONObject(i));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        @JvmStatic
        public final yw9 b(String str) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(GfhKeyValue.TYPE_DATE);
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(\"date\")");
                return new yw9(optString, a(jSONObject));
            }
            return (yw9) invokeL.objValue;
        }
    }

    public yw9(String date, List<zw9> groups) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {date, groups};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(groups, "groups");
        this.a = date;
        this.b = groups;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final List<zw9> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return Intrinsics.areEqual(this.a, xi.getDateStringDay(new Date()));
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String dateStringDay = xi.getDateStringDay(new Date());
            if (dateStringDay == null) {
                dateStringDay = "";
            }
            this.a = dateStringDay;
            this.b.clear();
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            zw9 zw9Var = null;
            for (zw9 zw9Var2 : this.b) {
                if (zw9Var2.a() == i) {
                    zw9Var = zw9Var2;
                }
            }
            if (zw9Var == null) {
                this.b.add(new zw9(i, 1));
                return;
            }
            zw9Var.c(zw9Var.b() + 1);
        }
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.a = str;
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (zw9 zw9Var : this.b) {
                jSONArray.put(zw9Var.d());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(GfhKeyValue.TYPE_DATE, this.a);
            jSONObject.put("groups", jSONArray);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …ray)\n        }.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }
}
