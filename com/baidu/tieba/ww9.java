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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ww9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ax9> a;
    public final List<xw9> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948285136, "Lcom/baidu/tieba/ww9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948285136, "Lcom/baidu/tieba/ww9;");
                return;
            }
        }
        c = new a(null);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ww9) {
                ww9 ww9Var = (ww9) obj;
                return Intrinsics.areEqual(this.a, ww9Var.a) && Intrinsics.areEqual(this.b, ww9Var.b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.a.hashCode() * 31) + this.b.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "PushSceneConfig(scenes=" + this.a + ", groups=" + this.b + ')';
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
        public final ww9 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                return new ww9(c(jSONObject.optJSONArray("scene")), b(jSONObject.optJSONArray("group_config")));
            }
            return (ww9) invokeL.objValue;
        }

        public final List<xw9> b(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        xw9 a = xw9.e.a(jSONArray.optJSONObject(i));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public final List<ax9> c(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        ax9 a = ax9.h.a(jSONArray.optJSONObject(i));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }
    }

    public ww9(List<ax9> scenes, List<xw9> groups) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {scenes, groups};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(scenes, "scenes");
        Intrinsics.checkNotNullParameter(groups, "groups");
        this.a = scenes;
        this.b = groups;
    }

    public final List<xw9> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final List<ax9> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }
}
