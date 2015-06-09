package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d cos;
    private com.baidu.adp.lib.cache.t<byte[]> cot;
    private u responseData = null;

    private d() {
        this.cot = null;
        this.cot = BdCacheService.gt().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d amp() {
        d dVar;
        synchronized (d.class) {
            if (cos == null) {
                cos = new d();
            }
            dVar = cos;
        }
        return dVar;
    }

    public boolean jo(String str) {
        if (this.cot != null && str != null) {
            byte[] bArr = this.cot.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
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
                this.cot.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.cot.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void D(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.cot.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.cot.ae(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        com.baidu.adp.lib.cache.v<byte[]> ad;
        if (str == null || str.length() <= 0 || (ad = this.cot.ad(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(ad.tz, System.currentTimeMillis());
    }

    public u getResponseData() {
        return this.responseData;
    }
}
