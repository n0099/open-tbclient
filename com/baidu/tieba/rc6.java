package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.switchs.OfflinePkgAutoCleanSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class rc6 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948116868, "Lcom/baidu/tieba/rc6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948116868, "Lcom/baidu/tieba/rc6;");
                return;
            }
        }
        a = OfflinePkgAutoCleanSwitch.isOn();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        mc6.h().e(str);
        m35.m().B("pref_key_quick_webview_versions", mc6.h().w());
        File file = new File(mc6.g + "bdtbNWCache/" + str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public static void b(String str, String str2) {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, str, str2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = mc6.g + "bdtbNWCache/" + str2;
        File file = new File(str3);
        if (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
            for (String str4 : list) {
                if (!StringUtils.isNull(str4) && !str4.equals(str)) {
                    FileHelper.deleteFileOrDir(new File(str3 + "/" + str4));
                }
            }
        }
    }

    public static HashMap<String, vc6> g(File file, InputStream inputStream) {
        InterceptResult invokeLL;
        BufferedReader bufferedReader;
        HashMap<String, vc6> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, file, inputStream)) == null) {
            InputStreamReader inputStreamReader = null;
            if (inputStream == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2);
                    try {
                        try {
                            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                sb.append(readLine);
                            }
                            bufferedReader.close();
                            hashMap = new HashMap<>();
                        } catch (Exception e) {
                            e = e;
                            hashMap = null;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(sb.toString());
                            e(jSONObject.optJSONObject("proxyConfig"), hashMap, file);
                            e(jSONObject.optJSONObject("config"), hashMap, file);
                            ii.g(inputStreamReader2);
                        } catch (Exception e2) {
                            e = e2;
                            inputStreamReader = inputStreamReader2;
                            try {
                                e.printStackTrace();
                                ii.g(inputStreamReader);
                                ii.g(bufferedReader);
                                return hashMap;
                            } catch (Throwable th) {
                                th = th;
                                ii.g(inputStreamReader);
                                ii.g(bufferedReader);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader = inputStreamReader2;
                        ii.g(inputStreamReader);
                        ii.g(bufferedReader);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader = null;
                    hashMap = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                hashMap = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
            ii.g(bufferedReader);
            return hashMap;
        }
        return (HashMap) invokeLL.objValue;
    }

    public static uc6 c(String str, String str2) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            File file = new File(mc6.g + "bdtbNWCache");
            FileInputStream fileInputStream2 = null;
            if (!file.exists() || TextUtils.isEmpty(str2)) {
                return null;
            }
            uc6 uc6Var = new uc6();
            File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
            uc6Var.a = file.getAbsolutePath();
            uc6Var.c = str2;
            File file3 = new File(file2, "router.json");
            try {
                if (!file3.exists()) {
                    return null;
                }
                try {
                    fileInputStream = new FileInputStream(file3);
                } catch (FileNotFoundException e) {
                    e = e;
                }
                try {
                    uc6Var.b = g(file2, fileInputStream);
                    ii.e(fileInputStream);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    ii.e(fileInputStream2);
                    return uc6Var;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    ii.e(fileInputStream2);
                    throw th;
                }
                return uc6Var;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (uc6) invokeLL.objValue;
        }
    }

    public static Set<String> d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            HashSet hashSet = new HashSet();
            if (jSONObject == null) {
                return hashSet;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data_urls");
            if (!vd6.c(optJSONArray)) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    hashSet.add(optJSONArray.optString(i, ""));
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v4, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public static void e(JSONObject jSONObject, HashMap<String, vc6> hashMap, File file) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, jSONObject, hashMap, file) == null) && jSONObject != null && hashMap != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && !hashMap.containsKey(next)) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        String optString = jSONObject2.optString("module", "");
                        String optString2 = jSONObject2.optString("path", "");
                        int optInt = jSONObject2.optInt("proxyMode", 0);
                        int i = optInt;
                        if (jSONObject2.has("proxySwitch")) {
                            JSONObject optJSONObject = jSONObject2.optJSONObject("proxySwitch");
                            i = optInt;
                            if (optJSONObject != null) {
                                i = yd6.a(optJSONObject.optString("android", ""), TbConfig.getVersion());
                            }
                        }
                        pc6.b().k(next, next);
                        pc6.b().l(next, optString2);
                        vc6 vc6Var = new vc6();
                        if (jSONObject2.optInt("proxyMode", 0) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        vc6Var.i = z;
                        if (i == 1) {
                            vc6Var.h = true;
                            vc6Var.a = dd6.a(jSONObject2);
                        } else {
                            vc6Var.h = false;
                            vc6Var.b = d(jSONObject2);
                        }
                        vc6Var.c = optString;
                        vc6Var.d = optString2;
                        try {
                            vc6Var.f = f(file, next, jSONObject2);
                        } catch (FileNotFoundException unused) {
                            if (a) {
                                a(optString);
                                return;
                            }
                        }
                        hashMap.put(next, vc6Var);
                        e09.a().j(next, next);
                        e09.a().k(next, optString2);
                    } catch (JSONException unused2) {
                    }
                }
            }
        }
    }

    public static Set<String> f(File file, String str, JSONObject jSONObject) throws FileNotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, file, str, jSONObject)) == null) {
            HashSet<String> hashSet = new HashSet();
            if (jSONObject == null) {
                return hashSet;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("source");
            if (!vd6.c(optJSONArray)) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    hashSet.add(optJSONArray.optString(i, ""));
                }
            }
            String optString = jSONObject.optString("staticPrePath", "");
            for (String str2 : hashSet) {
                if (!TextUtils.isEmpty(str2)) {
                    File file2 = new File(file, str2);
                    if (a && (!file2.exists() || !file2.isFile() || !file2.canRead() || file2.length() == 0)) {
                        pd6.b("lt-log", "file error:" + file2.getAbsolutePath());
                        throw new FileNotFoundException("静态资源文件检查失败：" + file2.getAbsolutePath());
                    }
                    pc6 b = pc6.b();
                    b.k(optString + "/" + str2, str);
                    pc6 b2 = pc6.b();
                    b2.l(optString + "/" + str2, str2);
                    e09 a2 = e09.a();
                    a2.j(optString + "/" + str2, str);
                    e09 a3 = e09.a();
                    a3.k(optString + "/" + str2, str2);
                }
            }
            return hashSet;
        }
        return (Set) invokeLLL.objValue;
    }
}
