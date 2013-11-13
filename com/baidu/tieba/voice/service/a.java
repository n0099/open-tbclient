package com.baidu.tieba.voice.service;

import android.media.AudioRecord;
import android.util.Log;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public static int f2638a = 8000;
    public static int b = 2;
    public static int c = 2;
    public static int d = 1;
    private String g;
    private RandomAccessFile i;
    private int k;
    private int l;
    private int m;
    private int n;
    private short o;
    private short p;
    private int e = 0;
    private boolean f = false;
    private AudioRecord h = null;
    private File j = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.e = AudioRecord.getMinBufferSize(i2, i3, i4) + LVBuffer.MAX_STRING_LENGTH;
        this.l = i2;
        this.m = i3;
        this.n = i4;
        if (this.h != null) {
            this.h.release();
        }
        this.h = new AudioRecord(i, this.l, this.m, this.n, this.e);
        this.o = (short) (this.m == 12 ? 2 : 1);
        this.p = (short) (this.n == 2 ? 16 : 8);
        this.j = new File(str);
        if (this.j.exists()) {
            this.j.delete();
        }
        try {
            this.j.createNewFile();
            if (this.i != null) {
                try {
                    this.i.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.i = new RandomAccessFile(this.j, "rw");
                e();
                b(this.j.getParent());
                return true;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            this.j = null;
            Log.e("create file error in audio record", e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tieba.voice.service.h
    public boolean a(String str) {
        return a(d, f2638a, b, c, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.h != null && this.j != null) {
            try {
                this.f = true;
                byte[] bArr = new byte[this.e];
                this.h.startRecording();
                while (this.f) {
                    this.h.read(bArr, 0, bArr.length);
                    this.i.write(bArr);
                    this.k += bArr.length;
                }
                this.i.seek(4L);
                this.i.writeInt(Integer.reverseBytes(this.k + 36));
                this.i.seek(40L);
                this.i.writeInt(Integer.reverseBytes(this.k));
                this.i.close();
                this.h.stop();
                this.h.release();
                this.f = false;
            } catch (Throwable th) {
                Log.e("AudioRecord", "Recording Failed");
                if (this.j.exists()) {
                    this.j.delete();
                }
            }
        }
    }

    @Override // com.baidu.tieba.voice.service.h
    public boolean a() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tieba.voice.service.h
    public void b() {
        this.f = false;
    }

    @Override // com.baidu.tieba.voice.service.h
    public boolean c() {
        return this.f;
    }

    private void e() {
        try {
            this.i.setLength(0L);
            this.i.writeBytes("RIFF");
            this.i.writeInt(0);
            this.i.writeBytes("WAVE");
            this.i.writeBytes("fmt ");
            this.i.writeInt(Integer.reverseBytes(16));
            this.i.writeShort(Short.reverseBytes((short) 1));
            this.i.writeShort(Short.reverseBytes(this.o));
            this.i.writeInt(Integer.reverseBytes(this.l));
            this.i.writeInt(Integer.reverseBytes(((this.l * this.o) * this.p) / 8));
            this.i.writeShort(Short.reverseBytes((short) ((this.o * this.p) / 8)));
            this.i.writeShort(Short.reverseBytes(this.p));
            this.i.writeBytes("data");
            this.i.writeInt(0);
        } catch (IOException e) {
            if (this.j.exists()) {
                this.j.delete();
            }
            e.printStackTrace();
        }
    }

    public void b(String str) {
        this.g = str;
    }
}
