package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d bTy;
    private e aDf;
    private com.baidu.adp.lib.cache.t<byte[]> bTz;

    private d() {
        this.aDf = null;
        this.bTz = null;
        this.aDf = new e();
        this.bTz = BdCacheService.cQ().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d aeC() {
        d dVar;
        synchronized (d.class) {
            if (bTy == null) {
                bTy = new d();
            }
            dVar = bTy;
        }
        return dVar;
    }

    public boolean hY(String str) {
        if (this.bTz != null && str != null) {
            byte[] bArr = this.bTz.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                return this.aDf.B(bArr) != null;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bTz.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.bTz.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void B(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bTz.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.bTz.V(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public e getForumModel() {
        return this.aDf;
    }

    public boolean isSameDay(String str) {
        com.baidu.adp.lib.cache.v<byte[]> U;
        if (str == null || str.length() <= 0 || (U = this.bTz.U(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(U.hR, System.currentTimeMillis());
    }
}
