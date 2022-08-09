package com.baidu.yunjiasu.tornadosdk;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.VpnService;
import android.os.Build;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.Tun2tornado;
import com.baidu.yunjiasu.tornadosdk.TornadoSetting;
import com.baidu.yunjiasu.tornadosdk.TrdVpnBinderInterface;
import com.baidu.yunjiasu.tornadosdk.TrdVpnService;
import com.bytedance.pangle.servermanager.AbsServerManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TrdVpnService;", "Landroid/net/VpnService;", "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnBinderInterface;", "()V", AbsServerManager.BUNDLE_BINDER, "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnAIDL;", "broadcastReceiver", "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnBroadcast;", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "Lkotlin/Lazy;", "executorService", "Ljava/util/concurrent/ExecutorService;", "pfd", "Landroid/os/ParcelFileDescriptor;", "onBind", "Landroid/os/IBinder;", IntentData.KEY, "Landroid/content/Intent;", "onCreate", "", MissionEvent.MESSAGE_DESTROY, "onRebind", "onUnbind", "", "setupVPN", "start", "stopVPN", "Companion", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class TrdVpnService extends VpnService implements TrdVpnBinderInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String TAG = "VpnService";
    public transient /* synthetic */ FieldHolder $fh;
    public final TrdVpnAIDL binder;
    public final TrdVpnBroadcast broadcastReceiver;
    public final Lazy connectivityManager$delegate;
    public final ExecutorService executorService;
    public ParcelFileDescriptor pfd;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TrdVpnService$Companion;", "", "()V", "TAG", "", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1273183599, "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1273183599, "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnService;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public TrdVpnService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        Intrinsics.checkNotNullExpressionValue(newFixedThreadPool, "newFixedThreadPool(1)");
        this.executorService = newFixedThreadPool;
        this.binder = new TrdVpnAIDL(this);
        this.connectivityManager$delegate = LazyKt__LazyJVMKt.lazy(new TrdVpnService$connectivityManager$2(this));
        this.broadcastReceiver = new TrdVpnBroadcast();
    }

    private final ConnectivityManager getConnectivityManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? (ConnectivityManager) this.connectivityManager$delegate.getValue() : (ConnectivityManager) invokeV.objValue;
    }

    private final boolean setupVPN(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, intent)) == null) {
            final TrdVpnConfig trdVpnConfig = TrdVpnConfig.INSTANCE;
            Parcelable parcelableExtra = intent.getParcelableExtra(Reflection.getOrCreateKotlinClass(TornadoSetting.class).getSimpleName());
            Intrinsics.checkNotNull(parcelableExtra);
            final TornadoSetting tornadoSetting = (TornadoSetting) parcelableExtra;
            T2TOperationInterface t2TOperationInterface = new T2TOperationInterface(this);
            Tun2tornado.INSTANCE.setDebug(tornadoSetting.getDebug());
            Tun2tornado.INSTANCE.setLog(tornadoSetting.getPrintLog());
            LogTo logTo = LogTo.INSTANCE;
            logTo.i(TAG, "setupVPN(): {Region: " + tornadoSetting.getGameRegion() + ", GameID: " + tornadoSetting.getGameID() + ", GameName: " + tornadoSetting.getGameName() + '}');
            Tun2tornado.INSTANCE.setOperationInterface(t2TOperationInterface);
            TrdVpnNetwork.INSTANCE.init(this, getConnectivityManager(), tornadoSetting.getEnablePingCMD(), tornadoSetting.getEnableIPv6());
            TrdVpnNetwork.INSTANCE.register();
            Tun2tornado.INSTANCE.setEnv(Tun2tornado.ENV_CHANNEL_NAME, tornadoSetting.getAuthChannel());
            Tun2tornado.INSTANCE.setEnv("CUID", tornadoSetting.getAuthCUID());
            Tun2tornado.INSTANCE.setEnv(Tun2tornado.ENV_TOKEN, tornadoSetting.getAuthToken());
            Tun2tornado.INSTANCE.setEnv(Tun2tornado.ENV_CLIENT_VERSION, tornadoSetting.getClientVersion());
            Tun2tornado tun2tornado = Tun2tornado.INSTANCE;
            String RELEASE = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
            tun2tornado.setEnv(Tun2tornado.ENV_SYSTEM_VERSION, RELEASE);
            LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("ENV_CHANNEL_NAME:", tornadoSetting.getAuthChannel()));
            LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("ENV_CUID:", tornadoSetting.getAuthCUID()));
            LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("ENV_TOKEN:", tornadoSetting.getAuthToken()));
            LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("ENV_CLIENT_VERSION:", tornadoSetting.getClientVersion()));
            this.executorService.submit(new Runnable() { // from class: com.repackage.ue9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TrdVpnService.m72setupVPN$lambda0(TornadoSetting.this, this, trdVpnConfig);
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: setupVPN$lambda-0  reason: not valid java name */
    public static final void m72setupVPN$lambda0(TornadoSetting setting, TrdVpnService this$0, TrdVpnConfig trdConf) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, setting, this$0, trdConf) == null) {
            Intrinsics.checkNotNullParameter(setting, "$setting");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(trdConf, "$trdConf");
            try {
                if (!Tun2tornado.INSTANCE.prepare(ArraysKt___ArraysJvmKt.asList(setting.getSClientList()))) {
                    this$0.stopVPN();
                    return;
                }
                VpnService.Builder blocking = new VpnService.Builder(this$0).setSession(trdConf.getName()).setMtu(trdConf.getMtu()).setBlocking(true);
                blocking.addAddress(trdConf.getAddr(), trdConf.getADDRPrefixLength());
                blocking.addDnsServer(trdConf.getDnsServer1()).addDnsServer(trdConf.getDnsServer2()).addRoute(trdConf.getRoute(), trdConf.getRoutePrefixLength());
                if (!setting.getVpnAllowedAllApp()) {
                    int i = 0;
                    if (!(setting.getVpnDisallowedPackages().length == 0)) {
                        String[] vpnDisallowedPackages = setting.getVpnDisallowedPackages();
                        int length = vpnDisallowedPackages.length;
                        while (i < length) {
                            String str = vpnDisallowedPackages[i];
                            i++;
                            blocking.addDisallowedApplication(str);
                        }
                    } else {
                        blocking.addAllowedApplication(setting.getGameName());
                        String[] vpnAllowedPackages = setting.getVpnAllowedPackages();
                        int length2 = vpnAllowedPackages.length;
                        while (i < length2) {
                            String str2 = vpnAllowedPackages[i];
                            i++;
                            blocking.addAllowedApplication(str2);
                        }
                    }
                }
                ParcelFileDescriptor establish = blocking.establish();
                this$0.pfd = establish;
                if (establish == null) {
                    return;
                }
                Tun2tornado tun2tornado = Tun2tornado.INSTANCE;
                Intrinsics.checkNotNull(establish);
                tun2tornado.start(establish.getFd(), setting.getGameRegion(), setting.getGameID(), setting.getGameName());
                LogTo.INSTANCE.i("*****", "executor: tun2tornado had stopped -> vpn exit");
                this$0.stopVPN();
                LogTo.INSTANCE.i("*****", "executor exit");
            } catch (Exception unused) {
                this$0.stopVPN();
            }
        }
    }

    private final void start(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, intent) == null) {
            Tun2tornado.INSTANCE.init();
            if (setupVPN(intent)) {
                return;
            }
            stopVPN();
        }
    }

    @Override // com.baidu.yunjiasu.tornadosdk.TrdVpnBinderInterface
    public String getRuntimeInfo(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? TrdVpnBinderInterface.DefaultImpls.getRuntimeInfo(this, j) : (String) invokeJ.objValue;
    }

    @Override // android.net.VpnService, android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            if (intent == null || !Intrinsics.areEqual("android.net.VpnService", intent.getAction())) {
                if (intent == null) {
                    return null;
                }
                start(intent);
                return this.binder;
            }
            return super.onBind(intent);
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            TrdVpnBroadcast.Companion.register(this, this.broadcastReceiver);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TrdVpnBroadcast.Companion.unRegister(this, this.broadcastReceiver);
            super.onDestroy();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            super.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, intent)) == null) {
            super.onUnbind(intent);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.yunjiasu.tornadosdk.TrdVpnBinderInterface
    public void stopVPN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                TrdVpnNetwork.INSTANCE.unregister();
                Tun2tornado.INSTANCE.stop();
                if (!this.executorService.isShutdown() || !this.executorService.isTerminated()) {
                    this.executorService.shutdown();
                }
                ParcelFileDescriptor parcelFileDescriptor = this.pfd;
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
                this.pfd = null;
                Pinger.INSTANCE.stop();
                stopSelf();
                TimeUnit.MILLISECONDS.sleep(500L);
                TrdVpnBroadcast.Companion.unRegister(this, this.broadcastReceiver);
                System.exit(0);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            } catch (Exception unused) {
                stopSelf();
                TimeUnit.MILLISECONDS.sleep(500L);
                TrdVpnBroadcast.Companion.unRegister(this, this.broadcastReceiver);
                System.exit(0);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            }
        }
    }
}
