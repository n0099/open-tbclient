package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.webrtc.PeerConnection;
import org.webrtc.RtpTransceiver;
/* compiled from: PeerConnection.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class qx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void $default$onConnectionChange(PeerConnection.Observer observer, PeerConnection.PeerConnectionState peerConnectionState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, observer, peerConnectionState) == null) {
        }
    }

    public static void $default$onTrack(PeerConnection.Observer observer, RtpTransceiver rtpTransceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, observer, rtpTransceiver) == null) {
        }
    }
}
