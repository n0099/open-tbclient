package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
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
/* loaded from: classes5.dex */
public class LangbridgePreloadCellCenter implements NoProguard, h.a {
    public static final int Millis = 1000;
    public static final String PRELOAD_POOL_TAG_FROM_NA = "PRELOAD";
    public static final String TAG = "LangbridgePreloadCellCenter";

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, LinkedHashMap<b, c>> f24956a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f24957b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24958c;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LangbridgePreloadCellCenter f24974a = new LangbridgePreloadCellCenter();
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f24975a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f24976b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap f24977c;

        /* renamed from: d  reason: collision with root package name */
        public String f24978d;

        /* renamed from: e  reason: collision with root package name */
        public long f24979e;

        /* renamed from: f  reason: collision with root package name */
        public int f24980f = 0;

        public b(String str, long j) {
            this.f24975a = str;
            this.f24979e = j;
            this.f24976b = Integer.valueOf(CheckUtils.stripUrlParams(str).hashCode());
            this.f24977c = (HashMap) LangbridgePreloadCellCenter.getURLRequest(str);
            this.f24978d = LangbridgePreloadCellCenter.b(str);
        }

        public String toString() {
            return "originUrl = " + this.f24975a + "\tdeadTime = " + this.f24979e + "\turlHashCode = " + this.f24976b + "\turlReMap = " + this.f24977c.toString() + "\tref = " + this.f24978d;
        }
    }

    private void e() {
    }

    public static LangbridgePreloadCellCenter getInstance(Context context) {
        LangbridgePreloadCellCenter langbridgePreloadCellCenter = a.f24974a;
        if (langbridgePreloadCellCenter.f24958c == null && context != null) {
            langbridgePreloadCellCenter.f24958c = context.getApplicationContext();
            a.f24974a.f24957b = new Handler(Looper.getMainLooper());
            a.f24974a.c();
        }
        return a.f24974a;
    }

    public static Map<String, String> getURLRequest(String str) {
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

    public void clearPreloadPool() {
        DXMSdkSAUtils.onEvent("#clearPreloadPool");
        PayStatisticsUtil.onEvent("#clearPreloadPool");
        Runnable runnable = new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.6
            @Override // java.lang.Runnable
            public void run() {
                c cVar;
                try {
                    for (Map.Entry entry : LangbridgePreloadCellCenter.this.f24956a.entrySet()) {
                        String str = (String) entry.getKey();
                        Iterator it = ((Map) entry.getValue()).keySet().iterator();
                        while (it != null && it.hasNext()) {
                            b bVar = (b) it.next();
                            if (bVar != null && (cVar = (c) ((LinkedHashMap) LangbridgePreloadCellCenter.this.f24956a.get(str)).get(bVar)) != null) {
                                cVar.i();
                            }
                        }
                        LangbridgePreloadCellCenter.this.f24956a.remove(str);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f24957b.post(runnable);
        }
    }

    public void clearPreloadPoolByGroup(final String str) {
        DXMSdkSAUtils.onEventWithValues("#clearPreloadPool", Arrays.asList(str));
        PayStatisticsUtil.onEventWithValue("#clearPreloadPool", str);
        Runnable runnable = new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.5
            @Override // java.lang.Runnable
            public void run() {
                c cVar;
                try {
                    for (Map.Entry entry : LangbridgePreloadCellCenter.this.f24956a.entrySet()) {
                        if (((String) entry.getKey()).equals(str)) {
                            Iterator it = ((Map) entry.getValue()).keySet().iterator();
                            while (it != null && it.hasNext()) {
                                b bVar = (b) it.next();
                                if (bVar != null && (cVar = (c) ((LinkedHashMap) LangbridgePreloadCellCenter.this.f24956a.get(str)).get(bVar)) != null) {
                                    cVar.i();
                                }
                            }
                            LangbridgePreloadCellCenter.this.f24956a.remove(str);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f24957b.post(runnable);
        }
    }

    public c getCellFromPrePool(String str, String str2, boolean z) {
        b a2;
        final c cVar = null;
        if (!h.a().a(this.f24958c).MW_ON) {
            DXMSdkSAUtils.onEventWithValues("#preloadURLMatchRet", Arrays.asList("-1"));
            PayStatisticsUtil.onEventWithValue("#preloadURLMatchRet", "-1");
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            b a3 = a(str, this.f24956a.get(str2));
            if (a3 != null) {
                LogUtil.d(TAG, "getCell success");
                cVar = this.f24956a.get(str2).get(a3);
                this.f24956a.get(str2).remove(a3);
                e();
            } else if (z && (a2 = a(str, this.f24956a.get("PRELOAD"))) != null) {
                LogUtil.d(TAG, "getCell success");
                cVar = this.f24956a.get("PRELOAD").get(a2);
                this.f24956a.get("PRELOAD").remove(a2);
                e();
            }
        }
        LogUtil.d(TAG, "getCell result = " + cVar);
        if (cVar == null) {
            DXMSdkSAUtils.onEventWithValues("#preloadURLMatchRet", Arrays.asList("1", str));
            PayStatisticsUtil.onEventWithValues("#preloadURLMatchRet", Arrays.asList("1", str));
        } else {
            a(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.3
                @Override // java.lang.Runnable
                public void run() {
                    if (cVar.b() != null) {
                        cVar.b().onResume();
                    }
                }
            });
            DXMSdkSAUtils.onEventWithValues("#preloadURLMatchRet", Arrays.asList("0", str));
            PayStatisticsUtil.onEventWithValues("#preloadURLMatchRet", Arrays.asList("0", str));
        }
        return cVar;
    }

    @Override // com.baidu.wallet.lightapp.multipage.h.a
    public void onSettingUpdated(LangbridgeSettings langbridgeSettings) {
        if (langbridgeSettings.MW_ON) {
            return;
        }
        clearPreloadPool();
    }

    public void preload(ArrayList<String> arrayList, String str) {
        preload(arrayList, h.a().a(this.f24958c).MW_PRELOAD_LIFE_TIME, str);
    }

    public void preloadUrls(String[] strArr, boolean z) {
        final int i2;
        if (!h.a().a(this.f24958c).MW_ON || strArr == null || strArr.length <= 0) {
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        for (final String str : strArr) {
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
                        i2 = h.a().a(this.f24958c).MW_PRELOAD_LIFE_TIME;
                    }
                    this.f24957b.post(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LangbridgePreloadCellCenter.this.a(str, i2, (String) null);
                        }
                    });
                }
            } catch (Exception unused2) {
            }
        }
        LogUtil.d(TAG, "preloadUrls cost:" + (System.currentTimeMillis() - valueOf.longValue()));
    }

    public void setAllCellsEnable(final boolean z) {
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.7
            @Override // java.lang.Runnable
            public void run() {
                c cVar;
                try {
                    for (Map.Entry entry : LangbridgePreloadCellCenter.this.f24956a.entrySet()) {
                        String str = (String) entry.getKey();
                        Iterator it = ((Map) entry.getValue()).keySet().iterator();
                        while (it != null && it.hasNext()) {
                            b bVar = (b) it.next();
                            if (bVar != null && (cVar = (c) ((LinkedHashMap) LangbridgePreloadCellCenter.this.f24956a.get(str)).get(bVar)) != null && cVar.b() != null) {
                                if (z) {
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
        });
    }

    public LangbridgePreloadCellCenter() {
        this.f24956a = new LinkedHashMap<>();
        h.a().a(this);
    }

    private void b() {
        if (this.f24956a.size() <= 0) {
            return;
        }
        String str = null;
        b bVar = null;
        for (String str2 : this.f24956a.keySet()) {
            for (b bVar2 : this.f24956a.get(str2).keySet()) {
                if (bVar == null || bVar2.f24979e < bVar.f24979e) {
                    str = str2;
                    bVar = bVar2;
                }
            }
        }
        if (TextUtils.isEmpty(str) || bVar == null || this.f24956a.get(str) == null) {
            return;
        }
        c cVar = this.f24956a.get(str).get(bVar);
        if (cVar != null) {
            cVar.i();
        }
        this.f24956a.get(str).remove(bVar);
        DXMSdkSAUtils.onEventWithValues("#popOldestPreloadUrl", Arrays.asList(bVar.toString()));
        PayStatisticsUtil.onEventWithValue("#popOldestPreloadUrl", bVar.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f24957b.postDelayed(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.2
            @Override // java.lang.Runnable
            public void run() {
                LangbridgePreloadCellCenter.this.d();
                LangbridgePreloadCellCenter.this.c();
            }
        }, h.a().a(this.f24958c).MW_PRELOAD_CHECK_TIME * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (this.f24956a.size() <= 0) {
            return;
        }
        for (Map.Entry<String, LinkedHashMap<b, c>> entry : this.f24956a.entrySet()) {
            Set<b> keySet = entry.getValue().keySet();
            Vector<b> vector = new Vector();
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            for (b bVar : keySet) {
                if (bVar.f24979e <= valueOf.longValue()) {
                    LogUtil.d(TAG, "release cell : " + bVar.f24975a);
                    c cVar = this.f24956a.get(entry.getKey()).get(bVar);
                    if (cVar != null) {
                        cVar.i();
                    }
                    vector.add(bVar);
                }
            }
            for (b bVar2 : vector) {
                this.f24956a.get(entry.getKey()).remove(bVar2);
            }
        }
    }

    public void preload(ArrayList<String> arrayList, int i2, String str) {
        if (!h.a().a(this.f24958c).MW_ON || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), i2, str);
        }
        LogUtil.d(TAG, "preload map = " + this.f24956a.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, int i2, String str2) {
        DXMSdkSAUtils.onEventWithValues("#preloadURL", Arrays.asList(str, "" + i2));
        PayStatisticsUtil.onEventWithValues("#preloadURL", Arrays.asList(str, "" + i2));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis() + (i2 * 1000));
        if (TextUtils.isEmpty(str2)) {
            str2 = "PRELOAD";
        }
        b a2 = a(str, this.f24956a.get(str2));
        if (a2 != null) {
            a2.f24979e = valueOf.longValue();
            DXMSdkSAUtils.onEventWithValues("#preloadURLRet", Arrays.asList("0", str));
            PayStatisticsUtil.onEventWithValues("#preloadURLRet", Arrays.asList("0", str));
            return;
        }
        if (a() >= h.a().a(this.f24958c).MW_PRELOAD_POOL_SUM) {
            b();
        }
        LightappBrowserWebView lightappWebViewFromPool = LightappWebViewCenter.getInstance().getLightappWebViewFromPool();
        if (lightappWebViewFromPool == null) {
            b();
            lightappWebViewFromPool = LightappWebViewCenter.getInstance().getLightappWebViewFromPool();
        }
        if (lightappWebViewFromPool != null) {
            LangbridgeCell langbridgeCell = new LangbridgeCell(this.f24958c, lightappWebViewFromPool, str2);
            b bVar = new b(str, valueOf.longValue());
            a(str2, bVar, langbridgeCell);
            b(str2, bVar, langbridgeCell);
            DXMSdkSAUtils.onEventWithValues("#preloadURLRet", Arrays.asList("1", str));
            PayStatisticsUtil.onEventWithValues("#preloadURLRet", Arrays.asList("1", str));
        } else {
            LogUtil.d(TAG, "preload fail [" + str + "]");
            DXMSdkSAUtils.onEventWithValues("#preloadURLRet", Arrays.asList("-1", str));
            PayStatisticsUtil.onEventWithValues("#preloadURLRet", Arrays.asList("-1", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final b bVar, final c cVar) {
        if (bVar == null || cVar == null || TextUtils.isEmpty(bVar.f24975a)) {
            return;
        }
        LogUtil.d(TAG, "preloadUrlbyCell url = " + bVar.f24975a + " ; cell = " + cVar + " ; reloadTimes = " + bVar.f24980f);
        int i2 = bVar.f24980f;
        bVar.f24980f = i2 + (-1);
        if (i2 >= 0) {
            cVar.a(bVar.f24975a, new com.baidu.wallet.lightapp.multipage.b() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.4
                @Override // com.baidu.wallet.lightapp.multipage.b
                public void a(int i3, String str2, String str3) {
                    if (i3 == 0) {
                        LogUtil.d(LangbridgePreloadCellCenter.TAG, "preload success url = " + str3);
                    } else if (i3 != 1101 && i3 != 1102) {
                        if (bVar.f24980f < 0) {
                            cVar.i();
                            ((LinkedHashMap) LangbridgePreloadCellCenter.this.f24956a.get(str)).values().remove(cVar);
                            e a2 = e.a();
                            Context context = LangbridgePreloadCellCenter.this.f24958c;
                            a2.a(context, 1, "preload fail", Arrays.asList(str3, "" + i3, str2));
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onError destory url = " + str3);
                            return;
                        }
                        LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onError code = " + i3 + " ; desc = " + str2 + " ; url = " + str3);
                        LangbridgePreloadCellCenter.this.b(str, bVar, cVar);
                    } else {
                        cVar.i();
                        ((LinkedHashMap) LangbridgePreloadCellCenter.this.f24956a.get(str)).values().remove(cVar);
                        e a3 = e.a();
                        Context context2 = LangbridgePreloadCellCenter.this.f24958c;
                        a3.a(context2, 1, "preload exception", Arrays.asList(str3, "" + i3, str2));
                        LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onException destory url = " + str3);
                    }
                }
            });
        }
    }

    public static String b(String str) {
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

    private int a() {
        int i2 = 0;
        for (String str : this.f24956a.keySet()) {
            i2 += this.f24956a.get(str).size();
        }
        return i2;
    }

    private void a(String str, b bVar, c cVar) {
        if (this.f24956a.containsKey(str)) {
            this.f24956a.get(str).put(bVar, cVar);
            return;
        }
        LinkedHashMap<b, c> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(bVar, cVar);
        this.f24956a.put(str, linkedHashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0147, code lost:
        com.baidu.wallet.core.utils.LogUtil.d(com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.TAG, "targetReqMap = " + r5.toString() + " \n poolReqMap = " + r9.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private b a(String str, LinkedHashMap linkedHashMap) {
        b bVar;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (TextUtils.isEmpty(str) || linkedHashMap == null || linkedHashMap.size() <= 0) {
            return null;
        }
        b bVar2 = new b(str, 0L);
        Integer valueOf = Integer.valueOf(CheckUtils.stripUrlParams(str).hashCode());
        HashMap hashMap = bVar2.f24977c;
        LogUtil.d(TAG, "targetIns = " + bVar2.toString());
        if (valueOf != null) {
            Iterator it = linkedHashMap.entrySet().iterator();
            bVar = null;
            while (true) {
                if (it == null || !it.hasNext()) {
                    break;
                }
                bVar = (b) ((Map.Entry) it.next()).getKey();
                if (bVar != null && bVar.f24976b != null) {
                    LogUtil.d(TAG, "poolIns = " + bVar.toString());
                    HashMap hashMap2 = bVar.f24977c;
                    if (valueOf.equals(bVar.f24976b)) {
                        LogUtil.d(TAG, "protocol+host is match");
                        atomicBoolean.compareAndSet(false, true);
                        String str2 = bVar2.f24978d;
                        if (str2 != bVar.f24978d && (TextUtils.isEmpty(str2) || !bVar2.f24978d.equals(bVar.f24978d))) {
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

    private void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
