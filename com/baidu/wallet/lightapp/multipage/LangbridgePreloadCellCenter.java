package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import androidx.collection.ArraySet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.multipage.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes13.dex */
public class LangbridgePreloadCellCenter implements NoProguard, i.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int Millis = 1000;
    public static final String PRELOAD_POOL_TAG_FROM_NA = "PRELOAD";
    public static final String TAG = "LangbridgePreloadCellCenter";
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap<String, LinkedHashMap<b, c>> a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f51748b;

    /* renamed from: c  reason: collision with root package name */
    public Context f51749c;

    /* loaded from: classes13.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static LangbridgePreloadCellCenter a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(689540600, "Lcom/baidu/wallet/lightapp/multipage/LangbridgePreloadCellCenter$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(689540600, "Lcom/baidu/wallet/lightapp/multipage/LangbridgePreloadCellCenter$a;");
                    return;
                }
            }
            a = new LangbridgePreloadCellCenter();
        }
    }

    /* loaded from: classes13.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f51759b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap f51760c;

        /* renamed from: d  reason: collision with root package name */
        public String f51761d;

        /* renamed from: e  reason: collision with root package name */
        public long f51762e;

        /* renamed from: f  reason: collision with root package name */
        public int f51763f;

        /* renamed from: g  reason: collision with root package name */
        public String f51764g;

        public b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51763f = 0;
            this.a = str;
            this.f51762e = j2;
            this.f51759b = Integer.valueOf(CheckUtils.stripUrlParams(str).hashCode());
            this.f51760c = (HashMap) LangbridgePreloadCellCenter.getURLRequest(str);
            this.f51761d = LangbridgePreloadCellCenter.c(str);
            this.f51764g = LangbridgePreloadCellCenter.d(str);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "originUrl = " + this.a + "\tdeadTime = " + this.f51762e + "\turlHashCode = " + this.f51759b + "\turlReMap = " + this.f51760c.toString() + "\tref = " + this.f51761d + "\turlTag = " + this.f51764g;
            }
            return (String) invokeV.objValue;
        }
    }

    public static boolean checkURL(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, charSequence)) == null) {
            if (TextUtils.isEmpty(charSequence)) {
                return false;
            }
            boolean matches = Patterns.WEB_URL.matcher(charSequence).matches();
            if (matches) {
                return matches;
            }
            String str = ((Object) charSequence) + "";
            if (URLUtil.isNetworkUrl(str)) {
                try {
                    new URL(str);
                    return true;
                } catch (Exception unused) {
                    return matches;
                }
            }
            return matches;
        }
        return invokeL.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
        }
    }

    public static LangbridgePreloadCellCenter getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            LangbridgePreloadCellCenter langbridgePreloadCellCenter = a.a;
            if (langbridgePreloadCellCenter.f51749c == null && context != null) {
                langbridgePreloadCellCenter.f51749c = DxmApplicationContextImpl.getApplicationContext(context);
                a.a.f51748b = new Handler(Looper.getMainLooper());
                a.a.c();
            }
            return a.a;
        }
        return (LangbridgePreloadCellCenter) invokeL.objValue;
    }

    public static Map<String, String> getURLRequest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(str)) {
                return hashMap;
            }
            String str2 = null;
            try {
                str2 = new URL(str).getQuery();
                LogUtil.d(TAG, "query = " + str2);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
            if (TextUtils.isEmpty(str2)) {
                return hashMap;
            }
            for (String str3 : str2.split("[&]")) {
                String[] split = str3.split("[=]");
                if (split.length > 1) {
                    hashMap.put(split[0], split[1]);
                } else if (split[0] != "") {
                    hashMap.put(split[0], "");
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static boolean needNewWebviewOpen(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) ? !TextUtils.isEmpty(str) && str.contains("LangbridgePreloadPageTag=") : invokeL.booleanValue;
    }

    public void clearPreloadPool() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            DXMSdkSAUtils.onEvent("#clearPreloadPool");
            Runnable runnable = new Runnable(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LangbridgePreloadCellCenter a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            for (Map.Entry entry : this.a.a.entrySet()) {
                                String str = (String) entry.getKey();
                                Iterator it = ((Map) entry.getValue()).keySet().iterator();
                                while (it != null && it.hasNext()) {
                                    b bVar = (b) it.next();
                                    if (bVar != null && (cVar = (c) ((LinkedHashMap) this.a.a.get(str)).get(bVar)) != null) {
                                        cVar.i();
                                    }
                                }
                                this.a.a.remove(str);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            };
            if (Looper.getMainLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                this.f51748b.post(runnable);
            }
        }
    }

    public void clearPreloadPoolByGroup(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            DXMSdkSAUtils.onEventWithValues("#clearPreloadPool", Arrays.asList(str));
            Runnable runnable = new Runnable(this, str) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangbridgePreloadCellCenter f51757b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f51757b = this;
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            for (Map.Entry entry : this.f51757b.a.entrySet()) {
                                if (((String) entry.getKey()).equals(this.a)) {
                                    Iterator it = ((Map) entry.getValue()).keySet().iterator();
                                    while (it != null && it.hasNext()) {
                                        b bVar = (b) it.next();
                                        if (bVar != null && (cVar = (c) ((LinkedHashMap) this.f51757b.a.get(this.a)).get(bVar)) != null) {
                                            cVar.i();
                                        }
                                    }
                                    this.f51757b.a.remove(this.a);
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            };
            if (Looper.getMainLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                this.f51748b.post(runnable);
            }
        }
    }

    public c getCellFromPrePool(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, str2, z)) == null) {
            c cVar = null;
            if (!i.a().a(this.f51749c).MW_ON) {
                DXMSdkSAUtils.onEventWithValues("#preloadURLMatchRet", Arrays.asList("-1"));
                return null;
            }
            if (!TextUtils.isEmpty(str)) {
                b a3 = a(str, this.a.get(str2));
                if (a3 != null) {
                    LogUtil.d(TAG, "getCell success");
                    cVar = this.a.get(str2).get(a3);
                    this.a.get(str2).remove(a3);
                    e();
                } else if (z && (a2 = a(str, this.a.get("PRELOAD"))) != null) {
                    LogUtil.d(TAG, "getCell success");
                    cVar = this.a.get("PRELOAD").get(a2);
                    this.a.get("PRELOAD").remove(a2);
                    e();
                }
            }
            LogUtil.d(TAG, "getCell result = " + cVar);
            if (cVar == null) {
                DXMSdkSAUtils.onEventWithValues("#preloadURLMatchRet", Arrays.asList("1", str));
            } else {
                a(new Runnable(this, cVar) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LangbridgePreloadCellCenter f51753b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f51753b = this;
                        this.a = cVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.b() == null) {
                            return;
                        }
                        this.a.b().onResume();
                    }
                });
                DXMSdkSAUtils.onEventWithValues("#preloadURLMatchRet", Arrays.asList("0", str));
            }
            return cVar;
        }
        return (c) invokeLLZ.objValue;
    }

    public HashSet<String> getLangbridgeCellHashStampByGroup(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashSet<String> hashSet = new HashSet<>();
            for (Map.Entry<String, LinkedHashMap<b, c>> entry : this.a.entrySet()) {
                if (entry.getKey().equals(str)) {
                    Iterator<b> it = entry.getValue().keySet().iterator();
                    while (it != null && it.hasNext()) {
                        b next = it.next();
                        if (next != null) {
                            hashSet.add(this.a.get(str).get(next).k());
                        }
                    }
                }
            }
            return hashSet;
        }
        return (HashSet) invokeL.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.i.a
    public void onSettingUpdated(LangbridgeSettings langbridgeSettings) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, langbridgeSettings) == null) || langbridgeSettings.MW_ON) {
            return;
        }
        clearPreloadPool();
    }

    public void preload(ArrayList<String> arrayList, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, arrayList, str, str2) == null) {
            preload(arrayList, i.a().a(this.f51749c).MW_PRELOAD_LIFE_TIME, str, str2);
        }
    }

    public void preloadUrls(String[] strArr, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, strArr, z) == null) || !i.a().a(this.f51749c).MW_ON || strArr == null || strArr.length <= 0) {
            return;
        }
        ArraySet arraySet = new ArraySet();
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        for (String str : strArr) {
            if (!arraySet.contains(str) && checkURL(str)) {
                arraySet.add(str);
                if (!TextUtils.isEmpty(str) && str.contains("LangbridgePreloadMode=")) {
                    try {
                        int indexOf = str.indexOf("LangbridgePreloadMode=");
                        int indexOf2 = str.indexOf("LangbridgePreloadTime=");
                        String str2 = indexOf >= 0 ? str.substring(indexOf + 22).split("&")[0] : "";
                        String str3 = indexOf2 >= 0 ? str.substring(indexOf2 + 22).split("&")[0] : "";
                        if ("2".equals(str2) || ("1".equals(str2) && !z)) {
                            try {
                                i2 = Integer.valueOf(str3).intValue();
                            } catch (Exception unused) {
                                i2 = 0;
                            }
                            if (i2 <= 0) {
                                i2 = i.a().a(this.f51749c).MW_PRELOAD_LIFE_TIME;
                            }
                            this.f51748b.post(new Runnable(this, str, i2) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ String a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ int f51750b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ LangbridgePreloadCellCenter f51751c;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, str, Integer.valueOf(i2)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f51751c = this;
                                    this.a = str;
                                    this.f51750b = i2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.f51751c.a(this.a, this.f51750b, (String) null, (String) null);
                                    }
                                }
                            });
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        LogUtil.d(TAG, "preloadUrls cost:" + (System.currentTimeMillis() - valueOf.longValue()));
    }

    public synchronized void removeCellByCell(c cVar) {
        c cVar2;
        Set<b> keySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            synchronized (this) {
                if (cVar == null) {
                    return;
                }
                if (this.a.size() <= 0) {
                    return;
                }
                b bVar = null;
                String str = null;
                for (String str2 : this.a.keySet()) {
                    if (this.a.get(str2) != null && (keySet = this.a.get(str2).keySet()) != null) {
                        Iterator<b> it = keySet.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                b next = it.next();
                                if (cVar == this.a.get(str2).get(next)) {
                                    str = str2;
                                    bVar = next;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (bVar != null && !TextUtils.isEmpty(str) && (cVar2 = this.a.get(str).get(bVar)) != null && cVar2 == cVar) {
                    a(new Runnable(this, cVar2) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ c a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ LangbridgePreloadCellCenter f51752b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cVar2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f51752b = this;
                            this.a = cVar2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.a.i();
                            }
                        }
                    });
                    this.a.get(str).remove(bVar);
                    LogUtil.i(TAG, "remove cell from repload webviewPool，origin url: " + bVar);
                }
            }
        }
    }

    public void setAllCellsEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            a(new Runnable(this, z) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangbridgePreloadCellCenter f51758b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f51758b = this;
                    this.a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            for (Map.Entry entry : this.f51758b.a.entrySet()) {
                                String str = (String) entry.getKey();
                                Iterator it = ((Map) entry.getValue()).keySet().iterator();
                                while (it != null && it.hasNext()) {
                                    b bVar = (b) it.next();
                                    if (bVar != null && (cVar = (c) ((LinkedHashMap) this.f51758b.a.get(str)).get(bVar)) != null && cVar.b() != null) {
                                        if (this.a) {
                                            cVar.b().onResume();
                                        } else {
                                            cVar.b().onPause();
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public LangbridgePreloadCellCenter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedHashMap<>();
        i.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.f51748b.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LangbridgePreloadCellCenter a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.d();
                        this.a.c();
                    }
                }
            }, i.a().a(this.f51749c).MW_PRELOAD_CHECK_TIME * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            synchronized (this) {
                if (this.a.size() <= 0) {
                    return;
                }
                for (Map.Entry<String, LinkedHashMap<b, c>> entry : this.a.entrySet()) {
                    Set<b> keySet = entry.getValue().keySet();
                    Vector<b> vector = new Vector();
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    for (b bVar : keySet) {
                        if (bVar.f51762e <= valueOf.longValue()) {
                            LogUtil.d(TAG, "release cell : " + bVar.a);
                            c cVar = this.a.get(entry.getKey()).get(bVar);
                            if (cVar != null) {
                                cVar.i();
                            }
                            vector.add(bVar);
                        }
                    }
                    for (b bVar2 : vector) {
                        this.a.get(entry.getKey()).remove(bVar2);
                    }
                }
            }
        }
    }

    public void preload(ArrayList<String> arrayList, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048581, this, arrayList, i2, str, str2) == null) || !i.a().a(this.f51749c).MW_ON || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), i2, str, str2);
        }
        LogUtil.d(TAG, "preload map = " + this.a.toString());
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.a.size() <= 0) {
            return;
        }
        String str = null;
        b bVar = null;
        for (String str2 : this.a.keySet()) {
            for (b bVar2 : this.a.get(str2).keySet()) {
                if (bVar == null || bVar2.f51762e < bVar.f51762e) {
                    str = str2;
                    bVar = bVar2;
                }
            }
        }
        if (TextUtils.isEmpty(str) || bVar == null || this.a.get(str) == null) {
            return;
        }
        c cVar = this.a.get(str).get(bVar);
        if (cVar != null) {
            cVar.i();
        }
        this.a.get(str).remove(bVar);
        DXMSdkSAUtils.onEventWithValues("#popOldestPreloadUrl", Arrays.asList(bVar.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65545, this, str, i2, str2, str3) == null) {
            synchronized (this) {
                DXMSdkSAUtils.onEventWithValues("#preloadURL", Arrays.asList(str, "" + i2));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() + (i2 * 1000));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "PRELOAD";
                }
                b a2 = a(str, this.a.get(str2));
                if (a2 != null) {
                    c cVar = this.a.get(str2).get(a2);
                    if (cVar != null) {
                        LogUtil.i(TAG, "had preloaded, refresh" + a2);
                        a2.f51763f = 0;
                        b(str2, a2, cVar);
                    }
                    a2.f51762e = valueOf.longValue();
                    DXMSdkSAUtils.onEventWithValues("#preloadURLRet", Arrays.asList("0", str));
                    return;
                }
                if (a() >= i.a().a(this.f51749c).MW_PRELOAD_POOL_SUM) {
                    b();
                }
                LightappBrowserWebView lightappWebViewFromPool = LightappWebViewCenter.getInstance().getLightappWebViewFromPool();
                if (lightappWebViewFromPool == null) {
                    b();
                    lightappWebViewFromPool = LightappWebViewCenter.getInstance().getLightappWebViewFromPool();
                }
                if (lightappWebViewFromPool != null) {
                    LangbridgeCell langbridgeCell = new LangbridgeCell(this.f51749c, lightappWebViewFromPool, str2, str3);
                    b bVar = new b(str, valueOf.longValue());
                    a(str2, bVar, langbridgeCell);
                    b(str2, bVar, langbridgeCell);
                    DXMSdkSAUtils.onEventWithValues("#preloadURLRet", Arrays.asList("1", str));
                } else {
                    LogUtil.d(TAG, "preload fail [" + str + PreferencesUtil.RIGHT_MOUNT);
                    DXMSdkSAUtils.onEventWithValues("#preloadURLRet", Arrays.asList("-1", str));
                }
            }
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            String str2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                str2 = new URL(str).getRef();
                LogUtil.d(TAG, "getURlRef = " + str2);
                return str2;
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                return str2;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, b bVar, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, this, str, bVar, cVar) == null) || bVar == null || cVar == null || TextUtils.isEmpty(bVar.a)) {
            return;
        }
        LogUtil.d(TAG, "preloadUrlbyCell url = " + bVar.a + " ; cell = " + cVar + " ; reloadTimes = " + bVar.f51763f);
        int i2 = bVar.f51763f;
        bVar.f51763f = i2 + (-1);
        if (i2 >= 0) {
            cVar.a(bVar.a, new com.baidu.wallet.lightapp.multipage.b(this, cVar, str, bVar) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f51754b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f51755c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LangbridgePreloadCellCenter f51756d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar, str, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f51756d = this;
                    this.a = cVar;
                    this.f51754b = str;
                    this.f51755c = bVar;
                }

                @Override // com.baidu.wallet.lightapp.multipage.b
                public void a(int i3, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str2, str3) == null) {
                        if (i3 == 0 && !TextUtils.isEmpty(str3) && !TextUtils.equals("about:blank", str3)) {
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preload success url = " + str3);
                        } else if (i3 != 1101 && i3 != 1102) {
                            if (this.f51755c.f51763f < 0) {
                                this.a.i();
                                if (this.f51756d.a.containsKey(this.f51754b) && ((LinkedHashMap) this.f51756d.a.get(this.f51754b)).values() != null) {
                                    ((LinkedHashMap) this.f51756d.a.get(this.f51754b)).values().remove(this.a);
                                }
                                e a2 = e.a();
                                Context context = this.f51756d.f51749c;
                                a2.a(context, 1, "preload fail", Arrays.asList(str3, "" + i3, str2));
                                LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onError destory url = " + str3);
                                return;
                            }
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onError code = " + i3 + " ; desc = " + str2 + " ; url = " + str3);
                            this.f51756d.b(this.f51754b, this.f51755c, this.a);
                        } else {
                            this.a.i();
                            if (this.f51756d.a.containsKey(this.f51754b) && ((LinkedHashMap) this.f51756d.a.get(this.f51754b)).values() != null) {
                                ((LinkedHashMap) this.f51756d.a.get(this.f51754b)).values().remove(this.a);
                            }
                            e a3 = e.a();
                            Context context2 = this.f51756d.f51749c;
                            a3.a(context2, 1, "preload exception", Arrays.asList(str3, "" + i3, str2));
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onException destory url = " + str3);
                        }
                    }
                }
            }, true);
        }
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int indexOf = str.indexOf("LangbridgePreloadPageTag=");
            return indexOf >= 0 ? str.substring(indexOf + 25).split("&")[0] : "";
        }
        return (String) invokeL.objValue;
    }

    private int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int i2 = 0;
            for (String str : this.a.keySet()) {
                i2 += this.a.get(str).size();
            }
            return i2;
        }
        return invokeV.intValue;
    }

    private void a(String str, b bVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, this, str, bVar, cVar) == null) {
            if (this.a.containsKey(str)) {
                this.a.get(str).put(bVar, cVar);
                return;
            }
            LinkedHashMap<b, c> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(bVar, cVar);
            this.a.put(str, linkedHashMap);
        }
    }

    private b a(String str, LinkedHashMap linkedHashMap) {
        InterceptResult invokeLL;
        b bVar;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, linkedHashMap)) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            if (TextUtils.isEmpty(str) || linkedHashMap == null || linkedHashMap.size() <= 0) {
                return null;
            }
            b bVar2 = new b(str, 0L);
            Integer valueOf = Integer.valueOf(CheckUtils.stripUrlParams(str).hashCode());
            HashMap hashMap2 = bVar2.f51760c;
            DXMSdkSAUtils.onEventStart("#webviewPoolMatchTime");
            LogUtil.d(TAG, "targetIns = " + bVar2.toString());
            if (valueOf != null) {
                Iterator it = linkedHashMap.entrySet().iterator();
                bVar = null;
                while (true) {
                    if (it == null || !it.hasNext()) {
                        break;
                    }
                    bVar = (b) ((Map.Entry) it.next()).getKey();
                    if (bVar != null && bVar.f51759b != null) {
                        if (!TextUtils.isEmpty(bVar2.f51764g) && bVar2.f51764g.equals(bVar.f51764g)) {
                            atomicBoolean.set(true);
                            break;
                        }
                        LogUtil.d(TAG, "poolIns = " + bVar.toString());
                        if (bVar.a.equals(bVar2.a)) {
                            atomicBoolean.set(true);
                            break;
                        }
                        hashMap = bVar.f51760c;
                        if (valueOf.equals(bVar.f51759b)) {
                            LogUtil.d(TAG, "protocol+host is match");
                            atomicBoolean.compareAndSet(false, true);
                            String str2 = bVar2.f51761d;
                            if (str2 != bVar.f51761d && (TextUtils.isEmpty(str2) || !bVar2.f51761d.equals(bVar.f51761d))) {
                                LogUtil.d(TAG, "ref is not match");
                                atomicBoolean.set(false);
                            } else {
                                LogUtil.d(TAG, "ref is match");
                                if (hashMap2 == null || hashMap.equals(hashMap2)) {
                                    break;
                                }
                                Iterator it2 = hashMap2.entrySet().iterator();
                                Iterator it3 = hashMap.entrySet().iterator();
                                if (it2 != null && it3 != null && hashMap2.size() > 0 && hashMap2.size() >= hashMap.size()) {
                                    while (it3.hasNext() && atomicBoolean.compareAndSet(true, false)) {
                                        Map.Entry entry = (Map.Entry) it3.next();
                                        String str3 = (String) entry.getKey();
                                        String str4 = (String) entry.getValue();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                Map.Entry entry2 = (Map.Entry) it2.next();
                                                String str5 = (String) entry2.getValue();
                                                if (((String) entry2.getKey()).equals(str3) && str5.equals(str4)) {
                                                    atomicBoolean.set(true);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if (atomicBoolean.get()) {
                                        LogUtil.d(TAG, "query is match");
                                        break;
                                    }
                                } else {
                                    LogUtil.d(TAG, "query is not match");
                                    atomicBoolean.set(false);
                                }
                            }
                        } else {
                            LogUtil.d(TAG, "protocol+host is not match");
                            atomicBoolean.set(false);
                        }
                    } else {
                        atomicBoolean.set(false);
                    }
                }
                LogUtil.d(TAG, "targetReqMap = " + hashMap2.toString() + " \n poolReqMap = " + hashMap.toString());
                atomicBoolean.set(true);
            } else {
                bVar = null;
            }
            DXMSdkSAUtils.onEventEnd("#webviewPoolMatchTime", atomicBoolean.get() ? 1 : 0);
            if (atomicBoolean.get()) {
                return bVar;
            }
            return null;
        }
        return (b) invokeLL.objValue;
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, runnable) == null) || runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
