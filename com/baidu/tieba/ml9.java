package com.baidu.tieba;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.mr9;
import com.baidu.tieba.sl9;
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
/* loaded from: classes5.dex */
public final class ml9 {
    public static /* synthetic */ Interceptable $ic;
    public static sl9 a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a(kl9 kl9Var);
    }

    public static rl9 a(Random random, List list, tl9 tl9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, random, list, tl9Var)) == null) {
            if (random == null || list == null || list.isEmpty()) {
                return null;
            }
            LogPrinter.v("Start select for class:%s with size:%d", ((rl9) list.iterator().next()).getClass().getSimpleName(), Integer.valueOf(list.size()));
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            rl9 rl9Var = null;
            for (int i = 0; i < size; i++) {
                rl9 rl9Var2 = (rl9) list.get(i);
                if (tl9Var != null) {
                    if (!tl9Var.a(rl9Var2)) {
                        continue;
                    }
                    if (rl9Var == null && rl9Var2.b() != rl9Var.b()) {
                        break;
                    }
                    arrayList.add(rl9Var2);
                    rl9Var = rl9Var2;
                } else {
                    if (!rl9Var2.a()) {
                        continue;
                    }
                    if (rl9Var == null) {
                    }
                    arrayList.add(rl9Var2);
                    rl9Var = rl9Var2;
                }
            }
            if (arrayList.isEmpty()) {
                LogPrinter.v("No one is selected", new Object[0]);
                return null;
            }
            return (rl9) arrayList.get(random.nextInt(arrayList.size()));
        }
        return (rl9) invokeLLL.objValue;
    }

    public static boolean g(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        sl9 sl9Var;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, jSONObject)) == null) {
            if (str == null || jSONObject == null || (sl9Var = a) == null) {
                return false;
            }
            for (sl9.a aVar : sl9Var.a) {
                if (str.equals(aVar.a)) {
                    for (Map.Entry entry : aVar.b.entrySet()) {
                        Object opt = jSONObject.opt((String) entry.getKey());
                        if (opt != null) {
                            Iterator it = ((Set) entry.getValue()).iterator();
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

    public static Object b(String str, zq9 zq9Var) {
        InterceptResult invokeLL;
        byte[] decode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, zq9Var)) == null) {
            if (str == null || zq9Var == null || (decode = Base64.decode(str, 0)) == null) {
                return null;
            }
            try {
                return zq9Var.a(new ObjectInputStream(new ByteArrayInputStream(decode)));
            } catch (IOException e) {
                LogPrinter.e(e);
                return null;
            }
        }
        return invokeLL.objValue;
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
    public static String d(br9 br9Var) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, br9Var)) == null) {
            if (br9Var != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    br9Var.srzable(objectOutputStream);
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

    public static void e(long j, a aVar, FunAdConfig funAdConfig, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), aVar, funAdConfig, map}) == null) {
            mr9.a aVar2 = mr9.a;
            aVar2.a = System.currentTimeMillis() - 0;
            aVar2.b = SystemClock.currentThreadTimeMillis() - 0;
            LogPrinter.d("All ssp initialized with %dms consumed.", Long.valueOf(System.currentTimeMillis() - j));
            funAdConfig.moduleInitManager.tryCallbackComplete();
            aVar.a(new kl9(map));
        }
    }

    public static void f(String str, String str2, FunAdConfig funAdConfig, Map map, String str3) {
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
            PidLoaderCreator init = module.init(funAdConfig, str3);
            if (init == null) {
                LogPrinter.e("Module for %s init failed", str);
            } else {
                map.put(str, init);
            }
        }
    }
}
