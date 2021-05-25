package com.baidu.wallet.base.audio;

import com.baidu.wallet.base.audio.AudioRecorder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes5.dex */
public class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public AudioRecorder f23107a;

    /* renamed from: b  reason: collision with root package name */
    public FileOutputStream f23108b;

    /* renamed from: c  reason: collision with root package name */
    public File f23109c = new File("/sdcard/cu.wav");

    /* renamed from: d  reason: collision with root package name */
    public b f23110d;

    /* renamed from: e  reason: collision with root package name */
    public int f23111e;

    public a(AudioRecorder audioRecorder) {
        this.f23107a = audioRecorder;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (observable != this.f23107a) {
            return;
        }
        if (obj instanceof AudioRecorder.State) {
            AudioRecorder.State state = (AudioRecorder.State) obj;
            if (AudioRecorder.State.OPEN == state) {
                this.f23111e = 0;
                try {
                    this.f23108b = new FileOutputStream(this.f23109c);
                    FileInputStream fileInputStream = new FileInputStream(this.f23109c);
                    b.a(fileInputStream).a();
                    fileInputStream.close();
                    b a2 = b.a(1, 16, 8000, 0);
                    this.f23110d = a2;
                    a2.a(this.f23108b);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (AudioRecorder.State.STOP == state) {
                try {
                    this.f23108b.close();
                    this.f23110d = b.a(1, 16, 8000, this.f23111e);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.f23109c, "rw");
                    this.f23110d.a(randomAccessFile);
                    this.f23110d.a();
                    randomAccessFile.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                this.f23108b = null;
            }
        } else if (!(obj instanceof Buffer) || this.f23108b == null) {
        } else {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            try {
                this.f23111e += byteBuffer.remaining();
                this.f23108b.write(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }
}
