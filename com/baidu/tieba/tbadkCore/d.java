package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d bTz;
    private e aDi;
    private com.baidu.adp.lib.cache.t<byte[]> bTA;

    private d() {
        this.aDi = null;
        this.bTA = null;
        this.aDi = new e();
        this.bTA = BdCacheService.cQ().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d aeH() {
        d dVar;
        synchronized (d.class) {
            if (bTz == null) {
                bTz = new d();
            }
            dVar = bTz;
        }
        return dVar;
    }

    public boolean ia(String str) {
        if (this.bTA != null && str != null) {
            byte[] bArr = this.bTA.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                return this.aDi.B(bArr) != null;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bTA.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.bTA.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void B(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bTA.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.bTA.V(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public e getForumModel() {
        return this.aDi;
    }

    public boolean isSameDay(String str) {
        com.baidu.adp.lib.cache.v<byte[]> U;
        if (str == null || str.length() <= 0 || (U = this.bTA.U(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(U.hR, System.currentTimeMillis());
    }
}
