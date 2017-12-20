package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes2.dex */
class e {
    private final MediaMuxer gRM;
    private volatile boolean gRO;
    private volatile boolean gRP;
    private int gRN = 2;
    private boolean mIsStarted = false;

    public e(String str) throws IOException {
        this.gRM = new MediaMuxer(str, 0);
    }

    public void bBS() {
        this.gRO = true;
    }

    public void bBT() {
        this.gRP = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        boolean z;
        if (!this.gRP || !this.gRO) {
            z = false;
        } else {
            if (this.gRN > 0 && this.gRP && this.gRO) {
                this.gRM.start();
                this.mIsStarted = true;
                notifyAll();
            }
            z = this.mIsStarted;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        if (this.gRN > 0) {
            try {
                this.gRM.stop();
                this.gRM.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mIsStarted = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int d(MediaFormat mediaFormat) {
        if (this.mIsStarted) {
            throw new IllegalStateException("muxer already started");
        }
        return this.gRM.addTrack(mediaFormat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.mIsStarted) {
            this.gRM.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
