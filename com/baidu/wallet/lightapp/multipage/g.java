package com.baidu.wallet.lightapp.multipage;

import android.text.TextUtils;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f24971a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Map<String, String>> f24972b;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static g f24973a = new g();
    }

    static {
        HashSet hashSet = new HashSet();
        f24971a = hashSet;
        hashSet.add("getItem");
        f24971a.add("setItem");
        f24971a.add("clear");
        f24971a.add("key");
        f24971a.add("length");
        f24971a.add("removeItem");
    }

    public static boolean a(String str) {
        return f24971a.contains(str);
    }

    private void b() {
    }

    public void b(String str) {
        this.f24972b.remove(str);
    }

    public void c(String str) {
        for (Map.Entry<String, Map<String, String>> entry : this.f24972b.entrySet()) {
            if (entry.getKey().startsWith(str)) {
                this.f24972b.remove(entry.getKey());
            }
        }
    }

    public int d(String str) {
        if (this.f24972b.containsKey(str)) {
            return this.f24972b.get(str).size();
        }
        return 0;
    }

    public g() {
        this.f24972b = new ConcurrentHashMap();
    }

    public static g a() {
        return a.f24973a;
    }

    public void b(String str, String str2) {
        if (this.f24972b.containsKey(str2) && this.f24972b.get(str2).containsKey(str)) {
            this.f24972b.get(str2).remove(str);
        }
    }

    public String a(String str, String str2) {
        if (this.f24972b.containsKey(str2) && this.f24972b.get(str2).containsKey(str)) {
            return this.f24972b.get(str2).get(str);
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object] */
    public void d(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (String str3 : this.f24972b.keySet()) {
            if (!TextUtils.isEmpty(str3) && str3.startsWith(str)) {
                concurrentHashMap2.put(str3, this.f24972b.get(str3));
                concurrentHashMap.put(str2 + str3.substring(str3.indexOf("+") + 1, str3.length()), this.f24972b.get(str3));
            }
        }
        for (String str4 : concurrentHashMap2.keySet()) {
            this.f24972b.remove(str4);
        }
        Iterator it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            String str5 = (String) it.next();
            if (this.f24972b.containsKey(str5)) {
                Map map = (Map) concurrentHashMap.get(str5);
                Iterator it2 = map.keySet().iterator();
                while (it.hasNext()) {
                    String str6 = (String) it2.next();
                    if (!this.f24972b.get(str5).containsKey(str6)) {
                        this.f24972b.get(str5).put(str6, map.get(str6));
                    }
                }
            } else {
                this.f24972b.put(str5, concurrentHashMap.get(str5));
            }
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.f24972b.containsKey(str3)) {
            this.f24972b.get(str3).put(str, str2);
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(str, str2);
        this.f24972b.put(str3, concurrentHashMap);
    }

    public String c(String str, String str2) {
        int i;
        try {
            i = Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            i = -1;
        }
        if (this.f24972b.containsKey(str2)) {
            Map<String, String> map = this.f24972b.get(str2);
            String[] strArr = (String[]) map.keySet().toArray(new String[map.keySet().size()]);
            if (i < 0 || i >= strArr.length) {
                return null;
            }
            return strArr[i];
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(String str, String[] strArr) {
        char c2;
        String str2;
        b();
        switch (str.hashCode()) {
            case -1106363674:
                if (str.equals("length")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -354615841:
                if (str.equals("clear_by_tab")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -75439223:
                if (str.equals("getItem")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 106079:
                if (str.equals("key")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 94746189:
                if (str.equals("clear")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1098253751:
                if (str.equals("removeItem")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1280882667:
                if (str.equals(BaiduWalletServiceProviderMap.PLUGIN_TRNASFER)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1984670357:
                if (str.equals("setItem")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                if (strArr.length >= 3) {
                    str2 = a(strArr[0], strArr[2]);
                    break;
                }
                str2 = null;
                break;
            case 1:
                if (strArr.length >= 3) {
                    a(strArr[0], strArr[1], strArr[2]);
                }
                str2 = null;
                break;
            case 2:
                if (strArr.length >= 3) {
                    b(strArr[0], strArr[2]);
                }
                str2 = null;
                break;
            case 3:
                if (strArr.length >= 3) {
                    b(strArr[2]);
                }
                str2 = null;
                break;
            case 4:
                if (strArr.length >= 3) {
                    str2 = c(strArr[0], strArr[2]);
                    break;
                }
                str2 = null;
                break;
            case 5:
                if (strArr.length >= 2) {
                    d(strArr[0], strArr[1]);
                }
                str2 = null;
                break;
            case 6:
                if (strArr.length >= 1) {
                    c(strArr[0]);
                }
                str2 = null;
                break;
            case 7:
                if (strArr.length >= 3) {
                    str2 = "" + d(strArr[2]);
                    break;
                }
                str2 = null;
                break;
            default:
                str2 = null;
                break;
        }
        b();
        return str2;
    }
}
