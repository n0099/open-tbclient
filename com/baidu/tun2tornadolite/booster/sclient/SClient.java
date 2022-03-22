package com.baidu.tun2tornadolite.booster.sclient;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.AndroidOperationInterface;
import com.baidu.tun2tornadolite.booster.LogTo;
import com.baidu.tun2tornadolite.booster.data.HandShakePacketRequest;
import com.baidu.tun2tornadolite.booster.data.HandShakePacketResponse;
import com.baidu.tun2tornadolite.booster.data.SClientConfig;
import com.baidu.tun2tornadolite.booster.data.SClientEvent;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.baidu.tun2tornadolite.booster.tun.Tun;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.gson.Gson;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001FB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010,J!\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010,J\u000e\u0010.\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tJ\u0011\u0010/\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0004\u0018\u00010\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J\b\u00102\u001a\u00020\u000eH\u0002J\u0019\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u000205H\u0086@ø\u0001\u0000¢\u0006\u0002\u00106J\u0018\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020:H\u0002J!\u0010;\u001a\u00020(2\u0006\u00104\u001a\u0002052\u0006\u0010*\u001a\u00020+H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010<J\u0011\u0010=\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J\u0011\u0010>\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u00100J\u0006\u0010?\u001a\u00020\u000eJ;\u0010@\u001a\u0002HA\"\u0004\b\u0000\u0010A2\u0006\u0010*\u001a\u00020+2\u001a\b\u0004\u0010B\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002HA0C\u0012\u0004\u0012\u00020\u000e0\u001aH\u0082Hø\u0001\u0000¢\u0006\u0002\u0010DJ\u000e\u0010E\u001a\u00020\u000e2\u0006\u00109\u001a\u00020:R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/sclient/SClient;", "", "()V", "PACKET_SIZE", "", "UDP_PROD_PORT", "address", "", "ai", "Lcom/baidu/tun2tornadolite/AndroidOperationInterface;", "bodyBuffer", "Ljava/nio/ByteBuffer;", "handleLoop", "Lkotlinx/coroutines/Deferred;", "", "getHandleLoop", "()Lkotlinx/coroutines/Deferred;", "setHandleLoop", "(Lkotlinx/coroutines/Deferred;)V", "headerBuffer", "inited", "", "json", "Lcom/google/gson/Gson;", "looping", "onHandShakeSuccess", "Lkotlin/Function1;", "output", "Ljava/io/OutputStream;", DpStatConstants.KEY_PREPARED, "probeLoop", "getProbeLoop", "setProbeLoop", "socket", "Ljava/net/Socket;", "udpSocket", "Ljava/net/DatagramSocket;", "writeLock", "Ljava/util/concurrent/locks/ReentrantLock;", "connectSClient", "Lcom/baidu/tun2tornadolite/booster/sclient/SClient$ConnectResult;", "sClient", "timeout", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConnectSClientTime", "init", "loop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loopProbe", "openWriteChannel", "prepare", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tun2tornadolite/booster/data/SClientConfig;", "(Lcom/baidu/tun2tornadolite/booster/data/SClientConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processPacket", "i", "packet", "Lcom/baidu/tun2tornadolite/booster/sclient/SClientPacket;", "selectSClient", "(Lcom/baidu/tun2tornadolite/booster/data/SClientConfig;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendHandShake", "start", IntentConfig.STOP, "suspendCoroutineWithTimeout", "T", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/coroutines/Continuation;", "(JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AlbumActivityConfig.FROM_WRITE, "ConnectResult", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final SClient INSTANCE;
    public static final int PACKET_SIZE = 65535;
    public static final int UDP_PROD_PORT = 8018;
    public static String address;
    public static AndroidOperationInterface ai;
    public static ByteBuffer bodyBuffer;
    public static Deferred<Unit> handleLoop;
    public static ByteBuffer headerBuffer;
    public static boolean inited;
    public static Gson json;
    public static boolean looping;
    public static Function1<? super Boolean, Unit> onHandShakeSuccess;
    public static OutputStream output;
    public static boolean prepared;
    public static Deferred<Unit> probeLoop;
    public static Socket socket;
    public static DatagramSocket udpSocket;
    public static ReentrantLock writeLock;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/sclient/SClient$ConnectResult;", "", "address", "", "socket", "Ljava/net/Socket;", "status", "", "connectTime", "", "(Ljava/lang/String;Ljava/net/Socket;IJ)V", "getAddress", "()Ljava/lang/String;", "getConnectTime", "()J", "getSocket", "()Ljava/net/Socket;", "getStatus", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ConnectResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String address;
        public final long connectTime;
        public final Socket socket;
        public final int status;

        public ConnectResult(String address, Socket socket, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {address, socket, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(address, "address");
            this.address = address;
            this.socket = socket;
            this.status = i;
            this.connectTime = j;
        }

        public static /* synthetic */ ConnectResult copy$default(ConnectResult connectResult, String str, Socket socket, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = connectResult.address;
            }
            if ((i2 & 2) != 0) {
                socket = connectResult.socket;
            }
            Socket socket2 = socket;
            if ((i2 & 4) != 0) {
                i = connectResult.status;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                j = connectResult.connectTime;
            }
            return connectResult.copy(str, socket2, i3, j);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.address : (String) invokeV.objValue;
        }

        public final Socket component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.socket : (Socket) invokeV.objValue;
        }

        public final int component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.status : invokeV.intValue;
        }

        public final long component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.connectTime : invokeV.longValue;
        }

        public final ConnectResult copy(String address, Socket socket, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{address, socket, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                Intrinsics.checkNotNullParameter(address, "address");
                return new ConnectResult(address, socket, i, j);
            }
            return (ConnectResult) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ConnectResult) {
                    ConnectResult connectResult = (ConnectResult) obj;
                    return Intrinsics.areEqual(this.address, connectResult.address) && Intrinsics.areEqual(this.socket, connectResult.socket) && this.status == connectResult.status && this.connectTime == connectResult.connectTime;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public final String getAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.address : (String) invokeV.objValue;
        }

        public final long getConnectTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.connectTime : invokeV.longValue;
        }

        public final Socket getSocket() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.socket : (Socket) invokeV.objValue;
        }

        public final int getStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.status : invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                int hashCode = this.address.hashCode() * 31;
                Socket socket = this.socket;
                return ((((hashCode + (socket == null ? 0 : socket.hashCode())) * 31) + this.status) * 31) + a.a(this.connectTime);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "ConnectResult(address=" + this.address + ", socket=" + this.socket + ", status=" + this.status + ", connectTime=" + this.connectTime + ')';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(95030508, "Lcom/baidu/tun2tornadolite/booster/sclient/SClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(95030508, "Lcom/baidu/tun2tornadolite/booster/sclient/SClient;");
                return;
            }
        }
        INSTANCE = new SClient();
        json = new Gson();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(4)");
        headerBuffer = allocate;
        ByteBuffer allocate2 = ByteBuffer.allocate(65535);
        Intrinsics.checkNotNullExpressionValue(allocate2, "allocate(PACKET_SIZE)");
        bodyBuffer = allocate2;
        writeLock = new ReentrantLock();
    }

    public SClient() {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connectSClient(String str, long j, Continuation<? super ConnectResult> continuation) {
        InterceptResult invokeCommon;
        SClient$connectSClient$1 sClient$connectSClient$1;
        int i;
        String str2;
        long currentTimeMillis;
        Socket createSocket;
        SClient$connectSClient$$inlined$suspendCoroutineWithTimeout$1 sClient$connectSClient$$inlined$suspendCoroutineWithTimeout$1;
        String str3;
        long j2;
        Socket socket2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, this, new Object[]{str, Long.valueOf(j), continuation})) == null) {
            if (continuation instanceof SClient$connectSClient$1) {
                sClient$connectSClient$1 = (SClient$connectSClient$1) continuation;
                int i2 = sClient$connectSClient$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    sClient$connectSClient$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = sClient$connectSClient$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = sClient$connectSClient$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{':'}, false, 0, 6, (Object) null);
                            int parseInt = Integer.parseInt((String) split$default.get(1));
                            currentTimeMillis = System.currentTimeMillis();
                            createSocket = SSLSocketFactory.getDefault().createSocket();
                            sClient$connectSClient$$inlined$suspendCoroutineWithTimeout$1 = new SClient$connectSClient$$inlined$suspendCoroutineWithTimeout$1(null, createSocket, (String) split$default.get(0), parseInt);
                            str2 = str;
                        } catch (Exception e2) {
                            e = e2;
                            str2 = str;
                        }
                        try {
                            sClient$connectSClient$1.L$0 = str2;
                            sClient$connectSClient$1.L$1 = createSocket;
                            sClient$connectSClient$1.J$0 = currentTimeMillis;
                            sClient$connectSClient$1.label = 1;
                            if (TimeoutKt.withTimeout(j, sClient$connectSClient$$inlined$suspendCoroutineWithTimeout$1, sClient$connectSClient$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = str2;
                            j2 = currentTimeMillis;
                            socket2 = createSocket;
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            return new ConnectResult(str2, null, 1, 0L);
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        j2 = sClient$connectSClient$1.J$0;
                        Socket socket3 = (Socket) sClient$connectSClient$1.L$1;
                        str3 = (String) sClient$connectSClient$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            socket2 = socket3;
                        } catch (Exception e4) {
                            e = e4;
                            str2 = str3;
                            e.printStackTrace();
                            return new ConnectResult(str2, null, 1, 0L);
                        }
                    }
                    return new ConnectResult(str3, socket2, 0, System.currentTimeMillis() - j2);
                }
            }
            sClient$connectSClient$1 = new SClient$connectSClient$1(this, continuation);
            Object obj2 = sClient$connectSClient$1.result;
            Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = sClient$connectSClient$1.label;
            if (i != 0) {
            }
            return new ConnectResult(str3, socket2, 0, System.currentTimeMillis() - j2);
        }
        return invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getConnectSClientTime(String str, long j, Continuation<? super ConnectResult> continuation) {
        InterceptResult invokeCommon;
        SClient$getConnectSClientTime$1 sClient$getConnectSClientTime$1;
        int i;
        Socket socket2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, this, new Object[]{str, Long.valueOf(j), continuation})) == null) {
            if (continuation instanceof SClient$getConnectSClientTime$1) {
                sClient$getConnectSClientTime$1 = (SClient$getConnectSClientTime$1) continuation;
                int i2 = sClient$getConnectSClientTime$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    sClient$getConnectSClientTime$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = sClient$getConnectSClientTime$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = sClient$getConnectSClientTime$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        sClient$getConnectSClientTime$1.label = 1;
                        obj = connectSClient(str, j, sClient$getConnectSClientTime$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    ConnectResult connectResult = (ConnectResult) obj;
                    socket2 = connectResult.getSocket();
                    if (socket2 != null) {
                        socket2.close();
                    }
                    return connectResult;
                }
            }
            sClient$getConnectSClientTime$1 = new SClient$getConnectSClientTime$1(this, continuation);
            Object obj2 = sClient$getConnectSClientTime$1.result;
            Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = sClient$getConnectSClientTime$1.label;
            if (i != 0) {
            }
            ConnectResult connectResult2 = (ConnectResult) obj2;
            socket2 = connectResult2.getSocket();
            if (socket2 != null) {
            }
            return connectResult2;
        }
        return invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loop(Continuation<? super Unit> continuation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, continuation)) == null) {
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new SClient$loop$2(null), continuation);
            return withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }
        return invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loopProbe(Continuation<? super Unit> continuation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, this, continuation)) == null) ? BuildersKt.withContext(Dispatchers.getIO(), new SClient$loopProbe$2(null), continuation) : invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openWriteChannel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            Socket socket2 = socket;
            Intrinsics.checkNotNull(socket2);
            output = socket2.getOutputStream();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processPacket(long j, SClientPacket sClientPacket) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65564, this, j, sClientPacket) == null) {
            LogTo logTo = LogTo.INSTANCE;
            logTo.d("*****", "[SClient " + j + "] read socket packet all:" + ((Object) UInt.m831toStringimpl(sClientPacket.m85getBodyLengthpVg5ArA())) + " command:" + SClientPacket.Companion.m91cmd2StrWZ4Q5Ns(sClientPacket.m86getCommandpVg5ArA()));
            int m86getCommandpVg5ArA = sClientPacket.m86getCommandpVg5ArA();
            if (m86getCommandpVg5ArA == 0) {
                byte[] array = sClientPacket.getBody().array();
                Intrinsics.checkNotNullExpressionValue(array, "packet.getBody().array()");
                byte[] sliceArray = ArraysKt___ArraysKt.sliceArray(array, new IntRange(0, sClientPacket.m85getBodyLengthpVg5ArA() - 1));
                sClientPacket.getBody().get(sliceArray, 0, sClientPacket.m85getBodyLengthpVg5ArA());
                Charset defaultCharset = Charset.defaultCharset();
                Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
                String str = new String(sliceArray, defaultCharset);
                LogTo logTo2 = LogTo.INSTANCE;
                logTo2.d("*****", "[CMD_HAND_SHAKE " + j + "] " + str);
                Object fromJson = json.fromJson(str, (Class<Object>) HandShakePacketResponse.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "json.fromJson(str, HandS…cketResponse::class.java)");
                HandShakePacketResponse handShakePacketResponse = (HandShakePacketResponse) fromJson;
                if (handShakePacketResponse.getError_code() == 0) {
                    TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(51L);
                    Function1<? super Boolean, Unit> function1 = onHandShakeSuccess;
                    if (function1 == null) {
                        return;
                    }
                    function1.invoke(Boolean.TRUE);
                    return;
                }
                TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(52L, handShakePacketResponse.getError_msg());
                looping = false;
                Function1<? super Boolean, Unit> function12 = onHandShakeSuccess;
                if (function12 == null) {
                    return;
                }
                function12.invoke(Boolean.FALSE);
            } else if (m86getCommandpVg5ArA == 1) {
                LogTo logTo3 = LogTo.INSTANCE;
                logTo3.d("*****", "[CMD_IP_PACKET " + j + "] len: " + sClientPacket.m85getBodyLengthpVg5ArA());
                Tun.INSTANCE.write(sClientPacket.getBody(), sClientPacket.m85getBodyLengthpVg5ArA());
            } else if (m86getCommandpVg5ArA == 2) {
                byte[] bArr = new byte[sClientPacket.m85getBodyLengthpVg5ArA()];
                sClientPacket.getBody().get(bArr, 0, sClientPacket.m85getBodyLengthpVg5ArA());
                Charset defaultCharset2 = Charset.defaultCharset();
                Intrinsics.checkNotNullExpressionValue(defaultCharset2, "defaultCharset()");
                String str2 = new String(bArr, defaultCharset2);
                Object fromJson2 = json.fromJson(str2, (Class<Object>) SClientEvent.class);
                Intrinsics.checkNotNullExpressionValue(fromJson2, "json.fromJson(str, SClientEvent::class.java)");
                SClientEvent sClientEvent = (SClientEvent) fromJson2;
                LogTo logTo4 = LogTo.INSTANCE;
                logTo4.d("*****", "[CMD_EVENT " + j + "] " + str2 + WebvttCueParser.CHAR_SPACE + sClientEvent);
                if (Intrinsics.areEqual(sClientEvent.getEvent(), SClientEvent.EVENT_CLOSE)) {
                    TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(61L, sClientEvent.getData().getMessage_cn());
                    looping = false;
                }
            } else if (m86getCommandpVg5ArA != 3) {
            } else {
                byte[] array2 = sClientPacket.getBody().array();
                Intrinsics.checkNotNullExpressionValue(array2, "packet.getBody().array()");
                byte[] sliceArray2 = ArraysKt___ArraysKt.sliceArray(array2, new IntRange(0, sClientPacket.m85getBodyLengthpVg5ArA() - 1));
                int m786constructorimpl = UInt.m786constructorimpl(UInt.m786constructorimpl(UInt.m786constructorimpl(UByte.m710constructorimpl(sliceArray2[0]) & 255) << 8) | UInt.m786constructorimpl(UByte.m710constructorimpl(sliceArray2[1]) & 255));
                int m786constructorimpl2 = UInt.m786constructorimpl(UInt.m786constructorimpl(UInt.m786constructorimpl(UByte.m710constructorimpl(sliceArray2[2]) & 255) << 8) | UInt.m786constructorimpl(UByte.m710constructorimpl(sliceArray2[3]) & 255));
                TornadoLiteRuntime.INSTANCE.setLatencyFromSClientToRemote$tun2tornadolite_release(m786constructorimpl);
                TornadoLiteRuntime.INSTANCE.setLossRateFromSClientToRemote$tun2tornadolite_release(m786constructorimpl2);
                int latencyFromMClientToSClient = TornadoLiteRuntime.INSTANCE.getLatencyFromMClientToSClient();
                int lossRateFromMClientToSClient = TornadoLiteRuntime.INSTANCE.getLossRateFromMClientToSClient();
                if (TornadoLiteRuntime.INSTANCE.getLossRateFromSClientToRemote() + TornadoLiteRuntime.INSTANCE.getLossRateFromMClientToSClient() >= 100) {
                    TornadoLiteRuntime.INSTANCE.setOptimizationRate$tun2tornadolite_release(0);
                    i = latencyFromMClientToSClient;
                } else {
                    i = latencyFromMClientToSClient;
                    TornadoLiteRuntime.INSTANCE.setOptimizationRate$tun2tornadolite_release((100 - (TornadoLiteRuntime.INSTANCE.getLossRateFromSClientToRemote() + TornadoLiteRuntime.INSTANCE.getLossRateFromMClientToSClient())) + ((int) (((-Math.random()) * 10) + 3)));
                    if (TornadoLiteRuntime.INSTANCE.getOptimizationRate() > 100) {
                        TornadoLiteRuntime.INSTANCE.setOptimizationRate$tun2tornadolite_release(100);
                    }
                }
                LogTo logTo5 = LogTo.INSTANCE;
                StringBuilder sb = new StringBuilder();
                sb.append("[CMD_HEART_BEAT ");
                sb.append(j);
                sb.append("] remote_latency:");
                sb.append((Object) UInt.m831toStringimpl(m786constructorimpl));
                sb.append(" remote_lossRate:");
                sb.append((Object) UInt.m831toStringimpl(m786constructorimpl2));
                sb.append(" local_latency:");
                int i2 = i;
                sb.append(i2);
                sb.append(" local_lossRate:");
                sb.append(lossRateFromMClientToSClient);
                sb.append(" optimization_rate:");
                sb.append(TornadoLiteRuntime.INSTANCE.getOptimizationRate());
                logTo5.d("*****", sb.toString());
                sliceArray2[0] = (byte) ((i2 & 65280) >> 8);
                sliceArray2[1] = (byte) ((i2 & 255) << 0);
                sliceArray2[2] = (byte) ((lossRateFromMClientToSClient & 65280) >> 8);
                sliceArray2[3] = (byte) ((lossRateFromMClientToSClient & 255) << 0);
                SClientPacket sClientPacket2 = new SClientPacket(1, 0, 3, 4, null);
                sClientPacket2.encodeHeader2Buffer(headerBuffer);
                bodyBuffer.clear();
                bodyBuffer.put(sliceArray2);
                sClientPacket2.writeBodyBuffer(bodyBuffer);
                write(sClientPacket2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object selectSClient(SClientConfig sClientConfig, long j, Continuation<? super ConnectResult> continuation) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, this, new Object[]{sClientConfig, Long.valueOf(j), continuation})) == null) ? BuildersKt.withContext(Dispatchers.getIO(), new SClient$selectSClient$2(sClientConfig, j, null), continuation) : invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendHandShake(Continuation<? super Boolean> continuation) {
        InterceptResult invokeL;
        SClient$sendHandShake$1 sClient$sendHandShake$1;
        Object obj;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65566, this, continuation)) != null) {
            return invokeL.objValue;
        }
        try {
            if (continuation instanceof SClient$sendHandShake$1) {
                sClient$sendHandShake$1 = (SClient$sendHandShake$1) continuation;
                int i2 = sClient$sendHandShake$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    sClient$sendHandShake$1.label = i2 - Integer.MIN_VALUE;
                    obj = sClient$sendHandShake$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = sClient$sendHandShake$1.label;
                    boolean z = true;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        HandShakePacketRequest handShakePacketRequest = new HandShakePacketRequest();
                        handShakePacketRequest.setUserinfo(new HandShakePacketRequest.UserInfo());
                        HandShakePacketRequest.UserInfo userinfo = handShakePacketRequest.getUserinfo();
                        Intrinsics.checkNotNull(userinfo);
                        userinfo.setChannel(TornadoLiteRuntime.INSTANCE.getChannel());
                        HandShakePacketRequest.UserInfo userinfo2 = handShakePacketRequest.getUserinfo();
                        Intrinsics.checkNotNull(userinfo2);
                        userinfo2.setClient_ver(TornadoLiteRuntime.INSTANCE.getClientVersion());
                        HandShakePacketRequest.UserInfo userinfo3 = handShakePacketRequest.getUserinfo();
                        Intrinsics.checkNotNull(userinfo3);
                        userinfo3.setSys_ver(TornadoLiteRuntime.INSTANCE.getSysVersion());
                        HandShakePacketRequest.UserInfo userinfo4 = handShakePacketRequest.getUserinfo();
                        Intrinsics.checkNotNull(userinfo4);
                        userinfo4.setCuid(TornadoLiteRuntime.INSTANCE.getCuid());
                        HandShakePacketRequest.UserInfo userinfo5 = handShakePacketRequest.getUserinfo();
                        Intrinsics.checkNotNull(userinfo5);
                        userinfo5.setToken(TornadoLiteRuntime.INSTANCE.getToken());
                        HandShakePacketRequest.UserInfo userinfo6 = handShakePacketRequest.getUserinfo();
                        Intrinsics.checkNotNull(userinfo6);
                        userinfo6.setDevice(TornadoLiteRuntime.INSTANCE.getDevice());
                        handShakePacketRequest.setGameinfo(new HandShakePacketRequest.GameInfo());
                        HandShakePacketRequest.GameInfo gameinfo = handShakePacketRequest.getGameinfo();
                        Intrinsics.checkNotNull(gameinfo);
                        gameinfo.setGame_id(TornadoLiteRuntime.INSTANCE.getGameID());
                        HandShakePacketRequest.GameInfo gameinfo2 = handShakePacketRequest.getGameinfo();
                        Intrinsics.checkNotNull(gameinfo2);
                        gameinfo2.setPackage_name(TornadoLiteRuntime.INSTANCE.getGamePackageName());
                        HandShakePacketRequest.GameInfo gameinfo3 = handShakePacketRequest.getGameinfo();
                        Intrinsics.checkNotNull(gameinfo3);
                        gameinfo3.setRegion(TornadoLiteRuntime.INSTANCE.getRegion());
                        String str = json.toJson(handShakePacketRequest);
                        LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("[Send Hand Shake] ", str));
                        Intrinsics.checkNotNullExpressionValue(str, "str");
                        byte[] bytes = str.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        bodyBuffer.put(bytes);
                        SClientPacket sClientPacket = new SClientPacket(1, 0, 0, UInt.m786constructorimpl(bytes.length), null);
                        sClientPacket.encodeHeader2Buffer(headerBuffer);
                        sClientPacket.writeBodyBuffer(bodyBuffer);
                        write(sClientPacket);
                        SClient$sendHandShake$$inlined$suspendCoroutineWithTimeout$1 sClient$sendHandShake$$inlined$suspendCoroutineWithTimeout$1 = new SClient$sendHandShake$$inlined$suspendCoroutineWithTimeout$1(null);
                        sClient$sendHandShake$1.L$0 = this;
                        sClient$sendHandShake$1.label = 1;
                        obj = TimeoutKt.withTimeout(10000L, sClient$sendHandShake$$inlined$suspendCoroutineWithTimeout$1, sClient$sendHandShake$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        SClient sClient = (SClient) sClient$sendHandShake$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    if (((Boolean) obj).booleanValue()) {
                        z = false;
                    }
                    return Boxing.boxBoolean(z);
                }
            }
            if (i != 0) {
            }
            if (((Boolean) obj).booleanValue()) {
            }
            return Boxing.boxBoolean(z);
        } catch (Throwable th) {
            onHandShakeSuccess = null;
            th.printStackTrace();
            return Boxing.boxBoolean(false);
        }
        sClient$sendHandShake$1 = new SClient$sendHandShake$1(this, continuation);
        obj = sClient$sendHandShake$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = sClient$sendHandShake$1.label;
        boolean z2 = true;
    }

    private final <T> Object suspendCoroutineWithTimeout(long j, Function1<? super Continuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65567, this, new Object[]{Long.valueOf(j), function1, continuation})) == null) {
            SClient$suspendCoroutineWithTimeout$2 sClient$suspendCoroutineWithTimeout$2 = new SClient$suspendCoroutineWithTimeout$2(function1, null);
            InlineMarker.mark(0);
            Object withTimeout = TimeoutKt.withTimeout(j, sClient$suspendCoroutineWithTimeout$2, continuation);
            InlineMarker.mark(1);
            return withTimeout;
        }
        return invokeCommon.objValue;
    }

    public final Deferred<Unit> getHandleLoop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Deferred<Unit> deferred = handleLoop;
            if (deferred != null) {
                return deferred;
            }
            Intrinsics.throwUninitializedPropertyAccessException("handleLoop");
            return null;
        }
        return (Deferred) invokeV.objValue;
    }

    public final Deferred<Unit> getProbeLoop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Deferred<Unit> deferred = probeLoop;
            if (deferred != null) {
                return deferred;
            }
            Intrinsics.throwUninitializedPropertyAccessException("probeLoop");
            return null;
        }
        return (Deferred) invokeV.objValue;
    }

    public final void init(AndroidOperationInterface ai2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ai2) == null) {
            Intrinsics.checkNotNullParameter(ai2, "ai");
            ai = ai2;
            inited = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepare(SClientConfig sClientConfig, Continuation<? super Boolean> continuation) {
        InterceptResult invokeLL;
        SClient$prepare$1 sClient$prepare$1;
        int i;
        boolean booleanValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sClientConfig, continuation)) == null) {
            if (continuation instanceof SClient$prepare$1) {
                sClient$prepare$1 = (SClient$prepare$1) continuation;
                int i2 = sClient$prepare$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    sClient$prepare$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = sClient$prepare$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = sClient$prepare$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineDispatcher io2 = Dispatchers.getIO();
                        SClient$prepare$ok$1 sClient$prepare$ok$1 = new SClient$prepare$ok$1(sClientConfig, this, null);
                        sClient$prepare$1.L$0 = this;
                        sClient$prepare$1.label = 1;
                        obj = BuildersKt.withContext(io2, sClient$prepare$ok$1, sClient$prepare$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        SClient sClient = (SClient) sClient$prepare$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    booleanValue = ((Boolean) obj).booleanValue();
                    if (!booleanValue) {
                        TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(0L);
                    } else {
                        TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(1L, "SClient node 连接失败");
                    }
                    prepared = booleanValue;
                    return Boxing.boxBoolean(booleanValue);
                }
            }
            sClient$prepare$1 = new SClient$prepare$1(this, continuation);
            Object obj2 = sClient$prepare$1.result;
            Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = sClient$prepare$1.label;
            if (i != 0) {
            }
            booleanValue = ((Boolean) obj2).booleanValue();
            if (!booleanValue) {
            }
            prepared = booleanValue;
            return Boxing.boxBoolean(booleanValue);
        }
        return invokeLL.objValue;
    }

    public final void setHandleLoop(Deferred<Unit> deferred) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, deferred) == null) {
            Intrinsics.checkNotNullParameter(deferred, "<set-?>");
            handleLoop = deferred;
        }
    }

    public final void setProbeLoop(Deferred<Unit> deferred) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, deferred) == null) {
            Intrinsics.checkNotNullParameter(deferred, "<set-?>");
            probeLoop = deferred;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002d, B:29:0x0071, B:32:0x0082, B:34:0x0098, B:39:0x00ad, B:35:0x00a0, B:20:0x003f, B:24:0x0050, B:26:0x0054, B:30:0x0078, B:23:0x0044), top: B:47:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002d, B:29:0x0071, B:32:0x0082, B:34:0x0098, B:39:0x00ad, B:35:0x00a0, B:20:0x003f, B:24:0x0050, B:26:0x0054, B:30:0x0078, B:23:0x0044), top: B:47:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002d, B:29:0x0071, B:32:0x0082, B:34:0x0098, B:39:0x00ad, B:35:0x00a0, B:20:0x003f, B:24:0x0050, B:26:0x0054, B:30:0x0078, B:23:0x0044), top: B:47:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object start(Continuation<? super Boolean> continuation) {
        InterceptResult invokeL;
        SClient$start$1 sClient$start$1;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048582, this, continuation)) != null) {
            return invokeL.objValue;
        }
        try {
            if (continuation instanceof SClient$start$1) {
                sClient$start$1 = (SClient$start$1) continuation;
                int i2 = sClient$start$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    sClient$start$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = sClient$start$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = sClient$start$1.label;
                    boolean z2 = true;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        AndroidOperationInterface androidOperationInterface = ai;
                        if (androidOperationInterface != null) {
                            Socket socket2 = socket;
                            Intrinsics.checkNotNull(socket2);
                            Boxing.boxBoolean(androidOperationInterface.protect(socket2));
                        }
                        if (prepared) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SClient$start$ok$1(null), 3, null);
                            sClient$start$1.label = 1;
                            obj = sendHandShake(sClient$start$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(22L, "SClient node 未连接");
                            z = false;
                            if (z) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SClient$start$2(null), 3, null);
                            }
                            if (z) {
                                TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(21L);
                            } else {
                                TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(23L, "握手失败");
                            }
                            if (!z) {
                                z2 = false;
                            }
                            return Boxing.boxBoolean(z2);
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    z = ((Boolean) obj).booleanValue();
                    if (z) {
                    }
                    if (z) {
                    }
                    if (!z) {
                    }
                    return Boxing.boxBoolean(z2);
                }
            }
            if (i != 0) {
            }
            z = ((Boolean) obj).booleanValue();
            if (z) {
            }
            if (z) {
            }
            if (!z) {
            }
            return Boxing.boxBoolean(z2);
        } catch (Throwable th) {
            th.printStackTrace();
            TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(22L, th.toString());
            return Boxing.boxBoolean(false);
        }
        sClient$start$1 = new SClient$start$1(this, continuation);
        Object obj2 = sClient$start$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = sClient$start$1.label;
        boolean z22 = true;
    }

    public final void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            looping = false;
        }
    }

    public final void write(SClientPacket packet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, packet) == null) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            if (inited) {
                ReentrantLock reentrantLock = writeLock;
                reentrantLock.lock();
                try {
                    OutputStream outputStream = output;
                    Intrinsics.checkNotNull(outputStream);
                    outputStream.write(packet.getHeader().array(), 0, 4);
                    OutputStream outputStream2 = output;
                    Intrinsics.checkNotNull(outputStream2);
                    outputStream2.write(packet.getBody().array(), 0, packet.m85getBodyLengthpVg5ArA());
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                }
            }
        }
    }
}
