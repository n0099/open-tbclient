package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65536, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        hd6.h().e(str);
        b55.m().B("pref_key_quick_webview_versions", hd6.h().t());
        File file = new File(hd6.f + "bdtbNWCache/" + str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public static void b(String str, String str2) {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, str, str2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = hd6.f + "bdtbNWCache/" + str2;
        File file = new File(str3);
        if (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
            for (String str4 : list) {
                if (!StringUtils.isNull(str4) && !str4.equals(str)) {
                    FileHelper.deleteFileOrDir(new File(str3 + "/" + str4));
                }
            }
        }
    }

    public static qd6 c(String str, String str2) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            File file = new File(hd6.f + "bdtbNWCache");
            FileInputStream fileInputStream2 = null;
            if (!file.exists() || TextUtils.isEmpty(str2)) {
                return null;
            }
            qd6 qd6Var = new qd6();
            File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
            qd6Var.a = file.getAbsolutePath();
            qd6Var.c = str2;
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
                    qd6Var.b = e(fileInputStream);
                    fj.e(fileInputStream);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    fj.e(fileInputStream2);
                    return qd6Var;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    fj.e(fileInputStream2);
                    throw th;
                }
                return qd6Var;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (qd6) invokeLL.objValue;
        }
    }

    public static void d(JSONObject jSONObject, HashMap<String, ld6> hashMap) {
        String str;
        String str2;
        String str3;
        boolean z;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, jSONObject, hashMap) == null) {
            JSONObject jSONObject2 = jSONObject;
            String str4 = "source";
            String str5 = "path";
            if (jSONObject2 != null && hashMap != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!hashMap.containsKey(next)) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                            ArrayList<String> arrayList = new ArrayList<>();
                            if (jSONObject3.has("data_urls") && (optJSONArray2 = jSONObject3.optJSONArray("data_urls")) != null) {
                                for (int i = 0; i < optJSONArray2.length(); i++) {
                                    arrayList.add(optJSONArray2.optString(i));
                                }
                            }
                            if (!jSONObject3.has("module")) {
                                str = "";
                            } else {
                                str = jSONObject3.optString("module");
                            }
                            if (!jSONObject3.has(str5)) {
                                str2 = "";
                            } else {
                                str2 = jSONObject3.optString(str5);
                            }
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            if (jSONObject3.has(str4) && (optJSONArray = jSONObject3.optJSONArray(str4)) != null) {
                                str3 = str4;
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    arrayList2.add(optJSONArray.optString(i2));
                                }
                            } else {
                                str3 = str4;
                            }
                            String optString = jSONObject3.optString("staticPrePath", "");
                            int optInt = jSONObject3.optInt("proxyMode");
                            kd6.a().h(next, next);
                            kd6.a().i(next, str2);
                            Iterator<String> it = arrayList2.iterator();
                            while (it.hasNext()) {
                                String next2 = it.next();
                                if (!TextUtils.isEmpty(next2)) {
                                    kd6 a = kd6.a();
                                    String str6 = str5;
                                    a.h(optString + "/" + next2, next);
                                    kd6 a2 = kd6.a();
                                    a2.i(optString + "/" + next2, next2);
                                    str5 = str6;
                                }
                            }
                            String str7 = str5;
                            ld6 ld6Var = new ld6();
                            ld6Var.a = arrayList;
                            ld6Var.b = str;
                            ld6Var.c = str2;
                            ld6Var.d = arrayList2;
                            if (optInt == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ld6Var.f = z;
                            hashMap.put(next, ld6Var);
                            jSONObject2 = jSONObject;
                            str4 = str3;
                            str5 = str7;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x004d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x004f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0051 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x0005 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.io.InputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v14, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v15, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v16, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v17, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v21, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    public static HashMap<String, ld6> e(InputStream inputStream) {
        InterceptResult invokeL;
        InputStreamReader inputStreamReader;
        Throwable th;
        Object obj;
        HashMap<String, ld6> hashMap;
        Object obj2;
        Object obj3;
        Reader reader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) == null) {
            InputStreamReader inputStreamReader2 = null;
            try {
                if (inputStream == 0) {
                    return null;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        inputStream = new BufferedReader(inputStreamReader);
                        try {
                            try {
                                for (String readLine = inputStream.readLine(); readLine != null; readLine = inputStream.readLine()) {
                                    stringBuffer.append(readLine);
                                }
                                inputStream.close();
                                hashMap = new HashMap<>();
                                try {
                                    JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                                    d(jSONObject.optJSONObject("proxyConfig"), hashMap);
                                    d(jSONObject.optJSONObject("config"), hashMap);
                                    fj.g(inputStreamReader);
                                    reader = inputStream;
                                } catch (IOException e) {
                                    e = e;
                                    inputStreamReader2 = inputStreamReader;
                                    obj3 = inputStream;
                                    e.printStackTrace();
                                    inputStream = obj3;
                                    fj.g(inputStreamReader2);
                                    reader = inputStream;
                                    fj.g(reader);
                                    return hashMap;
                                } catch (JSONException e2) {
                                    e = e2;
                                    inputStreamReader2 = inputStreamReader;
                                    obj2 = inputStream;
                                    e.printStackTrace();
                                    inputStream = obj2;
                                    fj.g(inputStreamReader2);
                                    reader = inputStream;
                                    fj.g(reader);
                                    return hashMap;
                                } catch (Exception e3) {
                                    e = e3;
                                    inputStreamReader2 = inputStreamReader;
                                    obj = inputStream;
                                    e.printStackTrace();
                                    inputStream = obj;
                                    fj.g(inputStreamReader2);
                                    reader = inputStream;
                                    fj.g(reader);
                                    return hashMap;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fj.g(inputStreamReader);
                                fj.g(inputStream);
                                throw th;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            hashMap = null;
                        } catch (JSONException e5) {
                            e = e5;
                            hashMap = null;
                        } catch (Exception e6) {
                            e = e6;
                            hashMap = null;
                        }
                    } catch (IOException e7) {
                        e = e7;
                        inputStream = 0;
                        hashMap = null;
                    } catch (JSONException e8) {
                        e = e8;
                        inputStream = 0;
                        hashMap = null;
                    } catch (Exception e9) {
                        e = e9;
                        inputStream = 0;
                        hashMap = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = 0;
                    }
                } catch (IOException e10) {
                    e = e10;
                    obj3 = null;
                    hashMap = null;
                } catch (JSONException e11) {
                    e = e11;
                    obj2 = null;
                    hashMap = null;
                } catch (Exception e12) {
                    e = e12;
                    obj = null;
                    hashMap = null;
                } catch (Throwable th4) {
                    inputStreamReader = null;
                    th = th4;
                    inputStream = 0;
                }
                fj.g(reader);
                return hashMap;
            } catch (Throwable th5) {
                inputStreamReader = inputStreamReader2;
                th = th5;
            }
        } else {
            return (HashMap) invokeL.objValue;
        }
    }
}
