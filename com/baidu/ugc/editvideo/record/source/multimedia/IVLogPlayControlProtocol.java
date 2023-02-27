package com.baidu.ugc.editvideo.record.source.multimedia;

import com.baidu.ugc.editvideo.data.MultiMediaData;
/* loaded from: classes7.dex */
public interface IVLogPlayControlProtocol {

    /* loaded from: classes7.dex */
    public interface OnPlayStateListener {
        void onPause();

        void onSeek(long j);

        void onSetIsLoop(boolean z);

        void onSpeedChanged(float f, MultiMediaData multiMediaData);

        void onStart();
    }

    /* loaded from: classes7.dex */
    public static abstract class OnPlayStateListenerAdapter implements OnPlayStateListener {
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onPause() {
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSeek(long j) {
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSetIsLoop(boolean z) {
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSpeedChanged(float f, MultiMediaData multiMediaData) {
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onStart() {
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

    void setVolume(float f);

    void setVolume(int i, float f);

    void start();
}
