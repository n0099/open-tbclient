package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class rt2 extends ot2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public static final rt2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-449869221, "Lcom/baidu/tieba/rt2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-449869221, "Lcom/baidu/tieba/rt2$b;");
                    return;
                }
            }
            a = new rt2(null);
        }
    }

    public rt2() {
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

    public static rt2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (rt2) invokeV.objValue;
    }

    public /* synthetic */ rt2(a aVar) {
        this();
    }

    public boolean j(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pMSAppInfo)) == null) {
            return TextUtils.equals(c(pMSAppInfo), "1");
        }
        return invokeL.booleanValue;
    }

    public JSONObject k(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pMSAppInfo)) == null) {
            JSONObject b2 = b(pMSAppInfo);
            if (b2 != null && b2.length() > 0) {
                return b2.optJSONObject("topPages");
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public boolean h(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pMSAppInfo)) == null) {
            JSONObject d = d(pMSAppInfo);
            if (d != null && d.length() > 0) {
                boolean optBoolean = d.optBoolean("is_opti");
                if (ot2.c) {
                    Log.d("SwanAppExtInfo", "is opt pkg  - " + optBoolean);
                }
                return optBoolean;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean i(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo)) == null) {
            JSONObject b2 = b(pMSAppInfo);
            if (b2 != null && b2.has(PrefetchEvent.MODULE)) {
                z = b2.optBoolean(PrefetchEvent.MODULE);
            } else {
                JSONObject a2 = a(pMSAppInfo);
                if (a2 != null && a2.optBoolean(PrefetchEvent.MODULE)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (ot2.c) {
                Log.d("SwanAppExtInfo", "is prefetch on - " + z);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
