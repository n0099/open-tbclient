package com.baidu.tieba.model;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class o {
    private static o a;
    private z b;
    private com.baidu.adp.lib.cache.s<String> c;

    private o() {
        this.b = null;
        this.c = null;
        this.b = new z();
        this.c = BdCacheService.c().a("tb.frs", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (a == null) {
                a = new o();
            }
            oVar = a;
        }
        return oVar;
    }

    public boolean a(String str) {
        if (this.c != null && str != null) {
            String a2 = this.c.a(String.valueOf(TiebaApplication.A()) + str);
            if (a2 != null && a2.length() > 0) {
                this.b.a(a2);
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        if (str != null && str.length() > 0) {
            this.c.a(String.valueOf(TiebaApplication.A()) + str, str2, 604800000L);
        }
    }

    public void b(String str) {
        if (str != null && str.length() > 0) {
            this.c.c(String.valueOf(TiebaApplication.A()) + str);
        }
    }

    public z b() {
        return this.b;
    }

    public boolean c(String str) {
        com.baidu.adp.lib.cache.t<String> b;
        if (str == null || str.length() <= 0 || (b = this.c.b(str)) == null) {
            return false;
        }
        return UtilHelper.a(b.c, System.currentTimeMillis());
    }
}
