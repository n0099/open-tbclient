package com.bytedance.pangle.service.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d;
import com.bytedance.pangle.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.servermanager.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
@Keep
/* loaded from: classes2.dex */
public class ServiceManagerNative {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ServiceManagerNative sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<ServiceConnection, HashSet<ServiceInfo>> conn2Service;
    public HashMap<IBinder, HashMap<ServiceConnection, HashSet<ComponentName>>> process2ConnAndService;
    public final HashMap<ServiceConnection, f> serviceConn2ServiceConn;

    public ServiceManagerNative() {
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
        this.serviceConn2ServiceConn = new HashMap<>();
        this.process2ConnAndService = new HashMap<>();
        this.conn2Service = new HashMap<>();
    }

    public static ServiceManagerNative getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (ServiceManagerNative.class) {
                    if (sInstance == null) {
                        sInstance = new ServiceManagerNative();
                    }
                }
            }
            return sInstance;
        }
        return (ServiceManagerNative) invokeV.objValue;
    }

    public boolean bindServiceNative(Context context, Intent intent, ServiceConnection serviceConnection, int i2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, intent, serviceConnection, Integer.valueOf(i2), str})) == null) {
            ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
            if (queryServiceFromPlugin == null) {
                return context.bindService(intent, serviceConnection, i2);
            }
            if (!this.serviceConn2ServiceConn.containsKey(serviceConnection)) {
                this.serviceConn2ServiceConn.put(serviceConnection, new f.a(this, serviceConnection) { // from class: com.bytedance.pangle.service.client.ServiceManagerNative.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ServiceConnection a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ServiceManagerNative f53129b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, serviceConnection};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f53129b = this;
                        this.a = serviceConnection;
                    }

                    @Override // com.bytedance.pangle.f
                    public final void a(ComponentName componentName, IBinder iBinder) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName, iBinder) == null) {
                            this.a.onServiceConnected(componentName, iBinder);
                        }
                    }

                    @Override // com.bytedance.pangle.f
                    public final int a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.a.hashCode() : invokeV.intValue;
                    }
                });
            }
            if (this.conn2Service.get(serviceConnection) == null) {
                this.conn2Service.put(serviceConnection, new HashSet<>());
            }
            this.conn2Service.get(serviceConnection).add(queryServiceFromPlugin);
            d a = b.a(queryServiceFromPlugin.processName);
            IBinder asBinder = a.asBinder();
            HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = this.process2ConnAndService.get(asBinder);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                this.process2ConnAndService.put(asBinder, hashMap);
            }
            HashSet<ComponentName> hashSet = hashMap.get(serviceConnection);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                hashMap.put(serviceConnection, hashSet);
            }
            hashSet.add(intent.getComponent());
            try {
                return a.a(intent, this.serviceConn2ServiceConn.get(serviceConnection), i2, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                ZeusLogger.e(ZeusLogger.TAG_SERVICE, "bindService failed!", e2);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public ServiceInfo queryServiceFromPlugin(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, str)) == null) {
            Zeus.loadPlugin(str);
            return PluginManager.getInstance().getPlugin(str).pluginServices.get(intent.getComponent().getClassName());
        }
        return (ServiceInfo) invokeLL.objValue;
    }

    public ComponentName startServiceNative(Context context, Intent intent, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, intent, str)) == null) {
            ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
            if (queryServiceFromPlugin == null) {
                return context.startService(intent);
            }
            try {
                return b.a(queryServiceFromPlugin.processName).a(intent, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (ComponentName) invokeLLL.objValue;
    }

    public boolean stopServiceNative(Context context, Intent intent, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, intent, str)) == null) {
            ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
            if (queryServiceFromPlugin == null) {
                return context.stopService(intent);
            }
            try {
                return b.a(queryServiceFromPlugin.processName).b(intent, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public void unbindServiceNative(ServiceConnection serviceConnection) {
        HashSet<ServiceInfo> hashSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, serviceConnection) == null) || (hashSet = this.conn2Service.get(serviceConnection)) == null) {
            return;
        }
        Iterator<ServiceInfo> it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                b.a(it.next().processName).a(this.serviceConn2ServiceConn.get(serviceConnection));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
