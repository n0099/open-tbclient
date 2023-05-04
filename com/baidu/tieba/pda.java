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
import com.baidu.tieba.vea;
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
/* loaded from: classes5.dex */
public class pda {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public boolean c;
    public Context d;
    public lea e;
    public oda f;
    public int g;
    public long h;
    public List<aea> i;
    public long j;
    public long k;
    public long l;
    public int m;
    public SparseArray<ArrayList> n;
    public HashMap<String, Long> o;
    public hea p;
    public tda q;
    public int r;
    public int s;
    public int t;
    public vea u;
    public boolean v;
    public int w;
    public Runnable x;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pda a;

        public a(pda pdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pdaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.a.h;
                    if (uptimeMillis >= 5000) {
                        if (pda.y) {
                            Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                        }
                        this.a.z();
                        this.a.g = 0;
                        return;
                    }
                    qda.w().J(this, 5000 - uptimeMillis);
                } else if (this.a.g != 2) {
                } else {
                    this.a.g = 0;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements gea {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pda a;

        public b(pda pdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pdaVar;
        }

        @Override // com.baidu.tieba.gea
        public void a(boolean z, aea aeaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, aeaVar) == null) {
                if (!z) {
                    this.a.e.z(aeaVar);
                    return;
                }
                this.a.e.h();
                kea.f().a(aeaVar.l(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public aea b;
        public File c;
        public JSONObject d;
        public String e;
        public long f;
        public boolean g;
        public boolean h;
        public gea i;

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

    /* loaded from: classes5.dex */
    public class d implements vea.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(pda pdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(pda pdaVar, a aVar) {
            this(pdaVar);
        }

        @Override // com.baidu.tieba.vea.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qda.w().P();
                qda.w().K();
            }
        }

        @Override // com.baidu.tieba.vea.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                qda.w().P();
                qda.w().K();
                qda.w().E();
            }
        }

        @Override // com.baidu.tieba.vea.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                qda.w().K();
            }
        }

        @Override // com.baidu.tieba.vea.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                qda.w().P();
                qda.w().K();
                qda.w().E();
            }
        }

        @Override // com.baidu.tieba.vea.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                qda.w().P();
                qda.w().K();
                qda.w().E();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948059580, "Lcom/baidu/tieba/pda;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948059580, "Lcom/baidu/tieba/pda;");
                return;
            }
        }
        y = oea.m();
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

    public lea n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.e;
        }
        return (lea) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.m++;
            xea.a().d("ubc_real_time_count", this.m);
        }
    }

    public final void z() {
        List<aea> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (list = this.i) != null && list.size() != 0) {
            this.e.A(this.i);
            this.i.clear();
            if (this.g == 1) {
                this.g = 2;
            }
        }
    }

    public pda(Context context) {
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
        xea a2 = xea.a();
        this.e = new lea(context);
        this.f = new oda(context);
        this.p = oea.j();
        this.i = new ArrayList(20);
        this.j = a2.c("ubc_last_upload_non_real", 0L);
        this.k = a2.c("ubc_reset_real_time_count_time", 0L);
        this.l = a2.c("ubc_last_upload_failed_data_time", 0L);
        this.m = a2.b("ubc_real_time_count", 0);
        tda o = tda.o();
        this.q = o;
        o.D(this, context);
        this.b = System.currentTimeMillis();
        this.a = new Random().nextInt(31) + 60;
        this.v = tda.o().I();
        this.w = tda.o().x();
        kea.f().g(this.e);
        vea m = vea.m();
        this.u = m;
        m.n(this.d, this.e, new d(this, null));
    }

    public final void J(yea yeaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yeaVar) == null) {
            yeaVar.k();
            if (yeaVar.y()) {
                return;
            }
            if (yeaVar.x()) {
                str = yeaVar.p();
            } else {
                try {
                    JSONObject u = yeaVar.u();
                    String c2 = wea.c(u.toString().getBytes(), true);
                    D(u.toString(), c2);
                    if (y) {
                        nea.a(yeaVar);
                        Log.d("UBCBehaviorModel", "save send data to file " + c2);
                    }
                    str = c2;
                } catch (OutOfMemoryError unused) {
                    yeaVar.e();
                    return;
                }
            }
            if (!this.e.g(yeaVar, str)) {
                yeaVar.e();
                File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.e.l(str);
                return;
            }
            qea.a().m(yeaVar.B(), yeaVar.v());
            qda.w().Q(yeaVar, str);
            yeaVar.e();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.l) < 7200000) {
                return;
            }
            this.l = currentTimeMillis;
            xea.a().e("ubc_last_upload_failed_data_time", this.l);
            qda.w().E();
            qda.w().K();
        }
    }

    public void O(bea beaVar) {
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, beaVar) != null) || beaVar == null) {
            return;
        }
        String a2 = beaVar.a();
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", a2);
        if (!file.exists()) {
            return;
        }
        if (beaVar.c()) {
            qda.w().Q(yea.g(file, (int) file.length()), a2);
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
                JSONObject jSONObject = new JSONObject(tfa.b(inputStream));
                JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
                jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                jSONObject.put(TtmlNode.TAG_METADATA, jSONObject2);
                qda.w().S(jSONObject, a2);
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

    public void t(aea aeaVar) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, aeaVar) == null) {
            boolean equals = TextUtils.equals(aeaVar.l(), aeaVar.k());
            boolean z3 = false;
            if (this.q.e(aeaVar.l()) && (aeaVar.n() & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            if ((aeaVar.n() & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((equals && z) || (equals && z2)) {
                z3 = true;
            }
            if (oea.i().isPeakTime()) {
                if (!z3) {
                    this.e.z(aeaVar);
                    return;
                }
                List<String> i = oea.i().i();
                if (i != null && i.contains(aeaVar.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(aeaVar);
                            return;
                        }
                    }
                } else {
                    this.e.z(aeaVar);
                    return;
                }
            }
            if (z3) {
                this.e.z(aeaVar);
            } else if ((aeaVar.n() & 1) == 0) {
                if (this.q.K(aeaVar.l())) {
                    g(aeaVar);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (this.q.K(aeaVar.l())) {
                this.e.z(aeaVar);
            }
            qda.w().I(aeaVar, z3);
        }
    }

    public void B(aea aeaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aeaVar) == null) {
            this.f.g(aeaVar, this.q.e(aeaVar.l()));
        }
    }

    public void C(aea aeaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aeaVar) != null) || !ij1.g()) {
            return;
        }
        this.f.i(aeaVar);
    }

    public void I(cea ceaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ceaVar) == null) {
            this.e.B(ceaVar);
        }
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            tda tdaVar = this.q;
            if (tdaVar != null) {
                return tdaVar.C(str);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void A(aea aeaVar) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aeaVar) == null) {
            boolean equals = TextUtils.equals(aeaVar.l(), aeaVar.k());
            if (this.q.e(aeaVar.l()) && (aeaVar.n() & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            if ((aeaVar.n() & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((equals && z) || (equals && z2)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (oea.i().isPeakTime()) {
                if (!z3) {
                    this.e.z(aeaVar);
                    return;
                }
                List<String> i = oea.i().i();
                if (i != null && i.contains(aeaVar.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(aeaVar);
                            return;
                        }
                    }
                } else {
                    this.e.z(aeaVar);
                    return;
                }
            }
            if (z3 && !V(aeaVar)) {
                if (this.q.K(aeaVar.l())) {
                    this.e.z(aeaVar);
                    return;
                }
                return;
            }
            if (z3) {
                kea.f().a(aeaVar.l(), false);
            }
            if (oea.i().isPeakTime()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= tda.o().t()) {
                if (!z3 && this.q.K(aeaVar.l())) {
                    g(aeaVar);
                }
                U();
            } else if ((aeaVar.n() & 1) == 0) {
                if (!z3 && this.q.K(aeaVar.l())) {
                    g(aeaVar);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (!z3 && this.q.K(aeaVar.l())) {
                this.e.z(aeaVar);
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
                    nea.b("save to file suc");
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
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !wea.a(this.d)) {
            return;
        }
        if (this.n == null) {
            r();
        }
        yea h = yea.h(this.d);
        if (kea.f().d(h) && h != null && !h.y()) {
            h.L(true);
            J(h);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            yea i = yea.i();
            if (this.f.e(i)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "sendQualityData:" + u.toString());
                }
                qda.w().R(u);
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || !wea.a(this.d) || !j()) {
            return;
        }
        yea h = yea.h(this.d);
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
            if (oea.i().isPeakTime()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= tda.o().t()) {
                U();
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            yea i = yea.i();
            i.L(z);
            if (this.f.f(i, z)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "checkFileData:" + u.toString());
                }
                this.f.c(z);
                qda.w().R(u);
            }
        }
    }

    public boolean X(aea aeaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, aeaVar)) == null) {
            if (!wea.a(this.d)) {
                return false;
            }
            aeaVar.A("1");
            yea p = p(aeaVar, true);
            if (p == null || p.y()) {
                return false;
            }
            this.e.u(p);
            qda.w().U(p.u(), true, aeaVar, new b(this));
            p.e();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void K(jea jeaVar, boolean z, fea feaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{jeaVar, Boolean.valueOf(z), feaVar}) == null) {
            JSONArray jSONArray = new JSONArray();
            this.r = 0;
            this.s = 0;
            this.t = 0;
            k(jeaVar, z, jSONArray);
            s(jeaVar, z, jSONArray);
            if (feaVar != null && jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("items", jSONArray);
                    int i = this.r + this.s + this.t;
                    jSONObject.put("count", i + "," + this.r + "," + this.t);
                    feaVar.setUBCConfigStatisticData(jSONObject);
                } catch (JSONException e) {
                    if (y) {
                        e.printStackTrace();
                    }
                }
            }
            this.q.Y(jeaVar.b());
            this.q.P(jeaVar.i() * 86400000);
            this.q.Q(jeaVar.h());
            this.q.R(jeaVar.c());
            this.q.U(jeaVar.f());
            this.q.T(jeaVar.e());
            this.q.S(jeaVar.d());
            this.q.W(jeaVar.j());
            this.q.X(jeaVar.k());
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
            jeaVar.b().clear();
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
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !wea.a(this.d)) {
            return;
        }
        yea h = yea.h(this.d);
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
        if (vea.m().p() && !wea.a(this.d)) {
            qda.w().V(cVar.e, false);
            return;
        }
        if (cVar.a) {
            a2 = this.p.b(cVar.c, cVar.f, cVar.g, cVar.h);
        } else {
            a2 = this.p.a(cVar.d, cVar.g, cVar.h);
        }
        gea geaVar = cVar.i;
        if (geaVar != null) {
            geaVar.a(a2, cVar.b);
        }
        if (TextUtils.isEmpty(cVar.e)) {
            return;
        }
        qda.w().V(cVar.e, a2);
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
            if (y) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
            }
            nea.b("delete file");
            if (file.exists() && file.delete()) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
                nea.b("delete file suc");
            }
            this.e.l(str);
        }
    }

    public final boolean V(aea aeaVar) {
        InterceptResult invokeL;
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, aeaVar)) == null) {
            if (!wea.a(this.d) || !j()) {
                return false;
            }
            z();
            yea p = p(aeaVar, false);
            if (p == null || p.y()) {
                return false;
            }
            if ((aeaVar.n() & 128) != 0) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(aeaVar.l());
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
            nea.b("upload file fail");
            this.e.F(str);
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, str) != null) || !wea.a(this.d) || !j()) {
            return;
        }
        yea h = yea.h(this.d);
        h.L(true);
        h.C();
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        this.e.r(arrayList, true, h);
        J(h);
        y();
    }

    public final void g(aea aeaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, aeaVar) == null) {
            this.i.add(aeaVar);
            int i = this.g;
            if (i == 0) {
                this.h = SystemClock.uptimeMillis();
                qda.w().J(this.x, 5000L);
                this.g = 1;
            } else if (i == 2) {
                this.h = SystemClock.uptimeMillis();
                this.g = 1;
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || !wea.a(this.d)) {
            return;
        }
        this.e.e();
        yea h = yea.h(this.d);
        int p = this.q.p();
        h.M(p);
        h.L(true);
        yea h2 = yea.h(this.d);
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
                qea.a().l("uploadAll", String.valueOf(p), String.valueOf(v));
            }
            J(h);
        }
        if (v2 > 0) {
            if (h2.z()) {
                qea.a().l("uploadAll", String.valueOf(p), String.valueOf(v2));
            }
            J(h2);
        }
    }

    public void v() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || !wea.a(this.d)) {
            return;
        }
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (int i = 0; i < listFiles.length; i++) {
                bea w = this.e.w(listFiles[i].getName());
                if (w != null && TextUtils.equals("1", w.b())) {
                    if (y) {
                        Log.d("UBCBehaviorModel", "processOneFailedData send " + listFiles[i].getAbsolutePath());
                    }
                    nea.b("processOneFailedData file, send");
                    this.e.G(listFiles[i].getName(), "0");
                    O(w);
                    return;
                }
            }
        }
    }

    public final void T(SparseArray<ArrayList> sparseArray, yea yeaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048595, this, sparseArray, yeaVar) != null) || sparseArray == null) {
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
        for (int i = 0; i < sparseArray.size() && !yeaVar.d(51200); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (keyAt == 0) {
                if (H && G) {
                    this.e.r(new ArrayList<>(this.q.u()), false, yeaVar);
                } else {
                    this.e.r(sparseArray.valueAt(i), true, yeaVar);
                }
            } else if (this.v) {
                yeaVar.M(this.w);
                if (H && !G && keyAt == m) {
                    ArrayList<String> o = o(sparseArray, keyAt);
                    if (o != null) {
                        this.e.t(o, false, yeaVar);
                    }
                } else {
                    this.e.t(sparseArray.valueAt(i), true, yeaVar);
                }
            } else if (H && !G && keyAt == m) {
                ArrayList<String> o2 = o(sparseArray, keyAt);
                if (o2 != null) {
                    this.e.r(o2, false, yeaVar);
                }
            } else {
                this.e.r(sparseArray.valueAt(i), true, yeaVar);
            }
            if (yeaVar.w()) {
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
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || !wea.a(this.d)) {
            return;
        }
        if (y) {
            Log.d("UBCBehaviorModel", " upload no real data");
        }
        this.j = System.currentTimeMillis();
        xea.a().e("ubc_last_upload_non_real", this.j);
        i();
        z();
        this.e.e();
        HashSet hashSet = new HashSet();
        if (this.n == null) {
            r();
        }
        yea h = yea.h(this.d);
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

    public final boolean Y(yea yeaVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, yeaVar, str)) == null) {
            if (oea.i().isPeakTime()) {
                List<String> i = oea.i().i();
                if (i != null && i.size() != 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(i);
                    if (arrayList.size() == 0) {
                        return true;
                    }
                    this.e.r(arrayList, true, yeaVar);
                    J(yeaVar);
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
            if (!oea.i().isPeakTime() && Math.abs(System.currentTimeMillis() - this.j) >= tda.o().t()) {
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

    public final yea p(aea aeaVar, boolean z) {
        InterceptResult invokeLZ;
        yea h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048610, this, aeaVar, z)) == null) {
            if (z) {
                h = yea.i();
            } else {
                h = yea.h(this.d);
            }
            if (!h.c(aeaVar, aeaVar.g())) {
                return null;
            }
            h.L(true);
            if ((aeaVar.n() & 128) != 0) {
                h.C();
            }
            if (!TextUtils.isEmpty(aeaVar.h())) {
                h.K("1");
            }
            return h;
        }
        return (yea) invokeLZ.objValue;
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
                xea.a().e("ubc_reset_real_time_count_time", this.k);
                xea.a().d("ubc_real_time_count", this.m);
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
                    qea.a().f(String.valueOf(10000));
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

    public void k(jea jeaVar, boolean z, JSONArray jSONArray) {
        JSONObject a2;
        String str;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048605, this, new Object[]{jeaVar, Boolean.valueOf(z), jSONArray}) != null) || (a2 = jeaVar.a()) == null) {
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject = new JSONObject();
                wda p = this.e.p(next);
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
            if (oea.i().isPeakTime()) {
                if (e && (i3 = oea.i().i()) != null && i3.contains(str)) {
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
            if (!oea.i().isPeakTime() && Math.abs(System.currentTimeMillis() - this.j) >= tda.o().t()) {
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
    public void s(jea jeaVar, boolean z, JSONArray jSONArray) {
        List<wda> b2;
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
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{jeaVar, Boolean.valueOf(z), jSONArray}) == null) && (b2 = jeaVar.b()) != null && b2.size() != 0) {
            ArrayList arrayList2 = new ArrayList(b2);
            String str5 = "Json格式转化失败";
            String str6 = "1";
            String str7 = "UBCBehaviorModel";
            if (this.e.q() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((wda) it.next()).c());
                }
                HashMap<String, String> o = this.e.o(arrayList3);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    wda wdaVar = (wda) it2.next();
                    String c2 = wdaVar.c();
                    String str8 = o.get(c2);
                    if (!TextUtils.isEmpty(str8)) {
                        try {
                            jSONObject = new JSONObject(str8);
                            optString = jSONObject.optString("version");
                            hashMap = o;
                            try {
                                j = wdaVar.j();
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
                            if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && wdaVar.l()) {
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
                wda wdaVar2 = (wda) it3.next();
                JSONObject jSONObject3 = new JSONObject();
                String c3 = wdaVar2.c();
                String j2 = wdaVar2.j();
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
            jeaVar.m(arrayList4);
        }
    }

    public void u() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || !wea.a(this.d)) {
            return;
        }
        if (tda.o().M() && System.currentTimeMillis() < tda.o().v()) {
            return;
        }
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length > 1000) {
                if (!y) {
                    qea.a().d(String.valueOf(1000), listFiles.length);
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
                bea w = this.e.w(listFiles[i].getName());
                if (w != null && TextUtils.equals("0", w.b())) {
                    if (y) {
                        Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                    }
                    nea.b("processFailedData file, no need to send");
                } else if (w != null && TextUtils.equals("1", w.b())) {
                    nea.b("processFailedData file, send");
                    this.e.G(listFiles[i].getName(), "0");
                    O(w);
                } else {
                    if (y) {
                        Log.d("UBCBehaviorModel", "processFailedData data in db");
                    }
                    nea.b("processFailedData file, data in db, delete file");
                    listFiles[i].delete();
                }
            }
        }
    }

    public void w(aea aeaVar, boolean z) {
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048617, this, aeaVar, z) == null) {
            if (z) {
                if (!wea.a(this.d) || !j()) {
                    return;
                }
                z();
                yea h = yea.h(this.d);
                h.L(true);
                if ((aeaVar.n() & 128) != 0) {
                    h.C();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(aeaVar.l());
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
