package com.baidu.wallet.base.audio;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
import java.util.Observable;
/* loaded from: classes5.dex */
public class AudioRecorder extends Observable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f23924a;

    /* renamed from: b  reason: collision with root package name */
    public State f23925b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f23926c;

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
        public static final AudioRecorder f23927a = new AudioRecorder();
    }

    private void a(State state) {
        this.f23925b = state;
        setChanged();
        notifyObservers(state);
    }

    public static AudioRecorder getInstance() {
        return a.f23927a;
    }

    public void end() {
        if (State.RUNNING == this.f23925b) {
            this.f23925b = State.STOP;
        }
    }

    public State getState() {
        return this.f23925b;
    }

    public synchronized boolean init(int i2, int i3, int i4, int i5) {
        if (this.f23925b == null || State.DESTROY == this.f23925b) {
            try {
                AudioRecord audioRecord = new AudioRecord(1, i2, i3, i4, i5);
                this.f23924a = audioRecord;
                if (1 == audioRecord.getState()) {
                    this.f23926c = new byte[i5];
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
        AudioRecord audioRecord = this.f23924a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.startRecording();
        a(State.OPEN);
        ByteBuffer wrap = ByteBuffer.wrap(this.f23926c);
        this.f23925b = State.RUNNING;
        while (State.RUNNING == this.f23925b) {
            wrap.clear();
            AudioRecord audioRecord2 = this.f23924a;
            byte[] bArr = this.f23926c;
            int read = audioRecord2.read(bArr, 0, bArr.length);
            if (read <= 0) {
                break;
            }
            wrap.limit(read);
            setChanged();
            notifyObservers(wrap);
        }
        this.f23924a.stop();
        a(State.STOP);
        this.f23924a.release();
        this.f23924a = null;
        a(State.DESTROY);
        deleteObservers();
        this.f23926c = null;
    }

    public AudioRecorder() {
        this.f23924a = null;
        this.f23925b = null;
    }
}
