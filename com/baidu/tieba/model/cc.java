package com.baidu.tieba.model;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class cc {

    /* renamed from: a  reason: collision with root package name */
    private static cc f1910a;
    private com.baidu.adp.lib.cache.s<String> b;

    private cc() {
        this.b = null;
        this.b = BdCacheService.c().a("tb.pv", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized cc a() {
        cc ccVar;
        synchronized (cc.class) {
            if (f1910a == null) {
                f1910a = new cc();
            }
            ccVar = f1910a;
        }
        return ccVar;
    }

    public void a(String str, String str2) {
        if (str != null && str.length() > 0) {
            this.b.a(TiebaApplication.A() + str, str2, Util.MILLSECONDS_OF_DAY);
        }
    }

    public boolean a(String str) {
        if (str != null && str.length() > 0) {
            com.baidu.adp.lib.cache.t<String> b = this.b.b(TiebaApplication.A() + str);
            if (b != null) {
                return UtilHelper.a(b.b, System.currentTimeMillis());
            }
        }
        return false;
    }
}
