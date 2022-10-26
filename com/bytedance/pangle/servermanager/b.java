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
import com.bytedance.pangle.c;
import com.bytedance.pangle.d;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static final Object b;
    public static final Object c;
    public static final Map d;
    public static final Map e;
    public static c f;
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
        a = new Object();
        b = new Object();
        c = new Object();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085 A[Catch: RemoteException -> 0x009e, TryCatch #0 {RemoteException -> 0x009e, blocks: (B:17:0x005a, B:32:0x0094, B:34:0x0099, B:22:0x007b, B:25:0x0085), top: B:47:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099 A[Catch: RemoteException -> 0x009e, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x009e, blocks: (B:17:0x005a, B:32:0x0094, B:34:0x0099, B:22:0x007b, B:25:0x0085), top: B:47:0x005a }] */
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
            if (Zeus.hasInit()) {
                if (((ProviderInfo) Zeus.getServerManagerHashMap().get(str2)) != null) {
                    Bundle call = Zeus.getAppApplication().getContentResolver().call(Uri.parse("content://" + providerInfo.authority), AbsServerManager.METHOD_QUERY_BINDER, str, (Bundle) null);
                    if (call != null) {
                        call.setClassLoader(AbsServerManager.class.getClassLoader());
                        a aVar = (a) call.getParcelable(AbsServerManager.BUNDLE_BINDER);
                        if (aVar != null) {
                            iBinder = aVar.a;
                            if (iBinder != null && iBinder.isBinderAlive()) {
                                try {
                                    char c2 = 0;
                                    iBinder.linkToDeath(new IBinder.DeathRecipient(str2, iBinder) { // from class: com.bytedance.pangle.servermanager.b.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ String a;
                                        public final /* synthetic */ IBinder b;

                                        {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {str2, iBinder};
                                                interceptable2.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable2.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.a = str2;
                                            this.b = iBinder;
                                        }

                                        @Override // android.os.IBinder.DeathRecipient
                                        public final void binderDied() {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                b.d.put(this.a, Boolean.FALSE);
                                                ZeusLogger.e(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                                                HashMap hashMap = (HashMap) ServiceManagerNative.getInstance().process2ConnAndService.get(this.b);
                                                for (ServiceConnection serviceConnection : hashMap.keySet()) {
                                                    Iterator it = ((HashSet) hashMap.get(serviceConnection)).iterator();
                                                    while (it.hasNext()) {
                                                        serviceConnection.onServiceDisconnected((ComponentName) it.next());
                                                    }
                                                }
                                            }
                                        }
                                    }, 0);
                                    d.put(str2, Boolean.TRUE);
                                    hashCode = str.hashCode();
                                    if (hashCode == -807062458) {
                                        if (hashCode == 1984153269 && str.equals("service")) {
                                            c2 = 1;
                                            if (c2 == 0) {
                                                if (c2 == 1) {
                                                    return d.a.a(iBinder);
                                                }
                                            } else {
                                                return c.a.a(iBinder);
                                            }
                                        }
                                        c2 = 65535;
                                        if (c2 == 0) {
                                        }
                                    } else {
                                        if (str.equals("package")) {
                                            if (c2 == 0) {
                                            }
                                        }
                                        c2 = 65535;
                                        if (c2 == 0) {
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
                            public final /* synthetic */ String a;
                            public final /* synthetic */ IBinder b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = objArr;
                                    Object[] objArr = {str2, iBinder};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = str2;
                                this.b = iBinder;
                            }

                            @Override // android.os.IBinder.DeathRecipient
                            public final void binderDied() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    b.d.put(this.a, Boolean.FALSE);
                                    ZeusLogger.e(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                                    HashMap hashMap = (HashMap) ServiceManagerNative.getInstance().process2ConnAndService.get(this.b);
                                    for (ServiceConnection serviceConnection : hashMap.keySet()) {
                                        Iterator it = ((HashSet) hashMap.get(serviceConnection)).iterator();
                                        while (it.hasNext()) {
                                            serviceConnection.onServiceDisconnected((ComponentName) it.next());
                                        }
                                    }
                                }
                            }
                        }, 0);
                        d.put(str2, Boolean.TRUE);
                        hashCode = str.hashCode();
                        if (hashCode == -807062458) {
                        }
                    }
                    return null;
                }
                throw new RuntimeException("宿主中没有找对对应进程的serverManager ".concat(String.valueOf(str2)));
            }
            throw new RuntimeException("generateServerManager 请先初始化Zeus, processName:".concat(String.valueOf(str2)));
        }
        return (IInterface) invokeLL.objValue;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Boolean bool = (Boolean) d.get("main");
            if (bool == null || !bool.booleanValue()) {
                f = null;
            }
            if (f == null) {
                synchronized (c) {
                    c cVar = (c) a("package", "main");
                    if (cVar == null) {
                        ZeusLogger.e(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                        return null;
                    }
                    f = cVar;
                }
            }
            return f;
        }
        return (c) invokeV.objValue;
    }

    public static d a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Boolean bool = (Boolean) d.get(str);
            if (bool == null || !bool.booleanValue()) {
                e.remove(str);
            }
            if (e.get(str) == null) {
                synchronized (b) {
                    d dVar = (d) a("service", str);
                    if (dVar == null) {
                        ZeusLogger.e(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                        return null;
                    }
                    e.put(str, dVar);
                }
            }
            return (d) e.get(str);
        }
        return (d) invokeL.objValue;
    }
}
