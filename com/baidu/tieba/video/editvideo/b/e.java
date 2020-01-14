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
    private volatile boolean kvX;
    private volatile boolean kvY;
    private final MediaMuxer mMediaMuxer;
    private int kvW = 2;
    private boolean mIsStarted = false;

    public e(String str) throws IOException {
        this.mMediaMuxer = new MediaMuxer(str, 0);
    }

    public void cOx() {
        this.kvX = true;
    }

    public void cOy() {
        this.kvY = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        boolean z;
        if (!this.kvY || !this.kvX) {
            z = false;
        } else {
            if (this.kvW > 0 && this.kvY && this.kvX) {
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
        if (this.kvW > 0) {
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
