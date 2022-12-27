package com.baidu.ubc.service;

import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.jg9;
import com.baidu.tieba.nf1;
import com.baidu.tieba.uf9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.IRemoteUBCService;
import com.baidu.ubc.UBC;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class IPCService implements jg9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(667600129, "Lcom/baidu/ubc/service/IPCService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(667600129, "Lcom/baidu/ubc/service/IPCService;");
                return;
            }
        }
        a = uf9.m();
    }

    public IPCService() {
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

    @Override // com.baidu.tieba.jg9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IPCServiceManager.c(UBC.UBC_REMOTE_SERVICE_NAME, new IRemoteUBCService.Stub(this) { // from class: com.baidu.ubc.service.IPCService.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IPCService this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowCancel(Flow flow) throws RemoteException {
                    UBCManager uBCManager;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, flow) == null) && flow != null && (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
                        uBCManager.flowCancel(flow);
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public String getUploadType(String str) throws RemoteException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                        if (uBCManager != null) {
                            return uBCManager.getUploadType(str);
                        }
                        return "";
                    }
                    return (String) invokeL.objValue;
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLLL(1048576, this, flow, str, str2) == null) && flow != null) {
                        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                        if (uBCManager != null) {
                            uBCManager.flowAddEvent(flow, str, str2);
                        }
                        if (IPCService.a) {
                            Log.d("UBCIPCService", " [add Event] flow id " + flow.getId() + " handler id " + flow.getHandle());
                        }
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public Flow ubcBeginFlow(String str, String str2, int i) throws RemoteException {
                    InterceptResult invokeLLI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLI = interceptable2.invokeLLI(1048585, this, str, str2, i)) == null) {
                        Flow beginFlow = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(str, str2, i);
                        if (IPCService.a && beginFlow != null) {
                            Log.d("UBCIPCService", " process name " + nf1.b() + " flow hashCode " + beginFlow.hashCode() + " flow id " + str + " handle id " + beginFlow.getHandle());
                        }
                        return beginFlow;
                    }
                    return (Flow) invokeLLI.objValue;
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowAddEventWithTime(Flow flow, String str, String str2, long j) throws RemoteException {
                    UBCManager uBCManager;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{flow, str, str2, Long.valueOf(j)}) == null) && flow != null && (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
                        uBCManager.flowAddEventWithDate(flow, str, str2, j);
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowEnd(Flow flow) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048579, this, flow) == null) && flow != null) {
                        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                        if (uBCManager != null) {
                            uBCManager.flowEnd(flow);
                        }
                        if (IPCService.a) {
                            Log.d("UBCIPCService", " [end] flow id " + flow.getId() + " handler id " + flow.getHandle());
                        }
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowEndSlot(Flow flow, String str) throws RemoteException {
                    UBCManager uBCManager;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048580, this, flow, str) == null) && flow != null && (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
                        uBCManager.flowEndSlot(flow, str);
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowSetValue(Flow flow, String str) throws RemoteException {
                    UBCManager uBCManager;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048581, this, flow, str) == null) && flow != null && (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
                        uBCManager.flowSetValue(flow, str);
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
                    UBCManager uBCManager;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048582, this, flow, str) == null) && flow != null && (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
                        uBCManager.flowSetValueWithDuration(flow, str);
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLLL(1048583, this, flow, str, str2) == null) && flow != null) {
                        if (TextUtils.isEmpty(str2)) {
                            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                            if (uBCManager != null) {
                                uBCManager.flowStartSlot(flow, str, null);
                                return;
                            }
                            return;
                        }
                        try {
                            UBCManager uBCManager2 = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                            if (uBCManager2 != null) {
                                uBCManager2.flowStartSlot(flow, str, new JSONObject(str2));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public Flow ubcBeginFlowWithBizInfo(String str, String str2, int i, String str3) throws RemoteException {
                    InterceptResult invokeLLIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(1048586, this, str, str2, i, str3)) == null) {
                        Flow beginFlow = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(str, str2, i);
                        if (IPCService.a && beginFlow != null) {
                            Log.d("UBCIPCService", " process name " + nf1.b() + " flow hashCode " + beginFlow.hashCode() + " flow id " + str + " handle id " + beginFlow.getHandle());
                        }
                        return beginFlow;
                    }
                    return (Flow) invokeLLIL.objValue;
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void ubcOnEvent(String str, String str2, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(1048587, this, str, str2, i) == null) {
                        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, str2, i);
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void ubcOnEventWithBizInfo(String str, String str2, int i, String str3) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048588, this, str, str2, i, str3) == null) {
                        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, str2, i);
                    }
                }

                @Override // com.baidu.ubc.IRemoteUBCService
                public void uploadLocalDatas() throws RemoteException {
                    UBCManager uBCManager;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048589, this) == null) && (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
                        uBCManager.uploadLocalDatas();
                    }
                }
            }, false);
        }
    }

    @Override // com.baidu.tieba.jg9
    public IBinder a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return IPCServiceManager.f(str, true);
        }
        return (IBinder) invokeL.objValue;
    }
}
