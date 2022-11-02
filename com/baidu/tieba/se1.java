package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.mr0;
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
/* loaded from: classes5.dex */
public class se1 {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public static List<ue1> b;
    public static ue1 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;

        /* renamed from: com.baidu.tieba.se1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0416a implements mr0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0416a(a aVar) {
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

            @Override // com.baidu.tieba.mr0.b
            public void a(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                    ClogBuilder.LogType logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                    a aVar = this.a;
                    z01.b(new b11(logType, aVar.b, aVar.d, true).b(i, str, "download"));
                }
            }

            @Override // com.baidu.tieba.mr0.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a aVar = this.a;
                    se1.z(aVar.a, aVar.c);
                    re1.m().g();
                }
            }
        }

        public a(File file, String str, File file2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, file2, str2};
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
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    mr0.a(this.a, this.b, new C0416a(this));
                } catch (Exception e) {
                    z01.b(new b11(ClogBuilder.LogType.DOWNLOAD_FAILED, this.b, this.d, true).b(-1, e.getMessage(), "download"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue1 a;

        public b(ue1 ue1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                se1.B(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            ue1 ue1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.a) != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList(3);
                Iterator it = this.a.iterator();
                while (it.hasNext() && (ue1Var = (ue1) it.next()) != null) {
                    if (se1.u(ue1Var.w)) {
                        se1.i(ue1Var);
                    } else {
                        arrayList.add(ue1Var);
                    }
                }
                if (arrayList.size() > 0) {
                    if (se1.a == null) {
                        d unused = se1.a = new d(arrayList, null);
                        zi0.b().registerReceiver(se1.a, se1.a.getIntentFilter());
                        return;
                    }
                    se1.a.setNeedDownloadList(arrayList);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ue1> mNeedDownloadList;

        public d(List<ue1> list) {
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

        public void setNeedDownloadList(List<ue1> list) {
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
                return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            }
            return (IntentFilter) invokeV.objValue;
        }

        public List<ue1> getNeedDownloadList() {
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
                if (!TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (ue1 ue1Var : this.mNeedDownloadList) {
                    if (se1.u(ue1Var.w)) {
                        Log.d("SourceManager", "onReceive: " + ue1Var);
                        se1.i(ue1Var);
                    } else {
                        arrayList.add(ue1Var);
                    }
                }
                this.mNeedDownloadList = arrayList;
            }
        }
    }

    public static void A(List<ue1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, list) == null) {
            a21.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }

    public static void C(ue1 ue1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, ue1Var) == null) && ue1Var.v >= 1) {
            int i = ue1Var.x;
            if (i < Integer.MAX_VALUE) {
                ue1Var.x = i + 1;
            }
            a21.d(new b(ue1Var), "updateSplashDataItemRate");
        }
    }

    public static void D(List<ue1> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, list) == null) && list != null && list.size() != 0) {
            b = Collections.synchronizedList(list);
            y(list, p());
        }
    }

    public static File q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            String l = l(str);
            if (TextUtils.isEmpty(l)) {
                return null;
            }
            return new File(n(), l);
        }
        return (File) invokeL.objValue;
    }

    public static File t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".tmp");
            return new File(n(), stringBuffer.toString());
        }
        return (File) invokeL.objValue;
    }

    public static boolean u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i)) == null) {
            if (new zq0(zi0.b()).a() || i == 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static List<ue1> w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65562, null, z)) == null) {
            return x(z, 0);
        }
        return (List) invokeZ.objValue;
    }

    public static void B(ue1 ue1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ue1Var) == null) {
            ArrayList arrayList = new ArrayList();
            File p = p();
            List<ue1> r = r();
            if (r != null && r.size() != 0) {
                for (int i = 0; i < r.size(); i++) {
                    ue1 ue1Var2 = r.get(i);
                    if (TextUtils.equals(ue1Var.b, ue1Var2.b)) {
                        ue1.m(ue1Var2, ue1Var);
                        arrayList.add(ue1Var2);
                    } else {
                        arrayList.add(ue1Var2);
                    }
                }
                y(arrayList, p);
            }
        }
    }

    public static String k(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, file)) == null) {
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

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(q31.b(str, false));
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

    public static int e(ue1 ue1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, ue1Var, i)) == null) {
            return f(ue1Var, false, i);
        }
        return invokeLI.intValue;
    }

    public static boolean z(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, file, file2)) == null) {
            if (file != null && file2 != null) {
                return file.renameTo(file2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static File n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            File file = new File(zi0.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
            file.mkdirs();
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return new File(n(), "splash.dat");
        }
        return (File) invokeV.objValue;
    }

    public static List<ue1> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return x(false, 0);
        }
        return (List) invokeV.objValue;
    }

    public static int f(ue1 ue1Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{ue1Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return g(ue1Var, z, i, System.currentTimeMillis());
        }
        return invokeCommon.intValue;
    }

    public static int g(ue1 ue1Var, boolean z, int i, long j) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{ue1Var, Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (ue1Var.g()) {
                if (!te1.a(me1.b())) {
                    i2 = 1024;
                } else {
                    i2 = 0;
                }
                if (we1.a() >= te1.d()) {
                    i2 |= 2048;
                }
                if (!te1.c(true)) {
                    i2 |= 4096;
                }
                if (i2 != 0) {
                    return i2;
                }
            } else {
                i2 = 0;
            }
            if (ue1Var.y) {
                return i2;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = j / 1000;
            long c2 = we1.c();
            if ((l31.a(System.currentTimeMillis(), j) < 2 && j2 < ue1Var.s) || j2 > ue1Var.t) {
                i2 |= 2;
            }
            if (z) {
                int i3 = ue1Var.x;
                int i4 = ue1Var.v;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - c2 < ue1Var.u * 60000) {
                i2 |= 16;
            }
            File q = q(ue1Var.g);
            if (q == null || !q.exists()) {
                i2 |= 4;
            }
            if (i == 1 && ge1.a().d() != null && ge1.a().d().optInt("hot_launch_splash_policy", 0) == 2 && TextUtils.equals(ue1Var.e, "splash_video")) {
                i2 |= 256;
            }
            long currentTimeMillis2 = (System.currentTimeMillis() - me1.a()) / 1000;
            if (i == 1 && te1.q() && ue1Var.Q > 0 && (System.currentTimeMillis() - me1.a()) / 1000 < ue1Var.Q) {
                return i2 | 16384;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static void h(@Nullable List<ue1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = n().listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (ue1 ue1Var : list) {
                        if (ue1Var != null) {
                            arrayList.add(l(ue1Var.g));
                            arrayList.add(l(ue1Var.z));
                            arrayList.add(l(ue1Var.H));
                        }
                    }
                    ue1 ue1Var2 = c;
                    if (ue1Var2 != null) {
                        arrayList.add(l(ue1Var2.g));
                        arrayList.add(l(c.z));
                        arrayList.add(l(c.H));
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
            p31.c(n());
        }
    }

    public static void i(ue1 ue1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65548, null, ue1Var) != null) || !URLUtil.isNetworkUrl(ue1Var.g)) {
            return;
        }
        j(ue1Var.g, ue1Var.d);
        if (!TextUtils.isEmpty(ue1Var.z)) {
            j(ue1Var.z, ue1Var.d);
        }
        if (!TextUtils.isEmpty(ue1Var.H)) {
            j(ue1Var.H, ue1Var.d);
        }
    }

    @Nullable
    public static ue1 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            List<ue1> x = x(true, i);
            if (x != null && x.size() > 0) {
                for (int i2 = 0; i2 < x.size(); i2++) {
                    ue1 ue1Var = x.get(i2);
                    if (ue1Var != null && ue1Var.i()) {
                        return ue1Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (ue1) invokeI.objValue;
    }

    @Nullable
    public static ue1 o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            List<ue1> w = w(false);
            if (o01.g(w)) {
                return null;
            }
            for (int i = 0; i < w.size(); i++) {
                ue1 ue1Var = w.get(i);
                if (ue1Var != null && TextUtils.equals(str, ue1Var.c)) {
                    return ue1Var;
                }
            }
            return null;
        }
        return (ue1) invokeL.objValue;
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            File q = q(str);
            if (q != null && q.exists()) {
                return;
            }
            File t = t(q31.b(str, false));
            if (t.exists()) {
                t.delete();
            }
            a21.d(new a(t, str, q, str2), "download splash resource");
        }
    }

    public static List<ue1> r() {
        InterceptResult invokeV;
        String k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            List<ue1> list = b;
            if (list != null) {
                return list;
            }
            b = new CopyOnWriteArrayList();
            File p = p();
            if (!p.exists() || (k = k(p)) == null) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(k);
                for (int i = 0; i < jSONArray.length(); i++) {
                    b.add(ue1.b(jSONArray.optJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return b;
        }
        return (List) invokeV.objValue;
    }

    public static HashMap<String, ue1> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            HashMap<String, ue1> hashMap = new HashMap<>();
            File p = p();
            if (!p.exists()) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(k(p));
                for (int i = 0; i < jSONArray.length(); i++) {
                    ue1 b2 = ue1.b((JSONObject) jSONArray.get(i));
                    hashMap.put(b2.b, b2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static List<ue1> x(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            List<ue1> r = r();
            if (r != null && r.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < r.size(); i3++) {
                    ue1 ue1Var = r.get(i3);
                    int f = f(ue1Var, z, i);
                    if (f == 0) {
                        arrayList.add(ue1Var);
                    } else {
                        i2 |= f;
                        try {
                            jSONObject.put(ue1Var.c, f);
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

    public static boolean y(List<ue1> list, File file) {
        InterceptResult invokeLL;
        StringBuffer stringBuffer;
        int i;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, list, file)) == null) {
            int i2 = 0;
            if (list.size() <= 0) {
                return false;
            }
            FileWriter fileWriter2 = null;
            try {
                ue1[] ue1VarArr = (ue1[]) list.toArray(new ue1[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = ue1VarArr.length;
                while (true) {
                    i = length - 1;
                    if (i2 >= i) {
                        break;
                    }
                    stringBuffer.append(ue1VarArr[i2].l());
                    stringBuffer.append(",");
                    i2++;
                }
                stringBuffer.append(ue1VarArr[i].l());
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
