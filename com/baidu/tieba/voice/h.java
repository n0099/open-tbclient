package com.baidu.tieba.voice;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.baidu.adp.lib.voice.Amrnb;
import com.baidu.adp.lib.voice.BdSoundGate;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class h implements Runnable {
    private String b;
    private int c;
    private FileOutputStream d;
    private Amrnb e;
    private Handler f;
    private long g;
    private long h;
    private volatile int a = 0;
    private Handler i = new Handler();
    private Runnable j = new i(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Message obtainMessage = this.f.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.f.sendMessage(obtainMessage);
    }

    public h(Handler handler) {
        this.f = handler;
        try {
            this.e = Amrnb.getInstance();
            if (this.e == null || !Amrnb.bLoadLibrary) {
                this.e = null;
                if (this.f != null) {
                    this.f.sendMessage(this.f.obtainMessage(5));
                }
            }
        } catch (Exception e) {
            if (this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(5));
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRecord audioRecord;
        short[] sArr;
        int i;
        boolean z;
        Process.setThreadPriority(-19);
        if (this.e == null) {
            if (this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(5));
            }
        } else if (this.a == 4) {
            if (this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(8));
            }
            this.a = 0;
        } else {
            if (this.b != null && this.b.length() > 0) {
                try {
                    File a = com.baidu.adp.lib.util.b.a((String) null, this.b);
                    if (a != null) {
                        this.d = new FileOutputStream(a);
                    } else if (this.f != null) {
                        this.f.sendMessage(this.f.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b("Recorder", "run", "error = " + e.getMessage());
                    c();
                    if (this.f != null) {
                        this.f.sendMessage(this.f.obtainMessage(1));
                    }
                    this.a = 0;
                    return;
                }
            }
            if (this.a == 4) {
                if (this.f != null) {
                    this.f.sendMessage(this.f.obtainMessage(8));
                }
                c();
                this.a = 0;
                return;
            }
            try {
                AudioRecord b = k.a().b();
                if (b == null || b.getState() == 0) {
                    if (b != null) {
                        try {
                            b.release();
                        } catch (Exception e2) {
                        }
                    }
                    if (this.f != null) {
                        this.f.sendMessage(this.f.obtainMessage(6));
                    }
                    c();
                    this.a = 0;
                } else if (this.a == 4) {
                    try {
                        b.release();
                    } catch (Exception e3) {
                    }
                    if (this.f != null) {
                        this.f.sendMessage(this.f.obtainMessage(8));
                    }
                    c();
                    this.a = 0;
                } else {
                    b.startRecording();
                    if (this.a == 4) {
                        try {
                            b.stop();
                            b.release();
                        } catch (Exception e4) {
                        }
                        if (this.f != null) {
                            this.f.sendMessage(this.f.obtainMessage(8));
                        }
                        c();
                        this.a = 0;
                        return;
                    }
                    this.a = 3;
                    try {
                        if (this.d == null) {
                            try {
                                b.stop();
                                b.release();
                                audioRecord = null;
                            } catch (Exception e5) {
                                audioRecord = b;
                            }
                            try {
                                if (this.f != null) {
                                    this.f.sendMessage(this.f.obtainMessage(1));
                                }
                                this.a = 0;
                                return;
                            } catch (IOException e6) {
                                try {
                                    audioRecord.stop();
                                    audioRecord.release();
                                } catch (Exception e7) {
                                }
                                if (this.f != null) {
                                    this.f.sendMessage(this.f.obtainMessage(3));
                                }
                                this.a = 0;
                                return;
                            }
                        }
                        com.baidu.adp.lib.util.b.a(this.d);
                        this.e.encoderInit();
                        if (this.c > 0) {
                            BdSoundGate.a();
                            BdSoundGate.a(1600, this.c);
                        }
                        ArrayList arrayList = new ArrayList();
                        this.g = System.currentTimeMillis();
                        this.i.post(this.j);
                        int i2 = 0;
                        short[] sArr2 = null;
                        while (true) {
                            if (this.a != 3) {
                                sArr = sArr2;
                                i = i2;
                                z = false;
                                break;
                            }
                            if (sArr2 == null) {
                                sArr2 = new short[160];
                                i2 = 0;
                            }
                            int read = b.read(sArr2, i2, 160 - i2);
                            if (read > 0) {
                                int i3 = 0;
                                for (int i4 = 0; i4 < sArr2.length; i4++) {
                                    i3 += sArr2[i4] * sArr2[i4];
                                }
                                if (this.f != null) {
                                    Message obtainMessage = this.f.obtainMessage(4);
                                    int abs = Math.abs((((int) (i3 / read)) / 100000) >> 1);
                                    while (abs > 100) {
                                        abs = (int) (abs / 10.0d);
                                    }
                                    obtainMessage.arg1 = abs;
                                    this.f.sendMessage(obtainMessage);
                                }
                            }
                            i2 += read;
                            if (i2 == 160) {
                                long currentTimeMillis = System.currentTimeMillis();
                                if (this.c > 0) {
                                    int size = arrayList.size();
                                    if (size + 1 > 1 && (size + 1) % 10 == 0) {
                                        a(arrayList);
                                        arrayList.clear();
                                    }
                                    arrayList.add(sArr2);
                                } else {
                                    a(sArr2);
                                }
                                com.baidu.adp.lib.util.e.a(getClass(), "TestVoice_compress", new StringBuilder(String.valueOf(System.currentTimeMillis() - currentTimeMillis)).toString());
                                sArr2 = null;
                            }
                            if (System.currentTimeMillis() - this.g > com.baidu.adp.lib.voice.a.a) {
                                sArr = sArr2;
                                i = i2;
                                z = true;
                                break;
                            }
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (sArr != null) {
                            while (i < 160 && i < sArr.length) {
                                sArr[i] = 0;
                                i++;
                            }
                            a(sArr);
                        }
                        if (this.c > 0) {
                            BdSoundGate.a().c();
                        }
                        Log.d("test_record", "1:" + (System.currentTimeMillis() - currentTimeMillis2));
                        long currentTimeMillis3 = System.currentTimeMillis();
                        b.stop();
                        b.release();
                        com.baidu.adp.lib.util.e.a(getClass(), "test_record", "2:" + (System.currentTimeMillis() - currentTimeMillis3));
                        System.currentTimeMillis();
                        if (this.a == 5) {
                            com.baidu.adp.lib.util.e.d("----runnable cancel");
                            if (!c()) {
                                if (this.f != null) {
                                    this.f.sendMessage(this.f.obtainMessage(2));
                                }
                            } else {
                                try {
                                    com.baidu.adp.lib.util.b.c(this.b);
                                    if (this.f != null) {
                                        this.f.sendMessage(this.f.obtainMessage(100));
                                    }
                                } catch (Exception e8) {
                                    if (this.f != null) {
                                        this.f.sendMessage(this.f.obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID));
                                    }
                                    this.a = 0;
                                }
                            }
                            this.a = 0;
                            return;
                        }
                        this.a = 4;
                        this.h = System.currentTimeMillis() - this.g;
                        a((int) this.h);
                        if (this.i != null) {
                            this.i.removeCallbacks(this.j);
                        }
                        long currentTimeMillis4 = System.currentTimeMillis();
                        if (!c() && this.f != null) {
                            this.f.sendMessage(this.f.obtainMessage(2));
                        }
                        this.e.encoderDeinit();
                        this.a = 0;
                        if (this.f != null) {
                            if (z) {
                                this.f.sendMessage(this.f.obtainMessage(7));
                            } else {
                                Message obtainMessage2 = this.f.obtainMessage(0);
                                obtainMessage2.arg1 = (int) this.h;
                                this.f.sendMessage(obtainMessage2);
                            }
                        }
                        com.baidu.adp.lib.util.e.a(getClass(), "test_record", "5:" + (System.currentTimeMillis() - currentTimeMillis4));
                    } catch (IOException e9) {
                        audioRecord = b;
                    }
                }
            } catch (IllegalArgumentException e10) {
                if (this.f != null) {
                    this.f.sendMessage(this.f.obtainMessage(6));
                }
                c();
                this.a = 0;
            }
        }
    }

    private void a(List<short[]> list) {
        int b = BdSoundGate.a().b();
        short[] sArr = new short[b];
        short[] sArr2 = new short[b];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.a().a(sArr2, sArr);
                int i3 = 0;
                int i4 = 0;
                while (i3 < size) {
                    System.arraycopy(sArr, i4, list.get(i3), 0, 160);
                    a(list.get(i3));
                    i3++;
                    i4 += 160;
                }
                i = 0;
            }
        }
    }

    private void a(short[] sArr) {
        byte[] bArr = new byte[32];
        try {
            this.d.write(bArr, 0, this.e.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean c() {
        if (this.d != null) {
            try {
                this.d.close();
            } catch (IOException e) {
                com.baidu.adp.lib.util.e.b("Recorder", "closeFileStream", "error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public final boolean a(String str, int i) {
        if (this.e == null) {
            return false;
        }
        this.a = 0;
        this.b = str;
        this.c = i;
        return true;
    }

    public final void a() {
        this.a = 4;
        com.baidu.adp.lib.util.e.d("----stop:" + this.a);
        com.baidu.adp.lib.util.e.d("record runnable state after stop:----" + this.h);
    }

    public final void b() {
        this.a = 5;
        com.baidu.adp.lib.util.e.d("----cancel:");
    }
}
