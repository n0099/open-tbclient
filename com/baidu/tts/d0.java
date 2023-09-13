package com.baidu.tts;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.speechsynthesizer.utility.SpeechDecoder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.g2;
import com.baidu.tts.receiver.TestCommandReceiver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<String, d0> r;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final SpeechDecoder c;
    public String d;
    public final LinkedBlockingQueue<v1> e;
    public volatile int f;
    public volatile boolean g;
    public final Object h;
    public b i;
    public m j;
    public volatile boolean k;
    public final Semaphore l;
    public i2 m;
    public volatile boolean n;
    public v1 o;
    public int p;
    public Runnable q;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        public a(d0 d0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int b;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LoggerProxy.d(this.a.b, "stream decoder thread begin runs.");
                while (!this.a.k) {
                    try {
                        d0 d0Var = this.a;
                        d0Var.o = d0Var.e.poll(1L, TimeUnit.SECONDS);
                        v1 v1Var = this.a.o;
                        if (v1Var != null) {
                            String str = v1Var.i.g;
                            if (str != null && !str.isEmpty()) {
                                String str2 = this.a.d;
                                try {
                                    if (str2 != null && str2.equalsIgnoreCase(str)) {
                                        d0 d0Var2 = this.a;
                                        d0Var2.i.e(d0Var2.o);
                                        String str3 = this.a.b;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("+++ decode sn=");
                                        sb.append(str);
                                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                                        d0 d0Var3 = this.a;
                                        sb.append(d0Var3.i.c(d0Var3.o));
                                        LoggerProxy.d(str3, sb.toString());
                                        d0 d0Var4 = this.a;
                                        b = d0Var4.i.b(d0Var4.o);
                                        if (b != 0 && b != 31415926) {
                                            z0 a = z0.a();
                                            u0 u0Var = u0.l;
                                            Throwable th = new Throwable("Audio decode failed.");
                                            d a2 = a.a(u0Var);
                                            a2.a = th;
                                            f0.a(this.a.a).a(a2, str);
                                        }
                                        String str4 = this.a.b;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("--- decode sn=");
                                        sb2.append(str);
                                        sb2.append(", ret=");
                                        sb2.append(b);
                                        sb2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                                        d0 d0Var5 = this.a;
                                        b bVar = d0Var5.i;
                                        v1 v1Var2 = d0Var5.o;
                                        bVar.getClass();
                                        sb2.append("ChunkIndex=" + v1Var2.c + ", last_pcm_index=" + bVar.c + ", last_word_pos=" + bVar.e);
                                        sb2.append(" ");
                                        sb2.append(this.a.o.a);
                                        LoggerProxy.d(str4, sb2.toString());
                                    }
                                    String str32 = this.a.b;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("+++ decode sn=");
                                    sb3.append(str);
                                    sb3.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                                    d0 d0Var32 = this.a;
                                    sb3.append(d0Var32.i.c(d0Var32.o));
                                    LoggerProxy.d(str32, sb3.toString());
                                    d0 d0Var42 = this.a;
                                    b = d0Var42.i.b(d0Var42.o);
                                    if (b != 0) {
                                        z0 a3 = z0.a();
                                        u0 u0Var2 = u0.l;
                                        Throwable th2 = new Throwable("Audio decode failed.");
                                        d a22 = a3.a(u0Var2);
                                        a22.a = th2;
                                        f0.a(this.a.a).a(a22, str);
                                    }
                                    String str42 = this.a.b;
                                    StringBuilder sb22 = new StringBuilder();
                                    sb22.append("--- decode sn=");
                                    sb22.append(str);
                                    sb22.append(", ret=");
                                    sb22.append(b);
                                    sb22.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                                    d0 d0Var52 = this.a;
                                    b bVar2 = d0Var52.i;
                                    v1 v1Var22 = d0Var52.o;
                                    bVar2.getClass();
                                    sb22.append("ChunkIndex=" + v1Var22.c + ", last_pcm_index=" + bVar2.c + ", last_word_pos=" + bVar2.e);
                                    sb22.append(" ");
                                    sb22.append(this.a.o.a);
                                    LoggerProxy.d(str42, sb22.toString());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                synchronized (this.a.h) {
                                    if (this.a.f > 0) {
                                        d0 d0Var6 = this.a;
                                        d0Var6.f--;
                                    }
                                }
                                d0 d0Var7 = this.a;
                                d0Var7.p = 0;
                                d0Var7.i = new b(d0Var7, d0Var7.o);
                                d0 d0Var8 = this.a;
                                d0Var8.c.setOnDecodedDataListener(d0Var8.i);
                                d0 d0Var9 = this.a;
                                d0Var9.d = d0Var9.o.i.g;
                            }
                            LoggerProxy.d(this.a.b, "bag will drop for empty.");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                LoggerProxy.d(this.a.b, "notify thread exit+++");
                this.a.l.release();
                LoggerProxy.d(this.a.b, "notify thread exit---");
                LoggerProxy.d(this.a.b, "stream decoder thread end runs.");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements SpeechDecoder.OnDecodedDataListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public byte[] b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public FileOutputStream g;
        public File h;
        public f2 i;
        public final /* synthetic */ d0 j;

        public b(d0 d0Var, v1 v1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, v1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = d0Var;
            this.c = 1;
            this.d = 0;
            this.e = 0;
            this.f = false;
            this.g = null;
            this.h = null;
            this.b = new byte[0];
            e(v1Var);
            LoggerProxy.d(d0Var.b, "create new DCB");
            a(v1Var);
        }

        public final void a(v1 v1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, v1Var) == null) && LoggerProxy.needPrint(2)) {
                int i = TestCommandReceiver.b;
                if (TestCommandReceiver.b.a.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("/sdcard/bds-tts/");
                    sb.append("audio_dump");
                    String str = File.separator;
                    sb.append(str);
                    sb.append(this.j.a);
                    sb.append(str);
                    sb.append(v1Var.i.g);
                    String sb2 = sb.toString();
                    w0.a(sb2);
                    this.h = new File(sb2);
                    String str2 = this.j.b;
                    LoggerProxy.d(str2, "AudioDumpDir: " + sb2);
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:146:0x00e1 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x010f */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x0111 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:106:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:132:0x0248 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:133:0x024c  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0166  */
        /* JADX WARN: Type inference failed for: r20v0 */
        /* JADX WARN: Type inference failed for: r20v10 */
        /* JADX WARN: Type inference failed for: r20v12 */
        /* JADX WARN: Type inference failed for: r20v13 */
        /* JADX WARN: Type inference failed for: r20v14 */
        /* JADX WARN: Type inference failed for: r20v6 */
        /* JADX WARN: Type inference failed for: r20v7 */
        /* JADX WARN: Type inference failed for: r20v8 */
        /* JADX WARN: Type inference failed for: r6v1, types: [int] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int b(v1 v1Var) {
            Interceptable interceptable;
            byte[] bArr;
            int i;
            byte[] bArr2;
            f2 f2Var;
            boolean z;
            f2 f2Var2;
            w1 w1Var;
            String str;
            StringBuilder sb;
            byte[] bArr3;
            long j;
            Interceptable interceptable2 = $ic;
            if (interceptable2 != null) {
                interceptable = interceptable2;
                bArr = 1048577;
                InterceptResult invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v1Var);
                if (invokeL != null) {
                    return invokeL.intValue;
                }
            }
            b bVar = this;
            if (v1Var.a == l0.c) {
                byte[] bArr4 = v1Var.g;
                ?? r6 = v1Var.c;
                if (Math.abs((int) r6) == 1) {
                    w1 w1Var2 = v1Var.i;
                    g2 g2Var = w1Var2.k;
                    if (g2Var.i == 0) {
                        g2Var.i = System.currentTimeMillis();
                        String str2 = bVar.j.b;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("timeCostStatics = ");
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, g2Var.c);
                            jSONObject.put("text", g2Var.e);
                            jSONObject.put("instanceId", g2Var.d);
                            jSONObject.put("beginSynthesize", g2Var.f);
                            w1Var = w1Var2;
                            try {
                                jSONObject.put("gbkCodeCost", g2Var.g - g2Var.f);
                                jSONObject.put("onSynthesizeStart", g2Var.h);
                                jSONObject.put("onFirstDataArrive", g2Var.i);
                                jSONObject.put("totalCost", g2Var.i - g2Var.f);
                                g2.b bVar2 = g2Var.a;
                                try {
                                    if (bVar2 != null) {
                                        long j2 = bVar2.a;
                                        long j3 = bVar2.b;
                                        interceptable = r6;
                                        try {
                                            long j4 = bVar2.c;
                                            bArr = bArr4;
                                            long j5 = bVar2.d;
                                            jSONObject.put("onlineTimeStatistics", bVar2.a());
                                            if (j2 != 0) {
                                                jSONObject.put("sdkEarlyCost", j2 - g2Var.f);
                                            } else if (j3 != 0) {
                                                jSONObject.put("sdkEarlyCost", j3 - g2Var.f);
                                            } else {
                                                jSONObject.put("sdkEarlyCost", j4 - g2Var.f);
                                            }
                                            sb = sb2;
                                            j = g2Var.i - j5;
                                            str = str2;
                                        } catch (JSONException e) {
                                            e = e;
                                            bArr = bArr4;
                                            str = str2;
                                            sb = sb2;
                                            e.printStackTrace();
                                            bArr3 = bArr;
                                            StringBuilder sb3 = sb;
                                            sb3.append(jSONObject.toString());
                                            LoggerProxy.d(str, sb3.toString());
                                            bArr2 = bArr3;
                                            f2 f2Var3 = new f2();
                                            bVar = this;
                                            bVar.i = f2Var3;
                                            f2Var3.d = bVar.j.a;
                                            w1 w1Var3 = w1Var;
                                            f2Var3.b = w1Var3.g;
                                            f2Var3.c = w1Var3.b;
                                            f2Var3.e = w1Var3.a;
                                            if (v1Var.h == i0.a) {
                                            }
                                            bVar.e = v1Var.d;
                                            if (bVar.f) {
                                            }
                                        }
                                    } else {
                                        bArr = bArr4;
                                        interceptable = r6;
                                        g2.a aVar = g2Var.b;
                                        if (aVar != null) {
                                            long j6 = aVar.a;
                                            long j7 = aVar.b;
                                            long j8 = j6 - g2Var.f;
                                            JSONObject jSONObject2 = new JSONObject();
                                            str = str2;
                                            sb = sb2;
                                            try {
                                                try {
                                                    jSONObject2.put("sendDataToEngine", aVar.a);
                                                    jSONObject2.put("firstReceiveDataFromEngine", aVar.b);
                                                    jSONObject2.put("engineCost", aVar.b - aVar.a);
                                                } catch (JSONException e2) {
                                                    e2.printStackTrace();
                                                }
                                                jSONObject.put("offlineTimeStatistics", jSONObject2);
                                                jSONObject.put("sdkEarlyCost", j8);
                                                j = g2Var.i - j7;
                                            } catch (JSONException e3) {
                                                e = e3;
                                                e.printStackTrace();
                                                bArr3 = bArr;
                                                StringBuilder sb32 = sb;
                                                sb32.append(jSONObject.toString());
                                                LoggerProxy.d(str, sb32.toString());
                                                bArr2 = bArr3;
                                                f2 f2Var32 = new f2();
                                                bVar = this;
                                                bVar.i = f2Var32;
                                                f2Var32.d = bVar.j.a;
                                                w1 w1Var32 = w1Var;
                                                f2Var32.b = w1Var32.g;
                                                f2Var32.c = w1Var32.b;
                                                f2Var32.e = w1Var32.a;
                                                if (v1Var.h == i0.a) {
                                                }
                                                bVar.e = v1Var.d;
                                                if (bVar.f) {
                                                }
                                            }
                                        } else {
                                            str = str2;
                                            sb = sb2;
                                            j = 0;
                                        }
                                    }
                                    jSONObject.put("sdkLaterCost", j);
                                    bArr3 = bArr;
                                } catch (JSONException e4) {
                                    e = e4;
                                }
                            } catch (JSONException e5) {
                                e = e5;
                                bArr = bArr4;
                                interceptable = r6;
                            }
                        } catch (JSONException e6) {
                            e = e6;
                            bArr = bArr4;
                            interceptable = r6;
                            w1Var = w1Var2;
                        }
                        StringBuilder sb322 = sb;
                        sb322.append(jSONObject.toString());
                        LoggerProxy.d(str, sb322.toString());
                        bArr2 = bArr3;
                    } else {
                        bArr2 = bArr4;
                        interceptable = r6;
                        w1Var = w1Var2;
                    }
                    f2 f2Var322 = new f2();
                    bVar = this;
                    bVar.i = f2Var322;
                    f2Var322.d = bVar.j.a;
                    w1 w1Var322 = w1Var;
                    f2Var322.b = w1Var322.g;
                    f2Var322.c = w1Var322.b;
                    f2Var322.e = w1Var322.a;
                } else {
                    bArr2 = bArr4;
                    interceptable = r6;
                }
                if (v1Var.h == i0.a) {
                    byte[] bArr5 = v1Var.g;
                    if (bArr5 != null && (f2Var2 = bVar.i) != null) {
                        f2Var2.a = false;
                        f2Var2.f += v1Var.e;
                        f2Var2.h += bArr5.length;
                    }
                    d(v1Var);
                    byte[] bArr6 = v1Var.g;
                    FileOutputStream fileOutputStream = bVar.g;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.write(bArr6);
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (v1Var.g != null && v1Var.c < 0) {
                        z = true;
                        v1Var.m = true;
                    } else {
                        z = true;
                    }
                    i = d0.a(bVar.j, v1Var, bVar.i);
                    if (i == 31415926) {
                        bVar.f = z;
                    }
                    try {
                        FileOutputStream fileOutputStream2 = bVar.g;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                            bVar.g = null;
                        }
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                } else {
                    byte[] bArr7 = bArr2;
                    i = 0;
                    if (bArr7.length == 0) {
                        bVar.onDecodedData(bArr7);
                    } else {
                        int i2 = (int) v1Var.l;
                        byte[] bArr8 = v1Var.g;
                        if (i2 != 0 && bArr8 != null && (f2Var = bVar.i) != null) {
                            f2Var.a = true;
                            f2Var.f += v1Var.e;
                            ByteBuffer wrap = ByteBuffer.wrap(bArr8);
                            wrap.clear();
                            wrap.order(ByteOrder.BIG_ENDIAN);
                            wrap.getInt();
                            int i3 = (v1Var.k.a * 2) / (i2 / 8);
                            while (wrap.position() != bArr8.length) {
                                int i4 = wrap.getInt();
                                wrap.getInt();
                                bVar.i.g += i4 * i3;
                                wrap.get(new byte[i4]);
                            }
                        }
                        d(v1Var);
                        int decodeWithCallback = bVar.j.c.decodeWithCallback(bArr7, interceptable == 1 ? 1 : 0);
                        try {
                            FileOutputStream fileOutputStream3 = bVar.g;
                            if (fileOutputStream3 != null) {
                                fileOutputStream3.close();
                                bVar.g = null;
                            }
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                        i = decodeWithCallback;
                    }
                }
                bVar.e = v1Var.d;
            } else {
                i = 0;
                m mVar = bVar.j.j;
                if (mVar != null) {
                    mVar.a(v1Var);
                }
            }
            if (bVar.f) {
                return 31415926;
            }
            return i;
        }

        public String c(v1 v1Var) {
            InterceptResult invokeL;
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v1Var)) == null) {
                byte[] bArr = v1Var.g;
                if (bArr == null) {
                    length = 0;
                } else {
                    length = bArr.length;
                }
                return "ChunkIndex=" + v1Var.c + ", audio_len=" + length + ", playtime=" + this.a + "ms, last_pcm_index=" + this.c + ", last_word_pos=" + this.e;
            }
            return (String) invokeL.objValue;
        }

        public final void d(v1 v1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, v1Var) == null) {
                try {
                    if (this.h != null) {
                        String str = this.h.getPath() + File.separator + v1Var.c + ".pcm";
                        LoggerProxy.d(this.j.b, "create file " + str);
                        this.g = new FileOutputStream(str, true);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        public void e(v1 v1Var) {
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, v1Var) == null) {
                int i = 0;
                this.f = false;
                i0 i0Var = v1Var.h;
                int i2 = v1Var.k.a;
                if (i2 != 0 && (bArr = v1Var.g) != null) {
                    int i3 = i2 * 2;
                    i = i0Var == i0.a ? (bArr.length * 1000) / i3 : ((bArr.length * ((int) (i3 / (v1Var.l / 8.0d)))) * 1000) / i3;
                }
                this.a = i;
            }
        }

        @Override // com.baidu.speechsynthesizer.utility.SpeechDecoder.OnDecodedDataListener
        public void onDecodedData(byte[] bArr) {
            v1 v1Var;
            int length;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) && bArr != null && !this.f) {
                b bVar = this.j.i;
                bVar.getClass();
                try {
                    String str = bVar.j.o.i.g;
                    f2 f2Var = bVar.i;
                    if (f2Var != null && TextUtils.equals(f2Var.b, str)) {
                        bVar.i.h += bArr.length;
                    }
                    FileOutputStream fileOutputStream = bVar.g;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.write(bArr);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    byte[] bArr2 = bVar.b;
                    length = bArr2.length + bArr.length;
                    byte[] bArr3 = new byte[length];
                    System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                    System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
                    bVar.b = bArr3;
                    v1Var = bVar.j.o.a();
                    i = v1Var.k.a * 2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (length >= i / 10) {
                    v1 v1Var2 = bVar.j.o;
                    int length2 = v1Var2.g.length;
                    int i3 = v1Var2.d;
                    double d = (length / i) / ((length2 * 8) / v1Var2.l);
                    double d2 = bVar.d;
                    int i4 = bVar.c;
                    v1Var.g = bVar.b;
                    v1Var.b = 0;
                    v1Var.h = i0.a;
                    v1Var.d = (int) (d2 + (d * (i3 - i2) * i4));
                    bVar.c = i4 + 1;
                    bVar.b = new byte[0];
                } else {
                    if (bArr.length == 0) {
                        v1 v1Var3 = bVar.j.o;
                        int i5 = v1Var3.d;
                        bVar.d = i5;
                        bVar.c = 1;
                        if (v1Var3.c < 0) {
                            bVar.d = 0;
                            v1Var.m = true;
                        }
                        v1Var.g = bVar.b;
                        v1Var.b = 0;
                        v1Var.h = i0.a;
                        v1Var.d = i5;
                        bVar.b = new byte[0];
                    }
                    v1Var = null;
                }
                if (v1Var != null && d0.a(this.j, v1Var, this.i) == 31415926) {
                    this.f = true;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722252421, "Lcom/baidu/tts/d0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722252421, "Lcom/baidu/tts/d0;");
                return;
            }
        }
        r = new ConcurrentHashMap<>();
    }

    public boolean a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.h) {
                if (this.f >= 5) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.e.clear();
            synchronized (this.h) {
                this.f = 0;
                this.g = true;
            }
            this.m.interrupt();
            return 0;
        }
        return invokeV.intValue;
    }

    public d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new LinkedBlockingQueue<>();
        this.f = 0;
        this.g = true;
        this.h = new Object();
        this.i = null;
        this.k = false;
        this.l = new Semaphore(0);
        this.m = null;
        this.n = false;
        this.q = new a(this);
        this.b = w0.a("StreamDecoderService", str);
        this.a = str;
        this.c = new SpeechDecoder(str);
        this.m = new i2(this.q, "bds-decoder-" + str);
    }

    public int a(v1 v1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v1Var)) == null) {
            if (this.k) {
                return -1;
            }
            try {
                boolean offer = this.e.offer(v1Var, 1L, TimeUnit.SECONDS);
                if (offer) {
                    int i = v1Var.c;
                    synchronized (this.h) {
                        if (this.g) {
                            this.f++;
                            this.g = false;
                        }
                        if (i < 0) {
                            this.g = true;
                        }
                    }
                    LoggerProxy.d(this.b, "new bag accepted sn=" + v1Var.i.g + ", index=" + v1Var.c);
                }
                if (offer) {
                    return 0;
                }
                return -3;
            } catch (InterruptedException unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static int a(d0 d0Var, v1 v1Var, f2 f2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, d0Var, v1Var, f2Var)) == null) {
            int i = d0Var.p + 1;
            d0Var.p = i;
            boolean z = v1Var.m;
            if (z) {
                d0Var.p = -i;
            }
            v1 v1Var2 = d0Var.o;
            int i2 = d0Var.p;
            v1Var2.f = i2;
            v1Var.f = i2;
            byte[] bArr = v1Var.g;
            if (f2Var != null && bArr != null) {
                f2Var.i += bArr.length;
                if (z) {
                    String str = d0Var.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("audioIntegrityDetection = ");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("instanceId", f2Var.d);
                        jSONObject.put(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, f2Var.b);
                        jSONObject.put("text", f2Var.e);
                        jSONObject.put("utteranceId", f2Var.c);
                        jSONObject.put("isEncoder", f2Var.a);
                        if (f2Var.a) {
                            jSONObject.put("encoderLength", f2Var.f);
                            jSONObject.put("expectDecoderLength", f2Var.g);
                        }
                        jSONObject.put("actualDecoderLength", f2Var.h);
                        jSONObject.put("actualLength", f2Var.i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    sb.append(jSONObject);
                    LoggerProxy.d(str, sb.toString());
                }
            }
            m mVar = d0Var.j;
            if (mVar != null) {
                mVar.a(v1Var);
                if (Thread.currentThread().isInterrupted()) {
                    Thread.interrupted();
                    return 31415926;
                }
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    public static d0 a(String str) {
        InterceptResult invokeL;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (d0.class) {
                ConcurrentHashMap<String, d0> concurrentHashMap = r;
                if (!concurrentHashMap.containsKey(str)) {
                    concurrentHashMap.put(str, new d0(str));
                }
                d0Var = concurrentHashMap.get(str);
            }
            return d0Var;
        }
        return (d0) invokeL.objValue;
    }

    public void a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
            this.j = mVar;
        }
    }
}
