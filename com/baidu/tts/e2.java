package com.baidu.tts;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.observer.receiver.NetworkChangeReceiver;
import com.baidu.tts.t;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes9.dex */
public class e2 extends ConnectivityManager.NetworkCallback {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int j = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public ConnectivityManager a;
    public c b;
    public boolean c;
    public String d;
    public final Set<Network> e;
    public boolean f;
    public boolean g;
    public a h;
    public x1 i;

    /* loaded from: classes9.dex */
    public class a extends NetworkChangeReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2 a;

        public a(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e2Var;
        }

        @Override // com.baidu.tts.observer.receiver.NetworkChangeReceiver, android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                try {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        LoggerProxy.d("NetworkCallback", "NetworkChangeReceiver network is on.");
                        this.a.g = true;
                        this.a.a((NetworkCapabilities) null, activeNetworkInfo);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                LoggerProxy.d("NetworkCallback", "NetworkChangeReceiver network is off.");
                this.a.g = false;
                this.a.c();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final e2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1523131718, "Lcom/baidu/tts/e2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1523131718, "Lcom/baidu/tts/e2$b;");
                    return;
                }
            }
            a = new e2();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c c;
        public static final c d;
        public static final c e;
        public static final c f;
        public static final c g;
        public static final c h;
        public static final c i;
        public static final /* synthetic */ c[] j;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final String b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1523131749, "Lcom/baidu/tts/e2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1523131749, "Lcom/baidu/tts/e2$c;");
                    return;
                }
            }
            c cVar = new c("NETWORK_UNKNOWN", 0, 0, "unknown");
            c = cVar;
            c cVar2 = new c("NETWORK_ETHER", 1, 1, "ether");
            d = cVar2;
            c cVar3 = new c("NETWORK_2G", 2, 2, "2G");
            e = cVar3;
            c cVar4 = new c("NETWORK_3G", 3, 3, "3G");
            f = cVar4;
            c cVar5 = new c("NETWORK_4G", 4, 4, "4G");
            g = cVar5;
            c cVar6 = new c("NETWORK_5G", 5, 5, "5G");
            h = cVar6;
            c cVar7 = new c("NETWORK_WIFI", 6, 10, "wifi");
            i = cVar7;
            j = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7};
        }

        public c(String str, int i2, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i3;
            this.b = str2;
        }

        public static c valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (c) Enum.valueOf(c.class, str);
            }
            return (c) invokeL.objValue;
        }

        public static c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (c[]) j.clone();
            }
            return (c[]) invokeV.objValue;
        }
    }

    public e2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = c.c;
        this.d = "";
        this.e = new CopyOnWriteArraySet();
        this.f = true;
        this.g = false;
        this.h = null;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, network, linkProperties) == null) {
            super.onLinkPropertiesChanged(network, linkProperties);
            LoggerProxy.d("NetworkCallback", "onLinkPropertiesChanged");
        }
    }

    public final c a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i != 1 && i != 2 && i != 4 && i != 7 && i != 11) {
                if (i != 3 && i != 5 && i != 6 && i != 8 && i != 9 && i != 10 && i != 12 && i != 14 && i != 15) {
                    if (i == 13) {
                        return c.g;
                    }
                    if (i == 20) {
                        return c.h;
                    }
                    return c.c;
                }
                return c.f;
            }
            return c.e;
        }
        return (c) invokeI.objValue;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public synchronized void onLost(Network network) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, network) == null) {
            synchronized (this) {
                super.onLost(network);
                this.e.remove(network);
                LoggerProxy.d("NetworkCallback", "onLost network =" + network.toString() + " , netWorkIdSet = " + this.e.toString());
                c();
            }
        }
    }

    public final void a(NetworkCapabilities networkCapabilities, NetworkInfo networkInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkCapabilities, networkInfo) == null) {
            this.d = "";
            c cVar = c.c;
            this.b = cVar;
            if (networkInfo == null) {
                networkInfo = this.a.getActiveNetworkInfo();
            }
            if (networkCapabilities != null) {
                if (networkCapabilities.hasTransport(3)) {
                    this.b = c.d;
                } else if (networkCapabilities.hasTransport(1)) {
                    this.b = c.i;
                } else if (networkCapabilities.hasTransport(0)) {
                    if (networkInfo != null) {
                        this.b = a(networkInfo.getSubtype());
                    }
                    this.d = ((TelephonyManager) b1.d().b().getSystemService("phone")).getSimOperatorName();
                } else {
                    this.b = cVar;
                }
            } else if (networkInfo != null) {
                if (networkInfo.getType() == 1) {
                    this.b = c.i;
                } else if (networkInfo.getType() != 0) {
                    this.b = a(networkInfo.getSubtype());
                    this.d = ((TelephonyManager) b1.d().b().getSystemService("phone")).getSimOperatorName();
                } else if (networkInfo.getType() == 9) {
                    this.b = c.d;
                } else {
                    this.b = cVar;
                }
            }
            LoggerProxy.d("NetworkCallback", "NETWORK NAME: " + this.b.b);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.e.isEmpty() && !this.g) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.b.a;
            if (i < 3 && i != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            t tVar = t.a.a;
            synchronized (tVar) {
                synchronized (tVar) {
                    if (tVar.e != null) {
                        tVar.a.removeCallbacksAndMessages(null);
                    }
                    tVar.d = false;
                }
            }
            h2 h2Var = tVar.e;
            if (h2Var != null) {
                h2Var.quit();
                tVar.e = null;
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onUnavailable();
            LoggerProxy.d("NetworkCallback", "onUnavailable");
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!a()) {
                this.b = c.c;
                this.d = "";
                t tVar = t.a.a;
                synchronized (tVar) {
                    if (tVar.e != null) {
                        tVar.a.removeCallbacksAndMessages(null);
                    }
                    tVar.d = false;
                }
                return;
            }
            Iterator<Network> it = this.e.iterator();
            if (it.hasNext()) {
                a(this.a.getNetworkCapabilities(it.next()), (NetworkInfo) null);
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public synchronized void onAvailable(Network network) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, network) == null) {
            synchronized (this) {
                super.onAvailable(network);
                NetworkCapabilities networkCapabilities = this.a.getNetworkCapabilities(network);
                if (networkCapabilities == null) {
                    LoggerProxy.d("NetworkCallback", "onAvailable network =" + network.toString() + " , networkCapabilities is null");
                    return;
                }
                LoggerProxy.d("NetworkCallback", "onAvailable network =" + network.toString() + " , networkCapabilities =" + networkCapabilities.toString());
                if (!networkCapabilities.hasCapability(12)) {
                    LoggerProxy.e("NetworkCallback", "the network is unavailable ");
                } else if (!this.f || Build.VERSION.SDK_INT < 23 || networkCapabilities.hasCapability(16)) {
                    this.e.add(network);
                    LoggerProxy.d("NetworkCallback", "checkNetworkCapabilities network =" + network.toString() + " , netWorkIdSet = " + this.e.toString());
                    a(networkCapabilities, (NetworkInfo) null);
                    t tVar = t.a.a;
                    synchronized (tVar) {
                        if (!tVar.d && b.a.a() && tVar.e != null) {
                            tVar.a.post(tVar.b);
                            tVar.d = true;
                        }
                    }
                }
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public synchronized void onLosing(Network network, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, network, i) == null) {
            synchronized (this) {
                super.onLosing(network, i);
                LoggerProxy.d("NetworkCallback", "onLosing network =" + network.toString() + ", maxMsToLive = " + i);
            }
        }
    }
}
