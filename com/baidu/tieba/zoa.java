package com.baidu.tieba;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fqa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class zoa {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public boolean c;
    public Context d;
    public vpa e;
    public yoa f;
    public int g;
    public long h;
    public List<kpa> i;
    public long j;
    public long k;
    public long l;
    public int m;
    public SparseArray<ArrayList> n;
    public HashMap<String, Long> o;
    public rpa p;
    public dpa q;
    public int r;
    public int s;
    public int t;
    public fqa u;
    public boolean v;
    public int w;
    public Runnable x;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zoa a;

        public a(zoa zoaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zoaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zoaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.a.h;
                    if (uptimeMillis >= 5000) {
                        if (zoa.y) {
                            Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                        }
                        this.a.z();
                        this.a.g = 0;
                        return;
                    }
                    apa.w().J(this, 5000 - uptimeMillis);
                } else if (this.a.g != 2) {
                } else {
                    this.a.g = 0;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements qpa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zoa a;

        public b(zoa zoaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zoaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zoaVar;
        }

        @Override // com.baidu.tieba.qpa
        public void a(boolean z, kpa kpaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, kpaVar) == null) {
                if (!z) {
                    this.a.e.z(kpaVar);
                    return;
                }
                this.a.e.h();
                upa.f().a(kpaVar.l(), false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public kpa b;
        public File c;
        public JSONObject d;
        public String e;
        public long f;
        public boolean g;
        public boolean h;
        public qpa i;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = true;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = -1L;
            this.g = false;
            this.h = false;
            this.i = null;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements fqa.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(zoa zoaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zoaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(zoa zoaVar, a aVar) {
            this(zoaVar);
        }

        @Override // com.baidu.tieba.fqa.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                apa.w().P();
                apa.w().K();
            }
        }

        @Override // com.baidu.tieba.fqa.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                apa.w().P();
                apa.w().K();
                apa.w().E();
            }
        }

        @Override // com.baidu.tieba.fqa.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                apa.w().K();
            }
        }

        @Override // com.baidu.tieba.fqa.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                apa.w().P();
                apa.w().K();
                apa.w().E();
            }
        }

        @Override // com.baidu.tieba.fqa.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                apa.w().P();
                apa.w().K();
                apa.w().E();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948368061, "Lcom/baidu/tieba/zoa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948368061, "Lcom/baidu/tieba/zoa;");
                return;
            }
        }
        y = ypa.m();
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.C();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            G(true);
            G(false);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            try {
                z();
            } catch (RuntimeException unused) {
                if (y) {
                    Log.d("UBCBehaviorModel", "save cache error!");
                }
            }
        }
    }

    public vpa n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.e;
        }
        return (vpa) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.m++;
            hqa.a().d("ubc_real_time_count", this.m);
        }
    }

    public final void z() {
        List<kpa> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (list = this.i) != null && list.size() != 0) {
            this.e.A(this.i);
            this.i.clear();
            if (this.g == 1) {
                this.g = 2;
            }
        }
    }

    public zoa(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = false;
        this.g = 0;
        this.h = 0L;
        this.x = new a(this);
        this.d = context;
        hqa a2 = hqa.a();
        this.e = new vpa(context);
        this.f = new yoa(context);
        this.p = ypa.j();
        this.i = new ArrayList(20);
        this.j = a2.c("ubc_last_upload_non_real", 0L);
        this.k = a2.c("ubc_reset_real_time_count_time", 0L);
        this.l = a2.c("ubc_last_upload_failed_data_time", 0L);
        this.m = a2.b("ubc_real_time_count", 0);
        dpa o = dpa.o();
        this.q = o;
        o.D(this, context);
        this.b = System.currentTimeMillis();
        this.a = new Random().nextInt(31) + 60;
        this.v = dpa.o().I();
        this.w = dpa.o().x();
        upa.f().g(this.e);
        fqa m = fqa.m();
        this.u = m;
        m.n(this.d, this.e, new d(this, null));
    }

    public final void J(iqa iqaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iqaVar) == null) {
            iqaVar.k();
            if (iqaVar.y()) {
                return;
            }
            if (iqaVar.x()) {
                str = iqaVar.p();
            } else {
                try {
                    JSONObject u = iqaVar.u();
                    String c2 = gqa.c(u.toString().getBytes(), true);
                    D(u.toString(), c2);
                    if (y) {
                        xpa.a(iqaVar);
                        Log.d("UBCBehaviorModel", "save send data to file " + c2);
                    }
                    str = c2;
                } catch (OutOfMemoryError unused) {
                    iqaVar.e();
                    return;
                }
            }
            if (!this.e.g(iqaVar, str)) {
                iqaVar.e();
                File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.e.l(str);
                return;
            }
            aqa.a().m(iqaVar.B(), iqaVar.v());
            apa.w().Q(iqaVar, str);
            iqaVar.e();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.l) < 7200000) {
                return;
            }
            this.l = currentTimeMillis;
            hqa.a().e("ubc_last_upload_failed_data_time", this.l);
            apa.w().E();
            apa.w().K();
        }
    }

    public void O(lpa lpaVar) {
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, lpaVar) != null) || lpaVar == null) {
            return;
        }
        String a2 = lpaVar.a();
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", a2);
        if (!file.exists()) {
            return;
        }
        if (lpaVar.c()) {
            apa.w().Q(iqa.g(file, (int) file.length()), a2);
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                if (y) {
                    Log.d("UBCBehaviorModel", "uploadFile fileName:" + a2);
                }
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        } catch (OutOfMemoryError e2) {
            e = e2;
        }
        try {
            if (fileInputStream.available() > 0) {
                inputStream = new Base64InputStream(fileInputStream, 0);
                JSONObject jSONObject = new JSONObject(dra.b(inputStream));
                JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
                jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                jSONObject.put(TtmlNode.TAG_METADATA, jSONObject2);
                apa.w().S(jSONObject, a2);
                fileInputStream = inputStream;
            }
            try {
                fileInputStream.close();
            } catch (IOException e3) {
                e = e3;
                if (!y) {
                    return;
                }
                e.printStackTrace();
            }
        } catch (Exception e4) {
            e = e4;
            inputStream = fileInputStream;
            if (y) {
                Log.d("UBCBehaviorModel", "error:" + e.getMessage());
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e = e5;
                    if (!y) {
                        return;
                    }
                    e.printStackTrace();
                }
            }
        } catch (OutOfMemoryError e6) {
            e = e6;
            inputStream = fileInputStream;
            if (y) {
                Log.d("UBCBehaviorModel", "OutOfMemoryError:" + e.getMessage());
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    e = e7;
                    if (!y) {
                        return;
                    }
                    e.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = fileInputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                    if (y) {
                        e8.printStackTrace();
                    }
                }
            }
            throw th;
        }
    }

    public void t(kpa kpaVar) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, kpaVar) == null) {
            boolean equals = TextUtils.equals(kpaVar.l(), kpaVar.k());
            boolean z3 = false;
            if (this.q.e(kpaVar.l()) && (kpaVar.n() & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            if ((kpaVar.n() & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((equals && z) || (equals && z2)) {
                z3 = true;
            }
            if (ypa.i().isPeakTime()) {
                if (!z3) {
                    this.e.z(kpaVar);
                    return;
                }
                List<String> i = ypa.i().i();
                if (i != null && i.contains(kpaVar.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(kpaVar);
                            return;
                        }
                    }
                } else {
                    this.e.z(kpaVar);
                    return;
                }
            }
            if (z3) {
                this.e.z(kpaVar);
            } else if ((kpaVar.n() & 1) == 0) {
                if (this.q.K(kpaVar.l())) {
                    g(kpaVar);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (this.q.K(kpaVar.l())) {
                this.e.z(kpaVar);
            }
            apa.w().I(kpaVar, z3);
        }
    }

    public void B(kpa kpaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kpaVar) == null) {
            this.f.g(kpaVar, this.q.e(kpaVar.l()));
        }
    }

    public void C(kpa kpaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kpaVar) != null) || !il1.g()) {
            return;
        }
        this.f.i(kpaVar);
    }

    public void I(mpa mpaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mpaVar) == null) {
            this.e.B(mpaVar);
        }
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            dpa dpaVar = this.q;
            if (dpaVar != null) {
                return dpaVar.C(str);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void A(kpa kpaVar) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kpaVar) == null) {
            boolean equals = TextUtils.equals(kpaVar.l(), kpaVar.k());
            if (this.q.e(kpaVar.l()) && (kpaVar.n() & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            if ((kpaVar.n() & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((equals && z) || (equals && z2)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (ypa.i().isPeakTime()) {
                if (!z3) {
                    this.e.z(kpaVar);
                    return;
                }
                List<String> i = ypa.i().i();
                if (i != null && i.contains(kpaVar.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(kpaVar);
                            return;
                        }
                    }
                } else {
                    this.e.z(kpaVar);
                    return;
                }
            }
            if (z3 && !V(kpaVar)) {
                if (this.q.K(kpaVar.l())) {
                    this.e.z(kpaVar);
                    return;
                }
                return;
            }
            if (z3) {
                upa.f().a(kpaVar.l(), false);
            }
            if (ypa.i().isPeakTime()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= dpa.o().t()) {
                if (!z3 && this.q.K(kpaVar.l())) {
                    g(kpaVar);
                }
                U();
            } else if ((kpaVar.n() & 1) == 0) {
                if (!z3 && this.q.K(kpaVar.l())) {
                    g(kpaVar);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (!z3 && this.q.K(kpaVar.l())) {
                this.e.z(kpaVar);
            }
        }
    }

    public final void D(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            String str3 = this.d.getFilesDir() + File.separator + "ubcsenddir";
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(str3, str2);
            if (!file2.exists()) {
                OutputStream outputStream = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    outputStream = new Base64OutputStream(fileOutputStream, 0);
                    outputStream.write(str.getBytes());
                    outputStream.flush();
                    xpa.b("save to file suc");
                    try {
                        outputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        if (!y) {
                            return;
                        }
                        e.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    outputStream = fileOutputStream;
                    if (y) {
                        e.printStackTrace();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e4) {
                            e = e4;
                            if (!y) {
                                return;
                            }
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = fileOutputStream;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e5) {
                            if (y) {
                                e5.printStackTrace();
                            }
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !gqa.a(this.d)) {
            return;
        }
        if (this.n == null) {
            r();
        }
        iqa h = iqa.h(this.d);
        if (upa.f().d(h) && h != null && !h.y()) {
            h.L(true);
            J(h);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            iqa i = iqa.i();
            if (this.f.e(i)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "sendQualityData:" + u.toString());
                }
                apa.w().R(u);
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || !gqa.a(this.d) || !j()) {
            return;
        }
        iqa h = iqa.h(this.d);
        h.L(true);
        if (this.n == null) {
            r();
        }
        if (Y(h, "1")) {
            return;
        }
        T(this.n, h);
        J(h);
        y();
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (ypa.i().isPeakTime()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= dpa.o().t()) {
                U();
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            iqa i = iqa.i();
            i.L(z);
            if (this.f.f(i, z)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "checkFileData:" + u.toString());
                }
                this.f.c(z);
                apa.w().R(u);
            }
        }
    }

    public boolean X(kpa kpaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, kpaVar)) == null) {
            if (!gqa.a(this.d)) {
                return false;
            }
            kpaVar.A("1");
            iqa p = p(kpaVar, true);
            if (p == null || p.y()) {
                return false;
            }
            this.e.u(p);
            apa.w().U(p.u(), true, kpaVar, new b(this));
            p.e();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void K(tpa tpaVar, boolean z, ppa ppaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{tpaVar, Boolean.valueOf(z), ppaVar}) == null) {
            JSONArray jSONArray = new JSONArray();
            this.r = 0;
            this.s = 0;
            this.t = 0;
            k(tpaVar, z, jSONArray);
            s(tpaVar, z, jSONArray);
            if (ppaVar != null && jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("items", jSONArray);
                    int i = this.r + this.s + this.t;
                    jSONObject.put("count", i + "," + this.r + "," + this.t);
                    ppaVar.setUBCConfigStatisticData(jSONObject);
                } catch (JSONException e) {
                    if (y) {
                        e.printStackTrace();
                    }
                }
            }
            this.q.Y(tpaVar.b());
            this.q.P(tpaVar.i() * 86400000);
            this.q.Q(tpaVar.h());
            this.q.R(tpaVar.c());
            this.q.U(tpaVar.f());
            this.q.T(tpaVar.e());
            this.q.S(tpaVar.d());
            this.q.W(tpaVar.j());
            this.q.X(tpaVar.k());
            SparseArray<ArrayList> sparseArray = this.n;
            if (sparseArray == null) {
                this.n = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            HashMap<String, Long> hashMap = this.o;
            if (hashMap == null) {
                this.o = new HashMap<>();
            } else {
                hashMap.clear();
            }
            this.e.x(this.n);
            if (y) {
                Log.d("UBCBehaviorModel", "mIdArray: " + this.n.toString());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt = this.n.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                HashMap<String, Long> hashMap2 = this.o;
                hashMap2.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.V(i2);
            tpaVar.b().clear();
        }
    }

    public void L(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, str, i, str2) == null) {
            this.e.E(str, i, str2);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !gqa.a(this.d)) {
            return;
        }
        iqa h = iqa.h(this.d);
        int p = this.q.p();
        h.L(false);
        if (this.v) {
            h.M(this.w);
            this.e.b(h);
        } else {
            h.M(p);
            this.e.a(h);
        }
        int v = h.v();
        if (v > 0) {
            if (y) {
                Log.d("UBCBehaviorModel", "uploadBackLog size=" + v);
            }
            J(h);
        }
    }

    public final void N(c cVar) {
        boolean a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, cVar) != null) || cVar == null) {
            return;
        }
        if (fqa.m().p() && !gqa.a(this.d)) {
            apa.w().V(cVar.e, false);
            return;
        }
        if (cVar.a) {
            a2 = this.p.b(cVar.c, cVar.f, cVar.g, cVar.h);
        } else {
            a2 = this.p.a(cVar.d, cVar.g, cVar.h);
        }
        qpa qpaVar = cVar.i;
        if (qpaVar != null) {
            qpaVar.a(a2, cVar.b);
        }
        if (TextUtils.isEmpty(cVar.e)) {
            return;
        }
        apa.w().V(cVar.e, a2);
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
            if (y) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
            }
            xpa.b("delete file");
            if (file.exists() && file.delete()) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
                xpa.b("delete file suc");
            }
            this.e.l(str);
        }
    }

    public final boolean V(kpa kpaVar) {
        InterceptResult invokeL;
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, kpaVar)) == null) {
            if (!gqa.a(this.d) || !j()) {
                return false;
            }
            z();
            iqa p = p(kpaVar, false);
            if (p == null || p.y()) {
                return false;
            }
            if ((kpaVar.n() & 128) != 0) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(kpaVar.l());
                sparseArray = new SparseArray<>(1);
                sparseArray.put(0, arrayList);
            } else {
                if (this.n == null) {
                    r();
                }
                if (Y(p, "0")) {
                    return true;
                }
                sparseArray = this.n;
            }
            T(sparseArray, p);
            J(p);
            y();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (y) {
                Log.d("UBCBehaviorModel", "upload file fail:" + str);
            }
            xpa.b("upload file fail");
            this.e.F(str);
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, str) != null) || !gqa.a(this.d) || !j()) {
            return;
        }
        iqa h = iqa.h(this.d);
        h.L(true);
        h.C();
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        this.e.r(arrayList, true, h);
        J(h);
        y();
    }

    public final void g(kpa kpaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, kpaVar) == null) {
            this.i.add(kpaVar);
            int i = this.g;
            if (i == 0) {
                this.h = SystemClock.uptimeMillis();
                apa.w().J(this.x, 5000L);
                this.g = 1;
            } else if (i == 2) {
                this.h = SystemClock.uptimeMillis();
                this.g = 1;
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || !gqa.a(this.d)) {
            return;
        }
        this.e.e();
        iqa h = iqa.h(this.d);
        int p = this.q.p();
        h.M(p);
        h.L(true);
        iqa h2 = iqa.h(this.d);
        h2.M(p);
        h2.L(false);
        this.e.n(h, h2);
        int v = h.v();
        int v2 = h2.v();
        if (y) {
            Log.d("UBCBehaviorModel", "real size = " + v + "   no real  = " + v2);
        }
        if (v > 0) {
            if (h.z()) {
                aqa.a().l("uploadAll", String.valueOf(p), String.valueOf(v));
            }
            J(h);
        }
        if (v2 > 0) {
            if (h2.z()) {
                aqa.a().l("uploadAll", String.valueOf(p), String.valueOf(v2));
            }
            J(h2);
        }
    }

    public void v() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || !gqa.a(this.d)) {
            return;
        }
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (int i = 0; i < listFiles.length; i++) {
                lpa w = this.e.w(listFiles[i].getName());
                if (w != null && TextUtils.equals("1", w.b())) {
                    if (y) {
                        Log.d("UBCBehaviorModel", "processOneFailedData send " + listFiles[i].getAbsolutePath());
                    }
                    xpa.b("processOneFailedData file, send");
                    this.e.G(listFiles[i].getName(), "0");
                    O(w);
                    return;
                }
            }
        }
    }

    public final void T(SparseArray<ArrayList> sparseArray, iqa iqaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048595, this, sparseArray, iqaVar) != null) || sparseArray == null) {
            return;
        }
        boolean H = this.q.H();
        boolean G = this.q.G();
        int m = this.q.m();
        if (H && !G && sparseArray.get(m, null) == null) {
            sparseArray.put(m, new ArrayList(0));
            z = true;
        } else {
            z = false;
        }
        for (int i = 0; i < sparseArray.size() && !iqaVar.d(51200); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (keyAt == 0) {
                if (H && G) {
                    this.e.r(new ArrayList<>(this.q.u()), false, iqaVar);
                } else {
                    this.e.r(sparseArray.valueAt(i), true, iqaVar);
                }
            } else if (this.v) {
                iqaVar.M(this.w);
                if (H && !G && keyAt == m) {
                    ArrayList<String> o = o(sparseArray, keyAt);
                    if (o != null) {
                        this.e.t(o, false, iqaVar);
                    }
                } else {
                    this.e.t(sparseArray.valueAt(i), true, iqaVar);
                }
            } else if (H && !G && keyAt == m) {
                ArrayList<String> o2 = o(sparseArray, keyAt);
                if (o2 != null) {
                    this.e.r(o2, false, iqaVar);
                }
            } else {
                this.e.r(sparseArray.valueAt(i), true, iqaVar);
            }
            if (iqaVar.w()) {
                break;
            }
        }
        if (z) {
            sparseArray.remove(m);
        }
    }

    public final void U() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || !gqa.a(this.d)) {
            return;
        }
        if (y) {
            Log.d("UBCBehaviorModel", " upload no real data");
        }
        this.j = System.currentTimeMillis();
        hqa.a().e("ubc_last_upload_non_real", this.j);
        i();
        z();
        this.e.e();
        HashSet hashSet = new HashSet();
        if (this.n == null) {
            r();
        }
        iqa h = iqa.h(this.d);
        h.L(false);
        for (int i = 0; i < this.n.size(); i++) {
            int keyAt = this.n.keyAt(i);
            if (keyAt != 0) {
                HashMap<String, Long> hashMap = this.o;
                long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                long j = (long) keyAt;
                long j2 = 60000 * j;
                if (this.v) {
                    j2 = 1000 * j;
                }
                if (longValue == 0 || (longValue + j2) - System.currentTimeMillis() < this.q.t()) {
                    if (this.v) {
                        h.M(this.w);
                        this.e.t(this.n.valueAt(i), true, h);
                    } else {
                        this.e.r(this.n.valueAt(i), true, h);
                    }
                    if (h.w()) {
                        break;
                    }
                    HashMap<String, Long> hashMap2 = this.o;
                    hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                    hashSet.add(Integer.valueOf(keyAt));
                }
            }
        }
        if (h.y()) {
            return;
        }
        boolean H = this.q.H();
        boolean G = this.q.G();
        int m = this.q.m();
        if (H && !G && this.n.get(m, null) == null) {
            this.n.put(m, new ArrayList(0));
            z = true;
        } else {
            z = false;
        }
        if (!this.v) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                int keyAt2 = this.n.keyAt(i2);
                if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                    if (h.d(51200)) {
                        break;
                    }
                    if (H && !G && keyAt2 == m) {
                        ArrayList<String> o = o(this.n, keyAt2);
                        if (o != null) {
                            this.e.r(o, false, h);
                        }
                    } else {
                        this.e.r(this.n.valueAt(i2), true, h);
                    }
                    if (h.w()) {
                        break;
                    }
                }
            }
        }
        if (z) {
            this.n.remove(m);
        }
        if (y) {
            Log.d("UBCBehaviorModel", "UBC non real time:");
        }
        J(h);
    }

    public final boolean Y(iqa iqaVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, iqaVar, str)) == null) {
            if (ypa.i().isPeakTime()) {
                List<String> i = ypa.i().i();
                if (i != null && i.size() != 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(i);
                    if (arrayList.size() == 0) {
                        return true;
                    }
                    this.e.r(arrayList, true, iqaVar);
                    J(iqaVar);
                    y();
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i) == null) {
            z();
            this.e.d(str, i);
            if (!ypa.i().isPeakTime() && Math.abs(System.currentTimeMillis() - this.j) >= dpa.o().t()) {
                if (y) {
                    Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                U();
            }
        }
    }

    public final ArrayList o(SparseArray<ArrayList> sparseArray, int i) {
        InterceptResult invokeLI;
        ArrayList valueAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048609, this, sparseArray, i)) == null) {
            if (sparseArray != null && sparseArray.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    if (sparseArray.keyAt(i2) != i && (valueAt = sparseArray.valueAt(i2)) != null && valueAt.size() != 0) {
                        arrayList.addAll(valueAt);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public final iqa p(kpa kpaVar, boolean z) {
        InterceptResult invokeLZ;
        iqa h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048610, this, kpaVar, z)) == null) {
            if (z) {
                h = iqa.i();
            } else {
                h = iqa.h(this.d);
            }
            if (!h.c(kpaVar, kpaVar.g())) {
                return null;
            }
            h.L(true);
            if ((kpaVar.n() & 128) != 0) {
                h.C();
            }
            if (!TextUtils.isEmpty(kpaVar.h())) {
                h.K("1");
            }
            return h;
        }
        return (iqa) invokeLZ.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (y) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.k) > 86400000) {
                this.m = 0;
                this.k = currentTimeMillis;
                hqa.a().e("ubc_reset_real_time_count_time", this.k);
                hqa.a().d("ubc_real_time_count", this.m);
            }
            if (this.m < 10000) {
                return true;
            }
            if (y) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            int i = this.m;
            if (i == 10000) {
                this.m = i + 1;
                if (!y) {
                    aqa.a().f(String.valueOf(10000));
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || this.n != null) {
            return;
        }
        if (y) {
            Log.d("UBCBehaviorModel", "BehaviorModel initCache");
        }
        SparseArray<ArrayList> sparseArray = new SparseArray<>();
        this.n = sparseArray;
        this.e.x(sparseArray);
        if (y) {
            Log.d("UBCBehaviorModel", "mIdArray: " + this.n.toString());
        }
        this.o = new HashMap<>();
        int i = 0;
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            int keyAt = this.n.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            HashMap<String, Long> hashMap = this.o;
            hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.q.V(i);
    }

    public void k(tpa tpaVar, boolean z, JSONArray jSONArray) {
        JSONObject a2;
        String str;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048605, this, new Object[]{tpaVar, Boolean.valueOf(z), jSONArray}) != null) || (a2 = tpaVar.a()) == null) {
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject = new JSONObject();
                gpa p = this.e.p(next);
                String optString = a2.optString(next, "0");
                if (p == null) {
                    str = "0";
                } else {
                    str = p.j();
                }
                if (Integer.parseInt(str) >= Integer.parseInt(optString)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z && str != null && z2) {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("valid", "2");
                    jSONObject.put("version", optString);
                    jSONArray.put(jSONObject);
                    this.t++;
                } else {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("version", optString);
                    jSONObject.put("valid", "1");
                    if (!this.e.j(next)) {
                        jSONObject.put("valid", "0");
                        this.s++;
                    } else {
                        this.r++;
                    }
                    jSONArray.put(jSONObject);
                }
            } catch (Exception e) {
                if (y) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void l(String str, int i, int i2, long j, JSONArray jSONArray) {
        List<String> i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), jSONArray}) == null) {
            z();
            this.e.m(str, i, j, jSONArray);
            if ((i2 & 128) != 0) {
                R(str);
                return;
            }
            boolean e = this.q.e(str);
            if (ypa.i().isPeakTime()) {
                if (e && (i3 = ypa.i().i()) != null && i3.contains(str)) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 < this.a) {
                            return;
                        }
                        this.c = true;
                    }
                } else {
                    return;
                }
            }
            if (e) {
                if (y) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
                }
                W();
            }
            if (!ypa.i().isPeakTime() && Math.abs(System.currentTimeMillis() - this.j) >= dpa.o().t()) {
                if (y) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                U();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(tpa tpaVar, boolean z, JSONArray jSONArray) {
        List<gpa> b2;
        HashMap<String, String> hashMap;
        ArrayList arrayList;
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject;
        String optString;
        String j;
        JSONObject jSONObject2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{tpaVar, Boolean.valueOf(z), jSONArray}) == null) && (b2 = tpaVar.b()) != null && b2.size() != 0) {
            ArrayList arrayList2 = new ArrayList(b2);
            String str5 = "Json格式转化失败";
            String str6 = "1";
            String str7 = "UBCBehaviorModel";
            if (this.e.q() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((gpa) it.next()).c());
                }
                HashMap<String, String> o = this.e.o(arrayList3);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    gpa gpaVar = (gpa) it2.next();
                    String c2 = gpaVar.c();
                    String str8 = o.get(c2);
                    if (!TextUtils.isEmpty(str8)) {
                        try {
                            jSONObject = new JSONObject(str8);
                            optString = jSONObject.optString("version");
                            hashMap = o;
                            try {
                                j = gpaVar.j();
                                arrayList = arrayList2;
                            } catch (NumberFormatException unused) {
                                arrayList = arrayList2;
                                str2 = str5;
                                str3 = str7;
                                if (y) {
                                    Log.d(str3, "数据转换失败");
                                }
                                str5 = str2;
                                str7 = str3;
                                o = hashMap;
                                arrayList2 = arrayList;
                            } catch (JSONException unused2) {
                                arrayList = arrayList2;
                                str = str5;
                                str4 = str7;
                                if (y) {
                                    str2 = str;
                                    str3 = str4;
                                    Log.d(str3, str2);
                                    str5 = str2;
                                    str7 = str3;
                                    o = hashMap;
                                    arrayList2 = arrayList;
                                }
                                str2 = str;
                                str3 = str4;
                                str5 = str2;
                                str7 = str3;
                                o = hashMap;
                                arrayList2 = arrayList;
                            }
                        } catch (NumberFormatException unused3) {
                            hashMap = o;
                        } catch (JSONException unused4) {
                            hashMap = o;
                        }
                        try {
                            jSONObject2 = new JSONObject();
                            str = str5;
                            try {
                                str4 = str7;
                            } catch (NumberFormatException unused5) {
                                str3 = str7;
                                str2 = str;
                            } catch (JSONException unused6) {
                                str4 = str7;
                                if (y) {
                                }
                                str2 = str;
                                str3 = str4;
                                str5 = str2;
                                str7 = str3;
                                o = hashMap;
                                arrayList2 = arrayList;
                            }
                        } catch (NumberFormatException unused7) {
                            str2 = str5;
                            str3 = str7;
                            if (y) {
                            }
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        } catch (JSONException unused8) {
                            str = str5;
                            str4 = str7;
                            if (y) {
                            }
                            str2 = str;
                            str3 = str4;
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        }
                        try {
                            if (Integer.parseInt(optString) >= Integer.parseInt(j)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } catch (NumberFormatException unused9) {
                            str2 = str;
                            str3 = str4;
                            if (y) {
                            }
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        } catch (JSONException unused10) {
                            if (y) {
                            }
                            str2 = str;
                            str3 = str4;
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        }
                        if (z && optString != null && j != null && z2) {
                            it2.remove();
                            jSONObject2.put("product", "set/" + c2);
                            jSONObject2.put("valid", "2");
                            jSONObject2.put("version", j);
                            jSONArray.put(jSONObject2);
                            this.t++;
                            o = hashMap;
                            arrayList2 = arrayList;
                            str5 = str;
                            str7 = str4;
                        } else {
                            if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && gpaVar.l()) {
                                it2.remove();
                            }
                            str2 = str;
                            str3 = str4;
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        }
                    }
                }
            }
            ArrayList arrayList4 = arrayList2;
            String str9 = str5;
            String str10 = str7;
            boolean D = this.e.D(arrayList4);
            int size = arrayList4.size();
            if (D) {
                this.r += size;
            } else {
                this.s += size;
                str6 = "0";
            }
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                gpa gpaVar2 = (gpa) it3.next();
                JSONObject jSONObject3 = new JSONObject();
                String c3 = gpaVar2.c();
                String j2 = gpaVar2.j();
                try {
                    jSONObject3.put("product", "set/" + c3);
                    jSONObject3.put("version", j2);
                    jSONObject3.put("valid", str6);
                } catch (JSONException unused11) {
                    if (y) {
                        Log.d(str10, str9);
                    }
                }
                jSONArray.put(jSONObject3);
            }
            tpaVar.m(arrayList4);
        }
    }

    public void u() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || !gqa.a(this.d)) {
            return;
        }
        if (dpa.o().M() && System.currentTimeMillis() < dpa.o().v()) {
            return;
        }
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length > 1000) {
                if (!y) {
                    aqa.a().d(String.valueOf(1000), listFiles.length);
                }
                for (File file2 : listFiles) {
                    file2.delete();
                }
                this.e.i();
            }
            for (int i = 0; i < listFiles.length; i++) {
                if (y) {
                    Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                }
                lpa w = this.e.w(listFiles[i].getName());
                if (w != null && TextUtils.equals("0", w.b())) {
                    if (y) {
                        Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                    }
                    xpa.b("processFailedData file, no need to send");
                } else if (w != null && TextUtils.equals("1", w.b())) {
                    xpa.b("processFailedData file, send");
                    this.e.G(listFiles[i].getName(), "0");
                    O(w);
                } else {
                    if (y) {
                        Log.d("UBCBehaviorModel", "processFailedData data in db");
                    }
                    xpa.b("processFailedData file, data in db, delete file");
                    listFiles[i].delete();
                }
            }
        }
    }

    public void w(kpa kpaVar, boolean z) {
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048617, this, kpaVar, z) == null) {
            if (z) {
                if (!gqa.a(this.d) || !j()) {
                    return;
                }
                z();
                iqa h = iqa.h(this.d);
                h.L(true);
                if ((kpaVar.n() & 128) != 0) {
                    h.C();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(kpaVar.l());
                    sparseArray = new SparseArray<>(1);
                    sparseArray.put(0, arrayList);
                } else {
                    if (this.n == null) {
                        r();
                    }
                    if (Y(h, "0")) {
                        return;
                    }
                    sparseArray = this.n;
                }
                T(sparseArray, h);
                if (h.y()) {
                    return;
                }
                J(h);
                y();
            }
            x();
        }
    }
}
