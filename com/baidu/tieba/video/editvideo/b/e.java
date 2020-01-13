package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes8.dex */
class e {
    private volatile boolean kvS;
    private volatile boolean kvT;
    private final MediaMuxer mMediaMuxer;
    private int kvR = 2;
    private boolean mIsStarted = false;

    public e(String str) throws IOException {
        this.mMediaMuxer = new MediaMuxer(str, 0);
    }

    public void cOv() {
        this.kvS = true;
    }

    public void cOw() {
        this.kvT = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        boolean z;
        if (!this.kvT || !this.kvS) {
            z = false;
        } else {
            if (this.kvR > 0 && this.kvT && this.kvS) {
                this.mMediaMuxer.start();
                this.mIsStarted = true;
                notifyAll();
            }
            z = this.mIsStarted;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        if (this.kvR > 0) {
            try {
                this.mMediaMuxer.stop();
                this.mMediaMuxer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mIsStarted = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int i(MediaFormat mediaFormat) {
        if (this.mIsStarted) {
            throw new IllegalStateException("muxer already started");
        }
        return this.mMediaMuxer.addTrack(mediaFormat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.mIsStarted) {
            this.mMediaMuxer.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
