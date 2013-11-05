package com.baidu.tieba.model;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private static z f1964a;
    private ak b;
    private com.baidu.adp.lib.cache.s<String> c;

    private z() {
        this.b = null;
        this.c = null;
        this.b = new ak();
        this.c = BdCacheService.c().a("tb.frs", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized z a() {
        z zVar;
        synchronized (z.class) {
            if (f1964a == null) {
                f1964a = new z();
            }
            zVar = f1964a;
        }
        return zVar;
    }

    public boolean a(String str) {
        if (this.c != null && str != null) {
            String a2 = this.c.a(TiebaApplication.C() + str);
            if (a2 != null && a2.length() > 0) {
                this.b.a(a2);
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        if (str != null && str.length() > 0) {
            this.c.a(TiebaApplication.C() + str, str2, 604800000L);
        }
    }

    public void b(String str) {
        if (str != null && str.length() > 0) {
            this.c.c(TiebaApplication.C() + str);
        }
    }

    public ak b() {
        return this.b;
    }

    public boolean c(String str) {
        com.baidu.adp.lib.cache.t<String> b;
        if (str == null || str.length() <= 0 || (b = this.c.b(str)) == null) {
            return false;
        }
        return UtilHelper.a(b.b, System.currentTimeMillis());
    }
}
