package com.baidu.tieba;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.rxa;
import com.baidu.tieba.xra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.Module;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class rra {
    public static /* synthetic */ Interceptable $ic;
    public static xra a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        void a(pra praVar);
    }

    public static <T extends wra> T a(Random random, List<T> list, yra<T> yraVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, random, list, yraVar)) == null) {
            if (random == null || list == null || list.isEmpty()) {
                return null;
            }
            LogPrinter.v("Start select for class:%s with size:%d", list.iterator().next().getClass().getSimpleName(), Integer.valueOf(list.size()));
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            T t = null;
            for (int i = 0; i < size; i++) {
                T t2 = list.get(i);
                if (yraVar != null) {
                    if (!yraVar.a(t2)) {
                        continue;
                    }
                    if (t == null && t2.b() != t.b()) {
                        break;
                    }
                    arrayList.add(t2);
                    t = t2;
                } else {
                    if (!t2.a()) {
                        continue;
                    }
                    if (t == null) {
                    }
                    arrayList.add(t2);
                    t = t2;
                }
            }
            if (arrayList.isEmpty()) {
                LogPrinter.v("No one is selected", new Object[0]);
                return null;
            }
            return (T) arrayList.get(random.nextInt(arrayList.size()));
        }
        return (T) invokeLLL.objValue;
    }

    public static boolean g(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        xra xraVar;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, jSONObject)) == null) {
            if (str == null || jSONObject == null || (xraVar = a) == null) {
                return false;
            }
            for (xra.a aVar : xraVar.a) {
                if (str.equals(aVar.a)) {
                    for (Map.Entry<String, Set<Object>> entry : aVar.b.entrySet()) {
                        Object opt = jSONObject.opt(entry.getKey());
                        if (opt != null) {
                            Iterator<Object> it = entry.getValue().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (opt.equals(it.next())) {
                                        z2 = true;
                                        continue;
                                        break;
                                    }
                                } else {
                                    z2 = false;
                                    continue;
                                    break;
                                }
                            }
                            if (!z2) {
                            }
                        }
                        z = false;
                    }
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static <T> T b(String str, exa<T> exaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, exaVar)) == null) {
            if (str != null && exaVar != null) {
                try {
                    byte[] decode = Base64.decode(str, 0);
                    if (decode == null) {
                        return null;
                    }
                    try {
                        return exaVar.a(new ObjectInputStream(new ByteArrayInputStream(decode)));
                    } catch (IOException e) {
                        LogPrinter.e(e);
                        return null;
                    }
                } catch (Exception e2) {
                    LogPrinter.e(e2);
                }
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TextUtils.isEmpty(b)) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FunAdSdk.getAppContext());
                String string = defaultSharedPreferences.getString("u_tok", "");
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(string.getBytes(Charset.forName("UTF-8")));
                        string = Base64.encodeToString(messageDigest.digest(), 2);
                    } catch (Throwable unused) {
                        if (string.length() >= 24) {
                            string = string.substring(0, 24);
                        }
                    }
                    defaultSharedPreferences.edit().putString("u_tok", string).apply();
                }
                b = string;
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(gxa gxaVar) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gxaVar)) == null) {
            if (gxaVar != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    gxaVar.srzable(objectOutputStream);
                    objectOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                } catch (IOException unused) {
                }
                if (bArr != null) {
                    return null;
                }
                return Base64.encodeToString(bArr, 0);
            }
            bArr = null;
            if (bArr != null) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static void e(long j, a aVar, FunAdConfig funAdConfig, Map<String, PidLoaderCreator> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), aVar, funAdConfig, map}) == null) {
            rxa.a aVar2 = rxa.a;
            aVar2.a = System.currentTimeMillis() - 0;
            aVar2.b = SystemClock.currentThreadTimeMillis() - 0;
            LogPrinter.d("All ssp initialized with %dms consumed.", Long.valueOf(System.currentTimeMillis() - j));
            funAdConfig.moduleInitManager.tryCallbackComplete();
            aVar.a(new pra(map));
        }
    }

    public static void f(String str, String str2, FunAdConfig funAdConfig, Map<String, PidLoaderCreator> map, String str3) {
        Module module;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65541, null, str, str2, funAdConfig, map, str3) == null) {
            try {
                module = (Module) Class.forName(str2).getConstructor(new Class[0]).newInstance(new Object[0]);
                LogPrinter.d("Module for %s created", str2);
            } catch (Exception e) {
                LogPrinter.e(e, "Module for %s not found", str2);
                module = null;
            }
            if (module == null) {
                return;
            }
            try {
                PidLoaderCreator init = module.init(funAdConfig, str3);
                if (init == null) {
                    LogPrinter.e("Module for %s init failed", str);
                } else {
                    map.put(str, init);
                }
            } catch (Exception unused) {
            }
        }
    }
}
