package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d ckr;
    private com.baidu.adp.lib.cache.t<byte[]> cks;
    private u responseData = null;

    private d() {
        this.cks = null;
        this.cks = BdCacheService.gp().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d akD() {
        d dVar;
        synchronized (d.class) {
            if (ckr == null) {
                ckr = new d();
            }
            dVar = ckr;
        }
        return dVar;
    }

    public boolean iv(String str) {
        if (this.cks != null && str != null) {
            byte[] bArr = this.cks.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new u();
                this.responseData.D(bArr);
                return true;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.cks.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.cks.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void D(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.cks.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.cks.ac(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        com.baidu.adp.lib.cache.v<byte[]> ab;
        if (str == null || str.length() <= 0 || (ab = this.cks.ab(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(ab.tn, System.currentTimeMillis());
    }

    public u getResponseData() {
        return this.responseData;
    }
}
