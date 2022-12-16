package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes6.dex */
public class us2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile us2 r;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecord a;
    public String b;
    public int c;
    public int d;
    public Context e;
    public String f;
    public Timer g;
    public ts2 h;
    public long i;
    public long j;
    public ps2 k;
    public qs2 l;
    public boolean m;
    public TelephonyManager n;
    public ss2 o;
    public boolean p;

    /* loaded from: classes6.dex */
    public class a implements ts2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us2 a;

        public a(us2 us2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us2Var;
        }

        @Override // com.baidu.tieba.ts2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (us2.q) {
                    Log.d("AudioRecorderManager", "record --- timeOut");
                }
                e12.i("recorder", "time out");
                this.a.F();
                this.a.z();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements p3a<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us2 a;

        public b(us2 us2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p3a
        public void call(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bool) != null) || bool.booleanValue()) {
                return;
            }
            this.a.f();
            e12.c("recorder", "record error");
            this.a.z();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements t3a<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us2 a;

        public c(us2 us2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.t3a
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return Boolean.valueOf(this.a.C());
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts2 a;
        public final /* synthetic */ us2 b;

        public d(us2 us2Var, ts2 ts2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us2Var, ts2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = us2Var;
            this.a = ts2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ts2 ts2Var = this.a;
                if (ts2Var != null) {
                    ts2Var.a();
                }
                this.b.G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us2 a;

        public e(us2 us2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h != null) {
                    this.a.h.a();
                }
                this.a.G();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948221493, "Lcom/baidu/tieba/us2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948221493, "Lcom/baidu/tieba/us2;");
                return;
            }
        }
        q = ok1.a;
    }

    public us2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = -1;
        this.k = new ps2();
        this.p = false;
    }

    public static us2 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (r == null) {
                synchronized (us2.class) {
                    if (r == null) {
                        r = new us2();
                    }
                }
            }
            return r;
        }
        return (us2) invokeV.objValue;
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65544, null) != null) || r == null) {
            return;
        }
        r.z();
        r.H();
        r.o();
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            x();
            r = null;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "resume record");
            }
            D(false);
            B();
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] bArr = new byte[this.c];
            ps2 ps2Var = this.k;
            vs2 vs2Var = new vs2(ps2Var.b, ps2Var.c, ps2Var.d, ps2Var.e);
            if (this.a == null) {
                return false;
            }
            return v(bArr, vs2Var);
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "stop timer");
            }
            e12.i("recorder", "stop timer");
            this.h = null;
            Timer timer = this.g;
            if (timer != null) {
                timer.cancel();
                this.g = null;
            }
        }
    }

    public final void H() {
        TelephonyManager telephonyManager;
        ss2 ss2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (telephonyManager = this.n) != null && (ss2Var = this.o) != null) {
            telephonyManager.listen(ss2Var, 0);
            this.n = null;
            this.o = null;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g(2002, "error execute");
        }
    }

    public qs2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.l;
        }
        return (qs2) invokeV.objValue;
    }

    public ps2 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.k;
        }
        return (ps2) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i = this.d;
            if (i == 0 || i == 1) {
                if (!this.p) {
                    this.p = true;
                    e(qs2.i, "recorderInterruptionBegin");
                }
                t();
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.p) {
            this.p = false;
            e(qs2.j, "recorderInterruptionEnd");
        }
    }

    public final void w() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || (context = this.e) == null) {
            return;
        }
        this.n = (TelephonyManager) context.getSystemService("phone");
        ss2 ss2Var = new ss2();
        this.o = ss2Var;
        this.n.listen(ss2Var, 32);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            G();
            this.e = null;
            this.d = -1;
            AudioRecord audioRecord = this.a;
            if (audioRecord != null) {
                audioRecord.release();
                this.a = null;
            }
        }
    }

    public static void r(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65543, null, z) != null) || r == null) {
            return;
        }
        r.s(z);
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (!this.m) {
                return false;
            }
            if (!TextUtils.equals(str, "/swanAPI/recorder/start") && !TextUtils.equals(str, "/swanAPI/recorder/resume")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (z && this.d == 1) {
                t();
            }
            this.m = z;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "resume timer");
            }
            e12.i("recorder", "resume timer");
            ts2 ts2Var = this.h;
            if (ts2Var != null) {
                if (this.j <= 0) {
                    ts2Var.a();
                    return;
                }
                Timer timer = new Timer();
                this.g = timer;
                timer.schedule(new e(this), this.j);
                this.i = System.currentTimeMillis();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "stop record");
            }
            AudioRecord audioRecord = this.a;
            if (audioRecord == null) {
                f();
                e12.c("recorder", "none audioRecord");
                z();
                return;
            }
            try {
                audioRecord.stop();
                G();
                this.d = 3;
                h();
                H();
            } catch (IllegalStateException e2) {
                f();
                e12.d("recorder", "stop error", e2);
                z();
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "pause record");
            }
            AudioRecord audioRecord = this.a;
            if (audioRecord == null) {
                f();
                e12.c("recorder", "none audio record");
                z();
                return;
            }
            try {
                audioRecord.stop();
                this.d = 2;
                u();
                e(qs2.e, "recorderPause");
            } catch (IllegalStateException e2) {
                f();
                e12.d("recorder", "pause error", e2);
                z();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.j);
            }
            e12.i("recorder", "pause timer, lastTime:" + this.j);
            Timer timer = this.g;
            if (timer != null) {
                timer.cancel();
                this.g = null;
            }
            this.j = this.k.a - (System.currentTimeMillis() - this.i);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (this.e == null) {
                f();
                e12.c("recorder", "start error, context is null");
                z();
            } else if (this.d != -1 && !TextUtils.isEmpty(this.b)) {
                if (z) {
                    String str = null;
                    int i = this.d;
                    if (i == 1) {
                        str = "start fail: recorder is recording";
                    } else if (i != 0 && i != 3) {
                        str = "start fail: recorder is paused";
                    }
                    if (str != null) {
                        g(2003, str);
                        e12.c("recorder", str);
                        return;
                    }
                }
                if (q) {
                    Log.d("AudioRecorderManager", "start record");
                }
                try {
                    this.a.startRecording();
                    if (this.a.getRecordingState() != 3) {
                        f();
                        e12.c("recorder", "start error, no real permission");
                        z();
                        return;
                    }
                    if (z) {
                        E(new a(this));
                        e(qs2.d, "recorderStart");
                    } else {
                        e(qs2.f, "recorderResume");
                    }
                    b3a.f("").y(Schedulers.io()).h(new c(this)).k(l3a.b()).w(new b(this));
                } catch (IllegalStateException e2) {
                    f();
                    e12.d("recorder", "can't start", e2);
                    z();
                }
            } else {
                f();
                e12.c("recorder", "start error, wrong state");
                z();
            }
        }
    }

    public void E(ts2 ts2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ts2Var) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "start timer:" + this.k.a);
            }
            e12.i("recorder", "start timer, totalTime:" + this.k.a);
            this.h = ts2Var;
            Timer timer = new Timer();
            this.g = timer;
            timer.schedule(new d(this, ts2Var), this.k.a);
            this.i = System.currentTimeMillis();
        }
    }

    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
            }
            if (this.l != null && !TextUtils.isEmpty(str)) {
                this.l.b(str);
                return;
            }
            rp2.U().u(new fe2(str2));
        }
    }

    public final void g(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            if (this.l != null && !TextUtils.isEmpty(qs2.h)) {
                this.l.d(i, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, i);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                rp2.U().u(new fe2("recorderError", hashMap));
            } catch (JSONException e2) {
                e12.d("recorder", "json error", e2);
                z();
            }
        }
    }

    public final void h() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String J = mb3.J(this.b, this.f);
            long j2 = -1;
            if (!TextUtils.isEmpty(this.b)) {
                j2 = ik4.u(this.b);
                j = new File(this.b).length();
            } else {
                j = -1;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(J)) {
                    jSONObject.put("tempFilePath", J);
                }
                if (j2 >= 0) {
                    jSONObject.put("duration", j2);
                }
                if (j >= 0) {
                    jSONObject.put("fileSize", j);
                }
                if (this.l != null && !TextUtils.isEmpty(qs2.g)) {
                    this.l.c(qs2.g, jSONObject);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                rp2.U().u(new fe2("recorderStop", hashMap));
            } catch (JSONException e2) {
                f();
                e12.d("recorder", "json error", e2);
                z();
            }
        }
    }

    public void l(String str, ps2 ps2Var, Context context, qs2 qs2Var, String str2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048590, this, str, ps2Var, context, qs2Var, str2) == null) {
            int i2 = this.d;
            if (i2 != -1 && i2 != 3) {
                e12.c("recorder", "wrong state, can't init");
                return;
            }
            this.k = ps2Var;
            m(str);
            this.l = qs2Var;
            int minBufferSize = AudioRecord.getMinBufferSize(ps2Var.d, ps2Var.c, 2);
            this.c = minBufferSize;
            if (minBufferSize <= 0) {
                f();
                e12.c("recorder", "wrong buffer size");
                z();
                return;
            }
            if (ps2Var.c == 1) {
                i = 16;
            } else {
                i = 12;
            }
            this.a = new AudioRecord(ps2Var.f, ps2Var.d, i, 2, this.c);
            this.d = 0;
            this.e = context;
            this.f = str2;
            w();
        }
    }

    public final void m(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (TextUtils.equals(this.k.b, "mp3")) {
                str2 = ".mp3";
            } else if (TextUtils.equals(this.k.b, "pcm")) {
                str2 = ".pcm";
            } else {
                str2 = DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
            }
            this.b = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
        }
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
                if (this.d != 1) {
                    str2 = "pause fail: recorder is not recording";
                }
                str2 = null;
            } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
                if (this.d != 2) {
                    str2 = "resume fail: recorder is not paused";
                }
                str2 = null;
            } else {
                if (TextUtils.equals(str, "/swanAPI/recorder/stop") && (i = this.d) != 2 && i != 1) {
                    str2 = "stop fail: recorder is not started";
                }
                str2 = null;
            }
            if (str2 == null) {
                return true;
            }
            g(2003, str2);
            e12.c("recorder", str2);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean v(byte[] bArr, vs2 vs2Var) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        byte[] f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, bArr, vs2Var)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    File file = new File(this.b);
                    if (this.d == 0) {
                        if (file.exists()) {
                            file.delete();
                        }
                        ik4.h(file);
                    }
                    fileOutputStream = new FileOutputStream(file, true);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.d = 1;
                while (this.d == 1) {
                    if (this.a.read(bArr, 0, this.c) >= 0) {
                        if (TextUtils.equals(this.k.b, "pcm")) {
                            f = bArr;
                        } else {
                            f = vs2Var.f(bArr);
                        }
                        if (f != null && f.length > 0) {
                            fileOutputStream.write(f);
                        }
                    }
                }
                ik4.d(fileOutputStream);
                return true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e12.d("recorder", "save record error", e);
                if (this.d == 1) {
                    this.d = 3;
                }
                ik4.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                ik4.d(fileOutputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }
}
