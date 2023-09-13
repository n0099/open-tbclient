package com.baidu.tts;

import android.media.AudioTrack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
/* loaded from: classes9.dex */
public class z1 implements AudioTrack.OnPlaybackPositionUpdateListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ a2 a;

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onPeriodicNotification(AudioTrack audioTrack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, audioTrack) == null) {
        }
    }

    public z1(a2 a2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = a2Var;
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onMarkerReached(AudioTrack audioTrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, audioTrack) == null) && audioTrack != null) {
            try {
                if (audioTrack.getPlayState() == 3) {
                    int notificationMarkerPosition = audioTrack.getNotificationMarkerPosition();
                    int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                    if (notificationMarkerPosition == playbackHeadPosition) {
                        a2 a2Var = this.a;
                        a2Var.n = notificationMarkerPosition;
                        a2Var.o = System.currentTimeMillis();
                    }
                    String str = this.a.b;
                    LoggerProxy.d(str, "onMarkerReached markerPosition = " + notificationMarkerPosition + " , PlaybackHeadPosition = " + playbackHeadPosition);
                }
            } catch (Exception e) {
                LoggerProxy.d(this.a.b, e.getMessage());
            }
        }
    }
}
