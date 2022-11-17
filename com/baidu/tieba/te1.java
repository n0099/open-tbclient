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
import com.baidu.tieba.nr0;
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
public class te1 {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public static List<ve1> b;
    public static ve1 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;

        /* renamed from: com.baidu.tieba.te1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0432a implements nr0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0432a(a aVar) {
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

            @Override // com.baidu.tieba.nr0.b
            public void a(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                    ClogBuilder.LogType logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                    a aVar = this.a;
                    a11.b(new c11(logType, aVar.b, aVar.d, true).b(i, str, "download"));
                }
            }

            @Override // com.baidu.tieba.nr0.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a aVar = this.a;
                    te1.z(aVar.a, aVar.c);
                    se1.m().g();
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
                    nr0.a(this.a, this.b, new C0432a(this));
                } catch (Exception e) {
                    a11.b(new c11(ClogBuilder.LogType.DOWNLOAD_FAILED, this.b, this.d, true).b(-1, e.getMessage(), "download"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve1 a;

        public b(ve1 ve1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                te1.B(this.a);
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
            ve1 ve1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.a) != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList(3);
                Iterator it = this.a.iterator();
                while (it.hasNext() && (ve1Var = (ve1) it.next()) != null) {
                    if (te1.u(ve1Var.w)) {
                        te1.i(ve1Var);
                    } else {
                        arrayList.add(ve1Var);
                    }
                }
                if (arrayList.size() > 0) {
                    if (te1.a == null) {
                        d unused = te1.a = new d(arrayList, null);
                        aj0.b().registerReceiver(te1.a, te1.a.getIntentFilter());
                        return;
                    }
                    te1.a.setNeedDownloadList(arrayList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ve1> mNeedDownloadList;

        public d(List<ve1> list) {
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

        public void setNeedDownloadList(List<ve1> list) {
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

        public List<ve1> getNeedDownloadList() {
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
                for (ve1 ve1Var : this.mNeedDownloadList) {
                    if (te1.u(ve1Var.w)) {
                        Log.d("SourceManager", "onReceive: " + ve1Var);
                        te1.i(ve1Var);
                    } else {
                        arrayList.add(ve1Var);
                    }
                }
                this.mNeedDownloadList = arrayList;
            }
        }
    }

    public static void A(List<ve1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, list) == null) {
            b21.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }

    public static void C(ve1 ve1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, ve1Var) == null) && ve1Var.v >= 1) {
            int i = ve1Var.x;
            if (i < Integer.MAX_VALUE) {
                ve1Var.x = i + 1;
            }
            b21.d(new b(ve1Var), "updateSplashDataItemRate");
        }
    }

    public static void D(List<ve1> list) {
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
            if (new ar0(aj0.b()).a() || i == 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static List<ve1> w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65562, null, z)) == null) {
            return x(z, 0);
        }
        return (List) invokeZ.objValue;
    }

    public static void B(ve1 ve1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ve1Var) == null) {
            ArrayList arrayList = new ArrayList();
            File p = p();
            List<ve1> r = r();
            if (r != null && r.size() != 0) {
                for (int i = 0; i < r.size(); i++) {
                    ve1 ve1Var2 = r.get(i);
                    if (TextUtils.equals(ve1Var.b, ve1Var2.b)) {
                        ve1.m(ve1Var2, ve1Var);
                        arrayList.add(ve1Var2);
                    } else {
                        arrayList.add(ve1Var2);
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
            sb.append(r31.b(str, false));
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

    public static int e(ve1 ve1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, ve1Var, i)) == null) {
            return f(ve1Var, false, i);
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
            File file = new File(aj0.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
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

    public static List<ve1> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return x(false, 0);
        }
        return (List) invokeV.objValue;
    }

    public static int f(ve1 ve1Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{ve1Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return g(ve1Var, z, i, System.currentTimeMillis());
        }
        return invokeCommon.intValue;
    }

    public static int g(ve1 ve1Var, boolean z, int i, long j) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{ve1Var, Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (ve1Var.g()) {
                if (!ue1.a(ne1.b())) {
                    i2 = 1024;
                } else {
                    i2 = 0;
                }
                if (xe1.a() >= ue1.d()) {
                    i2 |= 2048;
                }
                if (!ue1.c(true)) {
                    i2 |= 4096;
                }
                if (i2 != 0) {
                    return i2;
                }
            } else {
                i2 = 0;
            }
            if (ve1Var.y) {
                return i2;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = j / 1000;
            long c2 = xe1.c();
            if ((m31.a(System.currentTimeMillis(), j) < 2 && j2 < ve1Var.s) || j2 > ve1Var.t) {
                i2 |= 2;
            }
            if (z) {
                int i3 = ve1Var.x;
                int i4 = ve1Var.v;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - c2 < ve1Var.u * 60000) {
                i2 |= 16;
            }
            File q = q(ve1Var.g);
            if (q == null || !q.exists()) {
                i2 |= 4;
            }
            if (i == 1 && he1.a().d() != null && he1.a().d().optInt("hot_launch_splash_policy", 0) == 2 && TextUtils.equals(ve1Var.e, "splash_video")) {
                i2 |= 256;
            }
            long currentTimeMillis2 = (System.currentTimeMillis() - ne1.a()) / 1000;
            if (i == 1 && ue1.q() && ve1Var.Q > 0 && (System.currentTimeMillis() - ne1.a()) / 1000 < ve1Var.Q) {
                return i2 | 16384;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static void h(@Nullable List<ve1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = n().listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (ve1 ve1Var : list) {
                        if (ve1Var != null) {
                            arrayList.add(l(ve1Var.g));
                            arrayList.add(l(ve1Var.z));
                            arrayList.add(l(ve1Var.H));
                        }
                    }
                    ve1 ve1Var2 = c;
                    if (ve1Var2 != null) {
                        arrayList.add(l(ve1Var2.g));
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
            q31.c(n());
        }
    }

    public static void i(ve1 ve1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65548, null, ve1Var) != null) || !URLUtil.isNetworkUrl(ve1Var.g)) {
            return;
        }
        j(ve1Var.g, ve1Var.d);
        if (!TextUtils.isEmpty(ve1Var.z)) {
            j(ve1Var.z, ve1Var.d);
        }
        if (!TextUtils.isEmpty(ve1Var.H)) {
            j(ve1Var.H, ve1Var.d);
        }
    }

    @Nullable
    public static ve1 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            List<ve1> x = x(true, i);
            if (x != null && x.size() > 0) {
                for (int i2 = 0; i2 < x.size(); i2++) {
                    ve1 ve1Var = x.get(i2);
                    if (ve1Var != null && ve1Var.i()) {
                        return ve1Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (ve1) invokeI.objValue;
    }

    @Nullable
    public static ve1 o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            List<ve1> w = w(false);
            if (p01.g(w)) {
                return null;
            }
            for (int i = 0; i < w.size(); i++) {
                ve1 ve1Var = w.get(i);
                if (ve1Var != null && TextUtils.equals(str, ve1Var.c)) {
                    return ve1Var;
                }
            }
            return null;
        }
        return (ve1) invokeL.objValue;
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            File q = q(str);
            if (q != null && q.exists()) {
                return;
            }
            File t = t(r31.b(str, false));
            if (t.exists()) {
                t.delete();
            }
            b21.d(new a(t, str, q, str2), "download splash resource");
        }
    }

    public static List<ve1> r() {
        InterceptResult invokeV;
        String k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            List<ve1> list = b;
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
                    b.add(ve1.b(jSONArray.optJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return b;
        }
        return (List) invokeV.objValue;
    }

    public static HashMap<String, ve1> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            HashMap<String, ve1> hashMap = new HashMap<>();
            File p = p();
            if (!p.exists()) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(k(p));
                for (int i = 0; i < jSONArray.length(); i++) {
                    ve1 b2 = ve1.b((JSONObject) jSONArray.get(i));
                    hashMap.put(b2.b, b2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static List<ve1> x(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            List<ve1> r = r();
            if (r != null && r.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < r.size(); i3++) {
                    ve1 ve1Var = r.get(i3);
                    int f = f(ve1Var, z, i);
                    if (f == 0) {
                        arrayList.add(ve1Var);
                    } else {
                        i2 |= f;
                        try {
                            jSONObject.put(ve1Var.c, f);
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

    public static boolean y(List<ve1> list, File file) {
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
                ve1[] ve1VarArr = (ve1[]) list.toArray(new ve1[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = ve1VarArr.length;
                while (true) {
                    i = length - 1;
                    if (i2 >= i) {
                        break;
                    }
                    stringBuffer.append(ve1VarArr[i2].l());
                    stringBuffer.append(",");
                    i2++;
                }
                stringBuffer.append(ve1VarArr[i].l());
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
