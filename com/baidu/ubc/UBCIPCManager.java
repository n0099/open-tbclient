package com.baidu.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.b.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.IRemoteUBCService;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class UBCIPCManager {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f59349a = "UBCIPCManager";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(837537915, "Lcom/baidu/ubc/UBCIPCManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(837537915, "Lcom/baidu/ubc/UBCIPCManager;");
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            IPCServiceManager.c(UBC.UBC_REMOTE_SERVICE_NAME, new IRemoteUBCService.Stub() { // from class: com.baidu.ubc.UBCIPCManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, flow, str, str2) == null) || flow == null) {
                        return;
                    }
                    flow.addEvent(str, str2);
                    if (AppConfig.isDebug()) {
                        String unused = UBCIPCManager.f59349a;
                        String str3 = " [add Event] flow id " + flow.getId() + " handler id " + flow.getHandle();
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowAddEventWithTime(Flow flow, String str, String str2, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{flow, str, str2, Long.valueOf(j2)}) == null) || flow == null) {
                        return;
                    }
                    flow.addEvent(str, str2, j2);
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowCancel(Flow flow) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, flow) == null) || flow == null) {
                        return;
                    }
                    flow.cancel();
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowEnd(Flow flow) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048579, this, flow) == null) || flow == null) {
                        return;
                    }
                    flow.end();
                    if (AppConfig.isDebug()) {
                        String unused = UBCIPCManager.f59349a;
                        String str = " [end] flow id " + flow.getId() + " handler id " + flow.getHandle();
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowEndSlot(Flow flow, String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048580, this, flow, str) == null) || flow == null) {
                        return;
                    }
                    flow.endSlot(str);
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowSetValue(Flow flow, String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048581, this, flow, str) == null) || flow == null) {
                        return;
                    }
                    flow.setValue(str);
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048582, this, flow, str) == null) || flow == null) {
                        return;
                    }
                    flow.setValueWithDuration(str);
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(1048583, this, flow, str, str2) == null) || flow == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        flow.startSlot(str, null);
                        return;
                    }
                    try {
                        flow.startSlot(str, new JSONObject(str2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public String getUploadType(String str) throws RemoteException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? UBC.getUploadType(str) : (String) invokeL.objValue;
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public Flow ubcBeginFlow(String str, String str2, int i2) throws RemoteException {
                    InterceptResult invokeLLI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLI = interceptable2.invokeLLI(1048585, this, str, str2, i2)) == null) {
                        Flow beginFlow = UBC.beginFlow(str, str2, i2);
                        if (AppConfig.isDebug() && beginFlow != null) {
                            String unused = UBCIPCManager.f59349a;
                            String str3 = " process name " + a.b() + " flow hashCode " + beginFlow.hashCode() + " flow id " + str + " handle id " + beginFlow.getHandle();
                        }
                        return beginFlow;
                    }
                    return (Flow) invokeLLI.objValue;
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void ubcOnEvent(String str, String str2, int i2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(1048586, this, str, str2, i2) == null) {
                        UBC.onEvent(str, str2, i2);
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void uploadLocalDatas() throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048587, this) == null) {
                        UBC.uploadLocalDatas();
                    }
                }
            }, false);
        }
    }
}
