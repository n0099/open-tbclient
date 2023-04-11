package com.baidu.tieba;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.voice.Amrnb;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.audiorecorder.lib.voice.BdSoundGate;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class jo implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static int k;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;
    public String b;
    public int c;
    public FileOutputStream d;
    public Amrnb e;
    public final Handler f;
    public long g;
    public long h;
    public final Handler i;
    public final Runnable j;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo a;

        public a(jo joVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {joVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = joVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g((int) (System.currentTimeMillis() - this.a.g));
                this.a.i.postDelayed(this.a.j, 200L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448308488, "Lcom/baidu/tieba/jo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448308488, "Lcom/baidu/tieba/jo;");
                return;
            }
        }
        k = wi.a;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = 5;
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FileOutputStream fileOutputStream = this.d;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e) {
                    BdLog.e(e.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = 4;
        }
    }

    public jo(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.i = new Handler();
        this.j = new a(this);
        this.f = handler;
        try {
            Amrnb amrnb = Amrnb.getInstance();
            this.e = amrnb;
            if (amrnb == null || !Amrnb.bLoadLibrary) {
                this.e = null;
                if (this.f != null) {
                    this.f.sendMessage(this.f.obtainMessage(5));
                }
            }
        } catch (Exception unused) {
            Handler handler2 = this.f;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(5));
            }
        }
    }

    public final void f(short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sArr) == null) {
            byte[] bArr = new byte[32];
            try {
                this.d.write(bArr, 0, this.e.encoderEncode(2, sArr, bArr));
            } catch (IOException unused) {
            }
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            Message obtainMessage = this.f.obtainMessage(9);
            obtainMessage.arg1 = i;
            this.f.sendMessage(obtainMessage);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            k = i;
        }
    }

    public boolean j(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i)) == null) {
            if (this.e == null) {
                return false;
            }
            this.a = 0;
            this.b = str;
            this.c = i;
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void i(List<short[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            int a2 = BdSoundGate.b().a();
            short[] sArr = new short[a2];
            short[] sArr2 = new short[a2];
            int size = list.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                System.arraycopy(list.get(i2), 0, sArr2, i, 160);
                i += 160;
                if (i2 == size - 1) {
                    BdSoundGate.b().f(sArr2, sArr);
                    int i3 = 0;
                    for (int i4 = 0; i4 < size; i4++) {
                        System.arraycopy(sArr, i3, list.get(i4), 0, 160);
                        i3 += 160;
                        f(list.get(i4));
                    }
                    i = 0;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioRecord audioRecord;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Process.setThreadPriority(-19);
            if (this.e == null) {
                Handler handler2 = this.f;
                if (handler2 != null) {
                    handler2.sendMessage(handler2.obtainMessage(5));
                }
            } else if (this.a == 4) {
                Handler handler3 = this.f;
                if (handler3 != null) {
                    handler3.sendMessage(handler3.obtainMessage(8));
                }
                this.a = 0;
            } else {
                String str = this.b;
                AudioRecord audioRecord2 = null;
                boolean z = true;
                if (str != null && str.length() > 0) {
                    try {
                        File h = di.h(null, this.b);
                        if (h != null) {
                            this.d = new FileOutputStream(h);
                        } else if (this.f != null) {
                            this.f.sendMessage(this.f.obtainMessage(1));
                            return;
                        } else {
                            return;
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        e();
                        Handler handler4 = this.f;
                        if (handler4 != null) {
                            handler4.sendMessage(handler4.obtainMessage(1));
                        }
                        this.a = 0;
                        return;
                    }
                }
                if (this.a == 4) {
                    Handler handler5 = this.f;
                    if (handler5 != null) {
                        handler5.sendMessage(handler5.obtainMessage(8));
                    }
                    e();
                    this.a = 0;
                    return;
                }
                try {
                    audioRecord = ko.b().a();
                } catch (IllegalArgumentException unused) {
                    Handler handler6 = this.f;
                    if (handler6 != null) {
                        handler6.sendMessage(handler6.obtainMessage(6));
                    }
                    e();
                    this.a = 0;
                    return;
                } catch (Exception unused2) {
                    audioRecord = null;
                }
                if (audioRecord != null && audioRecord.getState() != 0) {
                    if (this.a == 4) {
                        try {
                            audioRecord.release();
                        } catch (Exception unused3) {
                        }
                        Handler handler7 = this.f;
                        if (handler7 != null) {
                            handler7.sendMessage(handler7.obtainMessage(8));
                        }
                        e();
                        this.a = 0;
                        return;
                    }
                    audioRecord.startRecording();
                    if (this.a == 4) {
                        try {
                            audioRecord.stop();
                            audioRecord.release();
                        } catch (Exception unused4) {
                        }
                        Handler handler8 = this.f;
                        if (handler8 != null) {
                            handler8.sendMessage(handler8.obtainMessage(8));
                        }
                        e();
                        this.a = 0;
                        return;
                    }
                    this.a = 3;
                    try {
                        if (this.d == null) {
                            try {
                                audioRecord.stop();
                                audioRecord.release();
                            } catch (Exception unused5) {
                                audioRecord2 = audioRecord;
                            }
                            try {
                                if (this.f != null) {
                                    this.f.sendMessage(this.f.obtainMessage(1));
                                }
                                this.a = 0;
                                return;
                            } catch (IOException unused6) {
                                audioRecord = audioRecord2;
                                try {
                                    audioRecord.stop();
                                    audioRecord.release();
                                } catch (Exception unused7) {
                                }
                                Handler handler9 = this.f;
                                if (handler9 != null) {
                                    handler9.sendMessage(handler9.obtainMessage(3));
                                }
                                this.a = 0;
                                return;
                            }
                        }
                        di.A(this.d);
                        this.e.encoderInit();
                        if (this.c > 0) {
                            BdSoundGate.b().d(FeatureCodes.ADVANCE_BEAUTY, this.c);
                        }
                        ArrayList arrayList = new ArrayList();
                        this.g = System.currentTimeMillis();
                        this.i.post(this.j);
                        short[] sArr = null;
                        short s = 0;
                        while (true) {
                            if (this.a == 3) {
                                if (sArr == null) {
                                    sArr = new short[160];
                                    s = 0;
                                }
                                int read = audioRecord.read(sArr, s, 160 - s);
                                if (read > 0) {
                                    int i = 0;
                                    for (int i2 = 0; i2 < sArr.length; i2++) {
                                        i += sArr[i2] * sArr[i2];
                                    }
                                    Handler handler10 = this.f;
                                    if (handler10 != null) {
                                        Message obtainMessage = handler10.obtainMessage(4);
                                        int abs = Math.abs((((int) (i / read)) / DefaultOggSeeker.MATCH_BYTE_RANGE) >> 1);
                                        while (abs > 100) {
                                            abs = (int) (abs / 10.0d);
                                        }
                                        obtainMessage.arg1 = abs;
                                        this.f.sendMessage(obtainMessage);
                                    }
                                }
                                s = (short) (s + read);
                                if (s == 160) {
                                    if (this.c > 0) {
                                        int size = arrayList.size() + 1;
                                        if (size > 1 && size % 10 == 0) {
                                            i(arrayList);
                                            arrayList.clear();
                                        }
                                        arrayList.add(sArr);
                                    } else {
                                        f(sArr);
                                    }
                                    sArr = null;
                                }
                                ArrayList arrayList2 = arrayList;
                                if (System.currentTimeMillis() - this.g > k) {
                                    break;
                                }
                                arrayList = arrayList2;
                            } else {
                                z = false;
                                break;
                            }
                        }
                        System.currentTimeMillis();
                        if (sArr != null) {
                            while (s < 160) {
                                try {
                                    if (s >= sArr.length || s < 0) {
                                        break;
                                    }
                                    sArr[s] = 0;
                                    s = (short) (s + 1);
                                } catch (Exception unused8) {
                                }
                            }
                            f(sArr);
                        }
                        if (this.c > 0) {
                            BdSoundGate.b().e();
                        }
                        System.currentTimeMillis();
                        audioRecord.stop();
                        audioRecord.release();
                        System.currentTimeMillis();
                        if (this.a == 5) {
                            if (!e()) {
                                Handler handler11 = this.f;
                                if (handler11 != null) {
                                    handler11.sendMessage(handler11.obtainMessage(2));
                                }
                            } else {
                                try {
                                    di.k(this.b);
                                    if (this.f != null) {
                                        this.f.sendMessage(this.f.obtainMessage(100));
                                    }
                                } catch (Exception unused9) {
                                    Handler handler12 = this.f;
                                    if (handler12 != null) {
                                        handler12.sendMessage(handler12.obtainMessage(101));
                                    }
                                    this.a = 0;
                                }
                            }
                            this.a = 0;
                            Handler handler13 = this.i;
                            if (handler13 != null) {
                                handler13.removeCallbacks(this.j);
                                return;
                            }
                            return;
                        }
                        this.a = 4;
                        long currentTimeMillis = System.currentTimeMillis() - this.g;
                        this.h = currentTimeMillis;
                        g((int) currentTimeMillis);
                        Handler handler14 = this.i;
                        if (handler14 != null) {
                            handler14.removeCallbacks(this.j);
                        }
                        System.currentTimeMillis();
                        if (!e() && (handler = this.f) != null) {
                            handler.sendMessage(handler.obtainMessage(2));
                        }
                        this.e.encoderDeinit();
                        this.a = 0;
                        Handler handler15 = this.f;
                        if (handler15 != null) {
                            if (z) {
                                handler15.sendMessage(handler15.obtainMessage(7));
                                return;
                            }
                            Message obtainMessage2 = handler15.obtainMessage(0);
                            obtainMessage2.arg1 = (int) this.h;
                            this.f.sendMessage(obtainMessage2);
                        }
                    } catch (IOException unused10) {
                    }
                } else {
                    if (audioRecord != null) {
                        try {
                            audioRecord.release();
                        } catch (Exception unused11) {
                        }
                    }
                    Handler handler16 = this.f;
                    if (handler16 != null) {
                        handler16.sendMessage(handler16.obtainMessage(6));
                    }
                    e();
                    this.a = 0;
                }
            }
        }
    }
}
