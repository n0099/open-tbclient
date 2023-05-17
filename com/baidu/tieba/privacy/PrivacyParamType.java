package com.baidu.tieba.privacy;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001aH\u0007J\b\u0010\u001c\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R!\u0010\n\u001a\u00020\u000b8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000eR!\u0010\u0011\u001a\u00020\u000b8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u000eR!\u0010\u0015\u001a\u00020\u000b8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/privacy/PrivacyParamType;", "", "()V", "KEY_PRIVACY_COMMON_PARAM_A", "", "KEY_PRIVACY_COMMON_PARAM_ANDROID", "KEY_PRIVACY_COOKIE_PARAM_A", "KEY_PRIVACY_COOKIE_PARAM_ANDROID", "KEY_PRIVACY_MAC_PARAM_A", "KEY_PRIVACY_MAC_PARAM_ANDROID", "commonParamSwitch", "", "getCommonParamSwitch$annotations", "getCommonParamSwitch", "()I", "commonParamSwitch$delegate", "Lkotlin/Lazy;", "cookieParamSwitch", "getCookieParamSwitch$annotations", "getCookieParamSwitch", "cookieParamSwitch$delegate", "macParamSwitch", "getMacParamSwitch$annotations", "getMacParamSwitch", "macParamSwitch$delegate", "isPrivacyCookieParamA", "", "isPrivacyMacParamA", "isPrivacyRequestParamA", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PrivacyParamType {
    public static /* synthetic */ Interceptable $ic;
    public static final PrivacyParamType a;
    public static final Lazy b;
    public static final Lazy c;
    public static final Lazy d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1284750439, "Lcom/baidu/tieba/privacy/PrivacyParamType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1284750439, "Lcom/baidu/tieba/privacy/PrivacyParamType;");
                return;
            }
        }
        a = new PrivacyParamType();
        b = LazyKt__LazyJVMKt.lazy(PrivacyParamType$commonParamSwitch$2.INSTANCE);
        c = LazyKt__LazyJVMKt.lazy(PrivacyParamType$cookieParamSwitch$2.INSTANCE);
        d = LazyKt__LazyJVMKt.lazy(PrivacyParamType$macParamSwitch$2.INSTANCE);
    }

    public PrivacyParamType() {
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

    public static final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return ((Number) b.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public static final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return ((Number) c.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public static final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return ((Number) d.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    @JvmStatic
    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return UbsABTestHelper.isExistSid("12_40_privacy_cookie_param_a");
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return UbsABTestHelper.isExistSid("12_40_privacy_mac_param_a");
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return UbsABTestHelper.isExistSid("12_40_privacy_common_param_a");
        }
        return invokeV.booleanValue;
    }
}
