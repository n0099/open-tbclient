package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.tieba.yt0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qk1 {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public static List<sk1> b;
    public static sk1 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        /* renamed from: com.baidu.tieba.qk1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0458a implements yt0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0458a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.yt0.b
            public void a(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                    ClogBuilder.LogType logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                    a aVar = this.a;
                    r31.b(new t31(logType, aVar.b, aVar.d, true).b(i, str, "download"));
                }
            }

            @Override // com.baidu.tieba.yt0.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a aVar = this.a;
                    qk1.A(aVar.a, aVar.c);
                    pk1.m().g();
                }
            }
        }

        public a(File file, String str, File file2, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, file2, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.b = str;
            this.c = file2;
            this.d = str2;
            this.e = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    yt0.a(this.a, this.b, new C0458a(this), this.e);
                } catch (Exception e) {
                    r31.b(new t31(ClogBuilder.LogType.DOWNLOAD_FAILED, this.b, this.d, true).b(-1, e.getMessage(), "download"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk1 a;

        public b(sk1 sk1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sk1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qk1.C(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public c(List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            sk1 sk1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.a) != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList(3);
                Iterator it = this.a.iterator();
                while (it.hasNext() && (sk1Var = (sk1) it.next()) != null) {
                    if (qk1.v(sk1Var.w)) {
                        qk1.j(sk1Var);
                    } else {
                        arrayList.add(sk1Var);
                    }
                }
                if (arrayList.size() > 0) {
                    if (qk1.a == null) {
                        d unused = qk1.a = new d(arrayList, null);
                        ok0.b().registerReceiver(qk1.a, qk1.a.getIntentFilter());
                        return;
                    }
                    qk1.a.setNeedDownloadList(arrayList);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<sk1> mNeedDownloadList;

        public d(List<sk1> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNeedDownloadList = list;
        }

        public void setNeedDownloadList(List<sk1> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.mNeedDownloadList = list;
            }
        }

        public /* synthetic */ d(List list, a aVar) {
            this(list);
        }

        public IntentFilter getIntentFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new IntentFilter(NetworkMonitor.NET_CHANGE_ACTION);
            }
            return (IntentFilter) invokeV.objValue;
        }

        public List<sk1> getNeedDownloadList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mNeedDownloadList;
            }
            return (List) invokeV.objValue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) {
                Log.d("SourceManager", "onReceive: receiver");
                if (!TextUtils.equals(intent.getAction(), NetworkMonitor.NET_CHANGE_ACTION)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (sk1 sk1Var : this.mNeedDownloadList) {
                    if (qk1.v(sk1Var.w)) {
                        Log.d("SourceManager", "onReceive: " + sk1Var);
                        qk1.j(sk1Var);
                    } else {
                        arrayList.add(sk1Var);
                    }
                }
                this.mNeedDownloadList = arrayList;
            }
        }
    }

    public static boolean A(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, file, file2)) == null) {
            if (file != null && file2 != null) {
                return file.renameTo(file2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int f(sk1 sk1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, sk1Var, i)) == null) {
            return g(sk1Var, false, i);
        }
        return invokeLI.intValue;
    }

    public static void B(List<sk1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, list) == null) {
            s41.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }

    public static void D(sk1 sk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, sk1Var) == null) && sk1Var.v >= 1) {
            int i = sk1Var.x;
            if (i < Integer.MAX_VALUE) {
                sk1Var.x = i + 1;
            }
            s41.d(new b(sk1Var), "updateSplashDataItemRate");
        }
    }

    public static void E(List<sk1> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) && list != null && list.size() != 0) {
            b = Collections.synchronizedList(list);
            z(list, q());
        }
    }

    public static File r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            String m = m(str);
            if (TextUtils.isEmpty(m)) {
                return null;
            }
            return new File(o(), m);
        }
        return (File) invokeL.objValue;
    }

    public static File u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".tmp");
            return new File(o(), stringBuffer.toString());
        }
        return (File) invokeL.objValue;
    }

    public static boolean v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i)) == null) {
            if (new lt0(ok0.b()).a() || i == 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static List<sk1> x(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65564, null, z)) == null) {
            return y(z, 0);
        }
        return (List) invokeZ.objValue;
    }

    public static void C(sk1 sk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, sk1Var) == null) {
            ArrayList arrayList = new ArrayList();
            File q = q();
            List<sk1> s = s();
            if (s != null && s.size() != 0) {
                for (int i = 0; i < s.size(); i++) {
                    sk1 sk1Var2 = s.get(i);
                    if (TextUtils.equals(sk1Var.b, sk1Var2.b)) {
                        sk1.t(sk1Var2, sk1Var);
                        arrayList.add(sk1Var2);
                    } else {
                        arrayList.add(sk1Var2);
                    }
                }
                z(arrayList, q);
            }
        }
    }

    public static String l(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, file)) == null) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (Exception unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(k61.b(str, false));
            int lastIndexOf = str.lastIndexOf(".");
            int lastIndexOf2 = str.lastIndexOf("/");
            if (lastIndexOf < lastIndexOf2 || lastIndexOf == -1 || lastIndexOf2 == -1) {
                return null;
            }
            sb.append(str.substring(lastIndexOf));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            File file = new File(ok0.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
            file.mkdirs();
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return new File(o(), "splash.dat");
        }
        return (File) invokeV.objValue;
    }

    public static List<sk1> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return y(false, 0);
        }
        return (List) invokeV.objValue;
    }

    public static boolean e(@NonNull sk1 sk1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, sk1Var)) == null) {
            long j = sk1Var.R;
            long j2 = sk1Var.S;
            if (j <= 0 || j2 <= 0) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis >= j && currentTimeMillis <= j2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void j(sk1 sk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65550, null, sk1Var) != null) || !URLUtil.isNetworkUrl(sk1Var.g)) {
            return;
        }
        k(sk1Var.g, sk1Var.d, sk1Var.V);
        if (!TextUtils.isEmpty(sk1Var.z)) {
            k(sk1Var.z, sk1Var.d, sk1Var.V);
        }
        if (!TextUtils.isEmpty(sk1Var.H)) {
            k(sk1Var.H, sk1Var.d, sk1Var.V);
        }
    }

    @Nullable
    public static sk1 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i)) == null) {
            List<sk1> y = y(true, i);
            if (y != null && y.size() > 0) {
                for (int i2 = 0; i2 < y.size(); i2++) {
                    sk1 sk1Var = y.get(i2);
                    if (sk1Var != null && sk1Var.m() && e(sk1Var)) {
                        return sk1Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (sk1) invokeI.objValue;
    }

    @Nullable
    public static sk1 p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            List<sk1> x = x(false);
            if (b31.g(x)) {
                return null;
            }
            for (int i = 0; i < x.size(); i++) {
                sk1 sk1Var = x.get(i);
                if (sk1Var != null && TextUtils.equals(str, sk1Var.c)) {
                    return sk1Var;
                }
            }
            return null;
        }
        return (sk1) invokeL.objValue;
    }

    public static int g(sk1 sk1Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{sk1Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return h(sk1Var, z, i, System.currentTimeMillis());
        }
        return invokeCommon.intValue;
    }

    public static int h(sk1 sk1Var, boolean z, int i, long j) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{sk1Var, Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (sk1Var.k()) {
                if (!rk1.a(kk1.b())) {
                    i2 = 1024;
                } else {
                    i2 = 0;
                }
                if (uk1.a() >= rk1.d()) {
                    i2 |= 2048;
                }
                if (!rk1.c(true)) {
                    i2 |= 4096;
                }
                if (i2 != 0) {
                    return i2;
                }
            } else {
                i2 = 0;
            }
            if (sk1Var.y) {
                return i2;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = j / 1000;
            long c2 = uk1.c();
            if ((f61.a(System.currentTimeMillis(), j) < 2 && j2 < sk1Var.s) || j2 > sk1Var.t) {
                i2 |= 2;
            }
            if (z) {
                int i3 = sk1Var.x;
                int i4 = sk1Var.v;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - c2 < sk1Var.u * 60000) {
                i2 |= 16;
            }
            File r = r(sk1Var.g);
            if (r == null || !r.exists()) {
                i2 |= 4;
            }
            if (i == 1 && ek1.a().d() != null && ek1.a().d().optInt("hot_launch_splash_policy", 0) == 2 && TextUtils.equals(sk1Var.e, "splash_video")) {
                i2 |= 256;
            }
            long currentTimeMillis2 = (System.currentTimeMillis() - kk1.a()) / 1000;
            if (i == 1 && rk1.q() && sk1Var.Q > 0 && (System.currentTimeMillis() - kk1.a()) / 1000 < sk1Var.Q) {
                i2 |= 16384;
            }
            if (sk1Var.o() && rk1.M()) {
                return i2 | 32768;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static void i(@Nullable List<sk1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = o().listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (sk1 sk1Var : list) {
                        if (sk1Var != null) {
                            arrayList.add(m(sk1Var.g));
                            arrayList.add(m(sk1Var.z));
                            arrayList.add(m(sk1Var.H));
                        }
                    }
                    sk1 sk1Var2 = c;
                    if (sk1Var2 != null) {
                        arrayList.add(m(sk1Var2.g));
                        arrayList.add(m(c.z));
                        arrayList.add(m(c.H));
                    }
                    for (File file : listFiles) {
                        if (!arrayList.contains(file.getName())) {
                            file.delete();
                        }
                    }
                    return;
                }
                return;
            }
            j61.c(o());
        }
    }

    public static void k(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            File r = r(str);
            if (r != null && r.exists()) {
                return;
            }
            File u = u(k61.b(str, false));
            if (u.exists()) {
                u.delete();
            }
            s41.d(new a(u, str, r, str2, str3), "download splash resource");
        }
    }

    public static List<sk1> s() {
        InterceptResult invokeV;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            List<sk1> list = b;
            if (list != null) {
                return list;
            }
            b = new CopyOnWriteArrayList();
            File q = q();
            if (!q.exists() || (l = l(q)) == null) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(l);
                for (int i = 0; i < jSONArray.length(); i++) {
                    b.add(sk1.c(jSONArray.optJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return b;
        }
        return (List) invokeV.objValue;
    }

    public static HashMap<String, sk1> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            HashMap<String, sk1> hashMap = new HashMap<>();
            File q = q();
            if (!q.exists()) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(l(q));
                for (int i = 0; i < jSONArray.length(); i++) {
                    sk1 c2 = sk1.c((JSONObject) jSONArray.get(i));
                    hashMap.put(c2.b, c2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static List<sk1> y(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            List<sk1> s = s();
            if (s != null && s.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < s.size(); i3++) {
                    sk1 sk1Var = s.get(i3);
                    int g = g(sk1Var, z, i);
                    if (g == 0) {
                        arrayList.add(sk1Var);
                    } else {
                        i2 |= g;
                        try {
                            jSONObject.put(sk1Var.c, g);
                        } catch (JSONException unused) {
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    BaseVM.i(i2, jSONObject.toString());
                    return null;
                }
                return arrayList;
            }
            BaseVM.h(1);
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    public static boolean z(List<sk1> list, File file) {
        InterceptResult invokeLL;
        StringBuffer stringBuffer;
        int i;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, list, file)) == null) {
            int i2 = 0;
            if (list.size() <= 0) {
                return false;
            }
            FileWriter fileWriter2 = null;
            try {
                sk1[] sk1VarArr = (sk1[]) list.toArray(new sk1[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = sk1VarArr.length;
                while (true) {
                    i = length - 1;
                    if (i2 >= i) {
                        break;
                    }
                    stringBuffer.append(sk1VarArr[i2].s());
                    stringBuffer.append(",");
                    i2++;
                }
                stringBuffer.append(sk1VarArr[i].s());
                stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
                fileWriter = new FileWriter(file);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(stringBuffer.toString());
                try {
                    fileWriter.close();
                } catch (Exception unused2) {
                }
                return true;
            } catch (IOException unused3) {
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception unused4) {
                    }
                }
                return true;
            } catch (Throwable th2) {
                fileWriter2 = fileWriter;
                th = th2;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }
}
