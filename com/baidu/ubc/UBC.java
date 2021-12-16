package com.baidu.ubc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import c.a.u0.b0;
import c.a.u0.d;
import c.a.v0.a;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.IRemoteUBCService;
import java.util.Map;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes13.dex */
public class UBC {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_KEY_DURATION = "duration";
    public static final String CONTENT_KEY_EXT = "ext";
    public static final String CONTENT_KEY_FROM = "from";
    public static final String CONTENT_KEY_PAGE = "page";
    public static final String CONTENT_KEY_SOURCE = "source";
    public static final String CONTENT_KEY_TYPE = "type";
    public static final String CONTENT_KEY_VALUE = "value";
    public static final boolean DEBUG;
    public static final int FLAG_DEFAULT_CLOSE = 32;
    public static final int FLAG_DISABLE_REALTIME_UPLOAD = 64;
    public static final int FLAG_DO_NOT_ADD_TIME = 2;
    public static final int FLAG_DO_NOT_USE_CACHE = 1;
    public static final int FLAG_EVENT_FILE = 8;
    public static final int FLAG_SAMPLE = 16;
    public static final int FLAG_UPLOAD_WITHOUT_END = 4;
    public static final int NOVALUE_FOR_KEY_VALUE = -1;
    public static final String TAG = "UBC";
    public static final String UBC_REMOTE_SERVICE_NAME = "remote_ubc_service";
    public static volatile IRemoteUBCService sProxy;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(44367788, "Lcom/baidu/ubc/UBC;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(44367788, "Lcom/baidu/ubc/UBC;");
                return;
            }
        }
        DEBUG = b0.m();
    }

    public UBC() {
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

    public static final Flow beginFlow(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? beginFlow(str, "", 0) : (Flow) invokeL.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? b0.b() : (Context) invokeV.objValue;
    }

    public static IRemoteUBCService getProxy() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (sProxy == null) {
                synchronized (UBC.class) {
                    if (sProxy == null) {
                        IBinder e2 = b0.e(UBC_REMOTE_SERVICE_NAME);
                        if (e2 == null) {
                            throw new RemoteException("UBC get remote service empty !");
                        }
                        if (e2 != null) {
                            sProxy = IRemoteUBCService.Stub.asInterface(e2);
                        }
                    }
                }
            }
            return sProxy;
        }
        return (IRemoteUBCService) invokeV.objValue;
    }

    public static final void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            onEvent(str, "", 0);
        }
    }

    public static void onMutilProcessEvent(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, str, str2, str3) == null) {
            String a = a.a(str3);
            if (DEBUG) {
                String str4 = "on onMultiProcessEvent id:" + str + " value:" + str2 + " name: " + a;
            }
            d.w().z(str, str2, a, 8);
        }
    }

    public static final Flow beginFlow(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) ? beginFlow(str, "", i2) : (Flow) invokeLI.objValue;
    }

    public static final void onEvent(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, str, i2) == null) {
            onEvent(str, "", i2);
        }
    }

    public static final Flow beginFlow(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) ? beginFlow(str, str2, 0) : (Flow) invokeLL.objValue;
    }

    public static final void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            onEvent(str, str2, 0);
        }
    }

    public static final Flow beginFlow(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, jSONObject)) == null) ? beginFlow(str, jSONObject, 0) : (Flow) invokeLL.objValue;
    }

    public static final void onEvent(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, jSONObject) == null) {
            onEvent(str, jSONObject, 0);
        }
    }

    public static final Flow beginFlow(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, map)) == null) ? beginFlow(str, map, 0) : (Flow) invokeLL.objValue;
    }

    public static final void onEvent(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, map) == null) {
            onEvent(str, map, 0);
        }
    }

    public static final Flow beginFlow(String str, Map<String, String> map, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, str, map, i2)) == null) ? ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(str, map, i2) : (Flow) invokeLLI.objValue;
    }

    public static final void onEvent(String str, Map<String, String> map, int i2) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65553, null, str, map, i2) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.onEvent(str, map, i2);
    }

    public static Flow beginFlow(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, str2, i2)) == null) ? ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(str, str2, i2) : (Flow) invokeLLI.objValue;
    }

    public static void onEvent(String str, String str2, int i2) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65551, null, str, str2, i2) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.onEvent(str, str2, i2);
    }

    public static Flow beginFlow(String str, JSONObject jSONObject, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, str, jSONObject, i2)) == null) ? ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(str, jSONObject, i2) : (Flow) invokeLLI.objValue;
    }

    public static void onEvent(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65555, null, str, jSONObject, i2) == null) {
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject, i2);
        }
    }
}
