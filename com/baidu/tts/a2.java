package com.baidu.tts;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.DiskCodeCacheManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.internal.http2.Http2Codec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final m c;
    public AudioTrack d;
    public r1 e;
    public final c2 f;
    public final Lock g;
    public final Condition h;
    public boolean i;
    public int j;
    public int k;
    public Handler l;
    public HandlerThread m;
    public int n;
    public long o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public int t;
    public float u;
    public int v;

    public a2(String str, r1 r1Var, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, r1Var, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new c2();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.g = reentrantLock;
        this.h = reentrantLock.newCondition();
        this.i = false;
        this.a = str;
        this.b = w0.a("AudioTrackPlayer", str);
        this.e = r1Var;
        this.v = r1Var.c();
        this.s = this.e.d();
        this.t = this.e.b();
        this.u = this.e.e();
        this.c = mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00fd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        int i;
        int i2;
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Integer num = k2.b;
            String str = "bds-maker-" + this.a;
            if (num != null) {
                this.m = new HandlerThread(str, num.intValue());
            } else {
                this.m = new HandlerThread(str);
            }
            this.m.start();
            this.l = new Handler(this.m.getLooper());
            r1 r1Var = this.e;
            int i4 = r1Var.a;
            int i5 = r1Var.b;
            int i6 = r1Var.c;
            int i7 = r1Var.d;
            this.v = r1Var.h;
            this.s = r1Var.f;
            this.t = r1Var.g;
            this.u = r1Var.e;
            LoggerProxy.d(this.b, "sampleRateHz = " + i4 + " , streamType = " + this.v + " , usage = " + this.s + " , contentType = " + this.t + " , volume = " + this.u);
            int minBufferSize = AudioTrack.getMinBufferSize(i4, i5, i6);
            String str2 = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append("minBufferSize pre ");
            sb.append(minBufferSize);
            LoggerProxy.d(str2, sb.toString());
            int i8 = minBufferSize * 2;
            if (i5 != 12) {
                if (i5 != 1 && i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            i = Integer.bitCount(i5);
                            if (i6 == 3) {
                                i2 = 1;
                            } else {
                                i2 = 2;
                            }
                            int i9 = i2 * i;
                            LoggerProxy.d(this.b, "minBufferSize  frameSizeInBytes = " + i9 + " , channelCount = " + i + " , audioFormat = " + i6);
                            i8 = (i8 % i9 == 0 || i8 < 1) ? 5120 : 5120;
                            LoggerProxy.d(this.b, "minBufferSize after " + i8);
                            this.q = i8;
                            AudioAttributes.Builder builder = new AudioAttributes.Builder();
                            i3 = this.v;
                            if (i3 != -1) {
                                builder.setLegacyStreamType(i3);
                            } else {
                                builder.setUsage(this.s).setContentType(this.t);
                            }
                            AudioTrack audioTrack = new AudioTrack(builder.build(), new AudioFormat.Builder().setSampleRate(i4).setEncoding(i6).setChannelMask(i5).build(), this.q, i7, 0);
                            this.d = audioTrack;
                            audioTrack.setVolume(this.u);
                            z = false;
                            this.k = 0;
                            this.n = 0;
                            this.o = 0L;
                            this.p = i4 * 86400;
                            this.d.setPlaybackPositionUpdateListener(new z1(this), this.l);
                            if (this.e.i == 2) {
                                z = true;
                            }
                            if (!z) {
                                this.d.play();
                            }
                            this.r = true;
                        }
                    }
                }
                i = 1;
                if (i6 == 3) {
                }
                int i92 = i2 * i;
                LoggerProxy.d(this.b, "minBufferSize  frameSizeInBytes = " + i92 + " , channelCount = " + i + " , audioFormat = " + i6);
                if (i8 % i92 == 0) {
                }
                LoggerProxy.d(this.b, "minBufferSize after " + i8);
                this.q = i8;
                AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
                i3 = this.v;
                if (i3 != -1) {
                }
                AudioTrack audioTrack2 = new AudioTrack(builder2.build(), new AudioFormat.Builder().setSampleRate(i4).setEncoding(i6).setChannelMask(i5).build(), this.q, i7, 0);
                this.d = audioTrack2;
                audioTrack2.setVolume(this.u);
                z = false;
                this.k = 0;
                this.n = 0;
                this.o = 0L;
                this.p = i4 * 86400;
                this.d.setPlaybackPositionUpdateListener(new z1(this), this.l);
                if (this.e.i == 2) {
                }
                if (!z) {
                }
                this.r = true;
            }
            i = 2;
            if (i6 == 3) {
            }
            int i922 = i2 * i;
            LoggerProxy.d(this.b, "minBufferSize  frameSizeInBytes = " + i922 + " , channelCount = " + i + " , audioFormat = " + i6);
            if (i8 % i922 == 0) {
            }
            LoggerProxy.d(this.b, "minBufferSize after " + i8);
            this.q = i8;
            AudioAttributes.Builder builder22 = new AudioAttributes.Builder();
            i3 = this.v;
            if (i3 != -1) {
            }
            AudioTrack audioTrack22 = new AudioTrack(builder22.build(), new AudioFormat.Builder().setSampleRate(i4).setEncoding(i6).setChannelMask(i5).build(), this.q, i7, 0);
            this.d = audioTrack22;
            audioTrack22.setVolume(this.u);
            z = false;
            this.k = 0;
            this.n = 0;
            this.o = 0L;
            this.p = i4 * 86400;
            this.d.setPlaybackPositionUpdateListener(new z1(this), this.l);
            if (this.e.i == 2) {
            }
            if (!z) {
            }
            this.r = true;
        }
    }

    public final void a(v1 v1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v1Var) == null) && this.k <= this.p) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.o;
            byte[] bArr = v1Var.g;
            int i = v1Var.c;
            int i2 = v1Var.f;
            int i3 = v1Var.b;
            int i4 = this.k;
            if (i4 != 0 && i4 == this.n && Math.abs(i2) != 1 && j > 40) {
                String str = this.b;
                LoggerProxy.d(str, "stuck time " + j + " , sn = " + v1Var.i.g + " , idx = " + i);
                f0 a = f0.a(this.a);
                long j2 = this.o;
                if (a.d == null) {
                    a.d = new h0();
                }
                h0 h0Var = a.d;
                if (h0Var.h == null) {
                    h0Var.h = new JSONArray();
                }
                h0 h0Var2 = a.d;
                h0Var2.getClass();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DiskCodeCacheManager.DISK_CODE_CACHE_INDEX_SUFFIX, i);
                    jSONObject.put("type", i3);
                    jSONObject.put(Http2Codec.TE, j2);
                    jSONObject.put("ts", currentTimeMillis);
                    JSONArray jSONArray = h0Var2.h;
                    if (jSONArray != null) {
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            int length = this.k + (bArr.length / 2);
            this.k = length;
            this.d.setNotificationMarkerPosition(length);
        }
    }

    public d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d();
            try {
                AudioTrack audioTrack = this.d;
                if (audioTrack != null) {
                    audioTrack.release();
                }
                this.d = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            HandlerThread handlerThread = this.m;
            if (handlerThread != null) {
                boolean quit = handlerThread.quit();
                this.m.interrupt();
                try {
                    this.m.join(50L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.m = null;
                String str = this.b;
                LoggerProxy.d(str, "mark thread is quit = " + quit);
            }
            this.l = null;
            this.r = false;
            return null;
        }
        return (d) invokeV.objValue;
    }

    public final void b(v1 v1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v1Var) == null) {
            this.f.getClass();
            v1 v1Var2 = new v1(l0.h, v1Var.i, null);
            m mVar = this.c;
            if (mVar != null) {
                mVar.a(v1Var2);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                this.g.lock();
                this.h.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.g.unlock();
            }
        }
    }

    public final void c(v1 v1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, v1Var) == null) {
            c2 c2Var = this.f;
            r1 r1Var = this.e;
            c2Var.b = (r1Var.a * 2) / r1Var.j;
            c2Var.a = 0;
            c2Var.c = 0;
            c2Var.d = 0;
            c2Var.e = 0;
            c2Var.f = 0;
            this.j = 0;
            v1 v1Var2 = new v1(l0.f, v1Var.i, null);
            m mVar = this.c;
            if (mVar != null) {
                mVar.a(v1Var2);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LoggerProxy.d(this.b, "stop");
            try {
                if (this.i) {
                    this.i = false;
                    c();
                }
                AudioTrack audioTrack = this.d;
                if (audioTrack != null) {
                    audioTrack.pause();
                    this.d.flush();
                    this.d.stop();
                    this.k = 0;
                    this.n = 0;
                    this.o = 0L;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final boolean d(v1 v1Var) {
        InterceptResult invokeL;
        y1 y1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, v1Var)) == null) {
            byte[] bArr = v1Var.g;
            while (true) {
                if (!this.f.hasNext()) {
                    return true;
                }
                y1 next = this.f.next();
                int i = next.a;
                int i2 = next.b;
                int i3 = 0;
                for (int i4 = 1; i3 < i2 && this.d.getPlayState() != i4; i4 = 1) {
                    int i5 = i2 - i3;
                    int i6 = i3 + i;
                    f0 a = f0.a(this.a);
                    int i7 = v1Var.b;
                    int i8 = this.e.a;
                    a.getClass();
                    if (i7 == 0) {
                        y1Var = next;
                        a.j += i5;
                        a.l = i8;
                    } else {
                        y1Var = next;
                        if (i7 == i4) {
                            a.k += i5;
                            a.m = i8;
                        }
                    }
                    int write = this.d.write(bArr, i6, i5);
                    if (write >= 0) {
                        int i9 = write + i3;
                        while (this.i) {
                            try {
                                try {
                                    this.g.lock();
                                    LoggerProxy.d(this.b, "await before" + System.currentTimeMillis());
                                    this.h.await();
                                    LoggerProxy.d(this.b, "await after" + System.currentTimeMillis());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } finally {
                                this.g.unlock();
                            }
                        }
                        i3 = i9;
                        next = y1Var;
                    } else {
                        b();
                        a();
                        this.d.play();
                        LoggerProxy.e(this.b, "audio track write fatal error, ret=" + write);
                        break;
                    }
                }
                y1Var = next;
                if (this.d.getPlayState() == 1) {
                    return false;
                }
                y1 y1Var2 = y1Var;
                if (y1Var2.c) {
                    int round = Math.round(v1Var.d * y1Var2.d);
                    if (round > this.j) {
                        this.j = round;
                    }
                    int i10 = this.j;
                    v1 v1Var2 = new v1(l0.g, v1Var.i, null);
                    v1Var2.b = v1Var.b;
                    v1Var2.h = v1Var.h;
                    v1Var2.g = v1Var.g;
                    v1Var2.d = i10;
                    v1Var2.k = v1Var.k;
                    v1Var2.c = v1Var.c;
                    v1Var2.f = v1Var.f;
                    m mVar = this.c;
                    if (mVar != null) {
                        mVar.a(v1Var2);
                    }
                }
            }
        } else {
            return invokeL.booleanValue;
        }
    }
}
