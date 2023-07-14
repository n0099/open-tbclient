package com.baidu.tieba;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.cfb;
import com.baidu.tieba.jlb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.Module;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class xeb {
    public static /* synthetic */ Interceptable $ic;
    public static cfb a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void a(Map<String, PidLoaderCreator> map);
    }

    public static <T extends seb> T a(Random random, List<T> list, yeb<T> yebVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, random, list, yebVar)) == null) {
            if (random == null || list == null || list.isEmpty()) {
                return null;
            }
            LogPrinter.v("Start select for class:%s with size:%d", list.iterator().next().getClass().getSimpleName(), Integer.valueOf(list.size()));
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            T t = null;
            for (int i = 0; i < size; i++) {
                T t2 = list.get(i);
                if (yebVar != null) {
                    if (!yebVar.a(t2)) {
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

    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(final FunAdConfig funAdConfig, Set<Ssp> set, final a aVar) {
        char c;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, funAdConfig, set, aVar) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new RuntimeException("Wrong thread");
            }
            final HashMap hashMap = new HashMap();
            final ArrayList arrayList = new ArrayList();
            final long currentTimeMillis = System.currentTimeMillis();
            for (Ssp ssp : set) {
                if (!TextUtils.isEmpty(ssp.sspId)) {
                    if (funAdConfig.forbiddenPlatforms.contains(ssp.type)) {
                        LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp.type);
                    } else {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String str2 = ssp.type;
                        str2.hashCode();
                        int hashCode = str2.hashCode();
                        if (hashCode == 3160) {
                            if (str2.equals(FunAdSdk.PLATFORM_BZ)) {
                                c = 0;
                                if (c == 0) {
                                }
                                if (str == null) {
                                }
                            }
                            c = 65535;
                            if (c == 0) {
                            }
                            if (str == null) {
                            }
                        } else if (hashCode == 3175) {
                            if (str2.equals(FunAdSdk.PLATFORM_CJ)) {
                                c = 1;
                                if (c == 0) {
                                }
                                if (str == null) {
                                }
                            }
                            c = 65535;
                            if (c == 0) {
                            }
                            if (str == null) {
                            }
                        } else if (hashCode != 3178) {
                            if (hashCode == 98810 && str2.equals(FunAdSdk.PLATFORM_CSJ)) {
                                c = 3;
                                str = c == 0 ? c != 1 ? c != 2 ? c != 3 ? null : "com.fun.ad.sdk.channel.CsjModule" : "com.fun.ad.sdk.channel.CMModule" : "com.fun.ad.sdk.channel.CjModule" : "com.fun.ad.sdk.channel.BzModule";
                                if (str == null) {
                                    LogPrinter.d("sdk for %s init start", ssp.type);
                                    g(ssp.type, str, funAdConfig, hashMap, ssp.sspId);
                                    LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                } else {
                                    arrayList.add(ssp);
                                }
                            }
                            c = 65535;
                            if (c == 0) {
                            }
                            if (str == null) {
                            }
                        } else {
                            if (str2.equals(FunAdSdk.PLATFORM_CM)) {
                                c = 2;
                                if (c == 0) {
                                }
                                if (str == null) {
                                }
                            }
                            c = 65535;
                            if (c == 0) {
                            }
                            if (str == null) {
                            }
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                e(currentTimeMillis, aVar, funAdConfig, hashMap);
            } else {
                new Thread(new Runnable() { // from class: com.baidu.tieba.deb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            xeb.h(arrayList, funAdConfig, hashMap, currentTimeMillis, aVar);
                        }
                    }
                }).start();
            }
        }
    }

    public static /* synthetic */ void h(List list, FunAdConfig funAdConfig, Map map, long j, a aVar) {
        String str;
        String str2;
        String str3;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Ssp ssp = (Ssp) it.next();
            if (!funAdConfig.forbiddenPlatforms.contains(ssp.type)) {
                long currentTimeMillis = System.currentTimeMillis();
                LogPrinter.d("sdk for %s init start", ssp.type);
                String str4 = ssp.type;
                str4.hashCode();
                char c = 65535;
                switch (str4.hashCode()) {
                    case 3116:
                        if (str4.equals(FunAdSdk.PLATFORM_AM)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3127:
                        if (str4.equals(FunAdSdk.PLATFORM_AX)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3343:
                        if (str4.equals(FunAdSdk.PLATFORM_HW)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3370:
                        if (str4.equals("is")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 3407:
                        if (str4.equals(FunAdSdk.PLATFORM_JY)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 3432:
                        if (str4.equals(FunAdSdk.PLATFORM_KS)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 3477:
                        if (str4.equals(FunAdSdk.PLATFORM_MB)) {
                            c = 6;
                            break;
                        }
                        break;
                    case 3483:
                        if (str4.equals(FunAdSdk.PLATFORM_MH)) {
                            c = 7;
                            break;
                        }
                        break;
                    case 3488:
                        if (str4.equals(FunAdSdk.PLATFORM_MM)) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 3560:
                        if (str4.equals(FunAdSdk.PLATFORM_OW)) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 3575:
                        if (str4.equals(FunAdSdk.PLATFORM_PG)) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 3693:
                        if (str4.equals(FunAdSdk.PLATFORM_TA)) {
                            c = 11;
                            break;
                        }
                        break;
                    case 96437:
                        if (str4.equals(FunAdSdk.PLATFORM_ADX)) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 102199:
                        if (str4.equals(FunAdSdk.PLATFORM_GDT)) {
                            c = '\r';
                            break;
                        }
                        break;
                    case 107876:
                        if (str4.equals(FunAdSdk.PLATFORM_MAX)) {
                            c = 14;
                            break;
                        }
                        break;
                    case 113873:
                        if (str4.equals(FunAdSdk.PLATFORM_SIG)) {
                            c = 15;
                            break;
                        }
                        break;
                    case 3023727:
                        if (str4.equals(FunAdSdk.PLATFORM_BIGO)) {
                            c = 16;
                            break;
                        }
                        break;
                    case 3418016:
                        if (str4.equals("oppo")) {
                            c = 17;
                            break;
                        }
                        break;
                    case 3620012:
                        if (str4.equals("vivo")) {
                            c = 18;
                            break;
                        }
                        break;
                    case 93498907:
                        if (str4.equals("baidu")) {
                            c = 19;
                            break;
                        }
                        break;
                    case 110532770:
                        if (str4.equals(FunAdSdk.PLATFORM_TOBID)) {
                            c = 20;
                            break;
                        }
                        break;
                    case 293190201:
                        if (str4.equals(FunAdSdk.PLATFORM_GROMORE)) {
                            c = 21;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.am.AmModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 1:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.AxModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 2:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.HwModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 3:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.is.IsModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 4:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.JyModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 5:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.KsModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 6:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.MbModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 7:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.MhModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case '\b':
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.MmModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case '\t':
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.OwModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case '\n':
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.pg.PgModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 11:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.TAModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case '\f':
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.adx.AdxModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case '\r':
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.GdtModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 14:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.max.MaxModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 15:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.SigModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 16:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.bigo.BigoModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 17:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.oppo.OppoModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 18:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.VivoModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 19:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.BaiduModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 20:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.ToBidModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    case 21:
                        str = ssp.type;
                        str2 = ssp.sspId;
                        str3 = "com.fun.ad.sdk.channel.GmModule";
                        g(str, str3, funAdConfig, map, str2);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                    default:
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                }
            } else {
                LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp.type);
            }
        }
        e(j, aVar, funAdConfig, map);
    }

    public static boolean i(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        cfb cfbVar;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, jSONObject)) == null) {
            if (str == null || jSONObject == null || (cfbVar = a) == null) {
                return false;
            }
            for (cfb.a aVar : cfbVar.a) {
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

    public static <T> T b(String str, ofb<T> ofbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, ofbVar)) == null) {
            if (str == null || ofbVar == null) {
                return null;
            }
            try {
                byte[] decode = Base64.decode(str, 0);
                if (decode == null) {
                    return null;
                }
                try {
                    return ofbVar.a(new ObjectInputStream(new ByteArrayInputStream(decode)));
                } catch (IOException e) {
                    LogPrinter.e(e);
                    return null;
                }
            } catch (Exception unused) {
                return null;
            }
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
    public static String d(qfb qfbVar) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, qfbVar)) == null) {
            if (qfbVar != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    qfbVar.srzable(objectOutputStream);
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
            jlb.a aVar2 = jlb.a;
            aVar2.a = System.currentTimeMillis() - 0;
            aVar2.b = SystemClock.currentThreadTimeMillis() - 0;
            LogPrinter.d("All ssp initialized with %dms consumed.", Long.valueOf(System.currentTimeMillis() - j));
            funAdConfig.moduleInitManager.tryCallbackComplete();
            aVar.a(map);
        }
    }

    public static void g(String str, String str2, FunAdConfig funAdConfig, Map<String, PidLoaderCreator> map, String str3) {
        Module module;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, str, str2, funAdConfig, map, str3) == null) {
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
