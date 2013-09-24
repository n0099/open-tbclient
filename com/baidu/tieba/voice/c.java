package com.baidu.tieba.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.voice.Amrnb;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f2030a = 0;
    private static Object g = new Object();
    private AudioTrack b;
    private String c;
    private Amrnb e;
    private Handler f;
    private int l;
    private short[] d = {12, 13, 15, 17, 19, 20, 26, 31, 5};
    private int h = 0;
    private int i = 0;
    private Handler j = new Handler();
    private Runnable k = new d(this);

    public int a() {
        return (int) (((this.b.getPlaybackHeadPosition() * 1.0f) / (this.b.getSampleRate() * 1.0f)) * 1000.0f);
    }

    public c(Handler handler, int i) {
        this.l = 0;
        this.l = i;
        this.f = handler;
        try {
            this.e = new Amrnb();
            if (this.e == null && this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(2));
            }
        }
    }

    public void a(int i) {
        this.l = i;
    }

    private void d() {
        this.b = new AudioTrack(r.i, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, (int) LVBuffer.LENGTH_ALLOC_PER_NEW), 1);
        f2030a = 1;
    }

    public void b() {
        int i;
        synchronized (g) {
            if (this.b != null) {
                try {
                    i = this.b.getPlaybackHeadPosition();
                    try {
                        this.b.stop();
                        this.b.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.l = 0;
                this.b = null;
            } else {
                i = 0;
            }
            if (this.j != null) {
                this.j.removeCallbacks(this.k);
            }
            if (this.f != null) {
                Message obtainMessage = this.f.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.f.sendMessage(obtainMessage);
            }
        }
        f2030a = 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        FileInputStream fileInputStream;
        Process.setThreadPriority(-19);
        if (this.e == null) {
            if (this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(2));
            }
        } else if (this.c == null) {
            if (this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(1));
            }
        } else {
            File file = new File(this.c);
            if (file == null || !file.exists()) {
                if (this.f != null) {
                    this.f.sendMessage(this.f.obtainMessage(1));
                    return;
                }
                return;
            }
            FileInputStream fileInputStream2 = null;
            d();
            if (this.b.getState() == 0) {
                if (this.f != null) {
                    this.f.sendMessage(this.f.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.l > 0) {
                this.b.reloadStaticData();
                this.b.setPlaybackHeadPosition(this.l);
            }
            this.b.play();
            f2030a = 2;
            this.j.post(this.k);
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
            }
            try {
                Boolean bool = true;
                byte[] bArr = new byte[32];
                this.e.decoderInit();
                short[] sArr = new short[160];
                while (f2030a == 2) {
                    if (bool.booleanValue()) {
                        if (fileInputStream.read(bArr, 0, 6) != 6 || bArr[0] != 35 || bArr[1] != 33 || bArr[2] != 65 || bArr[3] != 77 || bArr[4] != 82 || bArr[5] != 10) {
                            break;
                        }
                        bool = false;
                    }
                    if (fileInputStream.read(bArr, 0, 1) <= 0) {
                        break;
                    }
                    short s = this.d[(bArr[0] >> 3) & 15];
                    if (fileInputStream.read(bArr, 1, s) != s) {
                        break;
                    }
                    synchronized (g) {
                        if (this.b != null && this.b.getPlayState() == 3) {
                            this.e.decoderDecode(bArr, sArr);
                            this.b.write(sArr, 0, sArr.length);
                        }
                    }
                }
                fileInputStream.close();
                this.e.decoderDeinit();
                com.baidu.adp.lib.f.d.b("-----gf : decoderDeinit");
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                if (this.f != null) {
                    this.f.sendMessage(this.f.obtainMessage(5));
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e3) {
                        com.baidu.adp.lib.f.d.b("AudioPlayer", "play", "error = " + e3.getMessage());
                    }
                }
                f2030a = 3;
                b();
            }
            f2030a = 3;
            b();
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public void c() {
        f2030a = 3;
        b();
    }
}
