package com.baidu.yunjiasu.tornadosdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TrdVpnBinderInterface;", "", "getRuntimeInfo", "", "key", "", "stopVPN", "", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface TrdVpnBinderInterface {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String getRuntimeInfo(TrdVpnBinderInterface trdVpnBinderInterface, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65536, null, trdVpnBinderInterface, j)) == null) {
                Intrinsics.checkNotNullParameter(trdVpnBinderInterface, "this");
                if (j == 0) {
                    return TornadoLiteRuntime.INSTANCE.getChannel();
                }
                if (j == 1) {
                    return TornadoLiteRuntime.INSTANCE.getDevice();
                }
                if (j == 2) {
                    return TornadoLiteRuntime.INSTANCE.getCuid();
                }
                if (j == 3) {
                    return TornadoLiteRuntime.INSTANCE.getToken();
                }
                if (j == 4) {
                    return TornadoLiteRuntime.INSTANCE.getClientVersion();
                }
                if (j == 5) {
                    return TornadoLiteRuntime.INSTANCE.getSysVersion();
                }
                if (j == 6) {
                    return TornadoLiteRuntime.INSTANCE.getRegion();
                }
                if (j == 7) {
                    return TornadoLiteRuntime.INSTANCE.getGameID();
                }
                if (j == 8) {
                    return String.valueOf(TornadoLiteRuntime.INSTANCE.getLatencyFromSClientToRemote() + TornadoLiteRuntime.INSTANCE.getLatencyFromMClientToSClient());
                }
                if (j == 9) {
                    return String.valueOf(Math.max(TornadoLiteRuntime.INSTANCE.getLossRateFromMClientToSClient(), TornadoLiteRuntime.INSTANCE.getLossRateFromSClientToRemote()));
                }
                if (j == 10) {
                    return String.valueOf(TornadoLiteRuntime.INSTANCE.getOptimizationRate());
                }
                if (j == 11) {
                    return TornadoLiteRuntime.INSTANCE.getGamePackageName();
                }
                if (j == 12) {
                    return TornadoLiteRuntime.INSTANCE.getStatus();
                }
                return j == 13 ? String.valueOf(TornadoLiteRuntime.INSTANCE.getStartTime()) : "-1";
            }
            return (String) invokeLJ.objValue;
        }
    }

    String getRuntimeInfo(long j);

    void stopVPN();
}
