package com.baidu.wallet.base.audio;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes13.dex */
public class a implements Observer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecorder a;

    /* renamed from: b  reason: collision with root package name */
    public FileOutputStream f52488b;

    /* renamed from: c  reason: collision with root package name */
    public File f52489c;

    /* renamed from: d  reason: collision with root package name */
    public b f52490d;

    /* renamed from: e  reason: collision with root package name */
    public int f52491e;

    public a(AudioRecorder audioRecorder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {audioRecorder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = audioRecorder;
        this.f52489c = new File("/sdcard/cu.wav");
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, observable, obj) == null) && observable == this.a) {
            if (obj instanceof AudioRecorder.State) {
                AudioRecorder.State state = (AudioRecorder.State) obj;
                if (AudioRecorder.State.OPEN == state) {
                    this.f52491e = 0;
                    try {
                        this.f52488b = new FileOutputStream(this.f52489c);
                        FileInputStream fileInputStream = new FileInputStream(this.f52489c);
                        b.a(fileInputStream).a();
                        fileInputStream.close();
                        b a = b.a(1, 16, 8000, 0);
                        this.f52490d = a;
                        a.a(this.f52488b);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (AudioRecorder.State.STOP == state) {
                    try {
                        this.f52488b.close();
                        this.f52490d = b.a(1, 16, 8000, this.f52491e);
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f52489c, "rw");
                        this.f52490d.a(randomAccessFile);
                        this.f52490d.a();
                        randomAccessFile.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    this.f52488b = null;
                }
            } else if (!(obj instanceof Buffer) || this.f52488b == null) {
            } else {
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                try {
                    this.f52491e += byteBuffer.remaining();
                    this.f52488b.write(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }
}
