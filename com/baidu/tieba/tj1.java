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
import com.baidu.tieba.bt0;
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
public class tj1 {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public static List<vj1> b;
    public static vj1 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        /* renamed from: com.baidu.tieba.tj1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0427a implements bt0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0427a(a aVar) {
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

            @Override // com.baidu.tieba.bt0.b
            public void a(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                    ClogBuilder.LogType logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                    a aVar = this.a;
                    u21.b(new w21(logType, aVar.b, aVar.d, true).b(i, str, "download"));
                }
            }

            @Override // com.baidu.tieba.bt0.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a aVar = this.a;
                    tj1.A(aVar.a, aVar.c);
                    sj1.m().g();
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
                    bt0.a(this.a, this.b, new C0427a(this), this.e);
                } catch (Exception e) {
                    u21.b(new w21(ClogBuilder.LogType.DOWNLOAD_FAILED, this.b, this.d, true).b(-1, e.getMessage(), "download"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj1 a;

        public b(vj1 vj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tj1.C(this.a);
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
            vj1 vj1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.a) != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList(3);
                Iterator it = this.a.iterator();
                while (it.hasNext() && (vj1Var = (vj1) it.next()) != null) {
                    if (tj1.v(vj1Var.w)) {
                        tj1.j(vj1Var);
                    } else {
                        arrayList.add(vj1Var);
                    }
                }
                if (arrayList.size() > 0) {
                    if (tj1.a == null) {
                        d unused = tj1.a = new d(arrayList, null);
                        rj0.b().registerReceiver(tj1.a, tj1.a.getIntentFilter());
                        return;
                    }
                    tj1.a.setNeedDownloadList(arrayList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<vj1> mNeedDownloadList;

        public d(List<vj1> list) {
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

        public void setNeedDownloadList(List<vj1> list) {
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

        public List<vj1> getNeedDownloadList() {
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
                for (vj1 vj1Var : this.mNeedDownloadList) {
                    if (tj1.v(vj1Var.w)) {
                        Log.d("SourceManager", "onReceive: " + vj1Var);
                        tj1.j(vj1Var);
                    } else {
                        arrayList.add(vj1Var);
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

    public static int f(vj1 vj1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, vj1Var, i)) == null) {
            return g(vj1Var, false, i);
        }
        return invokeLI.intValue;
    }

    public static void B(List<vj1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, list) == null) {
            v31.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }

    public static void D(vj1 vj1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, vj1Var) == null) && vj1Var.v >= 1) {
            int i = vj1Var.x;
            if (i < Integer.MAX_VALUE) {
                vj1Var.x = i + 1;
            }
            v31.d(new b(vj1Var), "updateSplashDataItemRate");
        }
    }

    public static void E(List<vj1> list) {
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
            if (new os0(rj0.b()).a() || i == 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static List<vj1> x(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65564, null, z)) == null) {
            return y(z, 0);
        }
        return (List) invokeZ.objValue;
    }

    public static void C(vj1 vj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, vj1Var) == null) {
            ArrayList arrayList = new ArrayList();
            File q = q();
            List<vj1> s = s();
            if (s != null && s.size() != 0) {
                for (int i = 0; i < s.size(); i++) {
                    vj1 vj1Var2 = s.get(i);
                    if (TextUtils.equals(vj1Var.b, vj1Var2.b)) {
                        vj1.t(vj1Var2, vj1Var);
                        arrayList.add(vj1Var2);
                    } else {
                        arrayList.add(vj1Var2);
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
            sb.append(n51.b(str, false));
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
            File file = new File(rj0.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
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

    public static List<vj1> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return y(false, 0);
        }
        return (List) invokeV.objValue;
    }

    public static boolean e(@NonNull vj1 vj1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, vj1Var)) == null) {
            long j = vj1Var.R;
            long j2 = vj1Var.S;
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

    public static void j(vj1 vj1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65550, null, vj1Var) != null) || !URLUtil.isNetworkUrl(vj1Var.g)) {
            return;
        }
        k(vj1Var.g, vj1Var.d, vj1Var.V);
        if (!TextUtils.isEmpty(vj1Var.z)) {
            k(vj1Var.z, vj1Var.d, vj1Var.V);
        }
        if (!TextUtils.isEmpty(vj1Var.H)) {
            k(vj1Var.H, vj1Var.d, vj1Var.V);
        }
    }

    @Nullable
    public static vj1 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i)) == null) {
            List<vj1> y = y(true, i);
            if (y != null && y.size() > 0) {
                for (int i2 = 0; i2 < y.size(); i2++) {
                    vj1 vj1Var = y.get(i2);
                    if (vj1Var != null && vj1Var.m() && e(vj1Var)) {
                        return vj1Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (vj1) invokeI.objValue;
    }

    @Nullable
    public static vj1 p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            List<vj1> x = x(false);
            if (e21.g(x)) {
                return null;
            }
            for (int i = 0; i < x.size(); i++) {
                vj1 vj1Var = x.get(i);
                if (vj1Var != null && TextUtils.equals(str, vj1Var.c)) {
                    return vj1Var;
                }
            }
            return null;
        }
        return (vj1) invokeL.objValue;
    }

    public static int g(vj1 vj1Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{vj1Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return h(vj1Var, z, i, System.currentTimeMillis());
        }
        return invokeCommon.intValue;
    }

    public static int h(vj1 vj1Var, boolean z, int i, long j) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{vj1Var, Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (vj1Var.k()) {
                if (!uj1.a(nj1.b())) {
                    i2 = 1024;
                } else {
                    i2 = 0;
                }
                if (xj1.a() >= uj1.d()) {
                    i2 |= 2048;
                }
                if (!uj1.c(true)) {
                    i2 |= 4096;
                }
                if (i2 != 0) {
                    return i2;
                }
            } else {
                i2 = 0;
            }
            if (vj1Var.y) {
                return i2;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = j / 1000;
            long c2 = xj1.c();
            if ((i51.a(System.currentTimeMillis(), j) < 2 && j2 < vj1Var.s) || j2 > vj1Var.t) {
                i2 |= 2;
            }
            if (z) {
                int i3 = vj1Var.x;
                int i4 = vj1Var.v;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - c2 < vj1Var.u * 60000) {
                i2 |= 16;
            }
            File r = r(vj1Var.g);
            if (r == null || !r.exists()) {
                i2 |= 4;
            }
            if (i == 1 && hj1.a().d() != null && hj1.a().d().optInt("hot_launch_splash_policy", 0) == 2 && TextUtils.equals(vj1Var.e, "splash_video")) {
                i2 |= 256;
            }
            long currentTimeMillis2 = (System.currentTimeMillis() - nj1.a()) / 1000;
            if (i == 1 && uj1.q() && vj1Var.Q > 0 && (System.currentTimeMillis() - nj1.a()) / 1000 < vj1Var.Q) {
                i2 |= 16384;
            }
            if (vj1Var.o() && uj1.M()) {
                return i2 | 32768;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static void i(@Nullable List<vj1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = o().listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (vj1 vj1Var : list) {
                        if (vj1Var != null) {
                            arrayList.add(m(vj1Var.g));
                            arrayList.add(m(vj1Var.z));
                            arrayList.add(m(vj1Var.H));
                        }
                    }
                    vj1 vj1Var2 = c;
                    if (vj1Var2 != null) {
                        arrayList.add(m(vj1Var2.g));
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
            m51.c(o());
        }
    }

    public static void k(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            File r = r(str);
            if (r != null && r.exists()) {
                return;
            }
            File u = u(n51.b(str, false));
            if (u.exists()) {
                u.delete();
            }
            v31.d(new a(u, str, r, str2, str3), "download splash resource");
        }
    }

    public static List<vj1> s() {
        InterceptResult invokeV;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            List<vj1> list = b;
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
                    b.add(vj1.c(jSONArray.optJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return b;
        }
        return (List) invokeV.objValue;
    }

    public static HashMap<String, vj1> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            HashMap<String, vj1> hashMap = new HashMap<>();
            File q = q();
            if (!q.exists()) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(l(q));
                for (int i = 0; i < jSONArray.length(); i++) {
                    vj1 c2 = vj1.c((JSONObject) jSONArray.get(i));
                    hashMap.put(c2.b, c2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static List<vj1> y(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            List<vj1> s = s();
            if (s != null && s.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < s.size(); i3++) {
                    vj1 vj1Var = s.get(i3);
                    int g = g(vj1Var, z, i);
                    if (g == 0) {
                        arrayList.add(vj1Var);
                    } else {
                        i2 |= g;
                        try {
                            jSONObject.put(vj1Var.c, g);
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

    public static boolean z(List<vj1> list, File file) {
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
                vj1[] vj1VarArr = (vj1[]) list.toArray(new vj1[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = vj1VarArr.length;
                while (true) {
                    i = length - 1;
                    if (i2 >= i) {
                        break;
                    }
                    stringBuffer.append(vj1VarArr[i2].s());
                    stringBuffer.append(",");
                    i2++;
                }
                stringBuffer.append(vj1VarArr[i].s());
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
