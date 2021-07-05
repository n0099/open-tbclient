package com.baidu.wallet.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class Domains implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final EnumSet<Permission> ALL_PERMISSION;
    public static final String BAIDU = ".baidu.com";
    public static final String BAIFUBAO = ".baifubao.com";
    public static final String BAI_YING_FUND = ".baiyingfund.com";
    public static final Map<String, EnumSet<Permission>> DEFAULT_PERMISSION_CONFIG;
    public static final String DU_XIAO_MAN = ".duxiaoman.com";
    public static final String DU_XIAO_MAN_FUND = ".duxiaomanfund.com";
    public static final String DU_XIAO_MAN_INT = ".duxiaoman-int.com";
    public static final String DU_XIAO_MAN_PAY = ".dxmpay.com";
    public static final String NUOMI = ".nuomi.com";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, EnumSet<Permission>> mDomainsPermissionConfig;

    /* renamed from: com.baidu.wallet.core.Domains$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Domains f24554a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-819846249, "Lcom/baidu/wallet/core/Domains$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-819846249, "Lcom/baidu/wallet/core/Domains$a;");
                    return;
                }
            }
            f24554a = new Domains(null);
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-586327308, "Lcom/baidu/wallet/core/Domains;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-586327308, "Lcom/baidu/wallet/core/Domains;");
                return;
            }
        }
        DEFAULT_PERMISSION_CONFIG = new HashMap();
        EnumSet<Permission> of = EnumSet.of(Permission.NONE, Permission.READ_NORMAL, Permission.READ_PRIVATE, Permission.WRITE, Permission.READ_DEVICE);
        ALL_PERMISSION = of;
        DEFAULT_PERMISSION_CONFIG.put(BAIDU, of);
        DEFAULT_PERMISSION_CONFIG.put(NUOMI, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(BAIFUBAO, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN_FUND, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(BAI_YING_FUND, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN_PAY, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN_INT, ALL_PERMISSION);
    }

    public /* synthetic */ Domains(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static final Domains getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f24554a : (Domains) invokeV.objValue;
    }

    public Map<String, EnumSet<Permission>> getDomainsPermissionConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, EnumSet<Permission>> map = this.mDomainsPermissionConfig;
            if (map != null && !map.isEmpty()) {
                return this.mDomainsPermissionConfig;
            }
            return DEFAULT_PERMISSION_CONFIG;
        }
        return (Map) invokeV.objValue;
    }

    public void setDomainsPermissionConfig(Map<String, EnumSet<Permission>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
            this.mDomainsPermissionConfig = map;
        }
    }

    public Domains() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
