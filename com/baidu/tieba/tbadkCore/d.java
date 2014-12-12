package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d bRM;
    private e aCh;
    private com.baidu.adp.lib.cache.t<byte[]> bRN;

    private d() {
        this.aCh = null;
        this.bRN = null;
        this.aCh = new e();
        this.bRN = BdCacheService.cS().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d aed() {
        d dVar;
        synchronized (d.class) {
            if (bRM == null) {
                bRM = new d();
            }
            dVar = bRM;
        }
        return dVar;
    }

    public boolean hT(String str) {
        if (this.bRN != null && str != null) {
            byte[] bArr = this.bRN.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                return this.aCh.B(bArr) != null;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bRN.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.bRN.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void C(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bRN.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.bRN.V(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public e getForumModel() {
        return this.aCh;
    }

    public boolean isSameDay(String str) {
        com.baidu.adp.lib.cache.v<byte[]> U;
        if (str == null || str.length() <= 0 || (U = this.bRN.U(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(U.hP, System.currentTimeMillis());
    }
}
