package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
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
import com.baidu.wallet.lightapp.multipage.h;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class LangbridgePreloadCellCenter implements NoProguard, h.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int Millis = 1000;
    public static final String PRELOAD_POOL_TAG_FROM_NA = "PRELOAD";
    public static final String TAG = "LangbridgePreloadCellCenter";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, LinkedHashMap<b, c>> f25613a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f25614b;

    /* renamed from: c  reason: collision with root package name */
    public Context f25615c;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LangbridgePreloadCellCenter f25631a;
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
            f25631a = new LangbridgePreloadCellCenter();
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f25632a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f25633b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap f25634c;

        /* renamed from: d  reason: collision with root package name */
        public String f25635d;

        /* renamed from: e  reason: collision with root package name */
        public long f25636e;

        /* renamed from: f  reason: collision with root package name */
        public int f25637f;

        public b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25637f = 0;
            this.f25632a = str;
            this.f25636e = j;
            this.f25633b = Integer.valueOf(CheckUtils.stripUrlParams(str).hashCode());
            this.f25634c = (HashMap) LangbridgePreloadCellCenter.getURLRequest(str);
            this.f25635d = LangbridgePreloadCellCenter.b(str);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "originUrl = " + this.f25632a + "\tdeadTime = " + this.f25636e + "\turlHashCode = " + this.f25633b + "\turlReMap = " + this.f25634c.toString() + "\tref = " + this.f25635d;
            }
            return (String) invokeV.objValue;
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
        }
    }

    public static LangbridgePreloadCellCenter getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            LangbridgePreloadCellCenter langbridgePreloadCellCenter = a.f25631a;
            if (langbridgePreloadCellCenter.f25615c == null && context != null) {
                langbridgePreloadCellCenter.f25615c = context.getApplicationContext();
                a.f25631a.f25614b = new Handler(Looper.getMainLooper());
                a.f25631a.c();
            }
            return a.f25631a;
        }
        return (LangbridgePreloadCellCenter) invokeL.objValue;
    }

    public static Map<String, String> getURLRequest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
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

    public void clearPreloadPool() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            DXMSdkSAUtils.onEvent("#clearPreloadPool");
            PayStatisticsUtil.onEvent("#clearPreloadPool");
            Runnable runnable = new Runnable(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgePreloadCellCenter f25628a;

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
                    this.f25628a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            for (Map.Entry entry : this.f25628a.f25613a.entrySet()) {
                                String str = (String) entry.getKey();
                                Iterator it = ((Map) entry.getValue()).keySet().iterator();
                                while (it != null && it.hasNext()) {
                                    b bVar = (b) it.next();
                                    if (bVar != null && (cVar = (c) ((LinkedHashMap) this.f25628a.f25613a.get(str)).get(bVar)) != null) {
                                        cVar.i();
                                    }
                                }
                                this.f25628a.f25613a.remove(str);
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
                this.f25614b.post(runnable);
            }
        }
    }

    public void clearPreloadPoolByGroup(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            DXMSdkSAUtils.onEventWithValues("#clearPreloadPool", Arrays.asList(str));
            PayStatisticsUtil.onEventWithValue("#clearPreloadPool", str);
            Runnable runnable = new Runnable(this, str) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f25626a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangbridgePreloadCellCenter f25627b;

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
                    this.f25627b = this;
                    this.f25626a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            for (Map.Entry entry : this.f25627b.f25613a.entrySet()) {
                                if (((String) entry.getKey()).equals(this.f25626a)) {
                                    Iterator it = ((Map) entry.getValue()).keySet().iterator();
                                    while (it != null && it.hasNext()) {
                                        b bVar = (b) it.next();
                                        if (bVar != null && (cVar = (c) ((LinkedHashMap) this.f25627b.f25613a.get(this.f25626a)).get(bVar)) != null) {
                                            cVar.i();
                                        }
                                    }
                                    this.f25627b.f25613a.remove(this.f25626a);
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
                this.f25614b.post(runnable);
            }
        }
    }

    public c getCellFromPrePool(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, str2, z)) == null) {
            c cVar = null;
            if (!h.a().a(this.f25615c).MW_ON) {
                DXMSdkSAUtils.onEventWithValues("#preloadURLMatchRet", Arrays.asList("-1"));
                PayStatisticsUtil.onEventWithValue("#preloadURLMatchRet", "-1");
                return null;
            }
            if (!TextUtils.isEmpty(str)) {
                b a3 = a(str, this.f25613a.get(str2));
                if (a3 != null) {
                    LogUtil.d(TAG, "getCell success");
                    cVar = this.f25613a.get(str2).get(a3);
                    this.f25613a.get(str2).remove(a3);
                    e();
                } else if (z && (a2 = a(str, this.f25613a.get("PRELOAD"))) != null) {
                    LogUtil.d(TAG, "getCell success");
                    cVar = this.f25613a.get("PRELOAD").get(a2);
                    this.f25613a.get("PRELOAD").remove(a2);
                    e();
                }
            }
            LogUtil.d(TAG, "getCell result = " + cVar);
            if (cVar == null) {
                DXMSdkSAUtils.onEventWithValues("#preloadURLMatchRet", Arrays.asList("1", str));
                PayStatisticsUtil.onEventWithValues("#preloadURLMatchRet", Arrays.asList("1", str));
            } else {
                a(new Runnable(this, cVar) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f25620a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LangbridgePreloadCellCenter f25621b;

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
                        this.f25621b = this;
                        this.f25620a = cVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f25620a.b() == null) {
                            return;
                        }
                        this.f25620a.b().onResume();
                    }
                });
                DXMSdkSAUtils.onEventWithValues("#preloadURLMatchRet", Arrays.asList("0", str));
                PayStatisticsUtil.onEventWithValues("#preloadURLMatchRet", Arrays.asList("0", str));
            }
            return cVar;
        }
        return (c) invokeLLZ.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.h.a
    public void onSettingUpdated(LangbridgeSettings langbridgeSettings) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, langbridgeSettings) == null) || langbridgeSettings.MW_ON) {
            return;
        }
        clearPreloadPool();
    }

    public void preload(ArrayList<String> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, arrayList, str) == null) {
            preload(arrayList, h.a().a(this.f25615c).MW_PRELOAD_LIFE_TIME, str);
        }
    }

    public void preloadUrls(String[] strArr, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, strArr, z) == null) || !h.a().a(this.f25615c).MW_ON || strArr == null || strArr.length <= 0) {
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        for (String str : strArr) {
            try {
                String str2 = "";
                String str3 = "";
                for (String str4 : new URL(str).getQuery().split("&")) {
                    String[] split = str4.split("=");
                    if (split.length > 1) {
                        if ("LangbridgePreloadMode".equals(split[0])) {
                            str2 = split[1];
                        } else if ("LangbridgePreloadTime".equals(split[0])) {
                            str3 = split[1];
                        }
                    }
                }
                if ("2".equals(str2) || ("1".equals(str2) && !z)) {
                    try {
                        i2 = Integer.valueOf(str3).intValue();
                    } catch (Exception unused) {
                        i2 = 0;
                    }
                    if (i2 <= 0) {
                        i2 = h.a().a(this.f25615c).MW_PRELOAD_LIFE_TIME;
                    }
                    this.f25614b.post(new Runnable(this, str, i2) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f25616a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f25617b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ LangbridgePreloadCellCenter f25618c;

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
                            this.f25618c = this;
                            this.f25616a = str;
                            this.f25617b = i2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f25618c.a(this.f25616a, this.f25617b, (String) null);
                            }
                        }
                    });
                }
            } catch (Exception unused2) {
            }
        }
        LogUtil.d(TAG, "preloadUrls cost:" + (System.currentTimeMillis() - valueOf.longValue()));
    }

    public void setAllCellsEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            a(new Runnable(this, z) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f25629a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangbridgePreloadCellCenter f25630b;

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
                    this.f25630b = this;
                    this.f25629a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            for (Map.Entry entry : this.f25630b.f25613a.entrySet()) {
                                String str = (String) entry.getKey();
                                Iterator it = ((Map) entry.getValue()).keySet().iterator();
                                while (it != null && it.hasNext()) {
                                    b bVar = (b) it.next();
                                    if (bVar != null && (cVar = (c) ((LinkedHashMap) this.f25630b.f25613a.get(str)).get(bVar)) != null && cVar.b() != null) {
                                        if (this.f25629a) {
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
        this.f25613a = new LinkedHashMap<>();
        h.a().a(this);
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.f25613a.size() <= 0) {
            return;
        }
        String str = null;
        b bVar = null;
        for (String str2 : this.f25613a.keySet()) {
            for (b bVar2 : this.f25613a.get(str2).keySet()) {
                if (bVar == null || bVar2.f25636e < bVar.f25636e) {
                    str = str2;
                    bVar = bVar2;
                }
            }
        }
        if (TextUtils.isEmpty(str) || bVar == null || this.f25613a.get(str) == null) {
            return;
        }
        c cVar = this.f25613a.get(str).get(bVar);
        if (cVar != null) {
            cVar.i();
        }
        this.f25613a.get(str).remove(bVar);
        DXMSdkSAUtils.onEventWithValues("#popOldestPreloadUrl", Arrays.asList(bVar.toString()));
        PayStatisticsUtil.onEventWithValue("#popOldestPreloadUrl", bVar.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.f25614b.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgePreloadCellCenter f25619a;

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
                    this.f25619a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f25619a.d();
                        this.f25619a.c();
                    }
                }
            }, h.a().a(this.f25615c).MW_PRELOAD_CHECK_TIME * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            synchronized (this) {
                if (this.f25613a.size() <= 0) {
                    return;
                }
                for (Map.Entry<String, LinkedHashMap<b, c>> entry : this.f25613a.entrySet()) {
                    Set<b> keySet = entry.getValue().keySet();
                    Vector<b> vector = new Vector();
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    for (b bVar : keySet) {
                        if (bVar.f25636e <= valueOf.longValue()) {
                            LogUtil.d(TAG, "release cell : " + bVar.f25632a);
                            c cVar = this.f25613a.get(entry.getKey()).get(bVar);
                            if (cVar != null) {
                                cVar.i();
                            }
                            vector.add(bVar);
                        }
                    }
                    for (b bVar2 : vector) {
                        this.f25613a.get(entry.getKey()).remove(bVar2);
                    }
                }
            }
        }
    }

    public void preload(ArrayList<String> arrayList, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048580, this, arrayList, i2, str) == null) || !h.a().a(this.f25615c).MW_ON || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), i2, str);
        }
        LogUtil.d(TAG, "preload map = " + this.f25613a.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, this, str, i2, str2) == null) {
            synchronized (this) {
                DXMSdkSAUtils.onEventWithValues("#preloadURL", Arrays.asList(str, "" + i2));
                PayStatisticsUtil.onEventWithValues("#preloadURL", Arrays.asList(str, "" + i2));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() + (i2 * 1000));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "PRELOAD";
                }
                b a2 = a(str, this.f25613a.get(str2));
                if (a2 != null) {
                    a2.f25636e = valueOf.longValue();
                    DXMSdkSAUtils.onEventWithValues("#preloadURLRet", Arrays.asList("0", str));
                    PayStatisticsUtil.onEventWithValues("#preloadURLRet", Arrays.asList("0", str));
                    return;
                }
                if (a() >= h.a().a(this.f25615c).MW_PRELOAD_POOL_SUM) {
                    b();
                }
                LightappBrowserWebView lightappWebViewFromPool = LightappWebViewCenter.getInstance().getLightappWebViewFromPool();
                if (lightappWebViewFromPool == null) {
                    b();
                    lightappWebViewFromPool = LightappWebViewCenter.getInstance().getLightappWebViewFromPool();
                }
                if (lightappWebViewFromPool != null) {
                    LangbridgeCell langbridgeCell = new LangbridgeCell(this.f25615c, lightappWebViewFromPool, str2);
                    b bVar = new b(str, valueOf.longValue());
                    a(str2, bVar, langbridgeCell);
                    b(str2, bVar, langbridgeCell);
                    DXMSdkSAUtils.onEventWithValues("#preloadURLRet", Arrays.asList("1", str));
                    PayStatisticsUtil.onEventWithValues("#preloadURLRet", Arrays.asList("1", str));
                } else {
                    LogUtil.d(TAG, "preload fail [" + str + PreferencesUtil.RIGHT_MOUNT);
                    DXMSdkSAUtils.onEventWithValues("#preloadURLRet", Arrays.asList("-1", str));
                    PayStatisticsUtil.onEventWithValues("#preloadURLRet", Arrays.asList("-1", str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, b bVar, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, this, str, bVar, cVar) == null) || bVar == null || cVar == null || TextUtils.isEmpty(bVar.f25632a)) {
            return;
        }
        LogUtil.d(TAG, "preloadUrlbyCell url = " + bVar.f25632a + " ; cell = " + cVar + " ; reloadTimes = " + bVar.f25637f);
        int i2 = bVar.f25637f;
        bVar.f25637f = i2 + (-1);
        if (i2 >= 0) {
            cVar.a(bVar.f25632a, new com.baidu.wallet.lightapp.multipage.b(this, cVar, str, bVar) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f25622a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25623b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f25624c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LangbridgePreloadCellCenter f25625d;

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
                    this.f25625d = this;
                    this.f25622a = cVar;
                    this.f25623b = str;
                    this.f25624c = bVar;
                }

                @Override // com.baidu.wallet.lightapp.multipage.b
                public void a(int i3, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str2, str3) == null) {
                        if (i3 == 0) {
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preload success url = " + str3);
                        } else if (i3 != 1101 && i3 != 1102) {
                            if (this.f25624c.f25637f < 0) {
                                this.f25622a.i();
                                ((LinkedHashMap) this.f25625d.f25613a.get(this.f25623b)).values().remove(this.f25622a);
                                e a2 = e.a();
                                Context context = this.f25625d.f25615c;
                                a2.a(context, 1, "preload fail", Arrays.asList(str3, "" + i3, str2));
                                LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onError destory url = " + str3);
                                return;
                            }
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onError code = " + i3 + " ; desc = " + str2 + " ; url = " + str3);
                            this.f25625d.b(this.f25623b, this.f25624c, this.f25622a);
                        } else {
                            this.f25622a.i();
                            ((LinkedHashMap) this.f25625d.f25613a.get(this.f25623b)).values().remove(this.f25622a);
                            e a3 = e.a();
                            Context context2 = this.f25625d.f25615c;
                            a3.a(context2, 1, "preload exception", Arrays.asList(str3, "" + i3, str2));
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onException destory url = " + str3);
                        }
                    }
                }
            });
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
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

    private int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int i2 = 0;
            for (String str : this.f25613a.keySet()) {
                i2 += this.f25613a.get(str).size();
            }
            return i2;
        }
        return invokeV.intValue;
    }

    private void a(String str, b bVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, this, str, bVar, cVar) == null) {
            if (this.f25613a.containsKey(str)) {
                this.f25613a.get(str).put(bVar, cVar);
                return;
            }
            LinkedHashMap<b, c> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(bVar, cVar);
            this.f25613a.put(str, linkedHashMap);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x014b, code lost:
        com.baidu.wallet.core.utils.LogUtil.d(com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.TAG, "targetReqMap = " + r5.toString() + " \n poolReqMap = " + r9.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private b a(String str, LinkedHashMap linkedHashMap) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, linkedHashMap)) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            if (TextUtils.isEmpty(str) || linkedHashMap == null || linkedHashMap.size() <= 0) {
                return null;
            }
            b bVar2 = new b(str, 0L);
            Integer valueOf = Integer.valueOf(CheckUtils.stripUrlParams(str).hashCode());
            HashMap hashMap = bVar2.f25634c;
            LogUtil.d(TAG, "targetIns = " + bVar2.toString());
            if (valueOf != null) {
                Iterator it = linkedHashMap.entrySet().iterator();
                bVar = null;
                while (true) {
                    if (it == null || !it.hasNext()) {
                        break;
                    }
                    bVar = (b) ((Map.Entry) it.next()).getKey();
                    if (bVar != null && bVar.f25633b != null) {
                        LogUtil.d(TAG, "poolIns = " + bVar.toString());
                        HashMap hashMap2 = bVar.f25634c;
                        if (valueOf.equals(bVar.f25633b)) {
                            LogUtil.d(TAG, "protocol+host is match");
                            atomicBoolean.compareAndSet(false, true);
                            String str2 = bVar2.f25635d;
                            if (str2 != bVar.f25635d && (TextUtils.isEmpty(str2) || !bVar2.f25635d.equals(bVar.f25635d))) {
                                LogUtil.d(TAG, "ref is not match");
                                atomicBoolean.set(false);
                            } else {
                                LogUtil.d(TAG, "ref is match");
                                if (hashMap == null || hashMap2.equals(hashMap)) {
                                    break;
                                }
                                Iterator it2 = hashMap.entrySet().iterator();
                                Iterator it3 = hashMap2.entrySet().iterator();
                                if (it2 != null && it3 != null && hashMap.size() > 0 && hashMap.size() >= hashMap2.size()) {
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
            } else {
                bVar = null;
            }
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
