package com.baidu.yunjiasu.tornadosdk;

import android.os.Handler;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.yunjiasu.ping.Ping;
import com.baidu.yunjiasu.ping.PingStatistics;
import com.baidu.yunjiasu.tornadosdk.Pinger;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/Pinger;", "", "()V", "TAG", "", "addressTarget", "Ljava/net/InetAddress;", "pingHandler", "Landroid/os/Handler;", "pingStatistics", "Lcom/baidu/yunjiasu/ping/PingStatistics;", "threadRun", "Ljava/lang/Thread;", "get", "run", "", "address", "runOnce", "stop", StickerDataChangeType.UPDATE, "ps", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class Pinger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pinger INSTANCE;
    public static final String TAG = "Pinger";
    public static InetAddress addressTarget;
    public static final Handler pingHandler;
    public static PingStatistics pingStatistics;
    public static Thread threadRun;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(799028513, "Lcom/baidu/yunjiasu/tornadosdk/Pinger;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(799028513, "Lcom/baidu/yunjiasu/tornadosdk/Pinger;");
                return;
            }
        }
        INSTANCE = new Pinger();
        pingHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.nka
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) ? Pinger.m83pingHandler$lambda0(message) : invokeL.booleanValue;
            }
        });
    }

    public Pinger() {
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

    public final synchronized PingStatistics get() {
        InterceptResult invokeV;
        PingStatistics pingStatistics2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                pingStatistics2 = pingStatistics;
            }
            return pingStatistics2;
        }
        return (PingStatistics) invokeV.objValue;
    }

    public final void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Thread thread = threadRun;
            if (thread != null) {
                thread.interrupt();
            }
            Thread thread2 = threadRun;
            if (thread2 != null) {
                thread2.join();
            }
            threadRun = null;
        }
    }

    /* renamed from: pingHandler$lambda-0  reason: not valid java name */
    public static final boolean m83pingHandler$lambda0(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, message)) == null) {
            Object obj = message.obj;
            if (obj != null) {
                Pinger pinger = INSTANCE;
                if (obj != null) {
                    pinger.update((PingStatistics) obj);
                    return false;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.yunjiasu.ping.PingStatistics");
            }
            INSTANCE.update(null);
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runOnce(InetAddress inetAddress) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, inetAddress) == null) {
            PingStatistics ping = Ping.INSTANCE.ping(inetAddress);
            LogTo.INSTANCE.d(TAG, Intrinsics.stringPlus("run1(): ", ping));
            if (ping != null) {
                Message message = new Message();
                message.obj = ping;
                pingHandler.sendMessage(message);
            }
        }
    }

    public final synchronized void update(PingStatistics pingStatistics2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pingStatistics2) == null) {
            synchronized (this) {
                pingStatistics = pingStatistics2;
            }
        }
    }

    public final void run(final InetAddress address) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, address) == null) {
            Intrinsics.checkNotNullParameter(address, "address");
            InetAddress inetAddress = addressTarget;
            if (inetAddress != null && Intrinsics.areEqual(inetAddress.getHostAddress(), address.getHostAddress())) {
                return;
            }
            addressTarget = address;
            if (threadRun != null) {
                INSTANCE.stop();
            }
            LogTo.INSTANCE.i(TAG, Intrinsics.stringPlus("run: ", address));
            threadRun = ThreadsKt.thread$default(false, false, null, null, 0, new Function0<Unit>(address) { // from class: com.baidu.yunjiasu.tornadosdk.Pinger$run$3
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ InetAddress $address;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {address};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$address = address;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Thread thread;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    while (true) {
                        try {
                            thread = Pinger.threadRun;
                            boolean z = false;
                            if (thread != null && !thread.isInterrupted()) {
                                z = true;
                            }
                            return;
                            Pinger.INSTANCE.runOnce(this.$address);
                            TimeUnit.SECONDS.sleep(5L);
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
            }, 31, null);
        }
    }
}
