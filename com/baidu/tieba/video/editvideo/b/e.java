package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes22.dex */
class e {
    private final MediaMuxer bDo;
    private volatile boolean mFS;
    private volatile boolean mFT;
    private int mFR = 2;
    private boolean mIsStarted = false;

    public e(String str) throws IOException {
        this.bDo = new MediaMuxer(str, 0);
    }

    public void dFK() {
        this.mFS = true;
    }

    public void dFL() {
        this.mFT = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        boolean z;
        if (!this.mFT || !this.mFS) {
            z = false;
        } else {
            if (this.mFR > 0 && this.mFT && this.mFS) {
                this.bDo.start();
                this.mIsStarted = true;
                notifyAll();
            }
            z = this.mIsStarted;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        if (this.mFR > 0) {
            try {
                this.bDo.stop();
                this.bDo.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mIsStarted = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int c(MediaFormat mediaFormat) {
        if (this.mIsStarted) {
            throw new IllegalStateException("muxer already started");
        }
        return this.bDo.addTrack(mediaFormat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.mIsStarted) {
            this.bDo.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
