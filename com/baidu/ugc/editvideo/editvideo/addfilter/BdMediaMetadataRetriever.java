package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tieba.bsb;
import com.baidu.tieba.ksb;
import com.baidu.tieba.qsb;
import com.baidu.tieba.wrb;
import com.baidu.ugc.editvideo.editvideo.addfilter.VideoKeyFrameModel;
import com.baidu.ugc.editvideo.magicmusic.VideoEffectData;
import java.io.Closeable;
import java.util.List;
/* loaded from: classes9.dex */
public class BdMediaMetadataRetriever extends MediaMetadataRetriever implements Closeable {
    public boolean isMirror;
    public int mAngle;
    public VideoKeyFrameModel mVideoKeyFrameModel;
    public String mPath = null;
    public boolean isUseMediacodec = ksb.a();

    /* loaded from: classes9.dex */
    public interface OnGetFrameAtExactTimeListener {
        void onFinish(Bitmap bitmap);
    }

    @NonNull
    private VideoKeyFrameModel getVideoKeyFrameModel() {
        VideoKeyFrameModel videoKeyFrameModel = new VideoKeyFrameModel();
        this.mVideoKeyFrameModel = videoKeyFrameModel;
        videoKeyFrameModel.setAngle(this.mAngle);
        this.mVideoKeyFrameModel.setMirror(this.isMirror);
        return this.mVideoKeyFrameModel;
    }

    private boolean isUseMediacodec() {
        return this.isUseMediacodec && !qsb.a(this.mPath);
    }

    @Override // android.media.MediaMetadataRetriever, java.lang.AutoCloseable, java.io.Closeable
    public void close() {
        release();
    }

    public void forceUseMediaCodec() {
        this.isUseMediacodec = true;
    }

    public Bitmap getFrameAtExactTime(long j, int i) {
        Bitmap frameAtTime;
        return (!isUseMediacodec() || Build.VERSION.SDK_INT < 21 || (frameAtTime = getVideoKeyFrameModel().getFrameAtTime(this.mPath, (long) ((int) j), true)) == null) ? super.getFrameAtTime(j, i) : frameAtTime;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r8 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getFrameAtExactTime(long j, int i, VideoEffectData videoEffectData, OnGetFrameAtExactTimeListener onGetFrameAtExactTimeListener) {
        Bitmap frameAtTime;
        if (isUseMediacodec() && Build.VERSION.SDK_INT >= 21) {
            VideoKeyFrameModel videoKeyFrameModel = getVideoKeyFrameModel();
            videoKeyFrameModel.setVideoEffectData(videoEffectData);
            frameAtTime = videoKeyFrameModel.getFrameAtTime(this.mPath, (int) j, true);
        }
        frameAtTime = super.getFrameAtTime(j, i);
        if (onGetFrameAtExactTimeListener != null) {
            onGetFrameAtExactTimeListener.onFinish(frameAtTime);
        }
    }

    @Override // android.media.MediaMetadataRetriever
    @Deprecated
    public Bitmap getFrameAtTime() {
        return getFrameAtTime(0L);
    }

    @Override // android.media.MediaMetadataRetriever
    @Deprecated
    public Bitmap getFrameAtTime(long j) {
        return getFrameAtTime(j, 2);
    }

    @Override // android.media.MediaMetadataRetriever
    @Deprecated
    public Bitmap getFrameAtTime(long j, int i) {
        return getFrameAtTime(j, i, 0, 0);
    }

    public Bitmap getFrameAtTime(long j, int i, int i2, int i3) {
        Bitmap frameAtTime;
        try {
            if (!isUseMediacodec() || Build.VERSION.SDK_INT < 21) {
                frameAtTime = super.getFrameAtTime(j, i);
                if (frameAtTime == null) {
                    return null;
                }
                if (i2 != 0 && i3 != 0) {
                    frameAtTime = ThumbnailUtils.extractThumbnail(frameAtTime, i2, i3, 2);
                }
            } else {
                frameAtTime = getVideoKeyFrameModel().getFrameAtTime(this.mPath, (int) j, false, i2, i3);
            }
            return frameAtTime;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getFrameAtTimeList(List<Long> list, int i, int i2, VideoKeyFrameModel.OnDecodeFrameAvailableListener onDecodeFrameAvailableListener) {
        if (bsb.e(list) || onDecodeFrameAvailableListener == null) {
            return;
        }
        if (isUseMediacodec()) {
            getVideoKeyFrameModel().getFrameAtTimeList(this.mPath, list, i, i2, onDecodeFrameAvailableListener);
        } else if (!TextUtils.isEmpty(this.mPath)) {
            for (Long l : list) {
                onDecodeFrameAvailableListener.onFrameAvailable(l.longValue(), getFrameAtTime(l.longValue(), 2, i, i2));
            }
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void release() {
        super.release();
        VideoKeyFrameModel videoKeyFrameModel = this.mVideoKeyFrameModel;
        if (videoKeyFrameModel != null) {
            videoKeyFrameModel.setOnDecodeFrameAvailableListener(null);
            this.mVideoKeyFrameModel.release();
            this.mVideoKeyFrameModel = null;
        }
    }

    public void setAngle(int i) {
        this.mAngle = i;
        VideoKeyFrameModel videoKeyFrameModel = this.mVideoKeyFrameModel;
        if (videoKeyFrameModel != null) {
            videoKeyFrameModel.setAngle(i);
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(String str) {
        try {
            super.setDataSource(str);
            if (Build.VERSION.SDK_INT >= 17) {
                this.mPath = str;
            }
        } catch (Exception e) {
            wrb.g(e);
        }
    }

    public void setMirror(boolean z) {
        this.isMirror = z;
        VideoKeyFrameModel videoKeyFrameModel = this.mVideoKeyFrameModel;
        if (videoKeyFrameModel != null) {
            videoKeyFrameModel.setMirror(z);
        }
    }
}
