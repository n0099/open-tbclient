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
        STOPPED
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
                    if (!(myAudioRecorder.d() != State.INITIALIZING) || !(i2 >= 0)) {
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

    public State d() {
        return this.i;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.g = 0;
        this.h = null;
        try {
            this.d = z;
            if (this.d) {
                if (i4 == 2) {
                    this.m = (short) 16;
                } else {
                    this.m = (short) 8;
                }
                if (i3 == 2) {
                    this.k = (short) 1;
                } else {
                    this.k = (short) 2;
                }
                this.o = i;
                this.l = i2;
                this.p = i4;
                this.q = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / LocationClientOption.MIN_SCAN_SPAN;
                this.n = (((this.q * 2) * this.m) * this.k) / 8;
                if (this.n < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.n = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.q = this.n / (((this.m * 2) * this.k) / 8);
                    Log.w(MyAudioRecorder.class.getName(), "Increasing buffer size to " + Integer.toString(this.n));
                }
                e = new AudioRecord(i, i2, i3, i4, this.n);
                if (e.getRecordingState() == 3) {
                    e.stop();
                }
                if (e.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                f = new MediaRecorder();
                f.setAudioSource(1);
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

    public boolean b(String str) {
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

    public boolean e() {
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
            f();
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

    public void f() {
        if (this.i == State.RECORDING) {
            h();
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

    public void g() {
        if (this.i == State.READY) {
            if (this.d) {
                this.s = 0;
                e.startRecording();
                e.read(this.r, 0, this.r.length);
            } else {
                f.start();
            }
            this.i = State.RECORDING;
            return;
        }
        Log.e(MyAudioRecorder.class.getName(), "start() called on illegal state");
        this.i = State.ERROR;
    }

    public void h() {
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

    private short a(byte b2, byte b3) {
        return (short) ((b3 << 8) | b2);
    }

    @Override // com.baidu.tieba.voice.service.h
    public boolean a(String str) {
        if (b(str)) {
            return e();
        }
        return false;
    }

    @Override // com.baidu.tieba.voice.service.h
    public boolean a() {
        synchronized (b) {
            if (this.c == null || !this.c.isAlive()) {
                this.c = new Thread(new f(this));
                this.c.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.voice.service.h
    public void b() {
        this.i = State.STOPPED;
    }

    @Override // com.baidu.tieba.voice.service.h
    public boolean c() {
        return this.i == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (e != null) {
            try {
                g();
                while (c()) {
                    e.read(this.r, 0, this.r.length);
                    try {
                        System.out.println(this.r);
                        this.j.write(this.r);
                        this.s += this.r.length;
                        if (this.m == 16) {
                            for (int i = 0; i < this.r.length / 2; i++) {
                                short a2 = a(this.r[i * 2], this.r[(i * 2) + 1]);
                                if (a2 > this.g) {
                                    this.g = a2;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.r.length; i2++) {
                                if (this.r[i2] > this.g) {
                                    this.g = this.r[i2];
                                }
                            }
                        }
                    } catch (IOException e2) {
                    }
                }
                h();
                f();
            } catch (Throwable th) {
                Log.e("AudioRecord", "Recording Failed");
            }
        }
    }
}
