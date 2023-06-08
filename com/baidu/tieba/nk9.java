package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.privacy.PrivacyParamType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes7.dex */
public final class nk9 {
    public static /* synthetic */ Interceptable $ic;
    public static final nk9 a;
    public static final HashMap<String, String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948005485, "Lcom/baidu/tieba/nk9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948005485, "Lcom/baidu/tieba/nk9;");
                return;
            }
        }
        a = new nk9();
        b = MapsKt__MapsKt.hashMapOf(TuplesKt.to("mac", HttpRequest.MAC_REVERSAL));
    }

    public nk9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (PrivacyParamType.e()) {
                return true;
            }
            if (PrivacyParamType.c() != 1 && PrivacyParamType.c() != 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (PrivacyParamType.e() || PrivacyParamType.c() != 1) {
                return "0";
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return a(PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final String a(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return "";
            }
            if (PrivacyParamType.e()) {
                return str;
            }
            int c = PrivacyParamType.c();
            if (c != 1) {
                if (c == 2) {
                    return "";
                }
                return str;
            }
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] B64Encode = Base64Encoder.B64Encode(bytes);
            if (B64Encode == null) {
                return "";
            }
            return new String(B64Encode, Charsets.UTF_8);
        }
        return (String) invokeL.objValue;
    }

    @JvmStatic
    public static final String d(String key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, key)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (PrivacyParamType.e()) {
                return key;
            }
            int c = PrivacyParamType.c();
            if (c != 1) {
                if (c == 2) {
                    return "";
                }
                return key;
            }
            String str = b.get(key);
            if (str != null) {
                return str;
            }
            return key;
        }
        return (String) invokeL.objValue;
    }
}
