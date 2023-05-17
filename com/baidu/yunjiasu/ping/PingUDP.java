package com.baidu.yunjiasu.ping;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructPollfd;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.FileDescriptor;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/yunjiasu/ping/PingUDP;", "", "()V", "TAG", "", "ping", "Lcom/baidu/yunjiasu/ping/PingStatistics;", "address", "Ljava/net/InetAddress;", "setLowDelay", "", "fd", "Ljava/io/FileDescriptor;", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class PingUDP {
    public static /* synthetic */ Interceptable $ic = null;
    public static final PingUDP INSTANCE;
    public static final String TAG = "PingUDP";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(204810714, "Lcom/baidu/yunjiasu/ping/PingUDP;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(204810714, "Lcom/baidu/yunjiasu/ping/PingUDP;");
                return;
            }
        }
        INSTANCE = new PingUDP();
    }

    public PingUDP() {
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

    public final PingStatistics ping(InetAddress address) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, address)) == null) {
            Intrinsics.checkNotNullParameter(address, "address");
            FileDescriptor socketFD = Os.socket(OsConstants.AF_INET, OsConstants.SOCK_DGRAM, OsConstants.IPPROTO_ICMP);
            Intrinsics.checkNotNullExpressionValue(socketFD, "socketFD");
            setLowDelay(socketFD);
            StructPollfd structPollfd = new StructPollfd();
            structPollfd.fd = socketFD;
            structPollfd.events = (short) OsConstants.POLLIN;
            byte[] bytes = "abcdefghijklmnopqrstuvwabcdefghi".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            ByteBuffer build = new PingEchoPacketBuilder((byte) 8, bytes).build();
            long currentTimeMillis = System.currentTimeMillis();
            Os.sendto(socketFD, build, 0, address, 7);
            int limit = build.limit();
            byte[] bArr = new byte[limit];
            int poll = Os.poll(new StructPollfd[]{structPollfd}, 100);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (poll >= 0 && structPollfd.revents == ((short) OsConstants.POLLIN)) {
                structPollfd.revents = (short) 0;
                int recvfrom = Os.recvfrom(socketFD, bArr, 0, limit, 64, null);
                if (recvfrom < 0) {
                    Log.d(TAG, Intrinsics.stringPlus("recvfrom() return failure: ", Integer.valueOf(recvfrom)));
                }
                Log.e(TAG, ">>> Ping " + currentTimeMillis + WebvttCueParser.CHAR_SPACE + currentTimeMillis2);
            }
            Os.close(socketFD);
            return null;
        }
        return (PingStatistics) invokeL.objValue;
    }

    public final void setLowDelay(FileDescriptor fd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fd) == null) {
            Intrinsics.checkNotNullParameter(fd, "fd");
            if (Build.VERSION.SDK_INT >= 26) {
                Os.setsockoptInt(fd, OsConstants.IPPROTO_IP, OsConstants.IP_TOS, 16);
                return;
            }
            try {
                Method method = Os.class.getMethod("setsockoptInt", FileDescriptor.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                Intrinsics.checkNotNullExpressionValue(method, "Os::class.java.getMethod…:class.javaPrimitiveType)");
                method.invoke(null, fd, Integer.valueOf(OsConstants.IPPROTO_IP), Integer.valueOf(OsConstants.IP_TOS), 16);
            } catch (Exception e) {
                Log.e(TAG, Intrinsics.stringPlus("Exception: ", e));
            }
        }
    }
}
