package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes10.dex */
class e {
    private final MediaMuxer boG;
    private volatile boolean lDa;
    private volatile boolean lDb;
    private int lCZ = 2;
    private boolean mIsStarted = false;

    public e(String str) throws IOException {
        this.boG = new MediaMuxer(str, 0);
    }

    public void diO() {
        this.lDa = true;
    }

    public void diP() {
        this.lDb = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        boolean z;
        if (!this.lDb || !this.lDa) {
            z = false;
        } else {
            if (this.lCZ > 0 && this.lDb && this.lDa) {
                this.boG.start();
                this.mIsStarted = true;
                notifyAll();
            }
            z = this.mIsStarted;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        if (this.lCZ > 0) {
            try {
                this.boG.stop();
                this.boG.release();
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
        return this.boG.addTrack(mediaFormat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.mIsStarted) {
            this.boG.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
