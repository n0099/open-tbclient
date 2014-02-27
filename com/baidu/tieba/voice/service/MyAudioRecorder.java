package com.baidu.tieba.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.location.LocationClientOption;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements h {
    private static final int[] a = {44100, 22050, 11025, 8000};
    private static Object b = new Object();
    private static AudioRecord e = null;
    private static MediaRecorder f = null;
    private Thread c;
    private boolean d;
    private int g;
    private String h;
    private State i;
    private RandomAccessFile j;
    private short k;
    private int l;
    private short m;
    private int n;
    private int o;
    private int p;
    private int q;
    private byte[] r;
    private int s;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    public static MyAudioRecorder a(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (b) {
            e = null;
            f = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, a[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.i != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, a[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    private MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.g = 0;
        this.h = null;
        try {
            this.d = z;
            if (this.d) {
                this.m = (short) 16;
                this.k = (short) 1;
                this.o = 1;
                this.l = i2;
                this.p = 2;
                this.q = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / LocationClientOption.MIN_SCAN_SPAN;
                this.n = (((this.q * 2) * this.m) * this.k) / 8;
                if (this.n < AudioRecord.getMinBufferSize(i2, 2, 2)) {
                    this.n = AudioRecord.getMinBufferSize(i2, 2, 2);
                    this.q = this.n / (((this.m * 2) * this.k) / 8);
                    Log.w(MyAudioRecorder.class.getName(), "Increasing buffer size to " + Integer.toString(this.n));
                }
                AudioRecord audioRecord = new AudioRecord(1, i2, 2, 2, this.n);
                e = audioRecord;
                if (audioRecord.getRecordingState() == 3) {
                    e.stop();
                }
                if (e.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                MediaRecorder mediaRecorder = new MediaRecorder();
                f = mediaRecorder;
                mediaRecorder.setAudioSource(1);
                f.setOutputFormat(1);
                f.setAudioEncoder(1);
            }
            this.g = 0;
            this.h = null;
            this.i = State.INITIALIZING;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e2.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while initializing recording");
            }
            this.i = State.ERROR;
        }
    }

    private boolean b(String str) {
        try {
            if (this.i == State.INITIALIZING) {
                this.h = str;
                if (!this.d) {
                    f.setOutputFile(this.h);
                }
            }
            return true;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e2.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while setting output path");
            }
            this.i = State.ERROR;
            return false;
        }
    }

    private boolean d() {
        try {
            if (this.i == State.INITIALIZING) {
                if (this.d) {
                    if ((this.h != null) & (e.getState() == 1)) {
                        if (this.j != null) {
                            this.j.close();
                            this.j = null;
                        }
                        this.j = new RandomAccessFile(this.h, "rw");
                        this.j.setLength(0L);
                        this.j.writeBytes("RIFF");
                        this.j.writeInt(0);
                        this.j.writeBytes("WAVE");
                        this.j.writeBytes("fmt ");
                        this.j.writeInt(Integer.reverseBytes(16));
                        this.j.writeShort(Short.reverseBytes((short) 1));
                        this.j.writeShort(Short.reverseBytes(this.k));
                        this.j.writeInt(Integer.reverseBytes(this.l));
                        this.j.writeInt(Integer.reverseBytes(((this.l * this.m) * this.k) / 8));
                        this.j.writeShort(Short.reverseBytes((short) ((this.k * this.m) / 8)));
                        this.j.writeShort(Short.reverseBytes(this.m));
                        this.j.writeBytes("data");
                        this.j.writeInt(0);
                        this.r = new byte[((this.q * this.m) / 8) * this.k];
                        this.i = State.READY;
                    } else {
                        Log.e(MyAudioRecorder.class.getName(), "prepare() method called on uninitialized recorder");
                        this.i = State.ERROR;
                        return false;
                    }
                } else {
                    f.prepare();
                    this.i = State.READY;
                }
                return true;
            }
            Log.e(MyAudioRecorder.class.getName(), "prepare() method called on illegal state");
            e();
            this.i = State.ERROR;
            return false;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e2.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured in prepare()");
            }
            this.i = State.ERROR;
            return false;
        }
    }

    private void e() {
        if (this.i == State.RECORDING) {
            f();
        } else {
            if ((this.i == State.READY) & this.d) {
                try {
                    this.j.close();
                } catch (IOException e2) {
                    Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                }
                new File(this.h).delete();
            }
        }
        if (this.d) {
            if (e != null) {
                e.release();
            }
        } else if (f != null) {
            f.release();
        }
    }

    private void f() {
        Log.e(MyAudioRecorder.class.getName(), "audioRecorder.stop()");
        e.stop();
        try {
            this.j.seek(4L);
            this.j.writeInt(Integer.reverseBytes(this.s + 36));
            this.j.seek(40L);
            this.j.writeInt(Integer.reverseBytes(this.s));
            this.j.close();
            Log.e(MyAudioRecorder.class.getName(), "randomAccessWriter.close()");
        } catch (IOException e2) {
            Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
            this.i = State.ERROR;
        }
        this.i = State.STOPPED;
    }

    @Override // com.baidu.tieba.voice.service.h
    public final boolean a(String str) {
        if (b(str)) {
            return d();
        }
        return false;
    }

    @Override // com.baidu.tieba.voice.service.h
    public final boolean a() {
        synchronized (b) {
            if (this.c == null || !this.c.isAlive()) {
                this.c = new Thread(new f(this));
                this.c.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.voice.service.h
    public final void b() {
        this.i = State.STOPPED;
    }

    @Override // com.baidu.tieba.voice.service.h
    public final boolean c() {
        return this.i == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(MyAudioRecorder myAudioRecorder) {
        if (e != null) {
            try {
                if (myAudioRecorder.i == State.READY) {
                    if (myAudioRecorder.d) {
                        myAudioRecorder.s = 0;
                        e.startRecording();
                        e.read(myAudioRecorder.r, 0, myAudioRecorder.r.length);
                    } else {
                        f.start();
                    }
                    myAudioRecorder.i = State.RECORDING;
                } else {
                    Log.e(MyAudioRecorder.class.getName(), "start() called on illegal state");
                    myAudioRecorder.i = State.ERROR;
                }
                while (myAudioRecorder.c()) {
                    e.read(myAudioRecorder.r, 0, myAudioRecorder.r.length);
                    try {
                        System.out.println(myAudioRecorder.r);
                        myAudioRecorder.j.write(myAudioRecorder.r);
                        myAudioRecorder.s += myAudioRecorder.r.length;
                        if (myAudioRecorder.m == 16) {
                            for (int i = 0; i < myAudioRecorder.r.length / 2; i++) {
                                short s = (short) (myAudioRecorder.r[i * 2] | (myAudioRecorder.r[(i * 2) + 1] << 8));
                                if (s > myAudioRecorder.g) {
                                    myAudioRecorder.g = s;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < myAudioRecorder.r.length; i2++) {
                                if (myAudioRecorder.r[i2] > myAudioRecorder.g) {
                                    myAudioRecorder.g = myAudioRecorder.r[i2];
                                }
                            }
                        }
                    } catch (IOException e2) {
                    }
                }
                myAudioRecorder.f();
                myAudioRecorder.e();
            } catch (Throwable th) {
                Log.e("AudioRecord", "Recording Failed");
            }
        }
    }
}
