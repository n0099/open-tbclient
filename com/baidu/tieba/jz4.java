package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.gl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            if (file.exists() && file.isFile() && file.canRead()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static gl9.g b(String str, String str2) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            File file = new File(gl9.g + "bdtbNWCache");
            FileInputStream fileInputStream2 = null;
            if (TextUtils.isEmpty(str2) || !file.exists()) {
                return null;
            }
            gl9.g gVar = new gl9.g();
            File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
            gVar.a = file.getAbsolutePath();
            gVar.c = str2;
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
                    gVar.b = f(fileInputStream);
                    wi.e(fileInputStream);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    wi.e(fileInputStream2);
                    return gVar;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    wi.e(fileInputStream2);
                    throw th;
                }
                return gVar;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (gl9.g) invokeLL.objValue;
        }
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        il9 d;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (QuickWebViewSwitch.getInOn() && !gl9.s(str)) {
                try {
                    d = hl9.a().d(new URL(str).getPath());
                } catch (MalformedURLException | Exception unused) {
                }
                if (d != null && d.e) {
                    String p = gl9.n().p(d.b);
                    if (!TextUtils.isEmpty(d.b) && !TextUtils.isEmpty(d.c) && !TextUtils.isEmpty(p)) {
                        String str2 = gl9.n().m() + "/" + d.b + "/" + p + "/";
                        if (!d.c.endsWith(".html")) {
                            file = new File(str2, d.c + ".html");
                        } else {
                            file = new File(str2, d.c);
                        }
                        if (!a(file)) {
                            YunDialogLog.getInstance().b("OfflineHelper", "离线包检查：主html文件异常==" + str);
                            return false;
                        }
                        ArrayList<String> arrayList = d.d;
                        if (ListUtils.isEmpty(arrayList)) {
                            YunDialogLog.getInstance().b("OfflineHelper", "离线包检查：静态资源(js、css)配置信息错误==" + str);
                            return false;
                        }
                        for (String str3 : arrayList) {
                            if (TextUtils.isEmpty(str3)) {
                                YunDialogLog.getInstance().b("OfflineHelper", "离线包检查：静态资源(js、css)配置信息错误2==" + str);
                                return false;
                            } else if (!a(new File(str2, str3))) {
                                YunDialogLog.getInstance().b("OfflineHelper", "离线包检查：静态资源(js、css)配置信息错误3==" + str);
                                return false;
                            }
                        }
                        return true;
                    }
                    YunDialogLog.getInstance().b("OfflineHelper", "离线包检查：版本异常==" + str);
                    return false;
                }
                YunDialogLog.getInstance().b("OfflineHelper", "离线包检查：离线包未初始化==" + str);
                return false;
            }
            YunDialogLog.getInstance().b("OfflineHelper", "离线包检查：开关关闭==" + str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void d(Set<String> set) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, set) == null) && !jm6.a(set)) {
            gl9.f fVar = new gl9.f();
            fVar.a = new HashMap();
            fVar.b = new HashMap<>();
            for (String str : set) {
                gl9.g b = b(str, gl9.n().p(str));
                if (b != null && !TextUtils.isEmpty(b.a) && !jm6.b(b.b)) {
                    fVar.a.put(str, b);
                    fVar.b.putAll(b.b);
                }
            }
            if (!jm6.b(fVar.b)) {
                hl9.a().i(fVar.b);
            }
        }
    }

    public static HashMap<String, il9> f(InputStream inputStream) {
        InterceptResult invokeL;
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        HashMap<String, il9> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, inputStream)) == null) {
            InputStreamReader inputStreamReader2 = null;
            if (inputStream == null) {
                return null;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        try {
                            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                stringBuffer.append(readLine);
                            }
                            bufferedReader.close();
                            hashMap = new HashMap<>();
                        } catch (Exception e) {
                            e = e;
                            hashMap = null;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                            e(jSONObject.optJSONObject("proxyConfig"), hashMap);
                            e(jSONObject.optJSONObject("config"), hashMap);
                            wi.g(inputStreamReader);
                        } catch (Exception e2) {
                            e = e2;
                            inputStreamReader2 = inputStreamReader;
                            try {
                                e.printStackTrace();
                                wi.g(inputStreamReader2);
                                wi.g(bufferedReader);
                                return hashMap;
                            } catch (Throwable th2) {
                                inputStreamReader = inputStreamReader2;
                                th = th2;
                                wi.g(inputStreamReader);
                                wi.g(bufferedReader);
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        wi.g(inputStreamReader);
                        wi.g(bufferedReader);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader = null;
                    hashMap = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                hashMap = null;
            } catch (Throwable th5) {
                inputStreamReader = null;
                th = th5;
                bufferedReader = null;
            }
            wi.g(bufferedReader);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void e(JSONObject jSONObject, HashMap<String, il9> hashMap) {
        String str;
        String str2;
        String str3;
        boolean z;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, hashMap) == null) {
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
                            hl9.a().j(next, next);
                            hl9.a().k(next, str2);
                            Iterator<String> it = arrayList2.iterator();
                            while (it.hasNext()) {
                                String next2 = it.next();
                                if (!TextUtils.isEmpty(next2)) {
                                    hl9 a = hl9.a();
                                    String str6 = str5;
                                    a.j(optString + "/" + next2, next);
                                    hl9 a2 = hl9.a();
                                    a2.k(optString + "/" + next2, next2);
                                    str5 = str6;
                                }
                            }
                            String str7 = str5;
                            il9 il9Var = new il9();
                            il9Var.a = arrayList;
                            il9Var.b = str;
                            il9Var.c = str2;
                            il9Var.d = arrayList2;
                            if (optInt == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            il9Var.f = z;
                            il9Var.e = true;
                            hashMap.put(next, il9Var);
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
}
