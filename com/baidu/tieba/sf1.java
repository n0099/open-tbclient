package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.nps.interfa.IPackageGetCallback;
import com.baidu.nps.interfa.ISharePrefsWrapper;
import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.SubBundleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.NPSPatch;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sf1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final int g;
    public static sf1 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Map<String, BundleInfo> b;
    public Set<String> c;

    /* loaded from: classes7.dex */
    public class b implements IPackageDownloadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ BundleInfo b;
        public final /* synthetic */ d c;
        public final /* synthetic */ CountDownLatch d;
        public final /* synthetic */ sf1 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ b b;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context context = this.b.a;
                    File g = dg1.g(context, this.b.b.getPackageName() + Constant.FILE.SUFFIX.APK_PATCH_SUFFIX);
                    Context context2 = this.b.a;
                    File g2 = dg1.g(context2, this.b.b.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                    b bVar = this.b;
                    String c = bVar.e.c(g2, g, this.a, bVar.b);
                    if (TextUtils.isEmpty(c)) {
                        this.b.c.a = 52;
                    } else {
                        if (this.b.e.w(new File(c), g2)) {
                            this.b.c.a = 2;
                        } else {
                            this.b.c.a = 11;
                        }
                    }
                    this.b.d.countDown();
                }
            }
        }

        /* renamed from: com.baidu.tieba.sf1$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0448b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ b b;

            public RunnableC0448b(b bVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.b;
                    bVar.c.a = this.a;
                    if (bVar.b.getDownloadType() == 2) {
                        this.b.c.a = 52;
                    }
                    this.b.d.countDown();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ b c;

            public c(b bVar, long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = j;
                this.b = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.a.getContentResolver().notifyChange(kg1.c(this.c.b.getPackageName(), this.a, this.b), null);
                }
            }
        }

        public b(sf1 sf1Var, Context context, BundleInfo bundleInfo, d dVar, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf1Var, context, bundleInfo, dVar, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sf1Var;
            this.a = context;
            this.b = bundleInfo;
            this.c = dVar;
            this.d = countDownLatch;
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadFail(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
                if1.a().b().run(new RunnableC0448b(this, i));
            }
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadSuccess(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                if1.a().b().run(new a(this, str2));
            }
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onProgress(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if1.a().b().run(new c(this, j, j2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements IPackageGetCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ CountDownLatch b;

        public a(sf1 sf1Var, d dVar, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf1Var, dVar, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.b = countDownLatch;
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                d dVar = this.a;
                dVar.a = i;
                dVar.b = new ArrayList();
                this.b.countDown();
            }
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetSuccess(List<IBundleInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                d dVar = this.a;
                dVar.a = 0;
                if (list == null) {
                    list = new ArrayList<>();
                }
                dVar.b = list;
                this.b.countDown();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BundleInfo a;
        public final /* synthetic */ String b;

        public c(sf1 sf1Var, BundleInfo bundleInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf1Var, bundleInfo, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundleInfo;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    File file = new File(ContextHolder.getApplicationContext().getCacheDir(), "nps");
                    file.mkdirs();
                    File file2 = new File(file, "ext_nps_upgradle_application");
                    if (file2.exists() && file2.length() > 1048576) {
                        file2.delete();
                        file2.createNewFile();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("v_c", this.a.getVersionCode());
                    jSONObject.put("name", this.a.getPackageName());
                    jSONObject.put("upgrade", this.a.getUpdateV());
                    jSONObject.put("f_u", this.a.needForceUpdate());
                    jSONObject.put("f_b", this.a.isForbidden());
                    jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_VISI, this.a.isVisible());
                    try {
                        fileOutputStream = new FileOutputStream(file2, true);
                        try {
                            fileOutputStream.write(jSONObject.toString().getBytes());
                            fileOutputStream.write(this.b.getBytes());
                            fileOutputStream.write(String.valueOf(System.currentTimeMillis()).getBytes());
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        fileOutputStream = null;
                        th = th3;
                    }
                } catch (IOException | Exception unused2) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public List<IBundleInfo> b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948149387, "Lcom/baidu/tieba/sf1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948149387, "Lcom/baidu/tieba/sf1;");
                return;
            }
        }
        d = "nps" + File.separator + "preset";
        e = d + File.separator + "info";
        f = d + File.separator + StateManager.KEY_STATE;
        g = 4;
        h = new sf1();
    }

    public sf1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = new HashMap();
        this.c = new HashSet();
    }

    public static sf1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return h;
        }
        return (sf1) invokeV.objValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ff1.a().getInt(ISharePrefsWrapper.NPS_FRAME_PATCH_FAIL_COUNT, 0) >= 5) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String c(File file, File file2, String str, BundleInfo bundleInfo) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, file, file2, str, bundleInfo)) == null) {
            File file3 = new File(file.getAbsolutePath() + ".temp");
            if (file3.exists()) {
                file3.delete();
            }
            if (file.exists()) {
                if (bundleInfo.getDownloadType() == 2) {
                    str = t(file, file3.getAbsolutePath(), file2, str, bundleInfo);
                }
                file.delete();
            } else if (bundleInfo.getDownloadType() == 2) {
                Application applicationContext = ContextHolder.getApplicationContext();
                str = t(dg1.d(applicationContext, bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX), file3.getAbsolutePath(), file2, str, bundleInfo);
            }
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            return str;
        }
        return (String) invokeLLLL.objValue;
    }

    public final String s(String str, String str2, String str3, BundleInfo bundleInfo) {
        InterceptResult invokeLLLL;
        int bsPatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048591, this, str, str2, str3, bundleInfo)) == null) {
            String str4 = "";
            long currentTimeMillis = System.currentTimeMillis();
            IStatisticManager.StatisticExtendInfo statisticExtendInfo = new IStatisticManager.StatisticExtendInfo();
            try {
                bsPatch = new NPSPatch(str, str3, bundleInfo.getMd5()).bsPatch(str2);
                if (bsPatch != 0) {
                    str2 = "";
                }
            } catch (Exception unused) {
            }
            try {
                statisticExtendInfo.costTime = System.currentTimeMillis() - currentTimeMillis;
                hf1.a().b().onPatchResult(bsPatch, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "", statisticExtendInfo);
                return str2;
            } catch (Exception unused2) {
                str4 = str2;
                statisticExtendInfo.costTime = System.currentTimeMillis() - currentTimeMillis;
                hf1.a().b().onPatchResult(-1, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "", statisticExtendInfo);
                return str4;
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public final void d(File file, boolean z) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, z) != null) || !file.exists() || file.isFile() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                listFiles[i].delete();
            } else {
                d(listFiles[i], true);
            }
        }
        if (z) {
            file.delete();
        }
    }

    public int e(BundleInfo bundleInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bundleInfo, i)) == null) {
            d dVar = new d();
            dVar.a = 2;
            if (bundleInfo.getAbi() != gg1.a() && bundleInfo.getAbi() != 3) {
                return 53;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Application applicationContext = ContextHolder.getApplicationContext();
            if (!f()) {
                bundleInfo.setPatchMD5(null);
                bundleInfo.setPatchUrl(null);
            }
            cf1.a().b().downloadBundle(bundleInfo, dg1.h(applicationContext).getAbsolutePath(), i, new b(this, applicationContext, bundleInfo, dVar, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
            int i2 = dVar.a;
            if (i2 == 52) {
                bundleInfo.setPatchUrl(null);
                bundleInfo.setPatchMD5(null);
                return e(bundleInfo, i);
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public d g(List<IBundleInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            d dVar = new d();
            dVar.a = -1;
            dVar.b = new ArrayList();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            cf1.a().b().getBundleInfo(list, new a(this, dVar, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                Log.e("NPS", "PackageManagerNative getBundleInfo InterruptedException.");
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stackTrace.length; i++) {
                sb.append(stackTrace[i].getClassName());
                sb.append(":");
                sb.append(stackTrace[i].getMethodName());
                sb.append(ParamableElem.DIVIDE_PARAM);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public synchronized Map<String, BundleInfo> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.a) {
                    return this.b;
                }
                try {
                    AssetManager assets = ContextHolder.getApplicationContext().getAssets();
                    InputStream open = assets.open(e + File.separator + "preset.json");
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Xml.Encoding.UTF_8.toString()), 8192);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    this.b = r(new JSONArray(sb.toString()));
                    this.a = true;
                } catch (IOException e2) {
                    if (cg1.a()) {
                        Log.e("PRESET", "e=" + e2.getMessage());
                    }
                } catch (JSONException e3) {
                    if (cg1.a()) {
                        Log.e("PRESET", "e=" + e3.getMessage());
                    }
                }
                return this.b;
            }
        }
        return (Map) invokeV.objValue;
    }

    public int k(BundleInfo bundleInfo, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundleInfo, file)) == null) {
            try {
                x(bundleInfo, i());
            } catch (Exception unused) {
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            PackageInfo a2 = fg1.a(file.getAbsolutePath(), 128);
            if (a2 == null) {
                return 8;
            }
            if (!TextUtils.equals(bundleInfo.getPackageName(), a2.packageName)) {
                return 9;
            }
            if (!gf1.a().b().checkSignature(bundleInfo.getPackageName(), jg1.a(file.getAbsolutePath()))) {
                return 10;
            }
            dg1.f(applicationContext, bundleInfo.getPackageName()).mkdirs();
            File e2 = dg1.e(applicationContext, bundleInfo.getPackageName());
            e2.mkdirs();
            File d2 = dg1.d(applicationContext, bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            if (!dg1.b(file, d2)) {
                if (d2.exists()) {
                    d2.delete();
                    return 11;
                }
                return 11;
            }
            d(e2, false);
            if (!m(d2.getAbsolutePath(), e2)) {
                if (d2.exists()) {
                    d2.delete();
                    return 12;
                }
                return 12;
            } else if (file.exists()) {
                file.delete();
                return 13;
            } else {
                return 13;
            }
        }
        return invokeLL.intValue;
    }

    public int l(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundleInfo)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            File g2 = dg1.g(applicationContext, System.currentTimeMillis() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            if (g2.exists()) {
                g2.delete();
            }
            String apkPath = bundleInfo.getApkPath();
            if (TextUtils.isEmpty(apkPath)) {
                return 6;
            }
            File file = new File(apkPath);
            if (!file.exists()) {
                return 7;
            }
            if (!dg1.b(file, g2)) {
                return 11;
            }
            return k(bundleInfo, g2);
        }
        return invokeL.intValue;
    }

    public final boolean m(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, file)) == null) {
            System.currentTimeMillis();
            boolean o = o(str, file);
            if (!o) {
                return n(str, file);
            }
            return o;
        }
        return invokeLL.booleanValue;
    }

    public final boolean o(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, file)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return false;
            }
            ye1 ye1Var = new ye1();
            if (!ye1Var.h()) {
                return false;
            }
            return ye1Var.f(str, file);
        }
        return invokeLL.booleanValue;
    }

    public final boolean w(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, file, file2)) == null) {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                return file.renameTo(file2);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void x(BundleInfo bundleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, bundleInfo, str) == null) {
            if1.a().b().run(new c(this, bundleInfo, str));
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, IF, INVOKE, IF, IF] complete} */
    public final boolean n(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, file)) == null) {
            String str2 = Build.CPU_ABI;
            String str3 = Build.CPU_ABI2;
            try {
                ZipFile zipFile = new ZipFile(str);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                boolean z = false;
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name.startsWith("lib/") && name.endsWith(".so")) {
                        int lastIndexOf = name.lastIndexOf("/");
                        String substring = name.substring(g, lastIndexOf);
                        if (str2.equals(substring)) {
                            z = true;
                        } else if (str3.equals(substring) && !z) {
                        }
                        InputStream inputStream = null;
                        String substring2 = name.substring(lastIndexOf);
                        File file2 = new File(file, substring2 + System.currentTimeMillis());
                        File file3 = new File(file, substring2);
                        try {
                            inputStream = zipFile.getInputStream(nextElement);
                            if (!dg1.c(inputStream, file2)) {
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                return false;
                            }
                            if (file3.exists()) {
                                file3.delete();
                            }
                            file2.renameTo(file3);
                            if (file2.exists()) {
                                file2.delete();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                        } catch (IOException unused3) {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            throw th;
                        }
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException unused6) {
                }
                return true;
            } catch (IOException unused7) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public int p(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bundleInfo)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            File g2 = dg1.g(applicationContext, System.currentTimeMillis() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            if (g2.exists()) {
                g2.delete();
            }
            if (!dg1.a(applicationContext, f + File.separator + bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX, g2.getAbsolutePath())) {
                return 11;
            }
            return k(bundleInfo, g2);
        }
        return invokeL.intValue;
    }

    public synchronized boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return this.c.contains(str);
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.c.add(str);
            }
        }
    }

    public synchronized void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.c.remove(str);
            }
        }
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            int i = 0;
            int i2 = ff1.a().getInt(ISharePrefsWrapper.NPS_FRAME_PATCH_FAIL_COUNT, 0);
            if (z) {
                i = i2 + 1;
            }
            ff1.a().putInt(ISharePrefsWrapper.NPS_FRAME_PATCH_FAIL_COUNT, i);
        }
    }

    public final Map<String, BundleInfo> r(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, jSONArray)) == null) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    BundleInfo bundleInfo = new BundleInfo();
                    bundleInfo.setPackageName(jSONObject.optString("pkg_name"));
                    bundleInfo.setMd5(jSONObject.optString(PackageTable.MD5));
                    bundleInfo.setType(2);
                    bundleInfo.setVersionCode(jSONObject.optInt("version_code"));
                    bundleInfo.setName(jSONObject.optString("name"));
                    bundleInfo.setDescription(jSONObject.optString("description"));
                    bundleInfo.setIconUrl(jSONObject.optString("icon_url"));
                    JSONObject optJSONObject = jSONObject.optJSONObject("sub_bundle");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        ArrayList arrayList = new ArrayList();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                            if (optJSONObject2 != null) {
                                int i2 = optJSONObject2.getInt("min");
                                int i3 = optJSONObject2.getInt(FunAdSdk.PLATFORM_MAX);
                                SubBundleInfo subBundleInfo = new SubBundleInfo();
                                subBundleInfo.setMaxVersion(i3);
                                subBundleInfo.setMinVersion(i2);
                                subBundleInfo.setPackageName(next);
                                arrayList.add(subBundleInfo);
                            }
                        }
                        bundleInfo.setSubBundle(arrayList);
                    }
                    String optString = jSONObject.optString("main_bundle");
                    if (!TextUtils.isEmpty(optString)) {
                        bundleInfo.setMainBundle(optString);
                    }
                    hashMap.put(bundleInfo.getPackageName(), bundleInfo);
                } catch (JSONException unused) {
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final String t(File file, String str, File file2, String str2, BundleInfo bundleInfo) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048592, this, file, str, file2, str2, bundleInfo)) == null) {
            if (!file.exists()) {
                return str2;
            }
            if (w(new File(str2), file2)) {
                y(true);
                String s = s(file.getAbsolutePath(), str, file2.getAbsolutePath(), bundleInfo);
                y(false);
                return s;
            }
            return "";
        }
        return (String) invokeLLLLL.objValue;
    }
}
