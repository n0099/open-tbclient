package com.baidu.wallet.base.audio;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
import java.util.Observable;
/* loaded from: classes5.dex */
public class AudioRecorder extends Observable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f23516a;

    /* renamed from: b  reason: collision with root package name */
    public State f23517b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f23518c;

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
        public static final AudioRecorder f23519a = new AudioRecorder();
    }

    private void a(State state) {
        this.f23517b = state;
        setChanged();
        notifyObservers(state);
    }

    public static AudioRecorder getInstance() {
        return a.f23519a;
    }

    public void end() {
        if (State.RUNNING == this.f23517b) {
            this.f23517b = State.STOP;
        }
    }

    public State getState() {
        return this.f23517b;
    }

    public synchronized boolean init(int i, int i2, int i3, int i4) {
        if (this.f23517b == null || State.DESTROY == this.f23517b) {
            try {
                AudioRecord audioRecord = new AudioRecord(1, i, i2, i3, i4);
                this.f23516a = audioRecord;
                if (1 == audioRecord.getState()) {
                    this.f23518c = new byte[i4];
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
        AudioRecord audioRecord = this.f23516a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.startRecording();
        a(State.OPEN);
        ByteBuffer wrap = ByteBuffer.wrap(this.f23518c);
        this.f23517b = State.RUNNING;
        while (State.RUNNING == this.f23517b) {
            wrap.clear();
            AudioRecord audioRecord2 = this.f23516a;
            byte[] bArr = this.f23518c;
            int read = audioRecord2.read(bArr, 0, bArr.length);
            if (read <= 0) {
                break;
            }
            wrap.limit(read);
            setChanged();
            notifyObservers(wrap);
        }
        this.f23516a.stop();
        a(State.STOP);
        this.f23516a.release();
        this.f23516a = null;
        a(State.DESTROY);
        deleteObservers();
        this.f23518c = null;
    }

    public AudioRecorder() {
        this.f23516a = null;
        this.f23517b = null;
    }
}
