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
/* loaded from: classes7.dex */
public final class n1a {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final List<o1a> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947950987, "Lcom/baidu/tieba/n1a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947950987, "Lcom/baidu/tieba/n1a;");
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
            if (obj instanceof n1a) {
                n1a n1aVar = (n1a) obj;
                return Intrinsics.areEqual(this.a, n1aVar.a) && Intrinsics.areEqual(this.b, n1aVar.b);
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

    /* loaded from: classes7.dex */
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

        public final List<o1a> a(JSONObject jSONObject) {
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
                    o1a a = o1a.c.a(optJSONArray.optJSONObject(i));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        @JvmStatic
        public final n1a b(String str) {
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
                return new n1a(optString, a(jSONObject));
            }
            return (n1a) invokeL.objValue;
        }
    }

    public n1a(String date, List<o1a> groups) {
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

    public final List<o1a> b() {
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
            return Intrinsics.areEqual(this.a, ei.getDateStringDay(new Date()));
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String dateStringDay = ei.getDateStringDay(new Date());
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
            o1a o1aVar = null;
            for (o1a o1aVar2 : this.b) {
                if (o1aVar2.a() == i) {
                    o1aVar = o1aVar2;
                }
            }
            if (o1aVar == null) {
                this.b.add(new o1a(i, 1));
                return;
            }
            o1aVar.c(o1aVar.b() + 1);
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
            for (o1a o1aVar : this.b) {
                jSONArray.put(o1aVar.d());
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
