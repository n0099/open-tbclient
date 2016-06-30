package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d eUL;
    private com.baidu.adp.lib.cache.o<byte[]> byT;
    private n responseData = null;

    private d() {
        this.byT = null;
        this.byT = BdCacheService.cH().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d bah() {
        d dVar;
        synchronized (d.class) {
            if (eUL == null) {
                eUL = new d();
            }
            dVar = eUL;
        }
        return dVar;
    }

    public boolean pl(String str) {
        if (this.byT != null && str != null) {
            byte[] bArr = this.byT.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new n();
                this.responseData.A(bArr);
                return true;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.byT.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.byT.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void N(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.byT.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.byT.R(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.b<byte[]> Q;
        if (str == null || str.length() <= 0 || (Q = this.byT.Q(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(Q.jC, System.currentTimeMillis());
    }

    public n getResponseData() {
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
