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
    public AudioRecorder f23292a;

    /* renamed from: b  reason: collision with root package name */
    public FileOutputStream f23293b;

    /* renamed from: c  reason: collision with root package name */
    public File f23294c = new File("/sdcard/cu.wav");

    /* renamed from: d  reason: collision with root package name */
    public b f23295d;

    /* renamed from: e  reason: collision with root package name */
    public int f23296e;

    public a(AudioRecorder audioRecorder) {
        this.f23292a = audioRecorder;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (observable != this.f23292a) {
            return;
        }
        if (obj instanceof AudioRecorder.State) {
            AudioRecorder.State state = (AudioRecorder.State) obj;
            if (AudioRecorder.State.OPEN == state) {
                this.f23296e = 0;
                try {
                    this.f23293b = new FileOutputStream(this.f23294c);
                    FileInputStream fileInputStream = new FileInputStream(this.f23294c);
                    b.a(fileInputStream).a();
                    fileInputStream.close();
                    b a2 = b.a(1, 16, 8000, 0);
                    this.f23295d = a2;
                    a2.a(this.f23293b);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (AudioRecorder.State.STOP == state) {
                try {
                    this.f23293b.close();
                    this.f23295d = b.a(1, 16, 8000, this.f23296e);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.f23294c, "rw");
                    this.f23295d.a(randomAccessFile);
                    this.f23295d.a();
                    randomAccessFile.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                this.f23293b = null;
            }
        } else if (!(obj instanceof Buffer) || this.f23293b == null) {
        } else {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            try {
                this.f23296e += byteBuffer.remaining();
                this.f23293b.write(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }
}
