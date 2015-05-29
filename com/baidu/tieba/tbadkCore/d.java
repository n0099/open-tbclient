package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d cor;
    private com.baidu.adp.lib.cache.t<byte[]> cos;
    private u responseData = null;

    private d() {
        this.cos = null;
        this.cos = BdCacheService.gt().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d amo() {
        d dVar;
        synchronized (d.class) {
            if (cor == null) {
                cor = new d();
            }
            dVar = cor;
        }
        return dVar;
    }

    public boolean jo(String str) {
        if (this.cos != null && str != null) {
            byte[] bArr = this.cos.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
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
                this.cos.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.cos.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void D(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.cos.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.cos.ae(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        com.baidu.adp.lib.cache.v<byte[]> ad;
        if (str == null || str.length() <= 0 || (ad = this.cos.ad(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(ad.tz, System.currentTimeMillis());
    }

    public u getResponseData() {
        return this.responseData;
    }
}
