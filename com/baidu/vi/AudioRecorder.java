package com.baidu.vi;

import android.media.AudioRecord;
import android.os.Handler;
/* loaded from: classes15.dex */
public class AudioRecorder {
    private static Handler j = new com.baidu.vi.a();

    /* renamed from: a  reason: collision with root package name */
    private volatile AudioRecord f5908a;

    /* renamed from: b  reason: collision with root package name */
    private int f5909b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private volatile boolean h = false;
    private Object i = new Object();
    private Thread k = new b(this, AudioRecorder.class.getSimpleName() + "-Record");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        AudioRecorder f5910a;

        /* renamed from: b  reason: collision with root package name */
        byte[] f5911b;
        int c;

        public a(AudioRecorder audioRecorder, byte[] bArr, int i) {
            this.f5910a = audioRecorder;
            this.f5911b = bArr;
            this.c = i;
        }
    }

    public AudioRecorder(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.e = true;
        if (i3 == 8) {
            this.d = 3;
        } else {
            this.d = 2;
        }
        if (i4 == 2) {
            this.c = 3;
        } else {
            this.c = 2;
        }
        this.e = i7 == 1;
        this.f5909b = i2;
        this.g = i5;
        this.f = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.e) {
            j.sendMessage(j.obtainMessage(2, new a(this, null, 0)));
        } else if (this.h) {
            onReadError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i) {
        if (this.e) {
            j.sendMessage(j.obtainMessage(1, new a(this, bArr, i)));
        } else if (this.h) {
            onReadData(bArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void onReadData(byte[] bArr, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void onReadError();
}
