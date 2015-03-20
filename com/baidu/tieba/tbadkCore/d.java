package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d ckb;
    private com.baidu.adp.lib.cache.t<byte[]> ckc;
    private u responseData = null;

    private d() {
        this.ckc = null;
        this.ckc = BdCacheService.gp().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d ako() {
        d dVar;
        synchronized (d.class) {
            if (ckb == null) {
                ckb = new d();
            }
            dVar = ckb;
        }
        return dVar;
    }

    public boolean is(String str) {
        if (this.ckc != null && str != null) {
            byte[] bArr = this.ckc.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
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
                this.ckc.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.ckc.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void D(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.ckc.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.ckc.ac(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        com.baidu.adp.lib.cache.v<byte[]> ab;
        if (str == null || str.length() <= 0 || (ab = this.ckc.ab(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(ab.tn, System.currentTimeMillis());
    }

    public u getResponseData() {
        return this.responseData;
    }
}
