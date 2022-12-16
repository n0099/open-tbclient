package com.baidu.ugc.editvideo.record.source;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import com.baidu.ugc.editvideo.player.VideoPlayData;
import com.baidu.ugc.editvideo.record.IMediaLifeCycle;
import com.baidu.ugc.editvideo.record.source.IDataSourceView;
import java.util.List;
/* loaded from: classes7.dex */
public interface IMediaDataSource extends IMediaLifeCycle {

    /* loaded from: classes7.dex */
    public interface IPlayerDataSource extends IMediaDataSource, IMediaLifeCycle {
        void addIPlayerDataSourceView(IDataSourceView.IPlayerDataSourceView iPlayerDataSourceView);

        long getCurrentPosition();

        long getDuration();

        String getVideoPath();

        List<VideoPlayData> getVideoPathList();

        boolean isEnd();

        boolean isInOriginalRange();

        boolean isInPlaybackState();

        boolean isPlaying();

        boolean isSameSpeed(float f);

        void pause();

        void release();

        void reset();

        void seekTo(long j);

        void seekToForce(long j);

        void setLooping(boolean z);

        void setSpeed(float f);

        void setVideoPath(String str);

        void setVideoPathList(List<VideoPlayData> list);

        void setVolume(float f, float f2);

        void start();

        void stop();
    }

    void onSurfaceHolderCreate(SurfaceHolder surfaceHolder);

    void onSurfaceTextureCreate(SurfaceTexture surfaceTexture);
}
