package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class c {
    private static c eqc;
    private com.baidu.adp.lib.cache.o<byte[]> bcU;
    private m responseData = null;

    private c() {
        this.bcU = null;
        this.bcU = BdCacheService.cG().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized c aRZ() {
        c cVar;
        synchronized (c.class) {
            if (eqc == null) {
                eqc = new c();
            }
            cVar = eqc;
        }
        return cVar;
    }

    public boolean nG(String str) {
        if (this.bcU != null && str != null) {
            byte[] bArr = this.bcU.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new m();
                this.responseData.A(bArr);
                return true;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bcU.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.bcU.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void L(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bcU.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.bcU.R(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.b<byte[]> Q;
        if (str == null || str.length() <= 0 || (Q = this.bcU.Q(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(Q.jE, System.currentTimeMillis());
    }

    public m getResponseData() {
        return this.responseData;
    }

    public String d(String str, int i, int i2, int i3) {
        String str2 = String.valueOf(str) + i + i2;
        if (i3 != 0) {
            return String.valueOf(str) + i + i2 + "categoryid" + String.valueOf(i3);
        }
        return str2;
    }
}
