package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.uq0;
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
/* loaded from: classes6.dex */
public class zd1 {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public static List<be1> b;
    public static be1 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;

        /* renamed from: com.baidu.tieba.zd1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0479a implements uq0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0479a(a aVar) {
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

            @Override // com.baidu.tieba.uq0.b
            public void a(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                    ClogBuilder.LogType logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                    a aVar = this.a;
                    h01.b(new j01(logType, aVar.b, aVar.d, true).b(i, str, "download"));
                }
            }

            @Override // com.baidu.tieba.uq0.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a aVar = this.a;
                    zd1.A(aVar.a, aVar.c);
                    yd1.m().g();
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
                    uq0.a(this.a, this.b, new C0479a(this));
                } catch (Exception e) {
                    h01.b(new j01(ClogBuilder.LogType.DOWNLOAD_FAILED, this.b, this.d, true).b(-1, e.getMessage(), "download"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ be1 a;

        public b(be1 be1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = be1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zd1.C(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            be1 be1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(3);
            Iterator it = this.a.iterator();
            while (it.hasNext() && (be1Var = (be1) it.next()) != null) {
                if (zd1.w(be1Var.w)) {
                    zd1.k(be1Var);
                } else {
                    arrayList.add(be1Var);
                }
            }
            if (arrayList.size() > 0) {
                if (zd1.a == null) {
                    d unused = zd1.a = new d(arrayList, null);
                    zi0.b().registerReceiver(zd1.a, zd1.a.getIntentFilter());
                    return;
                }
                zd1.a.setNeedDownloadList(arrayList);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<be1> mNeedDownloadList;

        public /* synthetic */ d(List list, a aVar) {
            this(list);
        }

        public IntentFilter getIntentFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE") : (IntentFilter) invokeV.objValue;
        }

        public List<be1> getNeedDownloadList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mNeedDownloadList : (List) invokeV.objValue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) {
                Log.d("SourceManager", "onReceive: receiver");
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                    ArrayList arrayList = new ArrayList();
                    for (be1 be1Var : this.mNeedDownloadList) {
                        if (zd1.w(be1Var.w)) {
                            Log.d("SourceManager", "onReceive: " + be1Var);
                            zd1.k(be1Var);
                        } else {
                            arrayList.add(be1Var);
                        }
                    }
                    this.mNeedDownloadList = arrayList;
                }
            }
        }

        public void setNeedDownloadList(List<be1> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.mNeedDownloadList = list;
            }
        }

        public d(List<be1> list) {
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
    }

    public static boolean A(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, file, file2)) == null) {
            if (file == null || file2 == null) {
                return false;
            }
            return file.renameTo(file2);
        }
        return invokeLL.booleanValue;
    }

    public static void B(List<be1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, list) == null) {
            i11.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }

    public static void C(be1 be1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, be1Var) == null) {
            ArrayList arrayList = new ArrayList();
            File r = r();
            List<be1> t = t();
            if (t == null || t.size() == 0) {
                return;
            }
            for (int i = 0; i < t.size(); i++) {
                be1 be1Var2 = t.get(i);
                if (TextUtils.equals(be1Var.b, be1Var2.b)) {
                    be1.l(be1Var2, be1Var);
                    arrayList.add(be1Var2);
                } else {
                    arrayList.add(be1Var2);
                }
            }
            z(arrayList, r);
        }
    }

    public static void D(be1 be1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, be1Var) == null) || be1Var.v < 1) {
            return;
        }
        int i = be1Var.x;
        if (i < Integer.MAX_VALUE) {
            be1Var.x = i + 1;
        }
        i11.d(new b(be1Var), "updateSplashDataItemRate");
    }

    public static void E(List<be1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) || list == null || list.size() == 0) {
            return;
        }
        b = Collections.synchronizedList(list);
        z(list, r());
    }

    public static int e(be1 be1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, be1Var)) == null) ? h(be1Var, false, 0) : invokeL.intValue;
    }

    public static int f(be1 be1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, be1Var, i)) == null) ? h(be1Var, false, i) : invokeLI.intValue;
    }

    public static int g(be1 be1Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, null, be1Var, j)) == null) ? i(be1Var, false, 0, j) : invokeLJ.intValue;
    }

    public static int h(be1 be1Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{be1Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) ? i(be1Var, z, i, System.currentTimeMillis()) : invokeCommon.intValue;
    }

    public static int i(be1 be1Var, boolean z, int i, long j) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{be1Var, Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (be1Var.f()) {
                i2 = !ae1.a(td1.a()) ? 1024 : 0;
                if (de1.a() >= ae1.d()) {
                    i2 |= 2048;
                }
                if (!ae1.c(true)) {
                    i2 |= 4096;
                }
                if (i2 != 0) {
                    return i2;
                }
            } else {
                i2 = 0;
            }
            if (be1Var.y) {
                return i2;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = j / 1000;
            long c2 = de1.c();
            if ((s21.a(System.currentTimeMillis(), j) < 2 && j2 < be1Var.s) || j2 > be1Var.t) {
                i2 |= 2;
            }
            if (z) {
                int i3 = be1Var.x;
                int i4 = be1Var.v;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - c2 < be1Var.u * 60000) {
                i2 |= 16;
            }
            File s = s(be1Var.g);
            if (s == null || !s.exists()) {
                i2 |= 4;
            }
            return (i == 1 && nd1.a().d() != null && nd1.a().d().optInt("hot_launch_splash_policy", 0) == 2 && TextUtils.equals(be1Var.e, "splash_video")) ? i2 | 256 : i2;
        }
        return invokeCommon.intValue;
    }

    public static void j(@Nullable List<be1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = q().listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (be1 be1Var : list) {
                    if (be1Var != null) {
                        arrayList.add(n(be1Var.g));
                        arrayList.add(n(be1Var.z));
                        arrayList.add(n(be1Var.H));
                    }
                }
                be1 be1Var2 = c;
                if (be1Var2 != null) {
                    arrayList.add(n(be1Var2.g));
                    arrayList.add(n(c.z));
                    arrayList.add(n(c.H));
                }
                for (File file : listFiles) {
                    if (!arrayList.contains(file.getName())) {
                        file.delete();
                    }
                }
                return;
            }
            w21.c(q());
        }
    }

    public static void k(be1 be1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, null, be1Var) == null) && URLUtil.isNetworkUrl(be1Var.g)) {
            l(be1Var.g, be1Var.d);
            if (!TextUtils.isEmpty(be1Var.z)) {
                l(be1Var.z, be1Var.d);
            }
            if (TextUtils.isEmpty(be1Var.H)) {
                return;
            }
            l(be1Var.H, be1Var.d);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            File s = s(str);
            if (s == null || !s.exists()) {
                File v = v(x21.b(str, false));
                if (v.exists()) {
                    v.delete();
                }
                i11.d(new a(v, str, s, str2), "download splash resource");
            }
        }
    }

    public static String m(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, file)) == null) {
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

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(x21.b(str, false));
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

    @Nullable
    public static be1 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? p(0) : (be1) invokeV.objValue;
    }

    @Nullable
    public static be1 p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            List<be1> y = y(true, i);
            if (y == null || y.size() <= 0) {
                return null;
            }
            for (int i2 = 0; i2 < y.size(); i2++) {
                be1 be1Var = y.get(i2);
                if (be1Var != null && be1Var.h()) {
                    return be1Var;
                }
            }
            return null;
        }
        return (be1) invokeI.objValue;
    }

    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            File file = new File(zi0.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
            file.mkdirs();
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? new File(q(), "splash.dat") : (File) invokeV.objValue;
    }

    public static File s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            String n = n(str);
            if (TextUtils.isEmpty(n)) {
                return null;
            }
            return new File(q(), n);
        }
        return (File) invokeL.objValue;
    }

    public static List<be1> t() {
        InterceptResult invokeV;
        String m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            List<be1> list = b;
            if (list != null) {
                return list;
            }
            b = new CopyOnWriteArrayList();
            File r = r();
            if (r.exists() && (m = m(r)) != null) {
                try {
                    JSONArray jSONArray = new JSONArray(m);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        b.add(be1.b(jSONArray.optJSONObject(i)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return b;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public static HashMap<String, be1> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            HashMap<String, be1> hashMap = new HashMap<>();
            File r = r();
            if (r.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(m(r));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        be1 b2 = be1.b((JSONObject) jSONArray.get(i));
                        hashMap.put(b2.b, b2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return hashMap;
            }
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public static File v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".tmp");
            return new File(q(), stringBuffer.toString());
        }
        return (File) invokeL.objValue;
    }

    public static boolean w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65563, null, i)) == null) ? new hq0(zi0.b()).a() || i == 0 : invokeI.booleanValue;
    }

    public static List<be1> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? y(false, 0) : (List) invokeV.objValue;
    }

    public static List<be1> y(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            List<be1> t = t();
            if (t != null && t.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < t.size(); i3++) {
                    be1 be1Var = t.get(i3);
                    int h = h(be1Var, z, i);
                    if (h == 0) {
                        arrayList.add(be1Var);
                    } else {
                        i2 |= h;
                        try {
                            jSONObject.put(be1Var.c, h);
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

    public static boolean z(List<be1> list, File file) {
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
                be1[] be1VarArr = (be1[]) list.toArray(new be1[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = be1VarArr.length;
                while (true) {
                    i = length - 1;
                    if (i2 >= i) {
                        break;
                    }
                    stringBuffer.append(be1VarArr[i2].k());
                    stringBuffer.append(",");
                    i2++;
                }
                stringBuffer.append(be1VarArr[i].k());
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
