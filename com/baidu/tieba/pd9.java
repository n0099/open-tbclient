package com.baidu.tieba;

import android.media.MediaFormat;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.audioedit.AudioChangeConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class pd9 implements ae9, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static AudioChangeConfig A;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;
    public Object b;
    public Object c;
    public volatile long d;
    public volatile nd9 e;
    public volatile long f;
    public volatile long g;
    public volatile td9 h;
    public volatile kf9 i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public float r;
    public int s;
    public volatile boolean t;
    public byte[] u;
    public List<yd9> v;
    public int[] w;
    public int x;
    public int y;
    public lf9 z;

    public pd9(int i, String str, float f, float f2, int[] iArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, Float.valueOf(f), Float.valueOf(f2), iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = Long.MIN_VALUE;
        this.g = Long.MIN_VALUE;
        this.r = 1.0f;
        this.s = 0;
        this.t = false;
        this.u = null;
        this.n = i;
        this.w = iArr;
        q(str);
        this.h = p();
        this.a = new Object();
        this.b = new Object();
        this.c = new Object();
        this.j = true;
        this.k = false;
        this.l = false;
        this.m = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public pd9(int i, String str, int[] iArr) throws Exception {
        this(i, str, 1.0f, 1.0f, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue(), (int[]) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean o(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iArr)) == null) {
            if (iArr == null || iArr.length == 0) {
                return false;
            }
            boolean z = false;
            for (int i : iArr) {
                if (i > 700 || i > 300 || i > 200 || i > 100) {
                    z = true;
                    break;
                }
                if (i > 0) {
                    z = true;
                }
            }
            AudioChangeConfig audioChangeConfig = A;
            return audioChangeConfig != null ? audioChangeConfig.configEnabled(z) : z;
        }
        return invokeL.booleanValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || A == null) {
            return;
        }
        A = null;
    }

    public abstract void B(long j);

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.i == null || this.k) {
            return;
        }
        long currentPosition = this.e.getCurrentPosition();
        long duration = this.e.getDuration();
        this.i.onProgressChanged(this.n, (currentPosition == 0 || duration == 0) ? 0.0d : currentPosition / duration, currentPosition);
    }

    public void D(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) {
            E(iArr, null, null);
        }
    }

    public void E(int[] iArr, int[] iArr2, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, iArr, iArr2, dArr) == null) {
            this.w = iArr;
            rd9 f = f();
            if (iArr2 == null && dArr == null) {
                f.b(this.w);
            } else {
                f.c(this.w, iArr2, dArr);
            }
        }
    }

    public void F(kf9 kf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kf9Var) == null) {
            this.i = kf9Var;
        }
    }

    public void G(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            if (this.v == null) {
                this.v = new ArrayList();
            }
            qd9 qd9Var = null;
            Iterator<yd9> it = this.v.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yd9 next = it.next();
                if (next instanceof qd9) {
                    qd9Var = (qd9) next;
                    break;
                }
            }
            if (qd9Var == null) {
                qd9Var = new qd9();
                qd9Var.a(this.n, this.o, this.p, this.q);
                this.v.add(0, qd9Var);
            }
            qd9Var.b(f);
        }
    }

    public void H(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.r = f;
            if (this.v == null) {
                this.v = new ArrayList();
            }
            sd9 sd9Var = null;
            Iterator<yd9> it = this.v.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yd9 next = it.next();
                if (next instanceof sd9) {
                    sd9Var = (sd9) next;
                    break;
                }
            }
            if (sd9Var == null) {
                sd9Var = new sd9();
                sd9Var.a(this.n, this.o, this.p, this.q);
                List<yd9> list = this.v;
                list.add(list.size(), sd9Var);
            }
            sd9Var.b(this.r);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.a) {
                u();
                this.j = false;
                this.m = false;
                this.k = false;
                this.l = false;
                this.a.notifyAll();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.j) {
                synchronized (this.a) {
                    this.j = false;
                    this.a.notifyAll();
                }
            }
            v();
            this.k = true;
        }
    }

    @Override // com.baidu.tieba.ae9
    public void a(MediaFormat mediaFormat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mediaFormat) == null) {
            try {
                this.o = this.e.e();
                this.p = this.e.b();
                r();
                if (this.h instanceof xd9) {
                    ((xd9) this.h).c(m(), i());
                }
            } catch (Exception e) {
                lf9 lf9Var = this.z;
                if (lf9Var != null) {
                    lf9Var.onExceptionThrown(ah9.g(e));
                }
            }
        }
    }

    public final byte[] b() throws IOException {
        InterceptResult invokeV;
        byte[] l;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.t) {
                return null;
            }
            this.t = true;
            if (l(Math.abs(this.s)).length > 0) {
                synchronized (this.b) {
                    this.d += this.h.write(l, 0, length);
                    qg9.j("VideoMuxer: ", "bytesWritten ：" + this.d + " ， empty bytesWritten time ：" + (((float) this.d) / ((this.q * this.p) * this.o)) + 1000);
                }
                return null;
            }
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || vg9.e(this.v)) {
            return;
        }
        for (yd9 yd9Var : this.v) {
            if (yd9Var != null) {
                yd9Var.e();
            }
        }
    }

    public final byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bArr)) == null) {
            if (!this.t) {
                this.t = true;
                this.u = l(Math.abs(this.s));
            }
            byte[] bArr2 = this.u;
            if (bArr2 == null) {
                return bArr;
            }
            if (bArr.length < bArr2.length) {
                int length = bArr2.length - bArr.length;
                byte[] bArr3 = new byte[length];
                System.arraycopy(bArr2, bArr.length, bArr3, 0, length);
                this.u = bArr3;
                qg9.j("VideoMuxer: ", "----discardAudioData-----,result.length : " + this.u.length);
                return null;
            }
            qg9.j("VideoMuxer: ", "----discardAudioData-----, audioData.length >= result.length ， audioData.length : " + bArr.length + " ， result.length : " + this.u.length);
            int length2 = bArr.length;
            byte[] bArr4 = this.u;
            int length3 = length2 - bArr4.length;
            byte[] bArr5 = new byte[length3];
            System.arraycopy(bArr, bArr4.length, bArr5, 0, length3);
            this.u = null;
            qg9.j("VideoMuxer: ", "----discardAudioData-----, audioData.length >= result.length ，new baffle length : " + length3);
            return bArr5;
        }
        return (byte[]) invokeL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || vg9.e(this.v)) {
            return;
        }
        for (yd9 yd9Var : this.v) {
            if (yd9Var != null) {
                yd9Var.c();
            }
        }
    }

    public final rd9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.v == null) {
                this.v = new ArrayList();
            }
            rd9 rd9Var = null;
            Iterator<yd9> it = this.v.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yd9 next = it.next();
                if (next instanceof rd9) {
                    rd9Var = (rd9) next;
                    break;
                }
            }
            if (rd9Var == null) {
                rd9 rd9Var2 = new rd9();
                rd9Var2.a(this.n, this.o, this.p, this.q * 8);
                List<yd9> list = this.v;
                list.add(list.size(), rd9Var2);
                return rd9Var2;
            }
            return rd9Var;
        }
        return (rd9) invokeV.objValue;
    }

    public int[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.w : (int[]) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.q : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            this.y = this.o;
            if (n()) {
                this.y = 1;
            }
            return this.y;
        }
        return invokeV.intValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this.c) {
                if (this.e != null) {
                    return this.e.getCurrentPosition();
                }
                return Long.MIN_VALUE;
            }
        }
        return invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.e != null) {
                return this.e.getDuration();
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    public final byte[] l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            int m = (((this.q * m()) * i()) / 1000) * i;
            qg9.j("VideoMuxer: ", "byte size is : " + m);
            return new byte[m];
        }
        return (byte[]) invokeI.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            this.x = this.p;
            qg9.b("SoundStreamRunnable: mTargetSampleRate=" + this.x);
            return this.x;
        }
        return invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? o(this.w) : invokeV.booleanValue;
    }

    public abstract td9 p() throws IOException;

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this.a) {
                t();
                this.j = true;
            }
        }
    }

    public final void q(String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (Build.VERSION.SDK_INT < 16) {
                if (this.i == null || this.l) {
                    return;
                }
                this.i.onExceptionThrown("Only API level >= 16 supported.");
                return;
            }
            this.e = new zd9(str);
            ((zd9) this.e).k(this);
            this.o = this.e.e();
            this.p = this.e.b();
            this.q = this.e.a();
            qg9.d("SoundStreamRunnable: channels=" + this.o + ";samplingRate=" + this.p + ";byteWidth=" + this.q);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || vg9.e(this.v)) {
            return;
        }
        for (yd9 yd9Var : this.v) {
            if (yd9Var != null) {
                yd9Var.a(this.n, this.o, this.p, this.q);
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            while (!this.k) {
                try {
                    try {
                        if (!this.m) {
                            y();
                            synchronized (this.c) {
                                this.e.d();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (this.i != null && !this.l) {
                            this.i.onExceptionThrown(ah9.g(e));
                        }
                        this.k = true;
                        z();
                        A();
                        synchronized (this.b) {
                            try {
                                this.h.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            this.h = null;
                            synchronized (this.c) {
                                if (this.e != null) {
                                    this.e.close();
                                }
                                this.e = null;
                                return;
                            }
                        }
                    }
                } catch (Throwable th) {
                    this.k = true;
                    z();
                    A();
                    synchronized (this.b) {
                        try {
                            this.h.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        this.h = null;
                        synchronized (this.c) {
                            if (this.e != null) {
                                this.e.close();
                            }
                            this.e = null;
                            throw th;
                        }
                    }
                }
            }
            this.k = true;
            z();
            A();
            synchronized (this.b) {
                try {
                    this.h.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                this.h = null;
            }
            synchronized (this.c) {
                if (this.e != null) {
                    this.e.close();
                }
                this.e = null;
            }
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.f == Long.MIN_VALUE || this.g == Long.MIN_VALUE) ? false : true : invokeV.booleanValue;
    }

    public abstract void t();

    public abstract void u();

    public abstract void v();

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            synchronized (this.a) {
                while (this.j) {
                    try {
                        this.a.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final int x(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, bArr)) == null) {
            if (bArr == null) {
                return 0;
            }
            if (vg9.e(this.v)) {
                length = bArr.length;
            } else {
                length = bArr.length;
                for (yd9 yd9Var : this.v) {
                    if (!yd9Var.b()) {
                        yd9Var.a(this.n, this.o, this.p, this.q);
                    }
                    if (yd9Var.a() && bArr != null) {
                        int length2 = bArr.length;
                        yd9Var.a(bArr, length2);
                        bArr = yd9Var.a(length2);
                        length = bArr != null ? bArr.length : 0;
                    }
                }
            }
            if (length > 0) {
                synchronized (this.b) {
                    this.d += this.h.write(bArr, 0, length);
                }
            }
            return length;
        }
        return invokeL.intValue;
    }

    public final void y() throws IOException {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            while (true) {
                boolean z = false;
                if ((this.e.f() || j() >= k() + this.s) && !s()) {
                    break;
                }
                w();
                if (this.k) {
                    break;
                }
                if (s() && this.e.getCurrentPosition() >= this.g) {
                    B(this.f);
                    this.t = false;
                }
                synchronized (this.c) {
                    try {
                        z = this.e.c();
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (this.i != null && !this.l) {
                            this.i.onExceptionThrown(ah9.g(e));
                        }
                    }
                }
                if (z) {
                    byte[] g = this.e.g();
                    int i = this.s;
                    if (i != 0) {
                        if (i > 0) {
                            b();
                        } else {
                            g = d(g);
                        }
                    }
                    C();
                    x(g);
                }
            }
            qg9.j("VideoMuxer: ", "----解码结束-----");
            if (this.l) {
                if (this.i != null) {
                    this.i.onCancel();
                    return;
                }
                return;
            }
            if (!vg9.e(this.v)) {
                for (int i2 = 0; i2 < this.v.size(); i2++) {
                    if (this.v.get(i2).a()) {
                        this.v.get(i2).c();
                        do {
                            byte[] a = this.v.get(i2).a(4096);
                            if (a != null && a.length != 0) {
                                length = a.length;
                                int i3 = length;
                                for (int i4 = i2 + 1; i4 < this.v.size(); i4++) {
                                    if (this.v.get(i4).a()) {
                                        int length2 = a.length;
                                        this.v.get(i4).a(a, length2);
                                        a = this.v.get(i4).a(length2);
                                        i3 = a != null ? a.length : 0;
                                    }
                                }
                                if (i3 > 0) {
                                    synchronized (this.b) {
                                        qg9.j("VideoMuxer: ", "----getLastBuffer-----");
                                        this.d += this.h.write(a, 0, i3);
                                    }
                                    continue;
                                }
                            }
                        } while (length > 0);
                    }
                }
            }
            e();
            if (this.i != null) {
                this.i.onTrackEnd(this.n);
                qg9.j("VideoMuxer: ", "----所有数据输入编码器onTrackEnd-----,bytesWritten:" + this.d);
            }
            this.m = true;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || vg9.e(this.v)) {
            return;
        }
        for (yd9 yd9Var : this.v) {
            if (yd9Var != null) {
                yd9Var.d();
            }
        }
    }
}
