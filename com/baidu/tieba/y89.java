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
import com.baidu.tieba.ea9;
import com.baidu.tieba.im.model.IMUserListModel;
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
/* loaded from: classes6.dex */
public class y89 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public boolean c;
    public Context d;
    public u99 e;
    public x89 f;
    public int g;
    public long h;
    public List<j99> i;
    public long j;
    public long k;
    public long l;
    public int m;
    public SparseArray<ArrayList> n;
    public HashMap<String, Long> o;
    public q99 p;
    public c99 q;
    public int r;
    public int s;
    public int t;
    public ea9 u;
    public boolean v;
    public int w;
    public Runnable x;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y89 a;

        public a(y89 y89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y89Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.a.h;
                    if (uptimeMillis >= 5000) {
                        if (y89.y) {
                            Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                        }
                        this.a.z();
                        this.a.g = 0;
                        return;
                    }
                    z89.w().J(this, 5000 - uptimeMillis);
                } else if (this.a.g == 2) {
                    this.a.g = 0;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements p99 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y89 a;

        public b(y89 y89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y89Var;
        }

        @Override // com.baidu.tieba.p99
        public void a(boolean z, j99 j99Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, j99Var) == null) {
                if (!z) {
                    this.a.e.z(j99Var);
                    return;
                }
                this.a.e.h();
                t99.f().a(j99Var.l(), false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public j99 b;
        public File c;
        public JSONObject d;
        public String e;
        public long f;
        public boolean g;
        public boolean h;
        public p99 i;

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

    /* loaded from: classes6.dex */
    public class d implements ea9.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(y89 y89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ea9.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z89.w().P();
                z89.w().K();
            }
        }

        @Override // com.baidu.tieba.ea9.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                z89.w().P();
                z89.w().K();
                z89.w().E();
            }
        }

        @Override // com.baidu.tieba.ea9.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                z89.w().K();
            }
        }

        @Override // com.baidu.tieba.ea9.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                z89.w().P();
                z89.w().K();
                z89.w().E();
            }
        }

        @Override // com.baidu.tieba.ea9.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                z89.w().P();
                z89.w().K();
                z89.w().E();
            }
        }

        public /* synthetic */ d(y89 y89Var, a aVar) {
            this(y89Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948284175, "Lcom/baidu/tieba/y89;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948284175, "Lcom/baidu/tieba/y89;");
                return;
            }
        }
        y = x99.m();
    }

    public y89(Context context) {
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
        ga9 a2 = ga9.a();
        this.e = new u99(context);
        this.f = new x89(context);
        this.p = x99.j();
        this.i = new ArrayList(20);
        this.j = a2.c("ubc_last_upload_non_real", 0L);
        this.k = a2.c("ubc_reset_real_time_count_time", 0L);
        this.l = a2.c("ubc_last_upload_failed_data_time", 0L);
        this.m = a2.b("ubc_real_time_count", 0);
        c99 o = c99.o();
        this.q = o;
        o.D(this, context);
        this.b = System.currentTimeMillis();
        this.a = new Random().nextInt(31) + 60;
        this.v = c99.o().I();
        this.w = c99.o().x();
        t99.f().g(this.e);
        ea9 m = ea9.m();
        this.u = m;
        m.n(this.d, this.e, new d(this, null));
    }

    public void A(j99 j99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, j99Var) == null) {
            boolean equals = TextUtils.equals(j99Var.l(), j99Var.k());
            boolean z = (equals && (this.q.e(j99Var.l()) && (j99Var.n() & 64) == 0)) || (equals && ((j99Var.n() & 128) != 0));
            if (x99.i().isPeakTime()) {
                if (!z) {
                    this.e.z(j99Var);
                    return;
                }
                List<String> i = x99.i().i();
                if (i != null && i.contains(j99Var.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(j99Var);
                            return;
                        }
                    }
                } else {
                    this.e.z(j99Var);
                    return;
                }
            }
            if (z && !V(j99Var)) {
                if (this.q.K(j99Var.l())) {
                    this.e.z(j99Var);
                    return;
                }
                return;
            }
            if (z) {
                t99.f().a(j99Var.l(), false);
            }
            if (x99.i().isPeakTime()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= c99.o().t()) {
                if (!z && this.q.K(j99Var.l())) {
                    g(j99Var);
                }
                U();
            } else if ((j99Var.n() & 1) == 0) {
                if (!z && this.q.K(j99Var.l())) {
                    g(j99Var);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (z || !this.q.K(j99Var.l())) {
            } else {
                this.e.z(j99Var);
            }
        }
    }

    public void B(j99 j99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j99Var) == null) {
            this.f.g(j99Var, this.q.e(j99Var.l()));
        }
    }

    public void C(j99 j99Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j99Var) == null) && ue1.g()) {
            this.f.i(j99Var);
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
            if (file2.exists()) {
                return;
            }
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
                w99.b("save to file suc");
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

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && fa9.a(this.d)) {
            if (this.n == null) {
                r();
            }
            ha9 h = ha9.h(this.d);
            if (!t99.f().d(h) || h == null || h.y()) {
                return;
            }
            h.L(true);
            J(h);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ha9 i = ha9.i();
            if (this.f.e(i)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "sendQualityData:" + u.toString());
                }
                z89.w().R(u);
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            ha9 i = ha9.i();
            i.L(z);
            if (this.f.f(i, z)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "checkFileData:" + u.toString());
                }
                this.f.c(z);
                z89.w().R(u);
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.C();
        }
    }

    public void I(l99 l99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l99Var) == null) {
            this.e.B(l99Var);
        }
    }

    public final void J(ha9 ha9Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ha9Var) == null) {
            ha9Var.k();
            if (ha9Var.y()) {
                return;
            }
            if (ha9Var.x()) {
                str = ha9Var.p();
            } else {
                try {
                    JSONObject u = ha9Var.u();
                    String c2 = fa9.c(u.toString().getBytes(), true);
                    D(u.toString(), c2);
                    if (y) {
                        w99.a(ha9Var);
                        Log.d("UBCBehaviorModel", "save send data to file " + c2);
                    }
                    str = c2;
                } catch (OutOfMemoryError unused) {
                    ha9Var.e();
                    return;
                }
            }
            if (!this.e.g(ha9Var, str)) {
                ha9Var.e();
                File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.e.l(str);
                return;
            }
            z99.a().m(ha9Var.B(), ha9Var.v());
            z89.w().Q(ha9Var, str);
            ha9Var.e();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.l) < IMUserListModel.REQUEST_SPACE) {
                return;
            }
            this.l = currentTimeMillis;
            ga9.a().e("ubc_last_upload_failed_data_time", this.l);
            z89.w().E();
            z89.w().K();
        }
    }

    public void K(s99 s99Var, boolean z, o99 o99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{s99Var, Boolean.valueOf(z), o99Var}) == null) {
            JSONArray jSONArray = new JSONArray();
            this.r = 0;
            this.s = 0;
            this.t = 0;
            k(s99Var, z, jSONArray);
            s(s99Var, z, jSONArray);
            if (o99Var != null && jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("items", jSONArray);
                    int i = this.r + this.s + this.t;
                    jSONObject.put("count", i + "," + this.r + "," + this.t);
                    o99Var.setUBCConfigStatisticData(jSONObject);
                } catch (JSONException e) {
                    if (y) {
                        e.printStackTrace();
                    }
                }
            }
            this.q.Y(s99Var.b());
            this.q.P(s99Var.i() * 86400000);
            this.q.Q(s99Var.h());
            this.q.R(s99Var.c());
            this.q.U(s99Var.f());
            this.q.T(s99Var.e());
            this.q.S(s99Var.d());
            this.q.W(s99Var.j());
            this.q.X(s99Var.k());
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
            s99Var.b().clear();
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
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && fa9.a(this.d)) {
            ha9 h = ha9.h(this.d);
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
    }

    public final void N(c cVar) {
        boolean a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || cVar == null) {
            return;
        }
        if (ea9.m().p() && !fa9.a(this.d)) {
            z89.w().V(cVar.e, false);
            return;
        }
        if (cVar.a) {
            a2 = this.p.b(cVar.c, cVar.f, cVar.g, cVar.h);
        } else {
            a2 = this.p.a(cVar.d, cVar.g, cVar.h);
        }
        p99 p99Var = cVar.i;
        if (p99Var != null) {
            p99Var.a(a2, cVar.b);
        }
        if (TextUtils.isEmpty(cVar.e)) {
            return;
        }
        z89.w().V(cVar.e, a2);
    }

    public void O(k99 k99Var) {
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, k99Var) == null) || k99Var == null) {
            return;
        }
        String a2 = k99Var.a();
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", a2);
        if (file.exists()) {
            if (k99Var.c()) {
                z89.w().Q(ha9.g(file, (int) file.length()), a2);
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
                    JSONObject jSONObject = new JSONObject(cb9.b(inputStream));
                    JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
                    jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                    jSONObject.put(TtmlNode.TAG_METADATA, jSONObject2);
                    z89.w().S(jSONObject, a2);
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
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (y) {
                Log.d("UBCBehaviorModel", "upload file fail:" + str);
            }
            w99.b("upload file fail");
            this.e.F(str);
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
            if (y) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
            }
            w99.b("delete file");
            if (file.exists() && file.delete()) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
                w99.b("delete file suc");
            }
            this.e.l(str);
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && fa9.a(this.d) && j()) {
            ha9 h = ha9.h(this.d);
            h.L(true);
            h.C();
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            this.e.r(arrayList, true, h);
            J(h);
            y();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && fa9.a(this.d)) {
            this.e.e();
            ha9 h = ha9.h(this.d);
            int p = this.q.p();
            h.M(p);
            h.L(true);
            ha9 h2 = ha9.h(this.d);
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
                    z99.a().l("uploadAll", String.valueOf(p), String.valueOf(v));
                }
                J(h);
            }
            if (v2 > 0) {
                if (h2.z()) {
                    z99.a().l("uploadAll", String.valueOf(p), String.valueOf(v2));
                }
                J(h2);
            }
        }
    }

    public final void T(SparseArray<ArrayList> sparseArray, ha9 ha9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, sparseArray, ha9Var) == null) || sparseArray == null) {
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
        for (int i = 0; i < sparseArray.size() && !ha9Var.d(51200); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (keyAt == 0) {
                if (H && G) {
                    this.e.r(new ArrayList<>(this.q.u()), false, ha9Var);
                } else {
                    this.e.r(sparseArray.valueAt(i), true, ha9Var);
                }
            } else if (this.v) {
                ha9Var.M(this.w);
                if (H && !G && keyAt == m) {
                    ArrayList<String> o = o(sparseArray, keyAt);
                    if (o != null) {
                        this.e.t(o, false, ha9Var);
                    }
                } else {
                    this.e.t(sparseArray.valueAt(i), true, ha9Var);
                }
            } else if (H && !G && keyAt == m) {
                ArrayList<String> o2 = o(sparseArray, keyAt);
                if (o2 != null) {
                    this.e.r(o2, false, ha9Var);
                }
            } else {
                this.e.r(sparseArray.valueAt(i), true, ha9Var);
            }
            if (ha9Var.w()) {
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
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && fa9.a(this.d)) {
            if (y) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.j = System.currentTimeMillis();
            ga9.a().e("ubc_last_upload_non_real", this.j);
            i();
            z();
            this.e.e();
            HashSet hashSet = new HashSet();
            if (this.n == null) {
                r();
            }
            ha9 h = ha9.h(this.d);
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
    }

    public final boolean V(j99 j99Var) {
        InterceptResult invokeL;
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, j99Var)) == null) {
            if (fa9.a(this.d) && j()) {
                z();
                ha9 p = p(j99Var, false);
                if (p == null || p.y()) {
                    return false;
                }
                if ((j99Var.n() & 128) != 0) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(j99Var.l());
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
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && fa9.a(this.d) && j()) {
            ha9 h = ha9.h(this.d);
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
    }

    public boolean X(j99 j99Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, j99Var)) == null) {
            if (fa9.a(this.d)) {
                j99Var.A("1");
                ha9 p = p(j99Var, true);
                if (p == null || p.y()) {
                    return false;
                }
                this.e.u(p);
                z89.w().U(p.u(), true, j99Var, new b(this));
                p.e();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean Y(ha9 ha9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, ha9Var, str)) == null) {
            if (x99.i().isPeakTime()) {
                List<String> i = x99.i().i();
                if (i != null && i.size() != 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(i);
                    if (arrayList.size() == 0) {
                        return true;
                    }
                    this.e.r(arrayList, true, ha9Var);
                    J(ha9Var);
                    y();
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void g(j99 j99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, j99Var) == null) {
            this.i.add(j99Var);
            int i = this.g;
            if (i == 0) {
                this.h = SystemClock.uptimeMillis();
                z89.w().J(this.x, 5000L);
                this.g = 1;
            } else if (i == 2) {
                this.h = SystemClock.uptimeMillis();
                this.g = 1;
            }
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i) == null) {
            z();
            this.e.d(str, i);
            if (!x99.i().isPeakTime() && Math.abs(System.currentTimeMillis() - this.j) >= c99.o().t()) {
                if (y) {
                    Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                U();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            G(true);
            G(false);
        }
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
                ga9.a().e("ubc_reset_real_time_count_time", this.k);
                ga9.a().d("ubc_real_time_count", this.m);
            }
            if (this.m >= 10000) {
                if (y) {
                    Log.d("UBCBehaviorModel", "real time upload total count check fail");
                }
                int i = this.m;
                if (i == 10000) {
                    this.m = i + 1;
                    if (!y) {
                        z99.a().f(String.valueOf(10000));
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k(s99 s99Var, boolean z, JSONArray jSONArray) {
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{s99Var, Boolean.valueOf(z), jSONArray}) == null) || (a2 = s99Var.a()) == null) {
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject = new JSONObject();
                f99 p = this.e.p(next);
                String optString = a2.optString(next, "0");
                String j = p != null ? p.j() : "0";
                boolean z2 = Integer.parseInt(j) >= Integer.parseInt(optString);
                if (z && j != null && z2) {
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
            if (x99.i().isPeakTime()) {
                if (!e || (i3 = x99.i().i()) == null || !i3.contains(str)) {
                    return;
                }
                if (!this.c) {
                    if ((System.currentTimeMillis() - this.b) / 1000 < this.a) {
                        return;
                    }
                    this.c = true;
                }
            }
            if (e) {
                if (y) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
                }
                W();
            }
            if (!x99.i().isPeakTime() && Math.abs(System.currentTimeMillis() - this.j) >= c99.o().t()) {
                if (y) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                U();
            }
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

    public u99 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.e : (u99) invokeV.objValue;
    }

    public final ArrayList o(SparseArray<ArrayList> sparseArray, int i) {
        InterceptResult invokeLI;
        ArrayList valueAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048609, this, sparseArray, i)) == null) {
            if (sparseArray == null || sparseArray.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (sparseArray.keyAt(i2) != i && (valueAt = sparseArray.valueAt(i2)) != null && valueAt.size() != 0) {
                    arrayList.addAll(valueAt);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public final ha9 p(j99 j99Var, boolean z) {
        InterceptResult invokeLZ;
        ha9 h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048610, this, j99Var, z)) == null) {
            if (z) {
                h = ha9.i();
            } else {
                h = ha9.h(this.d);
            }
            if (h.c(j99Var, j99Var.g())) {
                h.L(true);
                if ((j99Var.n() & 128) != 0) {
                    h.C();
                }
                if (!TextUtils.isEmpty(j99Var.h())) {
                    h.K("1");
                }
                return h;
            }
            return null;
        }
        return (ha9) invokeLZ.objValue;
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            c99 c99Var = this.q;
            if (c99Var != null) {
                return c99Var.C(str);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.n == null) {
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
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(s99 s99Var, boolean z, JSONArray jSONArray) {
        List<f99> b2;
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
        if (!(interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{s99Var, Boolean.valueOf(z), jSONArray}) == null) || (b2 = s99Var.b()) == null || b2.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(b2);
        String str5 = "Json格式转化失败";
        String str6 = "1";
        String str7 = "UBCBehaviorModel";
        if (this.e.q() > 0) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((f99) it.next()).c());
            }
            HashMap<String, String> o = this.e.o(arrayList3);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                f99 f99Var = (f99) it2.next();
                String c2 = f99Var.c();
                String str8 = o.get(c2);
                if (!TextUtils.isEmpty(str8)) {
                    try {
                        jSONObject = new JSONObject(str8);
                        optString = jSONObject.optString("version");
                        hashMap = o;
                    } catch (NumberFormatException unused) {
                        hashMap = o;
                    } catch (JSONException unused2) {
                        hashMap = o;
                    }
                    try {
                        j = f99Var.j();
                        arrayList = arrayList2;
                        try {
                            jSONObject2 = new JSONObject();
                            str = str5;
                        } catch (NumberFormatException unused3) {
                            str2 = str5;
                            str3 = str7;
                            if (y) {
                                Log.d(str3, "数据转换失败");
                            }
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        } catch (JSONException unused4) {
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
                    } catch (NumberFormatException unused5) {
                        arrayList = arrayList2;
                        str2 = str5;
                        str3 = str7;
                        if (y) {
                        }
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    } catch (JSONException unused6) {
                        arrayList = arrayList2;
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
                        str4 = str7;
                    } catch (NumberFormatException unused7) {
                        str3 = str7;
                        str2 = str;
                    } catch (JSONException unused8) {
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
                        z2 = Integer.parseInt(optString) >= Integer.parseInt(j);
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
                        if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && f99Var.l()) {
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
            f99 f99Var2 = (f99) it3.next();
            JSONObject jSONObject3 = new JSONObject();
            String c3 = f99Var2.c();
            String j2 = f99Var2.j();
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
        s99Var.m(arrayList4);
    }

    public void t(j99 j99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, j99Var) == null) {
            boolean equals = TextUtils.equals(j99Var.l(), j99Var.k());
            boolean z = false;
            boolean z2 = this.q.e(j99Var.l()) && (j99Var.n() & 64) == 0;
            boolean z3 = (j99Var.n() & 128) != 0;
            if ((equals && z2) || (equals && z3)) {
                z = true;
            }
            if (x99.i().isPeakTime()) {
                if (!z) {
                    this.e.z(j99Var);
                    return;
                }
                List<String> i = x99.i().i();
                if (i != null && i.contains(j99Var.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(j99Var);
                            return;
                        }
                    }
                } else {
                    this.e.z(j99Var);
                    return;
                }
            }
            if (z) {
                this.e.z(j99Var);
            } else if ((j99Var.n() & 1) == 0) {
                if (this.q.K(j99Var.l())) {
                    g(j99Var);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (this.q.K(j99Var.l())) {
                this.e.z(j99Var);
            }
            z89.w().I(j99Var, z);
        }
    }

    public void u() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && fa9.a(this.d)) {
            if (!c99.o().M() || System.currentTimeMillis() >= c99.o().v()) {
                File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    if (listFiles.length > 1000) {
                        if (!y) {
                            z99.a().d(String.valueOf(1000), listFiles.length);
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
                        k99 w = this.e.w(listFiles[i].getName());
                        if (w != null && TextUtils.equals("0", w.b())) {
                            if (y) {
                                Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                            }
                            w99.b("processFailedData file, no need to send");
                        } else if (w != null && TextUtils.equals("1", w.b())) {
                            w99.b("processFailedData file, send");
                            this.e.G(listFiles[i].getName(), "0");
                            O(w);
                        } else {
                            if (y) {
                                Log.d("UBCBehaviorModel", "processFailedData data in db");
                            }
                            w99.b("processFailedData file, data in db, delete file");
                            listFiles[i].delete();
                        }
                    }
                }
            }
        }
    }

    public void v() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && fa9.a(this.d)) {
            File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    k99 w = this.e.w(listFiles[i].getName());
                    if (w != null && TextUtils.equals("1", w.b())) {
                        if (y) {
                            Log.d("UBCBehaviorModel", "processOneFailedData send " + listFiles[i].getAbsolutePath());
                        }
                        w99.b("processOneFailedData file, send");
                        this.e.G(listFiles[i].getName(), "0");
                        O(w);
                        return;
                    }
                }
            }
        }
    }

    public void w(j99 j99Var, boolean z) {
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048617, this, j99Var, z) == null) {
            if (z) {
                if (!fa9.a(this.d) || !j()) {
                    return;
                }
                z();
                ha9 h = ha9.h(this.d);
                h.L(true);
                if ((j99Var.n() & 128) != 0) {
                    h.C();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(j99Var.l());
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

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (x99.i().isPeakTime()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= c99.o().t()) {
                U();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.m++;
            ga9.a().d("ubc_real_time_count", this.m);
        }
    }

    public final void z() {
        List<j99> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (list = this.i) == null || list.size() == 0) {
            return;
        }
        this.e.A(this.i);
        this.i.clear();
        if (this.g == 1) {
            this.g = 2;
        }
    }
}
