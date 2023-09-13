package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSResponseEntity;
import com.baidu.searchbox.aperf.bosuploader.BOSUploader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.ykb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kkb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile kkb e;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public File b;
    public ExecutorService c;

    /* loaded from: classes6.dex */
    public class a implements lkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ nkb b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ String f;

        public a(kkb kkbVar, File file, nkb nkbVar, String str, String str2, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkbVar, file, nkbVar, str, str2, jSONObject, str3};
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
            this.b = nkbVar;
            this.c = str;
            this.d = str2;
            this.e = jSONObject;
            this.f = str3;
        }

        @Override // com.baidu.tieba.lkb
        public void a(okb okbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, okbVar) == null) {
                if (okbVar != null && okbVar.c()) {
                    if (kkb.d) {
                        Log.d("VoyagerFileManager", "bos upload success");
                    }
                    if (this.a.exists()) {
                        this.a.delete();
                    }
                    nkb nkbVar = this.b;
                    if (nkbVar != null) {
                        nkbVar.d(this.c, this.d, this.e);
                    }
                } else if (okbVar != null) {
                    int a = okbVar.a();
                    String b = okbVar.b();
                    if (kkb.d) {
                        Log.d("VoyagerFileManager", "bos upload fail: error code = " + a + ", error message: " + b);
                    }
                    nkb nkbVar2 = this.b;
                    if (nkbVar2 != null) {
                        nkbVar2.c(this.f, a, b, this.e);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ lkb d;
        public final /* synthetic */ kkb e;

        public b(kkb kkbVar, String str, String str2, File file, lkb lkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkbVar, str, str2, file, lkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = kkbVar;
            this.a = str;
            this.b = str2;
            this.c = file;
            this.d = lkbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.e.m(this.a, this.b, this.c, this.d);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947917383, "Lcom/baidu/tieba/kkb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947917383, "Lcom/baidu/tieba/kkb;");
                return;
            }
        }
        d = AppConfig.isDebug();
    }

    public static kkb g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (kkb.class) {
                    if (e == null) {
                        e = new kkb();
                    }
                }
            }
            return e;
        }
        return (kkb) invokeV.objValue;
    }

    public ArrayList<File> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<File> arrayList = new ArrayList<>();
            File[] listFiles = this.a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                return new ArrayList<>(Arrays.asList(listFiles));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (File) invokeV.objValue;
    }

    public kkb() {
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
        j();
        this.c = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public void c(rkb rkbVar, nkb nkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, rkbVar, nkbVar) == null) {
            String j = rkbVar.j();
            String a2 = rkbVar.a();
            if (!TextUtils.isEmpty(j) && !TextUtils.isEmpty(a2)) {
                File file = new File(this.a, j);
                JSONObject c = rkbVar.c();
                if (file.exists()) {
                    if (d) {
                        Log.d("VoyagerFileManager", "retry: " + j + " exists and upload");
                    }
                    k(j, a2, file, c, nkbVar);
                    return;
                }
                d(rkbVar, nkbVar);
            }
        }
    }

    public void d(rkb rkbVar, nkb nkbVar) {
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rkbVar, nkbVar) == null) {
            String j = rkbVar.j();
            String a2 = rkbVar.a();
            if (!TextUtils.isEmpty(j) && !TextUtils.isEmpty(a2)) {
                ArrayList<String> g = rkbVar.g();
                JSONObject c = rkbVar.c();
                if (c == null) {
                    c = new JSONObject();
                    rkbVar.n(c);
                }
                JSONObject jSONObject = c;
                if (g != null && g.size() != 0) {
                    if (!rkbVar.l() && g.size() == 1) {
                        String str = g.get(0);
                        if (TextUtils.isEmpty(str)) {
                            nkbVar.a(j, jSONObject);
                            return;
                        }
                        File file = new File(str);
                        if (!file.exists()) {
                            nkbVar.a(j, jSONObject);
                            return;
                        } else {
                            i = new File(this.a, j);
                            alb.a(file, i);
                        }
                    } else {
                        long e2 = rkbVar.e();
                        if (e2 == 0) {
                            e2 = ikb.f().d(a2);
                        }
                        i = i(j, g, e2, jSONObject);
                    }
                    File file2 = i;
                    if (file2 != null && file2.exists()) {
                        k(j, a2, file2, jSONObject, nkbVar);
                        return;
                    } else {
                        nkbVar.b(j, jSONObject);
                        return;
                    }
                }
                nkbVar.a(j, jSONObject);
            }
        }
    }

    public void e(String str, String str2, String str3, File file, String str4, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, file, str4, Boolean.valueOf(z), jSONObject}) == null) {
            try {
                JSONObject b2 = zkb.b(file, str4, str2, str3, z);
                jSONObject.put(str, b2);
                if (d) {
                    Log.d("VoyagerFileManager", "generateMetaInfo path " + str + " fileMeta ：" + b2);
                }
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public File i(String str, ArrayList<String> arrayList, long j, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        JSONObject jSONObject2;
        String str2;
        File file;
        String str3;
        Iterator<String> it;
        File file2;
        String str4;
        boolean z;
        String str5;
        File file3;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, arrayList, Long.valueOf(j), jSONObject})) == null) {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            if (jSONObject == null) {
                jSONObject2 = new JSONObject();
            } else {
                jSONObject2 = jSONObject;
            }
            Iterator<String> it2 = arrayList.iterator();
            long j2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    str2 = "VoyagerFileManager";
                    file = null;
                    str3 = " not exist";
                    break;
                }
                String next = it2.next();
                if (!TextUtils.isEmpty(next)) {
                    if (next.startsWith("external:")) {
                        next = next.replace("external:", AppRuntime.getAppContext().getExternalFilesDir(null).getParent() + File.separatorChar);
                    } else if (next.startsWith("internal:")) {
                        next = next.replace("internal:", AppRuntime.getAppContext().getApplicationInfo().dataDir + File.separator);
                    }
                    String str8 = next;
                    if (str8.contains("../")) {
                        e(str8, "4", str8 + " error", null, null, true, jSONObject2);
                    } else {
                        File file4 = new File(str8);
                        if (!file4.exists()) {
                            e(str8, "1", str8 + " not exist", null, null, true, jSONObject2);
                        } else {
                            if (d) {
                                Log.d("VoyagerFileManager", "path: " + str8);
                            }
                            if (file4.isFile()) {
                                long length = file4.length() + j2;
                                if (d) {
                                    Log.d("VoyagerFileManager", "total file size: " + length);
                                    Log.d("VoyagerFileManager", "max file size: " + j);
                                }
                                if (length > j) {
                                    file = null;
                                    e(str8, "3", str8 + " size exceed maxFileSize ", null, null, true, jSONObject2);
                                    str3 = " not exist";
                                    str2 = "VoyagerFileManager";
                                    break;
                                }
                                file = null;
                                StringBuilder sb = new StringBuilder(blb.c(file4.getAbsolutePath().getBytes(), true));
                                sb.append("_");
                                sb.append(file4.getName());
                                arrayList2.add(new ykb.a(file4, sb.toString()));
                                file2 = file4;
                                str4 = str8;
                                it = it2;
                                z = true;
                                str3 = " not exist";
                                e(str8, "0", str8 + " success", file2, sb.toString(), true, jSONObject2);
                                if (d) {
                                    Log.d("VoyagerFileManager", "zip name: " + ((Object) sb));
                                }
                                str5 = "VoyagerFileManager";
                                j2 = length;
                            } else {
                                it = it2;
                                file2 = file4;
                                str4 = str8;
                                file = null;
                                str3 = " not exist";
                                z = true;
                                str5 = "VoyagerFileManager";
                            }
                            if (file2.isDirectory()) {
                                ArrayList arrayList3 = new ArrayList();
                                File file5 = file2;
                                alb.e(file5, arrayList3);
                                if (arrayList3.size() != 0) {
                                    boolean z2 = false;
                                    Iterator it3 = arrayList3.iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            String str9 = (String) it3.next();
                                            if (!TextUtils.isEmpty(str9)) {
                                                File file6 = new File(str9);
                                                if (file6.exists()) {
                                                    j2 += file6.length();
                                                    if (j2 > j) {
                                                        file3 = file5;
                                                        str6 = str5;
                                                        e(str4, "3", file5.getPath() + "size exceed maxFileSize ", null, null, true, jSONObject2);
                                                        z2 = true;
                                                        break;
                                                    }
                                                }
                                                file5 = file5;
                                                str5 = str5;
                                            }
                                        } else {
                                            file3 = file5;
                                            str6 = str5;
                                            break;
                                        }
                                    }
                                    if (z2) {
                                        str2 = str6;
                                        break;
                                    }
                                    File file7 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "/store/");
                                    String c = blb.c(file3.getAbsolutePath().getBytes(), z);
                                    File file8 = new File(file7, c + ".zip");
                                    if (d) {
                                        str7 = str6;
                                        Log.d(str7, "inner path: " + file7.getAbsolutePath());
                                        Log.d(str7, "inner path md5: " + c);
                                        Log.d(str7, "inner zip out file: " + file8.getAbsolutePath());
                                    } else {
                                        str7 = str6;
                                    }
                                    if (!file7.exists()) {
                                        file7.mkdir();
                                    }
                                    if (file8.exists()) {
                                        file8.delete();
                                    }
                                    if (alb.h(file3, file8.getAbsolutePath())) {
                                        if (d) {
                                            Log.d(str7, "inner zip out file: " + file8.getName());
                                        }
                                        arrayList2.add(new ykb.a(file8, file8.getName(), z));
                                        e(str4, "0", "success", file8, file8.getPath(), false, jSONObject2);
                                    } else {
                                        StringBuilder sb2 = new StringBuilder();
                                        String str10 = str4;
                                        sb2.append(str10);
                                        sb2.append("copy error");
                                        e(str10, "2", sb2.toString(), null, null, false, jSONObject2);
                                    }
                                }
                            }
                            it2 = it;
                        }
                    }
                }
            }
            File file9 = new File(this.b, "filemeta_" + str + ".log");
            try {
                file9.createNewFile();
                alb.g(jSONObject2.toString(), file9);
            } catch (IOException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            if (file9.exists()) {
                arrayList2.add(new ykb.a(file9, file9.getName(), true));
            }
            if (d) {
                Log.d(str2, "start generate out zip file");
            }
            File file10 = new File(this.a, str);
            try {
                if (file10.exists()) {
                    file10.delete();
                }
                file10.createNewFile();
            } catch (IOException e3) {
                if (d) {
                    e3.printStackTrace();
                }
            }
            if (arrayList2.size() > 0) {
                ykb.a(file10, arrayList2);
                File file11 = new File(file10.getAbsolutePath());
                if (d) {
                    Log.d(str2, "out put File: " + file11.getAbsolutePath());
                }
                return file11;
            }
            e(file10.getAbsolutePath(), "1", file10.getPath() + str3, null, null, true, jSONObject2);
            return file;
        }
        return (File) invokeCommon.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String str = AppRuntime.getAppContext().getApplicationInfo().dataDir + "/.voyager";
            File file = new File(str, "/upload/");
            this.a = file;
            if (!file.exists()) {
                this.a.mkdirs();
            }
            File file2 = new File(str, "/store/");
            this.b = file2;
            if (!file2.exists()) {
                this.b.mkdirs();
            }
        }
    }

    public final void k(String str, String str2, File file, JSONObject jSONObject, nkb nkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, file, jSONObject, nkbVar) == null) {
            String str3 = str + ".zip";
            String createObjectKey = BOSUploader.getInstance().createObjectKey(str2, str3);
            if (d) {
                Log.d("VoyagerFileManager", "bos object key is : " + createObjectKey);
            }
            l(str2, str3, file, new a(this, file, nkbVar, str3, createObjectKey, jSONObject, str));
        }
    }

    public final void l(String str, String str2, File file, lkb lkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, file, lkbVar) == null) {
            this.c.execute(new b(this, str, str2, file, lkbVar));
        }
    }

    public final void m(@NonNull String str, @NonNull String str2, @NonNull File file, lkb lkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, str, str2, file, lkbVar) == null) {
            BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync(str, str2, file);
            okb okbVar = new okb(uploadFileSync.isSuccess(), uploadFileSync.getErrorCode(), uploadFileSync.getMessage());
            if (lkbVar != null) {
                lkbVar.a(okbVar);
            }
        }
    }
}
