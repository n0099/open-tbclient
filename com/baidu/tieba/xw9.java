package com.baidu.tieba;

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
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class xw9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a e;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public final List<String> c;
    public final int d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314927, "Lcom/baidu/tieba/xw9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314927, "Lcom/baidu/tieba/xw9;");
                return;
            }
        }
        e = new a(null);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof xw9) {
                xw9 xw9Var = (xw9) obj;
                return Intrinsics.areEqual(this.a, xw9Var.a) && this.b == xw9Var.b && Intrinsics.areEqual(this.c, xw9Var.c) && this.d == xw9Var.d;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "PushSceneGroup(groupName=" + this.a + ", groupNo=" + this.b + ", groupList=" + this.c + ", limit=" + this.d + ')';
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
        public final xw9 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                List<String> b = b(jSONObject.optJSONArray("group"));
                String optString = jSONObject.optString("group_name");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"group_name\")");
                return new xw9(optString, jSONObject.optInt("group_no"), b, jSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT));
            }
            return (xw9) invokeL.objValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
            if (r5 == true) goto L13;
         */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List, T, java.util.ArrayList] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<String> b(JSONArray jSONArray) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new ArrayList();
                if (jSONArray != null) {
                    ?? arrayList = new ArrayList();
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
                    objectRef.element = arrayList;
                }
                return (List) objectRef.element;
            }
            return (List) invokeL.objValue;
        }
    }

    public xw9(String groupName, int i, List<String> groupList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupName, Integer.valueOf(i), groupList, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(groupList, "groupList");
        this.a = groupName;
        this.b = i;
        this.c = groupList;
        this.d = i2;
    }

    public final List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }
}
