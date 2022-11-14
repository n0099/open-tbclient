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
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.qc9;
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
/* loaded from: classes4.dex */
public class kb9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public boolean c;
    public Context d;
    public gc9 e;
    public jb9 f;
    public int g;
    public long h;
    public List<vb9> i;
    public long j;
    public long k;
    public long l;
    public int m;
    public SparseArray<ArrayList> n;
    public HashMap<String, Long> o;
    public cc9 p;
    public ob9 q;
    public int r;
    public int s;
    public int t;
    public qc9 u;
    public boolean v;
    public int w;
    public Runnable x;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kb9 a;

        public a(kb9 kb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kb9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.a.h;
                    if (uptimeMillis >= 5000) {
                        if (kb9.y) {
                            Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                        }
                        this.a.z();
                        this.a.g = 0;
                        return;
                    }
                    lb9.w().J(this, 5000 - uptimeMillis);
                } else if (this.a.g != 2) {
                } else {
                    this.a.g = 0;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements bc9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kb9 a;

        public b(kb9 kb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kb9Var;
        }

        @Override // com.baidu.tieba.bc9
        public void a(boolean z, vb9 vb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, vb9Var) == null) {
                if (!z) {
                    this.a.e.z(vb9Var);
                    return;
                }
                this.a.e.h();
                fc9.f().a(vb9Var.l(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public vb9 b;
        public File c;
        public JSONObject d;
        public String e;
        public long f;
        public boolean g;
        public boolean h;
        public bc9 i;

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

    /* loaded from: classes4.dex */
    public class d implements qc9.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(kb9 kb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(kb9 kb9Var, a aVar) {
            this(kb9Var);
        }

        @Override // com.baidu.tieba.qc9.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lb9.w().P();
                lb9.w().K();
            }
        }

        @Override // com.baidu.tieba.qc9.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                lb9.w().P();
                lb9.w().K();
                lb9.w().E();
            }
        }

        @Override // com.baidu.tieba.qc9.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                lb9.w().K();
            }
        }

        @Override // com.baidu.tieba.qc9.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                lb9.w().P();
                lb9.w().K();
                lb9.w().E();
            }
        }

        @Override // com.baidu.tieba.qc9.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                lb9.w().P();
                lb9.w().K();
                lb9.w().E();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947907463, "Lcom/baidu/tieba/kb9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947907463, "Lcom/baidu/tieba/kb9;");
                return;
            }
        }
        y = jc9.m();
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

    public gc9 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.e;
        }
        return (gc9) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.m++;
            sc9.a().d("ubc_real_time_count", this.m);
        }
    }

    public final void z() {
        List<vb9> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (list = this.i) != null && list.size() != 0) {
            this.e.A(this.i);
            this.i.clear();
            if (this.g == 1) {
                this.g = 2;
            }
        }
    }

    public kb9(Context context) {
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
        sc9 a2 = sc9.a();
        this.e = new gc9(context);
        this.f = new jb9(context);
        this.p = jc9.j();
        this.i = new ArrayList(20);
        this.j = a2.c("ubc_last_upload_non_real", 0L);
        this.k = a2.c("ubc_reset_real_time_count_time", 0L);
        this.l = a2.c("ubc_last_upload_failed_data_time", 0L);
        this.m = a2.b("ubc_real_time_count", 0);
        ob9 o = ob9.o();
        this.q = o;
        o.D(this, context);
        this.b = System.currentTimeMillis();
        this.a = new Random().nextInt(31) + 60;
        this.v = ob9.o().I();
        this.w = ob9.o().x();
        fc9.f().g(this.e);
        qc9 m = qc9.m();
        this.u = m;
        m.n(this.d, this.e, new d(this, null));
    }

    public final void J(tc9 tc9Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tc9Var) == null) {
            tc9Var.k();
            if (tc9Var.y()) {
                return;
            }
            if (tc9Var.x()) {
                str = tc9Var.p();
            } else {
                try {
                    JSONObject u = tc9Var.u();
                    String c2 = rc9.c(u.toString().getBytes(), true);
                    D(u.toString(), c2);
                    if (y) {
                        ic9.a(tc9Var);
                        Log.d("UBCBehaviorModel", "save send data to file " + c2);
                    }
                    str = c2;
                } catch (OutOfMemoryError unused) {
                    tc9Var.e();
                    return;
                }
            }
            if (!this.e.g(tc9Var, str)) {
                tc9Var.e();
                File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.e.l(str);
                return;
            }
            lc9.a().m(tc9Var.B(), tc9Var.v());
            lb9.w().Q(tc9Var, str);
            tc9Var.e();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.l) < IMUserListModel.REQUEST_SPACE) {
                return;
            }
            this.l = currentTimeMillis;
            sc9.a().e("ubc_last_upload_failed_data_time", this.l);
            lb9.w().E();
            lb9.w().K();
        }
    }

    public void O(wb9 wb9Var) {
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, wb9Var) != null) || wb9Var == null) {
            return;
        }
        String a2 = wb9Var.a();
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", a2);
        if (!file.exists()) {
            return;
        }
        if (wb9Var.c()) {
            lb9.w().Q(tc9.g(file, (int) file.length()), a2);
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
                JSONObject jSONObject = new JSONObject(od9.b(inputStream));
                JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
                jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                jSONObject.put(TtmlNode.TAG_METADATA, jSONObject2);
                lb9.w().S(jSONObject, a2);
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

    public void t(vb9 vb9Var) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, vb9Var) == null) {
            boolean equals = TextUtils.equals(vb9Var.l(), vb9Var.k());
            boolean z3 = false;
            if (this.q.e(vb9Var.l()) && (vb9Var.n() & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            if ((vb9Var.n() & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((equals && z) || (equals && z2)) {
                z3 = true;
            }
            if (jc9.i().isPeakTime()) {
                if (!z3) {
                    this.e.z(vb9Var);
                    return;
                }
                List<String> i = jc9.i().i();
                if (i != null && i.contains(vb9Var.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(vb9Var);
                            return;
                        }
                    }
                } else {
                    this.e.z(vb9Var);
                    return;
                }
            }
            if (z3) {
                this.e.z(vb9Var);
            } else if ((vb9Var.n() & 1) == 0) {
                if (this.q.K(vb9Var.l())) {
                    g(vb9Var);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (this.q.K(vb9Var.l())) {
                this.e.z(vb9Var);
            }
            lb9.w().I(vb9Var, z3);
        }
    }

    public void B(vb9 vb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vb9Var) == null) {
            this.f.g(vb9Var, this.q.e(vb9Var.l()));
        }
    }

    public void C(vb9 vb9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vb9Var) != null) || !of1.g()) {
            return;
        }
        this.f.i(vb9Var);
    }

    public void I(xb9 xb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xb9Var) == null) {
            this.e.B(xb9Var);
        }
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            ob9 ob9Var = this.q;
            if (ob9Var != null) {
                return ob9Var.C(str);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void A(vb9 vb9Var) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vb9Var) == null) {
            boolean equals = TextUtils.equals(vb9Var.l(), vb9Var.k());
            if (this.q.e(vb9Var.l()) && (vb9Var.n() & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            if ((vb9Var.n() & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((equals && z) || (equals && z2)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (jc9.i().isPeakTime()) {
                if (!z3) {
                    this.e.z(vb9Var);
                    return;
                }
                List<String> i = jc9.i().i();
                if (i != null && i.contains(vb9Var.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(vb9Var);
                            return;
                        }
                    }
                } else {
                    this.e.z(vb9Var);
                    return;
                }
            }
            if (z3 && !V(vb9Var)) {
                if (this.q.K(vb9Var.l())) {
                    this.e.z(vb9Var);
                    return;
                }
                return;
            }
            if (z3) {
                fc9.f().a(vb9Var.l(), false);
            }
            if (jc9.i().isPeakTime()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= ob9.o().t()) {
                if (!z3 && this.q.K(vb9Var.l())) {
                    g(vb9Var);
                }
                U();
            } else if ((vb9Var.n() & 1) == 0) {
                if (!z3 && this.q.K(vb9Var.l())) {
                    g(vb9Var);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (!z3 && this.q.K(vb9Var.l())) {
                this.e.z(vb9Var);
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
                    ic9.b("save to file suc");
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
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !rc9.a(this.d)) {
            return;
        }
        if (this.n == null) {
            r();
        }
        tc9 h = tc9.h(this.d);
        if (fc9.f().d(h) && h != null && !h.y()) {
            h.L(true);
            J(h);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            tc9 i = tc9.i();
            if (this.f.e(i)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "sendQualityData:" + u.toString());
                }
                lb9.w().R(u);
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || !rc9.a(this.d) || !j()) {
            return;
        }
        tc9 h = tc9.h(this.d);
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
            if (jc9.i().isPeakTime()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= ob9.o().t()) {
                U();
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            tc9 i = tc9.i();
            i.L(z);
            if (this.f.f(i, z)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "checkFileData:" + u.toString());
                }
                this.f.c(z);
                lb9.w().R(u);
            }
        }
    }

    public boolean X(vb9 vb9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, vb9Var)) == null) {
            if (!rc9.a(this.d)) {
                return false;
            }
            vb9Var.A("1");
            tc9 p = p(vb9Var, true);
            if (p == null || p.y()) {
                return false;
            }
            this.e.u(p);
            lb9.w().U(p.u(), true, vb9Var, new b(this));
            p.e();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void K(ec9 ec9Var, boolean z, ac9 ac9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{ec9Var, Boolean.valueOf(z), ac9Var}) == null) {
            JSONArray jSONArray = new JSONArray();
            this.r = 0;
            this.s = 0;
            this.t = 0;
            k(ec9Var, z, jSONArray);
            s(ec9Var, z, jSONArray);
            if (ac9Var != null && jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("items", jSONArray);
                    int i = this.r + this.s + this.t;
                    jSONObject.put("count", i + "," + this.r + "," + this.t);
                    ac9Var.setUBCConfigStatisticData(jSONObject);
                } catch (JSONException e) {
                    if (y) {
                        e.printStackTrace();
                    }
                }
            }
            this.q.Y(ec9Var.b());
            this.q.P(ec9Var.i() * 86400000);
            this.q.Q(ec9Var.h());
            this.q.R(ec9Var.c());
            this.q.U(ec9Var.f());
            this.q.T(ec9Var.e());
            this.q.S(ec9Var.d());
            this.q.W(ec9Var.j());
            this.q.X(ec9Var.k());
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
            ec9Var.b().clear();
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
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !rc9.a(this.d)) {
            return;
        }
        tc9 h = tc9.h(this.d);
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
        if (qc9.m().p() && !rc9.a(this.d)) {
            lb9.w().V(cVar.e, false);
            return;
        }
        if (cVar.a) {
            a2 = this.p.b(cVar.c, cVar.f, cVar.g, cVar.h);
        } else {
            a2 = this.p.a(cVar.d, cVar.g, cVar.h);
        }
        bc9 bc9Var = cVar.i;
        if (bc9Var != null) {
            bc9Var.a(a2, cVar.b);
        }
        if (TextUtils.isEmpty(cVar.e)) {
            return;
        }
        lb9.w().V(cVar.e, a2);
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
            if (y) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
            }
            ic9.b("delete file");
            if (file.exists() && file.delete()) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
                ic9.b("delete file suc");
            }
            this.e.l(str);
        }
    }

    public final boolean V(vb9 vb9Var) {
        InterceptResult invokeL;
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, vb9Var)) == null) {
            if (!rc9.a(this.d) || !j()) {
                return false;
            }
            z();
            tc9 p = p(vb9Var, false);
            if (p == null || p.y()) {
                return false;
            }
            if ((vb9Var.n() & 128) != 0) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(vb9Var.l());
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
            ic9.b("upload file fail");
            this.e.F(str);
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, str) != null) || !rc9.a(this.d) || !j()) {
            return;
        }
        tc9 h = tc9.h(this.d);
        h.L(true);
        h.C();
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        this.e.r(arrayList, true, h);
        J(h);
        y();
    }

    public final void g(vb9 vb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, vb9Var) == null) {
            this.i.add(vb9Var);
            int i = this.g;
            if (i == 0) {
                this.h = SystemClock.uptimeMillis();
                lb9.w().J(this.x, 5000L);
                this.g = 1;
            } else if (i == 2) {
                this.h = SystemClock.uptimeMillis();
                this.g = 1;
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || !rc9.a(this.d)) {
            return;
        }
        this.e.e();
        tc9 h = tc9.h(this.d);
        int p = this.q.p();
        h.M(p);
        h.L(true);
        tc9 h2 = tc9.h(this.d);
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
                lc9.a().l("uploadAll", String.valueOf(p), String.valueOf(v));
            }
            J(h);
        }
        if (v2 > 0) {
            if (h2.z()) {
                lc9.a().l("uploadAll", String.valueOf(p), String.valueOf(v2));
            }
            J(h2);
        }
    }

    public void v() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || !rc9.a(this.d)) {
            return;
        }
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (int i = 0; i < listFiles.length; i++) {
                wb9 w = this.e.w(listFiles[i].getName());
                if (w != null && TextUtils.equals("1", w.b())) {
                    if (y) {
                        Log.d("UBCBehaviorModel", "processOneFailedData send " + listFiles[i].getAbsolutePath());
                    }
                    ic9.b("processOneFailedData file, send");
                    this.e.G(listFiles[i].getName(), "0");
                    O(w);
                    return;
                }
            }
        }
    }

    public final void T(SparseArray<ArrayList> sparseArray, tc9 tc9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048595, this, sparseArray, tc9Var) != null) || sparseArray == null) {
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
        for (int i = 0; i < sparseArray.size() && !tc9Var.d(51200); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (keyAt == 0) {
                if (H && G) {
                    this.e.r(new ArrayList<>(this.q.u()), false, tc9Var);
                } else {
                    this.e.r(sparseArray.valueAt(i), true, tc9Var);
                }
            } else if (this.v) {
                tc9Var.M(this.w);
                if (H && !G && keyAt == m) {
                    ArrayList<String> o = o(sparseArray, keyAt);
                    if (o != null) {
                        this.e.t(o, false, tc9Var);
                    }
                } else {
                    this.e.t(sparseArray.valueAt(i), true, tc9Var);
                }
            } else if (H && !G && keyAt == m) {
                ArrayList<String> o2 = o(sparseArray, keyAt);
                if (o2 != null) {
                    this.e.r(o2, false, tc9Var);
                }
            } else {
                this.e.r(sparseArray.valueAt(i), true, tc9Var);
            }
            if (tc9Var.w()) {
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
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || !rc9.a(this.d)) {
            return;
        }
        if (y) {
            Log.d("UBCBehaviorModel", " upload no real data");
        }
        this.j = System.currentTimeMillis();
        sc9.a().e("ubc_last_upload_non_real", this.j);
        i();
        z();
        this.e.e();
        HashSet hashSet = new HashSet();
        if (this.n == null) {
            r();
        }
        tc9 h = tc9.h(this.d);
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

    public final boolean Y(tc9 tc9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, tc9Var, str)) == null) {
            if (jc9.i().isPeakTime()) {
                List<String> i = jc9.i().i();
                if (i != null && i.size() != 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(i);
                    if (arrayList.size() == 0) {
                        return true;
                    }
                    this.e.r(arrayList, true, tc9Var);
                    J(tc9Var);
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
            if (!jc9.i().isPeakTime() && Math.abs(System.currentTimeMillis() - this.j) >= ob9.o().t()) {
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

    public final tc9 p(vb9 vb9Var, boolean z) {
        InterceptResult invokeLZ;
        tc9 h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048610, this, vb9Var, z)) == null) {
            if (z) {
                h = tc9.i();
            } else {
                h = tc9.h(this.d);
            }
            if (!h.c(vb9Var, vb9Var.g())) {
                return null;
            }
            h.L(true);
            if ((vb9Var.n() & 128) != 0) {
                h.C();
            }
            if (!TextUtils.isEmpty(vb9Var.h())) {
                h.K("1");
            }
            return h;
        }
        return (tc9) invokeLZ.objValue;
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
                sc9.a().e("ubc_reset_real_time_count_time", this.k);
                sc9.a().d("ubc_real_time_count", this.m);
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
                    lc9.a().f(String.valueOf(10000));
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

    public void k(ec9 ec9Var, boolean z, JSONArray jSONArray) {
        JSONObject a2;
        String str;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048605, this, new Object[]{ec9Var, Boolean.valueOf(z), jSONArray}) != null) || (a2 = ec9Var.a()) == null) {
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject = new JSONObject();
                rb9 p = this.e.p(next);
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
            if (jc9.i().isPeakTime()) {
                if (e && (i3 = jc9.i().i()) != null && i3.contains(str)) {
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
            if (!jc9.i().isPeakTime() && Math.abs(System.currentTimeMillis() - this.j) >= ob9.o().t()) {
                if (y) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                U();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(ec9 ec9Var, boolean z, JSONArray jSONArray) {
        List<rb9> b2;
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
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{ec9Var, Boolean.valueOf(z), jSONArray}) == null) && (b2 = ec9Var.b()) != null && b2.size() != 0) {
            ArrayList arrayList2 = new ArrayList(b2);
            String str5 = "Json格式转化失败";
            String str6 = "1";
            String str7 = "UBCBehaviorModel";
            if (this.e.q() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((rb9) it.next()).c());
                }
                HashMap<String, String> o = this.e.o(arrayList3);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    rb9 rb9Var = (rb9) it2.next();
                    String c2 = rb9Var.c();
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
                            j = rb9Var.j();
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
                            if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && rb9Var.l()) {
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
                rb9 rb9Var2 = (rb9) it3.next();
                JSONObject jSONObject3 = new JSONObject();
                String c3 = rb9Var2.c();
                String j2 = rb9Var2.j();
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
            ec9Var.m(arrayList4);
        }
    }

    public void u() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || !rc9.a(this.d)) {
            return;
        }
        if (ob9.o().M() && System.currentTimeMillis() < ob9.o().v()) {
            return;
        }
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length > 1000) {
                if (!y) {
                    lc9.a().d(String.valueOf(1000), listFiles.length);
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
                wb9 w = this.e.w(listFiles[i].getName());
                if (w != null && TextUtils.equals("0", w.b())) {
                    if (y) {
                        Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                    }
                    ic9.b("processFailedData file, no need to send");
                } else if (w != null && TextUtils.equals("1", w.b())) {
                    ic9.b("processFailedData file, send");
                    this.e.G(listFiles[i].getName(), "0");
                    O(w);
                } else {
                    if (y) {
                        Log.d("UBCBehaviorModel", "processFailedData data in db");
                    }
                    ic9.b("processFailedData file, data in db, delete file");
                    listFiles[i].delete();
                }
            }
        }
    }

    public void w(vb9 vb9Var, boolean z) {
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048617, this, vb9Var, z) == null) {
            if (z) {
                if (!rc9.a(this.d) || !j()) {
                    return;
                }
                z();
                tc9 h = tc9.h(this.d);
                h.L(true);
                if ((vb9Var.n() & 128) != 0) {
                    h.C();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(vb9Var.l());
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
