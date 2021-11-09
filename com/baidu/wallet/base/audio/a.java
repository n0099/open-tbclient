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
/* loaded from: classes10.dex */
public class a implements Observer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecorder f57303a;

    /* renamed from: b  reason: collision with root package name */
    public FileOutputStream f57304b;

    /* renamed from: c  reason: collision with root package name */
    public File f57305c;

    /* renamed from: d  reason: collision with root package name */
    public b f57306d;

    /* renamed from: e  reason: collision with root package name */
    public int f57307e;

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
        this.f57303a = audioRecorder;
        this.f57305c = new File("/sdcard/cu.wav");
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, observable, obj) == null) && observable == this.f57303a) {
            if (obj instanceof AudioRecorder.State) {
                AudioRecorder.State state = (AudioRecorder.State) obj;
                if (AudioRecorder.State.OPEN == state) {
                    this.f57307e = 0;
                    try {
                        this.f57304b = new FileOutputStream(this.f57305c);
                        FileInputStream fileInputStream = new FileInputStream(this.f57305c);
                        b.a(fileInputStream).a();
                        fileInputStream.close();
                        b a2 = b.a(1, 16, 8000, 0);
                        this.f57306d = a2;
                        a2.a(this.f57304b);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (AudioRecorder.State.STOP == state) {
                    try {
                        this.f57304b.close();
                        this.f57306d = b.a(1, 16, 8000, this.f57307e);
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f57305c, "rw");
                        this.f57306d.a(randomAccessFile);
                        this.f57306d.a();
                        randomAccessFile.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    this.f57304b = null;
                }
            } else if (!(obj instanceof Buffer) || this.f57304b == null) {
            } else {
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                try {
                    this.f57307e += byteBuffer.remaining();
                    this.f57304b.write(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }
}
