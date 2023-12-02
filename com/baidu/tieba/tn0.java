package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class tn0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    @JvmField
    public String c;
    public final String d;
    public final String e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948186835, "Lcom/baidu/tieba/tn0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948186835, "Lcom/baidu/tieba/tn0;");
                return;
            }
        }
        f = new a(null);
    }

    @JvmStatic
    public static final tn0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? f.a(jSONObject) : (tn0) invokeL.objValue;
    }

    @JvmStatic
    public static final tn0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f.b() : (tn0) invokeV.objValue;
    }

    @JvmStatic
    public static final JSONObject g(tn0 tn0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tn0Var)) == null) ? f.c(tn0Var) : (JSONObject) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof tn0) {
                    tn0 tn0Var = (tn0) obj;
                    return Intrinsics.areEqual(this.a, tn0Var.a) && Intrinsics.areEqual(this.b, tn0Var.b) && Intrinsics.areEqual(this.c, tn0Var.c) && Intrinsics.areEqual(this.d, tn0Var.d) && Intrinsics.areEqual(this.e, tn0Var.e);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.d;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.e;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "ExtPolicy(invokeTaskId=" + this.a + ", backCmd=" + this.b + ", sdkSwitch=" + this.c + ", defaultLimit=" + this.d + ", completeInfo=" + this.e + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        public final tn0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new tn0("", "", "0", "1", "");
            }
            return (tn0) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final tn0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    String optString = jSONObject.optString("invoke_task_id");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(\"invoke_task_id\")");
                    String optString2 = jSONObject.optString("back_cmd");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"back_cmd\")");
                    String optString3 = jSONObject.optString("sdk_switch", "0");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"sdk_switch\", \"0\")");
                    String optString4 = jSONObject.optString("default_upper_limit", "1");
                    Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"default_upper_limit\", \"1\")");
                    String optString5 = jSONObject.optString("complete_info");
                    Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"complete_info\")");
                    return new tn0(optString, optString2, optString3, optString4, optString5);
                }
                return null;
            }
            return (tn0) invokeL.objValue;
        }

        @JvmStatic
        public final JSONObject c(tn0 tn0Var) {
            InterceptResult invokeL;
            String e;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tn0Var)) == null) {
                JSONObject jSONObject = new JSONObject();
                String str3 = null;
                if (tn0Var != null) {
                    try {
                        e = tn0Var.e();
                    } catch (JSONException unused) {
                    }
                } else {
                    e = null;
                }
                JSONObject put = jSONObject.put("invoke_task_id", e);
                if (tn0Var != null) {
                    str = tn0Var.b();
                } else {
                    str = null;
                }
                JSONObject put2 = put.put("back_cmd", str);
                if (tn0Var != null) {
                    str2 = tn0Var.c;
                } else {
                    str2 = null;
                }
                JSONObject put3 = put2.put("sdk_switch", str2);
                if (tn0Var != null) {
                    str3 = tn0Var.c();
                }
                put3.put("complete_info", str3);
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }
    }

    public tn0(String invokeTaskId, String backCmd, String sdkSwitch, String defaultLimit, String completeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invokeTaskId, backCmd, sdkSwitch, defaultLimit, completeInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(invokeTaskId, "invokeTaskId");
        Intrinsics.checkNotNullParameter(backCmd, "backCmd");
        Intrinsics.checkNotNullParameter(sdkSwitch, "sdkSwitch");
        Intrinsics.checkNotNullParameter(defaultLimit, "defaultLimit");
        Intrinsics.checkNotNullParameter(completeInfo, "completeInfo");
        this.a = invokeTaskId;
        this.b = backCmd;
        this.c = sdkSwitch;
        this.d = defaultLimit;
        this.e = completeInfo;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
