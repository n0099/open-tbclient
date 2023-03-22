package com.baidu.tieba;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.voice.Amrnb;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes6.dex */
public class ti implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static Object l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;
    public AudioTrack b;
    public String c;
    public final short[] d;
    public Amrnb e;
    public final Handler f;
    public int g;
    public final Handler h;
    public final Runnable i;
    public int j;
    public final Runnable k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti a;

        public a(ti tiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b == null) {
                return;
            }
            try {
                if (this.a.b.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException unused) {
            }
            int g = this.a.g() + 0;
            if (g != this.a.g) {
                this.a.g = g;
                Message obtainMessage = this.a.f.obtainMessage(6);
                obtainMessage.arg1 = this.a.g;
                this.a.f.sendMessage(obtainMessage);
            }
            this.a.h.postDelayed(this.a.i, 100L);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti a;

        public b(ti tiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317912, "Lcom/baidu/tieba/ti;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317912, "Lcom/baidu/tieba/ti;");
                return;
            }
        }
        l = new Object();
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = 3;
            i();
        }
    }

    public ti(Handler handler, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.d = new short[]{12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
        this.g = 0;
        this.h = new Handler();
        this.i = new a(this);
        this.j = 0;
        this.k = new b(this);
        this.j = i;
        this.f = handler;
        try {
            Amrnb amrnb = new Amrnb();
            this.e = amrnb;
            if (amrnb == null && this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(2));
            }
        } catch (Exception unused) {
            Handler handler2 = this.f;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(2));
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.j = i;
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AudioTrack audioTrack = this.b;
            if (audioTrack == null) {
                return 0;
            }
            try {
                int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                if (this.b == null) {
                    return 0;
                }
                int sampleRate = this.b.getSampleRate();
                if (sampleRate == 0) {
                    return 0;
                }
                return (int) (((playbackHeadPosition * 1.0f) / (sampleRate * 1.0f)) * 1000.0f);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                this.b = new AudioTrack(zi.b, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
            } catch (IllegalArgumentException e) {
                this.b = null;
                BdLog.e(e.getMessage());
            }
            this.a = 1;
        }
    }

    public void i() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacks(this.k);
            }
            synchronized (l) {
                if (this.b != null) {
                    try {
                        i = this.b.getPlaybackHeadPosition();
                        try {
                            this.b.stop();
                            this.b.release();
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        i = 0;
                    }
                    this.j = 0;
                    this.b = null;
                } else {
                    i = 0;
                }
                if (this.h != null) {
                    this.h.removeCallbacks(this.i);
                }
                if (this.f != null) {
                    Message obtainMessage = this.f.obtainMessage(0);
                    obtainMessage.arg1 = i;
                    this.f.sendMessage(obtainMessage);
                }
            }
            this.a = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x012f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        FileInputStream fileInputStream;
        Boolean bool;
        byte[] bArr;
        long decoderInit;
        short[] sArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Process.setThreadPriority(-19);
            if (this.e == null) {
                Handler handler = this.f;
                if (handler != null) {
                    handler.sendMessage(handler.obtainMessage(2));
                    return;
                }
                return;
            }
            boolean z = true;
            if (this.c == null) {
                Handler handler2 = this.f;
                if (handler2 != null) {
                    handler2.sendMessage(handler2.obtainMessage(1));
                    return;
                }
                return;
            }
            File file = new File(this.c);
            if (!file.exists()) {
                Handler handler3 = this.f;
                if (handler3 != null) {
                    handler3.sendMessage(handler3.obtainMessage(1));
                    return;
                }
                return;
            }
            FileInputStream fileInputStream2 = null;
            h();
            AudioTrack audioTrack = this.b;
            if (audioTrack != null && audioTrack.getState() != 0) {
                if (this.j > 0) {
                    this.b.reloadStaticData();
                    this.b.setPlaybackHeadPosition(this.j);
                }
                boolean z2 = false;
                try {
                    this.b.play();
                    this.a = 2;
                    this.h.post(this.i);
                    fileInputStream = new FileInputStream(file);
                    try {
                        bool = Boolean.TRUE;
                        bArr = new byte[32];
                        decoderInit = this.e.decoderInit();
                        sArr = new short[160];
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                }
                try {
                    while (this.a == 2) {
                        if (bool.booleanValue()) {
                            if (fileInputStream.read(bArr, 0, 6) != 6 || bArr[0] != 35 || bArr[1] != 33 || bArr[2] != 65 || bArr[3] != 77 || bArr[4] != 82 || bArr[5] != 10) {
                                break;
                            }
                            bool = Boolean.FALSE;
                        }
                        if (fileInputStream.read(bArr, 0, 1) > 0) {
                            short s = this.d[(bArr[0] >> 3) & 15];
                            if (fileInputStream.read(bArr, 1, s) == s) {
                                synchronized (l) {
                                    if (this.b != null && this.b.getPlayState() == 3) {
                                        this.e.decoderDecode(decoderInit, bArr, sArr);
                                        this.b.write(sArr, 0, 160);
                                    }
                                }
                            }
                        }
                    }
                    fileInputStream.close();
                    this.e.decoderDeinit(decoderInit);
                } catch (Exception unused3) {
                    z2 = z;
                    fileInputStream2 = fileInputStream;
                    Handler handler4 = this.f;
                    if (handler4 != null) {
                        handler4.sendMessage(handler4.obtainMessage(5));
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    z = z2;
                    this.a = 3;
                    if (!z) {
                    }
                }
                z = false;
                this.a = 3;
                if (!z) {
                    Handler handler5 = this.f;
                    if (handler5 != null) {
                        handler5.postDelayed(this.k, 500L);
                        return;
                    }
                    return;
                }
                i();
                return;
            }
            Handler handler6 = this.f;
            if (handler6 != null) {
                handler6.sendMessage(handler6.obtainMessage(3));
            }
        }
    }
}
