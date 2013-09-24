package com.baidu.tieba.model;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static r f1454a;
    private ac b;
    private com.baidu.adp.lib.cache.q<String> c;

    private r() {
        this.b = null;
        this.c = null;
        this.b = new ac();
        this.c = BdCacheService.c().a("tb.frs", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            if (f1454a == null) {
                f1454a = new r();
            }
            rVar = f1454a;
        }
        return rVar;
    }

    public boolean a(String str) {
        if (this.c != null && str != null) {
            String a2 = this.c.a(String.valueOf(TiebaApplication.C()) + str);
            if (a2 != null && a2.length() > 0) {
                this.b.a(a2);
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        if (str != null && str.length() > 0) {
            this.c.a(String.valueOf(TiebaApplication.C()) + str, str2, 604800000L);
        }
    }

    public void b(String str) {
        if (str != null && str.length() > 0) {
            this.c.c(String.valueOf(TiebaApplication.C()) + str);
        }
    }

    public ac b() {
        return this.b;
    }

    public boolean c(String str) {
        com.baidu.adp.lib.cache.r<String> b;
        if (str == null || str.length() <= 0 || (b = this.c.b(str)) == null) {
            return false;
        }
        return UtilHelper.a(b.b, System.currentTimeMillis());
    }
}
