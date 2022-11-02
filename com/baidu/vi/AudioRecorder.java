package com.baidu.vi;

import android.media.AudioRecord;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AudioRecorder {
    public static /* synthetic */ Interceptable $ic;
    public static Handler j;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile AudioRecord a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public volatile boolean h;
    public Object i;
    public Thread k;

    public native void onReadData(byte[] bArr, int i);

    public native void onReadError();

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AudioRecorder a;
        public byte[] b;
        public int c;
        public final /* synthetic */ AudioRecorder d;

        public a(AudioRecorder audioRecorder, AudioRecorder audioRecorder2, byte[] bArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioRecorder, audioRecorder2, bArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = audioRecorder;
            this.a = audioRecorder2;
            this.b = bArr;
            this.c = i;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1561346485, "Lcom/baidu/vi/AudioRecorder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1561346485, "Lcom/baidu/vi/AudioRecorder;");
                return;
            }
        }
        j = new com.baidu.vi.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.e) {
                a aVar = new a(this, this, null, 0);
                Handler handler = j;
                handler.sendMessage(handler.obtainMessage(2, aVar));
            } else if (this.h) {
                onReadError();
            }
        }
    }

    public AudioRecorder(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = true;
        this.h = false;
        this.i = new Object();
        this.k = new b(this, AudioRecorder.class.getSimpleName() + "-Record");
        if (i3 == 8) {
            this.d = 3;
        } else {
            this.d = 2;
        }
        if (i4 == 2) {
            this.c = 3;
        } else {
            this.c = 2;
        }
        this.e = i7 == 1;
        this.b = i2;
        this.g = i5;
        this.f = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, bArr, i) == null) {
            if (this.e) {
                a aVar = new a(this, this, bArr, i);
                Handler handler = j;
                handler.sendMessage(handler.obtainMessage(1, aVar));
            } else if (this.h) {
                onReadData(bArr, i);
            }
        }
    }
}
