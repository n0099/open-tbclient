package com.bytedance.pangle.servermanager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d;
import com.bytedance.pangle.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f61482a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f61483b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f61484c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Boolean> f61485d;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, e> f61486e;

    /* renamed from: f  reason: collision with root package name */
    public static d f61487f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1152393428, "Lcom/bytedance/pangle/servermanager/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1152393428, "Lcom/bytedance/pangle/servermanager/b;");
                return;
            }
        }
        f61482a = new Object();
        f61483b = new Object();
        f61484c = new Object();
        f61485d = new ConcurrentHashMap();
        f61486e = new ConcurrentHashMap();
    }

    public static e a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Boolean bool = f61485d.get(str);
            if (bool == null || !bool.booleanValue()) {
                f61486e.remove(str);
            }
            if (f61486e.get(str) == null) {
                synchronized (f61483b) {
                    e eVar = (e) a("service", str);
                    if (eVar == null) {
                        ZeusLogger.e(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                        return null;
                    }
                    f61486e.put(str, eVar);
                }
            }
            return f61486e.get(str);
        }
        return (e) invokeL.objValue;
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Boolean bool = f61485d.get(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
            if (bool == null || !bool.booleanValue()) {
                f61487f = null;
            }
            if (f61487f == null) {
                synchronized (f61484c) {
                    d dVar = (d) a("package", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
                    if (dVar == null) {
                        ZeusLogger.e(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                        return null;
                    }
                    f61487f = dVar;
                }
            }
            return f61487f;
        }
        return (d) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f A[Catch: RemoteException -> 0x0098, TryCatch #0 {RemoteException -> 0x0098, blocks: (B:15:0x0054, B:30:0x008e, B:32:0x0093, B:20:0x0075, B:23:0x007f), top: B:43:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093 A[Catch: RemoteException -> 0x0098, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x0098, blocks: (B:15:0x0054, B:30:0x008e, B:32:0x0093, B:20:0x0075, B:23:0x007f), top: B:43:0x0054 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static IInterface a(String str, String str2) {
        InterceptResult invokeLL;
        ProviderInfo providerInfo;
        IBinder iBinder;
        int hashCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (Zeus.getServerManagerHashMap().get(str2) != null) {
                Bundle call = Zeus.getAppApplication().getContentResolver().call(Uri.parse("content://" + providerInfo.authority), AbsServerManager.METHOD_QUERY_BINDER, str, (Bundle) null);
                if (call != null) {
                    call.setClassLoader(AbsServerManager.class.getClassLoader());
                    a aVar = (a) call.getParcelable(AbsServerManager.BUNDLE_BINDER);
                    if (aVar != null) {
                        iBinder = aVar.f61481a;
                        if (iBinder != null && iBinder.isBinderAlive()) {
                            try {
                                char c2 = 0;
                                iBinder.linkToDeath(new IBinder.DeathRecipient(str2, iBinder) { // from class: com.bytedance.pangle.servermanager.b.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ String f61488a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ IBinder f61489b;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {str2, iBinder};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f61488a = str2;
                                        this.f61489b = iBinder;
                                    }

                                    @Override // android.os.IBinder.DeathRecipient
                                    public final void binderDied() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            b.f61485d.put(this.f61488a, Boolean.FALSE);
                                            ZeusLogger.e(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                                            HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = ServiceManagerNative.getInstance().process2ConnAndService.get(this.f61489b);
                                            for (ServiceConnection serviceConnection : hashMap.keySet()) {
                                                Iterator<ComponentName> it = hashMap.get(serviceConnection).iterator();
                                                while (it.hasNext()) {
                                                    serviceConnection.onServiceDisconnected(it.next());
                                                }
                                            }
                                        }
                                    }
                                }, 0);
                                f61485d.put(str2, Boolean.TRUE);
                                hashCode = str.hashCode();
                                if (hashCode == -807062458) {
                                    if (hashCode == 1984153269 && str.equals("service")) {
                                        c2 = 1;
                                        if (c2 != 0) {
                                            return d.a.a(iBinder);
                                        }
                                        if (c2 == 1) {
                                            return e.a.a(iBinder);
                                        }
                                    }
                                    c2 = 65535;
                                    if (c2 != 0) {
                                    }
                                } else {
                                    if (str.equals("package")) {
                                        if (c2 != 0) {
                                        }
                                    }
                                    c2 = 65535;
                                    if (c2 != 0) {
                                    }
                                }
                            } catch (RemoteException e2) {
                                ZeusLogger.e(ZeusLogger.TAG_SERVER, "generateServerManager failed.", e2);
                            }
                        }
                        return null;
                    }
                }
                iBinder = null;
                if (iBinder != null) {
                    char c22 = 0;
                    iBinder.linkToDeath(new IBinder.DeathRecipient(str2, iBinder) { // from class: com.bytedance.pangle.servermanager.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f61488a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ IBinder f61489b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = objArr;
                                Object[] objArr = {str2, iBinder};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61488a = str2;
                            this.f61489b = iBinder;
                        }

                        @Override // android.os.IBinder.DeathRecipient
                        public final void binderDied() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                b.f61485d.put(this.f61488a, Boolean.FALSE);
                                ZeusLogger.e(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                                HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = ServiceManagerNative.getInstance().process2ConnAndService.get(this.f61489b);
                                for (ServiceConnection serviceConnection : hashMap.keySet()) {
                                    Iterator<ComponentName> it = hashMap.get(serviceConnection).iterator();
                                    while (it.hasNext()) {
                                        serviceConnection.onServiceDisconnected(it.next());
                                    }
                                }
                            }
                        }
                    }, 0);
                    f61485d.put(str2, Boolean.TRUE);
                    hashCode = str.hashCode();
                    if (hashCode == -807062458) {
                    }
                }
                return null;
            }
            throw new RuntimeException("宿主中没有找对对应进程的serverManager ".concat(String.valueOf(str2)));
        }
        return (IInterface) invokeLL.objValue;
    }
}
