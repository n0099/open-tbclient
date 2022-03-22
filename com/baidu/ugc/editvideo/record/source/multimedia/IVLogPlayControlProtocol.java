package com.baidu.ugc.editvideo.record.source.multimedia;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
/* loaded from: classes6.dex */
public interface IVLogPlayControlProtocol {

    /* loaded from: classes6.dex */
    public interface OnPlayStateListener {
        void onPause();

        void onSeek(long j);

        void onSetIsLoop(boolean z);

        void onSpeedChanged(float f2, MultiMediaData multiMediaData);

        void onStart();
    }

    /* loaded from: classes6.dex */
    public static abstract class OnPlayStateListenerAdapter implements OnPlayStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OnPlayStateListenerAdapter() {
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

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSeek(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSetIsLoop(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSpeedChanged(float f2, MultiMediaData multiMediaData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), multiMediaData}) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    long getCurrentPlayTime();

    long getDuration();

    float getVolume(int i);

    boolean isMute();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void repeatIndex(int i);

    void reset();

    void seek(long j);

    void seek(long j, int i);

    void setLooping(boolean z);

    void setMute(boolean z);

    void setOnPlayStateListener(OnPlayStateListener onPlayStateListener);

    void setPreparedListener(IMultiMediaPreparedListener iMultiMediaPreparedListener);

    void setVolume(float f2);

    void setVolume(int i, float f2);

    void start();
}
