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
import com.baidu.tieba.xo9;
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
/* loaded from: classes4.dex */
public class io9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile io9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public File b;
    public ExecutorService c;

    /* loaded from: classes4.dex */
    public class a implements jo9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ lo9 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ String f;

        public a(io9 io9Var, File file, lo9 lo9Var, String str, String str2, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io9Var, file, lo9Var, str, str2, jSONObject, str3};
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
            this.b = lo9Var;
            this.c = str;
            this.d = str2;
            this.e = jSONObject;
            this.f = str3;
        }

        @Override // com.baidu.tieba.jo9
        public void a(mo9 mo9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mo9Var) == null) {
                if (mo9Var != null && mo9Var.c()) {
                    if (io9.d) {
                        Log.d("VoyagerFileManager", "bos upload success");
                    }
                    if (this.a.exists()) {
                        this.a.delete();
                    }
                    lo9 lo9Var = this.b;
                    if (lo9Var != null) {
                        lo9Var.d(this.c, this.d, this.e);
                    }
                } else if (mo9Var != null) {
                    int a = mo9Var.a();
                    String b = mo9Var.b();
                    if (io9.d) {
                        Log.d("VoyagerFileManager", "bos upload fail: error code = " + a + ", error message: " + b);
                    }
                    lo9 lo9Var2 = this.b;
                    if (lo9Var2 != null) {
                        lo9Var2.c(this.f, a, b, this.e);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ jo9 d;
        public final /* synthetic */ io9 e;

        public b(io9 io9Var, String str, String str2, File file, jo9 jo9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io9Var, str, str2, file, jo9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = io9Var;
            this.a = str;
            this.b = str2;
            this.c = file;
            this.d = jo9Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947860374, "Lcom/baidu/tieba/io9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947860374, "Lcom/baidu/tieba/io9;");
                return;
            }
        }
        d = AppConfig.isDebug();
    }

    public static io9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (io9.class) {
                    if (e == null) {
                        e = new io9();
                    }
                }
            }
            return e;
        }
        return (io9) invokeV.objValue;
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

    public io9() {
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

    public void c(qo9 qo9Var, lo9 lo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, qo9Var, lo9Var) == null) {
            String j = qo9Var.j();
            String a2 = qo9Var.a();
            if (!TextUtils.isEmpty(j) && !TextUtils.isEmpty(a2)) {
                File file = new File(this.a, j);
                JSONObject c = qo9Var.c();
                if (file.exists()) {
                    if (d) {
                        Log.d("VoyagerFileManager", "retry: " + j + " exists and upload");
                    }
                    k(j, a2, file, c, lo9Var);
                    return;
                }
                d(qo9Var, lo9Var);
            }
        }
    }

    public void d(qo9 qo9Var, lo9 lo9Var) {
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qo9Var, lo9Var) == null) {
            String j = qo9Var.j();
            String a2 = qo9Var.a();
            if (!TextUtils.isEmpty(j) && !TextUtils.isEmpty(a2)) {
                ArrayList<String> g = qo9Var.g();
                JSONObject c = qo9Var.c();
                if (c == null) {
                    c = new JSONObject();
                    qo9Var.n(c);
                }
                JSONObject jSONObject = c;
                if (g != null && g.size() != 0) {
                    if (!qo9Var.l() && g.size() == 1) {
                        String str = g.get(0);
                        if (TextUtils.isEmpty(str)) {
                            lo9Var.a(j, jSONObject);
                            return;
                        }
                        File file = new File(str);
                        if (!file.exists()) {
                            lo9Var.a(j, jSONObject);
                            return;
                        } else {
                            i = new File(this.a, j);
                            zo9.a(file, i);
                        }
                    } else {
                        long e2 = qo9Var.e();
                        if (e2 == 0) {
                            e2 = go9.f().d(a2);
                        }
                        i = i(j, g, e2, jSONObject);
                    }
                    File file2 = i;
                    if (file2 != null && file2.exists()) {
                        k(j, a2, file2, jSONObject, lo9Var);
                        return;
                    } else {
                        lo9Var.b(j, jSONObject);
                        return;
                    }
                }
                lo9Var.a(j, jSONObject);
            }
        }
    }

    public void e(String str, String str2, String str3, File file, String str4, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, file, str4, Boolean.valueOf(z), jSONObject}) == null) {
            try {
                JSONObject b2 = yo9.b(file, str4, str2, str3, z);
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
                                StringBuilder sb = new StringBuilder(ap9.c(file4.getAbsolutePath().getBytes(), true));
                                sb.append("_");
                                sb.append(file4.getName());
                                arrayList2.add(new xo9.a(file4, sb.toString()));
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
                                zo9.e(file5, arrayList3);
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
                                    String c = ap9.c(file3.getAbsolutePath().getBytes(), z);
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
                                    if (zo9.h(file3, file8.getAbsolutePath())) {
                                        if (d) {
                                            Log.d(str7, "inner zip out file: " + file8.getName());
                                        }
                                        arrayList2.add(new xo9.a(file8, file8.getName(), z));
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
                zo9.g(jSONObject2.toString(), file9);
            } catch (IOException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            if (file9.exists()) {
                arrayList2.add(new xo9.a(file9, file9.getName(), true));
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
                xo9.a(file10, arrayList2);
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

    public final void k(String str, String str2, File file, JSONObject jSONObject, lo9 lo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, file, jSONObject, lo9Var) == null) {
            String str3 = str + ".zip";
            String createObjectKey = BOSUploader.getInstance().createObjectKey(str2, str3);
            if (d) {
                Log.d("VoyagerFileManager", "bos object key is : " + createObjectKey);
            }
            l(str2, str3, file, new a(this, file, lo9Var, str3, createObjectKey, jSONObject, str));
        }
    }

    public final void l(String str, String str2, File file, jo9 jo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, file, jo9Var) == null) {
            this.c.execute(new b(this, str, str2, file, jo9Var));
        }
    }

    public final void m(@NonNull String str, @NonNull String str2, @NonNull File file, jo9 jo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, str, str2, file, jo9Var) == null) {
            BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync(str, str2, file);
            mo9 mo9Var = new mo9(uploadFileSync.isSuccess(), uploadFileSync.getErrorCode(), uploadFileSync.getMessage());
            if (jo9Var != null) {
                jo9Var.a(mo9Var);
            }
        }
    }
}
