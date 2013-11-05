package com.baidu.tieba.kn;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.s;
import com.baidu.tieba.TiebaApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static a f1733a;
    private final com.baidu.adp.lib.d.a<String, Long> c = new com.baidu.adp.lib.d.a<>(100);
    private final s<String> b = BdCacheService.c().a("tb.cooldown", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 100);

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f1733a == null) {
                f1733a = new a();
            }
            aVar = f1733a;
        }
        return aVar;
    }

    public void a(int i, long j) {
        String C = TiebaApplication.C();
        if (C != null) {
            long time = new Date().getTime() + j;
            this.b.a(i + C, String.valueOf(time), j);
            this.c.a(i + C, Long.valueOf(time));
        }
    }

    public long a(int i) {
        String C = TiebaApplication.C();
        String str = C == null ? "" : C;
        Long a2 = this.c.a((com.baidu.adp.lib.d.a<String, Long>) (i + str));
        if (a2 == null) {
            String a3 = this.b.a(String.valueOf(i + str));
            if (a3 == null) {
                return 0L;
            }
            this.c.a(i + str, Long.valueOf(new Date().getTime()));
            return Long.valueOf(a3).longValue();
        }
        return a2.longValue();
    }
}
