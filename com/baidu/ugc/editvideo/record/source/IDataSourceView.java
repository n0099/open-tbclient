package com.baidu.ugc.editvideo.record.source;

import android.app.Activity;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import com.baidu.ugc.editvideo.player.IPlayer;
/* loaded from: classes11.dex */
public interface IDataSourceView {
    public static final int AUDIO_RECORD_INVALID = 1;
    public static final int OPEN_CAMERA_FAIL = 0;

    /* loaded from: classes11.dex */
    public interface ICameraDataSourceView {
        public static final int CAMERA_FACING_BACK = 0;
        public static final int CAMERA_FACING_FRONT = 1;

        Activity getCurrentActivity();

        Camera.PreviewCallback getPreviewCallback();

        void notifyBuildDataSourceFail(int i2);

        void setPreviewSize(int i2, int i3);
    }

    /* loaded from: classes11.dex */
    public interface IMultiMediaDataSourceView extends GLSurfaceView.Renderer {
        void onDestroy();

        void onPause();
    }

    /* loaded from: classes11.dex */
    public interface IPlayerDataSourceView {
        void onCompletion(IPlayer iPlayer);

        void onError(IPlayer iPlayer, int i2, int i3, Exception exc);

        void onInfo(IPlayer iPlayer, int i2, int i3);

        void onPlayStateListener(IPlayer iPlayer, int i2);

        void onPrepared(IPlayer iPlayer);

        void onVideoSizeChanged(int i2, int i3);
    }
}
