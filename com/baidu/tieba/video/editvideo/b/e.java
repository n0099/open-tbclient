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
    private final MediaMuxer cil;
    private volatile boolean nHs;
    private volatile boolean nHt;
    private int nHr = 2;
    private boolean mIsStarted = false;

    public e(String str) throws IOException {
        this.cil = new MediaMuxer(str, 0);
    }

    public void dUp() {
        this.nHs = true;
    }

    public void dUq() {
        this.nHt = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        boolean z;
        if (!this.nHt || !this.nHs) {
            z = false;
        } else {
            if (this.nHr > 0 && this.nHt && this.nHs) {
                this.cil.start();
                this.mIsStarted = true;
                notifyAll();
            }
            z = this.mIsStarted;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        if (this.nHr > 0) {
            try {
                this.cil.stop();
                this.cil.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mIsStarted = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int f(MediaFormat mediaFormat) {
        if (this.mIsStarted) {
            throw new IllegalStateException("muxer already started");
        }
        return this.cil.addTrack(mediaFormat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.mIsStarted) {
            this.cil.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
