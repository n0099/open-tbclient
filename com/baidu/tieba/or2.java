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
/* loaded from: classes5.dex */
public class or2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile or2 r;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecord a;
    public String b;
    public int c;
    public int d;
    public Context e;
    public String f;
    public Timer g;
    public nr2 h;
    public long i;
    public long j;
    public jr2 k;
    public kr2 l;
    public boolean m;
    public TelephonyManager n;
    public mr2 o;
    public boolean p;

    /* loaded from: classes5.dex */
    public class a implements nr2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or2 a;

        public a(or2 or2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or2Var;
        }

        @Override // com.baidu.tieba.nr2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (or2.q) {
                    Log.d("AudioRecorderManager", "record --- timeOut");
                }
                yz1.i("recorder", "time out");
                this.a.F();
                this.a.z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ex9<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or2 a;

        public b(or2 or2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ex9
        public void call(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool.booleanValue()) {
                return;
            }
            this.a.f();
            yz1.c("recorder", "record error");
            this.a.z();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ix9<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or2 a;

        public c(or2 or2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ix9
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(this.a.C()) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr2 a;
        public final /* synthetic */ or2 b;

        public d(or2 or2Var, nr2 nr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or2Var, nr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = or2Var;
            this.a = nr2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nr2 nr2Var = this.a;
                if (nr2Var != null) {
                    nr2Var.a();
                }
                this.b.G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or2 a;

        public e(or2 or2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948041786, "Lcom/baidu/tieba/or2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948041786, "Lcom/baidu/tieba/or2;");
                return;
            }
        }
        q = ij1.a;
    }

    public or2() {
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
        this.k = new jr2();
        this.p = false;
    }

    public static or2 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (r == null) {
                synchronized (or2.class) {
                    if (r == null) {
                        r = new or2();
                    }
                }
            }
            return r;
        }
        return (or2) invokeV.objValue;
    }

    public static void r(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65543, null, z) == null) || r == null) {
            return;
        }
        r.s(z);
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || r == null) {
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

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "resume timer");
            }
            yz1.i("recorder", "resume timer");
            nr2 nr2Var = this.h;
            if (nr2Var != null) {
                if (this.j <= 0) {
                    nr2Var.a();
                    return;
                }
                Timer timer = new Timer();
                this.g = timer;
                timer.schedule(new e(this), this.j);
                this.i = System.currentTimeMillis();
            }
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] bArr = new byte[this.c];
            jr2 jr2Var = this.k;
            pr2 pr2Var = new pr2(jr2Var.b, jr2Var.c, jr2Var.d, jr2Var.e);
            if (this.a == null) {
                return false;
            }
            return v(bArr, pr2Var);
        }
        return invokeV.booleanValue;
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (this.e == null) {
                f();
                yz1.c("recorder", "start error, context is null");
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
                        yz1.c("recorder", str);
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
                        yz1.c("recorder", "start error, no real permission");
                        z();
                        return;
                    }
                    if (z) {
                        E(new a(this));
                        e(kr2.d, "recorderStart");
                    } else {
                        e(kr2.f, "recorderResume");
                    }
                    qw9.f("").y(Schedulers.io()).h(new c(this)).k(ax9.b()).w(new b(this));
                } catch (IllegalStateException e2) {
                    f();
                    yz1.d("recorder", "can't start", e2);
                    z();
                }
            } else {
                f();
                yz1.c("recorder", "start error, wrong state");
                z();
            }
        }
    }

    public void E(nr2 nr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nr2Var) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "start timer:" + this.k.a);
            }
            yz1.i("recorder", "start timer, totalTime:" + this.k.a);
            this.h = nr2Var;
            Timer timer = new Timer();
            this.g = timer;
            timer.schedule(new d(this, nr2Var), this.k.a);
            this.i = System.currentTimeMillis();
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
                yz1.c("recorder", "none audioRecord");
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
                yz1.d("recorder", "stop error", e2);
                z();
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "stop timer");
            }
            yz1.i("recorder", "stop timer");
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
        mr2 mr2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (telephonyManager = this.n) == null || (mr2Var = this.o) == null) {
            return;
        }
        telephonyManager.listen(mr2Var, 0);
        this.n = null;
        this.o = null;
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
            lo2.U().u(new zc2(str2));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g(2002, "error execute");
        }
    }

    public final void g(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            if (this.l != null && !TextUtils.isEmpty(kr2.h)) {
                this.l.d(i, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, i);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                lo2.U().u(new zc2("recorderError", hashMap));
            } catch (JSONException e2) {
                yz1.d("recorder", "json error", e2);
                z();
            }
        }
    }

    public final void h() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String J = ga3.J(this.b, this.f);
            long j2 = -1;
            if (TextUtils.isEmpty(this.b)) {
                j = -1;
            } else {
                j2 = cj4.u(this.b);
                j = new File(this.b).length();
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
                if (this.l != null && !TextUtils.isEmpty(kr2.g)) {
                    this.l.c(kr2.g, jSONObject);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                lo2.U().u(new zc2("recorderStop", hashMap));
            } catch (JSONException e2) {
                f();
                yz1.d("recorder", "json error", e2);
                z();
            }
        }
    }

    public kr2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (kr2) invokeV.objValue;
    }

    public jr2 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (jr2) invokeV.objValue;
    }

    public void l(String str, jr2 jr2Var, Context context, kr2 kr2Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048590, this, str, jr2Var, context, kr2Var, str2) == null) {
            int i = this.d;
            if (i != -1 && i != 3) {
                yz1.c("recorder", "wrong state, can't init");
                return;
            }
            this.k = jr2Var;
            m(str);
            this.l = kr2Var;
            int minBufferSize = AudioRecord.getMinBufferSize(jr2Var.d, jr2Var.c, 2);
            this.c = minBufferSize;
            if (minBufferSize <= 0) {
                f();
                yz1.c("recorder", "wrong buffer size");
                z();
                return;
            }
            this.a = new AudioRecord(jr2Var.f, jr2Var.d, jr2Var.c == 1 ? 16 : 12, 2, this.c);
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
            } else {
                str2 = TextUtils.equals(this.k.b, "pcm") ? ".pcm" : DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
            }
            this.b = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i = this.d;
            if (i == 0 || i == 1) {
                if (!this.p) {
                    this.p = true;
                    e(kr2.i, "recorderInterruptionBegin");
                }
                t();
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.p) {
            this.p = false;
            e(kr2.j, "recorderInterruptionEnd");
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
            if (str2 != null) {
                g(2003, str2);
                yz1.c("recorder", str2);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (this.m) {
                return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
            }
            return false;
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

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "pause record");
            }
            AudioRecord audioRecord = this.a;
            if (audioRecord == null) {
                f();
                yz1.c("recorder", "none audio record");
                z();
                return;
            }
            try {
                audioRecord.stop();
                this.d = 2;
                u();
                e(kr2.e, "recorderPause");
            } catch (IllegalStateException e2) {
                f();
                yz1.d("recorder", "pause error", e2);
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
            yz1.i("recorder", "pause timer, lastTime:" + this.j);
            Timer timer = this.g;
            if (timer != null) {
                timer.cancel();
                this.g = null;
            }
            this.j = this.k.a - (System.currentTimeMillis() - this.i);
        }
    }

    public final boolean v(byte[] bArr, pr2 pr2Var) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, bArr, pr2Var)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    File file = new File(this.b);
                    if (this.d == 0) {
                        if (file.exists()) {
                            file.delete();
                        }
                        cj4.h(file);
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
                        byte[] f = TextUtils.equals(this.k.b, "pcm") ? bArr : pr2Var.f(bArr);
                        if (f != null && f.length > 0) {
                            fileOutputStream.write(f);
                        }
                    }
                }
                cj4.d(fileOutputStream);
                return true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                yz1.d("recorder", "save record error", e);
                if (this.d == 1) {
                    this.d = 3;
                }
                cj4.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                cj4.d(fileOutputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void w() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (context = this.e) == null) {
            return;
        }
        this.n = (TelephonyManager) context.getSystemService("phone");
        mr2 mr2Var = new mr2();
        this.o = mr2Var;
        this.n.listen(mr2Var, 32);
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
}
