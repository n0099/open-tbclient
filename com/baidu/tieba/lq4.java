package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.downloader.Downloader;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public jq4 b;
    public kq4 c;
    public List<rq4> d;
    public long e;
    public long f;
    public long g;
    public int h;
    public SparseArray<ArrayList> i;
    public HashMap<String, Long> j;
    public vq4 k;
    public mq4 l;

    public lq4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = new jq4(context);
        this.c = new kq4(context);
        this.k = nq4.g().l();
        this.d = new ArrayList(20);
        cr4 e = cr4.e();
        this.e = e.getLong("ubc_last_upload_all_time", 0L);
        this.f = e.getLong("ubc_last_upload_non_real", 0L);
        this.g = e.getLong("ubc_reset_real_time_count_time", 0L);
        this.h = e.getInt("ubc_real_time_count", 0);
        mq4 g = mq4.g();
        this.l = g;
        g.k(this, context);
    }

    public void k(rq4 rq4Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, rq4Var) == null) {
            if (TextUtils.equals(rq4Var.a, rq4Var.b) && this.l.b(rq4Var.a) && (rq4Var.g & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && !A(rq4Var)) {
                this.b.y(rq4Var);
            } else if (Math.abs(System.currentTimeMillis() - this.f) >= mq4.g().h()) {
                if (!z) {
                    this.d.add(rq4Var);
                }
                z();
            } else if ((1 & rq4Var.g) == 0) {
                if (!z) {
                    this.d.add(rq4Var);
                }
                if (this.d.size() >= 20) {
                    j();
                }
            } else if (!z) {
                this.b.y(rq4Var);
            }
        }
    }

    public final void q(dr4 dr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, dr4Var) != null) || dr4Var.d()) {
            return;
        }
        JSONArray jSONArray = dr4Var.a;
        String d = nr4.d(jSONArray.toString().getBytes(), true);
        m(jSONArray.toString(), d);
        this.b.A(d, dr4Var.g);
        if (!this.b.g(dr4Var.b, dr4Var.c, dr4Var.g, d)) {
            dr4Var.c();
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", d);
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
            }
            this.b.i(d);
            return;
        }
        wq4.f().r(jSONArray, d);
        dr4Var.c();
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", str);
            InputStream inputStream = null;
            try {
                InputStream fileInputStream = new FileInputStream(file);
                try {
                    if (fileInputStream.available() > 0) {
                        inputStream = new Base64InputStream(fileInputStream, 0);
                        wq4.f().r(new JSONArray(pr4.c(inputStream)), str);
                        fileInputStream = inputStream;
                    }
                    lr4.d(fileInputStream);
                } catch (Exception unused) {
                    inputStream = fileInputStream;
                    lr4.d(inputStream);
                } catch (Throwable th) {
                    th = th;
                    inputStream = fileInputStream;
                    lr4.d(inputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final boolean A(rq4 rq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rq4Var)) == null) {
            if (!g(this.a) || !c()) {
                return false;
            }
            j();
            dr4 dr4Var = new dr4();
            dr4Var.g = true;
            JSONObject jSONObject = rq4Var.e;
            try {
                if (jSONObject != null && jSONObject.has("bizId")) {
                    ar4.a(jSONObject);
                    dr4Var.a(jSONObject);
                    long j = rq4Var.f;
                    dr4Var.g(j, j);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    JSONObject jSONObject3 = jSONObject.getJSONObject(DI.APP_INFO_NAME);
                    if (jSONObject2 != null && jSONObject3 != null) {
                        jSONObject2.put(DI.APP_INFO_NAME, jSONObject3);
                        jSONObject.remove(DI.APP_INFO_NAME);
                    }
                } else {
                    JSONObject e = new ar4(rq4Var.a()).e();
                    e.put("bizId", rq4Var.a);
                    e.put("timestamp", Long.toString(rq4Var.f));
                    if (rq4Var.e != null) {
                        e.put("content", rq4Var.e);
                    } else {
                        e.put("content", rq4Var.d);
                    }
                    e.put("eventType", "0");
                    if (!TextUtils.isEmpty(rq4Var.h)) {
                        e.put("abtest", rq4Var.h);
                        dr4Var.f = "1";
                    }
                    if (!TextUtils.isEmpty(rq4Var.i)) {
                        e.put("c", rq4Var.i);
                    }
                    if (rq4Var.j) {
                        e.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    e.put(Constant.ID_TYPE, this.l.j(rq4Var.a));
                    dr4Var.a(e);
                    dr4Var.g(rq4Var.f, rq4Var.f);
                }
            } catch (JSONException unused) {
            }
            if (this.i == null) {
                f();
            }
            if (this.i.size() > 0) {
                this.b.m(this.i.valueAt(0), dr4Var);
            }
            q(dr4Var);
            i();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !g(this.a) || !c()) {
            return;
        }
        dr4 dr4Var = new dr4();
        dr4Var.g = true;
        if (this.i == null) {
            f();
        }
        if (this.i.size() > 0) {
            if (nq4.g().r()) {
                this.b.l(dr4Var);
            } else {
                this.b.m(this.i.valueAt(0), dr4Var);
            }
        }
        q(dr4Var);
        i();
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (nq4.g().r()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.g) > 86400000) {
                this.h = 0;
                this.g = currentTimeMillis;
                cr4.e().putLong("ubc_reset_real_time_count_time", this.g);
                cr4.e().putInt("ubc_real_time_count", this.h);
            }
            int i = this.h;
            if (i < 1000) {
                return true;
            }
            if (i == 1000) {
                this.h = i + 1;
                nq4.h("23", "realLimit");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.i != null) {
            return;
        }
        SparseArray<ArrayList> sparseArray = new SparseArray<>();
        this.i = sparseArray;
        this.b.v(sparseArray);
        this.j = new HashMap<>();
        int i = 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            int keyAt = this.i.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            HashMap<String, Long> hashMap = this.j;
            hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.l.p(i);
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            j();
            this.b.d(str, i);
            if (Math.abs(System.currentTimeMillis() - this.f) >= mq4.g().h()) {
                z();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n(true);
            n(false);
        }
    }

    public jq4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (jq4) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.h++;
            cr4.e().putInt("ubc_real_time_count", this.h);
        }
    }

    public final void j() {
        List<rq4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (list = this.d) != null && list.size() != 0) {
            this.b.z(this.d);
            this.d.clear();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.C();
        }
    }

    public void d(String str, int i, long j, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), jSONArray}) == null) {
            j();
            this.b.j(str, i, j, jSONArray);
            if (this.l.b(str)) {
                B();
            }
            if (Math.abs(System.currentTimeMillis() - this.f) >= mq4.g().h()) {
                z();
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public final boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo networkInfo = null;
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
            }
            if (networkInfo == null || !networkInfo.isAvailable()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void l(rq4 rq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rq4Var) == null) {
            this.c.d(rq4Var, this.l.b(rq4Var.a));
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            dr4 dr4Var = new dr4();
            dr4Var.g = z;
            if (this.c.c(dr4Var, z)) {
                JSONArray jSONArray = dr4Var.a;
                this.c.b(z);
                wq4.f().s(jSONArray);
            }
        }
    }

    public void p(tq4 tq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, tq4Var) == null) {
            this.b.B(tq4Var);
        }
    }

    public void w(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, jSONArray) == null) && !this.k.a(jSONArray)) {
            nq4.h("23", "sendFail");
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            br4.a("upload file fail");
            this.b.F(str);
        }
    }

    public void h() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !g(this.a)) {
            return;
        }
        File file = new File(this.a.getFilesDir() + File.separator + "statistics_data");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length > 50) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "del_file");
                    jSONObject.put("del_file_size", listFiles.length);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                nq4.h("23", jSONObject.toString());
                for (File file2 : listFiles) {
                    file2.delete();
                }
                this.b.h();
            }
            for (int i = 0; i < listFiles.length; i++) {
                sq4 u = this.b.u(listFiles[i].getName());
                if (u != null && TextUtils.equals("0", u.a())) {
                    br4.a("processFailedData file, no need to send");
                } else if (u != null && TextUtils.equals("1", u.a())) {
                    br4.a("processFailedData file, send");
                    this.b.G(listFiles[i].getName(), "0");
                    v(listFiles[i].getName());
                } else {
                    br4.a("processFailedData file, data in db, delete file");
                    listFiles[i].delete();
                }
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || !g(this.a) || Math.abs(System.currentTimeMillis() - this.e) < 3600000) {
            return;
        }
        this.b.f();
        dr4 dr4Var = new dr4();
        if (this.b.l(dr4Var) == 0) {
            return;
        }
        dr4 dr4Var2 = new dr4();
        dr4Var2.g(dr4Var.d, dr4Var.e);
        dr4Var2.f = dr4Var.f;
        dr4Var2.g = true;
        dr4 dr4Var3 = new dr4();
        dr4Var3.g(dr4Var.d, dr4Var.e);
        dr4Var3.f = dr4Var.f;
        dr4Var3.g = false;
        SparseIntArray sparseIntArray = dr4Var.b;
        int size = sparseIntArray.size();
        for (int i = 0; i < size; i++) {
            if (this.l.b(String.valueOf(sparseIntArray.valueAt(i)))) {
                dr4Var2.f(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
            } else {
                dr4Var3.f(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
            }
        }
        ArrayList<String> arrayList = dr4Var.c;
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String str = arrayList.get(i2);
            if (this.l.b(str)) {
                dr4Var2.e(str);
            } else {
                dr4Var3.e(str);
            }
        }
        JSONArray jSONArray = dr4Var.a;
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject.has("bizId")) {
                String str2 = null;
                try {
                    str2 = optJSONObject.getString("bizId");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (this.l.b(str2)) {
                        dr4Var2.a(optJSONObject);
                    } else {
                        dr4Var3.a(optJSONObject);
                    }
                }
            }
        }
        if (dr4Var2.a.length() > 0) {
            q(dr4Var2);
        }
        if (dr4Var3.a.length() > 0) {
            q(dr4Var3);
        }
        this.e = System.currentTimeMillis();
        cr4.e().putLong("ubc_last_upload_all_time", this.e);
        this.f = this.e;
        cr4.e().putLong("ubc_last_upload_non_real", this.f);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || !g(this.a)) {
            return;
        }
        this.f = System.currentTimeMillis();
        cr4.e().putLong("ubc_last_upload_non_real", this.f);
        b();
        j();
        this.b.f();
        HashSet hashSet = new HashSet();
        if (this.i == null) {
            f();
        }
        dr4 dr4Var = new dr4();
        dr4Var.g = false;
        int i = 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            int keyAt = this.i.keyAt(i2);
            if (keyAt != 0) {
                HashMap<String, Long> hashMap = this.j;
                long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.l.h()) {
                    i |= this.b.m(this.i.valueAt(i2), dr4Var);
                    HashMap<String, Long> hashMap2 = this.j;
                    hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                    hashSet.add(Integer.valueOf(keyAt));
                }
            }
        }
        if (i == 0) {
            return;
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            int keyAt2 = this.i.keyAt(i3);
            if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                if (dr4Var.b(Downloader.DOWNLOAD_BUF_SIZE)) {
                    break;
                }
                this.b.m(this.i.valueAt(i3), dr4Var);
            }
        }
        q(dr4Var);
    }

    public final void m(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            String str3 = this.a.getFilesDir() + File.separator + "statistics_data";
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
                    br4.a("save to file suc");
                } catch (Exception e2) {
                    e = e2;
                    outputStream = fileOutputStream;
                    e.printStackTrace();
                    lr4.d(outputStream);
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = fileOutputStream;
                    lr4.d(outputStream);
                    throw th;
                }
                lr4.d(outputStream);
            }
        }
    }

    public void r(zq4 zq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, zq4Var) == null) {
            this.l.q(zq4Var.a());
            this.l.n(zq4Var.d() * 86400000);
            this.l.o(zq4Var.c());
            cr4.e().putString("ubc_version_md5", zq4Var.b());
            this.b.D(zq4Var.a());
            zq4Var.a().clear();
            if (this.i == null) {
                this.i = new SparseArray<>();
            }
            this.i.clear();
            if (this.j == null) {
                this.j = new HashMap<>();
            }
            this.j.clear();
            this.b.v(this.i);
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                int keyAt = this.i.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                HashMap<String, Long> hashMap = this.j;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.l.p(i);
        }
    }

    public void s(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, str, i, str2) == null) {
            this.b.E(str, i, str2);
        }
    }

    public final void u(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, jSONArray, str) == null) {
            wq4.f().t(str, this.k.a(jSONArray));
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", str);
            br4.a("delete file");
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
                br4.a("delete file suc");
            }
            this.b.i(str);
        }
    }
}
