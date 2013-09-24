package com.baidu.tieba.voice.service;

import android.media.AudioRecord;
import android.os.AsyncTask;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyRecorder extends AsyncTask<Void, Integer, Void> implements h {

    /* renamed from: a  reason: collision with root package name */
    private File f2045a;
    private final int b;
    private final int c;
    private final int d;
    private final short e;
    private final short f;
    private boolean g;
    private int h;
    private DataOutputStream i;
    private RandomAccessFile j;
    private AudioRecord k;

    public MyRecorder() {
        this(11025, 16, 2);
    }

    public MyRecorder(int i, int i2, int i3) {
        this.g = false;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = (short) (this.c == 12 ? 2 : 1);
        this.f = (short) (this.d == 2 ? 16 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        this.g = true;
        try {
            this.j = new RandomAccessFile(this.f2045a, "rw");
            f();
            int minBufferSize = AudioRecord.getMinBufferSize(this.b, this.c, this.d);
            AudioRecord audioRecord = new AudioRecord(1, this.b, this.c, this.d, minBufferSize);
            short[] sArr = new short[minBufferSize];
            audioRecord.startRecording();
            int i = 0;
            while (this.g) {
                int read = audioRecord.read(sArr, 0, minBufferSize);
                for (int i2 = 0; i2 < read; i2++) {
                    this.j.writeShort(Short.reverseBytes(sArr[i2]));
                }
                this.h += read * 2;
                publishProgress(new Integer(i));
                i++;
            }
            this.j.writeBoolean(this.h % 2 != 0);
            this.j.seek(4L);
            this.j.writeInt(Integer.reverseBytes(this.h + 36));
            this.j.seek(40L);
            this.j.writeInt(Integer.reverseBytes(this.h));
            audioRecord.stop();
            this.j.close();
            this.g = false;
            return null;
        } catch (Throwable th) {
            this.g = false;
            return null;
        }
    }

    private void f() {
        this.j.setLength(0L);
        this.j.writeBytes("RIFF");
        this.j.writeInt(0);
        this.j.writeBytes("WAVE");
        this.j.writeBytes("fmt ");
        this.j.writeInt(Integer.reverseBytes(16));
        this.j.writeShort(Short.reverseBytes((short) 1));
        this.j.writeShort(Short.reverseBytes(this.e));
        this.j.writeInt(Integer.reverseBytes(this.b));
        this.j.writeInt(Integer.reverseBytes(((this.b * this.e) * this.f) / 8));
        this.j.writeShort(Short.reverseBytes((short) ((this.e * this.f) / 8)));
        this.j.writeShort(Short.reverseBytes(this.f));
        this.j.writeBytes("data");
        this.j.writeInt(0);
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        this.g = false;
        this.k.stop();
        try {
            this.i.close();
        } catch (IOException e) {
        }
    }

    public void d() {
        this.h = 0;
        execute(new Void[0]);
    }

    public void e() {
        this.g = false;
    }

    @Override // com.baidu.tieba.voice.service.h
    public boolean a(String str) {
        this.f2045a = new File(str);
        if (this.f2045a.exists()) {
            return true;
        }
        try {
            this.f2045a.createNewFile();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.tieba.voice.service.h
    public boolean a() {
        d();
        return true;
    }

    @Override // com.baidu.tieba.voice.service.h
    public void b() {
        e();
    }

    @Override // com.baidu.tieba.voice.service.h
    public boolean c() {
        return this.g;
    }
}
