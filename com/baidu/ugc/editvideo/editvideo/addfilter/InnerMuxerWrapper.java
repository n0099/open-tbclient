package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.baidu.tieba.yua;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes8.dex */
public class InnerMuxerWrapper {
    public static final String TAG = "InnerMuxerWrapper";
    public static final boolean VERBOSE = false;
    public volatile boolean mAudioStart;
    public final MediaMuxer mMediaMuxer;
    public volatile boolean mVideoStart;
    public int mEncoderCount = 2;
    public volatile boolean mIsStarted = false;
    public boolean mMuxAudio = true;

    public InnerMuxerWrapper(String str) throws IOException {
        this.mMediaMuxer = new MediaMuxer(str, 0);
    }

    public synchronized int addTrack(MediaFormat mediaFormat) {
        if (!this.mIsStarted) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.mMediaMuxer.addTrack(mediaFormat);
    }

    public void setMuxAudio(boolean z) {
        this.mMuxAudio = z;
        if (!z) {
            this.mEncoderCount = 1;
        }
    }

    public static void log(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            yua.i(str2);
        }
    }

    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }

    public void setAudioStart() {
        this.mAudioStart = true;
    }

    public void setVideoStart() {
        this.mVideoStart = true;
    }

    public synchronized boolean start() {
        if ((this.mMuxAudio && !this.mAudioStart) || !this.mVideoStart) {
            return false;
        }
        if (this.mEncoderCount > 0 && ((!this.mMuxAudio || this.mAudioStart) && this.mVideoStart)) {
            this.mMediaMuxer.start();
            this.mIsStarted = true;
            notifyAll();
        }
        return this.mIsStarted;
    }

    public synchronized void stop() {
        if (this.mEncoderCount > 0) {
            try {
                this.mMediaMuxer.stop();
                this.mMediaMuxer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mIsStarted = false;
        }
    }

    public synchronized void writeSampleData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.mIsStarted) {
            this.mMediaMuxer.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
