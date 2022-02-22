package com.baidu.yunjiasu.tornadosdk;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.AndroidOperationInterface;
import com.baidu.yunjiasu.ping.PingStatistics;
import com.baidu.yunjiasu.tornadosdk.IAction;
import java.net.DatagramSocket;
import java.net.Socket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0015H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/T2TOperationInterface;", "Lcom/baidu/tun2tornadolite/AndroidOperationInterface;", "svc", "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnService;", "(Lcom/baidu/yunjiasu/tornadosdk/TrdVpnService;)V", "vpn", "bindNetwork", "", "networkType", "fd", "getNetwork", "", "getPing", "onEvent", "", "msgType", "msgText", "protect", "", "socket", "Ljava/net/DatagramSocket;", "Ljava/net/Socket;", "", "Companion", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class T2TOperationInterface implements AndroidOperationInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String TAG = "T2T_OP_INTERFACE";
    public transient /* synthetic */ FieldHolder $fh;
    public TrdVpnService vpn;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/T2TOperationInterface$Companion;", "", "()V", "TAG", "", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-367067154, "Lcom/baidu/yunjiasu/tornadosdk/T2TOperationInterface;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-367067154, "Lcom/baidu/yunjiasu/tornadosdk/T2TOperationInterface;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public T2TOperationInterface(TrdVpnService svc) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {svc};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(svc, "svc");
        this.vpn = svc;
    }

    @Override // com.baidu.tun2tornadolite.AndroidOperationInterface
    public long bindNetwork(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (j2 == 2) {
                long bindSocket = TrdVpnNetwork.INSTANCE.bindSocket((int) j3);
                Intrinsics.stringPlus("bindSocket() fd: ", Long.valueOf(j3));
                return bindSocket;
            }
            return 0L;
        }
        return invokeCommon.longValue;
    }

    @Override // com.baidu.tun2tornadolite.AndroidOperationInterface
    public String getNetwork(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? TrdVpnNetwork.INSTANCE.getNetworkForT2T(j2) : (String) invokeJ.objValue;
    }

    @Override // com.baidu.tun2tornadolite.AndroidOperationInterface
    public String getPing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PingStatistics pingStatistics = Pinger.INSTANCE.get();
            return pingStatistics == null ? "" : pingStatistics.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tun2tornadolite.AndroidOperationInterface
    public void onEvent(long j2, String msgText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j2, msgText) == null) {
            Intrinsics.checkNotNullParameter(msgText, "msgText");
            String str = IAction.T2T.INSTANCE.getActionMap().get(Long.valueOf(j2));
            if (str == null) {
                return;
            }
            Intent putExtra = new Intent(str).putExtra(IAction.EXTRA.VALUE_STRING, msgText);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(action).putExtra(…RA.VALUE_STRING, msgText)");
            this.vpn.sendBroadcast(putExtra);
        }
    }

    @Override // com.baidu.tun2tornadolite.AndroidOperationInterface
    public boolean protect(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.vpn.protect(i2) : invokeI.booleanValue;
    }

    @Override // com.baidu.tun2tornadolite.AndroidOperationInterface
    public boolean protect(Socket socket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, socket)) == null) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            return this.vpn.protect(socket);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tun2tornadolite.AndroidOperationInterface
    public boolean protect(DatagramSocket socket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, socket)) == null) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            return this.vpn.protect(socket);
        }
        return invokeL.booleanValue;
    }
}
