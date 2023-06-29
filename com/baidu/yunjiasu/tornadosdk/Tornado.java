package com.baidu.yunjiasu.tornadosdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.dto.IsShowRealNameGuideDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.Tun2tornado;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.baidu.yunjiasu.tornadosdk.ITrdVpnInterface;
import com.baidu.yunjiasu.tornadosdk.TornadoBroadcast;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0016\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010 \u001a\u00020\fJ\b\u0010!\u001a\u0004\u0018\u00010\"J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002J.\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\fJ\u0006\u0010-\u001a\u00020\fJ\u0006\u0010.\u001a\u00020\fJ\b\u0010/\u001a\u00020\fH\u0002J\b\u00100\u001a\u00020&H\u0002J\u001d\u00101\u001a\u00020&2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0004H\u0000¢\u0006\u0002\b5J\u0006\u00106\u001a\u00020&J\u0019\u00107\u001a\u00020&2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000409¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020\u0013J\u0019\u0010=\u001a\u00020&2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000409¢\u0006\u0002\u0010:J\u0016\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0004J\u0016\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010<\u001a\u00020DJ\u001e\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0004J\u0006\u0010I\u001a\u00020&J\b\u0010J\u001a\u00020&H\u0002J\b\u0010K\u001a\u00020&H\u0002J\u0006\u0010L\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006M"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/Tornado;", "", "()V", "TAG", "", "broadcastReceiver", "Lcom/baidu/yunjiasu/tornadosdk/TornadoBroadcast;", "connectivityManager", "Landroid/net/ConnectivityManager;", "context", "Landroid/content/Context;", "debug", "", "getDebug$tornadosdk_release", "()Z", "setDebug$tornadosdk_release", "(Z)V", "enableIPv6", "eventCallback", "Lcom/baidu/yunjiasu/tornadosdk/TornadoCallback;", "inited", "serviceConnection", "com/baidu/yunjiasu/tornadosdk/Tornado$serviceConnection$1", "Lcom/baidu/yunjiasu/tornadosdk/Tornado$serviceConnection$1;", IsShowRealNameGuideDTO.TYPE_SETTING, "Lcom/baidu/yunjiasu/tornadosdk/TornadoSetting;", "vpnBinder", "Lcom/baidu/yunjiasu/tornadosdk/ITrdVpnInterface;", "getVpnBinder$tornadosdk_release", "()Lcom/baidu/yunjiasu/tornadosdk/ITrdVpnInterface;", "setVpnBinder$tornadosdk_release", "(Lcom/baidu/yunjiasu/tornadosdk/ITrdVpnInterface;)V", "bind", "getRuntimeInfo", "Lcom/baidu/yunjiasu/tornadosdk/TornadoRuntime;", "getVPNProcess", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "init", "", "ctx", "appPackageName", "cuid", "channel", "clientVersion", "isBind", "isRunning", "isVPNProcessRunning", "isVPNServiceRunning", "killVpnProcess", "onEvent", "event", "Lcom/baidu/yunjiasu/tornadosdk/TornadoEvent;", "msg", "onEvent$tornadosdk_release", "release", "setAllowedPackages", "packages", "", "([Ljava/lang/String;)V", "setCallback", "cb", "setDisallowedPackages", "setEnv", "env", "Lcom/baidu/yunjiasu/tornadosdk/TornadoENV;", "value", "setToken", "token", "Lcom/baidu/yunjiasu/tornadosdk/TornadoTokenCallback;", "start", "gameRegion", "gameID", "gamePackageName", "stop", "unBind", "updateRuntimeInfo", "version", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes9.dex */
public final class Tornado {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Tornado INSTANCE;
    public static final String TAG = "Tornado";
    public static final TornadoBroadcast broadcastReceiver;
    public static ConnectivityManager connectivityManager;
    public static Context context;
    public static boolean debug;
    public static boolean enableIPv6;
    public static TornadoCallback eventCallback;
    public static boolean inited;
    public static final Tornado$serviceConnection$1 serviceConnection;
    public static TornadoSetting setting;
    public static ITrdVpnInterface vpnBinder;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1089150958, "Lcom/baidu/yunjiasu/tornadosdk/Tornado$WhenMappings;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1089150958, "Lcom/baidu/yunjiasu/tornadosdk/Tornado$WhenMappings;");
                    return;
                }
            }
            int[] iArr = new int[TornadoENV.values().length];
            iArr[TornadoENV.ENABLE_DEBUG.ordinal()] = 1;
            iArr[TornadoENV.ALLOWED_ALL.ordinal()] = 2;
            iArr[TornadoENV.ENABLE_PING_CMD.ordinal()] = 3;
            iArr[TornadoENV.PRINT_LOG.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.yunjiasu.tornadosdk.Tornado$serviceConnection$1] */
    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1467708031, "Lcom/baidu/yunjiasu/tornadosdk/Tornado;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1467708031, "Lcom/baidu/yunjiasu/tornadosdk/Tornado;");
                return;
            }
        }
        INSTANCE = new Tornado();
        debug = true;
        broadcastReceiver = new TornadoBroadcast();
        serviceConnection = new ServiceConnection() { // from class: com.baidu.yunjiasu.tornadosdk.Tornado$serviceConnection$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    LogTo.INSTANCE.d(Tornado.TAG, "onServiceConnected");
                    Tornado.INSTANCE.setVpnBinder$tornadosdk_release(ITrdVpnInterface.Stub.asInterface(iBinder));
                    if (Tornado.INSTANCE.getVpnBinder$tornadosdk_release() == null) {
                        return;
                    }
                    Tornado.INSTANCE.updateRuntimeInfo();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                    LogTo.INSTANCE.d(Tornado.TAG, "onServiceDisconnected");
                    Tornado.INSTANCE.setVpnBinder$tornadosdk_release(null);
                }
            }
        };
    }

    public final boolean bind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!inited) {
                return false;
            }
            Context context2 = context;
            Context context3 = null;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            Intent intent = new Intent(context2, TrdVpnService.class);
            try {
                Context context4 = context;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context3 = context4;
                }
                return context3.bindService(intent, serviceConnection, 1);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean isRunning() {
        InterceptResult invokeV;
        boolean isVPNProcessRunning;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!inited || !isBind()) {
                return false;
            }
            ITrdVpnInterface iTrdVpnInterface = vpnBinder;
            Intrinsics.checkNotNull(iTrdVpnInterface);
            boolean areEqual = Intrinsics.areEqual(iTrdVpnInterface.getRuntimeInfo(12L), "RUNNING");
            if (Build.VERSION.SDK_INT > 23) {
                isVPNProcessRunning = isVPNServiceRunning();
            } else {
                isVPNProcessRunning = isVPNProcessRunning();
            }
            return areEqual & isVPNProcessRunning;
        }
        return invokeV.booleanValue;
    }

    public Tornado() {
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

    private final void killVpnProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            try {
                ActivityManager.RunningAppProcessInfo vPNProcess = getVPNProcess();
                if (vPNProcess != null) {
                    Process.killProcess(vPNProcess.pid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final void unBind() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, this) != null) || !inited) {
            return;
        }
        Context context2 = null;
        try {
            vpnBinder = null;
            Context context3 = context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context2 = context3;
            }
            context2.unbindService(serviceConnection);
        } catch (Exception unused) {
        }
    }

    public final boolean getDebug$tornadosdk_release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return debug;
        }
        return invokeV.booleanValue;
    }

    public final TornadoRuntime getRuntimeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!inited || !isBind() || !isRunning()) {
                return null;
            }
            updateRuntimeInfo();
            return TornadoRuntime.INSTANCE;
        }
        return (TornadoRuntime) invokeV.objValue;
    }

    public final ITrdVpnInterface getVpnBinder$tornadosdk_release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return vpnBinder;
        }
        return (ITrdVpnInterface) invokeV.objValue;
    }

    public final boolean isBind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!inited || vpnBinder == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TornadoBroadcast.Companion companion = TornadoBroadcast.Companion;
            Context context2 = context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            companion.unRegister(context2, broadcastReceiver);
            unBind();
            TornadoNetwork.INSTANCE.unregister();
            inited = false;
        }
    }

    public final void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || !inited) {
            return;
        }
        try {
            ITrdVpnInterface iTrdVpnInterface = vpnBinder;
            if (iTrdVpnInterface != null) {
                iTrdVpnInterface.stop();
            }
        } catch (Exception unused) {
        }
        unBind();
        killVpnProcess();
    }

    public final String version() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return TornadoRuntime.INSTANCE.getSdkVersion();
        }
        return (String) invokeV.objValue;
    }

    public final void setAllowedPackages(String[] packages) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, packages) == null) {
            Intrinsics.checkNotNullParameter(packages, "packages");
            TornadoSetting tornadoSetting = setting;
            if (tornadoSetting == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                tornadoSetting = null;
            }
            tornadoSetting.setVpnAllowedPackages(packages);
        }
    }

    public final void setCallback(TornadoCallback cb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cb) == null) {
            Intrinsics.checkNotNullParameter(cb, "cb");
            eventCallback = cb;
        }
    }

    public final void setDebug$tornadosdk_release(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            debug = z;
        }
    }

    public final void setDisallowedPackages(String[] packages) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, packages) == null) {
            Intrinsics.checkNotNullParameter(packages, "packages");
            TornadoSetting tornadoSetting = setting;
            if (tornadoSetting == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                tornadoSetting = null;
            }
            tornadoSetting.setVpnDisallowedPackages(packages);
        }
    }

    public final void setVpnBinder$tornadosdk_release(ITrdVpnInterface iTrdVpnInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iTrdVpnInterface) == null) {
            vpnBinder = iTrdVpnInterface;
        }
    }

    private final ActivityManager.RunningAppProcessInfo getVPNProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Context context2 = context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            Object systemService = context2.getSystemService("activity");
            if (systemService != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                int i = 0;
                int size = runningAppProcesses.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        String str = runningAppProcesses.get(i).processName;
                        TornadoSetting tornadoSetting = setting;
                        if (tornadoSetting == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                            tornadoSetting = null;
                        }
                        if (str.equals(Intrinsics.stringPlus(tornadoSetting.getAppPackageName(), ":vpn"))) {
                            return runningAppProcesses.get(i);
                        }
                        if (i2 > size) {
                            break;
                        }
                        i = i2;
                    }
                }
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        return (ActivityManager.RunningAppProcessInfo) invokeV.objValue;
    }

    private final boolean isVPNServiceRunning() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Context context2 = context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            Object systemService = context2.getSystemService("activity");
            if (systemService != null) {
                List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) systemService).getRunningServices(300);
                Intrinsics.checkNotNullExpressionValue(runningServices, "activityManager.getRunningServices(300)");
                if (runningServices.isEmpty() || runningServices.size() - 1 < 0) {
                    return false;
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String className = runningServices.get(i).service.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className, "serviceList[i].service.className");
                    if (StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) "TrdVpnService", false, 2, (Object) null)) {
                        return true;
                    }
                    if (i2 > size) {
                        return false;
                    }
                    i = i2;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    public final boolean isVPNProcessRunning() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context2 = context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            Object systemService = context2.getSystemService("activity");
            if (systemService != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                if (runningAppProcesses.isEmpty() || runningAppProcesses.size() - 1 < 0) {
                    return false;
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String str = runningAppProcesses.get(i).processName;
                    TornadoSetting tornadoSetting = setting;
                    if (tornadoSetting == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                        tornadoSetting = null;
                    }
                    if (str.equals(Intrinsics.stringPlus(tornadoSetting.getAppPackageName(), ":vpn"))) {
                        return true;
                    }
                    if (i2 > size) {
                        return false;
                    }
                    i = i2;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateRuntimeInfo() {
        String runtimeInfo;
        ITrdVpnInterface iTrdVpnInterface;
        String runtimeInfo2;
        ITrdVpnInterface iTrdVpnInterface2;
        String runtimeInfo3;
        ITrdVpnInterface iTrdVpnInterface3;
        String runtimeInfo4;
        ITrdVpnInterface iTrdVpnInterface4;
        String runtimeInfo5;
        Long longOrNull;
        ITrdVpnInterface iTrdVpnInterface5;
        String runtimeInfo6;
        Long longOrNull2;
        ITrdVpnInterface iTrdVpnInterface6;
        String runtimeInfo7;
        Long longOrNull3;
        ITrdVpnInterface iTrdVpnInterface7;
        String runtimeInfo8;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65544, this) != null) || !isBind()) {
            return;
        }
        ITrdVpnInterface iTrdVpnInterface8 = vpnBinder;
        Long l = null;
        if (iTrdVpnInterface8 == null) {
            runtimeInfo = null;
        } else {
            runtimeInfo = iTrdVpnInterface8.getRuntimeInfo(12L);
        }
        if (runtimeInfo != null) {
            int hashCode = runtimeInfo.hashCode();
            if (hashCode != -2026200673) {
                if (hashCode != 2252048) {
                    if (hashCode == 2099433536 && runtimeInfo.equals(TornadoLiteRuntime.STATE_STARTING)) {
                        TornadoRuntime.INSTANCE.setState(TornadoState.STATE_STARTING);
                    }
                } else if (runtimeInfo.equals(TornadoLiteRuntime.STATE_INIT)) {
                    TornadoRuntime.INSTANCE.setState(TornadoState.STATE_INIT);
                }
            } else if (runtimeInfo.equals("RUNNING")) {
                TornadoRuntime.INSTANCE.setState(TornadoState.STATE_RUNNING);
            }
            TornadoRuntime tornadoRuntime = TornadoRuntime.INSTANCE;
            iTrdVpnInterface = vpnBinder;
            if (iTrdVpnInterface != null) {
                runtimeInfo2 = null;
            } else {
                runtimeInfo2 = iTrdVpnInterface.getRuntimeInfo(7L);
            }
            tornadoRuntime.setGameID(runtimeInfo2);
            TornadoRuntime tornadoRuntime2 = TornadoRuntime.INSTANCE;
            iTrdVpnInterface2 = vpnBinder;
            if (iTrdVpnInterface2 != null) {
                runtimeInfo3 = null;
            } else {
                runtimeInfo3 = iTrdVpnInterface2.getRuntimeInfo(11L);
            }
            tornadoRuntime2.setGamePackage(runtimeInfo3);
            TornadoRuntime tornadoRuntime3 = TornadoRuntime.INSTANCE;
            iTrdVpnInterface3 = vpnBinder;
            if (iTrdVpnInterface3 != null) {
                runtimeInfo4 = null;
            } else {
                runtimeInfo4 = iTrdVpnInterface3.getRuntimeInfo(6L);
            }
            tornadoRuntime3.setGameRegion(runtimeInfo4);
            TornadoRuntime tornadoRuntime4 = TornadoRuntime.INSTANCE;
            iTrdVpnInterface4 = vpnBinder;
            if (iTrdVpnInterface4 == null || (runtimeInfo5 = iTrdVpnInterface4.getRuntimeInfo(9L)) == null) {
                longOrNull = null;
            } else {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(runtimeInfo5);
            }
            tornadoRuntime4.setDataLoss(longOrNull);
            TornadoRuntime tornadoRuntime5 = TornadoRuntime.INSTANCE;
            iTrdVpnInterface5 = vpnBinder;
            if (iTrdVpnInterface5 == null || (runtimeInfo6 = iTrdVpnInterface5.getRuntimeInfo(8L)) == null) {
                longOrNull2 = null;
            } else {
                longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(runtimeInfo6);
            }
            tornadoRuntime5.setDataLatency(longOrNull2);
            TornadoRuntime tornadoRuntime6 = TornadoRuntime.INSTANCE;
            iTrdVpnInterface6 = vpnBinder;
            if (iTrdVpnInterface6 == null || (runtimeInfo7 = iTrdVpnInterface6.getRuntimeInfo(10L)) == null) {
                longOrNull3 = null;
            } else {
                longOrNull3 = StringsKt__StringNumberConversionsKt.toLongOrNull(runtimeInfo7);
            }
            tornadoRuntime6.setDataOptimizeRate(longOrNull3);
            TornadoRuntime tornadoRuntime7 = TornadoRuntime.INSTANCE;
            iTrdVpnInterface7 = vpnBinder;
            if (iTrdVpnInterface7 != null && (runtimeInfo8 = iTrdVpnInterface7.getRuntimeInfo(13L)) != null) {
                l = StringsKt__StringNumberConversionsKt.toLongOrNull(runtimeInfo8);
            }
            tornadoRuntime7.setStartTime(l);
        }
        TornadoRuntime.INSTANCE.setState(TornadoState.STATE_UNINIT);
        TornadoRuntime tornadoRuntime8 = TornadoRuntime.INSTANCE;
        iTrdVpnInterface = vpnBinder;
        if (iTrdVpnInterface != null) {
        }
        tornadoRuntime8.setGameID(runtimeInfo2);
        TornadoRuntime tornadoRuntime22 = TornadoRuntime.INSTANCE;
        iTrdVpnInterface2 = vpnBinder;
        if (iTrdVpnInterface2 != null) {
        }
        tornadoRuntime22.setGamePackage(runtimeInfo3);
        TornadoRuntime tornadoRuntime32 = TornadoRuntime.INSTANCE;
        iTrdVpnInterface3 = vpnBinder;
        if (iTrdVpnInterface3 != null) {
        }
        tornadoRuntime32.setGameRegion(runtimeInfo4);
        TornadoRuntime tornadoRuntime42 = TornadoRuntime.INSTANCE;
        iTrdVpnInterface4 = vpnBinder;
        if (iTrdVpnInterface4 == null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(runtimeInfo5);
            tornadoRuntime42.setDataLoss(longOrNull);
            TornadoRuntime tornadoRuntime52 = TornadoRuntime.INSTANCE;
            iTrdVpnInterface5 = vpnBinder;
            if (iTrdVpnInterface5 == null) {
                longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(runtimeInfo6);
                tornadoRuntime52.setDataLatency(longOrNull2);
                TornadoRuntime tornadoRuntime62 = TornadoRuntime.INSTANCE;
                iTrdVpnInterface6 = vpnBinder;
                if (iTrdVpnInterface6 == null) {
                    longOrNull3 = StringsKt__StringNumberConversionsKt.toLongOrNull(runtimeInfo7);
                    tornadoRuntime62.setDataOptimizeRate(longOrNull3);
                    TornadoRuntime tornadoRuntime72 = TornadoRuntime.INSTANCE;
                    iTrdVpnInterface7 = vpnBinder;
                    if (iTrdVpnInterface7 != null) {
                        l = StringsKt__StringNumberConversionsKt.toLongOrNull(runtimeInfo8);
                    }
                    tornadoRuntime72.setStartTime(l);
                }
                longOrNull3 = null;
                tornadoRuntime62.setDataOptimizeRate(longOrNull3);
                TornadoRuntime tornadoRuntime722 = TornadoRuntime.INSTANCE;
                iTrdVpnInterface7 = vpnBinder;
                if (iTrdVpnInterface7 != null) {
                }
                tornadoRuntime722.setStartTime(l);
            }
            longOrNull2 = null;
            tornadoRuntime52.setDataLatency(longOrNull2);
            TornadoRuntime tornadoRuntime622 = TornadoRuntime.INSTANCE;
            iTrdVpnInterface6 = vpnBinder;
            if (iTrdVpnInterface6 == null) {
            }
            longOrNull3 = null;
            tornadoRuntime622.setDataOptimizeRate(longOrNull3);
            TornadoRuntime tornadoRuntime7222 = TornadoRuntime.INSTANCE;
            iTrdVpnInterface7 = vpnBinder;
            if (iTrdVpnInterface7 != null) {
            }
            tornadoRuntime7222.setStartTime(l);
        }
        longOrNull = null;
        tornadoRuntime42.setDataLoss(longOrNull);
        TornadoRuntime tornadoRuntime522 = TornadoRuntime.INSTANCE;
        iTrdVpnInterface5 = vpnBinder;
        if (iTrdVpnInterface5 == null) {
        }
        longOrNull2 = null;
        tornadoRuntime522.setDataLatency(longOrNull2);
        TornadoRuntime tornadoRuntime6222 = TornadoRuntime.INSTANCE;
        iTrdVpnInterface6 = vpnBinder;
        if (iTrdVpnInterface6 == null) {
        }
        longOrNull3 = null;
        tornadoRuntime6222.setDataOptimizeRate(longOrNull3);
        TornadoRuntime tornadoRuntime72222 = TornadoRuntime.INSTANCE;
        iTrdVpnInterface7 = vpnBinder;
        if (iTrdVpnInterface7 != null) {
        }
        tornadoRuntime72222.setStartTime(l);
    }

    public final void init(Context ctx, String appPackageName, String cuid, String channel, String clientVersion) {
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, ctx, appPackageName, cuid, channel, clientVersion) == null) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
            Intrinsics.checkNotNullParameter(cuid, "cuid");
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(clientVersion, "clientVersion");
            if (inited) {
                return;
            }
            context = ctx;
            Context context3 = null;
            if (ctx == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            } else {
                context2 = ctx;
            }
            Object systemService = context2.getSystemService("connectivity");
            if (systemService != null) {
                connectivityManager = (ConnectivityManager) systemService;
                TornadoSetting tornadoSetting = new TornadoSetting();
                setting = tornadoSetting;
                if (tornadoSetting == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                    tornadoSetting = null;
                }
                tornadoSetting.setAppPackageName(appPackageName);
                if (inited) {
                    return;
                }
                inited = true;
                TornadoNetwork tornadoNetwork = TornadoNetwork.INSTANCE;
                ConnectivityManager connectivityManager2 = connectivityManager;
                if (connectivityManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                    connectivityManager2 = null;
                }
                tornadoNetwork.init(ctx, connectivityManager2, enableIPv6);
                TornadoNetwork.INSTANCE.register();
                TornadoSetting tornadoSetting2 = setting;
                if (tornadoSetting2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                    tornadoSetting2 = null;
                }
                tornadoSetting2.setAuthCUID(cuid);
                TornadoSetting tornadoSetting3 = setting;
                if (tornadoSetting3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                    tornadoSetting3 = null;
                }
                tornadoSetting3.setAuthChannel(channel);
                TornadoSetting tornadoSetting4 = setting;
                if (tornadoSetting4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                    tornadoSetting4 = null;
                }
                tornadoSetting4.setClientVersion(clientVersion);
                Tun2tornado.INSTANCE.init();
                TornadoBroadcast.Companion companion = TornadoBroadcast.Companion;
                Context context4 = context;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context4 = null;
                }
                companion.register(context4, broadcastReceiver);
                TornadoBroadcast.Companion companion2 = TornadoBroadcast.Companion;
                Context context5 = context;
                if (context5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context3 = context5;
                }
                companion2.sendPing(context3);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }

    public final void onEvent$tornadosdk_release(TornadoEvent event, String msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event, msg) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(msg, "msg");
            TornadoCallback tornadoCallback = eventCallback;
            if (tornadoCallback != null) {
                tornadoCallback.onEvent(event, msg);
            }
        }
    }

    public final boolean setEnv(TornadoENV env, String value) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, env, value)) == null) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(value, "value");
            int i = WhenMappings.$EnumSwitchMapping$0[env.ordinal()];
            TornadoSetting tornadoSetting = null;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return true;
                        }
                        TornadoSetting tornadoSetting2 = setting;
                        if (tornadoSetting2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                        } else {
                            tornadoSetting = tornadoSetting2;
                        }
                        tornadoSetting.setPrintLog(Boolean.parseBoolean(value));
                        return true;
                    }
                    TornadoSetting tornadoSetting3 = setting;
                    if (tornadoSetting3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                    } else {
                        tornadoSetting = tornadoSetting3;
                    }
                    tornadoSetting.setEnablePingCMD(Boolean.parseBoolean(value));
                    return true;
                }
                TornadoSetting tornadoSetting4 = setting;
                if (tornadoSetting4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                } else {
                    tornadoSetting = tornadoSetting4;
                }
                tornadoSetting.setVpnAllowedAllApp(Boolean.parseBoolean(value));
                return true;
            }
            debug = Boolean.parseBoolean(value);
            TornadoSetting tornadoSetting5 = setting;
            if (tornadoSetting5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
            } else {
                tornadoSetting = tornadoSetting5;
            }
            tornadoSetting.setDebug(Boolean.parseBoolean(value));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void setToken(String token, TornadoTokenCallback cb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, token, cb) == null) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(cb, "cb");
            TornadoSetting tornadoSetting = setting;
            if (tornadoSetting == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                tornadoSetting = null;
            }
            tornadoSetting.setAuthToken(token);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new Tornado$setToken$1(cb, null), 3, null);
        }
    }

    public final void start(String gameRegion, String gameID, String gamePackageName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, gameRegion, gameID, gamePackageName) == null) {
            Intrinsics.checkNotNullParameter(gameRegion, "gameRegion");
            Intrinsics.checkNotNullParameter(gameID, "gameID");
            Intrinsics.checkNotNullParameter(gamePackageName, "gamePackageName");
            if (!inited || isRunning()) {
                return;
            }
            TornadoRuntime.INSTANCE.reset();
            TornadoSetting tornadoSetting = setting;
            Context context2 = null;
            if (tornadoSetting == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                tornadoSetting = null;
            }
            tornadoSetting.setGameRegion(gameRegion);
            TornadoSetting tornadoSetting2 = setting;
            if (tornadoSetting2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                tornadoSetting2 = null;
            }
            tornadoSetting2.setGameID(gameID);
            TornadoSetting tornadoSetting3 = setting;
            if (tornadoSetting3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                tornadoSetting3 = null;
            }
            tornadoSetting3.setGameName(gamePackageName);
            LogTo.INSTANCE.d(TAG, "start(): {Region: " + gameRegion + ", GameID: " + gameID + ", PackageName: " + gamePackageName + '}');
            Context context3 = context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context3 = null;
            }
            Intent intent = new Intent(context3, TrdVpnService.class);
            String simpleName = Reflection.getOrCreateKotlinClass(TornadoSetting.class).getSimpleName();
            TornadoSetting tornadoSetting4 = setting;
            if (tornadoSetting4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IsShowRealNameGuideDTO.TYPE_SETTING);
                tornadoSetting4 = null;
            }
            Intent putExtra = intent.putExtra(simpleName, tornadoSetting4);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, TrdVpnSe…lass.simpleName, setting)");
            try {
                Context context4 = context;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context2 = context4;
                }
                LogTo.INSTANCE.d(TAG, Intrinsics.stringPlus("bindService(): ", Boolean.valueOf(context2.bindService(putExtra, serviceConnection, 1))));
            } catch (Exception unused) {
            }
        }
    }
}
