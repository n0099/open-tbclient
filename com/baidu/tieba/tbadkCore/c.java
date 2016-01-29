package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class c {
    private static c dUn;
    private com.baidu.adp.lib.cache.o<byte[]> bct;
    private m responseData = null;

    private c() {
        this.bct = null;
        this.bct = BdCacheService.gs().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized c aKN() {
        c cVar;
        synchronized (c.class) {
            if (dUn == null) {
                dUn = new c();
            }
            cVar = dUn;
        }
        return cVar;
    }

    public boolean mw(String str) {
        if (this.bct != null && str != null) {
            byte[] bArr = this.bct.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new m();
                this.responseData.T(bArr);
                return true;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bct.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.bct.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void I(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bct.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.bct.aa(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.b<byte[]> Z;
        if (str == null || str.length() <= 0 || (Z = this.bct.Z(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(Z.tH, System.currentTimeMillis());
    }

    public m getResponseData() {
        return this.responseData;
    }

    public String al(String str, int i) {
        if (i != 0) {
            return String.valueOf(str) + "categoryid" + String.valueOf(i);
        }
        return str;
    }
}
