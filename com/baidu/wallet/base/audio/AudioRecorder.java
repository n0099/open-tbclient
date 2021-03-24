package com.baidu.wallet.base.audio;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
import java.util.Observable;
/* loaded from: classes5.dex */
public class AudioRecorder extends Observable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f23515a;

    /* renamed from: b  reason: collision with root package name */
    public State f23516b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f23517c;

    /* loaded from: classes5.dex */
    public enum State {
        INIT,
        OPEN,
        RUNNING,
        STOP,
        DESTROY
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final AudioRecorder f23518a = new AudioRecorder();
    }

    private void a(State state) {
        this.f23516b = state;
        setChanged();
        notifyObservers(state);
    }

    public static AudioRecorder getInstance() {
        return a.f23518a;
    }

    public void end() {
        if (State.RUNNING == this.f23516b) {
            this.f23516b = State.STOP;
        }
    }

    public State getState() {
        return this.f23516b;
    }

    public synchronized boolean init(int i, int i2, int i3, int i4) {
        if (this.f23516b == null || State.DESTROY == this.f23516b) {
            try {
                AudioRecord audioRecord = new AudioRecord(1, i, i2, i3, i4);
                this.f23515a = audioRecord;
                if (1 == audioRecord.getState()) {
                    this.f23517c = new byte[i4];
                    a(State.INIT);
                    return true;
                }
                throw new IllegalArgumentException("guaranteed format is (8000, mono, 16bit)");
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioRecord audioRecord = this.f23515a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.startRecording();
        a(State.OPEN);
        ByteBuffer wrap = ByteBuffer.wrap(this.f23517c);
        this.f23516b = State.RUNNING;
        while (State.RUNNING == this.f23516b) {
            wrap.clear();
            AudioRecord audioRecord2 = this.f23515a;
            byte[] bArr = this.f23517c;
            int read = audioRecord2.read(bArr, 0, bArr.length);
            if (read <= 0) {
                break;
            }
            wrap.limit(read);
            setChanged();
            notifyObservers(wrap);
        }
        this.f23515a.stop();
        a(State.STOP);
        this.f23515a.release();
        this.f23515a = null;
        a(State.DESTROY);
        deleteObservers();
        this.f23517c = null;
    }

    public AudioRecorder() {
        this.f23515a = null;
        this.f23516b = null;
    }
}
