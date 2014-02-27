package com.baidu.tieba.voice.service;

import android.media.AudioRecord;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public final class a implements h {
    public static int a = 8000;
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

    private boolean a(int i, int i2, int i3, int i4, String str) {
        this.e = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
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
                } catch (IOException e2) {
                    if (this.j.exists()) {
                        this.j.delete();
                    }
                    e2.printStackTrace();
                }
                this.g = this.j.getParent();
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException e4) {
            this.j = null;
            Log.e("create file error in audio record", e4.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tieba.voice.service.h
    public final boolean a(String str) {
        return a(d, a, b, c, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar) {
        if (aVar.h == null || aVar.j == null) {
            return;
        }
        try {
            aVar.f = true;
            byte[] bArr = new byte[aVar.e];
            aVar.h.startRecording();
            while (aVar.f) {
                aVar.h.read(bArr, 0, bArr.length);
                aVar.i.write(bArr);
                aVar.k += bArr.length;
            }
            aVar.i.seek(4L);
            aVar.i.writeInt(Integer.reverseBytes(aVar.k + 36));
            aVar.i.seek(40L);
            aVar.i.writeInt(Integer.reverseBytes(aVar.k));
            aVar.i.close();
            aVar.h.stop();
            aVar.h.release();
            aVar.f = false;
        } catch (Throwable th) {
            Log.e("AudioRecord", "Recording Failed");
            if (aVar.j.exists()) {
                aVar.j.delete();
            }
        }
    }

    @Override // com.baidu.tieba.voice.service.h
    public final boolean a() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tieba.voice.service.h
    public final void b() {
        this.f = false;
    }

    @Override // com.baidu.tieba.voice.service.h
    public final boolean c() {
        return this.f;
    }
}
