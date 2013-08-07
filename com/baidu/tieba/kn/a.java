package com.baidu.tieba.kn;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.q;
import com.baidu.tieba.TiebaApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static a f1172a;
    private final com.baidu.adp.lib.a.a c = new com.baidu.adp.lib.a.a(100);
    private final q b = BdCacheService.c().a("tb.cooldown", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 100);

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f1172a == null) {
                f1172a = new a();
            }
            aVar = f1172a;
        }
        return aVar;
    }

    public void a(int i, long j) {
        String E = TiebaApplication.E();
        if (E != null) {
            long time = new Date().getTime() + j;
            this.b.a(String.valueOf(i) + E, String.valueOf(time), j);
            this.c.a(String.valueOf(i) + E, Long.valueOf(time));
        }
    }

    public long a(int i) {
        String E = TiebaApplication.E();
        String str = E == null ? "" : E;
        Long l = (Long) this.c.a(String.valueOf(i) + str);
        if (l == null) {
            String str2 = (String) this.b.a(String.valueOf(String.valueOf(i) + str));
            if (str2 == null) {
                return 0L;
            }
            this.c.a(String.valueOf(i) + str, Long.valueOf(new Date().getTime()));
            return Long.valueOf(str2).longValue();
        }
        return l.longValue();
    }
}
