package com.baidu.tieba.model;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static p f1413a;
    private aa b;
    private com.baidu.adp.lib.cache.q c;

    private p() {
        this.b = null;
        this.c = null;
        this.b = new aa();
        this.c = BdCacheService.c().a("tb.frs", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            if (f1413a == null) {
                f1413a = new p();
            }
            pVar = f1413a;
        }
        return pVar;
    }

    public boolean a(String str) {
        if (this.c != null && str != null) {
            String str2 = (String) this.c.a(String.valueOf(TiebaApplication.E()) + str);
            if (str2 != null && str2.length() > 0) {
                this.b.a(str2);
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        if (str != null && str.length() > 0) {
            this.c.a(String.valueOf(TiebaApplication.E()) + str, str2, 604800000L);
        }
    }

    public void b(String str) {
        if (str != null && str.length() > 0) {
            this.c.c(String.valueOf(TiebaApplication.E()) + str);
        }
    }

    public aa b() {
        return this.b;
    }

    public boolean c(String str) {
        com.baidu.adp.lib.cache.r b;
        if (str == null || str.length() <= 0 || (b = this.c.b(str)) == null) {
            return false;
        }
        return UtilHelper.a(b.b, System.currentTimeMillis());
    }
}
