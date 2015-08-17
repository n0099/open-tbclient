package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class c {
    private static c cGE;
    private com.baidu.adp.lib.cache.o<byte[]> aRx;
    private l responseData = null;

    private c() {
        this.aRx = null;
        this.aRx = BdCacheService.go().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized c aoQ() {
        c cVar;
        synchronized (c.class) {
            if (cGE == null) {
                cGE = new c();
            }
            cVar = cGE;
        }
        return cVar;
    }

    public boolean kk(String str) {
        if (this.aRx != null && str != null) {
            byte[] bArr = this.aRx.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new l();
                this.responseData.U(bArr);
                return true;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aRx.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.aRx.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void E(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aRx.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.aRx.ad(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.b<byte[]> ac;
        if (str == null || str.length() <= 0 || (ac = this.aRx.ac(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(ac.tx, System.currentTimeMillis());
    }

    public l getResponseData() {
        return this.responseData;
    }
}
