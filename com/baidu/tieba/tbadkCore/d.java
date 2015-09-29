package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d cWt;
    private com.baidu.adp.lib.cache.o<byte[]> aQH;
    private m responseData = null;

    private d() {
        this.aQH = null;
        this.aQH = BdCacheService.gl().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d avn() {
        d dVar;
        synchronized (d.class) {
            if (cWt == null) {
                cWt = new d();
            }
            dVar = cWt;
        }
        return dVar;
    }

    public boolean ln(String str) {
        if (this.aQH != null && str != null) {
            byte[] bArr = this.aQH.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new m();
                this.responseData.U(bArr);
                return true;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aQH.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.aQH.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void H(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aQH.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.aQH.ad(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.b<byte[]> ac;
        if (str == null || str.length() <= 0 || (ac = this.aQH.ac(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(ac.tv, System.currentTimeMillis());
    }

    public m getResponseData() {
        return this.responseData;
    }
}
