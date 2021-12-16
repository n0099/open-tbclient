package com.baidu.wallet.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
/* loaded from: classes13.dex */
public class Domains implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_JSIPC = "{\".baidu.com\": 15, \".dxmbaoxian.com\":15, \".nuomi.com\": 15, \".baifubao.com\": 15, \".duxiaoman.com\": 15, \".baiyingfund.com\": 15, \".duxiaomanfund.com\": 15, \".dxmpay.com\": 15, \"bdtrust.gt-trust.com\": 10, \"bdtrust.mintrust.com\": 10, \"bdtrust.ebtrust.com\": 10, \"bdtrust.cfitc.com\":10}";
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, EnumSet<Permission>> DEFAULT_PERMISSION_CONFIG;
    public Map<String, EnumSet<Permission>> mDomainsPermissionConfig;

    /* renamed from: com.baidu.wallet.core.Domains$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes13.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final Domains a;
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
            a = new Domains(null);
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

    public /* synthetic */ Domains(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static final Domains getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (Domains) invokeV.objValue;
    }

    public Map<String, EnumSet<Permission>> getDomainsPermissionConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, EnumSet<Permission>> map = this.mDomainsPermissionConfig;
            if (map != null && !map.isEmpty()) {
                LogUtil.d("Domains", "use the online jsipc");
                return this.mDomainsPermissionConfig;
            }
            LogUtil.d("Domains", "use the default jsipc");
            return this.DEFAULT_PERMISSION_CONFIG;
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
        Map<String, EnumSet<Permission>> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            LogUtil.d("Domains", "parse the default jsipc: {\".baidu.com\": 15, \".dxmbaoxian.com\":15, \".nuomi.com\": 15, \".baifubao.com\": 15, \".duxiaoman.com\": 15, \".baiyingfund.com\": 15, \".duxiaomanfund.com\": 15, \".dxmpay.com\": 15, \"bdtrust.gt-trust.com\": 10, \"bdtrust.mintrust.com\": 10, \"bdtrust.ebtrust.com\": 10, \"bdtrust.cfitc.com\":10}");
            hashMap = Permission.parseDomainsConfig(DEFAULT_JSIPC);
        } catch (JSONException unused) {
            hashMap = new HashMap<>();
        }
        this.DEFAULT_PERMISSION_CONFIG = hashMap;
    }
}
