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
    public AudioRecorder f23210a;

    /* renamed from: b  reason: collision with root package name */
    public FileOutputStream f23211b;

    /* renamed from: c  reason: collision with root package name */
    public File f23212c = new File("/sdcard/cu.wav");

    /* renamed from: d  reason: collision with root package name */
    public b f23213d;

    /* renamed from: e  reason: collision with root package name */
    public int f23214e;

    public a(AudioRecorder audioRecorder) {
        this.f23210a = audioRecorder;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (observable != this.f23210a) {
            return;
        }
        if (obj instanceof AudioRecorder.State) {
            AudioRecorder.State state = (AudioRecorder.State) obj;
            if (AudioRecorder.State.OPEN == state) {
                this.f23214e = 0;
                try {
                    this.f23211b = new FileOutputStream(this.f23212c);
                    FileInputStream fileInputStream = new FileInputStream(this.f23212c);
                    b.a(fileInputStream).a();
                    fileInputStream.close();
                    b a2 = b.a(1, 16, 8000, 0);
                    this.f23213d = a2;
                    a2.a(this.f23211b);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (AudioRecorder.State.STOP == state) {
                try {
                    this.f23211b.close();
                    this.f23213d = b.a(1, 16, 8000, this.f23214e);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.f23212c, "rw");
                    this.f23213d.a(randomAccessFile);
                    this.f23213d.a();
                    randomAccessFile.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                this.f23211b = null;
            }
        } else if (!(obj instanceof Buffer) || this.f23211b == null) {
        } else {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            try {
                this.f23214e += byteBuffer.remaining();
                this.f23211b.write(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }
}
