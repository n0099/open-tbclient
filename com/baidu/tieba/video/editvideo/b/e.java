package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes23.dex */
class e {
    private final MediaMuxer cbA;
    private volatile boolean nDn;
    private volatile boolean nDo;
    private int nDm = 2;
    private boolean mIsStarted = false;

    public e(String str) throws IOException {
        this.cbA = new MediaMuxer(str, 0);
    }

    public void dUy() {
        this.nDn = true;
    }

    public void dUz() {
        this.nDo = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        boolean z;
        if (!this.nDo || !this.nDn) {
            z = false;
        } else {
            if (this.nDm > 0 && this.nDo && this.nDn) {
                this.cbA.start();
                this.mIsStarted = true;
                notifyAll();
            }
            z = this.mIsStarted;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        if (this.nDm > 0) {
            try {
                this.cbA.stop();
                this.cbA.release();
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
        return this.cbA.addTrack(mediaFormat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.mIsStarted) {
            this.cbA.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
